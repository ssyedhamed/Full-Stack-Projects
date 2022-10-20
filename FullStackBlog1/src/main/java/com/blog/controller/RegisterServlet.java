package com.blog.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.blog.dao.UserDao;
import com.blog.helper.ConnectionProvider;
import com.blog.model.UserBean;
//@WebServlet("/RegisterServlet")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
//		String terms=request.getParameter("terms");
		String terms= (String) request.getAttribute("terms");
		out.print(terms);
//		System.out.println("registered success");
//		response.getWriter().append("Registered Succesfully ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserDao ud=new UserDao();
		String name=request.getParameter("user_name");
		String email=request.getParameter("user_email");
		String password=request.getParameter("user_password");
		String gender=request.getParameter("user_gender");
		String about=request.getParameter("user_about");
		String terms=request.getParameter("terms");
//		System.out.println(name+" " +email+" "+password+" "+gender+" " +about+" "+terms);
		if(terms==null) {
			System.out.println("please accept terms");
			request.setAttribute("terms", "unchecked");
			doGet(request, response);
		}
		else if(terms.equals("checked")) {
			UserBean userBean=new UserBean();
			userBean.setName(name);
			userBean.setEmail(email);
			userBean.setPassword(password);
			userBean.setGender(gender);
			userBean.setAbout(about);
			UserDao userDao=new UserDao();
			if(ud.contains(email)) {
				request.setAttribute("terms", "email-error");
				doGet(request, response);
			}
			else if(userDao.registerUser(userBean)) {
				System.out.println("terms checked and data is set to db");
				request.setAttribute("terms", "checked");
				doGet(request, response);
			}
			else {
//				PrintWriter out=response.getWriter();
//				out.print("terms checked but error in database");
				System.out.println("terms checked but error in  sql");
				
				
				request.setAttribute("terms", "db-error");
				doGet(request, response);
			}
		}			
	}

}

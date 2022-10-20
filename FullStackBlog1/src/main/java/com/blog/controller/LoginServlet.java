package com.blog.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.blog.dao.UserDao;
import com.blog.helper.ConnectionProvider;
import com.blog.model.Message;
import com.blog.model.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
////		RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
////		rd.forward(request, response);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("user_email");
//		System.out.println(email);
		String password=request.getParameter("user_password");
//		System.out.println(password);
		UserDao userDao =new UserDao();
		UserBean user=userDao.loginUser(email, password);
		System.out.println(user);
		if(user==null) {
//			PrintWriter out=response.getWriter();
//			out.print("email doesnt exist");
			Message msg=new Message("Invalid Details, Make sure email or password is correct","error","alert-error");
			HttpSession session=request.getSession();
			session.setAttribute("msg", msg);
			response.sendRedirect("login.jsp");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("user_details", user);
//			RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
//			rd.forward(request, response);
			response.sendRedirect("profile.jsp");
//			doGet(request, response);
		}
	}
	}



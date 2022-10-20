package com.blog.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.blog.dao.UserDao;
import com.blog.model.UserBean;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name =request.getParameter("user_name");
		String password =request.getParameter("user_password");
		String about=request.getParameter("user_about");
		UserDao userDao =new UserDao();
		HttpSession session=request.getSession();
		UserBean user=(UserBean)session.getAttribute("user_details");
		System.out.println(user);
		user.setName(name);
		user.setPassword(password);
		user.setAbout(about);
		System.out.println(name+password+about);
		if(userDao.updateUser(user)) {
			//refresh page
		response.sendRedirect("profile.jsp");
//			doGet(request, response);
		}else {
			//error
		}
	}

}

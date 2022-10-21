package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DisplayServlet implements Servlet {

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println("hello " + name + ", how r u?");
		res.setContentType("text/html");
		PrintWriter display = res.getWriter();
//		display.print(name);
		display.print("<center><large><h1>hello " + name + " </h1></large></center>");
	}

}

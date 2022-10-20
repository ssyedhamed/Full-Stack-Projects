<%@page import="com.blog.model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
UserBean user = (UserBean) session.getAttribute("user_details");
session.setAttribute("user_details2", user);
System.out.println(" from profile.jsp : " + response.isCommitted());
%>
<%
if(!request.getParameter("pid").equals("")){
	
int pid=Integer.parseInt(request.getParameter("pid"));
String name=request.getParameter("name");
}
%>
<%
if (user == null) {
	/*  RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
	rd.forward(request, response); */
	/* session.invalidate(); */
	/* HttpSession sess=request.getSession(true); */
	/* response.sendRedirect("login.jsp"); */
	response.sendRedirect("login.jsp");
	System.out.println(" from profile.jsp : " + response.isCommitted());
	System.out.println(request.getContextPath());

}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><%=request.getParameter("name") %></title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<%=request.getParameter("pid") %>
</body>
</html>
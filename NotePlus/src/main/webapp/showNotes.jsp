<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.query.Query"%>
    <%@page import="org.hibernate.*" %>
    <%@page import="org.hibernate.query.*" %>
    <%@page import="net.helper.*" %>
    <%@page import="net.model.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes</title>
<%@include file="include-bootstrap.jsp" %>
</head>
<body>
	<%@include file="navbar.jsp"  %>
	<div class="container">
		<h1>All Notes</h1>
		<div class="border container d-flex justify-content-between flex-wrap">
		<%
		Session ses=SessionFact.getSessionFactory().openSession();
		String get="from Note";
		Query<Note> q=ses.createQuery(get,Note.class);
		
		List<Note> notes=q.list();
		for(Note note: notes){
			
		%>
		<div class="card text-dark bg-light mb-3 col-md-3 p-3 " style="width: 18rem;">
			<div class="card-header"><%=note.getTitle() %></div>
			<div class="card-body">
				<h5 class="card-title">Light card title</h5>
				<p class="card-text"><%=note.getContent() %></p>
			</div>
		
		</div>
		<%
		}
		%>
		</div>
	</div>
</body>
</html>
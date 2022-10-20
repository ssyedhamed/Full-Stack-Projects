<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.blog.model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Nav</title>
<link rel="stylesheet" href="./css/style.css">
<script src="https://kit.fontawesome.com/af344a0535.js"
	crossorigin="anonymous"></script>
 <%
UserBean user = (UserBean) session.getAttribute("user_details");
 session.setAttribute("user_details2", user);
	System.out.println( " from profile.jsp : "+response.isCommitted());
	%>

</head>

<body>
	<header id="profile-header">
		<div class="nav-container flex-row">

			<div class="logo">
				<h3>
					<a href="./home.jsp">Blog</a>
				</h3>
			</div>
			<nav>
				<ul class="nav-items">
					<li class="nav-link flex-row"><i
						class="fa-solid fa-chalkboard-user"></i><a href="#">LearnCodeWithHamed</a>
					</li>
					<li class="nav-link flex-row" id="sub-nav-holder"><i
						class="fa-solid fa-book"></i><a href="#cate">Categories</a>
						<ul class="sub-nav">
							<li>First</li>
							<li>Second</li>
							<li>Third</li>
						</ul></li>
					<li class="nav-link flex-row"><i class="fa-solid fa-message"></i><a
						href="#">Contacts</a></li>
				</ul>
			</nav>
			<div class="flex-row third ">
				<a href="./profile.jsp" class="hover"><i
					class="fa-solid fa-arrow-left"></i>&nbsp;Go Back</a> <a
					class="hover-dark" id="profile-view-btn" style="postion: relative;"><i
					class="fa-solid fa-user-circle"></i>&nbsp;Profile </a>
				<div id="profile-modal">
					<div class="modal-head">
						<div class="modal-img-container"
							style="border-right: 1px solid black;">
							<img alt="image here" src="">
						</div>
						<div style="text-align: center;">
							
							<%-- <span><%=user.getName()%></span> --%>
							
						</div>
					</div>
					<div class="modal-content">
						<ul>
							<a href="about.jsp"><li class="hover">Your Profile</li></a>
							<a href="#"><li class="hover">Settings</li></a>
							<a href="LogOutServlet"><li class="hover">LogOut</li></a>

						</ul>
					</div>
				</div>
			</div>

		</div>
	</header>
	<main class="about-main">
		<div class="about-container">
			<div class="about-left">
				<div class="about-nav">
					<ul>
						<li><a class="hover-dark active" href="#about-info">
								Profile</a></li>
						<li><a class="hover-dark" href="#account-info"> Account</a></li>
						<li><a class="hover-dark" href="#"> Appearance</a></li>
						<li><a class="hover-dark" href="#"> Accessiblity</a></li>
						<li><a class="hover-dark" href="#"> Notifications</a></li>
						<li><a class="hover-dark" href="#"> Inbox</a></li>
					</ul>
				</div>
			</div>
			<div class="about-right">
				<div class="about-info" id="about-info">
					<button class="btn hover" id="edit-about-button">Edit
						Details</button>
						<div class="img-container">
								<img alt="image here" src="./images/default.png" class="img">
						
						</div>
<%
if(user!=null){

%>
					<table class="info-table " id="info-table">
						<tr>
							<td>ID</td>
						

							<td><%=user.getId()%></td>
						</tr>
						<tr>
							<td>Name</td>
							<td><%=user.getName()%></td>
						</tr>
						<tr>
							<td>About</td>
							<td><%=user.getAbout()%></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><%=user.getEmail()%></td>
						</tr>
						<tr>
							<td>Gender</td>
							<td><%=user.getGender()%></td>
						</tr>
						<tr>
							<td>Time of registration</td>
							<td><%=user.getRegisterTime()%></td>
						</tr>
					</table>
					<div id="edit-table" class="" style="display: none;">
						<form action="EditServlet" method="post">
							<table class="info-table">
								<tr>
									<td>ID</td>
									<td><%=user.getId()%></td>
								</tr>
								<tr>
									<td>Name</td>
									<td><input type="text" name="user_name"
										value=<%=user.getName()%>></td>
								</tr>
								<tr>
									<td>About</td>
									<td><textarea name="user_about"><%=user.getAbout()%></textarea></td>
								</tr>
								<tr>
									<td>Password</td>
									<td><input type="password" name="user_password"
										value=<%=user.getPassword()%>></td>
								</tr>

							</table>
							<%} else{ 
							
								 response.sendRedirect("login.jsp"); 
									System.out.println( " from profile.jsp : "+response.isCommitted());
									System.out.println(" user  : "+user);
							
							
							
							}%>
							<button type="submit" class="btn hover" id="edit-about-button">Save
								My Details</button>
						</form>

					</div>
				</div>
				<div class="account-info" id="account-info">
					<p>adsjfjdfladsjfljadfjldajfldafdlfldsfjdsjfdo;jaghierjgdjfdj</p>
				</div>

			</div>
		</div>
	</main>



	<script src="./js/app.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"
		integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#profile-view-btn").click(function() {
				$(this).toggleClass("etc");
				$("#profile-modal").toggle();

			});

			let editStatus = false;
			$("#edit-about-button").click(function() {
				if (!editStatus) {
					$(this).text("Back");
					$("#edit-table").show();
					$("#info-table").hide();
					editStatus = true;
				} else {
					$(this).text("Edit Details");
					$("#edit-table").hide();
					$("#info-table").show();
					editStatus = false;
				}
			});

		})
	</script>
</body>
</html>
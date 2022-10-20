<%@page import="com.blog.dao.PostDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.blog.model.*"%>
<%@page import="java.util.*"%>


<%--  <%@page errorPage="error_page.jsp" %> --%>

<!DOCTYPE html SYSTEM "about:legacy-compat">
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Nav</title>
<link rel="stylesheet" href="./css/style.css">
<style type="text/css">
#profile-body #post-container #post-container-right{
  
  padding: 1rem;
 
}
.posts{
display: grid;
  grid-template-columns: repeat(auto-fit,minmax(250px,1fr));
  grid-gap: 1.5rem;

}
.active{
	background-color: blue;
	color: white;
}
</style>
<script src="https://kit.fontawesome.com/af344a0535.js" ></script>
<%
UserBean user = (UserBean) session.getAttribute("user_details");
session.setAttribute("user_details2", user);
System.out.println(" from profile.jsp : " + response.isCommitted());
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
</head>
<body id="profile-body">
 

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
					<li class="nav-link flex-row"><i class="fa-solid fa-plus "></i>&nbsp;
						<a id="post-modal-btn">POST</a></li>
				</ul>
			</nav>
			<div class="flex-row third ">
				<a href="LogOutServlet" class="hover"><i
					class="fa-solid fa-user-circle"></i>&nbsp;Logout</a> <a
					class="hover-dark" id="profile-view-btn" style="postion: relative;"><i
					class="fa-solid fa-user-circle"></i>&nbsp;Profile </a>
				<div id="profile-modal">
					<div class="modal-head">
						<div class="modal-img-container"
							style="border-right: 1px solid black;">
							<img alt="image here" src="">
						</div>
						<div style="text-align: center;">
							<%
							if (user != null) {
							%>
							<span><%=user.getName()%></span>
							<%
							}
							%>
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
	<!-- Post modal -->
	<section class="post-modal-container" id="post-modal-container" 
	style="display: none;
	position: absolute;
	top: 12%;
	left: 30%;
	z-index: 5;
	background-color: var(--bg-color);">


		<form action="AddPostServlet" id="post-form" method="post"
			enctype="multipart/form-data">
			<%
			ArrayList<Category> arr = PostDao.getCategories();
			%>
			<select name="select" required="required">
				<option value="65">test</option>
				<option disabled="disabled" selected="selected">---Select
					Category ---</option>
				<%
				for (Category c : arr) {
				%>
				<option value="<%=c.getId()%>"><%=c.getName()%></option>
				<%
				}
				%>
			</select>
			<table>
				<tr>

					<td><label>Choose a post category</label></td>
				</tr>
				<tr>

					<td><input type="text" placeholder="Post Title Here"
						name="post_title"></td>
				</tr>
				<tr>
					<td><textarea rows="10" cols="50"
							placeholder="write a post..." name="post_content"></textarea></td>
				</tr>
				<tr>
					<td><textarea rows="10" cols="50"
							placeholder="write a code..." name="post_code"></textarea></td>
				</tr>
				<tr>
					<td><label>Add image</label><input type="file" name="post_pic"></td>
				</tr>


			</table>
			<button type="submit" class="btn">Add Post</button>

		</form>
	</section>


	<!--XXX Post modal XXX-->
	<!-- Post Container-->
	<section id="post-container" 
	style="display:grid; grid-template-columns: 25% 75%;">
	<div class="post-container-left">
	<ul>
			<li><a href="#" onclick="getPosts(0,this)" class="active">All Posts</a></li>
		
		</ul>
	<%
	List<Category> catList=PostDao.getCategories();
	for(Category cat: catList){
		%>
		<ul>
			<li><a href="#" onclick="getPosts(<%=cat.getId()%>,this) " class="active"><%=cat.getName() %></a></li>
		
		</ul>
			<% 
	}
	%>
	</div>
	<div class="post-container-right" id="post-container-right">
	<div class="refresh"><i class="fa-solid fa-refresh fa-spin"></i>
	<h4>Loading posts</h4>
	</div>
	
	<div class="posts"></div>
	</div>
	
	
	</section>
	
	
	
	
	
	
	
	<!--xxxx Post Container xxxx-->
	
	
	
	
	
	
	
	
	<!-- Java script and jqeury -->
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

		});
	</script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<!--XXX Post modal script-->
	<!--XXX Post modal script-->
	<script type="text/javascript">
		$(document).ready(function() {
			$("#post-modal-btn").click(function() {
				$("#post-modal-container").toggle();
			})
		 $("#post-form").on("submit", function(e) {
				e.preventDefault();
				let form = new FormData(this);
				$.ajax({
					url : "AddPostServlet",
					method : "post",
					data : form,
					success : function(data) {
						if(data==="success"){
							
						console.log(data);
						 swal("Your blog has been posted","","success")
						.then((value) => {
						  window.location="profile.jsp";	
						}); 
						}else if(data.trim()==="FileNotValid"){
							console.log(data);
							 swal("please select an image with extensions .jpg, .jpeg or .png","","error");
							 
						}else if(data.trim()==="NoCategory"){
							console.log(data);
							 swal("please select category for your post");
						}
						
					},
					error : function(XHR) {
						alert("error on server");
					},
					contentType: false,
					processData : false,

				})

			}) 
		});
	</script>
	<!-- post container -->
	
	<script type="text/javascript">
	function getPosts(catId,activeElement){
	$(".refresh").show();
	$(".posts").hide();
	$(".active").removeClass("active");
		$.ajax({
			url: "load_posts.jsp",
			data:{cid:catId},
			success: function(data){
				/* console.log(data); */
				$(".refresh").hide();
				$(".posts").show();
				$(activeElement).addClass("active");
				
				$(".posts").html(data);
			},
			error: function(data){
				alert("error")
			},
		})
		console.log("invoked");
	}
	
	$(document).ready(function(){
		let allPostsLink=$(".active")[0];
		 getPosts(0,allPostsLink); 
		
	})
	
	
	
	
	
	
	</script>
	
	
	
	
	
	
	<!-- post container -->
</body>
</html>
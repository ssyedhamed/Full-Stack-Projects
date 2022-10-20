<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>
<link rel="stylesheet" href="./css/style.css">
<script src="https://kit.fontawesome.com/af344a0535.js"
	crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
	<!-- Navbar -->
	<%@include file="./navbar.jsp"%>
	<!--xxxx Navbar xxxx -->
	<section class="login-site clip-path">
		<section class="register-form-container">
			<div class="form-header">
				<span><i class="fa-solid fa-user-plus"></i></span>
				<h1>Registeration</h1>
			</div>
			<hr>
			<form action="RegisterServlet" method="post" id="form">
				<div class="form-group">
					<label for="name">Name</label> <input type="text" name="user_name"
						placeholder="Type your email here" id="name" required="required">
				</div>
				<div class="form-group">
					<label for="email">Email</label> <input type="email"
						name="user_email" placeholder="Type your email here" id="email" required="required">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						name="user_password" placeholder="Enter password" id="password" required="required">
				</div>
				<div class="form-gender">
					<label for="gender">Gender</label>
					<div class="inline-group">

						<div class="">
							<span>Male</span>&nbsp;<input type="radio" name="user_gender"
								value="male">

						</div>
						<div class="">
							<span>Female</span>&nbsp;<input type="radio" name="user_gender"
								value="female">

						</div>
						<div class="">
							<span>Other</span>&nbsp;<input type="radio" name="user_gender"
								value="other">

						</div>
					</div>
				</div>
				<div class="about">
					<textarea name="user_about" id=""
						placeholder="Write here something important about yourself"></textarea>
				</div>
				<div class="terms">
					<span><input type="checkbox" id="terms" value="checked"
						name="terms"></span> &nbsp;&nbsp; <span><label for="terms">I
							have read all the terms and conditions</label></span>
				</div>
				<div id="refresh-state">
					<i class="fa-solid fa-arrows-rotate fa-3x fa-spin"></i>
				</div>
				<div class="register-form-btns">
					<button class="btn" id="register-btn" type="submit">Register
						Now</button>
					<div class="lower-third">
						<span>Already have an account?</span>&nbsp;<a href="./login.jsp">Click
							here to login</a>
					</div>
				</div>
			</form>

		</section>
	</section>
	<script src="./js/app.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"
		integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			$("#form").on("submit", function(e) {
				e.preventDefault();
				let formData = new FormData(this);
				console.log(formData);
				$(".register-form-btns .btn").hide();
				$("#refresh-state").css("display", "flex");
				$.ajax({
					url : "RegisterServlet",
					method : "post",
					data : formData,
					success : function(data) {
						$(".register-form-btns .btn").show();
						$("#refresh-state").css("display", "none");
							 console.log(data); 
						if (data.trim()==="checked") {
							console.log("data trimmed");
							swal({
								title : "Registered Successfully!",
								text : "Go back to login page",
								icon : "success",
								button : "Login",
								className: "swalMedium",
							}).then((value) => {
								  window.location="./login.jsp";
							});
							
						} else if(data.trim()==="unchecked") {
							
							console.log("data uncheck trimmed");
							swal({
								className: "swalSmall",
								closeModal:false,
								closeOnEsc:true,
								text : "please accept terms and conditions",
								icon : "warning",
							});
						}else if(data.trim()==="email-error"){
							console.log("data trimmed");
							swal({
								title : "Email already used. Use another",
								text : "",
								icon: "error",
								className: "swalMedium",
							})
							
						}
						else if(data.trim()==="db-error"){
							console.log("data trimmed");
							swal({
								title : "Something went wrong",
								text : "Refreshing the page...",
								button: false,
								className: "swalMedium",
							}).then((value) => {
								  window.location="./register.jsp";
							});
							
						}
					}
					,
					error : function(jqXHR) {
						console.log(jqXHR);
						$(".register-form-btns .btn").show();
						$("#refresh-state").css("display", "none");
						
						swal({
							title : "Something went wrong",
							text : "Refreshing the page...",
							button: false,
							className: "swalMedium",
						}).then((value) => {
							  window.location="./register.jsp";
						});
						
					},
					processData : false,
					contentType : false,

				})
			})
		})
	</script>
</body>
</html>
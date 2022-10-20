<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@  page import="com.blog.model.*" %>
    <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="./css/style.css">
    <script src="https://kit.fontawesome.com/af344a0535.js" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="#" />
</head>
<body style="height:100vh; overflow:hidden;">
<!-- navbar -->
<%@include file="./navbar.jsp" %>
<!-- Login screen -->
<section class="login-site clip-path" 
style="height:100vh; overflow:hidden;">
        <section class="login-form-container">
            <div class="form-header">
                <span><i class="fa-solid fa-user"></i></span>
                <h1>Login</h1>
                
            </div>
            <hr>
            <%
            Message msg=(Message)session.getAttribute("msg");
            
            if(msg!=null){
       
           	 String cssClass=msg.getCssClass();
            String str=msg.getMsg();
            	%>
                <div class=<%=cssClass %>><span><i class="fa-regular fa-smile" ></i></span>&nbsp;<%=str %></div>
            <% }
            
            request.getSession().invalidate();
            %>
            
           
            <form action="LoginServlet" method="post" id="form">
            	
                <div class="form-group">
                    <label for="email">Email</label>
                    <input  type="email" name="user_email" placeholder="Type your email here" id="email">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input required="required" type="password" name="user_password" placeholder="Enter password" id="password">
                </div>
                <div class="form-btns">
                    <a href="./register.jsp" class="btn"><span><i
                                class="fa-solid fa-arrow-left"></i></span>&nbsp;Register
                        First
                    </a>
                    <button class="btn" type="submit">Login</button>
                </div>
            </form>

        </section>
    </section>
 <script src="./js/app.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>

</body>
</html>
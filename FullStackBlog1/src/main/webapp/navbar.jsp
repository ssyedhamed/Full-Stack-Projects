<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nav</title>
    <link rel="stylesheet" href="./css/style.css">
    <script src="https://kit.fontawesome.com/af344a0535.js" crossorigin="anonymous"></script>
</head>
<body>
	
    <header>
        <div class="nav-container flex-row">

            <div class="logo">
                <h3><a href="./home.jsp">Blog</a></h3>
            </div>
            <nav>
                <ul class="nav-items">
                    <li class="nav-link flex-row"><i class="fa-solid fa-chalkboard-user"></i><a
                            href="#">LearnCodeWithHamed</a>
                    </li>
                    <li class="nav-link flex-row" id="sub-nav-holder"><i class="fa-solid fa-book"></i><a
                            href="#cate">Categories</a>
                        <ul class="sub-nav">
                            <li>First</li>
                            <li>Second</li>
                            <li>Third</li>
                        </ul>
                    </li>
                    <li class="nav-link flex-row"><i class="fa-solid fa-user-plus"></i><a href="./register.jsp">Register</a></li>
               <li class="nav-link flex-row"><i class="fa-solid fa-user"></i>&nbsp;<a href="./login.jsp">Login</a></li>
                </ul>
            </nav>
            <div class="search-bar">
                <input type="text" placeholder="Search">
            </div>
        </div>
    </header>
     <script src="./js/app.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
</body>
</html>
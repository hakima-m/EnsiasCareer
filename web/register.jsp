<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EnsiasCareer | Sign in</title>
        <link rel="stylesheet" href="css/register.css">
        <script src="https://kit.fontawesome.com/890b8f224b.js" crossorigin="anonymous"></script>
        
    </head>
    <body>
        <div class="box-area">
        <%@ include file="menu.jsp" %>
        <div class="banner-area" style="background-image: linear-gradient( rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5) ), url('images/home1.jpg')">
		<h2>Welcome to EnsiasCareer</h2>
	</div>
        <div class="content-area" style="height: 500px;">
            <div class="form-container">
                <div class="form-btn">
                    <span onclick="login()">Sign in</span>
                    <span onclick="register()">Register</span>
                    <hr id="Indicator">
                </div>
                <form class="input-group" id="LoginForm" action="LoginServlet" method="post">
                    <input type="text" class="input-field" placeholder="Username"  name="login" required>
                    <input type="password" class="input-field" placeholder="Password"  name="mdp" required>
                    <button type="submit" class="btn">Sign in</button>
                    <a href="">Forgot password</a>
               </form>
                <form class="input-group" id="RegForm" action="RegisterServlet" method="post">
                    <input type="text" class="input-field" placeholder="Username" name="login" required>
                    <input type="email" class="input-field" placeholder="Email" name="email" required>
                    <input type="password" class="input-field" placeholder="Password" name="mdp" required>
                    <select class="type" name="typeCompte">
                        <option value="type">Select type</option>
                        <option value="student">Student</option>
                        <option value="company">Company</option>
                        <option value="admin">Admin</option>
                    </select>
                    <button type="submit" class="btn">Sign up</button>
               </form>               
            </div>
        </div>
        <script>
            var LoginForm = document.getElementById("LoginForm");
            var RegForm = document.getElementById("RegForm");
            var Indicator = document.getElementById("Indicator");
                    
                    function register(){
                        RegForm.style.transform = "translateX(-400px)";
                        LoginForm.style.transform = "translateX(-450px)";
                        Indicator.style.transform = "translateX(120px)";
                    }
                    function login(){
                        RegForm.style.transform = "translateX(50px)";
                        LoginForm.style.transform = "translateX(0px)";
                        Indicator.style.transform = "translateX(15px)";
                    }
        </script>
    </body>
</html>

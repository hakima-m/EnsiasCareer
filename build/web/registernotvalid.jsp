
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EnsiasCareer | Sign in</title>
        <script src="https://kit.fontawesome.com/890b8f224b.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/register.css">
        <style>
            .alert{
                  
                  height: 80px;
                  width: 600px;
                  margin-top:20px;
                  margin-bottom:0px;
                  margin-left:340px;
                  margin-right: 340px;
                 } 
        </style>
    </head>
    <body>
        <div class="box-area">
        <%@ include file="menu.jsp" %>
        <div class="banner-area" style="background-image: linear-gradient( rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5) ), url('images/home1.jpg')">
		<h2>Welcome to EnsiasCareer</h2>
	</div>
        <div class="content-area" style="height: 700px;">
                    <div class="col">
                        <div class="alert alert-danger alert-dismissable fade show" role="alert">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <p class="p1" style="font-family: 'Poppins', sans-serif">Thank you for signing up. Your account needs to be verified first
                            </p>
                        </div>
                    </div>
            <div class="row"> 
        <div class="account-page">
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
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    </body>
</html>


<%@page import="org.projet.entities.Ensiaste"%>
<%@page import="org.projet.db.EnsiasteDB"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String value =(String) session.getAttribute("id_ensiaste");%>
<%
    int id = Integer.parseInt(value);
    Ensiaste en = EnsiasteDB.getStudent(id);
    request.setAttribute("edit_student", en);
    
%>
<!DOCTYPE html>
<html>
    <head>
         <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>EnsiasCareer | Edit Student Information</title>
        <style>
            *{
  
                outline: none;
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif;
              }
              .container{
                max-width: 800px;
                background: #fff;
                width: 800px;
                margin: auto;
                padding: 25px 40px 10px 40px;
                box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
              }
            .inner{
                margin: 15px 0;
            }
            h3{
                text-align: center;
                border-bottom: 2px solid midnightblue;
                margin-bottom: 20px;
            }
            nav li a{
                font-size: 25px;
                font-weight: 500;
            }
            a{
                color: #fff;
                text-decoration: none;
            }
            a:hover{
                color: #fff;
                text-decoration: none;
            }
            .btn-primary{
                width: 45%;
                padding: 10px 0px;
                color:white ;
                display: block;
                border-radius: 5px;
                text-transform: uppercase;
                border: 1px solid transparent;
                outline: none;
                background: #f0264f;
                transition: 0.4s;
                cursor: pointer;
                margin: 16px 0.5px 0.5px 195px;
                font-family: Poppins;

              }
              .btn-primary:hover {
                background: #f0264f;
                color: white;
                border: 1px solid transparent;

              }
              .btn-primary:focus {
                background: #f0264f;
                color: white;
                border: 1px solid transparent;

              }
              .btn-primary:active {
                background: #f0264f;
                color: white;
                border: 1px solid transparent;

              }
              .center{
                  text-align: center;
                  color:#f0264f;
                 }  
               .form-group label{
                  text-align: left;
                 }
               
        </style>
    </head>
    <body>
       <!--<div  class="container-fluid">
            <nav class="navbar navbar-light">
                <a class="navbar-brand">Edit Students</a>
                <ul class="navbar-nav ml-auto mt-3 mx-5">
<li class="nav-item">
                            <a class="nav-link active" href="index.jsp">Home</a>
                        </li>
</ul>
</nav>
        </div>-->
       
 <div class="box-area">
        <%@ include file="menu.jsp" %>
         <div class="banner-area" style="background-image: linear-gradient( rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5) ), url('images/home1.jpg')">
		<h2>Welcome to EnsiasCareer</h2>
	</div>   
<div class="content-area">
<div class="container">
            <div class=" inner">
                <div class="row">
                    <div class="col-12">
                        <h3 class="center" style="font-family: 'Poppins', sans-serif; font-size: 45px;" >Edit Student Information</h3>
<form action="ModifierStudentServlet" method="post">
 <input type="hidden" name="id_ensiaste" value="<%=(String) session.getAttribute("id_ensiaste")%>"/>                           
<div class="form-group">
    <label>Last Name</label>
                                <input class="form-control" name="nom" value="${edit_student.nom }" required>
                            </div>
<div class="form-group">
                                <label>First Name</label>
                                <input class="form-control" name="prenom" value="${edit_student.prenom}" required>
                            </div>
<div class="form-group">
                                <label>CNE</label>
                                <input class="form-control" name="CNE" value="${edit_student.CNE}" required>
                            </div>
                            <div class="form-group">
                                <label>City</label>
                                <input class="form-control" name="ville" value="${edit_student.ville}" required>
                            </div>
                            
                            
                            <div class="form-group" >
  
                                <label>Branch</label>
                                <select id="inputState" class="form-control" name="filiere" value="${edit_student.filiere}" required>
                                    <option selected disabled>${edit_student.filiere}</option>
                                    <option value="IWIM">IWIM</option>
                                    <option value="SSI">SSI</option>
                                    <option value="GL">GL</option>
                                    <option value="ISEM">ISEM</option>
                                    <option value="e-MBI">e-MBI</option>
                                    <option value="IeL">IeL</option>
                                    <option value="IDF">IDF</option>
                                    <option value="IA">IA</option>
                                </select>
                            </div>
                                    
                            <div class="form-group" >
  
                                <label>Level</label>
                                <select id="inputState" class="form-control" name="annee" value="${edit_student.annee}" required>
                                    <option selected disabled>${edit_student.annee}</option>
                                    <option value="1A">1A</option>
                                    <option value="2A">2A</option>
                                    <option value="3A">3A</option> 
                                </select>
                            </div>
                            
                            

<button type="submit" class="btn btn-primary">Submit</button>
                            <button  class="btn btn-primary"><a href="ensiasteHome.jsp">Cancel</a></button>
                        </form>
</div>
</div>
</div>
</div>
            </div>
                            </div>
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        
    </body>
</html>



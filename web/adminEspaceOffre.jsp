<%@page import="org.projet.entities.Offre"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.projet.db.OffreDB"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%  String var;
    List<Offre> list = OffreDB.getAllOffre();
    List<Offre> list1=new ArrayList<Offre>();
    List<Offre> list2=new ArrayList<Offre>();
    for (Offre en : list )
                                {
                                   var=en.getValidation();
                                   if (var.equals("new")){
                                       list1.add(en);
                                       
                                   }else if (var.equals("checked")){
                                       list2.add(en);
                                       
                                   }
				}
    request.setAttribute("OFFRE_LIST", list2);
    request.setAttribute("OFFRE1_LIST", list1);
    
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css/navmenu.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>EnsiasCareer | Offers management</title>

        <style>
            
            *{
  
                outline: none;
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif;
              }
              .container{
                width: 90%;
                background: #fff;
                width: 850px;
                margin: auto;
                padding: 25px 40px 10px 40px;
                box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
              }
            .inner{
                margin: 15px 0;
            }
            .btn-primary{
                width: 85%;
                padding: 10px 30px;
                color:white ;
                display: block;
                border-radius: 5px;
                text-transform: uppercase;
                border: 1px solid transparent;
                outline: none;
                background: #f0264f;
                transition: 0.4s;
                cursor: pointer;
                margin: 30px 18px 30px 18px;
                font-family: Poppins;

              }
              .center{
                  text-align: center;
                  color:#f0264f;
                  margin-bottom: 45px;
                 }   
                .p1{
                  text-align: left;
                 } 
                 .alert{
                  height: 85px;
                 } 
        </style>
    </head>
    <body>
      <!--   <div  class="container-fluid">
            <nav class="navbar navbar-light">
                <a class="navbar-brand">admin Panel</a>
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
</nav>
        </div>-->
      
 <div class="box-area">
        <%@ include file="menu2.jsp" %>
         <div class="banner-area" style="background-image: linear-gradient( rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5) ), url('images/home1.jpg')">
		<h2>Welcome to EnsiasCareer</h2>
	</div>   
<div class="content-area" style="position: relative;"> 
             
                <nav class="navmenu" style="position: absolute; left: auto; margin-top: 30px; margin-left: 200px; background-color: #f0264f;">
                    <label for="btn" class="button">More Options<span class="fas fa-caret-down"></span></label>
                    <input type="checkbox" id="btn">
                    <ul class="menu">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="adminHome.jsp">Administrator Home</a></li>
                    <li><a href="adminEspace.jsp">Students Management</a></li>
                    <li><a href="adminEspaceEntreprise.jsp">Companies Management</a></li>
                    <li><a href="adminEspaceOffre.jsp">Offers Management</a></li>
                    
                    </ul>
                </nav>

    <!-- This code used to rotate drop icon(-180deg).. -->

             
         <div class="container" style="position: absolute; left:500px; ">
            <div class="inner">
               
                   <!-- <div class="col-md-3">
                        <h3>Input Student Information</h3>
<form action="AddStudentServlet" method="post">
                            <div class="form-group">
                                <label>Last name</label>
                                <input class="form-control" name="nom" place-holder="Book Name" required>
                            </div>
<div class="form-group">
                                <label>first name</label>
                                <input class="form-control" name="prenom" place-holder="Book Name" required>
                            </div>
<div class="form-group">
                                <label>CNE</label>
                                <input class="form-control" name="CNE" place-holder="Book Name" required>
                            </div>
   <div class="form-group">
                                <label>Ville</label>
                                <input class="form-control" name="ville" place-holder="Book Name" required>
                            </div>
    <div class="form-group">
                                <label>filiere</label>
                                <input class="form-control" name="filiere" place-holder="Book Name" required>
                            </div>
    <div class="form-group">
                                <label>annee</label>
                                <input class="form-control" name="annee" place-holder="Book Name" required>
                            </div>
    <div class="form-group">
                                <label>Login</label>
                                <input class="form-control" name="login" place-holder="Book Name" required>
                            </div>
    <div class="form-group">
                                <label>MDP</label>
                                <input class="form-control" name="mdp" place-holder="Book Name" required>
                            </div>

<button type="submit" class="btn btn-primary">Submit</button>
                            <button type="reset" class="btn btn-primary">Reset</button>
                        </form>
</div>-->

                        <h3 class="center" style="font-family: 'Poppins', sans-serif; font-size: 45px;">Offers List</h3>
<table class="table">
                            <thead class="bg-light">
<tr>
                                    <th scope="col" name="titre">Title</th>
                                    <th scope="col" name="description">Description</th>
                                    <th scope="col" name="recruteur">Recruiter</th>
                                    <th scope="col" name="datePublication">Date of publication</th>
                                    <th scope="col" name="categorie">Category</th>
                                    <th scope="col" name="ville">City</th>
                                    
                                    <th scope="col">Options</th>
                                </tr>
</thead>
                            <tbody>
                                <c:forEach var="tS" items="${OFFRE1_LIST}">
<tr class="table-danger">
                                        <td>${tS.titre}</td>
                                        <td>${tS.description }</td>
                                        <td>${tS.recruteur }</td>
                                        <td>${tS.datePublication}</td>
                                        <td>${tS.categorie}</td>
                                        <td>${tS.ville}</td>
                                        <td>
                                            <a href="DeleteOffreServlet?id=${tS.id}">Delete</a>
                                            <a href="ValidateOffreServlet?id=${tS.id}">Validate</a></td>
                                    </tr>
</c:forEach>
                                <c:forEach var="tS" items="${OFFRE_LIST}">
<tr>
                                        <td>${tS.titre}</td>
                                        <td>${tS.description }</td>
                                        <td>${tS.recruteur }</td>
                                        <td>${tS.datePublication}</td>
                                        <td>${tS.categorie}</td>
                                        <td>${tS.ville}</td>
                                        <td>
                                            <a href="DeleteOffreServlet?id=${tS.id}">Delete</a></td>
                                    </tr>
</c:forEach>
                            </tbody>
                        </table>


</div>
</div>
    </div>
         </div>
<!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    </body>
</html>


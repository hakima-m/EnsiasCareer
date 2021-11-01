<%@page import="org.projet.db.OffreDB"%>
<%@page import="org.projet.entities.Offre"%>
<%@page import="org.projet.db.EntrepriseDB"%>
<%@page import="org.projet.entities.Entreprise"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.projet.entities.Ensiaste"%>
<%@page import="org.projet.db.EnsiasteDB"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

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

        <title>EnsiasCareer | Admin Panel</title>

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
                 }   
                .p1{
                  text-align: left;
                 } 
                 .alert{
                  height: 85px;
                  
                 } 
                 .text{
                        text-align: center;
                        font-size: 40px;
                        font-weight: 600;
                        background: -webkit-linear-gradient(right, #56d8e4, #9f01ea, #56d8e4, #9f01ea);
                        -webkit-background-clip: text;
                        -webkit-text-fill-color: #f0264f;
                        font-family: 'Poppins', sans-serif;
                        margin-bottom: 70px;
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
            <div class="text">Welcome to Administrator Panel</div>
             
               <% 
    String var;
    int l;
    List<Ensiaste> list3 = EnsiasteDB.getAllEnsiaste1();
    List<Ensiaste> list33=new ArrayList<Ensiaste>();

    boolean test = false;
    for (Ensiaste en3 : list3 )
                                {  
                                   var=en3.getValidation();
                                   if (var.equals("new")){
                                       test=true;
                                       list33.add(en3);
                                   }
                                   }
    l=list33.size();
    request.setAttribute("TEST", test);
               %>
    
    <c:if test="${TEST=='true'}">

                <div class="row">
                    <div class="col">
                        <div class="alert alert-warning alert-dismissable fade show" role="alert">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <p class="p1" style="font-family: 'Poppins', sans-serif"><%=l%> new students have requested to sign up, verify new information
                            </p>
                        </div>
                    </div>
                </div> 
    </c:if>
               
    <% 
    int l1;
    String var1;
    List<Entreprise> list1 = EntrepriseDB.getAllEntreprise();
    List<Entreprise> list11=new ArrayList<Entreprise>();

    boolean test1 = false;
    for (Entreprise en1 : list1 )
                                {  
                                   var1=en1.getValidation();
                                   if (var1.equals("new")){
                                       test1=true;
                                       list11.add(en1);
                                   }
                                   }
    l1=list11.size();
    request.setAttribute("TEST1", test1);
               %>
    
    <c:if test="${TEST1=='true'}">

                <div class="row">
                    <div class="col">
                        <div class="alert alert-info alert-dismissable fade show" role="alert">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <p class="p1" style="font-family: 'Poppins', sans-serif"><%=l1%> new companies have requested to sign up, verify new information
                            </p>
                        </div>
                    </div>
                </div> 
    </c:if>
               
    <% 
    int l2;
    String var2;
    List<Offre> list2 = OffreDB.getAllOffre();
    List<Offre> list22=new ArrayList<Offre>();

    boolean test2 = false;
    for (Offre en2 : list2 )
                                {  
                                   var2=en2.getValidation();
                                   if (var2.equals("new")){
                                       test2=true;
                                       list22.add(en2);
                                   }
                                   }
    l2=list22.size();
    request.setAttribute("TEST2", test2);
               %>
    
    <c:if test="${TEST2=='true'}">

                <div class="row">
                    <div class="col">
                        <div class="alert alert-danger alert-dismissable fade show" role="alert">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <p class="p1" style="font-family: 'Poppins', sans-serif"><%=l2%> new offers have been added, verify new information
                            </p>
                        </div>
                    </div>
                </div> 
    </c:if>
    
    <c:if test="${TEST1=='false' && TEST2=='false' && TEST=='false'}">

                <div class="row">
                    <div class="col">
                        <div class="alert alert-primary alert-dismissable fade show" role="alert">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <p class="p1" style="font-family: 'Poppins', sans-serif">No new notification for the moment
                            </p>
                        </div>
                    </div>
                </div> 
    </c:if>
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

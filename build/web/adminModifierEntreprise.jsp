<%@page import="org.projet.entities.Entreprise"%>
<%@page import="org.projet.db.EntrepriseDB"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String value =(String) session.getAttribute("id_entreprise");%>
<%
    int id = Integer.parseInt(value);
    Entreprise en = EntrepriseDB.getEntreprise(id);
    request.setAttribute("edit_entreprise", en);
    
%>
<!DOCTYPE html>
<html>
    <head>
         <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>EnsiasCareer | Edit Company Information</title>
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
                        <h3 class="center" style="font-family: 'Poppins', sans-serif; font-size: 45px;" >Edit Company Information</h3>
<form action="ModifierEntrepriseServlet" method="post">
<input type="hidden" name="id_entreprise" value="<%=(String) session.getAttribute("id_entreprise")%>"/>                            
<div class="form-group">
    <label>Corporate Name</label>
                                <input class="form-control" name="RaisonSocial" value="${edit_entreprise.raisonSocial }" required>
                            </div>
<div class="form-group">
                                <label>Brand Name</label>
                                <input class="form-control" name="NomMarque" value="${edit_entreprise.nomMarque}" required>
                            </div>
<div class="form-group">
                                <label>Legal Status</label>
                                <input class="form-control" name="StatutJuridique" value="${edit_entreprise.statutJuridique}" required>
                            </div>
                            <div class="form-group">
                                <label>Capital</label>
                                <input class="form-control" name="capital" value="${edit_entreprise.capital}" required>
                            </div>
                            <div class="form-group">
                                <label>Workforce</label>
                                <input class="form-control" name="effectif" value="${edit_entreprise.effectif}" required>
                            </div>
                            <div class="form-group">
                                <label>Domain</label>
                                <input class="form-control" name="domaine" value="${edit_entreprise.domaine}" required>
                            </div>
                            

<button type="submit" class="btn btn-primary">Submit</button>
                            <button  class="btn btn-primary"><a href="entrepriseHome.jsp">Cancel</a></button>
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



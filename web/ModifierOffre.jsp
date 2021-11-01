<%@page import="org.projet.entities.Offre"%>
<%@page import="org.projet.db.OffreDB"%>
<%@page import="org.projet.entities.Entreprise"%>
<%@page import="org.projet.db.EntrepriseDB"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Offre o = OffreDB.getOffre(id);
    request.setAttribute("edit_offre", o);
    
%>
<!DOCTYPE html>
<html>
    <head>
         <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>EnsiasCareer | Edit Offer Information</title>
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
                        <h3 class="center" style="font-family: 'Poppins', sans-serif; font-size: 45px;" >Edit Offer Information</h3>
<form action="ModifierOffreServlet" method="post">
    
<input type="hidden" name="id_offre" value="<%=Integer.toString(id)%>"/>  
<div class="form-group">
    <label>Title</label>
                                <input class="form-control" name="titre" value="${edit_offre.titre }" required>
                            </div>
<div class="form-group">
                                <label>Description</label>
                                <input class="form-control" name="description" value="${edit_offre.description}" required>
                            </div>
<div class="form-group">
                                <label>Contact</label>
                                <input class="form-control" name="contact" value="${edit_offre.contact}" required>
                            </div>
                            
                            <div class="form-group" >
  
                                <label>Category</label>
                                <select id="inputState" class="form-control" name="categorie" value="${edit_offre.categorie}" required>
                                    
                                    <option selected disabled>${edit_offre.categorie}</option>
                                    <option value="web et mobile">development</option>
                                    <option value="business intelligence">business intelligence</option>
                                    <option value="logistic">logistic</option>
                                    <option value="cyber security">cyber security</option>
                                    <option value="artificial intelligence">artificial intelligence</option>
                                    <option value="digital finance">digital finance</option>
                                </select>
                            </div>
                            
                            <div class="form-group" >
  
                                <label>City</label>
                                <select id="inputState" class="form-control" name="ville" value="${edit_offre.ville}" required>
                                    <option selected disabled>${edit_offre.ville}</option>
                                    <option value="casablanca">casablanca</option>
                                    <option value="rabat">rabat</option>
                                    <option value="agadir">agadir</option>
                                    <option value="fez">fez</option>  
                                    <option value="marrakesh">marrakesh</option>
                                    <option value="tangier">tangier</option>
                                    <option value="Safi">Safi</option>
                                </select>
                            </div>
                            
                            

<button type="submit" class="btn btn-primary">Submit</button>
                            <button  class="btn btn-primary"><a href="GererOffreEntreprise.jsp">Cancel</a></button>
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




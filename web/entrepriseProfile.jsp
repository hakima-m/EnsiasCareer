<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/form1.css">
        <link rel="stylesheet" href="css/navmenu.css">
        <title>EnsiasCareer | Home</title>
        <script src="https://kit.fontawesome.com/890b8f224b.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.js"></script>

    </head>
    <body>
        <div class="box-area">
        <%@ include file="menu.jsp" %>
         <div class="banner-area" style="background-image: linear-gradient( rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5) ), url('images/home1.jpg')">
		<h2>Welcome to EnsiasCareer</h2>
	</div>
         
         <div class="content-area" style="position: relative;"> 
             
                <nav class="navmenu" style="position: absolute; left: auto; margin-top: 30px; margin-left: 200px; background-color: #f0264f;">
                    <label for="btn" class="button">More Options<span class="fas fa-caret-down"></span></label>
                    <input type="checkbox" id="btn">
                    <ul class="menu">
                    <li><a href="index.jsp">Home</a></li>
                    <%--<li><a href="entrepriseHome.jsp">Company Home</a></li>
                    <li><a href="AjouterOffre.jsp">Add Internship Offer</a></li>
                    <li><a href="AfficherOffre.jsp">Manage Internship Offer</a></li>--%>
                    
                    </ul>
                </nav>

    <!-- This code used to rotate drop icon(-180deg).. -->

             
         <div class="container" style="position: absolute; left:500px; ">
           <div class="text">Create Your Profile</div>
           <form action="EntrepriseProfile" method="post">  
                <div class="form-row">                 
                    <div class="input-data">
                    <input type="text" name="NomMarque" required>
                    <label for="">Nom Marque</label>
                    </div>
                    <div class="input-data">
                    <input type="text" name="StatutJuridique" required>
                    <label for="">Statut Juridique</label>
                    </div>                     
                </div>
                               
               
               <div class="form-row">                  
                    <div class="input-data">
                    <input type="text" name="capital" required>
                    <label for="">capital</label>
                    </div>
                    <div class="input-data">
                    <input type="text" name="effectif" required>
                    <label for="">effectif</label>
                    </div>                                       
                </div>
                               
               <div class="form-row">                                     
                   <div class="input-data">
                    <input type="text" name="domaine" required>
                    <label for="">domaine</label>
                    </div>
                   <div class="input-data">
                    <input type="text" name="RaisonSocial" required>
                    <label for="">Raison Social</label>
                    </div>
                </div>
<%--      --------------------------------------------------------------------------------------- --%>                                                    
  <%-- <div class="form-row"> 
                   <input type="file" name="photo">
               </div> --%>
             
<%--      --------------------------------------------------------------------------------------- --%>                                                    
               
                <div class="form-row submit-btn">
                    <div class="input-data">
                    <div class="inner"></div>
                    <input type="submit" value="submit">
                    
                    </div>
                </div>
        </form>
           
        </div> 
        </div>
        </div>
    <script>
    $('nav .button').click(function(){
      $('nav .button span').toggleClass("rotate");
    });
      $('nav ul li .first').click(function(){
        $('nav ul li .first span').toggleClass("rotate");
      });
      $('nav ul li .second').click(function(){
        $('nav ul li .second span').toggleClass("rotate");
      });
    </script>
    </body>
</html>
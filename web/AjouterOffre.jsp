<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/form1.css">
        <link rel="stylesheet" href="css/navmenu.css">
        <title>EnsiasCareer | Home</title>
        <script src="https://kit.fontawesome.com/890b8f224b.js" crossorigin="anonymous"></script>

    </head>
   
    <body>
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
                    <li><a href="entrepriseHome.jsp">Company Home</a></li>
                    <li><a href="adminModifierEntreprise.jsp">Edit Profile</a></li>
                    <li><a href="AjouterOffre.jsp">Add Internship Offer</a></li>
                    <li><a href="GererOffreEntreprise.jsp">Manage Internship Offer</a></li>
                    
                    </ul>
                </nav>   
         <div class="container" style="position: absolute; left:500px; ">
           <div class="text">Add a new Internship offer</div>
           <form action="AjouterOffre" method="post">  
                <div class="form-row">                    
                    <div class="input-data">
                    <input type="text" name="titre" required>
                    <label for="">Offer title</label>
                    </div>
                    <div class="input-data">
                    <input type="text" name="contact" required>
                    <label for="">Contact</label>
                    </div>
                    <div>
                    <input type="hidden" name="id_recruteur" value="<%=(String) session.getAttribute("id_entreprise")%>"/>
                    </div>
                     
                </div>
               
                                          
               <div class="form-row">
                  
                   <div class="select">
                       <select name="categorie" id="categorie">
                            <option selected disabled>Choose a field</option>
                            <option value="web et mobile">development</option>
                            <option value="business intelligence">business intelligence</option>
                            <option value="logistic">logistic</option>
                            <option value="cyber security">cyber security</option>
                            <option value="artificial intelligence">artificial intelligence</option>
                            <option value="digital finance">digital finance</option>
                       </select>
                    </div>
                    
                   <div class="select">
                       <select name="ville" id="ville">
                            <option selected disabled>Choose a city</option>
                            <option value="casablanca">casablanca</option>
                            <option value="rabat">rabat</option>
                            <option value="agadir">agadir</option>
                            <option value="fez">fez</option>  
                            <option value="marrakesh">marrakesh</option>
                            <option value="tangier">tangier</option>
                            <option value="Safi">Safi</option>
                       </select>
                    </div>         
                </div>
               
                <div class="form-row">
                    <div class="input-data">
                    <input type="text" name="description" required>
                    <label for="">Offer Description</label>
                    </div> 
                    <br />
                </div>   
               
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
    </body>
</html>
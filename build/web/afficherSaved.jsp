<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.projet.db.OffreDB"%>
<%@page import="org.projet.entities.Offre"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <!-- Somehow I got an error, so I comment the title, just uncomment to show -->
    <!-- <title>Responsive Cards</title> -->
    <link rel="stylesheet" href="css/form1.css">
    <link rel="stylesheet" href="css/navmenu.css">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        
        
    </style>
    
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
                    <li><a href="ensiasteHome.jsp">Student Home</a></li>
                    <li><a href="modifierUser.jsp">Edit profile</a></li>
                    <li><a href="savedOffers.jsp">saved offers</a></li>
                    
                    
                    </ul>
                </nav>

    <!-- This code used to rotate drop icon(-180deg).. -->

             
         <div class="container" style="position: absolute; left:500px; ">
             
    <div class="cards">
        <div class="text1">Your Saved Offers</div>
        <div class="services">
            <% List<Offre> liste = OffreDB.savedOffers((String)session.getAttribute("id_ensiaste")); 
            int count =1;
            %>
            <table>
            <% for(Offre v : liste){ if(count==3 || count==1){%> <tr><%} %>
           
                <td>    
            <div class="content content-1" style="border-color: #DCDCDC	;">
             <div class=""><img src="<% out.print(v.getPhoto()); %>" width="70" height="60"></div>
             <h2 style="color: #A0A0A0	;"><% out.print(v.getTitre()); %></h2>
             <div><span class="company"><% out.print(v.getRecruteur()); %></span></div>
             <div style="display: none"></div>
             <span class="ville"><% out.print(v.getVille()); %></span>
             <p><% out.print(v.getDescription()); %></p>
             <span class="date "><% out.print(v.getDatePublication()); %></span>
             <a href="#">Read More</a>
             <a href="#">Save </a>
            </div>
             <% count=count+1;%>
                </td>
            <%if(count==3 || count==1){count=1;%> </tr><%} %>
             <% } %>
             </table>
        </div>
    </div>
         </div>
         </div>
      </div>
</body>
</html>

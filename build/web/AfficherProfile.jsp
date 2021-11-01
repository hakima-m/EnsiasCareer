<%@page import="org.projet.db.EnsiasteDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.projet.entities.Ensiaste"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/form1.css">
        <link rel="stylesheet" href="css/navmenu.css">
        
        <title>EnsiasCareer | Profiles</title>
        <script src="https://kit.fontawesome.com/890b8f224b.js" crossorigin="anonymous"></script>
        <style></style>
    </head>
    <body>
        <div class="box-area">
        <%@ include file="menu2.jsp" %>
         <div class="banner-area" style="background-image: linear-gradient( rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5) ), url('images/home1.jpg')">
		<h2>Welcome to EnsiasCareer</h2>
	</div>
	<div class="content-area" style="position: relative; height: 600px;"> 
             
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

  
    <%--     les profiles recommandés            --%>        
            <div class="cards" style="background: white; display: inline-block; position: absolute; left:500px; ">
                <div class="text1">Profiles</div>
        <div class="services">
            <% List<Ensiaste> liste = EnsiasteDB.EnsiasteByFilAn(request.getParameter("filiere"),request.getParameter("annee")); 
            int count =1;
            %>
            <table>
            <% for(Ensiaste v : liste){ if(count==3 || count==1){%> <tr><%} %>
           
                <td>    
            <div class="content content-1" style="border-color: #DCDCDC	;">
             <div class=""><img src="images/ig.png" width="70" height="60"></div>
             <h3 style="color: #A0A0A0; font-family: Georgia, serif; font-size: 40px;"><% out.print(v.getPrenom()+" "+v.getNom()); %></h3>
             <div><span class="company"><b>Branch : </b><% out.print(v.getFiliere()); %></span></div>
             <div style="display: none"></div>
             <span class="ville"><b>Academic year : </b><% out.print(v.getAnnee()); %></span>
             <p><b>City : </b><% out.print(v.getVille()); %></p>
             <span class="date "><b>Contact :</b> <% out.print(v.getContact()); %></span>
             
             
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
    </body>
</html>

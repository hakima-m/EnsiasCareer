<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.projet.db.OffreDB"%>
<%@page import="org.projet.entities.Offre"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/form1.css">
        <link rel="stylesheet" href="css/navmenu.css">
        
        <title>EnsiasCareer | Home</title>
        <script src="https://kit.fontawesome.com/890b8f224b.js" crossorigin="anonymous"></script>
        <style></style>
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

  
    <%--     les stages recommandés            --%>        
            <div class="cards" style="background: white; display: inline-block; position: absolute; left:500px; ">
                <div class="text1">Your Saved List</div>
        <div class="services">
            <% List<Offre> liste = OffreDB.savedOffers((String) session.getAttribute("id_ensiaste")); 
            int count =1;
            %>
            <table>
            <% for(Offre v : liste){ if(count==3 || count==1){
            String id_off=v.getId();
            %> <tr><%} %>
           
                <td>    
            <div class="content content-1" style="border-color: #DCDCDC	;">
             <div class=""><img src="images/ig.png" width="70" height="60"></div>
             <h2 style="color: #A0A0A0; font-family: Georgia, serif; font-size: 40px;"><% out.print(v.getTitre()); %></h2>
             <div><span class="company"><% out.print(v.getRecruteur()); %></span></div>
             <div style="display: none"></div>
             <span class="ville"><b><% out.print(v.getVille()); %></b></span>
             <p><% out.print(v.getDescription()); %></p>
             <span class="date "><b>Published :</b> <% out.print(v.getDatePublication()); %></span>
             
            <%-- <form action="afficherMore.jsp" method="post">
                 <input type="hidden" name="id_ensiaste" value="<%=(String) session.getAttribute("id_ensiaste")%>"/>
                 <input type="hidden" name="id_offre" value="<%= v.getId() %>"/>
                 <div class="form-row submit-btn" style="padding-bottom:20px; hover: ">
                    <div class="input-data">
                    <div class="inner"></div>
                    <input name="more" type="submit" value="more">                    
                    </div>                  
                </div>
             </form>--%>
             <%--<form action="Sauvegarde" method="post">
                 <input type="hidden" name="id_ensiaste" value="<%=(String) session.getAttribute("id_ensiaste")%>"/>
                 <input type="hidden" name="id_offre" value="<%= v.getId() %>"/>
                 <div class="form-row submit-btn">
                    <div class="input-data">
                    <div class="inner"></div>
                    <input name="unsave" type="submit" value="unsave">                    
                    </div>                  
                </div>                                  
             </form>--%>
             
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

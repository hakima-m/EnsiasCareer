<%@page import="org.projet.db.RatingDB"%>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
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

  
    <%--     les stages recommandés            --%>        
            <div class="cards" style="background: white; display: inline-block; position: absolute; left:500px; ">
                <div class="text1">Available offers</div>
        <div class="services">
            <% List<Offre> liste = OffreDB.OffreByCityKeyw(request.getParameter("villeR"),request.getParameter("motcle")); 
            int count =1;
            %>
            <table>
            <% for(Offre v : liste){ if(count==3 || count==1){%> <tr><%} %>
           
                <td>    
            <div class="content content-1" style="border-color: #DCDCDC	;">
                <%  float countSum;
                    int countNum;
                    double avg;
                    countSum=RatingDB.getRatingSum(Integer.parseInt(v.getId()));
                    countNum=RatingDB.getNumber(Integer.parseInt(v.getId()));
                    if(countNum==0){
                        avg=0;
                    }else{
                     avg=countSum/countNum;
                            }%>
                    
                          <div class="center">
             <div class="rateyo" id= "rateYo" data-rateyo-num-stars="5" data-rateyo-read-only="true" data-rateyo-rating="<%=avg%>"/>
                  </div>
             </div>
             <div class=""><img src="images/ig.png" width="70" height="60"></div>
             <h2 style="color: #A0A0A0; font-family: Georgia, serif; font-size: 40px;"><% out.print(v.getTitre()); %></h2>
             <div><span class="company"><% out.print(v.getRecruteur()); %></span></div>
             <div style="display: none"></div>
             <span class="ville"><b><% out.print(v.getVille()); %></b></span>
             <span class="date "><b>Published :</b> <% out.print(v.getDatePublication()); %></span>

             
             <form action="afficherMore.jsp" method="post">
                 <input type="hidden" name="id_ensiaste" value="<%=(String) session.getAttribute("id_ensiaste")%>"/>
                 <input type="hidden" name="id_offre" value="<%= v.getId() %>"/>
                 <div class="form-row submit-btn" style="padding-bottom:20px; hover: ">
                    <div class="input-data">
                    <div class="inner"></div>
                    <input name="more" type="submit" value="more">                    
                    </div>                  
                </div>
             </form>
             <form action="Sauvegarde" method="post">
                 <input type="hidden" name="id_ensiaste" value="<%=(String) session.getAttribute("id_ensiaste")%>"/>
                 <input type="hidden" name="id_offre" value="<%= v.getId() %>"/>
                 <div class="form-row submit-btn">
                    <div class="input-data">
                    <div class="inner"></div>
                    <input name="save" type="submit" value="save">                    
                    </div>                  
                </div>                                  
             </form>
             
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
             
             <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
             <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
 
<script>
 
 
    $(function () {
        $(".rateyo").rateYo().on("rateyo.change", function (e, data) {
            var rating = data.rating;
            $(this).parent().find('.score').text('score :'+ $(this).attr('data-rateyo-score'));
            $(this).parent().find('.result').text('rating :'+ rating);
            $(this).parent().find('input[name=rating]').val(rating); //add rating value to input field
        });
    });
    
    $(function () {
        $(".rateYo").rateYo()({
            rating: 3,
            readOnly:true
        });
    var readOnly = $(".rateYo").rateYo("option", "readOnly");
    $(".rateYo").rateYo("option", "readOnly", true);
    });
 
</script>
    </body>
</html>
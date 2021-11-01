<%@page import="org.projet.entities.Rating"%>
<%@page import="org.projet.db.RatingDB"%>
<%@page import="org.projet.entities.Commentaire"%>
<%@page import="org.projet.db.CommentaireDB"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.projet.db.OffreDB"%>
<%@page import="org.projet.entities.Offre"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

int idsession=Integer.parseInt((String)request.getParameter("id_ensiaste"));
String value1=(String)request.getParameter("id_offre");
int idsession1=Integer.parseInt(value1);
Commentaire en = CommentaireDB.getCommentaire(idsession1,idsession);
request.setAttribute("edit_commentaire", en);
request.setAttribute("ID1", idsession1);
request.setAttribute("ID", idsession);%>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <!-- Somehow I got an error, so I comment the title, just uncomment to show -->
    <!-- <title>Responsive Cards</title> -->
    <link rel="stylesheet" href="css/form1.css">
    <link rel="stylesheet" href="css/navmenu.css">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
      .containercomment
{
    width: 600px;
    border: 2px solid #333;
    padding: 15px 10px;
}
.containercomment h4
{
    text-align: center;
    margin-bottom: 15px
}
textarea
{
    height: 20px;
    width: 100%;
    border: none;
    border-bottom: 2px solid #aaa;
    background-color: transparent;
    margin-bottom: 10px;
    resize: none;
    outline: none;
    transition: .5s
}

input[type="submit"], button
{
    padding: 10px 15px;
    border: none;
    outline: none;
    border-radius: 5px;
    text-transform: uppercase;
    font-weight: bold;
    cursor: pointer;
}
input[type="submit"]
{
    color: #fff;
    background-color: #273c75
}
button
{
    color: #333;
    background-color: transparent
}
.btncomm
{
    display: none
}  
.flex-container{
    display: flex;
    
}
.flex-child{
    flex:1;
}
.flex-child:first-child{
    margin-right: 20px;
}
.center{
    margin-right: 160px;
    margin-left: 160px;
    width: 50%;
    padding: 10px;
}
.content-1{
    position: relative;
}

    .content-1 .info .row{
    position: absolute;
    top: 0;
    right:0;
    margin-top: 16px;
    margin-right: 16px;
}
.content-1 .info .row1{
    position: absolute;
    top: 0;
    right:0;
    margin-top: 41px;
    margin-right: 18px;
}

   button.btn.btn-outline,
.btn:not(.close):not(.mfp-close).btn-outline,
a.btn:not([href]):not([tabindex]).btn-outline {
  background-color: transparent;
  border-width: 2px;
  border-style: solid;
  border-color:transparent;
  border-radius: 2px;
  color: grey;
  font-size: 15px;
  text-decoration: underline;
  text-transform: none;
  padding-bottom: 0;
  padding-top: 0;
  padding-right: 0;
  padding-left: 0;
}
button.btn.btn-outline:hover, button.btn.btn-outline:focus, button.btn.btn-outline:active, button.btn.btn-outline.active,
.btn:not(.close):not(.mfp-close).btn-outline:hover,
.btn:not(.close):not(.mfp-close).btn-outline:focus,
.btn:not(.close):not(.mfp-close).btn-outline:active,
.btn:not(.close):not(.mfp-close).btn-outline.active,
a.btn:not([href]):not([tabindex]).btn-outline:hover,
a.btn:not([href]):not([tabindex]).btn-outline:focus,
a.btn:not([href]):not([tabindex]).btn-outline:active,
a.btn:not([href]):not([tabindex]).btn-outline.active {
  background-color: transparent;
  border-width: 2px;
  border-style: solid;
  border-color: transparent;
  color: grey;
  border-radius: 2px;
  text-decoration: underline;
  text-transform: none;
  
}    
.content h2{
  font-size: 30px;
  margin: 16px 0;
  letter-spacing: 1px;
  text-transform: uppercase;
}

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
         <%--    
         <div class="modal fade" id="updateCommentModal">
          <div class="modal-dialog">
              <div class="modal-content">
                  <form  action="ModifierCommentaireServlet" method="post">
                      <div class="modal-header">
                          <h4 class="modal-title" style="color:#f0264f; text-align: center;">Edit Your Comment</h4>
                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                          
                      </div>
                      <div class="modal-body">
                          <div class="form-group">
                              <textarea name="comment">${edit_commentaire.comment }</textarea>
                        <input type="hidden" name="id_ensiaste" value="<%=request.getParameter("id_ensiaste")%>"/>
                        <input type="hidden" name="id_offre" value="<%= request.getParameter("id_offre") %>"/>
                         <div class="rateyo" id= "rating" 
                            data-rateyo-rating="0"
                            data-rateyo-num-stars="5"
                            data-rateyo-score="0">
                            </div>
                        
                       
                       <input type="hidden" name="rating">
                          </div>
                      </div>
                      <div class="modal-fooder">
                          
                              <input type="submit" style="background-color:#f0264f;" class="btn btn-primary" value="Submit">
                      </div>
                  </form>
                     
              </div>
          </div>
      </div>--%> 
         <div class="container" style="position: absolute; left:500px; ">
             
    <div class="cards">
        <div class="text1">Offer Details</div>
        <div class="services">
        <%------------    section detail de l'offre  start     ------------------------%>    
            <div class="content content-13" style="border-color: #DCDCDC;">
             <div class=""><img src="images/shell.png" width="150" height="150" style="border-radius: 50%; position:absolute; left: 150px;"></div>
             <% Offre v=OffreDB.OffreByID(request.getParameter("id_offre"));
                          %>
             <br/><h2 style="color: #A0A0A0; margin-left:100px; font-family: 'Poppins', sans-serif;"><% out.print(v.getTitre()); %></h2>
             <div><span class="company"><% out.print(v.getRecruteur()); %></span></div>
             <div style="display: none"></div>
             <span class="ville"><b><% out.print(v.getVille()); %></b></span>
             <p>Internship<% out.print(v.getDescription()); %></p>
             <span class="date "><b>Published :</b> <% out.print(v.getDatePublication()); %></span>
             <span ><b>Field :    </b><% out.print(v.getCategorie()); %></span>
             <span ><b>Contact us : </b><% out.print(v.getContact()); %></span>  
             
             
        <%------------    section commentaire list start     ----------------------%>  
        
       <% List<Commentaire> liste = CommentaireDB.comments((String)request.getParameter("id_offre")); 
            int count =1;
            %>
            
            <table>
            <% for(Commentaire c : liste){ if(count==2 || count==1){%> <tr><%} %>
                <td>    
            <div class="content content-1" style="border-color: #DCDCDC	;">
             <div class=""><img src="images/ig.png" width="70" height="60"></div>
             <h3 style="color: #A0A0A0	;"><% out.print(c.getPrenom()+" "+c.getNom()+" "+c.getDatePub()); %></h3>
             <div><span class=""><% out.print(c.getComment()); %></span></div> 
             <%  float idt;
                 Rating rt = RatingDB.getRating(Integer.parseInt((String)request.getParameter("id_offre")), Integer.parseInt(c.getId_ensiaste()));
                 idt=rt.getRateindex();
                 
             %>
           <%--  <div class="center">
             <div class="rateyo" id= "rateYo" data-rateyo-num-stars="5" data-rateyo-read-only="true" data-rateyo-rating="<%=idt%>"/>
                  </div>
             </div>--%>  
             <%if (Integer.parseInt(c.getId_ensiaste())==idsession){%>
             <div class="info">
                 <div class="row">
                     <a href="editComment.jsp?id=${ID}&id1=${ID1}" class="btn btn-outline">Update</a>
             </div>
             <div class="row1">
                 <a href="SupprimerCommentServlet?id=${ID}&id1=${ID1}" class="btn btn-outline">Delete</a>
                 </div>
             </div>
             <%}%>
            </div>
             <% count=count+1;%>
                </td>
            <%if(count==2 || count==1){count=1;%> </tr><%} %>
             <% } %>
             </table>
        
        <%------------    section commentaire list end     ----------------------%>     
        <%------------    section commentaire start     ------------------------%>    
         
        <div class="containercomment" style="border-color:#f0264f;">
            <h4 style="color:#f0264f;">Share Your Experience Here</h4>
                   <form action="AjouterCommentaire" method="post">
                        <textarea name="comment" placeholder='Add Your Comment'></textarea>
                        <input type="hidden" name="id_ensiaste" value="<%=request.getParameter("id_ensiaste")%>"/>
                        <input type="hidden" name="id_offre" value="<%= request.getParameter("id_offre") %>"/>
                         <div class="rateyo" id= "rating" 
                            data-rateyo-rating="0"
                            data-rateyo-num-stars="5"
                            data-rateyo-score="0">
                            </div>
                        
                       
                       <input type="hidden" name="rating">
                        
                        <div class="form-row submit-btn" style="">
                            <div class="input-data">
                            <div class="inner"></div>
                            <input type="submit" value="submit"> 
                            </div> 
                        </div>
                    
                       
                       
                  <!--   <span class='result'>0</span> !-->
                </form>
                </div> 
         <%------------    section commentaire end     ------------------------%>      
                <D
                     </div>
    
            </div>
            
        </div>
    </div>
         </div>
         </div>
      </div>
      
        <script>
            var feild = document.querySelector('textarea');
var backUp = feild.getAttribute('placeholder');
var btn = document.querySelector('.btn');
var clear = document.getElementById('clear')

feild.onfocus = function(){
    this.setAttribute('placeholder', '');
    this.style.borderColor = '#333';
    btn.style.display = 'block'
}

feild.onblur = function(){
    this.setAttribute('placeholder',backUp);
    this.style.borderColor = '#aaa'
}

clear.onclick = function(){
    btn.style.display = 'none';
    feild.value = '';
}
        </script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
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

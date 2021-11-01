<%@page import="org.projet.db.CommentaireDB"%>
<%@page import="org.projet.entities.Commentaire"%>
<%@page import="org.projet.entities.Entreprise"%>
<%@page import="org.projet.db.EntrepriseDB"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%  
    int id = Integer.parseInt(request.getParameter("id"));
    int id1 = Integer.parseInt(request.getParameter("id1"));
    Commentaire en = CommentaireDB.getCommentaire(id1,id);
    request.setAttribute("edit_commentaire", en);
    

%>
<!DOCTYPE html>
<html>
    <head>
         <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css/form1.css">
        <link rel="stylesheet" href="css/navmenu.css">
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

        <title>EnsiasCareer | Edit Comment</title>
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
               .containercomment
{
    width: 600px;
    border: 2px solid #333;
    padding: 15px 10px;
    margin-right: 60px;
    margin-left: 60px;
    margin-top: 20px;
    margin-bottom: 20px;
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
        <%@ include file="menu2.jsp" %>
         <div class="banner-area" style="background-image: linear-gradient( rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5) ), url('images/home1.jpg')">
		<h2>Welcome to EnsiasCareer</h2>
	</div>   
<div class="content-area">
<div class="container">
            <div class=" inner">
                


<div class="containercomment" style="border-color:#f0264f;">
            <h4 style="color:#f0264f;">Edit Your Comment</h4>
                   <form action="ModifierCommentaireServlet" method="post">
                        <textarea name="comment">${edit_commentaire.comment }</textarea>
                        <input type="hidden" name="id_ensiaste" value="<%=request.getParameter("id")%>"/>
                        <input type="hidden" name="id_offre" value="<%= request.getParameter("id1") %>"/>
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
</div>
</div>
</div>
</div>
           
                            
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
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



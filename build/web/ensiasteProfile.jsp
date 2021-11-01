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
        <%@ include file="menu.jsp" %>
         <div class="banner-area" style="background-image: linear-gradient( rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5) ), url('images/home1.jpg')">
		<h2>Welcome to EnsiasCareer</h2>
	</div>
         
         <div class="content-area" style="position: relative; height: 600px;"> 
             
                <nav class="navmenu" style="position: absolute; left: auto; margin-top: 30px; margin-left: 200px; background-color: #f0264f;">
                    <label for="btn" class="button">More Options<span class="fas fa-caret-down"></span></label>
                    <input type="checkbox" id="btn">
                    <ul class="menu">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="afficherSaved.jsp">saved offers</a></li>
                    <%--<li><a href="entrepriseHome.jsp">Company Home</a></li>
                    <li><a href="AjouterOffre.jsp">Add Internship Offer</a></li>
                    <li><a href="AfficherOffre.jsp">Manage Internship Offer</a></li>--%>
                    
                    </ul>
                </nav>

    <!-- This code used to rotate drop icon(-180deg).. -->

             
         <div class="container" style="position: absolute; left:500px; ">
           <div class="text">Create Your Profile</div>
           <form action="EnsiasteProfile" method="post">  
                <div class="form-row">
                   <div class="input-data">
                    <input type="text" name="prenom" required>
                    <label for="">First Name</label>
                    </div>
                    <div class="input-data">
                    <input type="text" name="nom" required>
                    <label for="">Last Name</label>
                    </div>
                                        
                </div>
                <div class="form-row">                 
                    <div class="input-data">
                    <input type="text" name="cne" required>
                    <label for="">CNE</label>
                    </div>    
                    <div class="input-data">
                    <input type="text" name="contact" required>
                    <label for="">Contact</label>
                    </div>
                </div>
                               
               
              
               
               <div class="form-row">
                     <div class="select">
                       <select name="filiere" id="filiere">
                            <option selected disabled>Choose a branch</option>
                            <option value="web et mobile">IWIM</option>
                            <option value="cyber security">SSI</option>
                            <option value="web et mobile">GL</option>
                            <option value="business intelligence">e-MBI</option>
                            <option value="logistic">IeL</option>
                            <option value="digital finance">IDF</option>
                            <option value="artificial intelligence">IA</option>
                       </select>
                    </div>
                    <div class="select">
                       <select name="annee" id="annee">
                            <option selected disabled>Choose a level</option>
                            <option value="1A">1A</option>
                            <option value="2A">2A</option>
                            <option value="3A">3A</option>                            
                       </select>
                    </div>
                </div>
               
                
               <div class="form-row">
                  
                    <div class="input-data">
                    <input type="text" name="ville" required>
                    <label for="">City</label>
                    </div>
                </div>
<%--      --------------------------------------------------------------------------------------- --%>                                                    
 <%--  <div class="container1">
      <div class="wrapper3">
        <div class="image">
          <img class="logoimg"  src="" alt="">
        </div>
        <div class="content">
          <div class="icon"><i class="fas fa-cloud-upload-alt"></i></div>
          <div class="text">No file chosen, yet!</div>
        </div>
        <div id="cancel-btn"><i class="fas fa-times"></i></div>
        <div class="file-name">File name here</div>
      </div>       
      <button onclick="defaultBtnActive()" id="custom-btn">Choose a file</button>
      <input id="default-btn" name="photo" type="file" size="50" hidden>
    </div>
   
<script>
      const wrapper3 = document.querySelector(".wrapper3");
      const fileName = document.querySelector(".file-name");
      const defaultBtn = document.querySelector("#default-btn");
      const customBtn = document.querySelector("#custom-btn");
      const cancelBtn = document.querySelector("#cancel-btn i");
      const img = document.querySelector(".logoimg");
      let regExp = /[0-9a-zA-Z\^\&\'\@\{\}\[\]\,\$\=\!\-\#\(\)\.\%\+\~\_ ]+$/;
      function defaultBtnActive(){
        defaultBtn.click();
      }
      defaultBtn.addEventListener("change", function(){
        const file = this.files[0];
        if(file){
          const reader = new FileReader();
          reader.onload = function(){
            const result = reader.result;
            img.src = result;
            wrapper3.classList.add("active");
          }
          cancelBtn.addEventListener("click", function(){
            img.src = "";
            wrapper3.classList.remove("active");
          })
          reader.readAsDataURL(file);
        }
        if(this.value){
          let valueStore = this.value.match(regExp);
          fileName.textContent = valueStore;
        }
      });
    </script>              
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
    </body>
</html>
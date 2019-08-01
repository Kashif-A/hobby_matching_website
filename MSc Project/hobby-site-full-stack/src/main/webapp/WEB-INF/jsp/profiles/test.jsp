<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <title>Prototype</title>
      <link href='<c:url value="/resources/css/Styles.css" />' rel="stylesheet">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   </head>
   <body>
      <nav class="navbar">
         <div class="navbar-header">
            <img src="../logo.jpg" width=170 height=45 style="padding-left: 10px; padding-right: 10px;" />
         </div>
         <ul class="nav">
            <li>
               <a href="../index/index.html">
                  <h5><strong>Go To HOMEPAGE</strong></h5>
               </a>
            </li>
         </ul>
      </nav>
      <div class="row">
      <div class="col-md-2"></div>
      <div class="col-md-8">
         <div class="text-center">
            <br>
            <div class="form">
               <p><strong style="font-size: 25px;">Use this input field to search users based on hobbies or location.</strong></p>
               <div class="user-search" style="display: inline">
                  <input id="userInput" style="width: 480px;" type="text" name="searchInput" placeholder="Click here to enter hobby..." onfocus="this.placeholder = ''" onblur="this.placeholder = 'Click here to enter hobby...'" />
                  <button type="submit" class="btn btn-primary" style="background-color: #171e75; margin-left: 25px; margin-top: -5px; border: 3px solid white;" onclick="search()">
                     <h2><strong>Search Button</strong></h2>
                  </button>
               </div>
            </div>
            <br />
            <div class="all-profiles-holder" id="all-profiles-holder">
            </div>
         </div>
         <div class="col-md-2"></div>
      </div>
   </body>
   <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
   <script>
      //Get and create profiles from AJAX
      function getProfiles(){
       	 var url = "http://localhost:8080/hobby-site/profilesJSON";
       	 var results;
       	 $.ajax({
                type: 'GET',
                url: url,
                cache: false,
                success: function (result) {
   				console.log(JSON.parse(result));
                 results = result;
                },
                error: function(xhr,status,error) {
                  console.log(error);
                },
                complete:function(){
                	console.log('AJAX request success!')
              }
           })
      }
      
      getProfiles();
      					
      const divs = [...document.querySelectorAll("a")]
      let parentContainer = document.getElementById("all-profiles-holder");
      
      function search() {
          const input = document.getElementById("userInput").value
          while (parentContainer.firstChild) {
              parentContainer.removeChild(parentContainer.firstChild);
          }
          divs.map(e => {
              console.log(e);
              if (e.id && e.id.toLowerCase().includes(input.toLowerCase())) {
                  parentContainer.appendChild(e);
              }
          });
      }
      
      document.getElementById("userInput").onkeydown = function checkIfEmpty() {
          console.log(divs);
          var key = event.keyCode || event.charCode;
          if (key == 8 || key == 46) {
              if (document.getElementById("userInput").value === "") {
                  window.location.reload();
              }
          }
      }
   </script>
</html>
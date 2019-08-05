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
            <img src="../logo.jpg" width=170 height=45 style="padding-left: 10px padding-right: 10px" />
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
               <p><strong style="font-size: 25px">Use this input field to search users based on hobbies or location.</strong></p>
               <div class="user-search" style="display: inline">
                  <input id="userInput" style="width: 480px" type="text" name="searchInput" placeholder="Click here to enter hobby..." onfocus="this.placeholder = ''" onblur="this.placeholder = 'Click here to enter hobby...'" />
                  <button type="submit" class="btn btn-primary" style="background-color: #171e75 margin-left: 25px margin-top: -5px border: 3px solid white" onclick="search()">
                     <h2><strong>Search Button</strong></h2>
                  </button>
               </div>
            </div>
            <br />
            <div class="all-profiles-holder" id="all-profiles-holder">
            <!-- profile container -->
                    <a href="./IP/owen.html" id="Reading Movies Parks">
                        <div class="profile-container">
                            <div class="profile-info">
                                <ul>
                                    <li> Reading</li>
                                    <li> Movies</li>
                                    <li> Parks</li>
                                </ul>
                            </div>
                        </div>
                    </a>
            </div>
         </div>
         <div class="col-md-2"></div>
      </div>
   </body>
   <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
   <script>
      //Get and create profiles from AJAX
      var results
      function getProfiles(){
       	 var url = "http://localhost:8080/hobby-site/profilesJSON"
       	 results = $.ajax({
                type: 'GET',
                url: url,
                cache: false,
                success: function (result) {
	               	var users = JSON.parse(result)
	               	users.map(function generateProfiles(user){
	               		const parentContainer = document.getElementById('all-profiles-holder')
	                    const anchorTag = document.createElement('a')
	                    const profileContainer = document.createElement('div')
	                    const profileImage = document.createElement('img')
	                    const profileInfo = document.createElement('div')
	                    const online = document.createElement('p')
	                    const locationImage = document.createElement('img')
	                    const locationP = document.createElement('p')
	                    const nameP = document.createElement('p')
	                    const hobbiesH5 = document.createElement('h5')
	                    
	                    anchorTag.href = 'www.google.com'
	                    
	                    profileContainer.className = 'profile-container'
	                    
	                    profileImage.className = 'profile-image'
	                    profileImage.src = user.profile_img
	                    
	                    profileInfo.className = 'profile-info'
	                    
	                    online.innerHTML = '<strong>' + user.status.toUpperCase() + '</strong>'
	                    online.style.textAlign = 'left'
	                    online.style.fontSize = '20px'
	                    online.style.color = 'green'
	                    online.style.marginBottom = '20px'
	                    
	                    locationImage.src = 'https://thumbs.dreamstime.com/m/map-pointer-icon-gps-location-symbol-map-pin-sign-map-icon-sign-white-background-arrow-pin-logo-location-sign-map-pointer-icon-126452006.jpg'
						locationImage.style.height = '30px'
						locationImage.style.cssFloat = 'left'
						
						locationP.innerText = user.location
						locationP.style.cssFloat = 'left'
						locationP.style.fontSize = '18px'
						locationP.style.marginLeft = '1ch'
						locationP.style.marginTop = '1ch'
						
						nameP.innerHTML = user.first_name.charAt(0).toUpperCase() + user.first_name.substr(1,user.first_name.length)
						nameP.style.cssFloat = 'center'
						
						hobbiesH5.innerHTML = 'Hobbies & Interests'
						
						// Hobbies UL
						const hobbiesUL = document.createElement('ul')
						const li1 = document.createElement('ul')
						const li2 = document.createElement('ul')
						const li3 = document.createElement('ul')
						hobbiesUL.appendChild(li1)
						hobbiesUL.appendChild(li2)
						hobbiesUL.appendChild(li3)
						li1.innerText = 'one'
						li2.innerText = 'one'
						li3.innerText = 'one'
	                    
						const br = document.createElement('br')
						const br2 = document.createElement('br')
						
	                    profileInfo.appendChild(online)
	                    profileInfo.appendChild(locationImage)
	                    profileInfo.appendChild(locationP)
	                    profileInfo.appendChild(br)
	                    profileInfo.appendChild(br2)
	                    profileInfo.appendChild(nameP)
	                    profileInfo.appendChild(hobbiesH5)
	                    profileInfo.appendChild(hobbiesUL)
	                    profileContainer.appendChild(profileImage)
	                    profileContainer.appendChild(profileInfo)
	                    parentContainer.appendChild(profileContainer)
	               	})
                },
                error: function(xhr,status,error) {
                  console.log(error)
                },
                complete:function(){
                	console.log('AJAX request success!')
              }
           })
      }
      getProfiles()      
     // console.log(results.responseText)
      					
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      function search() {
          const input = document.getElementById("userInput").value
          while (parentContainer.firstChild) {
              parentContainer.removeChild(parentContainer.firstChild)
          }
          divs.map(e => {
              console.log(e)
              if (e.id && e.id.toLowerCase().includes(input.toLowerCase())) {
                  parentContainer.appendChild(e)
              }
          })
      }
      
      document.getElementById("userInput").onkeydown = function checkIfEmpty() {
          console.log(divs)
          var key = event.keyCode || event.charCode
          if (key == 8 || key == 46) {
              if (document.getElementById("userInput").value === "") {
                  window.location.reload()
              }
          }
      }
   </script>
</html>
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
                        <div class="all-profiles-holder" id="all-profiles-holder"></div>
                    </div>
                    <div class="col-md-2"></div>
                </div>
        </body>
        <script>      
        	 (function populateProfiles(){
        		 var profiles = ${json}
        		 console.log(profiles)
	          	let mainDiv = document.getElementById('all-profiles-holder')
	          	profiles.map((profile) => {
	          		let anchorTag = document.createElement('a')
		          	let profileContainerDiv = document.createElement('div')
		          	let profileImg = document.createElement('img')
		          	let profileInfoDiv = document.createElement('div')
		          	let paragraphStatus = document.createElement('p')
		          	let locationImg = document.createElement('img')
		          	let paragraphLocation = document.createElement('p')
		          	let breakOne = document.createElement('br')
		          	let breakTwo = document.createElement('br')
		          	let breakThree = document.createElement('br')
		          	let paragraphName = document.createElement('p')
		          	let h5 = document.createElement('h5')
		          	let ul = document.createElement('ul')
		          	
		          	profileContainerDiv.className = "profile-container"
		          	profileImg.className = "profile-image"
		          	profileInfoDiv.className = "profile-info"
		          	paragraphStatus.style.color = "green"
		         	paragraphStatus.style.textAlign = "left"
		       		paragraphStatus.style.fontSize = "20px"
		       		paragraphStatus.style.marginBottom = "20px"
		       		profileImg.style.cssFloat = "left"
		       		profileImg.style.marginTop = "-7px"
		       		profileImg.style.marginRight = "5px"
		       		paragraphLocation.style.cssFloat = "left"
		       		paragraphLocation.style.fontSize = "18px"
		       		paragraphName.style.cssFloat = "left"
		          	
		          	profileImg.href = profile.profile_img
		          	paragraphStatus.innerHTML = profile.status
		          	locationImg.href = "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/location-128.png"
		          	paragraphLocation.innerHTML = profile.location
		          	paragraphName.innerHTML = profile.first_name
		          	h5.innerHTML = "Hobbies & Interests"

		          	profileInfoDiv.append(paragraphStatus)
		          	profileInfoDiv.append(locationImg)
		          	profileInfoDiv.append(paragraphLocation)
		          	profileInfoDiv.append(breakOne)
		          	profileInfoDiv.append(breakTwo)
		          	profileInfoDiv.append(paragraphName)
		          	profileInfoDiv.append(breakThree)
		          	profileInfoDiv.append(h5)
		          	profileInfoDiv.append(ul)
		          	
		          	profileContainerDiv.append(profileImg)
		          	profileContainerDiv.append(profileInfoDiv)
		          	anchorTag.append(profileContainerDiv)
		          	mainDiv.append(anchorTag)
		          	
		          	profile.hobbies.map((hobby) => {
		          		console.log(hobby)
		          		let li = document.createElement('li')
		          		li.innerHTML = hobby
		          		ul.append(li)
		          	})
	          	})
	          })()
	
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
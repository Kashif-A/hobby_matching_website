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
                        <form class="form" onsubmit="event.preventDefault();" method="POST">
                            <p style="font-size: 30px; margin-bottom: 40px;"><strong>Enter your details below, thanks...</strong></p>
                            <div style="margin: auto; width: 58%;">
                                <label style="margin-top: 10px; font-size: 25px;" for="username">Username</label>
                                <input id="username" style="float: right;" type="text" name="username" placeholder="Username" />
                                <br/>
                                <br/>
                                <label style="margin-top: 10px; font-size: 25px;" for="password">Password</label>
                                <input id="password" style="float: right;" type="password" name="password" placeholder="Password" />
                                <br/>
                                <br/>
                                <label style="margin-top: 10px; font-size: 25px;" for="firstname">First Name</label>
                                <input id="firstname" style="float: right;" type="text" name="firstname" placeholder="firstname" />
                                <br/>
                                <br/>
                                <label style="margin-top: 10px; font-size: 25px;" for="lastname">Last Name</label>
                                <input id="lastname" style="float: right;" type="text" name="lastname" placeholder="lastname" />
                                <br/>
                                <br/>
                                <label style="margin-top: 10px; font-size: 25px;" for="location">Location</label>
                                <input id="location" style="float: right;" type="text" name="location" placeholder="Location" />
                                <br/>
                                <br/>
                                <label style="font-size: 30px; margin-top: 15px;" for="gender">Gender</label>
                                <br/>
                                <input style="float: left;" type="radio" id="male" name="gender" value="Male">
                                <label style="margin-left: -430px; font-size: 30px;" for="male">Male</label>
                                <br/>
                                <input style="float: left;" type="radio" id="female" name="gender" value="Female">
                                <label style="margin-left: -420px; font-size: 30px;" for="female">Female</label>
                                <br/>
                                <input style="float: left;" type="radio" id="female" name="gender" value="Female">
                                <label style="margin-left: -430px; font-size: 30px;" for="female">Other</label>
                                <br/>
                                <br/>

                                <div id="dropDown" style="display: inline-block;">
                                    <h3 style="float: left; margin-top: 15px;">Choose hobbies you like: </h3>
                                    <select id="dropDownList" style="font-size: 25px; padding: 20px; float: left; margin-left: 25px;">
                                    </select>
                                    <button type=""
                                    		class="btn btn-success" 
                                    		style="margin: 10px; padding: 10px;"
                                    		onclick="addHobbies()">Add Hobby</button>
                                </div>
                                <br/>
                                <br/>
                                <textarea id="hobbyList" style="height: 200px; width: 400px;"></textarea>
                                <br/>
                                <br/>
                            </div>
                            <br/>
                            <button type="submit" onclick="validateMyForm();" class="btn btn-primary">Submit</button>
                            <br/>
                            <br/>
                        </form>
                        <br />
                    </div>
                    <div class="col-md-2"></div>
                </div>
        </body>
        <script>
            var div = document.querySelector("#dropDown")
            var select = document.getElementById("dropDownList")
            fetch('/hobby-site/hobbies')
                .then(function data(data) {
                    data.text().then(function(JSONdata) {
                        JSONdata.split(",").map((a) => {
                            if (a.indexOf('"') === 0) {
                                var option = document.createElement("option");
                                option.value = a.substring(1, a.lastIndexOf('"'))
                                option.text = a.substring(1, a.lastIndexOf('"'))
                                select.appendChild(option);
                            }
                        })
                    })
                })
                .catch(function err(error) {
                    console.log(error)
                })
            div.appendChild(select)

            function validateMyForm() {
           	 	var username, password, firstName, lastName, gender, location, chosenHobbies
                username = document.getElementById('username')
                password  = document.getElementById('password')
                firstName = document.getElementById('firstname')
                lastName = document.getElementById('lastname')
                location = document.getElementById('location')
                chosenHobbies = document.getElementById('hobbyList')
                
                if (document.getElementById('male').checked) {
				  	gender = 'male'
				} else {
					gender = 'female'
				}

				var hobbies = new Object()
                hobbies = makeHobbiesObject(chosenHobbies.value)
                	
                var obj = new Object()
                obj.uname = username.value
                obj.password = password.value
                obj.fname = firstName.value
                obj.lname = lastName.value
                obj.gender = gender
                obj.location = location.value
                obj.hobbies = hobbies
                
                console.log(obj)
                
                var http = new XMLHttpRequest();
                var url = '/hobby-site/register';
                http.open('POST', url, true);

                //Send the proper header information along with the request
                http.setRequestHeader('Content-type', 'application/json');

                http.onreadystatechange = function() {//Call a function when the state changes.
                    if(http.readyState == 4 && http.status == 200) {
                        http.responseText === 'success' ? window.location.href = '/hobby-site/profiles' : window.location.href = '/hobby-site/register'
                    }
                }
                http.send(JSON.stringify(obj));
            }
            
            function makeHobbiesObject(hobbies){
            	var hobbyObj = hobbies.substring(2, hobbies.length).split(',')
            	var trimmedHobbyObj = hobbyObj.map((hobby) => hobby.trim())
            	return trimmedHobbyObj
            }
        </script>
		<script>
			 function addHobbies(){
				var dropDownHobby = document.getElementById('dropDownList');
	         	var textArea = document.getElementById('hobbyList')
	         	var selectedHobbies = textArea.value
	         	selectedHobbies = selectedHobbies + ', ' + dropDownHobby.value
	         	textArea.value = selectedHobbies
	         }
		</script>
        </html>
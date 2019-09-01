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
                                <label style="margin-left: -420px; font-size: 35px;" for="male">Male</label>
                                <br/>
                                <input style="float: left;" type="radio" id="female" name="gender" value="Female">
                                <label style="margin-left: -420px; font-size: 35px;" for="female">Female</label>
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
            (function test() {
            	var userDetails = ${json}
            	document.getElementById('firstname').value = userDetails.first_name
            	document.getElementById('lastname').value = userDetails.last_name
            	document.getElementById('location').value = userDetails.location
            })()
		</script>
        </html>
<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Prototype</title>
    <link href='<c:url value="http://localhost:8080/hobby-site/resources/css/Styles.css	" />' rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
    <nav class="navbar">
        <div class="navbar-header">
            <img src="" width=170 height=45 style="padding-left: 10px; padding-right: 10px;" />
        </div>
        <ul class="nav">
            <li>
                <a href="../../index/index.html">
                    <h5><strong>Go To HOMEPAGE</strong></h5>
                </a>
            </li>
        </ul>
    </nav>
    <div class="row">
        <div class="col text-center">
            <div class="individual-profile-holder">
                <div class="message-button">
                   <button onclick="sendMessage()" class="btn btn-primary" style="background-color: #171e75; margin-bottom: 10px;">
                       <h5 style="margin-top: 4px; padding: 1px;"><strong>MESSAGE THIS USER</strong></h5>
                   </button>
                </div>
                <div class="individual-profile-image">
                    <img src="../../pics/5.jpg" class="individual-profile-img">
                </div>
                <h3 id="name"><strong></strong></h3>
                <hr />
                <h4><st2rong>Hi. I hope you like my profile! My hobbies and interests:</strong></h4>
                <ul id="hobbies" style="text-align: left; margin-left: 50px; font-size: 30px; color: #853220;">
                </ul>
            </div>
        </div>
    </div>
</body>
<script>
(function populateProfiles(){
	var profile = ${json}
	console.log(profile)
	var name = document.getElementById('name')
	var ul = document.getElementById('hobbies')
	name.innerHTML = profile.first_name + " " + profile.last_name
	profile.hobbies.map((hobby) => {
  		let li = document.createElement('li')
  		li.innerHTML = "-   " + hobby
  		ul.append(li)
	})
 })()
 
 function sendMessage() {
	var userId = window.location.href
	userId = userId[userId.length - 1]
	window.location.href="/hobby-site/sendmessage/" + userId
}
</script>
</html>
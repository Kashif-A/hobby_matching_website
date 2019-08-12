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
<form class="form" action="/hobby-site/register" method="POST">
    <p><strong style="font-size: 25px;">Enter your details below, thanks...</strong></p>
    <label for="username">Username</label>
    <input type="text" name="username" placeholder="Username"/><br/><br/>
    <label for="password">Password</label>
    <input type="password" name="password" placeholder="Password"/><br/><br/>
    <label for="firstname">First Name</label>
    <input type="text" name="firstname" placeholder="firstname"/><br/><br/>
    <label for="lastname">Last Name</label>
    <input type="text" name="lastname" placeholder="lastname"/><br/><br/>
    <label for="gender">Gender</label><br/>
    <input style="height:40px;" type="radio" id="male" name="male" value="Male">
    <label for="male">Male</label>
    <input style="height:40px;" type="radio" id="female" name="female" value="Female">
    <label for="female">Female</label><br/><br/>
    <label for="location">Location</label>
    <input type="text" name="location" placeholder="Location"/><br/><br/>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
                        <br />
                        <div class="all-profiles-holder" id="all-profiles-holder"></div>
                    </div>
                    <div class="col-md-2"></div>
                </div>
        </body>
        <script>      
        	
        </script>
        </html>
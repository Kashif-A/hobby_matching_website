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
                    <!-- profile container -->
                    <a href="./IP/owen.html" id="Reading Movies Parks">
                        <div class="profile-container">
                            <img src="../pics/6.jpg" class="profile-image">
                            <div class="profile-info">
                                <p style="color: green; text-align: left; font-size: 20px; margin-bottom: 20px;"><strong>ONLINE</strong></p>
                                <img src="../location.png" height=20 style="float: left; margin-top: -7px; margin-right: 5px;" />
                                <p style="float: left; font-size: 18px;"><strong>Bradford</strong></p>
                                <br />
                                <br />
                                <p style="float: left;">Owen</p>
                                <br />
                                <h5>Hobbies & Interests</h5>
                                <ul>
                                    <li> Reading</li>
                                    <li> Movies</li>
                                    <li> Parks</li>
                                </ul>
                            </div>
                        </div>
                    </a>

                    <!-- profile container -->
                    <a href="individual-profile.html" id="Painting Bowling Golf">
                        <div class="profile-container">
                            <img src="../pics/f1.png" class="profile-image">
                            <div class="profile-info">
                                <p style="color: red; text-align: left; font-size: 20px; margin-bottom: 20px;"><strong>OFFLINE</strong></p>
                                <img src="../location.png" height=20 style="float: left; margin-top: -7px; margin-right: 5px;" />
                                <p style="float: left; font-size: 18px;"><strong>Manchester</strong></p>
                                <br />
                                <br />
                                <p style="float: left;">Joanna</p>
                                <br />
                                <h5>Hobbies & Interests</h5>
                                <ul>
                                    <li> &nbsp Painting</li>
                                    <li> &nbsp Bowling</li>
                                    <li> &nbsp Golf</li>
                                </ul>
                            </div>
                        </div>
                    </a>

                    <!-- profile container -->
                    <a href="individual-profile.html" id="Swimming Tennis Cooking">
                        <div class="profile-container">
                            <img src="../pics/f2.png" class="profile-image">
                            <div class="profile-info">
                                <p style="color: green; text-align: left; font-size: 20px; margin-bottom: 20px;"><strong>ONLINE</strong></p>
                                <img src="../location.png" height=20 style="float: left; margin-top: -7px; margin-right: 5px;" />
                                <p style="float: left; font-size: 18px;"><strong>Leigh</strong></p>
                                <br />
                                <br />
                                <p style="float: left;">Laura</p>
                                <br />
                                <h5>Hobbies & Interests</h5>
                                <ul>
                                    <li> &nbsp Swimming</li>
                                    <li> &nbsp Tennis</li>
                                    <li> &nbsp Cooking</li>
                                </ul>
                            </div>
                        </div>
                    </a>

                    <!-- profile container -->
                    <a href="individual-profile.html" id="Dog Friends Chatting">
                        <div class="profile-container">
                            <img src="../pics/f3.png" class="profile-image">
                            <div class="profile-info">
                                <p style="color: red; text-align: left; font-size: 20px; margin-bottom: 20px;"><strong>OFFLINE</strong></p>
                                <img src="../location.png" height=20 style="float: left; margin-top: -7px; margin-right: 5px;" />
                                <p style="float: left; font-size: 18px;"><strong>Stockport</strong></p>
                                <br />
                                <br />
                                <p style="float: left;">Alice</p>
                                <br />
                                <h5>Hobbies & Interests</h5>
                                <ul>
                                    <li> &nbsp Dog walking</li>
                                    <li> &nbsp Friends</li>
                                    <li> &nbsp Chatting</li>
                                </ul>
                            </div>
                        </div>
                    </a>

                    <!-- profile container -->
                    <a href="individual-profile.html" id="Internet Youtube Movies">
                        <div class="profile-container">
                            <img src="../pics/f4.png" class="profile-image">
                            <div class="profile-info">
                                <p style="color: green; text-align: left; font-size: 20px; margin-bottom: 20px;"><strong>ONLINE</strong></p>
                                <img src="../location.png" height=20 style="float: left; margin-top: -7px; margin-right: 5px;" />
                                <p style="float: left; font-size: 18px;"><strong>Manchester</strong></p>
                                <br />
                                <br />
                                <p style="float: left;">Susan</p>
                                <br />
                                <h5>Hobbies & Interests</h5>
                                <ul>
                                    <li> &nbsp Browsing web</li>
                                    <li> &nbsp Youtube</li>
                                    <li> &nbsp Movies</li>
                                </ul>
                            </div>
                        </div>
                    </a>

                    <!-- profile container -->
                    <a href="./IP/mark.html" id="Movies Parks Reading">
                        <div class="profile-container">
                            <img src="../pics/5.jpg" class="profile-image">
                            <div class="profile-info">
                                <p style="color: green; text-align: left; font-size: 20px; margin-bottom: 20px;"><strong>ONLINE</strong></p>
                                <img src="../location.png" height=20 style="float: left; margin-top: -7px; margin-right: 5px;" />
                                <p style="float: left; font-size: 18px;"><strong>Altrincham</strong></p>
                                <br />
                                <br />
                                <p style="float: left;">Mark</p>
                                <br />
                                <h5>Hobbies & Interests</h5>
                                <ul>
                                    <li> &nbsp Movies</li>
                                    <li> &nbsp Parks</li>
                                    <li> &nbsp Reading</li>
                                </ul>
                            </div>
                        </div>
                    </a>

                    <!-- profile container -->
                    <a href="individual-profile.html" id="Golf Painting Bowling">
                        <div class="profile-container">
                            <img src="../pics/1.jpg" class="profile-image">
                            <div class="profile-info">
                                <p style="color: red; text-align: left; font-size: 20px; margin-bottom: 20px;"><strong>OFFLINE</strong></p>
                                <img src="../location.png" height=20 style="float: left; margin-top: -7px; margin-right: 5px;" />
                                <p style="float: left; font-size: 18px;"><strong>Bradford</strong></p>
                                <br />
                                <br />
                                <p style="float: left;">Jones</p>
                                <br />
                                <h5>Hobbies & Interests</h5>
                                <ul>
                                    <li> &nbsp Golf</li>
                                    <li> &nbsp Painting</li>
                                    <li> &nbsp Bowling</li>
                                </ul>
                            </div>
                        </div>
                    </a>

                    <!-- profile container -->
                    <a href="individual-profile.html" id="Swimming Cooking Tennis">
                        <div class="profile-container">
                            <img src="../pics/f5.png" class="profile-image">
                            <div class="profile-info">
                                <p style="color: green; text-align: left; font-size: 20px; margin-bottom: 20px;"><strong>ONLINE</strong></p>
                                <img src="../location.png" height=20 style="float: left; margin-top: -7px; margin-right: 5px;" />
                                <p style="float: left; font-size: 18px;"><strong>Hyde</strong></p>
                                <br />
                                <br />
                                <p style="float: left;">Kirsty</p>
                                <br />
                                <h5>Hobbies & Interests</h5>
                                <ul>
                                    <li> &nbsp Swimming</li>
                                    <li> &nbsp Cooking</li>
                                    <li> &nbsp Tennis</li>
                                </ul>
                            </div>
                        </div>
                    </a>

                    <!-- profile container -->
                    <a href="individual-profile.html" id="Friends Chatting Dog">
                        <div class="profile-container">
                            <img src="../pics/3.jpg" class="profile-image">
                            <div class="profile-info">
                                <p style="color: red; text-align: left; font-size: 20px; margin-bottom: 20px;"><strong>OFFLINE</strong></p>
                                <img src="../location.png" height=20 style="float: left; margin-top: -7px; margin-right: 5px;" />
                                <p style="float: left; font-size: 18px;"><strong>Salford</strong></p>
                                <br />
                                <br />
                                <p style="float: left;">Ben</p>
                                <br />
                                <h5>Hobbies & Interests</h5>
                                <ul>
                                    <li> &nbsp Friends</li>
                                    <li> &nbsp Chatting</li>
                                    <li> &nbsp Dog walking</li>
                                </ul>
                            </div>
                        </div>
                    </a>

                    <!-- profile container -->
                    <a href="individual-profile.html" id="Movies Youtube Internet">
                        <div class="profile-container">
                            <img src="../pics/2.png" class="profile-image">
                            <div class="profile-info">
                                <p style="color: green; text-align: left; font-size: 20px; margin-bottom: 20px;"><strong>ONLINE</strong></p>
                                <img src="../location.png" height=20 style="float: left; margin-top: -7px; margin-right: 5px;" />
                                <p style="float: left; font-size: 18px;"><strong>Rochdale</strong></p>
                                <br />
                                <br />
                                <p style="float: left;">Kevin</p>
                                <br />
                                <h5>Hobbies & Interests</h5>
                                <ul>
                                    <li> &nbsp Movies</li>
                                    <li> &nbsp Youtube</li>
                                    <li> &nbsp Browsing web</li>
                                </ul>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-md-2"></div>
        </div>
</body>
<script>
				console.log('gucci');
				//Create profiles from AJAX
				function readFilmByTitle(a, b){
        	 var userInput = $("#title").val();
        	 var url = "http://localhost:8080/hobby-site/profiles";
        	 var results;
        	 $.ajax({
																	console.log('here');
                 type: 'GET',
                 url: url,
                 cache: false,
                 success: function (result) {
																		console.log(JSON.stringify(result));
                  results = result;
                 },
                 error: function(xhr,status,error) {
                   console.log(error);
                 },
                 complete:function(){
                 	console.log('AJAX request success!')
               });
         }

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
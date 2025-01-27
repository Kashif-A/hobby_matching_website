<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>

        <!doctype html>

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
                    <img src="https://image.flaticon.com/icons/png/128/33/33447.png" width=170 height=45 style="padding-left: 10px; padding-right: 10px;" />
                </div>
                <ul class="nav">
                    <li>
                        <a href="/">
                            <h5><strong>Go To HOMEPAGE</strong></h5>
                        </a>
                    </li>
                </ul>
            </nav>

            <div class="row">
                <div class="col">
                    <div class="form-container">
                        <div class="form-container-child text-right">
                            <div class="form" style="padding: 35px;">
                                <form method=POST action="/hobby-site/login" id="LoginForm">
                                    <p><strong style="font-size: 26px;">Use this form to input Username and Password, then click Login button.</strong></p>
                                    <br />
                                    <br />
                                    <fieldset style="text-align: center;">
                                        <label for="username"><b><h3>Username</h3></b></label>
                                        <input id="userInput" type="text" name="username" style="margin-right: 7px;" placeholder="Click here to enter Username" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Click here to enter Username'">
                                        <br />
                                        <br />
                                        <label for="password"><b><h3>Password</h3></b></label>
                                        <input id="userInput" type="password" name="password" placeholder="Click here to enter Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Click here to enter Password'">
                                        <br/>
                                        <br />
                                        <br />
                                        <button type="submit" class="btn btn-primary" style="background-color: #171e75; border: 3px solid white;">
                                            <h2 style="margin-top: -2px;"><strong>Login Button</strong></h2>
                                        </button>
                                        <a style="margin-left:30px; background-color: #171e75; border: 3px solid white;" href="/hobby-site/register" class="btn btn-primary">
                                            <h2 style="margin-top: -2px;"><strong>Register</strong></h2>
                                        </a>
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
        </body>
        <script>
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
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <html lang="en">

        <head>
            <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" type="text/css" rel="stylesheet" />
            <meta charset="utf-8">
            <title>Prototype</title>
            <link href='<c:url value="/resources/css/Styles.css" />' rel="stylesheet">
            <link href='<c:url value="/resources/css/message-css.css" />' rel="stylesheet">
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
                <div class="col text-center">
                    <h2 class="text-center" style="padding-top: 5px"><strong>Messaging Area</strong></h2>
                    <div class="messaging">
                        <div class="inbox_msg">
                            <div class="msg_history">
                                <div id="hidden"></div>
                            </div>
                        </div>
                        <div class="form">
                            <div class="input_msg_write">
                                <textarea id="input" type="text" placeholder="Click here to type your message" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Click here to enter Username'" style="margin-right: 30px height: 100px width: 410px padding: 10px font-size: 25px"></textarea>
                                <button class="btn btn-primary" type="button" onclick="sendMessage()" style=" border: 3px solid white background-color: #171e75 margin-top: -100px font-size: 25px"><strong>Send Message Button</strong></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </body>
        <script>
            function displayMessage(message, datetime) {

                var hidden = document.getElementById("hidden")
                var divOutgoingMsg = document.createElement('div')
                var divSentMsg = document.createElement('div')
                divSentMsg.className = 'sent_msg'
                var msgP = document.createElement('p')
                msgP.innerHTML = "<p style=\"font-size: 28px\"><strong>" + message + "</strong></p>" + "<i style=\"font-size: 15px\">" + datetime + "</i>"
                msgP.style.padding = '10px'
                msgP.style.fontSize = 'large'

                hidden.style.display = 'block' //Show msg

                divSentMsg.appendChild(msgP)
                divOutgoingMsg.appendChild(divSentMsg)
                hidden.appendChild(divOutgoingMsg)
            }
            
            function sendMessage() {
            	var message = document.getElementById('input').value
            	var http = new XMLHttpRequest()
                var url = '/hobby-site/insertMessage'
                http.open('POST', url, true)
                
                var dateTime = new Date()
                var minutes = dateTime.getMinutes()<10?'0':'' + dateTime.getMinutes()
                        
                var timestamp = dateTime.getHours() + ":" + minutes
                				
                var messageObj = {
                	message,
                	timestamp
                }

                // Send the proper header information along with the request
                http.setRequestHeader('Content-type', 'application/json')

                http.onreadystatechange = function() {//Call a function when the state changes.
                    if(http.readyState == 4 && http.status == 200) {
                        // http.responseText === 'success' ? window.location.href = '/hobby-site/profiles' : window.location.href = '/hobby-site/register'
                    }
                }
                http.send(JSON.stringify(messageObj))
                displayMessage(messageObj.message, messageObj.timestamp)
            }
        </script>

        </html>
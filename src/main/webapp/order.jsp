<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
   <head>
      <title>Ideal Ammunition</title>
      <link rel="stylesheet" type="text/css" href="style.css">
   </head>
    <style>
      body {
           background-image: url("/images/img.jpeg");
           background-repeat: no-repeat;
      }
      .ammunition {
           display: flex;
           width: 72%;
           margin: auto;
      }
      .ammunition > div {
           background-color: #f1f1f1;
           margin: 10px;
           padding: 20px;
           font-size: 20px;
      }
      h3 {
           text-align: center;
      }
      .b {
      float: right;
      }
    </style>
   <body>
   <div class="b">
    <a href="/home.jsp" ><button class="button">Go to Home Page</button></a>
    <a href="/login.jsp" ><button class="button">Sign In!</button></a> &nbsp
    </div>
    <br/>
      <center>
         <h1>Find Your Ideal Ammunition</h1>
         <form name="orderForm" method="GET" action="servlet" >
         <input type="hidden" name="command" value="calculate_ammunition"/>
         Select type:
         <select name="typelist">
            <option value="poor knight">Poor Knight</option>
            <option value="middle knight">Middle-class Knight</option>
            <option value="rich knight">Rich Knight</option>
         </select>
         <br/>
         <input type="submit" class="button" value="calculate"><br/><br/><br/>
      </center>
      <% if (request.getAttribute("helmet") != null) { %>
      <center>
         <p>YOUR IDEAL AMMUNITION:</p>
         <br/>
      </center>
      <div class="ammunition">
         <div>
            <h3>HELMET</h3>
            <p>${helmet}</p>
         </div>
         <div>
            <h3>WEAPON</h3>
            <p>${weapon}</p>
         </div>
         <div>
            <h3>CHAIN ARMOR</h3>
            <p>${chainArmor}</p>
         </div>
         <div>
            <h3>LEG ARMOR</h3>
            <p>${legArmor}</p>
         </div>
         <div>
            <h3>VEHICLE</h3>
            <p>${vehicle}</p>
         </div>
      </div>
      <center>
         <p>PRICE: $${price}</p>
      </center>
      <% } %>
   </body>
</html>


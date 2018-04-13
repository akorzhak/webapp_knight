<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
   <head>
      <title>Ideal Ammunition</title>
      <link rel="stylesheet" type="text/css" href="style.css">
   </head>
    <style>
      body {
           background-image: url("images/img.jpeg");
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
         Your weight: <input type="number" name="weight" min="40" max="120" required><br/><br/>
         <br/>
         <input type="submit" class="button" value="calculate"><br/><br/><br/>
      </center>
      <% if (request.getAttribute("helmetName") != null) { %>
      <center>
         <p>YOUR IDEAL AMMUNITION:</p>
         <br/>
      </center>
      <div class="ammunition">
         <div>
            <h3>HELMET</h3>
            <p>${helmetName}</p>
            <p>description: ${helmetDescription}</p>
            <p>price: $${helmetPrice}</p>
         </div>
         <div>
            <h3>WEAPON</h3>
            <p>${weaponName}</p>
            <p>description: ${weaponDescription}</p>
            <p>price: $${weaponPrice}</p>
         </div>
         <div>
            <h3>CHAIN ARMOR</h3>
            <p>${chainArmorName}</p>
            <p>description: ${chainArmorDescription}</p>
            <p>price: $${chainArmorPrice}</p>
         </div>
         <div>
            <h3>LEG ARMOR</h3>
            <p>${legArmorName}</p>
            <p>description: ${legArmorDescription}</p>
            <p>price: $${legArmorPrice}</p>
         </div>
         <div>
            <h3>VEHICLE</h3>
            <p>${vehicleName}</p>
            <p>description: ${vehicleDescription}</p>
            <p>price: $${vehiclePrice}</p>
         </div>
      </div>
      <center>
         <p>SIZE: ${size}</p>
         <p>PRICE: $${price}</p>
      </center>
      <% } %>
   </body>
</html>


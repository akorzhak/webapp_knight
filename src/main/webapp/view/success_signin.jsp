<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
     <title>Signed in</title>
     <link rel="stylesheet" type="text/css" href="style.css">
</head>
<style>
         body {
         background-image: url("/images/success_signup.jpg");
         background-repeat: no-repeat;
         background-size: 40%;
         background-attachment: fixed;
         background-position: center;
         }
   </style>
<body>
<center>
<h2>Welcome, ${user}!</h2>
You have successfully signed in!</br></br>
<a href="/view/order.jsp"><button class="button">View Product List!</button></a>
<a href="/view/home.jsp"><button class="button">Go to Home Page</button></a>
</center>
</body>
</html>
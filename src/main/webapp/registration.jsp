<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
   <head>
      <title>Sign Up</title>
      <link rel="stylesheet" type="text/css" href="style.css">
   </head>
   <style>
      body {
            background-image: url("images/signup.jpeg");
            background-repeat: no-repeat;
            background-size: 25%;
      }
      form {
            text-align: center;
      }
            .warning {
                 color: red;
            }
   </style>
   <body>
   <form name="registrationForm" method="POST" action="servlet">
        <input type="hidden" name="command" value="register"/>

         <h1>Sign Up, it's FREE!</h1>
         <h3>Please fill in the form to create an account.</h3>
         <input type="text" name="name" placeholder="name..." required><br/>
         <input type="text" name="age" placeholder="age..."  required><br/>
         <input type="text" name="email" placeholder="email..." required><br/>
         <input type="text" name="login" placeholder="login..." required><br/>
         <input type="password" name="password" placeholder="password..." required><br/>
         <input type="checkbox" name="subscribe" value="subsribed"> Subsribe me to your news!<br/>
         <br/>
         <div class="warning">
                ${invalidInputMessage}</br>
                ${notUniqueLoginMessage}</br>
         </div>
         <input type="submit" class="button" value="register"><br/><br/><br/>
    </form>
   </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
   <head>
      <title>Login</title>
      <link rel="stylesheet" type="text/css" href="style.css">
   </head>
   <style>
      body {
            background-image: url("/images/login.jpg");
            background-repeat: no-repeat;
            background-size: 35%;
            background-attachment: fixed;
            background-position: right bottom;
      }
      form {
            text-align: center;
      }
      .warning {
           color: red;
      }
</style>
   <body>
      <form name="loginForm" method="POST" action="servlet">
         <input type="hidden" name="command" value="login"/>
         <h1>Sign in!</h1>
         <input type="text" name="login" placeholder="login..." required><br/>
         <input type="password" name="password" placeholder="password..." required><br/>
         <br/>
         <div class="warning">
            ${invalidLogin}
         </div>
         <br/><br/>
         <input type="submit" class="button" value="Log in"/>
      </form>
   </body>
</html>
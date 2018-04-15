<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8"
						pageEncoding="UTF-8"%>
<html>
<head>
      <title>Error 500</title>
      <link rel="stylesheet" type="text/css" href="style.css">
   </head>
   <style>
         body {

               display: flex;
                   justify-content: center; /*Центрирование по горизонтали*/
                   align-items: center;     /*Центрирование по вертикали */
                   vertical-align: middle;
                   align-items: center;
                     justify-content: center;
               }
         .flex-container {
           display: flex;
         }
      </style>
	<body>

        <div class="flex-container">
         <div><img src="/images/error500.jpg" alt="error 500" width="300" height="250"></div>
		<div>
		<h1 style="color:#6e15a5; font-size:250%;">Oops...</h1>
		<p style="font-size:160%;">Request from ${pageContext.errorData.requestURI} is failed.
		<br/>Status code: ${pageContext.errorData.statusCode}</br>
		Exception: ${pageContext.exception}
        		<br/>
        Message from exception: ${pageContext.exception.message}<br/><br/>
        <a href="/home.jsp"><button class="button">Go to Home Page</button></a>
		</p></div>
		</div>
</body>
</html>
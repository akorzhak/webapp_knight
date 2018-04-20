<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8"
						pageEncoding="UTF-8"%>
<html>
<head>
      <title>Error 404</title>
       <link rel="stylesheet" type="text/css" href="style.css">
   </head>
   <style>
         body {

               display: flex;
                   justify-content: center; /*Центрирование по горизонтали*/
                   align-items: center;     /*Центрирование по вертикали */
                   vertical-align: middle;
               }
         .flex-container {
           display: flex;
         }
      </style>
	<body>

        <div class="flex-container">
         <div><img src="/images/error404.jpg" alt="error 404" width="290" height="290"></div>
		<div>
		<h1 style="color:#6e15a5; font-size:250%;">Oops...</h1>
		<p style="font-size:160%;">Requested page ${pageContext.errorData.requestURI} is not found.
		<br/>
		Status code: ${pageContext.errorData.statusCode}<br/><br/><br/>
		<a href="/view/home.jsp"><button class="button">Go to Home Page</button></a>
		</p></div>
		</div>
</body>
</html>
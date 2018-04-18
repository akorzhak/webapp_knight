<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
   <head>
      <title>Ideal Ammunition</title>
      <link rel="stylesheet" type="text/css" href="style.css">
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   </head>
   <style>
      body {
           background-image: url("/images/img.jpeg");
           background-repeat: no-repeat;
      }
      .request {
           display: flex;
           width: 72%;
           margin: auto;

           justify-content: center;
      }
      .request > div {
           margin: 10px;
           padding: 10px;
           font-size: 20px;
           border-style: groove;
           border-width: 2px;
           background-color: #eaf2ff;
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
      <br/><br/>
      <center>
         <div class="request">
            <div>
               <p>View Full Product List</p>
               <form name="showAmmunition" method="GET" action="servlet" >
                  <input type="hidden" name="command" value="show_all_ammunition"/>
                  <br/><br/>
                  <input type="submit" class="button" value="show all">
               </form>
            </div>
            <div>
               <p>Calculate Your Ideal Set</p>
               <form name="orderForm" method="GET" action="servlet" >
                  <input type="hidden" name="command" value="calculate_ammunition"/>
                  Preferable price:
                  <select name="pricetype">
                     <option value="low price">Low</option>
                     <option value="middle price">Middle</option>
                     <option value="high price">High</option>
                  </select>
                  <br/><br/>
                  <input type="submit" class="button" value="calculate">
               </form>
            </div>
         </div>
         <c:if test="${products != null}">
            <table border="1" cellpadding="5">
               <caption>
                  <h3>Ammunition List</h3>
               </caption>
               <tr>
                  <th>Type</th>
                  <th>Name</th>
                  <th>Description</th>
                  <th>Price</th>
               </tr>
               <c:forEach var="product" items="${products}" varStatus="loop">
                  <tr>
                     <td>
                        <c:out value = "${product.type}"/>
                     </td>
                     <td>
                        <c:out value = "${product.name}"/>
                     </td>
                     <td>
                        <c:out value = "${product.description}"/>
                     </td>
                     <td>
                        <c:out value = "${product.price}"/>
                     </td>
                  </tr>
               </c:forEach>
            </table>
         </c:if>
         <c:if test="${sorted_products != null}">
            <table border="1" cellpadding="5">
               <caption>
                  <h3>Your Ideal Ammunition</h3>
               </caption>
               <tr>
                  <th>Type</th>
                  <th>Name</th>
                  <th>Description</th>
                  <th>Price</th>
               </tr>
               <c:forEach var="sorted_product" items="${sorted_products}" varStatus="loop">
                  <tr>
                     <td>
                        <c:out value = "${sorted_product.type}"/>
                     </td>
                     <td>
                        <c:out value = "${sorted_product.name}"/>
                     </td>
                     <td>
                        <c:out value = "${sorted_product.description}"/>
                     </td>
                     <td>
                        <c:out value = "${sorted_product.price}"/>
                     </td>
                  </tr>
               </c:forEach>
            </table><br/>
            PRICE: $${price}
         </c:if>
      </center>
   </body>
</html>

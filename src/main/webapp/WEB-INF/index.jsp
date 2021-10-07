<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet"
	href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />

	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>
	
	<title>Poke Book</title>
	
</head>

<body>

<h1>PokeBook</h1>

<table class="table table-dark w-50 p-3">
  <thead>
    <tr>
      <th scope="col">Expense</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
  
    <c:forEach var="pbook" items="${pbooks}">
					<tr>
	        			
	        			<td> <a href="/showbook/${pbook.id}"> <c:out value="${pbook.expenseName}"></c:out> </a> </td>
	        			
	        			<td><c:out value="${pbook.vendor}"></c:out></td>
	        			<td>$<c:out value="${pbook.numberOfAmount}"></c:out></td>
	        			<td>
	        			
	        			<div class="d-flex justify-content-evenly">
	        			
	        			 <a  href="/edit/${pbook.id}">Edit</a> |
	        			 
	        			<!-- <a href="/delete/${pbook.id}">Delete</a> --> 
	        			 
	        			<form action="/delete/${pbook.id}" method="post">
	        			
    						<input type="hidden" name="_method" value="delete">
    						
    						<input type="submit" value="Delete" class="bg-transparent text-primary border border-transparent">
    						
						</form>
	        			
	        			</div>
	        			
	        			</td>
	        			
	        		</tr>
    </c:forEach>
    
  </tbody>
</table>

<a  href="/new">New Expense Track</a>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
    
    
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
	
	
	
	
	
	<title>Track an expense:</title>
</head>

<body>
 
<h1>Track an expense</h1>
<form:form action="/pbooks" method="post" modelAttribute="pbook">
		
		
    <p>
        <form:label path="expenseName"> Expense Name </form:label>
        <form:errors path="expenseName"/>
        <form:input path="expenseName"/>
    </p>
    
        
     <p>
        <form:label path="vendor"> Vendor </form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    
    
    <p>
        <form:label path="numberOfAmount"> Amount </form:label>
        <form:errors path="numberOfAmount"/>     
        <form:input type="number" path="numberOfAmount"/>
    </p>
    
    
    <p>
        <form:label path="description"> Description </form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    
          
    <input type="submit" value="Submit"/>
</form:form>    


<div class="d-flex justify-content-center">

<a href="/">Go Back</a>

</div>


</body>
</html>
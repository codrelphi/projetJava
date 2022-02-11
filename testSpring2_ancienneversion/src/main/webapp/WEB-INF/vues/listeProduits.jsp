<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Liste des produits</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
			<div class="row">
				<div class="col-4"></div>
				<div class="col-6">
					<h1>Liste des produits</h1>
				</div>
				<div class="col-2"></div>
			</div>
			<div class="row">
				<table class="table table-bordered">
				  <thead class="thead-dark">
				    <tr>
				      <th class="col-2">Code</th>
				      <th class="col-8">Description</th>
				      <th class="col-2">Prix</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach items="${produits }" var="p">
				  	<tr>
				  		<td>${p.code }</td>
				  		<td>${p.description }</td>
				  		<td>${p.prix }</td>
				  	</tr>
				  </c:forEach>
				  </tbody>
				</table>
			</div>
		</div>
		
	
</body>
</html>
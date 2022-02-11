<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Erreur 403</title>
</head>
<body>
	
	<h1>L'accès aux ressources est interdit !</h1>
	<p>Revenir en <a href="<%= request.getContextPath()%>/hello">arrière</a> !</p>
	
	
</body>
</html>
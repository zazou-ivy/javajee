<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body class="container">
	<%@ include file="menu.jsp" %>

<form method="post" action="" class="container">

   	<div class="form-group">
		    <label for="latitude">Latitude</label>
		    <input type="number" class="form-control" step="0.01" name="latitude"  id="latitude" placeholder="longitude">
  	</div>
  	<div class="form-group">
		    <label for="longitude">Longitude</label>
		    <input type="number"class="form-control" step="0.01" name="longitude"  id="longitude" placeholder="longitude">
  	</div>
</form>
</body>

</html>
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
		    <label for="latitude">Ville</label>
		    <input type="text" class="form-control" step="0.01" name="ville"  id="ville" placeholder="ville">
  	</div>
   	<div class="form-group">
		    <label for="latitude">Latitude</label>
		    <input type="number" class="form-control" step="0.01" name="latitude"  id="latitude" placeholder="longitude">
  	</div>
  	<div class="form-group">
		    <label for="longitude">Longitude</label>
		    <input type="number"class="form-control" step="0.01" name="longitude"  id="longitude" placeholder="longitude">
  	</div>
  	  <button type="submit" name="createHero" value="enr" class="btn btn-primary">Submit</button>
  	<div class="d-flex">
  	<c:forEach var="typeIncident" items="${typeIncidents}"> 
		 <div class="form-check">
		  <input class="form-check-input"  name="incident"   type="radio" value="${typeIncident.id}" id="${typeIncident.name}">
		  <label class="form-check-label" for="${typeIncident.name}">
		    <c:out value="${typeIncident.name}"/>
		  </label>
		</div>
	</c:forEach>
</div>
</form>
</body>

</html>
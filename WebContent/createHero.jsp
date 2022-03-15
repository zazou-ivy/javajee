<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jsp" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body class="container">
	<%@ include file="WEB-INF/menu.jsp" %>

<form method="post" action="" >
  <div class="form-group">
      <label for="Nom">Nom</label>
	<input type="text" class="form-control" name="nom" id="Nom" placeholder=" Nom">
  </div>
   <div class="form-group">
      <label for="Nom">Tél</label>
	<input type="text" class="form-control" name="tel" id="tel"placeholder=" Votre numéro de tel">
  </div>
   <div class="form-group">
      <label for="Nom">longitude</label>
	<input type="number" class="form-control" name="longitude" id="longitude"placeholder=" longitude">
  </div>
   <div class="form-group">
      <label for="Nom">latitude</label>
	<input type="number" class="form-control" name="latitude" id="latitude"placeholder=" latitude">
  </div>
	
	<h1>Déclarez les incidents que vous maitrisez</h1>
	
<div class="d-flex">
  	<c:forEach var="typeIncident" items="${typeIncidents}"> 
		 <div class="form-check">
		  <input class="form-check-input"  name="incident${typeIncident.id}"   type="checkbox" value="${typeIncident.id}" id="${typeIncident.name}">
		  <label class="form-check-label" for="${typeIncident.name}">
		    <c:out value="${typeIncident.name}"/>
		  </label>
		</div>
	</c:forEach>
	<script>$("input:checkbox").click(function() {
		var bol = $("input:checkbox:checked").length >= 3;     
		$("input:checkbox").not(":checked").attr("disabled",bol);
		});</script>
</div>
  <button type="submit" name="createHero" value="enr" class="btn btn-primary">Submit</button>
</form>
</body>

</html>
<%@page import="services.ZoneService"%>
<%@page import="entities.Zone"%>
<%@page import="services.VilleService"%>
<%@page import="entities.Ville"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="fr">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<title>Formulaire de creation de zone</title>
</head>

<body>
	<!-- Header -->
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-4">Creation de zone</h1>
				<form action="ZoneController" method="get">
				<input type="hidden" name="id"
				value="<%=request.getParameter("id") == null ? "" : request.getParameter("id")%>" />
					<div class="form-group">
						<label for="zoneName">Nom de la zone</label> <input type="text"
							class="form-control" name="nom"
					value="<%=request.getParameter("nom") == null ? "" : request.getParameter("nom")%>"
					class="form-control" id="nom">
					</div>
					<div class="form-group">
						<label for="city">Ville</label> 
						
						<select class="form-control" name="city"
							id="city">
							<%
				VilleService vs = new VilleService();
				for (Ville v : vs.findAll()) {
				%>
							<option value=<%=v.getId()%>><%=v.getNom()%></option>	
							<%
				}
				%>
						</select>
						
					</div>
					<button id="add" type="submit"  class="btn btn-primary btn-block"><%=request.getParameter("id") == null ? "Ajouter" : "Modifier"%></button>
				</form>
			</div>
		</div>
		<div class="row mt-5">
			<div class="col-md-6 offset-md-3">
				<h2 class="text-center mb-4">Liste des zones</h2>
				<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">TYPE</th>
					<th scope="col">ACTIONS</th>
				</tr>
			</thead>
			<tbody>
				<!-- Ajoutez ici les lignes du tableau pour chaque ville -->
				<%
				ZoneService zs = new ZoneService();
				for (Zone z : zs.findAll()) {
				%>
				<tr>
					<td><%=z.getId()%></td>
					<td><%=z.getNom()%></td>
					<td><%=z.getVille().getNom() %></td>
					<td><a href="ZoneController?id=<%=z.getId()%>&op=update"
						class="btn btn-primary btn-sm mr-2"> <i class="fas fa-edit"></i>
							Modifier
					</a> <a href="ZoneController?id=<%=z.getId()%>&op=delete"
						class="btn btn-danger btn-sm"> <i class="fas fa-trash-alt"></i>
							Supprimer
					</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/template/footer.jsp" />
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.16.6/dist/umd/popper.min.js"
		integrity="sha384-Q2XjA0n+bJZPVZ8WpZj1nAJpAEYtRnG8WPU9+4B3tJ5Ht3Kj2gSZM5PZO5NQq5g5E"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>

</html>


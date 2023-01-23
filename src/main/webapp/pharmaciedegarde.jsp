<%@page import="entities.PharmacieDeGarde"%>
<%@page import="services.PharmacieDeGardeService"%>
<%@page import="entities.Garde"%>
<%@page import="services.GardeService"%>
<%@page import="entities.Ville"%>
<%@page import="entities.Pharmacie"%>
<%@page import="entities.Zone"%>
<%@page import="services.VilleService"%>
<%@page import="services.ZoneService"%>
<%@page import="services.PharmacieService"%>
<%@page import="entities.Pharmacien"%>
<%@page import="services.PharmacienService"%>
<%@page import="entities.Photo"%>
<%@page import="services.PhotoService"%>
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

<title>Formulaire de création de pharmacie de garde</title>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
</head>

<body>
	<!-- Header -->
	
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-4">Création de pharmacie de garde</h1>
				<form id="firstform" action="PharmacieDeGardeController" method="get" enctype="multipart/form-data">
				
				<div class="form-group">
						<label for="pic">Date debut</label> 
								<input type="date" id="datedebut" name="datedebut"  required pattern="\d{4}-\d{2}-\d{2}
								value="<%= request.getParameter("datebedut")%>">
				<label for="pic"></label>
				<label for="pic"></label> 
				<label for="pic"></label> 
						<label for="pic">Date Fin</label> 
								<input type="date" id="datefin" name="datefin"  required pattern="\d{4}-\d{2}-\d{2}
								value="<%= request.getParameter("datefin")%>">
				</div>
				
					<div class="form-group">
						<label for="pharma">Pharmacie</label> 
						
						<select class="form-control" name="pharmacie"
							id="pharmacie">
							<%
							Pharmacien pharmacien = (Pharmacien)session.getAttribute("user");
				PharmacieService phs = new PharmacieService();
				for (Pharmacie ph : phs.findAll()) {
					if(ph.getPharmacien().getId()==pharmacien.getId()){
						
					
				%>
				<option value=<%=ph.getId() %>><%=ph.getNom()%></option>
								
							<%
				}}
				%>
						</select>
						
					</div>
					
					
					<div class="form-group">
						<label for="garde">Garde</label> 
						<select   class="form-control"  name="garde" id="garde">
						
						
						<%
								 	GardeService zs = new GardeService();
									for(Garde z : zs.findAll()){
						%>
							<option value=<%=z.getId() %>><%=z.getType()%></option>
							<%
									}
				%> </select>
					</div>
					<button id="add" type="submit"  class="btn btn-primary btn-block"><%=request.getParameter("datedebut") == null ? "Créer" : "Modifier"%></button>
				</form>
			</div>
		</div>
			<div class="row justify-content-center">
			<div class="col-auto" align="center">
			<br>
				<h2 class="text-center mb-4">Liste des pharmacies de garde</h2>
				<table class="table table-responsive" align="center">
			<thead>
				<tr class="table-primary">
					<th scope="col">PHOTO</th>
					<th scope="col">NOM</th>
					<th scope="col">VILLE</th>
					<th scope="col">ZONE</th>
					<th scope="col">PHARMACIEN</th>
					<th scope="col">GARDE</th>
					<th scope="col">DATE-DEBUT</th>
					<th scope="col">DATE-FIN</th>
					<th scope="col">ACTIONS</th>
				</tr>
			</thead>
			<tbody>
				<!-- Ajoutez ici les lignes du tableau pour chaque ville -->
				<%
				PharmacieDeGardeService ps = new PharmacieDeGardeService();
				for (PharmacieDeGarde p : ps.findAll()) {
				%>
				<tr>
					
					<%PhotoService pss = new PhotoService(); %>
					<td><img src="img/<%=pss.findByPharma(p.getPharmacie()).getUrl() %>" style="width:75px;height:75px;"></td>
					<td><%=p.getPharmacie().getNom()%></td>			
					<td><%=p.getPharmacie().getZone().getVille().getNom() %></td>
					<td><%=p.getPharmacie().getZone().getNom() %></td>
					<td><%=p.getPharmacie().getPharmacien().getPrenom() %></td>
					<td><%=p.getGarde().getType() %></td>
					<td><%=p.getPk().getDateDebut()%></td>
					<td><%=p.getDateFin() %></td>
					
					
					
					
					<td><a href="PharmacieController?id=<%%>&op=afficher"
                                class="btn btn-warning btn-sm mr-2"> <i class="fas fa-edit"></i>
                                    Afficher
                            </a>
					<a href="PharmacieController?id=<%%>&op=update"
						class="btn btn-primary btn-sm mr-2"> <i class="fas fa-edit"></i>
							Modifier
					</a> <a href="PharmacieController?id=<%%>&op=delete"
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
<script>


					                </script>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script type="text/javascript">
	
</script>
	
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

<%@page import="entities.PharmacieDeGarde"%>
<%@page import="services.PharmacieDeGardeService"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<title>Search</title>

</head>

<body>
	<!-- Header -->
	
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-4">Search</h1>
				
			<form id="firstform" action="Home.jsp?vid=<%=request.getParameter("ville")%>&zid=<%=request.getParameter("zone")%>gid=<%=request.getParameter("garde")%>"  enctype="multipart/form-data">
				
					<div class="form-group">
						<label for="ville">Ville</label> 
						<select   class="form-control"  name="ville" id="ville">
						<option value disabled selected>Selectionner Une Ville</option>
						<%
								 	VilleService vs = new VilleService();
									for(Ville v:vs.findAll()){
						%>	
							<option value=<%=v.getId() %>><%=v.getNom()%></option>
							<%}%>
						</select>
						</div>
					<div class="form-group">
						<label for="zone">Zone</label> 
						<select   class="form-control"  name="zone" id="zone">
							
					    </select>
					</div>
					<div class="form-group">
						<label for="zone">Garde</label> 
						<select   class="form-control"  name="garde" id="garde">
							<option value=nuit>nuit</option>
							<option value=jour>jour</option>
							
					    </select>
					</div>
									<button id="add" type="submit"  class="btn btn-primary btn-block">Afficher Les pharmacies</button>
								</form>
				
			</div>
		</div>
		
		<div class="row justify-content-center">
			<div class="col-auto" align="center">
			<br>
				<h2 class="text-center mb-4">Liste des pharmacies</h2>
				<table class="table table-responsive" align="center">
			<thead>
				<tr class="table-primary">
					<th scope="col">PHOTO</th>
					<th scope="col">NOM</th>
					<th scope="col">ADRESSE</th>
					<th scope="col">LATITUDE</th>
					<th scope="col">LOGITUDE</th>
					<th scope="col">VILLE</th>
					<th scope="col">ZONE</th>
					<th scope="col">PHARMACIEN</th>
					<th scope="col">DATE-DEBUT</th>
					<th scope="col">DATE-FIN</th>
					<th scope="col">ACTIONS</th>
				</tr>
			</thead>
			<tbody>
					<!-- Ajoutez ici les lignes du tableau pour chaque ville -->
				<%
				String a =request.getParameter("ville");
				String b =request.getParameter("zone");
				String c =request.getParameter("garde");
				if(a!=null && b!=null && c!=null){
				PharmacieDeGardeService ps = new PharmacieDeGardeService();
				for (PharmacieDeGarde p : ps.findAll()) {
					int aa = Integer.parseInt(a);
					int bb = Integer.parseInt(b);
					if(p.getGarde().getType().equals(c)==true&&p.getPharmacie().getZone().getId()==aa&&p.getPharmacie().getZone().getVille().getId()==bb){
					
				%>
				<tr>
					
					<%PhotoService pss = new PhotoService(); %>
					<td><img src="img/<%=pss.findByPharma(p.getPharmacie()).getUrl() %>" style="width:75px;height:75px;"></td>
					<td><%=p.getPharmacie().getNom()%></td>			
					<td><%=p.getPharmacie().getAddress() %></td>
					<td><%=p.getPharmacie().getLatitude()%></td>
					<td><%=p.getPharmacie().getLongitude()%></td>
					<td><%=p.getPharmacie().getZone().getVille().getNom() %></td>
					<td><%=p.getPharmacie().getZone()%></td>
					<td><%=p.getPharmacie().getPharmacien().getPrenom()%></td>
					<td><%=p.getPk().getDateDebut()%></td>
					<td><%=p.getDateFin() %></td>
				<td><a href="PharmacieController?id=<%=p.getPharmacie().getId()%>&op=afficher"
                                class="btn btn-warning btn-sm mr-2"> <i class="fas fa-edit"></i>
                                    Afficher
                            </a>
				</td>
				</tr>
				<%
				}}}
				%>
			</tbody>
		</table>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/template/footer.jsp" />

	
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous">
	</script>
	
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	  <script >
	$(document).ready(function () {
		//$("#ville option[value='']").attr('selected', true)
		console.log("yes");
	    $("#ville").change(function (e) {
	    	var ville=$('#ville').val();
	    	console.log(ville);
	    		e.preventDefault();
	            $.ajax ({
	            url: 'ZoneByVilleController',
	            data: {ville:ville},
	            datatype: 'json',
	            type: 'POST',
	            success: function (data) {
	            	$("#zone").html(data);
	            	
	            	console.log('success');
	            	//console.log(data);
	            	
	               
	            },error: function(request,status,errorThrown)
	            {
	            	console.log(request);
	            	console.log(status)
	            	console.log(errorThrown)
	            }
	           
	        })
	    })


	})
	
	</script>
</body>

</html>


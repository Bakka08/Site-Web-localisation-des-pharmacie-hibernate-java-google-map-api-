<%@page import="entities.Admin"%>
<%@page import="entities.Pharmacien"%>
<%@page import="entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg bg-primary navbar-dark" >
  <a class="navbar-brand" style="font-weight: 900;" href="">Localisation des pharmacies</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
 
	  
	   <%
  if( (User)session.getAttribute("user") instanceof Pharmacien){
	  Pharmacien pharmacien = (Pharmacien)session.getAttribute("user");
	%>   <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav ml-auto" style="font-weight: 900;">
      <li class="nav-item">
        <a class="nav-link" style="font-weight: 900;" href="#">Bonjour Pharmacien  : <%=pharmacien.getPrenom() %></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#">Accueil</a>
      </li>
  
        <li class="nav-item">
        <a class="nav-link" href="pharmacie.jsp">Gestion des pharmacie	</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="pharmaciedegarde.jsp">Gestion des pharmacie de garde	</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Home.jsp">Search</a>
      <li class="nav-item">
        <a href="Logout"
						class="btn btn-dark "style="font-weight: 900;">
							Deconnexion
					</a>
      </li>
      
    </ul>
  </div>
	 <% }else if( (User)session.getAttribute("user") instanceof Admin){
		 Admin admin = (Admin)session.getAttribute("user");
	%>     <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="#">Bonjour Admin  :  <%= admin.getNom() %></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#">Accueil</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./villes.jsp">Gestion des villes</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="zones.jsp">Gestion des zones</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="garde.jsp">Gestion des gardes</a>
        <li class="nav-item">
        <a class="nav-link" href="Home.jsp">Search</a>
       <li class="nav-item">
        <a href="Logout"
						class="btn btn-dark ">
							Deconnexion
					</a>
      </li>
    </ul>
  </div>
	 <% }
		 
	%>  
	


</nav>

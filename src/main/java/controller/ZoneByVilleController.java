package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.VilleService;
import services.ZoneService;

import java.awt.Window.Type;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import entities.Zone;

/**
 * Servlet implementation class ZoneByVilleController
 */

public class ZoneByVilleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VilleService vs = new VilleService();
	ZoneService zs = new ZoneService();
	
	  protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		  int id = Integer.parseInt(request.getParameter("ville"));
		  System.out.println("id = "+id);
		  PrintWriter pw = response.getWriter();
		  var ligne="";
          
          	for(Zone z : zs.findZonesByVille(vs.findById(id))){

              ligne+="<option value="+z.getId()+">"+z.getNom()+"</option>";
          }
		 
		  pw.print(ligne);
		  /* int id = Integer.parseInt(request.getParameter("ville"));
	        System.out.println("id = "+id);
	        response.setContentType("application/json;charset=UTF-8");
	         List<Zone> l = zs.findZonesByVille(vs.findById(id));
				
			String jsonString = new Gson().toJson(l);
				response.setContentType("text/html");
				response.getWriter().write(jsonString);*/
			
	        
	    //Type type = new TypeToken<Collection<Machine>>(){}.getType(); 
	      //  Collection<Machine> etudiants = new Gson().fromJson(response, type);        
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
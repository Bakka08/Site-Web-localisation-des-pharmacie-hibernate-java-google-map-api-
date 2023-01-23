package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.VilleService;
import services.ZoneService;

import java.io.IOException;

import entities.Ville;
import entities.Zone;

/**
 * Servlet implementation class ZoneController
 */
public class ZoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ZoneService zs;
    private VilleService vs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZoneController() {
        zs = new ZoneService();
        vs = new VilleService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				zs.delete(zs.findById(id));
				response.sendRedirect("zones.jsp");
			}
			if (request.getParameter("op").equals("update")) {
				Zone z = zs.findById(Integer.parseInt(request.getParameter("id")));
				response.sendRedirect("zones.jsp?id=" + z.getId() + "&nom=" + z.getNom());
			}

		} else if (!request.getParameter("id").equals("")) {
			Zone z = zs.findById(Integer.parseInt(request.getParameter("id")));
			String nom = request.getParameter("nom");
			int idville =Integer.parseInt(request.getParameter("city"));
			z.setNom(nom);
			z.setVille(vs.findById(idville));
			zs.update(z);
			response.sendRedirect("zones.jsp");
			
		}else  {
			String nom = request.getParameter("nom");
			int idville =Integer.parseInt(request.getParameter("city"));
			
			zs.create(new Zone(nom,vs.findById(idville)));
			response.sendRedirect("zones.jsp");
		}

			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

package controller;

import java.io.IOException;

import entities.Garde;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.GardeService;

/**
 * Servlet implementation class VilleController
 */
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private  GardeService vs ;

	/**
	 * Default constructor.
	 */
	public GradeController() {
		// TODO Auto-generated constructor stub
		vs = new GardeService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				vs.delete(vs.findById(id));
				response.sendRedirect("garde.jsp");
			}
			if (request.getParameter("op").equals("update")) {
				Garde v = vs.findById(Integer.parseInt(request.getParameter("id")));
				response.sendRedirect("garde.jsp?id=" + v.getId() + "&type=" + v.getType());
			}

		} else if (!request.getParameter("id").equals("")) {
			Garde v = vs.findById(Integer.parseInt(request.getParameter("id")));
			String type = request.getParameter("type");
			v.setType(type);
			vs.update(v);
			response.sendRedirect("garde.jsp");
			
		}else  {
			String type = request.getParameter("type");
			vs.create(new Garde(type));
			response.sendRedirect("garde.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.GardeService;
import services.PharmacieDeGardeService;
import services.PharmacieService;
import services.PharmacienService;
import services.PhotoService;
import services.ZoneService;

import java.io.IOException;

import entities.Garde;
import entities.Pharmacie;
import entities.PharmacieDeGarde;
import entities.PharmacieGardePK;
import entities.Zone;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  

/**
 * Servlet implementation class PharmacieDeGardeController
 */
public class PharmacieDeGardeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PharmacieDeGardeService pgs;
	private PharmacieDeGarde pg;
	private PharmacieGardePK pgpk;
	private GardeService gs;
	private PharmacieService ps;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmacieDeGardeController() {
    pgs = new PharmacieDeGardeService();
    gs=new GardeService();
    ps= new PharmacieService();
    
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String datedebut = request.getParameter("datedebut");
		String datefin = request.getParameter("datefin");
		int idpahrmacie =Integer.parseInt(request.getParameter("pharmacie"));
		int idgarde =Integer.parseInt(request.getParameter("garde"));
		String replaceString1=datedebut.replace('-','/');
		String replaceString2=datefin.replace('-','/');
		
    	
		Date d1;
		Date d2;
		
		
	
		PharmacieGardePK pgpk = new PharmacieGardePK(idpahrmacie, idgarde,  d1 = new Date(replaceString1));
		
		pgs.create(new PharmacieDeGarde(pgpk, d2 = new Date(replaceString2), gs.findById(idgarde), ps.findById(idpahrmacie)));
		
		response.sendRedirect("pharmaciedegarde.jsp");

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
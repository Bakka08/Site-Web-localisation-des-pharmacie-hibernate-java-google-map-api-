package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import services.PharmacieService;
import services.PharmacienService;
import services.PhotoService;
import services.ZoneService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



import entities.Pharmacie;
import entities.Pharmacien;
import entities.Photo;
import entities.Ville;
import entities.Zone;

/**
 * Servlet implementation class PharmacieController
 */
@MultipartConfig
public class PharmacieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private PharmacieService ps;
       private ZoneService zs;
       private PharmacienService phs;
       private PhotoService pp;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmacieController() {
        ps = new PharmacieService();
        zs = new ZoneService();
        phs = new PharmacienService();
        pp = new PhotoService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				pp.delete(pp.findByPharma(ps.findById(id)));
				ps.delete(ps.findById(id));
				
				response.sendRedirect("pharmacie.jsp");
			}
			if (request.getParameter("op").equals("update")) {
				Pharmacie v = ps.findById(Integer.parseInt(request.getParameter("id")));
				response.sendRedirect("pharmacie.jsp?id=" + v.getId() + "&nom=" + v.getNom());
			}if (request.getParameter("op").equals("afficher")) {
                Pharmacie p = ps.findById(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("map.jsp?&latitude=" + p.getLatitude() + "&logitude=" + p.getLongitude() );}

		} else if (!request.getParameter("id").equals("")) {
			
			Pharmacie v = ps.findById(Integer.parseInt(request.getParameter("id")));
			String nom = request.getParameter("nom");
			String adresse = request.getParameter("adresse");
			Pharmacien pharmacien = phs.findById(Integer.parseInt(request.getParameter("pharmacien")));
			double latitude = Double.parseDouble(request.getParameter("latitude"));
			double longitude = Double.parseDouble(request.getParameter("longitude"));
			Zone zone = zs.findById(Integer.parseInt(request.getParameter("zone")));
			v.setNom(nom);
			v.setAddress(adresse);
			v.setLatitude(latitude);
			v.setLongitude(longitude);
			v.setZone(zone);
			v.setPharmacien(pharmacien);
			ps.update(v);
			response.sendRedirect("pharmacie.jsp");
			
		}else  {
			
			String nom = request.getParameter("nom");
			String adresse = request.getParameter("adresse");
			double latitude = Double.parseDouble(request.getParameter("latitude"));
			double longitude = Double.parseDouble(request.getParameter("longitude"));
			Zone zone = zs.findById(Integer.parseInt(request.getParameter("zone")));
			Pharmacien pharmacien = phs.findById(Integer.parseInt(request.getParameter("pharmacien")));
			
				Part file = request.getPart("photo");
				String imgFileName = file.getSubmittedFileName();
				String uploadPath = "C:/Users/computer/eclipse-workspace/Pharmacie/src/main/webapp/img/"+imgFileName;
				FileOutputStream fos = new FileOutputStream(uploadPath);
				InputStream is = file.getInputStream();
				byte[] data = new byte[is.available()];
	            is.read(data);
	            fos.write(data);
	            fos.close();
			
			
			
			Pharmacie pharma =new Pharmacie(nom, adresse, longitude, latitude, pharmacien, zone);
			ps.create(pharma);
			Photo p=new Photo(imgFileName,pharma);
			pp.create(p);
			/*} catch(Exception e) {
				e.printStackTrace();
			}*/
			response.sendRedirect("pharmacie.jsp");
			
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
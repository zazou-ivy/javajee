package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Hero;
import entity.Incident;
import entity.TypeIncident;
import model.HeroRepository;
import model.IncidentRepository;
import model.Myconnection;


@WebServlet("/createIncident")
public class ServletIncident extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IncidentRepository incidentRepository;	
	private HeroRepository heroRepository;	
	public ServletIncident() {
		incidentRepository = new IncidentRepository();
		heroRepository = new HeroRepository();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TypeIncident> typeIncidents = heroRepository.findAllTypeIncident();
		System.out.println("typeIncidents=" + typeIncidents);
		request.setAttribute("typeIncidents", typeIncidents);
		request.setAttribute("page", "createIncident");
		System.out.println("doGet");
		String urlVue = "/WEB-INF/createIncident.jsp";
		request.getRequestDispatcher(urlVue).forward(request, response); 		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		if(request.getParameter("createIncident") != null) {
			System.out.println("createIncident");
			String ville = request.getParameter("ville");  
			double longitude = Double.parseDouble(request.getParameter("longitude")); 
			double latitude = Double.parseDouble(request.getParameter("latitude")); 
			Incident incident = new Incident(ville, latitude, longitude);
			int idIncident = incidentRepository.creerIncident(incident); 
		}
	}
}

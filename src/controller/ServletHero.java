package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Hero;
import entity.TypeIncident;
import model.HeroRepository;


@SuppressWarnings("serial")
@WebServlet("/createHero")
public class ServletHero extends HttpServlet {
	private HeroRepository heroRepository;	
    public ServletHero() {
    	heroRepository = new HeroRepository();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TypeIncident> typeIncidents = heroRepository.findAllTypeIncident();
		System.out.println("typeIncidents=" + typeIncidents);
		request.setAttribute("typeIncidents", typeIncidents);
		request.setAttribute("page", "createHero");
		System.out.println("doGet");
		String urlVue = "createHero.jsp";
		request.getRequestDispatcher(urlVue).forward(request, response); 
	}


	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		if(request.getParameter("createHero") != null) {
			System.out.println("createHero");
			String nom = request.getParameter("nom");  
			String tel = request.getParameter("tel"); 
			double longitude = Double.parseDouble(request.getParameter("longitude")); 
			double latitude = Double.parseDouble(request.getParameter("latitude")); 
			Hero hero = new Hero(nom, tel, latitude, longitude);
			int idHero = heroRepository.creer(hero); 
			
			for(int i = 1; i<= 10; i++) {
				System.out.println("bonjour");
				String id_incident = request.getParameter("incident".concat(String.valueOf(i)));
				System.out.println(id_incident);
				if(id_incident != null) {
					System.out.println("salut");
					heroRepository.insertTypeIncidents(idHero, Integer.parseInt(id_incident));
				}
			}
		}
		doGet(request, response);
	}		
}


package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/createIncident")
public class ServletIncident extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public ServletIncident() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "createIncident");
		System.out.println("doGet");
		String urlVue = "createIncident.jsp";
		request.getRequestDispatcher(urlVue).forward(request, response); 		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

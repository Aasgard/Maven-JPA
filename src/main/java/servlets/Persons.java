package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PersonService;

@WebServlet(name = "persons", urlPatterns = { "/Persons" })
public class Persons extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PersonService ps = new PersonService();
		
		PrintWriter out = response.getWriter();

		out.println("<HTML>\n<BODY>\n" + "<H1>Tous les utilisateurs</H1>\n" + ps.getPersons() + "</BODY></HTML>");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
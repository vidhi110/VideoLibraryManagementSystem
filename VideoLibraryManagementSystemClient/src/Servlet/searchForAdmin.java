package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Movie;
import entity.Person;

/**
 * Servlet implementation class searchForAdmin
 */
public class searchForAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public searchForAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VideoLibrary.ServiceProxy proxy = new VideoLibrary.ServiceProxy();
		response.setContentType("text/html");
		proxy.setEndpoint("http://localhost:8080/VideoLibraryManagementSystem/services/Service");
		HttpSession session = request.getSession(false);

		String formname = request.getParameter("formname");

		try {

			if (formname.equals("searchMovie")) {
				
				String searchBy = request.getParameter("searchBy"); // the search category selected by user
				String searchValue = request.getParameter("searchTextValue"); // the search keyword entered by user

				//method call to search movies on basis of parameters passsed ; it returns array of matching movies
				Movie[] listMovies = proxy.searchMovie(searchBy, searchValue); 

				if (listMovies == null) {

					response.sendRedirect("NotFound.jsp"); // if no records matching the parameters found
				} else {
					// list of  movies obtained after searching are shown on homescreen
					session.setAttribute("displayMovies", listMovies);
					RequestDispatcher reqDispatcher = request.getRequestDispatcher("listMovies.jsp");
					reqDispatcher.forward(request, response);
				}
			}

			if (formname.equals("searchPerson")) {
				String searchBy = request.getParameter("searchBy"); // the search parameter selected by user
				String searchValue = request.getParameter("searchTextValue"); // the keyword entered by user

				// member is searched based on the parameters passed
				Person[] listPerson = proxy.searchPerson(searchBy, searchValue);

				if (listPerson == null) {
					//if no matching result found 
					response.sendRedirect("NotFoundAdmin.jsp");

				} else {
					//list of members obtained after searching is shown on listAllMmbers page
					session.setAttribute("listAllMembers", listPerson);
					RequestDispatcher reqDispatcher = request.getRequestDispatcher("listAllMembers.jsp");
					reqDispatcher.forward(request, response);
				}
			}

		} catch (Exception E) {
		}

	}

}

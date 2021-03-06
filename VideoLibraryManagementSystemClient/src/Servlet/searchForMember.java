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

/**
 * Servlet implementation class searchForMember
 */
public class searchForMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public searchForMember() {
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

					if (listMovies == null) {

						response.sendRedirect("NotFound.jsp"); // if no records matching the parameters found
					}
				} else {
					session.setAttribute("displayMovies", listMovies);
					// list of  movies obtained after searching are shown on homescreen
					RequestDispatcher reqDispatcher = request.getRequestDispatcher("homescreen.jsp");
					reqDispatcher.forward(request, response);
				}
			}

		} catch (Exception E) {
		}

	}

}

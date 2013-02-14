package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VideoLibrary.ServiceProxy;
import entity.Movie;
import entity.Person;


/**
 * Servlet implementation class delete
 */
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy = new ServiceProxy();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		doPost(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);	
		VideoLibrary.ServiceProxy proxy = new VideoLibrary.ServiceProxy();
		proxy.setEndpoint("http://localhost:8080/VideoLibraryManagementSystem/services/Service");
		String formname = request.getParameter("formname");


				if (formname.equals("deleteMovie"))
				{
					
				int movieId = Integer.parseInt(request.getParameter("movieId"));
				String movieName = request.getParameter("movieName");


					boolean result =proxy.deleteMovie(movieId,movieName); //call delete method 
						if(result == false || result == true){						
						Movie[] listMovies=proxy.displayMovies();
						session.setAttribute("displayMovies", listMovies); // set and pass array of movies 
						RequestDispatcher reqDispatcher = request.getRequestDispatcher("listMovies.jsp"); // after delete is done redirect ot listmovies page
						reqDispatcher.forward(request, response);

					}
				}
				
				
				if (formname.equals("deletePerson")){	
					long memberId = Long.parseLong(request.getParameter("memberId"));

					boolean result =proxy.deleteMember(memberId); // method call to delete a member
					if(result == true){						

					Person[] listPerson=proxy.displayPerson();
					session.setAttribute("listAllMembers", listPerson);
					RequestDispatcher reqDispatcher = request.getRequestDispatcher("listAllMembers.jsp");
					reqDispatcher.forward(request, response);
					}
				}

		 }		 

}



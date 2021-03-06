package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VideoLibrary.ServiceProxy;
import entity.Movie;
import entity.PremiumMembers;
import entity.SimpleMembers;


/**
 * Servlet implementation class adminMovie
 */
public class adminMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy = new ServiceProxy();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		VideoLibrary.ServiceProxy proxy = new VideoLibrary.ServiceProxy();
		response.setContentType("text/html");
		proxy.setEndpoint("http://localhost:8080/VideoLibraryManagementSystem/services/Service");
		HttpSession session = request.getSession(false);


		String formname = request.getParameter("formname");

		try {
			
			if (formname.equals("allMovies"))
			{
			Movie[] listMovies=proxy.displayMovies();		
			session.setAttribute("displayMovies", listMovies);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("listMovies.jsp");
			reqDispatcher.forward(request, response);
			}

			if (formname.equals("addMovie"))
			{
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("addMovie.jsp");
			reqDispatcher.forward(request, response);
			}
			
			if (formname.equals("displayAllMembers"))
			{
//			SimpleMembers[] listAllMembers =	proxy.displayPerson(); // remaining 
//			session.setAttribute("listAllMembers", listAllMembers);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("listAllMembers.jsp");
			reqDispatcher.forward(request, response);
			}


			if (formname.equals("displaySimple"))
			{
//			SimpleMembers[] listsimple =	proxy.displaySimpleMembers(); // remaining 
//			session.setAttribute("listsimple", listsimple);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("listSimpleMembers.jsp");
			reqDispatcher.forward(request, response);
			}

			if (formname.equals("displayPremium"))
			{
				
//			PremiumMembers[] listpremium =	proxy.displayPremiumMembers(); // remaining 
//			session.setAttribute("listpremium", listpremium);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("listPremiumMembers.jsp");
			reqDispatcher.forward(request, response);
			}

		}
		catch (Exception e) {
		e.printStackTrace();}

	
	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		PrintWriter out = response.getWriter();
		VideoLibrary.ServiceProxy proxy = new VideoLibrary.ServiceProxy();
		response.setContentType("text/html");
		proxy.setEndpoint("http://localhost:8080/VideoLibraryManagementSystem/services/Service");
		HttpSession session = request.getSession(false);


		String formname = request.getParameter("formname");

		try {
			
			if (formname.equals("allMovies"))
			{
			Movie[] listMovies=proxy.displayMovies();			
			session.setAttribute("displayMovies", listMovies);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("listMovies.jsp");
			reqDispatcher.forward(request, response);
			}

			if (formname.equals("addMovie"))
			{
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("addMovie.jsp");
			reqDispatcher.forward(request, response);
			}
			
			if (formname.equals("displayAllMembers"))
			{
			//SimpleMembers[] listAllMembers =	proxy.displayPerson(); // remaining 
		//	session.setAttribute("listAllMembers", listAllMembers);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("listAllMembers.jsp");
			reqDispatcher.forward(request, response);
			}


			if (formname.equals("displaySimple"))
			{
		//	SimpleMembers[] listsimple =	proxy.displaySimpleMembers(); // remaining 
			//session.setAttribute("listsimple", listsimple);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("listSimpleMembers.jsp");
			reqDispatcher.forward(request, response);
			}

			if (formname.equals("displayPremium"))
			{
				
			//PremiumMembers[] listpremium =	proxy.displayPremiumMembers(); // remaining 
			//session.setAttribute("listpremium", listpremium);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("listPremiumMembers.jsp");
			reqDispatcher.forward(request, response);
			}

		}
		catch (Exception e) {
		e.printStackTrace();}

	
	}

}

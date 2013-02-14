package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Movie;
import entity.Person;

import VideoLibrary.ServiceProxy;

import java.io.*;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceProxy proxy = new ServiceProxy();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		VideoLibrary.ServiceProxy proxy = new VideoLibrary.ServiceProxy();
		response.setContentType("text/html");

		try {
			HttpSession session = request.getSession(true);

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			proxy.setEndpoint("http://localhost:8080/VideoLibraryManagementSystem/services/Service");
			if (email.equals("admin")) {

				response.sendRedirect("adminHome.jsp"); // if admin redirect to admin home.

			}
			else {
			Person person = proxy.login(email, password); // validate login details
			
			if (person == null) {
				if (session != null) {
					session.invalidate();
					
					response.sendRedirect("login.jsp?isValid=No"); // if wrong login details redirect to login page
				}
			}

			else {
				
				session.setAttribute("personDetails", person); // set person details 
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("memberhome.jsp"); // redirect to member home if login details are correct
				reqDispatcher.forward(request, response);
			}
		} 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

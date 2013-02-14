import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;

import VideoLibrary.Service;
import org.junit.Test;

import entity.Cart;
import entity.Movie;
import entity.Person;
import junit.framework.Assert;
import junit.framework.TestCase;
public class test extends TestCase {
	public test(String name) {
		super(name);
	}

	Service objService = new Service();


	 public void testcreateMember() throws SQLException {
	 long memberId = 111223341; /////
	 String fName = "Riya";
	 String lName = "Lock";
	 String emailId = "Riya@r.com"; /////
	 String pwd = "riya";
	 String address= "tim";
	 String city="tim";
	 long zipCode = 95123;
	 String state = "California";
	 Integer userType = 0;
	 Integer monthlySubFee = 50;
	 Integer totalOutstandingMovies=0;
	 Integer rentForMoviesIssued=0;
	 assertEquals("true", objService.createMember(memberId, fName, lName,
	 emailId, pwd, address, city, state, zipCode, userType, monthlySubFee,
	 totalOutstandingMovies, rentForMoviesIssued));
	
	 }

	 public void testcreateMemberDuplicate() throws SQLException {
	 long memberId = 111223333;
	 String fName = "Tim";
	 String lName = "Lock";
	 String emailId = "riya@r.com"; ////
	 String pwd = "riya";
	 String address= "tim";
	 String city="tim";
	 long zipCode = 95123;
	 String state = "California";
	 Integer userType = 0;
	 Integer monthlySubFee = 50;
	 Integer totalOutstandingMovies=0;
	 Integer rentForMoviesIssued=0;
	 assertEquals("false", objService.createMember(memberId, fName, lName,
	 emailId, pwd, address, city, state, zipCode, userType, monthlySubFee,
	 totalOutstandingMovies, rentForMoviesIssued));
	
	 }

	 public void testLogin() throws SQLException {
	 Person person = objService.login("eSimp66@e.com", "123456"); ////
	 String fname = "fname66";
	 assertEquals(person.getFirstName(), fname);
	 }

	 public void testLoginFail() throws SQLException {
	 assertEquals(null, objService.login("a@a.com", "tom"));
	 }

	 public void testdeleteMember() throws SQLException {
	 long membershipId = 222222251; ///////
	 assertEquals(true, objService.deleteMember(membershipId ));
	 }

	 public void testdeleteMemberFail() throws SQLException {
	 long membershipId = 868686868;
	 assertEquals(false, objService.deleteMember(membershipId ));
	 }

	 public void testmemberFromID() throws SQLException {
	 long memberId = 121111111; // passed wrong Id
	 assertEquals(null, objService.memberFromID(memberId ));
	 }

	 public void testdeleteMovieFail() throws SQLException { 
	 int movieId = 9;
	 String movieName = "mm";
	 assertEquals(false, objService.deleteMovie(movieId, movieName));
	 }

	 public void testcreateMovie() throws SQLException {
	 String movieName = "Kaal";
	 String movieBanner = "Yash";
	 long date = 2011-11-11;
	 Date movieReleaseDate = new Date(date);
	 float movieRent = 7;
	 String movieCategory= "Action";
	 int availableCopies= 10;
	 assertEquals(true, objService.createMovie(movieName, movieBanner,
	 movieReleaseDate,
	 movieRent, movieCategory, availableCopies));
	 }

	 public void testcreateMovieFail() throws SQLException { 
	 String movieName = null;
	 String movieBanner = "Yash";
	 long date = 2011-11-11;
	 Date movieReleaseDate = new Date(date);
	 float movieRent = 7;
	 String movieCategory= "Action";
	 int availableCopies= 10;
	 assertEquals(false, objService.createMovie(movieName, movieBanner,
	 movieReleaseDate,
	 movieRent, movieCategory, availableCopies));
	 }

		
	 public void testdisplayMovies() throws SQLException {
	 Movie[] listMovies = objService.displayMovies();
	 String name = listMovies[0].getMovieName();
	 assertEquals("movie1",name );
	 }

	 public void testsearchMovie() throws SQLException {
	 String attributeName = "movieName";
	 String attributeValue= "movie1";
	 Movie[] listMovies = objService.searchMovie(attributeName,
	 attributeValue);
	
	 System.out.println("sefsd" + listMovies.length);
	 assertEquals(listMovies[0].getMovieName(),attributeValue );
	 }

	public void testreturnMovie() throws SQLException {
		int movieId = 9;
		long membershipId = 118811111; // wrong id
		int userType = 0;
		assertEquals(false,
				objService.returnMovie(movieId, membershipId, userType));
	}

	
//	 public void testrentMovie() throws SQLException {
//	 long membershipId = 111111111;
//	 Cart[] cart_details_array = new Cart[0]; //passed empty array of cart 
//	int userType= 0;
//	assertEquals(false, objService.rentMovie(cart_details_array, membershipId, userType));
//	 }

	 public void testremoveMovieFromCart() throws SQLException {
	int removeMovieFromCart = 17 ;  // change it while showing
	assertEquals(true, objService.removeMovieFromCart(removeMovieFromCart));
	 }
 
	 
	 public void testremoveMovieFromCartFail() throws SQLException {
	int cartId = 999 ;
	assertEquals(false, objService.removeMovieFromCart(cartId));
	 }
	
	 
	 
	 public void testaddToCart() throws SQLException {
	int movieId = 17 ; 
	long memberId = 111111110;
	assertEquals(true, objService.addToCart(movieId, memberId));
	 }

	 
		public static void main(String[] args) {
			junit.textui.TestRunner.run(test.class);
		}
	} 
	 
	 
//	 public void testaddToCartFail()  throws SQLException{
//	int movieId = 1110 ; 
//	long memberId = (Long) null;
//    Exception eOutOfBounds = null;
//	
//	
//    try {
//
//		objService.addToCart(movieId, memberId);
//
//    } catch (NullPointerException e) {
//        eOutOfBounds = e;
//     }
//     
//     // asset the exception object
//     Assert.assertNotNull("Login Failed", eOutOfBounds);
//   }
////	try
////	{
////		objService.addToCart(movieId, memberId);
////	    fail("Didn't throw expected exception");
////	}
////	catch(NullPointerException e)
////	{
////	    assertEquals("Expected message", e.getMessage());
////	}}
//

	 

	
	 
	 
	


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page import=  "entity.Movie"%>
<%@ page import=  "entity.*"%>
<%@ page import=  "java.util.Date"%>
<%@ page import=  "java.text.SimpleDateFormat"%>
<%@ page import=  "java.util.Calendar"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Update Details</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="templatemo_style.css" />
<link rel="stylesheet" type="text/css" href="stylesheet/styles.css" />
<!-- <link rel="stylesheet" type="text/css" href="style.css" /> -->

<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>
<script language="javascript" type="text/javascript" src="scripts/mootools-1.2.1-core.js"></script>
<script language="javascript" type="text/javascript" src="scripts/mootools-1.2-more.js"></script>
<script language="javascript" type="text/javascript" src="scripts/slideitmoo-1.1.js"></script>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="jquery.dropotron-1.0.js"></script>
<script type="text/javascript" src="jquery.slidertron-1.1.js"></script>
<script type="text/javascript" src="js.js"></script>
<script type="text/javascript">
	$(function() {
		$('#menu > ul').dropotron({
			mode: 'fade',
			globalOffsetY: 11,
			offsetY: -15
		});
		/* $('#slider').slidertron({
			viewerSelector: '.viewer',
			indicatorSelector: '.indicator span',
			reelSelector: '.reel',
			slidesSelector: '.slide',
			speed: 'fast',
			advanceDelay: 4000
		}); */
	});
</script>



<!-- <script language="javascript" type="text/javascript">
	window.addEvents({
		'domready': function(){
			/* thumbnails example , div containers */
			new SlideItMoo({
						overallContainer: 'SlideItMoo_outer',
						elementScrolled: 'SlideItMoo_inner',
						thumbsContainer: 'SlideItMoo_items',		
						itemsVisible: 5,
						elemsSlide: 3,
						duration: 200,
						itemsSelector: '.SlideItMoo_element',
						itemWidth: 140,
						showControls:1});
		},
		
	});
</script> -->
</head>


<%
	HttpSession sess = request.getSession(false);

	/* Movie[] listMovies	= (Movie[])sess.getAttribute("displayMovies");
	Person personDetails	= (Person)sess.getAttribute("personDetails");
	session.setAttribute("memberId", personDetails.getMembershipId());
	
	 */
	
	Person personDetails	= (Person)sess.getAttribute("displayaccount");
	
	session.setAttribute("memberId", personDetails.getMembershipId());
	session.setAttribute("userType", personDetails.getUserType());
	


 %>
<% 
	Calendar TimeStop = personDetails.getLastLogin();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String TimeStop_Str = sdf.format(TimeStop.getTime());
%>

<body>
<div id="templatemo_wrapper">
	<div id="templatemo_menu">
	<center>
		<ul>
			<li><span>Video Library Management System</span></li>
		</ul>
	</center>
         	
    </div> 						<!-- end of templatemo_menu -->
    
    
    
      <div id="templatemo_header_bar">
    
    	<div id="menu">
		<ul>
			<li class="first"><a href="memberhome.jsp">Home</a></li>
			<li><a href =" memberhome?formname=allMovies">View Movies</a></li>
			<li><a href =" memberhome?formname=myAccount">My Account</a></li>
			
			<li><a href =" memberhome?formname=myCart">View Cart</a></li>
			
			<li><a href="logout">Logout</a></li>
			<li class="last">Last Login <%= TimeStop_Str%></li>
		</ul>
		</div>
    
    
    
	</div>          <!-- end of templatemo_header_bar -->
     
    <div class="cleaner"></div>
    
        <div id="sidebar"><div class="sidebar_top"></div><div class="sidebar_bottom"></div>
    	
        <div class="sidebar_section">
        
            <h2>Search</h2>
            
          <!--   <form id="login" method="post" action="login" onsubmit="return validateForm(form1)">
                <label>Username</label>
                <input type="text" value="" name="username" size="10" class="input_field" title="username" />
                <label>Password</label>
                <input type="password" value="" name="password" class="input_field" title="password" />
                <a href="signup.jsp">Create Account</a> 
              <input type="submit" name="login" value="Login" alt="Login" id="" title="" />
            </form> -->
            
        <form name='searchMovie' action='searchForMember' method='post' onsubmit="return isSelect()">
		<input type='hidden' name='formname' value='searchMovie'/>		
		
		<label>Search Movie By:</label>              
	  	<select name="searchBy" id="select" class="input_field" onchange="showRate()">
	                    <option value="">Select</option>
	                    <option value="movieName">Name</option>
	                    <option value="movieBanner">Banner</option>
	                    <option value="movieRent">Rent</option>
	                    </select>
		<label>Keyword:</label>
		<input type='text' name='searchTextValue' class="input_field"/>		
		<input type='submit' value='Go'/>
		
		</form>
            
		<div class="cleaner"></div>
            
		</div>
        
        <div class="sidebar_section">
        
        	<h2>Categories</h2>
                    
            <ul class="categories_list">
            
                <li><a href="searchForMember?formname=searchMovie&searchBy=movieCategory&searchTextValue=Action">Action</a></li>
                <li><a href="searchForMember?formname=searchMovie&searchBy=movieCategory&searchTextValue=Comedy">Comedy</a></li>
                <li><a href="searchForMember?formname=searchMovie&searchBy=movieCategory&searchTextValue=Drama">Drama</a></li>
                <li><a href="searchForMember?formname=searchMovie&searchBy=movieCategory&searchTextValue=Animation">Animation</a></li>
                <li><a href="searchForMember?formname=searchMovie&searchBy=movieCategory&searchTextValue=Documentary">Documentary</a></li>
                <li><a href="searchForMember?formname=searchMovie&searchBy=movieCategory&searchTextValue=Family">Family</a></li>
                <li><a href="searchForMember?formname=searchMovie&searchBy=movieCategory&searchTextValue=Sci-Fi">Sci-Fi</a></li>
                <li><a href="searchForMember?formname=searchMovie&searchBy=movieCategory&searchTextValue=Horror">Horror</a></li>
                <li><a href="searchForMember?formname=searchMovie&searchBy=movieCategory&searchTextValue=Romance">Romance</a></li>
               
            </ul>
        </div>
        
        
    </div> <!-- end of sidebar -->
       
    <div id="templatmeo_content" >
    
           
	    	<div id="latest_product_gallery">
	    			<h2>Featured Movies</h2>
	    			<div id="SlideItMoo_outer">	
                <div id="SlideItMoo_inner">			
                    <div id="SlideItMoo_items">
                        <div class="SlideItMoo_element">
                                <a href="#">
                                <img src="images/mov1.jpg" alt="product 1" /></a>
                           
                        </div>	
                        <div class="SlideItMoo_element">
                                <a href="#">
                                <img src="images/mov2.jpg" alt="product 2" /></a>
        
                        </div>
                        <div class="SlideItMoo_element">
                                <a href="#">
                                <img src="images/mov3.jpg" alt="product 3" /></a>
        
                        </div>
                        <div class="SlideItMoo_element">
                                <a href="#">
                                <img src="images/mov4.jpg" alt="product 4" /></a>
        
                        </div>
                        <div class="SlideItMoo_element">
                                <a href="#">
                                <img src="images/mov5.jpg" alt="product 4" /></a>
        
                        </div>
                        
                    </div>			
                </div>
            </div>	<!-- end of latest_content_gallery -->
            </div>
            
    	
        <div class="content_section">
              <%!String states[]={
			"Select State",
		    "Alabama",
		    "Alaska",
		    "American Samoa",
		    "Arizona",
		    "Arkansas",
		    "California",
		    "Colorado",
		    "Connecticut",
		    "Delaware",
		    "District of Columbia",
		    "Florida",
		    "Georgia",
		    "Guam",
		    "Hawaii",
		    "Idaho",
		    "Illinois",
		    "Indiana",
		    "Iowa",
		    "Kansas",
		    "Kentucky",
		    "Louisiana",
		    "Maine",
		    "Maryland",
		    "Massachusetts",
		    "Michigan",
		    "Minnesota",
		    "Mississippi",
		    "Missouri",
		    "Montana",
		    "Nebraska",
		    "Nevada",
		    "New Hampshire",
		    "New Jersey",
		    "New Mexico",
		    "New York",
		    "North Carolina",
		    "North Dakota",
		    "Northern Marianas Islands",
		    "Ohio",
		    "Oklahoma",
		    "Oregon",
		    "Pennsylvania",
		    "Puerto Rico",
		    "Rhode Island",
		    "South Carolina",
		    "South Dakota",
		    "Tennessee",
		    "Texas",
		    "Utah",
		    "Vermont",
		    "Virginia",
		    "Virgin Islands",
		    "Washington",
		    "West Virginia",
		    "Wisconsin",
		    "Wyoming"
}; %>

				<div style="height:500px;border:1px solid #ccc;width:800px;font:16px/26px Georgia, Garamond, Serif;overflow:auto;">

				<H2 ALIGN="CENTER">Update Details</H2>

				<form name="updateDetails" method="post" action="myaccount" onsubmit="return updateDetails()">
					<input type='hidden' name='formname' value='updateDetails'>

						<table align='center' style="font-family: cursive;" border="1">

							<tr>
								<td><label class="contact"><strong>Membership
											Id:</strong></label></td>
								<td><%=personDetails.getMembershipId()%></td>
							</tr>

							<tr>
								<td><label class="contact"><strong>First
											Name:</strong></label></td>
								<td><input type="text" class="contact_input" name="fname"
									value="<%=personDetails.getFirstName()%>"  required/></td>
							</tr>

							<tr>
								<td><label class="contact"><strong>Last
											Name:</strong></label></td>
								<td><input type="text" class="contact_input" name="lname"
									value="<%=personDetails.getLastName()%>" required/></td>
							</tr>

							<tr>
								<td><label class="contact"><strong>Email:</strong></label></td>
								<td><input type="text" class="contact_input" name="email"
									value="<%=personDetails.getEmailId()%>" required/></td>
							</tr>

							<tr>
								<td><label class="contact"><strong>Password:</strong></label></td>
								<td><input type="password" class="contact_input"
									name="password" value="<%=personDetails.getPassword()%>" required /></td>
							</tr>

							<tr>
								<td><label class="contact"><strong>Confirm
											Password:</strong></label></td>
								<td><input type="password" class="contact_input"
									name="cpassword" value="<%=personDetails.getPassword()%>" required /></td>
							</tr>


							<tr>
								<td><label class="contact"><strong>Address:</strong></label></td>
								<td><textarea class="contact_textarea" name="address"> <%=personDetails.getAddress()%></textarea></td>
							</tr>

							<tr>
								<td><label class="contact"><strong>City:</strong></label></td>
								<td><input type="text" class="contact_input" name="city"
									value="<%=personDetails.getCity()%>"  required/></td>
							</tr>


					<tr><td><label class="contact"><strong>State:</strong></label></td>
	                   <td><select name="state">
	                   	<%for(int i=0;i<states.length;i++ ){ %>
	                   		<option value="<%=states[i]%>"><%=states[i]%></option>
	                   	<%} %>
	                   </select></td>
                    </tr>

<%-- 							<tr>
								<td><label class="contact"><strong>State:</strong></label></td>
								<td><input type="text" class="contact_input" name="state"
									value="<%=personDetails.getState()%>" /></td>
							</tr>
 --%>

							<tr>
								<td><label class="contact"><strong>Zipcode:</strong></label></td>
								<td><input type="text" class="contact_input" name="zipcode"
									value="<%=personDetails.getZipCode()%>" required/></td>
							</tr>

							<tr>
								<td></td>
								<td><input type="submit" name="updateDetails"
									value="Update Details" /></td>
							</tr>
						</table>
						</form>
						</div>
			</div> 
    
    </div> <!-- end of templatmeo_content -->
    
    
</div> <!-- end of templatemo_wrapper -->


<div id="templatemo_footer_wrapper">

	<div id="templatemo_footer">
    
    	<ul class="footer_menu">
            <li><a href="about.jsp">About US</a></li>
            <li><a href="contactUs.jsp">Contact Us</a></li>
            <li class="last_menu"><a href="terms.jsp">Terms</a></li>
      
        </ul>

       | Copyright © 2012 <a href="">273 Project</a> | 
       
    
    </div> <!-- end of footer -->

</div> <!-- end of footer_wrapper -->

</body>
</html>


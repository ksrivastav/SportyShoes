<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <title>Booking -> Flight Search Page</title>
    <link rel = "shortcut icon" type = "image/png" href = "img/favicon.png" >
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 <!--    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/global.css"> -->
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
        body, html {
            height: 100%;
            line-height: 1.8;
        }
        .bgimg-1 {
            background-position: center;
            background-size: cover;
            background-image: url("https://images.pexels.com/photos/1510492/pexels-photo-1510492.jpeg?cs=srgb&dl=pexels-marta-branco-1510492.jpg&fm=jpg&_gl=1*6nhdni*_ga*MTExNTg1MTEzLjE2NjYxMjE4NDg.*_ga_8JE65Q40S6*MTY2NjM4NjkzOS4yLjEuMTY2NjM4NzUyMi4wLjAuMA..");
            min-height: 100%;
        }
        .w3-bar .w3-button {
            padding: 16px;
        }

        .footer {
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            background-color: #f5f5f5;
            color: #3b3b3b;
            text-align: center;
        }
    </style>
    
    <script type="text/javascript">
$(#numOfPassengerSearch).change(function(){
	var value= $(#numOfPassengerSearch).val();
  $(#numOfPassengerFlightDetailGlobal).val(value));
});
</script>
</head>
<body>
<header class="bgimg-1 w3-display-container w3-grayscale-min" id="home">
<div class="w3-bar w3-white w3-card" id="myNavbar">
    <a href="/FlyawayWebApp/" class="w3-bar-item w3-button w3-wide"><img src="img/favicon.png" class="img-fluid" alt="image" width="18%">  FlyAway</a>
    <div class="w3-right w3-hide-small">
    </div>
</div>       
        
 <section class="container-fluid bg">
        <section class="row justify-content-center">
	         <div class="w3-display-centre w3-text-white" style="padding:28px">
	            <span class="w3-large">Booking -> Flight Search Page</span><br>	            
	        </div>	        
	    </section>
		        
	           
              <div class="row">
                <div class="col">
                    <h2 align="center" style="color:whitesmoke;"><b>Flight Details</b></h2>
                    <br>
                </div>
            </div>
            <section class="col-sm-6 col-md-3">
                <form action="/FlyawayWebApp/bookFlight" method="post" class="form-container" style="color:whitesmoke;">
	                <table border ="1">
		                <tr><th>
		                	</th>			                
			                <th>
			                	FlightNumber
			                </th>
			                <th>
			                	LocalDepartureDateTime
			                </th>
			                <th>
			                	LocalArrivalDateTime
			                </th>			                			               
			                <th>
			                	DepAirportName
			                </th>
			                <th>
			                	DepCity
			                </th>
			                <th>
			                	ArrAirportName
			                </th>
			                <th>
			                	ArrCity
			                </th>			                
		                </tr>
		                <c:forEach items="${allAvailableFlightsData}" var="flight">
		                
		    				<tr>
		    					<td><input type="checkbox" id="flightId" name="flightId" value="${flight.flightId}"></td>
		      					<td><c:out value="${flight.flightNumber}" /></td>
		      					<td><c:out value="${flight.localDepartureDateTime}" /></td>
		      					<td><c:out value="${flight.localArrivalDateTime}" /></td>		      						      				
		      					<td><c:out value="${flight.depAirportName}" /></td>
		      					<td><c:out value="${flight.depCity}" /></td>
		      					<td><c:out value="${flight.arrAirportName}" /></td>
		      					<td><c:out value="${flight.arrCity}" /></td>		      							      				
		    				</tr>
		  				</c:forEach>
	                	               	
	                </table>
	                <input type="text" name = "numOfPassengerFlightDetails" id="numOfPassengerFlightDetailGlobal" class="btn btn-success btn-block" value="${numOfPassenger} "/>         
	                <button type="submit" class="btn btn-success btn-block" value="Submit">Book Flight</button>                   
                </form>
            </section>
            
             <div class="row">
                <div class="col">
                    <h2 align="center" style="color:whitesmoke;"><b>Enter Passenger Details</b></h2>
                    <br>
                </div>
            </div>
            <section class="col-sm-6 col-md-3">
                <form action="/FlyawayWebApp/bookFlightTome" method="post" class="form-container" style="color:whitesmoke;"   modelAttribute="passenger2" >
	                <table border ="1">
		                <tr><th>
		                	</th>			                
			                <th>
			                	Salutation
			                </th>
			                <th>
			                	FirstName
			                </th>
			                <th>
			                	LastName
			                </th>			                			               
			                <th>
			                	Age
			                </th>
			                <th>
			                	Gender
			                </th>			                		                
		                </tr>
		                
		                <%Integer numPas = Integer.parseInt(request.getAttribute("numOfPassenger").toString());;
		        		for (int i=0;i< numPas ; i ++)
		        		{
		        		 %>
		                
		    				<tr>
			    				<td>
			    					<c:out value = "<%=i+1 %>"/>
			    				</td>
		    					<td>
		    						<select class="form-control" id="selectPrefix" name="prefix" >
										<option value="Mr">Mr</option>
										<option value="Miss">Miss</option>
										<option value="Mrs">Mrs</option>									
									</select>
								</td>
		      					<td>
		      						<input type="text" name = "firstName" id="inputFirstName" class="btn btn-success btn-block" placeholder="First Name"/>
								</td>
		      					<td>
		      						<input type="text" name = "lastName" id="inputLastName" class="btn btn-success btn-block" placeholder="Last Name"/>
								</td>
		      					<td>
		      						<input type="text" name = "age" id="inputAge" class="btn btn-success btn-block" placeholder="Age"/>
								</td>		      						      				
		      					<td>
		      					    <select class="form-control" id="selectGender" name="gender" >
										<option value="Male">Male</option>
										<option value="Female">Female</option>																			
									</select>
		      					</td>		      							      							      				
		    				</tr>
		  				<%} %>
	                </table>
	                        
	                <button type="submit" class="btn btn-success btn-block" value="Submit">Book Flight</button>                   
                </form>
            </section>
</section>
</header>


</body>

</html>
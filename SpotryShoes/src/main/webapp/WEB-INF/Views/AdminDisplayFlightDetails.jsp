<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <title>FlyAway Admin Add Flight</title>
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
            background-image: url("https://images.pexels.com/photos/731217/pexels-photo-731217.jpeg?cs=srgb&dl=pexels-sheila-731217.jpg&fm=jpg&_gl=1*1s1jzd8*_ga*MTExNTg1MTEzLjE2NjYxMjE4NDg.*_ga_8JE65Q40S6*MTY2NjEyMTg0OC4xLjEuMTY2NjEyMjYxNi4wLjAuMA..");
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
	            <span class="w3-large">Create New Flight</span><br>	            
	        </div>
            <div class="row">
                <div class="col">
                    <h2 align="center" style="color:whitesmoke;"><b>New Flight Details</b></h2>
                    <br>
                </div>
            </div>
            <section class="col-sm-6 col-md-3">
                <form action="/FlyawayWebApp/createFlight" method="post" class="form-container">
                <table>
                	<tr>
                	</tr>
                    <div class="form-group mx-sm-3 mb-2"  style="margin:auto;display:block">
         				<select class="form-control" id="depAirport" name="depAirport">
							<option value="">Departure Airport</option>
							<c:forEach items ="${airportList}" var = "airport">
								<option value="">${airport.airportName}</option>	
							</c:forEach>
						</select>                                                       
       				</div> 
       				 <div class="form-group mx-sm-3 mb-2"  style="margin:auto;display:block">
         				<select class="form-control" id="arrAirport" name="arrAirport">
							<option value="">Arrival Airport</option>
							<c:forEach items ="${airportList}" var = "airport">
								<option value="">${airport.airportName}</option>	
							</c:forEach>
						</select>                                                       
       				</div> 
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="depDate" class="w3-display-centre w3-text-white">Departure Date</label>
                        <input type="date" name="depDate" class="form-control" id="depDate" />                        
                    </div>
                     <div class="form-group mx-sm-3 mb-2">
                        <label for="depTime" class="w3-display-centre w3-text-white">Departure Time</label>
                        <input type="time" name="departureTime" class="form-control" id="depTime"/>                        
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="arrDate" class="w3-display-centre w3-text-white">Arrival Date</label>
                        <input type="date" name="arrDate" class="form-control" id="arrDate" />                        
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <label for="arrTime" class="w3-display-centre w3-text-white">Arrival Time</label>
                        <input type="time" name="arrTime" class="form-control" id="arrTime" />                        
                    </div>
                    <div class="form-group mx-sm-3 mb-2" style="margin:auto;display:block">
         				<select class="form-control" id="aircraft" name="aircraft">
							<option value="">Aircraft</option>
							<c:forEach items ="${aircraftList}" var = "aircraft">
								<option value="">${aircraft.aircraftType}</option>	
							</c:forEach>
						</select>                                                       
       				</div>  
                    <div>
                    	<button type="submit" class="btn btn-success btn-block" value="Submit">Register</button>
                    </div>
                </table>                        
                </form>
            </section>
        </section>
    </section>

                    
                    
     
     
</header>
</body>

</html>
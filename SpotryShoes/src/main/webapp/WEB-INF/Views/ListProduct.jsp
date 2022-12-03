<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <title>Product Page</title>
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
            background-image: url("https://images.pexels.com/photos/1124466/pexels-photo-1124466.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
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
	            <span class="w3-large">Premium Shoes Collection</span><br>	            
	        </div>	        
	    </section>
	    
	    <div class="row">
                <div class="col">
                    <h2 align="center" style="color:whitesmoke;"><b>Premium Shoes Collection</b></h2>
                    <h1 style="color:whitesmoke;"> You are viewing ${ProductList.size()}" Products</h1>
                    <br>
                </div>
            </div>
		        
	           
              <div class="row">
                <div class="col">
                    <h2 align="center" style="color:whitesmoke;"><b>You are viewing ${ProductList.size()}</b></h2>
                    <br>
                </div>
            </div>
            <section class="col-sm-6 col-md-3">
                <form action="/FlyawayWebApp/bookFlight" method="post" class="form-container" style="color:whitesmoke;">
	                <table border ="1">
		                <tr>			                
			                <th>
			                	Name
			                </th>
			                <th>
			                	Brand
			                </th>
			                <th>
			                	Price
			                </th>			                			               
			                <th>
			                	Color
			                </th>	
			                	               		                
		                </tr>
		                		                
		    				<c:forEach items ="${ProductList}" var = "product">
		    				<tr>
		    					<td><c:out value="${product.getName()}" /></td>
		      					<td><c:out value="${product.getBrand().getName()}" /></td>
		      					<td><c:out value="${product.getPrice()}" /></td>
		      					<td><c:out value="${product.getColor()}" /></td>
		    				</tr>
		  				</c:forEach>
		  				
	                	               	
	                </table>
	                                   
                </form>
            </section>
            
             <div class="row">
                <div class="col">
                    <h2 align="center" style="color:whitesmoke;"><b>Booking Account Details</b></h2>
                    <br>
                </div>
            </div>
            	<section class="col-sm-6 col-md-3">                
                <form action="/FlyawayWebApp/updateAdmin" method="post" class="form-container"  style="color:whitesmoke;" >
	                <table border ="1">
	                <tr>
			                <th>
			                	Email Address		                	
			                </th>
			                <th>
			                	FirstName
			                </th>
			                <th>
			                	LastName
			                </th>			               		                	              
		            </tr>
		                <tr>
			                    
		    					<td><c:out value="${BookingMemberAccountDetails.email}"/></td>
		      					<td><c:out value="${BookingMemberAccountDetails.firstName}" /></td>
		      					<td><c:out value="${BookingMemberAccountDetails.lastName}" /></td>		      						      				
		      			         
		                </tr>
		                
		    								
	                	               	
	                </table>                        
                </form>
                   
            
            
             <div class="row">
                <div class="col">
                    <h2 align="center" style="color:whitesmoke;"><b>Passenger Details</b></h2>
                    <br>
                </div>
            </div>
            <section class="col-sm-6 col-md-3">
                <form  method="post" class="form-container" style="color:whitesmoke;"   modelAttribute="passenger2" >
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
		                
		                <tr>
		                <c:forEach items = "${BookingPassengerList}" var="passenger">
		    					<td><c:out value="${passenger.prefix}"/></td>
		      					<td><c:out value="${passenger.firstName}" /></td>
		      					<td><c:out value="${passenger.lastName}" /></td>
		      					<td><c:out value="${passenger.age}" /></td>		      						      				
		      					<td><c:out value="${passenger.gender}" /></td>		      				
		      			</c:forEach>	      							      				
		    				</tr>
		                
		    				
		  				
	                </table>
	                        
	                <button type="submit" class="btn btn-success btn-block" value="Submit">Create Booking</button>                   
                </form>
            </section>




            
</section>
</header>


</body>

</html>
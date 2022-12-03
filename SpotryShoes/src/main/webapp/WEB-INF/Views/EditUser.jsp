<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 
 <%@page import="model.*"%> 
<%@page import="service.ProductService"%> 
<%@page import="service.ProductCategoryService"%> 
<%@page import ="java.util.ArrayList" %>
  
  <%
  
  		
  	
   %>
    
<!DOCTYPE html>
<html>
<head>

    <title>Manager User Page</title>
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
        body, html {
            height: 100%;
            line-height: 1.8;
        }
        .bgimg-1 {
            background-position: center;
            background-size: cover;
            background-image: url("");
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
    <a href="/SpotryShoes/" class="w3-bar-item w3-button w3-wide">SportyShoes</a>
    <form action="/SpotryShoes/manageProduct" method="get" class="form-container">
           <button type="submit"  class="w3-bar-item w3-button w3-wide" value="Submit">Manage Product</button>
     </form>
     <form action="/SpotryShoes/manageUsers" method="get" class="form-container">
            <button type="submit"  class="w3-bar-item w3-button w3-wide" value="Submit">Manage Users</button>
      </form>
      <form action="/SpotryShoes/PurchaseReport" method="get" class="form-container">
         <button type="submit"  class="w3-bar-item w3-button w3-wide" value="Submit">Manage Purchase Report</button>
      </form>  
      <form action="/SpotryShoes/manageAdminAccount" method="get" class="form-container">
      	<button type="submit"  class="w3-bar-item w3-button w3-wide" value="Submit">Manage Admin Account</button>
      </form>  
    <div class="w3-right w3-hide-small">
    </div>
</div>       
        
 <section class="container-fluid bg">
        <section class="row justify-content-center">
	         <div class="w3-display-centre w3-text-white" style="padding:28px">
	            <span class="w3-large">Edit User</span><br>	            
	        </div>	        
	    </section>
	    

<div class="container-fluid px-1 py-5 mx-auto">
    <div class="row d-flex justify-content-center">
        <div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
            <h3>Edit User</h3>
            <p class="blue-text"> <br> Please enter User details</p>
            <div class="card">
                <h5 class="text-center mb-4"> ${User.getUserName()}</h5>
                <form class="form-card" action="/SpotryShoes/updateUser" method="post">
                    <div class="row justify-content-between text-left">
                    	<div class="form-group col-sm-6 flex-column d-flex"></div>                    	
                     	<div class="form-group col-sm-6 flex-column d-flex"> <img class="card-img-top" width="200" height="200"  src="https://images.pexels.com/photos/1520760/pexels-photo-1520760.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"	alt="Card image cap"> </div>                     	
                    </div>
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">User Name<span class="text-danger"> *</span></label> <input type="text" id="userName" name="userName" placeholder="Enter your product name" onblur="validate(1)" value="${User.getUserName()}"> </div>
                        <div class="form-group col-sm-6 flex-column d-flex"> <input type="hidden" id="userId" name="userId" placeholder="" onblur="validate(1)" value="${User.getUserId()}"> </div>
                        <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Address<span class="text-danger"> *</span></label> <input type="text" id="userAddress" name="userAddress" placeholder="Enter Address" onblur="validate(2)" value="${User.getAddress()}"> </div>
                    </div>
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Email Address<span class="text-danger"> *</span></label> <input type="text" id="userEmail" name="userEmail" placeholder="" onblur="validate(3)" value="${User.getEmail()}"> </div>
                        <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Phone Number<span class="text-danger"> *</span></label> <input type="text" id="userPhoneNumber" name="userPhoneNumber" placeholder="" onblur="validate(4)" value="${User.getPhoneNumber()}"> </div>
                    </div>
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Password<span class="text-danger"> *</span></label> <input type="text" id="userPassword" name="userPassword" placeholder="" onblur="validate(5)" value="${User.getPassword()}"> </div>
                    </div>
                                   
                    
                    <div class="row justify-content-end">
                        <div class="form-group col-sm-6"> <button type="submit" class="btn-block btn-primary">Submit</button> </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
				
            
</section>
</header>


</body>

</html>
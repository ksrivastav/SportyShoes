<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <title>FlyAway</title>
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
	            <span class="w3-large">Update Account Details</span><br>
	            
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
			                <th>
			                	Password
			                </th>			                	              
		                </tr>
		                <tr>
			                <th>
			                	<label for="inputEmail" class="sr-only">Email address</label>
                        		<input type="email" name="email" readonly="readonly" class="form-control" id="inputEmail" aria-describedby="emailHelp" value="${currAdminAccount.email}"/>	                	
			                </th>
			                <th>
			                	<div class="form-group mx-sm-3 mb-2">
                        			<label for="inputFirstName" class="sr-only">First Name</label>
                        			<input type="text" name="firstName" class="form-control" id="inputFirstName"  value="${currAdminAccount.firstName}"/>                       
                    			</div>
			                </th>
			                <th>
			                	<div class="form-group mx-sm-3 mb-2">
                        			<label for="inputLastName" class="sr-only">Last Name</label>
                        			<input type="text" name="lastName" class="form-control" id="inputLastName" value="${currAdminAccount.lastName}"/>                       
                    			</div>
			                </th>
			                <th>
			                	<div class="nu">
                        			<label for="inputPassword" class="sr-only">Password</label>
                        			<input type="password" name="password" class="form-control" id="inputPassword" value="${currAdminAccount.password}"/>                       
                    			</div>
			                </th>
			                <th>
			                	<div>
                    				<button type="submit" class="btn btn-success btn-block" value="Submit">Update</button>
                    			</div>
			                </th>			              
		                </tr>
		                
		    				<tr>
		    					 <div class="w3-display-centre w3-text-white" >
                    				<c:if test="${not empty updateAdminError}" >
   										${updateAdminError}
									</c:if>
                    			</div>
		      					
		    				</tr>	 
		    				<tr>
		    					  <div  class="w3-display-centre w3-text-white">
                    				<c:if test="${not empty updateAdminSuccessfull}">
   										${updateAdminSuccessfull}
									</c:if>
                    			 </div>
		    				</tr> 				
	                	               	
	                </table>                        
                </form>
                   
            
        </section>
    </section>
    </section>
</header>
</body>

</html>
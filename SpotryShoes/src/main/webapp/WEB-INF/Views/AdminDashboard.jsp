<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <title>FlyAway Admin Dashboard</title>
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
            background-image: url("https://images.pexels.com/photos/1166868/pexels-photo-1166868.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
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
	         <div class="w3-display-centre w3-text-black" style="padding:28px">
	            <span class="w3-large">Admin Dashboard</span><br>	            
	        </div>
            <div class="row">
                <div class="col">
                    <h2 align="center" style="color:black;"><b>Welcome!</b></h2>
                    <br>
                </div>
            </div>
            <section class="col-sm-6 col-md-3">
                
                <table>
                	<tr>
	                	<td>
		                	
		                	<form action="/SpotryShoes/manageProduct" method="get" class="form-container">
                				<button type="submit" class="btn btn-success btn-block" value="Submit">Manage Product</button>
                			</form>
                		</td>						
						<td>
							<form action="/SpotryShoes/manageUsers" method="get" class="form-container">
                				<button type="submit" class="btn btn-success btn-block" value="Submit">Manage Users</button>
                			</form>
						</td>
						<td>
						 	<form action="/SpotryShoes/purchaseReport" method="get" class="form-container">
                				<button type="submit" class="btn btn-success btn-block" value="Submit">Purchase Report</button>
                			</form>    
						</td>
						<td>
						 	<form action="/SpotryShoes/manageAdminAccount" method="get" class="form-container">
                				<button type="submit" class="btn btn-success btn-block" value="Submit">Manage Admin Account</button>
                			</form>    
						</td>
                	</tr>
                </table> 
            </section>
        </section>
    </section>

                    
                    
     
     
</header>
</body>

</html>
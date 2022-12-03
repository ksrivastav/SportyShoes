<!DOCTYPE html>
<html>
<head>

    <title>SportyShoes</title>
    <link rel = "shortcut icon" type = "" href = "img/favicon.png" >
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/global.css">
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
<%@include file="navbar.jsp"%>
    
    
    <header class="bgimg-1 w3-display-container w3-grayscale-min" id="home">
        <br>
        <div class="w3-display-centre w3-text-black" style="padding:48px">
            <span class="w3-jumbo w3-hide-small">Funk up with SportyShoes?</span><br>
            <span class="w3-large">Trendy shoes at best prices</span>
        </div>
        <div class="w3-display-left w3-text-black" style="padding:48px">
            <p><br><br><br><br><br><br><br><br><br><br><a href="/SpotryShoes/listproduct" class="w3-button w3-black w3-padding-large w3-large w3-margin-top w3-opacity w3-hover-opacity-on"><i class="fa fa-fighter-jet"></i>View All Products</a></p>
            <p><a href="/SpotryShoes/customerlogin" class="w3-button w3-black w3-padding-large w3-large w3-margin-top w3-opacity w3-hover-opacity-on"><i class="fa fa-sign-in"></i>   Customer Login</a></p>       
            <p><a href="/SpotryShoes/adminlogin" class="w3-button w3-black w3-padding-large w3-large w3-margin-top w3-opacity w3-hover-opacity-on"><i class="fa fa-sign-in"></i>   Admin Login</a></p>            
        </div>
    </header>
    <div class="footer">
       SportyShoes by Kartikaya Srivastav
    </div>
</body>
</html>
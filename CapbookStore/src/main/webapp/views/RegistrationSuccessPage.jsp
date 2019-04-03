<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
.index1 {
	width: 1200px;
	margin: auto;
	border: 3px solid black;
	background-position: center top;
}

h1.h {
	border-bottom: 6px solid red;
	background-color: lightgrey;
	color: green;
	text: bold;
}
h1 {
    display: block;
    font-size: 2em;
    margin-block-start: 0.67em;
    margin-block-end: 0.67em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
}
.s {
	color: blue;
}

body {
	    background: linear-gradient(to top, rgba(185, 182, 218, 0), rgb(11, 113, 174));
    height: 930px;
}

.logox {
	position: static;
	/* left: auto; */
	/* top: 10%; */
	color: #fcfeff;
}
.main{
    position: absolute;
    width: 100%;
    height: 500px;
    background-repeat: no-repeat;
    background-size: cover;
    top: 70px;
    left: 0px;
    color: white;
    z-index: 20;
    font-family: verdana;
}
.box{
    margin-top: 20px;
    height: 500px;
    width: 400px;
    background: #cae0ef;
    padding-top: 40px;
    padding-left: 40px;
    padding-right: 40px;
    padding-bottom: 40px;
}
div{
display: block;
}
#i1{
text-align: center;
    color: black;
    font-family: arial;
    font-size: 20px;
}
.header{  
    position: absolute;
    width: 100%;
    height: 70px;
    background: rgba(208, 208, 208, 0.25);
    top: 0px;
    left: 0px;
    color: white;
    z-index: 7;
    font-family: verdana;
}
.headerx {
    position: absolute;
    width: 100%;
    height: 70px;
    top: 0px;
    left: 0px;
    color: white;
    z-index: 7;
    font-family: verdana;
    -webkit-box-shadow: 0 3px 8px rgba(0, 0, 0, .25);
    s: ;
}
#img-l {
    position: absolute;
    left: 14%;
    height: -webkit-fill-available;
    width: auto;
}
</style>
</head>
<body>
<div class="w3-container">
<div class="headerx"></div>
	<div align="center">
		<div class="header">
		<img id="img-l" src="https://www.capgemini.com/us-en/wp-content/themes/capgemini-komposite/assets/images/favicon.ico" alt="logo">
			<h1 class="logox">CAPBOOK</h1>
			<br>
		</div>
		<div class="main" align="center">
			<div class="box">
				<div id="i1">Welcome to CAPBOOK</div>
				<br><br>
				<div id="i1" class="s">Your Registration has been Successful</div>
				<br><br>
				<div id="i1">You can LOGIN to CapBook using your Email ID and Password</div>
				<br><br>
				<div id="i1">
					Click Here to
                    <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-blue w3-large">Login</button>
                    <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">
    
 <!--  LOGIN PAGE --> 
 
      <div class="w3-center"><br>
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-transparent w3-display-topright" title="Close Modal">×</span>
        <img src="img_avatar4.png" alt="Avatar" style="width:30%" class="w3-circle w3-margin-top">
      </div>
	<form:form class="w3-container" action="loginUser" method="post"
				modelAttribute="userAccount">
        <div class="w3-section">
          <label><b>Username</b></label>
          <form:input path="emailId" class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Email ID/Username" size="30" />
          <form:errors path="emailId" cssClass="error" />
          <label><b>Password</b></label>
          <form:input type="password" path="password" class="w3-input w3-border" placeholder="Enter Password" size="30" />
          <form:errors path="password" cssClass="error" />
          <button class="w3-button w3-block w3-blue w3-section w3-padding" type="submit">Login</button>
          <input class="w3-check w3-margin-top" type="checkbox" checked="checked"> Remember me
        </div>
      </form:form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
        <span class="w3-right w3-padding w3-hide-small">Forgot <a href="forgetPassword">password?</a></span>
      </div>

    </div>
  </div>
				</div><br>
				<div id="i1">
					Click <a href="index">Here</a> to Return to Capbook's Home Page
				</div><br>
			</div>
		</div>
	</div>
    </div>
</body>
</html>


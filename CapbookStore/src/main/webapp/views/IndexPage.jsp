
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<title>Capbook style login page</title>
<head> 
<style>
<link type="text/css" rel="stylesheet" href="style.css" /> 
body{ 
background:linear-gradient(to bottom right, white, #bcbdc4);
height:750px;
}
.headerx{
	position:absolute;
	width:100%;
	height:70px;
	top:0px;
	left:0px;
	color:white;
	z-index:7;
	font-family:verdana;
	-webkit-box-shadow: 0 3px 8px rgba(0, 0, 0, .25);
	
}
.header{
    position:absolute;
	width:100%;
	height:70px;
	background:#333333;
	top:0px;
	left:0px;
	color:white;
	z-index:7;
	font-family:verdana;
	
}
#logo{
	height:28px;
	width:120px;
	left:22%;
	top:20px;
	
}
#form1{
	left:43%;
	top:10px;
	height:25px;
	width:220px;
	
}
#form2{
	left:60%;
	top:10px;
	height:25px;
	width:200px;
}
#forget{
	color:white;
	font-size:12px;
	margin-top:5px;
}
#submit1{ left:76%; top:12px; background:gray;
 color:black;  z-index:20; 
 height:23px; width:60px; cursor:pointer; 
 }
 .main{
	position:absolute;
	width:100%;
	height:500px;
	background-image:url("linkedin-back.jpg");
    background-repeat:no-repeat;
    background-size:cover;
	top:70px;
	left:0px;
	color:white;
	z-index:20;
	font-family:verdana;
	 
 }
 .box{
	 margin-top:20px;
	 
	 height:420px;
	 width:350px;
	 background:#efefef;
	 padding-top:15px;
	 padding-left:28px;
	 padding-right:28px;
	 padding-bottom:25px;
 }
 #info1{
	 text-align:center;
	 
	 color:black;
	 
	 font-family:arial;
	 font-size:20px;
 }
 #info2{
	 text-align:center;
	 
	 color:black;
	 
	 font-family:arial;
	 font-size:16px;
 }
  #info3{
	 text-align:left;
	 
	 color:#888889;
	 
	 font-family:arial;
	 font-size:12px;
 }
 #info4{
	 text-align:center;
	 
	 color:#888889;
	 
	 font-family:arial;
	 font-size:12px;
 }
 
 .button2{ width:350px; height:35px; 
 top:625px; background:#f1c218; font-family:verdana;
 font-size:16px; font-weight:bold; color:black; border-radius:5px 5px 5px 5px;
 border-width: 1px; border-style:solid; border-color: gray;
 cursor:pointer; outline:none; }
 .sub-footer{
	position:absolute;
	width:100%;
	height:150px;
	background:#474644;
    top:500px;
	left:0px;
	color:white;
	z-index:20;
	font-family:verdana;
	 
 }
 
  .box2{
	 
	 color:white;
	 height:100px;
	 width:848px;
	 background:#474644;
	 padding-top:15px;
	 padding-left:10px;
	 padding-right:10px;
	 padding-bottom:25px;
 }
 #submit2{  background:white;
 color:black;  z-index:20; 
 height:23px; width:60px; cursor:pointer; 
 }
 .footer{
	position:absolute;
	width:100%;
	height:80px;
	background:#000;
    top:650px;
	left:0px;
	color:white;
	z-index:20;
	font-family:verdana;
	 
 }
 
  .box3{
	 
	 color:white;
	 height:50px;
	 width:1000px;
	 
	 padding-top:10px;
	 padding-left:10px;
	 padding-right:10px;
	 padding-bottom:20px;
 }
 .box3 li{
	 float:left;
	 margin-right:20px;
	 font-size:12px;
 }
</style>
</head>
<body>

<div class="headerx">
	</div>
	<div class="header">
		<div id="logo" class="header"> <img src="logo.png" /> </div>
		<div id="form1" class="header">
			<input type="mail" style="height:25px; width:200px;" name="email" placeholder="Email or phone number" />
		</div>
		<div id="form2" class="header">
			<input type="password" style="height:25px; width:200px;" name="email" placeholder="Password" /><br>
			<div id="forget">forget password?</div>
		</div>
		<div id="submit1" class="header">
		<input type="submit" id="submit1" value="Sign in" />
		</div>
	</div>
	<div class="main" align="center">
	      <form:form action="registerUser" method="post"
				modelAttribute="userAccount">
		     <div class="box">
		      <div id="info1"> Be great at what you do</div><br>
			  <div id="info2"> Get started - it's free.</div><br>
			  <div id="info3">First Name</div>
			  <input type="text" name="first-name" style="width:350px; height:30px;" /><br><br>
			  <div id="info3">Last Name</div>
			  <input type="text" name="last-name" style="width:350px; height:30px;" /><br><br>
			  <div id="info3">Email Name</div>
			  <input type="email" name="email" style="width:350px; height:30px;" /><br><br>
			  <div id="info3">Password (6 or more characters)</div>
			  <input type="password" name="password" style="width:350px; height:30px;" /><br><br>
			  <div id="info4"> By clicking Join now, you agree to LinkedIn's User <b style="color:black;">Agreement</b>, <b style="color:black">Privacy Policy</b>, and
			  <b style="color:black">Cookie Policy</b>.</div><br>
			  <input class="button2" type="button" value="Create account" />
		     </div>
	    </form:form>
		 </div>
		 
		 

	
	

</body>
</html>

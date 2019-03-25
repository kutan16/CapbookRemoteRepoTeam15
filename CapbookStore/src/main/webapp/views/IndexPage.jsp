<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<title>CapBook Store</title>
<head>
<style>
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
	-webkit-box-shadow: 0 3px 8px rgba(0, 0, 0, .25);s	
}
.header{
    position:absolute;
	width:100%;
	height:70px;
	background:#4e4848;
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
#img-l{
	position:absolute;
	left: 15%;
    top: -60%;
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
#submit1{ left:76%; top:12px; background:#c2c3d0;
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
	 height:590px;
	 width:350px;
	 background:#f3eee1;
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
	background:#4e4848;
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

	<div class="headerx"></div>
	<form:form action="loginUser" method="post" modelAttribute="userLogin">
		<div class="header">
			<img id="img-l" src="https://www.sas.com/en_id/partners/find-a-partner/alliance-partners/capgemini/_jcr_content/par/styledcontainer_d4b4/par/styledcontainer_dd96/par/image_14e4.img.png/1541437810290.png" />
			
			<div id="form1" class="header">
				<form:input path="emailId" type="email"
					style="height:25px; width:200px;" name="email"
					placeholder="Email/User Name" />
				<form:errors path="emailId" cssClass="error" />
			</div>
			<div id="form2" class="header">
				<form:input type="password" path="password"
					style="height:25px; width:200px;" name="email"
					placeholder="Password" />
				<br>
				<form:errors path="password" cssClass="error" />
				<div id="forget">forget password?</div>
			</div><br>
			<div id="submit1" class="header">
				<input type="submit" id="submit1" value="Sign in" />
			</div>
		</div>
	</form:form>
	<form:form action="registerUser" method="post"
			modelAttribute="userAccount">
	<div class="main" align="center">
		
			<div class="box">
				<div id="info1">Welcome to Capbook</div>
				<br>
				<div id="info2">Get started - it's free.</div>
				<br>
				<div id="info3">First Name</div>
				<form:input path="firstName" style="width:350px; height:30px;" />
				<br>
				<br>
				<form:errors path="firstName" cssClass="error" />
				<div id="info3">Last Name</div>
				<form:input path="lastName" style="width:350px; height:30px;" />
				<br>
				<br>
				<form:errors path="lastName" cssClass="error" />
				<div id="info3">Email Name</div>
				<form:input path="emailId" style="width:350px; height:30px;" />
				<br>
				<br>
				<form:errors path="emailId" cssClass="error" />
				<div id="info3">Password (6 or more characters)</div>
				<form:input class="password" path="password"
					style="width:350px; height:30px;" />
				<br>
				<br>
				<form:errors path="password" cssClass="error" />
				<div id="info3">Date of Birth</div>
				<form:input type ="date" path="dateOfBirth" style="width:350px; height:30px;" />
				<br>
				<br>
				<form:errors path="dateOfBirth" cssClass="error" />
				<div id="info3">Mobile Number</div>
				<form:input path="mobileNo" style="width:350px; height:30px;" />
				<br>
				<br>
				<form:errors path="mobileNo" cssClass="error" />
				<div id="info3">Gender</div>
				<form:radiobutton path="gender" value="Male" style="width:50px; height:30px;" />MALE
				<form:radiobutton path="gender" value="Female" style="width:50px; height:30px;" />FEMALE
				<form:radiobutton path="gender" value="Other" style="width:50px; height:30px;" />OTHER
				<form:errors path="gender" cssClass="error" />
				<div id="info4">
					By clicking Join now, you agree to CapBook's User <b
						style="color: black;">Agreement</b>, <b style="color: black">Privacy
						Policy</b>, and <b style="color: black">Cookie Policy</b>.
				</div>
				<br> <input class="button2" type="submit" value="Create account" />
			</div>
		

		<div class="footer" align="center">
			<div class="box3">
			</div>
		</div>
	</div>
	</form:form>
</body>
</html>
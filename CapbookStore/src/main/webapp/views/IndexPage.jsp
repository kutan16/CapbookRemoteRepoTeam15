<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<title>CapBook Store</title> 

<script language="javascript">

function chkEmpty(){
var mob = /^[7-9]{1}[0-9]{9}$/;
var email=/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/;

if (document.frmReg.firstName.value == "") {alert("Please fill the First Name");}
else if (document.frmReg.lastName.value == "") {alert("Please fill the Last Name");}
else if (document.frmReg.emailId.value == ""){alert("Please fill the Email");}
else if (email.test(document.frmReg.emailId.value) == false) { alert("Please enter valid Email Id.");}
else if (document.frmReg.dateOfBirth.value == ""){alert("Please Enter Date of Birth");}
else if (document.frmReg.mobileNo.value == "") {alert("Please fill the Contact No.");}
else if (mob.test(document.frmReg.mobileNo.value) == false) { alert("Please enter valid Contact no.");}
/* else if (document.frmReg.securityQuestion.value=="Security Question"){alert("Please select a security question")}
 */

else if (document.frmReg.gender[0].checked==false&&document.frmReg.gender[1].checked==false &&document.frmReg.gender[2].checked==false){alert("Please Select Gender");}
else {
	alert("Registeration Successful! :)");
	window.location = 'RegisterationSuccessPage.jsp';
	}
}


</script>

<head>
<style>
body{ 
background:linear-gradient(to top, rgba(185, 182, 218, 0), rgb(11, 113, 174));
height:930px;
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
	background:rgba(208, 208, 208, 0.25);
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
.logox{
position:absolute;
	left: 20%;
    top: -13%;
    color: #fcfeff;
}
#img-l{
	position: absolute;
    left: 14%;
    height: -webkit-fill-available;
    width: auto;
}
#form1{
	left:66%;
	top:13px;
	height:25px;
	width:200px;	
}
#form2{
	left:80%;
	top:13px;
	height:25px;
	width:200px;
}
#forget{
	color:white;
	font-size:12px;
	margin-top:5px;
}
#submit1{ left:94%; top:12px; background:#c2c3d0;
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
	 height:650px;
	 width:350px;
	 background:#cae0ef;
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
	 color:#000000;	 
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
	background:rgba(208, 208, 208, 0.25);
    top:800px;
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
	<form:form action="loginUser" method="post" modelAttribute="userAccount">
		<div class="header">
			<img id="img-l" src="https://www.capgemini.com/us-en/wp-content/themes/capgemini-komposite/assets/images/favicon.ico" alt="logo"/>
			<h1 class="logox">CAPBOOK</h1>
			
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
				<div id="forget"><a href="forgetPassword">Forgot Password?</a></div>
			</div><br>
			<div id="submit1" class="header">
				<input type="submit" id="submit1" value="Sign in" />
			</div>
		</div>
	</form:form>
	<form:form action="registerUser" onsubmit="return chkEmpty();" method="post"
			modelAttribute="userAccount" name="frmReg">
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
				<form:input class="password" type ="password" path="password"
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
				<div id="info3">
								<select name="securityQuestion"
									id="securityQuestion" >
									<option value="" selected disabled hidden>Security Question</option>
									<option value="What's your nick name?" >What's your nick name?</option>
									<option value="What's your favourite game?" >What's your favourite game?</option>
									<option value="What's your pet name?" >What's your pet name?</option>
									<option value="What's your favourite car?" >What's your favourite car?</option>
									<option value="What's your favourite book?" >What's your favourite book?</option>
									<option value="What's your birthplace?" >What's your Birth Place?</option>
								</select>
							</div>
							<div>
								<form:input path="securityQuestion" style="width:350px; height:30px;"
									id="securityAnswer" placeholder="Security Answer" />
							</div>
				<div id="info3">Gender</div>
				<form:radiobutton path="gender" value="Male" style="width:20px; height:15px;" /><a style="color:black">Male</a>
				<form:radiobutton path="gender" value="Female" style="width:20px; height:15px;" /><a style="color:black">Female</a>
				<form:radiobutton path="gender" value="Other" style="width:20px; height:15px;" /><a style="color:black">Others</a>
				<form:errors path="gender" cssClass="error" />
				<div id="info4">
					By clicking Join Now, you will be a member of Capgemini's web application ' CapBook '.
				</div>
				<br> <input class="button2" type="submit" name="submit"  value="Join Now" />
			</div>
		

		<div class="footer" align="center">
			<div class="box3">
			</div>
		</div>
	</div>
	</form:form>
</body>
</html>
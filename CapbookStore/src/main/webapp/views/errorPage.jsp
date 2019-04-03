<html>
<head>
</head>
<!--abcd-->

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.abc{
color: white
}
* {
  box-sizing: border-box;
}

body {
  /* Permalink - use to edit and share this gradient: http://colorzilla.com/gradient-editor/#0c1019+0,0b0b0e+100 */
  background: #2F4F4F;
  /* Old browsers */
  /* FF3.6-15 */
  /* Chrome10-25,Safari5.1-6 */
  background: radial-gradient(ellipse at center, #0c1019 0%, #0b0b0e 100%);
  /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
  filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#0c1019', endColorstr='#0b0b0e',GradientType=1 );
  /* IE6-9 fallback on horizontal gradient */
  font-family: montserrat;
  text-align: center;
  margin: 0;
  padding: 0;
  overflow: hidden;
  height: 100vh;
}
body .container_inner {
  width: 300px;
  margin: 0 auto;
}
body .container_inner__login {
  height: 100vh;
  -webkit-perspective: 800px;
          perspective: 800px;
}
body .container_inner__login .tip {
  color: #81AECE;
  opacity: 0;
  transition: all .4s;
  font-size: 10px;
  position: relative;
  font-weight: 100;
  height: 0px;
  overflow: hidden;
  top: -27px;
  line-height: 14px;
}
body .container_inner__login .tick {
  -webkit-transform: scale(0) translateY(-50%);
          transform: scale(0) translateY(-50%);
  transition: all 0.35s cubic-bezier(0.65, 1.88, 0.51, 0.69);
  position: absolute;
  left: 0;
  top: 50%;
  right: 0;
  margin: auto;
}
body .container_inner__login .tick img {
  width: 50px;
}
body .container_inner__login .hide {
  opacity: 0 !important;
}
body .container_inner__login .bulge {
  -webkit-transform: scale(1) !important;
          transform: scale(1) !important;
  top: 50px !important;
  transition: all .4s;

}
body .container_inner__login .login_check {
  font-size: 11px;
  text-align: center;
  line-height: 20px;
  color: white;
  color: #BFBFCE;
  position: absolute;
  display: none;
  left: -26px;
  top: 160px;
  height: 280px;
  width: 278px;
  margin: auto;
  right: 0;
}
body .container_inner__login .login_check img {
  opacity: 0.9;
  width: 140px;
  margin-bottom: 30px;
}
body .container_inner__login .login_check span {
  color: #FF133D;
  line-height: 20px;
}
body .container_inner__login .login {
  position: absolute;
  left: 0;
  top: 50%;
  transition: all .2s;
  width: 220px;

  margin: auto;
  -webkit-transform: scale(1) translateY(-50%) rotatex(360deg) rotatey(360deg);
          transform: scale(1) translateY(-50%) rotatex(360deg) rotatey(360deg);
  right: 0;
}
body .container_inner__login .login .center {
  top: 100px !important;
}
body .container_inner__login .login_profile {
  border-radius: 100px;
  height: 80px;
  width: 60px;
  background: white;
  margin-bottom: 40px;
  margin: 0 auto;
  position: relative;
  top: 0px;


}
body .container_inner__login .login_profile img {
  position: relative;
  top: 18px;
}
body .container_inner__login .login_profile .logo {
  z-index: 2;
}
body .container_inner__login .login_profile .pulse {
  width: 160px;
  position: relative;
  top: -85px;
  display: none;
  left: -42px;
  z-index: 1;
}
body .container_inner__login .login_desc {
  color: #BFBFCE;
  font-size: 10px;
  margin-top: 20px;

  position: relative;
  opacity: 0;
}
body .container_inner__login .login_desc h3 {
  font-weight: 500;
}
body .container_inner__login .login_desc span {
  color: #FF133D;
  font-weight: 600;
}
body .container_inner__login .login_inputs {
  margin-top: 50px;
}
body .container_inner__login .login_inputs form {
  margin: 0;
  padding: 0;
}
body .container_inner__login .login_inputs form input {
  width: 100%;
  padding: 10px;
  color: #141416;
  border: none;
  border-radius: 3px;
  text-align: center;
  position: relative;
  opacity: 0;
  font-size: 13px;
  outline: none;
}
body .container_inner__login .login_inputs form input[type="submit"] {
  margin-top: 12px;
  cursor: pointer;
  border: 1px solid #FF133D;
  text-transform: uppercase;
  letter-spacing: 1px;
  padding: 10px 10px;

  position: relative;
  opacity: 0;
  position: relative;
  font-weight: 100;
  color: white;
  font-family: montserrat;
  background: #D61134;
  box-shadow: 0px 2px #69091A, 0px 0px 3px rgba(2, 2, 2, 0.17), 0px 0px rgba(255, 255, 255, 0.13) inset;
  font-size: 11px;
  transition: all .24s;
}
body .container_inner__login .login_inputs a {
  color: #393940;
  text-decoration: none;
  font-weight: 100;
  -webkit-animation: pop .1s forwards;
          animation: pop .1s forwards;
  position: relative;
  opacity: 0;
  font-size: 11px;
  display: inline-block;
  margin-top: 20px;
  transition: all .24s;
}
body .container_inner__login .login_inputs a:hover {
  color: #FF133D;
}




@keyframes logo_in {
  0% {
    -webkit-transform: scale(0);
            transform: scale(0);
  }
  20% {
    -webkit-transform: scale(1.1);
            transform: scale(1.1);
  }
  40% {
    -webkit-transform: scale(0.98);
            transform: scale(0.98);
  }
  60% {
    -webkit-transform: scale(1.012);
            transform: scale(1.012);
  }
  80% {
    -webkit-transform: scale(0.995);
            transform: scale(0.995);
  }
  100% {
    -webkit-transform: scale(1);
            transform: scale(1);
  }
}
@-webkit-keyframes pop {
  0% {
    opacity: 0;
    top: 4px;
  }
  100% {
    opacity: 1;
    top: 0px;
  }
}

.column {
  color: white;
  opacity: 0.1;
  float: left;
  position: relative;
}

.column .row {
  height: 10px;
  margin-left: 130px;
  margin-top: 20px;
  font-size: 10px;
  position: relative;
  margin-bottom: -10px;
  opacity: 0;
}


</style>
<body>


<div class='container'>
  <div class='container_inner'>
    <div class='container_inner__login'>
      <div class='login'>
        <div class='login_profile'>
          <img class='logo' src="https://www.capgemini.com/us-en/wp-content/themes/capgemini-komposite/assets/images/favicon.ico" width=80 height=100>
          <img class='pulse' src="https://www.capgemini.com/us-en/wp-content/themes/capgemini-komposite/assets/images/favicon.ico">
        </div>
        <div class='login_desc'>
          <h3>
            <span>capBook</span>
          </h3>
        </div>
        <div class='login_inputs'>
           		<div class="abc"> ${errorMessage}</div>
                <a href="/" ><h2>Retry Login</h2></a>
		</div>
          
        </div>
      </div>
      <div class='tick'>
        <img src='"https://www.capgemini.com/us-en/wp-content/themes/capgemini-komposite/assets/images/favicon.ico"'>
      </div>
    </div>
  </div>
</div>

</body>
</html>
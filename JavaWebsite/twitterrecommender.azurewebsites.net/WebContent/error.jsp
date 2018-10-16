<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="bootstrap/Content/bootstrap.css" rel="stylesheet"
	type="text/css" />
<script type=”text/javascript”
	src=”bootstrap/Scripts/modernizr-2.6.2.js”></script>
<script type=”text/css” src=”bootstrap/Content/Site.css”></script>
<title>Movie Recommender</title>
<style>
 .loader {
  border: 5px solid #f3f3f3; 
   border-radius: 50%; 
   border-top: 5px solid #3498db; 
   border-bottom: 5px solid #3498db; 
   width: 50px; 
   height: 50px; 
   -webkit-animation: spin 2s linear infinite; 
   animation: spin 2s linear infinite; 
   position: relative; 
   left:630px; 
   bottom:50px; 
 } 

@-webkit-keyframes spin { 
   0% { -webkit-transform: rotate(0deg); } 
   100% { -webkit-transform: rotate(360deg); } 
 }

 @keyframes spin { 
  0% { transform: rotate(0deg); } 
  100% { transform: rotate(360deg); } 
 } 
</style>

</head>
<body>
	<div id="wrap">
		<div class="container">
			<div style="background: transparent" class="jumbotron">
				<h1 align="center" style="color: whitesmoke">MOVIES LIST</h1>
				<h2 align="center" style="color: whitesmoke">PERSONALISED FOR
					YOU!</h2>

				<p style="color: #808080; margin: 45px;" class="text-center">
					This is a free movie matching system. Using IBM AI for analysing
					your personality from your tweets and movie reviews from regular
					people just like you.<br />This makes a recipe for a good match!
				</p>
				<hr />
				<h2 style="color: whitesmoke; margin: 45px"
					class="row col-md8 col-md-push2 text-center">Enter your
					twitter handle to get your list</h2>

				<form action="MvcResult" method="GET" class="form-inline">
					<!-- <p align="center" class="row col-md-12">  -->

					<div class="text-center">
					<p><font color="red">Please check your Twitter username !</font></p>
						<span class="h3" style="color: whitesmoke">@</span> <input
							type="text" name="twitterUsername" id="twitterUser"
							placeholder="your twitter username..." value=""
							autocomplete="off" class="paragraph-form-control"
							onchange="handleChange(this)" required /> <input type="submit"
							name="answer" value="Submit" onclick="showDiv()" id="myButton1"
							class="btn btn-lg btn-primary" />
					</div>

				</form>



				<div class="loader" id="loader" style="display: none;"></div>

			</div>

		</div>
	</div>
	<script>				
					function showDiv() {
						var elem = document.getElementById("myButton1");
					 if((document.getElementById("twitterUser").value === "") && ($('[required]').val() != '')){
						     return false;
						}
						else{
						document.getElementById('loader').style.display = "block";
						 elem.style.visibility = "hidden";
						 }
					}
				</script>
	<script type="text/javascript">
					var elem = document.getElementById("myButton1");
					window.onload = function(){
					elem.value = "Submit";
};
					</script>
</body>
</html>
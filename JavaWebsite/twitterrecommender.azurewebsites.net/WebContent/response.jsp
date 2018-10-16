<%@page
	import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
	<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-3d.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
	
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
 h2 {
    text-align: center;
    color:#1E90FF;
    font-family: "Times New Roman";
    font-weight: bold;
}
</style>
</head>
<body>

	<div id="wrap">
		<div class="container">
			<div style="background: transparent" class="jumbotron">
				<h1 align="center" style="color: whitesmoke">MOVIES LIST</h1>
				<h2 align="center" style="color: whitesmoke">PERSONALISED FOR
					YOU !</h2>

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
						<span class="h3" style="color: whitesmoke">@</span> <input
							type="text" name="twitterUsername" id="twitterUser"
							placeholder="your twitter username..." value=""
							autocomplete="off" class="paragraph-form-control"
							onchange="handleChange(this)" required />
						<!-- 			<input onclick="return change()" type="submit"	value="Submit" id="myButton1" class="btn btn-lg btn-primary" /> -->
						<input type="submit" name="answer" value="Submit"
							onclick="showDiv()" id="myButton1" class="btn btn-lg btn-primary" />
					
					
					</div>

				</form>
				<div>
				</div>
								
				<div class="loader" id="loader" style="display: none;"></div>
				

			

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


			</div>
		</div>
	</div>
	
	<div class="container">

		<div class="row">
			<div class="well">
			<h2>
			  <%= session.getAttribute("twitterUsername") %>
			</h2>
			<br>			
				<div class="list-group">

					<c:forEach var="movie" items="${movie_list}">

						<a target="_blank"
							href="http://www.imdb.com/title/${movie.movieId}"
							class="list-group-item">

							<div class="media col-md-3">
								<figure class="pull-left"> <img
									class="media-object img-rounded img-responsive"
									src=${movie.posterLink } alt="placehold.it/180x270"
									style="width: 110px; height: 160px;" /> </figure>
							</div>
							<div class="col-md-6">
								<h4 class="list-group-item-heading">${movie.title}
									(${movie.year})</h4>
								|
								<c:forEach var="genre" items="${movie.genres}">
									
									${genre.name}	 
								
									</c:forEach>
								| <br>
								<br>
								<p class="list-group-item-text">${movie.summary}</p>

							</div>
							<div class="col-md-3 text-center">

								<div class="stars">
									<big>${movie.score}</big>/10 <span
										class="glyphicon glyphicon-star"></span>

								</div>

							</div>

						</a>

					</c:forEach>
				</div>
				<div id="container" style="height: 400px"></div>
			</div>
		</div>
	</div>

		
<script type="text/javascript">
Highcharts.chart('container', {
    chart: {
        type: 'pie',
        options3d: {
            enabled: true,
            alpha: 45
        }
    },
    title: {
        text: 'Ibm Watson Personality Insights'
    },
    subtitle: {
        text: 'Big 5 Personality Traits'
    },
    plotOptions: {
        pie: {
            innerSize: 100,
            depth: 45
        }
    },
    series: [{
        name: 'Value',
        data: [
            ['Conscientiousness', ${userInsights.conscientiousness}],
            ['Openness', ${userInsights.openness}],
            ['',],
            ['Agreeableness', ${userInsights.agreeableness}],
            ['',],
            ['Adventurousness', ${userInsights.adventurousness}],
            ['Artistic Interest', ${userInsights.artisticInterests}],
            ['Emotionality', ${userInsights.emotionality}],
            ['Intellect', ${userInsights.intellect}],
            ['',],
            ['',],
            ['',],
            ['',],
            ['',],
            ['SelfDiscipline', ${userInsights.selfDiscipline}],
            ['Self Efficacy', ${userInsights.selfEfficacy}],            
            ['Activity-Level', ${userInsights.activityLevel}],
            ['',],
            ['',],
            ['',],
            ['',],
            ['',],
            ['Altruism', ${userInsights.altruism}],
            ['Cooperation', ${userInsights.cooperation}],
            ['Modesty', ${userInsights.modesty}],
            ['Morality', ${userInsights.morality}],
            ['Sympathy', ${userInsights.sympathy}],
            ['Trust', ${userInsights.trust}],
            ['Anger', ${userInsights.anger}],
            ['',],
            ['Depression', ${userInsights.depression}],
            ['',],
            ['',],
            ['Vulnerability', ${userInsights.vulnerability}],
            ['Challenge', ${userInsights.challenge}],
            ['',],
            ['Curiosity', ${userInsights.curiosity}],
            ['',],
            ['',],
            ['',],
            ['',],
            ['Love', ${userInsights.love}],
            ['Practicality', ${userInsights.practicality}],
            ['Self Expression', ${userInsights.selfExpression}],
            ['',],
            ['',],
            ['Conservation', ${userInsights.conservation}]
        ]
    }]
});
</script>

</body>
</html>
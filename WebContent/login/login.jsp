<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>

    <head>
		<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0">       
        <link rel="stylesheet" type="text/css" href="<%=path %>/login/css/style.css" />	
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	
		<style>
			@import url(http://fonts.googleapis.com/css?family=Ubuntu:400,700);
			body {
				background: #563c55 url(<%=path %>/login/images/blurred.jpg) no-repeat center top;
				-webkit-background-size: cover;
				-moz-background-size: cover;
				background-size: cover;
			}
			.container > header h1,
			.container > header h2 {
				color: #fff;
				text-shadow: 0 1px 1px rgba(0,0,0,0.7);
			}
		</style>
		<title>로그인</title>
    </head>
    <body>
        <div class="container">			
			<section class="main">
				<div class="form-3">
				    <p class="clearfix">
				        <label for="login">ID</label>
				        <input type="text" name="login" id="login_email" placeholder="Username">
				    </p>
				    <p class="clearfix">
				        <label for="password">Password</label>
				        <input type="password" name="password" id="login_pw" placeholder="Password"> 
				    </p>
				    <p class="clearfix">
				        <input type="checkbox" name="remember" id="remember">
				        <label for="remember">Remember me</label>
				    </p>
				    <p class="clearfix">
				        <button onclick="sendData('<%=path%>')">로그인</button>
<!-- 				        <button onclick="alert('adsa')">로그인</button> -->
				    </p>       
				</div>
			</section>
		
        </div>
     	   <script>			   
				function sendData(path) {					
					var email = $('#login_email').val();		
					var pw = $('#login_pw').val();		
				
					console.log(pw);
						
					var postUrl = path + "/login_proc.devil"
					$.post(postUrl, //form 의 action 역할
					{ // request.getParameter로 받는 것 , input의 name
						
						email : email,
						pw : pw

					},

					function(data, status) {
						var site="";
						console.log("status : " + status);
						console.log("data : " + data);
						if (status.trim() == "success" && data.trim() == "YES") {
							console.log("로그인 성공");
							location.href="<%=path %>/main.devil";
						} else {
							console.log("로그인 실패");
							alert("아이디 패스워드를 확인하세요.")
						}
						
						//alert("Data: " + data + "\nStatus: " + status);
					});}</script>
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>LOGIN</title>
<link rel="stylesheet"
	href="https://bootswatch.com/superhero/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
<link href='https://fonts.googleapis.com/css?family=Lato:300'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<%
		String message = (String) request.getAttribute("message");
	%>
	<div class="container register-wrap">
		<div class="outer-wrap">
			<div class="inner-wrap">
				<h2 class="register-head">REGISTER</h2>
				<form action="./register.do" method="get">
					<div class="form-wrap">
						<div class="form-group">
							<input class="form-control input-lg" type="text" name="firstName"
								placeholder="First Name">
						</div>
						<div class="form-group">
							<input class="form-control input-lg" type="text" name="lastName"
								placeholder="Last Name">
						</div>
						<div class="form-group">
							<input class="form-control input-lg" type="text" name="username"
								placeholder="Username">
						</div>
						<div class="form-group">
							<input class="form-control input-lg" type="password"
								name="password" placeholder="Password">
						</div>
						<button class="btn btn-default btn-lg submit-button" type="submit">REGISTER</button>
					</div>
				</form>
				<div class="failed">
					<%=message == null ? "" : message%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<style>
html, body {
	background: rgba(0, 0, 0, 0.8);
	height: 100vh;
	width: 100vw;
	color: #fff;
	font-family: 'Verdana', sans-serif;
}

.register-wrap {
	display: table;
	text-align: center;
	vertical-align: middle;
	height: 100vh;
	width: 100vw;
}

.register-wrap .outer-wrap {
	background: rgba(0, 0, 0, 0.8);
	display: table;
	text-align: center;
	vertical-align: middle;
	height: 100vh;
	width: 100%;
}

.register-wrap .outer-wrap .inner-wrap {
	display: table-cell;
	vertical-align: middle;
	text-align: center;
	height: 100%;
	width: 100%;
}

.form-wrap {
	margin: 0 auto;
	max-width: 360px;
}

.form-wrap .submit-button {
	width: 100%;
}

.register-wrap .outer-wrap .inner-wrap .register-head {
	padding-bottom: 40px;
	letter-spacing: 0.5em;
}
</style>
</html>
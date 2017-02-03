<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SEARCH</title>
<link rel="stylesheet"
	href="https://bootswatch.com/superhero/bootstrap.min.css">
<link rel="stylesheet" href="style.css">
<link href='https://fonts.googleapis.com/css?family=Lato:300'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<%
		String message = (String) request.getAttribute("message");
		String username = (String) request.getAttribute("username");
	%>

	<div class="container search-wrap">
		<div class="outer-wrap">
			<div class="inner-wrap">
				<h2 class="search-head">SEARCH</h2>
				<form action="./searchresults.do" method="get">
					<div class="form-wrap">
						<div class="form-group">
							<input class="form-control input-lg" type="text" name="title"
								placeholder="By Title">
						</div>
						<p>OR</p>
						<div class="form-group">
							<input class="form-control input-lg" type="text" name="author"
								placeholder="By Author">
						</div>
						<p>OR</p>
						<div class="form-group">
							<input class="form-control input-lg" type="text" name="isbn"
								placeholder="By ISBN">
						</div>
						<input type="hidden" name="username" value="<%=username%>">
						<button class="btn btn-default btn-lg submit-button" type="submit">SEARCH</button>
						<a href="./logout.do" class="exit-btn exit-btn-2">LOG OUT</a>
					</div>
				</form>
				<div class="account">
					<a href="./account.do?username=<%=username%>"><h6>MY
							ACCOUNT</h6></a>
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

.search-wrap {
	display: table;
	text-align: center;
	vertical-align: middle;
	height: 100vh;
	width: 100vw;
}

.search-wrap .outer-wrap {
	background: rgba(0, 0, 0, 0.8);
	display: table;
	text-align: center;
	vertical-align: middle;
	height: 100vh;
	width: 100%;
}

.search-wrap .outer-wrap .inner-wrap {
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

.search-wrap .outer-wrap .inner-wrap .search-head {
	padding-bottom: 40px;
	letter-spacing: 0.5em;
}

.exit-btn:after {
	content: '';
	position: absolute;
	z-index: -1;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
}

.exit-btn {
	border: none;
	font-family: 'Verdana', sans-serif;
	font-size: inherit;
	color: white;
	background: none;
	cursor: pointer;
	padding: 10px 10px;
	display: inline-block;
	margin: 15px 15px;
	text-transform: uppercase;
	letter-spacing: 1px;
	font-weight: 700;
	outline: none;
	position: relative;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
}

.exit-btn-2 {
	padding: 25px 60px 25px 120px;
	border-radius: 5px;
}

.exit-btn-2 {
	background-color: black;
	color: #fff;
}

.exit-btn-2:before {
	position: absolute;
	height: 100%;
	left: 0;
	top: 0;
	line-height: 3;
	font-size: 140%;
	width: 60px;
}

.exit-btn-2:before {
	border-right: 2px solid rgba(255, 255, 255, 0.5);
	content: "\e017";
	font-family: 'Glyphicons Halflings';
}
</style>
</html>
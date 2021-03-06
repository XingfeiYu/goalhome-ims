<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Listing</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/justified-nav.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
		<div class="masthead">
			<h3 class="text-muted">Yeah house</h3>
			<nav>
				<ul class="nav nav-justified">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Projects</a></li>
					<li><a href="#">Services</a></li>
					<li><a href="#">Downloads</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</nav>
		</div>
		<!-- <!-- Jumbotron 
		<div class="jumbotron">
			<h1>Marketing stuff!</h1>
			<p class="lead">Cras justo odio, dapibus ac facilisis in, egestas
				eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris
				condimentum nibh, ut fermentum massa justo sit amet.</p>
			<p>
				<a class="btn btn-lg btn-success" href="#" role="button">Get
					started today</a>
			</p>
		</div> -->

		<!-- Example row of columns -->
		<div class="row">
			<div class="col-lg-2">
				<h2>filter!</h2>
				<p class="text-danger">
					<select class="form-control" name="agent_id" id="unit"><option
							value="">所有房源</option>
						<option value="100">我的房源</option></select>
				</p>
				<p>
					<select class="form-control" name="unit_type" id="unit_type"><option
							value="">所有</option>
						<option value="1">整套</option>
						<option value="0">合租</option></select>
				</p>
				<p>
					<label>金额:</label>
				<p>
					<input class="form-control input-sm col-lg-1" type="text"
						placeholder="From" style="width: 40%" id="from_amt"><input
						class="form-control input-sm col-lg-1" type="text"
						placeholder="To" style="width: 40%" id="to_amt">
				</p>
				<p>

					<a class="btn btn-primary" href="#" role="button"
						onclick="filterSearch();">Apply &raquo;</a>
				</p>
			</div>
			<div class="col-lg-6">
				<h2>房源信息</h2>
				<div class="row">
					<div class="col-lg-3">
						<img src="<%=request.getContextPath()%>/img/house-default.jpeg"
							alt="..." class="img-thumbnail">
					</div>
					<div class="col-lg-8" id="address">四川省成都市人民大道100号</div>
					<div class="col-lg-8">
						<div id="price">-1550元/月</div>
						<div id="status">-待租</div>
						<a class="btn btn-primary" href="#" role="button"
							onclick="unitDeail(houseid)">详细信息 &raquo;</a>
					</div>
				</div>
				<p></p>
			</div>
			<div class="col-lg-3">
				<h2>Heading</h2>
				<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
					egestas eget quam. Vestibulum id ligula porta felis euismod semper.
					Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
					nibh, ut fermentum massa.</p>
				<p>
					<a class="btn btn-primary" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
		</div>

		<!-- Site footer -->
		<footer class="footer">
			<p>&copy; Company 2015</p>
		</footer>

	</div>
	<!-- /container -->

	<script src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/yeah.js"></script>
</body>
</html>
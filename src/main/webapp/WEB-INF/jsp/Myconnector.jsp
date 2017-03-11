<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"> </link>

	<title>首页</title>
	<style>
		<!--
		.coon_nav{width: 100%; position: fixed;z-index: 999;top:0;left: 0;right: 0;height: 69px;background-color: #fff;border-bottom: 1px solid #ccc;}

		.coon_nav_cont{width: 80%;right: 0px; left: 0px;top:0;position: inherit;margin: 0 auto;}
		.coon_table{width: 100%;float: left;margin-top: 90px}

		.coon_nav_logo{width: 100%;float: left;position: relative;z-index: 1000;}

		.coon_nav_logo>a>img{margin-top: 0px; margin-left: 0px;padding-top: 8px; padding-bottom: 8px;}

		.coon_nav_menu{width: 100%;text-align: right;position: absolute;z-index: 1001;display: block}

		.coon_nav_menu>ul{margin-bottom: 0px;}

		.coon_nav_menu ul>li{display: inline}

		.coon_nav_menu>ul>li{height: 69px;line-height: 69px;}

		.coon_nav_menu a{ color: #111; font-size: 1.25em; padding: 21px 25px; text-decoration: none;}

		.coon_nav_menu>ul>li>a:hover{color: #42AF41;border-bottom: 3px solid #42AF41;}

		.active>a{color: #42AF41;border-bottom: 3px solid #42AF41;}



		@media (max-width: 980px) {

			.coon_nav_cont{ width: 95%; }

		}

		@media (max-width: 768px) {

			.coon_nav_cont{ width: 100%;}

			.coon_nav_menu a{ font-size: 1em; padding: 21px 15px;}

		}



		@media (max-width: 550px) {

			.coon_nav{height: 55px;}

			.coon_nav_cont{  width: 100%;  }

			.coon_nav_logo>a>img{height: 55px; margin-left: 45px;padding-top: 4px; padding-bottom: 4px;}

			.coon_nav_menu ul{padding-left: 0px;}

			.coon_nav_menu a{ font-size: 1em; padding: 21px 15px;}

			.coon_nav_menu{width: 50%;text-align:center; right:0;top:55px;border: 1px solid #ccc;display: none}

			.coon_nav_menu ul>li{display: list-item;list-style: none;border-bottom: 1px solid #ccc;}

			.coon_nav_menu>ul>li{background:rgba(1,1,1,0.75);height: 45px;line-height: 45px;}

			.coon_nav_menu a{ width:100%;color: #fff; font-size: 1.25em; padding-top: 8px;padding-bottom: 8px; text-decoration: none;}

			.coon_nav_menu>ul>li>a:hover{color: #42AF41;border-bottom: 0px solid #42AF41;width: 100%;}

			.active>a{color: #42AF41;border-bottom: 0px solid #42AF41;}

		--></style>
</head>
<body  ms-controller="viewmodel">
<div class="coon_nav">
	<div class="coon_nav_cont">
		<div class="coon_nav_logo">
			<a href="#"><img src="img/logo.png"/></a>
		</div>
		<div class="coon_nav_menu">
			<ul>
				<li class="active"><button type="button" class="btn btn-primary" style="margin: 10px;" ms-click="@request">查看联系人</button></li>
				<li><button type="button" class="btn btn-primary" style="margin: 10px;" >添加联系人</button></li>
				<li><button type="button" class="btn btn-primary" style="margin: 10px;" >修改联系人</button></li>
				<li><a href="Login.html">退出</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="coon_table">
	<table class="table table-striped"><thead><tr>

		<td class="success">姓名</td>
		<td class="warning">电话</td>
		<td class="danger">email</td>
		<td class="danger">微信号</td>
		<td class="info">地址</td>
		<td class="info">操作</td>
	</tr>
	</thead>
		<tbody>
		<tr ms-for="el in @datalist">
			<td >{{el.contacts}}</td>
			<td >{{el.phone}}</td>
			<td>{{el.mail}}</td>
			<td >{{el.weixinnumber}}</td>
			<td >{{el.adress}}</td>
			<td ></td>
		</tr>
		</tbody>
	</table>

</div>


<script src="js/bootstrap.min.js"></script>
<script src="js/UsedByMain.js"></script>


</body>
</html>

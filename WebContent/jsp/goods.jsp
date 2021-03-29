<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<title>index</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="bootstrap/jquery-3.0.0.min.js"></script>
<script scr="bootstrap/js/bootstrap/min.js"></script>
<style rel="stylesheet">
#d1 {
	background-image: url(images/bg1.jpg)
}
</style>
</head>
<body>
	<div class="row" id=d1>
		<div class="container-fluid">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">${username}</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="${pageContext.request.contextPath}/Default">金融电子商城 </a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/custom/MyCart">申请购入产品</a></li>
					<li class="nav-item"><a class="nav-link" href="UserCenter">申请保险理赔</a></li>

					<c:if test="${custom==null}">
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/Login">请登录</a></li>
					</c:if>
					<c:if test="${custom!=null}">
						
					
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> ${custom.username} </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="#">Action</a> <a
									class="dropdown-item" href="#">Another action</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#">Something else here</a>
							</div></li>
					</c:if>

				</ul>
				<form class="form-inline my-2 my-lg-0" method="post" action="#">
					<input class="form-control mr-sm-2" type="search"
						placeholder="请输入名称" aria-label="Search" name="key">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>

		</nav>


	<div class="container-fluid">
		<div class="row" id=d1>


			<div class="col-9">
				<div class="card-group">

					<c:forEach items="${goodsList}" var="goods">
						<div class="col-sm-4"
							style="margin-bottom: 10px; padding-left: 0px">
							<div class="card">
								<img class="card-img-top"
									src="${pageContext.request.contextPath}/goodsimg/${goods.itemimg}"
									width="120" alt="Card image cap">
								<div class="card-body">
									<p style="margin-bottom: 2px">
										<a href="${pageContext.request.contextPath}/GoodsDetails?goodsId=${goods.id}">${goods.itemname}</a>
									</p>
									<p style="color:red;margin-bottom:2px">寝室号：${goods.price}</p>
									<p style="margin-bottom: 2px">宿管人员：${goods.shopname}</p>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>

			<%@include file="right.jsp"%>
		</div>
	</div>
</body>
</html>
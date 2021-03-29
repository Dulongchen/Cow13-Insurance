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

		<div class="row">
			<div class="col">
				<div class="row">
					<div class="col-sm-6">
						<div class="card">
							<img class="card-img-top"
								src="${pageContext.request.contextPath}/goodsimg/${goods.itemimg}"
								alt="Card image cap">
						</div>
					</div>
					<div class="col-sm-6">
						<h3 style="margin-bottom: 2px">
							<a href="#">${goods.itemname}</a>
						</h3>
						<form method="post" action="${pageContext.request.contextPath}/custom/AddItemCart">
							<p style="font-size: 1.2em; margin-top: 12px">产品编号：${goods.price}</p>
							
							<div class="form-group row">
								<label for="inputPassword3" class="col-sm-3 col-form-label"
									style="font-size: 1.2em">份数</label>
								<div class="col-sm-4">
									<input type="hidden" name="goodsId" value="${goods.id}">
									<input type="number" name="num" class="form-control" value="1"
										step="1" min="1" required>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-9">
									<button type="submit" class="btn btn-primary">添加到申请名单</button>
								</div>
							</div>

						</form>
					</div>
					<div class="col-sm-12" style="margin-top: 20px">
						<ul class="nav nav-tabs" id="myTab" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								id="home-tab" data-toggle="tab" href="#home" role="tab"
								aria-controls="home" aria-selected="true">类型</a></li>
							<li class="nav-item"><a class="nav-link" id="profile-tab"
								data-toggle="tab" href="#profile" role="tab"
								aria-controls="profile" aria-selected="false">期限</a></li>
							<li class="nav-item"><a class="nav-link" id="contact-tab"
								data-toggle="tab" href="#contact" role="tab"
								aria-controls="contact" aria-selected="false">简介</a></li>
						</ul>
						<div class="tab-content" id="myTabContent">
							<div class="tab-pane fade show active" id="home" role="tabpanel"
								aria-labelledby="home-tab">${goods.details}</div>
							<div class="tab-pane fade" id="profile" role="tabpanel"
								aria-labelledby="profile-tab">...</div>
							<div class="tab-pane fade" id="contact" role="tabpanel"
								aria-labelledby="contact-tab">...</div>
						</div>

					</div>
				</div>
			</div>

			<%@include file="right.jsp"%>
		</div>
	</div>
	</div>
</body>
</html>
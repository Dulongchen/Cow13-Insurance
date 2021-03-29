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
						href="${pageContext.request.contextPath}/Default">网上商城 </a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/custom/MyCart">我的购物车</a></li>
					<li class="nav-item"><a class="nav-link" href="UserCenter">我的订单</a></li>

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
						placeholder="请输入商品" aria-label="Search" name="key">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>

		</nav>

		<div class="row" id=d1>

			<div class="col-9">
				<div class="card">
					<form method="post"
						action="${pageContext.request.contextPath}/custom/OrderAction">
						<div class="card-header">订单确认</div>
						<div class="card-body">
							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">订单号</label>
								<div class="col-sm-9">
									<input type="text" readonly class="from-control-plaintext"
										value="${temp_order.id}" disabled>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">总金额</label>
								<div class="col-sm-9">
										<input type="text" readonly class="from-control-plaintext"
										value="${temp_order.calcTotal()}" disabled>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">发货地址</label>
								<div class="col-sm-9">
									<input type="text" name="address" class="form-control"
										id="inputEmail3" placeholder="请输入发货地址" required>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">联系人</label>
								<div class="col-sm-9">
									<input type="text" name="contacts" class="form-control"
										id="inputEmail3" placeholder="请输入联系人" required>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">联系电话</label>
								<div class="col-sm-9">
									<input type="text" name="phone" class="form-control"
										id="inputEmail3" placeholder="请输入联系电话" required>
								</div>
							</div>



						</div>
						<div class="card-footer">
							<button type="submit" class="btn btn-primary mb-2 float-right">确认订单</div>
					</form>
				</div>

				<table class="table">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">名称</th>
							<th scope="col">价格</th>
							<th scope="col">数量</th>
							<th scope="col">金额</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${temp_order.orderItems}" var="item">
							<tr>

								<td><img
									src="${pageContext.request.contextPath}/goodsimg/${item.itemimg}"
									width=120></td>
								<td>${item.itemname}</td>
								<td>${item.price}</td>
								<td>${item.num}</td>
								<td>${item.price}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>


		</div>
</body>
</html>

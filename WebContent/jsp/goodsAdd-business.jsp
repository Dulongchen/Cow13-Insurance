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
						href="${pageContext.request.contextPath}/Default">宿舍管理系统 </a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/custom/MyCart">申请离校</a></li>
					<li class="nav-item"><a class="nav-link" href="UserCenter">申请入校住宿</a></li>

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

			<%@include file="left-business.jsp"%>
			<div class="col-sm">
				<div class="card">
					<div class="class-header">添加住宿人员</div>
					<div class="card-body">
						<form method="post" enctype="multipart/form-data action="pageContext.request.contextPath}/business/GoodsAddAction">
							<p style="color: red">${info}</p>


							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">学生姓名</label>
								<div class="col-sm-9">
									<input type="text" name="goodsname" class="form-control"
										id="inputEmail3" placeholder="请输入学生姓名" required>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPassword3" class="col-sm-2 col-form-label">登记寝室号</label>
								<div class="col-sm-9">
									<input type="number" name="price" class="form-control"
										placeholder="0.01" step="0.01" min="0.01" required>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">个人信息</label>
								<div class="col-sm-9">
									<textarea class="form-control" id="exampleFormControlTextarea1"
										name="details" rows="3"></textarea>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputEmail3" class="col-sm-2 col-form-label">学生照片</label>
								<div class="col-sm-9">
									<input type="file" name="goodsimg" class="form-control-file"
										id="goodsimg" accept=".jpg">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-9">
									<button type="sumbit" class="btn btn-primary">添加住宿人员</button>

								</div>
							</div>
						</form>
					</div>
				</div>


			</div>
</body>
</html>
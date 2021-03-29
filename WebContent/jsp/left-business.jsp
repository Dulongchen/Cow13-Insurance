<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="col-3">

	<div class="card">
		<div class="card-header bg-transparent">${business.shopname}</div>
		<div class="card-body">
			<p class="card-body">
				<img src="../img/business1.jpg" style="width: 100%">
			</p>
			<p class="card-text">性别：男</p>
			<p class="card-text">负责人ID：${business.loginname}</p>
			<p class="card-text">工作履历：...</p>


		</div>



	</div>



	<div class="list-group" style="margin-top: 15px">
		<a href="${pageContext.request.contextPath}/business/GoodsManager"
			class="list-group-item list-group-item-action">回到首页</a> <a
			href="${pageContext.request.contextPath}/business/GoodsAdd"
			class="list-group-item list-group-item-action">登记个人信息</a> <a
			href="reg02.jsp" class="list-group-item list-group-item-action">修改保险状态</a>
		<a href="VerfImg" class="list-group-item list-group-item-action">修改受保人状态</a>

	</div>



</div>





<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<h1>Request示例</h1>
<hr>
<form style="margin-bottom: 200px;">
	<div class="card" style="width: 25rem" method="post"
		enctype="multipart/form-data">
		<div class="card-body">
			用户名：<input type="text" name="username" required maxLength="10"
				minLength="6" title="请填写六位到十位"> <br> 密码：<input
				type="text" name="password" required pattern="[0-9]{6}"
				title="请填写六位数字"> <br> 性别：<input type="radio" value="男"
				name="sex" checked> 男 <input type="radio" value="女"
				name="sex" checked> 女 <br /> 特长： <input type="checkbox"
				value="c++" name="spec">c++ <input type="checkbox"
				value="java" name="spec">java <input type="checkbox"
				value="javascript" name="spec">javascript <input
				type="checkbox" value="nodejs" name="spec">nodejs <br>
			所属学院： <select name="major">
				<option value="电子商务">电子商务</option>
				<option value="计算机" selected>计算机</option>
				<option value="信息管理与信息系统" selected>信息管理与信息系统</option>
			</select> <br />本人照片：<input type="file" name="photo" required> <br />
			<input type="submit" value="注册" />
		</div>
	</div>
</form>
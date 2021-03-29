<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="container">
	<div class="row">
		<div class="col">
			<img src="qrimg/${img_filename}" width="300" height="300">

		</div>
		<div class="col">
			<form action="QrAction" method="post" style="margin-bottom: 290px;">
				<p>
					<textarea rows="5" cols="60" name="input_text">请输入需要生成的二维码文本：</textarea>
				</p>
				<p>
					请选择生成图片的大小： <select name="px">
						<option value="100">100</option>
						<option value="200">200</option>
						<option value="300">300</option>
					</select>
				</p>
				<p>
					请选择生成的容错率： <input type="radio" value="1" name="e">高 <input
						type="radio" value="2" name="e">中 <input type="radio"
						value="3" name="e">低
				</p>
				<p>
					<input type="submit" value="生成二维码图片">
				</p>
			</form>
		</div>
	</div>
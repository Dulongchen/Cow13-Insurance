<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="col-3">
	<div class="card-body" style="margin-bottom: 10px">
		<div class="card-header">
			按类型查询
			</h5>
			<p class="card-body">
			<form action="RegActionDb" method="post">
				<div class="form-group row">
					<div class="col-sm-9">
						<select class="form-control" id="major" name="major">
							<option value="医疗险">医疗险</option>
							<option value="寿险" selected>寿险</option>
							<option value="意外险" selected>意外险</option>
							<option value="财产保险" selected>财产保险</option>
						</select>
					</div>
				</div>

				<div class="form-group row"></div>
				<label class="col-sm-2 col-form-label"></label>
				<div class="col-sm-9">
					<button type="submit" class="btn btn-primary">查询用户</button>
				</div>
		</div>

	

			<div class="card-body">
				<h5 class="card-title">Card title</h5>
				<p class="card-text">Some quick example text to build on the
					card title and make up the bulk of the card's content.</p>
				<a href="#" class="btn btn-primary">Go somewhere</a>
			</div>
			</form>
		</div>
	</div>
</div>

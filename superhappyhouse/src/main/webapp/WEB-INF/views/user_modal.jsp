<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- login Modal -->
	<div class="modal" id="loginModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">로그인</h4>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="${root}/user/login" method="post" enctype="multipart/form-data"> 
					<!-- <form id="loginForm"> -->
						<div class="form-group">
							<label for="id">ID:</label> <input type="text"
								class="form-control" placeholder="Enter id" name="id" />
						</div>
						<div class="form-group pt-2">
							<label for="pw">Password:</label> <input type="password"
								class="form-control" placeholder="Enter password" name="pw" />
						</div>
						<div class="form-group form-check">
							<label class="form-check-label pt-2"> <input class="form-check-input" type="checkbox" /> Remember me
							</label>
						</div>
						<button type="submit" class="btn btn-primary" id="submitLogin">로그인</button>
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<a href="#" class="btn btn-outline-danger ">비밀번호 찾기</a>
				</div>
			</div>
		</div>
	</div>
	<!-- login Modal end -->
	
	<!-- regist Modal -->
	<div class="modal" id="registModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">회원가입</h4>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="${root}/user/regist" method="post"> 
					<!-- <form id="loginForm"> -->
						<div class="form-group">
							<label for="id">ID:</label> <input type="text"
								class="form-control" placeholder="Enter id" name="id" required="required"/>
						</div>
						<div class="form-group pt-2">
							<label for="pw">Password:</label> <input type="password"
								class="form-control" placeholder="Enter password" name="pw" required="required"/>
						</div>
						<div class="form-group pt-2">
							<label for="pw">Name:</label> <input type="text"
								class="form-control" placeholder="Enter name" name="name" required="required"/>
						</div>
						<div class="form-group pt-2">
							<label for="pw">Email:</label> <input type="text"
								class="form-control" placeholder="Enter email" name="email" required="required"/>
						</div>
						<div class="form-group pt-2">
							<label for="pw">Phone:</label> <input type="text"
								class="form-control" placeholder="Enter phone number" name="phone" required="required"/>
						</div>
						<div class="form-group pt-2">
							<label for="pw">Address:</label> <input type="text"
								class="form-control" placeholder="Enter address" name="address" />
						</div>
						<button type="submit" class="btn btn-primary" id="submitLogin">회원가입</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- regist Modal end -->
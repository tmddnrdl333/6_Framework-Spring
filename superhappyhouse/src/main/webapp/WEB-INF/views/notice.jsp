<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Framework Project</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="img/favicon.ico">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/apt.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

	<!-- 앞부분 include -->
	<div class="container">

		<section id="index_section">
			<div class="card col-sm-12 mt-1" style="min-height: 850px;">
				<div class="card-body">
					<div class="form-group form-inline justify-content-center">
						<form class="navbar-search text-center"
						action="${root}/notice" method="post">
	  						작성자 : <input type="text" class="search-query w-25" id="userName"/>
	  						제목 : <input type="text" class="search-query w-25" id="subject"/>
	  						<input type="submit" class="btn btn-info btn-sm" value="검색"/>
						</form>
						<!-- <button type="button" id="aptSearchBtn">검색</button> -->
					</div>
					<table class="table mt-2">
						<colgroup>
							<col width="100">
							<col width="*">
							<col width="100">
							<col width="120">
							<col width="*">
						</colgroup>
						<thead>
							<tr>
								<th class="text-center">글 번호</th>
								<th class="text-center">제목</th>
								<th class="text-center">작성자</th>
								<th class="text-center">작성일</th>
							</tr>
						</thead>
						<tbody id="searchResult">
							<script type="text/javascript">
								console.log(${list});
							</script> 
							<c:forEach var="item" items="\${list}">
								<tr>
									<td>${item.noticeNo}</td>
									<td>${item.subject}</td>
									<td>${item.userName}</td>
									<td>${item.reg}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div id="map" style="width: 100%; height: 500px;"></div>
					
				</div>
			</div>
		</section>
	</div>


</body>
</html>
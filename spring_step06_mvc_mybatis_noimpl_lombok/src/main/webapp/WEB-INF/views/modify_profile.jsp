<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${root}/css/table1.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>	
	<h1>프로필 수정</h1>
	<form method="post" enctype="multipart/form-data" action="${root}/user/modify_profile.do">
		profile : <input type="file" name="profile" />
		<input type="submit" value="수정" />
		<input type="reset" value="취소" />
	</form>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>	
	<h1>실행 시 문제가 발생했습니다. - ${errorMsg}</h1>
	<a href="${root}/">메인으로</a>
</body>
</html>
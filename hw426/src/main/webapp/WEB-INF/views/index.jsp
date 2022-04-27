<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Index</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>	
		
	<img src="${root}/img/ssafy_logo.png" width="100px" height="70px"/>
	<h1>도서 관리</h1>

<p>HI HI</p>

<ul>
	<li><a href="${root}/book/list.do">도서 목록</a></li>
	<li><a href="${root}/book/regist_form.do">도서 등록</a></li>
</ul>
</body>
</html>


<!--
- 전역 예외를 처리할 수 있도록 ExceptionController를 호출하도록 한다.
- 사용자의 request를 처리할 수 있도록 BookController를 생성한다.
-->
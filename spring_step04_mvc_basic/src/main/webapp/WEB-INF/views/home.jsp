<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=utf-8" %>
<html>
<head>
	<title>Home</title>
	<meta charset="utf-8"></meta>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${requestScope.serverTime}. </P>
</body>
</html>

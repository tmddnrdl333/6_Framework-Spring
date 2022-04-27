<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookRegist</title>
<link href="${root}/css/table.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>

	<h1>도서 등록</h1>
	<form action="${root}/book/regist.do" method="post">
		<table>
			<tbody>
				<tr>
					<th>도서 번호</th>
					<th><input type="text" name="isbn" required="required" /></th>
				</tr>
				<tr>
					<th>제목</th>
					<th><input type="text" name="title" required="required" /></th>
				</tr>
				<tr>
					<th>저자</th>
					<th><input type="text" name="author" required="required" /></th>
				</tr>
				<tr>
					<th>가격</th>
					<th><input type="text" name="price" required="required" /></th>
				</tr>
				<tr>
					<th>설명</th>
					<th><input type="text" name="desc" required="required" /></th>
				</tr>
				<tr>
					<th>사진</th>
					<th><input type="text" name="img" required="required" /></th>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록"/>
						<input type="reset" value="취소"/>
					</td>
				</tr>
			</tfoot>
		</table>


	</form>

</body>
</html>
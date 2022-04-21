<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookDetail</title>
<link href="${root}/css/table.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>

	<h1>도서 정보</h1>
	<form action="${root}/book/modify.do" method="post">
		<table>
			<tbody>
				<tr>
					<th>도서 번호</th>
					<th><input type="text" name="isbn" value="${book.isbn}" readonly="readonly"/></th>
				</tr>
				<tr>
					<th>제목</th>
					<th><input type="text" name="title" value="${book.title}" required="required" /></th>
				</tr>
				<tr>
					<th>저자</th>
					<th><input type="text" name="author" value="${book.author}" required="required" /></th>
				</tr>
				<tr>
					<th>가격</th>
					<th><input type="text" name="price" value="${book.price}" required="required" /></th>
				</tr>
				<tr>
					<th>설명</th>
					<th><input type="text" name="desc" value="${book.desc}" required="required" /></th>
				</tr>
				<tr>
					<th>사진</th>
					<th><input type="text" name="img" value="${book.img}" required="required" /></th>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정"/>
						<input type="reset" value="취소"/>
						<input type="submit" value="삭제" formaction="${root}/book/remove.do"/>
					</td>
				</tr>
			</tfoot>
		</table>


	</form>

</body>
</html>
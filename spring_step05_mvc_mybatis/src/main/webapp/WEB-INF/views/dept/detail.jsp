<%@page import="com.ssafy.myapp.model.dto.Dept"%>
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
	<h2>부서 상세 조회</h2>
	<form method="post" action="${root}/dept/auth/modify.do">
		<table>
			<tbody>
				<tr>
					<th>부서 번호</th>
					<td><input type="text"  name="deptNo" required="required" 
						readonly="readonly" value="${dept.deptNo}" /></td>
				</tr>
				<tr>
					<th>부서 이름</th>
					<td><input type="text"  name="dName" placeholder="부서이름을 입력하세요" 
					required="required" value="${requestScope.dept.dName }"/></td>
				</tr>
				<tr>
					<th>부서 지역</th>
					<td><input type="text"  name="loc" placeholder="지역을 입력하세요" 
					value="${dept.loc}"  /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="submit"  value="수정"/>
						<input type="submit"  value="삭제" formaction="${root}/dept/auth/remove.do"/>
						<input type="reset"  value="취소"/>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>
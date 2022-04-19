<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<c:if test="${empty userinfo}">
	<script type="text/javascript">
		alert("로그인 후 이용 가능한 페이지입니다.");
		location.href = "${root}/user/login";
	</script>
</c:if>
<c:if test="${!empty userinfo}">

    <script type="text/javascript">
        $(document).ready(function () {
            $("#registerBtn").click(function () {
                if (!$("#subject").val()) {
                    alert("제목 입력!!!!");
                    return;
                } else if (!$("#content").val()) {
                    alert("내용 입력!!!!");
                    return;
                } else {
                    $("#writeform").attr("action", "${root}/guestbook/register").submit();
                }
            });
        });
    </script>

    <div class="container text-center mt-3">
        <div class="col-lg-8 mx-auto">
        	<%@ include file="/WEB-INF/views/include/confirm.jsp" %>
            <h2 class="p-3 mb-3 shadow bg-light"><mark class="sky">글쓰기</mark></h2>
            <form id="writeform" class="text-left mb-3" method="post" action="">
                <!-- <div class="form-group">
                    <label for="userid">작성자ID:</label>
                    <input type="text" class="form-control" id="userid" name="userid" placeholder="작성자ID...">
                </div> -->
                <div class="form-group">
                    <label for="subject">제목:</label>
                    <input type="text" class="form-control" id="subject" name="subject" placeholder="제목...">
                </div>
                <div class="form-group">
                    <label for="content">내용:</label>
                    <textarea class="form-control" rows="15" id="content" name="content"></textarea>
                </div>
                <div class="text-center">
                    <button type="button" id="registerBtn" class="btn btn-outline-primary">글작성</button>
                    <button type="reset" class="btn btn-outline-danger">초기화</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
</c:if>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
      <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
	</head>
	<body>
		<form name="frmLogin" method="post" action="longinOK.jsp">
			아이디 : <input type="text" id="user_id" name="user_id"><br>
			비밀번호 : <input type="password" name="user_pw"><br>
			<input type="submit" value="로그인"> <input type="reset" value="취소">
		</form>
		<br><br>
		<a href="/JSP01/jstl/memberForm.jsp">회원등록하기</a>
		<!-- context path 동적설정(EL) -->
		<a href="${pageContext.request.contextPath }/jstl/memberForm.jsp">회원등록하기</a>
		<!-- context path 동적설정(변수사용) -->
		<a href="${contextPath }/jstl/memberForm.jsp">회원등록하기</a>
	</body>
</html>
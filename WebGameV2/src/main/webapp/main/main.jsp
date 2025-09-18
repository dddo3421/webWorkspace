<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/loginOK.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>💜 게임 메인 💜</title>
</head>
<body>
	<h1>💜 게임에 오신 것을 환영합니다 💜</h1>
	<hr>

	<br>
	<br>
	<!-- 메뉴로 이동(로그인 필요) -->
	<a href="<%=request.getContextPath()%>/menu.jsp">게임 메뉴로 이동</a>
	<br>
	<br>

	<!-- 애플리케이션 정보 -->
	<a href="<%=request.getContextPath()%>/appInfo.jsp">애플리케이션 정보</a>

</body>
</html>

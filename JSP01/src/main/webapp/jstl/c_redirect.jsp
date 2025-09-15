<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
<meta charset=”UTF-8">
<title>리다이렉트 페이지</title>
</head>
<body>
<%-- 쿼리 스트링 방식(?=&)으로 요청시 파라미터 전달 --%>
	<c:redirect url="/jstl/urlTestRes.jsp">
		<c:param name="id" value="hong" />
		<c:param name="pwd" value="1234" />
		<c:param name="name" value="홍길동" />
		<c:param name="email" value="hong@test.com" />
	</c:redirect>
</body>
</html>

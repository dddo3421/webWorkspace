<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:url 태그 사용</title>
</head>
<body>
	<img src="/image/apple.png"><!-- 현재 페이지 위치에 따라 경로 결정 : 잘못된 경로 -->
	<img src="../image/apple.png"><!-- 현재 페이지 위치에 따라 상대적인 경로 설정 : 현재 위치로는 올바른 경로, 현제 페이지 소스가 이동되면 경로가 달라질 수 있음 -->
	<img src="${pageContext.request.contextPath }/image/apple.png">
	<img src="<c:url value='/image/apple.png'/>">
	<%--value의 경로는 context path 뒤부터 url을 만든다 
		script/css 자원의 url 경로 생성 시 많이 사용하는 태그
	--%>
	
</body>
</html>
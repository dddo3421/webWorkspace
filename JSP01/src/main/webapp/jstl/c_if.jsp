<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
<!-- 변수 선언 -->
<c:set var="id" value="hong" scope="page" />
<c:set var="pwd" value="1234" scope="page" />
<c:set var="name" value="${'홍길동'}" scope="page"/>
<c:set var="age" value="${20}" scope="page"/>
<c:set var="height" value="${170}" scope="page" />
<c:set var="height1" value="180" scope="page" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL - c:if</title>
		<%-- <c:if test="조건식" var="변수명" [scope] />
			if 블럭 필요 : 여는태그 닫는태그
		 --%>
	</head>
	<body>
		<c:if test="${true }">
			<h3>항상 참 입니다</h3>
		</c:if>
		
		<c:if test="${height > 160}">
			<h3>${name }키는 160보다 큽니다</h3>
		</c:if>
		
		<c:if test="${height1 > 160}">
			<h3>160보다 큽니다</h3>
		</c:if>
		
		<c:if test="${id == 'hong' && pwd=='1234'}">
			<h3>로그인 성공</h3>
		</c:if>
		
		<c:if test="${id != 'hong' || pwd=='1234'}">
			<h3>로그인 실패</h3>
		</c:if>
		
	</body>
</html>








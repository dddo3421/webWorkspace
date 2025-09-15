<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 변수 선언 -->
<c:set var="id" value="hong" scope="page" />
<c:set var="pwd" value="1234" scope="page" />
<c:set var="name" value="${'홍길동'}" scope="page" />
<c:set var="age" value="${20}" scope="page" />
<c:set var="height" value="" scope="page" />
<c:set var="height1" value="180" scope="page" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - c:choose</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="7%">이름</td>
			<td width="7%">나이</td>
			<td width="7%">키</td>
		</tr>
		<c:choose>
			<c:when test="${name == null }"><%--null : 변수없음 --%>
				<tr align="center">
					<td colspan="5">이름이 없습니다</td>
				</tr>
			</c:when>
			<c:when test="${empty age}"><%--empty : 변수없음 --%>
				<tr align="center">
					<td colspan="5">나이가 없습니다</td>
				</tr>
			</c:when>
			<c:when test="${height==''}"><%--'' : 값없음, 변수는 있음 --%>
				<tr align="center">
					<td colspan="5">키가 없습니다</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr align="center">
					<td>${id}</td>
					<td>${pwd}</td>
					<td>${name}</td>
					<td>${age}</td>
					<td>${height}</td>
				</tr>
			</c:otherwise>
		</c:choose>



	</table>
</body>
</html>






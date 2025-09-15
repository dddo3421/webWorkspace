<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="id" value="hong" scope="page"/>  <!-- 이 page에만 영향을 미침  -->
<c:set var="pwd" value="1234" scope="page"/>
<c:set var="name" value="${'홍길동'}" scope="page"/>
<c:set var="age" value="${20}" scope="page"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:set 사용 예제</title>
</head>
<body>
	${id }<Br>
	${pwd }<Br>
	${name }<Br>
	${age }<Br>
</body>
</html>
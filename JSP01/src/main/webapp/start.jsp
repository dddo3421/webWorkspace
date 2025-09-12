<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	JSP확장자를 갖는 파일이 요청에 응답했음<br>
	<%
		//자바코드 공간입니다
		//자바 문법에 맞춰 코드 생성해야 합니다
		//주석도 자바 주석을 사용합니다
		out.println("JSP를 시작합니다"); //클라이언트 응답
		
	%>
	<br>
	<%= new java.util.Date() %>
</body>
</html>
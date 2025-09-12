<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
	int width, height;
	%>
	<%
	width = Integer.parseInt(request.getParameter("width"));
	height = Integer.parseInt(request.getParameter("height"));
	 // 클라이언트에서 전달된 파라미터("width", "height")를 문자열에서 정수로 변환하여 변수에 저장 
	%>
		
		
		사각형 넓이 : <%= width*height %>
	</body>
</html>
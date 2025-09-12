<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 로그인 페이지로 이동하는 a 태그 location을 여러 방법으로 설정 -->
<a href = "http://localhost:8080/JSP01/el/login.jsp">로그인1</a><br>
<a href = "/JSP01/el/login.jsp">로그인2</a><br><!-- 현재 페이지를 요청할 때 서버의 주소는 브라우저에 저장됨 -->
<a href = "<%=request.getContextPath() %>/el/login.jsp">로그인3</a><br><!-- 현재 페이지 요청 시 사용했던 context path와 동일한 path 사용 -->
<a href = "${pageContext.request.contextPath }/el/login.jsp">로그인4</a><br>

</body>
</html>
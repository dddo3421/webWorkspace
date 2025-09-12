<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>include 지시어 : bottom</title>
	</head>
	<body>
		<font color="blue" size="3pt">
			<h3>bottom.jsp 입니다</h3>
		    작성자 <b> <%=name %> </b> 입니다
		    <!-- name은 현재 페이지에서 선언되지 않은 변수이므로 오류 발생 -->
		    <!-- 다른 페이지에 포함 시 그 페이지에 name 변수가 선언되어 있으면 오류 없음-->
		</font>
	</body>
</html>
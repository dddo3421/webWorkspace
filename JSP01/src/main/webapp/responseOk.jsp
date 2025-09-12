<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- request 객체에 저장되어 전달되는 answer 값에 따라 
			두 페이지 중 하나로 포워딩(redirect)
			응답에 대한 표현은 없이 처리만하는 페이지들에서 html코드 필요 없음
			불필요한 html 태그가 있으면 서블릿 변환될 때 out.print문에 의해 출력되게 됨
		 -->
		 <%!String answer; %>
		 
		 <%
		 	request.setCharacterEncoding("utf-8");
		 	answer = request.getParameter("answer");
		 	
		 	if(answer.equals("서울")){
		 		response.sendRedirect("pass.jsp");
		 	}else{
		 		response.sendRedirect("fail.jsp"); //클라이언트로 응답->클라이언트가 fail.jsp요청
		 	}
		 %>
	</body>
</html>
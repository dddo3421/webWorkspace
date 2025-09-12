<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>forward 액션 태그</title>
	</head>
	<body>
		<%-- user_id 파라미터값을 전달했으면 login 진행, 아니면 로그인페이지로 전환 --%>
		<%
			request.setCharacterEncoding("utf-8");
			String user_id = request.getParameter("user_id");
			
			if(user_id.length() == 0){
				// 로그인페이지로 페이지 전환 - jsp 액션태그
				// 서블릿의 dispatch와 같은 포워딩 - 클라이언트 입장에서는 loginforwardresult.jsp 요청되어 있고 포워딩되어도 클라이언트에서 표시되지 않음
				%>
				
				<jsp:forward page="login_forward.jsp"/>
				
		<% 
			}
		%>
		
		<h3>환영합니다 <%=user_id %> 님</h3>
	</body>
</html>
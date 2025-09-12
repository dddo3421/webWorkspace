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
		<%! String msg = "아이디를 입력하지 않았습니다. 아이디를 입력하세요"; %>
		<%
			request.setCharacterEncoding("utf-8");
			String user_id = request.getParameter("user_id");
			
			if(user_id.length() == 0){
				// jsp액션태그 param 사용해서 포워딩되는 페이지로 msg 전달 - param 태그는 파라미터를 어느페이지로 전달할 것인지 설정되어있어야 함
				//name="" value=""
				//forward/include 액션태그를 이용해서 파라미터를 전달
				%>
				<jsp:forward page="login_param.jsp">
					<jsp:param value="<%=msg %>" name="msg"/>
				
				
				</jsp:forward>				
		<% 
			}
		%>
		
		<h3>환영합니다  님</h3>
	</body>
</html>
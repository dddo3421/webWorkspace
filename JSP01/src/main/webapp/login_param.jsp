<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>forward 액션 태그</title>
	</head>
	<body>
		<%	//로그인 진행(submit)시 아이디가 입력되지 않았으면 로그인 페이지로 제어 넘어올 때 파라미터 msg 전달
			//param 액션태그를 통해서 파라미터가 구성됨
			String msg = request.getParameter("msg");
		if(msg != null){
		%>
					<h3><%=msg %></h3>
		<%
		}
		%>
		
		<form name="frmLogin" method="post" action="loginParamResult.jsp">
			아이디 : <input type="text" id="user_id" name="user_id"><br>
			비밀번호 : <input type="password" name="user_pw"><br>
			<input type="submit" value="로그인"> <input type="reset" value="취소">
		</form>
	</body>
</html>
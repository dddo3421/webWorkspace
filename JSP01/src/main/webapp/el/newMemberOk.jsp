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
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String name = request.getParameter("name");

// 입력값이 하나라도 비어있으면 회원가입 폼으로 포워딩
if(id.length() == 0 || pwd.length() == 0 || name.length() == 0) {
%>
    <jsp:forward page="memberForm.jsp"/>
<%
}
%>
		
<jsp:useBean id="member" class="sec01.MemberBean" scope="page">
	<jsp:setProperty property="*" name="member" />
</jsp:useBean>
	
	<h3>회원가입 출력</h3>
	
	아이디 : <%=member.getId() %><br>
	비밀번호 : <%=member.getPwd() %><br>
	이름 : <%=member.getName() %><br>
	이메일 : <%=member.getEmail() %><br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    if(session == null || session.getAttribute("loginMember") == null) {
        response.sendRedirect(request.getContextPath() + "/loginForm.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>게임 메뉴</title>
</head>
<body>
<h1>💜 게임 메뉴 💜</h1>
<hr>
<h2>게임 목록</h2>
<a href="<%= request.getContextPath() %>/gameview/gababo.jsp">가위바위보</a><br>
<a href="<%= request.getContextPath() %>/gameview/guess.jsp">숫자 맞추기</a><br><br>
<a href="<%= request.getContextPath() %>/main/main.jsp">메인으로</a>
</body>
</html>

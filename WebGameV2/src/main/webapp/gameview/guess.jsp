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
<head><title>숫자 맞추기 게임</title></head>
<body>
<h1>숫자 맞추기 게임 (1~10)</h1>

<form method="post" action="<%=request.getContextPath()%>/guess/play">
    <input type="number" name="guess" min="1" max="10" required>
    <button type="submit">제출</button>
</form>

<%
    String result = (String) request.getAttribute("result");
    if (result != null) {
%>
<h2>결과: <%= result %></h2>
<% } %>

<br><br>
<a href="<%= request.getContextPath() %>/menu.jsp">게임 메뉴로</a><br>
<a href="<%= request.getContextPath() %>/main/main.jsp">메인으로</a>
</body>
</html>

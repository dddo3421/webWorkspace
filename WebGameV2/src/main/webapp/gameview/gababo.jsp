<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head><title>가위바위보 게임</title></head>
<body>
<h1>가위바위보 게임</h1>

<form method="post" action="<%=request.getContextPath()%>/gababo">
    <button type="submit" name="choice" value="가위">가위</button>
    <button type="submit" name="choice" value="바위">바위</button>
    <button type="submit" name="choice" value="보">보</button>
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

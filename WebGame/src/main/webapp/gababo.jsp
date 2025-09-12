<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>가위바위보 게임</title></head>
<body>
<h1>가위바위보 게임</h1>

<form method="post" action="<%=request.getContextPath()%>/gababo/play">
    <button type="submit" name="choice" value="가위">가위</button>
    <button type="submit" name="choice" value="바위">바위</button>
    <button type="submit" name="choice" value="보">보</button>
</form>
<br><br>
<%-- 결과 출력 --%>
<%
    String result = (String) request.getAttribute("result");
    if (result != null) {
%>
    <h2>결과: ${result }</h2>
<% } %>
<br><br>
<a href="<%= request.getContextPath() %>/menu.jsp">메뉴로 돌아가기</a>
</body>
</html>

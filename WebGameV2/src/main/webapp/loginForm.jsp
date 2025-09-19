<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<h1>로그인</h1>

<c:if test="${not empty msg}">
    <script>
        alert("${msg}");
    </script>
</c:if>

<form method="post" action="<%=request.getContextPath()%>/user?action=login">
    <table cellpadding="5" cellspacing="0">
        <tr>
            <td>아이디</td>
            <td><input type="text" name="id" required></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="pwd" required></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit">로그인</button>
            </td>
        </tr>
    </table>
</form>

<br>
<a href="<%=request.getContextPath()%>/main/main.jsp">메인으로</a>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.MemberVO"%>
<%
    MemberVO member = (MemberVO) session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html>
<head>
<title>회원정보 수정</title>
<script>
function togglePassword() {
    const pwdInput = document.getElementById('pwd');
    pwdInput.type = pwdInput.type === 'password' ? 'text' : 'password';
}
</script>
</head>
<body>
<h1>회원정보 수정</h1>

<form method="post" action="<%=request.getContextPath()%>/user?action=mod">
    <table cellpadding="5" cellspacing="0">
        <tr>
            <td>아이디</td>
            <td><%=member.getId()%></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td>
                <input type="password" id="pwd" name="pwd" value="<%=member.getPwd()%>" required>
                <button type="button" onclick="togglePassword()">o</button>
            </td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" value="<%=member.getName()%>" required></td>
        </tr>
        <tr>
            <td>이메일</td>
            <td><input type="email" name="email" value="<%=member.getEmail()%>"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit">수정</button>
            </td>
        </tr>
    </table>
</form>

<br>
<a href="<%=request.getContextPath()%>/main/main.jsp">메인으로</a>
</body>
</html>

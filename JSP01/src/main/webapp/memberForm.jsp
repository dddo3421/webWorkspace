<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
    <h3>회원 가입창</h3>
    <form name="frmMember" method="post" action="newMemberOk.jsp">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="pwd"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="가입하기">
                    <input type="reset" value="다시입력">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>

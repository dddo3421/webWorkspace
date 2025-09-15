<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,sec01.MemberVO"
    isELIgnored="false"
    %>
<!-- import 구문으로 자바 클래스 사용 isELIgnored="false" 는 true로 되어있으면 el표현어는 text로 인식 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ArrayList 사용</title>
<%
	request.setCharacterEncoding("UTF-8");
	
%>
</head>
<body>
<jsp:useBean id="mB" class="sec01.MemberVO"/>
<jsp:useBean id="membersList" class="java.util.ArrayList"/>

<%
	MemberVO m1 = new MemberVO("son", "1234", "손흥민", "son@test.com");
	MemberVO m2 = new MemberVO("son2", "1234", "손흥민", "son@test.com");
	membersList.add(m1);
	membersList.add(m2);
	request.setAttribute("memList", membersList);
%>
	<jsp:forward page="elArr-forward-result.jsp"/>
</body>
</html>
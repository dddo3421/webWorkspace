<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>request 회원가입 요청 처리</title>
	</head>
	<%! 
		//변수 선언
		String name, id ,pwd, h1, h2, h3, year, department;
		String interests[]; //체크박스 값 받을 배열
	%>
	<%
		request.setCharacterEncoding("utf-8");
	
		name=request.getParameter("name");
		id=request.getParameter("id");
	    pwd = request.getParameter("pw");
	    h1 = request.getParameter("hp1");
	    h2 = request.getParameter("hp2");
	    h3 = request.getParameter("hp3");
	    h3 = request.getParameter("hp3");
	    year = request.getParameter("grade");
	   	department = request.getParameter("department");
	   
	    
	    interests = request.getParameterValues("interests");
	    
	%>
	<body>
 	 
	 	 이름 : <%=name %><br>
	 	 아이디 : <%=id %><br>
	 	 비밀번호 : <%=pwd %><br>
	 	 전화번호 : <%=h1%>-<%=h2 %>-<%=h3 %><br>
	 	 학년 : <%=year %><br>
	 	 관심있는 분야 : 
	 	 <%
	 	 for(int i=0;i<interests.length;i++){%>
	 	 <!-- 스크립트 태그는 다른 태그가 필요하거나 html 태그가 필요하면 일단 닫고 다시 열 수 잇음 -->
	 		<%= interests[i]+","%> 		
	 	 <%}
	 	 %><br>
	 	 학과 : <%=department %>
	 	 
	</body>
</html>
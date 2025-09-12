<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	int x = 10 ; //전역변수 x
	float f = 3.14f; //전역변수 f
	public int plus(int x){ // method는 선언부에서 선언해야 함
		return x+10;
	}	
%>

<%
	//스크립트릿에서는 메소드 선언이 불가능함 - method 정의는 선언부에서 정의해야 함
		//public int minus(int x){
		//return 0;
//}
%>

<%=x %><br>
f 변수의 값 : <%=f %><br>
plus 메소드 호출 : <%=plus(x) %> <%--jsp 선언문에서 정의한 메소드 호출 후 결과가 출력 : jsp주석 사용 --%>
<!-- jsp 파일에서 html 태그 사용 : html 주석 사용(클라이언트에게 전달) -->

</body>
</html>
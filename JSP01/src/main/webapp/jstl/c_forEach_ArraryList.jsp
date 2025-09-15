<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,sec01.MemberVO"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
MemberVO m1 = new MemberVO("son", "1234", "손흥민", "son@test.com");
MemberVO m2 = new MemberVO("son2", "1234", "손흥민", "son@test.com");
MemberVO m3 = new MemberVO("son3", "1234", "손흥민", "son@test.com");

ArrayList<MemberVO> memList = new ArrayList<MemberVO>();
memList.add(m1);
memList.add(m2);
memList.add(m3);

request.setAttribute("memList", memList); //데이터 바인딩
%>

<%--request, response 객체 포워딩 페이지로 전달 제어가 넘어감 --%>
<jsp:forward page="c_forEach_ArrayList_result.jsp"/>

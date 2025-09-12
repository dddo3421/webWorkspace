<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>  <%--자바 코드에서 사용할 클래스 import는 @page에서 진행 --%>
 <%
 	  Date date = new Date(); //java.util 패키지에 있는 클래스 : 객체 인스턴스 생성
 %>

		<font color="blue" size="3pt">
			<h3>top.jsp 입니다</h3>
			<%= date.toLocaleString() %>
		</font>

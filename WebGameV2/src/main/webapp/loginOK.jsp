<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.MemberVO" %>

<%
    if (session != null && session.getAttribute("loginMember") != null) {
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
%>
        <div>
            로그인 상태: <strong><%= member.getName() %></strong>님 |
            <a href="<%= request.getContextPath() %>/user?action=modForm">회원정보 수정</a> |
            <a href="<%= request.getContextPath() %>/user?action=logout">로그아웃</a>
        </div>
<%
    } else {
%>
        <div>
            <a href="<%= request.getContextPath() %>/loginForm.jsp">로그인</a> |
            <a href="<%= request.getContextPath() %>/userForm.jsp">회원가입</a>
        </div>
<%
    }
%>
<hr>

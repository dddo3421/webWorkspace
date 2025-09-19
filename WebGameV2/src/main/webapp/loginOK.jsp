<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.MemberVO" %>
<!-- 메인 상단에 로그인, 로그아웃, 회원가입, 회원탈퇴 include -->
<%
    if (session != null && session.getAttribute("loginMember") != null) {
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
%>
        <div>
            로그인 상태: <b><%= member.getName() %></b>님 |
            <a href="<%= request.getContextPath() %>/user?action=modForm">회원정보 수정</a> |
            <a href="<%= request.getContextPath() %>/user?action=logout">로그아웃</a> |
            <a href="<%= request.getContextPath() %>/user?action=delete"
               onclick="return confirm('정말 탈퇴하시겠습니까?');">회원탈퇴</a>
        </div>
<%
    } else {
%>
        <div>
            <a href="<%= request.getContextPath() %>/user?action=loginForm">로그인</a> |
            <a href="<%= request.getContextPath() %>/user?action=signupForm">회원가입</a>
        </div>
<%
    }
%>
<hr>

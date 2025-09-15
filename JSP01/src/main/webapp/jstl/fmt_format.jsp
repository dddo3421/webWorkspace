<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"   %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>포매팅 태그 라이브러리</title>
	</head>
	<body>
		<h3>fmt:formatNumber 태그 이용한 숫자 포맷팅</h3>
		
		<c:set var="price" value="100000000" />
		기본(천단위 구분 표시) : <fmt:formatNumber value="${price }" type="number" /><br>
		원화: <fmt:formatNumber value="${price }" type="currency"  currencySymbol="\\"  /><br>
		원화: <fmt:formatNumber value="${price }" type="currency"  currencySymbol="￦" /><br>
		원화: <fmt:formatNumber value="${price }" type="currency"  currencySymbol="₩" /><br>
		달러: <fmt:formatNumber value="${price }" type="currency"  currencySymbol="$" /><br>
		
		천단위 구분 표시 없음 : <fmt:formatNumber value="${price }" type="number" groupingUsed="false" /><br>
		퍼센트 : <fmt:formatNumber value="${price }" type="percent" groupingUsed="false" /><br>
		<!--  groupingUsed 천단위 구분자 -->
		<h3>fmt:formatDate 태그 이용한 숫자 포맷팅</h3>
		<c:set var="now" value="<%=new Date() %>" />
		<fmt:formatDate value="${now }" type="date" /><br> <!--  2024. 6. 21. -->
		<fmt:formatDate value="${now }" type="date" dateStyle="full"/><br> <!-- 2024년 6월 21일 금요일 -->
		<fmt:formatDate value="${now }" type="date" dateStyle="short"/><br> <!-- 24. 6. 21. -->
		
		<fmt:formatDate value="${now }" type="time" /><br><!-- 오전 10:40:06 -->
		<fmt:formatDate value="${now }" type="both" dateStyle="full"  timeStyle="full" /><br>
		<!-- 2024년 6월 21일 금요일 오전 10시 40분 55초 대한민국 표준시 -->
		
		<!-- 출력 형식 설정 : pattern 지정 -->
		<fmt:formatDate value="${now }" pattern="YYYY-MM-dd :hh:mm:ss" /><br> <!-- 2024-06-21 :10:41:59  -->
		<fmt:formatDate value="${now }" pattern="YYYY-MM-dd" /><br> <!-- 2024-06-21 -->
		
		<!-- 타임존 -->
		<fmt:timeZone value="America/New_York">
			<fmt:formatDate value="${now }" type="both" dateStyle="full"  timeStyle="full" />
		</fmt:timeZone>
	</body>
</html>












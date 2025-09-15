<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"   %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL - fn:함수()</title>
	</head>
	<body>
		<h3>여러 가지 문자열 함수 사용</h3>
		<c:set var="title1" value="Java의 정석" />
		<c:set var="title2" value="문자열 함수 태그 라이브러리" />
		<c:set var="str" value="태그" />
		
		title1 = ${title1 } <br>
		title2 = ${title2 } <br>
		str = ${str } <br>
		
		title1의 문자열 길이 (fn:length()) : ${fn:length(title1) }<br> <!-- 8 -->
		title2 : 8 ~ 9 번째 문자열 추출 (fn:substring()) :  ${fn:substring(title2, 7, 9) }<br> <!-- 태그 -->
		title1 : 공백을 /로 변환 (fn:replace()) : ${fn:replace(title1, " ", "/")}<br>  <!-- Java의/정석 -->
		
		title1에 '태그' 단어 포함 여부 (fn:contains()) : ${fn:contains(title1, str) }<br> <!--  false -->
		title2에 '태그' 단어 포함 여부 (fn:contains()) : ${fn:contains(title2, str) }<br> <!--  true -->
	</body>
</html>






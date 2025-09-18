<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta charset="UTF-8">
<c:choose>
	<c:when test='${msg=="addProduct" }'>
		<script>
			window.onload=function(){
				alert("상품을 등록했습니다");
			}
		</script>
	</c:when>
	<c:when test='${msg=="modProduct" }'>
		<script>
			window.onload=function(){
				alert("상품정보를 수정했습니다");
			}
		</script>
	</c:when>
	<c:when test='${msg=="deleted" }'>
		<script>
			window.onload=function(){
				alert("상품을 삭제했습니다");
			}
		</script>
	</c:when>
</c:choose>
<title>상품 목록창</title>
<style>
.cls1 {
	font-size: 40px;
	text-align: center;
}
.cls2 {
	font-size: 20px;
	text-align: center;
}
</style>

</head>
<body>
	<p class="cls1">상품 목록</p>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="10%"><b>상품번호</b></td>
			<td width="15%"><b>상품명</b></td>
			<td width="10%"><b>가격</b></td>
			<td width="15%"><b>제조사</b></td>
			<td width="10%"><b>색상</b></td>
			<td width="10%"><b>카테고리번호</b></td>
			<td width="10%"><b>수정</b></td>
			<td width="10%"><b>삭제</b></td>
		</tr>
		<c:choose>
			<c:when test="${empty productList }">
				<tr>
					<td colspan=8><b>등록된 상품이 없습니다</b></td>
				</tr>
			</c:when>
			<c:when test="${!empty productList }">
				<c:forEach var="prd" items="${productList }">
					<tr align="center">
						<td>${prd.prdNO }</td>
						<td>${prd.prdName }</td>
						<td>${prd.prdPrice }</td>
						<td>${prd.prdMaker }</td>
						<td>${prd.prdColor }</td>
						<td>${prd.ctgNO }</td>
						<td><a href="${contextPath }/product/modProductForm.do?prdNO=${prd.prdNO}">수정</a></td>
						<td><a href="${contextPath }/product/delProduct.do?prdNO=${prd.prdNO}">삭제</a></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<a href="${contextPath}/product/productForm.do"><p class="cls2">상품 등록하기</p></a>
	<a href="${contextPath}/main/main.jsp"><p class="cls2">메인으로</p></a> <!-- 메인으로 돌아가기 -->
</body>
</html>

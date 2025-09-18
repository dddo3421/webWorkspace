<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:choose>
	<c:when test='${msg=="exist"}'>
		<script>
			alert("이미 존재하는 상품번호입니다");
		</script>
	</c:when>
	<c:when test='${msg=="failAdd"}'>
		<script>
			alert("상품 등록 실패");
		</script>
	</c:when>
</c:choose>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록창</title>
</head>
<body>
	<form method="post" action="${contextPath }/product/addProduct.do">
		<h1 style="text-align: center">상품 등록창</h1>
		<table align="center">
			<tr>
				<td width="200"><p align="right">상품번호</td>
				<td width="400"><input type="text" name="prdNO"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">상품명</td>
				<td width="400"><input type="text" name="prdName"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">가격</td>
				<td width="400"><input type="text" name="prdPrice"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">제조사</td>
				<td width="400"><input type="text" name="prdMaker"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">색상</td>
				<td width="400"><input type="text" name="prdColor"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">카테고리번호</td>
				<td width="400"><input type="text" name="ctgNO"></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400"><input type="submit" value="등록하기"> <input
					type="reset" value="다시입력"> <input type="button"
					value="상품목록"
					onclick="location.href='${contextPath}/product/listProducts.do'"> <!-- 상품목록으로 돌아가기 -->
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

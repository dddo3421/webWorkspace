<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var name = "${name}";//표현 언어를 script 태그내에 사용 "홍길동"
	alert(name);
</script>
</head>
<body>
request 객체에 attribute로 바인딩 된 data el로 출력<br>
id : ${id }<br><!-- 바인딩된 속성값은 속성명만 사용하면 됨 -->
pwd : ${pwd }<br>
name : ${name }<br>
email : ${email}<br>

</body>
</html>
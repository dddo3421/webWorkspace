<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입 폼</title>
		<style>			
			#id, #pwd { width: 100px;}
			table { margin:0 auto; width:600px; }
		</style>
	</head>
	<body>
		<div id="wrap">
	        <h3 align="center">회원 가입</h3>
	        <hr>
	        <form name="frmJoin" method="post" action="joinOk.jsp">
	          <table>
	            <tr><td> 성명</td><td><input type="text" id="name" name="name"></td></tr>
	            <tr><td> ID</td><td><input type="text" id="id" name="id"></td></tr>
	            <tr><td>비밀번호</td><td><input type="password" id="pwd" name="pw"></td></tr>
	            <tr><td>휴대폰 번호</td><td><input type="text" id="hp1" size="3" name="hp1"> 
	                    - <input type="text" id="hp2" size="4" name="hp2">
	                    - <input type="text" id="hp3" size="4" name="hp3"></td></tr>   
	            <tr><td>학년</td><td><input type="radio" value="1"  name="grade">1학년
	                                     <input type="radio" id="year2"  value="2" name="grade">2학년
	                                     <input type="radio" id="year3"  value="3" name="grade">3학년
	                                     <input type="radio" id="year4" value="4" name="grade">4학년</td></tr>
	            <tr><td>관심분야</td>
	                  <td><input type="checkbox"  id="web" value="웹" name="interests">웹 프로그래밍
	                         <input type="checkbox"  id="design"  value="웹디자인" name="interests">파이썬
	                         <input type="checkbox"  id="bigdata"  value="빅데이터" name="interests">빅데이터
	                         <input type="checkbox"  id="java" value="자바" name="interests">자바 프로그래밍</td></tr>
	            <tr><td>학과</td>
	                  <td><select id="department" name="department">
	                               <option value="">선택하세요</option>
								   <option value="경영학과">경영학과</option>
								   <option value="산업공학과">산업공학과</option>
								   <option value="경제학과">경제학과</option>
								   <option value="전자공학과">전자공학과</option>
								   <option value="컴퓨터학과">컴퓨터학과</option>
	                          </select></td></tr>
	             <tr>
	                <td colspan="2" align="center">
	                    <br><input type="submit" value="완료">
	                    <input type="reset" value="취소">
	                </td>
	            </tr>             
	          </table>
      		</form>	
      	 </div>            
    </body>
</html>
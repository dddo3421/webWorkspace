<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>

    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <style>
            .form {
                border: #323232 solid 1px;
                margin: auto;
                padding: 10px;
                width: 70vw;
                height: 100%;
            }

            .form__input {
                display: flex;
                flex-direction: column;
                gap: 1rem;
            }

            .form__input>div {
                display: flex;
                justify-content: space-between;
            }

            .form__button {
                margin-top: 10px;
                width: 100%;
            }

            .container {
                position: relative;
                overflow-x: auto;
                border: #323232 solid 1px;
                margin: 10px auto;
                padding: 10px;
                width: 70vw;
                height: 300px;
            }

            .container__header {
                position: absolute;
                top: 1rem;
                right: 1rem;
            }
        </style>
        <script>
        	function submitHandler(){ // 정규식을 통해 특수문자 사용 못하게 필터링
        		const keyword = document.querySelector("input[name='keyword']");
        		   name 속성이 'keyword'인 <input> 요소를 선택해서 변수 keyword에 저장
        		const regex = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9| |]+$/;
        //		  정규표현식(Regex) 객체
        //	     허용되는 문자: 한글(ㄱ~ㅎ, 가~힣), 영문 대소문자(a-z, A-Z), 숫자(0-9), 공백( ), 파이프(|)
        //	     ^와 $는 문자열의 시작과 끝을 의미하므로, 전체 문자열이 이 문자들로만 이루어져야 함
        		if(!regex.test(keyword.value)){ // keyword 입력값이 정규표현식과 일치하지 않는다면 (즉, 허용되지 않은 문자가 있다면)
					alert("특수문자는 입력할 수 없습니다");
        			return false;						
				}
        		return true;
        	}
        	
        </script>
        <title>Insert title here</title>
    </head>

    <body>
        <h1>Reflected XSS 공격 </h1>

        <div class="form">
            <form action="reflected4.jsp" method="get" onsubmit="return submitHandler()"> 
                <div class="form__input">
                    <div>
                        <span> 검색 </span>
                        <input type="text" name="keyword" />
                    </div>
                </div>
                <input class="form__button" type="submit" value=" 검색 " />
            </form>
        </div>

        <div class="container">
            <% 
            	request.setCharacterEncoding("UTF-8");
            	//String keyword = request.getParameter("keyword");// 해당파라미터가 없으면 null 값 반환됨
            	//if(keyword ==null){
            	//	keyword ="";
            	//}
            	
            	
            %>
			<!-- jstl 라이브러리는 java 코드가 아니기 때문에 자바스크립트릿 태그 사용 불가 -->
			<c:set var= "keyword" value="${param.keyword}"/> 
			<c:if test='${empty keyword}'> 
				<c:set var="keyword" value="" />
			</c:if>
			
			
                <div class="container__header"> 검색어 <c:out value='${keyword}'/> <!-- keyword 변수에 저장된 값이 출력 -->
                </div>
        </div>

    </body>

    </html>
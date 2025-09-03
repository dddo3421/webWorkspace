<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        	function submitHandler(){ //서버측에 값을 전송하기 전에 xss에 취약한 특수 문자들에 대해서 치환하는 기능의 함수 
        		const keyword = document.querySelector("input[name='keyword']");
        		keyword.value = keyword.value.replaceAll(
        			    /[&<>()"'$/]/g,          
        			    char => ({                // 화살표 함수, 치환할 문자 패턴 : 패턴의 대체값 
        			        '&':'&amp;',
        			        '<':'&lt;',
        			        '>':'&gt;',
        			        '"':'&quot;',
        			        "'":'&#39;',
        			        '$':'&#36;',
        			        '(':'&#40;',
        			        ')':'&#41;',
        			        '/':'&#47;'
        			    }[char])                // char 객체 사용, 매칭되면 치환함 
        			);
        		return true;
        	}
        	
        </script>
        <title>Insert title here</title>
    </head>

    <body>
        <h1>Reflected XSS 공격 </h1>

        <div class="form">
            <form action="reflected3.jsp" method="get" onsubmit="return submitHandler()"> 
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
            	String keyword = request.getParameter("keyword");// 해당파라미터가 없으면 null 값 반환됨
            	if(keyword ==null){
            		keyword ="";
            	}
            	
            	
            %>

                <div class="container__header"> 검색어 <%=keyword  %><!-- keyword 변수에 저장되어 값이 출력 -->
                </div>
        </div>

    </body>

    </html>
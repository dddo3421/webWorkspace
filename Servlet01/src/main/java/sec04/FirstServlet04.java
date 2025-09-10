package sec04;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstSevlet04
 */
@WebServlet("/first04")
public class FirstServlet04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * redirect 방식으로 다른 서블릿에 데이터 전달ㅍ
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		//처리된 결과
		String name ="홍길동"; //조합문자를 url 파라미터 값으로 추가할 때는 url 사용가능한 범위의 코드로 변경해야 함
		//한글데이터 인코딩 : URLEncoder.encode(data,"utf-8")
		String encodeName = URLEncoder.encode(name, "utf-8");
		System.out.println(encodeName);
		int age = 30;
		//파라미터 추가 : uri?파라미터명=값&파라미터명=값&....             &앞뒤로 공백없어야함
		response.sendRedirect("second04?name="+encodeName+"&age="+age);
		//http://localhost:8080/Servlet01/second04?name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=30
	}

}

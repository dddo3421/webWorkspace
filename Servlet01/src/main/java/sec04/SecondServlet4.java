package sec04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet02
 */
@WebServlet("/second04")
public class SecondServlet4 extends HttpServlet {
	

	/**
	 * 파라미터로 전달된 값 추출해서 클라이언트에 응답 데이터로 사용
	 * 요청은 FirstSevlet에 의해 redirect 요청으로 진행되는 서블릿 페이지 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String html = "<html><body>이름 : " + name + "<br>나이 : "+age+"<br></body></html>";
		out.print(html);
				
	}

}

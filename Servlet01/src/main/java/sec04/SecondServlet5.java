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
@WebServlet("/second05")
public class SecondServlet5 extends HttpServlet {
	

	/**
	 * FirstSevlet05에서 dispatch 방식으로 포워딩 요청된 서블릿 - 최종 응답 진행(클라이언트 브라우저의 url은 최초 요청된 first05에서 변경되지 않음)
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

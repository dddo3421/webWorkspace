package sec04;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet05
 */
@WebServlet("/first05")
public class FirstServlet05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Dispatcher 활용한 포워딩 -> 현재 서블릿이 다른 서블릿을 요청 : 관련 메소드는 Request 객체에 포함되어 잇음 
	 * request.getRequestDispatcher(location);
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "홍길동";
		String encodeName = URLEncoder.encode(name,"utf-8");
		int age=30;
		RequestDispatcher dispatch = request.getRequestDispatcher("second05?name="+encodeName+"&age="+age);
		dispatch.forward(request, response); //dispatch 메서드 forward(현재 메소드의 request, response 객체를 요구함 - 요청에 대한 응답을 떠넘기고 있으므로 요청 응답객체가 필요)
	}

}

package sec04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet02
 */
@WebServlet("/first02")
public class FirstServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstSevlet02에서 Refresh 처리");
		//response.addHeader("Refresh", "2;url=second02"); //2초 후 브라우저가 second02 URL로 이동
		response.addHeader("Refresh", "2;url=second02?name=kim"); //2초 후 브라우저가 second02 URL로 이동
	}

}

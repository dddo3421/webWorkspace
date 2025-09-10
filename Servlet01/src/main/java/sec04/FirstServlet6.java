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
@WebServlet("/first06")
public class FirstServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 바인딩 방식으로 데이터를 생성하고 redirect 방식으로 데이터 전달 (불가함)
	 * dispatch 방식으로 데이터 포워딩
	 * request.setAttribute()
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("second06으로 바인딩된 데이터 포워딩 : redirect방식으로 포워딩하면 응답 후에 재요청 - 기존 request 객체는 삭제됨");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//데이터 바인딩
		request.setAttribute("name", "홍길동"); //value 홍길동은 Object 타입 객체로 전달 - 사용할 때 형변환 필요
		request.setAttribute("address", "서울시 강남구");
		
		//response.sendRedirect("second06"); //request 객체 삭제 -> 포워딩시 바인딩 data 전달 불가 
		//dispatch 방식으로 포워딩
		RequestDispatcher dispatch = request.getRequestDispatcher("second06");
		dispatch.forward(request, response); //second06으로 전송되는 request 객체에 바인딩 된 데이터가 저장되어 있음
	}

}

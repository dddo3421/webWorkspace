package sec03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet3
 */
@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get방식 요청");
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post방식 요청");
		doHandle(request, response);
	}

	// get, post 요청 모두에 대응하는 메소드
	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doHandle 요청");
		// (1)요청처리
		// 전송되는 데이터 인코딩
		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");

		// (2)응답처리
		// MIME-TYPE 설정
		response.setContentType("text/html;charset=utf-8");
		// java i/o 스트림 사용가능한 PrintWriter 객체 생성 - HttpServletResponse의 메소드 활용
		PrintWriter out = response.getWriter();

		// html문서 형식으로 데이터 작성해서 전송(문자열이 컨테이너쪽으로 출력됨)
		out.println("<html><head></head><body>");
		out.println("아이디 : " + userId + "<br>");
		out.println("비밀번호 : " + userPw + "<br>");
		out.println("</body></html>");
	}
}

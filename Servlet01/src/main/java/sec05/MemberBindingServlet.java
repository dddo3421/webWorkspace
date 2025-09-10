package sec05;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberBindingServlet
 */
@WebServlet("/memBinding")
public class MemberBindingServlet extends HttpServlet {

	/**
	 * 요청을 doProcess로 넘김
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * 요청을 doProcess로 넘김
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	//get, post 요청 모두를 처리하는 메서드
	protected void doProcess (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB의 member 테이블에서 데이터를 select해와서 ArrayList에 저장한다고 가정
		MemberVO vo1 = new MemberVO("Kim", "1234", "김길동", "kim@naver.com");
		MemberVO vo2 = new MemberVO("lee", "1234", "이몽룡", "lee@naver.com");
		MemberVO vo3 = new MemberVO("park", "1111", "박길동", "park@naver.com");
		
		ArrayList<MemberVO> memList = new ArrayList<MemberVO>();
		memList.add(vo1);
		memList.add(vo2);
		memList.add(vo3);
		
		//데이터 바인딩
		request.setAttribute("memberList", memList); // 바인딩되는 data Object 타입이므로 데이터 타입 상관없이 바인딩 가능
		
		//포워딩
		RequestDispatcher dispatch = request.getRequestDispatcher("memView");
		dispatch.forward(request, response);
	}

}

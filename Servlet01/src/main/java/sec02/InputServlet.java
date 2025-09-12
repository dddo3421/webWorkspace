package sec02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/input")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 실행, 첫 번째요청이 들어왔을 때 한 번 실행, 동일 요청에 대해서는 인스턴스 새로 생성하지 않음 ");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("인스턴스 없어질 때 한 번 실행, 서버 재시작, 웹어플리케이션 리로드시 인스턴스 삭제");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //utf-8 또는 UTF-8, 한글깨짐방지
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String emailRcv = request.getParameter("emailRcv");
		//동일한 name 속성으로 여러개의 값이 전달되는 경우 배열로 받음
		String[] subject = request.getParameterValues("subject");
		
		System.out.println("아이디 : " + user_id);
		System.out.println("비밀번호 : " + user_pw);
		System.out.println("이메일 수신여부 : " + emailRcv);
		
		System.out.println("선택한 과목 : ");
		
		for(String sub : subject) {
		    System.out.print(sub + " ");
		}
		System.out.println();
	}

}

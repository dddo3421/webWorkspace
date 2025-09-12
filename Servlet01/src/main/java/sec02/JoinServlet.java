package sec02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/insertMember")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("시작");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("종료");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 방식");
		doProcess(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 방식");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doHandle 요청");
		// (1)요청처리
		// 전송되는 데이터 인코딩
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
//		String phonF = request.getParameter("phonF");
//		String phonS = request.getParameter("phonS");
//		String phonT = request.getParameter("phonT");
		String[] phone = {
			    request.getParameter("phonF"),
			    request.getParameter("phonS"),
			    request.getParameter("phonT")
			};
			String ph = String.join(" - ", phone);
		String grade = request.getParameter("grade");
		String[] interests = request.getParameterValues("interests");
		String department = request.getParameter("department");

		// (2)응답처리
		// MIME-TYPE 설정
		response.setContentType("text/html;charset=utf-8");
		// java i/o 스트림 사용가능한 PrintWriter 객체 생성 - HttpServletResponse의 메소드 활용
		PrintWriter out = response.getWriter();

		// html문서 형식으로 데이터 작성해서 전송(문자열이 컨테이너쪽으로 출력됨)
		out.println("<html><head></head><body>");
		out.println("성명 : " + name + "<br>");
		out.println("ID : " + id + "<br>");
		out.println("비밀번호 : " + pw + "<br>");
		out.println("휴대폰 번호: " + ph + "<br>");
		out.println("학년 : " + grade + "<br>");
		out.print("관심분야 : ");
		if(interests != null) {
		    for(String ints : interests) {
		        out.print(ints + " ");
		    }
		} else {
		    out.print("선택 없음");
		}		
		out.println("<br> 학과 : " + department);	
		out.println("</body></html>");
		
		
//		Enumeration<String> enu =request.getParameterNames(); //클라이언트로부터 전달된 파라미터명 추출
//		
//		while(enu.hasMoreElements()) { //다음 elements가 있으면 반복문 진행
//			String names = enu.nextElement();
//			String [] values = request.getParameterValues(names); // 파라미터의 값을 배열로 반환받음(체크박스)
//			
//			for (String value: values) {
//				System.out.println(names+" : " + value );
//			}
//		}
		
	}
}

package sec02;

import java.io.IOException;
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
		System.out.println("init 메서드 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("");
		String phonF = request.getParameter("phonF");
		String phonS = request.getParameter("phonS");
		String phonT = request.getParameter("phonT");
		String grade = request.getParameter("grade");
		String[] interests = request.getParameterValues("interests");
		String department = request.getParameter("department");
		System.out.println("성명 : " + name);
		System.out.println("ID : " + id);
		System.out.println("휴대폰 번호: " + phonF +"-" + phonS + "-" + phonT);
		System.out.println("학년 : " + grade);
		System.out.print("관심분야 : ");
		if(interests != null) {
		    for(String ints : interests) {
		        System.out.print(ints + " ");
		    }
		} else {
		    System.out.print("선택 없음");
		}
		
		System.out.println("\n학과 : " + department);	
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //utf-8 또는 UTF-8, 한글깨짐방지
		System.out.println("Post 방식의 method 요청");
		doGet(request, response);
	}

}

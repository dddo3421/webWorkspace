package sec02;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class inputServlet2
 */
@WebServlet("/input2")
public class inputServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 쓰레드 시작");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy 쓰레드 종료");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> enu =request.getParameterNames(); //클라이언트로부터 전달된 파라미터명 추출
		
		while(enu.hasMoreElements()) { //다음 elements가 있으면 반복문 진행
			String name = enu.nextElement();
			String [] values = request.getParameterValues(name); // 파라미터의 값을 배열로 반환받음(체크박스)
			
			for (String value: values) {
				System.out.println("name = " +name+", value = "+value );
			}
		}
		
	}

}

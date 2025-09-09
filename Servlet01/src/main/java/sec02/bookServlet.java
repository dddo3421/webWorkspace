package sec02;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bookServlet
 */
@SuppressWarnings("serial") // 직렬화에 대한 워닝메시지 무시코드
@WebServlet("/bookInsert")
public class bookServlet extends HttpServlet {
	
       
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}
	
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //utf-8 또는 UTF-8, 한글깨짐방지
		// 요청 데이터를 추출하는 코드 -> 출력은 콘솔에 출력
		// 웹상에서 파라미터로 전달되는 데이터는 기본 문자열로 전달됨 
		String bookNo = request.getParameter("bookNo");
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		String bookPrice = request.getParameter("bookPrice");
		String bookYear = request.getParameter("bookYear");
		String bookMonth = request.getParameter("bookMonth");
		String bookDate = request.getParameter("bookDate");
		String bookStock = request.getParameter("bookStock");
		String pubNo = request.getParameter("pubNo");
		System.out.println("도서번호 : " + bookNo);
		System.out.println("도서명 : " + bookName);
		System.out.println("저자 : " + bookAuthor);
		System.out.println("가격 : " + bookPrice);
		System.out.println("발행일 : " + bookYear +"-" + bookMonth + "-" + bookDate);	
		System.out.println("재고 : " + bookStock);	
		System.out.println("출판사번호 : " + pubNo);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //utf-8 또는 UTF-8, 한글깨짐방지
		// 요청 데이터를 추출하는 코드 -> 출력은 콘솔에 출력
		// 웹상에서 파라미터로 전달되는 데이터는 기본 문자열로 전달됨 
		System.out.println("Post 방식의 method 요청");
		doGet(request, response);
	}
}

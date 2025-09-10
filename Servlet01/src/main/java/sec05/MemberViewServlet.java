package sec05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberViewServlet
 */
@WebServlet("/memView")
public class MemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemberVO> memList = (ArrayList<MemberVO>)request.getAttribute("memberList"); //형변환
		
		//응답 처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><head>");
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td>" 
				+ "<td>이메일</td><td>삭제</td></tr>");
		for (int i = 0; i < memList.size(); i++) {
			MemberVO vo = (MemberVO)memList.get(i);
//			String id = vo.getId();
//			String pwd = vo.getPwd();
//			String name = vo.getName();
//			String email = vo.getEmail();
			//테이블 행을 구성
			out.print("<tr><td>" + vo.getId() + "</td>");
			out.print("<td>" + vo.getPwd() + "</td>");
			out.print("<td>" + vo.getName() + "</td>");
			out.print("<td>" + vo.getEmail() + "</td>");
			out.print("<td><a href='/Servlet01/memDelete?id=" +  vo.getId() + "'>삭제</a></td></tr>");
		}
		
		out.print("</table></body></html>");
	}
}

package sec08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prdSelect")
public class ProductServletView extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 컨트롤러에서 바인딩된 상품 목록 가져오기
		ArrayList<ProductVO> prdList = (ArrayList<ProductVO>) request.getAttribute("prdList");

		out.print("<html><head></head><body>"); // HTML 문서 시작
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>제품번호</td><td>제품명</td><td>제품가격</td>" + "<td>제조사</td><td>색상</td><td>카테고리번호</td><td>삭제</td></tr>");

		if (prdList != null) {
			for (ProductVO vo : prdList) {
				out.print("<tr>");
				out.print("<td>" + vo.getPrdNO() + "</td>");
				out.print("<td>" + vo.getPrdName() + "</td>");
				out.print("<td>" + vo.getPrdPrice() + "</td>");
				out.print("<td>" + vo.getPrdMaker() + "</td>");
				out.print("<td>" + vo.getPrdColor() + "</td>");
				out.print("<td>" + vo.getCtgNO() + "</td>");
				out.print("<td><a href='/Servlet01/prdDelete?prdNo=" + vo.getPrdNO() + "'>삭제</a></td></tr>");
			}
		}

		out.print("</table></body></html>");
		out.close(); // 출력 스트림 자원 반환
	}
}

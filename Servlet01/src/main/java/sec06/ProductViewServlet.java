package sec06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ProductViewServlet
 */
@WebServlet("/prdView")
public class ProductViewServlet extends HttpServlet {

	/**
	 * 요청을 doProcess로 넘김
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * 요청을 doProcess로 넘김
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ProductVO> prdList = (ArrayList<ProductVO>) request.getAttribute("productList"); // 형변환

		// 응답 처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.print("<html><head>");
		out.print("<table border=1><tr align='center' bgcolor='skyBlue'>");
		out.print("<td>제품번호</td><td>제품명</td><td>가격</td>" + "<td>재고</td><td>삭제</td></tr>");
		for (int i = 0; i < prdList.size(); i++) {
			ProductVO p = (ProductVO) prdList.get(i);

			// 테이블 행을 구성
			out.print("<tr><td>" + p.getPrdNo() + "</td>");
			out.print("<td>" + p.getPrdName() + "</td>");
			out.print("<td>" + p.getPrdPrice() + "원 </td>");
			out.print("<td>" + p.getPrdStock() + "개 </td>");
			out.print("<td><a href='/Servlet01/prdDelete?id=" + p.getPrdNo() + "'>삭제</a></td></tr>");
		}

		out.print("</table></body></html>");
	}
}

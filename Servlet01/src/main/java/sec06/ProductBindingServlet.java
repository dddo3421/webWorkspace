package sec06;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Product
 */
@WebServlet("/prdBinding")
public class ProductBindingServlet extends HttpServlet {

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
		// ArrayList에 데이터 저장
		ProductVO p1 = new ProductVO("001", "콜라", 1500, 100);
		ProductVO p2 = new ProductVO("002", "사이다", 1400, 80);
		ProductVO p3 = new ProductVO("003", "아메리카노", 3000, 50);
		ProductVO p4 = new ProductVO("004", "주스", 2500, 60);

		ArrayList<ProductVO> prdList = new ArrayList<ProductVO>();
		prdList.add(p1);
		prdList.add(p2);
		prdList.add(p3);
		prdList.add(p4);

		request.setAttribute("productList", prdList); // 데이터 바인딩

		RequestDispatcher dispatch = request.getRequestDispatcher("prdView"); // dispatch 포워딩 진행
		dispatch.forward(request, response);
	}
}

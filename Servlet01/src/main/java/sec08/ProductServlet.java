package sec08;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/prdBinding2")
public class ProductServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   // DAO 호출, 상품 목록 조회
        ProductDAO dao = new ProductDAO();
        ArrayList<ProductVO> prdList = dao.productSelect();
        
        // 조회된 결과를 request 바인딩
        request.setAttribute("prdList", prdList);
        
        // 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("/prdSelect");
        dispatcher.forward(request, response);
  
	}

}

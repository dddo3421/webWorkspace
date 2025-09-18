import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product/*")
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ProductDAO productDAO;

    public void init(ServletConfig config) throws ServletException {
        productDAO = new ProductDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doHandle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = null;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getPathInfo();
        System.out.println("action : " + action);

        if (action == null || action.equals("/listProducts.do")) { // 전체 상품 조회
            List<ProductVO> productList = productDAO.listProducts();
            request.setAttribute("productList", productList);
            nextPage = "/listProducts.jsp";

        } else if (action.equals("/productForm.do")) { // 상품 등록 폼
            nextPage = "/productForm.jsp";

        } else if (action.equals("/addProduct.do")) { // 상품 등록 처리
            String prdNO = request.getParameter("prdNO");
            String prdName = request.getParameter("prdName");
            int prdPrice = Integer.parseInt(request.getParameter("prdPrice"));
            String prdMaker = request.getParameter("prdMaker");
            String prdColor = request.getParameter("prdColor");
            int ctgNO = Integer.parseInt(request.getParameter("ctgNO"));

            ProductVO productVO = new ProductVO(prdNO, prdName, prdPrice, prdMaker, prdColor, ctgNO);

            // 등록 시 상품번호 중복 체크 - 중복되면 등록실패 문구
            if (productDAO.isPrdNoExist(prdNO)) {
                request.setAttribute("msg", "exist");
                nextPage = "/productForm.jsp";
            } else {
                boolean added = productDAO.addProduct(productVO);
                if (added) {
                    request.setAttribute("msg", "addProduct");
                    nextPage = "/product/listProducts.do";
                } else {
                    request.setAttribute("msg", "failAdd");
                    nextPage = "/productForm.jsp";
                }
            }

        } else if (action.equals("/modProductForm.do")) { // 상품 수정 폼
            String prdNO = request.getParameter("prdNO");
            ProductVO product = productDAO.findProduct(prdNO);
            request.setAttribute("product", product);
            nextPage = "/modProductForm.jsp";

        } else if (action.equals("/modProduct.do")) { // 상품 수정 처리
            String prdNO = request.getParameter("prdNO");
            String prdName = request.getParameter("prdName");
            int prdPrice = Integer.parseInt(request.getParameter("prdPrice"));
            String prdMaker = request.getParameter("prdMaker");
            String prdColor = request.getParameter("prdColor");
            int ctgNO = Integer.parseInt(request.getParameter("ctgNO"));

            ProductVO productVO = new ProductVO(prdNO, prdName, prdPrice, prdMaker, prdColor, ctgNO);
            productDAO.modProduct(productVO);

            request.setAttribute("msg", "modProduct");
            nextPage = "/product/listProducts.do";

        } else if (action.equals("/delProduct.do")) { // 삭제 처리
            String prdNO = request.getParameter("prdNO");
            productDAO.delProduct(prdNO);

            request.setAttribute("msg", "deleted");
            nextPage = "/product/listProducts.do";

        } else { // 상품 목록 
            List<ProductVO> productList = productDAO.listProducts();
            request.setAttribute("productList", productList);
            nextPage = "/listProducts.jsp";
        }

        RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
        dispatch.forward(request, response);
    }
}

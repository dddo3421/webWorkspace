package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/menu") //메뉴 진입시 로그인체크와 메뉴 포워딩 담당
public class MenuController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // 로그인 체크
        if (session == null || session.getAttribute("loginMember") == null) {
            response.sendRedirect(request.getContextPath() + "/user?action=loginForm"); 
            return;
        }

        // 메뉴 페이지로 포워딩
        request.getRequestDispatcher("/menu.jsp").forward(request, response);
    }
}

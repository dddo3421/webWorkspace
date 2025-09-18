package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/menu")
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
        if (session == null || session.getAttribute("loginMember") == null) {
            response.sendRedirect("user?action=loginForm"); // 로그인 필요
            return;
        }

        String action = request.getParameter("action");
        if ("appinfo".equals(action)) {
            request.getRequestDispatcher("/appinfo.jsp").forward(request, response);
        } else { // 메뉴 페이지
            request.getRequestDispatcher("/menu.jsp").forward(request, response);
        }
    }
}

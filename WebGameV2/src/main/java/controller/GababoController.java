package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import gamelogic.GaBaBo;

@WebServlet("/gababo")
public class GababoController extends HttpServlet {
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

        // 세션 로그인 체크
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loginMember") == null) {
            response.sendRedirect("user?action=loginForm");
            return;
        }

        // POST 요청일 때 게임 실행
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String choice = request.getParameter("choice"); // 가위/바위/보
            GaBaBo game = new GaBaBo();
            String result = game.play(choice);
            request.setAttribute("result", result); // JSP에 전달
        }

        request.getRequestDispatcher("/view/gababo.jsp").forward(request, response);
    }
}

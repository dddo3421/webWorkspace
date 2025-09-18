package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import gamelogic.Guess;

@WebServlet("/guess")
public class GuessController extends HttpServlet {
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

        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String input = request.getParameter("guess");
            try {
                int userInput = Integer.parseInt(input);
                Guess game = new Guess();
                String result = game.check(userInput);
                request.setAttribute("result", result);
            } catch (NumberFormatException e) {
                request.setAttribute("result", "1~10 사이의 숫자를 입력하세요.");
            }
        }

        request.getRequestDispatcher("/view/guess.jsp").forward(request, response);
    }
}

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
        request.setCharacterEncoding("UTF-8");

        // 세션 로그인 체크
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loginMember") == null) {
            response.sendRedirect("user?action=loginForm");
            return;
        }

        // 세션에서 게임 객체 가져오기
        Guess game = (Guess) session.getAttribute("guessGame");
        if (game == null) {
            game = new Guess(); // 새 게임 시작
            session.setAttribute("guessGame", game);
        }

        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String input = request.getParameter("guess");
            try {
                int userInput = Integer.parseInt(input);
                String result = game.check(userInput);
                request.setAttribute("result", result);

                if ("정답!".equals(result)) {
                    session.removeAttribute("guessGame"); // 정답 맞히면 게임 종료
                }

            } catch (NumberFormatException e) {
                request.setAttribute("result", "1~10 사이의 숫자를 입력하세요.");
            }
        }

        request.getRequestDispatcher("/gameview/guess.jsp").forward(request, response);
    }
}

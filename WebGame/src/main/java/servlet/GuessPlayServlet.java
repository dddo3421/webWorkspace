package servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import game.Guess;

@WebServlet("/guess/play")
public class GuessPlayServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Guess game = (Guess) session.getAttribute("guessGame");

        if (game == null) {
            // 게임 객체가 없으면 새 게임 시작 서블릿으로 이동
            response.sendRedirect(request.getContextPath() + "/guess/start");
            return;
        }

        String guessStr = request.getParameter("guess");
        String result;

        try {
            int guess = Integer.parseInt(guessStr);
            result = game.check(guess);

            if ("정답!".equals(result)) {
                session.removeAttribute("guessGame"); // 정답 맞추면 게임 종료
            }
        } catch (NumberFormatException e) {
            result = "숫자를 입력하세요.";
        }

        // request 속성으로 전달 (forward 시 EL에서 사용 가능)
        request.setAttribute("result", result);

        // forward 사용 → request 객체 유지
        RequestDispatcher rd = request.getRequestDispatcher("/guess.jsp");
        rd.forward(request, response);
    }
}

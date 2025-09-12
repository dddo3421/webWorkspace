package servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import game.GaBaBo;

@WebServlet("/gababo/play")
public class GababoPlayServlet extends HttpServlet {

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

        request.setCharacterEncoding("UTF-8");

        String userChoice = request.getParameter("choice");
        String result = null;

        if (userChoice != null) {
            GaBaBo game = new GaBaBo();
            result = game.play(userChoice);
        }

        request.setAttribute("result", result);

        // 결과를 같은 JSP로 보여주되 결과만 출력
        request.getRequestDispatcher("/gababo.jsp").forward(request, response);
    }
}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.MemberDAO;
import model.MemberVO;

@WebServlet("/user")
public class UserController extends HttpServlet {
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
        String action = request.getParameter("action");
        MemberDAO dao = new MemberDAO();

        // 공용 세션 변수
        HttpSession session = request.getSession(false);

        switch (action) {
            case "signupForm": // 회원가입 폼
                request.getRequestDispatcher("/userForm.jsp").forward(request, response);
                break;

            case "signup": // 회원가입 처리
                String id = request.getParameter("id");
                String pwd = request.getParameter("pwd");
                String name = request.getParameter("name");
                String email = request.getParameter("email");

                // DAO로 중복체크
                if (dao.isExistId(id)) { 
                    request.setAttribute("msg", "이미 사용 중인 아이디입니다.");
                    request.getRequestDispatcher("/userForm.jsp").forward(request, response);
                } else {
                    dao.addMember(new MemberVO(id, pwd, name, email, null));
                    response.sendRedirect(request.getContextPath() + "/user?action=loginForm");
                }
                break;

            case "loginForm": // 로그인 폼
                request.getRequestDispatcher("/loginForm.jsp").forward(request, response);
                break;

            case "login": // 로그인 처리
                id = request.getParameter("id");
                pwd = request.getParameter("pwd");
                MemberVO member = dao.login(id, pwd);

                if (member != null) {
                    session = request.getSession(); // 로그인 성공 시 세션 가져오기
                    session.setAttribute("loginMember", member);
                    response.sendRedirect(request.getContextPath() + "/main/main.jsp"); // 성공시 메인으로
                } else {
                    request.setAttribute("msg", "로그인 실패: 아이디/비밀번호 확인");
                    request.getRequestDispatcher("/loginForm.jsp").forward(request, response);
                }
                break;
                

            case "modForm": // 회원정보 수정 폼
                if (session == null || session.getAttribute("loginMember") == null) {
                    // 로그인 안 되어 있으면 알람 띄우고 로그인 폼으로
                    request.setAttribute("msg", "회원정보를 수정하려면 먼저 로그인하세요.");
                    request.getRequestDispatcher("/loginForm.jsp").forward(request, response);
                } else {
                    // 로그인 되어 있으면 JSP 포워딩
                    request.getRequestDispatcher("/modUserForm.jsp").forward(request, response);
                }
                break;

            case "mod": // 회원정보 수정 처리
                if (session == null || session.getAttribute("loginMember") == null) {
                    request.setAttribute("msg", "회원정보를 수정하려면 먼저 로그인하세요.");
                    request.getRequestDispatcher("/loginForm.jsp").forward(request, response);
                } else {
                    member = (MemberVO) session.getAttribute("loginMember");

                    String newPwd = request.getParameter("pwd");
                    String newName = request.getParameter("name"); 
                    String newEmail = request.getParameter("email");

                    member.setPwd(newPwd);
                    member.setName(newName);
                    member.setEmail(newEmail);
                    dao.modMember(member);
                    session.setAttribute("loginMember", member); // 세션 업데이트

                    response.sendRedirect(request.getContextPath() + "/main/main.jsp");
                }
                break;

            case "delete": // 회원 탈퇴
                if (session != null && session.getAttribute("loginMember") != null) {
                    member = (MemberVO) session.getAttribute("loginMember");
                    dao.delMember(member.getId());
                    session.invalidate(); // 세션 제거
                }
                response.sendRedirect(request.getContextPath() + "/user?action=loginForm");
                break;

            case "logout": // 로그아웃
                if (session != null) session.invalidate();
                response.sendRedirect(request.getContextPath() + "/main/main.jsp");
                break;

            default:
                response.sendRedirect(request.getContextPath() + "/user?action=loginForm");
        }
    }
}

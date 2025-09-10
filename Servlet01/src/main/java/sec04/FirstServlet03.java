package sec04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet03
 */
@WebServlet("/first03")
public class FirstServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("location script를 활용한 포워딩:FirstServlet 처리");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//String script = "<script type ='text/javascript'>location.href = 'second03'; </script>";
		String script = "<script type ='text/javascript'>location.href = 'second03?name=kim'; </script>";
		out.print(script);
	}

}

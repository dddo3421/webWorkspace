<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    String db_address = "jdbc:oracle:thin:@localhost:1521:xe";
    String db_username = "SQL_USER";
    String db_pwd = "1234";
    Connection connection = DriverManager.getConnection(db_address, db_username, db_pwd);

    String insertQuery = "select max(num) from pratice_board";
    PreparedStatement psmt = connection.prepareStatement(insertQuery);
    ResultSet result = psmt.executeQuery();

    int num=0;

    while(result.next()){
        num = result.getInt("max(num)") + 1;
    }

    Timestamp today_date = new Timestamp(System.currentTimeMillis());
    request.setCharacterEncoding("UTF-8");
    String writer = request.getParameter("writer");    
    String title = request.getParameter("title");
    String content = request.getParameter("content");
	
 	// 모든 입력값에 대해 <, >, &, ", ' 치환	
    if(writer != null) {
        writer = writer.replaceAll("&", "&amp;")
                       .replaceAll("<", "&lt;")
                       .replaceAll(">", "&gt;")
                       .replaceAll("\"", "&quot;")
                       .replaceAll("'", "&#39;");
    }
    if(title != null) {
        title = title.replaceAll("&", "&amp;")
                     .replaceAll("<", "&lt;")
                     .replaceAll(">", "&gt;")
                     .replaceAll("\"", "&quot;")
                     .replaceAll("'", "&#39;");
    }
    if(content != null) {
        content = content.replaceAll("&", "&amp;")
                         .replaceAll("<", "&lt;")
                         .replaceAll(">", "&gt;")
                         .replaceAll("\"", "&quot;")
                         .replaceAll("'", "&#39;");
    }

    insertQuery = "insert into pratice_board(num, title, writer, content, regdate) values (?,?,?,?,?)";
    psmt = connection.prepareStatement(insertQuery);
    psmt.setInt(1, num);
    psmt.setString(2, title);
    psmt.setString(3, writer);
    psmt.setString(4, content);
    psmt.setTimestamp(5, today_date);

    psmt.executeUpdate();

    response.sendRedirect("post_list.jsp"); 

} catch (Exception ex) {
    out.println("오류가 발생했습니다. 오류 메시지 : " + ex.getMessage());
}
%>

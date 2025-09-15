package sec02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class MemberDAO {
	// DB 연결 담당 메소드 : DB 연결하고 Connection 객체 반환
	private Connection getConnection() {
		Connection con = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// DB 연결을 위한 연결 주소, 사용자 계정, 비밀번호 문자열 생성 
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SQL_USER";
			String pwd = "1234";
			
			// DB 연결하기 위한 객체 생성 
			// DriverManager 클래스를 통해 Connection 객체 받아옴 
			// MySQL 서버 연결 : 주소, 사용자계정, 비밀번호 전송 
			con = DriverManager.getConnection(url, user, pwd);
			
			// Connection 객체가 생성되면(null이 아니면) DB 연결 성공 
			if(con != null) {
				System.out.println("DB 연결 성공!");
			} else {
				System.out.println("DB 연결 실패!");
			}			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	// 회원 정보 조회 메소드 (전체 회원 정보 SELECT 해서 반환)
	// MemberVO로 받아서 ArrayList에 저장 후 ArrayList 객체 memList 반환
	public ArrayList<MemberVO> memberSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 데이터 저장해서 반환할 ArrayList 객체 생성
		ArrayList<MemberVO> memList = new ArrayList<MemberVO>();
		
		
		try {
			con = getConnection();
			
			String sql = "select * from member2";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 한 행(1명) 처리
				String memId = rs.getString("memId"); // 순서 번호 1, 2, 3... 사용해도 되고, 열 이름 사용해도 됨
				String memPwd = rs.getString("memPwd");
				String memName = rs.getString("memName");
				String memEmail = rs.getString("memEmail");
				Date memJoinDate = rs.getDate("memJoinDate");
				
				// MemberVO에 담아서
				MemberVO vo = new MemberVO();				
				vo.setMemId(memId);
				vo.setMemPwd(memPwd);
				vo.setMemName(memName);
				vo.setMemEmail(memEmail);
				vo.setMemJoinDate(memJoinDate);
				
				// ArrayList에 추가
				memList.add(vo);
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {}
		}
		
		return memList; // ArrayList 반환
	}
}





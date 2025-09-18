package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원가입
	public void addMember(MemberVO m) {
		String query = "INSERT INTO member2 (memid, mempwd, memname, mememail) VALUES(?, ?, ?, ?)";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 회원 조회 (ID 기준)
	public MemberVO findMember(String id) {
		MemberVO member = null;
		String query = "SELECT * FROM member2 WHERE memid=?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String pwd = rs.getString("mempwd");
				String name = rs.getString("memname");
				String email = rs.getString("mememail");
				java.sql.Date joinDate = rs.getDate("memjoinDate");
				member = new MemberVO(id, pwd, name, email, joinDate);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return member;
	}
	
	
	public MemberVO login(String id, String pwd) {
	    MemberVO member = null;
	    String query = "SELECT * FROM member2 WHERE memid=? AND mempwd=?";
	    try {
	        conn = dataFactory.getConnection();
	        pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, id);
	        pstmt.setString(2, pwd);
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            String name = rs.getString("memname");
	            String email = rs.getString("mememail");
	            Date joinDate = rs.getDate("memjoinDate");
	            member = new MemberVO(id, pwd, name, email, joinDate);
	        }
	        rs.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close();
	    }
	    return member;
	}
	
	// 회원정보 수정 (비밀번호, 이메일만)
	public void modMember(MemberVO memberVO) {
		String query = "UPDATE member2 SET mempwd=?, mememail=? WHERE memid=?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberVO.getPwd());
			pstmt.setString(2, memberVO.getEmail());
			pstmt.setString(3, memberVO.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 회원 탈퇴
	public void delMember(String id) {
		String query = "DELETE FROM member2 WHERE memid=?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 자원 반납
	private void close() {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isExistId(String id) {
	    String sql = "SELECT COUNT(*) FROM member2 WHERE memid = ?";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = dataFactory.getConnection(); // 
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, id);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt(1) > 0; // 0보다 크면 이미 있는 아이디 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return false;
	}
}

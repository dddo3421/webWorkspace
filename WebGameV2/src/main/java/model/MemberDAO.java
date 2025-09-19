package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
    private DataSource dataFactory;

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
        try (Connection conn = dataFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, m.getId());
            pstmt.setString(2, m.getPwd());
            pstmt.setString(3, m.getName());
            pstmt.setString(4, m.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 회원 조회 (ID 기준)
    public MemberVO findMember(String id) {
        MemberVO member = null;
        String query = "SELECT * FROM member2 WHERE memid=?";
        try (Connection conn = dataFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    member = new MemberVO(
                        id,
                        rs.getString("mempwd"),
                        rs.getString("memname"),
                        rs.getString("mememail"),
                        rs.getDate("memjoinDate")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

    // 로그인
    public MemberVO login(String id, String pwd) {
        MemberVO member = null;
        String query = "SELECT * FROM member2 WHERE memid=? AND mempwd=?";
        try (Connection conn = dataFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    member = new MemberVO(
                        id,
                        pwd,
                        rs.getString("memname"),
                        rs.getString("mememail"),
                        rs.getDate("memjoinDate")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

    // 회원정보 수정 (비밀번호, 이메일)
    public void modMember(MemberVO memberVO) {
        String query = "UPDATE member2 SET mempwd=?, mememail=? WHERE memid=?";
        try (Connection conn = dataFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, memberVO.getPwd());
            pstmt.setString(2, memberVO.getEmail());
            pstmt.setString(3, memberVO.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 회원 탈퇴
    public void delMember(String id) {
        String query = "DELETE FROM member2 WHERE memid=?";
        try (Connection conn = dataFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ID 존재 여부 확인
    public boolean isExistId(String id) {
        boolean exists = false;
        String sql = "SELECT COUNT(*) FROM member2 WHERE memid=?";
        try (Connection conn = dataFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    exists = rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
}

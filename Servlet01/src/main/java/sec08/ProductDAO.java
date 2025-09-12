package sec08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {

    // 전체 상품 정보 반환 : select
    public ArrayList<ProductVO> productSelect() {
        Connection con = null;            // DB 연결 객체
        PreparedStatement pstmt = null;   // SQL 실행을 위한 객체
        ResultSet rs = null;              // SELECT 결과를 담는 객체
        
        ArrayList<ProductVO> prdList = new ArrayList<>();

        try {
            con = DBConnect.getConnection();
            String query = "SELECT * FROM product";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ProductVO vo = new ProductVO(); // 한 행을 담을 VO 객체 생성
                vo.setPrdNO(rs.getString("PRDNO"));
                vo.setPrdName(rs.getString("PRDNAME"));
                vo.setPrdPrice(rs.getInt("PRDPRICE"));
                vo.setPrdMaker(rs.getString("PRDMAKER"));
                vo.setPrdColor(rs.getString("PRDCOLOR"));
                vo.setCtgNO(rs.getInt("CTGNO"));

                prdList.add(vo);
            }

        } catch (Exception e) {
            System.out.println("상품 조회 실패");
            e.printStackTrace();
        } finally {
            DBConnect.close(con, pstmt, rs); // DBConnect에서 제공하는 자원 해제 메소드 사용
        }

        return prdList;
    }
}

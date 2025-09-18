import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductDAO {
    private DataSource dataFactory;
    private Connection conn;
    private PreparedStatement pstmt;

    public ProductDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 전체 상품 조회
    public List<ProductVO> listProducts() {
        List<ProductVO> productList = new ArrayList<>();
        try {
            conn = dataFactory.getConnection();
            String query = "SELECT * FROM product ORDER BY prdNO";
            pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String prdNO = rs.getString("prdNO");
                String prdName = rs.getString("prdName");
                int prdPrice = rs.getInt("prdPrice");
                String prdMaker = rs.getString("prdMaker");
                String prdColor = rs.getString("prdColor");
                int ctgNO = rs.getInt("ctgNO");

                ProductVO productVO = new ProductVO(prdNO, prdName, prdPrice, prdMaker, prdColor, ctgNO);
                productList.add(productVO);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
 // 상품번호 중복 체크
    public boolean isPrdNoExist(String prdNO) {
        boolean exist = false;
        try {
            conn = dataFactory.getConnection();
            String query = "SELECT COUNT(*) FROM product WHERE prdNO=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, prdNO);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                exist = rs.getInt(1) > 0;
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exist;
    }

    // 상품 추가 (성공 여부 반환)
    public boolean addProduct(ProductVO p) {
        boolean success = false;
        try {
            conn = dataFactory.getConnection();
            String query = "INSERT INTO product (prdNO, prdName, prdPrice, prdMaker, prdColor, ctgNO) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, p.getPrdNO());
            pstmt.setString(2, p.getPrdName());
            pstmt.setInt(3, p.getPrdPrice());
            pstmt.setString(4, p.getPrdMaker());
            pstmt.setString(5, p.getPrdColor());
            pstmt.setInt(6, p.getCtgNO());

            int result = pstmt.executeUpdate();
            if (result > 0) success = true;

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    // 상품 검색
    public ProductVO findProduct(String prdNO) {
        ProductVO product = null;
        try {
            conn = dataFactory.getConnection();
            String query = "SELECT * FROM product WHERE prdNO=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, prdNO);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("prdName");
                int price = rs.getInt("prdPrice");
                String maker = rs.getString("prdMaker");
                String color = rs.getString("prdColor");
                int ctgNO = rs.getInt("ctgNO");

                product = new ProductVO(prdNO, name, price, maker, color, ctgNO);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    // 상품 수정
    public void modProduct(ProductVO product) {
        try {
            conn = dataFactory.getConnection();
            String query = "UPDATE product SET prdName=?, prdPrice=?, prdMaker=?, prdColor=?, ctgNO=? WHERE prdNO=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, product.getPrdName());
            pstmt.setInt(2, product.getPrdPrice());
            pstmt.setString(3, product.getPrdMaker());
            pstmt.setString(4, product.getPrdColor());
            pstmt.setInt(5, product.getCtgNO());
            pstmt.setString(6, product.getPrdNO());
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 상품 삭제
    public void delProduct(String prdNO) {
        try {
            conn = dataFactory.getConnection();
            String query = "DELETE FROM product WHERE prdNO=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, prdNO);
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

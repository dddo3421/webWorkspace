package sec08;

public class ProductVO {
	
	private String prdNO;    
	private String prdName;   
	private int prdPrice;     
	private String prdMaker;  
	private String prdColor;  
	private int ctgNO;        
	
	// 기본 생성자
	public ProductVO() {}
	

	public ProductVO(String prdNO, String prdName, int prdPrice, String prdMaker, String prdColor, int ctgNO) {
		this.prdNO = prdNO;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdMaker = prdMaker;
		this.prdColor = prdColor;
		this.ctgNO = ctgNO;
	}

	// Getter / Setter
	public String getPrdNO() {
		return prdNO;
	}

	public void setPrdNO(String prdNO) {
		this.prdNO = prdNO;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public int getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}

	public String getPrdMaker() {
		return prdMaker;
	}

	public void setPrdMaker(String prdMaker) {
		this.prdMaker = prdMaker;
	}

	public String getPrdColor() {
		return prdColor;
	}

	public void setPrdColor(String prdColor) {
		this.prdColor = prdColor;
	}

	public int getCtgNO() {
		return ctgNO;
	}

	public void setCtgNO(int ctgNO) {
		this.ctgNO = ctgNO;
	}
}

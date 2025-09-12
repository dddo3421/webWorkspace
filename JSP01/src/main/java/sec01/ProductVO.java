package sec01;

public class ProductVO {
	
	private String prdNO;    
	private String prdName;   
	private int prdPrice;     
	private String prdMaker;
	
	
	
	public ProductVO(String prdNO, String prdName, int prdPrice, String prdMaker) {
		super();
		this.prdNO = prdNO;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdMaker = prdMaker;
	}

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
      
	
	
}

package application;

public class Product {

	private String productCode;
	private String productName;
	private String productLine;
	private String productScale;
	private String productVendor;
	private String productDescription;
	private String quantityInStock;
	private String buyPrice;
	private String MSRP;
	
    public Product (
    		String productCode,
    		String productName,
    		String productLine,
    		String productScale,
    		String productVendor,
    		String productDescription,
    		String quantityInStock,
    		String buyPrice,
    		String MSRP
    		) {
    	
    	this.productCode = productCode;
    	this.productName = productName;
    	this.productLine = productLine;
    	this.productScale = productScale;
    	this.productVendor = productVendor;
    	this.quantityInStock = quantityInStock;
    	this.buyPrice = buyPrice;
    	this.MSRP = MSRP;
 
    }

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getProductScale() {
		return productScale;
	}

	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(String quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public String getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(String buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getMSRP() {
		return MSRP;
	}

	public void setMSRP(String mSRP) {
		MSRP = mSRP;
	}
    
    
   
}

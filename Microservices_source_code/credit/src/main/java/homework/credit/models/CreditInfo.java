package homework.credit.models;

public class CreditInfo {

	private String pesel;
	private String name;
	private String surname;
	private String productname;
	private int productvalue;
	private int creditId;
	private String creditname;
	public CreditInfo() {
		super();
	}
	public CreditInfo(String pesel, String name, String surname, String productname, int productvalue, int creditId,
			String creditname) {
		super();
		this.pesel = pesel;
		this.name = name;
		this.surname = surname;
		this.productname = productname;
		this.productvalue = productvalue;
		this.creditId = creditId;
		this.creditname = creditname;
	}
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getProductvalue() {
		return productvalue;
	}
	public void setProductvalue(int productvalue) {
		this.productvalue = productvalue;
	}
	public int getCreditId() {
		return creditId;
	}
	public void setCreditId(int creditId) {
		this.creditId = creditId;
	}
	public String getCreditname() {
		return creditname;
	}
	public void setCreditname(String creditname) {
		this.creditname = creditname;
	}
	
	
	
}

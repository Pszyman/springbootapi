package homework.credit.models;

public class CreditInfo2 {

	private String pesel;
	private String name;
	private String surname;
	private String productname;
	private int productvalue;

	private String creditname;
	public CreditInfo2() {
		super();
	}
	public CreditInfo2(String pesel, String name, String surname, String productname, int productvalue,
			String creditname) {
		super();
		this.pesel = pesel;
		this.name = name;
		this.surname = surname;
		this.productname = productname;
		this.productvalue = productvalue;
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
	
	public String getCreditname() {
		return creditname;
	}
	public void setCreditname(String creditname) {
		this.creditname = creditname;
	}
	
	
	
}

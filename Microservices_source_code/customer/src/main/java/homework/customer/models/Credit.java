package homework.customer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "credit")
public class Credit {
	
	@Id
	@Column(name = "creditid")
	@NotNull
	private int id;
	
	@Column(name = "creditname")
	@NotNull
	private String creditname;
	
	@Column(name = "pesel")
	@NotNull
	private String pesel;
	
	public Credit() {
		super();
	}

	public Credit(int id, String creditname, String pesel) {
		super();
		this.id = id;
		this.creditname = creditname;
		this.pesel = pesel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreditname() {
		return creditname;
	}

	public void setCreditname(String creditname) {
		this.creditname = creditname;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}



}


package homework.credit.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;





public class Customer {

	private String pesel;
	private String firstname;
	private String surname;
	private List<Credit> credit = new ArrayList<>();

	public Customer() {
		super();
	}

	public Customer(String pesel, String firstname, String surname, List<Credit> credit) {
		super();
		this.pesel = pesel;
		this.firstname = firstname;
		this.surname = surname;
		this.credit = credit;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Credit> getCredit() {
		return credit;
	}

	public void setCredit(List<Credit> credit) {
		this.credit = credit;
	}

	

}

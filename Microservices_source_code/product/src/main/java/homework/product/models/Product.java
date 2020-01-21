package homework.product.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "product")
public class Product {

	//@GeneratedValue(strategy=GenerationType.AUTO)
		@Id
		@Column(name = "creditid")
		@NotNull
		private int creditid;
		
		
		@Column(name = "productname")
		@NotNull
		private String productname;
		
		@Column(name = "value")
		@NotNull
		private int value;

		public Product(int creditid, String productname, int value) {
			super();
			this.creditid = creditid;
			this.productname = productname;
			this.value = value;
		}

		public Product() {
			super();
		}

		public int getCreditid() {
			return creditid;
		}

		public void setCreditid(int creditid) {
			this.creditid = creditid;
		}

		public String getProductname() {
			return productname;
		}

		public void setProductname(String productname) {
			this.productname = productname;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	
}

package chinook.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;



/**
 * The persistent class for the Shippers database table.
 * 
 */
@Entity
@Table(name="Shippers")
@NamedQuery(name="Shipper.findAll", query="SELECT s FROM Shipper s")
public class Shipper implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ShipperID")
	private int shipperID;

	@Column(name="CompanyName")
	@Length(min=1,max=40,message="Company name value is required and is limited to 40 characters in length.")
	private String companyName;

	@Column(name="Phone")
	@Pattern(regexp="^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$",message="Phone number must match the pattern (667) 780-9502")
	private String phone;

	public Shipper() {
	}

	public int getShipperID() {
		return this.shipperID;
	}

	public void setShipperID(int shipperID) {
		this.shipperID = shipperID;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
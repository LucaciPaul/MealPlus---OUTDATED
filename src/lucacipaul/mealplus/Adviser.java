package lucacipaul.mealplus;

import java.util.*;

public class Adviser extends User {

	private ArrayList<Customer> customers;
	private String regNo;
	private String occupation;
	private String addr1;
	private String addr2;
	private String postCode;
	private String phoneNo;
	private boolean approved;

	public String getRegNo() {
		return this.regNo;
	}

	/**
	 * 
	 * @param regNo
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getOccupation() {
		return this.occupation;
	}

	/**
	 * 
	 * @param occupation
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAddr1() {
		return this.addr1;
	}

	/**
	 * 
	 * @param addr1
	 */
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return this.addr2;
	}

	/**
	 * 
	 * @param addr2
	 */
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getPostCode() {
		return this.postCode;
	}

	/**
	 * 
	 * @param postCode
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPhoneNo() {
		return this.phoneNo;
	}

	/**
	 * 
	 * @param phoneNo
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public ArrayList<Customer> getAssociatedCustomers() {
		return this.customers;
	}

	/**
	 * 
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		// TODO - implement Adviser.addCustomer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param customer
	 */
	public void sendAssociationRequest(Customer customer) {
		// TODO - implement Adviser.sendAssociationRequest
		throw new UnsupportedOperationException();
	}

	public boolean getApproved() {
		return this.approved;
	}

	/**
	 * 
	 * @param approved
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}

}
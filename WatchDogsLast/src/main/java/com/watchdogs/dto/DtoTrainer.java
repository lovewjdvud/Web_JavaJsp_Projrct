package com.watchdogs.dto;

import java.sql.Timestamp;

public class DtoTrainer { // 자바에서 Bin 역할. MVC 에서는 Dto
	String trId;
	String trEmail;
	String trTel;
	String trName;
	String trDate;
	String trDelDate;
	String adminID;
	
	public DtoTrainer() {
		// TODO Auto-generated constructor stub
	}

	// Generate constructor using fields 사용했음! ; 오버로드
	public DtoTrainer(String trId, String trEmail, String trTel, String trName, String trDate, String trDelDate,
			String adminID) {
		super();
		this.trId = trId;
		this.trEmail = trEmail;
		this.trTel = trTel;
		this.trName = trName;
		this.trDate = trDate;
		this.trDelDate = trDelDate;
		this.adminID = adminID;
	}

	public String getTrId() {
		return trId;
	}

	public void setTrId(String trId) {
		this.trId = trId;
	}

	public String getTrEmail() {
		return trEmail;
	}

	public void setTrEmail(String trEmail) {
		this.trEmail = trEmail;
	}

	public String getTrTel() {
		return trTel;
	}

	public void setTrTel(String trTel) {
		this.trTel = trTel;
	}

	public String getTrName() {
		return trName;
	}

	public void setTrName(String trName) {
		this.trName = trName;
	}

	public String getTrDate() {
		return trDate;
	}

	public void setTrDate(String trDate) {
		this.trDate = trDate;
	}

	public String getTrDelDate() {
		return trDelDate;
	}

	public void setTrDelDate(String trDelDate) {
		this.trDelDate = trDelDate;
	}

	public String getAdminID() { 
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	
	
	

}

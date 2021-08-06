package com.watchdogs.dto;

public class DtoDog {
	int dogId;
	String dogName;
	String dogTrainSt;
	String dogAdoptSt;
	String dogDate;
	String dogAdoptDate;
	String dogTrainComm;
	String adminID;
	String trainerID;
	
	public DtoDog() {
		// TODO Auto-generated constructor stub
	}

	public DtoDog(int dogId, String dogName, String dogTrainSt, String dogAdoptSt, String dogDate, String dogAdoptDate,
			String dogTrainComm, String adminID, String trainerID) {
		super();
		this.dogId = dogId;
		this.dogName = dogName;
		this.dogTrainSt = dogTrainSt;
		this.dogAdoptSt = dogAdoptSt;
		this.dogDate = dogDate;
		this.dogAdoptDate = dogAdoptDate;
		this.dogTrainComm = dogTrainComm;
		this.adminID = adminID;
		this.trainerID = trainerID;
	}

	public int getDogId() {
		return dogId;
	}

	public void setDogId(int dogId) {
		this.dogId = dogId;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getDogTrainSt() {
		return dogTrainSt;
	}

	public void setDogTrainSt(String dogTrainSt) {
		this.dogTrainSt = dogTrainSt;
	}

	public String getDogAdoptSt() {
		return dogAdoptSt;
	}

	public void setDogAdoptSt(String dogAdoptSt) {
		this.dogAdoptSt = dogAdoptSt;
	}

	public String getDogDate() {
		return dogDate;
	}

	public void setDogDate(String dogDate) {
		this.dogDate = dogDate;
	}

	public String getDogAdoptDate() {
		return dogAdoptDate;
	}

	public void setDogAdoptDate(String dogAdoptDate) {
		this.dogAdoptDate = dogAdoptDate;
	}

	public String getDogTrainComm() {
		return dogTrainComm;
	}

	public void setDogTrainComm(String dogTrainComm) {
		this.dogTrainComm = dogTrainComm;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getTrainerID() {
		return trainerID;
	}

	public void setTrainerID(String trainerID) {
		this.trainerID = trainerID;
	}


	
	
}

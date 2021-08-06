package com.watchdogs.dto;

public class DtoDocument {
	int docId;
	String docTitle;
	String docContent;
	String docType;
	String docDate;
	String docDelDate;
	String userID;
	String adminID;
	
	public DtoDocument() {
		// TODO Auto-generated constructor stub
	}

	public DtoDocument(int docId, String docTitle, String docContent, String docType, String docDate, String docDelDate,
			String userID, String adminID) {
		super();
		this.docId = docId;
		this.docTitle = docTitle;
		this.docContent = docContent;
		this.docType = docType;
		this.docDate = docDate;
		this.docDelDate = docDelDate;
		this.userID = userID;
		this.adminID = adminID;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocTitle() {
		return docTitle;
	}

	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}

	public String getDocContent() {
		return docContent;
	}

	public void setDocContent(String docContent) {
		this.docContent = docContent;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocDate() {
		return docDate;
	}

	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}

	public String getDocDelDate() {
		return docDelDate;
	}

	public void setDocDelDate(String docDelDate) {
		this.docDelDate = docDelDate;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	
	

	
	
	
}

package com.watchdogs.dto;

import java.sql.Timestamp;

public class ReviewDto { // 자바에서 Bean 역할. MVC 에서는 Dto : 불러오기 등 DB 값 가져올때 사용 (임시저장소)
	
	//-------------------------------------------Field
	
	//변수이름과 DB 이름은 소문자로 _ 사용 말고!

	int docid;
	int docviews; //조회수 추가 (2021.05.18)
	String user_userid;
	String doctitle;
	String doccontent;
	Timestamp docdate;
	String doctype;
	
	// 파일 이름 추가
	String filename;
	String filerealname;
	
	//-------------------------------------------Constructor

	public ReviewDto() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * 2021.05.17 권효은
	 * userid 받아오기
	 */
	//id만 받아오는 것 (먼저 만들어 놓은것)
	public ReviewDto(String user_userid) {
		super();
		this.user_userid = user_userid;
	}

	
	
	/*
	 * 2021.05.18 권효은
	 * docid만 받아오기 : ReviewDocidCommand 로 불러오기
	 */
	public ReviewDto(int docid) {
		super();
		this.docid = docid;
	}
	

	
	/*
	 *	2021.05.18 권효은
	 * 	review detail  : 상세 페이지에 불러올 요소
	 *  user_userid, title, content , date
	 */
	public ReviewDto(String user_userid, String doctitle, String doccontent, Timestamp docdate) {
		super();
		this.user_userid = user_userid;
		this.doctitle = doctitle;
		this.doccontent = doccontent;
		this.docdate = docdate;
	}
	/*
	 * 상세 페이지 불러오기 수정 더 불러옴 (위의 요소 변경) : docid, dochit 
	 * 
	 */

	public ReviewDto(int docid, String user_userid, int docviews, String doctitle, Timestamp docdate , String doccontent) {
		super();
		this.docid = docid;
		this.user_userid = user_userid;
		this.docviews = docviews;
		this.doctitle = doctitle;
		this.docdate = docdate;
		this.doccontent = doccontent;
	}
	
	
	
	/*/
	 *  2021.05.18 권효은
	 *  리스트 불러올때 조회수를 위해 추가함
	 */
	
	public ReviewDto(String user_userid, String doctitle, String doccontent, Timestamp docdate, int docviews) {
		super();
		this.user_userid = user_userid;
		this.doctitle = doctitle;
		this.doccontent = doccontent;
		this.docdate = docdate;
		this.docviews = docviews;
	}
	

	// ?? 수정..?
	public ReviewDto(String doctitle, String doccontent, int docid) {
		super();
		this.doctitle = doctitle;
		this.doccontent = doccontent;
		this.docid = docid;
	}
	
	
	/*/
	 * 2021.05.19 권효은
	 * 리스트 페이징 처리
	 */
	
	public ReviewDto(int docid, String doctitle, String doccontent, Timestamp docdate, int docviews) {
		super();
		this.docid = docid;
		this.docviews = docviews;
		this.doctitle = doctitle;
		this.doccontent = doccontent;
		this.docdate = docdate;
	}
	

	
	
	
	//-------------------------------------------Getter & Setter
	// Generate constructor using fields 사용; 오버로드
	public int getDocid() {
		return docid;
	}




	public void setDocid(int docid) {
		this.docid = docid;
	}

	public String getUser_userid() {
		return user_userid;
	}

	public void setUser_userid(String user_userid) {
		this.user_userid = user_userid;
	}

	public String getDoctitle() {
		return doctitle;
	}

	public void setDoctitle(String doctitle) {
		this.doctitle = doctitle;
	}

	public String getDoccontent() {
		return doccontent;
	}

	public void setDoccontent(String doccontent) {
		this.doccontent = doccontent;
	}

	public Timestamp getDocdate() {
		return docdate;
	}

	public void setDocdate(Timestamp docdate) {
		this.docdate = docdate;
	}

	public String getDoctype() {
		return doctype;
	}

	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}

	//조회수 추가
	public int getDocviews() {
		return docviews;
	}

	public void setDocviews(int docviews) {
		this.docviews = docviews;
	}



	//05.20 파일 추가
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getFilerealname() {
		return filerealname;
	}
	
	public void setFilerealname(String filerealname) {
		this.filerealname = filerealname;
	}
	

	
	
	
	
	
	
	
}//end
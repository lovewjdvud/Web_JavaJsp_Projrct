package com.watchdogs.dto;


public class NoticeDto {

	/*/
	 * 2021.05.20 권효은
	 * 공지사항 임시저장소 
	 */
	//-------------------------------------------Field
	int noticeid;
	int noticeviews;
	String userid;
	String adid;
	String noticetitle;
	String noticecontent;
	String noticedate;
	
	
	//-------------------------------------------Constructor
	public NoticeDto() {
		// TODO Auto-generated constructor stub
	}
	/*/
	 * 2021.05.20 권효은
	 * 공지 상세정보에 불러올 내용
	 */
	public NoticeDto(int noticeid, String noticetitle, String noticecontent, String noticedate, int noticeviews) {
		super();
		this.noticeid = noticeid;
		this.noticetitle = noticetitle;
		this.noticecontent = noticecontent;
		this.noticedate = noticedate;
		this.noticeviews = noticeviews;
		
	}
	/*
	 * 2021.05.21 권효은
	 * 모든 정보 불러외서 사용하기
	 */
		public NoticeDto(int noticeid, int noticeviews, String userid, String adid, String noticetitle,
				String noticecontent, String noticedate) {
			super();
			this.noticeid = noticeid;
			this.noticeviews = noticeviews;
			this.userid = userid;
			this.adid = adid;
			this.noticetitle = noticetitle;
			this.noticecontent = noticecontent;
			this.noticedate = noticedate;
		}
		
		
	//-------------------------------------------Getter & Setter
	//모든 getter /setter	
		
		
	public int getNoticeid() {
		return noticeid;
	}
	public void setNoticeid(int noticeid) {
		this.noticeid = noticeid;
	}
	public int getNoticeviews() {
		return noticeviews;
	}
	public void setNoticeviews(int noticeviews) {
		this.noticeviews = noticeviews;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAdid() {
		return adid;
	}
	public void setAdid(String adid) {
		this.adid = adid;
	}
	public String getNoticetitle() {
		return noticetitle;
	}
	public void setNoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}
	public String getNoticecontent() {
		return noticecontent;
	}
	public void setNoticecontent(String noticecontent) {
		this.noticecontent = noticecontent;
	}
	public String getNoticedate() {
		return noticedate;
	}
	public void setNoticedate(String noticedate) {
		this.noticedate = noticedate;
	}


	
	

}//end

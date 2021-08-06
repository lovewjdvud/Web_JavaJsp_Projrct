package com.watchdogs.command.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.NoticeDao;
import com.watchdogs.dto.NoticeDto;

public class NoticeDetailViewCommand implements BCommand {
	/*/
	 * 2021.05.21 권효은
	 * 공지 상세 정보
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("NoticeDetailViewCommand 성공");
		
		String noticeid = request.getParameter("noticeid");
		
		NoticeDao dao = new NoticeDao();
		//조회수 사용 위함
		int result = dao.countViews(noticeid);
		if(result == 1) {
			NoticeDto dto = dao.noticeDetail(noticeid);	//int 로 변경 (21)
			request.setAttribute("noticedetail", dto);
		}else {
			System.out.println("noticeCount&noticeDetail 실행 실패");
		}
			
	
	}

}//end

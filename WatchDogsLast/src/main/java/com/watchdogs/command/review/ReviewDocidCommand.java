package com.watchdogs.command.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.ReviewDao;
import com.watchdogs.dto.ReviewDto;

public class ReviewDocidCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// 제일먼저 jsp가 준 id 값을 가져와야함
		System.out.println("ReviewDocidCommand 성공");
//		String docid = request.getParameter("docid");
		
		ReviewDao dao = new ReviewDao();
		ReviewDto dto = dao.reviewDocid(); // 그러면 디티오에 데이터가 쌓일거임
		
		request.setAttribute("review_docid", dto); //디티오 데이터를 메모리에 넘겨놓을게 jsp야 가져가 (controller가 처리할거임)

	}


}

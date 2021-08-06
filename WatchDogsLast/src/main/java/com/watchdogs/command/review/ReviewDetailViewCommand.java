package com.watchdogs.command.review;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.ReviewDao;
import com.watchdogs.dto.ReviewDto;

public class ReviewDetailViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("ReviewDetailViewCommand 성공");
		
		String docid = request.getParameter("docid");
		
		ReviewDao dao = new ReviewDao();
		//조회수 사용 위함
		int result = dao.countViews(docid);
		if(result == 1) {
			ReviewDto dto = dao.reviewDetail(docid);	
			request.setAttribute("reviewdetail", dto);
		}else {
			System.out.println("reviewCount&reviewDetail 실행 실패");
		}
			
	}

	

}

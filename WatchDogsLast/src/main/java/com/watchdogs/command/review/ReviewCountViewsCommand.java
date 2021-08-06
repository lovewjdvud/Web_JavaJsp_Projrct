package com.watchdogs.command.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.ReviewDao;

public class ReviewCountViewsCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("ReviewCountViewsCommand 성공");
		String docid = request.getParameter("docid");
		
		ReviewDao dao = new ReviewDao();
		int countviews = dao.countViews(docid);
		request.setAttribute("countviews", countviews);

	}

}

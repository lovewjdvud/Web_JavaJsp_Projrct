package com.watchdogs.command.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.ReviewDao;

public class ReviewModifyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("ReviewModifyCommand 완료");

		/*/
		 * 2021.05.18 권효은
		 * 후기 수정 
		 * 수정을 위해 입력되어있는 값 가져오기
		 */
		//input tag에 있는 값들을 받아오기
//		String user_userid = request.getParameter("user_userid");
		String doctitle = request.getParameter("doctitle");
//		String docdate = request.getParameter("docdate");
		String doccontent = request.getParameter("doccontent");
		String docid = request.getParameter("docid");
		
		ReviewDao dao = new ReviewDao();
		dao.reviewModify(doctitle, doccontent, docid);
		
		
		
		
		
	}

}

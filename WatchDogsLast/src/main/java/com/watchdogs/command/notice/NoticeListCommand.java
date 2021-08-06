package com.watchdogs.command.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.NoticeDao;
import com.watchdogs.dto.NoticeDto;

public class NoticeListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("NoticeListCommand 성공");
		
		int numInAPage = 10; // 한 페이지 안에 나올 갯수
		int clickPage = 1; // 첫 페이지 

		NoticeDao dao = new NoticeDao();
		HttpSession session = request.getSession();

		//페이지로 입력한 값이 0 이거나 아무것도 입력 안할때는 처리 안하고
		// 0 이 아니거나 무언가 입력되었을 때에만 페이지 값을 받아오게 하기
		if (request.getParameter("page") != null && request.getParameter("page").length() !=0 ) {
			try{
				clickPage = Integer.parseInt(request.getParameter("page")); //최초페이지는 0. 다음페이지는 1 이런식으로 가야 좋음
				//페이지에 대한걸 Dao로 넘겨 줘야함
				//상세페이지에서 목록보기 요청시 최근 페이지 목록으로 돌아가기 
				session.setAttribute("curpage", clickPage);
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
		}

		int countrows = dao.countTotalRows(); //총 게시물 데이터 수
		ArrayList<Integer> pageList = countPage(countrows);
		session.setAttribute("pagelist", pageList); 
		
		ArrayList<NoticeDto> dtos = dao.noticeList(clickPage, numInAPage); // 해당 페이지에 알맞은 번호의 게시글
		request.setAttribute("noticelist", dtos); //결과!

		
		/*/
		 * 2021.05.20
		 * 조회수 추가 
		 */
		
		String noticeid = request.getParameter("noticeid");
		NoticeDao ndao = new NoticeDao();
		int countviews = ndao.countViews(noticeid);
		request.setAttribute("ncountviews", countviews);	


}		
	//total pages를 구하기 위해 총행의 갯수가 필요함
	public ArrayList<Integer> countPage(int countrows) { //countrows는 총 행의 갯수 
		int numInAPage = 10; 
		
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		int countPage = 0;

		// 게시물 총 갯수가 동일할 때를 위함 
		if (countrows % numInAPage == 0) { 
			countPage = countrows / numInAPage;
		} else {
			countPage = countrows / numInAPage + 1;
		}

		for (int i = 1; i <= countPage; i++) {
			System.out.println(i + "페이지");
			arrlist.add(i);
		}
		return arrlist;

	}//count end
	

}//end

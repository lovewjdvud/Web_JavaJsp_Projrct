package com.watchdogs.command.review;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.ReviewDao;
import com.watchdogs.dto.ReviewDto;

public class ReviewWriteCommand implements BCommand {
	
	@Override 
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//jsp에서 만든 request임
		/*
		 * 2021.05.17 Mon 
		 * 게시판 작성 부분 메소드
		 */
		
//		int docid = Integer.parseInt(request.getParameter("docid")) ;//게시글 번호 가져오기 인트로형변환.  기준
//		System.out.println("ReviewWriteCommand 성공");
//		String doctitle = request.getParameter("doctitle");
//		String doccontent = request.getParameter("doccontent");
		
		
		
//		//05.20 파일 추가
//		String filename = request.getParameter("filename");
//		String filerealname = request.getParameter("filerealname");
		
//		ReviewDao dao = new ReviewDao();
//		ReviewDto dto = dao.review_write(id, doctitle, doccontent);
//		dao.reviewWrite(docid, doctitle, doccontent,filename, filerealname);
//		dao.reviewWrite(docid, doctitle, doccontent);

		
//		request.setAttribute("review_write", dto);  // arraylist등 Dao에서 리턴값이 있을때 사용함

		//new FileDao().upload(filename,filerealname);
		// Dao에 있는 upload 메소드를 실행
		
		
		
		/*/
		 * 2021.05.21 이미지 업로드 테스트
		 */
		//2021.05.19 권효은 파일 업로드 작업
		//session 받기 
		HttpSession session = request.getSession();
	    // 파일이 저장되는 경로
	    String path = request.getSession().getServletContext().getRealPath("fileFolder"); 
//	    String path = "/Users/hehe/Documents/JSP/WatchDogs_Practice/src/main/webapp/resources/"; 
	    System.out.println(path);

	   // String path = request.getRealPath("fileUpload");
	   //String path = request.getRealPath("save");
	  	
	  	System.out.println("fileFolder 접근 완료");
	  	
	    int size = 1024 * 1024 * 10; // 업로드 할 최대 파일 크기 (몇 메가바이트까지인지)
	    String file = ""; // 업로드 한 파일의 이름(이름이 변경될수 있다)
	    String originalFile = ""; // 이름이 변경되기 전 실제 파일 이름 (옛날께 이름바꿨다고 삭제 되지 않게)

	    // 실제 파일 업로드하는 과정
	    try{
	        MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
			//실제 path, max size, defaulFileRenamePolicy : 오리지날파일 어떻게 하겠느냐 : 파일뒤에 1,2 3 붙음 (덮어씌우기 방지 )
			//String doc
	        String docid = multi.getParameter("docid") ;//게시글 번호 가져오기 인트로형변환.  기준
			System.out.println("ReviewWriteCommand 성공");
			String doctitle = multi.getParameter("doctitle");
			String doccontent = multi.getParameter("doccontent");
			
			ReviewDao dao = new ReviewDao();
			//파일 이름 가져오기
			Enumeration<String> files = multi.getFileNames();
			String str = (String)files.nextElement(); // 파일 이름을 받아와 string으로 저장
			file = multi.getFilesystemName(str); // 업로드 된 파일 이름 가져옴
			originalFile = multi.getOriginalFileName(str); // 원래의 파일이름 가져옴
			
			session.setAttribute("filepath", file); // name을 session에 저장
			
			//dao로 정보 다 보내서 write실행
			dao.reviewWrite(docid, doctitle, doccontent, file);

	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	
		
		
		
		
		
	}

}//end




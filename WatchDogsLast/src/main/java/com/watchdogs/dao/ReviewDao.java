package com.watchdogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.watchdogs.dto.ReviewDto;

public class ReviewDao {
	

	DataSource dataSource;
	
	public ReviewDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
			System.out.println("Review DB연결 완료");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Review DB연결 실패");
		}
	}
	
	
	//-------------------------------------------------------------HE part 
	/*
	 * 2021.05.17 권효은
	 * reviewWrite 메소드를 통해 DB에 게시판 내용 작성
	 * 2021.05.17 17:45 완성
	 */
	
	public void reviewWrite(String docid,String doctitle, String doccontent ,String file) { //여기 메소드에서 아이디는  사용할 필요는 없다
		// 입력해둔 아이디가 하나있고, 그 아이디와 같아야 입력됨! (임시아이디)
		String user_userid = "he"; 
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try { 
			connection = dataSource.getConnection();
			
			String query = "insert into document (doctitle, doccontent, docdate, user_userid, filepath) values (?, ?, now(), ?, ?)";
			
			preparedStatement = connection.prepareStatement(query);
			
			
			preparedStatement.setString(1, doctitle);
			preparedStatement.setString(2, doccontent);
			preparedStatement.setString(3, user_userid);
			preparedStatement.setString(4, file);
//			preparedStatement.setString(5, filerealname);
			
			
			preparedStatement.executeUpdate();
			
			System.out.println("reviewWrite 데이터 로드 성공");
		}catch(Exception e) {
			System.out.println("reviewWrite 데이터 로드 실패");
			e.printStackTrace();
			//정상적이든, 에러가 걸리든 무조건 final로 와라 
		}finally{
			try {
				if(preparedStatement !=null) preparedStatement.close();
				if(connection !=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
		}

		
	}//review write 메소드 end
	
	/*
	 * 2021.05.17-18 권효은
	 * review 게시물 리스트 불러오기
	 * 05 19: 페이징 추가 
	 */
	
	
	public ArrayList<ReviewDto> reviewList(int clickPage, int numInAPage) {
		ArrayList<ReviewDto> list = new ArrayList<ReviewDto>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		
		try {
//			where docid < ? order by docid desc limit 10
			//String query = "select docid, doctitle, doccontent, docdate, dochit from document order by docid desc limit 10;"; // bbsavailable
			//limit에 한 페이지당 들어갈 게시물 갯수를 ?로 구현 
			String query = "select docid, doctitle, doccontent, docdate, docviews from document order by docid desc limit ?, ?"; //limit start 지점. 몇개 뽑을 건지
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, getNext() - (pageNumber -1) * 10);
			
			int defpage = clickPage -1;
			preparedStatement.setInt(1, defpage * numInAPage); //여기에 그냥 요청 페이지를 넣으면 ? 안됨
			//10(numInApage)개 기준이면 0에서 -> 0, 1 이 들어오면 10, 2가 들어오면 20 이렇게 되어야함 
			//즉 처음 물음표는 값이 계속 limit해 놓은 페이지 다음게 시작해야하므로  clickpage * numInApage 인데, 첫시작은 0인게 좋음
			preparedStatement.setInt(2, numInAPage);
			
			resultSet = preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
//				//dto를 먼저 불러와서 , dto를 바꿔주자
//				ReviewDto dto = new ReviewDto();
//				dto.setDocid(resultSet.getInt(1));
//				dto.setDoctitle(resultSet.getString(2));
//				dto.setDoccontent(resultSet.getString(3));
//				dto.setDocdate(resultSet.getTimestamp(4));
//				dto.setDochit(resultSet.getInt(5));
//				
//				list.add(dto);
				int docid = resultSet.getInt(1);
				String doctitle = resultSet.getString(2);
				String doccontent = resultSet.getString(3);
				Timestamp docdate = resultSet.getTimestamp(4);
				int docviews = resultSet.getInt(5);
				
				ReviewDto dto = new ReviewDto(docid, doctitle, doccontent, docdate, docviews);
				list.add(dto); 
				System.out.println("reviewList 데이터 로드 성공");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("reviewList 데이터 로드 실패");
		}finally { // 메모리에서 정리 
			try {
				if(resultSet != null) resultSet.close(); // resultset이 비어있지 않으면, 정리한다. 
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				System.out.println("reviewList 데이터 final 성공");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}//arraylist review list end
	
	/*
	 * 2021.05.17-18 권효은
	 * review에 게시물 번호 불러오기 기능 구현 (번호만 불러와서 보여주기) : 나중에 작성자 등 추가 할수도!?
	 */
	
	public ReviewDto reviewDocid() {
		
		ReviewDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = dataSource.getConnection();
			String query = "select max(docid)+1 from document"; 
			
			//프리페어스테이트먼트를 쓰므로 스테이트먼트 필요없음 둘중 하나만 쓰면 됨
			preparedStatement = connection.prepareStatement(query);
			//아이디를 숫자로 받자 
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int docid = resultSet.getInt("max(docid)+1");  
				
				dto = new ReviewDto(docid);  
				System.out.println("reviewDocid 데이터 로드 성공");
				
			}
			
			
		}catch(Exception e) {
			System.out.println("reviewDocid 데이터 로드 실패");
			e.printStackTrace();
			//정상적이든, 에러가 걸리든 무조건 final로 와라 
		}finally{
			try {
				if(resultSet !=null) resultSet.close();
				if(preparedStatement !=null) preparedStatement.close();
				if(connection !=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
		}
		return dto; //내가 받은 데이터를 리턴해주면 됨
		
	
	}//review docid end
	
	
	
	
	/*
	 *  2021.05.18 권효은
	 *  review detail view 후기 상세 페이지
	 */
	public ReviewDto reviewDetail(String docid) {
		
		// 조회수
		//upHit(docid);
		
		ReviewDto dto =null; //추가 새벽
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select docid, user_userid, docviews, doctitle, docdate, doccontent from document where docid = ?"; 
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, Integer.parseInt(docid));  // ?인 것을 뭐로 하겠다! (쿼리문에서) --int로 바꿈 (새벽)
			
			resultSet = preparedStatement.executeQuery(); // 그 문장을 가지고 쿼리문을 실행한 값을 받아둠
			
			while(resultSet.next()) {
				//ReviewDto dto = new ReviewDto();
				
				int docId = resultSet.getInt(1); //추가 새벽
				String user_userid = resultSet.getString(2);
				int docviews = resultSet.getInt(3); //불러오는김에 히트도
				String doctitle = resultSet.getString(4);
				Timestamp docdate = resultSet.getTimestamp(5);
				String doccontent = resultSet.getString(6);
				

				dto = new ReviewDto(docId, user_userid, docviews, doctitle, docdate, doccontent);
				System.out.println("reviewDetail 데이터 로드 성공");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("reviewDetail 데이터 로드 실패");
		}finally { // 메모리에서 정리 
			try {
				if(resultSet != null) resultSet.close(); // resultset이 비어있지 않으면, 정리한다. 
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	
	}//arraylist reviewdetail end
	
	/*/
	 * 2021.05.18-19 권효은 
	 * 후기 수정
	 */
	public void reviewModify(String doctitle, String doccontent , String docid) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			//update때는 values가 안먹힐때 있음
			String query = "update document set doctitle = ?, doccontent = ? where docid = ? ";
			
			preparedStatement = connection.prepareStatement(query);
			
			//query문 안에 뭐넣을지 정해줌
			preparedStatement.setString(1, doctitle);
			preparedStatement.setString(2, doccontent);
			preparedStatement.setInt(3, Integer.parseInt(docid));
			
			System.out.println("reviewModify 로드 성공");
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("reviewModify 로드 실패");
			e.printStackTrace();
			//정상적이든, 에러가 걸리든 무조건 final로 와라 
		}finally{
			try {
				if(preparedStatement !=null) preparedStatement.close();
				if(connection !=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
		}

		
	}//reviewModify end
	
	/*/
	 * 2021.05.18 -19 권효은 
	 * 후기 삭제
	 */	
	//---------------------------------삭제 해보기

	public void reviewDelete(String docid) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = dataSource.getConnection();
			
			String query = "delete from document where docid= ?"; //삭제는 꼭 where 을 주기
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, Integer.parseInt(docid));
			
			preparedStatement.executeUpdate();
			System.out.println("reviewDelete DB입력 성공");
			
		}catch(Exception e) {
			System.out.println("reviewDelete DB입력 실패");
			e.printStackTrace();
			//정상적이든, 에러가 걸리든 무조건 final로 와라 
		}finally{
			try {
				//close해줘야 데이터가 쌓이지 않음
				if(preparedStatement !=null) preparedStatement.close();
				if(connection !=null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
		}

		
	}//reviewDelete end
	
	
//	public boolean nextPage(int pageNumber) {
//		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
//		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			
//			String query = "select * from document where docid < ?"; // bbsavailable
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, getNext() - (pageNumber -1) * 10);
//			resultSet = preparedStatement.executeQuery();
//			
//			if(resultSet.next()) {
//				return true;
//				System.out.println("nextPage 데이터 로드 성공");
//
//			}
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("nextPage 데이터 로드 실패");
//		}finally { // 메모리에서 정리 
//			try {
//				if(resultSet != null) resultSet.close(); // resultset이 비어있지 않으면, 정리한다. 
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return false;
//	
//	}//arraylist board list end
		
		
		
		/*/
		 * 2021.05.19 권효은
		 * 페이지 총 목록 행의 갯수 구하기 (게시물 수)
		 */
		public int countTotalRows() {
			int count = 0;
		
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			String query = "select count(*) from document";  //게시물에 있는 모든 게시물 갯수 가져오기
	
			try {
				connection = dataSource.getConnection();
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
	
				if (resultSet.next()) {
					count = resultSet.getInt(1);
					System.out.println("리스트 카운트 성공");
				}
			}catch (Exception e) {
				System.out.println("리스트 카운트 실패");
				e.printStackTrace();
			}finally { // 메모리에서 정리 
				try {
					if(resultSet != null) resultSet.close(); // resultset이 비어있지 않으면, 정리한다. 
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					System.out.println("reviewList 데이터 final 성공");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}//finally
	
				return count;

		}//countlist end
			
		/*
		 * 2021.05. 19-20 권효은
		 * 	조회수 갯수 구해보기
		 */
		
	public int countViews(String docid) {
		
		//글번호 -> 작성자 글내용 확인하는 메소드 / boolean->조회수를 올릴지 아닐지 확인하는 불린타입
		//show.jsp에서 들어가면 조회수 증가하고(true설정), edit.jsp에서 들어가면 조회수 증가 X(false설정)
		//hitadd?

		
		//ReviewDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		//조회수 저장공간
		int countRead = 0;
		try {
			connection = dataSource.getConnection();
			String query = "update document set docviews = docviews + 1 where docid = ? " ;
			preparedStatement = connection.prepareStatement(query);
			
			//query문 안에 뭐넣을지 정해줌
			preparedStatement.setInt(1, Integer.parseInt(docid));
			
			System.out.println("countViews 로드 성공");
			countRead = preparedStatement.executeUpdate(); //실행 -> countRead에 담기
			
			}catch(Exception e) {
			System.out.println("countViews 로드 실패");
			e.printStackTrace();
			}finally{
				try {
					if(preparedStatement !=null) preparedStatement.close();
					if(connection !=null) connection.close();
				}catch(Exception e) {
					e.printStackTrace();	
				}
			
			}//finally
		return countRead;
	}//countView end 
		
}//end

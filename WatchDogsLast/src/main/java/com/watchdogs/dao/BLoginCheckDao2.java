package com.watchdogs.dao;
//package com.jsplec.bbs.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.sql.DataSource;
//
//import com.jsplec.bbs.dto.BListDto;
//import com.jsplec.bbs.dto.BLoginCheckDto;
//
//public class BLoginCheckDao2 {
//
//	DataSource dataSource;
//	
//	public BLoginCheckDao2() {
//		// TODO Auto-generated constructor stub
//	
//		try {
//			Context context = new InitialContext();
//			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public BLoginCheckDto login(String inputID, String inputPW) {
//		BLoginCheckDto bLCDto = null;
//		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//
//			String query = "select userid, usertel, useremail, username, userdate from user where userid = ? and userPw = ? " ;
//			
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, inputID);
//			preparedStatement.setString(2, inputPW);
//			resultSet = preparedStatement.executeQuery();
//			
//				while(resultSet.next()) {
//					String bId = resultSet.getString("userid"); 
//					String bTel = resultSet.getString("usertel"); 
//					String bEmail = resultSet.getString("useremail");
//					String bName = resultSet.getString("username"); 
//					Timestamp bDate = resultSet.getTimestamp("userdate"); 
//					
//					bLCDto = new BLoginCheckDto(bId, bTel, bEmail, bName, bDate);
//				}
//			System.out.println(bLCDto.getbId() + " 님 로그인 되었습니다. ");					
//	
//		} catch (Exception e) {
//			
//			response.sendRedirect("writeFile_13.jsp?result="+result);
//			e.printStackTrace();
//		}finally { // 메모리에서 정리 
//			try {
//				if(resultSet != null) resultSet.close(); // resultset이 비어있지 않으면, 정리한다. 
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return bLCDto;
//	}
//}

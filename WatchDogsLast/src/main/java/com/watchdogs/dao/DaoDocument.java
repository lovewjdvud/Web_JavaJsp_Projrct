package com.watchdogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.watchdogs.dto.DtoDocument;
import com.watchdogs.dto.DtoDog;

public class DaoDocument {
	
	DataSource dataSource;
	
	public DaoDocument() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DtoDocument> list() {
		ArrayList<DtoDocument> dtos = new ArrayList<DtoDocument>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select docid, doctitle, doccontent, doctype, docdate, docdeldate, user_userid, admin_adid from document"; // 속성명에 유의! 
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int docid = resultSet.getInt("docid"); // 속성 명에 유의! 
				String doctitle = resultSet.getString("doctitle"); // 속성 명에 유의! 
				String doccontent = resultSet.getString("doccontent"); // 속성 명에 유의! 
				String doctype = resultSet.getString("doctype"); // 속성 명에 유의! 
				String docdate = resultSet.getString("docdate"); // 속성 명에 유의! 
				String docdeldate = resultSet.getString("docdeldate"); // 속성 명에 유의! 
				String user_userid = resultSet.getString("user_userid"); // 속성 명에 유의! 
				String admin_adid = resultSet.getString("admin_adid"); // 속성 명에 유의! 

				System.out.println(" Id = " + docid); // 테스트 용
				
				DtoDocument dto = new DtoDocument(docid, doctitle, doccontent, doctype, docdate, docdeldate, user_userid, admin_adid);
				dtos.add(dto);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally { // 메모리에서 정리 
			try {
				if(resultSet != null) resultSet.close(); // resultset이 비어있지 않으면, 정리한다. 
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	
	}
	
	public DtoDocument detail(int docId) {
		DtoDocument dto = null;
		 
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select docid, doctitle, doccontent, doctype, docdate, docdeldate, user_userid, admin_adid from document where docid = ?"; // 속성명에 유의! 
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, docId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int docid = resultSet.getInt("docid"); // 속성 명에 유의! 
				String doctitle = resultSet.getString("doctitle"); // 속성 명에 유의! 
				String doccontent = resultSet.getString("doccontent"); // 속성 명에 유의! 
				String doctype = resultSet.getString("doctype"); // 속성 명에 유의! 
				String docdate = resultSet.getString("docdate"); // 속성 명에 유의! 
				String docdeldate = resultSet.getString("docdeldate"); // 속성 명에 유의! 
				String user_userid = resultSet.getString("user_userid"); // 속성 명에 유의! 
				String admin_adid = resultSet.getString("admin_adid"); // 속성 명에 유의! 
				
				System.out.println(" Id = " + docid); // 테스트 용
				
				dto = new DtoDocument(docid, doctitle, doccontent, doctype, docdate, docdeldate, user_userid, admin_adid);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
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
		
	}
	
	public void update(int docId, String docTitle, String docContent, String docType, String docDate, String docDelDate, String userID, String adminID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update document set doctitle = ?, doccontent = ?, doctype = ?, docdate = ?, docdeldate = ?, user_userid = ?, admin_adid = ? where docid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, docTitle);
			preparedStatement.setString(2, docContent);
			preparedStatement.setString(3, docType);
			preparedStatement.setString(4, docDate);
			preparedStatement.setString(5, docDelDate);
			preparedStatement.setString(6, userID);
			preparedStatement.setString(7, adminID);
			preparedStatement.setInt(8, docId);
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(int docId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update document set docdeldate = now() where docid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, docId);
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insert(String docTitle, String docContent, String docType, String userID, String adminID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into document (doctitle, doccontent, doctype, docdate, user_userid, admin_adid) values (?,?,?,now(),?,?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, docTitle);
			preparedStatement.setString(2, docContent);
			preparedStatement.setString(3, docType);
			preparedStatement.setString(4, userID);
			preparedStatement.setString(5, adminID);
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

package com.watchdogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.watchdogs.dto.DtoDog;
import com.watchdogs.dto.DtoTrainer;

public class DaoDog {
	
	DataSource dataSource;
	
	public DaoDog() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<DtoDog> list() {
		ArrayList<DtoDog> dtos = new ArrayList<DtoDog>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select dogid, dogname, dogtrainst, dogadoptst, dogdate, dogadoptdate, dogtraincomm, admin_adid, trainer_trid from dog"; // 속성명에 유의! 
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int dogid = resultSet.getInt("dogid"); // 속성 명에 유의! 
				String dogname = resultSet.getString("dogname"); // 속성 명에 유의! 
				String dogtrainst = resultSet.getString("dogtrainst"); // 속성 명에 유의! 
				String dogadoptst = resultSet.getString("dogadoptst"); // 속성 명에 유의! 
				String dogdate = resultSet.getString("dogdate"); // 속성 명에 유의! 
				String dogadoptdate = resultSet.getString("dogadoptdate"); // 속성 명에 유의! 
				String dogtraincomm = resultSet.getString("dogtraincomm"); // 속성 명에 유의! 
				String admin_adid = resultSet.getString("admin_adid"); // 속성 명에 유의! 
				String trainer_trid = resultSet.getString("trainer_trid"); // 속성 명에 유의! 

				System.out.println(" Id = " + dogid); // 테스트 용
				
				DtoDog dto = new DtoDog(dogid, dogname, dogtrainst, dogadoptst, dogdate, dogadoptdate, dogtraincomm, admin_adid, trainer_trid);
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
	
	public DtoDog detail(int dogId) {
		DtoDog dto = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select dogid, dogname, dogtrainst, dogadoptst, dogdate, dogadoptdate, dogtraincomm, admin_adid, trainer_trid from dog where dogid = ?"; // 속성명에 유의! 
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, dogId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int dogid = resultSet.getInt("dogid"); // 속성 명에 유의! 
				String dogname = resultSet.getString("dogname"); // 속성 명에 유의! 
				String dogtrainSt = resultSet.getString("dogtrainst"); // 속성 명에 유의! 
				String dogadoptst = resultSet.getString("dogadoptst"); // 속성 명에 유의! 
				String dogdate = resultSet.getString("dogdate"); // 속성 명에 유의! 
				String dogadoptdate = resultSet.getString("dogadoptdate"); // 속성 명에 유의! 
				String dogtraincomm = resultSet.getString("dogtraincomm"); // 속성 명에 유의! 
				String admin_adid = resultSet.getString("admin_adid"); // 속성 명에 유의! 
				String trainer_trid = resultSet.getString("trainer_trid"); // 속성 명에 유의! 
				
				System.out.println(" Id = " + dogid); // 테스트 용
				
				dto = new DtoDog(dogid, dogname, dogtrainSt, dogadoptst, dogdate, dogadoptdate, dogtraincomm, admin_adid, trainer_trid);
				
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
	
	public void update(int dogId, String dogName, String dogTrainSt, String dogAdoptSt, String dogDate, String dogAdoptDate, String dogTrainComm, String adminID, String trainerID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update dog set dogid = ?, dogname = ?, dogtrainst = ?, dogadoptst = ?, dogdate = ?, dogadoptdate = ?, dogtraincomm = ?, admin_adid = ?, trainer_trid = ? where dogid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, dogId);
			preparedStatement.setString(2, dogName);
			preparedStatement.setString(3, dogTrainSt);
			preparedStatement.setString(4, dogAdoptSt);
			preparedStatement.setString(5, dogDate);
			preparedStatement.setString(6, dogAdoptDate);
			preparedStatement.setString(7, dogTrainComm);
			preparedStatement.setString(8, adminID);
			preparedStatement.setString(9, trainerID);
			preparedStatement.setInt(10, dogId);
			
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
	
	public void delete(int dogId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update dog set dogadoptst = '입양완료', dogadoptdate = now() where dogid = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, dogId);
			
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
	
	public void insert(String dogName, String adminID, String trainerID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into dog (dogname, dogtrainst, dogadoptst, dogdate, admin_adid, trainer_trid) values (?,'훈련중','훈련중',now(),?,?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, dogName);
			preparedStatement.setString(2, adminID);
			preparedStatement.setString(3, trainerID);
			
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

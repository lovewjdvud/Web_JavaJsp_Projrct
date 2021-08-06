package com.watchdogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.watchdogs.dto.BListDto;
import com.watchdogs.dto.BLoginCheckDto;

public class BLoginCheckDao {

	DataSource dataSource;
	
	public BLoginCheckDao() {
		// TODO Auto-generated constructor stub
	
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String logincheck(String inputID, String inputPW) {
		String bPW = "";
		String result = "";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select userpw from user where userid = ?" ;
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, inputID);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				bPW = resultSet.getString("userpw"); 
			}
		
			System.out.println("입력한 비밀번호 = " + inputPW +" 그리고 받은 비밀번호 = " + bPW );	
			
			if(inputPW.equals(bPW)) {
				result = "success";
			}else {
				result = "failure";
			}
			
		} catch (Exception e) {
			System.out.println("에러코드1");
			result = "fail";
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
		return result;
	}
}

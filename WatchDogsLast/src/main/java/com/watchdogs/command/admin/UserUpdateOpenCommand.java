package com.watchdogs.command.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoTrainer;
import com.watchdogs.dao.DaoUser;
import com.watchdogs.dto.DtoTrainer;
import com.watchdogs.dto.DtoUser;

public class UserUpdateOpenCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		DaoUser daoUser = new DaoUser();
		DtoUser dto = daoUser.detail(userId);
		
		request.setAttribute("detail", dto);
	}

}

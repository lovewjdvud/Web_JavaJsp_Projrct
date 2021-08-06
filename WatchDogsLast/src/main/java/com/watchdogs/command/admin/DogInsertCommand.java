package com.watchdogs.command.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoDog;
import com.watchdogs.dao.DaoTrainer;

public class DogInsertCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String dogName = request.getParameter("dogName");
		String adminID = request.getParameter("adminID");
		String trainerID = request.getParameter("trainerID");
		
		DaoDog daoDog = new DaoDog();
		daoDog.insert(dogName, adminID, trainerID);
	}

}
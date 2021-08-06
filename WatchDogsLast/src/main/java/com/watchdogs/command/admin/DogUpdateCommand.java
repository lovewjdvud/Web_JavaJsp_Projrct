package com.watchdogs.command.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoDog;
import com.watchdogs.dao.DaoTrainer;

public class DogUpdateCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int dogId = Integer.parseInt(request.getParameter("dogId"));
		String dogName = request.getParameter("dogName");
		String dogTrainSt = request.getParameter("dogTrainSt");
		String dogAdoptSt = request.getParameter("dogAdoptSt");
		String dogDate = request.getParameter("dogDate");
		String dogAdoptDate = request.getParameter("dogAdoptDate");
		String dogTrainComm = request.getParameter("dogTrainComm");
		String adminID = request.getParameter("adminID");
		String trainerID = request.getParameter("trainerID");
		
		DaoDog daoDog = new DaoDog();
		daoDog.update(dogId, dogName, dogTrainSt, dogAdoptSt, dogDate, dogAdoptDate, dogTrainComm, adminID, trainerID);
	}

}

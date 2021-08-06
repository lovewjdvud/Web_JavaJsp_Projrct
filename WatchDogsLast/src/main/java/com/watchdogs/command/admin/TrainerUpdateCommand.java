package com.watchdogs.command.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoTrainer;

public class TrainerUpdateCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String trId = request.getParameter("trId");
		String trEmail = request.getParameter("trEmail");
		String trTel = request.getParameter("trTel");
		String trName = request.getParameter("trName");
		String trDate = request.getParameter("trDate");
		String trDelDate = request.getParameter("trDelDate");
		String adminID = request.getParameter("adminID");
		
		DaoTrainer daoTrainer = new DaoTrainer();
		daoTrainer.update(trId, trEmail, trTel, trName, trDate, trDelDate, adminID);
	}

}

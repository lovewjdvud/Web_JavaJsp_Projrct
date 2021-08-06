package com.watchdogs.command.login;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.BListDao;
import com.watchdogs.dao.BLoginCheckDao;
import com.watchdogs.dto.BListDto;
import com.watchdogs.dto.BLoginCheckDto;

public class BLoginCheckCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String inputID = request.getParameter("id");
		String inputPW = request.getParameter("pw");
		
		BLoginCheckDao bLCDao = new BLoginCheckDao();
		String result =  bLCDao.logincheck(inputID, inputPW);
		
		System.out.println("result = " + result);
		
		HttpSession hSession = request.getSession(true); // Test2
		hSession.setAttribute("result", result);
	}
}

package com.watchdogs.command.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoDocument;
import com.watchdogs.dao.DaoDog;
import com.watchdogs.dao.DaoTrainer;
import com.watchdogs.dao.DaoUser;
import com.watchdogs.dto.DtoDocument;
import com.watchdogs.dto.DtoDog;
import com.watchdogs.dto.DtoTrainer;
import com.watchdogs.dto.DtoUser;

public class AdminOpenCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// DB에서 전체정보 읽어서 attribute로 jsp에 전달하기

			DaoTrainer daoTrainer = new DaoTrainer();
			ArrayList<DtoTrainer> dtosTrainer = daoTrainer.list();
			
			System.out.println(" Id = " + dtosTrainer); // 테스트 용
			request.setAttribute("listTrainer", dtosTrainer);
			
			DaoDog daoDog = new DaoDog();
			ArrayList<DtoDog> dtosDog = daoDog.list();
			
			System.out.println(" Id = " + dtosDog); // 테스트 용
			request.setAttribute("listDog", dtosDog);
			
			DaoDocument daoDoc = new DaoDocument();
			ArrayList<DtoDocument> dtosDocument = daoDoc.list();
			
			System.out.println(" Id = " + dtosDocument); // 테스트 용
			request.setAttribute("listDocument", dtosDocument);
			
			DaoUser daoUser = new DaoUser();
			ArrayList<DtoUser> dtosUser = daoUser.list();
			
			System.out.println(" Id = " + dtosUser); // 테스트 용
			request.setAttribute("listUser", dtosUser);
			
	}

}

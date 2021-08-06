package com.watchdogs.command.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.dao.DaoDocument;
import com.watchdogs.dao.DaoDog;

public class DocumentUpdateCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int docId = Integer.parseInt(request.getParameter("docId"));
		String docTitle = request.getParameter("docTitle");
		String docContent = request.getParameter("docContent");
		String docType = request.getParameter("docType");
		String docDate = request.getParameter("docDate");
		String docDelDate = request.getParameter("docDelDate");
		String userID = request.getParameter("userID");
		String adminID = request.getParameter("adminID");
		
		DaoDocument daoDocument = new DaoDocument();
		daoDocument.update(docId, docTitle, docContent, docType, docDate, docDelDate, userID, adminID);
	}

}

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.deliverik.infogovernor.kgm.vo.IGKGM02011VO" %>
<%@ page import="com.deliverik.infogovernor.kgm.form.IGKGM0228Form" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%		
		IGKGM02011VO vo = (IGKGM02011VO)request.getAttribute("vo");
		IGKGM0228Form form = (IGKGM0228Form)request.getAttribute("form");
		response.reset();
		response.setContentType("application/vnd.ms-excel");		    
		
		response.setHeader("Content-disposition","attachment;filename="  + new String( "知识信息.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGKGM0228(response.getOutputStream(),vo.getKnowledgeList());
		out.clear();
		pageContext.pushBody();
%>
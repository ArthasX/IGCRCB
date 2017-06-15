<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM03171VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0317Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%		
		IGLOM03171VO vo = (IGLOM03171VO)request.getAttribute("IGLOM03171VO");
		IGLOM0317Form form = (IGLOM0317Form)request.getSession().getAttribute("IGLOM0317Form");
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "预支明细统计报告.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0317(response.getOutputStream(),vo.getAdvanceDetailList(),form.getDate_from(),form.getDate_to());
		out.clear();
		pageContext.pushBody();
		
%>
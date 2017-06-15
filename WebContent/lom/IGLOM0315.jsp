<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM03081VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0308Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%		
		IGLOM03081VO vo = (IGLOM03081VO)request.getAttribute("IGLOM03081VO");
		IGLOM0308Form form = (IGLOM0308Form)request.getSession().getAttribute("IGLOM0308Form");
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "预支人员统计报告.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0308(response.getOutputStream(),vo.getPersonLoanSummaryList(),form.getLpduserorgname(),form.getLpddate_from(),form.getLpddate_to());
		out.clear();
		pageContext.pushBody();
		
%>
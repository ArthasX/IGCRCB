<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM03111VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0311Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%		
		IGLOM03111VO vo = (IGLOM03111VO)request.getAttribute("IGLOM03111VO");
		IGLOM0311Form form = (IGLOM0311Form)request.getSession().getAttribute("IGLOM0311Form");
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "人员借款明细统计报告.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0311(response.getOutputStream(),vo.getPersonLoanDetailList(),form.getUsername(),form.getDate_from(),form.getDate_to());
		out.clear();
		pageContext.pushBody();
		
%>
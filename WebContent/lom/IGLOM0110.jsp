<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM01061VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0106Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%		
		IGLOM01061VO vo = (IGLOM01061VO)request.getAttribute("IGLOM01061VO");
		IGLOM0106Form form = (IGLOM0106Form)request.getSession().getAttribute("IGLOM0106Form");
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "接待月度汇总.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0110(response.getOutputStream(),vo.getRecptionVWList(),form.getYear());
		out.clear();
		pageContext.pushBody();
		
%>
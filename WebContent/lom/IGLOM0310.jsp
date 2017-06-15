<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM0309VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0309Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%		
        IGLOM0309VO vo = (IGLOM0309VO)request.getAttribute("IGLOM0309VO");
        IGLOM0309Form form = (IGLOM0309Form)request.getSession().getAttribute("IGLOM0309Form");
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "预支月度统计报告.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0309(response.getOutputStream(),vo.getSummaryList(),form.getYear());
		out.clear();
		pageContext.pushBody();
		
%>
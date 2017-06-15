<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM04021VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0405Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%
	IGLOM04021VO vo = (IGLOM04021VO)request.getAttribute("IGLOM04021VO");
        IGLOM0405Form form = (IGLOM0405Form)request.getSession().getAttribute("IGLOM0405Form");
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "发票年度统计报告.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0406(response.getOutputStream(),vo.getInvoiceVWList(),form.getIyear());
		out.clear();
		pageContext.pushBody();
%>
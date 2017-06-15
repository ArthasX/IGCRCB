<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM01061VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0117Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>

<%		
		IGLOM01061VO vo = (IGLOM01061VO)request.getAttribute("IGLOM01061VO");
		IGLOM0117Form form = (IGLOM0117Form)request.getSession().getAttribute("IGLOM0117Form");
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "外出就餐月度汇总.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0123(response.getOutputStream(),vo.getDealVWList(),form.getYear());
		out.clear();
		pageContext.pushBody();
		
%>
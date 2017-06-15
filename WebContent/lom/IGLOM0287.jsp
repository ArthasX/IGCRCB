<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM02191VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0219Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%		
	IGLOM02191VO vo = (IGLOM02191VO)request.getAttribute("vo");
	IGLOM0219Form form = (IGLOM0219Form)request.getAttribute("form");
	response.reset();
	response.setContentType("application/vnd.ms-excel");		    
	response.setHeader("Content-disposition","attachment;filename=" + new String("领用调剂统计.xls".getBytes("gb2312"), "ISO8859-1" ));
	ExportExcel.exportLOM0219(response.getOutputStream(),vo.getGoutstockList());
	out.clear();
	pageContext.pushBody();
%>
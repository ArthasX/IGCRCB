<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM02151VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0215Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%		
		IGLOM02151VO vo = (IGLOM02151VO)request.getAttribute("vo");
		IGLOM0215Form form = (IGLOM0215Form)request.getAttribute("form");
		response.reset();
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename=" + new String("出入库汇总.xls".getBytes("gb2312"), "ISO8859-1" ));
		ExportExcel.exportLOM0215(response.getOutputStream(),vo.getGinoutStockDetailVWList(),form.getCategory());
		out.clear();
		pageContext.pushBody();
%>
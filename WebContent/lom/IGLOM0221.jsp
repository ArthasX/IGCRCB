<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM02201VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0220Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%		
		IGLOM02201VO vo = (IGLOM02201VO)request.getAttribute("IGLOM02201VO");
		IGLOM0220Form form = (IGLOM0220Form)request.getSession().getAttribute("IGLOM0220Form");
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "物品类盘存表.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0221(response.getOutputStream(),vo.getInventoryList(),form.getYear(),form.getMonth());
		out.clear();
		pageContext.pushBody();
		
%>
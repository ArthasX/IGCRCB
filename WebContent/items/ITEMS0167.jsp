<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.items.vo.ITEMS01081VO" %>
<%@ page import="com.csebank.items.form.ITEMS0148Form" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%@ page import="java.util.*" %>
<%
	ITEMS01081VO vo = (ITEMS01081VO)request.getAttribute("vo");
	ITEMS0148Form form = (ITEMS0148Form)request.getAttribute("form");
	response.reset();
	response.setContentType("application/vnd.ms-excel");		    
	
	response.setHeader("Content-disposition","attachment;filename="  + new String( "配送包号汇总清单.xls".getBytes("gb2312"), "ISO8859-1" ) );
	ExportExcel.exportITEMS0167(response.getOutputStream(),vo.getOutmap(),form.getOuttime_f(),form.getOuttime_t());
	out.clear();
	pageContext.pushBody();
%>
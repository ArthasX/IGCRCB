<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.items.vo.ITEMS01011VO" %>
<%@ page import="com.csebank.items.form.ITEMS0136Form" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%@ page import="java.util.*" %>
<%
	ITEMS01011VO vo = (ITEMS01011VO)request.getAttribute("vo");
	ITEMS0136Form form = (ITEMS0136Form)request.getAttribute("form");
	response.reset();
	response.setContentType("application/vnd.ms-excel");		    
	
	response.setHeader("Content-disposition","attachment;filename="  + new String( "支行结账清单明细.xls".getBytes("gb2312"), "ISO8859-1" ) );
	ExportExcel.exportITEMS0138(response.getOutputStream(),vo.getOutStockList(),form.getOuttime_f(),form.getOuttime_t(),form.getReqorg());
	out.clear();
	pageContext.pushBody();
%>
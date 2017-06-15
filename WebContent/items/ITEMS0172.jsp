<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.items.vo.ITEMS01711VO" %>
<%@ page import="com.csebank.items.form.ITEMS0171Form" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%@ page import="java.util.*" %>
<%
	ITEMS01711VO vo = (ITEMS01711VO)request.getAttribute("ITEMS01711VO");
	ITEMS0171Form form = (ITEMS0171Form)request.getSession().getAttribute("ITEMS0171Form");
	response.reset();
	response.setContentType("application/vnd.ms-excel");		    
	
	response.setHeader("Content-disposition","attachment;filename="  + new String( "单一物品收益明细.xls".getBytes("gb2312"), "ISO8859-1" ) );
	ExportExcel.exportITEMS0171(response.getOutputStream(),vo,form);
	out.clear();
	pageContext.pushBody();
%>
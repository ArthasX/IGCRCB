<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.items.vo.ITEMS01691VO" %>
<%@ page import="com.csebank.items.form.ITEMS0169Form" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%@ page import="java.util.*" %>
<%
	ITEMS01691VO vo = (ITEMS01691VO)request.getAttribute("ITEMS01691VO");
	ITEMS0169Form form = (ITEMS0169Form)request.getSession().getAttribute("ITEMS0169Form");
	response.reset();
	response.setContentType("application/vnd.ms-excel");		    
	
	response.setHeader("Content-disposition","attachment;filename="  + new String( "仓库收益情况.xls".getBytes("gb2312"), "ISO8859-1" ) );
	ExportExcel.exportITEMS0169(response.getOutputStream(),vo,form.getOuttime_f(),form.getOuttime_t());
	out.clear();
	pageContext.pushBody();
%>
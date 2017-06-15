<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM05141VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0514Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%@ page import="java.util.*" %>
<%

		IGLOM05141VO vo = (IGLOM05141VO)request.getAttribute("IGLOM05141VO");
		IGLOM0514Form form = (IGLOM0514Form)request.getAttribute("form");
		response.reset();
		response.setContentType("application/vnd.ms-excel");		    
	    //Stock  category
		response.setHeader("Content-disposition","attachment;filename="  + new String( "物品库存月统计.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0514(response.getOutputStream(),vo,form.getYear(),form.getMonth());  
		out.clear();
		pageContext.pushBody();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM05081VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0508Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%@ page import="java.util.*" %>
<%

		IGLOM05081VO vo = (IGLOM05081VO)request.getAttribute("IGLOM05081VO");
		IGLOM0508Form form = (IGLOM0508Form)request.getAttribute("form");
		response.reset();
		response.setContentType("application/vnd.ms-excel");		    
	    //Stock  category
		response.setHeader("Content-disposition","attachment;filename="  + new String( "招待费用统计.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0508(response.getOutputStream(),vo.getEentertainmentStatisticsList(),form.getEtime_from(),form.getEtime_to());  
		out.clear();
		pageContext.pushBody();
%>
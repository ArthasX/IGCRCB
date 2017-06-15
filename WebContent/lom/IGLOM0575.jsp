<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM05071VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0507Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%@ page import="java.util.*" %>
<%

		IGLOM05071VO vo = (IGLOM05071VO)request.getAttribute("IGLOM05071VO");
		IGLOM0507Form form = (IGLOM0507Form)request.getAttribute("form");
		response.reset();
		response.setContentType("application/vnd.ms-excel");		    
	    //Stock  category
		response.setHeader("Content-disposition","attachment;filename="  + new String( "招待费用明细.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0507(response.getOutputStream(),vo.getEentertainmentList(),form.getEetime_from(),form.getEetime_to());  
		out.clear();
		pageContext.pushBody();
%>
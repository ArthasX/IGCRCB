<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM02141VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0214Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%@ page import="java.util.*" %>
<%

		IGLOM02141VO vo = (IGLOM02141VO)request.getAttribute("vo");
		IGLOM0214Form form = (IGLOM0214Form)request.getAttribute("form");
		response.reset();
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "库存统计.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0214(response.getOutputStream(),vo.getGstockList(),form.getGscategory());  
		out.clear();      
		pageContext.pushBody();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.deliverik.infogovernor.syslog.vo.IGLOG0102VO" %>
<%@ page import="com.deliverik.infogovernor.syslog.form.IGLOG0102Form" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%		
		IGLOG0102VO vo = (IGLOG0102VO)request.getAttribute("vo");
		IGLOG0102Form form = (IGLOG0102Form)request.getAttribute("form");
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "历史设备日志.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOG0105(response.getOutputStream(),vo.getHistorySysLogList(),form.getExceltitle());
		out.clear();
		pageContext.pushBody();
		
%>
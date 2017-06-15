<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.deliverik.infogovernor.syslog.vo.IGLOG0101VO" %>
<%@ page import="com.deliverik.infogovernor.syslog.form.IGLOG0101Form" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%		
		IGLOG0101VO vo = (IGLOG0101VO)request.getAttribute("vo");
		IGLOG0101Form form = (IGLOG0101Form)request.getAttribute("form");
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "设备日志.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOG0103(response.getOutputStream(),vo.getSysLogList(),form.getExceltitle());
		out.clear();
		pageContext.pushBody();
		
%>
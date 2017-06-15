
<%@page import="com.deliverik.infogovernor.excel.ExportExcel"%><%@page import="com.deliverik.infogovernor.soc.mnt.model.SOC0301Info"%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<%@ page import="org.apache.struts.Globals;"%>
<%
	Locale loc = Locale.getDefault();
	if (request.getSession().getAttribute(Globals.LOCALE_KEY) != null) {
		loc = (Locale) request.getSession().getAttribute(
				Globals.LOCALE_KEY);
	}

	Map<String, List<SOC0301Info>> dataMap  = (Map<String, List<SOC0301Info>>)request.getAttribute("dataMap");
	response.reset();
	response.setContentType("application/vnd.ms-excel");		    
	if(loc.getLanguage().equalsIgnoreCase("en")) {
		response.setHeader("Content-disposition","attachment;filename=DMXRealTime.xls");
	}else{
		response.setHeader("Content-disposition","attachment;filename="  + new String( "DMX实时性能监控.xls".getBytes("gb2312"), "ISO8859-1" ) );
	}
	ExportExcel.exportIGMNT0108(response.getOutputStream(),dataMap);
	out.clear();
	pageContext.pushBody();
%>
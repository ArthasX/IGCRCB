
<%@page import="com.deliverik.infogovernor.excel.ExportExcel"%>

<%@page import="com.deliverik.infogovernor.soc.cim.vo.IGCIM03021VO"%>
<%@page import="com.deliverik.infogovernor.soc.cim.form.IGCIM0302Form"%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

	IGCIM03021VO vo = (IGCIM03021VO)request.getAttribute("vo");
	IGCIM0302Form form = (IGCIM0302Form)request.getAttribute("form");
	response.reset();
	response.setContentType("application/vnd.ms-excel");		    
	if(loc.getLanguage().equalsIgnoreCase("en")) {
		response.setHeader("Content-disposition","attachment;filename=AuditResult.xls");
	}else{
		response.setHeader("Content-disposition","attachment;filename="  + new String( "审计对比结果.xls".getBytes("gb2312"), "ISO8859-1" ) );
	}
	ExportExcel.exportIGCIM0302Action(response.getOutputStream(),vo.getSOC0137List(),form.getAutime_from(),form.getAutime_to(),form.getAutdesc());
	out.clear();
	pageContext.pushBody();
%>
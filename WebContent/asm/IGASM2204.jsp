<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.deliverik.infogovernor.asset.vo.IGASM22021VO" %>
<%@ page import="com.deliverik.infogovernor.asset.form.IGASM2202Form" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.struts.Globals;"%>
<%
	Locale loc = Locale.getDefault();
	if (request.getSession().getAttribute(Globals.LOCALE_KEY) != null) {
		loc = (Locale) request.getSession().getAttribute(
				Globals.LOCALE_KEY);
	}

	IGASM22021VO vo = (IGASM22021VO)request.getAttribute("vo");
	IGASM2202Form form = (IGASM2202Form)request.getAttribute("form");
	response.reset();
	response.setContentType("application/vnd.ms-excel");		    
	if(loc.getLanguage().equalsIgnoreCase("en")) {
		response.setHeader("Content-disposition","attachment;filename=CiditResult.xls");
	}else{
		response.setHeader("Content-disposition","attachment;filename="  + new String( "CI更新对比结果.xls".getBytes("gb2312"), "ISO8859-1" ) );
	}
	ExportExcel.exportIGASM2202(response.getOutputStream(),vo.getCiResultList(),form.getCitime_from(),form.getCitime_to(),form.getCitdesc(),form.getEname());
	out.clear();
	pageContext.pushBody();
%>
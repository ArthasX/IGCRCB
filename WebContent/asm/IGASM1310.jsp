<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.deliverik.infogovernor.asset.vo.IGASM13031VO" %>
<%@ page import="com.deliverik.infogovernor.asset.form.IGASM1303Form" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%		
        IGASM13031VO vo = (IGASM13031VO)request.getAttribute("vo");
        IGASM1303Form form = (IGASM1303Form)request.getAttribute("form");
		response.reset();
		//eiorgsyscoding_qname  ciupdtime_from  ciupdtime_to
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "新进设备分布统计.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGASM1310(response.getOutputStream(),vo.getEquDistributingCountList(),form.getOrgname(),form.getCiupdtime_from(),form.getCiupdtime_to());
		out.clear();
		pageContext.pushBody();
		
%>
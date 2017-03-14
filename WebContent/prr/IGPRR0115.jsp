<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.deliverik.infogovernor.prr.vo.IGPRR01021VO" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%		
		IGPRR01021VO vo = (IGPRR01021VO)request.getAttribute("vo");
		response.reset();
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "日志信息.xls".getBytes("gb2312"), "ISO8859-1" ) );
		
		ExportExcel.exportIGPRR0115(response.getOutputStream(),vo.getRecordLogList(),vo.getProcess(),vo.getDealtime(),vo.getProcessInfoDefmap());
		out.clear();
		pageContext.pushBody();
%>
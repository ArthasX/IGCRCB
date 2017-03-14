<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.deliverik.infogovernor.risk.vo.IGRIS01171VO" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%		
        IGRIS01171VO vo = (IGRIS01171VO)request.getAttribute("IGRIS01171VO");
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "审计报告.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGRIS0120(response.getOutputStream(),vo);
		out.clear();
		pageContext.pushBody();
		
%>
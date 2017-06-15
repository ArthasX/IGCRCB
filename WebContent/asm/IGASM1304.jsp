<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.deliverik.infogovernor.asset.vo.IGASM13011VO" %>
<%@ page import="com.deliverik.infogovernor.asset.form.IGASM1301Form" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%		
        IGASM13011VO vo = (IGASM13011VO)request.getAttribute("vo");
		IGASM1301Form form = (IGASM1301Form)request.getAttribute("form");
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "设备存量统计.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGASM1304(response.getOutputStream(),vo.getEntityCountList(),form.getOrgname(),form.getOrgType());
		out.clear();
		pageContext.pushBody();
		
%>
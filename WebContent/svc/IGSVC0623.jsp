<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.deliverik.infogovernor.svc.vo.IGSVC05131VO" %>
<%@ page import="com.deliverik.infogovernor.svc.form.IGSVC0602Form" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%		

		IGSVC05131VO vo = (IGSVC05131VO)request.getAttribute("igsvc05131vo");
		IGSVC0602Form form = (IGSVC0602Form)request.getSession().getAttribute("IGSVC0602Form");
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "人员工作报告.xls".getBytes("gb2312"), "ISO8859-1" ) );			
		ExportExcel.exportIGSVC0623(response.getOutputStream(),vo.getUserProcessCountList(),form.getPropentime_from(),form.getPropentime_to(),form.getOrgName());
		out.clear();
		pageContext.pushBody(); 

		
%>
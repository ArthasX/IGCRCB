<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM05051VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0505Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%@ page import="java.util.*" %>
<%

		IGLOM05051VO vo = (IGLOM05051VO)request.getAttribute("IGLOM05051VO");
		IGLOM0505Form form = (IGLOM0505Form)request.getAttribute("form");
		response.reset();
		response.setContentType("application/vnd.ms-excel");		    
	    //Stock  category
		
		if("D".equals(request.getParameter("searchtype"))){
			response.setHeader("Content-disposition","attachment;filename="  + new String( "工作餐收益月明细统计.xls".getBytes("gb2312"), "ISO8859-1" ) );
			ExportExcel.exportIGLOM0585(response.getOutputStream(),vo.getWorkLunchEateryList(),form.getYearD(),form.getMonthD());
		}else{
			response.setHeader("Content-disposition","attachment;filename="  + new String( "工作餐收益统计.xls".getBytes("gb2312"), "ISO8859-1" ) );
			ExportExcel.exportIGLOM0505(response.getOutputStream(),vo,form.getYear(),form.getMonth(),form.getQuarter());
		}
	      
		out.clear();
		pageContext.pushBody();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM05091VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0509Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%@ page import="java.util.*" %>
<%

		IGLOM05091VO vo = (IGLOM05091VO)request.getAttribute("IGLOM05091VO");
		IGLOM0509Form form = (IGLOM0509Form)request.getAttribute("form");
		response.reset();
		response.setContentType("application/vnd.ms-excel");		    
	    //Stock  category
		response.setHeader("Content-disposition","attachment;filename="  + new String( "部门招待统计.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0509(response.getOutputStream(),vo.getDeptEentertainmentList(),form.getEtime_from(),form.getEtime_to());  
		out.clear();
		pageContext.pushBody();
%>
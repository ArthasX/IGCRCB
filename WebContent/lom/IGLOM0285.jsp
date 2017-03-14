<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM02171VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0217Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%		
	IGLOM02171VO vo = (IGLOM02171VO)request.getAttribute("vo");
	IGLOM0217Form form = (IGLOM0217Form)request.getAttribute("form");
	response.reset();
	response.setContentType("application/vnd.ms-excel");		    
	response.setHeader("Content-disposition","attachment;filename=" + new String("机构领用统计.xls".getBytes("gb2312"), "ISO8859-1" ));
	ExportExcel.exportLOM0217(response.getOutputStream(),vo.getGoutstockList(),form.getGoorgname(),form.getGotime_f(),form.getGotime_t());
	out.clear();
	pageContext.pushBody();
%>
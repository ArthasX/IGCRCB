<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM01081VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0120Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%		
		IGLOM01081VO vo = (IGLOM01081VO)request.getAttribute("IGLOM01081VO");
		IGLOM0120Form form = (IGLOM0120Form)request.getSession().getAttribute("IGLOM0120Form");
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "部门外出就餐汇总.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0124(response.getOutputStream(),vo.getDealOrgVWList(),form.getYear(),form.getMonth_from(),form.getMonth_to(),form.getDeptName());
		out.clear();
		//String ss=form.getDeptName();
		pageContext.pushBody();
		
%>
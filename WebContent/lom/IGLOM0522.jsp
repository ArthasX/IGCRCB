<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM01081VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0520Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%		
		IGLOM01081VO vo = (IGLOM01081VO)request.getAttribute("IGLOM01081VO");
		IGLOM0520Form form = (IGLOM0520Form)request.getSession().getAttribute("IGLOM0520Form");
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "部门招待汇总.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0522(response.getOutputStream(),vo.getEeOrgVWList(),form.getYear(),form.getMonth_from(),form.getMonth_to(),form.getRapporgname());
		out.clear();
		//String ss=form.getDeptName();
		pageContext.pushBody();
		
%>
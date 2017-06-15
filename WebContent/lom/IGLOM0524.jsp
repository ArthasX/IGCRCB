<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM05081VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0513Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%		
        IGLOM05081VO vo = (IGLOM05081VO)request.getAttribute("IGLOM05081VO");
		IGLOM0513Form form = (IGLOM0513Form)request.getSession().getAttribute("IGLOM0513Form");
		response.reset();
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "食堂物品消耗明细.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0524(response.getOutputStream(),vo.getGoutDetailInfoList(),form.getYear(),form.getMonth_from(),form.getMonth_to(),form.getGuser());
		out.clear();
		pageContext.pushBody();
		
%>
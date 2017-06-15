<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM02161VO" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%		
		IGLOM02161VO vo = (IGLOM02161VO)request.getAttribute("vo");
		//IGLOM0216Form form = (IGLOM0216Form)request.getAttribute("form");
		response.reset();
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename=" + new String("单一物品出入库明细.xls".getBytes("gb2312"), "ISO8859-1" ));
		ExportExcel.exportLOM0216(response.getOutputStream(),vo.getGiostockdetailList(),vo.getGname(),vo.getTotalStockNum());
		out.clear();
		pageContext.pushBody();
%>
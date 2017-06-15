<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM02181VO" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%		
		IGLOM02181VO vo = (IGLOM02181VO)request.getAttribute("vo");
		response.reset();
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename=" + new String("物品出入库明细.xls".getBytes("gb2312"), "ISO8859-1" ));
		ExportExcel.exportLOM0218(response.getOutputStream(),vo.getGiostockdetailList());
		out.clear();
		pageContext.pushBody();
%>
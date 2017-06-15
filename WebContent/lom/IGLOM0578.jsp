<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM05151VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0515Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%@ page import="java.util.*" %>
<%

		IGLOM05151VO vo = (IGLOM05151VO)request.getAttribute("IGLOM05151VO");
		IGLOM0515Form form = (IGLOM0515Form)request.getAttribute("form");
		String goods = String.valueOf(request.getAttribute("goods"));
		response.reset();
		response.setContentType("application/vnd.ms-excel");		    
	    //Stock  category
		response.setHeader("Content-disposition","attachment;filename="  + new String( "单一物品库存汇总统计.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportIGLOM0515(response.getOutputStream(),vo.getSingleGoodsStockList(),form.getEtime_from(),form.getEtime_to(),goods);
		out.clear();
		pageContext.pushBody();
%>
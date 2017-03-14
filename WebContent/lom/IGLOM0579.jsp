<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.lom.vo.IGLOM05141VO" %>
<%@ page import="com.csebank.lom.form.IGLOM0514Form" %>
<%@ page import="com.csebank.lom.excel.ExportExcel" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%

		IGLOM05141VO vo = (IGLOM05141VO)request.getAttribute("IGLOM05141VO");
		IGLOM0514Form form = (IGLOM0514Form)request.getAttribute("form");
		String name = String.valueOf(request.getAttribute("name"));
		response.reset();
		response.setContentType("application/vnd.ms-excel"); 
	    //Stock  category
		response.setHeader("Content-disposition","attachment;filename="  + new String( "库存月明细统计.xls".getBytes("gb2312"), "ISO8859-1" ) );
		if(StringUtils.isNotEmpty(form.getFlag())){
			ExportExcel.exportIGLOM0518(response.getOutputStream(),vo.getGoodsStockList(),form.getYear(),form.getMonth(), name);
		}else{
	   		ExportExcel.exportIGLOM0517(response.getOutputStream(),vo.getGoodsStockList(),form.getYear(),form.getMonth(), name);
		}
		out.clear();
		pageContext.pushBody();
%>
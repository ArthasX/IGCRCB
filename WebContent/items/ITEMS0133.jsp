<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.items.vo.ITEMS01011VO" %>
<%@ page import="com.csebank.items.form.ITEMS0130Form" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%@ page import="java.util.*" %>
<%

		ITEMS01011VO vo = (ITEMS01011VO)request.getAttribute("vo");
  		ITEMS0130Form form = (ITEMS0130Form)request.getAttribute("form");
  		List chknumList = (List)request.getAttribute("chknumList");
		response.reset();
		response.setContentType("application/vnd.ms-excel");		    
	    //Stock  category
		response.setHeader("Content-disposition","attachment;filename="  + new String( "库存统计.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportITEMS0133(response.getOutputStream(),vo.getStockList(),chknumList,form.getStockorg_qname(),form.getCategory(),form.getSeqcode_q(),form.getItemsname_q());  
		out.clear();      
		pageContext.pushBody();
%>
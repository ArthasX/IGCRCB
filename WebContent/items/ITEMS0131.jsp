<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.csebank.items.vo.ITEMS01011VO" %>
<%@ page import="com.csebank.items.form.ITEMS0128Form" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%		
        ITEMS01011VO vo = (ITEMS01011VO)request.getAttribute("vo");
        ITEMS0128Form form = (ITEMS0128Form)request.getAttribute("form");
		response.reset();
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( "入库统计.xls".getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportITEMS0131(response.getOutputStream(),vo.getInStockList(),
				form.getIntime_f(),form.getIntime_t(),form.getInstockorg_name(),form.getSeqcode_q(),form.getItemsname_q());
		out.clear();
		pageContext.pushBody();
%>
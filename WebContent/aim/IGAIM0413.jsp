<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.deliverik.infogovernor.soc.cim.vo.IGCIM04011VO" %>
<%@ page import="com.deliverik.framework.soc.asset.model.SOC0117Info" %>
<%@ page import="com.deliverik.infogovernor.excel.ExportExcel" %>
<%@ page import="java.util.List" %>
<%		
		IGCIM04011VO vo = (IGCIM04011VO)request.getAttribute("IGCIM04011VO");
		List<SOC0117Info> list = vo.getTopEntityList();
		response.reset();
		
		response.setContentType("application/vnd.ms-excel");		    
		response.setHeader("Content-disposition","attachment;filename="  + new String( (list.get(0).getEname()+".xls").getBytes("gb2312"), "ISO8859-1" ) );
		ExportExcel.exportExcel_SOC(response.getOutputStream(),vo.getTopEntityList(),vo.getOrglist(),vo.getConfigurationMapList(),vo.getCcdList(),vo.getUserlist());
		out.clear();
		pageContext.pushBody();
		
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGFIN0203" toScope="request" />
<bean:define id="title" value="费用预算详细显示画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">



</script>


<body style="background-image: none;background-color: #FFFFFF;">


<!--content  内容-->
   
   
   <div id="location">
	<div class="image"></div>
	<p class="fonts1">查看</p>
	<div class="back"><a href="IGFIN0202_BACK.do" target="_self">返回</a></div>
	</div>
	<div class="title">
	<div class="name">基本信息</div>
	</div>

	<div class="record_list">
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="16%" height="20">
			<div align="right"><strong>预算编号：</strong></div>			</td>
			<td width="23%">${IGFIN01021VO.budgetData.bid}</td>
			<td width="13%">
			<div align="right"><strong>预算类型：</strong></div>			</td>
			<td width="48%">${IGFIN01021VO.budgetData.btype}</td>
			
		</tr>
		<tr>
			<td height="20">
			<div align="right"><strong>预算名称：</strong></div>			</td>
			<td>${IGFIN01021VO.budgetData.btitle}</td>
			<td>
			<div align="right"><strong>费用名称：</strong></div>			</td>
			<td>${IGFIN01021VO.budgetData.pname}</td>
		</tr>
		<tr>
			<td height="20">
			<div align="right"><strong>开始时间：</strong></div>			</td>
			<td>${IGFIN01021VO.budgetData.bopentime}</td>
			<td>
			<div align="right"><strong>结束时间：</strong></div>			</td>
			<td>${IGFIN01021VO.budgetData.bclosetime}</td>
		</tr>
		<tr>
		  <td height="20"><div align="right"><strong>预算年度：</strong></div></td>
		  <td>${IGFIN01021VO.budgetData.byear}</td>
		  <td><div align="right"><strong>预算金额：</strong></div></td>
		  <td>${IGFIN01021VO.budgetData.bamount}</td>
		</tr>
		<tr>
		  <td height="20"><div align="right"><strong>预算说明：</strong></div></td>
		  <td><pre>${IGFIN01021VO.budgetData.bdesc}</pre></td>
		</tr>
	</table>
	</div>

<div class="title">
	<div class="name"></div>
	</div>
	<div class="record_list">
         <div class="action">
             <img src="images/delete_16x16.gif" width="16" height="16" /><a href="IGFIN0204_Disp.do?id=${IGFIN01021VO.budgetData.bid}">关闭</a></div>
          <div class="action">
             <img src="images/close.gif" width="16" height="16" /><a href="IGFIN0205_Disp.do?id=${IGFIN01021VO.budgetData.bid}">删除</a></div>
      </div>
  
   

</body>
</html:html>
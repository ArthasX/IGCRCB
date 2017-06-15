<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGFIN0304" toScope="request" />
<bean:define id="title" value="查看页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<body>

<!--content  右侧内容-->

	<div class="title">
	<div class="name">基本信息</div>
	</div>
	<bean:define id="bean1" name="IGFIN01021VO" property="budgetData" type="com.deliverik.infogovernor.fin.model.Budget"></bean:define>
	<div class="record_list">
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="8%">
			预算编号：
			</th>
			<td width="42%">${IGFIN01021VO.budgetData.bid}</td>
			<th width="8%">
			预算类型：
			</th>
			<td width="42%">
			<ig:codeValue ccid="BUDGET_TYPE_CATEGORY_CODE" cid= "${IGFIN01021VO.budgetData.btype}" isChild="true"/>
			</td>
		</tr>
		<tr>
			<th>
			预算名称：
			</th>
			<td>${IGFIN01021VO.budgetData.btitle}</td>
			<th>
			项目名称：
			</th>
			<td>${IGFIN01021VO.budgetData.pname}</td>
		</tr>
		<tr>
			<th>
			开始时间：
			</th>
			<td>${IGFIN01021VO.budgetData.bopentime}</td>
			<th>
			结束时间：
			</th>
			<td>${IGFIN01021VO.budgetData.bclosetime}</td>
		</tr>
		<tr>
		  <th>
			预算年度：
			</th>
		  <td>${IGFIN01021VO.budgetData.byear}</td>
		  <th>
			预算金额：
			</th>
		  <td>
		  	<bean:write name="bean1" property="bamount" format="##.##"/>
		  </td>
		</tr>
		<tr>
		  <th>
			预算说明：
			</th>
		  <td colspan="3"><pre>${IGFIN01021VO.budgetData.bdesc}</pre></td>
		</tr>
	</table>
	</div>

<div class="title">
	<div class="name"></div>
	</div>
	<div style="margin-top:50px;" align="center">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>






</body>
</html:html>

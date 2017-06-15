<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGFIN0306" toScope="request" />
<bean:define id="title" value="查看页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<body>

<!--content  右侧内容-->

	<div class="title">
	<div class="name">基本信息</div>
	</div>
	<bean:define id="bean1" name="IGFIN02013VO" property="expenseData" type="com.deliverik.infogovernor.fin.model.Expense"></bean:define>
	<div class="record_list">
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="8%">
			费用编号：
			</th>
			<td width="42%">${IGFIN02013VO.expenseData.exid}</td>
			<th width="8%">
			费用金额：
			</th>
			<td width="42%">
				<bean:write name="bean1" property="examount" format="##.##"/>
			</td>
			
		</tr>
		<tr>
			<th>
			预算名称：
			</th>
			<td>${IGFIN02013VO.expenseData.btitle}</td>
			<th>
			费用名称：
			</th>
			<td>${IGFIN02013VO.expenseData.exapvname}</td>
			
		</tr>
		<tr>
			<th>
			发生时间：
			</th>
			<td>${IGFIN02013VO.expenseData.exopentime}</td>
			<th>
			登记时间：
			</th>
			<td>${IGFIN02013VO.expenseData.exclosetime}</td>
		</tr>
		<tr>
			<th>
			费用说明：
			</th>
			<td colspan="3"><pre>${IGFIN02013VO.expenseData.exdesc}</pre></td>
		 
		</tr>
		<tr>
			
		  <th>
			附件：
		  </th>
		  <td colspan="3">
				<logic:present name="IGFIN02014VO" property="attachmentDataList">
				<logic:iterate id="bean" name="IGFIN02014VO"
					property="attachmentDataList" indexId="index">
					<!-- 附件 -->
					<logic:empty name="bean"
					property="attname">&nbsp;</logic:empty>
					<a href="downloadFinFile.do?attId=${bean.attid}&type=fin">
					<bean:define id="attname" name="bean" property="attname" />
					<%=String.valueOf(attname).substring(String.valueOf(attname).indexOf("_")+1) %>
					&nbsp;&nbsp;&nbsp;&nbsp;
					</a>
				</logic:iterate>
				
				</logic:present>
		  </td>
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

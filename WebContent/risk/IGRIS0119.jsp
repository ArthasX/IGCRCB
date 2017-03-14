<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%
	String contextPath = request.getContextPath();
%>
<html:html>
<bean:define id="id" value="IGGIS0119" toScope="request" />
<bean:define id="title" value="风险检查详细信息" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">
var gid='IGGIS0204';


</script>
<body>
<div id="maincontent">
   <div id="location">
	<div class="image"></div>
	<p class="fonts1">查看</p>
	</div>
	<div class="title">
	<div class="name">基本信息</div>
	</div>

	<div class="record_list">
	<bean:define id="bean" name="IGRIS01151VO" property="riskCheck" ></bean:define>
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="8%" align="right">
			检查项名称：
			</th>
			<td width="42%">${bean.rcname}</td>
			<th width="8%" align="right">
			开始日期：
			</th>
			<td width="42%">${bean.rcstartdate}</td>
			
		</tr>
		<tr>
			<th align="right">
			结束日期：
			</th>
			<td>${bean.rcenddate}</td>
			<th align="right">
			频率：
			</th>
			<td>${IGRIS01151VO.cronInfo}</td>
			
		</tr>
		<tr>
			<th align="right">
			责任组：
			</th>
			<td>${bean.rcrolename}</td>
			<th align="right">
			责任人：
			</th>
			<td>${bean.rcusername}</td>
		</tr>
		
		<tr>
			<th align="right">
			相关资产：
			</th>
			<td colspan="3">
				<a href="javascript:void(0)" onclick="openSubIGCOM0303('${bean.rcasset}','')">
					${bean.rcassetname}
				</a>
			</td>
			
		</tr>
		
		<tr>
			<th align="right">
			说明：
			</th>
			<td colspan="3">${bean.rcdesc}</td>

		</tr>
		
		
		<tr>
		  <th align="right">
			附件：
			</th>
		  <td colspan="3">
				<logic:present name="IGRIS01151VO" property="attachmentList">
				<logic:iterate id="bean" name="IGRIS01151VO"
					property="attachmentList" indexId="index">
					<!-- 附件 -->
					<logic:empty name="bean"
					property="attname">&nbsp;</logic:empty>
					<a href="<%=contextPath %>/downloadFinFile.do?attId=${bean.attid}&type=risk">
					<bean:define id="attname" name="bean" property="attname" />
					<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
					&nbsp;&nbsp;&nbsp;&nbsp;
					</a>
				</logic:iterate>
				
				</logic:present>
		  </td>
		  </tr>
		  
	</table>
	</div>
	<div class="enter">
        <input type="button" name="btn_close" value="关闭" onclick="window.close()" class="button">
	</div>
   </div>
</body>
</html:html>
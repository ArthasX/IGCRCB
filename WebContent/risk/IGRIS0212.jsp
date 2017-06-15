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
<bean:define id="id" value="IGRIS0212" toScope="request" />
<bean:define id="title" value="检查报告详细显示画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">
var gid='IGGIS0212';


</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">

<!--content  右侧内容-->
   <div id="contentWrap">
   <div id="content">
   <div id="location">
	<div class="image"></div>
	<p class="fonts1">查看</p>
	<div class="back">
	<logic:equal value="1" name="IGRIS02011VO" property="mode">
		<a href="IGRIS0205_Supervise_Back.do" target="_self">返回</a>
	</logic:equal>
	<logic:notEqual value="1" name="IGRIS02011VO" property="mode">
		<a href="IGRIS0205_Back.do" target="_self">返回</a>
	</logic:notEqual>
	</div>
	</div>
	<div class="title">
	<div class="name">基本信息</div>
	</div>

	<div class="record_list">
	<bean:define id="bean1" name="IGRIS02011VO" property="riskCheckResult" ></bean:define>
	<bean:define id="bean" name="bean1" property="riskCheck" ></bean:define>
		<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%" align="right">
			检查项名称：
			</th>
			<td width="35%">${bean.rcname}</td>
			
			<th align="right">检查项类型：</th>
			<td><ig:codeValue ccid="RISKCHECK_CLASS_CODE" cid="${bean.rcclass}" /></td>
		</tr>
		<tr>
			<th align="right">检查方法：</th>
			<td><pre>${bean.rccommon}</pre></td>
			<th align="right"></th>
			<td></td>
		</tr>
		<tr>			
			<th width="15%" align="right">
			策略开始时间：
			</th>
			<td width="35%">${bean.rcstartdate}</td>
			<th align="right">
			策略结束时间：
			</th>
			<td>${bean.rcenddate}</td>
		</tr>
		<tr>
			<th width="15%" align="right">
			登记时间：
			</th>
			<td width="35%">${bean.rccreatetime}</td>
			<th align="right">
			重要程度：
			</th>
			<td><ig:codeValue ccid="RISKCHECK_TYPE_CODE" cid="${bean.rctype}" /></td>
		</tr>
		<tr>
			<th align="right">
			检查方式：
			</th>
			<td>
			<c:if test="${bean.rcrtestmode=='1'}" >内部常规</c:if> 
			<c:if test="${bean.rcrtestmode=='2'}" >等级保护</c:if> 
			<c:if test="${bean.rcrtestmode=='3'}" >专项</c:if> 
			</td>
			<th align="right">
			频率：
			</th>
			<td>
				<c:if test="${bean.rcfrequency=='once'}" >立即发起</c:if>
				<c:if test="${bean.rcfrequency=='day'}" >每日</c:if>
				<c:if test="${bean.rcfrequency=='week'}" >每周</c:if>
				<c:if test="${bean.rcfrequency=='month'}" >每月</c:if>
				<c:if test="${bean.rcfrequency=='quarter'}" >每季度</c:if> 
				<c:if test="${bean.rcfrequency=='halfyear'}" >每半年</c:if>
				<c:if test="${bean.rcfrequency=='year'}" >每年</c:if>
			</td>
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
			合作执行组：
			</th>
			<td>${bean.cog}</td>
			<th align="right">合作执行人：</th>
			<td><pre>${bean.ciiop}</pre></td>
		</tr>
		
		<tr>
			<th align="right">
			处理人：
			</th>
			<td>${bean1.rcrusername}</td>
			<th align="right">
			检查结果：
			</th>
			<td>
				<c:if test="${bean1.rcrresult=='A'}" >正常</c:if>
				<c:if test="${bean1.rcrresult=='B'}" >存在问题</c:if>
				<c:if test="${bean1.rcrresult=='C'}" >存在重大问题</c:if>
			</td>
						
		</tr>
		<!-- 工作执行期限(小时)：暂时不需要
			 执行时间：暂时不需要
		<tr>
			<th align="right">
			工作执行期限(小时)：
			</th>
			<td>
				${bean.wtip}
			</td>
			<th align="right">
			执行时间：
			</th>
			<td>${bean1.rcrrealtime}</td>
		</tr>
		 -->
		
		<tr>
			<th align="right">
			说明：
			</th>
			<td colspan="3">${bean1.rcrcomment}</td>
		</tr>

		<tr>
			<th align="right">附件：</th>
			<td colspan="3">
				<logic:present name="IGRIS02011VO" property="attachmentDataList">
				<logic:iterate id="bean" name="IGRIS02011VO"
					property="attachmentDataList" indexId="index">
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
   </div>
   </div>  
  </div>
</div>
</body>
</html:html>
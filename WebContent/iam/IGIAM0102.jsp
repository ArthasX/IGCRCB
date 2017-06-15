<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGIAM0102" toScope="request" />
<bean:define id="title" value="内审项目查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--sidebar  左菜单--> 
<div id="contentWrap">
<div id="content">
	
<div id="location">
<div class="image"></div>
<c:if test="${jump==0}">
<p class="fonts1">审计管理 &gt;&gt; 内审项目管理 &gt;&gt; 内审项目管理 &gt;&gt; 内审项目查询</p>
<div class="back">
	<a href="IGIAM0102_Back.do" target="_self">返回</a>
</div>
</c:if>
<c:if test="${jump==1}">
<p class="fonts1">审计管理 &gt;&gt; 内审项目管理  &gt;&gt; 内审项目查询</p>
<div class="back">
 	<a href="IGIAM0105_Back.do" target="_self">返回</a>
</div>
</c:if>
</div>
<div id="formwrapper">
	<ig:message />
	<fieldset>
		<legend>内审项目信息</legend>
		 <table class="table_style1" cellspacing="2">
		 	<tr>
			<bean:define id="status" name="IGIAM0101Form" property="iapStatus"></bean:define>
				<th>年度:</th><td width="35%"><bean:write property="iapYear" name="IGIAM0101Form"></bean:write></td>
				<th>状态：</th>
				<td width="35%"><ig:codeValue ccid="IAPSTATUS" cid="${status}"/></td>
			</tr>
			<tr>
				<th>内审项目名称：</th><td><bean:write property="iapName" name="IGIAM0101Form"></bean:write></td>
				<th>审计方式：</th><td><bean:write property="iapWay" name="IGIAM0101Form"></bean:write></td>	
			</tr>
			<tr>
				<th>审计对象：</th><td><bean:write property="iapObject" name="IGIAM0101Form"></bean:write></td>
				<th>审计人员：</th><td><bean:write property="iapUserName" name="IGIAM0101Form"></bean:write></td>
			</tr>
			<tr>
				<th>审计开始日期：</th><td><bean:write property="iapOpenTime" name="IGIAM0101Form"></bean:write></td>
				<th>审计结束日期：</th><td><bean:write property="iapCloseTime" name="IGIAM0101Form"></bean:write></td>
			</tr>
			<tr>
				<th>审计目的：</th><td colspan='3'><bean:write property="iapObjective" name="IGIAM0101Form"></bean:write></td>
			</tr>
			<tr>
				<th>审计范围：</th><td colspan='3'><bean:write property="iapScope" name="IGIAM0101Form"></bean:write></td>
			</tr>
			<tr>
				<th>审计依据：</th><td colspan='3'><bean:write property="iapBasis" name="IGIAM0101Form"></bean:write></td>
			</tr>
			<tr>
				<th>审计内容及要点：</th><td colspan='3'><bean:write property="iapDesc" name="IGIAM0101Form"></bean:write></td>
			</tr>
			<tr>
				<th>配合人员：</th><td colspan='3'><bean:write property="iapCooperator" name="IGIAM0101Form"></bean:write></td>
			</tr>
			<tr>
				<th>建议：</th><td colspan='3'><bean:write property="iapSuggestion" name="IGIAM0101Form"></bean:write></td>
			</tr>
			</table>
		<html:hidden property="iapAttKey" name="IGIAM0101Form"/>
		<logic:present name="IGIAM01011VO" property="attkeyList">
	     <div>
	     <logic:notEmpty name="IGIAM01011VO" property="attkeyList">
	     <label for="Name"><strong>附件</strong>：</label>
	       <table id="tb2">	
	     	<logic:iterate id="attkey" name="IGIAM01011VO" property="attkeyList">
				<tr id="${attkey.attid}">
				     <td>
						<html:link action="IGIAM0102_LoadFile.do?attId=${attkey.attid}" styleId='attach${attkey.attid}'>
							<bean:define id="attname" name="attkey" property="attname" />
							<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
						</html:link>
					 </td>
				</tr>
		</logic:iterate>
		</table>
		</logic:notEmpty>
	     </div>
	     </logic:present>  
	</fieldset>
</div>
	<div id="operate">
	<!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
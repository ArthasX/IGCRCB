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
<bean:define id="id" value="IGIAM0106" toScope="request" />
<bean:define id="title" value="内审项目确认画面" toScope="request" />
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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function confirmMessage() {
	
	if($F('iapCooperator').strlen()>32){
		alert("配合人员不能大于32个字符！");
		return false;
	}
	if($F('iapSuggestion').strlen()>512){
		alert("建议不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
		return false;
	}
	
	if (window.confirm("是否确认当前信息？")) {
		form.action="IGIAM0104_Update.do?forward=back&iapStatus=2";
		form.submit();
	} else {
		return false;
	}
}
function rejectMessage() {
	if (window.confirm("是否驳回当前信息？")) {
		form.action="IGIAM0104_Update.do?forward=back&iapStatus=0";
		form.submit();
	} else {
		return false;
	}
}
</script>
</head>
<div id="location">
<div class="image"></div>
<p class="fonts1">审计管理 &gt;&gt; 内审项目管理 &gt;&gt; 内审项目确认 &gt;&gt; 内审项目确认</p>
<div class="back"><a href="IGIAM0104_Back.do" target="_self">返回</a></div>
</div>
<html:form styleId="form" action="/IGIAM0104_Update">
<div class="title">
<div class="name">内审项目确认</div>
</div>
<html:hidden property="iapId" name="IGIAM0101Form"/>
	<div id="results_list">
	<ig:message />
	<table class="table_style1" cellspacing="2">
		<tr>
		<bean:define id="status" name="IGIAM0101Form" property="iapStatus"></bean:define>
			<th>年度：</th><td width="35%"><bean:write property="iapYear" name="IGIAM0101Form"></bean:write></td>
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
		<c:if test="${status == 2}">
			<tr>
				<th>配合人员：</th><td colspan='3'><bean:write property="iapCooperator" name="IGIAM0101Form"></bean:write></td>
			</tr>
			<tr>
				<th>建议：</th><td colspan='3'><bean:write property="iapSuggestion" name="IGIAM0101Form"></bean:write></td>
			</tr>
		</c:if>
		<tr>
		<logic:present name="IGIAM01011VO" property="attkeyList">
	     <logic:notEmpty name="IGIAM01011VO" property="attkeyList">
	     <th>附件：</th>
	     	<logic:iterate id="attkey" name="IGIAM01011VO" property="attkeyList">
			     <td>
					<html:link action="IGIAM0102_LoadFile.do?attId=${attkey.attid}" styleId='attach${attkey.attid}'>
						<bean:define id="attname" name="attkey" property="attname" />
						<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
					</html:link>
				 </td>
		</logic:iterate>
		</logic:notEmpty>
	     </logic:present>
	     </tr>
		<html:hidden property="iapYear" name="IGIAM0101Form"/>
		<html:hidden property="iapName" name="IGIAM0101Form"/>
		<html:hidden property="iapWay" name="IGIAM0101Form"/>			
		<html:hidden property="iapObject" name="IGIAM0101Form"/>
		<html:hidden property="iapUserName" name="IGIAM0101Form"/>
		<html:hidden property="iapOpenTime" name="IGIAM0101Form"/>
		<html:hidden property="iapCloseTime" name="IGIAM0101Form"/>
		<html:hidden property="iapObjective" name="IGIAM0101Form"/>
		<html:hidden property="iapScope" name="IGIAM0101Form"/>
		<html:hidden property="iapBasis" name="IGIAM0101Form"/>
		<html:hidden property="iapDesc" name="IGIAM0101Form"/>
		<html:hidden property="iapAttKey" name="IGIAM0101Form"/>	
	</table>
	</div>
	<c:if test="${status == 1}">
	<div class="title">
	<div class="name">确认信息</div>
	</div>
	<div id="formwrapper">
	<table class="table_style1" cellspacing="2">
		<tr>
		<th width="120px"><strong>配合人员</strong>：</th><td><html:text property="iapCooperator" size="110" name="IGIAM0101Form" style=""></html:text></td>
		</tr>
		<tr>
		<th><strong>建议</strong>：</th>
		<td><html:textarea property="iapSuggestion" rows="8" cols="80" name="IGIAM0101Form"></html:textarea></td>
		</tr>
	</table>
		<div class="enter"><html:button property="btn_search" styleClass="button" value="确认" onclick="return confirmMessage();"/>
		<html:button property="btn_search" styleClass="button" value="驳回" onclick="return rejectMessage();"/></div>
	</div>
	</c:if>
	<div id="operate">
	<!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
</html:form>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
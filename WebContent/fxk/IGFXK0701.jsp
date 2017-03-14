<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.sym.vo.IGSYM05011VO" %>
<html:html>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<bean:define id="id" value="IGFXK0701" toScope="request" />
<bean:define id="title" value="风险提示查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
	.ellips{
	width:100%; 
	white-space:nowrap; 
	text-overflow:ellipsis; 
	overflow:hidden;
	}
</style>
<script type="text/javascript">	
function setOrg(url) {

	var temp = window
			.showModalDialog(url, null,
					"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");

	if ("_resetall" == temp) {
		document.forms[0].norgid.value = "";
		document.forms[0].norgname.value = "";
		return false;
	}
	if (null != temp && temp.split("|").length > 1) {
		document.forms[0].norgid.value = temp.split("|")[0];
		document.forms[0].norgname.value = temp.split("|")[1];
	}

}
function setOrgAcc(url) {

	var temp = window
			.showModalDialog(url, null,
					"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");

	if ("_resetall" == temp) {
		document.forms[0].orgid_s.value = "";
		document.forms[0].orgname_s.value = "";
		return false;
	}
	if (null != temp && temp.split("|").length > 1) {
		document.forms[0].orgid_s.value = temp.split("|")[0];
		document.forms[0].orgname_s.value = temp.split("|")[1];
	}

}
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGFXK0701_Search"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">风险管理 &gt;&gt; 风险提示管理 &gt;&gt;风险提示查询</p>
</div>
<!-- 接收人员部门、接收人员 -->	
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	   <div>
	 <span style="font-size:15px;"><strong>查询条件</strong></span>
	    
	</div>
	<div style="margin-top:4px"><span class="subscribe" >风险提示名称：  </span><html:text property="rwname" name="IGFXK0700Form"/>
	<span class="subscribe">下发人员：</span><html:text property="nusername" name="IGFXK0700Form" style="width:90px"/>
	<span class="subscribe">下发人员部门：</span>
	<html:text property="norgname" styleId="norgname" readonly="true" name="IGFXK0700Form"/>
	<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" alt="请选择机构"/>
	<html:hidden property="norgid" styleId="norgid" name="IGFXK0700Form"/>
	
	<span class="subscribe">下发时间：</span><html:text property="ntime" name="IGFXK0700Form" styleId="ntime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('ntime'))" border="0" style="cursor: hand" />
	
    <html:submit property="btn_search" styleClass="button" value="查询"/>
	</div>
	<div style="margin-top:12px">
		<span class="subscribe">接收人员部门：</span>
		<html:text property="orgname_s" styleId="orgname_s" readonly="true" name="IGFXK0700Form"/>
		<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrgAcc('IGSYM0101_TREE.do');" alt="请选择机构"/>
		<html:hidden property="orgid_s" styleId="orgid_s"/>
		<span class="subscribe">接收人员：</span><html:text property="username_s" style="width:90px" name="IGFXK0700Form"/>
		<span> 
	
		 </span>
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<!-- <th width="3%">
				<label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','deleteNid')"/> </label>
				</th> -->
				<th width="17%">风险提示名称</th>
				<th width="15%">风险提示描述</th>
				<th width="15%">下发时间</th>
				<th width="8%">下发人员</th>
				<th width="10%">下发人员部门</th>
				<th width="12%">接收人员部门</th>
				<th width="12%">接收人员</th>
			</tr>
			<logic:present name="IGFXK07011VO" property="voList">
				<logic:iterate id="bean" name="IGFXK07011VO" property="voList" indexId="index">
					<tr style='cursor:hand' bgcolor="" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
					onclick="doLook(getAppRootUrl()+'/IGFXK0701_Each.do?rwid=${bean.risk.rwid}');">
					
						<td width="17%">${bean.risk.rwname}</td>
						<td width="15%">${bean.risk.rwcontext}</td>
						<td width="15%">${bean.risk.ntime }</td>
						<td width="12%"> ${bean.risk.nusername }</td>
						<td width="10%">${bean.risk.norgname }</td>
						<logic:present  name="bean" property="acceptuserList">
						<td width="8%" title="<logic:iterate id="ubean" name="bean" property="acceptuserList" indexId="index">${ubean.aporgname} </logic:iterate>" height="15px">
				
						<div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">
						<logic:iterate id="ubean" name="bean" property="acceptuserList" indexId="index">${ubean.aporgname}
						</logic:iterate>
						</div>
						</td>
						<td width="12%" title="<logic:iterate id="ubean" name="bean" property="acceptuserList" indexId="index">${ubean.apusername} </logic:iterate>" height="15px">
						<div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">
							<logic:iterate id="ubean" name="bean" property="acceptuserList" indexId="index">${ubean.apusername} </logic:iterate>
							</div>
						</td>
						</logic:present>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
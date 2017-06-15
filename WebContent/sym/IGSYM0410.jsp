<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM0410" toScope="request" />
<bean:define id="title" value="授权管理报表授权画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//按钮操作提示
	function deleteRec(obj,flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="角色" />';
        var mode="0";
		if(flag=="1"){
			message = '请选择添加对象。';
			confirmMsg = '请确认是否要进行角色添加处理?';
			mode="1";
		}
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
        if(window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGSYM0410.do?mode="+mode;
            return true;
        } else {
            return false;
        }
	}

//-->
</script>
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGSYM0410"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
<div class="back"><a href="IGSYM0413_RE.do" target="_self">返回</a></div>
</div>
	<html:hidden property="rfdtitle"/>
	<html:hidden property="cvalue"/>
	<input type="hidden" name="flag" value="1">
	
	<div class="role_title">被授权报表</div>
	<div id="results_list">

	<table class="table_style6" align="left">
			<tr>
				<th width="22%">
				显示名称
				</th>
				<td width="40%">

					<bean:write name="IGSYM0410Form" property="rfdtitle"/>

				</td>
				<th width="20%" >
				分类
				</th>
				<td width="38%">
					<bean:write name="IGSYM0410Form" property="rfdtypename"/>
				</td>
			</tr>	
	</table>
	</div>
	<div class="role_title">已有角色</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	
	<table class="table_style4" align="left">
		
			<tr>
				<th width="10%">
				<label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','roleidy')"/> </label>
					</th>
				<th width="22%">
				角色名称
				</th>
				<th width="22%">
				角色类型
				</th>
				<th width="34%" >
				角色说明
				</th>
			</tr>
		
			<logic:present name="IGSYM04101VO" property="yroleList">
				<logic:iterate id="bean" name="IGSYM04101VO"
					property="yroleList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td><label><html:checkbox
							property="roleidy" value="${bean.roleid}" /> </label>
						</td>
						<td><logic:empty name="bean"
							property="rolename">&nbsp;</logic:empty>${bean.rolename}
						</td>
						<td><logic:empty name="bean"
							property="roletype">&nbsp;</logic:empty>
							<ig:codeValue ccid="ROLE_CATEGORY_CODE" cid="${bean.roletype}" />
						</td>
						<td><logic:empty name="bean"
							property="roledesc">&nbsp;</logic:empty> ${bean.roledesc}
						</td>
					</tr>
				</logic:iterate>
			</logic:present>

	</table>
	</div>
	<div id="operate">
	<logic:present name="IGSYM04101VO"
		property="yroleList">
		<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return deleteRec('roleidy','0');" /></span>
	</logic:present>
	</div>
	<div class="role_title">可选角色</div>
	
	<!-- ================== -->

	<logic:present name="IGSYM04101VO" property="roleMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGSYM04101VO" property="roleMap" indexId="number">
				<li class="TabbedPanelsTab">
					<ig:codeValue ccid="ROLE_CATEGORY_CODE" cid="${map.key}" />
				</li>
			</logic:iterate>
		</ul>
		<div class="TabbedPanelsContentGroup">
		<logic:present name="IGSYM04101VO" property="roleMap">
			<logic:iterate id="map" name="IGSYM04101VO" property="roleMap" indexId="number">
				<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style4" align="left">
					<tr>
						<th width="10%">
						</th>
						<th width="22%">角色名称
						</th>
						<th width="56%">角色说明
						</th>
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
						<tr class="<ig:rowcss index="${index}"/>">
							<td>
								<label>
									<html:checkbox property="roleids" value="${bean.roleid}" /> 
								</label>
							</td>
							<td>
								<logic:empty name="bean" property="rolename">&nbsp;</logic:empty>${bean.rolename}
							</td>
							<td><logic:empty name="bean" property="roledesc">&nbsp;</logic:empty> ${bean.roledesc}
							</td>
						</tr>
					</logic:iterate>
				</table>
				</div>
				</div>
			</logic:iterate>
		</logic:present></div>
		</div>
	<script type="text/javascript">
	<!--
	var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
	//-->
	</script>
	</logic:present>
	
	<div id="operate">
	<logic:present name="IGSYM04101VO"
		property="roleList">
		<span> <html:submit property="btn_delete" value="添加所选"
			styleClass="button" onclick="return deleteRec('roleids','1');" /></span>
	</logic:present>
	</div>
	<html:hidden property="rfdid" styleId="rfdid" />
	<html:hidden property="roleid" styleId="roleid" />
</html:form>
<div class="Placeholder"></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
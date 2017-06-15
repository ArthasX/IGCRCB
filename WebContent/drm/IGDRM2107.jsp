<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM2107" toScope="request" />
<logic:equal name="IGDRM2105Form" property="mode" value="0">
	<bean:define id="title" value="专项预案查询" toScope="request" />
</logic:equal>
<logic:equal name="IGDRM2105Form" property="mode" value="1">
	<bean:define id="title" value="专项预案管理" toScope="request" />
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<style>
.clickable{
	cursor: pointer;
}
.hover {
	background-color: #F3F4F4;
}
.chkbox{
	cursor:default;
}
</style>
<!-- /header1 -->
<script type="text/javascript">
function confirmDelete() {
	if(window.confirm("是否确认删除？")){
		return true;
	}else{
		return false;
	}
}
function setBusinessSystem(){
	var url = "/IGDRM2101_BsInit.do?flag=sign&esyscoding=1_CM03000000_999003";
	openSubWindow(url, '_blank', '1100', '600');
}
function setParamDRM2101(eid, elabel, ename, eiid, eilabel, einame ,ecategory,eiversion,esyscoding,id){

	if(eiid){
		jQuery("#usinessSystemName").val(einame);
		jQuery("#usinessSystemId").val(eiid);
	}else{
		jQuery("#usinessSystemName").val("");
		jQuery("#usinessSystemId").val("");
	}
}
function setScene(){
	openSubWindow('/IGDRM2104_Single.do', '_blank', '850', '600');
}
function setSceneValue(eiid,einame){
	jQuery("#sceneName").val(einame);
	jQuery("#sceneId").val(eiid);
}
function setDrmResource(){
	openSubWindow('/IGDRM0402_Single.do', '_blank', '850', '600');
}
function setDrmResourceValue(eiid,einame){
	jQuery("#drmResourceName").val(einame);
	jQuery("#drmResourceId").val(eiid);
}

j$(function(){
	j$("tr[eiid]").addClass("clickable").click(function(event){
		window.location.href="IGDRM2102_View.do?eid=CM8001002&mode="+j$("#pageMode").val()+"&eiid="+j$(this).attr("eiid");
	});
	j$(".chkbox").click(function(event){ event.stopPropagation()});
	
})
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
<div id="contentWrap">
<html:form styleId="IGDRM2105Form" action="/IGDRM2105.do">
	<div id="location">
		<div class="image"></div>
		<p class="fonts1">
			<ig:navigation extname1="${urlable}" />
		</p>
	</div>
	<div id="search">
		<div class="img"></div>
		<div class="conditions">
			<div>
				<span>预案名称：</span>
				<span>
					<html:text property="einame_like" style="width:110px;"/>
				</span>
				&nbsp;&nbsp;
				<span>业务系统</span>
				<span>
					<html:text property="usinessSystemName" styleId="usinessSystemName" style="width:110px;" readonly="true"/>
					<html:hidden property="usinessSystemId" styleId="usinessSystemId"/>
					<img src="images/seek.gif" width="16" height="16" style="cursor: pointer;" onclick="setBusinessSystem();"/>
				</span>
				&nbsp;&nbsp;
				<span>场景</span>
				<span>
					<html:text property="sceneName" style="width:110px;" styleId="sceneName" readonly="true"/>
					<html:hidden property="sceneId" styleId="sceneId"/>
					<img src="images/seek.gif" width="16" height="16" style="cursor: pointer;" onclick="setScene();"/>
				</span>
				&nbsp;&nbsp;
				<span>应急资源</span>
				<span>
					<html:text property="drmResourceName" styleId="drmResourceName" style="width:110px;" readonly="true"/>
					<html:hidden property="drmResourceId" styleId="drmResourceId"/>
					<img src="images/seek.gif" width="16" height="16" style="cursor: pointer;" onclick="setDrmResource();"/>
				</span>
				<html:submit property="btn_search" styleClass="button" value="查询"></html:submit>
			</div>
		</div>						
	</div>
	<div id="results_list">
		<ig:message />
		<table class="table_style">
			<tr>
				<logic:equal name="IGDRM2105Form" property="mode" value="1">
					<th width="6%" style="text-align: center;">
						<label>
							<input type="checkbox" id="check_all" title="全选/不全选本页" onclick="selectAll('check_all', 'selectedEiids');" />
						</label>
					</th>
				</logic:equal>
				<logic:equal name="IGDRM2105Form" property="mode" value="0">
					<th width="6%">序号</th>
				</logic:equal>
				<th width="30%">预案名称</th>
				<th width="36%">预案描述</th>
				<th width="8%">登记日期</th>
				<th width="8%">登记人员</th>
				<logic:equal name="IGDRM2105Form" property="mode" value="1">
					<th width="4%">修改</th>
					<th width="4%">详细</th>
				</logic:equal>
				<th width="4%">导出</th>
			</tr>
			<logic:present name="IGDRM21051VO" property="soc0118VWList">
				<logic:iterate id="info" name="IGDRM21051VO" property="soc0118VWList" indexId="index">
					<tr eiid="${info.eiid }" class="<ig:rowcss index="${index}"/>">
						<logic:equal name="IGDRM2105Form" property="mode" value="1">
							<td style="text-align: center;">
								<html:checkbox property="selectedEiids" styleClass="chkbox" value="${info.eiid}" />
							</td>
						</logic:equal>
						<logic:equal name="IGDRM2105Form" property="mode" value="0">
							<td>${PagingDTO.viewStartCount + index}</td>
						</logic:equal>
						<td>${info.einame}</td>
						<td>${info.eidesc}</td>
						<td>${info.eiinsdate}</td>
						<td>${info.eiusername}</td>
						<logic:equal name="IGDRM2105Form" property="mode" value="1">
							<td>
								<html:link action="/IGDRM2101_Edit.do?eiid=${info.eiid}">
									<img src="images/edit.gif" alt="修改" width="16" height="16" border="0" />
								</html:link>
							</td>
						</logic:equal>
						<logic:equal name="IGDRM2105Form" property="mode" value="1">
							<td>
								<html:link action="/IGDRM2102_Disp.do?eid=${info.eid}&eiid=${info.eiid}">
									<img src="images/xx.gif" alt="显示详细信息" width="16" height="16" border="0" />
								</html:link>
							</td>
						</logic:equal>
						<td>
							<a href="IGDRM2105_Export.do?eiid=${info.eiid }">
								<img src="images/batch.gif" alt="导出" width="16" height="16" border="0" />
							</a>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
	</div>
	<div id="operate">
		<logic:equal name="IGDRM2105Form" property="mode" value="1">
			<html:submit property="btn_delete_sel" value="删除所选"  styleClass="button" onclick="return confirmDelete();"/>
		</logic:equal>
		<!-- paging -->
		<jsp:include page="/include/paging.jsp" />
	</div>
	<html:hidden styleId="pageMode" property="mode" value="${IGDRM2105Form.mode }" />
</html:form>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
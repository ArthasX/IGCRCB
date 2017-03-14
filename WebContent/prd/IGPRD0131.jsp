<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<%@ page import="com.deliverik.infogovernor.util.CodeDefine" %>
<html:html>
<bean:define id="id" value="IGPRD0131" toScope="request" />
<bean:define id="title" value="授权页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
function deleteRec(flag){
	var id = "";
	var message = "添加";
	if(flag == "0"){
		id = "orgid_del";
		message = "删除";
	}
	if(flag == "1"){
		id = "orgid_add";
	}
	var objs = document.getElementsByName(id);
	if(objs == null){
		alert("没有要"+message+"的机构信息！");
		return false;
	}else{
		var checkflag = true;
		for(var i=0;i<objs.length;i++){
			if(objs[i].checked){
				checkflag = false;
				break;
			}
		}
		if(checkflag){
			alert("请选择要"+message+"的机构！");
			return false;
		}
	}
	if(window.confirm("是否确认"+message+"？")){
		form.action = 'IGPRD0131.do?model='+flag;
		return true;
	}else{
		return false;
	}
}
function checkedChild(obj){
	var objs = document.getElementsByName("orgid_add");
	var checkflag = obj.checked;
	if(objs!=null){
		for(var i=0;i<objs.length;i++){
			if(objs[i].value.indexOf(obj.value)>-1){
				objs[i].checked = checkflag;
			}
		}
	}
}
//-->
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRD0131" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 流程管理 &gt;&gt; 机构列表 &gt;&gt; 授权</p>
<div class="back"><a href="IGPRD0101_Back.do" target="_self">返回</a></div> 
</div>
	<div class="role_title">现有机构</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table id="tab_del" class="table_style4" align="left">
			<tr>
				<th width="20%">
					<label> 
						<input type="checkbox" name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','orgid_del')"/>
					</label>
				</th>
				<th width="40%">机构名称</th>
				<th width="40%"></th>
			</tr>
			<logic:present name="IGPRD01311VO" property="pordList">
				<logic:iterate id="bean" name="IGPRD01311VO" property="pordList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
							<label>
								<input type="checkbox" name="orgid_del" value="${bean.potdid}">
						 	</label>
						</td>
						<td>${bean.orgname }</td>
						<td></td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRD01311VO" property="pordList">
		<span>
		<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
			<html:submit property="btn_delete" value="删除所选" styleClass="button" onclick="return deleteRec('0');" />
		<%} %>	
		</span>
	</logic:present>
	</div>
	<div class="role_title">可选机构</div>
	<div id="results_list">
	<table class="table_style4" align="left">
			<tr>
				<th width="20%"></th>
				<th width="40%">机构名称</th>
				<th width="40%"></th>
			</tr>
			<logic:present name="IGPRD01311VO" property="orgTreeMap">
				<logic:iterate id="map" name="IGPRD01311VO" property="orgTreeMap" indexId="index">
					<bean:define id="key" name="map" property="key"/>
					<bean:define id="list" name="map" property="value"/>
					<tr>
						<td>
							<input type="checkbox" name="orgpar" value="${key.orgsyscoding }" onclick="checkedChild(this);">
						</td>
						<td colspan="2" align="left" style=""><b>${key.orgname }</b></td>
					</tr>
					<logic:iterate id="bean" name="list">
						<tr>
							<td>
								<label>
									<input type="checkbox" name="orgid_add" value="${bean.orgsyscoding}_${bean.orgname}">
								</label>
							</td>
							<td>${bean.orgname }</td>
							<td></td>
						</tr>
					</logic:iterate>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRD01311VO" property="orgTreeMap">
		<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
			<html:submit property="btn_delete" value="添加所选" styleClass="button"  onclick="return deleteRec('1');"/>
		<%} %>	
	</logic:present>
	</div>
	<html:hidden property="pdid" styleId="pdid" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>

</body>
</html:html>
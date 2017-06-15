<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.risk.bl.IGRISCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGRIS0104" toScope="request" />
<bean:define id="title" value="审计项管理画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var gid='IGRIS0104';
function changeRaversion(){
	var obj = $("raid");
	$("raversion").value = obj.options[obj.selectedIndex].text;
	$("radparname").value = "";
	$("radparcode_q").value = "";
	
}
function checkSubmit(){
	if($F('raid').trim() == ""){
		alert("请选择版本名称！");
		return false;
	}
	if($F('radparname').trim() == ""){
		alert("请选择审计项！");
		return false;
	}
	$('raid').disabled = "";	
}

function setAudit(){
	if($F('raid').trim() == ""){
		alert("请选择版本名称！");
		return false;
	}
	var temp = window.showModalDialog("IGRIS0104_TREE.do?raid="+$F('raid'),null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].radparcode_q.value = "";
		document.forms[0].radparname.value = "";
		$('raid').disabled = "";
		return false;
	}
	
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].radparcode_q.value = temp.split("|")[0];
		document.forms[0].radparname.value = temp.split("|")[1];
		$('raid').disabled = "disabled";
	}		
}

function toChange(radid,radstatus){
	if( window.confirm("您是否确认修改状态？")){
        form.action = getAppRootUrl() + "/IGRIS0104_Change.do?radid="+radid+"&radstatus="+radstatus;
        form.submit();
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
<html:form styleId="form" action="/IGRIS0104_Button"
	onsubmit="return checkSubmit(this);">
	
<div id="location">
<div class="image"></div>
<p class="fonts1">信息安全 &gt;&gt; 风险审计 &gt;&gt; 审计项管理</p>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span><span class="red">*</span>版本名称：</span><logic:present name="labelList"><html:select property="raid" errorStyleClass="inputError imeActive" onchange="changeRaversion()" name="IGRIS0104Form" styleId="raid">
		<html:options collection="labelList" property="value" name="" labelProperty="label"/>
	</html:select> <html:hidden property="raversion" styleId="raversion" name="IGRIS0104Form"/>
	</logic:present>
	<span><span class="red">&nbsp;&nbsp;*</span>审计项：</span><html:text property="radparname"  readonly="true" name="IGRIS0104Form" styleId="radparname"></html:text>
		<img src="images/tree.gif" style="cursor: hand;" alt="选择上级审计项" width="16" height="16" border="0" onclick="setAudit();"/>
		<html:hidden property="radparcode_q" styleId="radparcode" name="IGRIS0104Form"/>&nbsp;&nbsp; 
	<html:submit property="btn_next" styleClass="button" value="下一级"/>
	<html:submit property="btn_all" styleClass="button" value="全部下级"/>
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	
	<table class="table_style">
		<tr>
			<th width="20%">版本名称</th>
            <th width="20%">审计项名称</th>
            <th width="36%">说明</th>
            <th width="8%">状态</th>
            <th width="8%">调整</th>
            <th width="8%">修改</th>
		</tr>
		<logic:present name="IGRIS01051VO" property="riskAuditDefList">
			<logic:iterate id="bean" name="IGRIS01051VO"
				property="riskAuditDefList" indexId="index">
				<tr>
					<td><logic:empty name="bean" property="raversion">&nbsp;</logic:empty>${bean.raversion}</td>
					<td><logic:empty name="bean" property="radname">&nbsp;</logic:empty>${bean.radname}</td>
					<td><logic:empty name="bean" property="raddesc">&nbsp;</logic:empty>${bean.raddesc}</td>
					<td>
					<logic:equal value="<%=IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE %>" name="bean" property="radstatus">已启用</logic:equal>
					<logic:equal value="<%=IGRISCONSTANTS.RISKAUDITDEF_STATUS_DISABLE %>" name="bean" property="radstatus">已停用</logic:equal>
					</td>
					<td>
					<logic:equal value="<%=IGRISCONSTANTS.RISKAUDITDEF_STATUS_DISABLE %>" name="bean" property="radstatus">
						<html:link  href="javascript:toChange('${bean.radid}','${bean.radstatus}')">
						<img src="images/start.gif" width="16" height="16" border="0" alt="启用" />
						</html:link>
					</logic:equal>
					<logic:equal value="<%=IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE %>" name="bean" property="radstatus">
						<html:link  href="javascript:toChange('${bean.radid}','${bean.radstatus}')">
						<img src="images/stop.gif" width="16" height="16" border="0" alt="停用" />
						</html:link>
					</logic:equal>
					</td>
					<td>
					<div align="center">
					<html:link action="/IGRIS0105_Edit_Disp.do?radid=${bean.radid}"> 
					<img src="images/edit.gif" alt="修改" width="16" height="16" border="0" />
					</html:link></div>
					</td>
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
</div>
<div class="zishiying"></div>
</div>
</body>
</html:html>
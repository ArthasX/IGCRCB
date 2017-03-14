<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSCH0401" toScope="request" />
<bean:define id="title" value="策略设定" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script>
function change(){
	var obj = document.forms[0].qjcrtuser;
	if(obj.selectedIndex!=-1){
		var temp = obj.options[obj.selectedIndex].text;
		$("qjimpluser").value=temp;
	}
}

function checkForm(){
	<logic:present name="IGSCH0401Form" property="urgencyname">
	<logic:iterate id="bean" name="IGSCH0401Form" property="urgencyname" indexId="index">
		if(parseInt($F('reportTime[${index}]')) > -1 && parseInt($F('notifyTime[${index}]'))>parseInt($F('reportTime[${index}]'))){
			alert("${bean}级事件再次提醒时间应小于报告上级时间！");
			return false;
		}
	</logic:iterate>
	</logic:present>
	if($F('qjimpluser').trim()==""||$F('qjcrtuser').trim()==""){
		alert("请选择事件经理！");
		return false;
	}
	if( window.confirm("您是否确认提交？")){
		return true;
	} else {
		return false;
	}
}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form action="/IGSCH0401" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">流程管理 &gt;&gt; 事件管理 &gt;&gt; 策略设定</p>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style4" align="left">
		<tr>
			<th width="20%">优先级</th>
			<th width="20%">再次提醒时间</th>
			<th width="20%">报告上级时间</th>
			<th width="20%">预计解决时间</th>
			<th width="20%">事件经理</th>
		</tr>
		<logic:present name="IGSCH0401Form" property="urgencyname">
			<logic:iterate id="bean" name="IGSCH0401Form" property="urgencyname"
				indexId="index">
				<tr>
					<td>${bean}<html:hidden property="urgency[${index}]" /></td>
					<td><html:select property="notifyTime[${index}]"
						style="width:60px">
						<ig:optionsCollection ccid="INCIDENT_SUPERVISION_NOTIFYTIME" isMakeBlankRow="false" isCodeLabel="true" />
					</html:select></td>
					<td><html:select property="reportTime[${index}]"
						style="width:60px">
						<ig:optionsCollection ccid="INCIDENT_SUPERVISION_REPORTTIME" isMakeBlankRow="false" isCodeLabel="true" />
					</html:select></td>
					<td><html:select property="resolveTime[${index}]"
						style="width:60px">
						<ig:optionsCollection ccid="INCIDENT_SUPERVISION_RESOLVETIME" isMakeBlankRow="false" isCodeLabel="true" />
					</html:select></td>
					<logic:equal value="0" name="index">
							<td rowspan="${IGSCH0401Form.urgencycount+1}"><html:select
								property="qjcrtuser" style="width:100px;"
								errorStyleClass="inputError imeActive" tabindex="2"
								onchange="change()">
								<html:options collection="roleList" property="value" name=""
									labelProperty="label" />
							</html:select></td>
						</logic:equal>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<span> <logic:greaterThan
		name="IGSCH0401Form" property="urgencycount" value="0">
		<html:submit property="btn_save" value="设置" styleClass="button"
			onclick="return checkForm();" />
	</logic:greaterThan> <logic:present name="IGSCH0401Form" property="qjstatus">
		<logic:equal name="IGSCH0401Form" property="qjstatus" value="A">
			<html:submit property="btn_remove" value="停止" styleClass="button"
				onclick="return checkForm();" />
		</logic:equal>
	</logic:present> 
	<logic:present name="IGSCH0401Form" property="definitioned">
		<logic:equal name="IGSCH0401Form" property="definitioned" value="1">
		<html:submit property="btn_delete" value="删除" styleClass="button" onclick="return checkForm();" />
		</logic:equal>
	</logic:present>			
	</span>
	</div>
	<html:hidden property="qjid" />
	<html:hidden property="qjimpluser" />
	<html:hidden property="urgencycount" />
	<html:hidden property="qjstatus" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
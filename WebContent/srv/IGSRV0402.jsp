<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils"%>
<html:html>
<bean:define id="id" value="IGSVC0402" toScope="request" />
<bean:define id="title" value="变更发起" toScope="request" />
<bean:define id="user" name="LOGIN_USER" scope="session" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var gid='IGSVC0402';
var num = 0;
var path = 0;
WebCalendar.timeShow   = true;          //是否返回时间
//改变角色名称(流程管理)
function changePrRolename(){
	var obj = document.forms[0].prroleid;
	document.forms[0].prrolename.value = obj.options[obj.selectedIndex].text;
}

function selectEntity(){
	openSubIGCOM0302();
}

function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory) {
	if(0 == path){
	    $("prassetid").value = eiid;
		$("prassetname").value = einame;
		$("prassetcategory").value = ecategory;
	} else {
		if("" == eiid){
			$("pivarvalue[" + num + "]").value = "";
			$("pivarassetname[" + num + "]").value = "";
		} else {
			$("pivarvalue[" + num + "]").value = eiid + "_asset_" + einame;
			$("pivarassetname[" + num + "]").value = einame;
		}
	}
	num = 0;
	path = 0;
}

function checkForm(){
	if($F('prroleid').trim()==""){
		alert("请选择角色！");
		return false;
	}
	if($F('prinfo').trim()==""){
		alert("请输入联系方式！");
		return false;
	}
	if($F('prtitle').trim()==""){
		alert("请输入变更名称！");
		return false;
	}
	if($F('prdesc').trim()==""){
		alert("请输入变更描述！");
		return false;
	}
	if($F('prplantime').trim()==""){
		alert("请选择执行周期开始时间！");
		return false;
	}
	if($F('prduration').trim()==""){
		alert("请选择执行周期结束时间！");
		return false;
	}
	if(!checkDateWithTimeShow("prplantime","prduration")){
		alert("执行周期开始时间不能晚于结束时间！");
		return false;
	}
	if($F('prurgency').trim()==""){
		alert("请选择紧急程度！");
		return false;
	}
	if($F('primpact').trim()==""){
		alert("请选择影响程度！");
		return false;
	}
	if($F('primplplan').trim()==""){
		alert("请输入执行计划！");
		return false;
	}
	if($F('prbackplan').trim()==""){
		alert("请输入恢复计划！");
		return false;
	}
	if($F('prvfyplan').trim()==""){
		alert("请输入验证计划！");
		return false;
	}	

	if($F('prinfo').strlen()>64){
		alert("联系方式不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('prtitle').strlen()>150){
		alert("变更名称不能大于"+Math.floor(150/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('prdesc').strlen()>512){
		alert("变更描述不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('primplplan').strlen()>512){
		alert("执行计划不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('prbackplan').strlen()>512){
		alert("恢复计划不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('prvfyplan').strlen()>512){
		alert("验证计划不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
		return false;
	}
	<logic:present name="IGSVC04021VO" property="processInfoDef">
	<logic:notEmpty name="IGSVC04021VO" property="processInfoDef">
	<logic:iterate id="infoDef" name="IGSVC04021VO" property="processInfoDef" indexId="index">
	<logic:equal value="1" name="infoDef" property="pidrequired">
		if($F('pivarvalue[${index}]').trim() == ""){
			alert("请输入${infoDef.pidlabel}！");
			return false;
		}
	</logic:equal>
	</logic:iterate>
	<logic:iterate id="infoDef" name="IGSVC04021VO" property="processInfoDef" indexId="index">
	if($F('pivarvalue[${index}]').strlen()>256){
		alert("${infoDef.pidlabel}不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
		return false;
		}
	</logic:iterate>
	</logic:notEmpty>
	</logic:present>
	if( window.confirm("您是否确认提交？")){
		return true;
	} else {
		return false;
	}
}
function selectBudget(){
	openSubWindow('/IGFIN0106_Disp.do?', 'budget','800','600');
}
function openSVCPage(){
	openSubWindow('/IGSVC0107_Disp.do?prtype=P_I', 'new','1000','600');
}
function setParams(prcorid,prcortype,prcortitle){
	if(0 == path){
	    $("prcorid").value = prcorid;
        $("prcortype").value = prcortype;
        $("prcortitle").value = prcortitle;
	} else {
		if(prcorid == ""){
			$("pivarvalue[" + num + "]").value = "";
			$("pivarprname[" + num + "]").value = "";
		} else {
	        $("pivarvalue[" + num + "]").value = prcorid + "_svc_" + prcortype + "_name=" + prcortitle;
		    $("pivarprname[" + num + "]").value = prcortitle;
		}
	}
   	num = 0;
   	path = 0;
}

function selectEntityItem(index,flag){
    num = index;
    path = flag;
    openSubIGCOM0302();
}

function selectProject(index){
	num = index;
	openSubWindow('/IGFIN0108_Disp.do', '_blank','1000','600');
}

function openSVCWindow(index,flag){
	num = index;
	path = flag;
	openSubWindow('/IGSVC0107_Disp.do', '_blank','1000','600');
}

function setPrjParams(pid,pcode,pname){
	if("" == pid){
		$("pivarvalue[" + num + "]").value = "";
		$("pivarprjname[" + num + "]").value = "";
	} else {
		$("pivarvalue[" + num + "]").value = pid + "_prj_" + pname;
		$("pivarprjname[" + num + "]").value = pname;
	}
	num = 0;
}
</script>
<body onload="changePrRolename()">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGSVC0402" styleId="form" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">流程管理 &gt;&gt; 变更管理 &gt;&gt; 变更发起</p>
	</div>
	<div id="formwrapper">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset><legend>发起者信息 </legend>
	<div><label><strong>姓名</strong>：</label><p class="p2"><bean:write name="user"
		property="username" /></p></div>
	<div><label><strong>发起者部门</strong>：</label><p class="p2"><bean:write name="user"
		property="orgname" /></p></div>
	<div><label for="Name"><strong><span class="red">*</span>发起者角色</strong>：</label> <html:select
		property="prroleid" style="width: 120px;"
		errorStyleClass="inputError imeActive" tabindex="2"
		onchange="changePrRolename()">
		<html:options collection="roleList" property="value" name=""
			labelProperty="label" />
	</html:select> <html:hidden property="prrolename"/><br />
	</div>
	<div><label><strong><span class="red">*</span>联系方式</strong>：</label> 
	<html:text property="prinfo" size="18" errorStyleClass="inputError imeActive" /><br />
	</div>
	</fieldset>
	<fieldset><legend>变更信息</legend>
	<div><label for="Name"><strong>变更类型</strong>：</label>
	<p class="p2"><bean:write name="IGSVC0402Form" property="prpdname"/></p>
	</div>
	<div><label for="Name"><strong><span class="red">*</span>变更名称</strong>：</label> <html:text
		property="prtitle" size="82" errorStyleClass="inputError imeActive"/> <br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>变更描述</strong>：</label> <html:textarea
		property="prdesc" cols="60" rows="6" errorStyleClass="inputError imeActive"></html:textarea> <br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>执行周期</strong>：</label> <strong>从</strong> <html:text
		property="prplantime" styleId="prplantime"
		errorStyleClass="inputError imeDisabled" size="18" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('prplantime'))"
		border="0" style="cursor: hand" />&nbsp;&nbsp;<strong>到</strong>
		<html:text
		property="prduration" styleId="prduration"
		errorStyleClass="inputError imeDisabled" size="18" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('prduration'))"
		border="0" style="cursor: hand" />
		<br />
	</div>
	<div><label for="Name"><strong>相关资产</strong>：</label> <html:text
		property="prassetname" size="18" readonly="true" errorStyleClass="inputError imeActive"/> 
		<img src="images/seek.gif" border="0" width="16" height="16" onclick="selectEntity()" alt="查询" style="cursor: hand"/><br />
	</div>
	<div><label for="Name"><strong>相关项目</strong>：</label> <html:text
		property="pname" size="18" readonly="true" errorStyleClass="inputError imeActive"/> 
		<img src="images/seek.gif" border="0" width="16" height="16" onclick="selectBudget()" alt="查询" style="cursor: hand"/><br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>紧急程度</strong>：</label> <html:select
		property="prurgency" errorStyleClass="inputError imeActive">
		<ig:optionsCollection ccid="CURGENCY_GRADE_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	</html:select> <br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>影响程度</strong>：</label> <html:select
		property="primpact" errorStyleClass="inputError imeActive">
		<ig:optionsCollection ccid="IMPACT_GRADE_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	</html:select> <br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>执行计划</strong>：</label> <html:textarea
		property="primplplan" cols="60" rows="6" errorStyleClass="inputError imeActive"></html:textarea> <br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>恢复计划</strong>：</label> <html:textarea
		property="prbackplan" cols="60" rows="6" errorStyleClass="inputError imeActive"></html:textarea> <br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>验证计划</strong>：</label> <html:textarea
		property="prvfyplan" cols="60" rows="6" errorStyleClass="inputError imeActive"></html:textarea> <br />
	</div>
	<logic:present name="IGSVC04021VO" property="processInfoDef">
	<logic:notEmpty name="IGSVC04021VO" property="processInfoDef">
	<logic:iterate id="infoDef" name="IGSVC04021VO" property="processInfoDef" indexId="index">
	<div>
		<logic:equal value="0" name="infoDef" property="pidtype">
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<html:text property="pivarvalue[${index}]" size="32" errorStyleClass="inputError imeActive"/> <br />
		</logic:equal>
		<logic:equal value="3" name="infoDef" property="pidtype">
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<html:text property="pivarvalue[${index}]" size="18" readonly="true" errorStyleClass="inputError imeActive"/> 
			<img src="images/date.gif" align="middle" onclick="calendar($('pivarvalue[${index}]'))" style="cursor: hand" />
			<br />
		</logic:equal>
		<logic:equal value="4" name="infoDef" property="pidtype">
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<html:text property="pivarassetname[${index}]" size="18" readonly="readonly" /> 
			<img src="images/seek.gif" alt="查询" onclick="selectEntityItem(${index},1)" style="cursor: hand"/>
			<br />
			<html:hidden property="pivarvalue[${index}]" />
		</logic:equal>
		<logic:equal value="5" name="infoDef" property="pidtype">
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<html:text property="pivarprname[${index}]" size="18" readonly="readonly" /> 
			<img src="images/seek.gif" alt="查询" onclick="openSVCWindow(${index},1)" style="cursor: hand"/>
			<br />
			<html:hidden property="pivarvalue[${index}]" />
		</logic:equal>
		<logic:equal value="6" name="infoDef" property="pidtype">
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<html:text property="pivarprjname[${index}]" size="18" readonly="readonly" /> 
			<img src="images/seek.gif" alt="查询" onclick="selectProject(${index})" style="cursor: hand"/>
			<br />
			<html:hidden property="pivarvalue[${index}]" />
		</logic:equal>
		<logic:equal value="2" name="infoDef" property="pidtype">
			<bean:define id="pidid" name="infoDef" property="pidid" />
			<bean:define id="piddefault" name="infoDef" property="piddefault" />
			<bean:define id="optionMap" name="IGSVC04021VO" property="optionMap" type="java.util.Map"/>
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<logic:equal value="1" name="IGSVC0402Form" property="isFirst">
				<html:select property="pivarvalue[${index}]">
					<%
					String[] options = (String[])optionMap.get(pidid);
					for(int i = 0; i < options.length; i++){
					%>
					<html:option value="<%=options[i] %>" ><%=options[i] %></html:option>
					<%
					}
					 %>
				</html:select>
			</logic:equal>
			<logic:notEqual value="1" name="IGSVC0402Form" property="isFirst">
				<html:select property="pivarvalue[${index}]" value="${piddefault}">
					<%
					String[] options = (String[])optionMap.get(pidid);
					for(int i = 0; i < options.length; i++){
					%>
					<html:option value="<%=options[i] %>" ><%=options[i] %></html:option>
					<%
					}
					 %>
				</html:select>
			</logic:notEqual>
			<br />
		</logic:equal>
		<input type="hidden" name="pivarname" value="${infoDef.pidname}" />
		<input type="hidden" name="pivarlabel" value="${infoDef.pidlabel}" />
		<input type="hidden" name="pivartype" value="${infoDef.pidtype}" />
	</div>
	</logic:iterate>
	</logic:notEmpty>
	</logic:present>
	<div style="padding-left: 50px"><img src="images/attachment.gif" /><a
		href="javascript:addFile();" id="aAddAttach">添加附件</a>
	<table id="tb">
	</table>
	</div>
	</fieldset>
	<div class="enter"><html:submit styleClass="button" value="提交" onclick="return checkForm();"/>
	<html:reset styleClass="button" value="重置" /></div>
	<div class="Placeholder"></div>
	</div>
	<html:hidden property="pid"/>
	<html:hidden property="pcode"/>
	<html:hidden property="prassetid"/>
	<html:hidden property="prcorid"/>
	<html:hidden property="prcortype"/>
	<html:hidden property="prassetcategory"/>
	<html:hidden property="prpdid"/>
	<html:hidden property="prpdname"/>
	<html:hidden property="flag" />
</html:form></div>
</div>


</div>
</div>
</body>
</html:html>


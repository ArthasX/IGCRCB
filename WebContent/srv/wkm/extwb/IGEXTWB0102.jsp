<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<base target="_self" >
<bean:define id="id" value="IGEXTWB0102" toScope="request" />
<bean:define id="title"  toScope="request" >个人工作发起</bean:define>
<bean:define id="user" name="LOGIN_USER" scope="session" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var gid='IGEXTWB0102';
var num = 0;
var path = 0;
WebCalendar.timeShow   = true;          //是否返回时间
//改变角色名称(流程管理)
function changePrRolename(){
	var obj = document.forms[0].prroleid;
	document.forms[0].prrolename.value = obj.options[obj.selectedIndex].text;
}


function selectProject(){
	openSubWindow('/IGFIN0106_Disp.do?', '_project');
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
	if($F('prplantime').trim()==""){
		alert("请选择发生时间！");
		return false;
	}
	if($F('prtitle').trim()==""){
		alert("请输入工作名称！");
		return false;
	}
	if($F('prdesc').trim()==""){
		alert("请输入工作描述！");
		return false;
	}
	if($F('prinfo').strlen()>64){
		alert("联系方式不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('prtitle').strlen()>150){
		alert("工作名称不能大于"+Math.floor(150/strByteFlag)+"个汉字！");
		return false;
		
	}
	if($F('prdesc').strlen()>1000){
		alert("工作描述不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
		
		return false;
	}
	<logic:present name="IGEXTWB01021VO" property="processInfoDef">
	<logic:notEmpty name="IGEXTWB01021VO" property="processInfoDef">
	<logic:iterate id="infoDef" name="IGEXTWB01021VO" property="processInfoDef" indexId="index">
	<logic:equal value="1" name="infoDef" property="pidrequired">

	<logic:equal value="4" name="infoDef" property="pidtype">
        if($F('pivarvalue[${index}]').trim() == "" || document.getElementsByName("${infoDef.pidid}").length == 0){
	//	alert($F('pivarvalue[${index}]').trim() + "-----" + document.getElementsByName("${infoDef.pidid}").length);
            alert("请输入${infoDef.pidlabel}！");
            return false;
        }
        var tags = document.getElementsByTagName("INPUT");
		for(var i = 0; i < tags.length; i++){
			if(tags[i].name.indexOf("entityId") == 0) {
				if(tags[i].className == '1' && tags[i].value.trim() == ''){
					if(tags[i].style.pidid == '${infoDef.pidid}'){
					 	alert("请输入${infoDef.pidlabel}！");
					 	return false;
					}
				}
			}
		}
	</logic:equal>
	<logic:notEqual value="4" name="infoDef" property="pidtype">
		if($F('pivarvalue[${index}]').trim() == ""){
			 alert("请输入${infoDef.pidlabel}！");
			return false;
		}
	</logic:notEqual>
	</logic:equal>
	</logic:iterate>
	<logic:iterate id="infoDef" name="IGEXTWB01021VO" property="processInfoDef" indexId="index">
	if($F('pivarvalue[${index}]').strlen()>2000){
		alert("${infoDef.pidlabel}不能大于"+Math.floor(2000/strByteFlag)+"个汉字！");
		return false;
		}
	</logic:iterate>
	</logic:notEmpty>
	</logic:present>


	var tt = 0;
	for(var m = 0; m < asmNum; m++){
		if($("entityId[" + m + "]")==null){
			continue;
		}else{
			for(var n = 0; n < asmNum; n++){
				if($("entityId[" + n + "]")==null){
					continue;
				}else{
					if(m != n){
						var idm = $("entityId[" + m + "]").value;
						var idn = $("entityId[" + n + "]").value;
						if(idm == idn && idm != "" && idn != ""){
							tt = 1;
						}
					}
				}
			}
		}
		
	}
	
	if( tt == 1){
		//您在同一表单中选择了相同资产，是否确认提交？
		if(window.confirm('您在同一表单中选择了相同资产，是否确认提交？')){
			return true;
		} else {
			return false;
		}
	}else{
		//您是否确认提交？
		if( window.confirm('您是否确认提交？')){
			return true;
		} else {
			return false;
		}
	}
}
function selectBudget(){
	openSubWindow('/IGFIN0106_Disp.do?', 'budget','800','600');
}

function setParams(prcorid,prcortype,prcortitle){
	if(prcorid == ""){
		$("pivarvalue[" + num + "]").value = "";
		$("pivarprname[" + num + "]").value = "";
	} else {
        $("pivarvalue[" + num + "]").value = prcorid + "_svc_" + prcortype + "_name=" + prcortitle;
	    $("pivarprname[" + num + "]").value = prcortitle;
	}
   	num = 0;
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

function openSVCWindow(index){
	num = index;
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

var asmNum=0;
var temp=0;
function addEntity(pidid, index, required)  
{	
	temp=index;
	eval("currRow=tbentity" +pidid + ".insertRow();");
	cell=currRow.insertCell();
	if(pidid == 'A'){
		cell.innerHTML= "<input type='text' name='entityName["+asmNum+"]' size='18' readonly='true' errorStyleClass='inputError imeActive'><img src='images/seek.gif' name='" + index + "' border='0' width='16' height='16'  alt='查询'  onclick=\"selectEntity("+asmNum+", '" + pidid + "', " + index + ")\" style='cursor: hand'/>&nbsp;&nbsp;<img src='images/delate.gif'  alt='删除' onclick=\"deleteEntity(this, '" + pidid + "')\" style='cursor: hand'/><input type='hidden' name='entityId["+asmNum+"]' class='" + required +"' style='pidid:" + pidid + "'/><input type='hidden' name='" + pidid + "'/>";
	}else{
		cell.innerHTML= "<input type='text' name='entityName["+asmNum+"]' size='18' readonly='true' errorStyleClass='inputError imeActive'><img src='images/seek.gif' name='" + index + "' border='0' width='16' height='16'  alt='查询' onclick='selectEntity("+asmNum+", " + pidid + ", " + index + ")' style='cursor: hand'/>&nbsp;&nbsp;<img src='images/delate.gif'  alt='删除' onclick='deleteEntity(this, " + pidid + ")' style='cursor: hand'/><input type='hidden' name='entityId["+asmNum+"]' class='" + required +"' style='pidid:" + pidid + "'/><input type='hidden' name='" + pidid + "'/>";
	}
	asmNum++;
}

function deleteEntity(obj, pidid)
{
	var curRow= obj.parentNode.parentNode;
	$("tbentity" + pidid).deleteRow(curRow.rowIndex);

}

function selectEntity(index, pidid, name){
	num = index;
	temp = name;
	//openSubIGCOM0302PARAM('?pidid='+pidid);
	openSubIGCOM0327PARAM("?pidid="+pidid+"&flag=true");		
}

function setParamIGCOM0327(eid, elabel, ename, eiid, eilabel, einame, ecategory, pidid) {
	if("" == eiid){
		$("entityId[" + num + "]").value = "";
		$("entityname[" + num + "]").value = "";
	} else {
		$("entityId[" + num + "]").value = pidid + "#" + eiid;
		$("entityname[" + num + "]").value = einame;
		if(pidid != 'A'){
			$("pivarvalue[" + temp + "]").value = "N/A";
		}
	}

	num = 0;
}

function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory, pidid) {
		if("" == eiid){
			$("entityId[" + num + "]").value = "";
			$("entityname[" + num + "]").value = "";
		} else {
			$("entityId[" + num + "]").value = pidid + "#" + eiid;
			$("entityname[" + num + "]").value = einame;
			if(pidid != 'A'){
				$("pivarvalue[" + temp + "]").value = "N/A";
			}
		}
	
	num = 0;

}
</script>
<style>
html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	font-size: 12px;
	overflow-x: hidden;
	background-color: #FFFFFF;
}
</style>
<body onload="changePrRolename()">
<div id="maincontent" style="background-color: #FFFFFF; background-image: none;">
<div id="content">
<html:form action="/IGEXTWB0102_SOC" styleId="form" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	
	<div id="formwrapper">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset style="width:97%;"><legend>发起者信息 </legend>
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
	<fieldset><legend>个人工作信息</legend>
	<div><label for="Name"><strong>工作类型</strong>：</label>
	<p class="p2"><bean:write name="IGEXTWB0102Form" property="prpdname"/></p>
	</div>
	<div><label for="Name"><strong><span class="red">*</span>发生时间</strong>：</label>  <html:text
		property="prplantime" styleId="prplantime"
		errorStyleClass="inputError imeDisabled" size="18" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('prplantime'))"
		border="0" style="cursor: hand" /><br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>工作名称</strong>：</label> <html:text
		property="prtitle" size="82" errorStyleClass="inputError imeActive"/> <br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>工作描述</strong>：</label> <html:textarea
		property="prdesc" cols="60" rows="6" errorStyleClass="inputError imeActive" value = "${IGEXTWB0102Form.prdesc}"></html:textarea> <br />
	</div>
	<div><label for="Name"><strong>相关资产</strong>：</label>
		<img src="images/addasm.gif" alt="查询" style="cursor: hand"/>
		<a href="javascript:addEntity('A', 'A','0');" id="aAddEntity">添加资产</a> <br />
		<table id="tbentityA">
		</table>
	</div>

	
	<logic:present name="IGEXTWB01021VO" property="processInfoDef">
	<logic:notEmpty name="IGEXTWB01021VO" property="processInfoDef">
	<logic:iterate id="infoDef" name="IGEXTWB01021VO" property="processInfoDef" indexId="index">
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
			<img src="images/addasm.gif" alt="查询" style="cursor: hand"/>
			<a href="javascript:addEntity('${infoDef.pidid}', ${index},
									<logic:equal value="1" name="infoDef" property="pidrequired">'1'</logic:equal>
									<logic:equal value="0" name="infoDef" property="pidrequired">'0'</logic:equal>
										);" id="aAddEntity"><bean:message bundle="wkmResources" key="button.IGEXTWB0105.addproperty"/></a> <br />
			<table id="tbentity${infoDef.pidid}">
			</table>
			<html:hidden property="pivarvalue[${index}]" />
		</logic:equal>
		<logic:equal value="5" name="infoDef" property="pidtype">
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<html:text property="pivarprname[${index}]" size="18" readonly="true" /> 
			<img src="images/seek.gif" alt="查询" onclick="openSVCWindow(${index})" style="cursor: hand"/>
			<br />
			<html:hidden property="pivarvalue[${index}]" />
		</logic:equal>
		<logic:equal value="6" name="infoDef" property="pidtype">
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<html:text property="pivarprjname[${index}]" size="18" readonly="true" /> 
			<img src="images/seek.gif" alt="查询" onclick="selectProject(${index})" style="cursor: hand"/>
			<br />
			<html:hidden property="pivarvalue[${index}]" />
		</logic:equal>
		<logic:equal value="2" name="infoDef" property="pidtype">
			<bean:define id="pidid" name="infoDef" property="pidid" />
			<bean:define id="piddefault" name="infoDef" property="piddefault" />
			<bean:define id="optionMap" name="IGEXTWB01021VO" property="optionMap" type="java.util.Map"/>
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<logic:equal value="1" name="IGEXTWB0102Form" property="isFirst">
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
			<logic:notEqual value="1" name="IGEXTWB0102Form" property="isFirst">
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
	<div class="enter" style="width:97%;"><html:submit styleClass="button"  onclick="return checkForm();">
	提交
	</html:submit>
	<html:reset styleClass="button" >
	重置
	</html:reset>
	</div>
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
</body>
</html:html>


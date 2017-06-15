<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>

<html>
<base target="_self">
<bean:define id="id" value="IGPRR0101" toScope="request" />
<bean:define id="title" value="工作信息" toScope="request" />
<% 
	String lastrowwidth = "";
	String trStartTag = "";
	String trEndTag = "";
	String tdStartTag = "";
	String textSize = "32";
	String textAreaSize = "25";
	int columnNum = 0;
	boolean privateIsNull = true;
%>
<link rel="stylesheet" href="<html:rewrite forward='pdimgstyle.css'/>" type="text/css">
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var gid='IGPRR0101';
var num = 0;

function selectTree(index,ccidinfo){
	num = index;
	var ccid = ccidinfo.split("_tree_")[0];
	url = "IGSYM1505_TREE.do" + "?ccid="+ccid;

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");

	if("_resetall"==temp){
		$("pivarvalue[" + num + "]").value = "";
		$("pivartreename[" + num + "]").value = "";
	}else if(null!=temp && temp.split("|").length>1){
		var id = temp.split("|")[0];
		var name = temp.split("|")[1];
		var treeccid;
		var treecid;
		var treesyscode;
		
		if(id.split("_").length>1){
			treeccid = id.split("_")[0];
			treecid = id.split("_")[1];
			treesyscode = id.split("_")[2];
		}else{
			treeccid = id.split("_")[0];
			treecid = "";
			treesyscode = "";
		}

		if(treesyscode!=null && name!=null && treesyscode != ''){
			$("pivarvalue[" + num + "]").value = treesyscode + "_tree_" + name;
			$("pivartreename[" + num + "]").value = name;
		}else{
			$("pivarvalue[" + num + "]").value = '';
			$("pivartreename[" + num + "]").value = '';
		}
		
	}		

	num = 0;
}

function selectRole(){
	var roleid = document.getElementById("prroleid").value;
	var pdid = document.getElementById("pdid").value;
	document.location.replace(getAppRootUrl() + "/IGPRR0101_Disp.do?psdcode=<%=IGPRDCONSTANTS.PROCESS_START_STATUS%>&pdid="+pdid+"&roleid="+roleid);

}
function changePrRolename(){
	var obj = IGPRR0101Form.prroleid;
	IGPRR0101Form.prrolename.value = obj.options[obj.selectedIndex].text;
}
function selectEntityItem(index){
    num = index;
    openSubIGCOM0302();
}

function selectProject(index){
	num = index;
	openSubWindow('/IGFIN0108_Disp.do', '_blank','1000','600');
}
function openSVCPage(index){
	num = index;
	openSubWindow('/IGSVC0107_Disp.do', '_blank','1000','600');
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

function selectRoleOnIGSYM0306(index,pdid){
    num = index;
    openSubIGSYM0306(pdid);
}
function setRoleParams(roleid,rolename) {
	if("" == roleid){
		$("pivarvalue[" + num + "]").value = "";
		$("pivarrolename[" + num + "]").value = "";
	} else {
		$("pivarvalue[" + num + "]").value = roleid + "_role_" + rolename;
		$("pivarrolename[" + num + "]").value = rolename;
	}
	num = 0;
}

function setRadio(index,obj){
	$("pivarvalue[" + index + "]").value = obj.value;
}

function setRadio_other(index,obj,obj2){
	$("pivarvalue[" + index + "]").value = obj.value;
	if(obj2 == 'other'){
		$("pivarvalue_Other[" + index + "]").value = "";
		$("pivarvalue_Other[" + index + "]").style.display = "";
	}else{
		$("pivarvalue_Other[" + index + "]").style.display = "none";
	}
}
function setOnChage_other(index,obj){
	$("pivarvalue[" + index + "]").value = obj.value;
	$("pivarradio_Other[" + index + "]").value = obj.value;
}

function setCheckbox(index,obj){
	var checkboxvalue = $("pivarvalue[" + index + "]").value;
	if(obj.checked){
		if(checkboxvalue == ""){
			checkboxvalue = obj.value;
		}else{
			checkboxvalue = checkboxvalue+"#"+obj.value;
		}
	}else{
		var afterDelValue = "";
		var str = checkboxvalue.split("#");
		for(var i=0; i<str.length;i++){
			if(str[i] != obj.value){
				if(i == 0){
					afterDelValue = str[i];
				}else{
					afterDelValue += "#"+str[i];
				}
			}
		}
		checkboxvalue = afterDelValue;
	}
	$("pivarvalue[" + index + "]").value = checkboxvalue;
}
function checkForm(action){

	var title = "";
	var desc = "";
	<logic:present name="IGPRR01011VO" property="processTitleDefTB">
		<bean:define id="processTitleTB" name="IGPRR01011VO" property="processTitleDefTB" type="com.deliverik.framework.workflow.prd.model.IG243Info" />
		<logic:equal value="<%=IGPRDCONSTANTS.PROCESSTITLE_DEFAULT %>" name="processTitleTB" property="ptitleaccess">
			<logic:empty name="processTitleTB" property="ptitlename">
				title="主题简述";
			</logic:empty>
			<logic:notEmpty name="processTitleTB" property="ptitlename">
				title="${processTitleTB.ptitlename}";
			</logic:notEmpty>
			if($F('prtitle').trim()==""){
				alert("请输入"+title+"！");
				return false;
			}
			if($F('prtitle').strlen()>150){
				alert(title+"不能大于"+Math.floor(150/strByteFlag)+"个汉字！");
				return false;
			}
		</logic:equal>
		<logic:equal value="0" name="processTitleTB" property="pdescaccess">
			<logic:empty name="processTitleTB" property="pdescname">
				desc="内容描述";
			</logic:empty>
			<logic:notEmpty name="processTitleTB" property="pdescname">
				desc="${processTitleTB.pdescname}";
			</logic:notEmpty>
			if($F('prdesc').trim()==""){
				alert("请输入"+desc+"！");
				return false;
			}
			if($F('prdesc').strlen()>3000){
				alert(desc+"不能大于"+Math.floor(3000/strByteFlag)+"个汉字！");
				return false;
			}
		</logic:equal>
	</logic:present>
	
	<logic:present name="IGPRR01011VO" property="processInfoDefmap">
		<logic:iterate id="map" name="IGPRR01011VO" property="processInfoDefmap" indexId="index" >
			<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
			<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
			<logic:present name="psid">
				<logic:equal name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>">
					<logic:equal value="1" name="psid" property="pidrequired">
						if($F('pivarvalue[${index}]').trim() == ""){
							alert("请输入${psid.pidlabel}！");
							return false;
						}
					</logic:equal>
					<logic:equal value="7" name="psid" property="pidtype">
						if(checkFloatNum($F('pivarvalue[${index}]'))){
				    		alert("${psid.pidlabel}为数字,整数位最多13位,小数位最多2位!");
							return false;
						}
					</logic:equal>
					if($F('pivarvalue[${index}]').strlen()>3000){
						alert("${psid.pidlabel}不能大于"+Math.floor(3000/strByteFlag)+"个汉字！");
						return false;
					}
				</logic:equal>
			</logic:present>
		</logic:iterate>
	</logic:present>

	var pdid = document.getElementById("pdid").value;
	if(pdid!="0114001"){
		if($F('ppusernames') == ""){
			alert('请选择参与人');
			return false;
		}
	}
	if( window.confirm("您是否确认提交？")){
		$("action").value = action;
		if($F('prtitle').trim()=="" && $F('prdesc').trim() !="" ){
			$("prtitle").value = $("prdesc").value;
		}
		if($F('prtitle').trim() !="" && $F('prdesc').trim() =="" ){
			$("prdesc").value = $("prtitle").value;
		}
		if($F('prtitle').trim()=="" && $F('prdesc').trim() =="" ){
			$("prdesc").value = "${IGPRR0101Form.prusername}"+"_"+"${IGPRR0101Form.prpdname}";
			$("prtitle").value = "${IGPRR0101Form.prusername}"+"_"+"${IGPRR0101Form.prpdname}";
		}
		return true;
	} else {
		return false;
	}
}

function ShowpProcessFlow(){
	window.showModalDialog(getAppRootUrl() + '/IGPRR0111_Disp.do?pdid=${IGPRR0101Form.pdid}&psdid=${IGPRR0101Form.psdid}',null,"dialogWidth:1000px;dialogHeight:600px;status:no;help:no;resizable:yes");
}
//单一表单多资产的下标
var asmNum=0;
//多个表单的表单下标
var tp=0;
function addEntity(pidid, index, required) 
{	

	tp=index;
	eval("currRow=tbentity" +pidid + ".insertRow();");
	cell=currRow.insertCell();
	cell.innerHTML= "<input type='text' name='entityName["+asmNum+"]' size='18' readonly='true' errorStyleClass='inputError imeActive'><img src='images/seek.gif' border='0' width='16' height='16' alt='查询' onclick=\"selectEntity("+asmNum+", '" + pidid + "')\" style='cursor: hand'/>&nbsp;&nbsp;<img src='images/delate.gif' alt='删除' onclick=\"deleteEntity(this, '" + pidid + "')\" style='cursor: hand'/><input type='hidden' name='entityId["+asmNum+"]' class='" + required +"'/><input type='hidden' name='" + pidid + "'/>";
	asmNum++;
	
}

function deleteEntity(obj, pidid)
{
	var curRow= obj.parentNode.parentNode;
	$("tbentity" + pidid).deleteRow(curRow.rowIndex);

}

function selectEntity(index, pidid){
	num = index;
	//openSubIGCOM0302PARAM('?pidid='+pidid);
	openSubIGCOM0327PARAM("?pidid="+pidid+"&flag=true");		
}

function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory, pidid) {
	if("" == eiid){
		$("entityId[" + num + "]").value = "";
		$("entityname[" + num + "]").value = "";
	} else {
		$("entityId[" + num + "]").value = pidid + "#" + eiid;
		$("entityname[" + num + "]").value = einame;
		if(pidid != 'A'){
			$("pivarvalue[" + tp + "]").value = "N/A";
		}
	}

	num = 0;
}

function setParamIGCOM0327(eid, elabel, ename, eiid, eilabel, einame, ecategory, pidid) {
	if("" == eiid){
		$("entityId[" + num + "]").value = "";
		$("entityname[" + num + "]").value = "";
	} else {
		$("entityId[" + num + "]").value = pidid + "#" + eiid;
		$("entityname[" + num + "]").value = einame;
		if(pidid != 'A'){
			$("pivarvalue[" + tp + "]").value = "N/A";
		}
	}

	num = 0;
}

function selectRoleUser(roleid){
	openSubWindow('/IGSYM0405.do?roleida='+roleid , 'newpage', '800', '600');
}
function setParamRoleUser(userid,username,roleid,orgid,orgname){
	var check=document.getElementsByName("roleids");
	for(var i=0;i<check.length;i++){
		if(check[i].value==roleid){
			document.getElementsByName("ppuserids")[i].value = userid;
			document.getElementsByName("ppusernames")[i].value = username;
			document.getElementsByName("pporgids")[i].value = orgid;
			document.getElementsByName("pporgnames")[i].value = orgname;
			break;
		}
	}
}
</script>
<body>
<div id="maincontent"><!--container 左菜单 右侧内容-->
<div id="container"><!-- content 右侧内容 -->
<div id="contentWrap">
<div id="content"><html:form action="/IGPRR0101_SOC" styleId="form"
	onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div id="formwrapper"><!--  message -->
	<fieldset>
	<legend>发起人信息 </legend>
		<div><label for="Name"><strong>发起人角色</strong>：</label>
			<logic:present name="IGPRR01011VO" property="disp">
				<logic:equal value="0" name="IGPRR01011VO" property="disp">
					<html:select property="prroleid" errorStyleClass="inputError imeActive"
						tabindex="2" styleId = "prroleid" onchange="selectRole();" name="IGPRR0101Form">
					<html:options collection="ADroleList" property="value" name="" labelProperty="label"/>
					</html:select>
					<html:hidden property="prrolename" name="IGPRR0101Form" styleId="prrolename"/>
				</logic:equal>
				<logic:notEqual value="0" name="IGPRR01011VO" property="disp">
					<html:text property="prrolename" size="18" errorStyleClass="inputError imeActive" 
					readonly="true" name="IGPRR0101Form" styleId="prrolename"/>
					<html:hidden property="prroleid" name="IGPRR0101Form" styleId="prroleid"/>
				</logic:notEqual>
			</logic:present>
	    </div>
		<div><label for="Name"><strong>发起人姓名</strong>：</label>
		<html:text property="prusername" size="18" errorStyleClass="inputError imeActive"  readonly="true"></html:text>
	    <html:hidden property="pruserid" />
	    </div>
		<div><label for="Name"><strong>发起人部门</strong>：</label>
		<html:text property="prorgname" size="18" errorStyleClass="inputError imeActive"  readonly="true"></html:text>
		<html:hidden property="prorgid" />
		</div>
		<div><label for="Name"><strong>发起人联系方式</strong>：</label>
	    <html:text property="prinfo" size="18" errorStyleClass="inputError imeActive" readonly="true"></html:text>
	    </div>
	</fieldset>
	</div>
	<div style="margin-top:10px;margin-left:40px;float: left">
		<a href="javascript:ShowpProcessFlow();">查看流程图</a>
	</div>
	<div id="formwrapper"><ig:message />
	<fieldset>
	<legend>工单信息</legend>
		<table cellspacing="2" class="table_style1">
		<tr style="display:none">
			<th width="15%"></th><td width="35%"></td><th width="15%"></th><td width="35%"></td>
		</tr>
		<logic:present name="IGPRR01011VO" property="processTitleDefTB">
			<bean:define id="processTitleTB" name="IGPRR01011VO" property="processTitleDefTB" type="com.deliverik.framework.workflow.prd.model.IG243Info" />
			<logic:equal value="<%=IGPRDCONSTANTS.PROCESSTITLE_DEFAULT %>" name="processTitleTB" property="ptitleaccess">
			<tr>	
				<th>
					<label for="Name" style="float: right;"><strong>流程类型</strong>：</label>
				</th>
				<td colspan="3"><p class="p2">&nbsp;&nbsp;<bean:write name="IGPRR0101Form" property="prpdname"/></p><!-- <html:text property="prtitle" size="82" errorStyleClass="inputError imeActive" /> -->
				</td>
			</tr>
			<tr>
				<th>
					<label for="Name" style="float: right;"><strong><span class="red">*</span>
					<logic:empty name="processTitleTB" property="ptitlename">
						主题简述
					</logic:empty>
					<logic:notEmpty name="processTitleTB" property="ptitlename">${processTitleTB.ptitlename}</logic:notEmpty></strong>：</label>
				</th>
				<td colspan="3"><html:text property="prtitle" size="82" errorStyleClass="inputError imeActive" />
				</td>
			</tr>
			</logic:equal>
			<logic:equal value="<%=IGPRDCONSTANTS.PROCESSTITLE_DEFAULT %>" name="processTitleTB" property="pdescaccess">
			<tr>
				<th><label for="Name" style="float: right;"><strong><span class="red">*</span><logic:empty name="processTitleTB" property="pdescname">内容描述</logic:empty>
				<logic:notEmpty name="processTitleTB" property="pdescname">${processTitleTB.pdescname}</logic:notEmpty></strong>：</label>
				</th>
				<td colspan="3">
				<html:textarea property="prdesc" cols="60" rows="6"  errorStyleClass="inputError imeActive"></html:textarea></td>
			</tr>
			</logic:equal>
			<logic:equal value="<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>" name="processTitleTB" property="pdescaccess">
				<html:hidden property="prdesc"/>
			</logic:equal>
			<logic:equal value="<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>" name="processTitleTB" property="ptitleaccess">
				<html:hidden property="prtitle"/>
			</logic:equal>
		</logic:present>
	<logic:present name="IGPRR01011VO" property="processInfoDefmap">
		<logic:iterate id="map" name="IGPRR01011VO" property="processInfoDefmap" indexId="index" >
			<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
			<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
			<logic:present name="psid">
			<% 
			if("2".equalsIgnoreCase(psid.getPidaccess()) || "3".equalsIgnoreCase(psid.getPidaccess()) || "4".equalsIgnoreCase(psid.getPidaccess())){
					String rowwidth = StringUtils.isEmpty(psid.getRowwidth())?"0":psid.getRowwidth().trim();
					rowwidth = StringUtils.isEmpty(rowwidth)?"0":rowwidth;
					tdStartTag = "<td>";
					textSize = "32";
					textAreaSize = "25";
					if(StringUtils.isEmpty(lastrowwidth)){
						trStartTag = "<tr>";
						if("0".equals(rowwidth)){
							tdStartTag = "<td colspan=\"3\">";
						}
					}
					if("0".equalsIgnoreCase(lastrowwidth)){
						trStartTag = "</tr><tr>";
						if("0".equals(rowwidth)){
							tdStartTag = "<td colspan=\"3\">";
						}
					}
					if("1".equalsIgnoreCase(lastrowwidth)){
						if("0".equals(rowwidth)){
							if(columnNum == 0){
								trStartTag = "</tr><tr>";
							}else{
								trStartTag = "<td></td><td></td></tr><tr>";
							}
							tdStartTag = "<td colspan=\"3\">";
						}else{
							if(columnNum == 0){
								trStartTag = "</tr><tr>";
							}else{
								trStartTag = "";
							}
						}
					}
					if("0".equalsIgnoreCase(rowwidth)){
						columnNum = 0;
					}else{
						columnNum = (columnNum+1)%2;
					}
					lastrowwidth = rowwidth;
					if("0".equals(rowwidth)){
						textSize = "82";
						textAreaSize = "60";
					}
				}
				%>
				<logic:equal name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>">
				<%=trStartTag %>
					<th>
						<label for="Name" style="float: right;"><strong>
						<logic:equal value="1" name="psid" property="pidrequired"><span class="red">*</span></logic:equal>
						${psid.pidlabel}</strong>：</label>
					</th>
					<%=tdStartTag %>
					<logic:equal value="0" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0101Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" size="<%= textSize%>" errorStyleClass="inputError imeActive"/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0101Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" size="<%= textSize%>" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" />
						</logic:notEqual>
					</logic:equal>
					<logic:equal value="3" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0101Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" size="32" readonly="true" errorStyleClass="inputError imeActive"/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0101Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" size="32" readonly="true" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" />
						</logic:notEqual>
						<img src="images/date.gif" align="middle" onclick="showDate($('pivarvalue[${index}]'))" style="cursor: hand" />
					</logic:equal>
					<logic:equal value="A" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0101Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" size="32" readonly="true" errorStyleClass="inputError imeActive"/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0101Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" size="32" readonly="true" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" />
						</logic:notEqual>
						<img src="images/date.gif" align="middle" onclick="showTime($('pivarvalue[${index}]'))" style="cursor: hand" />
					</logic:equal>
					<logic:equal value="7" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0101Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" styleId="pivarvalue[${index}]" errorStyleClass="inputError imeDisabled" size="32" readonly="true" /> 
                       		<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('pivarvalue[${index}]'))" border="0" style="cursor: hand"/>
                       		<a href="javascript:clear($('pivarvalue[${index}]'));">清空</a><br/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0101Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" styleId="pivarvalue[${index}]" errorStyleClass="inputError imeDisabled" size="32" readonly="true" value="${psid.pidvalue}" /> 
                       		<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('pivarvalue[${index}]'))" border="0" style="cursor: hand"/>
                       		<a href="javascript:clear($('pivarvalue[${index}]'));">清空</a><br/>
						</logic:notEqual>
					</logic:equal>
					<logic:equal value="4" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0101Form" property="isFirst">
							<html:text property="pivarassetname[${index}]" size="18" readonly="true"/> 
							<img src="images/seek.gif" alt='查询' onclick="selectEntityItem(${index})" style="cursor: hand"/>
							<html:hidden property="pivarvalue[${index}]"/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0101Form" property="isFirst">
							<img src="images/addasm.gif" alt='查询' style="cursor: hand"/>
							<a href="javascript:addEntity('${psid.pidid}', ${index},
									<logic:equal value="1" name="psid" property="pidrequired">'1'</logic:equal>
									<logic:equal value="0" name="psid" property="pidrequired">'0'</logic:equal>
										);" id="aAddEntity">添加资产</a> <br />
							<table id="tbentity${psid.pidid}">
							</table>
							<html:hidden property="pivarvalue[${index}]" />
						</logic:notEqual>
					</logic:equal>
					<logic:equal value="5" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0101Form" property="isFirst">
								<html:text property="pivarprname[${index}]" size="32" readonly="true"/> 
								<img src="images/seek.gif" alt="查询" onclick="openSVCPage(${index})" style="cursor: hand"/>
								<html:hidden property="pivarvalue[${index}]"/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0101Form" property="isFirst">
								<html:text property="pivarprname[${index}]" size="32" readonly="true" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_svc_"))?"":psid.getPidvalue().split("_svc_")[1].split("_name=")[1] %>' /> 
								<img src="images/seek.gif" alt="查询" onclick="openSVCPage(${index})" style="cursor: hand"/>
								<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
						</logic:notEqual>
					</logic:equal>
					<logic:equal value="6" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0101Form" property="isFirst">
								<html:text property="pivarprjname[${index}]" size="32" readonly="true"/> 
								<img src="images/seek.gif" alt="查询" onclick="selectProject(${index})" style="cursor: hand"/>
								<html:hidden property="pivarvalue[${index}]"/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0101Form" property="isFirst">
								<html:text property="pivarprjname[${index}]" size="32" readonly="true" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_prj_"))?"":psid.getPidvalue().split("_prj_")[1] %>'/> 
								<img src="images/seek.gif" alt="查询" onclick="selectProject(${index})" style="cursor: hand"/>
								<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
						</logic:notEqual>
					</logic:equal>
					<logic:equal value="T" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0101Form" property="isFirst">
							<html:text property="pivartreename[${index}]" size="32" readonly="true"/> 
							<img src="images/seek.gif" alt='查询' onclick="selectTree(${index},'${psid.ccid}')" style="cursor: hand"/>
							<html:hidden property="pivarvalue[${index}]"/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0101Form" property="isFirst">
							<html:text property="pivartreename[${index}]" size="32" readonly="true" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_tree_"))?"":psid.getPidvalue().split("_tree_")[1] %>' /> 
							<img src="images/seek.gif" alt='查询' onclick="selectTree(${index},'${psid.ccid}')" style="cursor: hand"/>
							<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
						</logic:notEqual>
					</logic:equal>
					<logic:equal value="9" name="psid" property="pidtype">
						<html:textarea property="pivarvalue[${index}]" errorStyleClass="inputError" rows="5" cols="<%= textAreaSize%>" value="${psid.pidvalue}"/>
						<img src="images/attachment.gif" /><a href="javascript:addFileMuti('${psid.pidlabel}')" id="aAddAttachMuti">添加附件</a>&nbsp;&nbsp;&nbsp;
						<table id="${psid.pidlabel}">
						</table>	
							<logic:present name="IGPRR01011VO" property="textAreaMap">
									<logic:notEmpty	name="IGPRR01011VO" property="textAreaMap">
											<bean:define id="a" name="IGPRR01011VO" property="textAreaMap" type="java.util.Map" />
											
											<logic:iterate id="map" name="IGPRR01011VO"	property="textAreaMap" indexId="number">
											<bean:define id="category" name="map" property="key"/>
											<bean:define id="list" name="map" property="value"	type="java.util.ArrayList" />
												
											
											<logic:equal name="map" property="key" value="${psid.pidlabel}">
											<br>
												<logic:iterate id="attachment" name="list" indexId="number">
												
													<a href="downloadSvcFile.do?attId=${attachment.attid}&type=prr" id="${attachment.attid}">
														<bean:define id="attname" name="attachment" property="attname" />
														<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
													</a>
													<img id="${attachment.attid}IMG" src="images/delate.gif" align="middle" onClick="delFile('${attachment.attid}','${psid.pidname}')" border="0" style="cursor: hand" alt="删除"/>
													
													<br />
												</logic:iterate>
											</logic:equal>
												
											</logic:iterate>
										<input type="hidden" name="strpsid" value=""/>
									</logic:notEmpty>
								</logic:present>
					</logic:equal>
					<logic:equal value="2" name="psid" property="pidtype">
						<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
						<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
						<bean:define id="optionMap" name="IGPRR01011VO" property="optionMap" type="java.util.Map"/>
						<logic:equal value="1" name="IGPRR0101Form" property="isFirst">
							<html:select property="pivarvalue[${index}]">
								<%
								String[] options = (String[])optionMap.get(pidid);
								for(int i = 0; i < options.length; i++){
								%>
								<html:option value="<%=options[i] %>" ><%=options[i]%></html:option>
								<%
								}
								 %>
							</html:select>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0101Form" property="isFirst">
							<html:select property="pivarvalue[${index}]" value='<%=StringUtils.isEmpty(psid.getPidvalue())?piddefault:psid.getPidvalue() %>'>
								<%
								String[] options = (String[])optionMap.get(pidid);
								for(int i = 0; i < options.length; i++){
								%>
								<html:option value="<%=options[i] %>" ><%=options[i]%></html:option>
								<%
								}
								 %>
							</html:select>
						</logic:notEqual>
					</logic:equal>
					<logic:equal value="B" name="psid" property="pidtype">
						<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
						<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
						<bean:define id="optionMap" name="IGPRR01011VO" property="optionMap" type="java.util.Map"/>
						<%
							String checkboxvalue = StringUtils.isEmpty(psid.getPidvalue())?piddefault:psid.getPidvalue();
							String[] options = (String[])optionMap.get(pidid);
							for(int iRadio = 0; iRadio < options.length; iRadio++){
								if(StringUtils.isNotEmpty(options[iRadio])){
									String checked = "";
									if(options[iRadio].equals(checkboxvalue)){
										checked = "checked=\"checked\"";
									}
						%>
								<span style="display:inline-block">
									<input type="radio" name="pivarradio[${index}]" value="<%=options[iRadio] %>" onclick="setRadio(${index},this)" <%=checked %>/><%=options[iRadio] %>
								</span>
						<%
								}
							}
						%>
						<html:hidden property="pivarvalue[${index}]" value="${piddefault}"/>
					</logic:equal>
					<logic:equal value="E" name="psid" property="pidtype">
						<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
						<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
						<bean:define id="optionMap" name="IGPRR01011VO" property="optionMap" type="java.util.Map"/>
						<%
							String checkboxvalue = StringUtils.isEmpty(psid.getPidvalue())?piddefault:psid.getPidvalue();
							String[] options = (String[])optionMap.get(pidid);
							boolean radio_flag = true;
							
							for(int iRadio = 0; iRadio < options.length; iRadio++){
								if(StringUtils.isNotEmpty(options[iRadio])){
									String checked = "";
									if(options[iRadio].equals(checkboxvalue)){
										checked = "checked=\"checked\"";
										radio_flag = false;
									}
						%>
								<span style="display:inline-block">
									<input type="radio" name="pivarradio[${index}]" value="<%=options[iRadio] %>" onclick="setRadio_other(${index},this)" <%=checked %>/><%=options[iRadio] %>
								</span>
						<%
								}
							}
							String checked_other = "";
							String display_other = "";
							if(radio_flag){
								checked_other = "checked=\"checked\"";
							}else{
								display_other = "display: none;";
							}
						%>
								<input id="pivarradio_Other[${index}]" type="radio" name="pivarradio[${index}]" value="<%=checkboxvalue %>" onclick="setRadio_other(${index},this,'other')" <%=checked_other %>/>其他 
								<html:text style="<%=display_other %>" styleId="pivarvalue_Other[${index}]" property="pivarvalue[${index}]" size="18" errorStyleClass="inputError imeActive"
								  value="<%=checkboxvalue %>" onchange="setOnChage_other(${index},this)" /> 
						<html:hidden property="pivarvalue[${index}]" value="${piddefault}"/>
					</logic:equal>	
					<logic:equal value="C" name="psid" property="pidtype">
						<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
						<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
						<bean:define id="optionMap" name="IGPRR01011VO" property="optionMap" type="java.util.Map"/>
						<%
							String checkboxvalue = StringUtils.isEmpty(psid.getPidvalue())?"":psid.getPidvalue();
							String[] boxValues = checkboxvalue.split("#");
							String[] options = (String[])optionMap.get(pidid);
							for(int iCheckbox = 0; iCheckbox < options.length; iCheckbox++){
								if(StringUtils.isNotEmpty(options[iCheckbox])){
									String checked = "";
									for(int iValue = 0; iValue < boxValues.length; iValue++){
										if(options[iCheckbox].equals(boxValues[iValue])){
											checked = "checked";
										}
									}
						%>
							<span style="display:inline-block">
									<input type="checkbox" name="pivarcheckbox[${index}]" value="<%=options[iCheckbox] %>" onclick="setCheckbox(${index},this)" <%=checked %>/><%=options[iCheckbox] %>
							</span>
						<%
								}
							}
						%>
						<html:hidden property="pivarvalue[${index}]" value="<%=checkboxvalue %>"/>
					</logic:equal>
					
					<logic:equal value="R" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0101Form" property="isFirst">
							<html:text property="pivarrolename[${index}]" size="32" readonly="true"/> 
							<img src="images/seek.gif" alt="查询" onclick="selectRoleOnIGSYM0306(${index},'${psid.pdid}')" style="cursor: hand"/>
							<html:hidden property="pivarvalue[${index}]"/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0101Form" property="isFirst">
							<html:text property="pivarrolename[${index}]" size="32" readonly="true" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_role_"))?"":psid.getPidvalue().split("_role_")[1] %>' /> 
							<img src="images/seek.gif" alt="查询" onclick="selectRoleOnIGSYM0306(${index},'${psid.pdid}')" style="cursor: hand"/>
							<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
						</logic:notEqual>
					</logic:equal>
					</td>
				</logic:equal>
			
				<logic:equal name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE %>">
				<%=trStartTag %>
							<th>
					<label for="Name"><strong>${psid.pidlabel}</strong>：</label>
					</th>
							<%=tdStartTag %>
					<logic:equal value="0" name="psid" property="pidtype">
						<html:text property="pivarvalue[${index}]" size="<%= textSize%>" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" readonly="true" styleClass="inputDisable"/>
					</logic:equal>
					<logic:equal value="3" name="psid" property="pidtype">
						<html:text property="pivarvalue[${index}]" size="<%= textSize%>" readonly="true" errorStyleClass="inputError imeActive"
						 value="${psid.pidvalue}" styleClass="inputDisable"/> 
					</logic:equal>
					<logic:equal value="A" name="psid" property="pidtype">
						<html:text property="pivarvalue[${index}]" size="32" readonly="true" errorStyleClass="inputError imeActive"
						 value="${psid.pidvalue}" styleClass="inputDisable" /> 
					</logic:equal>
					<logic:equal value="7" name="psid" property="pidtype">
						<html:text property="pivarvalue[${index}]" size="32" readonly="true" errorStyleClass="inputError imeActive"
						 value="${psid.pidvalue}" styleClass="inputDisable" /> 
					</logic:equal>
					<logic:equal value="4" name="psid" property="pidtype">
						<%if(StringUtils.isNotEmpty(psid.getPidvalue()) && psid.getPidvalue().contains("_asset_")){ %>
						<a href="javascript:void(0)" onclick="openSubIGCOM0303('<%=psid.getPidvalue().split("_asset_")[0] %>','')">
								<%=psid.getPidvalue().split("_asset_")[1] %> </a>
						<%} %>
						<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
					</logic:equal>
					<logic:equal value="4" name="psid" property="pidtype">
						
						<table id="tbentity1">
						</table>
						<html:hidden property="pivarvalue[${index}]" />
					</logic:equal>
					<logic:equal value="5" name="psid" property="pidtype">
						<%if(StringUtils.isNotEmpty(psid.getPidvalue()) && psid.getPidvalue().contains("_svc_")){ %>
						<a href="javascript:openRelatedProcess('<%=psid.getPidvalue().split("_svc_")[0] %>',
						'<%=psid.getPidvalue().split("_svc_")[1].split("_name=")[0] %>')">
						<%=psid.getPidvalue().split("_svc_")[1].split("_name=")[1]%>
						</a>
						<%} %>
						<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
					</logic:equal>
					<logic:equal value="6" name="psid" property="pidtype">
						<%if(StringUtils.isNotEmpty(psid.getPidvalue()) && psid.getPidvalue().contains("_prj_")){
						out.print(psid.getPidvalue().split("_prj_")[1]);
						}%>
						<input type="hidden" name="pivarvalue[${index}]" value="${psid.pidvalue}"/>
					</logic:equal>
					<logic:equal value="B" name="psid" property="pidtype">
						<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
						<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
						<bean:define id="optionMap" name="IGPRR01011VO" property="optionMap" type="java.util.Map"/>
						<%
							String checkboxvalue = StringUtils.isEmpty(psid.getPidvalue())?piddefault:psid.getPidvalue();
							String[] options = (String[])optionMap.get(pidid);
							for(int iRadio = 0; iRadio < options.length; iRadio++){
								if(StringUtils.isNotEmpty(options[iRadio])){
									String checked = "";
									if(options[iRadio].equals(checkboxvalue)){
										checked = "checked=\"checked\"";
									}
						%>
									<input type="radio" name="pivarradio[${index}]" value="<%=options[iRadio] %>" onclick="setRadio(${index},this)" <%=checked %> disabled="disabled" /><%=options[iRadio] %>
						<%
								}
							}
						%>
						<html:hidden property="pivarvalue[${index}]" value="${piddefault}"/>
					</logic:equal>
					<logic:equal value="E" name="psid" property="pidtype">
						<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
						<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
						<bean:define id="optionMap" name="IGPRR01011VO" property="optionMap" type="java.util.Map"/>
						<%
							String checkboxvalue = StringUtils.isEmpty(psid.getPidvalue())?piddefault:psid.getPidvalue();
							String[] options = (String[])optionMap.get(pidid);
							boolean radio_flag = true;
							
							for(int iRadio = 0; iRadio < options.length; iRadio++){
								if(StringUtils.isNotEmpty(options[iRadio])){
									String checked = "";
									if(options[iRadio].equals(checkboxvalue)){
										checked = "checked=\"checked\"";
										radio_flag = false;
									}
						%>
								<span style="display:inline-block">
									<input type="radio" name="pivarradio[${index}]" value="<%=options[iRadio] %>" onclick="setRadio_other(${index},this)" <%=checked %>/><%=options[iRadio] %>
								</span>
						<%
								}
							}
							String checked_other = "";
							String display_other = "";
							if(radio_flag){
								checked_other = "checked=\"checked\"";
							}else{
								display_other = "display: none;";
							}
						%>
								<input id="pivarradio_Other[${index}]" type="radio" name="pivarradio[${index}]" value="<%=checkboxvalue %>" onclick="setRadio_other(${index},this,'other')" <%=checked_other %>/>其他 
								<html:text style="<%=display_other %>" styleId="pivarvalue_Other[${index}]" property="pivarvalue[${index}]" size="18" errorStyleClass="inputError imeActive"
								  value="<%=checkboxvalue %>" onchange="setOnChage_other(${index},this)" /> 
						<html:hidden property="pivarvalue[${index}]" value="${piddefault}"/>
					</logic:equal>
					<logic:equal value="C" name="psid" property="pidtype">
						<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
						<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
						<bean:define id="optionMap" name="IGPRR01011VO" property="optionMap" type="java.util.Map"/>
						<%
							String checkboxvalue = StringUtils.isEmpty(psid.getPidvalue())?"":psid.getPidvalue();
							String[] boxValues = checkboxvalue.split("#");
							String[] options = (String[])optionMap.get(pidid);
							for(int iCheckbox = 0; iCheckbox < options.length; iCheckbox++){
								if(StringUtils.isNotEmpty(options[iCheckbox])){
									String checked = "";
									for(int iValue = 0; iValue < boxValues.length; iValue++){
										if(options[iCheckbox].equals(boxValues[iValue])){
											checked = "checked";
										}
									}
						%>
									<input type="checkbox" name="pivarcheckbox[${index}]" value="<%=options[iCheckbox] %>" onclick="setCheckbox(${index},this)" <%=checked %> disabled="disabled"/><%=options[iCheckbox] %>
						<%
								}
							}
						%>
						<html:hidden property="pivarvalue[${index}]" value="<%=checkboxvalue %>"/>
					</logic:equal>
					<!-- 树 -->
					<logic:equal value="T" name="psid" property="pidtype">
						<%if(StringUtils.isNotEmpty(psid.getPidvalue()) && psid.getPidvalue().contains("_tree_")){ %>
							<%=psid.getPidvalue().split("_tree_")[1] %> 
						<%} %>
						<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
					</logic:equal>
					<logic:equal value="9" name="psid" property="pidtype">
						<html:textarea property="pivarvalue[${index}]" errorStyleClass="inputError" readonly="true" rows="5" cols="<%= textAreaSize%>" value="${psid.pidvalue}"/>
						<div style="padding-left: 50px"><img src="images/attachment.gif" />
	<a href="javascript:addFileMuti('${psid.pidlabel}')" id="aAddAttachMuti">添加附件</a>&nbsp;&nbsp;&nbsp;

	<table id="${psid.pidlabel}">
	</table>
	
	
	</div>
					</logic:equal>
					<logic:equal value="2" name="psid" property="pidtype">
						<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
						<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
						<bean:define id="optionMap" name="IGPRR01011VO" property="optionMap" type="java.util.Map"/>
						<html:select property="pivarvalue[${index}]" value="<%=StringUtils.isEmpty(psid.getPidvalue())?piddefault:psid.getPidvalue() %>" 
						styleClass="inputDisable" disabled="true" >
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
					
					<logic:equal value="R" name="psid" property="pidtype">
						<%if(StringUtils.isNotEmpty(psid.getPidvalue()) && psid.getPidvalue().contains("_role_")){ %>
								<%=psid.getPidvalue().split("_role_")[1] %> 
						<%} %>
						<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
					</logic:equal>
					</td>
				</logic:equal>
				
				<logic:notEqual name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>">
					<logic:notEqual name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE %>">
						<input type="hidden" name="pivarvalue[${index}]" value="${psid.pidvalue}" /> 
					</logic:notEqual>
				</logic:notEqual>
				<html:hidden property="pivarname" value="${psid.pidname}" /> 
				<html:hidden property="pivarlabel" value="${psid.pidlabel}" /> 
				<html:hidden property="pivartype" value="${psid.pidtype}" /> 
				<html:hidden property="pidid" value="${psid.pidid}" />
				<html:hidden property="pidaccess" value="${psid.pidaccess}" />
				<html:hidden property="piid" value="${psid.piid}" />
				<html:hidden property="pidmode" value="${psid.pidmode}" />
				<html:hidden property="privatescope" value="${psid.privatescope}" />
				
				
			</logic:present>
		</logic:iterate>
		<% 
			if(StringUtils.isEmpty(lastrowwidth)){
			}
			if("0".equalsIgnoreCase(lastrowwidth)){
				trEndTag = "</tr>";
			}
			if("1".equalsIgnoreCase(lastrowwidth)){
				if(columnNum == 0){
					trEndTag = "</tr>";
				}else{
					trEndTag = "<td></td><td></td></tr>";
				}
			}
			%>
			<%=trEndTag%>
	</logic:present> 
	<th><label for="Name"><strong>备注</strong>：</label>
	</th>
	<td colspan="3">
		<html:textarea property="rlcomment" cols="60" errorStyleClass="inputError imeActive" rows="6"></html:textarea> <br />
	</td>
	</table>
	
	
	<div><img src="images/attachment.gif" />
	<a href="javascript:addFile();" id="aAddAttach">添加附件</a>&nbsp;&nbsp;&nbsp;

	<table id="tb">
	</table>
	</div>
	</fieldset>
	
	<logic:notEqual value="0114001" name="IGPRR0101Form" property="pdid">
	<br/>
	<fieldset>
	  <legend>参与人</legend>
		<div id="results_list"><ig:message />
			<table class="table_style4" align="left">
				<tr>
					<th width="30%">角色</th>
					<th width="20%">处理人</th>
					<th width="30%">机构</th>
				</tr>
				<tr class="<ig:rowcss index="${index}"/>">
					<td>现场工程师<html:hidden property="roleids" styleId="roleids" name="IGPRR0101Form" value="1001"/>
					</td>
					<td><html:text styleId="ppusernames" property="ppusernames" name="IGPRR0101Form" size="6" style="text-align: center" readonly="true"/><html:hidden property="ppuserids" styleId="ppuserids" name="IGPRR0101Form"/>
					<a href="javascript:void(0)" onclick="selectRoleUser('1001');"><img src="images/seek.gif" alt='查询' width="16" height="16" border="0" /></a>
					</td>
					<td><html:text property="pporgnames" styleId="pporgnames" name="IGPRR0101Form" size="18" style="text-align: center" readonly="true"/><html:hidden property="pporgids" styleId="pporgids" name="IGPRR0101Form"/></td>
				</tr>
			</table>
		</div>
	</fieldset>
	</logic:notEqual>
	
	<logic:equal value="0114001" name="IGPRR0101Form" property="pdid">
		<div id="results_list" style="display:none"><ig:message />
			<table class="table_style4" align="left">
				<tr class="<ig:rowcss index="${index}"/>">
					<td>现场工程师<html:hidden property="roleids" styleId="roleids" name="IGPRR0101Form" value="1001"/>
					</td>
					<td><html:text styleId="ppusernames" property="ppusernames" name="IGPRR0101Form" size="6" style="text-align: center" readonly="true"/><html:hidden property="ppuserids" styleId="ppuserids" name="IGPRR0101Form"/>
					<a href="javascript:void(0)" onclick="selectRoleUser('1001');"><img src="images/seek.gif" alt='查询' width="16" height="16" border="0" /></a>
					</td>
					<td><html:text property="pporgnames" styleId="pporgnames" name="IGPRR0101Form" size="18" style="text-align: center" readonly="true"/><html:hidden property="pporgids" styleId="pporgids" name="IGPRR0101Form"/></td>
				</tr>
			</table>
		</div>
	</logic:equal>
	
	<div class="enter">
	<div>
	<logic:present name="IGPRR01011VO" property="lst_ParticipantVisibleButtonVWInfo">
		<logic:iterate id="bean" name="IGPRR01011VO" property="lst_ParticipantVisibleButtonVWInfo">
			<html:submit styleClass="button" value="${bean.vbname}" onclick="return checkForm('${bean.vbid}');"/>
		</logic:iterate>
		<html:reset styleClass="button" value="重置" />
	</logic:present> 
	</div>
	</div>
	<div class="Placeholder"></div>
	</div>
	<html:hidden property="pdid" styleId="pdid" name="IGPRR0101Form" />
	<html:hidden property="psdid" styleId="psdid" name="IGPRR0101Form" />
	<html:hidden property="action" styleId="action" name="IGPRR0101Form" />
	<html:hidden property="pts" styleId="pts" name="IGPRR0101Form" />
	<html:hidden property="prpdid" styleId="prpdid" name="IGPRR0101Form" />
	<html:hidden property="strpsidid" styleId="strpsidid" name="IGPRR0101Form" />
	<input type="hidden" id="delFileMutiStr" name="delFileMutiStr" value=""/>
</html:form></div>
</div>


</div>
</div>

</body>
</html>


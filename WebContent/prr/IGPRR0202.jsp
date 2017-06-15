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
<bean:define id="id" value="IGPRR0202" toScope="request" />
<bean:define id="title" value="工作信息" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var gid='IGPRR0202';
var num = 0;
function selectRole(){
	var roleid = document.getElementById("qprroleid").value;
	var pdid = document.getElementById("pdid").value;
	document.location.replace(getAppRootUrl() + "/IGPRR0202_Quartz.do?psdcode=<%=IGPRDCONSTANTS.PROCESS_START_STATUS%>&pdid="+pdid+"&roleid="+roleid);

}
function changePrRolename(){
	var obj = IGPRR0202Form.qprroleid;
	IGPRR0202Form.prrolename.value = obj.options[obj.selectedIndex].text;
}
function selectEntityItem(index){
    num = index;
    openSubIGCOM0302();
}
function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory) {
	if("" == eiid){
		$("pivarvalue[" + num + "]").value = "";
		$("pivarassetname[" + num + "]").value = "";
	} else {
		$("pivarvalue[" + num + "]").value = eiid + "_asset_" + einame;
		$("pivarassetname[" + num + "]").value = einame;
	}
	num = 0;
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

function checkForm(actionid){
	if($F('qpruserid').trim()==""){
		alert("请选择发起人！");
		return false;
	}
	if($F('qprinfo').trim()==""){
		alert("请输入发起人联系方式！");
		return false;
	}
	if($F('qprtitle').trim()==""){
		alert("请输入主题简述！");
		return false;
	}
	if($F('qprdesc').trim()==""){
		alert("请输入内容描述！");
		return false;
	}
	if($F('qprurgency').trim()==""){
		alert("请选择紧急程度！");
		return false;
	}
	if($F('qprimpact').trim()==""){
		alert("请选择影响程度！");
		return false;
	}
	if($F('qprinfo').strlen()>64){
		alert("发起人联系方式不能大于64个字符！");
		return false;
	}
	if($F('qprtitle').strlen()>150){
		alert("主题简述不能大于"+Math.floor(150/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('qprdesc').strlen()>512){
		alert("内容描述不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('rlcomment').strlen()>450){
		alert("备注不能大于"+Math.floor(450/strByteFlag)+"个汉字！");
		return false;
	}



	<logic:present name="IGPRR01011VO" property="processInfoDefmap">
		<logic:iterate id="map" name="IGPRR01011VO" property="processInfoDefmap" indexId="index" >
			<bean:define id="pidid" name="map" property="key" type="java.lang.Integer" />
			<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
			<logic:present name="psid">
				<logic:equal name="psid" property="pidaccess" value="1">
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
	
	if( window.confirm("您是否确认提交？")){
		$("actionid").value = actionid;
		return true;
	} else {
		return false;
	}
}

function ShowpProcessFlow(){
	window.showModalDialog(getAppRootUrl() + '/IGPRR0111_Disp.do?pdid=${IGPRR0202Form.pdid}&psdid=${IGPRR0202Form.psdid}',null,"dialogWidth:1000px;dialogHeight:600px;status:no;help:no;resizable:yes");
}

function selectRoleUser(roleid){
	openSubWindow('/IGSYM0405.do?flag=1&roleida='+roleid , 'newpage', '800', '600');
}
function setParamRoleUser(userid,username,roleid,orgid,orgname,usermobile){
	
	document.getElementById("qpruserid").value = userid;
	document.getElementById("qprusername").value = username;
	document.getElementById("qprorgid").value = orgid;
	document.getElementById("qprorgname").value = orgname;
	document.getElementById("qprinfo").value = usermobile;

}

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGPRR0202_Quartz_Insert" styleId="form"
	onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">日常工作计划&gt;&gt; 工作发起</p>
	</div>
	<div id="formwrapper"><!--  message --> <ig:message /> <!--  /message -->
	<fieldset>
	<legend>发起人信息 </legend>
		<div><label for="Name"><strong><span class="red">*</span>发起人角色</strong>：</label>
			<logic:present name="IGPRR01011VO" property="disp">
				<logic:equal value="0" name="IGPRR01011VO" property="disp">
					<html:select property="qprroleid" errorStyleClass="inputError imeActive"
						tabindex="2" styleId = "qprroleid" onchange="selectRole();" name="IGPRR0202Form">
					<html:options collection="ADroleList" property="value" name="" labelProperty="label"/>
					</html:select>
					<html:hidden property="qprrolename"  styleId = "qprrolename"/>
				</logic:equal>
				<logic:notEqual value="0" name="IGPRR01011VO" property="disp">
					<html:text property="qprrolename" size="18" errorStyleClass="inputError imeActive" 
					readonly="true" name="IGPRR0202Form" styleId="qprrolename"/>
					<html:hidden property="qprroleid"/>
				</logic:notEqual>
			</logic:present>	
		</div>
		
		<div><label for="Name"><strong><span class="red">*</span>发起人姓名</strong>：</label>
		<html:text property="qprusername" styleId="qprusername" size="18" style="text-align: left" readonly="true"/>
		<a href="javascript:void(0)" onclick="selectRoleUser('${IGPRR0202Form.qprroleid}');"><img src="images/seek.gif" alt="查询" width="16" height="16" border="0" /></a>
		<html:hidden property="qpruserid" styleId="qpruserid" />
		</div>
		<div><label for="Name"><strong>发起人部门</strong>：</label>
		<html:text property="qprorgname" size="18" errorStyleClass="inputError imeActive"  readonly="true"></html:text>
		<html:hidden property="qprorgid" />
		</div>
		<div><label for="Name"><strong><span class="red">*</span>发起人联系方式</strong>：</label>
	    <html:text property="qprinfo" size="18" errorStyleClass="inputError imeActive" ></html:text>
	    </div>
	</fieldset>
	
	<div style="margin-top:10px;float: right">
	<a href="javascript:ShowpProcessFlow();">查看流程图</a>
	</div>
	</div>
	
	<div id="formwrapper">
	<fieldset><legend>工单信息</legend> 
	<div><label for="Name"><strong>流程类型</strong>：</label>
	<p class="p2">&nbsp;&nbsp;<bean:write name="IGPRR0202Form" property="qprpdname"/></p>
	</div>

	<div><label for="Name"><strong><span class="red">*</span>主题简述</strong>：</label>
	<html:text property="qprtitle" size="82" errorStyleClass="inputError imeActive" /> <br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>内容描述</strong>：</label>
	<html:textarea property="qprdesc" cols="60" rows="6"  errorStyleClass="inputError imeActive"></html:textarea> <br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>紧急程度</strong>：</label>
	<html:select property="qprurgency" errorStyleClass="inputError imeActive"  style="width:50px" >
		<ig:optionsCollection ccid="WDURGENCY_GRADE_CODE" isMakeBlankRow="true"
			isCodeLabel="true" />
	</html:select> <br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>影响程度</strong>：</label>
	<html:select property="qprimpact" errorStyleClass="inputError imeActive" style="width:50px">
		<ig:optionsCollection ccid="IMPACT_GRADE_CODE" isMakeBlankRow="true"
			isCodeLabel="true" />
	</html:select> <br />
	</div>
	<logic:present name="IGPRR01011VO" property="processInfoDefmap">
		<logic:iterate id="map" name="IGPRR01011VO" property="processInfoDefmap" indexId="index" >
			<bean:define id="pidid" name="map" property="key" type="java.lang.Integer" />
			<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
			<logic:present name="psid">
			<div>
				<logic:equal name="psid" property="pidaccess" value="1">
					<label for="Name"><strong>
					<logic:equal value="1" name="psid" property="pidrequired"><span class="red">*</span></logic:equal>
					${psid.pidlabel}</strong>：</label>
					<logic:equal value="0" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0202Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" size="32" errorStyleClass="inputError imeActive"/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0202Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" size="32" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" />
						</logic:notEqual>
					</logic:equal>
					<logic:equal value="3" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0202Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" size="18" readonly="true" errorStyleClass="inputError imeActive"/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0202Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" size="18" readonly="true" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" />
						</logic:notEqual>
						<img src="images/date.gif" align="middle" onclick="showDate($('pivarvalue[${index}]'))" style="cursor: hand" />
					</logic:equal>
					<logic:equal value="A" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0202Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" size="18" readonly="true" errorStyleClass="inputError imeActive"/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0202Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" size="18" readonly="true" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" />
						</logic:notEqual>
						<img src="images/date.gif" align="middle" onclick="showTime($('pivarvalue[${index}]'))" style="cursor: hand" />
					</logic:equal>
					<logic:equal value="7" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0202Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" styleId="pivarvalue[${index}]" errorStyleClass="inputError imeDisabled" size="17" readonly="true" onclick="SoftKeyboard($('pivarvalue[${index}]'))"/> 
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0202Form" property="isFirst">
							<html:text property="pivarvalue[${index}]" styleId="pivarvalue[${index}]" errorStyleClass="inputError imeDisabled" size="17" readonly="true" value="${psid.pidvalue}" onclick="SoftKeyboard($('pivarvalue[${index}]'))"/> 
						</logic:notEqual>
					</logic:equal>
					<logic:equal value="4" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0202Form" property="isFirst">
							<html:text property="pivarassetname[${index}]" size="18" readonly="true"/> 
							<img src="images/seek.gif" alt="查询" onclick="selectEntityItem(${index})" style="cursor: hand"/>
							<html:hidden property="pivarvalue[${index}]"/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0202Form" property="isFirst">
							<html:text property="pivarassetname[${index}]" size="18" readonly="true" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_asset_"))?"":psid.getPidvalue().split("_asset_")[1] %>' /> 
							<img src="images/seek.gif" alt="查询" onclick="selectEntityItem(${index})" style="cursor: hand"/>
							<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
						</logic:notEqual>
					</logic:equal>
					<logic:equal value="5" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0202Form" property="isFirst">
								<html:text property="pivarprname[${index}]" size="18" readonly="true"/> 
								<img src="images/seek.gif" alt="查询" onclick="openSVCPage(${index})" style="cursor: hand"/>
								<html:hidden property="pivarvalue[${index}]"/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0202Form" property="isFirst">
								<html:text property="pivarprname[${index}]" size="18" readonly="true" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_svc_"))?"":psid.getPidvalue().split("_svc_")[1].split("_name=")[1] %>' /> 
								<img src="images/seek.gif" alt="查询" onclick="openSVCPage(${index})" style="cursor: hand"/>
								<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
						</logic:notEqual>
					</logic:equal>
					<logic:equal value="6" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0202Form" property="isFirst">
								<html:text property="pivarprjname[${index}]" size="18" readonly="true"/> 
								<img src="images/seek.gif" alt="查询" onclick="selectProject(${index})" style="cursor: hand"/>
								<html:hidden property="pivarvalue[${index}]"/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0202Form" property="isFirst">
								<html:text property="pivarprjname[${index}]" size="18" readonly="true" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_prj_"))?"":psid.getPidvalue().split("_prj_")[1] %>'/> 
								<img src="images/seek.gif" alt="查询" onclick="selectProject(${index})" style="cursor: hand"/>
								<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
						</logic:notEqual>
					</logic:equal>
					<logic:equal value="9" name="psid" property="pidtype">
						<html:textarea property="pivarvalue[${index}]" errorStyleClass="inputError" rows="5" cols="25" value="${psid.pidvalue}"/>
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
								
<div style="padding-left: 50px"><img src="images/attachment.gif" />
	<a href="javascript:addFileMuti('${psid.pidlabel}')" id="aAddAttachMuti">添加附件</a>&nbsp;&nbsp;&nbsp;

	<table id="${psid.pidlabel}">
	</table>
	
	
	</div>
					</logic:equal>
					<logic:equal value="2" name="psid" property="pidtype">
						<bean:define id="pidid" name="psid" property="pidid" type="java.lang.Integer" />
						<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
						<bean:define id="optionMap" name="IGPRR01011VO" property="optionMap" type="java.util.Map"/>
						<logic:equal value="1" name="IGPRR0202Form" property="isFirst">
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
						<logic:notEqual value="1" name="IGPRR0202Form" property="isFirst">
							<html:select property="pivarvalue[${index}]" value='<%=StringUtils.isEmpty(psid.getPidvalue())?piddefault:psid.getPidvalue() %>'>
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
					</logic:equal>
					
					<logic:equal value="R" name="psid" property="pidtype">
						<logic:equal value="1" name="IGPRR0202Form" property="isFirst">
							<html:text property="pivarrolename[${index}]" size="18" readonly="true"/> 
							<img src="images/seek.gif" alt="查询" onclick="selectRoleOnIGSYM0306(${index},${psid.pdid})" style="cursor: hand"/>
							<html:hidden property="pivarvalue[${index}]"/>
						</logic:equal>
						<logic:notEqual value="1" name="IGPRR0202Form" property="isFirst">
							<html:text property="pivarrolename[${index}]" size="18" readonly="true" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_role_"))?"":psid.getPidvalue().split("_role_")[1] %>' /> 
							<img src="images/seek.gif" alt="查询" onclick="selectRoleOnIGSYM0306(${index},${psid.pdid})" style="cursor: hand"/>
							<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
						</logic:notEqual>
					</logic:equal>
					
				</logic:equal>
			
				<logic:equal name="psid" property="pidaccess" value="1">
					<label for="Name"><strong>${psid.pidlabel}</strong>：</label>
					<logic:equal value="0" name="psid" property="pidtype">
						<html:text property="pivarvalue[${index}]" size="32" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" readonly="true" styleClass="inputDisable"/>
					</logic:equal>
					<logic:equal value="3" name="psid" property="pidtype">
						<html:text property="pivarvalue[${index}]" size="18" readonly="true" errorStyleClass="inputError imeActive"
						 value="${psid.pidvalue}" readonly="true" styleClass="inputDisable" /> 
					</logic:equal>
					<logic:equal value="A" name="psid" property="pidtype">
						<html:text property="pivarvalue[${index}]" size="18" readonly="true" errorStyleClass="inputError imeActive"
						 value="${psid.pidvalue}" readonly="true" styleClass="inputDisable" /> 
					</logic:equal>
					<logic:equal value="7" name="psid" property="pidtype">
						<html:text property="pivarvalue[${index}]" size="18" readonly="true" errorStyleClass="inputError imeActive"
						 value="${psid.pidvalue}" readonly="true" styleClass="inputDisable" /> 
					</logic:equal>
					<logic:equal value="4" name="psid" property="pidtype">
						<%if(StringUtils.isNotEmpty(psid.getPidvalue()) && psid.getPidvalue().contains("_asset_")){ %>
						<a href="javascript:void(0)" onclick="openSubIGCOM0303('<%=psid.getPidvalue().split("_asset_")[0] %>','')">
								<%=psid.getPidvalue().split("_asset_")[1] %> </a>
						<%} %>
						<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
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
					<logic:equal value="9" name="psid" property="pidtype">
						<html:textarea property="pivarvalue[${index}]" errorStyleClass="inputError" readonly="true" rows="5" cols="25" value="${psid.pidvalue}"/>
						<div style="padding-left: 50px"><img src="images/attachment.gif" />
	<a href="javascript:addFileMuti('${psid.pidlabel}')" id="aAddAttachMuti">添加附件</a>&nbsp;&nbsp;&nbsp;

	<table id="${psid.pidlabel}">
	</table>
	
	
	</div>
					</logic:equal>
					<logic:equal value="2" name="psid" property="pidtype">
						<bean:define id="pidid" name="psid" property="pidid" type="java.lang.Integer" />
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
					
				</logic:equal>
				
				<logic:notEqual name="psid" property="pidaccess" value="1">
					<logic:notEqual name="psid" property="pidaccess" value="2">
						<input type="hidden" name="pivarvalue[${index}]" value="${psid.pidvalue}" /> 
					</logic:notEqual>
				</logic:notEqual>
				<html:hidden property="pivarname" value="${psid.pidname}" /> 
				<html:hidden property="pivarlabel" value="${psid.pidlabel}" /> 
				<html:hidden property="pivartype" value="${psid.pidtype}" /> 
				<html:hidden property="pidid" value="${psid.pidid}" />
				<html:hidden property="pidaccess" value="${psid.pidaccess}" />
				<html:hidden property="piid" value="${psid.piid}" />
				</div>
			</logic:present>
		</logic:iterate>
	</logic:present> 
	<div><label for="Name"><strong>备注</strong>：</label>
	<html:textarea property="rlcomment" cols="60" errorStyleClass="inputError imeActive" rows="6"></html:textarea> <br />
	</div>
<!--	<div style="padding-left: 50px"><img src="images/attachment.gif" />-->
<!--	<a href="javascript:addFile();" id="aAddAttach">添加附件</a>&nbsp;&nbsp;&nbsp;-->
<!---->
<!--	<table id="tb">-->
<!--	</table>-->
<!--	</div>-->
	</fieldset>
	<div class="enter">
	<logic:present name="IGPRR01011VO" property="actionlist">
		<logic:iterate id="but" name="IGPRR01011VO" property="actionlist">
		<bean:define id="butkey" name="but" property="key" type="java.lang.String" />
	    <bean:define id="butname" name="but" property="value" type="java.lang.String" />
			<logic:equal name="butkey" value="1">
				<html:submit styleClass="button" value="${butname}" onclick="return checkForm('${butkey}');"/>
			</logic:equal>
		</logic:iterate>
		<html:reset styleClass="button" value="重置" />
	</logic:present> 
	
	</div>
	<div class="Placeholder"></div>
	</div>
	<html:hidden property="pdid" styleId="pdid" name="IGPRR0202Form" />
	<html:hidden property="psdid" styleId="psdid" name="IGPRR0202Form" />
	<html:hidden property="actionid" styleId="actionid" name="IGPRR0202Form" />
	<html:hidden property="pts" styleId="pts" name="IGPRR0202Form" />
	<html:hidden property="qprpdid" styleId="qprpdid"/>
	<html:hidden property="strpsidid" styleId="strpsidid" name="IGPRR0202Form" />
	<input type="hidden" id="delFileMutiStr" name="delFileMutiStr" value=""/>
</html:form></div>
</div>


</div>
</div>
</body>
</html>


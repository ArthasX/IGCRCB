<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.user.model.User" %>
<%@ page import="com.deliverik.infogovernor.sdl.bl.QuartzJobsType" %>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>
<%
	String contextPath = request.getContextPath();
	User user1 = null;
	if(request.getAttribute("user")!=null){
		user1 = (User)request.getAttribute("user");
	}
%>
<html:html>
<bean:define id="id" value="IGEXTWA0000" toScope="request" />
<bean:define id="title" value="指派工作发起" toScope="request" />
<bean:define id="user" name="LOGIN_USER" scope="session" />
<bean:define id="bean" name="IGSCH0201Form" scope="session" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var gid='IGEXTWA0000';
var num = 0;
var path = 0;
//改变角色名称(流程管理)
function changePrRolename(){
	var obj = document.getElementById("qprroleid");//document.forms[0].prroleid;
	document.getElementById("qprrolename").value = obj.options[obj.selectedIndex].text;
}

function selectEntity(){
	openSubIGCOM0302();
}
function selectEntityItem(index,flag){
    num = index;
    path = flag;
    openSubIGCOM0302();
}
function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory) {
	if(0 == path){
	    $("qprassetid").value = eiid;
		$("qprassetname").value = einame;
		$("qprassetcategory").value = ecategory;
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
	if($F('qprroleid').trim()==""){
		alert("请选择角色！");
		return false;
	}
	if($F('qprinfo').trim()==""){
		alert("请输入联系方式！");
		return false;
	}
	if($F('qprinfo').strlen()>64){
		alert("联系方式不能大于20个汉字！");
		return false;
	}
	if($F('qjimplusername').trim()==""){
		alert("请选择执行人员！");
		return false;
	}
	if($F('qprtitle').trim()==""){
		alert("请输入工作名称！");
		return false;
	}
	if($F('qprtitle').strlen()>150){
		alert("工作名称不能大于50个汉字！");
		return false;
	}
	if($F('qprdesc').trim()==""){
		alert("请输入工作描述！");
		return false;
	}
	if($F('qprdesc').strlen()>2000){
		alert("工作描述不能大于"+Math.floor(2000/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('qprduration').trim()==""){
		alert("请输入期限！");
		document.forms[0].qprduration.focus();
		return false;
	}
	if(!checkIsNumber($F('qprduration'))){
		alert("期限请输入正整数！");
		document.forms[0].qprduration.value="";
		document.forms[0].qprduration.focus();
		return false;	
	}

	if($F('qprduration')>10000)
	{
		alert("期限超出允许天数！");
		document.forms[0].qprduration.value="";
		document.forms[0].qprduration.focus();
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

	var flag = 0;
	var quartzTime = document.getElementById("quartzTime").value;
	var nowTime;
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'type=servertime',
		 onSuccess:  function(req, json){
		 var result=req.responseText;
			if(result != null && result != ""){
				if(result >= quartzTime){
					nowTime = result;
					flag = 1;
				}
			} else{
				flag = 2;
			}
					
	     }
		});
	if(flag == 1){
		alert("任务发起时间必须在执行时间之前，服务器当前时间：" + nowTime + "！");
		return false;
	} else if(flag == 2){
		alert("获取服务器时间失败！");
		return false;
	}
	
	<logic:present name="IGEXTWA01021VO" property="processInfoDef">
	<logic:notEmpty name="IGEXTWA01021VO" property="processInfoDef">
	<logic:iterate id="infoDef" name="IGEXTWA01021VO" property="processInfoDef" indexId="index">
	<logic:equal value="1" name="infoDef" property="pidrequired">
		if($F('pivarvalue[${index}]').trim() == ""){
			alert("请输入${infoDef.pidlabel}！");
			return false;
		}
	</logic:equal>
	</logic:iterate>
	<logic:iterate id="infoDef" name="IGEXTWA01021VO" property="processInfoDef" indexId="index">
	if($F('pivarvalue[${index}]').strlen()>2000){
		alert("${infoDef.pidlabel}不能大于"+Math.floor(2000/strByteFlag)+"个汉字！");
		return false;
		}
	</logic:iterate>
	</logic:notEmpty>
	</logic:present>
	if(confirm("是否确认提交?")){
		return true;
	}
	return false;
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
function setParamIGFIN0105(pid,pcode,pname) {
    $("qpid").value = pid;
	$("qpcode").value = pcode;
	$("qpname").value = pname;
}
function selectBudget(){
	openSubWindow('/IGFIN0106_Disp.do?', 'budget','800','600');
}


function selectRoleUser(){
	if(document.getElementById("qjimplrole").value==""){
		alert("请选择角色");
		return;
	}
	var roleIdValue = document.getElementById("qjimplroleid").value;
	openSubWindow('/IGSYM0405.do?path=strategy&roleida='+roleIdValue , 'newpage', '800', '600');
}

function setParamRoleUser(userid,username,roleid,orgid,orgname){
	document.getElementById("qjimplusername").value = username;
  	document.getElementById("qjimpluser").value = userid;
	document.getElementById("qjorgid").value = orgid;
  	document.getElementById("qjorgname").value = orgname;
}

function setdefault(){
	<%if(user1!=null){%>
		document.forms[0].qprinfo.value = <%=user1.getUsermobile() %>;
	
	<%}%>
	
}
function add_zero(obj){
	if(Number(obj) < 10){
		obj = "0" + obj;
	}
	return obj;
}
</script>
<body onload="changePrRolename();setdefault();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGEXTWA0000" styleId="form" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">流程管理 &gt;&gt; 任务调度 &gt;&gt; 任务发起</p>
	</div>
	<div class="image" style="margin-top:2px;margin-left:4px;"><img src="images/w111.gif"/></div>
	<div id="formwrapper">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	 <fieldset>
        <legend>任务信息</legend>
         <table width="100%" border="0">
          <tr>
            <td width="6%"></td>
            <td width="10%"><label><strong>任务名称</strong>：</label></td>
            <td width="37%"><bean:write name="bean" property="qjname" /></td>
            <td width="10%"><label><strong>任务描述</strong>：</label></td>
            <td width="36%"><bean:write name="bean" property="qjdesc" /></td>
            </tr>
          <tr>
            <td>&nbsp;</td>
            <td><label><strong>执行人员</strong>：</label></td>
            <td>待定</td>
           <td><label><strong>创建人员</strong>：</label></td>
            <td><bean:write name="bean" property="qjcrtusername" /></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><label><strong>开始时间</strong>：</label></td>
            <td><bean:write name="bean" property="qjcrttime" /></td>
            <td><label><strong>结束时间</strong>：</label></td>
            <td><bean:write name="bean" property="qjendtime" /></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><label><strong>调度方式</strong>：</label></td>
            <td><ig:codeValue ccid="STRATEGY_WORK_CODE" cid="${bean.qjtype}" /></td>
            <td><label><strong>执行时间</strong>：</label></td>
            <td><bean:write name="bean" property="qjperiodinfo" /></td>
            <html:hidden property="quartzTime" value="${bean.qjperiodinfo}" />
          </tr>
        </table>
    </fieldset>
	<fieldset><legend>发起者信息 </legend>
	<div><label><strong>姓名</strong>：</label><p class="p2"><bean:write name="user"
		property="username" /></p></div>
	<div><label><strong>发起者部门</strong>：</label><p class="p2"><bean:write name="user"
		property="orgname" /></p></div>
	<div><label for="Name"><strong><span class="red">*</span>发起者角色</strong>：</label> <html:select
		property="qprroleid"
		errorStyleClass="inputError imeActive" tabindex="2"
		onchange="changePrRolename()">
		<html:options collection="roleList" property="value" name=""
			labelProperty="label" />
	</html:select> <html:hidden property="qprrolename"/><br />
	</div>
	<div><label><strong><span class="red">*</span>联系方式</strong>：</label> 
	<html:text property="qprinfo" size="18" errorStyleClass="inputError imeActive" /><br />
	</div>
	</fieldset>
	<fieldset><legend>工作信息</legend>
	<div><label for="Name"><strong>工作类型</strong>：</label>
	<p class="p2"><bean:write name="bean" property="pdname"/></p>
	</div>
	
	
	
	
	<div><label><strong><span class="red">*</span>执行人员</strong>：</label>
       	 <html:select property="qjimplrole" style="width:120px;"
		errorStyleClass="inputError imeActive" tabindex="2" onchange="changeImplRole()">
		<html:options collection="allRoleList" property="value" labelProperty="label" />
		</html:select>
		<html:text property="qjimplusername" size="8" readonly="true" errorStyleClass="inputError imeActive"/>
		<a href="javascript:void(0)" onclick="selectRoleUser();"><img src="images/seek.gif" width="16" height="16" border="0" alt="查询"/></a>
	    <html:hidden property="qjimplrolename"/>
		<html:hidden property="qjimplroleid"/>
		<html:hidden property="qjorgid"/>
		<html:hidden property="qjorgname"/>
		<html:hidden property="qjimpluser"/>
		<br />
    </div>
    
    
    
    
	
	<div><label for="Name"><strong><span class="red">*</span>工作名称</strong>：</label> <html:text
		property="qprtitle" size="82" errorStyleClass="inputError imeActive"/> <br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>工作描述</strong>：</label> <html:textarea
		property="qprdesc" cols="60" rows="6" errorStyleClass="inputError imeActive"></html:textarea> <br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>期限(天)</strong>：</label> <html:text
		property="qprduration" size="4" errorStyleClass="inputError imeActive"/>
		<br />
	</div>
	<div><label for="Name"><strong>相关资产</strong>：</label> <html:text
		property="qprassetname" size="18" readonly="true" errorStyleClass="inputError imeActive"/> 

		<img src="images/seek.gif" width="16" height="16" onclick="selectEntity()" style="cursor: hand" alt="查询"/>
		<br />
	</div>
	
	<div><label for="Name"><strong><span class="red">*</span>紧急程度</strong>：</label> 
	<html:select
		property="qprurgency" errorStyleClass="inputError imeActive">
		<ig:optionsCollection ccid="WAURGENCY_GRADE_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	</html:select>
	

	
	<br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>影响程度</strong>：</label> 
	<html:select
		property="qprimpact" errorStyleClass="inputError imeActive">
		<ig:optionsCollection ccid="IMPACT_GRADE_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	</html:select>

	<br />
	</div>
	
	<logic:present name="IGEXTWA01021VO" property="processInfoDef">
	<logic:notEmpty name="IGEXTWA01021VO" property="processInfoDef">
	<logic:iterate id="infoDef" name="IGEXTWA01021VO" property="processInfoDef" indexId="index">
	<div>
		<logic:equal value="0" name="infoDef" property="pidtype">
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<html:text property="pivarvalue[${index}]" size="32" errorStyleClass="inputError imeActive"/>
		</logic:equal>
		<logic:equal value="3" name="infoDef" property="pidtype">
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<html:text property="pivarvalue[${index}]" size="18" readonly="true" errorStyleClass="inputError imeActive"/> 
			<img src="images/date.gif" align="middle" onclick="shoeDate($('pivarvalue[${index}]'))" style="cursor: hand" />
		</logic:equal>
		<logic:equal value="4" name="infoDef" property="pidtype">
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<input type="text" name="pivarassetname[${index}]" size="18" readonly="readonly" /> 
			<img src="images/seek.gif" alt="查询" onclick="selectEntityItem(${index},1)" style="cursor: hand"/>
			<input type="hidden" name="pivarvalue[${index}]" />
		</logic:equal>
		<logic:equal value="5" name="infoDef" property="pidtype">
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<input type="text" name="pivarprname[${index}]" size="18" readonly="readonly" /> 
			<img src="images/seek.gif" alt="查询" onclick="openSVCPage(${index})" style="cursor: hand"/>
			<input type="hidden" name="pivarvalue[${index}]" />
		</logic:equal>
		<logic:equal value="6" name="infoDef" property="pidtype">
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<input type="text" name="pivarprjname[${index}]" size="18" readonly="readonly" /> 
			<img src="images/seek.gif" alt="查询" onclick="selectProject(${index})" style="cursor: hand"/>
			<input type="hidden" name="pivarvalue[${index}]" />
		</logic:equal>
		
		<logic:equal value="7" name="infoDef" property="pidtype">
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<html:text property="pivarvalue[${index}]" styleId="pivarvalue[${index}]" errorStyleClass="inputError imeDisabled" size="17" readonly="true" onclick="SoftKeyboard($('pivarvalue[${index}]'))" /> 
			<br />
		</logic:equal>
		
		<logic:equal value="9" name="infoDef" property="pidtype">
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<html:textarea property="pivarvalue[${index}]" cols="60" rows="6" errorStyleClass="inputError imeActive" /> 
			<br />
		</logic:equal>
								
		<logic:equal value="A" name="infoDef" property="pidtype">
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
			<html:text property="pivarvalue[${index}]" size="18" styleId="pivarvalue[${index}]" readonly="true" />
			<img src="images/date.gif" align="middle" onclick="showTime($('pivarvalue[${index}]'))" style="cursor: hand" />
			<html:hidden property="pivarvalue[${index}]" styleId="pivarvalue[${index}]" />
			<br />
		</logic:equal>
		<logic:equal value="2" name="infoDef" property="pidtype">
			<bean:define id="pidid" name="infoDef" property="pidid" />
			<bean:define id="piddefault" name="infoDef" property="piddefault" />
			<bean:define id="optionMap" name="IGEXTWA01021VO" property="optionMap" type="java.util.Map"/>
			<label for="Name"><strong>
			<logic:equal value="1" name="infoDef" property="pidrequired"><span class="red">*</span></logic:equal>
			${infoDef.pidlabel}</strong>：</label>
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
		</logic:equal>
		<br />
		<input type="hidden" name="pivarname" value="${infoDef.pidname}" />
		<input type="hidden" name="pivarlabel" value="${infoDef.pidlabel}" />
		<input type="hidden" name="pivartype" value="${infoDef.pidtype}" />
	</div>
	</logic:iterate>
	</logic:notEmpty>
	</logic:present>
	
	</fieldset>
	
	<div class="enter"><html:submit property="add" styleClass="button" value="提交" onclick="return checkForm();"/>
	<html:reset styleClass="button" value="重置" /></div>
	<div class="Placeholder"></div>
	</div>
	<html:hidden property="qpid"/>
	<html:hidden property="qpcode"/>
	<html:hidden property="qprassetid"/>
	<html:hidden property="qprcorid"/>
	<html:hidden property="qprcortype"/>
	<html:hidden property="qprassetcategory"/>
	<html:hidden property="qprpdid"/>
	<html:hidden property="qprpdname"/>
	<html:hidden property="qjstatus" value="<%=QuartzJobsType.TASK_SCHEDULING%>"/>
</html:form></div>
</div>


</div>
</div>
</body>
</html:html>


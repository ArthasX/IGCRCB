<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<!--javascript-->
<script type="text/javascript">
var gid='IGSCH0203';


function selectEntity(){
	openSubIGCOM0302();
}

function setParamIGFIN0105(pid,pcode,pname,flag){
    $("qpname").value = pname;
    $("qpcode").value = pcode;
    $("qpid").value = pid;
}

function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory) {
    $("qprassetid").value = eiid;
	$("qprassetname").value = einame;
	$("qprassetcategory").value = ecategory;
}

function selectProject(){
	openSubWindow('/IGFIN0106_Disp.do?', '_project');
}

function changePrRolename(){
	var obj = document.forms[0].qprroleid;
	document.forms[0].qprrolename.value = obj.options[obj.selectedIndex].text;
}
function checkForm(){
	if($F('qjimplusername').trim()==""){
		alert("请选择短信接收人！");
		return false;
	}
	if(confirm("是否确认提交?")){
		return true;
	}
	return false;
}

function setParamRoleUser(userid,username,roleid,orgid,orgname){
	document.getElementById("qjimplusername").value = username;
  	document.getElementById("qjimpluser").value = userid;
}

function selectRoleUser(){
	if(document.getElementById("qjimplrole").value==""){
		alert("请选择角色");
		return;
	}
	var roleIdValue = document.getElementById("qjimplroleid").value;
	openSubWindow('/IGSYM0405.do?path=strategy&roleida='+roleIdValue , 'newpage', '800', '600');
}
</script>
<bean:define id="id" value="IGSCH0203" toScope="request" />
<bean:define id="title" value="企业定时任务" toScope="request" />
<bean:define id="bean" name="IGSCH02021VO" property="igsch0201Form" />
<bean:define id="user" name="LOGIN_USER" scope="session" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<div id="container">
<!--container 左菜单 右侧内容-->
   <div id="contentWrap">
   <div id="content">
   <div id="location">
       <div class="image"></div>
        <p class="fonts1">流程管理 &gt;&gt; 任务调度 &gt;&gt; 指派任务</p>
    </div>
       <div id="formwrapper">
		<html:form action="/IGSCH0203" styleId="form">
       <ig:message/>
        <fieldset>
        <legend>任务信息</legend>
        
        <table width="700" border="0" cellpadding="3" cellspacing="4">
          <tr>
            <td>&nbsp;</td>
            <td align="right" bgcolor="#eeeeee"><strong>任务名称</strong>：</td>
            <td colspan="3"><bean:write name="bean" property="qjname" /></td>
          </tr>
          <tr>
            <td width="8%">&nbsp;</td>
            <td align="right" bgcolor="#eeeeee"><strong>任务描述</strong>：</td>
            <td colspan="3"><bean:write name="bean" property="qjdesc" /></td>
            </tr>
          <tr>
            <td>&nbsp;</td>
           	<td align="right" bgcolor="#EEEEEE"><strong>创建人员</strong>：</td>
            <td colspan="3"><bean:write name="bean" property="qjcrtusername" /></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td align="right" bgcolor="#eeeeee"><strong>开始时间</strong>：</td>
            <td><bean:write name="bean" property="qjcrttime" /></td>
            <td align="right" bgcolor="#EEEEEE"><strong>结束时间</strong>：</td>
            <td><bean:write name="bean" property="qjendtime" /></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td align="right" bgcolor="#eeeeee"><strong>调度方式</strong>：</td>
            <td><ig:codeValue ccid="STRATEGY_WORK_CODE" cid="${bean.qjtype}" /></td>
            <td align="right" bgcolor="#EEEEEE"><strong>执行时间</strong>：</td>
            <td><bean:write name="bean" property="qjperiodinfo" /></td>
          </tr>
        </table>
       
       <html:hidden property="qjname" value="${bean.qjname}" />
       <html:hidden property="qjdesc" value="${bean.qjdesc}" />
       <html:hidden property="qjtriname" value="${bean.qjtriname}" />
       <html:hidden property="qjtrigrp" value="${bean.qjtrigrp}" />
       <html:hidden property="qjcrtuser" value="${bean.qjcrtuser}" />
       <html:hidden property="qjimpluser" value="${bean.qjimpluser}" />
       <html:hidden property="qjcrttime" value="${bean.qjcrttime}" />
       <html:hidden property="qjendtime" value="${bean.qjendtime}" />
       <html:hidden property="qjtype" value="${bean.qjtype}" />
       <html:hidden property="qjstatus" value="${bean.qjstatus}" />
       <html:hidden property="qjinfo" value="${bean.qjinfo}" />
       <html:hidden property="qjtricron" value="${bean.qjtricron}" />
       <html:hidden property="qjperiodinfo" value="${bean.qjperiodinfo}" />
    </fieldset>
    
     <fieldset>
        <legend>发送短信</legend>
		
		<div><label><strong><span class="red">*</span>接收人员</strong>：</label>
	       	 <html:select property="qjimplrole" style="width:120px;"
			errorStyleClass="inputError imeActive" tabindex="2" onchange="changeImplRole()">
			<html:options collection="allRoleList" property="value" labelProperty="label" />
			</html:select>
			<html:text property="qjimplusername" size="8" readonly="true" errorStyleClass="inputError imeActive"/>
			<a href="javascript:void(0)" onclick="selectRoleUser();"><img src="images/seek.gif" width="16" height="16" border="0" alt="请选择人员"/></a>
			<html:hidden property="qjimpluser"/>
			<html:hidden property="qjimplusername"/>
			<html:hidden property="qjimplroleid"/>
			<html:hidden property="qjimplrolename"/>
			<br />
	    </div>
	
	
	</fieldset>
	<div class="enter"><html:submit styleClass="button" value="提交" onclick="return checkForm();"/>
	<html:reset styleClass="button" value="重置" /></div>
    </html:form>
    </div>
     </div>
</div>
</div>
</div>
</body>
</html:html>
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
var gid='IGSCH0302';


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
	if($F('qprroleid').trim()==""){
		alert("请选择角色！");
		return false;
	}
	if($F('qprinfo').trim()==""){
		alert("请输入联系方式！");
		return false;
	}
	if($F('qprtitle').trim()==""){
		alert("请输入工作名称！");
		return false;
	}
	if($F('qprdesc').trim()==""){
		alert("请输入工作描述！");
		return false;
	}
	if($F('qprurgency').trim()==""){
		alert("请输入紧急程度！");
		return false;
	}
	if($F('qprimpact').trim()==""){
		alert("请输入影响程度！");
		return false;
	}
	if(isNaN($F('qprduration').trim()))
	{
		alert("期限请输入数字！");
		return false;	
	}
	if(confirm("是否确认提交?")){
		return true;
	}
	return false;
}
</script>
<bean:define id="id" value="IGSCH0302" toScope="request" />
<bean:define id="title" value="企业定时任务" toScope="request" />
<bean:define id="bean" name="IGSCH03021VO" property="igsch0301Form" />
<bean:define id="user" name="LOGIN_USER" scope="session" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body onload="changePrRolename()">
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
          <div class="back"><a href="IGSCH0001_Disp.do" target="_self">返回</a></div>
    </div>
       <div id="formwrapper">
		<html:form action="/IGSCH0302" styleId="form" enctype="multipart/form-data">
		 <ig:message />
        <fieldset>
        <legend>任务信息</legend>
         <table width="700" border="0" cellpadding="3" cellspacing="4">
          <tr>
            <td>&nbsp;</td>
            <td align="right" bgcolor="#eeeeee"><strong>任务名称</strong>：</td>
            <td><bean:write name="bean" property="qjname" /></td>
            <td align="right" bgcolor="#eeeeee"><strong>任务描述</strong>：</td>
            <td><bean:write name="bean" property="qjdesc" /></td>
            </tr>
          <tr>
            <td>&nbsp;</td>
            <td align="right" bgcolor="#eeeeee"><strong>执行人员</strong>：</td>
            <td><bean:write name="bean" property="qjimplusername" /></td>
           <td align="right" bgcolor="#EEEEEE"><strong>创建人员</strong>：</td>
            <td><bean:write name="bean" property="qjcrtusername" /></td>
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
        <html:hidden property="qjimplrolename" value="${bean.qjimplrolename}"/>
		<html:hidden property="qjimplroleid" value="${bean.qjimplroleid}"/>
		<html:hidden property="qjimplusername" value="${bean.qjimplusername}"/>
	    <html:hidden property="qjcrtusername" value="${bean.qjcrtusername}"/>
	    <html:hidden property="qjperiodinfo" value="${bean.qjperiodinfo}"/>
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
		<html:options collection="ADroleList" property="value" name="" labelProperty="label" />
	</html:select> <html:hidden property="qprrolename"/><br />
	</div>
	<div><label><strong><span class="red">*</span>联系方式</strong>：</label> 
	<html:textarea property="qprinfo" cols="60" rows="6" errorStyleClass="inputError imeActive"></html:textarea> 
	<br />
	</div>
	</fieldset>
    
     <fieldset>
        <legend>工作信息</legend>
        <div><label for="Name"><strong>工作类型</strong>：</label>
	<p class="p2">
		<span>指派工作</span>
	</p>
	</div>
	<div><label for="Name"><strong><span class="red">*</span>工作名称</strong>：</label> <html:text
		property="qprtitle" size="18" errorStyleClass="inputError imeActive"/> <br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>期限(天)</strong>：</label> <html:text
		property="qprduration" size="4" errorStyleClass="inputError imeActive"/>
		<br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>工作描述</strong>：</label> <html:textarea
		property="qprdesc" cols="60" rows="6" errorStyleClass="inputError imeActive"></html:textarea> <br />
	</div>
	<div><label for="Name"><strong>相关资产</strong>：</label>
	 <html:text property="qprassetname" size="18" readonly="true" errorStyleClass="inputError imeActive"/>
	 <input type="button" name="btn_entity" value="查询" onclick="selectEntity();" class="button"> <br />
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
	
	<logic:present name="IGSCH03021VO" property="processInfoDefList">
	<logic:notEmpty name="IGSCH03021VO" property="processInfoDefList">
	<logic:iterate id="infoDef" name="IGSCH03021VO" property="processInfoDefList" indexId="index">
	<div>
		<label for="Name"><strong>${infoDef.pidlabel}</strong>：</label>
		<html:text property="pivarvalue[${index}]" errorStyleClass="inputError imeActive" size="32" /> <br />
		<input type="hidden" name="pivarname" value="${infoDef.pidname}"/>
		<input type="hidden" name="pivarlabel" value="${infoDef.pidlabel}"/>
		<input type="hidden" name="pivartype" value="${infoDef.pidtype}"/>
	</div>
	</logic:iterate>
	</logic:notEmpty>
	</logic:present>
	
	</fieldset>
	<div class="enter"><html:submit styleClass="button" value="提交" onclick="return checkForm();" />
	<html:reset styleClass="button" value="重置" /></div>
	
	<html:hidden property="qpid"/>
	<html:hidden property="qpcode"/>
	<html:hidden property="qprassetid"/>
	<html:hidden property="qprcorid"/>
	<html:hidden property="qprcortype"/>
	<html:hidden property="qprassetcategory"/>
	<html:hidden property="qprpdid"/>
	<html:hidden property="qprpdname"/>
	<html:hidden property="qprduration"/>
    </html:form>
    </div>
     </div>
</div>
</div>
</div>
</body>
</html:html>
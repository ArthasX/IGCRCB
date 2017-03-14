<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGVIR1302" toScope="request" />
<bean:define id="title" value="配置修改画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
	.fontContent{
		line-height:25px;
	}
</style>
<script type="text/javascript">
	function confirmDisp(){
		if($F("ip") != "" && !isIP($F("ip"))){
			alert("IP格式不正确");
			return false;
		}
		if(window.confirm("是否确认提交？")){
			return true;
		}else{
			return false;
		}
	}
	function setOrg(){
		var temp = window.showModalDialog("IGSYM0101_TREE.do",null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			$("orgsyscoding").value = "";
			$("orgname").value = "";
		}
		if(null!=temp && temp.split("|").length>1){
			$("orgsyscoding").value = temp.split("|")[0];
			$("orgname").value = temp.split("|")[1];
		}		
	}
	function setUser(){
		openSubWindow('/IGSYM0408.do?roletype=' , 'newpage', '800', '600');
	}
	function setParamRoleUser(userid,username,roleid,orgid,orgname){
		$("userid").value = userid;
		$("userName").value = username;
	}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">虚机资源管理 &gt;&gt; 配置修改</p>
	<div class="back"><a href="IGVIR1301_Back.do" target="_self">返回</a></div> 
</div>
<div id="formwrapper">
<html:form styleId="form" action="/IGVIR1302" onsubmit="return checkSubmit(this);">
	<html:hidden property="id"/>
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
		<legend>虚机信息</legend>
		<div>
			<label><strong>Host</strong>：</label>
			<span class="fontContent">${IGVIR1302Form.hostName }</span>
		</div>
		<div>
			<label><strong>虚机名称</strong>：</label>
			<span class="fontContent">${IGVIR1302Form.vmName }</span>
		</div>
		<div>
			<label><strong>管理人</strong>：</label>
			<html:text property="userName" styleId="userName" readonly="true"/>
			<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setUser();" alt="请选择机构"/>
			<html:hidden property="userid" styleId="userid"/>
		</div>
		<div>
			<label><strong>所属机构</strong>：</label>
			<html:text property="orgname" styleId="orgname" readonly="true"/>
			<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg();" alt="请选择机构"/>
			<html:hidden property="orgsyscoding"/>
		</div>
		<div>
			<label><strong>IP</strong>：</label>
			<html:text property="ip" styleId="ip"/>
		</div>
		<div>
			<label><strong>CPU</strong>：</label>
			<span class="fontContent">${IGVIR1302Form.vmCpus }个</span>
		</div>
		<div>
			<label><strong>内存</strong>：</label>
			<span class="fontContent">${IGVIR1302Form.vmMem }G</span>
		</div>
		<div>
			<label><strong>硬盘</strong>：</label>
			<span class="fontContent">${IGVIR1302Form.vmDisk }G</span>
		</div>
	</fieldset>
	<div class="enter">
		<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp();" /> 
		<html:reset property="btn_clear" styleClass="button" value="重置" />
	</div>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
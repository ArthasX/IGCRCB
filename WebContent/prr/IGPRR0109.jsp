<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRR0109" toScope="request" />
<bean:define id="title" value="执行人画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
<!--
	function toSave(){
		if(checkNum('ppuserids') == 0){
			alert("请选择执行人！");
	        return false;
		}
	    if(window.confirm("您是否确认保存？")){
	        return true;
	    } else {
	        return false;
	    }
	}
	
	function fun_search() {
		var arr_ppuserids = document.getElementsByName("ppuserids");
		var arr_username = document.getElementsByName("username");
		var arr_orgid = document.getElementsByName("orgid");
		for(var i = 0; i < arr_username.length; i++){
			if(!arr_ppuserids[i].checked) {
				if(
					($F("username_q").trim() == "" || arr_username[i].value.indexOf($F("username_q").trim()) >= 0)
					&& ($F("orgid_q").trim() == "" || arr_orgid[i].value == $F("orgid_q"))
				){
					arr_ppuserids[i].parentElement.parentElement.parentElement.style.display = "";
				} else {
					arr_ppuserids[i].parentElement.parentElement.parentElement.style.display = "none";
				}
			}
		}
	}
	
	function setOrg(url){
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall" == temp){
			document.forms[0].orgid_q.value = "";
			document.forms[0].orgname_q.value = "";
			return false;
		}
		if(null != temp && temp.split("|").length > 1){
			document.forms[0].orgid_q.value = temp.split("|")[0];
			document.forms[0].orgname_q.value = temp.split("|")[1];
			return false;
		}
	}
//-->
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGPRR0109"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">角色（${IGPRR0109Form.rolename}）执行人</p>
	<div class="back"><a href="IGPRR0102_Disp.do?pdid=${IGPRR0109Form.pdid}&roleid=${IGPRR0109Form.roleid}&prid=${IGPRR0109Form.prid}" target="_self">返回</a></div>
	</div>
	<div id="results_list">
	<div id="search">
		<div class="img"></div>
		<div class="conditions">
			<div>
				<label id="label_user">&nbsp;&nbsp;姓名：<input type="text" name="username_q" id="username_q"  size="10"/>&nbsp;&nbsp;</label>
				<label id="label_org">&nbsp;&nbsp;机构：<input type="text" name="orgname_q" id="orgname_q" size="20" readonly="readonly"/>
				<img src="images/tree.gif" style="cursor: hand;" alt="选择机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');"/>&nbsp;&nbsp;
				</label>
				<input type="hidden" name="orgid_q" id="orgid_q"/>
				<input type="button" value="查询" class="button" onclick="return fun_search();" style="height:20px"/>
			</div>
		</div>
	</div>
	<div style="padding-left: 10px">
	<ig:message/>
	</div>
	<table class="table_style">
		<tr>
			<th width="10%">执行人</th>
			<th width="10%">用户ID</th>
			<th width="15%">所属机构</th>
			<th width="10%">用户姓名</th>
			<th width="12%">用户电话</th>
			<th width="12%">用户手机</th>
			<th width="31%">用户邮箱</th>
		</tr>
		<logic:present name="IGPRR01091VO" property="userInfoList">
			<logic:iterate id="bean" name="IGPRR01091VO" property="userInfoList"
				indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><label><html:multibox property="ppuserids" value="${bean.userida}" /></label></td>
					<td>${bean.userida}</td>
					<td>${bean.orgname}<input type="hidden" name="orgid" value="${bean.orgida}"></td>
					<td>${bean.username}<input type="hidden" name="username" value="${bean.username}"></td>
					<td>${bean.userphone}</td>
					<td>${bean.usermobile}</td>
					<td>${bean.useremail}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><logic:present name="IGPRR01091VO"
		property="userInfoList">
		<span><html:submit property="btn_save" value="保存"
			styleClass="button" onclick="return toSave();" /></span>
	</logic:present></div>
	<html:hidden property="roleid" name="IGPRR0109Form" styleId="roleid"/>
	<html:hidden property="rolename" name="IGPRR0109Form" styleId="rolename"/>
	<html:hidden property="prid" name="IGPRR0109Form" styleId="prid"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
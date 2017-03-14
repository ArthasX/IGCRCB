<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<base target="_self" >
<bean:define id="id" value="IGEXTWA0112" toScope="request" />
<bean:define id="title" value="执行人页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	//记录行号
	var line = 0;
	function toSave(){
		if($F("hasUser") != "1") {
	    	var users =document.getElementsByName("ppuserids");
	    	var flag = true;
			for(var i = 0;i < users.length; i++){
				if(users[i].value != ""){
					flag = false;
					break;
				}
			}
			if(flag) {
				alert("请指定参与人员！");
				return false;
	    	}
	     } 
        if(window.confirm("您是否确认保存？")){
		    return true;
        } else {
            return false;
        }
	}
	function selectRoleUser(roleid, index){
		line = index;
		openSubWindow('/IGSYM0405.do?roleida='+roleid , 'newpage', '800', '600');
	}
	function setParamRoleUser(userid,username,roleid,orgid,orgname){
		document.getElementsByName("ppuserids")[line].value = userid;
		document.getElementsByName("ppusernames")[line].value = username;
		document.getElementsByName("pporgids")[line].value = orgid;
		document.getElementsByName("pporgnames")[line].value = orgname;
	}
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGEXTWA0112_SOC" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">参与人</p>
<div class="back"><a href="IGEXTWA0103_Disp.do?prid=<bean:write name="IGEXTWA0112Form" property="prid" />&bkmode=<bean:write name="IGEXTWA0112Form" property="bkmode" />">返回</a></div> 
</div>
	<div id="results_list"><ig:message />
	<table class="table_style4" align="left">
			<tr>
				<th width="30%">角色</th>
				<th width="20%">参与人</th>
				<th width="30%">机构</th>
			</tr>
			<logic:present name="IGEXTWA01121VO" property="processParticipantList">
				<logic:iterate id="bean" name="IGEXTWA01121VO"
					property="processParticipantList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td>${bean.pprolename}<html:hidden property="roleids" styleId="roleids" name="IGEXTWA0112Form" value="${bean.ppid}"/><html:hidden property="pproleid" styleId="pproleid" name="IGEXTWA0112Form" value="${bean.pproleid}"/>
						</td>
						<td><html:text styleId="ppusernames" property="ppusernames" name="IGEXTWA0112Form" size="6" style="text-align: center" readonly="true" value="${bean.ppusername}"/><html:hidden property="ppuserids" styleId="ppuserids" name="IGEXTWA0112Form" value="${bean.ppuserid}"/>
						<a href="javascript:void(0)" onclick="selectRoleUser('${bean.pproleid}', '${index}');"><img src="images/seek.gif" alt="查询" width="16" height="16" border="0" /></a>
						</td>
						<td><html:text property="pporgnames" styleId="pporgnames" name="IGEXTWA0112Form" size="18" style="text-align: center"
						readonly="true" value="${bean.pporgname}"/><html:hidden property="pporgids" styleId="pporgids" name="IGEXTWA0112Form" value="${bean.pporgid}"/></td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGEXTWA01121VO"
		property="processParticipantList">
		<span> <html:submit property="btn_save" value="保存"
			styleClass="button"  onclick="return toSave();"/></span>
	</logic:present>
	</div>
	<html:hidden property="prid" styleId="prid" name="IGEXTWA0112Form"/>
	<html:hidden property="hasUser" name="IGEXTWA0112Form" styleId="hasUser"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
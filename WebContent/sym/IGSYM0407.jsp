<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM0407" toScope="request" />
<bean:define id="title" value="人员画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
<!--
	function toSave(){
		if(checkNum('urids')==0 && $F("hasManager") != "1"){
			alert("请选择负责人！");
	        return false;
		}
	    if(window.confirm("您是否确认保存？")){
	        return true;
	    } else {
	        return false;
	    }
	}
//-->
	</script><body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGSYM0407"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	<div class="back"><a href="IGSYM0301_RE.do" target="_self">返回</a></div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="10%">负责人</th>
			<th width="10%">用户ID</th>
			<th width="15%">所属机构</th>
			<th width="10%">用户姓名</th>
			<!--				<th width="8%">用户状态</th>-->
			<th width="12%">用户电话</th>
			<th width="12%">用户手机</th>
			<th width="31%">用户邮箱</th>
		</tr>
		<logic:present name="IGSYM04071VO" property="userInfoMap">
			<logic:iterate id="bean" name="IGSYM04071VO" property="userInfoMap"
				indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><label><html:multibox property="urids" value="${bean.key}" /></label></td>
					<td>${bean.value.userida}</td>
					<td>${bean.value.orgname}</td>
					<td>${bean.value.username}</td>
					<!--											<td>${bean.value.userstatus}</td>-->
					<td>${bean.value.userphone}</td>
					<td>${bean.value.usermobile}</td>
					<td>${bean.value.useremail}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><logic:present name="IGSYM04071VO"
		property="userInfoMap">
		<span><html:submit property="btn_save" value="保存"
			styleClass="button" onclick="return toSave();" /><html:reset
			property="btn_reset" value="重置" styleClass="button" /></span>
	</logic:present></div>
	<html:hidden property="roleid" name="IGSYM0407Form" styleId="roleid"/>
	<html:hidden property="hasManager" name="IGSYM0407Form" styleId="hasManager"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
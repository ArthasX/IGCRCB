<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGGUT0205" toScope="request" />
<bean:define id="title" value="值班交接" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	var gid = "IGGUT0205";

	function checkForm(){
		<logic:present name="IGDUT02041VO" property="dutyPersonList">
		<logic:iterate id="dutyPerson" name="IGDUT02041VO" property="dutyPersonList" indexId="index">
			if($F('password[${index}]').trim() == ""){
				alert("请输入用户（${dutyPerson.dperusername}）的密码！");
				return false;
			}
			if($F('password[${index}]').strlen()>16){
				alert("用户（${dutyPerson.dperusername}）的密码长度不能大于"+Math.floor(16)+"个字符！");
				return false;
			}
		</logic:iterate>
		</logic:present>
		if( window.confirm("您是否确认交接？")){
			return true;
		} else {
			return false;
		}
	}

//-->
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
	<div id="content">
<html:form styleId="form"
	action="/IGDUT0205" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">服务管理 &gt;&gt; 值班管理 &gt;&gt; 值班交接</p>
	</div>
	<div id="formwrapper">
	<ig:message/>
	<fieldset><legend>交接班信息</legend>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td ><label for="Name"><strong>交班人</strong>：</label></td>
			<td >${IGDUT02041VO.usersinfo}</td>
		</tr>
		<logic:present name="IGDUT02041VO" property="dutyPersonList">
			<logic:iterate id="dutyPerson" name="IGDUT02041VO"
				property="dutyPersonList" indexId="index">
				<tr>
					<td><c:if test="${index == 0 }">
						<label for="Name"><strong>接班人</strong>：</label>
					</c:if><c:if test="${index > 0 }">&nbsp;</c:if></td>
					<td width="10%">${dutyPerson.dperusername}</td>
					<td width="7%"><strong>密码</strong>：</td>
					<td width="80%"><html:password property="password[${index}]"
						styleId="password[${index}]" errorStyleClass="inputError"/><span class="red">*</span><html:hidden property="userid" styleId="userid" value="${dutyPerson.dperuserid}" /></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</fieldset>
	</div>
	<logic:present name="IGDUT02041VO" property="dutyPersonList">
	<div class="enter"><html:submit property="btn_insert" value="确认"
		styleClass="button" onclick="return checkForm();" /></div>
	</logic:present>
	<div class="Placeholder"></div>
</html:form>
</div>
	</div>
</div>
<div class="Placeholder"></div>
</div>
<div class="zishiying"></div>
</body>
</html:html>
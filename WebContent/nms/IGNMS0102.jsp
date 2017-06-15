<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGNMS0102" toScope="request" />
<bean:define id="title" value="SNMP配置" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		function init(){
			<c:if test="${flag == '1' || IGNMS0102Form.snmpVersion == null || IGNMS0102Form.snmpVersion == ''}">
				$("snmpVersion").value = "0";
				$("snmpPort").value = "161";
				$("readCommit").value = "public";
				$('snmpUser').value="";
				$('snmpPassword').value="";
				$('snmpAuthType').value="";
				$('snmpPrivacyPassPhrase').value="";
				$('snmpPrivacyType').value="";
			</c:if>
		}
	    function toDel(id){
	    	if( window.confirm("您是否确认删除？")){
	    		IGNMS0102Form.action = getAppRootUrl() + "/IGNMS0102_Del.do?id="+id;
	    		IGNMS0102Form.submit();
			}
	    }
	  	//增加
		function toAdd(){
			if($F("snmpPort").trim()==""){
				alert("请输入端口号！");
				return false;
			}
			if($F("readCommit").trim()==""){
				alert("请输入读团体字！");
				return false;
			}
			if(!checkIsNumber($F('snmpPort'))){
				alert("端口号只能是数字！");
				return false;
			}
			if($F('snmpPort') > 65535){
				alert("端口号只能是0-65535之间！");
				return false;
			}
			if($F('readCommit').strlen()>32){
				alert("读团体字不能大于32个字符！");
				return false;
			}
			if(($F('snmpUser').trim() > " " || $F('snmpPassword').trim() > " " || $F('snmpAuthType').trim() > " "|| $F('snmpPrivacyPassPhrase').trim() > " "|| $F('snmpPrivacyType').trim() > " ") && $F('snmpVersion').trim() != "3") {
				alert("含有v3配置信息，请确认！");
				$('snmpUser').value="";
				$('snmpPassword').value="";
				$('snmpAuthType').value="";
				$('snmpPrivacyPassPhrase').value="";
				$('snmpPrivacyType').value="";
				return false;
			}
			if($F('snmpVersion') == "3") {
				if($F("snmpUser").trim()==""){
					alert("请输入用户名！");
					return false;
				}
				if($F("snmpPassword").trim()==""){
					alert("请输入密码！");
					return false;
				}
				if($F("snmpAuthType").trim()==""){
					alert("请选择加密类型！");
					return false;
				}
				if($F('snmpUser').strlen()>32){
					alert("用户名不能大于32个字符！");
					return false;
				}
				if($F('snmpPassword').strlen()>32){
					alert("密码不能大于32个字符！");
					return false;
				}
				if($F('snmpPrivacyPassPhrase').strlen()>32){
					alert("隐身密码不能大于32个字符！");
					return false;
				}
			}
		    if(window.confirm("您是否确认增加？")){
		        return true;
		    } else {
		        return false;
		    }
		}
	</script>
<body onload="init()">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGNMS0102_Ins" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation /></p>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="15%">版本</th>
			<th width="15%">端口号</th>
			<th width="15%">读团体字</th>
			<th width="15%">用户名（v3）</th>
			<th width="15%">密码（v3）</th>
			<th width="25%">删除</th>
		</tr>
		<logic:present name="IGNMS01021VO" property="lst_NMS02Info">
			<logic:iterate id="bean" name="IGNMS01021VO"
				property="lst_NMS02Info" indexId="index">
				<tr>
					<td><c:if test="${bean.snmpVersion == 0}">v1</c:if><c:if test="${bean.snmpVersion == 1}">v2C</c:if><c:if test="${bean.snmpVersion == 3}">v3</c:if></td>
					<td>${bean.snmpPort}</td>
					<td>${bean.readCommit}</td>
					<td>${bean.snmpUser}</td>
					<td>${bean.snmpPassword}</td>
					<td>
					<html:link href="javascript:toDel('${bean.id}')">
						<img src="images/delete.gif" width="16" height="16" border="0"
							alt="删除" />
					</html:link>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="formwrapper">
	<fieldset>
	<div><label for="Name"><strong>版本</strong>：</label>
	<p class="p2"><html:select property="snmpVersion" name="IGNMS0102Form">
	<html:option value="0">v1</html:option>
	<html:option value="1">v2C</html:option>
	<html:option value="3">v3</html:option>
	</html:select> </p>
	<br />
	</div>
	<div><label for="Name"><strong>端口号</strong>：</label> 
	<html:text property="snmpPort" name="IGNMS0102Form" size="18" styleId="snmpPort"/> <br />
	</div>
	<div><label for="Name"><strong>读团体字</strong>：</label>
	<html:text property="readCommit" name="IGNMS0102Form" size="18" styleId="readCommit"/> <br />
	</div>
	<div><label for="Name"><strong>用户名（v3）</strong>：</label>
	<html:text property="snmpUser" name="IGNMS0102Form" size="18" styleId="snmpUser"/> <br />
	</div>
	<div><label for="Name"><strong>密码（v3）</strong>：</label>
	<html:password property="snmpPassword" name="IGNMS0102Form" size="18" styleId="snmpPassword"/>
	</div>
	<div><label for="Name"><strong>加密类型（v3）</strong>：</label><html:select property="snmpAuthType" name="IGNMS0102Form" styleId="snmpAuthType">
		<html:option value=""></html:option>
		<html:option value="1">MD5</html:option>
		<html:option value="2">SHA</html:option>
	</html:select>
	</div>
	<div><label for="Name"><strong>隐私密码（v3）</strong>：</label>
	<html:password property="snmpPrivacyPassPhrase" name="IGNMS0102Form" size="18" styleId="snmpPrivacyPassPhrase" />
	</div>
	<div><label for="Name"><strong>隐私加密（v3）</strong>：</label><html:select property="snmpPrivacyType" name="IGNMS0102Form" styleId="snmpPrivacyType">
		<html:option value=""></html:option>
		<html:option value="1">DES</html:option>
		<html:option value="2">3DES</html:option>
		<html:option value="3">AES-128</html:option>
		<html:option value="4">AES-192</html:option>
		<html:option value="5">AES-256</html:option>
	</html:select>
	</div>
	</fieldset>
	<div class="enter">
	<html:submit property="btn_add" styleClass="button" value="增加" onclick="return toAdd()"/>
	</div>
	</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>

</body>
</html:html>

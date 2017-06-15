<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRR0302j" toScope="request" />
<bean:define id="title" value="角色查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function addRoleInfo(roleid,rolename){
	if(!window.opener.closed){
		 window.opener.setRoleInfo(roleid,rolename);
		 window.close();
	}
}
function cleanRoleInfo(){
	addRoleInfo("","");
}
</script>
<body>
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRR0302_OSearch.do" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">角色查询</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	 <html:hidden property="disabled" name="IGPRR0302Form" />
	<span>角色名称：</span><span><html:text property="rolename_q" styleId="rolename_q"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="16" />
	</span> 
	<span>&nbsp;&nbsp;角色类型：</span>
	<logic:equal value="0" name="IGPRR0302Form" property="disabled">
	<span><html:select property="roletype" style="width: 130px;" errorStyleClass="inputError">
	 <ig:optionsCollection ccid="ROLE_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	 </html:select>
	</span>
	</logic:equal>
	<logic:notEqual value="0" name="IGPRR0302Form" property="disabled">
	 <span><html:select property="roletype" style="width: 130px;" errorStyleClass="inputError" disabled="true">
	 <ig:optionsCollection ccid="ROLE_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	 </html:select>
	 <html:hidden property="roletype" name="IGPRR0302Form" />
	 <html:hidden property="roleids" name="IGPRR0302Form" />
	 <html:hidden property="roleidin" name="IGPRR0302Form" />
	</span>
	</logic:notEqual>
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	
	<div id="results_list">
		<table class="table_style">
			<tr>
				<th width="30%">角色名称</th>
				<th width="30%">角色说明</th>
				<th width="40%">角色类型</th>
			</tr>
			
			<logic:present name="IGPRR03021VO" property="roleList">
				<logic:iterate id="bean" name="IGPRR03021VO" property="roleList" type="com.deliverik.framework.user.model.Role">
					<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="addRoleInfo(${bean.roleid},'${bean.rolename }');">
						<td>
							${bean.rolename}
						</td>
						<td><pre>${bean.roledesc}</pre></td>
						<td><ig:codeValue ccid="ROLE_CATEGORY_CODE" cid="${bean.roletype}" /></td>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
		<div id="operate">
	 		<jsp:include page="/include/paging.jsp" />
	 	</div>
	 	<div class="enter">
	 		<html:button property="clean" value="清空" style="height:20px;" styleClass="button" onclick="cleanRoleInfo();"/>
	 		<html:button property="close" value="关闭" style="height:20px;" styleClass="button" onclick="window.close();"/>
	 	</div>
	</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</body>
</html:html>
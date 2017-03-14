<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRR0302" toScope="request" />
<bean:define id="title" value="OA角色配置" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	function addRoleInfo(){
		var roleids = document.getElementsByName("roleid");
		var rolenames = document.getElementsByName("rolename");
		var length = 0;
		if(roleids!=null){
			for(var i=0;i<roleids.length;i++){
				if(roleids[i].checked){
					length ++;
					createHiddenInput("addContent",roleids[i].value+","+rolenames[i].value);
				}
			}
		}
		if(roleids!=null&&length>0){
			if(window.confirm("是否确认添加？")){
				if(!window.opener.closed){
					form.action = "IGPRR0302_Add.do";
					form.submit();
				}else{
					alert("父窗口已关闭！");
				}
			}
		}else{
			alert("请选择要添加的角色信息！");
		}
	}
</script>
<body>
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRR0302.do" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">角色查询</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>角色名称：</span><span><html:text property="rolename_q" styleId="rolename_q"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="16" />
	</span> 
	<span>&nbsp;&nbsp;角色类型：</span><span><html:select property="roletype" style="width: 130px;" errorStyleClass="inputError">
	 <ig:optionsCollection ccid="ROLE_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	 </html:select>
	</span><html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	
	<div id="results_list">
		<table class="table_style">
			<tr>
				<th width="10%">
					<label> 
						<input type="checkbox" name="checkbox" id="checkbox" onclick="selectAll('checkbox','roleid')"/> 
					</label>
				</th>
				<th width="30%">角色名称</th>
				<th width="30%">角色说明</th>
				<th width="30%">角色类型</th>
			</tr>
			
			<logic:present name="IGPRR03021VO" property="roleList">
				<logic:iterate id="bean" name="IGPRR03021VO" property="roleList" type="com.deliverik.framework.user.model.Role">
					<tr>
						<td>
							<input type="checkbox" name="roleid" value="${bean.roleid}" />
						</td>
						<td>
							${bean.rolename}
							<input type="hidden" name="rolename" value="${bean.rolename}"/>
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
	 		<html:button property="add" value="添加所选" style="height:20px;" styleClass="button" onclick="addRoleInfo();"/>
	 		<html:button property="close" value="关闭" style="height:20px;" styleClass="button" onclick="window.close();"/>
	 	</div>
	</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</body>
</html:html>
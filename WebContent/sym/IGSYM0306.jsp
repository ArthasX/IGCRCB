<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGSYM0306" toScope="request" />
<bean:define id="title" value="角色查询画面" toScope="request" />
<%
	String path = request.getParameter("path");

%>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
        function setParentValue(roleid, rolename){
            if(!window.opener.closed){
                window.opener.setRoleParams(roleid, rolename);
            }
            window.close();
        }
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setRoleParams("", "");
            }
            window.close();
        }
      
       
	</script>
<body style="background-color: white; background-image: none;" >
<div id="maincontent">
<div id="contentainer">
<html:form styleId="form" action="/IGSYM0306"
	onsubmit="return checkSubmit(this);">
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
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style" align="left">
			<tr>

				<th width="20%">角色名称</th>
				<th width="80%">角色类型</th>
				

			</tr>
			<logic:present name="IGSYM03011VO" property="roleList">
				<logic:iterate id="bean" name="IGSYM03011VO"
					property="roleList" indexId="index" type="com.deliverik.framework.user.model.Role">
					<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="setParentValue('${bean.roleid}','${bean.rolename}');">

						<td>${bean.rolename}</td>
						
						<td> <ig:codeValue ccid="ROLE_CATEGORY_CODE" cid="${bean.roletype}" /></td>
						
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	<div class="enter">
	<input id="parent" type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
	<html:hidden name="IGSYM0301Form" property="pdid"/>
</html:form></div>
</div>
</body>
</html:html>
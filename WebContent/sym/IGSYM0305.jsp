<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGSYM0305" toScope="request" />
<bean:define id="title" value="角色查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<%
	String path = request.getParameter("path");
Map<Integer,String> namemap = new HashMap<Integer,String>();
Map<Integer,String> assetnamemap = new HashMap<Integer,String>();
String ciiop="";
ciiop=(String)session.getAttribute("flag");
if(null!=request.getAttribute("nameMap")){
	namemap = (Map)request.getAttribute("nameMap");
}
if(null!=request.getAttribute("assetnameMap")){
	assetnamemap = (Map)request.getAttribute("assetnameMap");
}
%>

<!-- /header1 -->
<script type="text/javascript">	
<!--

function setParentValue(roleid, rolename){
	var ciiop='<%=ciiop %>';
    if(!window.opener.closed){
        window.opener.setParamRole(roleid,rolename,ciiop);
    }
    window.close();
}
function clearParentValue(){
	var ciiop='<%=ciiop %>';
    if(!window.opener.closed){
        window.opener.setParamRole("", "",ciiop);
    }
    window.close();
}
	
//-->
	</script>
<body style="background-color: white; background-image: none;" >
<div id="maincontent">
<div id="contentainer">
<html:form styleId="form" action="/IGSYM0305"
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
	<span>&nbsp;&nbsp;角色类型：</span><span><html:select property="roletype" style="width: 130px;" errorStyleClass="inputError">
	 <ig:optionsCollection ccid="ROLE_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	 </html:select>
	</span><html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="16%">角色名称</th>
			<th width="12%">管理范围</th>
			<th width="12%">管理内容</th>
			<th width="24%">角色说明</th>
			<th width="20%">角色类型</th>

		</tr>
		<logic:present name="IGSYM03011VO" property="roleList">
			<logic:iterate id="bean" name="IGSYM03011VO" property="roleList"
				indexId="index">
				<bean:define id="rid" name="bean" property="roleid"  toScope="request" />
				<tr
					<%if((null != path || "system".equals(path)) && !"strategy".equals(path)){ %>
					<%}else{%> onmouseover="mouseOver(this);"
					onmouseout="mouseOut(this,'');"
					onclick="setParentValue('${bean.roleid}','${bean.rolename}')"
					<%} %>>
						
						<td>${bean.rolename}</td>
						
						<td title='<%=namemap.get(rid) %>'><%=namemap.get(rid).split("-")[(namemap.get(rid).split("-")).length-1] %></td>
						
						<td title='<%=assetnamemap.get(rid) %>'><%=assetnamemap.get(rid).split("-")[(assetnamemap.get(rid).split("-")).length-1] %></td>
						
						<td>${bean.roledesc}</td>
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
</html:form></div>
</div>
</body>
</html:html>
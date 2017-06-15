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
<bean:define id="id" value="IGSYM0301" toScope="request" />
<bean:define id="title" value="角色管理查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<%

	Map<Integer,String> namemap = new HashMap<Integer,String>();
	Map<Integer,String> assetnamemap = new HashMap<Integer,String>();
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
	//删除所选
	function deleteRec(obj){
		var message = '<bean:message key="IGCO10000.E002"/>';
	    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="角色基本信息" />';
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
	    if(window.confirm(confirmMsg)){
	        form.action = getAppRootUrl() + "/IGSYM0301_Del.do";
	        return true;
	    } else {
	        return false;
	    }
	}
	function selectRoleUser(roleid){
		openSubWindow('/IGSYM0405.do?path=system&roleida='+roleid , '_blank','900','600');
	}
//-->
	</script><body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGSYM0301"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
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
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="3%"><label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','deleteRoleid')"/> </label>
				</th>
				<th width="15%">角色名称</th>
				<th width="12%">管理范围</th>
				<th width="16%">管理内容</th>
				<th width="18%">角色说明</th>
				<th width="10%">角色类型</th>
				<th width="6%">修改</th>
				<th width="7%">添加人员</th>
				<th width="8%">角色负责人</th>
				<th width="6%">值班人</th>
			</tr>
			<logic:present name="IGSYM03011VO" property="roleList">
				<logic:iterate id="bean" name="IGSYM03011VO"
					property="roleList" indexId="index" type="com.deliverik.framework.user.model.Role">
					<bean:define id="rid" name="bean" property="roleid"  toScope="request" />
					<tr class="<ig:rowcss index="${index}"/>">
						<td>
						<logic:notEqual name="bean" property="roletype" value="IGBP01">
						<logic:notEqual name="bean" property="roletype" value="IGBP04">
						<logic:notEqual name="bean" property="roletype" value="IGBP05">
						<logic:notEqual name="bean" property="roletype" value="IGAM01">
						<label><html:checkbox
							property="deleteRoleid" value="${bean.roleid}"/>
							</label>
							</logic:notEqual>
							</logic:notEqual>
							</logic:notEqual>
							</logic:notEqual>
						</td>
						<td>${bean.rolename}</td>
						
						<td title='<%=namemap.get(rid).split("_")[(namemap.get(rid).split("_")).length-1] %>'><%=namemap.get(rid).split("_")[(namemap.get(rid).split("_")).length-1] %></td>
						
						<td title='<%=assetnamemap.get(rid).split("_")[(assetnamemap.get(rid).split("_")).length-1] %>'><%=assetnamemap.get(rid).split("_")[(assetnamemap.get(rid).split("_")).length-1] %></td>
						
						<td><pre>${bean.roledesc}</pre></td>
						<td> <ig:codeValue ccid="ROLE_CATEGORY_CODE" cid="${bean.roletype}" /></td>
						<td><html:link action="/IGSYM0302_Edit_Disp.do?roleidstr=${bean.roleid}">
									<img src="images/edit.gif" alt="修改" width="16" height="16" border="0"/>
								</html:link>
						</td>
						<td>
							<html:link action="/IGSYM0418_Disp.do?roleid=${bean.roleid}">
									<img src="images/add_att.gif" alt="添加人员" width="16" height="16" border="0"/>
							</html:link>
						</td>
						<td>
							<html:link action="/IGSYM0407_Disp.do?roleid=${bean.roleid}">
									<img src="images/look.gif" alt="角色负责人" width="16" height="16" border="0"/>
							</html:link>
						</td>
						<td>
							<html:link action="/IGSYM0409_Disp.do?roleid=${bean.roleid}">
									<img src="images/look.gif" alt="值班人" width="16" height="16" border="0"/>
							</html:link>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGSYM03011VO"
		property="roleList">
		<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return deleteRec('deleteRoleid');" /></span>
	</logic:present> <!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
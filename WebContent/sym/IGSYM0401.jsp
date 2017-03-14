<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.net.URLEncoder" %>
<html:html>
<bean:define id="id" value="IGSYM0401" toScope="request" />
<bean:define id="title" value="授权管理角色授权查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 --><body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<script type="text/javascript">	
function setOrg(url){
	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].orgidstr.value = "";
		document.forms[0].orgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].orgidstr.value = temp.split("|")[0];
		document.forms[0].orgname.value = temp.split("|")[1];
	}		

}
</script>

<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGSYM0401"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>用户ID：</span><span><html:text property="userid_q" styleId="userid_q"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="19" />
	</span>
	<span>&nbsp;&nbsp;用户姓名：</span><span><html:text property="username_q" styleId="username_q"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="16" />
	</span>
	<span>&nbsp;&nbsp;所属机构：</span><html:text property="orgname" readonly="true"></html:text>
	<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" alt="请选择机构"/>
	<html:hidden property="orgidstr"/>
	<html:hidden property="deleteflag" value="0"/>
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="10%">用户ID</th>
				<th width="25%">所属机构</th>
				<th width="10%">用户姓名</th>
<!--				<th width="8%">用户状态</th>-->
				<th width="10%">用户电话</th>
				<th width="10%">用户手机</th>
				<th width="15%">用户邮箱</th>
				<th width="10%">授权角色</th>
				<th width="10%">同步</th>
			</tr>
			<logic:present name="IGSYM04011VO" property="userList">
			
				<logic:iterate id="bean" name="IGSYM04011VO"
					property="userList" indexId="index" type="com.deliverik.framework.user.model.User">
					<tr class="<ig:rowcss index="${index}"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'<ig:rowcss index="${index}"/>');" onclick="doLook('IGSYM0402_Disp.do?userid=${bean.userid}&orgid=${bean.orgid}&orgname=<%=URLEncoder.encode(bean.getOrgname(),"UTF-8")%>&username=<%=URLEncoder.encode(bean.getUsername(),"UTF-8")%>');">
						<td>${bean.userid}</td>
						<td>${bean.orgname}</td>
						<td>${bean.username}</td>
<!--						<td>${bean.userstatus}</td>-->
						<td>${bean.userphone}</td>
						<td>${bean.usermobile}</td>
						<td>${bean.useremail}</td>
						<td>
							<a href="IGSYM0402_Disp.do?userid=${bean.userid}&orgid=${bean.orgid}">
								<img src="images/sq.gif" width="16" height="16" border="0"/>
							</a>
						</td>
						<td>
							<logic:notEmpty name="bean" property="userstatus">是</logic:notEmpty>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	<div class="Placeholder"></div>
</html:form></div>
</div>


</div>
</div>
</body>
</html:html>
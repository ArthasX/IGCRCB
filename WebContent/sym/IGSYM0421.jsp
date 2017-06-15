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
<bean:define id="id" value="IGSYM0421" toScope="request" />
<bean:define id="title" value="授权管理资源组授权角色查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 --><body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="25%">角色名称</th>
			<th width="30%">角色类型</th>
			<th width="15%">资源组授权</th>
		</tr>
		<logic:present name="IGSYM04211VO" property="roleList">
			<logic:iterate id="bean" name="IGSYM04211VO" property="roleList" indexId="index" type="com.deliverik.framework.user.model.Role">
				<tr class="<ig:rowcss index="${index}"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'<ig:rowcss index="${index}"/>');" onclick="doLook('IGSYM0422_Disp.do?roleid=${bean.fingerPrint}&rolename=<%=URLEncoder.encode(bean.getRolename(),"UTF-8")%>');">
					<td>${bean.rolename}</td>
					<td><ig:codeValue ccid="ROLE_CATEGORY_CODE" cid="${bean.roletype}" /></td>
					<td>
						<a href="IGSYM0422_Disp.do?roleid=${bean.fingerPrint}">
							<img src="images/sqcd.gif" width="16" height="16" border="0"/>
						</a>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
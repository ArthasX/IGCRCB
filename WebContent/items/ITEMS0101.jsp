<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils"%>
<html:html>
<bean:define id="id" value="ITEMS0101" toScope="request" />
<bean:define id="title" value="类别管理页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function changeStatus(icid){
	if(confirm("是否确认改变状态？")){
		var form = document.getElementById("submitForm");
		form.action="changeCategoryStatus.do?icid=" + icid;
		form.submit();
	}
}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<form id="submitForm" method="post" >
</form>
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="search">
<html:form action="/ITEMS0101">
<div class="img"></div>
<div class="conditions">

<div><span>物品种类：</span><html:select property="category" errorStyleClass="inputError imeActive" >
<html:options collection="itemsCodesList" property="value" labelProperty="label" />
</html:select>&nbsp;&nbsp;
<span>物品名称：</span><html:text property="typecode" />&nbsp;&nbsp;
<input type="submit" value="查询" class="button" />
</div>

</div>
</html:form>
</div>
<div id="results_list">
<ig:message/>
<table class="table_style">
	<tr>
		<th width="10%">物品编号</th>
		<th width="25%">物品名称</th>
		<th width="10%">物品型号</th>
		<th width="10%">物品种类</th>
		<th width="20%">说明</th>
		<th width="10%">状态</th>
		<th width="10%">调整</th>
		<th width="5%">修改</th>
	</tr>
	
	<logic:present name="ITEMS01011VO" property="itemsCategoryList">
		<logic:iterate id="bean" name="ITEMS01011VO" property="itemsCategoryList" indexId="index">
			<bean:define id="list" name="ITEMS01011VO" property="editList"></bean:define>
			<tr>
				<td>${bean.seqcode}</td>
				<td>${bean.typecode}</td>
				<td>${bean.type}</td>
				<td>
					<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />
				</td>
				<td>${bean.desc}</td>
				<td>
					<logic:equal name="bean" property="status" value="1">
						启用中
					</logic:equal>
					<logic:equal name="bean" property="status" value="0">
						已停用
					</logic:equal>
				</td>
				<td>
					<logic:equal name="bean" property="status" value="1">
						<a href="javascript:changeStatus('${bean.icid}');">
							<img src="images/start.gif" border="0" alt="启用中，可停用">
						</a>
					</logic:equal>
					<logic:equal name="bean" property="status" value="0">
						<a href="javascript:changeStatus('${bean.icid}');">
							<img src="images/stop.gif" border="0" alt="停用中，可启用">
						</a>
					</logic:equal>
				</td>
				<td>
					<c:if test="${list[index] == '1'}">		
						<a href="ITEMS0104_Disp.do?icid=${bean.icid}">
						<img src="images/edit.gif" width="16" height="16" border="0" alt="修改" /></a>
					</c:if>
					
				
				</td>
			</tr>
		</logic:iterate>
	</logic:present>

</table>
</div>
<div class="enter"><span><input type="submit" name=""
	value="增加" onclick="window.location='ITEMS0102_Disp.do';" class="button" /></span></div>
</div>
</div>
</div>
</div>
</body>
</html:html>
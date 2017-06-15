<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCRC1306" toScope="request" />
<bean:define id="title" value="文档详细信息查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />

<body>
<div id="maincontent">
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGCRC1301" styleId="form" onsubmit="">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
	
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="8%">文档编号</th>
			<th width="10%">文档名称</th>
			<th width="7%">文档类型</th>
			<th width="13%">文档分类</th>
			<th width="6%">文档密级</th>
			<th width="10%">部门</th>
			<th width="6%">管理者</th>
			<th width="10%">内容</th>
			<th width="7%">存储方式</th>
			<th width="7%">存放位置</th>
       	</tr>
		<logic:present name="IGCRC1301VO" property="igcrc1301VWList">
			<logic:iterate id="bean" name="IGCRC1301VO"
				property="igcrc1301VWList" indexId="index">
				<tr class="alarmcolor_level">
					<td  width="8%" style="text-align:center;">${bean.eiNumber}</td> 
					<td  width="10%" style="text-align:center;">${bean.eiName}</td>
					<td  width="7%" style="text-align:center;">${bean.eiType}</td>
					<td  width="13%" style="text-align:center;">${bean.eiSort}</td>
					<td  width="6%" style="text-align:center;">${bean.eiDense}</td>
					<td  width="10%" style="text-align:center;">${bean.department}</td>
					<td  width="6%" style="text-align:center;">${bean.userName}</td>
					<td  width="10%" style="text-align:center;">${bean.content}</td>
					<td  width="7%" style="text-align:center;">${bean.storageWay}</td>
					<td  width="7%" style="text-align:center;">${bean.storageLocation}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
		<jsp:include page="/include/paging.jsp" />
		<div class="enter">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
	</div>
	</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils"%>

<html:html>
<bean:define id="id" value="ITEMS0160" toScope="request" />
<bean:define id="title" value="下拨查询详细页面" toScope="request" />
<bean:define id="bean" name="ITEMS01081VO" property="stock" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
   <div id="content">
   <div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/>  &gt;&gt; 查看</p>
	<div class="back">
		<a href="ITEMS0145_BACK.do" target="_self">返回</a>
	</div>
	</div>
<div class="record_list">
	
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="10%">物品编号：</th>
			<td width="40%">${bean.seqcode}</td>
			<th width="10%">所属机构：</th>
			<td width="40%">
				<ig:cseOrgValue orgsyscoding="${bean.stockorg}"/>
			</td>
		</tr>
		<tr>
			<th>物品名称：</th>
			<td>${bean.itemsname}</td>
			<th>物品型号：</th>
			<td>${bean.typecode}</td>
		</tr>
		<tr>
			<th>物品种类：</th>
			<td>
				<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />
			</td>
			<th>物品类型：</th>
			<td>
				<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_TYPE%>" codeValue="${bean.type}"/>
			</td>
		</tr>
		<tr>
			<th>登记时间：</th>
			<td>${bean.uptime}</td>
			<th>库存数量：</th>
			<td>${bean.stocknum}</td>
		</tr>		
	</table>
  </div>
</div>
</div>
</div>
</div>
</body>
</html:html>
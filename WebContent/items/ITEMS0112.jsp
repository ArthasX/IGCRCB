<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils"%>
<html:html>
<bean:define id="id" value="ITEMS0112" toScope="request" />
<bean:define id="title" value="库存管理查询页面" toScope="request" />
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
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="search">
<html:form action="/ITEMS0112.do">
<div class="img"></div>
<div class="conditions">
<div>

<span>物品编号：</span><html:text property="seqcode" size="16" maxlength="32"/>&nbsp;&nbsp;
<span>物品名称：</span><html:text property="itemsname" size="16" maxlength="32"/>&nbsp;&nbsp;
<span>物品种类：</span><html:select property="category" errorStyleClass="inputError imeActive">
<html:options collection="itemsCodesList" property="value" labelProperty="label" />
</html:select>&nbsp;&nbsp;
<html:submit value="查询" styleClass="button" />
</div>
</div>
</html:form>
</div>
<div id="results_list">
<ig:message/>
<table class="table_style">
	<tr>
		<th width="10%">物品编号</th>
		<th width="24%">物品名称</th>
		<th width="10%">物品型号</th>
		<th width="12%">物品种类</th>
		<th width="14%">所属机构</th>
		<th width="10%">库存数量</th>
		<th width="5%">查看</th>
		<th width="5%">使用</th>
		<th width="5%">损耗</th>
		<th width="5%">销毁</th>
	</tr>

	<logic:present name="ITEMS01011VO" property="stockList">
		<logic:iterate id="bean" name="ITEMS01011VO" property="stockList" indexId="index">
			<tr>
				<td>${bean.seqcode}</td>
				<td>${bean.itemsname}</td>
				<td>${bean.typecode}</td>
				<td>
				<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />
				</td>
				<td>
				<ig:cseOrgValue orgsyscoding="${bean.stockorg}"/>
				</td>
				<td>${bean.stocknum}</td>
				<td>
					<a href="ITEMS0113_Disp.do?stockid=${bean.stockid}">
						<img src="images/look.gif" width="16" height="16" border="0" alt="查看详细信息" />
					</a> 
				</td>
                <td>
					<logic:equal value="0" name="bean" property="stocknum">
						&nbsp;
					</logic:equal>
					<logic:notEqual value="0" name="bean" property="stocknum">          	
						<a href="ITEMS0116_Disp.do?seqcode=${bean.seqcode}&category=${bean.category}&outtype=3">
							<img src="images/adjust.gif"  width="16" height="16" border="0" alt="使用" />
						</a>
					</logic:notEqual>
            	</td>
            	<td>
            		<logic:equal value="0" name="bean" property="stocknum">
						&nbsp;
					</logic:equal> 
					<logic:notEqual value="0" name="bean" property="stocknum">    
						<a href="ITEMS0116_Disp.do?seqcode=${bean.seqcode}&category=${bean.category}&outtype=4">
							<img src="images/adjust.gif"  width="16" height="16" border="0" alt="损耗" />
						</a>
					</logic:notEqual>
            	</td>
            	<td>
            		<logic:equal value="0" name="bean" property="stocknum">
						&nbsp;
					</logic:equal> 
					<logic:notEqual value="0" name="bean" property="stocknum">    
						<a href="ITEMS0116_Disp.do?seqcode=${bean.seqcode}&category=${bean.category}&outtype=5">
							<img src="images/adjust.gif"  width="16" height="16" border="0" alt="销毁" />
						</a>
					</logic:notEqual>
            	</td>
			</tr>
		</logic:iterate>
	</logic:present>

</table>
</div>
<div id="operate">
	<div class="operate_btn">
		<jsp:include page="/include/paging.jsp" />
	</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html:html>
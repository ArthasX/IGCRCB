<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="ITEMS0109" toScope="request" />
<bean:define id="title" value="入库调整查询页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="search">
<html:form action="/ITEMS0109">
<div class="img"></div>
<div class="conditions">
<div><span>物品种类：</span><html:select property="category" errorStyleClass="inputError imeActive">
<html:options collection="itemsCodesList" property="value" labelProperty="label" />
</html:select>&nbsp;&nbsp;
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
		<th width="15%">所属机构</th>
		<th width="15%">物品种类</th>
		<th width="10%">库存数量</th>
		<th width="5%">修改</th>
		<th width="10%">调整</th>
	</tr>
	
	
	<logic:present name="ITEMS01011VO" property="stockList">
		<logic:iterate id="bean" name="ITEMS01011VO" property="stockList" indexId="index">
			<tr>
				<td>${bean.seqcode}</td>
				<td>${bean.itemsname}</td>
				<td>${bean.typecode}</td>
				<td><ig:cseOrgValue orgsyscoding="${bean.stockorg}"/></td>
				<td>
				<ig:cseCodeValue codeIndex="1" codeValue="${bean.category}" />
				</td>
				<td>${bean.stocknum}</td>
				<td>
					<a href="ITEMS0110_Disp.do?seqcode=${bean.seqcode}&category=${bean.category}">
						<img src="images/edit.gif" width="16" height="16" border="0" alt="修改" />
					</a> 
				</td>
                <td>
					<a href="ITEMS0111_Disp.do?seqcode=${bean.seqcode}&category=${bean.category}">
						<img src="images/adjust.gif"  width="16" height="16" border="0" alt="调整" />
					</a>
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
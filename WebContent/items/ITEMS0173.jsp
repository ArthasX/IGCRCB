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
<bean:define id="id" value="ITEMS0173" toScope="request" />
<bean:define id="title" value="耗材接收情况画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
<!--
	

//-->
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/ITEMS0173">
	<div id="results_list">
	<ig:message />
		<table class="table_style">
			<tr>
				<th width="5%">
					序号
				</th>
				<logic:equal name="ITEMS0144Form" property="flag" value="1">
				<th width="20%">待接收机构</th>
				</logic:equal>
				
				<th width="15%">物品种类</th>
				<th width="10%">物品编号</th>
				<th width="20%">物品名称</th>
				<th width="15%">物品型号</th>
				<th width="10%">出库数量</th>
				
			</tr>
			<logic:present name="ITEMS01081VO" property="outStockList">
				<logic:iterate id="bean" name="ITEMS01081VO"
					property="outStockList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						<td>
							<div class="nowrapDiv">
							${PagingDTO.viewStartCount+index}
							</div>
						</td>
						<logic:equal name="ITEMS0144Form" property="flag" value="1">
						<td>
							<ig:cseOrgValue orgsyscoding="${bean.reqorg}"/>	
						</td>
						</logic:equal>
						
						
						<td>
							<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />
						</td>
						
						<td>${bean.seqcode}</td>
						
						<td>${bean.itemsname}</td>
						
						<td>${bean.typecode}</td>

						<td>${bean.outnum}</td>

					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<div class="operate_btn">
	<!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
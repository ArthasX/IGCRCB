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
<bean:define id="id" value="ITEMS0166" toScope="request" />
<bean:define id="title" value="配送清单明细画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
<!--
	
	function operation(name){
		if(name=="excel"){
			document.forms[0].action=getAppRootUrl() + "/ITEMS0166_Excel.do";
			document.forms[0].submit();

		}
	   
	}

	
//-->
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/ITEMS0166">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 明细</p>
<div class="back">
		<a href="ITEMS0165_BACK.do" target="_self">返回</a>
</div>
</div>

	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="15%">机构名称</th>
				<th width="10%">包裹号</th>
				<th width="12%">配送时间</th>
				<th width="15%">物品编号</th>
				<th width="15%">物品名称</th>
				<th width="15%">物品型号</th>
				<th width="10%">物品种类</th>
				<th width="8%">出库数量</th>
			</tr>
			<logic:present name="ITEMS01081VO" property="outStocktbList">
				<logic:iterate id="bean" name="ITEMS01081VO" property="outStocktbList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						<td>
							<ig:cseOrgValue orgsyscoding="${bean.reqorg}"/>
						</td>
						
						<td>
							${bean.packno}
						</td>
	
						<td>${bean.outtime}</td>
						
						<td>${bean.seqcode}</td>
						
						<td>${bean.itemsname}</td>
						
						<td>${bean.typecode}</td>
						
						<td>
							<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />
						</td>
						
						<td>${bean.outnum}</td>
						
						
					</tr>
				</logic:iterate>
			</logic:present>
			<html:hidden name="ITEMS0148Form" property="outtime_f"/>
			<html:hidden name="ITEMS0148Form" property="outtime_t"/>
	</table>
	</div>
	<div id="operate">
	<div class="operate_btn">
	<logic:present name="ITEMS01081VO" property="outStocktbList">
		<span> 
		<html:button property="btn_add" value="导出"
			styleClass="button" onclick="operation('excel')" />
		
		</span>
	</logic:present> <!-- paging --> <jsp:include page="/include/paging.jsp" /></div>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
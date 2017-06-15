<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils"%>
<html:html>
<bean:define id="id" value="ITEMS0107" toScope="request" />
<bean:define id="title" value="类别选择页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var gid='ITEMS0107';
function setParentValue(seqcode, typecode, type){
    if(!window.opener.closed){
        window.opener.setParamItems0106(seqcode, typecode, type);
    }
    window.close();
}
</script>
<style>
html{
	overflow-x:auto;
	overflow-y:auto;
}
body{
	overflow-x:hidden;
	overflow-y:hidden;
}
</style>
<body>
<div id="maincontent">
<div id="container">
<!--content  右侧内容-->
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="results_list">
<table class="table_style">
	<tr>
		<th width="10%">物品编号</th>
		<th width="25%">物品名称</th>
		<th width="15%">物品型号</th>
		<th width="15%">物品种类</th>
		<th width="25%">说明</th>
		<th width="10%">状态</th>
	</tr>
	
	<logic:present name="ITEMS01011VO" property="itemsCategoryList">
		<logic:iterate id="bean" name="ITEMS01011VO" property="itemsCategoryList" indexId="index">
			<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');"
				 onclick="setParentValue('${bean.seqcode}','${bean.typecode}','${bean.type}');">
				<td>${bean.seqcode}</td>
				<td>${bean.typecode}</td>
				<td>${bean.type}</td>
				<td>
					<ig:cseCodeValue codeIndex="<%=DefineUtils.ITEMSCODES_STOCK_CATEGORY%>" codeValue="${bean.category}" />
				</td>
				<td>${bean.desc}</td>
				<td>
					<logic:equal name="bean" property="status" value="1">
						使用
					</logic:equal>
					<logic:equal name="bean" property="status" value="0">
						停用
					</logic:equal>
				</td>
			</tr>
		</logic:iterate>
	</logic:present>

</table>
</div>
</div>
</div>
</body>
</html:html>
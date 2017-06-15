<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0281" toScope="request" />
<bean:define id="title" value="类别选择页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var gid='IGLOM0281';
function setParentValue(giodcode, giodname,gcategory){
    if(!window.opener.closed){
        window.opener.setParamLom0203(giodcode, giodname,gcategory);
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
<p class="fonts1">后勤管理&gt;&gt; 物品管理 &gt;&gt; 物品入库 &gt;&gt; 类别选择</p>
</div>
<div id="results_list">
<table class="table_style">
	<tr>
		<th width="20%">物品编号</th>
		<th width="20%">物品名称</th>
		<th width="20%">物品种类</th>
		<th width="20%">预警提示数量</th>
		<th width="20%">物品内部转移定价(%)</th>
	</tr>
	
	<logic:present name="IGLOM02021VO" property="goodsList">
		<logic:iterate id="bean" name="IGLOM02021VO" property="goodsList" indexId="index">
			<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');"
				 onclick="setParentValue('${bean.gcode}','${bean.gname}','${bean.gcategory}');">
				<td>${bean.gcode}</td>
				<td>${bean.gname}</td>
				<td>
					<ig:projectTypeValue ptype="${bean.gcategory}" />
				</td>
				<td>${bean.gwarningnum}</td>
				<td>
					${bean.gprice}
				</td>
			</tr>
		</logic:iterate>
	</logic:present>

</table>
</div>
<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
</div>
</div>
</body>
</html:html>
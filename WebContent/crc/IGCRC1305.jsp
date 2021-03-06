<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCRC1305" toScope="request" />
<bean:define id="title" value="部门提交统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<script type="text/javascript">


function modify(type){
	window.showModalDialog("IGCRC1304_DISP.do?type=" + type,
            null,"dialogWidth:1000px;dialogHeight:650px;status:no;help:no;resizable:no");
}

function setOrg(url){
	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");

	if("_resetall"==temp){
		document.forms[0].department.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		if(null!=temp.split("|")[1] && temp.split("|")[1].split("-").length>1){
			document.forms[0].department.value = temp.split("|")[1].split("-")[1];
		}else{
			document.forms[0].department.value = temp.split("|")[1];
		}
	}		

}
function onSearch(){
	form.action = "IGCRC1304.do";
	form.submit();
}
function onExcel(){
	form.action = "IGCRC1306.do";
	form.submit();
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGCRC1304" styleId="form" onsubmit="">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>统计条件</strong></span>
	</div>

	<div style="margin-top:4px;">
		<span>&nbsp;&nbsp;提交部门：</span>
		<html:text property="department" readonly="true"></html:text>
		<img src="images/tree.gif" style="cursor: hand;" alt="选择上级机构" width="16" height="16" border="0" onclick="setOrg('IGCRC1308_ROLETREE.do');"/>&nbsp;&nbsp; 
<%-- 		<html:submit property="btn_search" styleClass="button" value="查询" /> --%>
		<input type="button" value="查询" class="button" onclick="onSearch()">
		<input type="button" value="导出" class="button" onclick="onExcel()">
	</div>
	<div style="margin-top:8px;"></div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="33%">文档名称</th>
			<th width="33%">下载数量</th>
			<th>借阅次数</th>
       	</tr>
		<logic:present name="IGCRC1304VO" property="igcrc1304VWList">
			<logic:iterate id="bean" name="IGCRC1304VO"
				property="listVM" indexId="index">
				<tr class="alarmcolor_level">
					<td  width="33%" style="text-align:center;">${bean.einame}</td> 
					<td  width="33%" style="text-align:center;">${bean.dowSum}</td>
					<td  width="34%" style="text-align:center;"><a style='cursor:hand' onclick="modify('<bean:write name="bean" property="eiid" />');">${bean.readSum}</a></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
		<jsp:include page="/include/paging.jsp" />
	</div>
	</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>
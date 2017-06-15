<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.deliverik.framework.workflow.WorkFlowConstDefine"%>
<%@page import="java.util.List"%>
<html xmlns:v="urn:schemas-microsoft-com:vml">
<bean:define id="id" value="IGPRR0401" toScope="request" />
<bean:define id="title" value="流程体系" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<link rel="stylesheet" href="<html:rewrite forward='pdimgstyle.css'/>" type="text/css">
<script src="<html:rewrite forward='context.js'/>"  ></script>
<script src="<html:rewrite forward='webflow.js'/>" charset="gb2312"></script>
<script src="<html:rewrite forward='function.js'/>"></script>
<script src="<html:rewrite forward='shiftlang.js'/>" ></script>
<script src="<html:rewrite forward='movestep.js'/>"></script>
<style type="text/css">
#box{
	border:#e1e1e1 1px solid;
	height:560px;
}
#left{
	float:left;
	width:160px;
	background:#e1e1e1;
	height:100%;
}
#right{
	float:left;
	width:840px;
	height:100%;
}
.leftmenu{
	cursor: hand;
	height:30px;
	text-align:center;
	line-height:30px;
	background-image:url(images/servicecatalog/listbg.gif);
	border:#e1e1e1 1px solid;
}
.leftmenu_hover{
	background-image:none;
	background-color:#fff;
	border-right:none;
	cursor: hand;
	heidth:30px;
	text-align:center;
	line-height:30px;
	border-top:#e1e1e1 1px solid;
	border-bottom:#e1e1e1 1px solid;
	border-right:none;
	border-left:#0000ff 5px solid;
}
.leftmenu_title{
	height:30px;
	text-align:center;
	line-height:29px;
	background-image:url(images/servicecatalog/siderbartil.gif);
	border:#e1e1e1 1px solid;
}
.processescontent{
	background-image:url(images/servicecatalog/listtilbg.gif);
	width:105px;
	height:17px;
	line-height:17px;
	padding-left:20px;
	margin-left:30px;
	color:#004688;
}
.processescontent_a{
	width:105px;
	height:17px;
	line-height:17px;
	padding-left:20px;
	margin-left:30px;
	color:#004688;
}
.content_td{
	width:168px;
	padding-top:10px;
	valign:top;
}
.processescontent_li{
	list-style-image:url(images/servicecatalog/li_bg.gif);
	margin-bottom:5px;
}
</style>
<script type="text/javascript">
var current = "";
var item = new Array();
<logic:present name="IGPRR04011VO" property="serviceCatalogFirstClassify">
<logic:iterate id="classify" name="IGPRR04011VO" property="serviceCatalogFirstClassify">
item[item.length] = "${classify.syscoding}";
</logic:iterate>
</logic:present>
function classifyover(obj,syscoding){
	for(var i=0;i<item.length;i++){
		document.getElementById("datacontent_" + item[i]).style.display = "none";
		document.getElementById("menu_" + item[i]).className = "leftmenu";
		
	}
	obj.className = "leftmenu_hover";
	document.getElementById("datacontent_" + syscoding).style.display = "";
}
function initForm(){
	if(current != ""){
		var obj = document.getElementById("menu_" + current);
		classifyover(obj,current);
	}
}
function processChart(pdid){
	window.showModalDialog(getAppRootUrl() + '/IGPRR0111_Disp.do?pdid=' + pdid,null,"dialogWidth:1000px;dialogHeight:600px;status:no;help:no;resizable:yes");
}
</script>
<body onload="initForm();">
<div id="maincontent">
<!--header  头部和 一级菜单--> 
<jsp:include page="/include/header2.jsp" /> 
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form action="/IGPRR0401_Disp" styleId="form" >
<!-- 	<div id="location"> -->
<!-- 	<div class="image"></div> -->
<!-- 	<p class="fonts1">服务目录</p> -->
<!--     </div> -->
<div id="box">
	<div id="left">
		<div class="leftmenu_title">
			<img src="images/servicecatalog/icon01.gif" border="0" align="middle"/>
			&nbsp;&nbsp;
			流程体系
		</div>
		<logic:present name="IGPRR04011VO" property="serviceCatalogFirstClassify">
			<logic:iterate id="classify" name="IGPRR04011VO" property="serviceCatalogFirstClassify" indexId="index">
			<c:if test="${index == 0 }">
				<script type="text/javascript">
					current = "${classify.syscoding }";
				</script>
			</c:if>
			<div id="menu_${classify.syscoding }" class="leftmenu" onmouseover="classifyover(this,'${classify.syscoding }');" >
				<img src="images/servicecatalog/${classify.syscoding }.gif" border="0" align="middle"/>
				&nbsp;&nbsp;
				${classify.cvalue }
			</div>
			</logic:iterate>
		</logic:present>
	</div>
	<div id="right">
	<logic:present name="IGPRR04011VO" property="data">
	<logic:iterate id="map" name="IGPRR04011VO" property="data">
	<bean:define id="rows" name="map" property="value"/>
		<table id="datacontent_${map.key }" style="display:none;">
		<logic:present name="rows">
		<logic:iterate id="row" name="rows">
			<tr>
				<logic:present name="row">
				<logic:iterate id="cell" name="row">
				<td class="content_td" valign="top">
						<logic:equal value="1" name="cell" property="isShowTitle">
						<div class="processescontent">
							${cell.title }
						</div>
						</logic:equal>
						<logic:notEqual value="1" name="cell" property="isShowTitle">
						<div class="processescontent_a"></div>
						</logic:notEqual>
						<logic:present name="cell" property="content">
						<ul>
						<logic:iterate id="pd" name="cell" property="content">
							<li class="processescontent_li">
								<a href="javascript:processChart('${pd.pdid }');">${pd.pdname }</a>
							</li>
						</logic:iterate>
						</ul>
						</logic:present>
				</td>
				</logic:iterate>
				</logic:present>
			</tr>
		</logic:iterate>
		</logic:present>
		</table>
	</logic:iterate>
	</logic:present>
	</div>
</div>
</html:form>
</div>
</div>
</div>
</div>
</body>

</html>
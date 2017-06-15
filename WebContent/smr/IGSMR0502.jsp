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
<bean:define id="id" value="IGSMR0502" toScope="request" />
<bean:define id="title" value="报表信息" toScope="request" />
<jsp:include page="/include/header1.jsp" />

<link rel="stylesheet" href="<html:rewrite forward='pdimgstyle.css'/>" type="text/css">
<script src="<html:rewrite forward='context.js'/>"  ></script>
<script src="<html:rewrite forward='webflow.js'/>" charset="gb2312"></script>
<script src="<html:rewrite forward='function.js'/>"></script>
<script src="<html:rewrite forward='shiftlang.js'/>" ></script>
<script src="<html:rewrite forward='movestep.js'/>"></script>

<STYLE>
v\:* { Behavior: url(#default#VML) }
</STYLE>
<style>
html{
overflow-x:auto;
overflow-y:auto;
}
</style>
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<script type="text/javascript">
var formFileArr = new Array();
var assetFormArr = new Array();
function initAttFormFile(){
	if(formFileArr.length > 0){
		for(var i=0;i<formFileArr.length;i++){
			addSingleFileMuti(formFileArr[i]);
		}
	}
	if(assetFormArr.length > 0){
		for(var k=0;k<assetFormArr.length;k++){
			var params = assetFormArr[k].split("_");
			addSingleEntity(params[0],params[1],params[2],params[3],params[4]);
		}
	}
}
function selectOrgTree(index){
	num = index;
	var temp = window.showModalDialog('IGSYM0101_ROLETREE.do',null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		$("pivarvalue[" + num + "]").value = '';
		$("pivartreename[" + num + "]").value = '';
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		$("pivarvalue[" + num + "]").value = temp.split("|")[0]+"_OrgTree_"+temp.split("|")[1];
		$("pivartreename[" + num + "]").value = temp.split("|")[1];
	}
	num = 0;
}
function copyProcessInfo(prid){
	 if(!window.opener.closed){
		 window.opener.setProcessInfos(prid);
		 window.close();
	 }
}
</script>
<body onload="initAttFormFile();">
<div id="maincontent">
<jsp:include page="/prr/IGPRR0107.jsp"/>	
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form action="/IGPRR0102" styleId="form"
	onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">历史数据查看</p>
    </div>
	<div id="formwrapper"><ig:message />
	<logic:present name="IGPRR01021VO">
	<logic:equal name="IGPRR01021VO" property="hid" value="1">
	<logic:present name="IGPRR01021VO" property="processInfoDefmap">
		<div>
		<table cellspacing="2" class="table_style1">
			<tr style="display:none">
				<th width="15%"></th><td width="35%"></td><th width="15%"></th><td width="35%"><input type="hidden" id="delFileMutiStr" name="delFileMutiStr" value=""/></td>
			</tr>
			<jsp:include page="/smr/IGSMR0403.jsp"></jsp:include>
		</table>
		</div>
	</logic:present>
	</logic:equal>
	</logic:present>
	</div>
	<div class="enter">
		<logic:equal value="Y" name="IGPRR0112Form" property="showCopy">
			<html:button property="btn_copy" styleClass="button" value="复制" onclick="copyProcessInfo(${IGPRR0112Form.prid });"/>
		</logic:equal> 
		<html:button property="btn_close" styleClass="button" value="关闭" onclick="window.close();"/> 
	</div>
</html:form></div>
</div>
</div>
</div>
</body>

</html>
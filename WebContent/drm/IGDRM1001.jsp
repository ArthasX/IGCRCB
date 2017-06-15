<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM1001" toScope="request" />
<bean:define id="title" value="添加人员画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	//按钮操作提示
// 	function deleteRec(obj){
// 		if(checkNum('urids')==0){
// 			alert("请选择添加人！");
// 	        return false;
// 		}
// 	    if(window.confirm("您是否确认保存？")){
// 	        form.action = getAppRootUrl() + "/IGSYM0418_Delete.do?roleid="+$F("roleid");
// 	        return true;
// 	    } else {
// 	        return false;
// 	    }
// 	}

	//添加授权用户按钮操作提示
	function insertRec(){
		openSubWindow('/IGDRM1001_Disp.do?syscoding=' + $F("syscoding"), '_blank', '800', '600');
	}
    function deleteRelation(srid){
    	var alert= '您确认删除该条记录吗？';
    	if(window.confirm(alert)){
    		document.forms[0].action = getAppRootUrl() + "/IGDRM1002_DEL.do?srid=" + srid;
    		document.forms[0].submit();
    	}

    }
    function toback(){
    	document.forms[0].action = getAppRootUrl() + "/IGDRM1001_DISP.do?ccid=${IGDRM1002Form.ccid}&cid=${IGDRM1002Form.cid}&orgFlag=1&clevel=${IGDRM1002Form.clevel}";
		document.forms[0].submit();
    }
</script>
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<script src="<html:rewrite forward='common.js'/>"></script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGDRM1002_Disp"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>
	<input type="hidden" name="flag" value="1">
	
	<div class="role_title">组织架构</div>
	<div id="results_list">

	<table class="table_style6"  align="left" style="width: 80%">
		<logic:present name="IGDRM10021VO" property="codeDetailDef">
			<bean:define id="bean" name="IGDRM10021VO" property="codeDetailDef" />
			<tr>
				<th width="15%">内容</th>
				<td width="20%">${bean.cvalue}</td>
				<th width="15%" >更新时间</th>
				<td width="15%">${bean.updtime}</td>
			</tr>
		</logic:present>	
	</table>
	</div>
	<div class="role_title">已添加角色</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	
	<table class="table_style" align="left">
		<tr>
			<th width="25%">角色名称</th>
			<th width="15%">操作</th>
		</tr>
		<logic:present name="IGDRM10021VO" property="relationlist">
			<logic:iterate id="bean1" name="IGDRM10021VO" property="relationlist" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td>${bean1.rolename}</td>
					<td>
						<html:link href="javascript:deleteRelation('${bean1.srid}');"><img src="images/delete.gif" alt='删除'  width="16" height="16"  border="0"/></html:link>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate" align="center">
	<span> <html:button property="btn_insert" value="添加角色" styleClass="button" onclick="insertRec();" /></span>
	<span> <html:button property="btn_insert" value="返回" styleClass="button" onclick="toback()" /></span>
	</div>
	<html:hidden property="syscoding" name="IGDRM1002Form" styleId="syscoding"/>
	<html:hidden property="ccid" styleId="ccid"/>
	<html:hidden property="cid" styleId="cid"/>
	<html:hidden property="clevel" styleId="clevel"/>
</html:form>
 
</div>
</div>
 
</div>
</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGPRD0173" toScope="request"/>
<bean:define id="title" value="表格类表单预览" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript" src="js/tableform.js"></script>
<script type="text/javascript">
function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory,eiversion, pidid) {
	var showvalue = null;
	var showvalues = setEntityObj.parentElement.childNodes;
	if(showvalues != null){
		for(var i=0;i<showvalues.length;i++){
			if(showvalues[i].name == "show_value"){
				showvalue = showvalues[i];
			}
		}
	}
	var columnvalue = null;
	var columnvalues = setEntityObj.parentElement.parentElement.parentElement.parentElement.parentElement.childNodes;
	if(columnvalues != null){
		for(var k=0;k<columnvalues.length;k++){
			if(columnvalues[k].name == "column_value"){
				columnvalue = columnvalues[k];
			}
		}
	}
	if("" == eiid){
		showvalue.value = "";
	}else{
		showvalue.value = ename + "(" + eiversion + ")";
	}
}
</script>
<body>
<div id="maincontent">
<!-- <div id="container"> -->
<div id="location">
	<div class="image"></div>
	<p class="fonts1">预览</p>
</div>
<div style="margin-left:15px;margin-top:10px;">
<input type="hidden" id="addTableColumnFileStr" name="addTableColumnFileStr" value=""/>
<logic:present name="IGPRD01731VO" property="pidInfo">
	<bean:define id="bean" name="IGPRD01731VO" property="pidInfo"/>
	<ig:formToTag 
		property="pid" 
		pidaccess="3" 
		pidid="${bean.pidid }" 
		pidmode="1" 
		formType="${bean.pidtype }" 
		piduse="${bean.piduse }"
		pidrows="${bean.pidrows }"
		piddisplay="${bean.piddisplay }"
		showrownum="${bean.showrownum }"
		showline="${bean.showline }"
		titledisplay="${bean.titledisplay }"
		pidhide="${bean.pidhide }"
		pidlabel="${bean.pidlabel }"
		name="IGPRD0173Form"/>
</logic:present>
</div>
<div style="margin-left:300px;">
	<html:button property="btn_close" value="关闭" styleClass="button" onclick="window.close();"/>
</div>
</div>
<!-- </div> -->
</body>
</html:html>
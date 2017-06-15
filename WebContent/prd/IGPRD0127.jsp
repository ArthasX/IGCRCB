<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRD0127" toScope="request" />
<bean:define id="title" value="主动表单选择画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
function setParentValue(pidid,pidname){
	var   sc="setPid(\""+pidid+"\",\""+pidname+"\")";   
	window.dialogArguments.execScript(sc,"javascript");  
	window.parent.close();
}

function clearParentValue(){
	var   sc="setPid(\"\",\"\")";   
	window.dialogArguments.execScript(sc,"javascript");  
	window.parent.close();
}
function setOrg(url){
	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].orgidstr.value = "";
		document.forms[0].orgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].orgidstr.value = temp.split("|")[0];
		document.forms[0].orgname.value = temp.split("|")[1];
	}		

}
//-->
</script>
<style>
html{
overflow:auto;
}
body{

overflow-y:auto;
}
</style>
<body>

<html:form>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				
				<th width="50%">表单名称</th>
				<th width="50%">表单说明</th>
				
			</tr>
			<logic:present name="IGPRD01101VO" property="processInfoDefList">
				<logic:iterate id="bean" name="IGPRD01101VO"
					property="processInfoDefList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'<ig:rowcss index="${index}"/>');" onclick="javaScript:setParentValue('${bean.pidid}','${bean.pidname}');">
						
						<td>${bean.pidname}</td>
						<td>${bean.pidlabel}</td>
						
						
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div class="enter">
                	
                    <input type="button" name="btn_close" value="关闭" onclick="window.close()" class="button">
    </div>
</html:form>

</body>
</html:html>
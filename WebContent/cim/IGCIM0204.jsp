<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0204" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0204" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//按钮操作提示
	function deleteRec(obj,flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var arg0= '<bean:message bundle="asmResources" key="message.IGCIM0204.001"/>';
        var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="'+arg0+'" />';
        var mode="0";
		if(flag=="1"){
			//message = '请选择添加导入实体。';
		    message ='<bean:message  bundle="asmResources" key="message.IGCIM0204.002"/>';
			//confirmMsg = '请确认是否要进行角色添加处理?';
			confirmMsg = '<bean:message  bundle="asmResources" key="message.IGCIM0204.003"/>';
			mode="1";
		}
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
        if(window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGCIM0204.do?mode="+mode;
            return true;
        } else {
            return false;
        }
	}
function toback(){
	form.action = getAppRootUrl() + "/IGCIM0203_back.do";
	form.submit();
}
//-->
</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
		<ig:navigation extname1="${urlable}"/> &gt;&gt; Domain范围
		</p>
	<div class="back"><a href="javascript:toback();" target="_self"><bean:message
		bundle="asmResources" key="label.IGCIM0204.back" /></a></div>
	</div>

	<html:form styleId="form" action="/IGCIM0204" onsubmit="return checkSubmit(this);">
	<div class="role_title"><bean:message bundle="asmResources"
		key="title.IGCIM0204.ownimport" /></div>
	<div id="results_list">
	<!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style4" align="left" style="width: 100%">
		<tr>
			<th width="10%"><input type="checkbox"
				name="checkbox" id="checkbox"
				onclick="selectAll('checkbox','owneiddids')" /></th>
			<th width="22%"><bean:message bundle="asmResources"
				key="label.IGCIM0204.impeiname" /></th>
			<th width="22%"><bean:message bundle="asmResources"
				key="label.IGCIM0204.impversion" /></th>
			<th width="22%"><bean:message bundle="asmResources"
				key="label.IGCIM0204.impfilename" /></th>
			<th width="22%"><bean:message bundle="asmResources"
				key="label.IGCIM0204.impcreatetime" /></th>
		</tr>

		<logic:present name="IGCIM02041VO" property="ownImportVersion">
			<logic:iterate id="bean" name="IGCIM02041VO"
				property="ownImportVersion" indexId="index"
				type="com.deliverik.framework.soc.asset.model.SOC0120Info">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><label><html:checkbox property="owneiddids"
						value="${bean.impversion};${bean.impeiname}" /> </label></td>
					<td><logic:empty name="bean" property="impeiname">&nbsp;</logic:empty>${bean.impeiname}
					</td>
					<td><logic:empty name="bean" property="impversion">&nbsp;</logic:empty>${bean.impversion}
					</td>
					<td><logic:empty name="bean" property="impfilename">&nbsp;</logic:empty>${bean.impfilename}
					</td>
					<td><logic:empty name="bean" property="impcreatetime">&nbsp;</logic:empty>${bean.impcreatetime}
					</td>
				</tr>
			</logic:iterate>
		</logic:present>

	</table>
	</div>
	<div id="operate"><logic:present name="IGCIM02041VO"
		property="ownImportVersion">
		<span> <html:submit property="btn_delete" styleClass="button"
			onclick="return deleteRec('owneiddids','0');">
			<bean:message bundle="asmResources" key="button.IGCIM0204.delete" />
		</html:submit></span>
	</logic:present></div>
	
	
	<div class="role_title"><bean:message bundle="asmResources"
		key="title.IGCIM0204.otherimport"/></div>
			<div id="results_list">
			<table class="table_style4" align="left" style="width: 100%">
				<tr>
					<th width="10%">
					<input type="checkbox" name="checkbox_other" id="checkbox_other"
						onclick="selectAll('checkbox_other','eiddids')" /></th>
					<th width="22%"><bean:message bundle="asmResources"
						key="label.IGCIM0204.impeiname" /></th>
					<th width="22%"><bean:message bundle="asmResources"
						key="label.IGCIM0204.impversion" /></th>
					<th width="22%"><bean:message bundle="asmResources"
						key="label.IGCIM0204.impfilename" /></th>
					<th width="22%"><bean:message bundle="asmResources"
						key="label.IGCIM0204.impcreatetime" /></th>
				</tr>
				<logic:present name="IGCIM02041VO" property="otherImportVersion">
				<logic:iterate id="bean" name="IGCIM02041VO" indexId="index" property="otherImportVersion"
					type="com.deliverik.framework.soc.asset.model.SOC0120Info">
					<tr class="<ig:rowcss index="${index}"/>">
						<td><label> <html:checkbox property="eiddids"
							value="${bean.impversion};${bean.impeiname}" /> </label></td>
						<td><logic:empty name="bean" property="impeiname">&nbsp;</logic:empty>${bean.impeiname}
						</td>
						<td><logic:empty name="bean" property="impversion">&nbsp;</logic:empty>${bean.impversion}
						</td>
						<td><logic:empty name="bean" property="impfilename">&nbsp;</logic:empty>${bean.impfilename}
						</td>
						<td><logic:empty name="bean" property="impcreatetime">&nbsp;</logic:empty>${bean.impcreatetime}
						</td>
					</tr>
				</logic:iterate>
				</logic:present>
			</table>
			</div>
		<div id="operate"><logic:present name="IGCIM02041VO" property="otherImportVersion">
		<span> <html:submit property="btn_delete" styleClass="button"
			onclick="return deleteRec('eiddids','1');">
			<bean:message bundle="asmResources" key="label.IGCIM0204.addselect"/>
		</html:submit></span>
	</logic:present></div>
	<html:hidden property="eiddid" />
	<html:hidden property="eiddversion" />
</html:form>
<div class="Placeholder"></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM1109" toScope="request" />
<bean:define id="title" value="流程优先级配置画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGSYM1109">
	<div id="location">
		<div class="image"></div>
		<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	</div>

	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="20%" rowspan="${IGSYM11011VO.primpactSize-1}">影响程度</th>
			<th width="80%" colspan="${IGSYM11011VO.prurgencySize} }">紧急程度</th>
		</tr>
		<tr>
			<logic:iterate id="prurgencyBean" name="IGSYM11011VO" property="prurgencyList" indexId="index">
				<th width="10%"><bean:write name="prurgencyBean" property="cvalue" /></th>
			</logic:iterate>

		</tr>
		
		<logic:iterate id="primpactBean" name="IGSYM11011VO" property="primpactList" indexId="primpactIndex">
			<tr>
					<td><bean:write name="primpactBean" property="cvalue" /></td>
 					<logic:iterate id="formv" name="IGSYM1109Form" property="pvalues[${primpactIndex}]" indexId="prurgencyIndex">
						<td width="10%">
							<html:select property="pvalues[${primpactIndex}][${prurgencyIndex}]" styleId="prPriorityValue" 
								errorStyleClass="inputError imeActive" style="width:50px" value="${formv}" >
								<ig:optionsCollection ccid="PROCESS_PRIORITY_I" isMakeBlankRow="false" isCodeLabel="true" />
						    </html:select>
						</td>
					</logic:iterate>
			</tr>
		</logic:iterate>
	</table>
	</div>


	<div align="center">
	<span>
		<html:submit property="btn_save" value="保存" styleClass="button"/>
		<html:reset property="btn_save" value="重置" styleClass="button"/>
	</span>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
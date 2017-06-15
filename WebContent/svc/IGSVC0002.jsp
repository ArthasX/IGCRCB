<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGSVC0002" toScope="request" />
<bean:define id="title" value="问题查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var gid='IGSVC0002';
function setParentValue(prcorid,prcortype,prcortitle){
    if(!window.opener.closed){
        //window.opener.setParamIGFIN0202();
        window.opener.document.getElementById("prcorid").value = prcorid;
        window.opener.document.getElementById("prcortype").value = prcortype;
        window.opener.document.getElementById("prcortitle").value = prcortitle;
    }
    window.close();
}
function clearParentValue(){
    if(!window.opener.closed){
        //window.opener.setParamIGFIN0202();
        window.opener.document.getElementById("prcorid").value = "";
        window.opener.document.getElementById("prcortype").value = "";
        window.opener.document.getElementById("prcortitle").value = "";
    }
    window.close();
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container">
<html:form action="/IGSVC0100" styleId="form" onsubmit="return checkSubmit(this);">
    <div id="location" style="margin-top:10px">
        <div class="image"></div>
            <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
    </div>
    <div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>编号：</span><span><html:text property="prserialnum" errorStyleClass="inputError imeActive" size="12" /></span>
		<span>&nbsp;&nbsp;名称：</span><span><html:text property="prtitle" /></span>
		<span>&nbsp;&nbsp;发起者：</span><span><html:text property="prusername" /></span>
		<span>&nbsp;&nbsp;状态：</span><span><html:select property="prstatus">
		<ig:optionsCollection ccid="P"
		 isMakeBlankRow="true"
			isCodeLabel="true" />
	</html:select></span></div>
	<div>
	<span>时间：从</span><span><html:text property="propentime" styleId="propentime"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))"
		border="0" style="cursor: hand" /></span>
		<span>&nbsp;&nbsp;到</span><span><html:text property="prclosetime" styleId="prclosetime"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))"
		border="0" style="cursor: hand" /></span>
		<span>&nbsp;&nbsp;紧急程度：</span><span><html:select property="prurgency">
	<ig:optionsCollection ccid="PURGENCY_GRADE_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	</html:select></span>
	 <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:submit
		styleClass="button" value="查询" /></span></div>
	</div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="3%"></th>
			<th width="8%">编号</th>
			<th width="30%">名称</th>
			<th width="9%">类型</th>
			<th width="8%">发起者</th>
			<th width="9%">发起时间</th>
			<th width="9%">发生时间</th>
			<th width="9%">关闭时间</th>
			<th width="8%">状态</th>
			<th width="7%">影响程度</th>
		</tr>
		<logic:present name="IGSVC01001VO" property="processRecordList">
			<logic:iterate id="bean" name="IGSVC01001VO" property="processRecordList"
				indexId="index">
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="setParentValue('${bean.prid}','${bean.prtype}','${bean.prtitle}');">
					<td>
					<c:if test="${bean.prurgency != null and bean.prurgency > ' '}">
						 <img
							src="images/<bean:write name="bean" property="prurgency" />.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE"
							cid="${bean.prurgency}" />"
							border="0" />
					</c:if>
					</td>
					<td><bean:write name="bean" property="prserialnum" /></td>
					<td>
					<bean:write name="bean" property="prtitle" /></td>
					<td><bean:write name="bean" property="prpdname" /></td>
					<td><bean:write name="bean" property="prusername" /></td>
					<td><bean:write name="bean" property="propentime" /></td>
					<td><bean:write name="bean" property="prplantime" /></td>
					<td><bean:write name="bean" property="prclosetime" /></td>
					<td>
                         <logic:equal value="PD" name="bean" property="prtype">
							<ig:processDefineTypeValue prid="${bean.prid}"/>
							<logic:equal value="C" property="prsubstatus" name="bean">(中止)</logic:equal>
						</logic:equal>
						<logic:notEqual value="PD" name="bean" property="prtype">
						    <logic:notEqual value="" property="prsubstatus" name="bean">
								<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />(<ig:codeValue ccid="${bean.prtype}SUB" cid="${bean.prsubstatus}"/>)
							</logic:notEqual>
							<logic:equal value="" property="prsubstatus" name="bean">
								<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
							</logic:equal>
						</logic:notEqual>
					</td>
					<td><ig:codeValue ccid="IMPACT_GRADE_CODE"
						cid="${bean.primpact}" /></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
		
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	
	<div align="center">
	<input type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
	<html:hidden property="prtype"/>
	</html:form>
</div>
</div>
</body>
</html:html>

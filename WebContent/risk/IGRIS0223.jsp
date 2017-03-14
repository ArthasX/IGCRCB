<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGRIS0223" toScope="request" />
<bean:define id="title" value="执行风险检查选择画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
function setParentValue(rcid, rcname,rcclass,rcrid){
    if(!window.opener.closed){
    	window.opener.setRiskCheck(rcid,rcname,rcclass,rcrid);
    	window.close();
	}
}
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>查询条件</strong></span>
	</div>
	<div style="margin-top: 7px;">
	<html:form action="/IGRIS0202_sell" enctype="multipart/form-data">
	<div>
	<span class="subscribe">检查项类型：</span>
	<html:select property="rcclass" styleId="rcclass" style="width:102px;">
		<ig:optionsCollection ccid="RISKCHECK_CLASS_CODE" isMakeBlankRow="true" isCodeLabel="true" />
	</html:select> 
	<span class="subscribe" >计划检查时间：</span>
	<html:text  property="rcrplandate_from" styleId="rcrplandate_from"
		errorStyleClass="inputError imeDisabled" size="18" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="showTime(document.forms[0].rcrplandate_from)"
		border="0" style="cursor: hand" />
	--
	<html:text  property="rcrplandate_to" styleId="rcrplandate_to"
		errorStyleClass="inputError imeDisabled" size="18" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="showTime(document.forms[0].rcrplandate_to)"
		border="0" style="cursor: hand" />
	
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	<div style="margin-top:12px;">
	<span class="subscribe" >责任人：</span>
	<html:text  property="rcusername" size="18" errorStyleClass="inputError imeActive" /> 

	</div>
	</html:form> 
	</div>
</div>
</div>
	<div id="results_list">
		<table class="table_style" style="width: 100%;">
		<tr>
			<th width="6%">选择</th>
			<th width="30%">检查项名称</th>
			<th width="15%">计划检查时间</th>
			<th width="15%">计划结束时间</th>
			<th width="12%">责任组</th>
			<th width="12%">责任人</th>
			<th width="10%">结果</th>
		</tr>
			<logic:present name="IGRIS02013VO" property="igris02012voList">
				<logic:iterate id="beanvo" name="IGRIS02013VO" property="igris02012voList" indexId="index">
				<bean:define id="bean1" name="beanvo" property="riskCheckResult" ></bean:define>
				<bean:define id="bean" name="bean1" property="riskCheck" ></bean:define>
					<tr class="<ig:rowcss index="${index}"/>">
						<td>
							<img src="images/select_asset.gif" border="0" alt="选择" onclick="javaScript:setParentValue('${bean.rcid}','${bean.rcname}','${bean.rcclass}','${bean1.rcrid}');" style="cursor:hand"/>
						</td>
						<td>${bean.rcname}</td>
						<td>${bean1.rcrplandate}</td>
					    <td><bean:write name="beanvo" property="endDate" /></td>
						<td>${bean.rcrolename}</td>
						<td>${bean.rcusername}</td>
						<td><ig:codeValue ccid="RISKCHECKRESULT_CODE" cid="${bean1.rcrresult}"/>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
</body>
</html:html>
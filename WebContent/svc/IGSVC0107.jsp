<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSVC0107" toScope="request" />
<bean:define id="title" value="工作查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">

function setParentValue(prcorid,prcortype,prcortitle){
       if(!window.opener.closed){
           window.opener.setParams(prcorid, prcortype, prcortitle);
        }
       window.close();
}
function clearParentValue(){
       if(!window.opener.closed){
           window.opener.setParams("", "", "");
        }
       window.close();
}
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container">
<html:form action="/IGSVC0107" styleId="form" onsubmit="return checkSubmit(this);">
    <div id="location" style="margin-top:10px">
        <div class="image"></div>
            <p class="fonts1">工作查询</p>
    </div>
    <div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:20px;"><strong>查询条件</strong></span>
	</div>
	<div>
		<span class="subscribe">编号：</span>
		<html:text property="prserialnum" errorStyleClass="inputError imeActive" size="12" styleId="prserialnum" name="IGSVC0100Form"/>
		<span class="subscribe">名称：</span>
		<html:text property="prtitle" errorStyleClass="inputError imeActive" styleId="prtitle" name="IGSVC0100Form"/>
    	<span class="subscribe">时间：</span>
    	<html:text property="propentime" styleId="propentime" name="IGSVC0100Form" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:116px;"/>
		<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))" border="0" style="cursor: hand" />
		<span>&nbsp;--&nbsp;</span>
		<html:text property="prclosetime" styleId="prclosetime" name="IGSVC0100Form" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:116px;"/>
		<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" />
		<html:hidden name="IGSVC0100Form" property="prpdid"/>
		<html:submit styleClass="button" value="查询" />
	</div>
	<div style="margin-top:12px;">
		<span class="subscribe">发起者：</span>
		<html:text property="prusername" styleId="prusername" name="IGSVC0100Form"/>
	</div>
	<div style="margin-top:8px;"></div>
	</div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="5%">选择</th>
			<th width="8%">编号</th>
			<th width="25%">名称</th>
			<th width="10%">类型</th>
			<th width="7%">发起者</th>
			<th width="10%">发起时间</th>
			<th width="10%">关闭时间</th>
			<th width="10%">状态</th>
			<!--<th width="7%">影响程度</th>  -->
			<th width="7%">查看</th>
		</tr>
		<logic:present name="IGSVC01061VO" property="processRecordList">
			<logic:iterate id="bean" name="IGSVC01061VO" property="processRecordList"
				indexId="index" type="com.deliverik.framework.workflow.prr.model.IG500Info">
				<tr>
					<td>
						<img src="images/select_asset.gif" border="0" alt="选择" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,''); " onclick="setParentValue('${bean.prid}','${bean.prtype}','${bean.prtitle}')"/>
					</td>
					<td><bean:write name="bean" property="prserialnum" /></td>
					<td><bean:write name="bean" property="prtitle" /></td>
					<td><!--<img src="images/svc/<%=bean.getPrtype().substring(0,1)%>.gif" border="0" />--><bean:write name="bean" property="prpdname" /></td>
					<td><bean:write name="bean" property="prusername" /></td>
					<td><bean:write name="bean" property="propentime" /></td>
					<td><bean:write name="bean" property="prclosetime" /></td>
					<td>
					<logic:notEqual value="" property="prsubstatus" name="bean">
					<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />（<ig:codeValue ccid="${bean.prtype}SUB" cid="${bean.prsubstatus}"/>）
					</logic:notEqual>
					<logic:equal value="" property="prsubstatus" name="bean">
						<logic:equal value="WD" name="bean" property="prtype">
						<ig:processDefineTypeValue prid="${bean.prid}"/>
						</logic:equal>
						<logic:notEqual value="WD" name="bean" property="prtype">
						<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
						</logic:notEqual>
					</logic:equal>
					</td>
					<!--
					<td><ig:codeValue ccid="IMPACT_GRADE_CODE"
						cid="${bean.primpact}" /></td>-->
					<td>  
						<img src="images/look.gif" alt="查看详细信息" width="16" height="16" border="0" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,''); " onclick="javascript:openRelatedProcess('${bean.prid}','${bean.prtype}');"/>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	<div class="enter">
	<input type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
	</div>
		
	<html:hidden name="IGSVC0100Form" property="prtype" styleId="prtype"/>
	<html:hidden name="IGSVC0100Form" property="prActive" styleId="prActive"/>
	</html:form>
</div>
</div>
</body>
</html:html>

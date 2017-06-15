<%@page import="com.deliverik.infogovernor.asset.form.IGASM3201Form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.infogovernor.asset.vo.IGASM32011VO"%>

<html:html>
<bean:define id="id" value="IGASM3201T" toScope="request"/>
<bean:define id="title" value="风险事件查询画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	function setParentValue(eiid,einame,eiversion){
		if(!window.opener.closed){
            window.opener.setFxsjValue(eiid,einame,eiversion);
            window.close();
        }
	}
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body>
<div id="maincontent">
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGASM3201_T" styleId="form">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">风险事件查询</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>查询条件</strong></span>
	</div>
	<div style="margin-top:4px;">
		<span class="subscribe">风险事件名称：</span>
		<html:text property="fcname" size="12" />
		<span class="subscribe">风险事件来源：</span>
		<html:select property="fcorigin"  tabindex="2" style="width: 100px;" errorStyleClass="inputError">
			<ig:optionsCollection ccid="RISK_CASE_ORIGIN" isCodeLabel="true"/>
		</html:select>
		<span class="subscribe" style="width:110px">风险事件所属领域：</span>
		<html:select property="fccategory"  tabindex="5" style="width: 100px;" errorStyleClass="inputError">
			<ig:optionsCollection ccid="RISK_CASE_CATEGORY" isCodeLabel="true"/>
		</html:select>
		<span class="subscribe" style="width:80px;">风险点名称：</span>
		<html:text property="fcriskname" readonly="true" tabindex="5" />
		<input width="0px" type="hidden" name="riskid" id="riskid" />
		<html:submit styleClass="button" value="查询" />
		<html:hidden property="selectstatus" name="selectstatus" value="1"/>
	</div>
	<div style="margin-top:12px;">
		<span class="subscribe">风险识别时间：</span>
		<html:text property="riskcatchtime_from" styleId="riskcatchtime_from" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:117px;"/>
		<img src="images/date.gif" align="middle" onclick="calendar($('riskcatchtime_from'))" border="0" style="cursor: hand" />
		<span>&nbsp;--&nbsp;</span>
		<html:text property="riskcatchtime_to" styleId="riskcatchtime_to" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:117px;"/>
		<img src="images/date.gif" align="middle" onclick="calendar($('riskcatchtime_to'))" border="0" style="cursor: hand" />
		<span class="subscribe" style="width:110px">应对策略：</span>
		<html:select property="fcpolicy"  tabindex="12" style="width: 100px;" errorStyleClass="inputError">
			<ig:optionsCollection ccid="RISK_POLICY" isCodeLabel="true"/>
		</html:select>
		<span class="subscribe">评审结果：</span>
		<html:select property="riskreviewresult"  tabindex="12" style="width: 100px;" errorStyleClass="inputError">
			<ig:optionsCollection ccid="RISK_REVIEW_RESULT" isCodeLabel="true"/>
		</html:select>
	</div>

	</div>
	</div>

	<div id="results_list"><ig:message />
	
	<table class="table_style" style="table-layout: fixed;">
		<tr>
			<th width="30%" >
				<a href="IGASM3201.do?orderVal=prserialnum">风险事件名称
				<logic:equal name="IGASM3201Form" property="order" value="prserialnum">
					<logic:equal name="IGASM3201Form" property="sing" value="ASC">
						<img src="images/timeup.gif" border="0">
					</logic:equal>
					<logic:equal name="IGASM3201Form" property="sing" value="DESC">
						<img src="images/timedown.gif" border="0">
					</logic:equal>
				</logic:equal></a>
			</th>
			
			
			<th width="30%">
				<a href="IGASM3201.do?orderVal=prtitle">风险点名称			
					<logic:equal name="IGASM3201Form" property="order" value="prtitle">
						<logic:equal name="IGASM3201Form" property="sing" value="ASC">
							<img src="images/timeup.gif" border="0">
						</logic:equal>
						<logic:equal name="IGASM3201Form" property="sing" value="DESC">
							<img src="images/timedown.gif" border="0">
						</logic:equal>
					</logic:equal>
				</a>
			</th>
			
			<th width="13%"><a href="IGASM3201.do?orderVal=prclosetime">风险识别时间
			<logic:equal name="IGASM3201Form" property="order" value="prclosetime">
				<logic:equal name="IGASM3201Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGASM3201Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a>
			</th>
			<th width="13%"><a href="IGASM3201.do?orderVal=prclosetime">评审结果
			<logic:equal name="IGASM3201Form" property="order" value="prclosetime">
				<logic:equal name="IGASM3201Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGASM3201Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a>
			</th>
			
			<th width="13%"><a href="IGASM3201.do?orderVal=prclosetime">状态
			<logic:equal name="IGASM3201Form" property="order" value="prclosetime">
				<logic:equal name="IGASM3201Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGASM3201Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a>
			</th>
			
		</tr>
	<logic:present name="IGASM32011VO" property="riskcaseVWList">
			<logic:iterate id="bean" name="IGASM32011VO" property="riskcaseVWList"
				indexId="index">
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" onclick="setParentValue('${bean.EIID}','${bean.fcname }','${bean.version }')">
					<td>
						${bean.fcname}
					</td>
					<td>
						${bean.fcriskname}
					</td>
					
					<td>
						${bean.riskcatchtime}
					</td>
					
					<td>
						<ig:codeValue ccid="RISK_REVIEW_RESULT" cid="${bean.riskreviewresult}"/>
					</td>
					<td>
						<ig:codeValue ccid="RISK_STATUS" cid="${bean.EISTATUS}"/>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
		
	</table>
	</div>


	<div id="operate">
		<jsp:include page="/include/paging.jsp" />
		<div class="enter">
	        <input type="button" name="btn_clear" value="清空" onclick="setParentValue('','','')" class="button">
	        <input type="button" name="btn_close" value="关闭" onclick="window.close();" class="button">
        </div>
	</div>
	</html:form>
</div>
</div>
</div>


</div>
</body>
</html:html>

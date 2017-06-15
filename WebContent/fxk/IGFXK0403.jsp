<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.infogovernor.wkm.vo.IGWKM01011VO"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG259Info"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG380Info"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>

<html:html>
<bean:define id="id" value="IGFXK0403" toScope="request" />
<bean:define id="title" value="${IGWKM01011VO.actlabel}查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function changeStatus(value){
	if('C' == value){
		document.getElementById("prActive").value = "";
	}
}
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGWKM0103" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">风险管理&gt;&gt; 风险评估&gt;&gt; 风险评估管理</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	 <div>
	      <span style="font-size:15px;"><strong>查询条件</strong></span>
	    
	</div>
	<div>
		<html:hidden property="prActive" styleId="prActive"/>
		<span class="subscribe" style="margin-top:4px;">标题：</span>
		<html:text property="prtitle"></html:text>
		<span class="subscribe">发起者：</span>
		<html:text property="prusername" styleId="prusername"/>
		<span class="subscribe">时间：</span><html:text property="propentime" styleId="propentime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
		<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))" border="0" style="cursor: hand" />
		<span>--</span><html:text property="prclosetime" styleId="prclosetime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
		<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" />
		<html:submit styleClass="button" value="查询" />
	</div>
	<div style="margin-top:12px;">
	<span class="subscribe">流程状态：</span>
	<html:select property="prstatus" style="width: 100px;" onchange="changeStatus(this.value);">
    	<html:options collection="statusBeanList" property="value" labelProperty="label"/>
    </html:select>
	<logic:present name="AD_ProcessInfoQueryMap" scope="session">
		<logic:iterate id="map" name="AD_ProcessInfoQueryMap" scope="session" indexId="index">
			&nbsp;&nbsp;
			<bean:define id="bean" name="map" property="value"/>
			<ig:processInfoQuery pdid="${bean.pdid }"  pidname="${bean.pidname }" name="IGWKM0101Form" property="varvalues[${index }]" styleClassTagName="subscribe"/>
			<c:if test="${(index+1)%4==0 }">
				<br />
			</c:if>
			
		</logic:iterate> 
	</logic:present>
   </div>
	<html:hidden property="selectstatus" name="selectstatus" value="1"/>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="37%">
				<a href="IGWKM0103.do?orderVal=prtitle">标题		
					<logic:equal name="IGWKM0101Form" property="order" value="prtitle">
						<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
							<img src="images/timeup.gif" border="0">
						</logic:equal>
						<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
							<img src="images/timedown.gif" border="0">
						</logic:equal>
					</logic:equal>
				</a>
			</th>
			
			<th width="8%">
				<a href="IGWKM0103.do?orderVal=prusername">发起者
					<logic:equal name="IGWKM0101Form" property="order" value="prusername">
						<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
							<img src="images/timeup.gif" border="0">
						</logic:equal>
						<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
							<img src="images/timedown.gif" border="0">
						</logic:equal>
					</logic:equal>
				</a>
			</th>
			<th width="11%">
				<a href="IGWKM0103.do?orderVal=propentime">发起时间
					<logic:equal name="IGWKM0101Form" property="order" value="propentime">
						<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
							<img src="images/timeup.gif" border="0">
						</logic:equal>
						<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
							<img src="images/timedown.gif" border="0">
						</logic:equal>
					</logic:equal>
				</a>
			</th>
			
			<th width="11%">
				<a href="javascript:void(0);">评估工作来源</a>
			</th>
			<th width="11%">
				<a href="javascript:void(0);">评估开始时间</a>
			</th>
			<th width="11%">
				<a href="javascript:void(0);">评估结束时间</a>
			</th>
			<th width="11%">
				<a href="IGWKM0103.do?orderVal=prstatus">状态
					<logic:equal name="IGWKM0101Form" property="order" value="prstatus">
						<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
							<img src="images/timeup.gif" border="0">
						</logic:equal>
						<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
							<img src="images/timedown.gif" border="0">
						</logic:equal>
					</logic:equal>
				</a>
			</th>
		</tr>
		<logic:present name="IGWKM01011VO" property="processList">
			<logic:iterate id="bean" name="IGWKM01011VO" property="processList" indexId="index">
					<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
					onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
					<td>
						<bean:write name="bean" property="prtitle" />
					</td>
					<td>
						<bean:write name="bean" property="prusername" />
					</td>
					<td>
						<bean:write name="bean" property="propentime" />
					</td>
					<td>
						<ig:publicProcessInfoValue pidname="评估工作来源" prid="${bean.prid }"/>
					</td>
					<td>
						<ig:publicProcessInfoValue pidname="评估开始时间" prid="${bean.prid }"/>
					</td>
					<td>
						<ig:publicProcessInfoValue pidname="评估结束时间" prid="${bean.prid }"/>
					</td>
					<td>	
						<ig:processDefineTypeValue prid="${bean.prid}"/>
					</td>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
    <html:hidden property="prtype" styleId="prtype"/>
    <html:hidden property="prpdid" styleId="prpdid"/>
    <html:hidden property="actname" styleId="actname"/>
	</html:form>
</div>
</div>
</div>


</div>
</body>
</html:html>

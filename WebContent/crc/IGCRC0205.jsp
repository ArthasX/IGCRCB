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
<bean:define id="id" value="IGCRC0205" toScope="request" />
<bean:define id="title" value="事件查询页面" toScope="request" />
<!-- header1 -->
<script type="text/javascript">

function setParentValue(prcorid,prserialnum,prcortitle){
	if (confirm("确认是否关联 "+prcortitle+"？")) {   
		if(!window.opener.closed){
           window.opener.setParams(prcorid, prserialnum, prcortitle);
        }
       window.close();
	}
}
function clearParentValue(){
       if(!window.opener.closed){
           window.opener.setParams("", "", "");
        }
       window.close();
}
</script>
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGCRC0203_SEARCH" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">事件查询</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
    <div>
	 <span style="font-size:20px;"><strong>查询条件</strong></span>
	</div>
				 
	<div class="conditions">
	<div style="margin-top:4px">
	<span class="subscribe">编号：</span><html:text property="prserialnum" size="12" />
	<span class="subscribe">名称：</span><html:text property="prtitle"/>
	<span class="subscribe">时间：从</span><html:text property="propentime" styleId="propentime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))" border="0" style="cursor: hand" />
	<span>--</span><html:text property="prclosetime" styleId="prclosetime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" />
	<html:submit styleClass="button" value="查询" />
	</div>
	<div style="margin-top:12px">
	<span class="subscribe">发起者：</span><html:text property="prusername"/>
	<span class="subscribe">内容：</span>
	<span><html:text errorStyleClass="inputError imeActive"
		property="prdesc" size="40" /></span>
	<span class="subscribe">流程状态：</span>
	
	
	<html:select property="prstatus" style="width: 100px;">
    	<html:options collection="statusBeanList" property="value" labelProperty="label"/>
    </html:select>
    </div>
    <div  id="closeall" style="display:none">
	<logic:present name="AD_ProcessInfoQueryMap" scope="session">
		<logic:iterate id="map" name="AD_ProcessInfoQueryMap" scope="session" indexId="index">
			<bean:define id="bean" name="map" property="value"/>
			<ig:processInfoQuery pdid="${bean.pdid }" pidname="${bean.pidname }" name="IGWKM0101Form" property="varvalues[${index }]"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<c:if test="${(index+1)%4==0 }">
				<br />
			</c:if>
		</logic:iterate> 
	</logic:present>
	
	
	</div>
	
	<html:hidden property="selectstatus" name="selectstatus" value="1"/>
	</div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="5%">选择</th>
			<th width="1%"></th>
			<th width="1%"></th>
			<th width="7%"><a href="IGWKM0103.do?orderVal=prserialnum">编号
			<logic:equal name="IGWKM0101Form" property="order" value="prserialnum">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="14%"><a href="IGWKM0103.do?orderVal=prtitle">名称			
			<logic:equal name="IGWKM0101Form" property="order" value="prtitle">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			
			<th width="8%"><a href="IGWKM0103.do?orderVal=prusername">发起者
			<logic:equal name="IGWKM0101Form" property="order" value="prusername">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="10%"><a href="IGWKM0103.do?orderVal=propentime">发起时间
			<logic:equal name="IGWKM0101Form" property="order" value="propentime">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="8%"><a href="IGWKM0103.do?orderVal=prclosetime">关闭时间
			<logic:equal name="IGWKM0101Form" property="order" value="prclosetime">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			
			<th width="12%">当前处理人</th>
			<th width="10%"><a href="IGWKM0103.do?orderVal=prstatus">状态
			<logic:equal name="IGWKM0101Form" property="order" value="prstatus">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="4%">查看</th>
		</tr>
		<logic:present name="IGWKM01011VO" property="processList">
			<logic:iterate id="bean" name="IGWKM01011VO" property="processList"
				indexId="index">
				
					<tr>
					<td>
						<img src="images/select_asset.gif" border="0" alt="选择" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,''); " onclick="setParentValue('${bean.prid}','${bean.prserialnum}','${bean.prtitle}')"/>
					</td>
					<td>
					<ig:ProcessInfoValueLevelImgTag pdname="${bean.prpdname}"  prid="${bean.prid}" />
					</td>
					<td>
						<ig:ProcessOverdueLevelImgTag prstatus="${bean.prstatus}" prid="${bean.prid}" />
					</td>
					<td><bean:write name="bean" property="prserialnum" />
					</td>
					<td><bean:write name="bean"
						property="prtitle" />
					</td>
					<td><bean:write name="bean"
						property="prusername" />
					</td>
					<td><bean:write name="bean"
						property="propentime" />
					</td>
					<td><bean:write name="bean"
						property="prclosetime" />
					</td>
					
					<td title="<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />">
						<ig:SubstringShowEllipsisWriteTag len="8" showEllipsis="true">
							<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />
						</ig:SubstringShowEllipsisWriteTag>
						
					</td>
					<td>	
						<ig:processDefineTypeValue prid="${bean.prid}"/>
					</td>
					<td>
						<img src="images/look.gif" alt="查看详细信息" width="16" height="16" border="0" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,''); " onclick="javascript:openRelatedProcess('${bean.prid}','${bean.prtype}');"/>
					</td>
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

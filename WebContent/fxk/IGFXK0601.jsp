<%@page import="com.deliverik.infogovernor.wkm.form.IGWKM0101Form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%@ page import="com.deliverik.infogovernor.wkm.vo.IGWKM01011VO"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG259Info"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG380Info"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>
<%
IGWKM01011VO vo = (IGWKM01011VO) request.getAttribute("vo");
Map<String,String> nameURLMap = null;
List<IG259Info> processTemplateList = null;
List<IG380Info> processDefinitionList = null;
if(vo != null){
	nameURLMap = vo.getNameURLMap();
	processTemplateList = vo.getProcessTemplateList();
	processDefinitionList = vo.getProcessDefinitionList();
}
%>
<html:html>
<bean:define id="id" value="IGFXK0601" toScope="request" />
<bean:define id="type" name="IGWKM0101Form" property="prtype" />
<bean:define id="title" value="问题整改查询页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<script type="text/javascript">
function searchuser(){	
	openSubWindow('/IGSYM1905_Disp.do?', '_blank','1000','600','center:1');
}
function setIGCYB0101Params(username,orgname,orgid,useremail,userphone,usermobile,userid){
	document.getElementById("ppusername_like").value = username;
	if(username == ""){
		document.getElementById("prstatus").selectedIndex = 0;
	}else{
		document.getElementById("prstatus").selectedIndex = 5;
	}
}
function onShow(){
	document.getElementById("div_0.0").style.display="";
	document.getElementById("label_img").innerHTML = "<img src=\"images/backup.gif\" align=\"middle\" alt=\"收起\" onclick=\"onHidden()\" style=\"cursor: hand;\" border=\"0\"/>";
}
function onHidden(){
	document.getElementById("div_0.0").style.display="none";
	document.getElementById("label_img").innerHTML = "<img src=\"images/moreSearch.gif\" align=\"middle\" alt=\"更多搜索条件\" onclick=\"onShow()\" style=\"cursor: hand;\" border=\"0\"/>";
}
jQuery(document).ready(function() {
	var orgname="<%=request.getParameter("orgname")%>";

	   if(orgname=="null"){
		   
	    		   document.getElementById("div_0.0").style.display="none";
	    	  
	   }
	   if(orgname==''){
		  
	    		   document.getElementById("div_0.0").style.display="none";

	   }
	});
	
	
	function changeTimeValue(id,item1,item2){
		document.getElementById(id).value = document.getElementById(item1).value + "_time_" + document.getElementById(item2).value;
	}
	
	function init(){
		<%
			IGWKM0101Form form = (IGWKM0101Form)request.getSession().getAttribute("IGWKM0101Form");
		if(form != null){
				String[] varnames = form.getVarnames();
				String[] varvalues = form.getVarvalues();
				
				if(varnames != null && varnames.length > 0 && varvalues != null && varvalues.length > 0){
					for(int i=0;i<varnames.length;i++){
						if("整改开始时间".equals(varnames[i])){
							if(varvalues.length >= i){
								%>
								var value = '<%=varvalues[i]%>';
								if(value != '' && value.indexOf("_time_") >= 0){
									var infos = value.split("_time_");
									if(infos != null){
										if(infos.length > 0){
											document.getElementById("starttime_one").value = infos[0];
										}
										if(infos.length > 1){
											document.getElementById("starttime_two").value = infos[1];
										}
									}
									document.getElementById("starttime").value = value;
								}
								<%
							}
						}
						if("整改结束时间".equals(varnames[i])){
							if(varvalues.length >= i){
								%>
								var value = '<%=varvalues[i]%>';
								if(value != '' && value.indexOf("_time_") >= 0){
									var infos = value.split("_time_");
									if(infos != null){
										if(infos.length > 0){
											document.getElementById("endtime_one").value = infos[0];
										}
										if(infos.length > 1){
											document.getElementById("endtime_two").value = infos[1];
										}
									}
									document.getElementById("endtime").value = value;
								}
								<%
							}
						}
					}
				}
			}
		%>
	}
</script>
<body onload="init();">
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
	<p class="fonts1"><ig:navigation/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
		    <div>
	                <span style="font-size:15px;"><strong>查询条件</strong></span>
	    	<label id="label_img" style="margin-left:736px;margin-top:-1px;">
				    		<img src="images/moreSearch.gif" align="middle" alt="更多搜索条件" onclick="onShow()" style="cursor: hand;" border="0"/>
				   	    </label>
	                </div>
	<div style="margin-top:4px">
	<span class="subscribe">问题整改名称：</span><html:text property="prtitle"/>	
	 <logic:present name="AD_ProcessInfoQueryMap" scope="session">
		<logic:iterate id="map" name="AD_ProcessInfoQueryMap" scope="session" indexId="index">
			<bean:define id="bean" name="map" property="value"/>
				<c:if test="${index!=2 }">
				<ig:processInfoQuery pdid="${bean.pdid }" pidname="${bean.pidname }" name="IGWKM0101Form" property="varvalues[${index }]" styleClassTagName="subscribe"/>
				<c:if test="${(index+1)%3==0 &&bean.pidname}">
					<br />
				</c:if>
			</c:if>
		</logic:iterate>
	</logic:present> 
	<span class="subscribe">流程状态：</span>
	<html:select property="prstatus" styleId="prstatus" style="width: 100px;">
    	<html:options collection="statusBeanList" property="value" labelProperty="label"/>
    </html:select>
    <html:submit styleClass="button" value="查询" />
	</div>
	
	<div style="margin-top:12px">
	<span class="subscribe">整改开始时间：</span>
	<html:hidden property="varnames" value="整改开始时间"/>
	<html:hidden property="varvalues" styleId="starttime"/>
	<input type="text" name="starttime_one" id="starttime_one" readonly="readonly" onchange="changeTimeValue('starttime','starttime_one','starttime_two');"/>
	<img src="images/date.gif" align="middle" onclick="showTime($('starttime_one'))" border="0" style="cursor: hand" />
	<span>--</span>
	<input type="text" name="starttime_two" id="starttime_two" readonly="readonly" onchange="changeTimeValue('starttime','starttime_one','starttime_two');"/>
	<img src="images/date.gif" align="middle" onclick="showTime($('starttime_two'))" border="0" style="cursor: hand" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span class="subscribe">整改结束时间：</span>
	<html:hidden property="varnames" value="整改结束时间"/>
	<html:hidden property="varvalues" styleId="endtime"/>
	<input type="text" name="endtime_one" id="endtime_one" readonly="readonly" onchange="changeTimeValue('endtime','endtime_one','endtime_two');"/>
	<img src="images/date.gif" align="middle" onclick="showTime($('endtime_one'))" border="0" style="cursor: hand" />
	<span>--</span>
	<input type="text" name="endtime_two" id="endtime_two" readonly="readonly" onchange="changeTimeValue('endtime','endtime_one','endtime_two');"/>
	<img src="images/date.gif" align="middle" onclick="showTime($('endtime_two'))" border="0" style="cursor: hand" />

	</div>
	<div id="div_0.0" style="margin-top:12px;display:none">
	<span class="subscribe">处理人：</span>
	<html:text property="ppusername_like" styleId="ppusername_like" readonly="true" errorStyleClass="inputError imeActive"></html:text>
    <img  id="img01" src="images/seek.gif" border="0" style="cursor: pointer;" onclick="searchuser();"  alt="请选择整改执行人"/>
	</div>
	
	<html:hidden property="selectstatus" name="selectstatus" value="1"/>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="1%"></th>
			<th width="1%"></th>
			<th width="8%"><a href="IGWKM0103.do?orderVal=prtitle">问题整改名称			
			<logic:equal name="IGWKM0101Form" property="order" value="prtitle">
				<logic:equal name="IGWKM0101Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0101Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="6%">问题整改来源</th>
			<th width="10%">问题所属领域</th>
			<th width="10%">处理人</th>
			<th width="9%">整改开始时间</th>
			<th width="9%">整改结束时间</th>
			<th width="10%">状态</th>
		</tr>
		<logic:present name="IGWKM01011VO" property="processList">
			<logic:iterate id="bean" name="IGWKM01011VO" property="processList"
				indexId="index">
				<bean:define id="prtype" name="bean" property="prtype" />
				
				<logic:equal name="bean" property="prtype"  value="<%=IGPROCESSType.SELF_DEFINING_WORK_PRTYPE %>">
					<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
					onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=78');">
				</logic:equal>
				<logic:notEqual name="bean" property="prtype"  value="<%=IGPROCESSType.SELF_DEFINING_WORK_PRTYPE %>">
					<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);"
					onclick="doLook('<%=nameURLMap.get(prtype) %><bean:write name="bean" property="prid" />');">
				</logic:notEqual>
					<td>
					<ig:ProcessInfoValueLevelImgTag pdname="${bean.prpdname}"  prid="${bean.prid}" />
					</td>
					<td>
						<ig:ProcessOverdueLevelImgTag prstatus="${bean.prstatus}" prid="${bean.prid}" />
					</td>
					
					
					<td><bean:write name="bean"
						property="prtitle" />
					</td>
					<td><ig:publicProcessInfoValue pidname="问题整改来源" prid="${bean.prid }"/>
					</td>
					<td><ig:publicProcessInfoValue pidname="问题所属领域" prid="${bean.prid }"/>
					</td>
					<td><ig:ProcessParticipantForStatusWriteTag prstatus="V" prid="${bean.prid }" />
					</td>
					
						<td><ig:publicProcessInfoValue pidname="整改开始时间" prid="${bean.prid }"/>
					</td>
					<td><ig:publicProcessInfoValue pidname="整改结束时间" prid="${bean.prid }"/>
					</td>

					<td>
						
					<%-- <bean:write name="bean"
						property="prstatus" /> --%>
					<%-- <c:choose>
						<c:when test="${bean.prstatus}=='Z'">待发起</c:when>
						<c:when test="${bean.prstatus}=='X'">风险总经理审批</c:when>
						<c:when test="${bean.prstatus}=='Y'">分派</c:when>
						<c:when test="${bean.prstatus}=='C'">关闭</c:when>
						<c:when test="${bean.prstatus}=='U'">整改审核</c:when>
						<c:when test="${bean.prstatus}=='V'">整改计划执行</c:when>
						<c:when test="${bean.prstatus}=='W'">委员会审批</c:when>
					</c:choose> --%>
					<logic:equal value="WD" name="bean" property="prtype">
						<ig:processDefineTypeValue prid="${bean.prid}"/>
						<logic:equal value="C" property="prsubstatus" name="bean">(中止)</logic:equal>
						</logic:equal>
						<logic:notEqual value="WD" name="bean" property="prtype">
						    <logic:notEqual value="" property="prsubstatus" name="bean">
								<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />(<ig:codeValue ccid="${bean.prtype}SUB" cid="${bean.prsubstatus}"/>)
							</logic:notEqual>
							<logic:equal value="" property="prsubstatus" name="bean">
								<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
							</logic:equal>
						</logic:notEqual>	
						
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

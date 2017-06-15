<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="com.deliverik.infogovernor.prr.bl.IGPRR01BLType"%>
<%@page import="com.deliverik.framework.workflow.WorkFlowConstDefine"%>
<%@page import="java.util.List"%>
<html xmlns:v="urn:schemas-microsoft-com:vml">
<base target="_self">

<% 
	String lastrowwidth = "";
	String trStartTag = "";
	String trEndTag = "";
	String tdStartTag = "";
	String textSize = "32";
	String textAreaSize = "25";
	int columnNum = 0;
	boolean privateIsNull = true;
%>
<link rel="stylesheet" href="<html:rewrite forward='pdimgstyle.css'/>" type="text/css">
<script>
var tempPdid = 0;
var num = 0;
var asmNum=0;
var tempNum=0;
function addEntity(pidid, index, required) 
{	
	tempNum=index;
	eval("currRow=tbentity" +pidid + ".insertRow();");
	cell=currRow.insertCell();
	cell.innerHTML= "<input type='text' name='entityName["+asmNum+"]' size='18' readonly='true' errorStyleClass='inputError imeActive'><img src='images/seek.gif' border='0' width='16' height='16' alt='删除' onclick=\"selectEntity("+asmNum+", '" + pidid + "')\" style='cursor: hand'/>&nbsp;&nbsp;<img src='images/delate.gif' alt='删除' onclick=\"deleteEntityItem(this, '" + pidid + "')\" style='cursor: hand'/><input type='hidden' name='entityId["+asmNum+"]' class='" + required +"'/><input type='hidden' name='" + pidid + "'/>";

	asmNum++;
}

function deleteEntityItem(obj, pidid)
{
	var curRow= obj.parentNode.parentNode;
	$("tbentity" + pidid).deleteRow(curRow.rowIndex);

}

function selectEntity(index, pidid){
	num = index;
	openSubIGCOM0302PARAM('?pidid='+pidid);
}
var pieids = "";
function delEntity(pieid){
		document.getElementById(pieid).style.display = "none";
		document.getElementById(pieid + "ENT").style.display = "none";
		pieids = pieids + "#" + pieid;
		document.forms[0].pieids.value = pieids;
}

function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory, pidid) {
	if("" == eiid){
		$("entityId[" + num + "]").value = "";
		$("entityname[" + num + "]").value = "";
	} else {
		$("entityId[" + num + "]").value = pidid + "#" + eiid;
		$("entityname[" + num + "]").value = einame;
		if(pidid != 'A'){
			$("pivarvalue[" + tempNum + "]").value = "N/A";
		}
	}
	
	num = 0;

}

/**
* 流程快捷发起(可发起多个流程类型，打开流程选择页面)
* 
*   prid：流程ID
*   prtype：流程类型
*   pdid:当前流程的流程类型id
*   psdid:当前流程状态id
*   roleid:当前流程状态参与者角色
*   parameters:其他信息
*   url：需要刷新的父页url
*/
function showChooseProcessPage(prid, prtype, pdid, psdid, roleid, parameters, url){
    window.showModalDialog(getAppRootUrl() + "/IGPRM0003_RelevantProcess.do?prid=" + prid + 
            "&prtype=" + prtype+ 
            "&pdid=" + pdid+
            "&psdid=" + psdid+
            "&roleid=" + roleid+
            "&parameters=" + parameters,
            null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
    window.location.href = url;
}

/**
* 流程快捷发起（只可发起一种流程类型，打开发起页面）
* 
*   prid：流程ID
*   relevantPdid：相关发起的自定义流程类型id
*   parameters:其他信息
*   url：需要刷新的父页url
*/
function showInitProcessPage(prid, relevantPdid, parameters, url){
    window.showModalDialog(getAppRootUrl() + "/IGCOM0401.do?parprid="+prid+
            "&prtype=WD&prpdid=" + relevantPdid+
            "&flag=0&ptid=8&parameters=" + parameters,
            null,"dialogWidth:1080px;dialogHeight:650px;status:no;help:no;resizable:yes");
    window.location.href = url;
}

// function loadFromXML(){
// 	var xmlStr=document.all.FlowXML.value;
// 	  if(xmlStr!=null&&xmlStr!=''&&xmlStr!='null'){
// 	  var xmlDoc = new ActiveXObject('MSXML2.DOMDocument');
// 		 xmlDoc.async = false;
// 		 xmlDoc.loadXML(xmlStr);
// 		 var xmlRoot = xmlDoc.documentElement; 
// 		 document.all.FlowXML.value = xmlRoot.xml;
// 	 }
// }
</script>
<script src="<html:rewrite forward='context.js'/>"  ></script>
<script src="<html:rewrite forward='webflow.js'/>" charset="gb2312"></script>
<script src="<html:rewrite forward='function.js'/>"></script>
<script src="<html:rewrite forward='shiftlang.js'/>" ></script>
<script src="<html:rewrite forward='movestep.js'/>"></script>
<bean:define id="id" value="IGPRR0102" toScope="request" />
<bean:define id="title" value="工作信息" toScope="request" />
<jsp:include page="/include/header1.jsp" />

<!-- <STYLE> -->
<%-- v\:* { Behavior: url(#default#VML) } --%> 
<!-- </STYLE> -->
<style>
html{
overflow-x:auto;
overflow-y:auto;
}
</style>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent" style="background-color: #FFFFFF; background-image: none;">
<!--test-->
<jsp:include page="/srv/prr/IGPRR0135.jsp" />
<div id="container">
<div id="contentWrap">
<div id="content"><html:form action="/IGPRR0102_SOC" styleId="form"
	onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
<!-- 	<div id="location"> -->
<!-- 	<div class="image"></div> -->
<!-- 	<p class="fonts1">流程管理 &gt;&gt;  -->
<%-- 	<logic:equal name="prtype" value="WD">工作管理  &gt;&gt; 工作信息 --%>
<%-- 	（${IGPRR01021VO.process.prpdname}——<ig:processDefineTypeValue prid="${IGPRR01021VO.process.prid}"/>） --%>
<%-- 	</logic:equal> --%>
<%-- 	<logic:notEqual name="prtype" value="WD">流程信息 --%>
<%-- 	（${IGPRR01021VO.process.prpdname}——<ig:processDefineTypeValue prid="${IGPRR01021VO.process.prid}"/>） --%>
<%-- 	</logic:notEqual>  --%>
<!-- 	</p> -->
<%-- 	<logic:equal value="1" property="jump" name="IGPRR0102Form"> --%>
<%-- 	<div class="back"><a href="IGCOM0203_Disp.do" target="_self">返回</a></div></logic:equal> --%>
<%-- 	<logic:equal value="0" property="jump" name="IGPRR0102Form"> --%>
<%-- 	<div class="back"><a href="IGCOM0201_Disp.do" target="_self">返回</a></div></logic:equal> --%>
<%-- 	<logic:equal value="2" property="jump" name="IGPRR0102Form"> --%>
<%-- 	<div class="back"><a href="IGSVC0801_Back.do" target="_self">返回</a></div></logic:equal> --%>
<%-- 	<logic:equal value="3" property="jump" name="IGPRR0102Form"> --%>
<%-- 	<div class="back"><a href="IGSVC0801_Disp.do" target="_self">返回</a></div></logic:equal> --%>
<%-- 	<logic:equal value="4" property="jump" name="IGPRR0102Form"> --%>
<%--     <div class="back"><a href="IGSVC0703.do" target="_self">返回</a></div></logic:equal> --%>
<%-- 	<logic:equal value="5" property="jump" name="IGPRR0102Form"> --%>
<%--     <div class="back"><a href="IGWKM0101_BACK.do" target="_self">返回</a></div></logic:equal> --%>
<%--     <logic:equal value="6" property="jump" name="IGPRR0102Form"> --%>
<%--     <div class="back"><a href="IGSVC0902.do?type=${IGSVC0902Form.type}&prorgid=${IGSVC0902Form.prorgid}&propentime_from=${IGSVC0902Form.propentime_from}&propentime_to=${propentime_to}&prpdid=${IGSVC0902Form.prpdid}" target="_self">返回</a></div></logic:equal> --%>
<!--     </div> -->
<%-- 	<div id="formwrapper"><ig:message /> --%>
<!-- 	<div class="title"> -->
<!-- 	<div class="name">流程图</div>  -->
<!-- 	</div> -->
<!-- 	<div id="results_list"> -->
<%-- 	<INPUT TYPE="hidden" value="${IGPRR01021VO.flowChartXml}" id="FlowXML" onpropertychange='if(AUTODRAW) redrawVML();'> --%>
<%-- 	<logic:empty name="IGPRR01021VO" property="xmlheight"> --%>
<%-- 		<bean:define id="xmlheight" value="400px" type="java.lang.String" /> --%>
<%-- 	</logic:empty> --%>
<%-- 	<logic:notEmpty name="IGPRR01021VO" property="xmlheight"> --%>
<%-- 		<bean:define id="xmlheight" name="IGPRR01021VO" property="xmlheight" type="java.lang.String" /> --%>
<%-- 	</logic:notEmpty> --%>
<!-- 	<table cellspacing="0" cellpadding="0" class="panel_style" -->
<!-- 		align="center"> -->
<!-- 		<tr> -->
<%-- 			<td width="100%" height="${xmlheight}" --%>
<!-- 				onclick="cleancontextMenu();return false;" -->
<!-- 				oncontextmenu='flowContextMenu();return false;'> -->
<!-- 				<v:group ID="FlowVML" style="left:293;top:56;width:1000px;height:500px;position:absolute;" coordsize="2000,2000"> -->
<!-- 				</v:group> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
<!-- 	</div> -->
	<div id="formwrapper"><!--  message --> <!--  /message -->
	<jsp:include page="/srv/prr/IGPRR0136.jsp"/>
	
	<logic:present name="IGPRR01021VO">
	<logic:equal name="IGPRR01021VO" property="hid" value="1">
	<logic:present name="IGPRR01021VO" property="processInfoDefmap">
		<div class="record_list">
		<table cellspacing="2" class="table_style1">
			<tr style="display:none">
				<th width="15%"></th><td width="35%"></td><th width="15%"></th><td width="35%"></td>
			</tr>
			<bean:define id="useridprr" name="IGPRR01021VO" property="userid" type="java.lang.String" />
			<bean:define id="roleidprr" name="IGPRR01021VO" property="roleid" type="java.lang.Integer" />
			<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
				<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
				<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
				<bean:define id="processLinkageDefList" name="psid" property="processLinkageDefList" type="java.util.List" />
				<logic:present name="psid">
				<% 
				if("2".equalsIgnoreCase(psid.getPidaccess()) || "3".equalsIgnoreCase(psid.getPidaccess()) || "4".equalsIgnoreCase(psid.getPidaccess())){
					String rowwidth = StringUtils.isEmpty(psid.getRowwidth())?"0":psid.getRowwidth().trim();
					rowwidth = StringUtils.isEmpty(rowwidth)?"0":rowwidth;
					tdStartTag = "<td>";
					textSize = "32";
					textAreaSize = "25";
					if(StringUtils.isEmpty(lastrowwidth)){
						trStartTag = "<tr>";
						if("0".equals(rowwidth)){
							tdStartTag = "<td colspan=\"3\">";
						}
					}
					if("0".equalsIgnoreCase(lastrowwidth)){
						trStartTag = "</tr><tr>";
						if("0".equals(rowwidth)){
							tdStartTag = "<td colspan=\"3\">";
						}
					}
					if("1".equalsIgnoreCase(lastrowwidth)){
						if("0".equals(rowwidth)){
							if(columnNum == 0){
								trStartTag = "</tr><tr>";
							}else{
								trStartTag = "<td></td><td></td></tr><tr>";
							}
							tdStartTag = "<td colspan=\"3\">";
						}else{
							if(columnNum == 0){
								trStartTag = "</tr><tr>";
							}else{
								trStartTag = "";
							}
						}
					}
					if("0".equalsIgnoreCase(rowwidth)){
						columnNum = 0;
					}else{
						columnNum = (columnNum+1)%2;
					}
					lastrowwidth = rowwidth;
					if("0".equals(rowwidth)){
						textSize = "82";
						textAreaSize = "60";
					}
				}
				%>
					<logic:equal name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>">
						<%=trStartTag %>
							<th>
								<label for="Name"><strong>
								<logic:equal value="1" name="psid" property="pidrequired"><span class="red">*</span></logic:equal>
								${psid.pidlabel}</strong>：</label>
							</th>
							<%=tdStartTag %>
							<logic:equal value="<%=IGPRDCONSTANTS.PIDMODE_PUBLIC %>" name="psid" property="pidmode">
								<logic:equal value="0" name="psid" property="pidtype">
									<html:text styleId="pidid${pidid}" property="pivarvalue[${index}]" size="<%= textSize%>" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" />
								</logic:equal>
								<logic:equal value="2" name="psid" property="pidtype">
									<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
									<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
									<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
										<html:select  styleId="pidid${pidid}" property="pivarvalue[${index}]" value='<%=StringUtils.isEmpty(psid.getPidvalue())?piddefault:psid.getPidvalue() %>'>
										<%
											String[] options = (String[])optionMap.get(pidid);
											for(int i = 0; i < options.length; i++){
										%>
											<html:option value="<%=options[i] %>" ><%=options[i] %></html:option>
										<% } %>
										</html:select>
								</logic:equal>
								<logic:equal value="B" name="psid" property="pidtype">
									<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
									<%
										String checkboxvalue = StringUtils.isEmpty(psid.getPidvalue())?psid.getPiddefault():psid.getPidvalue();
										String[] options = (String[])optionMap.get(psid.getPidid());
										for(int iRadio = 0; iRadio < options.length; iRadio++){
											if(StringUtils.isNotEmpty(options[iRadio])){
												String checked = "";
												if(options[iRadio].equals(checkboxvalue)){
													checked = "checked=\"checked\"";
												}
									%>
											<span style="display:inline-block">
												<input type="radio" name="pivarradio[${index}]" value="<%=options[iRadio] %>" onclick="setRadio(${index},this)" <%=checked %>/><%=options[iRadio] %>
											</span>
									<%
											}
										}
									%>
									<html:hidden property="pivarvalue[${index}]" value="${piddefault}"/>
								</logic:equal>
								<logic:equal value="E" name="psid" property="pidtype">
									<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
									<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
									<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
									<%	String checkboxvalue = StringUtils.isEmpty(psid.getPidvalue())?piddefault:psid.getPidvalue();
										String[] options = (String[])optionMap.get(pidid);
										boolean radio_flag = true;
										
										for(int iRadio = 0; iRadio < options.length; iRadio++){
											if(StringUtils.isNotEmpty(options[iRadio])){
												String checked = "";
												if(options[iRadio].equals(checkboxvalue)){
													checked = "checked=\"checked\"";
													radio_flag = false;
												}%>
											<span style="display:inline-block">
												<input type="radio" name="pivarradio[${index}]" value="<%=options[iRadio] %>" onclick="setRadio_other(${index},this)" <%=checked %>/><%=options[iRadio] %>
											</span>
									<%		}
										}
										String checked_other = "";
										String display_other = "";
										if(radio_flag){
											checked_other = "checked=\"checked\"";
										}else{
											display_other = "display: none;";
										}%>
											<input id="pivarradio_Other[${index}]" type="radio" name="pivarradio[${index}]" value="<%=checkboxvalue %>" onclick="setRadio_other(${index},this,'other')" <%=checked_other %>/>其他 
											<html:text style="<%=display_other %>" styleId="pivarvalue_Other[${index}]" property="pivarvalue[${index}]" size="18" errorStyleClass="inputError imeActive"
											  value="<%=checkboxvalue %>" onchange="setOnChage_other(${index},this)" /> 
									<html:hidden property="pivarvalue[${index}]" value="${piddefault}"/>
								</logic:equal>
								<logic:equal value="C" name="psid" property="pidtype">
									<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
									<%
										String checkboxvalue = StringUtils.isEmpty(psid.getPidvalue())?"":psid.getPidvalue();
										String[] boxValues = checkboxvalue.split("#");
										String[] options = (String[])optionMap.get(psid.getPidid());
										for(int iCheckbox = 0; iCheckbox < options.length; iCheckbox++){
											if(StringUtils.isNotEmpty(options[iCheckbox])){
												String checked = "";
												for(int iValue = 0; iValue < boxValues.length; iValue++){
													if(options[iCheckbox].equals(boxValues[iValue])){
														checked = "checked";
													}
												}
									%>
										<span style="display:inline-block">
												<input type="checkbox" name="pivarcheckbox[${index}]" value="<%=options[iCheckbox] %>" onclick="setCheckbox(${index},this)" <%=checked %>/><%=options[iCheckbox] %>
										</span>
									<%
											}
										}
									%>
									<html:hidden property="pivarvalue[${index}]" value="<%=checkboxvalue %>"/>
								</logic:equal>
								<logic:equal value="3" name="psid" property="pidtype">
									<html:text styleId="pidid${pidid}" property="pivarvalue[${index}]" size="32" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" readonly="true"/>
										<img src="images/date.gif" align="middle" onclick="showDate($('pivarvalue[${index}]'))" style="cursor: hand" />
								</logic:equal>
								<logic:equal value="7" name="psid" property="pidtype">
									<html:text styleId="pidid${pidid}" property="pivarvalue[${index}]" size="32" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" readonly="true"/>
									<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('pivarvalue[${index}]'))" border="0" style="cursor: hand"/>
			                       	<a href="javascript:clear($('pivarvalue[${index}]'));">清空</a><br/>
								</logic:equal>
								<logic:equal value="A" name="psid" property="pidtype">
									<html:text styleId="pidid${pidid}" property="pivarvalue[${index}]" size="32" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" readonly="true"/>
									<img src="images/date.gif" align="middle" onclick="showTime($('pivarvalue[${index}]'))" style="cursor: hand" />
								</logic:equal>
								<logic:equal value="R" name="psid" property="pidtype">
									<html:text styleId="pidid${pidid}" property="pivarrolename[${index}]" size="32" errorStyleClass="inputError imeActive" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_role_"))?"":psid.getPidvalue().split("_role_")[1] %>' readonly="true"/>
									<img src="images/seek.gif" alt="查询" onclick="selectRoleOnIGSYM0306(${index},'${psid.pdid}')" style="cursor: hand"/>
									<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
								</logic:equal>
								<logic:equal value="4" name="psid" property="pidtype">

									<bean:define id="count" name="IGPRR01021VO" property="processInfolist" type="java.util.List"/>
									<logic:iterate id="info" name="IGPRR01021VO" property="processInfolist"
										type="com.deliverik.framework.workflow.prr.model.IG599Info">
											<%if((psid.getPidlabel().equals(info.getPivarlabel()))
														&& WorkFlowConstDefine.PROCESS_PIVRTYPE.equals(info.getPivartype())){ %>
												<logic:present name="IGPRR01021VO" property="processInfoEntityList">
													<logic:iterate id="entity" name="IGPRR01021VO" property="processInfoEntityList"
														 type="com.deliverik.framework.workflow.prd.model.IG731Info">
														<% if(info.getPiid().equals(entity.getPiid())){ %>
																	<a href="javascript:void(0)" onclick="openSubIGCOM0328('<%=entity.getEiid() %>','')" id="<%=entity.getPieid() %>">
																	<%=entity.getSoc0118TB().getEiname() %></a><img id="<%=entity.getPieid() %>ENT" src="images/delate.gif" align="middle" onClick="delEntity('<%=entity.getPieid() %>')" border="0" style="cursor: hand" alt='删除'/>&nbsp;
														<% } %>
													</logic:iterate>
												</logic:present>
											<% }%>
									</logic:iterate>
									<br/>
									<img src="images/addasm.gif" alt='查询' style="cursor: hand"/>
									<a href="javascript:addEntity('${psid.pidid}', ${index},
									<c:if test="${psid.pidrequired == '1' }">'1'</c:if><c:if test="${psid.pidrequired != '1' }">'0'</c:if>
										);" id="aAddEntity">添加资产</a> 
									<br/>
									<table id="tbentity${psid.pidid}">
									</table>
									<html:hidden property="pivarvalue[${index}]" />
								
								</logic:equal>
								<logic:equal value="5" name="psid" property="pidtype">
									<html:text styleId="pidid${pidid}" property="pivarprname[${index}]" size="32" errorStyleClass="inputError imeActive" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_svc_"))?"":psid.getPidvalue().split("_svc_")[1].split("_name=")[1] %>' readonly="true"/>
									<img src="images/seek.gif" alt="查询" onclick="openSVCPage(${index})" style="cursor: hand"/>
									<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
								</logic:equal>
								<logic:equal value="6" name="psid" property="pidtype">
									<html:text styleId="pidid${pidid}" property="pivarprjname[${index}]" size="32" errorStyleClass="inputError imeActive" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_prj_"))?"":psid.getPidvalue().split("_prj_")[1] %>' readonly="true"/>
									<img src="images/seek.gif" alt="查询" onclick="selectProject(${index})" style="cursor: hand"/>
									<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
								</logic:equal>
								<logic:equal value="T" name="psid" property="pidtype">
									<html:text property="pivartreename[${index}]" size="32" readonly="true" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_tree_"))?"":psid.getPidvalue().split("_tree_")[1] %>' /> 
									<img src="images/seek.gif" alt='查询' onclick="selectTree(${index},'${psid.ccid}')" style="cursor: hand"/>
									<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
								</logic:equal>
								<logic:equal value="9" name="psid" property="pidtype">
									<html:textarea  styleId="pidid${pidid}" property="pivarvalue[${index}]" errorStyleClass="inputError" rows="5" cols="<%= textAreaSize%>" value="${psid.pidvalue}"/>
									<img src="images/attachment.gif" /><a href="javascript:addFileMuti('${psid.pidlabel}')" id="aAddAttachMuti">添加附件</a>&nbsp;&nbsp;&nbsp;
									<table id="${psid.pidlabel}">
									</table>
									<input type="hidden" id="delFileMutiStr" name="delFileMutiStr" value=""/>
									<logic:present name="IGPRR01021VO" property="textAreaMap">
										<logic:notEmpty	name="IGPRR01021VO" property="textAreaMap">
											<bean:define id="a" name="IGPRR01021VO" property="textAreaMap" type="java.util.Map" />
											<logic:iterate id="map" name="IGPRR01021VO"	property="textAreaMap" indexId="number">
												<bean:define id="category" name="map" property="key"/>
												<bean:define id="list" name="map" property="value"	type="java.util.ArrayList" />
												<logic:equal name="map" property="key" value="${psid.pidlabel}">
													<logic:iterate id="attachment" name="list" indexId="number">
														<a href="downloadSvcFile.do?attId=${attachment.attid}&type=svc" id="${attachment.attid}">
															<bean:define id="attname" name="attachment" property="attname" />
															<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
														</a>
														<img id="${attachment.attid}IMG" src="images/delate.gif" align="middle" onClick="delFile('${attachment.attid}','${psid.piid}')" border="0" style="cursor: hand" alt="删除"/>
													</logic:iterate>
												</logic:equal>
											</logic:iterate>
										</logic:notEmpty>
									</logic:present>
								</logic:equal>
							</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PIDMODE_PRIVATE %>" name="psid" property="pidmode">
								<%privateIsNull = true; %>
								<logic:notEmpty name="psid" property="processPrivateInfoList">
									<logic:iterate id="privateinfoList" name="psid" property="processPrivateInfoList" type="com.deliverik.framework.workflow.prr.model.IG899Info">
										<c:if test='${(psid.privatescope == "0" && IGPRR01021VO.roleid == privateinfoList.roleid) || (psid.privatescope=="1" && IGPRR01021VO.userid == privateinfoList.userid)}'>
											<logic:equal value="0" name="psid" property="pidtype">
												<html:text styleId="pidid${pidid}" property="pivarvalue[${index}]" size="<%= textSize%>" errorStyleClass="inputError imeActive" value="${privateinfoList.ppivalue}" />
											</logic:equal>
											<logic:equal value="2" name="psid" property="pidtype">
												<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
												<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
												<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
													<html:select  styleId="pidid${pidid}" property="pivarvalue[${index}]" value='<%=StringUtils.isEmpty(privateinfoList.getPpivalue())?piddefault:privateinfoList.getPpivalue() %>'>
													<%
														String[] options = (String[])optionMap.get(pidid);
														for(int i = 0; i < options.length; i++){
													%>
														<html:option value="<%=options[i] %>" ><%=options[i] %></html:option>
													<% } %>
													</html:select>
											</logic:equal>
											<logic:equal value="B" name="psid" property="pidtype">
												<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
												<%
													String checkboxvalue = StringUtils.isEmpty(privateinfoList.getPpivalue())?psid.getPiddefault():privateinfoList.getPpivalue();
													String[] options = (String[])optionMap.get(psid.getPidid());
													for(int iRadio = 0; iRadio < options.length; iRadio++){
														if(StringUtils.isNotEmpty(options[iRadio])){
															String checked = "";
															if(options[iRadio].equals(checkboxvalue)){
																checked = "checked=\"checked\"";
															}
												%>
														<span style="display:inline-block">
															<input type="radio" name="pivarradio[${index}]" value="<%=options[iRadio] %>" onclick="setRadio(${index},this)" <%=checked %>/><%=options[iRadio] %>
														</span>
												<%
														}
													}
												%>
												<html:hidden property="pivarvalue[${index}]" value="${piddefault}"/>
											</logic:equal>
											<logic:equal value="E" name="psid" property="pidtype">
												<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
												<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
												<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
												<%	String checkboxvalue = StringUtils.isEmpty(privateinfoList.getPpivalue())?piddefault:privateinfoList.getPpivalue();
													String[] options = (String[])optionMap.get(pidid);
													boolean radio_flag = true;
													
													for(int iRadio = 0; iRadio < options.length; iRadio++){
														if(StringUtils.isNotEmpty(options[iRadio])){
															String checked = "";
															if(options[iRadio].equals(checkboxvalue)){
																checked = "checked=\"checked\"";
																radio_flag = false;
															}%>
														<span style="display:inline-block">
															<input type="radio" name="pivarradio[${index}]" value="<%=options[iRadio] %>" onclick="setRadio_other(${index},this)" <%=checked %>/><%=options[iRadio] %>
														</span>
												<%		}
													}
													String checked_other = "";
													String display_other = "";
													if(radio_flag){
														checked_other = "checked=\"checked\"";
													}else{
														display_other = "display: none;";
													}%>
														<input id="pivarradio_Other[${index}]" type="radio" name="pivarradio[${index}]" value="<%=checkboxvalue %>" onclick="setRadio_other(${index},this,'other')" <%=checked_other %>/>其他 
														<html:text style="<%=display_other %>" styleId="pivarvalue_Other[${index}]" property="pivarvalue[${index}]" size="18" errorStyleClass="inputError imeActive"
														  value="<%=checkboxvalue %>" onchange="setOnChage_other(${index},this)" /> 
												<html:hidden property="pivarvalue[${index}]" value="${piddefault}"/>
											</logic:equal>
											<logic:equal value="C" name="psid" property="pidtype">
												<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
												<%
													String checkboxvalue = StringUtils.isEmpty(privateinfoList.getPpivalue())?"":privateinfoList.getPpivalue();
													String[] boxValues = checkboxvalue.split("#");
													String[] options = (String[])optionMap.get(psid.getPidid());
													for(int iCheckbox = 0; iCheckbox < options.length; iCheckbox++){
														if(StringUtils.isNotEmpty(options[iCheckbox])){
															String checked = "";
															for(int iValue = 0; iValue < boxValues.length; iValue++){
																if(options[iCheckbox].equals(boxValues[iValue])){
																	checked = "checked";
																}
															}
												%>
													<span style="display:inline-block">
															<input type="checkbox" name="pivarcheckbox[${index}]" value="<%=options[iCheckbox] %>" onclick="setCheckbox(${index},this)" <%=checked %>/><%=options[iCheckbox] %>
													</span>
												<%
														}
													}
												%>
												<html:hidden property="pivarvalue[${index}]" value="<%=checkboxvalue %>"/>
											</logic:equal>
											<logic:equal value="3" name="psid" property="pidtype">
												<html:text styleId="pidid${pidid}" property="pivarvalue[${index}]" size="32" errorStyleClass="inputError imeActive" value="${privateinfoList.ppivalue}" readonly="true"/>
													<img src="images/date.gif" align="middle" onclick="showDate($('pivarvalue[${index}]'))" style="cursor: hand" />
											</logic:equal>
											<logic:equal value="7" name="psid" property="pidtype">
												<html:text styleId="pidid${pidid}" property="pivarvalue[${index}]" size="32" errorStyleClass="inputError imeActive" value="${privateinfoList.ppivalue}" readonly="true"/>
												<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('pivarvalue[${index}]'))" border="0" style="cursor: hand"/>
						                       	<a href="javascript:clear($('pivarvalue[${index}]'));">清空</a><br/>
											</logic:equal>
											<logic:equal value="A" name="psid" property="pidtype">
												<html:text styleId="pidid${pidid}" property="pivarvalue[${index}]" size="32" errorStyleClass="inputError imeActive" value="${privateinfoList.ppivalue}" readonly="true"/>
												<img src="images/date.gif" align="middle" onclick="showTime($('pivarvalue[${index}]'))" style="cursor: hand" />
											</logic:equal>
											<logic:equal value="R" name="psid" property="pidtype">
												<html:text styleId="pidid${pidid}" property="pivarrolename[${index}]" size="32" errorStyleClass="inputError imeActive" value='<%=(StringUtils.isEmpty(privateinfoList.getPpivalue()) || !privateinfoList.getPpivalue().contains("_role_"))?"":privateinfoList.getPpivalue().split("_role_")[1] %>' readonly="true"/>
												<img src="images/seek.gif" alt="查询" onclick="selectRoleOnIGSYM0306(${index},'${psid.pdid}')" style="cursor: hand"/>
												<html:hidden property="pivarvalue[${index}]" value="${privateinfoList.ppivalue}"/>
											</logic:equal>
											<logic:equal value="4" name="psid" property="pidtype">
			
												<bean:define id="count" name="IGPRR01021VO" property="processInfolist" type="java.util.List"/>
												<logic:iterate id="info" name="IGPRR01021VO" property="processInfolist"
													type="com.deliverik.framework.workflow.prr.model.IG599Info">
														<%if((psid.getPidlabel().equals(info.getPivarlabel()))
																	&& WorkFlowConstDefine.PROCESS_PIVRTYPE.equals(info.getPivartype())){ %>
									
															<logic:present name="IGPRR01021VO" property="processInfoEntityList">
																<logic:iterate id="entity" name="IGPRR01021VO" property="processInfoEntityList"
																	 type="com.deliverik.framework.workflow.prd.model.IG731Info">
																	<% if(info.getPiid().equals(entity.getPiid())){ %>
																				<a href="javascript:void(0)" onclick="openSubIGCOM0328('<%=entity.getEiid() %>','')" id="<%=entity.getPieid() %>">
																				<%=entity.getSoc0118TB().getEiname() %></a><img id="<%=entity.getPieid() %>ENT" src="images/delate.gif" align="middle" onClick="delEntity('<%=entity.getPieid() %>')" border="0" style="cursor: hand" alt='删除'/>&nbsp;
																	<% } %>
																</logic:iterate>
															</logic:present>
														<% }%>
												</logic:iterate>
												<br/>
												<img src="images/addasm.gif" alt='查询' style="cursor: hand"/>
												<a href="javascript:addEntity(${psid.pidid}, ${index},
												<c:if test="${psid.pidrequired == '1' }">'1'</c:if><c:if test="${psid.pidrequired != '1' }">'0'</c:if>
													);" id="aAddEntity">添加资产</a> 
												<br/>
												<table id="tbentity${psid.pidid}">
												</table>
												<html:hidden property="pivarvalue[${index}]" />
											</logic:equal>
											<logic:equal value="5" name="psid" property="pidtype">
												<html:text styleId="pidid${pidid}" property="pivarprname[${index}]" size="32" errorStyleClass="inputError imeActive" value='<%=(StringUtils.isEmpty(privateinfoList.getPpivalue()) || !privateinfoList.getPpivalue().contains("_svc_"))?"":privateinfoList.getPpivalue().split("_svc_")[1].split("_name=")[1] %>' readonly="true"/>	
												<img src="images/seek.gif" alt="查询" onclick="openSVCPage(${index})" style="cursor: hand"/>
												<html:hidden property="pivarvalue[${index}]" value="${privateinfoList.ppivalue}"/>
											</logic:equal>
											<logic:equal value="6" name="psid" property="pidtype">
												<html:text styleId="pidid${pidid}" property="pivarprjname[${index}]" size="32" errorStyleClass="inputError imeActive" value='<%=(StringUtils.isEmpty(privateinfoList.getPpivalue()) || !privateinfoList.getPpivalue().contains("_prj_"))?"":privateinfoList.getPpivalue().split("_prj_")[1] %>' readonly="true"/>	
												<img src="images/seek.gif" alt="查询" onclick="selectProject(${index})" style="cursor: hand"/>
												<html:hidden property="pivarvalue[${index}]" value="${privateinfoList.ppivalue}"/>
											</logic:equal>
											<logic:equal value="T" name="psid" property="pidtype">
												<html:text property="pivartreename[${index}]" size="32" readonly="true" value='<%=(StringUtils.isEmpty(privateinfoList.getPpivalue()) || !privateinfoList.getPpivalue().contains("_tree_"))?"":privateinfoList.getPpivalue().split("_tree_")[1] %>' /> 
												<img src="images/seek.gif" alt='查询' onclick="selectTree(${index},'${psid.ccid}')" style="cursor: hand"/>
												<html:hidden property="pivarvalue[${index}]" value="${privateinfoList.ppivalue}"/>
											</logic:equal>
											<logic:equal value="9" name="psid" property="pidtype">
												<html:textarea  styleId="pidid${pidid}" property="pivarvalue[${index}]" errorStyleClass="inputError" rows="5" cols="<%= textAreaSize%>" value="${privateinfoList.ppivalue}"/>
												<img src="images/attachment.gif" /><a href="javascript:addFileMuti('${psid.pidlabel}')" id="aAddAttachMuti">添加附件</a>&nbsp;&nbsp;&nbsp;
												<table id="${psid.pidlabel}">
												</table>
												<input type="hidden" id="delFileMutiStr" name="delFileMutiStr" value=""/>
												<logic:present name="IGPRR01021VO" property="textAreaMap">
													<logic:notEmpty	name="IGPRR01021VO" property="textAreaMap">
														<bean:define id="a" name="IGPRR01021VO" property="textAreaMap" type="java.util.Map" />
														<logic:iterate id="map" name="IGPRR01021VO"	property="textAreaMap" indexId="number">
															<bean:define id="category" name="map" property="key" type="java.lang.String"/>
															<bean:define id="list" name="map" property="value"	type="java.util.ArrayList" />
															<% 
																if(("0".equalsIgnoreCase(psid.getPrivatescope()) && category.equalsIgnoreCase(psid.getPidlabel()+"_"+privateinfoList.getRoleid()))
																		|| "1".equalsIgnoreCase(psid.getPrivatescope()) && category.equalsIgnoreCase(psid.getPidlabel()+"_"+privateinfoList.getUserid())){
															%>
																<logic:iterate id="attachment" name="list" indexId="number">
																	<a href="downloadSvcFile.do?attId=${attachment.attid}&type=svc" id="${attachment.attid}">
																		<bean:define id="attname" name="attachment" property="attname" />
																		<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
																	</a>
																	<img id="${attachment.attid}IMG" src="images/delate.gif" align="middle" onClick="delFile('${attachment.attid}','${psid.piid}')" border="0" style="cursor: hand" alt="删除"/>
																</logic:iterate>
															<%	} %>
														</logic:iterate>
													</logic:notEmpty>
												</logic:present>
											</logic:equal>
											<%privateIsNull = false; %>
										</c:if>		
									</logic:iterate>
								</logic:notEmpty>
								<%
									if(psid.getProcessPrivateInfoList() == null || privateIsNull){
								%>
									<logic:equal value="0" name="psid" property="pidtype">
										<html:text styleId="pidid${pidid}" property="pivarvalue[${index}]" size="<%= textSize%>" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" />
									</logic:equal>
									<logic:equal value="2" name="psid" property="pidtype">
										<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
										<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
										<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
											<html:select  styleId="pidid${pidid}" property="pivarvalue[${index}]" value='<%=StringUtils.isEmpty(psid.getPidvalue())?piddefault:psid.getPidvalue() %>'>
											<%
												String[] options = (String[])optionMap.get(pidid);
												for(int i = 0; i < options.length; i++){
											%>
												<html:option value="<%=options[i] %>" ><%=options[i] %></html:option>
											<% } %>
											</html:select>
									</logic:equal>
									<logic:equal value="B" name="psid" property="pidtype">
									<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
									<%
										String checkboxvalue = StringUtils.isEmpty(psid.getPidvalue())?psid.getPiddefault():psid.getPidvalue();
										String[] options = (String[])optionMap.get(psid.getPidid());
										for(int iRadio = 0; iRadio < options.length; iRadio++){
											if(StringUtils.isNotEmpty(options[iRadio])){
												String checked = "";
												if(options[iRadio].equals(checkboxvalue)){
													checked = "checked=\"checked\"";
												}
									%>
											<span style="display:inline-block">
												<input type="radio" name="pivarradio[${index}]" value="<%=options[iRadio] %>" onclick="setRadio(${index},this)" <%=checked %>/><%=options[iRadio] %>
											</span>
									<%
											}
										}
									%>
									<html:hidden property="pivarvalue[${index}]" value="${piddefault}"/>
									</logic:equal>
									<logic:equal value="E" name="psid" property="pidtype">
										<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
										<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
										<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
										<%	String checkboxvalue = StringUtils.isEmpty(psid.getPidvalue())?piddefault:psid.getPidvalue();
											String[] options = (String[])optionMap.get(pidid);
											boolean radio_flag = true;
											
											for(int iRadio = 0; iRadio < options.length; iRadio++){
												if(StringUtils.isNotEmpty(options[iRadio])){
													String checked = "";
													if(options[iRadio].equals(checkboxvalue)){
														checked = "checked=\"checked\"";
														radio_flag = false;
													}%>
												<span style="display:inline-block">
													<input type="radio" name="pivarradio[${index}]" value="<%=options[iRadio] %>" onclick="setRadio_other(${index},this)" <%=checked %>/><%=options[iRadio] %>
												</span>
										<%		}
											}
											String checked_other = "";
											String display_other = "";
											if(radio_flag){
												checked_other = "checked=\"checked\"";
											}else{
												display_other = "display: none;";
											}%>
												<input id="pivarradio_Other[${index}]" type="radio" name="pivarradio[${index}]" value="<%=checkboxvalue %>" onclick="setRadio_other(${index},this,'other')" <%=checked_other %>/>其他 
												<html:text style="<%=display_other %>" styleId="pivarvalue_Other[${index}]" property="pivarvalue[${index}]" size="18" errorStyleClass="inputError imeActive"
												  value="<%=checkboxvalue %>" onchange="setOnChage_other(${index},this)" /> 
										<html:hidden property="pivarvalue[${index}]" value="${piddefault}"/>
									</logic:equal>
									<logic:equal value="C" name="psid" property="pidtype">
										<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
										<%
											String checkboxvalue = StringUtils.isEmpty(psid.getPidvalue())?"":psid.getPidvalue();
											String[] boxValues = checkboxvalue.split("#");
											String[] options = (String[])optionMap.get(psid.getPidid());
											for(int iCheckbox = 0; iCheckbox < options.length; iCheckbox++){
												if(StringUtils.isNotEmpty(options[iCheckbox])){
													String checked = "";
													for(int iValue = 0; iValue < boxValues.length; iValue++){
														if(options[iCheckbox].equals(boxValues[iValue])){
															checked = "checked";
														}
													}
										%>
											<span style="display:inline-block">
													<input type="checkbox" name="pivarcheckbox[${index}]" value="<%=options[iCheckbox] %>" onclick="setCheckbox(${index},this)" <%=checked %>/><%=options[iCheckbox] %>
											</span>
										<%
												}
											}
										%>
										<html:hidden property="pivarvalue[${index}]" value="<%=checkboxvalue %>"/>
									</logic:equal>
									<logic:equal value="3" name="psid" property="pidtype">
										<html:text styleId="pidid${pidid}" property="pivarvalue[${index}]" size="32" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" readonly="true"/>
											<img src="images/date.gif" align="middle" onclick="showDate($('pivarvalue[${index}]'))" style="cursor: hand" />
									</logic:equal>
									<logic:equal value="7" name="psid" property="pidtype">
										<html:text styleId="pidid${pidid}" property="pivarvalue[${index}]" size="32" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" readonly="true"/>
										<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('pivarvalue[${index}]'))" border="0" style="cursor: hand"/>
				                       	<a href="javascript:clear($('pivarvalue[${index}]'));">清空</a><br/>
									</logic:equal>
									<logic:equal value="A" name="psid" property="pidtype">
										<html:text styleId="pidid${pidid}" property="pivarvalue[${index}]" size="32" errorStyleClass="inputError imeActive" value="${psid.pidvalue}" readonly="true"/>
										<img src="images/date.gif" align="middle" onclick="showTime($('pivarvalue[${index}]'))" style="cursor: hand" />
									</logic:equal>
									<logic:equal value="R" name="psid" property="pidtype">
										<html:text styleId="pidid${pidid}" property="pivarrolename[${index}]" size="32" errorStyleClass="inputError imeActive" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_role_"))?"":psid.getPidvalue().split("_role_")[1] %>' readonly="true"/>
										<img src="images/seek.gif" alt="查询" onclick="selectRoleOnIGSYM0306(${index},'${psid.pdid}')" style="cursor: hand"/>
										<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
									</logic:equal>
									<logic:equal value="4" name="psid" property="pidtype">
										
										<bean:define id="count" name="IGPRR01021VO" property="processInfolist" type="java.util.List"/>
										<logic:iterate id="info" name="IGPRR01021VO" property="processInfolist"
											type="com.deliverik.framework.workflow.prr.model.IG599Info">
												<%if((psid.getPidlabel().equals(info.getPivarlabel()))
															&& WorkFlowConstDefine.PROCESS_PIVRTYPE.equals(info.getPivartype())){ %>
							
													<logic:present name="IGPRR01021VO" property="processInfoEntityList">
														<logic:iterate id="entity" name="IGPRR01021VO" property="processInfoEntityList"
															 type="com.deliverik.framework.workflow.prd.model.IG731Info">
															<% if(info.getPiid().equals(entity.getPiid())){ %>
																		<a href="javascript:void(0)" onclick="openSubIGCOM0328('<%=entity.getEiid() %>','')" id="<%=entity.getPieid() %>">
																		<%=entity.getSoc0118TB().getEiname() %></a><img id="<%=entity.getPieid() %>ENT" src="images/delate.gif" align="middle" onClick="delEntity('<%=entity.getPieid() %>')" border="0" style="cursor: hand" alt='删除'/>&nbsp;
															<% } %>
														</logic:iterate>
													</logic:present>
												<% }%>
										</logic:iterate>
										<br/>
										<img src="images/addasm.gif" alt='查询' style="cursor: hand"/>
										<a href="javascript:addEntity(${psid.pidid}, ${index},
										<c:if test="${psid.pidrequired == '1' }">'1'</c:if><c:if test="${psid.pidrequired != '1' }">'0'</c:if>
											);" id="aAddEntity">添加资产</a> 
										<br/>
										<table id="tbentity${psid.pidid}">
										</table>
										<html:hidden property="pivarvalue[${index}]" />
									</logic:equal>
									<logic:equal value="5" name="psid" property="pidtype">
										<html:text styleId="pidid${pidid}" property="pivarprname[${index}]" size="32" errorStyleClass="inputError imeActive" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_svc_"))?"":psid.getPidvalue().split("_svc_")[1].split("_name=")[1] %>' readonly="true"/>
										<img src="images/seek.gif" alt="查询" onclick="openSVCPage(${index})" style="cursor: hand"/>
										<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
									</logic:equal>
									<logic:equal value="6" name="psid" property="pidtype">
										<html:text styleId="pidid${pidid}" property="pivarprjname[${index}]" size="32" errorStyleClass="inputError imeActive" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_prj_"))?"":psid.getPidvalue().split("_prj_")[1] %>' readonly="true"/>
										<img src="images/seek.gif" alt="查询" onclick="selectProject(${index})" style="cursor: hand"/>
										<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
									</logic:equal>
									<logic:equal value="T" name="psid" property="pidtype">
										<html:text property="pivartreename[${index}]" size="32" readonly="true" value='<%=(StringUtils.isEmpty(psid.getPidvalue()) || !psid.getPidvalue().contains("_tree_"))?"":psid.getPidvalue().split("_tree_")[1] %>' /> 
										<img src="images/seek.gif" alt='查询' onclick="selectTree(${index},'${psid.ccid}')" style="cursor: hand"/>
										<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
									</logic:equal>
											<logic:equal value="9" name="psid" property="pidtype">
												<html:textarea  styleId="pidid${pidid}" property="pivarvalue[${index}]" errorStyleClass="inputError" rows="5" cols="<%= textAreaSize%>" value=""/>
												<img src="images/attachment.gif" /><a href="javascript:addFileMuti('${psid.pidlabel}')" id="aAddAttachMuti">添加附件</a>&nbsp;&nbsp;&nbsp;
												<table id="${psid.pidlabel}">
												</table>
												<input type="hidden" id="delFileMutiStr" name="delFileMutiStr" value=""/>
												<logic:present name="IGPRR01021VO" property="textAreaMap">
													<logic:notEmpty	name="IGPRR01021VO" property="textAreaMap">
														<bean:define id="a" name="IGPRR01021VO" property="textAreaMap" type="java.util.Map" />
														<logic:iterate id="map" name="IGPRR01021VO"	property="textAreaMap" indexId="number">
															<bean:define id="category" name="map" property="key"/>
															<bean:define id="list" name="map" property="value"	type="java.util.ArrayList" />
															<logic:equal name="map" property="key" value="${psid.pidlabel}">
																<logic:iterate id="attachment" name="list" indexId="number">
																	<a href="downloadSvcFile.do?attId=${attachment.attid}&type=svc" id="${attachment.attid}">
																		<bean:define id="attname" name="attachment" property="attname" />
																		<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
																	</a>
																	<img id="${attachment.attid}IMG" src="images/delate.gif" align="middle" onClick="delFile('${attachment.attid}','${psid.piid}')" border="0" style="cursor: hand" alt="删除"/>
																</logic:iterate>
															</logic:equal>
														</logic:iterate>
													</logic:notEmpty>
												</logic:present>
											</logic:equal>
								<% 	} %>	
							</logic:equal>
							<!-- 为表单增加js事件   -->
								<c:if test="${processLinkageDefList != null && processLinkageDefList[0].initiativepidid==pidid && processLinkageDefList[0].pljtype==1}">									
									<script type="text/javascript">
									
										var obj = document.getElementById('pidid' + "${pidid}");
                                        if (window.attachEvent){
                                            obj.attachEvent("${processLinkageDefList[0].pljsevent}", changeValue(obj)); 
                                        }else{
                                        	obj.addEventListener("${processLinkageDefList[0].pljsevent}".replace("on",""), changeValue(obj)); 
                                        }
										</script>
								</c:if>
								
								<c:if test="${processLinkageDefList != null && processLinkageDefList[0].initiativepidid==pidid && processLinkageDefList[0].pljtype ==2}">									
									<script type="text/javascript">
									
										var obj = document.getElementById('pidid' + "${pidid}");
                                        if (window.attachEvent){
                                            obj.attachEvent("${processLinkageDefList[0].pljsevent}", changeOptions(obj)); 
                                        }else{
                                        	obj.addEventListener("${processLinkageDefList[0].pljsevent}".replace("on",""), changeOptions(obj)); 
                                        }
										</script>
								</c:if>
							<!-- 为表单增加js事件 -->
						</td>
					</logic:equal>
					<logic:equal name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE %>">
						<%=trStartTag %>
							<th>
								<label for="Name"><strong>${psid.pidlabel}</strong>：</label>
							</th>
							<%=tdStartTag %>
							<logic:equal value="<%=IGPRDCONSTANTS.PIDMODE_PUBLIC %>" name="psid" property="pidmode">
								<html:hidden property="pivarvalue[${index}]" value="${psid.pidvalue}"/>
								<c:if test='${psid.pidtype=="0" || psid.pidtype=="2" || psid.pidtype=="3" || psid.pidtype=="7" || psid.pidtype=="A"}'>
									${psid.pidvalue}
								</c:if>
								<logic:equal value="B" name="psid" property="pidtype">
									<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
									<%
										String checkboxvalue = StringUtils.isEmpty(psid.getPidvalue())?psid.getPiddefault():psid.getPidvalue();
										String[] options = (String[])optionMap.get(psid.getPidid());
										for(int iRadio = 0; iRadio < options.length; iRadio++){
											if(StringUtils.isNotEmpty(options[iRadio])){
												String checked = "";
												if(options[iRadio].equals(checkboxvalue)){
													checked = "checked=\"checked\"";
												}
									%>
											<span style="display:inline-block">
												<input type="radio" name="pivarradio[${index}]" value="<%=options[iRadio] %>" onclick="setRadio(${index},this)" <%=checked %> disabled="disabled"/><%=options[iRadio] %>
											</span>
									<%
											}
										}
									%>
								</logic:equal>
								<logic:equal value="E" name="psid" property="pidtype">
									<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
									<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
									<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
									<%	String checkboxvalue = StringUtils.isEmpty(psid.getPidvalue())?piddefault:psid.getPidvalue();
										String[] options = (String[])optionMap.get(pidid);
										boolean radio_flag = true;
										for(int iRadio = 0; iRadio < options.length; iRadio++){
											if(StringUtils.isNotEmpty(options[iRadio])){
												String checked = "";
												if(options[iRadio].equals(checkboxvalue)){
													checked = "checked=\"checked\"";
													radio_flag = false;
												}%>
												<input type="radio" name="pivarradio[${index}]" value="<%=options[iRadio] %>" onclick="setRadio_other(${index},this)" <%=checked %> disabled="disabled" /><%=options[iRadio] %>
									<%		}
										}
										String checked_other = "";
										String display_other = "";
										if(radio_flag){
											checked_other = "checked=\"checked\"";
										}else{
											display_other = "display: none;";
										}%>
										<input id="pivarradio_Other[${index}]" type="radio" name="pivarradio[${index}]" value="<%=checkboxvalue %>" onclick="setRadio_other(${index},this,'other')" <%=checked_other %> disabled="disabled" />其他 
										<html:text  style="<%=display_other %>" styleId="pivarvalue_Other[${index}]" property="pivarvalue[${index}]" size="18" readonly="true" errorStyleClass="inputError imeActive"
								 			value="<%=checkboxvalue %>" styleClass="inputDisable"  onchange="setOnChage_other(${index},this)"/> 
									<html:hidden property="pivarvalue[${index}]" value="${piddefault}"/>
								</logic:equal>
								<logic:equal value="C" name="psid" property="pidtype">
									<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
									<%
										String checkboxvalue = StringUtils.isEmpty(psid.getPidvalue())?"":psid.getPidvalue();
										String[] boxValues = checkboxvalue.split("#");
										String[] options = (String[])optionMap.get(psid.getPidid());
										for(int iCheckbox = 0; iCheckbox < options.length; iCheckbox++){
											if(StringUtils.isNotEmpty(options[iCheckbox])){
												String checked = "";
												for(int iValue = 0; iValue < boxValues.length; iValue++){
													if(options[iCheckbox].equals(boxValues[iValue])){
														checked = "checked";
													}
												}
									%>
										<span style="display:inline-block">
												<input type="checkbox" name="pivarcheckbox[${index}]" value="<%=options[iCheckbox] %>" onclick="setCheckbox(${index},this)" <%=checked %> disabled="disabled"/><%=options[iCheckbox] %>
										</span>
									<%
											}
										}
									%>
								</logic:equal>
								<logic:equal value="R" name="psid" property="pidtype">
									<%if(StringUtils.isNotEmpty(psid.getPidvalue()) && psid.getPidvalue().contains("_role_")){ %>
										<%=psid.getPidvalue().split("_role_")[1] %> 
									<%} %>
								</logic:equal>
								<logic:equal value="4" name="psid" property="pidtype">
									
									<bean:define id="count" name="IGPRR01021VO" property="processInfolist" type="java.util.List"/>
									<logic:iterate id="info" name="IGPRR01021VO" property="processInfolist"
										type="com.deliverik.framework.workflow.prr.model.IG599Info">
											<%if((psid.getPidlabel().equals(info.getPivarlabel()))
														&& WorkFlowConstDefine.PROCESS_PIVRTYPE.equals(info.getPivartype())){ %>
						
												<logic:present name="IGPRR01021VO" property="processInfoEntityList">
													<logic:iterate id="entity" name="IGPRR01021VO" property="processInfoEntityList"
														 type="com.deliverik.framework.workflow.prd.model.IG731Info">
														<%  if(info.getPiid().equals(entity.getPiid())){ %>
																	<a href="javascript:void(0)" onclick="openSubIGCOM0328('<%=entity.getEiid() %>','')" id="<%=entity.getPieid() %>">
																	<%=entity.getSoc0118TB().getEiname() %></a>&nbsp;
														<%  } %>
													</logic:iterate>
												</logic:present>
											<% }%>
									</logic:iterate>
								</logic:equal>
								<logic:equal value="5" name="psid" property="pidtype">
									<%if(StringUtils.isNotEmpty(psid.getPidvalue()) && psid.getPidvalue().contains("_svc_")){ %>
										<%=psid.getPidvalue().split("_svc_")[1].split("_name=")[1] %> 
									<%} %>
								</logic:equal>
								<logic:equal value="6" name="psid" property="pidtype">
									<%if(StringUtils.isNotEmpty(psid.getPidvalue()) && psid.getPidvalue().contains("_prj_")){ %>
										<%=psid.getPidvalue().split("_prj_")[1] %> 
									<%} %>
								</logic:equal>
								<logic:equal value="T" name="psid" property="pidtype">
									<%if(StringUtils.isNotEmpty(psid.getPidvalue()) && psid.getPidvalue().contains("_tree_")){ %>
											<%=psid.getPidvalue().split("_tree_")[1] %> 
									<%} %>
								</logic:equal>
								<logic:equal value="9" name="psid" property="pidtype">
									<pre>${psid.pidvalue}</pre>
									<logic:present name="IGPRR01021VO" property="textAreaMap">
									<logic:notEmpty	name="IGPRR01021VO" property="textAreaMap">
											<bean:define id="a" name="IGPRR01021VO" property="textAreaMap" type="java.util.Map" />
											<logic:iterate id="map" name="IGPRR01021VO"	property="textAreaMap" indexId="number">
											<bean:define id="category" name="map" property="key"/>
											<bean:define id="list" name="map" property="value"	type="java.util.ArrayList" />
											<logic:equal name="map" property="key" value="${psid.pidname}">
												<logic:iterate id="attachment" name="list" indexId="number">
												<br>
													<html:link
														action="downloadSvcFile.do?attId=${attachment.attid}&type=svc">
														<bean:define id="attname" name="attachment" property="attname" />
														<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
													</html:link>
													<br />
												</logic:iterate>
											</logic:equal>
											</logic:iterate>
									</logic:notEmpty>
								</logic:present>
								</logic:equal>
							</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PIDMODE_PRIVATE %>" name="psid" property="pidmode">
								<logic:notEmpty name="psid" property="processPrivateInfoList">
											<logic:iterate id="privateinfoList" name="psid" property="processPrivateInfoList" type="com.deliverik.framework.workflow.prr.model.IG899Info">
											<% 
											if(("0".equalsIgnoreCase(psid.getPrivatescope()) && (roleidprr.equals(privateinfoList.getRoleid()) || 9999 == roleidprr)) || (StringUtils.isNotEmpty(privateinfoList.getUserid()) && "1".equalsIgnoreCase(psid.getPrivatescope()) && useridprr.equalsIgnoreCase(privateinfoList.getUserid()) ))
												{
											%>
												<c:if test='${psid.pidtype=="0" || psid.pidtype=="2" || psid.pidtype=="3" || psid.pidtype=="7" || psid.pidtype=="A"}'>
													${privateinfoList.ppivalue}
												</c:if>
												<logic:equal value="B" name="psid" property="pidtype">
													<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
													<%
														String checkboxvalue = StringUtils.isEmpty(privateinfoList.getPpivalue())?psid.getPiddefault():privateinfoList.getPpivalue();
														String[] options = (String[])optionMap.get(psid.getPidid());
														for(int iRadio = 0; iRadio < options.length; iRadio++){
															if(StringUtils.isNotEmpty(options[iRadio])){
																String checked = "";
																if(options[iRadio].equals(checkboxvalue)){
																	checked = "checked=\"checked\"";
																}
													%>
															<span style="display:inline-block">
																<input type="radio" name="pivarradio[${index}]" value="<%=options[iRadio] %>" onclick="setRadio(${index},this)" <%=checked %> disabled="disabled"/><%=options[iRadio] %>
															</span>
													<%
															}
														}
													%>
												</logic:equal>
												<logic:equal value="E" name="psid" property="pidtype">
													<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
													<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
													<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
													<%	String checkboxvalue = StringUtils.isEmpty(privateinfoList.getPpivalue())?piddefault:privateinfoList.getPpivalue();
														String[] options = (String[])optionMap.get(pidid);
														boolean radio_flag = true;
														for(int iRadio = 0; iRadio < options.length; iRadio++){
															if(StringUtils.isNotEmpty(options[iRadio])){
																String checked = "";
																if(options[iRadio].equals(checkboxvalue)){
																	checked = "checked=\"checked\"";
																	radio_flag = false;
																}%>
																<input type="radio" name="pivarradio[${index}]" value="<%=options[iRadio] %>" onclick="setRadio_other(${index},this)" <%=checked %> disabled="disabled" /><%=options[iRadio] %>
													<%		}
														}
														String checked_other = "";
														String display_other = "";
														if(radio_flag){
															checked_other = "checked=\"checked\"";
														}else{
															display_other = "display: none;";
														}%>
														<input id="pivarradio_Other[${index}]" type="radio" name="pivarradio[${index}]" value="<%=checkboxvalue %>" onclick="setRadio_other(${index},this,'other')" <%=checked_other %> disabled="disabled" />其他 
														<html:text  style="<%=display_other %>" styleId="pivarvalue_Other[${index}]" property="pivarvalue[${index}]" size="18" readonly="true" errorStyleClass="inputError imeActive"
												 			value="<%=checkboxvalue %>" styleClass="inputDisable"  onchange="setOnChage_other(${index},this)"/> 
													<html:hidden property="pivarvalue[${index}]" value="${piddefault}"/>
												</logic:equal>
												<logic:equal value="C" name="psid" property="pidtype">
													<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
													<%
														String checkboxvalue = StringUtils.isEmpty(privateinfoList.getPpivalue())?"":privateinfoList.getPpivalue();
														String[] boxValues = checkboxvalue.split("#");
														String[] options = (String[])optionMap.get(psid.getPidid());
														for(int iCheckbox = 0; iCheckbox < options.length; iCheckbox++){
															if(StringUtils.isNotEmpty(options[iCheckbox])){
																String checked = "";
																for(int iValue = 0; iValue < boxValues.length; iValue++){
																	if(options[iCheckbox].equals(boxValues[iValue])){
																		checked = "checked";
																	}
																}
													%>
														<span style="display:inline-block">
																<input type="checkbox" name="pivarcheckbox[${index}]" value="<%=options[iCheckbox] %>" onclick="setCheckbox(${index},this)" <%=checked %> disabled="disabled"/><%=options[iCheckbox] %>
														</span>
													<%
															}
														}
													%>
												</logic:equal>
												<logic:equal value="R" name="psid" property="pidtype">
													<%if(StringUtils.isNotEmpty(privateinfoList.getPpivalue()) && privateinfoList.getPpivalue().contains("_role_")){ %>
														<%=privateinfoList.getPpivalue().split("_role_")[1] %> 
													<%} %>
												</logic:equal>
												<logic:equal value="4" name="psid" property="pidtype">
									
													<bean:define id="count" name="IGPRR01021VO" property="processInfolist" type="java.util.List"/>
													<logic:iterate id="info" name="IGPRR01021VO" property="processInfolist"
														type="com.deliverik.framework.workflow.prr.model.IG599Info">
															<%if((psid.getPidlabel().equals(info.getPivarlabel()))
																		&& WorkFlowConstDefine.PROCESS_PIVRTYPE.equals(info.getPivartype())){ %>
										
																<logic:present name="IGPRR01021VO" property="processInfoEntityList">
																	<logic:iterate id="entity" name="IGPRR01021VO" property="processInfoEntityList"
																		 type="com.deliverik.framework.workflow.prd.model.IG731Info">
																		<%  if(info.getPiid().equals(entity.getPiid())){ %>
																					<a href="javascript:void(0)" onclick="openSubIGCOM0328('<%=entity.getEiid() %>','')" id="<%=entity.getPieid() %>">
																					<%=entity.getSoc0118TB().getEiname() %></a>&nbsp;
																		<%  } %>
																	</logic:iterate>
																</logic:present>
															<% }%>
													</logic:iterate>
												</logic:equal>
												<logic:equal value="5" name="psid" property="pidtype">
													<%if(StringUtils.isNotEmpty(privateinfoList.getPpivalue()) && privateinfoList.getPpivalue().contains("_svc_")){ %>
														<%=privateinfoList.getPpivalue().split("_svc_")[1].split("_name=")[1] %> 
													<%} %>
												</logic:equal>
												<logic:equal value="6" name="psid" property="pidtype">
													<%if(StringUtils.isNotEmpty(privateinfoList.getPpivalue()) && privateinfoList.getPpivalue().contains("_prj_")){ %>
														<%=privateinfoList.getPpivalue().split("_prj_")[1] %> 
													<%} %>
												</logic:equal>
												<logic:equal value="T" name="psid" property="pidtype">
													<%if(StringUtils.isNotEmpty(privateinfoList.getPpivalue()) && privateinfoList.getPpivalue().contains("_tree_")){ %>
														<%=privateinfoList.getPpivalue().split("_tree_")[1] %> 
													<%} %>
												</logic:equal>
															<logic:equal value="9" name="psid" property="pidtype">
																<pre>${privateinfoList.ppivalue}</pre>
																<logic:present name="IGPRR01021VO" property="textAreaMap">
																<logic:notEmpty	name="IGPRR01021VO" property="textAreaMap">
																		<bean:define id="a" name="IGPRR01021VO" property="textAreaMap" type="java.util.Map" />
																		<logic:iterate id="map" name="IGPRR01021VO"	property="textAreaMap" indexId="number">
																		<bean:define id="category" name="map" property="key" type="java.lang.String"/>
																		<bean:define id="list" name="map" property="value"	type="java.util.ArrayList" />
																		<% 
																			if(("0".equalsIgnoreCase(psid.getPrivatescope()) && category.equalsIgnoreCase(psid.getPidlabel()+"_"+privateinfoList.getRoleid()))
																			|| "1".equalsIgnoreCase(psid.getPrivatescope()) && category.equalsIgnoreCase(psid.getPidlabel()+"_"+privateinfoList.getUserid())){
																		%>
																			<logic:iterate id="attachment" name="list" indexId="number">
																			<br>
																				<html:link
																					action="downloadSvcFile.do?attId=${attachment.attid}&type=svc">
																					<bean:define id="attname" name="attachment" property="attname" />
																					<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
																				</html:link>
																				<br />
																			</logic:iterate>
																		<% } %>
																		</logic:iterate>
																	
																</logic:notEmpty>
															</logic:present>
															</logic:equal>
												<html:hidden property="pivarvalue[${index}]" value="${privateinfoList.ppivalue}"/>
											<% }%>
											</logic:iterate>
								</logic:notEmpty>
								<logic:empty name="psid" property="processPrivateInfoList">
									<html:hidden property="pivarvalue[${index}]" value=""/>
								</logic:empty>
							</logic:equal>
							</td>
					</logic:equal>
					<logic:equal name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL %>">
						<%=trStartTag %>
							<th>
								<label for="Name"><strong>${psid.pidlabel}</strong>：</label>
							</th>
							<%=tdStartTag %>
							<logic:equal value="<%=IGPRDCONSTANTS.PIDMODE_PRIVATE %>" name="psid" property="pidmode">
								<logic:notEmpty name="psid" property="processPrivateInfoList">
											<table width="100%" >
												<% 
													int iRadioNum = 0;
												%>
												<logic:iterate id="privateinfoList" name="psid" property="processPrivateInfoList" type="com.deliverik.framework.workflow.prr.model.IG899Info">
													<tr>
													<%
														iRadioNum++;
													%>
														<td style="border-bottom:none;" width="30%">
															<logic:equal value="<%=IGPRDCONSTANTS.PRIVATESCOPE_ROLE %>" name="psid" property="privatescope">
																${privateinfoList.roleTB.rolename}
															</logic:equal>
															<logic:equal value="<%=IGPRDCONSTANTS.PRIVATESCOPE_USER %>" name="psid" property="privatescope">
																${privateinfoList.roleTB.rolename}(${privateinfoList.userTB.username})
															</logic:equal>
															<c:if test='${(psid.privatescope == "0" && IGPRR01021VO.roleid == privateinfoList.roleid) || (psid.privatescope=="1" && IGPRR01021VO.userid == privateinfoList.userid)}'>
																<html:hidden property="pivarvalue[${index}]" value="${privateinfoList.ppivalue}"/>
															</c:if>
														</td>
														<td style="border-bottom:none;" width="70%">
															<c:if test='${psid.pidtype=="0" || psid.pidtype=="2" || psid.pidtype=="3" || psid.pidtype=="7" || psid.pidtype=="A"}'>
																${privateinfoList.ppivalue}
															</c:if>
															<logic:equal value="B" name="psid" property="pidtype">
																<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
																<%
																	String checkboxvalue = StringUtils.isEmpty(privateinfoList.getPpivalue())?psid.getPiddefault():privateinfoList.getPpivalue();
																	String[] options = (String[])optionMap.get(psid.getPidid());
																	for(int iRadio = 0; iRadio < options.length; iRadio++){
																		if(StringUtils.isNotEmpty(options[iRadio])){
																			String checked = "";
																			if(options[iRadio].equals(checkboxvalue)){
																				checked = "checked=\"checked\"";
																			}
																%>
																		<span style="display:inline-block">
																			<input type="radio" name="pivarradio[<%=iRadioNum %>]" value="<%=options[iRadio] %>" onclick="setRadio(${index},this)" <%=checked %> disabled="disabled"/><%=options[iRadio] %>
																		</span>
																<%
																		}
																	}
																%>
															</logic:equal>
															<logic:equal value="E" name="psid" property="pidtype">
																<bean:define id="pidid" name="psid" property="pidid" type="java.lang.String" />
																<bean:define id="piddefault" name="psid" property="piddefault" type="java.lang.String"/>
																<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
																<%	String checkboxvalue = StringUtils.isEmpty(privateinfoList.getPpivalue())?piddefault:privateinfoList.getPpivalue();
																	String[] options = (String[])optionMap.get(pidid);
																	boolean radio_flag = true;
																	for(int iRadio = 0; iRadio < options.length; iRadio++){
																		if(StringUtils.isNotEmpty(options[iRadio])){
																			String checked = "";
																			if(options[iRadio].equals(checkboxvalue)){
																				checked = "checked=\"checked\"";
																				radio_flag = false;
																			}%>
																			<input type="radio" name="pivarradio[${index}]" value="<%=options[iRadio] %>" onclick="setRadio_other(${index},this)" <%=checked %> disabled="disabled" /><%=options[iRadio] %>
																<%		}
																	}
																	String checked_other = "";
																	String display_other = "";
																	if(radio_flag){
																		checked_other = "checked=\"checked\"";
																	}else{
																		display_other = "display: none;";
																	}%>
																	<input id="pivarradio_Other[${index}]" type="radio" name="pivarradio[${index}]" value="<%=checkboxvalue %>" onclick="setRadio_other(${index},this,'other')" <%=checked_other %> disabled="disabled" />其他 
																	<html:text  style="<%=display_other %>" styleId="pivarvalue_Other[${index}]" property="pivarvalue[${index}]" size="18" readonly="true" errorStyleClass="inputError imeActive"
															 			value="<%=checkboxvalue %>" styleClass="inputDisable"  onchange="setOnChage_other(${index},this)"/> 
																<html:hidden property="pivarvalue[${index}]" value="${piddefault}"/>
															</logic:equal>
															<logic:equal value="C" name="psid" property="pidtype">
																<bean:define id="optionMap" name="IGPRR01021VO" property="optionMap" type="java.util.Map"/>
																<%
																	String checkboxvalue = StringUtils.isEmpty(privateinfoList.getPpivalue())?"":privateinfoList.getPpivalue();
																	String[] boxValues = checkboxvalue.split("#");
																	String[] options = (String[])optionMap.get(psid.getPidid());
																	for(int iCheckbox = 0; iCheckbox < options.length; iCheckbox++){
																		if(StringUtils.isNotEmpty(options[iCheckbox])){
																			String checked = "";
																			for(int iValue = 0; iValue < boxValues.length; iValue++){
																				if(options[iCheckbox].equals(boxValues[iValue])){
																					checked = "checked";
																				}
																			}
																%>
																	<span style="display:inline-block">
																			<input type="checkbox" name="pivarcheckbox[<%=iRadioNum %>]" value="<%=options[iCheckbox] %>" onclick="setCheckbox(${index},this)" <%=checked %> disabled="disabled"/><%=options[iCheckbox] %>
																	</span>
																<%
																		}
																	}
																%>
															</logic:equal>
															<logic:equal value="R" name="psid" property="pidtype">
																<%if(StringUtils.isNotEmpty(privateinfoList.getPpivalue()) && privateinfoList.getPpivalue().contains("_role_")){ %>
																	<%=privateinfoList.getPpivalue().split("_role_")[1] %> 
																<%} %>
															</logic:equal>
															<logic:equal value="4" name="psid" property="pidtype">
									
																<bean:define id="count" name="IGPRR01021VO" property="processInfolist" type="java.util.List"/>
																<logic:iterate id="info" name="IGPRR01021VO" property="processInfolist"
																	type="com.deliverik.framework.workflow.prr.model.IG599Info">
																		<%if((psid.getPidlabel().equals(info.getPivarlabel()))
																					&& WorkFlowConstDefine.PROCESS_PIVRTYPE.equals(info.getPivartype())){ %>
													
																			<logic:present name="IGPRR01021VO" property="processInfoEntityList">
																				<logic:iterate id="entity" name="IGPRR01021VO" property="processInfoEntityList"
																					 type="com.deliverik.framework.workflow.prd.model.IG731Info">
																					<%  if(info.getPiid().equals(entity.getPiid())){ %>
																								<a href="javascript:void(0)" onclick="openSubIGCOM0328('<%=entity.getEiid() %>','')" id="<%=entity.getPieid() %>">
																								<%=entity.getSoc0118TB().getEiname() %></a>&nbsp;
																					<%  } %>
																				</logic:iterate>
																			</logic:present>
																		<% }%>
																</logic:iterate>
															</logic:equal>
															<logic:equal value="5" name="psid" property="pidtype">
																<%if(StringUtils.isNotEmpty(privateinfoList.getPpivalue()) && privateinfoList.getPpivalue().contains("_svc_")){ %>
																	<%=privateinfoList.getPpivalue().split("_svc_")[1].split("_name=")[1] %> 
																<%} %>
															</logic:equal>
															<logic:equal value="6" name="psid" property="pidtype">
																<%if(StringUtils.isNotEmpty(privateinfoList.getPpivalue()) && privateinfoList.getPpivalue().contains("_prj_")){ %>
																	<%=privateinfoList.getPpivalue().split("_prj_")[1] %> 
																<%} %>
															</logic:equal>
															<logic:equal value="T" name="psid" property="pidtype">
																<%if(StringUtils.isNotEmpty(privateinfoList.getPpivalue()) && privateinfoList.getPpivalue().contains("_tree_")){ %>
																		<%=privateinfoList.getPpivalue().split("_tree_")[1] %> 
																<%} %>
															</logic:equal>
															<logic:equal value="9" name="psid" property="pidtype">
																<pre>${privateinfoList.ppivalue}</pre>
																<logic:present name="IGPRR01021VO" property="textAreaMap">
																<logic:notEmpty	name="IGPRR01021VO" property="textAreaMap">
																		<bean:define id="a" name="IGPRR01021VO" property="textAreaMap" type="java.util.Map" />
																		<logic:iterate id="map" name="IGPRR01021VO"	property="textAreaMap" indexId="number">
																		<bean:define id="category" name="map" property="key" type="java.lang.String"/>
																		<bean:define id="list" name="map" property="value"	type="java.util.ArrayList" />
																		<% 
																			if(("0".equalsIgnoreCase(psid.getPrivatescope()) && category.equalsIgnoreCase(psid.getPidlabel()+"_"+privateinfoList.getRoleid()))
																			|| "1".equalsIgnoreCase(psid.getPrivatescope()) && category.equalsIgnoreCase(psid.getPidlabel()+"_"+privateinfoList.getUserid())){
																		%>
																			<logic:iterate id="attachment" name="list" indexId="number">
																			<br>
																				<html:link
																					action="downloadSvcFile.do?attId=${attachment.attid}&type=svc">
																					<bean:define id="attname" name="attachment" property="attname" />
																					<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
																				</html:link>
																				<br />
																			</logic:iterate>
																		<% } %>
																		</logic:iterate>
																</logic:notEmpty>
															</logic:present>
															</logic:equal>
														</td>
													</tr>
												</logic:iterate>
											</table>
								</logic:notEmpty>
								<logic:empty name="psid" property="processPrivateInfoList">
									<html:hidden property="pivarvalue[${index}]" value=""/>
								</logic:empty>
							</logic:equal>
							</td>
					</logic:equal>
					<logic:notEqual name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>">
						<logic:notEqual name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE %>">
							<input type="hidden" name="pivarvalue[${index}]" value="${psid.pidvalue}" /> 
						</logic:notEqual>
					</logic:notEqual>
					<html:hidden property="pivarname" value="${psid.pidname}" /> 
					<html:hidden property="pivarlabel" value="${psid.pidlabel}" /> 
					<html:hidden property="pivartype" value="${psid.pidtype}" /> 
					<html:hidden property="pidid" value="${psid.pidid}" />
					<html:hidden property="pidaccess" value="${psid.pidaccess}" />
					<html:hidden property="piid" value="${psid.piid}" />
					<html:hidden property="pidmode" value="${psid.pidmode}" />
					<html:hidden property="privatescope" value="${psid.privatescope}" />

				</logic:present>
			</logic:iterate>
			<% 
			if(StringUtils.isEmpty(lastrowwidth)){
			}
			if("0".equalsIgnoreCase(lastrowwidth)){
				trEndTag = "</tr>";
			}
			if("1".equalsIgnoreCase(lastrowwidth)){
				if(columnNum == 0){
					trEndTag = "</tr>";
				}else{
					trEndTag = "<td></td><td></td></tr>";
				}
			}
			%>
			<%=trEndTag%>
		</table>
		</div>
	</logic:present>
	</logic:equal>
	</logic:present>
	</div>
	
	<!-- 相关流程Include页，可显示相关流程的更多信息 -->
	<bean:define id="relevantProcessJsp" name="IGPRR01021VO" property="relevantProcessJsp" type="java.lang.String" />
	<jsp:include page="${relevantProcessJsp}"/>
	
<%-- 	<logic:notEqual name="disp" value="none"> --%>
	<logic:present name="IGPRR01021VO">
	<logic:notEqual value="C" name="IGPRR01021VO" property="status">
	<div class="title">
	<div class="name">处理记录</div>
	</div>
	<div class="record_list" style="width:98%">
	<fieldset>
		<div>
		<html:textarea property="rlcomment" cols="60" errorStyleClass="inputError imeActive" rows="6"></html:textarea> <br />
		</div>
		<div><img src="images/attachment.gif" />
		<a href="javascript:addFile();" id="aAddAttach">添加附件</a>&nbsp;&nbsp;&nbsp;
		<table id="tb">
		</table>
		</div>
	</fieldset>
		</div>
	</logic:notEqual>
	</logic:present>
<%-- 	</logic:notEqual> --%>
	<div id="formwrapper">
	<div class="enter">
	 
	<logic:notEqual value="C" name="IGPRR01021VO" property="status">
	<div class="action">
		<img src="images/gengxin.gif" width="16" height="16" />
		<a href="javascript:checkForm('<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>')">更新</a>
	</div>
	</logic:notEqual>
	 
	<logic:present name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo"><!--
		<div class="action">
			<img src="images/gengxin.gif" width="16" height="16" />
			<a href="javascript:checkForm('<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>')">更新</a>
		</div>
		--><logic:iterate id="bean" name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
		  <c:if test="${bean.vbid != '05' && bean.vbid != '06'}">
			<div class="action"><img src="images/${bean.vbimage}" width="16" height="16" />
				<a title='${bean.vbdesc}' id ="button${bean.vbid}" href="javascript:checkForm('${bean.vbid}','${bean.vbid}','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>')">${bean.vbname}</a>
			</div>
		  </c:if>
		  <c:if test="${bean.vbid == '05'}">
		    <div class="action"><img src="images/${bean.vbimage}" width="16" height="16" />
              <logic:equal name="IGPRR01021VO" property="isMoreRelevantProcess" value="1">
                  <a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###" 
                onclick="showChooseProcessPage('${IGPRR01021VO.process.prid}','${IGPRR01021VO.process.prtype}','${IGPRR0102Form.pdid}','${IGPRR0102Form.psdid}','${IGPRR01021VO.roleid}','','IGPRR0102_Disp.do?prid=${IGPRR01021VO.process.prid}')">${bean.vbname}</a>
              </logic:equal>
              <logic:notEqual name="IGPRR01021VO" property="isMoreRelevantProcess" value="1">
                  <a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###" 
                onclick="showInitProcessPage('${IGPRR01021VO.process.prid}','${IGPRR01021VO.relevantPdid}','','IGPRR0102_Disp.do?prid=${IGPRR01021VO.process.prid}')">${bean.vbname}</a>
              </logic:notEqual>
            </div>
		  </c:if>
		  <c:if test="${bean.vbid == '06'}">
		    <div class="action"><img src="images/${bean.vbimage}" width="16" height="16" />
              <a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###" 
              onclick="javascript:openSubIGKGM0206Parm('selectDisp=0&prid=${IGSVC0206Form.prid}');">${bean.vbname}</a>
            </div>
		  </c:if>
		</logic:iterate>
		<div class="action">
			<img src="images/chongzhi.gif" width="16" height="16" /><a href="javascript:resetForm()">重置</a>
		</div>
	</logic:present>
	<logic:present name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
		<logic:present name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
			<logic:equal name="IGPRR01021VO" property="isRoleManager" value="true">
			<logic:equal name="IGPRR01021VO" property="showExecutor" value="true">
				<div class="action">
					<img src="images/fp.gif" width="16"
						height="16" />
					<a href="javascript:roleManager('${IGPRR01021VO.process.prid}','<%=IGPRR01BLType.PROCESS_PEOPLE%>');">执行人</a>&nbsp;&nbsp;
				</div>
			</logic:equal>
			</logic:equal>
		</logic:present>	
		<logic:present name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
		<c:if test="${IGPRR01021VO.isRoleManager == 'true' && IGPRR01021VO.processStatusDef.psdmode == '2' && IGPRR01021VO.hasDutyPerson}">
			<div class="action">
				<img src="images/qsgz.gif" width="16"
					height="16" />
				<a href="###" onclick="grantDutyPerson('${IGPRR01021VO.process.prid}');">授权提交</a>&nbsp;&nbsp;
			</div>
		</c:if>
		</logic:present>	
		<logic:present name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
		<c:if test="${IGPRR01021VO.dutyPerson && IGPRR01021VO.processStatusDef.psdmode == '2'}">
			<div class="action">
				<img src="images/qsgz.gif" width="16"
					height="16" />
				<a href="###" onclick="noticeRoleManager('${IGPRR01021VO.process.prid}');">通知</a>&nbsp;&nbsp;
			</div>
		</c:if>
		</logic:present>	
	</logic:present>
	<logic:present name="IGPRR01021VO" property="superFlag">
		<logic:equal name="IGPRR01021VO" property="superFlag" value="1">
		<logic:equal name="IGPRR01021VO" property="isRoleManager" value="true">
			<div class="action">
				<img src="images/fp.gif" width="16"
					height="16" />
				<a href="javascript:assignNormal('${IGPRR01021VO.process.prid}', '${IGPRR01021VO.process.prstatus}', '${IGPRR01021VO.processStatusDef.psdid}', 'super');">分派</a>&nbsp;&nbsp;
			</div>
		</logic:equal>
		</logic:equal>
		<logic:equal name="IGPRR01021VO" property="superFlag" value="2">
		<logic:equal name="IGPRR01021VO" property="isRoleManager" value="true">
			<div class="action">
				<img src="images/fp.gif" width="16"
					height="16" />
				<a href="javascript:assignOA('${IGPRR01021VO.process.prid}', '${IGPRR01021VO.process.prstatus}', '${IGPRR01021VO.processStatusDef.psdid}', 'super');">分派</a>&nbsp;&nbsp;
			</div>
		</logic:equal>
		</logic:equal>
	</logic:present>
	<logic:notEqual value="C" name="IGPRR01021VO" property="status">
		<logic:present name="IGPRR01021VO" property="isAdmin">
			<logic:equal name="IGPRR01021VO" property="isAdmin" value="true">
				<div class="action"><img src="images/zz.gif" width="16" height="16" />
					<a href="javascript:checkForm('','<%=IGPRDCONSTANTS.BUTTON_TERMINATE%>')">中止</a>
				</div>
<!-- 				<div class="action"><img src="images/fp.gif" width="16" height="16" /> -->
<%-- 					<a href="javascript:assignNormal('${IGPRR01021VO.process.prid}', '${IGPRR01021VO.process.prstatus}', '${IGPRR01021VO.processStatusDef.psdid}');">角色调整</a>&nbsp;&nbsp; --%>
<!-- 				</div> -->
				<div class="action"><img src="images/fp.gif" width="16" height="16" />
					<a href="javascript:assignOA('${IGPRR01021VO.process.prid}', '${IGPRR01021VO.process.prstatus}', '${IGPRR01021VO.processStatusDef.psdid}');">分派者</a>&nbsp;&nbsp;
				</div>
			</logic:equal>
		</logic:present>
	</logic:notEqual>
	<logic:equal value="<%=IGPRDCONSTANTS.PROCESS_START_STATUS%>" name="IGPRR01021VO" property="status">
		<logic:present name="IGPRR01021VO" property="isInitiator">
			<logic:equal name="IGPRR01021VO" property="isInitiator" value="1">
				<div class="action"><img src="images/zz.gif" width="16" height="16" />
					<a href="javascript:checkForm('','<%=IGPRDCONSTANTS.BUTTON_TERMINATE%>')">中止</a>
				</div>
			</logic:equal>
		</logic:present>
	</logic:equal>
	</div>
	<div class="Placeholder"></div>
	</div>
	<html:hidden property="pdid" styleId="pdid" name="IGPRR0102Form" />
	<html:hidden property="prid" styleId="prid" name="IGPRR0102Form" />
	<html:hidden property="psdid" styleId="psdid" name="IGPRR0102Form" />
	<html:hidden property="action" styleId="action" name="IGPRR0102Form" />
	<html:hidden property="isInit" styleId="isInit" name="IGPRR0102Form" />
	<html:hidden property="pts" styleId="pts" name="IGPRR0102Form" />
	<html:hidden property="log_type" styleId="log_type" name="IGPRR0102Form" />
	<html:hidden property="tempRoleManager" styleId="tempRoleManager" name="IGPRR0102Form" />
	<html:hidden property="people_code" styleId="people_code" name="IGPRR0102Form" />
	<html:hidden property="psdmode_code" styleId="psdmode_code" name="IGPRR0102Form" />
	<html:hidden property="pieids" value=""/>
	<html:hidden property="roleid" styleId="roleid" name="IGPRR0102Form" />
</html:form></div>
</div>
</div>
</div>
<!-- <!-- <script> -->
<!-- loadFromXML(); -->
<!-- <!-- </script> -->
</body>
</html>
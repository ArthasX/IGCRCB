<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%@ page import="com.deliverik.infogovernor.prd.vo.IGPRD01041VO"%>
<%@ page import="com.deliverik.framework.utility.ResourceUtility"%>
<html xmlns:v="urn:schemas-microsoft-com:vml">
<bean:define id="id" value="IGPRD0104" toScope="request" />
<bean:define id="title" value="状态列表" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link rel="stylesheet" href="<html:rewrite forward='pdimgstyle.css'/>" type="text/css">
<script type="text/javascript" src="flex/swfobject.js"></script>
<script>
var tempPdid = '<%=request.getAttribute("pdid")%>';
var isUse = <%=request.getAttribute("isInUse")%>;
showMenu = "0";
</script>
<script src="<html:rewrite forward='context.js'/>"></script>
<script src="<html:rewrite forward='webflow.js'/>"
	type="text/javascript" charset="gbk"></script>
<script src="<html:rewrite forward='function.js'/>"></script>
<script src="<html:rewrite forward='shiftlang.js'/>"></script>
<script src="<html:rewrite forward='movestep.js'/>"></script>
<script type="text/javascript"><!--	
	function ope(temp,psdid){
		if(temp=="create"){
			IGPRD0104Form.action=getAppRootUrl() + "/IGPRD0105_Disp.do?ppsdid="+'<%=request.getAttribute("ppsdid")%>';
			IGPRD0104Form.submit();
		}else if(temp=="del"){

			if(window.confirm("您确定要删除该条记录吗？")){
				IGPRD0104Form.action=getAppRootUrl() + "/IGPRD0104_DEL.do?psdid="+psdid+"&ppsdid="+'<%=request.getAttribute("ppsdid")%>';
				IGPRD0104Form.submit();
			}
		}else if(temp=="saveImg"){

			if(window.confirm("您确定要保存流程图吗？")){
				var xml = getXML();
				IGPRD0104Form.pdxml.value = xml;
				IGPRD0104Form.action=getAppRootUrl() + "/IGPRD0104_SAVEXML.do?pdid="+'<%=request.getAttribute("pdid")%>'+"&ppsdid="+'<%=request.getAttribute("ppsdid")%>';
				IGPRD0104Form.submit();
			}
		}
	}
	function getXML(){
		return jQuery("#flashContent")[0].getXML();
	}
	function goToPRE(pdid,psdid){
		IGPRD0104Form.action=getAppRootUrl() + "/IGPRD0106_Disp.do?pdid="+pdid+"&psdid="+psdid;
		IGPRD0104Form.submit();
	}

	function goToPP(pdid,psdid){
		IGPRD0104Form.action=getAppRootUrl() + "/IGPRD0107_Disp.do?pdid="+pdid+"&psdid="+psdid;
		IGPRD0104Form.submit();
	}

	function goToRULE(pdid,psdid){
		IGPRD0104Form.action=getAppRootUrl() + "/IGPRD0109_Disp.do?pdid="+pdid+"&fpsdid="+psdid;
		IGPRD0104Form.submit();
	}

	function doDel(psdid){
		if(window.confirm("您确定要删除该条记录吗？")){
			IGPRD0104Form.action=getAppRootUrl() + "/IGPRD0104_DEL.do?psdid="+psdid+"&ppsdid="+'<%=request.getAttribute("ppsdid")%>';
			IGPRD0104Form.submit();
		}
	}

	function goToADD(){
		IGPRD0104Form.action=getAppRootUrl() + "/IGPRD0105_Disp.do?ppsdid="+'<%=request.getAttribute("ppsdid")%>';
		IGPRD0104Form.submit();
	}

	function goToSAVE(){
		if(window.confirm("您确定要保存流程图吗？")){
			alert(document.all.FlowXML.value);
			IGPRD0104Form.pdxml.value = document.all.FlowXML.value;
			IGPRD0104Form.action=getAppRootUrl() + "/IGPRD0104_SAVEXML.do?pdid="+'<%=request.getAttribute("pdid")%>'+"&ppsdid="+'<%=request.getAttribute("ppsdid")%>';
			IGPRD0104Form.submit();
		}
	}	
	
	function initFlowChart(){
		var xml = document.getElementById("FlowXML").value;
		return xml;
	}
	function initFlowChartWidth(){
		return 0;
	}
	function initFlowChartHeight(){
		return 0;
	}
	function initFlowChartCanMove(){
		return true;
	}
	
	var swfVersionStr = "11.1.0";
	var xiSwfUrlStr = "playerProductInstall.swf";
	var flashvars = {};
	var params = {};
	params.quality = "high";
	params.bgcolor = "#ffffff";
	params.allowscriptaccess = "sameDomain";
	params.allowfullscreen = "true";
	var attributes = {};
	params.wmode = "opaque";
	attributes.id = "flashContent";
	attributes.name = "flashContent";
	attributes.align = "middle";
	swfobject.embedSWF("flex/FlowChart.swf", "flashContent", "100%", "100%", swfVersionStr, xiSwfUrlStr,flashvars, params, attributes);
	swfobject.createCSS("#flashContent", "display:block;text-align:left;");
	
	
	
//-->
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGPRD0104" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation /> &gt;&gt; 状态列表</p>
	<div class="back"><a href="${backUrl}" target="_self">返回</a></div>
	</div>
	<div id="results_list"><ig:message /> <input TYPE="hidden"
		name="pdxml" /> <input type="hidden" value="${IGPRD01041VO.imgxml}" id="FlowXML"/>
	<table class="table_style">
		<tr>
			<th width="3%">序号</th>
			<th width="9%">状态名称</th>
			<th width="10%">状态说明</th>
			<th width="6%">状态类型</th>
			<th width="6%">状态模式</th>
			<th width="6%">可被分派</th>
			<th width="7%">子流程</th>
			<th width="5%">参与者</th>
			<th width="3%">规则</th>
			<th width="6%">缺省权限</th>
			<th width="6%">缺省规则</th>
			<th width="9%">可调整参与者</th>
			<th width="7%">表单初始化</th>
			<th width="6%">前后处理</th>
			<th width="6%">按钮事件</th>
			<th width="3%">删除</th>
		</tr>
		<logic:present name="IGPRD01041VO" property="processStatusDefList">
			<logic:iterate id="bean" name="IGPRD01041VO"
				property="processStatusDefList" indexId="index">
				<tr>
					<td>${index+1}</td>
					<td>
						<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_START_STATUS %>">
							<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
								<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_SUBSTATUS %>">
									<html:link action="/IGPRD0105_Edit_Disp.do?psdid=${bean.psdid}&mode=1">
										<logic:empty name="bean" property="psdname">&nbsp;</logic:empty>
										${bean.psdname}
									</html:link>
								</logic:notEqual>
							</logic:notEqual>
						</logic:notEqual>
						<logic:equal name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_START_STATUS %>">
							<html:link action="/IGPRD0105_Z_Disp.do?psdid=${bean.psdid}&mode=1">
								<logic:empty name="bean" property="psdname">&nbsp;</logic:empty>
									${bean.psdname}
							</html:link>
						</logic:equal>
						<logic:equal name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
							<logic:empty name="bean" property="psdname">&nbsp;</logic:empty>
							${bean.psdname}
						</logic:equal>
						<logic:equal name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_SUBSTATUS %>">
							<logic:empty name="bean" property="psdname">&nbsp;</logic:empty>
							${bean.psdname}
						</logic:equal>
					</td>
					<td><logic:empty name="bean" property="psddesc">&nbsp;</logic:empty>${bean.psddesc}</td>
					<td><ig:codeValue ccid="PROCESS_NODE_TYPE_CODE" cid="${bean.psdtype}" /></td>
					<td><ig:codeValue ccid="PROCESS_NODE_MODE_CODE" cid="${bean.psdmode}" /></td>
					<td>
						<c:if test="${bean.psdflag == '1'}">
							<c:if test="${bean.psdassign == '2'}">
							<html:link action="/IGPRD0143_Disp.do?pdid=${bean.pdid}&psdid=${bean.psdid}&ppsdid=${bean.ppsdid}" title="配置指定机构">
							是
							</html:link>
							</c:if>
							<c:if test="${bean.psdassign != '2'}">
							<html:link action="/IGPRD0139_Disp.do?pdid=${bean.pdid}&psdid=${bean.psdid}&ppsdid=${bean.ppsdid}" title="配置指定人员或角色">
							是
							</html:link>
							</c:if>
							
						</c:if>
						<c:if test="${bean.psdflag == '0'}">
							否
						</c:if>
					</td>
					<td>
						<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
							<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_SUBSTATUS %>">
								<c:if test="${bean.psdtype == '6' or bean.psdtype == '4'}">
								<html:link action="/IGPRD0104.do?pdid=${bean.pdid}&ppsdid=${bean.psdid}"><img
									src="images/list.gif" width="16" height="16" border="0" alt="子流程状态列表" />
								</html:link>
								</c:if>
							</logic:notEqual>
						</logic:notEqual>
					</td>
					<td>
					<c:if test="${bean.psdtype != '6'}">
						<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
						<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_SUBSTATUS %>">
							<logic:equal value="2" name="bean" property="psdassign">
								<html:link action="/IGPRD0134_Disp.do?pdid=${bean.pdid}&psdid=${bean.psdid}&ppsdid=${bean.ppsdid}">
									<img src="images/participants.gif" width="16" height="16" border="0" alt="参与者(机构)" />
								</html:link>
							</logic:equal>
							<logic:notEqual value="2" name="bean" property="psdassign">
								<html:link action="/IGPRD0107_Disp.do?pdid=${bean.pdid}&psdid=${bean.psdid}&ppsdid=${bean.ppsdid}">
									<img src="images/participants.gif" width="16" height="16" border="0" alt="参与者" />
								</html:link>
							</logic:notEqual>
						</logic:notEqual>
						</logic:notEqual>
					</c:if>
					</td>
					<c:if test="${bean.psdtype != '2' and bean.psdtype != '6'}">
					<td><logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
						<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_SUBSTATUS %>">
						<html:link action="/IGPRD0109_Disp.do?pdid=${bean.pdid}&fpsdid=${bean.psdid}&ppsdid=${bean.ppsdid}&viewhistory=0"><img src="images/rules.gif" width="16" height="16" border="0" alt="规则" /></html:link>
						</logic:notEqual>
						</logic:notEqual></td>
					</c:if>
					<c:if test="${bean.psdtype == '2' or bean.psdtype == '6'}">
					<td></td>
					</c:if>
					<td><c:if test="${bean.psdtype != '6'}">
					<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
					<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_SUBSTATUS %>">
					<html:link action="/IGPRD0116_Disp.do?pdid=${bean.pdid}&psdid=${bean.psdid}&ppsdid=${bean.ppsdid}&viewhistory=0"><img src="images/sqcd.gif" width="16" height="16" border="0" alt="缺省权限" /></html:link>
					</logic:notEqual>
					</logic:notEqual></c:if></td>
					<td>
						<c:if test="${bean.psdtype != '2'}">
							<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
							<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_SUBSTATUS %>">
								<html:link action="/IGPRD0109_Disp.do?pdid=${bean.pdid}&fpsdid=${bean.psdid}&ppsdid=${bean.ppsdid}&flag=1&viewhistory=0">
									<img src="images/qsgz.gif" width="16" height="16" border="0" alt="缺省规则" />
								</html:link>
							</logic:notEqual>
							</logic:notEqual>
						</c:if>
						<c:if test="${bean.psdtype == '2'}">
							<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
							<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_SUBSTATUS %>">
								<html:link action="/IGPRD0115_Disp.do?pdid=${bean.pdid}&fpsdid=${bean.psdid}&ppsdid=${bean.ppsdid}&flag=1&viewhistory=0">
									<img src="images/qsgz.gif" width="16" height="16" border="0" alt="缺省规则" />
								</html:link>
							</logic:notEqual>
							</logic:notEqual>
						</c:if>
					</td>
					<td>
						<c:if test="${bean.participantchange == '1'}">
							<html:link action="/IGPRD0142_Disp.do?pdid=${bean.pdid}&psdid=${bean.psdid}&ppsdid=${bean.ppsdid}&viewhistory=0">
							<img src="images/work.gif" width="16" height="16" border="0" alt="可调整参与者" />
							</html:link>
						</c:if>
					</td>
					<c:if test="${bean.psdtype != '6'}">
					<td>
						<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
						<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_SUBSTATUS %>">
							<html:link action="/IGPRD0165_Disp.do?pdid=${bean.pdid}&psdid=${bean.psdid}&ppsdid=${bean.ppsdid}"><img src="images/apply.gif" width="16" height="16" border="0" alt="表单初始化配置" /></html:link>
						</logic:notEqual>
						</logic:notEqual>
					</td>
					<td><html:link action="/IGPRD0126_List.do?pdid=${bean.pdid}&psdid=${bean.psdid}&ppsdid=${bean.ppsdid}"><img src="images/qhcl.gif" width="16" height="16" border="0" alt="前后处理配置（${bean.psdname}）" /></html:link></td>
					<td>
						<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
						<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_SUBSTATUS %>">
							<html:link action="/IGPRD0141_List.do?pdid=${bean.pdid}&psdid=${bean.psdid}&psdcode=${bean.psdcode}&ppsdid=${bean.ppsdid}"><img src="images/zichan2.gif" width="16" height="16" border="0" alt="按钮事件配置" /></html:link>
						</logic:notEqual>
						</logic:notEqual>
					</td>
					</c:if>
					<c:if test="${bean.psdtype == '6'}"><td/><td/><td/></c:if>
					<td><%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
					<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
					<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_START_STATUS %>">
					<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_SUBSTATUS %>">
					<a href="javascript:ope('del','${bean.psdid}');"><img src="images/delete.gif" width="16" height="16" border="0" alt="删除" /></a>
					</logic:notEqual>
					</logic:notEqual>
					</logic:notEqual>
					<%} %></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter">
	<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
	<input name="add" type="button" class="button" value="增加" onclick="ope('create');" /> 
	<%} %>	
	<input name="add1"
		type="button" class="button" value="保存流程图" onclick="ope('saveImg');" />
	</div>
	<div id="flashContent">
	</div>
	<html:hidden name="IGPRD0104Form" property="pdid" />
	<html:hidden name="IGPRD0104Form" property="ppsdid" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html>

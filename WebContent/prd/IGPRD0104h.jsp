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
<%
	String contextPath = request.getContextPath();
	String default_panel_width = ResourceUtility
			.getString("DEFAULT_PANEL_WIDTH") == null
			? "2000"
			: ResourceUtility.getString("DEFAULT_PANEL_WIDTH");//画板默认宽度（2000）
	String default_panel_height = ResourceUtility
			.getString("DEFAULT_PANEL_HEIGHT") == null
			? "2000"
			: ResourceUtility.getString("DEFAULT_PANEL_HEIGHT");//画板默认高度（2000）
%>
<html xmlns:v="urn:schemas-microsoft-com:vml">
<bean:define id="id" value="IGPRD0104h" toScope="request" />
<bean:define id="title" value="状态列表" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link rel="stylesheet" href="<html:rewrite forward='pdimgstyle.css'/>"
	type="text/css">
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
			IGPRD0104Form.action=getAppRootUrl() + "/IGPRD0105_Disp.do";
			IGPRD0104Form.submit();
		}else if(temp=="del"){

			if(window.confirm("您确定要删除该条记录吗？")){
				IGPRD0104Form.action=getAppRootUrl() + "/IGPRD0104_DEL.do?psdid="+psdid;
				IGPRD0104Form.submit();
			}
		}else if(temp=="saveImg"){

			if(window.confirm("您确定要保存流程图吗？")){
				IGPRD0104Form.pdxml.value = document.all.FlowXML.value;
				IGPRD0104Form.action=getAppRootUrl() + "/IGPRD0104_SAVEXML.do?pdid="+'<%=request.getAttribute("pdid")%>';
				IGPRD0104Form.submit();
			}
		}
	}


	function loadFromXML(){
		var xmlStr=document.all.FlowXML.value;
		  if(xmlStr!=null&&xmlStr!=''&&xmlStr!='null'){
		  var xmlDoc = new ActiveXObject('MSXML2.DOMDocument');
			 xmlDoc.async = false;
			 xmlDoc.loadXML(xmlStr);
			 var xmlRoot = xmlDoc.documentElement; 
			 document.all.FlowXML.value = xmlRoot.xml;

		 }
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
			IGPRD0104Form.action=getAppRootUrl() + "/IGPRD0104_DEL.do?psdid="+psdid;
			IGPRD0104Form.submit();
		}
	}

	function goToADD(){
		IGPRD0104Form.action=getAppRootUrl() + "/IGPRD0105_Disp.do";
		IGPRD0104Form.submit();
	}

	function goToSAVE(){
		if(window.confirm("您确定要保存流程图吗？")){
			IGPRD0104Form.pdxml.value = document.all.FlowXML.value;
			IGPRD0104Form.action=getAppRootUrl() + "/IGPRD0104_SAVEXML.do?pdid="+'<%=request.getAttribute("pdid")%>';
			IGPRD0104Form.submit();
		}
	}		
	
//-->
</script>
<STYLE>
v\: * {
	Behavior: url(#default#VML)
}
</STYLE>
<body
	oncontextmenu="cleancontextMenu();return false;" scroll="auto">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGPRD0104" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation /> &gt;&gt; 历史版本 &gt;&gt; 状态列表</p>
	<div class="back"><a href="IGPRD0140_Back.do?pdid=${IGPRD0104Form.pdid}" target="_self">返回</a></div>
	</div>
	<div id="results_list"><ig:message /> <input TYPE="hidden"
		name="pdxml" /> <INPUT TYPE="hidden" value="${IGPRD01041VO.imgxml}"
		name=FlowXML onpropertychange='if(AUTODRAW) redrawVML();'>
	<table class="table_style">
		<tr>
			<th width="4%">序号</th>
			<th width="10%">状态名称</th>
			<th width="10%">状态说明</th>
			<th width="6%">状态类型</th>
			<th width="6%">状态模式</th>
			<th width="6%">可被分派</th>
			<th width="5%">参与者</th>
			<th width="4%">规则</th>
			<th width="6%">缺省权限</th>
			<th width="6%">缺省规则</th>
			<th width="8%">可调整参与者</th>
			<th width="10%">表单初始化配置</th>
			<th width="8%">前后处理配置</th>
			<th width="8%">按钮事件配置</th>
		</tr>
		<logic:present name="IGPRD01041VO" property="processStatusDefList">
			<logic:iterate id="bean" name="IGPRD01041VO"
				property="processStatusDefList" indexId="index">
				<tr>
					<td>${index+1}</td>
					<td>
						<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_START_STATUS %>">
							<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
								<html:link action="/IGPRD0105_Edit_Disp.do?psdid=${bean.psdid}&mode=1&viewhistory=1">
									<logic:empty name="bean" property="psdname">&nbsp;</logic:empty>
									${bean.psdname}
								</html:link>
							</logic:notEqual>
						</logic:notEqual>
						<logic:equal name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_START_STATUS %>">
							<logic:empty name="bean" property="psdname">&nbsp;</logic:empty>
							${bean.psdname}
						</logic:equal>
						<logic:equal name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
							<logic:empty name="bean" property="psdname">&nbsp;</logic:empty>
							${bean.psdname}
						</logic:equal>
					</td>
					<td><logic:empty name="bean" property="psddesc">&nbsp;</logic:empty>${bean.psddesc}</td>
					<td><ig:codeValue ccid="PROCESS_NODE_TYPE_CODE" cid="${bean.psdtype}" /></td>
					<td><ig:codeValue ccid="PROCESS_NODE_MODE_CODE" cid="${bean.psdmode}" /></td>
					<td>
						<logic:equal name="bean" property="psdflag" value="1">
						<c:if test="${bean.psdassign == '2'}">
							<html:link action="/IGPRD0143_Disp.do?pdid=${bean.pdid}&psdid=${bean.psdid}&viewhistory=1" title="配置指定机构">
							是
							</html:link>
						</c:if>
						<c:if test="${bean.psdassign != '2'}">
							<html:link action="/IGPRD0139_Disp.do?pdid=${bean.pdid}&psdid=${bean.psdid}&viewhistory=1">
							是
							</html:link>
						</c:if>
						</logic:equal>
						<logic:equal name="bean" property="psdflag" value="0">
							否
						</logic:equal>
					</td>
					<td>
						<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
							<logic:equal value="2" name="bean" property="psdassign">
								<html:link action="/IGPRD0134_Disp.do?pdid=${bean.pdid}&psdid=${bean.psdid}&viewhistory=1">
									<img src="images/participants.gif" width="16" height="16" border="0" alt="参与者(机构)" />
								</html:link>
							</logic:equal>
							<logic:notEqual value="2" name="bean" property="psdassign">
								<html:link action="/IGPRD0107_Disp.do?pdid=${bean.pdid}&psdid=${bean.psdid}&viewhistory=1">
									<img src="images/participants.gif" width="16" height="16" border="0" alt="参与者" />
								</html:link>
							</logic:notEqual>
						</logic:notEqual>
					</td>
					<logic:notEqual name="bean" property="psdtype" value="2">
					<td><logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>"><html:link action="/IGPRD0109_Disp.do?pdid=${bean.pdid}&fpsdid=${bean.psdid}&viewhistory=1"><img src="images/rules.gif" width="16" height="16" border="0" alt="规则" /></html:link></logic:notEqual></td>
					</logic:notEqual>
					<logic:equal name="bean" property="psdtype" value="2">
					<td></td>
					</logic:equal>
					<td><logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>"><html:link action="/IGPRD0116_Disp.do?pdid=${bean.pdid}&psdid=${bean.psdid}&viewhistory=1"><img src="images/sqcd.gif" width="16" height="16" border="0" alt="缺省权限" /></html:link></logic:notEqual></td>
					<td>
						<logic:notEqual name="bean" property="psdtype" value="2">
							<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
								<html:link action="/IGPRD0109_Disp.do?pdid=${bean.pdid}&fpsdid=${bean.psdid}&flag=1&viewhistory=1">
									<img src="images/qsgz.gif" width="16" height="16" border="0" alt="缺省规则" />
								</html:link>
							</logic:notEqual>
						</logic:notEqual>
						<logic:equal name="bean" property="psdtype" value="2">
							<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
								<html:link action="/IGPRD0115_Disp.do?pdid=${bean.pdid}&fpsdid=${bean.psdid}&flag=1">
									<img src="images/qsgz.gif" width="16" height="16" border="0" alt="缺省规则" />
								</html:link>
							</logic:notEqual>
						</logic:equal>
				    </td>
					
					
					<td>
						<logic:equal name="bean" property="participantchange" value="1">
							<html:link action="/IGPRD0142_Disp.do?pdid=${bean.pdid}&psdid=${bean.psdid}&viewhistory=1">
							<img src="images/work.gif" width="16" height="16" border="0" alt="可调整参与者" />
							</html:link>
						</logic:equal>
					</td>
					<td>
						<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
							<html:link action="/IGPRD0165_Disp.do?pdid=${bean.pdid}&psdid=${bean.psdid}&viewhistory=1"><img src="images/apply.gif" width="16" height="16" border="0" alt="表单初始化配置" /></html:link>
						</logic:notEqual>
					</td>
					<td><html:link action="/IGPRD0126_List.do?pdid=${bean.pdid}&psdid=${bean.psdid}&viewhistory=1"><img src="images/qhcl.gif" width="16" height="16" border="0" alt="前后处理配置" /></html:link></td>
					<td>
						<logic:notEqual name="bean" property="psdcode" value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS %>">
							<html:link action="/IGPRD0141_List.do?pdid=${bean.pdid}&psdid=${bean.psdid}&psdcode=${bean.psdcode}&viewhistory=1"><img src="images/zichan2.gif" width="16" height="16" border="0" alt="按钮事件配置" /></html:link>
						</logic:notEqual>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter" style="display:none">
	<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
	<input name="add" type="button" class="button"
		value="增加" onclick="ope('create');" /> 
	<%} %>	
	<input name="add1"
		type="button" class="button" value="保存流程图" onclick="ope('saveImg');" />
	</div>


	<div id="results_list">

	<table cellspacing="0" cellpadding="0" class="panel_style"
		align="center">
		<tr>
			<td width="100%" height="250"
				onclick="cleancontextMenu();return false;"
				oncontextmenu='flowContextMenu();return false;'><v:group
				ID="FlowVML"
				style="left:293;top:56;width:1000px;height:500px;position:absolute;"
				coordsize="2000,2000">
			</v:group></td>
		</tr>
	</table>

	</div>



	<html:hidden name="IGPRD0104Form" property="pdid" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
<script>
loadFromXML();
</script>
</html>

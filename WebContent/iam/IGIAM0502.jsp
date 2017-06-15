<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGRAM0101" toScope="request" />
<bean:define id="title" value="流程类型" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>
html{
  overflow:hidden;
}
body{
	font-size: 12px;
	color: #0066CC;
	background-color: #FFFFFF;
	margin-top: 2px;
	margin-left: 20px;
 	overflow-y: auto;
}
li {
	background-image: url(images/choose1.gif);
	background-repeat: no-repeat;
	background-position: 2px 3px;
	margin-bottom: 4px;
	list-style-type: none;
	padding-top: 2px;
	padding-left: 18px;
	height: 18px;
}

a {
	color: #333333;
	text-decoration: none;
}

a:hover {
	color: #0066CC;
	text-decoration: underline;
}
</style>
<script>
function selectType(ptstartpg,flag,pdid){
	if(ptstartpg.indexOf("/") != 0){
		ptstartpg = "/"+ptstartpg;
	}
	window.returnValue = '<%=request.getContextPath()%>'+ptstartpg+"?flag="+flag+"&prpdid="+pdid;
	window.close();
}
function selectRole(ptstartpg,pdid,ptid,pttype){
	var pdiddel = pdid.substring(0,5);
	window.returnValue = "<%=request.getContextPath()%>/IGPRR0101_Disp.do?psdcode=<%=IGPRDCONSTANTS.PROCESS_START_STATUS%>&pdid="+pdiddel+"&ptid="+ptid+"&pts="+pttype+"&actname=ACT12IAM0502";
	window.close();
}
</script>
<body>
<%	
if("linkID=IGWKM0202&page=svc".equals(request.getQueryString())){%>
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">请选择类型</p>
	</div>
	<ig:message />
	<ul>
		<logic:present name="IGPRM00001VO" property="templateDefinitionMap">
			<logic:iterate id="map" name="IGPRM00001VO" property="templateDefinitionMap">
			<bean:define id="pt" name="map" property="key" type="com.deliverik.framework.workflow.prd.model.IG259Info"/>
			<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
			<logic:equal value="8" name="pt" property="ptid">
			<li>${pt.ptname}</li>
			</logic:equal>
			<logic:notEqual value="8" name="pt" property="ptid">
			<li><a href="###"
				onclick="selectType('${pt.ptstartpg}','1','${pt.ptid}')">${pt.ptname}</a></li>
			</logic:notEqual>
			<logic:present name="list">
				<logic:iterate id="pd" name="list" type="com.deliverik.framework.workflow.prd.model.IG380Info">
				<logic:notEqual value="8" name="pt" property="ptid">
					<li style="margin-left: 30px; background-image:url(images/choose2.gif);"><a href="###"
						onclick="selectType('${pt.ptstartpg}','0','${pd.pdid}')">${pd.pdname}</a></li>
				</logic:notEqual>
				<logic:equal value="8" name="pt" property="ptid">
					<li style="margin-left: 30px; background-image:url(images/choose2.gif);"><a href="###"
						onclick="selectRole('${pt.ptstartpg}','${pd.pdid}','${pd.ptid}')">${pd.pdname}</a></li>
				</logic:equal>
				</logic:iterate>
			</logic:present>
			</logic:iterate>
		</logic:present>
	</ul>
<%}else{%>
	<logic:present name="IGPRM00001VO" property="templateDefinitionMap">
		<logic:iterate id="map" name="IGPRM00001VO" property="templateDefinitionMap">
		<bean:define id="pt" name="map" property="key" type="com.deliverik.framework.workflow.prd.model.IG259Info"/>
		<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
		<%	
			if(list.size()==0 && "WD".equals(pt.getPttype())){%>
				<div id="location">
				<div class="image"></div>
				<p class="fonts1">请选择类型</p>
				</div>
				<ig:message />
				<ul>
				<logic:equal value="8" name="pt" property="ptid">
				<li>${pt.ptname}</li>
				</logic:equal>
				<logic:notEqual value="8" name="pt" property="ptid">
				<li>${pt.ptname}</li>
				</logic:notEqual>
		<%}else{%>
		<div id="location">
		<div class="image"></div>
		<p class="fonts1">请选择类型</p>
		</div>
		<ig:message />
		<ul>
		<logic:equal value="8" name="pt" property="ptid">
		<li>${pt.ptname}</li>
		</logic:equal>
		<logic:notEqual value="8" name="pt" property="ptid">
		<li>${pt.ptname}</li>
		</logic:notEqual>
		<logic:present name="list">
			
			<logic:iterate id="pd" name="list" type="com.deliverik.framework.workflow.prd.model.IG380Info">
			<logic:lessThan value="8" name="pd" property="ptid">
			<logic:notEqual value="设备日志告警" name="pd" property="pdname">
				<li style="margin-left: 30px; background-image:url(images/choose2.gif);"><a href="###"
					onclick="selectType('${pt.ptstartpg}','0','${pd.pdid}')">${pd.pdname}</a></li>
			</logic:notEqual>
			</logic:lessThan>
			<logic:equal value="8" name="pd" property="ptid">
				<li style="margin-left: 30px; background-image:url(images/choose2.gif);"><a href="###"
					onclick="selectRole('${pt.ptstartpg}','${pd.pdid}','${pd.ptid}')">${pd.pdname}</a></li>
			</logic:equal>
			<logic:greaterThan value="8" name="pd" property="ptid">
				<logic:equal value="14" name="pd" property="ptid">
					<li style="margin-left: 30px; background-image:url(images/choose2.gif);"><a href="###"
						onclick="selectType('${pt.ptstartpg}','0','${pd.pdid}')">${pd.pdname}</a></li>
				</logic:equal>
				<logic:equal value="17" name="pd" property="ptid">
					<li style="margin-left: 30px; background-image:url(images/choose2.gif);"><a href="###"
						onclick="selectRole('${pt.ptstartpg}','${pd.pdid}','${pd.ptid}','${pt.pttype }')">${pd.pdname}</a></li>
				</logic:equal>
				<%-- <logic:notEqual value="14" name="pd" property="ptid">
				<bean:define id="spt" name="IGPRM00001VO" property="spt" />
						<li style="margin-left: 30px; background-image:url(images/choose2.gif);"><a href="###"
							onclick="selectRole('${spt.ptstartpg}','${pd.pdid}','${pd.ptid}')">${pd.pdname}</a></li>
				</logic:notEqual> --%>
			</logic:greaterThan>

			
			</logic:iterate>
			
		</logic:present>
		</ul>
		<%}%>
		</logic:iterate>
	</logic:present>
<%}%>
</body>
</html:html>

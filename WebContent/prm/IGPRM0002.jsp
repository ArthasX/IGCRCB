<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRM0002" toScope="request" />
<bean:define id="title" value="任务调度类型" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>
html{
  overflow:hidden;
}
body{
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
function selectType(ptsavepg,pdid,pdname){
	window.returnValue = ptsavepg + "|" + pdid + "|" +pdname;
	window.close();
}
</script>
<body>
<div id="location">
	<div class="image"></div>
	<p class="fonts1">请选择任务类型</p>
</div>
<ig:message />
<ul>
	<logic:present name="IGPRM00001VO" property="templateDefinitionMap">
		<logic:iterate id="map" name="IGPRM00001VO" property="templateDefinitionMap">
		<bean:define id="pt" name="map" property="key" type="com.deliverik.framework.workflow.prd.model.IG259Info"/>
		<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />

		<li>${pt.ptname}</li>
		<logic:present name="list">
			<logic:iterate id="pd" name="list" type="com.deliverik.framework.workflow.prd.model.IG380Info">
				<li style="margin-left: 30px; background-image:url(images/choose2.gif);"><a href="javascript:void(0)"
					onclick="selectType('${pt.ptsavepg}','${pd.pdid}','${pd.pdname}')">${pd.pdname}</a></li>
			</logic:iterate>
		</logic:present>

		</logic:iterate>
	</logic:present>
</ul>
</body>
</html:html>

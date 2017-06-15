<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGDWP0104" toScope="request" />
<bean:define id="title" value="工作类型" toScope="request" />
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
<script type="text/javascript">
function setValue(value){
	returnValue = value;
	window.close();
}
</script>
<body>
<div id="location">
<div class="image"></div>
<p class="fonts1">请选择类型</p>
</div>
<br>
<ig:message />
<ul>
	<logic:present name="IGDWP01041VO" property="processDefinitionMap">
		<logic:iterate id="map" name="IGDWP01041VO" property="processDefinitionMap">
			<li>${map.key.ptname}</li>
			<logic:present name="map" property="value">
				<logic:iterate id="pd" name="map" property="value">
					<li style="margin-left: 30px; background-image: url(images/choose2.gif);">
						<a href="javascript:setValue('${pd.pdid}_sp_${pd.pdname}')">${pd.pdname}</a>
					</li>
				</logic:iterate>
			</logic:present>
		</logic:iterate>
	</logic:present>
</ul>
<div class="enter">
	<input onclick="javascript:window.close();" type="button"  class="button" value="取消">
	<input onclick="setValue('_resetall');" type="button"  class="button" value="清空">
</div>
</body>
</html:html>

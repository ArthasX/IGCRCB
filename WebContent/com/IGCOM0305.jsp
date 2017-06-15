<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0305" toScope="request" />
<bean:define id="title" value="关系图" toScope="request" />
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
	background-image: url(images/ee.gif);
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
var gid='IGCOM0305';
function searchEi(eiid,civersion){
	openSubIGCOM0303(eiid,civersion);
}
</script>
<body>
<div id="location">
<div style="margin-top: 5px;"><img src="images/ee.gif"/><span style="margin-left: 5px;">${IGCOM03051VO.entityData.einame}</span></div>
</div>
<ig:message />
<ul>
	<logic:present name="IGCOM03051VO" property="parEntityItemRelationMap">
		<logic:iterate id="map" name="IGCOM03051VO" property="parEntityItemRelationMap">
		<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
		<li><ig:codeValue
					ccid="ENTITY_CATEGORY_CODE" cid="${map.key}" /></li>
		<logic:present name="list">
			<logic:iterate id="ei" name="list">
				<li style="margin-left: 30px; background-image:url(images/ee.gif);">
				<logic:equal name="ei" property="parflag" value="1">
				<logic:equal value="true" name="IGCOM03051VO" property="flag">
				<a href="javascript:void(0)" onclick="searchEi('${ei.pareiid}','${IGCOM0305Form.eiversion }')">${ei.parEntityItemVW.einame}</a>
				</logic:equal>
				<logic:equal value="false" name="IGCOM03051VO" property="flag">
				${ei.parEntityItemVW.einame}
				</logic:equal>
				</logic:equal>
				<logic:equal name="ei" property="parflag" value="0">
				<logic:equal value="true" name="IGCOM03051VO" property="flag">
				<a href="javascript:void(0)" onclick="searchEi('${ei.cldeiid}','${IGCOM0305Form.eiversion }')">${ei.cldEntityItemVW.einame}</a>
				</logic:equal>
				<logic:equal value="false" name="IGCOM03051VO" property="flag">
				${ei.cldEntityItemVW.einame}
				</logic:equal>
				</logic:equal>
				</li>
		 	</logic:iterate>
		</logic:present>
		</logic:iterate>
	</logic:present>
	<logic:notPresent name="IGCOM03051VO" property="parEntityItemRelationMap">
	<p class="red">该资产项目没有关联任何资产项</p>
	</logic:notPresent>
</ul>
</body>
</html:html>

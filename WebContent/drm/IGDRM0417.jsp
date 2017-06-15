<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM0417" toScope="request" />
<bean:define id="title" value="取值范围" toScope="request" />
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
	background-position: 8px 3px;
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
function selectType(ccdcategory,ccdlabel){
	window.returnValue = new CCDBean(ccdcategory,ccdlabel);
	window.close();
}
function CCDBean(ccdcategory,ccdlabel){
	this.ccdcategory = ccdcategory;
	this.ccdlabel = ccdlabel;
}
</script>
<body>
<div id="location">
<div class="image"></div>
<p class="fonts1">请选择</p>
</div>
<ig:message />
<div style="overflow:auto;height:500px">
<ul>
	<logic:present name="IGDRM04171VO" property="configurationCodeDetailBeanList">
			<logic:iterate id="bean" name="IGDRM04171VO" property="configurationCodeDetailBeanList">
				<li style="padding-left: 30px;"><a href="javascript:void(0)"
					onclick="selectType('${bean.ccdcategory}','${bean.ccdlabel}')">${bean.ccdlabel}</a></li>
			</logic:iterate>
	</logic:present>
</ul>
</div>
</body>
</html:html>

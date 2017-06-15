<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0151" toScope="request" />
<bean:define id="title" value=""  toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<script type="text/javascript">
function shuxingweihu (eiid) {
	this.parent.location.href = getAppRootUrl() + "/IGAIM0124_Disp.do?eiid=" + eiid;
}
function guanxiweihu (eiid) {
	this.parent.location.href = getAppRootUrl() + "/IGAIM0126_Disp.do?eiid=" + eiid;
}
function guanxidengji (type,eiid) {//type: service：应用-服务；software：应用-软件
	this.parent.location.href = getAppRootUrl() + "/IGCIM0152_Disp.do?pareiid=" + eiid + "&type=" + type;
}

</script>
<style>
body,html{background-color: #FFFFFF;
      background-image: none;
     }
</style>
<body>
<div class="title">
	<div class="name">功能按钮</div>
</div>
<div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" class="button" value="属性维护" onclick="shuxingweihu('${IGCIM0151Form.eiid}')" style="background-color: #fc890e;border: 0px;"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" class="button" value="关系维护" onclick="guanxiweihu('${IGCIM0151Form.eiid}')" style="background-color: #fc890e;border: 0px;"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" class="button" value="应用服务关系登记" onclick="guanxidengji('service','${IGCIM0151Form.eiid}')" style="background-color: #fc890e;border: 0px;"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" class="button" value="应用软件关系登记" onclick="guanxidengji('software','${IGCIM0151Form.eiid}')" style="background-color: #fc890e;border: 0px;"/>
</div>

<div class="title">
<div class="name">配置拓扑</div>
</div>
<div class="message"><ig:message /></div>
<div id="container" >
<iframe name="tuopu" id="tuopu" width="770" height="340" frameborder="0" scrolling="auto" src="IGAIM0148.do?EIID=${IGCIM0151Form.eiid}"></iframe>
</div>
</body>
</html:html>
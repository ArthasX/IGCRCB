<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGSMR0501" toScope="request"/>
<bean:define id="title" value="分组信息" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">
	var win = null;
	function showHistoryInfo(prtype,prid){
		var url = '/IGPRR0112_Popup.do?popupFlag=Y&prtype=' + prtype + "&prid=" + prid + '&showCopy=${IGSMR0501Form.showCopy}';
		var iTop = (window.screen.availHeight-30-1100)/2;       //获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth-10-600)/2;           //获得窗口的水平位置;
		win = window.open(getAppRootUrl() + url, '_banks', 'width=1100,height=600,scrollbars=yes,resizable=no,status=yes,top='+iTop+',left='+iLeft+',');
		win.focus();
	}
	function setProcessInfos(prid){
		if(!window.opener.closed){
			 window.opener.setProcessInfos(prid);
			 window.close();
		 }
	}
</script>
<body>
<div id="maincontent">
<div id="container">
<div style="margin-left:100px;">
	<div style="margin-top:15px;margin-left:35px;">
		<p class="fonts1">历史记录</p>
	</div>
	<ul>
		<logic:present name="IGSMR05011VO" property="reportHistoryVWInfoList">
			<logic:iterate id="bean" name="IGSMR05011VO" property="reportHistoryVWInfoList">
				<li><a href="javascript:showHistoryInfo('${bean.prtype }',${bean.prid });">${bean.reportdesc }</a></li>
			</logic:iterate>
		</logic:present>
	</ul>
</div>
</div>
</div>
</body>
</html:html>
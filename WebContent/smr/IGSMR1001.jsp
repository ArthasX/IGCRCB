<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSMR1001" toScope="request" />
<bean:define id="title" value="季报" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common.js" type="text/javascript"></script>
<script type="text/javascript" src="js/swfobject.js"></script>

<script type="text/javascript">


	var swfVersionStr = "12.0.0";
	var xiSwfUrlStr = "images/dbmswf/QuarterDashboardMain.swf";
	var flashvars = {};
	var params = {};
	var attributes = {};
	attributes.id = "QuarterDashboardMain";
	attributes.name = "QuarterDashboardMain";
	params.wmode = "Opaque";
	swfobject.embedSWF(xiSwfUrlStr, "flashContent", "1010", "800",
			swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);

	function quit() {
		if (window.confirm("您确定要退出系统吗？")) {
			window.location = "./IGCOM0102.do";
		}
	}

	function initApp() {
		//  	setElecTransTotal(null,null);
		//    	setMultiBankTransCount(null,null);
		//    	setMultiBankTransMoney(null,null);
		//    	setMultiBankTransCountTrend(null,null);
		//    	setMultiBankTransMoneyTrend(null,null);
		setElecWorkScale();
	}

	function setElecTransTotal(year, quarter) {
		var res;
		var parametersStr = 'searchType=ElecTransTotal';
		if (year != null)
			parametersStr = parametersStr + '&year=' + year;
		if (quarter != null)
			parametersStr = parametersStr + '&quarter=' + quarter;
		try {
			new Ajax.Request(getAppRootUrl() + "/IGSMR0901_Search.do", {
				asynchronous : false,
				parameters : parametersStr,
				onSuccess : function(req, json) {
					var result = req.responseText;
					if (result != null && result != "") {
						res = result;
					} else {
						res = "";
					}
				}
			});
			QuarterDashboardMain.getElecTransTotal(res);
			
		} catch (err) {
			setTimeout("setElecTransTotal(" + year + "," + quarter + ")", 50);
		}

	}

	function setMultiBankTransCount(year, quarter) {
		var res;
		var parametersStr = 'searchType=MultiBankTransCount';
		if (year != null)
			parametersStr = parametersStr + '&year=' + year;
		if (quarter != null)
			parametersStr = parametersStr + '&quarter=' + quarter;
		try {
			new Ajax.Request(getAppRootUrl() + "/IGSMR0901_Search.do", {
				asynchronous : false,
				parameters : parametersStr,
				onSuccess : function(req, json) {
					var result = req.responseText;
					if (result != null && result != "") {
						res = result;
					} else {
						res = "";
					}
				}
			});
			QuarterDashboardMain.getMultiBankTransBDT(res);
		} catch (err) {
			setTimeout("setMultiBankTransCount(" + year + "," + quarter + ")",
					50);
		}
	}

	function setMultiBankTransMoney(year, quarter) {
		var res;
		var parametersStr = 'searchType=MultiBankTransMoney';
		if (year != null)
			parametersStr = parametersStr + '&year=' + year;
		if (quarter != null)
			parametersStr = parametersStr + '&quarter=' + quarter;
		try {
			new Ajax.Request(getAppRootUrl() + "/IGSMR0901_Search.do", {
				asynchronous : false,
				parameters : parametersStr,
				onSuccess : function(req, json) {
					var result = req.responseText;
					if (result != null && result != "") {
						res = result;
					} else {
						res = "";
					}
				}
			});
			QuarterDashboardMain.getMultiBankTransTDB(res);
		} catch (err) {
			setTimeout("setMultiBankTransMoney(" + year + "," + quarter + ")",
					50);
		}
	}

	function setMultiBankTransCountTrend(year, quarter) {
		var res;
		var parametersStr = 'searchType=MultiBankTransCountTrend';
		if (year != null)
			parametersStr = parametersStr + '&year=' + year;
		if (quarter != null)
			parametersStr = parametersStr + '&quarter=' + quarter;
		try {
			new Ajax.Request(getAppRootUrl() + "/IGSMR0901_Search.do", {
				asynchronous : false,
				parameters : parametersStr,
				onSuccess : function(req, json) {
					var result = req.responseText;
					if (result != null && result != "") {
						res = result;
					} else {
						res = "";
					}
				}
			});
			QuarterDashboardMain.getMultiBankTransCountTrend(res);
		} catch (err) {
			setTimeout("setMultiBankTransCountTrend(" + year + "," + quarter
					+ ")", 50);
		}
	}

	function setMultiBankTransMoneyTrend(year, quarter) {
		var res;
		var parametersStr = 'searchType=MultiBankTransMoneyTrend';
		if (year != null)
			parametersStr = parametersStr + '&year=' + year;
		if (quarter != null)
			parametersStr = parametersStr + '&quarter=' + quarter;
		try {
			new Ajax.Request(getAppRootUrl() + "/IGSMR0901_Search.do", {
				asynchronous : false,
				parameters : parametersStr,
				onSuccess : function(req, json) {
					var result = req.responseText;
					if (result != null && result != "") {
						res = result;
					} else {
						res = "";
					}
				}
			});
			QuarterDashboardMain.getMultiBankTransMoneyTrend(res);
		} catch (err) {
			setTimeout("setMultiBankTransMoneyTrend(" + year + "," + quarter
					+ ")", 50);
		}
	}

	function setElecWorkScale(year, quarter) {
		var res;
		var parametersStr = 'searchType=ElecWorkScale';
		if (year != null)
			parametersStr = parametersStr + '&year=' + year;
		if (quarter != null)
			parametersStr = parametersStr + '&quarter=' + quarter;
		try {
			new Ajax.Request(getAppRootUrl() + "/IGSMR0901_Search.do", {
				asynchronous : false,
				parameters : parametersStr,
				onSuccess : function(req, json) {
					var result = req.responseText;
					if (result != null && result != "") {
						res = result;
					} else {
						res = "";
					}
				}
			});
			QuarterDashboardMain.getElecWorkScale(res);
		} catch (err) {
			setTimeout("setElecWorkScale(" + year + "," + quarter + ")", 50);
		}
	}
	function autoHeight() {
		document.getElementById("bg").style.height = document.getElementById(
				"it").getElementsByTagName("li").length * 22;
	}
</script>
<body onload="initApp();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
<!--sidebar  左菜单-->
<!--content  右侧内容-->
	<div id="dbmcontentWrap">
	<div id="content">
<div class="box">

		<!-- 在此显示菜单 -->
<!-- 		<ul id="flyout"> -->
<!-- 		<li><a href="#" class="nikon">[if gte IE 7]><!</a><![endif] -->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
<!-- 		<b id="bg"></b> -->
<!-- 		<ul id="it"> -->
<%-- 		<ig:dbMenu acturl="<%=request.getContextPath()%>"/> --%>
<!-- 		</ul> -->
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
<!-- 		</li> -->
<!-- 		</ul>		 -->
<div id="flashContent">
</div>
</div>
	</div>
	</div>
</div>
</div>
</body>

</html:html>
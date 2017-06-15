<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGRAM0301" toScope="request" />
<bean:define id="title" value="部门评估统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
.file {
	font: 10pt;
	color: black;
}
</style>
<script type="text/javascript">
	function SwitchMenu(obj) {
		if (document.getElementById) {
			var el = document.getElementById(obj);
			var ar = document.getElementById("masterdiv").getElementsByTagName(
					"span"); //DynamicDrive.com change
			if (el.style.display != "block") { //DynamicDrive.com change
				for ( var i = 0; i < ar.length; i++) {
					if (ar[i].className == "submenu") //DynamicDrive.com change
						ar[i].style.display = "none";
				}
				el.style.display = "block";
			} else {
				el.style.display = "none";
			}
		}
	}

	function setOrg(url) {

		var temp = window
				.showModalDialog(url, null,
						"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if ("_resetall" == temp) {
			document.forms[0].orgid.value = "";
			document.forms[0].orgName.value = "";
			return false;
		}
		if (null != temp && temp.split("|").length > 1) {
			var orgsyscoding = "";
			orgsyscoding = temp.split("|")[0] + "%";
			document.forms[0].orgid.value = orgsyscoding;
			document.forms[0].orgName.value = temp.split("|")[1];
		}

	}

	function checkForm() {

		if ($F('propentime_from').trim() == "") {
			alert("请选择查询开始时间");
			return false;
		}
		if ($F('propentime_to').trim() == "") {
			alert("请选择查询结束时间");
			return false;
		}
		if (!checkDate("propentime_from", "propentime_to")) {
			alert("查询开始时间不能晚于结束时间！");
			return false;
		} else {

			document.forms[0].action = getAppRootUrl() + "/IGRAM0301.do";
			document.forms[0].submit();
		}

	}
	function exportExcel() {
		if ($F('propentime_from').trim() == "") {
			alert("请选择查询开始时间");
			return false;
		}
		if ($F('propentime_to').trim() == "") {
			alert("请选择查询结束时间");
			return false;
		}
		if (!checkDate("propentime_from", "propentime_to")) {
			alert("查询开始时间不能晚于结束时间！");
			return false;
		} else {
			document.forms[0].action = getAppRootUrl()
					+ "/IGRAM0301_Export.do?report1=1";
			document.forms[0].submit();
		}
	}
</script>

<body >
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />
		<!--container 左菜单 右侧内容-->
		<div id="container">
			<!--sidebar  左菜单-->
			<%-- <jsp:include page="/include/epileft.jsp" /> --%>
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<div id="location">
						<div class="image"></div>
						<p class="fonts1">外包管理 &gt;&gt; 风险评估 &gt;&gt; 部门评估统计</p>
					</div>
					<div id="search">
						<html:form styleId="form" action="/IGRAM0301"
							onsubmit="return checkSubmit(this);">
							<div class="img"></div>
							<div class="conditions">
								<div>
									<span>时间：从</span><span><html:text
											property="propentime_from" readonly="true"
											errorStyleClass="inputError imeActive" /></span> <img
										src="images/date.gif" align="middle"
										onClick="calendar($('propentime_from'))" border="0" /> <span>&nbsp;&nbsp;到</span><span><html:text
											property="propentime_to" readonly="true"
											errorStyleClass="inputError imeActive" /></span> <img
										src="images/date.gif" align="middle"
										onClick="calendar($('propentime_to'))" border="0" /> <span>
										<input type="hidden" value="user" name="type" /> <html:submit
											property="btn_search" styleClass="button" value="查询"
											onclick="return checkForm()" /> <html:submit
											property="btn_search" styleClass="button" value="导出"
											onclick="return exportExcel()" />
									</span>
								</div>
							</div>
						</html:form>
					</div>

					<div id="results_list">
						<ig:message />
						<table class="table_style" id="caseListTable">
							<tr>
								<th width="20%">部门</th>
								<th width="20%">项目立项评估</th>
								<th width="20%">项目实施评估</th>
								<th width="20%">项目售后评估</th>
								<th width="20%">服务商年度评估</th>
							</tr>
							<!-- body部 -->
							<logic:present name="IGRAM03011VO" property="orgReport">
								<c:set var="num" value="0"></c:set>
								<logic:iterate id="report" name="IGRAM03011VO"
									property="orgReport">
									<bean:define id="report" name="report" type="java.lang.String"></bean:define>
									<c:if test="${num==0 }">
										<tr>
									</c:if>
									<td>${report}</td>
									<c:set var="num" value="${num+1 }"></c:set>
									<c:if test="${num==5 }">
										</tr>
										<c:set var="num" value="0"></c:set>
									</c:if>
								</logic:iterate>
							</logic:present>
						</table>
					</div>
					<div id="operate"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html:html>
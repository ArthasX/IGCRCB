<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGRAM0401" toScope="request" />
<bean:define id="title" value="年度评估统计画面" toScope="request" />
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
	if (document.getElementById) { //DynamicDrive.com change
		document.write('<style type="text/css">\n')
		document.write('.submenu{display: none;}\n')
		document.write('</style>\n')
	}

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

		if ($F('currentyear').trim() == "") {
			alert("请选择查询开始时间");
			return false;
		} else {
			document.forms[0].action = getAppRootUrl() + "/IGRAM0401.do";
			document.forms[0].submit();
		}

	}
	function exportExcel() {
		if ($F('currentyear').trim() == "") {
			alert("请选择查询开始时间");
			return false;
		} else {
			document.forms[0].action = getAppRootUrl()
					+ "/IGRAM0401_Export.do?report1=1";
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
						<p class="fonts1">外包管理 &gt;&gt; 风险评估 &gt;&gt; 年度评估统计</p>
					</div>
					<div id="search">
						<html:form styleId="form" action="/IGRAM0401"
							onsubmit="return checkSubmit(this);">
							<div class="img"></div>
							<div class="conditions">
								<div>
									<span>时间：从</span> <span> <html:select
											property="currentyear">
											<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false"
												isCodeLabel="true" />
										</html:select> <input type="hidden" value="user" name="type" /> <html:submit
											property="btn_search" styleClass="button" value="查询"
											onclick="checkForm()" /> <html:submit property="btn_search"
											styleClass="button" value="导出" onclick="exportExcel()" />
									</span>
								</div>
							</div>
						</html:form>
					</div>
					<div id="results_list">
						<ig:message />
						<table class="table_style" id="caseListTable">

							<tr>
								<th width="12%">评估类型</th>
								<th>一月</th>
								<th>二月</th>
								<th>三月</th>
								<th>四月</th>
								<th>五月</th>
								<th>六月</th>
								<th>七月</th>
								<th>八月</th>
								<th>九月</th>
								<th>十月</th>
								<th>十一月</th>
								<th>十二月</th>
							</tr>
							<!-- body部 -->
							<logic:present name="IGRAM04011VO" property="yearReport">
								<c:set var="num" value="0"></c:set>
								<logic:iterate id="report" name="IGRAM04011VO"
									property="yearReport">
									<bean:define id="report" name="report" type="java.lang.String"></bean:define>
									<c:if test="${num==0 }">
										<tr>
									</c:if>
									<td>${report}</td>
									<c:set var="num" value="${num+1 }"></c:set>
									<c:if test="${num==13 }">
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
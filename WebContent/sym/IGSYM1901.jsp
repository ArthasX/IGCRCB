<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<html:html>
<bean:define id="id" value="IGSYM1901" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="symResources" key="ietitle.IGSYM1901" />
</bean:define>
<link type="text/css" href="css/portal.css" rel="stylesheet" />
<link rel="stylesheet" href="/css/master.css" type="text/css">
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	function add() {
		var year = $("year").value;
		window.location = "IGSYM1902_Disp.do?year=" + year;
	}
	function selectYear() {
		var year = $("year").value;
		window.location = "IGSYM1901_ReDisp.do?year=" + year + "&month=0";
	}

	function backMonth(year, month) {
		var curmonth = month - 1;
		var curyear = year;
		if (year == 2011 && month == 0) {
			curyear = 2011;
			curmonth = 0;
		} else if (curmonth < 0) {
			curmonth = 11;
			curyear = year - 1;
		}
		window.location = "IGSYM1901_ReDisp.do?year=" + curyear + "&month="
				+ curmonth;
	}

	function nextMonth(year, month) {
		var curmonth = month + 1;
		var curyear = year;
		if (year == 2020 && month == 11) {
			curyear = 2020;
			curmonth = 11;
		} else if (curmonth > 11) {
			curmonth = 0;
			curyear = year + 1;
		}
		window.location = "IGSYM1901_ReDisp.do?year=" + curyear + "&month="
				+ curmonth;
	}

	function goPage(pwtId) {
		window.location = "IGSYM1903_Disp.do?pwtId=" + pwtId;
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1">
	<ig:navigation></ig:navigation>
	</p>
</div>

<div id="formwrapper">
<fieldset><legend><bean:message
	bundle="symResources" key="legend.IGSYM1901.001" /></legend>
<div><label for="Name"><strong><bean:message
	bundle="symResources" key="label.IGSYM1901.year" /></strong>：</label> <html:select
	name="IGSYM1901Form" property="year" style="width: 150px;"
	onchange="selectYear()">
	<html:option value="2013"></html:option>
	<html:option value="2014"></html:option>
	<html:option value="2015"></html:option>
	<html:option value="2016"></html:option>
	<html:option value="2017"></html:option>
	<html:option value="2018"></html:option>
	<html:option value="2019"></html:option>
	<html:option value="2020"></html:option>
	<html:option value="2021"></html:option>
	<html:option value="2022"></html:option>
</html:select> <logic:notPresent name="IGSYM19011VO"
	property="processWorkTimeTemplateInfoList">
	<html:button property="" onclick="add()" styleClass="button">
		<bean:message bundle="symResources" key="label.IGSYM1901.add" />
	</html:button>
</logic:notPresent>
</div>
<logic:present name="IGSYM19011VO"
	property="processWorkTimeTemplateInfoList">
	<div style="margin-left: 0px">
	<table width="780" border="0" align="center" cellpadding="0"
		cellspacing="0" style="margin-top: 10px; font-weight: bold">
		<tr style="background-image: url(images/calbg.gif)">
			<td height="44">
			<table cellSpacing="0" cellPadding="0" width="300" align="center"
				border="0">
				<tr>
					<td style="text-align: center" width="30"><a
						href="javascript:backMonth(${IGSYM1901Form.year},${IGSYM1901Form.month})"><img
						src="images/cn8.gif"
						alt='<bean:message bundle="symResources" key="img.IGSYM1901.backmonth"/>'
						border="0" /></a></td>
					<td style="text-align: center; color: #FFF; font-size: 14px"
						width="240">${IGSYM1901Form.month+1}<bean:message
						bundle="symResources" key="label.IGSYM1901.month" /></td>
					<td style="text-align: center" width="30"><a
						href="javascript:nextMonth(${IGSYM1901Form.year},${IGSYM1901Form.month});"><img
						src="images/cn9.gif"
						alt='<bean:message bundle="symResources" key="img.IGSYM1901.nextmonth"/>'
						border="0" /></a></td>
				</tr>
			</table>
			</td>
		</tr>

		<tr>
			<td>
			<table class="change_date" style="MARGIN-TOP: 0px" cellSpacing="1"
				cellPadding="0" width="780" border="0">
				<tr height="30">
					<th width="110"><bean:message bundle="symResources"
						key="title.IGSYM1901.sun" /></th>
					<th><bean:message bundle="symResources"
						key="title.IGSYM1901.one" /></th>
					<th><bean:message bundle="symResources"
						key="title.IGSYM1901.two" /></th>
					<th><bean:message bundle="symResources"
						key="title.IGSYM1901.three" /></th>
					<th><bean:message bundle="symResources"
						key="title.IGSYM1901.four" /></th>
					<th><bean:message bundle="symResources"
						key="title.IGSYM1901.five" /></th>
					<th width="110"><bean:message bundle="symResources"
						key="title.IGSYM1901.six" /></th>
				</tr>
				<tr height="50" bgcolor="#ffffff">
					<td bgcolor="${voMap.vo1.cellColor}"><logic:present name="voMap"
						property="vo1.day">
						<strong><a
							href="javascript:goPage(${voMap.vo1.pwtId})" style="cursor: hand"><font size="5" color="${voMap.vo1.dayColor}">${voMap.vo1.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo1.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo2.cellColor}"><logic:present name="voMap"
						property="vo2.day">
						<strong><a
							href="javascript:goPage(${voMap.vo2.pwtId})" style="cursor: hand"><font size="5" color="${voMap.vo2.dayColor}">${voMap.vo2.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo2.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo3.cellColor}"><logic:present name="voMap"
						property="vo3.day">
						<strong><a
							href="javascript:goPage(${voMap.vo3.pwtId})" style="cursor: hand"><font size="5" color="${voMap.vo3.dayColor}">${voMap.vo3.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo3.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo4.cellColor}"><logic:present name="voMap"
						property="vo4.day">
						<strong><a
							href="javascript:goPage(${voMap.vo4.pwtId})" style="cursor: hand"><font size="5" color="${voMap.vo4.dayColor}">${voMap.vo4.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo4.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo5.cellColor}"><logic:present name="voMap"
						property="vo5.day">
						<strong><a
							href="javascript:goPage(${voMap.vo5.pwtId})" style="cursor: hand"><font size="5" color="${voMap.vo5.dayColor}">${voMap.vo5.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo5.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo6.cellColor}"><logic:present name="voMap"
						property="vo6.day">
						<strong><a
							href="javascript:goPage(${voMap.vo6.pwtId})" style="cursor: hand"><font size="5" color="${voMap.vo6.dayColor}">${voMap.vo6.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo6.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo7.cellColor}"><logic:present name="voMap"
						property="vo7.day">
						<strong><a
							href="javascript:goPage(${voMap.vo7.pwtId})" style="cursor: hand"><font size="5" color="${voMap.vo7.dayColor}">${voMap.vo7.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo7.pwtSleepTime}" />
						</font>
					</logic:present></td>
				</tr>
				<tr height="50" bgcolor="#ffffff">
					<td bgcolor="${voMap.vo8.cellColor}"><strong><a href="javascript:goPage(${voMap.vo8.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo8.dayColor}">${voMap.vo8.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo8.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo9.cellColor}"><strong><a href="javascript:goPage(${voMap.vo9.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo9.dayColor}">${voMap.vo9.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo9.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo10.cellColor}"><strong><a href="javascript:goPage(${voMap.vo10.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo10.dayColor}">${voMap.vo10.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo10.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo11.cellColor}"><strong><a href="javascript:goPage(${voMap.vo11.pwtId})"
						style="cursor: hand"><font
						size="5"  color="${voMap.vo11.dayColor}">${voMap.vo11.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo11.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo12.cellColor}"><strong><a href="javascript:goPage(${voMap.vo12.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo12.dayColor}">${voMap.vo12.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo12.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo13.cellColor}"><strong><a href="javascript:goPage(${voMap.vo13.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo13.dayColor}">${voMap.vo13.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo13.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo14.cellColor}"><strong><a href="javascript:goPage(${voMap.vo14.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo14.dayColor}">${voMap.vo14.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo14.pwtSleepTime}" />
						</font></td>
				</tr>
				<tr height="50" bgcolor="#ffffff">
					<td bgcolor="${voMap.vo15.cellColor}"><strong><a href="javascript:goPage(${voMap.vo15.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo15.dayColor}">${voMap.vo15.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo15.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo16.cellColor}"><strong><a href="javascript:goPage(${voMap.vo16.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo16.dayColor}">${voMap.vo16.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo16.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo17.cellColor}"><strong><a href="javascript:goPage(${voMap.vo17.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo17.dayColor}">${voMap.vo17.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo17.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo18.cellColor}"><strong><a href="javascript:goPage(${voMap.vo18.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo18.dayColor}">${voMap.vo18.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo18.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo19.cellColor}"><strong><a href="javascript:goPage(${voMap.vo19.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo19.dayColor}">${voMap.vo19.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo19.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo20.cellColor}"><strong><a href="javascript:goPage(${voMap.vo20.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo20.dayColor}">${voMap.vo20.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo20.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo21.cellColor}"><strong><a href="javascript:goPage(${voMap.vo21.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo21.dayColor}">${voMap.vo21.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo21.pwtSleepTime}" />
						</font></td>
				</tr>
				<tr height="50" bgcolor="#ffffff">
					<td bgcolor="${voMap.vo22.cellColor}"><strong><a href="javascript:goPage(${voMap.vo22.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo22.dayColor}">${voMap.vo22.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo22.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo23.cellColor}"><strong><a href="javascript:goPage(${voMap.vo23.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo23.dayColor}">${voMap.vo23.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo23.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo24.cellColor}"><strong><a href="javascript:goPage(${voMap.vo24.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo24.dayColor}">${voMap.vo24.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo24.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo25.cellColor}"><strong><a href="javascript:goPage(${voMap.vo25.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo25.dayColor}">${voMap.vo25.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo25.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo26.cellColor}"><strong><a href="javascript:goPage(${voMap.vo26.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo26.dayColor}">${voMap.vo26.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo26.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo27.cellColor}"><strong><a href="javascript:goPage(${voMap.vo27.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo27.dayColor}">${voMap.vo27.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo27.pwtSleepTime}" />
						</font></td>
					<td bgcolor="${voMap.vo28.cellColor}"><strong><a href="javascript:goPage(${voMap.vo28.pwtId})"
						style="cursor: hand"><font
						size="5" color="${voMap.vo28.dayColor}">${voMap.vo28.day}</font></a></strong><br>
					<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo28.pwtSleepTime}" />
						</font></td>
				</tr>
				<tr height="50" bgcolor="#ffffff">
					<td bgcolor="${voMap.vo29.cellColor}"><logic:present name="voMap"
						property="vo29.day">
						<strong><a
							href="javascript:goPage(${voMap.vo29.pwtId})"
							style="cursor: hand"><font size="5" color="${voMap.vo29.dayColor}">${voMap.vo29.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo29.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo30.cellColor}"><logic:present name="voMap"
						property="vo30.day">
						<strong><a
							href="javascript:goPage(${voMap.vo30.pwtId})"
							style="cursor: hand"><font size="5" color="${voMap.vo30.dayColor}">${voMap.vo30.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo30.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo31.cellColor}"><logic:present name="voMap"
						property="vo31.day">
						<strong><a
							href="javascript:goPage(${voMap.vo31.pwtId})"
							style="cursor: hand"><font size="5" color="${voMap.vo31.dayColor}">${voMap.vo31.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo31.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo32.cellColor}"><logic:present name="voMap"
						property="vo32.day">
						<strong><a
							href="javascript:goPage(${voMap.vo32.pwtId})"
							style="cursor: hand"><font size="5" color="${voMap.vo32.dayColor}">${voMap.vo32.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo32.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo33.cellColor}"><logic:present name="voMap"
						property="vo33.day">
						<strong><a
							href="javascript:goPage(${voMap.vo33.pwtId})"
							style="cursor: hand"><font size="5" color="${voMap.vo33.dayColor}">${voMap.vo33.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo33.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo34.cellColor}"><logic:present name="voMap"
						property="vo34.day">
						<strong><a
							href="javascript:goPage(${voMap.vo34.pwtId})"
							style="cursor: hand"><font size="5" color="${voMap.vo34.dayColor}">${voMap.vo34.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo34.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo35.cellColor}"><logic:present name="voMap"
						property="vo35.day">
						<strong><a
							href="javascript:goPage(${voMap.vo35.pwtId})"
							style="cursor: hand"><font size="5" color="${voMap.vo35.dayColor}">${voMap.vo35.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo35.pwtSleepTime}" />
						</font>
					</logic:present></td>
				</tr>
				<tr height="50" bgcolor="#ffffff">
					<td bgcolor="${voMap.vo36.cellColor}"><logic:present name="voMap"
						property="vo36.day">
						<strong><a
							href="javascript:goPage(${voMap.vo36.pwtId})"
							style="cursor: hand"><font size="5" color="${voMap.vo36.dayColor}">${voMap.vo36.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo36.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo37.cellColor}"><logic:present name="voMap"
						property="vo37.day">
						<strong><a
							href="javascript:goPage(${voMap.vo37.pwtId})"
							style="cursor: hand"><font size="5" color="${voMap.vo37.dayColor}">${voMap.vo37.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo37.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo38.cellColor}"><logic:present name="voMap"
						property="vo38.day">
						<strong><a
							href="javascript:goPage(${voMap.vo38.pwtId})"
							style="cursor: hand"><font size="5" color="${voMap.vo38.dayColor}">${voMap.vo38.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo38.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo39.cellColor}"><logic:present name="voMap"
						property="vo39.day">
						<strong><a
							href="javascript:goPage(${voMap.vo39.pwtId})"
							style="cursor: hand"><font size="5" color="${voMap.vo39.dayColor}">${voMap.vo39.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo39.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo40.cellColor}"><logic:present name="voMap"
						property="vo40.day">
						<strong><a
							href="javascript:goPage(${voMap.vo40.pwtId})"
							style="cursor: hand"><font size="5" color="${voMap.vo40.dayColor}">${voMap.vo40.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo40.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo41.cellColor}"><logic:present name="voMap"
						property="vo41.day">
						<strong><a
							href="javascript:goPage(${voMap.vo41.pwtId})"
							style="cursor: hand"><font size="5" color="${voMap.vo41.dayColor}">${voMap.vo41.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo41.pwtSleepTime}" />
						</font>
					</logic:present></td>
					<td bgcolor="${voMap.vo42.cellColor}"><logic:present name="voMap"
						property="vo42.day">
						<strong><a
							href="javascript:goPage(${voMap.vo42.pwtId})"
							style="cursor: hand"><font size="5" color="${voMap.vo42.dayColor}">${voMap.vo42.day}</font></a></strong>
						<br>
						<font color="red"><ig:codeValue
							ccid="DATETYPE"
							cid="${voMap.vo42.pwtSleepTime}" />
						</font>
					</logic:present></td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
	</div>
</logic:present>
</fieldset>
</div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
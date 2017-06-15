<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>

<html:html>
<bean:define id="id" value="IGVEN0201" toScope="request" />
<bean:define id="title" value="风险监测管理查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//跳转工作页面
	function readInfo(rmid) {
		var form = document.getElementById("form");
		form.action = "IGVEN0202.do?rmid=" + rmid;
		form.submit();

	}

	/* function showIncident() {
		var ccid = "106";
		var cid = "";
		var syscode = "";
		if (null == syscode || "" == syscode) {
			syscode = ccid;
		} else {
			ccid = syscode.substring(0, 3);
		}

		url = "IGSYM1505_TREE.do" + "?ccid=" + ccid + "&cid=" + cid
				+ "&syscode=" + syscode;

		var temp = window
				.showModalDialog(url, null,
						"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if ("_resetall" == temp) {
			$("rccategory").value = "";
			$("rccategoryname").value = "";
			return false;
		}
		if (null != temp && temp.split("|").length > 1) {
			var id = temp.split("|")[0];
			var name = temp.split("|")[1];
			var treeccid;
			var treecid;
			var treesyscode;

			if (id.split("_").length > 1) {
				treeccid = id.split("_")[0];
				treecid = id.split("_")[1];
				treesyscode = id.split("_")[2];
			} else {
				treeccid = id.split("_")[0];
				treecid = "";
				treesyscode = "";
			}
			$("rccategory").value = treesyscode;
			$("rccategoryname").value = name;

		}

	} */
	//-->

	window.onload = function() {
		var obj = document.getElementById("table_list");
		var date = new Date();
		var mon = ((date.getMonth() + 1).toString().length == 1 ? "0"
				+ (date.getMonth() + 1) : (date.getMonth() + 1));
		var day = date.getDate().toString().length == 1 ? "0" + date.getDate()
				: date.getDate();
		var h = date.getHours().toString().length == 1 ? "0" + date.getHours()
				: date.getHours();
		var min = date.getMinutes().toString().length == 1 ? "0"
				+ date.getMinutes() : date.getMinutes();
		var time = date.getYear() + "/" + mon + "/" + day + " " + h + ":" + min;
		for ( var i = 1; i < obj.rows.length; i++) {
			//计划结束时间
			var endtime = obj.rows[i].cells[3].innerHTML;
			//实际检查时间
			var checktime = obj.rows[i].cells[5].innerHTML;
			/* 如果实际检查时间不为空,则拿实际检查时间与计划结束时间比较,
			  // 如果实际检查时间为空,则拿计划结束时间与当前时间比较
			 */
			if (checktime != '') {
				if (endtime < checktime) {
				//	obj.rows[i].cells[0].innerHTML = "<img src='images/cs1.png' align='middle' style='cursor:pointer;'  border='0' id='cs' />";
				}
			} else {
				if (time > endtime) {
				//	obj.rows[i].cells[0].innerHTML = "<img src='images/cs1.png' align='middle' style='cursor:pointer;'  border='0' id='cs' />";
				}
			}
		}
	};

	/* function getScrollTop() {
		var scrollTop = 0;
		if (document.documentElement && document.documentElement.scrollTop) {
			scrollTop = document.documentElement.scrollTop;
		} else if (document.body) {
			scrollTop = document.body.scrollTop;
		}
		return scrollTop;
	}
	function hideDiv() {
		var oSon = window.document.getElementById("hint");
		if (oSon == null)
			return;
		with (oSon) {
			innerText = '';
			style.display = "none";
		}
	} */
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<style type="text/css">
.rlcomment{cursor: hand;}
</style>
<body>
<div id="hint" style="width:130px;heigth:auto;display:none;position: absolute;z-index: 9999;border:1px;background-color: #bbbbbb;border: 5px solid #bbbbbb;"></div>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGVEN0201" onsubmit="return checkSubmit(this);" >
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation></ig:navigation></p>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>查询条件</strong></span>
	</div>
	<div style="margin-top:4px">
		<span class="subscribe">监测任务名称：</span>
		<html:text property="rmname" styleId="rmname" errorStyleClass="inputError imeDisabled" size="15" maxlength="32"  tabindex="1" />
		&nbsp;&nbsp;<span class="subscribe">计划开始时间：</span>
		<html:text property="rmstartdate_from" readonly="true" size="18" style="width:118px;"/>
		<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('rmstartdate_from'))" border="0" />
		<span>&nbsp;--&nbsp;</span>
		<html:text property="rmstartdate_to" readonly="true" style="width:118px;"/>
		<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('rmstartdate_to'))" border="0" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<html:submit styleClass="button" value="查询" />
		<%-- <html:hidden property="rccategory"/> --%>
	</div>
	<div style="margin-top:12px">
		<span class="subscribe">实际完成时间：</span>
		<html:text property="rmenddate_from" readonly="true" size="18" style="width:118px;"/>
		<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('rmenddate_from'))" border="0" />
		<span>&nbsp;--&nbsp;</span>
		<html:text property="rmenddate_to" readonly="true" style="width:118px;"/>
		<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('rmenddate_to'))" border="0" />
	</div>
	<div style="margin-top:8px;"></div>
	</div>
</div>
	<div id="results_list">
	<ig:message />
	
	<table class="table_style" id="table_list">
			<tr>
				<th width="7%">序号</th>
				<th width="18%">监测任务名称</th>
				<th width="10%">计划开始时间</th>
				<th width="10%">实际完成时间</th>
				<th width="8%">进度</th>
				<th style="display: none;" >prid</th>
			</tr>
			
			<logic:present name="IGVEN02013VO" property="igven02012voList">
				<logic:iterate id="beanvo" name="IGVEN02013VO" property="igven02012voList" indexId="index">
					<bean:define id="bean1" name="beanvo" property="riskMonitoringInfo" ></bean:define>
					<tr onclick="readInfo('${bean1.rmid}')" class="rlcomment">
						<td >
							${PagingDTO.viewStartCount+index}
						</td>
						<td title="${bean1.rmname}">
							<ig:SubstringShowEllipsisWriteTag len="20" showEllipsis="true">
								${bean1.rmname}
							</ig:SubstringShowEllipsisWriteTag>
						</td>
						<td>${bean1.rmstartdate}</td>
						<td>${bean1.rmenddate}</td>
						<td style="display: none;">${bean1.rmid}</td>
						<td>${bean1.rmrate}%</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>

</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
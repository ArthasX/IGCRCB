<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM1604" toScope="request" />
<bean:define id="title" value="事件影响范围编辑" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	function toback() {
		document.forms[0].action = getAppRootUrl() + "/IGDRM1602_Disp.do";
		document.forms[0].submit();
	}
	function checkSubmit() {
		var eventName = document.getElementById("eventName");
		var eventDes = document.getElementById("eventDes");

		if (eventName.value == "") {
			alert("请输入事件等级名称！");
			return false;
		}
		if (eventDes.value == "") {
			alert("请输入事件描述！");
			return false;
		}
		if(eventName.value.length>64){
			alert("输入事件名称的字符过多，请重新输入！");
			return false;
		}
		if(eventDes.value.length>256){
			alert("输入事件描述的字符过多，请重新输入！");
			return false;
		}
		
		var eles = document.getElementsByName("impscope");
		for ( var i = 0; i < eles.length - 1; i++) {
			if (eles[i].value.trim() == "") {
				alert("请输入事件影响范围！");
				return false;
			}
			if (eles[i].value.strlen() > 256) {
				alert("影响范围不能大于" + Math.floor(256 / strByteFlag) + "个汉字！");
				return false;
			}
		}
		eles = document.getElementsByName("impbus");
		for ( var i = 0; i < eles.length - 1; i++) {
			if (eles[i].value.trim() == "") {
				alert("请输入业务中断机构！");
				return false;
			}
			if (eles[i].value.strlen() > 512) {
				alert("应无中断机构不能大于" + Math.floor(512 / strByteFlag) + "个汉字！");
				return false;
			}
		}
		eles = document.getElementsByName("imptime");
		for ( var i = 0; i < eles.length - 1; i++) {
			if (eles[i].value.trim() == "") {
				alert("请输入业务影响时间！");
				return false;
			}
			if (eles[i].value.strlen() > 512) {
				alert("业务影响时间不能大于" + Math.floor(512 / strByteFlag) + "个汉字！");
				return false;
			}
		}

		if (window.confirm("确认提交？")) {
			return true;
		} else {
			return false;
		}
	}
</script>
<style type="text/css">
.table_form_group {
	border-collapse: collapse;
	margin-top: -1px;
	margin-bottom: -1px;
	width: 960px;
}

.tdIcon {
	text-align: center;
	vertical-align: middle;
}
.table_form_group td{
	text-align: center;
}
</style>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script language="JavaScript" src="js/tableform.js"
	type="text/javascript" charset="gbk"></script>
<body>
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />
		<!--container 左菜单 右侧内容-->
		<div id="container">
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<div id="location">
						<div class="image"></div>
						<p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt;事件影响范围</p>
						<div class="back">
							<html:link href="javascript:toback();">返回</html:link>
						</div>
					</div>

					<html:form styleId="form" action="/IGDRM1604_EDIT"
						enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
<!-- 						<div class="title"> -->
<!-- 							<div class="name">事件基本信息</div> -->
<!-- 						</div> -->
						<fieldset>
							<legend>事件基本信息</legend>
						<div id="results_list">
							<div>
								<label for="Name"><strong><span class="red">*</span>事件等级名称</strong>：</label>
								<html:text tabindex="1" property="eventName" value="${IGDRM16021VO.eventssInfo.eventname}" styleId="eventName" errorStyleClass="inputError imeDisabled" size="12" style="width:30%;"/>
								<html:hidden property="labels" value="${IGDRM16021VO.eventssInfo.labels}"/>

								<br />
							</div>
							<div>	
								<label for="Name" ><strong><span class="red">*</span>事件描述</strong>：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
								<textarea rows="6" cols="80" name="eventDes"  id="eventDes">${IGDRM16021VO.eventssInfo.eventdes}</textarea>
								<br />
							</div>
						</div>
						<div class="title">
							<div class="name">事件影响范围</div>
						</div>
						<div class="message">
							<ig:message />
						</div>
						<!-- hidden -->
						<html:hidden property="upEventid" name="IGDRM1604Form" />

						<table name="table_form" class="table_form_group" id="tf" width="98%">
							<%
								int count = 0;
							%>
							<tr>
								<th width="10%" style="border: 0px; background: #fff;"></th>
								<th width="3%" style="border: 0px; background: #fff;"></th>
								<th style="width: 40%" align="left">影响范围（省、自治区、直辖市）</th>
<!-- 								<th style="width: 30%" align="left">业务中断金融机构</th> -->
								<th style="width: 30%" align="left">业务中断时间(分钟)</th>
							</tr>

							<logic:present name="IGDRM16021VO" property="scopeInfoList">
								<logic:iterate id="bean"
									type="com.deliverik.infogovernor.drm.model.ScopesInfo"
									name="IGDRM16021VO" property="scopeInfoList" indexId="index">
									<%
										count++;
									%>
									<tr>
										<td width="10%"></td>
										<td class="tdIcon" style="border: none;">
										<img
											src="images/bullet_delete.png" name="delImg"
											onclick="deleteGroup(this);" style="cursor: hand" border="0" />
										</td>
										<td style="text-align: left;width: 40%"><input id="impscope_${index}" rownumber="${index}"
											type="text" size="60" name="impscope"
											value="${bean.impscope}" />
										</td>

<!-- 										<td style="width: 30%;  colspan="1"><input -->
<%-- 											id="impbus_${index}" rownumber="${index}" type="text" --%>
<%-- 											size="30" name="impbus" value="${bean.impbus}" /> --%>
<!-- 										</td> -->
										<td style="width: 30%;text-align: left;"  colspan="1">
											<input	id="imptime_${index}" rownumber="${index}" type="text"
											size="30" name="imptime" onkeydown="return columnValueNumber()" value="${bean.imptime}" />
										</td>
									</tr>
								</logic:iterate>
							</logic:present>


							<!--添加一一条影响条目按钮 -->
							<tr>
								<td width="10%"></td>
								<td class="tdIcon" style="width: 3%;border: none;"><img
									src="images/bullet_add.png" onclick="addGroup(this);"
									style="cursor: hand" border="0" /></td>
								<td style="border: none;" colspan="2"></td>

							</tr>
							<tr style="display: none;">
								<td width="10%"></td>
								<td class="tdIcon" style="width: 3%;border: none;"><img
									src="images/bullet_delete.png" name="delImg"
									onclick="deleteGroup(this);" style="cursor: hand" border="0" /></td>
								<td style="width: 40%;text-align: left"><input rownumber="${index}" type="text" size="60"
									name="impscope" value="" /></td>

<!-- 								<td style="width: 30%; colspan="1"><input -->
<%-- 									rownumber="${index}" type="text" size="30" name="impbus" --%>
<!-- 									value="" /></td> -->
								<td style="width: 30%;text-align: left"  colspan="1"><input
									rownumber="${index}" type="text" size="30" name="imptime"
									value="" /></td>
							</tr>
						</table>
						</fieldset>
						<br/>
						<div class="enter">
							<html:submit property="btn_insert" value="提交" styleClass="button" />							
						</div>
					</html:form>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	function addGroup(obj, insertRowNum) {
		//需要添加行的table对象
		var tr = jQ(obj).parent().parent();
		tr.before(tr.next().clone());
		tr.prev().show().find("input").val('');

	}
	function deleteGroup(obj) {
		var tr = jQ(obj).parent().parent();
		tr.remove();
	}
</script>
</html:html>
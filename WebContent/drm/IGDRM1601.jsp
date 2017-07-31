<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.drm.vo.IGDRM16021VO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html:html>
<bean:define id="id" value="IGDRM1601" toScope="request" />
<bean:define id="title" value="事件新增画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link rel="stylesheet"
	href="<html:rewrite forward='jquery.tzCheckbox.css'/>" type="text/css">
<script>
var jQ = jQuery.noConflict(true);//jquery与prototype冲突
</script>	
<script src="<html:rewrite forward='jquery.tzCheckbox.js'/>"></script>
<style type="text/css">
#entBox  th{
	background-color: #EEEEEE;
	border-bottom: 1px solid #ccc;
}
#entBox  td{
	border-bottom: 1px solid #d3d3d3;
}

#entBox{
	width: 95%;
	text-align: center;
	padding: 5px;
	margin: 0 auto;
	margin-top: 2px;
}
.entb{
	margin: auto;
	width: 100%;
/* 	border-collapse: collapse; */
/* 	border: 1px solid #f3f3f3; */
}
.entb th{
	width: 15%;
	text-align: right;
/* 	vertical-align: top; */
/* 	border-collapse: collapse; */
}
.entb td{
	width: 35%;
/* 	border: 1px solid #f3f3f3; */
	text-align: left;
/* 	border-collapse: collapse; */
}
.entb select{
	width: 170px;
}
.entb input{
	margin-left: 5px;
	height: auto;
}
.entb textarea{
	width: 85%;
	height: 100px;
}
</style>
<script type="text/javascript">
	WebCalendar.timeShow = true;
	//新增提交
	function doInsert() {

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
		if(eventName.value.strlen()>64){
			alert("输入事件名称不能大于"+Math.floor(64/strByteFlag)+"个汉字，请重新输入！");
			return false;
		}
		if(eventDes.value.strlen()>3000){
			alert("输入事件描述不能大于"+Math.floor(3000/strByteFlag)+"个汉字，请重新输入！");
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

		if (confirm("是否新增数据？")) {
// 			jQ("#tempTr").remove();
			form.submit();
			return true;
		}
	}
</script>
<body>
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />
		<!--container 左菜单 右侧内容-->
		<div id="container">
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<html:form action="IGDRM1601_Insert.do" styleId="form" onsubmit="">
						<div id="location">
							<div class="image"></div>
							<p class="fonts1">
								<ig:navigation />
							</p>
						</div>
						<fieldset>
							<legend>事件级别定义</legend>
							<div>
								<label for="Name"><strong><span class="red">*</span>事件等级名称</strong>：</label>
								<html:text tabindex="1" property="eventName"
									styleId="eventName" errorStyleClass="inputError imeDisabled"
									size="12" style="width:30%;"/>
								<html:hidden property="labels" value="${fn:length(IGDRM16021VO.eventssInfoList)+1 }"/>

								<br />
							</div>
							<div>	
								<label for="Name" ><strong><span class="red">*</span>事件描述</strong>：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
								<textarea rows="6" cols="80" name="eventDes"  id="eventDes"></textarea>
								<br />
							</div>

							<table name="table_form" align="center" class="table_form_group" id="tf" width="100%">
							<%
								int count = 0;
							%>
							<tr>
								<th width="8%" style="border: 0px; background: #fff;"></th>
								<th width="3%" style="border: 0px; background: #fff;"></th>
								<th style="width: 40%" align="left"><p style="text-indent:2em;">影响范围（省、自治区、直辖市）</p></th>
<!-- 								<th style="width: 30%" align="left">业务中断金融机构</th> -->
								<th style="width: 30%" align="left">业务中断时间(分钟)</th>
							</tr>

							<logic:present name="IGDRM16021VO" property="scopeInfoList">
								<logic:iterate id="bean" type="com.deliverik.infogovernor.drm.model.ScopesInfo" name="IGDRM16021VO" property="scopeInfoList" indexId="index">
									<%
										count++;
									%>
									<tr>
										<td width="8%"></td>
										<td class="tdIcon" style="border: none;">
											<input name = "scopeid" type="hidden" value="${bean.scopeid}">
											<img src="images/bullet_delete.png" name="delImg" onclick="deleteGroup(this);" style="cursor: hand" border="0" />
										</td>
										<td>
											<input id="impscope_${index}" rownumber="${index}" type="text" size="60" name="impscope" value="${bean.impscope}" />
										</td>

<!-- 										<td style="width: 30%;  colspan="1"> -->
<%-- 											<input id="impbus_${index}" rownumber="${index}" type="text" size="30" name="impbus" value="${bean.impbus}" /> --%>
<!-- 										</td> -->
										<td style="width:30%;"  colspan="1">
											<input	id="imptime_${index}" rownumber="${index}" type="text" size="30" name="imptime" onkeydown="return columnValueNumber()" value="${bean.imptime}" />(分钟)
										</td>
									</tr>
								</logic:iterate>
							</logic:present>


							<!--添加一一条影响条目按钮 -->
							<tr>
							<td width="8%"></td>
								<td class="tdIcon" style="border: none;">
									<img src="images/bullet_add.png" onclick="addGroup(this);" style="cursor: hand" border="0" /></td>
								<td style="border: none;" colspan="2"></td>

							</tr>
							
							<tr id = "tempTr" style="display: none;">
							<td width="8%"></td>
								<td class="tdIcon" style="border: none;">
									<input name = "scopeid" type="hidden" />
									<img src="images/bullet_delete.png" name="delImg" onclick="deleteGroup(this);" style="cursor: hand" border="0" /></td>
								<td>
									<input rownumber="${index}" type="text" size="60" name="impscope" value="" />
								</td>

<!-- 								<td style="width: 30%; colspan="1"> -->
<%-- 									<input rownumber="${index}" type="text" size="30" name="impbus" value="" /> --%>
<!-- 								</td> -->
								<td style="width: 30%;"  colspan="1">
									<input style="width: 65%;" rownumber="${index}" type="text" size="30" name="imptime" value="" />
								</td>
							</tr>
						</table>
						</fieldset>
						<br/>
			<div class="enter">
				<input type="button" class="button" value="提交" onClick="doInsert();" />
				<html:reset property="btn_clear" styleClass="button" value="重置" />
			</div>
			</html:form>
		</div>
	</div>
	</div>
	</div>
	<jsp:include page="/include/paging.jsp" />
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
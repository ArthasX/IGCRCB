<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.util.ASMHelper"%>
<html:html>
<bean:define id="id" value="IGASM1102" toScope="request" />
<bean:define id="title" value="机房登记画面" toScope="request" />


<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	var gid = 'IGASM1102';

	function confirmDisp() {
		var myReg = /^[0-9]*$/;

		var newReg = /^[^\<,^\>,^\",^\',^\/]+$/;
		var patrn = /[\/\\:*?<>|\"]+/;

		var s = $F('eilabel');

		if (patrn.exec(s)) {
			alert("机房编号不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		var s = $F('einame');

		if (patrn.exec(s)) {
			alert("机房名称不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		
		var s = $F('eidesc');

		if (patrn.exec(s)) {
			alert("机房说明不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		if ($F('eilabel').trim() == "") {
			alert("请输入机房编号！");
			return false;
		}

		if (!newReg.test($F('eilabel').trim())) {
			alert("输入机房编号非法！");
			return false;
		}
		if ($F('einame').trim() == "") {
			alert("请输入机房名称！");
			return false;
		}
		if (!newReg.test($F('einame').trim())) {
			alert("输入机房名称非法！");
			return false;
		}
		if ($F('eiinsdate').trim() == "") {
			alert("请选择登记日！");
			return false;
		}
		if ($F('eilabel').strlen() > 32) {
			alert("机房编号不能大于32个字符！");
			return false;
		}
		if ($F('einame').strlen() > 120) {
			alert("机房名称不能大于" + Math.floor(120 / strByteFlag) + "个汉字！");
			return false;
		}
		if ($F('eidesc').strlen() > 256) {
			alert("机房说明不能大于" + Math.floor(256 / strByteFlag) + "个汉字！");
			return false;
		}
		<logic:present name="IGASM11021VO" property="configurationList">
		<logic:iterate id="bean" name="IGASM11021VO" property="configurationList" indexId="number">
		<logic:equal name="bean" property="cattach" value="1">
		<logic:equal value="1" name="bean" property="crequired">
		if ($F('attachFile[${ADcheckCount}]').trim() == "") {
			alert("请输入${bean.cname}！");
			return false;
		}
		</logic:equal>
		</logic:equal>
		<logic:equal name="bean" property="cattach" value="5">
		var flag = false;
		var submitValue = "";
		var check = document.getElementsByName("cb_civalue[${ADcheckCount}]");
		<logic:equal value="1" name="bean" property="crequired">
		for ( var i = 0; i < check.length; i++) {
			if (check[i].checked == true) {
				if (submitValue != "") {
					submitValue = submitValue + "；" + check[i].value;
				} else {
					submitValue = check[i].value;
				}
				flag = true;
			}
		}
		if (submitValue.strlen() > 128) {
			alert("${bean.cname}不能大于" + Math.floor(128 / strByteFlag) + "个汉字！");
			submitValue = "";
			return false;
		}
		if (flag) {
			document.getElementById("civalue[${ADcheckCount}]").value = submitValue;
		}
		if (!flag) {
			alert("请选择${bean.cname}！");
			return false;
		}
		</logic:equal>
		<logic:notEqual value="1" name="bean" property="crequired">
		for ( var i = 0; i < check.length; i++) {
			if (check[i].checked == true) {
				if (submitValue != "") {
					submitValue = submitValue + "；" + check[i].value;
				} else {
					submitValue = check[i].value;
				}
				flag = true;
			}
		}
		if (submitValue.strlen() > 128) {
			alert("${bean.cname}不能大于" + Math.floor(128 / strByteFlag) + "个汉字！");
			submitValue = "";
			return false;
		}
		if (flag) {
			document.getElementById("civalue[${ADcheckCount}]").value = submitValue;
		} else {
			document.getElementById("civalue[${ADcheckCount}]").value = "";
		}
		</logic:notEqual>
		</logic:equal>
		<logic:notEqual name="bean" property="cattach" value="1">
		<logic:notEqual name="bean" property="cattach" value="5">
		<logic:notEqual name="bean" property="cattach" value="6">
		<logic:equal value="1" name="bean" property="crequired">
		if ($F('civalue[${ADcheckCount}]').trim() == "") {
			alert("请输入${bean.cname}！");
			return false;
		}
		if ($F('civalue[${ADcheckCount}]').trim().strlen() > 128) {
			alert("${bean.cname}不能大于" + Math.floor(128 / strByteFlag) + "个汉字！");
			return false;
		}
		</logic:equal>
		<logic:notEqual value="1" name="bean" property="crequired">
		if ($F('civalue[${ADcheckCount}]').trim().strlen() > 128) {
			alert("${bean.cname}不能大于" + Math.floor(128 / strByteFlag) + "个汉字！");
			return false;
		}
		</logic:notEqual>
		</logic:notEqual>
		</logic:notEqual>

		<logic:equal name="bean" property="cattach" value="6">
		<logic:equal value="1" name="bean" property="crequired">
		if ($F('civalue[${ADcheckCount}]').trim() == "") {
			alert("请输入${bean.cname}！");
			return false;
		}
		if ($F('civalue[${ADcheckCount}]').trim().strlen() > 1500) {
			alert("${bean.cname}不能大于" + Math.floor(1500 / strByteFlag) + "个汉字！");
			return false;
		}
		</logic:equal>
		<logic:notEqual value="1" name="bean" property="crequired">
		if ($F('civalue[${ADcheckCount}]').trim().strlen() > 1500) {
			alert("${bean.cname}不能大于" + Math.floor(1500 / strByteFlag) + "个汉字！");
			return false;
		}
		</logic:notEqual>
		</logic:equal>
		<logic:equal name="bean" property="cattach" value="7">
		<logic:equal value="1" name="bean" property="crequired">
		if ($F('civalue[${ADcheckCount}]').trim() == "") {
			alert("请输入${bean.cname}！");
			return false;
		}

		if (checkFloatNum($F('civalue[${ADcheckCount}]').trim())) {
			alert("${bean.cname}为数字,整数位最多13位,小数位最多2位!");
			return false;
		}
		</logic:equal>
		<logic:notEqual value="1" name="bean" property="crequired">
		if (checkFloatNum($F('civalue[${ADcheckCount}]').trim())) {
			alert("${bean.cname}为数字,整数位最多13位,小数位最多2位!");
			return false;
		}
		</logic:notEqual>
		</logic:equal>

		</logic:notEqual>
		<c:set var="ADcheckCount" value="${ADcheckCount+1}"/>
		</logic:iterate>
		</logic:present>
		var xnumValue = document.getElementById("civalue[0]").value
		var ynumValue = document.getElementById("civalue[1]").value
		
		var patrn = /[\/\\:*?<>|\"]+/;

		var s = document.getElementById("civalue[2]").value

		if (patrn.exec(s)) {
			alert("负责人信息不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		var s=document.getElementById("civalue[3]").value
		if (patrn.exec(s)) {
			alert("联系电话不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		if (!checkIsNumber(xnumValue) ||xnumValue>100) {
			
			alert("横向宽(地板) 填写的数值必须为正整数并且不能大于100！");
			return false;
		}

		if (!checkIsNumber(ynumValue) || ynumValue>100) {
			alert("纵向宽(地板) 填写的数值必须为正整数并且不能大于100！");
			return false;
		}
		var message = '<bean:message key="IGCO10000.W001" arg0="机房信息" />';
		if (window.confirm(message)) {
			return true;
		} else {
			return false;
		}
	}

	function toback() {
		form.action = getAppRootUrl() + "/IGASM1101_Back.do?";
		form.submit();
	}
	function checkInteger(obj) {
		if (obj.value.trim() != "") {
			if (!checkIsNumber(obj.value) || obj.value.strlen() > 2) {
				alert("请输入正整数并且不能大于2位！");
				obj.value = "";
			}
		} else {
			obj.value = "";
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

					<div id="location">
						<div class="image"></div>
						<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
					</div>

					<div id="formwrapper">
						<html:form styleId="form" action="/IGASM1102"
							enctype="multipart/form-data"
							onsubmit="return checkSubmit(this);">
							<!--  message -->
							<ig:message />
							<!--  /message -->
							<fieldset>
								<legend>机房信息登记</legend>
     
								<div>
									<span style="color: red;">录入表单信息时，请不要使用特殊字符（如："&gt;"、"&lt;"、"/"等）</span>
								</div>
								<div>
									<label for="Name"><strong><span class="red">*</span>机房编号</strong>：</label>
									<html:text property="eilabel" size="20" tabindex="1"
										errorStyleClass="inputError imeActive" />
									<br>
								</div>
								<div>
									<label for="Name"><strong><span class="red">*</span>机房名称</strong>：</label>
									<html:text property="einame" size="18" style="width:300px;"
										errorStyleClass="inputError imeActive" tabindex="2" />
									<br>
								</div>
								<div>
									<label for="Name"><strong>机房说明</strong>：</label>
									<html:text property="eidesc" styleId="eidesc" size="30"
										tabindex="3" style="width:450px;" errorStyleClass="inputError" />
									<br>
								</div>
								<div>
									<label for="Name"><strong><span class="red">*</span>登记日</strong>：</label>
									<html:text name="IGASM1102Form" property="eiinsdate"
										styleId="eiinsdate" size="12" tabindex="5"
										styleClass="inputDisable"
										errorStyleClass="inputError imeActive" readonly="true" />
									<img src="images/date.gif" align="middle"
										onClick="calendar($('eiinsdate'))" border="0" /> <br>
								</div>
								<logic:present name="IGASM11021VO" property="configurationList">
									<logic:iterate id="bean" name="IGASM11021VO"
										property="configurationList" indexId="number">
										<div
											<logic:equal name="bean" property="cseq" value="2">style="display: none;"</logic:equal>>
											<label for="Name"><strong> <logic:equal
														value="1" name="bean" property="crequired">
														<span class="red">*</span>
													</logic:equal> <logic:empty name="bean" property="cname">&nbsp;</logic:empty>
													${bean.cname}
											</strong>：</label>

											<logic:equal name="bean" property="cattach" value="1">
												<html:file property="attachFile[${ADcount}]"
													styleId="attachFile[${ADcount}]" size="30"
													errorStyleClass="inputError imeActive"
													onkeydown="return false;" styleClass="imeDisabled" />
												<img src="images/empty.gif" align="middle"
													onClick="cleanFile('attachFile[${ADcount}]','civalue[${ADcount}]')"
													border="0" style="cursor: hand" />
												<html:hidden property="civalue[${ADcount}]"
													styleId="civalue" />
											</logic:equal>
											<logic:equal name="bean" property="cattach" value="0">
												<html:text property="civalue[${ADcount}]"
													styleId="civalue[${ADcount}]" size="20"
													errorStyleClass="inputError imeActive" />
											</logic:equal>
											<logic:equal name="bean" property="cattach" value="2">
												<html:select property="civalue[${ADcount}]"
													errorStyleClass="inputError imeActive">
													<html:options collection="ADlist${ADmapcount}"
														property="value" name="" labelProperty="label" />
												</html:select>
												<c:set var="ADmapcount" value="${ADmapcount+1}" />
											</logic:equal>
											<logic:equal name="bean" property="cattach" value="3">
												<html:text property="civalue[${ADcount}]"
													styleId="civalue[${ADcount}]"
													errorStyleClass="inputError imeDisabled" size="20"
													readonly="true" />
												<img src="images/date.gif" align="middle"
													onclick="calendar($('civalue[${ADcount}]'))" border="0"
													style="cursor: hand" />
											</logic:equal>
											<logic:equal name="bean" property="cattach" value="5">
												<table>
													<tr>
														<td><logic:present name="IGASM1102Form"
																property="civalue[${ADcount}]">
																<bean:define id="civalue" name="IGASM1102Form"
																	property="civalue[${ADcount}]" type="java.lang.String" />
																<logic:iterate id="checkboxbean"
																	name="ADlist${ADmapcount}">
																	<bean:define id="cb_civalue" name="checkboxbean"
																		property="value" type="java.lang.String" />
																	<input type="checkbox" name="cb_civalue[${ADcount}]"
																		value="${checkboxbean.value}"
																		<%=ASMHelper.isChecked(civalue,cb_civalue)?"checked='checked'":"" %> />${checkboxbean.value}<br />
																</logic:iterate>
															</logic:present> <logic:notPresent name="IGASM1102Form"
																property="civalue[${ADcount}]">
																<logic:iterate id="checkboxbean"
																	name="ADlist${ADmapcount}">
																	<input type="checkbox" name="cb_civalue[${ADcount}]"
																		value="${checkboxbean.value}" />${checkboxbean.value}<br />
																</logic:iterate>
															</logic:notPresent> <html:hidden property="civalue[${ADcount}]" /></td>
													</tr>
												</table>
											</logic:equal>

											<logic:equal name="bean" property="cattach" value="6">
												<html:textarea property="civalue[${ADcount}]"
													styleId="civalue" errorStyleClass="inputError" rows="5"
													cols="38" />
											</logic:equal>
											<logic:equal name="bean" property="cattach" value="7">
												<html:text property="civalue[${ADcount}]"
													styleId="civalue[${ADcount}]"
													errorStyleClass="inputError imeDisabled" size="17"
													readonly="true"
													onclick="SoftKeyboard($('civalue[${ADcount}]'))" />

											</logic:equal>

											<br>
											<html:hidden property="cid" styleId="cid" value="${bean.cid}" />
											<html:hidden property="clabel" styleId="clabel"
												value="${bean.clabel}" />
											<html:hidden property="ciattach" styleId="ciattach"
												value="${bean.cattach}" />
											<html:hidden property="eid" styleId="eid" value="${bean.eid}" />
										</div>

										<c:set var="ADcount" value="${ADcount+1}" />
									</logic:iterate>
								</logic:present>
							</fieldset>
							<div class="enter">
								<html:submit property="btn_insert" value="提交"
									styleClass="button" onclick="return confirmDisp();" />
								<html:button styleClass="button" property="button" value="返回"
									onclick="toback();" />
							</div>
							<html:hidden property="eid" styleId="eid" />
							<html:hidden property="eiid" styleId="eiid" />
							<html:hidden property="mode" styleId="mode" />
							<html:hidden property="esyscoding" styleId="esyscoding"
								value="999007" />
						</html:form>
					</div>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>


	</div>
</body>
</html:html>
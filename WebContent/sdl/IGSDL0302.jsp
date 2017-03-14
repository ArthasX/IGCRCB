<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSDL0302" toScope="request" />
<bean:define id="title" value="目标基本信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	var gid = "IGSDL0302";
	function confirmDisp(){
		if($F('sdiyear').trim()==""){
			alert("年度不能为空！");
			return false;
		}
		if($F('sdieiid').trim()==""){
			alert("相关资产不能为空！");
			return false;
		}
		var intnum = /^(\+|-)?\d+$/;
		var doublenum = /^(\+|-)?\d+($|\.\d+$)/;
		if($F('sdibreakm').trim()!=""){
			if(!intnum.test($F('sdibreakm').trim())){
				alert("业务中断(月)的时间必须为整数！");
				return false;
			}
			if($F('sdibreakm').trim()>44640){
				alert("业务中断(月)的时间超出范围！");
				return false;
			}
		}

		if($F('sdicontinuousm').trim()!=""){
			if(!doublenum.test($F('sdicontinuousm').trim())){
				alert("业务连续(月)的百分比格式不正确！");
				return false;
			}
			if($F('sdicontinuousm').trim()>100){
				alert("业务连续(月)的百分比超出范围！");
				return false;
			}
		}
		if($F('sdibreaky').trim()!=""){
			if(!intnum.test($F('sdibreaky').trim())){
				alert("业务中断(年)的时间必须为整数！");
				return false;
			}
			if($F('sdibreaky').trim()>535680){
				alert("业务中断(年)的时间超出范围！");
				return false;
			}
		}
		if($F('sdicontinuousy').trim()!=""){
			if(!doublenum.test($F('sdicontinuousy').trim())){
				alert("业务连续(年)的百分比格式不正确！");
				return false;
			}
			if($F('sdicontinuousy').trim()>100){
				alert("业务连续(年)的百分比超出范围！");
				return false;
			}
		}
		if($F('sdiimpactm').trim()!=""){
			if(!intnum.test($F('sdiimpactm').trim())){
				alert("业务受影响(月)的时间必须为整数！");
				return false;
			}
			if($F('sdiimpactm').trim()>535680){
				alert("业务受影响(月)的时间超出范围！");
				return false;
			}
		}
		if($F('sdisteadym').trim()!=""){
			if($F('sdisteadym').trim()!=""&&!doublenum.test($F('sdisteadym').trim())){
				alert("业务稳定(月)的百分比格式不正确！");
				return false;
			}
			if($F('sdisteadym').trim()!=""&&$F('sdisteadym').trim()>100){
				alert("业务稳定(月)的百分比超出范围！");
				return false;
			}
		}
		if($F('sdiimpacty').trim()!=""){
			if($F('sdiimpacty').trim()!=""&&!intnum.test($F('sdiimpacty').trim())){
				alert("业务受影响(年)的时间必须为整数！");
				return false;
			}
			if($F('sdiimpacty').trim()!=""&&$F('sdiimpacty').trim()>535680){
				alert("业务受影响(年)的时间超出范围！");
				return false;
			}
		}
		if($F('sdisteadyy').trim()!=""){
			if($F('sdisteadyy').trim()!=""&&!doublenum.test($F('sdisteadyy').trim())){
				alert("业务稳定(年)的百分比格式不正确！");
				return false;
			}
			if($F('sdisteadyy').trim()!=""&&$F('sdisteadyy').trim()>100){
				alert("业务稳定(年)的百分比超出范围！");
				return false;
			}
		}
		if($F('sdisafecasem').trim()!=""&&!intnum.test($F('sdisafecasem').trim())){
			alert("安全事件数(月)的值必须为整数！");
			return false;
		}
		if($F('sdisafecasey').trim()!=""&&!intnum.test($F('sdisafecasey').trim())){
			alert("安全事件数(年)的值必须为整数！");
			return false;
		}
		if($F('sdicapacitycasem').trim()!=""&&!intnum.test($F('sdicapacitycasem').trim())){
			alert("容量事件数(月)的值必须为整数！");
			return false;
		}
		if($F('sdicapacitycasey').trim()!=""&&!intnum.test($F('sdicapacitycasey').trim())){
			alert("容量事件数(年)的值必须为整数！");
			return false;
		}
		var message = '';
		if ('${IGSDL0302Form.mode}' == '1'){
			message = '<bean:message key="IGCO10000.W003" arg0="服务水平定义基本信息" />';
		} else {
			message = '<bean:message key="IGCO10000.W001" arg0="服务水平定义基本信息" />';
		}
		if( window.confirm(message)){
			return true;
		} else {
			return false;
		}
	}

	//选择资产
	function selectEntity(){
		openSubIGCOM0302();
	}
	
	function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory) {
	    $("sdieiid").value = eiid;
		$("sdieiname").value = einame;
	}

	 function checkIntegerNum(obj){
			if(obj.value!=""){
				if(!checkIsNumberForCSE(obj.value)){
					alert("请输入正整数！");
					obj.value = "";
					obj.focus();
					event.returnValue = false;
				}
			}
			
		}

		function checkIsNumberForCSE(str){
		 	myReg = /^[0-9]{0,}$/;
		 	return myReg.test(str);
		}
	
//-->
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">服务管理 &gt;&gt; 服务水平 &gt;&gt; <logic:equal
	name="IGSDL0302Form" property="mode" value="0">目标登记</logic:equal><logic:equal
	name="IGSDL0302Form" property="mode" value="1">目标变更</logic:equal></p>
<logic:equal name="IGSDL0302Form" property="mode" value="1">
	<div class="back"><a href="IGSDL0301_BACK.do" target="_self">返回</a></div>
</logic:equal></div>
<div id="formwrapper"><html:form action="/IGSDL0302.do">
<ig:message />
	<fieldset><legend>目标信息</legend>
	<table width="600" border="0" cellspacing="1" cellpadding="0"
		class="table_form">
		<tr>
			<td height="5" colspan="6" align="center"></td>
		</tr>
		<tr>
			<td width="34" height="15" align="center"></td>
			<th width="75" align="center" bgcolor="#ebf3f7"><strong><span class="red">*</span>年度</strong>：</th>
			<td colspan="4"><html:select property="sdiyear" tabindex="1">
				<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false" isCodeLabel="true" />
			</html:select></td>
		</tr>
		<tr>
			<td align="center"></td>
			<th align="center" bgcolor="#ebf3f7"><strong><span class="red">*</span>相关资产</strong>：</th>
			<td colspan="4"><html:text property="sdieiname" size="18"
				readonly="true" errorStyleClass="inputError imeActive" tabindex="2" />
			<img src="images/seek.gif" border="0" width="16" height="16" alt="查询"
				onclick="selectEntity()" style="cursor: hand" /></td>
		</tr>
		<tr>
			<td rowspan="4" align="center">&nbsp;</td>
			<th rowspan="4" align="center" bgcolor="#ebf3f7">业务连续性</th>
			<td width="122" align="right"><label for="Name"><strong>业务中断(月)</strong>：</label></td>
			<td width="126"><html:text property="sdibreakm" size="10"
				errorStyleClass="inputError imeActive" tabindex="3" onblur="checkIntegerNum(this)"/> 分钟</td>
			<td width="122" align="right"><label for="Name"><strong>业务连续(月)</strong>：</label></td>
			<td width="122"><html:text property="sdicontinuousm" size="10"
				errorStyleClass="inputError imeActive" tabindex="4" onblur="checkIntegerNum(this)" /> %</td>
		</tr>
		<tr>
			<td align="right"><label for="Name"><strong>业务中断(年)</strong>：</label></td>
			<td><html:text property="sdibreaky" size="10"
				errorStyleClass="inputError imeActive" tabindex="5" onblur="checkIntegerNum(this)"/> 分钟</td>
			<td align="right"><label for="Name"><strong>业务连续(年)</strong>：</label></td>
			<td><html:text property="sdicontinuousy" size="10"
				errorStyleClass="inputError imeActive" tabindex="6" onblur="checkIntegerNum(this)" /> %</td>
		</tr>
		<tr>
			<td align="right"><label for="Name"><strong>业务受影响</strong><strong>(月)</strong>：</label></td>
			<td><html:text property="sdiimpactm" size="10"
				errorStyleClass="inputError imeActive" tabindex="7" onblur="checkIntegerNum(this)" /> 分钟</td>
			<td align="right"><label for="Name"><strong>业务稳定</strong><strong>(月)</strong>：</label></td>
			<td><html:text property="sdisteadym" size="10"
				errorStyleClass="inputError imeActive" tabindex="8" onblur="checkIntegerNum(this)" />  %</td>
		</tr>
		<tr>
			<td align="right"><label for="Name"><strong>业务受影响</strong><strong>(年)</strong>：</label></td>
			<td><html:text property="sdiimpacty" size="10"
				errorStyleClass="inputError imeActive" tabindex="9" onblur="checkIntegerNum(this)" /> 分钟</td>
			<td align="right"><label for="Name"><strong>业务稳定</strong><strong>(年)</strong>：</label></td>
			<td><html:text property="sdisteadyy" size="10"
				errorStyleClass="inputError imeActive" tabindex="10" onblur="checkIntegerNum(this)" /> %</td>
		</tr>
		<tr>
			<td rowspan="2" align="center">&nbsp;</td>
			<th rowspan="2" align="center" bgcolor="#ebf3f7">安全</th>
			<td align="right"><label for="Name"><strong>安全事件数(月)</strong>：</label></td>
			<td><html:text property="sdisafecasem" size="10"
				errorStyleClass="inputError imeActive" tabindex="11" onblur="checkIntegerNum(this)" /></td>
			<td align="right"><label for="Name"><strong>安全评分(月)</strong>：</label></td>
			<td><html:select property="sdisafemarkm"
				errorStyleClass="inputError imeActive" tabindex="12">
				<ig:optionsCollection ccid="SERVICE_LEVEL_GRADE"
					isMakeBlankRow="true" isCodeLabel="true" />
			</html:select></td>
		</tr>
		<tr>
			<td align="right"><label for="Name"><strong>安全事件数(年)</strong>：</label></td>
			<td><html:text property="sdisafecasey" size="10"
				errorStyleClass="inputError imeActive" tabindex="13" onblur="checkIntegerNum(this)" /></td>
			<td align="right"><label for="Name"><strong>安全评分</strong><strong>(年)</strong>：</label></td>
			<td><html:select property="sdisafemarky"
				errorStyleClass="inputError imeActive" tabindex="14">
				<ig:optionsCollection ccid="SERVICE_LEVEL_GRADE"
					isMakeBlankRow="true" isCodeLabel="true" />
			</html:select></td>
		</tr>
		<tr>
			<td align="center">&nbsp;</td>
			<th align="center" bgcolor="#ebf3f7">风险</th>
			<td align="right"><label for="Name"><strong>风险评分(月)</strong>：</label></td>
			<td><html:select property="sdiriskmarkm"
				errorStyleClass="inputError imeActive" tabindex="15">
				<ig:optionsCollection ccid="SERVICE_LEVEL_GRADE"
					isMakeBlankRow="true" isCodeLabel="true" />
			</html:select></td>
			<td align="right"><label for="Name"><strong>风险评分</strong><strong>(年)</strong>：</label></td>
			<td><html:select property="sdiriskmarky"
				errorStyleClass="inputError imeActive" tabindex="16">
				<ig:optionsCollection ccid="SERVICE_LEVEL_GRADE"
					isMakeBlankRow="true" isCodeLabel="true" />
			</html:select></td>
		</tr>

		<tr>
			<td rowspan="2" align="center">&nbsp;</td>
			<th rowspan="2" align="center" bgcolor="#ebf3f7">容量</th>
			<td align="right"><label for="Name"><strong>容量事件数(月)</strong>：</label></td>
			<td><html:text property="sdicapacitycasem" size="10"
				errorStyleClass="inputError imeActive" tabindex="17" onblur="checkIntegerNum(this)" /></td>
			<td align="right"><label for="Name"><strong>容量评分(月)</strong>：</label></td>
			<td><html:select property="sdicapacitymarkm"
				errorStyleClass="inputError imeActive" tabindex="18">
				<ig:optionsCollection ccid="SERVICE_LEVEL_GRADE"
					isMakeBlankRow="true" isCodeLabel="true" />
			</html:select></td>
		</tr>
		<tr>
			<td align="right"><label for="Name"><strong>容量事件数</strong><strong>(年)</strong>：</label></td>
			<td><html:text property="sdicapacitycasey" size="10"
				errorStyleClass="inputError imeActive" tabindex="19" onblur="checkIntegerNum(this)" /></td>
			<td align="right"><label for="Name"><strong>容量评分(年)</strong>：</label></td>
			<td><html:select property="sdicapacitymarky"
				errorStyleClass="inputError imeActive" tabindex="20">
				<ig:optionsCollection ccid="SERVICE_LEVEL_GRADE"
					isMakeBlankRow="true" isCodeLabel="true" />
			</html:select></td>
		</tr>
	</table>

	</fieldset>
	<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return confirmDisp();" /> <html:reset
		property="btn_clear" styleClass="button" value="重置" /></div>
	<html:hidden property="sdiid" styleId="sdiid" />
	<html:hidden property="sdieiid" styleId="sdieiid" />
	<html:hidden property="mode" styleId="mode" />
</html:form></div>

</div>
</div>
</div>
</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDUT0203" toScope="request" />
<bean:define id="title" value="值班日报" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<script type="text/javascript">	
<!--
	WebCalendar.timeShow   = true;          //是否返回时间
	var gid = "IGGUT0203";

	function checkForm(){
		var message = '<bean:message key="IGCO10000.W001" arg0="值班日报基本信息" />';

		<logic:present name="IGDUT02031VO" property="typeMap">
		<logic:iterate id="map" name="IGDUT02031VO" property="typeMap" >
		    <bean:define id="key" name="map" property="key"  />
			<bean:define id="list" name="map" property="value" type="java.util.List" />
				<logic:iterate id="vo" name="list" indexId="number" type="com.deliverik.infogovernor.dut.model.DutyResultVWInfo">
						<logic:equal name="vo" property="dadinfo" value="1">
							if($F('drresults[${ADcheckCount}]').trim()!=""){
								if($F('drresults[${ADcheckCount}]').strlen()>256){
						    		alert("检查内容为\"${vo.dadname}\"的结果说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
						    		
						    		return false;
						    	}
							}
						</logic:equal>
					
						<c:set var="ADcheckCount" value="${ADcheckCount+1}"/>
				</logic:iterate>
		
		</logic:iterate>
		</logic:present>
		
		if($F('dpremarks').strlen()>1024){
			alert("处理记录不能大于"+Math.floor(1024/strByteFlag)+"个汉字！");
			return false;
		}
		if( window.confirm(message)){
			return true;
		} else {
			return false;
		}
	}

//-->
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGDUT0203"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">服务管理 &gt;&gt; 值班管理 &gt;&gt; 值班日报</p>
	</div>
	<div id="formwrapper"><ig:message />
	<fieldset><legend>日报信息</legend>
	<div><label for="Name"><strong>当前值班人</strong>：</label>
	<p class="p2">${IGDUT02031VO.usersinfo}</p>
	</div>
	<div><label for="Name"><strong>值班时间</strong>：</label>
	<p class="p2"><c:if test="${IGDUT02031VO.dptype == 1}">
		<ig:codeValue ccid="DAYSHIFT_DUTY_PERIOD"
			cid="${IGDUT0203Form.dadcategory}001" />-<ig:codeValue
			ccid="DAYSHIFT_DUTY_PERIOD" cid="${IGDUT0203Form.dadcategory}002" />
	</c:if> <c:if test="${IGDUT02031VO.dptype == 2}">
		<ig:codeValue ccid="NIGHTSHIFT_DUTY_PERIOD"
			cid="${IGDUT0203Form.dadcategory}001" />-<ig:codeValue
			ccid="NIGHTSHIFT_DUTY_PERIOD" cid="${IGDUT0203Form.dadcategory}002" />
	</c:if></p>
	</div>
	</fieldset>
	</div>


	<logic:present name="IGDUT02031VO" property="typeMap">
		<div style="margin-left: 20px;">注：实际填报时间为提交时的系统时间，且提交后检查结果不可修改。
		</div>
		<div id="results_list">
		<div id="TabbedPanels1" class="TabbedPanels1">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGDUT02031VO" property="typeMap"
				indexId="number">
				<li class="TabbedPanelsTab"><ig:codeValue ccid="DUTY_TYPE"
					cid="${map.key}" /></li>
			</logic:iterate>
		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGDUT02031VO" property="typeMap">
			<bean:define id="showlist" name="IGDUT02031VO" property="showList" />
			<bean:define id="showResultlist" name="IGDUT02031VO" property="showResultList" />
			<logic:iterate id="map" name="IGDUT02031VO" property="typeMap">
				<bean:define id="key" name="map" property="key" />
				<bean:define id="list" name="map" property="value"
					type="java.util.List" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
						<th width="20%">检查内容</th>
						<th width="8%">检查时间</th>
						<th width="25%">检查结果</th>
						<th width="8%">规定时间</th>
						<th width="14%">实际填报时间</th>
						<th width="25%">结果说明</th>
						<th></th>
					</tr>

					<logic:iterate id="vo" name="list" indexId="number"
						type="com.deliverik.infogovernor.dut.model.DutyResultVWInfo">
						<tr>
							<td>${vo.dadname}</td>

							<td>${vo.dattime}</td>
							<td><ig:dutDadcontentRadio ccid="${vo.dadcontent}"
								radioname="dadcontenttypes[${ADcount}]"
								checkedvalue="${vo.drcontent}" editAble="${showlist[ADcount]}" />
							</td>
							<td>${vo.datlimtime}</td>

							<td>${vo.drfilltime}</td>
							<logic:equal name="vo" property="dadinfo" value="1">
								<td>
									<c:if test="${showResultlist[ADcount]=='show'}">
									<html:text name="IGDUT0203Form"
										property="drresults[${ADcount}]" value="${vo.drresult}"
										size="30" errorStyleClass="inputError" />
									</c:if> 
									<c:if test="${showResultlist[ADcount]!='show'}">
				    					${vo.drresult}
				    				<html:hidden property="drresults[${ADcount}]"
										styleId="drresults[${ADcount}]" name="IGDUT0203Form"
										value="${vo.drresult}" />
									</c:if>
								</td>
							</logic:equal>
							<logic:notEqual name="vo" property="dadinfo" value="1">
								<td><html:hidden property="drresults[${ADcount}]"
									styleId="drresults[${ADcount}]" name="IGDUT0203Form" value="" />
								</td>
							</logic:notEqual>

							<td><html:hidden property="dadids" styleId="dadids"
								name="IGDUT0203Form" value="${vo.dadid}" /> <html:hidden
								property="dadtypes" styleId="dadtypes" name="IGDUT0203Form"
								value="${vo.dadtype}" /> <html:hidden property="dadnames"
								styleId="dadnames" name="IGDUT0203Form" value="${vo.dadname}" />
							<html:hidden property="dattimes" styleId="dattimes"
								name="IGDUT0203Form" value="${vo.dattime}" /> <html:hidden
								property="datlimtimes" styleId="datlimtimes"
								name="IGDUT0203Form" value="${vo.datlimtime}" /> <html:hidden
								property="dadcontents" styleId="dadcontents"
								name="IGDUT0203Form" value="${vo.dadcontent}" /> <html:hidden
								property="drfilltimes" styleId="drfilltimes"
								name="IGDUT0203Form" value="${vo.drfilltime}" /> <html:hidden
								property="dadlimtimes" styleId="dadlimtimes"
								name="IGDUT0203Form" value="${vo.dadlimtime}" /> <html:hidden
								property="dadcontenttypes_hides" styleId="dadcontenttypes_hides"
								name="IGDUT0203Form" value="${vo.drcontent}" /></td>
						</tr>
						<c:set var="ADcount" value="${ADcount+1}" />
					</logic:iterate>
				</table>

				</div>
				</div>
			</logic:iterate>
		</logic:present></div>
		</div>
		</div>
		<div id="results_list">
		<div class="title">
		<div class="name">处理记录</div>
		</div>
		
		<div id="formwrapper">
		<fieldset>
		<div><html:textarea property="dpremarks" styleId="dpremarks" cols="80" errorStyleClass="inputError imeActive"
			rows="8" value="${IGDUT02031VO.dpremarks}"></html:textarea> <br />
		</div>
		</fieldset>
		</div>
		</div>
		<div class="enter"><html:submit property="btn_insert" value="提交"
			styleClass="button" onclick="return checkForm();" /> <html:reset
			property="btn_clear" styleClass="button" value="重置" /></div>
		<html:hidden property="dadcategory" styleId="dadcategory"
			name="IGDUT0203Form" />
	</logic:present>


	<script type="text/javascript">
<!--
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
//-->
</script>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
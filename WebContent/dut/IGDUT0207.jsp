<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGGUT0207" toScope="request" />
<bean:define id="title" value="值班中止" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<script type="text/javascript">	
<!--
	var gid = "IGGUT0207";

	function checkForm(){
		if($F('dpquestion').strlen()>256){
			alert("遗留问题不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
			return false;
		}
		if($F('dpinfo').strlen()>256){
			alert("总结不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
			return false;
		}
		if( window.confirm("您是否确认中止？")){
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
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGDUT0207"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">服务管理 &gt;&gt; 值班管理 &gt;&gt; 值班中止</p>
	</div>
	<div id="formwrapper"><ig:message />
	<fieldset><legend>日报信息</legend>
	<div><label for="Name"><strong>当前值班人</strong>：</label>
	<p class="p2">${IGDUT02071VO.usersinfo}</p>
	</div>
	<div><label for="Name"><strong>值班时间</strong>：</label>
	<p class="p2"><c:if test="${IGDUT02071VO.dutyPlan.dptype == 1}">
		<ig:codeValue ccid="DAYSHIFT_DUTY_PERIOD"
			cid="${IGDUT0207Form.dadcategory}001" />-<ig:codeValue
			ccid="DAYSHIFT_DUTY_PERIOD" cid="${IGDUT0207Form.dadcategory}002" />
	</c:if> <c:if test="${IGDUT02071VO.dutyPlan.dptype == 2}">
		<ig:codeValue ccid="NIGHTSHIFT_DUTY_PERIOD"
			cid="${IGDUT0207Form.dadcategory}001" />-<ig:codeValue
			ccid="NIGHTSHIFT_DUTY_PERIOD" cid="${IGDUT0207Form.dadcategory}002" />
	</c:if></p>
	</div>
	<div><label for="Name"><strong>遗留问题</strong>：</label> <html:textarea
		name="IGDUT0207Form" property="dpquestion" cols="80" rows="5"
		errorStyleClass="inputError" tabindex="1" /></div>
	<div><label for="Name"><strong>总结</strong>：</label> <html:textarea
		name="IGDUT0207Form" property="dpinfo" cols="80" rows="5"
		errorStyleClass="inputError" tabindex="2" /></div>

	</fieldset>
	</div>

		<div class="enter"><html:submit property="btn_insert" value="中止"
			styleClass="button" onclick="return checkForm();" /></div>
</html:form>
<logic:present name="IGDUT02071VO" property="voList">
<div id="TabbedPanels1" class="TabbedPanels">
<ul class="TabbedPanelsTabGroup">
	<logic:present name="IGDUT02071VO" property="voList">
		<logic:iterate id="vo" name="IGDUT02071VO" property="voList"
			indexId="number">
			<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
				ccid="DUTY_TYPE" cid="${vo.dutyResult.dadtype}" /></li>
		</logic:iterate>
	</logic:present>
</ul>
<div class="TabbedPanelsContentGroup"><logic:present
	name="IGDUT02071VO" property="voList">
	<logic:iterate id="vo" name="IGDUT02071VO" property="voList"
		indexId="number">
		<div class="TabbedPanelsContent">
		<div class="record_list">
		<table class="table_style2">
			<tr>
				<th width="20%">检查内容</th>
				<th width="20%">检查结果</th>
				<th width="60%">结果说明</th>
			</tr>
			<tr>
				<td>${vo.dutyResult.dadname}</td>
				<td><ig:codeValue ccid="${vo.dutyResult.dadcontent}"
					cid="${vo.dutyResult.drcontent}" isCcidCode="true" /></td>
				<td>${vo.dutyResult.drresult}</td>
			</tr>
			<logic:present name="vo" property="dutyResultList">
				<logic:iterate id="bean" name="vo" property="dutyResultList">
					<tr>
						<td>${bean.dadname}</td>
						<td><ig:codeValue ccid="${bean.dadcontent}"
							cid="${bean.drcontent}" isCcidCode="true" /></td>
						<td>${bean.drresult}</td>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
		</div>
		</div>
	</logic:iterate>
</logic:present></div>
</div>
<script type="text/javascript">
<!--
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
//-->
</script>
</logic:present>
<div class="Placeholder"></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
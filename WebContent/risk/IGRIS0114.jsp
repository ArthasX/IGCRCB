<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGRIS0114" toScope="request" />
<bean:define id="title" value="审计评估详细画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var gid='IGRIS0114';

function checkForm(){
	if($F('raroverallscore').trim() == ""){
		alert("请选择总体评分！");
		return false;
	}
	if($F('raroveralldesc').trim() == ""){
		alert("请输入总体评价！");
		return false;
	}
	if($F('rarplandesc').strlen()>512){
		alert("制度建设评分不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('rarexecdesc').strlen()>512){
		alert("制度执行评分不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('raroveralldesc').strlen()>512){
		alert("总体评分不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
		return false;
	}
	var message = '<bean:message key="IGCO10000.W001" arg0="审计评估信息" />';
	if( window.confirm(message)){
		return true;
	} else {
		return false;
	}
}

	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">服务管理 &gt;&gt; 风险审计 &gt;&gt; 审计评估</p>
<div class="back"><a href="IGRIS0113.do" target="_self">返回</a></div>
</div>
<div id="formwrapper"><html:form styleId="form"
	action="/IGRIS0114" onsubmit="return checkSubmit(this);">
	
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
	<legend>审计评估信息</legend>
	<div><label for="Name"><strong>制度建设评分</strong>：</label>
	<html:select property="rarplanscore" name="IGRIS0114Form" styleId="rarplanscore">
		<ig:optionsCollection ccid="RARPLANSCORE_CODE" isMakeBlankRow="true"
			isCodeLabel="true" />
	</html:select>
	<br />
	</div>
	<div><label for="Name"><strong>制度建设评价</strong>：</label>
	<html:textarea
		property="rarplandesc" cols="60" rows="6" errorStyleClass="inputError imeActive" name="IGRIS0114Form" styleId="rarplandesc"/> <br />
	<br/>
	</div>
	
	<div><label for="Name"><strong>制度执行评分</strong>：</label>
	<html:select property="rarexecscore" name="IGRIS0114Form" styleId="rarexecscore">
		<ig:optionsCollection ccid="RAREXECSCORE_CODE" isMakeBlankRow="true"
			isCodeLabel="true" />
	</html:select>
	<br />
	</div>
	<div><label for="Name"><strong>制度执行评价</strong>：</label>
	<html:textarea
		property="rarexecdesc" cols="60" rows="6" errorStyleClass="inputError imeActive" name="IGRIS0114Form" styleId="rarexecdesc"/> <br />
	<br/>
	</div>
	
	<div><label for="Name"><strong><span class="red">*</span>总体评分</strong>：</label>
	<html:select property="raroverallscore" name="IGRIS0114Form" styleId="raroverallscore">
		<ig:optionsCollection ccid="RAROVERALLSCORE_CODE" isMakeBlankRow="true"
			isCodeLabel="true" />
	</html:select>
	<br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>总体评价</strong>：</label>
	<html:textarea
		property="raroveralldesc" cols="60" rows="6" errorStyleClass="inputError imeActive" name="IGRIS0114Form" styleId="raroveralldesc"/> <br />
	<br/>
	</div>
	</fieldset>
	<div class="enter"><html:submit property="btn_insert" value="提交" styleClass="button" onclick="return checkForm();"/> 
	<html:reset property="btn_clear" styleClass="button" value="重置" /></div>
	<html:hidden property="rarid" name="IGRIS0114Form" styleId="rarid"/>
	<html:hidden property="radid" name="IGRIS0114Form" styleId="radid"/>
	<html:hidden property="raiid" name="IGRIS0114Form" styleId="raiid"/>
	<html:hidden property="raruserid" name="IGRIS0114Form" styleId="raruserid"/>
	<html:hidden property="rarusername" name="IGRIS0114Form" styleId="rarusername"/>
	<html:hidden property="rardate" name="IGRIS0114Form" styleId="rardate"/>
	<html:hidden property="radcode" name="IGRIS0114Form" styleId="radcode"/>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<%@ page import="com.csebank.lom.bl.IGLOMCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGLOM0518" toScope="request" />
<bean:define id="title" value="餐卡登记画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function toback(){
	form.action = getAppRootUrl() + "/IGLOM0518.do";
	form.submit();
}
function confirmDisp(){

	if($F('typename').trim()==""){
		alert("请添写餐卡名称！");
		return false;
	}
	if($F('prince').trim()==""){
		alert("请添写餐卷面值！");
		return false;
	}
	if($F('typename').strlen()>30){
		alert("餐卡名称不能大于"+Math.floor(30/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('allowance').trim()==""){
		document.forms[0].allowance.value = "0";
	}
	var message = '';
    if ('${IGLOM0518Form.mode}' == '0'){
        message = '<bean:message key="IGCO10000.W001" arg0="餐卡信息" />';
    } else {
        message = '<bean:message key="IGCO10000.W003" arg0="餐卡信息" />';
    }
	if( window.confirm(message)){
		return true;
	} else {
		return false;
	}
	
}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 
<logic:equal name="IGLOM0518Form" property="mode" value="0">
餐卡登记
</logic:equal>
<logic:equal name="IGLOM0518Form" property="mode" value="1">
餐卡管理&gt;&gt;餐卡编辑
</logic:equal>
</p>
<logic:equal name="IGLOM0518Form" property="mode" value="1">
	<div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
</logic:equal>
</div>
			<div id="formwrapper">
            <html:form styleId="form" action="/IGLOM0518" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					<logic:equal name="IGLOM0518Form" property="mode" value="0">
					    <legend>餐卡信息添加</legend>
					</logic:equal>
					<logic:equal name="IGLOM0518Form" property="mode" value="1">
	                          <legend>餐卡信息变更</legend>
					</logic:equal>				
					
					<div>
						<label for="Name"><strong><span class="red">*</span>餐卡名称</strong>：</label>
						<html:text name="IGLOM0518Form" property="typename" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="1" />
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><strong><span class="red">*</span>餐券面值</strong>：</label>
						<html:text name="IGLOM0518Form" property="prince" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="2" 
						onblur="checkFloatNum(this,'餐券面值整数部分最大为10位，小数部分为2位！','餐券面值整数部分最大为10位，小数部分为2位！');"/>
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><strong>补贴</strong>：</label>
						<html:text name="IGLOM0518Form" property="allowance" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="3" 
						onblur="checkFloatNum(this,'补贴整数部分最大为10位，小数部分为2位！','补贴整数部分最大为10位，小数部分为2位！');"/>
						<br>
    				</div>
    			</fieldset>
				<div class="enter">
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
				    <html:reset  property="btn_clear" styleClass="button" value="重置" />
				</div>
				<html:hidden property="mode" styleId="mode" name="IGLOM0518Form"/>
				<html:hidden property="icid" styleId="icid" name="IGLOM0518Form"/>
				<html:hidden property="typecode" styleId="typecode" name="IGLOM0518Form"/>
				<html:hidden property="type" styleId="type" name="IGLOM0518Form"/>
				<html:hidden property="selectid" styleId="selectid" name="IGLOM0518Form"/>
				<html:hidden property="desc" styleId="desc" name="IGLOM0518Form"/>
            </html:form>
            </div>
</div>
</div>
</div>
</div>
</body>
</html:html>
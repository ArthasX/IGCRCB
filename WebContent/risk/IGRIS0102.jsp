<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGRIS0102" toScope="request"/>
<bean:define id="title" value="审计版本信息登记画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	    function checkForm(){
	    	if($F('raversion').trim() == ""){
	    		alert("请输入版本名称！");
	    		return false;
	    	}
	    	if($F('raversion').strlen()>32){
	    		alert("版本名称不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
	    		return false;
	    	}if($F('radesc').strlen()>128){
	    		alert("说明不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
	    		return false;
	    	}else {
	    		var message = '<bean:message key="IGCO10000.W001" arg0="审计版本信息" />';
				if( window.confirm(message)){
					return true;
				} else {
					return false;
				}
	    	}
	    }
	    function toback() {
	    	var url = window.location.search;
	    	var cwrid = url.substring(url.lastIndexOf('=')+1, url.length);
	    	window.location.href = getAppRootUrl() + "/IGRIS0203_sel.do?cwrid="+cwrid;
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
                <p class="fonts1">信息安全 &gt;&gt; 风险审计 &gt;&gt; 创建版本</p>
            </div>
            <div id="formwrapper">
            <html:form styleId="form" action="/IGRIS0102" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					    <legend>审计版本信息</legend>
                    <div>
						<label for="Name"><strong><span class="red">*</span>版本名称</strong>：</label>
						<html:text name="IGRIS0102Form" property="raversion" styleId="raversion" size="8" style="width:200px;" errorStyleClass="inputError" tabindex="1"/>
						<br>
    				</div>
	       			<div>
					    <label for="Name"><strong>说明</strong>：</label>
					    <html:text name="IGRIS0102Form" property="radesc" styleId="radesc" tabindex="2" size="41" style="width:450px;" errorStyleClass="inputError"/>
					    <br>
    				</div>
    				</fieldset>
				<div class="enter">
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
				</div>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
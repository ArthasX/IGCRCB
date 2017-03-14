<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGSMR0101" toScope="request"/>
<bean:define id="title" value="年报填报发起" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	    function checkForm(){
	    	var limittime =document.getElementById('limittime').value;
	    	if($F('year').trim() == ""){
	    		alert("请选择年份！");
	    		return false;
	    	}
	    	if($F('limittime').trim() == ""){
	    		alert("请输入填报限制时间！");
	    		return false;
	    	}
	    	if($F('remark').strlen()>300){
	    		alert("备注不能大于"+Math.floor(300/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	var time=parseInt(limittime.substring(0,4));
	    	var year = parseInt(document.getElementById('year').value);
	    	if(year>time){
	    		alert("填报限制时间不能小于发起年份！");
		    	return false;
	    	}else{             
	    		var message = '请确认是否要进行年报填报发起处理？';
				if(window.confirm(message)){
					screenLayer();
					document.forms[0].submit();
					return true;
				} else {
					return false;
				}
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
                <p class="fonts1"><ig:navigation /></p>
            </div>
            <div id="formwrapper">
            <html:form styleId="form" action="/IGSMR0101" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					    <legend>基本信息</legend>
                    <div>
						<label for="Name"><strong><span class="red">*</span>年份</strong>：</label>
						<html:select name="IGSMR0101Form" property="year" styleId="year" style="width:100px;" errorStyleClass="inputError" tabindex="1">
							<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="true" isCodeLabel="true" />    
		     			</html:select>
						<br>
    				</div>
                    <div>
						<label for="Name"><strong><span class="red">*</span>填报限制时间</strong>：</label>
						<html:text name="IGSMR0101Form" readonly="true" property="limittime" styleId="limittime" style="width:100px;" errorStyleClass="inputError" tabindex="2"/>
						<img src="images/date.gif" align="middle" onclick="showDate($('limittime'))" border="0" style="cursor: hand" />
						<br>
    				</div>
	       			<div>
					    <label for="Name"><strong>备注</strong>：</label>
					    <html:textarea name="IGSMR0101Form" property="remark" styleId="remark" errorStyleClass="inputError" rows="6" cols="50" tabindex="3"/>
					    <br>
    				</div>
    				</fieldset>
				<div class="enter">
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
				    <html:hidden property="test" name="IGSMR0101Form" styleId="test"/>
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
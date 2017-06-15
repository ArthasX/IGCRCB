<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGLOM0501" toScope="request"/>
<logic:equal name="IGLOM0501Form" property="mode" value="0">
<bean:define id="title" value="成本登记" toScope="request"/>
</logic:equal>
<logic:equal name="IGLOM0501Form" property="mode" value="1">
<bean:define id="title" value="成本变更" toScope="request"/>
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

		function confirmDisp(){

			if($F('edate').trim()==""){
	    		alert("请选择日期！");
	    		return false;
	    	}
			var message = '';
            if ('${IGLOM0501Form.mode}' == '0'){
                message = '<bean:message key="IGCO10000.W001" arg0="食堂成本信息" />';
            } else {
                message = '<bean:message key="IGCO10000.W003" arg0="食堂成本信息" />';
            }
			if( window.confirm(message)){
				if(document.forms[0].estaplecost.value == ""){
					document.forms[0].estaplecost.value = "0";
				}
				if(document.forms[0].eflavouringcost.value == ""){
					document.forms[0].eflavouringcost.value = "0";
				}
				if(document.forms[0].eothercost.value == ""){
					document.forms[0].eothercost.value = "0";
				}
				return true;
			} else {
				return false;
			}
			
		}
		
		function toback(){
			if(document.forms[0].estaplecost.value == ""){
				document.forms[0].estaplecost.value = "0";
			}
			if(document.forms[0].eflavouringcost.value == ""){
				document.forms[0].eflavouringcost.value = "0";
			}
			if(document.forms[0].eothercost.value == ""){
				document.forms[0].eothercost.value = "0";
			}
	    	form.action = getAppRootUrl() + "/IGLOM0501_RE.do";
			form.submit();
	    }

	    function checkNum(obj){
	    	if(obj.value!=""){
	    		if(!checkIsNumberForCSE(obj.value)){
	    			alert("请输入最大长度为9位的正整数！");
	    			obj.value = "";
	    			obj.focus();
	    			event.returnValue = false;
	    		}
	    	}
	    	
	    }

	    function checkIsNumberForCSE(str){
	     	myReg = /^[1-9][0-9]{0,8}$/;
	    	
	     	return myReg.test(str);
	    }
	    
	</script>
<body">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 
	                <logic:equal name="IGLOM0501Form" property="mode" value="0">
	                                             成本登记
	                </logic:equal>
					<logic:equal name="IGLOM0501Form" property="mode" value="1">
					成本管理 &gt;&gt; 成本变更
					</logic:equal>
                </p>
                <logic:equal name="IGLOM0501Form" property="mode" value="1">
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
                </logic:equal>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGLOM0501" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					<logic:equal name="IGLOM0501Form" property="mode" value="0">
					    <legend>成本信息添加</legend>
					</logic:equal>
					<logic:equal name="IGLOM0501Form" property="mode" value="1">
	                          <legend>成本信息变更</legend>
					</logic:equal>
					
					<div><label for="Name"><strong><span class="red">*</span>日期</strong>：</label>
					<html:text property="edate" styleId="edate"
							   errorStyleClass="inputError imeDisabled" size="18" readonly="true" />
					<logic:equal name="IGLOM0501Form" property="mode" value="0">
	                    <img src="images/date.gif" align="middle"
							 onclick="calendar($('edate'))" border="0" style="cursor: hand" /><br />
	                </logic:equal>
					
					</div>					
					
					<div>
						<label for="Name"><strong>采购原料成本</strong>：</label>
						<html:text name="IGLOM0501Form" property="estaplecost" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="2" 
						onblur="checkFloatNum(this,'采购原料成本整数部分最大为10位，小数部分为2位！','采购原料成本请输入数字！');"/>
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><strong>酒成本</strong>：</label>
						<html:text name="IGLOM0501Form" property="eflavouringcost" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="3" 
						onblur="checkFloatNum(this,'酒成本整数部分最大为10位，小数部分为2位！','酒成本请输入数字！');"/>
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><strong>其他成本</strong>：</label>
						<html:text name="IGLOM0501Form" property="eothercost" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="4" 
						onblur="checkFloatNum(this,'其他成本整数部分最大为10位，小数部分为2位！','其他成本请输入数字！');"/>
						<br>
    				</div>
    			</fieldset>
				<div class="enter">
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
				    <html:reset  property="btn_clear" styleClass="button" value="重置" />
				</div>
				<html:hidden property="mode" styleId="mode" name="IGLOM0501Form"/>
				<html:hidden property="eid" styleId="eid" name="IGLOM0501Form"/>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
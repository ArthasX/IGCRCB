<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="title" value="模型基本信息变更画面" toScope="request"/>
<bean:define id="id" value="IGCIM1205" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		window.onunload = function(){ 
			var eid = $('eidStr').value;
			this.opener.parent.location.href = getAppRootUrl() + '/IGAIM0401_Disp.do';
        	//this.opener.location.href = getAppRootUrl()+'/IGAIM0406_Disp.do?eid='+eid;;       
        };

	    function checkForm(){
	    	var enopatrn =/^[0-9]{3}$/;

	    	var s=$F('ename');
			
	        if($F('eparname').trim()==""){
	    		alert("请选择上级模型！");
	    		return false;
	    	}
			
	    	if($F('ename').trim()==""){
	    		alert("请输入模型名称！");
	    		return false;
	    	}
	    	if($F('ename').strlen()>120){
	    		alert("模型名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	
	    	if($F('edesc').strlen()>256){
	    		alert("模型说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
	    		return false;
	    	}else {
	    		var message = '';
	            if ('${IGCIM0402Form.mode}' == '0'){
	                message = '<bean:message key="IGCO10000.W001" arg0="模型基本信息" />';
	            } else {
	                message = '<bean:message key="IGCO10000.W003" arg0="模型基本信息" />';
	            }
				if( window.confirm(message)){
					//window.opener.location.href=getAppRootUrl()+'/IGAIM0406_Disp.do?eid='+eid;
					window.close();
					return true;
				} else {
					return false;
				}
				
	    	}
	    }
	</script>
<body>
<div id="maincontent">
<!--container 左菜单 右侧内容-->
<div > 
 <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <div id="formwrapper">
            <html:form styleId="form" action="/IGAIM0402" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
	                 <legend>基本信息变更</legend>
					 <div>
						<label for="Name"><strong><span class="red">*</span>上级模型</strong>：</label>
						<logic:equal name="IGCIM0402Form" property="mode" value="0">
						<html:text name="IGCIM0402Form" property="eparname" style="width:85;" errorStyleClass="inputError" tabindex="5" readonly="true"/>
						<img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity();"/>
						</logic:equal>
						<logic:equal name="IGCIM0402Form" property="mode" value="1">
						<html:text name="IGCIM0402Form" property="eparname" style="width:85;" errorStyleClass="inputError" tabindex="5" readonly="true" styleClass="inputDisable"/>
						</logic:equal>
						<br>
    				</div>
    				
    				<div>
    					<label for="Name"><strong><span class="red">*</span>模型编码</strong>：</label>
    					<html:text name="IGCIM0402Form" property="eidStr" style="width:85;" errorStyleClass="inputError" tabindex="5" readonly="true" styleClass="inputDisable"/>
    				</div>
					
                    <div>
						<label for="Name"><strong><span class="red">*</span>模型名称</strong>：</label>
						<html:text name="IGCIM0402Form" property="ename" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="2"/>
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><strong><span class="red">*</span>父类属性</strong>：</label>
							<html:radio name="IGCIM0402Form" property="ekey2" value="0" >继承</html:radio>
							&nbsp;&nbsp;
							<html:radio name="IGCIM0402Form" property="ekey2" value="1">不继承</html:radio>
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><strong><span class="red">*</span>资产树上显示</strong>：</label>
							<html:radio name="IGCIM0402Form" property="ekey1" value="0" >显示</html:radio>
							&nbsp;&nbsp;
							<html:radio name="IGCIM0402Form" property="ekey1" value="1">不显示</html:radio>
						<br>
    				</div>
    				
	       			<div>
					    <label for="Name"><strong>模型说明</strong>：</label>
					    <html:text name="IGCIM0402Form" property="edesc" styleId="edesc" tabindex="3" size="41" style="width:250px;" errorStyleClass="inputError"/>
					    <br>
    				</div>
    				</fieldset><html:hidden property="esyscoding"/>
				<html:hidden property="eparcoding"/>
				<html:hidden property="estatus"/>
				<div class="enter">
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
				    <logic:equal name="IGCIM0402Form" property="mode" value="1">
				    <input type="button" class="button" value="取消" onclick="window.close();">
				    </logic:equal>
				</div>
		        <html:hidden property="eid" styleId="eid"/>
		        <html:hidden property="mode" styleId="mode"/>
		        <html:hidden property="ecategory" styleId="ecategory"/>
		        <html:hidden property="emodeltype" styleId="emodeltype"/>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
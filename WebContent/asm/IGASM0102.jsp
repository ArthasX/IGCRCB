<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0102" toScope="request"/>
<logic:equal name="IGASM0102Form" property="mode" value="0">
<bean:define id="title" value="模型基本信息登记画面" toScope="request"/>
</logic:equal>
<logic:equal name="IGASM0102Form" property="mode" value="1">
<bean:define id="title" value="模型基本信息变更画面" toScope="request"/>
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

		function confirmDisp(){
			var message = '';
            if ('${IGASM0102Form.mode}' == '0'){
                message = '<bean:message key="IGCO10000.W001" arg0="模型基本信息" />';
            } else {
                message = '<bean:message key="IGCO10000.W003" arg0="模型基本信息" />';
            }
			if( window.confirm(message)){
				return true;
			} else {
				return false;
			}
		}
		
	    function toback(){
	        form.action = getAppRootUrl() + "/IGASM0102.do?org.apache.struts.taglib.html.CANCEL=1";
	        form.submit();
	    }

	    function setEntity(url){

			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				document.forms[0].eparname.value = "";
				document.forms[0].eparcoding.value = "";
				document.forms[0].ecategory.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){

				var syscode_eid = temp.split("|")[0];
				var name = temp.split("|")[1];
				var syscode;
				var eid;
				var ecategory;
				if(syscode_eid =="999")
				{
					eid = "";
					syscode = syscode_eid;
					
				}else if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
					ecategory = syscode_eid.split("_")[2];
				document.forms[0].ecategory.value = ecategory;
				}
				document.forms[0].eparname.value = name;
				document.forms[0].eparcoding.value = syscode;
			//	document.forms[0].esyscoding.value = syscode;
			
			}		
			
		}
	    function checkForm(){
	    	var patrn=/[\/\\:*?<>|\"]+/;

	    	var s=$F('ename');
			
			 if(patrn.exec(s))
	    	{   
	    		alert("文件名不能包含下列字符:  "+"\/\\:*?\"<>|");
	    		return false;
	    	}
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
	    	}if($F('edesc').strlen()>256){
	    		alert("模型说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
	    		return false;
	    	}else {
	    		var message = '';
	            if ('${IGASM0102Form.mode}' == '0'){
	                message = '<bean:message key="IGCO10000.W001" arg0="模型基本信息" />';
	            } else {
	                message = '<bean:message key="IGCO10000.W003" arg0="模型基本信息" />';
	            }
				if( window.confirm(message)){
					return true;
				} else {
					return false;
				}
				
	    	}
	    }
	</script>
<body >
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
                <p class="fonts1">资产管理 &gt;&gt; 模型管理 &gt;&gt; 
	                <logic:equal name="IGASM0102Form" property="mode" value="0">
	                                             模型登记
	                </logic:equal>
					<logic:equal name="IGASM0102Form" property="mode" value="1">
					模型查询 &gt;&gt; 模型变更
					</logic:equal>
                </p>
                <logic:equal name="IGASM0102Form" property="mode" value="1">
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
                </logic:equal>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGASM0102" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					<logic:equal name="IGASM0102Form" property="mode" value="0">
					    <legend>基本信息添加</legend>
					</logic:equal>
					<logic:equal name="IGASM0102Form" property="mode" value="1">
	                          <legend>基本信息变更</legend>
					</logic:equal>
					 <div>
						<label for="Name"><strong><span class="red">*</span>上级模型</strong>：</label>
						<logic:equal name="IGASM0102Form" property="mode" value="0">
						<html:text name="IGASM0102Form" property="eparname" style="width:85;" errorStyleClass="inputError" tabindex="5" readonly="true"/>
						<img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity('IGSYM1201_ENTITY_TREE.do?levelnode=999&type=0&socflag=yes');"/>
						</logic:equal>
						<logic:equal name="IGASM0102Form" property="mode" value="1">
						<html:text name="IGASM0102Form" property="eparname" style="width:85;" errorStyleClass="inputError" tabindex="5" readonly="true" styleClass="inputDisable"/>
						</logic:equal>
						<br>
    				</div>
    		
					
                    <div>
						<label for="Name"><strong><span class="red">*</span>模型名称</strong>：</label>
						<html:text name="IGASM0102Form" property="ename" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="2"/>
						<br>
    				</div>
	       			<div>
					    <label for="Name"><strong>模型说明</strong>：</label>
					    <html:text name="IGASM0102Form" property="edesc" styleId="edesc" tabindex="3" size="41" style="width:450px;" errorStyleClass="inputError"/>
					    <br>
    				</div>
    				</fieldset><html:hidden property="esyscoding"/>
				<html:hidden property="eparcoding"/>
				<html:hidden property="estatus"/>
				<div class="enter">
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();confirmDisp();"  />
				    <logic:equal name="IGASM0102Form" property="mode" value="1">
				    <html:cancel styleClass="button" value="返回"/>
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
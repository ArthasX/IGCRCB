<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGAIM0402" toScope="request"/>
<bean:define id="title" value="模型基本信息登记画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	    function setEntity(){
			 var alertMessage = '<bean:message bundle="asmResources" key="message.IGCIM0101.005"/>';
				var url = "IGCIM1203_ENTITY_TREE.do?levelnode=999";

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

		function load(){
			document.all('ekey1')[0].checked = true;
			document.all('ekey2')[0].checked = true;
		}
		
	    function checkForm(){
	    	var patrn=/[\/\\:*?<>&;|\"\']+/;
	    	var enopatrn =/^[0-9]{3}$/;

	    	var s=$F('ename');
	    	var eno=$F('eno').trim();
			
			if(patrn.exec(s)){   
	    		alert("文件名不能包含下列字符:  "+"\/\\:*?\"'<>&;|");
	    		return false;
	    	}
	        if($F('eparname').trim()==""){
	    		alert("请选择上级模型！");
	    		return false;
	    	}
	        if(eno==""){
				alert("请输入模型编号！");
				return false;
			}
	        if(!enopatrn.exec(eno)){
				alert("模型编号必须是3位数字！");
				return false;
			}

	        var flag = false;
	    	var eid = 'CM'+$F('type1')+$F('type2')+'1'+eno;
    		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,
    				{asynchronous:false,parameters:'type=checkEntityID&eid='+eid,
    				 onSuccess:  function(req, json){
    			 					result=req.responseText;
    								if(result == "yes") {
    									flag = true;
    			  					}
    		     			}
    				});
	    	if(flag){
				alert("模型编号已经存在！");
				return false;
		    }else{
				$('eid').value = eid;
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
	    		var message = '<bean:message key="IGCO10000.W001" arg0="模型基本信息" />';
				if( window.confirm(message)){
					return true;
				} else {
					return false;
				}
				
	    	}
	    }
	</script>
<body onload="load();">
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
                <p class="fonts1">配置管理 &gt;&gt; 配置模型 &gt;&gt;模型登记
                </p>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGAIM0402" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					 <legend>基本信息添加</legend>
					 <div>
						<label for="Name"><strong><span class="red">*</span>上级模型</strong>：</label>
						<html:text name="IGCIM0402Form" property="eparname" style="width:85;" errorStyleClass="inputError" tabindex="5" readonly="true"/>
						<img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity();"/>
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><strong><span class="red">*</span>模型类别</strong>：</label>
							<html:select property="type1" name="IGCIM0402Form" >
								<logic:iterate name="IGCIM04021VO" property="types1" id="bean1" >
									<html:option value="${bean1.cvalue}">${bean1.cdinfo}</html:option>
								</logic:iterate>
							</html:select>&nbsp;&nbsp;&nbsp;
							<html:select property="type2" name="IGCIM0402Form" >
								<logic:iterate name="IGCIM04021VO" property="types2" id="bean2" >
									<html:option value="${bean2.cvalue}">${bean2.cdinfo}</html:option>
								</logic:iterate>
							</html:select>
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><strong><span class="red">*</span>模型编号</strong>：</label>
						<html:text name="IGCIM0402Form" property="eno" size="18" style="width:160px;" errorStyleClass="inputError" tabindex="2"/>
						<br>
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
					    <html:text name="IGCIM0402Form" property="edesc" styleId="edesc" tabindex="3" size="41" style="width:450px;" errorStyleClass="inputError"/>
					    <br>
    				</div>
    				</fieldset><html:hidden property="esyscoding"/>
				<html:hidden property="eparcoding"/>
				<html:hidden property="estatus"/>
				<div class="enter">
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM0122" toScope="request"/>
<bean:define id="title"  toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0122"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
         var gid='IGCIM0122';

		 function checkForm(){
			 var alertModelName= '<bean:message bundle="asmResources" key="message.IGCIM0122.001"/>';
			 var alertOrgan= '<bean:message bundle="asmResources" key="message.IGCIM0122.002"/>';
			 var alertNO= '<bean:message bundle="asmResources" key="message.IGCIM0122.003"/>';
			 var alertName= '<bean:message bundle="asmResources" key="message.IGCIM0122.004"/>';
			 var alertMarkDay= '<bean:message bundle="asmResources" key="message.IGCIM0122.005"/>';
			 var alertMaxCount= '<bean:message bundle="asmResources" key="message.IGCIM0122.006"/>';
			 var argName= '<bean:message bundle="asmResources" key="message.IGCIM0122.007"/>';
			 var argNameCount= '<bean:message bundle="asmResources" key="message.IGCIM0122.008"/>';
			 var argRemark= '<bean:message bundle="asmResources" key="message.IGCIM0122.009"/>';
			 var argRemarkCount= '<bean:message bundle="asmResources" key="message.IGCIM0122.0010"/>';
			 var argMessage= '<bean:message bundle="asmResources" key="message.IGCIM0122.0011"/>';
		    	if($F('ename').trim()==""){
		    		alert(alertModelName);
		    		return false;
		    	}
		    	if($F('eiorgname').trim()==""){
					alert(alertOrgan);
					return false;
				}
		    	if($F('eilabel').trim()==""){
		    		alert(alertNO);
		    		return false;
		    	}
		    	if($F('einame').trim()==""){
		    		alert(alertName);
		    		return false;
		    	}
		    	if($F('eiinsdate').trim()==""){
		    		alert(alertMarkDay);
		    		return false;
		    	}if($F('eilabel').strlen()>128){
		    		alert(alertMaxCount);
		    		return false;
		    	}if($F('einame').strlen()>120){
		    		alert(argName+Math.floor(120/strByteFlag)+argNameCount);
		    		return false;
		    	}if($F('eidesc').strlen()>256){
		    		alert(argRemark+Math.floor(256/strByteFlag)+argRemarkCount);
		    		return false;
		    	}else {
		    		var message = '<bean:message key="IGCO10000.W001" arg0="'+argMessage+'" />';
					if( window.confirm(message)){
						return true;
					} else {
						return false;
					}
		    	}
		 }
		 function setRoleDomain(url){
				url = url+"?roletype=IGCI01";
				var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
				if("_resetall"==temp){
					document.forms[0].eiorgsyscoding.value = "";
					document.forms[0].eiorgname.value = "";
					return false;
				}
				if(null!=temp && temp.split("|").length>1){
					document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
					document.forms[0].eiorgname.value = temp.split("|")[1];
				}		
			}
	    function setOrg(url){
		   	 
	    	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	    	if("_resetall"==temp){
				document.forms[0].eiorgsyscoding.value = "";
				document.forms[0].eiorgname.value = "";
				return false;
			}
	    	if(null!=temp && temp.split("|").length>1){
	    		document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
	    		document.forms[0].eiorgname.value = temp.split("|")[1];
	    	}		
	    }
	    function setEntity(url){
	    	url = url+"?roletype=IGCI01&subtype=999003";
			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			var argMessage= '<bean:message bundle="asmResources" key="message.IGCIM0122.0012"/>';
			if("_resetall"==temp){
				document.forms[0].ename.value = "";
				document.forms[0].eid.value = "";
				document.forms[0].esyscoding.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
				var syscode_eid = temp.split("|")[0];
				var name = temp.split("|")[1];
				var syscode;
				var eid;
				if(syscode_eid =="999")
				{
					alert(argMessage);
					return false;
					
				}else if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
				}
				document.forms[0].ename.value = name;
				document.forms[0].eid.value = eid;
				document.forms[0].esyscoding.value = syscode;
			}		
	}
	    function searchMaxEntityItemLable(){
	    	var argMessage= '<bean:message bundle="asmResources" key="message.IGCIM0122.0013"/>';
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ parameters: 'ecategorykey=YYZC&type=eilable',
				 onSuccess:  function(req, json){
				 	var result = req.responseText;
					if(result != null && result.trim() != ""){	
						document.getElementById("eilabel").value = result;
					} else {
						document.getElementById("labelMessage").innerText =argMessage;
					}
			     }
				});
		}
	    function clear(){
	    	document.forms[0].eilabel.value = '';
		}
	    function toback(){
	        form.action = getAppRootUrl() + "/IGCIM0121_Disp.do?";
	        form.submit();
	    }
	</script>
<body onload="clear();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1">
                	<ig:navigation extname1="${urlable}"/> &gt;&gt; 应用信息登记
                </p>
                <div class="back"><html:link href="javascript:toback();"><bean:message bundle="asmResources" key="button.IGCIM0122.btn_toback"/></html:link></div>
            </div>
            
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGCIM0122" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                    <logic:equal name="IGCIM0122Form" property="mode" value="0">
			            <legend><bean:message bundle="asmResources" key="label.IGCIM0122.InfoAdd"/></legend>
			            </logic:equal>
	                    <logic:equal name="IGCIM0122Form" property="mode" value="1">
	                    <legend><bean:message bundle="asmResources" key="label.IGCIM0122.InfoChange"/></legend>
	                    </logic:equal>
	                    
			            
			             <div>
                            <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0122.ModelName"/></strong>：</label>
                            <html:text property="ename" errorStyleClass="inputError imeActive" readonly="true" tabindex="2"/>
                             <img src="images/tree.gif" style="cursor: hand;" alt='<bean:message bundle="asmResources" key="img.IGCIM0122.AssetModel.alt"/>'  width="16" height="16" border="0" onclick="setEntity('IGSYM0304_ASSET.do');"/>
                            <br>
                        </div>
                        <div><label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0122.BelongToOrgan"/></strong>：</label>
							<html:text property="eiorgname" readonly="true" errorStyleClass="inputError imeActive"></html:text>
							<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0304.do');" alt='<bean:message bundle="asmResources" key="img.IGCIM0122.BelongToOrgan.alt"/>'/>
							<html:hidden property="eiorgsyscoding"/>
							<br/>
							</div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0122.UserNO"/></strong>：</label>
			                <html:text property="eilabel" style="width:125px;" tabindex="1" errorStyleClass="inputError imeActive"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0122.UserName"/></strong>：</label>
			                <html:text property="einame" style="width:200px;" errorStyleClass="inputError imeActive" tabindex="2"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong><bean:message bundle="asmResources" key="label.IGCIM0122.UserRemark"/></strong>：</label>
			                <html:text property="eidesc" styleId="eidesc" tabindex="3" style="width:450px;" errorStyleClass="inputError"/>
			                <br>
			            </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0122.MarkDay"/></strong>：</label>
                            <html:text property="eiinsdate" styleId="eiinsdate" size="12" tabindex="5" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" />
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiinsdate'))" border="0"/>
                            <br>
                        </div>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert"   styleClass="button"  onclick="return checkForm();" >
		                	<bean:message bundle="asmResources" key="button.IGCIM0122.btn_commit"/>	
		                </html:submit>
		            </div>
                    <html:hidden property="eid" styleId="eid"/>
                   <html:hidden property="esyscoding"/>
                    <html:hidden property="mode" styleId="mode"/>
		         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
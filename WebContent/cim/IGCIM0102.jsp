<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM0102" toScope="request"/>
<bean:define id="title"  toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0102"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
         var gid='IGCIM0102';
		 function checkForm(){
			    var arg0= '<bean:message bundle="asmResources" key="message.IGCIM0102.0013"/>';
		        var alertModel = '<bean:message bundle="asmResources" key="message.IGCIM0102.001"/>';
		        var alertOrgan = '<bean:message bundle="asmResources" key="message.IGCIM0102.002"/>';
		        var alertDeviceNO = '<bean:message bundle="asmResources" key="message.IGCIM0102.003"/>';
		        var alertDeviceName = '<bean:message bundle="asmResources" key="message.IGCIM0102.004"/>';
		        var alertMarkDay = '<bean:message bundle="asmResources" key="message.IGCIM0102.005"/>';
		        var alertNOScope  = '<bean:message bundle="asmResources" key="message.IGCIM0102.006"/>';
		        var argDeviceName  = '<bean:message bundle="asmResources" key="message.IGCIM0102.007"/>';
		        var argNameCount  = '<bean:message bundle="asmResources" key="message.IGCIM0102.008"/>';
		        var argDeviceRemark   = '<bean:message bundle="asmResources" key="message.IGCIM0102.009"/>';
		        var argRemarkCount  = '<bean:message bundle="asmResources" key="message.IGCIM0102.0010"/>';
				if($F('ename').trim()==""){
		    		alert(alertModel);
		    		return false;
		    	}
		    	if($F('eiorgname').trim()==""){
		    		alert(alertOrgan);
		    		return false;
		    	}
		    	if($F('eilabel').trim()==""){
		    		alert(alertDeviceNO);
		    		return false;
		    	}
		    	if($F('einame').trim()==""){
		    		alert(alertDeviceName);
		    		return false;
		    	}
		    	if($F('eiinsdate').trim()==""){
		    		alert(alertMarkDay);
		    		return false;
		    	}if($F('eilabel').strlen()>128){
		    		alert(alertNOScope);
		    		return false;
		    	}if($F('einame').strlen()>120){
		    		alert(argDeviceName+Math.floor(120/strByteFlag)+argNameCount);
		    		return false;
		    	}if($F('eidesc').strlen()>256){
		    		alert(argDeviceRemark+Math.floor(256/strByteFlag)+argRemarkCount);
		    		return false;
		    	}else {
		    		var message = '<bean:message key="IGCO10000.W001" arg0="'+arg0+'" />';
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
	    function setEntity(url){
	    	url = url+"?roletype=IGCI01&subtype=999001";
			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			var alertAssetModel  = '<bean:message bundle="asmResources" key="message.IGCIM0102.0011"/>';
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
					alert(alertAssetModel);
					return false;
					
				}else if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
					if(syscode.length<=9){
						alert(alertAssetModel);
						return false;
					}
				}
				document.forms[0].ename.value = name;
				document.forms[0].eid.value = eid;
				document.forms[0].esyscoding.value = syscode;
			}		
		}
	    function searchMaxEntityItemLable(){
	    	var alertNOInfo  = '<bean:message bundle="asmResources" key="message.IGCIM0102.0012"/>';
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ parameters: 'ecategorykey=SBZC&type=eilable',
				 onSuccess:  function(req, json){
				 	var result = req.responseText;
					if(result != null && result.trim() != ""){	
						document.getElementById("eilabel").value = result;
					} else {
						document.getElementById("labelMessage").innerText = alertNOInfo;
					}
			     }
				});
		}
	    function setDefRoleDomain(){
			var eiorgsyscoding = document.forms[0].eiorgsyscoding.value;
			var eiorgname = document.forms[0].eiorgname.value;
			if((eiorgsyscoding==null || eiorgsyscoding=="") && (eiorgname==null || eiorgname=="")){
				var name = '<%=request.getAttribute("deforgname") %>';
				var id = '<%=request.getAttribute("deforgsys") %>';
				if(null!=id && null!=name && "null"!=id && "null"!=name){
					document.forms[0].eiorgsyscoding.value = id;
					document.forms[0].eiorgname.value = name;
				}		
			}
			
		}
	    function setDefAssetDomain(){
			var esyscoding = document.forms[0].esyscoding.value;
			var ename = document.forms[0].ename.value;
			if((esyscoding==null || esyscoding=="") && (ename==null || ename=="")){
				var id = '<%=request.getAttribute("defassetsys") %>';
				var name = '<%=request.getAttribute("defassetname") %>';

				if(null!=id && null!=name && "null"!=id && "null"!=name){
					var syscode_eid = id;
					var syscode;
					var eid;
					if(syscode_eid.split("_").length>1){
						eid = syscode_eid.split("_")[0];
						syscode = syscode_eid.split("_")[1];
					}
					document.forms[0].esyscoding.value = syscode;
					document.forms[0].ename.value = name;
				}		
			}
			
		}
	    function clear(){
	    	document.forms[0].eilabel.value = '';
		}
	    function toback(){
	        form.action = getAppRootUrl() + "/IGCIM0101_Disp.do?";
	        form.submit();
	    }
	</script>
<body onload="clear();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1">
					<ig:navigation extname1="${urlable}"/> &gt;&gt; 设备登记
                </p>
                <div class="back"><html:link href="javascript:toback();"><bean:message bundle="asmResources" key="button.IGCIM0102.btn_toback"/></html:link></div>
            </div>
            
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGCIM0102" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                    <logic:equal name="IGCIM0102Form" property="mode" value="0">
			            <legend><bean:message bundle="asmResources" key="label.IGCIM0102.AddDeviceInfo"/></legend>
			            </logic:equal>
	                    <logic:equal name="IGCIM0102Form" property="mode" value="1">
	                    <legend><bean:message bundle="asmResources" key="label.IGCIM0102.ChangeDeviceInfo"/></legend>
	                    </logic:equal>
                        <div>
                            <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0102.ModelName"/></strong>：</label>
                            <html:text property="ename" errorStyleClass="inputError imeActive" readonly="true" tabindex="2"/>
                             <img src="images/tree.gif" style="cursor: hand;" alt='<bean:message bundle="asmResources" key="img.IGCIM0102.AssetModel.alt"/>' width="16" height="16" border="0" onclick="setEntity('IGSYM0304_ASSET.do');"/>
                            <br>
                        </div>
                        <div><label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0102.Organ"/></strong>：</label>
							<html:text property="eiorgname" readonly="true" errorStyleClass="inputError imeActive"></html:text>
							<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0304.do');" alt='<bean:message bundle="asmResources" key="img.IGCIM0102.ChoiceOrgan.alt"/>'/>
							<html:hidden property="eiorgsyscoding"/>
							<br/>
							</div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0102.DeviceNO"/></strong>：</label>
			                <html:text property="eilabel" tabindex="1" style="width:125px;" errorStyleClass="inputError"/>
			                
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0102.DeviceName"/></strong>：</label>
			                <html:text property="einame" style="width:200px;" errorStyleClass="inputError imeActive" tabindex="2"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong><bean:message bundle="asmResources" key="label.IGCIM0102.DeviceRemark"/></strong>：</label>
			                <html:text property="eidesc" styleId="eidesc" tabindex="3" style="width:450px;" errorStyleClass="inputError"/>
			                <br>
			            </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0102.MarkDay"/></strong>：</label>
                            <html:text property="eiinsdate" styleId="eiinsdate" size="12" tabindex="5" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" />
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiinsdate'))" border="0"/>
                            <br>
                        </div>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert"   styleClass="button"  onclick="return checkForm();"  >
		                	<bean:message bundle="asmResources" key="button.IGCIM0102.btn_commit"/>
		                </html:submit>
		            </div>
		             <html:hidden property="esyscoding"/>
			         <html:hidden property="eid"/>
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
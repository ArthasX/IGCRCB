<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGAIM0128" toScope="request"/>
<bean:define id="title"  toScope="request" value="应用基本信息变更画面"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		 function checkForm(){
			 var alertOrgan= '<bean:message bundle="asmResources" key="message.IGASM0812.001"/>';
			 var alertNO= '<bean:message bundle="asmResources" key="message.IGASM0812.002"/>';
			 var alertName= '<bean:message bundle="asmResources" key="message.IGASM0812.003"/>';
			 var MaxC= '<bean:message bundle="asmResources" key="message.IGASM0812.004"/>';
			 var alertNameArg0= '<bean:message bundle="asmResources" key="message.IGASM0812.005"/>';
			 var alertNameArg1= '<bean:message bundle="asmResources" key="message.IGASM0812.006"/>';
			 var alertRemark0= '<bean:message bundle="asmResources" key="message.IGASM0812.007"/>';
			 var alertRemark1= '<bean:message bundle="asmResources" key="message.IGASM0812.008"/>';
			 var alertManager= '<bean:message bundle="asmResources" key="message.IGASM0812.009"/>';
			 var arg0= '<bean:message bundle="asmResources" key="message.IGASM0812.0011"/>';
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
		    	}if($F('eilabel').strlen()>32){
		    		alert(MaxC);
		    		return false;
		    	}if($F('einame').strlen()>120){
		    		alert(alertNameArg0+Math.floor(120/strByteFlag)+alertNameArg1);
		    		return false;
		    	}if($F('eidesc').strlen()>40){
		    		alert(alertRemark0+Math.floor(40/strByteFlag)+alertRemark1);
		    		return false;
		    	}if($F('eiuserid').trim() == "" || $F('eiusername').trim() == ""){
		    		alert(alertManager);
		    		return false;
		    	}else {
		    		var message = '<bean:message key="IGCO10000.W003" arg0="'+arg0+'" />';
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
	    function toback(){
	        form.action = getAppRootUrl() + "/IGAIM0121_Back.do?";
	        form.submit();
	    }
	    function selectRoleUser(){
			openSubWindow('/IGSYM0408.do?roletype=IGAC07' , 'newpage', '800', '600');
		}
		function setParamRoleUser(userid,username,roleid,orgid,orgname){
			$("eiuserid").value = userid;
			$("eiusername").value = username;
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
                <p class="fonts1">
                	<ig:navigation extname1="${urlable}"/> &gt;&gt; 应用变更
                </p>
                <div class="back"><html:link href="javascript:toback();"><bean:message bundle="asmResources" key="button.IGASM0812.btn_toback"/></html:link></div> 
            </div>
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGAIM0128" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                    <legend><bean:message bundle="asmResources" key="label.IGASM0812.UserChangeInfo"/></legend>
                        <div>
                            <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGASM0812.ModelName"/></strong>：</label>
                            <html:text name="IGCIM0128Form" property="ename" errorStyleClass="inputError imeActive" readonly="true" tabindex="2" styleClass="inputDisable"/>
                            <br>
                        </div>
                        <div><label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGASM0812.UserOrgan"/></strong>：</label>
							<html:text name="IGCIM0128Form" property="eiorgname" readonly="true" errorStyleClass="inputError imeActive"></html:text>
							<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0304.do');" alt='<bean:message bundle="asmResources" key="img.IGASM0812.ChoiceOrgan.alt"/>' />
							<br/>
							</div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGASM0812.UserNO"/></strong>：</label>
			                <html:text name="IGCIM0128Form" property="eilabel" tabindex="1" errorStyleClass="inputError" readonly="true" styleClass="inputDisable"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGASM0812.UserName"/></strong>：</label>
			                <html:text name="IGCIM0128Form" property="einame" size="18" style="width:300px;" errorStyleClass="inputError imeActive" tabindex="2"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong><bean:message bundle="asmResources" key="label.IGASM0812.UserRemark"/></strong>：</label>
			                <html:text name="IGCIM0128Form" property="eidesc" styleId="eidesc" size="30" tabindex="3" style="width:450px;" errorStyleClass="inputError"/>
			                <br>
			            </div>
			            <logic:present name="IGCIM0128Form" property="roleManager">
			            <logic:equal value="true" name="IGCIM0128Form" property="roleManager">
			            <div>
                            <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGASM0812.UserManager"/></strong>：</label>
                            <html:text  name="IGCIM0128Form" property="eiusername" styleId="eiusername" size="12" tabindex="4" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" />
                            <a href="javascript:void(0)" onclick="selectRoleUser();"><img src="images/seek.gif" alt='<bean:message bundle="asmResources" key="img.IGASM0812.Search.alt"/>'  width="16" height="16" border="0" /></a>
                            <br>
                        </div>
                        </logic:equal>
                        </logic:present>
                        <logic:present name="IGCIM0128Form" property="roleManager">
                        <logic:notEqual value="true" name="IGCIM0128Form" property="roleManager">
			            <div>
                            <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGASM0812.UserManager"/></strong>：</label>
                            <html:text  name="IGCIM0128Form" property="eiusername" styleId="eiusername" size="12" tabindex="4" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" />
                            <br>
                        </div>
                        </logic:notEqual>
                        </logic:present>
                        <div>
                            <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGASM0812.UserMarkDay"/></strong>：</label>
                            <html:text  name="IGCIM0128Form" property="eiinsdate" styleId="eiinsdate" size="12" tabindex="5" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" />
                            <br>
                        </div>
		            </fieldset>
		            <div class="enter">
		           		 <logic:present name="IGCIM0128Form" property="permission">
		            	<logic:equal value="true" name="IGCIM0128Form" property="permission">
		                <html:submit property="btn_insert"  styleClass="button"  onclick="return checkForm();"  >
		                	<bean:message bundle="asmResources" key="button.IGASM0812.btn_commit"/>
		                </html:submit>
		                <html:reset property="btn_insert"  styleClass="button" >
		                	<bean:message bundle="asmResources" key="button.IGASM0812.btn_reset"/>
		                </html:reset>
		                </logic:equal>
		                </logic:present>
		            </div>
		            <html:hidden property="eiid" name="IGCIM0128Form" styleId="eiid"/>
		            <html:hidden property="eid" name="IGCIM0128Form" styleId="eid"/>
		            <html:hidden property="esyscoding" name="IGCIM0128Form" styleId="esyscoding"/>
		            <html:hidden property="eiorgsyscoding" name="IGCIM0128Form" styleId="eiorgsyscoding"/>
		            <html:hidden property="eiupdtime" name="IGCIM0128Form" styleId="eiupdtime"/>
		            <html:hidden property="eistatus" name="IGCIM0128Form" styleId="eistatus"/>
		            <html:hidden property="eiversion" name="IGCIM0128Form" styleId="eiversion"/>
		            <html:hidden property="eismallversion" name="IGCIM0128Form" styleId="eismallversion" value="0"/>
		            <html:hidden property="eilabelbak" name="IGCIM0128Form" styleId="eilabelbak"/>
		            <html:hidden property="eiuserid" name="IGCIM0128Form" styleId="eiuserid"/>
		         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
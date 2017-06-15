<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM0107" toScope="request"/>
<logic:equal name="IGCIM0107Form" property="mode" value="0">
	<bean:define id="title"   toScope="request">
			<bean:message bundle="asmResources" key="ietitle.IGCIM0107.000"/>
	</bean:define>
</logic:equal>
<logic:equal name="IGCIM0107Form" property="mode" value="1">
	<bean:define id="title"   toScope="request">
			<bean:message bundle="asmResources" key="ietitle.IGCIM0107.001"/>
	</bean:define>
</logic:equal>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
        var gid='IGCIM0107';
        var alterRelationship= '<bean:message bundle="asmResources" key="message.IGCIM0107.001"/>';
        var alterNO= '<bean:message bundle="asmResources" key="message.IGCIM0107.002"/>';
        var alterArg0= '<bean:message bundle="asmResources" key="message.IGCIM0107.003"/>';
        var alterArg1= '<bean:message bundle="asmResources" key="message.IGCIM0107.004"/>';
        var arg0 = '<bean:message bundle="asmResources" key="message.IGCIM0107.005"/>';
		function confirmDisp(){
	    	if($F('tempeirrelation').trim()==""){
	    		alert(alterRelationship);
	    		return false;
	    	}
			if($F('eilabel').trim()==""){
	    		alert(alterNO);
	    		return false;
	    	}
	    	if($F('eirdesc').strlen()>64){
	    		alert( alterArg0+Math.floor(64/strByteFlag)+alterArg1);
	    		return false;
	    	}else {
				var msgConfirm = '';
				var message1 = '<bean:message key="IGCO10000.W001" arg0="'+ arg0+'"/>';
				var message2 = '<bean:message key="IGCO10000.W003" arg0="'+ arg0+'" />';
	
			    if ('${IGCIM0107Form.mode}' == '0'){
			    	msgConfirm = message1;
			    } else {
			    	msgConfirm = message2;
			    }
				
				if( window.confirm(msgConfirm)){
					return true;
				} else {
					return false;
				}
	    	}
		}

		 function selectEntityItem(){
			 var alterRelationship= '<bean:message bundle="asmResources" key="message.IGCIM0107.001"/>';
			 if($F('tempeirrelation').trim()==""){
		    		alert(alterRelationship);
		    		return false;
		    	}
		    var hostEid=100;
		    var tmpCid=$F('eirrelation');
		    //if(tmpCid=='3'){
		    //	openSubIGCOM0327PARAM("?esyscoding=999003002"+"&flag=false");
			//}
			//if(tmpCid=='CR030100010001'){
				//openSubIGCOM0327PARAM("?esyscoding=999003001"+"&flag=false");
			//}
			 //openSubIGCOM0302PARAM("?ecategory="+getRelationEcategory($F('eirrelationcode').trim(),"001"));
		    openSubIGCOM0329PARAM("?eirrelation="+tmpCid);
	        }

	        function setParamIGCOM0327(eid, elabel, ename, eiid, eilabel, einame, ecategory) {
	            $("cldeid").value = eid;
	            $("elabel").value = elabel;
	            $("cldeiid").value = eiid;
	            $("eilabel").value = eilabel;
	            $("einame").value = einame;
	            
	        }
		
        function toback(){
            form.action = getAppRootUrl() + "/IGCIM0107.do?org.apache.struts.taglib.html.CANCEL=1";
            form.submit();
        }

        function changeRelation(obj){
            var temp = obj.value.split("#");
        	document.forms[0].eirrelation.value = temp[0];
        	document.forms[0].eirrelationcode.value = temp[1];
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
                    <logic:equal name="IGCIM0107Form" property="mode" value="0">
                    	配置管理 &gt;&gt;CI管理 &gt;&gt;设备维护 &gt;&gt;关系管理 &gt;&gt;关系登记
                    </logic:equal>
                    <logic:equal name="IGCIM0107Form" property="mode" value="1">
                    	配置管理 &gt;&gt;CI管理 &gt;&gt;设备维护 &gt;&gt;关系管理  &gt;&gt;关系修改
                    </logic:equal>
                </p>
                <div class="back">
                	<html:link href="javascript:toback();">
                    		<bean:message bundle="asmResources" key="button.IGCIM0107.btn_toback"/>
                    </html:link>
                 </div> 
            </div>

		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGCIM0107" onsubmit="return checkSubmit(this);">
                    <!--  message -->
                    <ig:message/>
                    <!--  /message -->     
		            <fieldset>
	                    <logic:equal name="IGCIM0107Form" property="mode" value="0">
			           		 <legend><bean:message bundle="asmResources" key="label.IGCIM0107.DeviceRelationshipInfoAdd"/></legend>
			            </logic:equal>
	                    <logic:equal name="IGCIM0107Form" property="mode" value="1">
	                    <legend><bean:message bundle="asmResources" key="label.IGCIM0107.DeviceRelationshipInfoChange"/></legend>
	                    </logic:equal>
	                    <div>
                            <label for="Name"><strong><bean:message bundle="asmResources" key="label.IGCIM0107.DeviceNO"/></strong>：</label>
                            <html:text property="pareilabel" size="18" style="width:85"  styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="1"/>
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong><bean:message bundle="asmResources" key="label.IGCIM0107.DeviceName"/></strong>：</label>
                            <html:text property="pareiname" size="18" style="width:300px;" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="2"/>
                            <br>
                        </div>
                         <!-- 依赖类型 -->
                          <logic:equal name="IGCIM0107Form" property="relationType" value="1">
	                    <div>
	                        <label for="Name"><strong><bean:message bundle="asmResources" key="label.IGCIM0107.RelationType"/></strong>：</label>
	                        <html:select property="belongType" style="width: 120px;" errorStyleClass="inputError" tabindex="5" >
	                           <ig:optionsCollection ccid="BELONG_RELATION_TYPE" isMakeBlankRow="true" isCodeLabel="true" />
	                        </html:select>
	                        <br>
	                    </div>
	                    </logic:equal>
	                    <div>
	                        <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0107.RelevanceAssetRelationship"/></strong>：</label>
	                        <html:select property="tempeirrelation" style="width: 120px;" errorStyleClass="inputError" tabindex="5" onchange="changeRelation(this)">
	                            <html:options collection="ADrelationList" property="value" name="" labelProperty="label" />
	                        </html:select>
	                        <br>
	                    </div>
	                   
	                    
	                    <div>
			                <label for="Name"><strong><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0107.RelevanceNO"/></strong>：</label>
	                        <logic:equal name="IGCIM0107Form" property="mode" value="0">
			                <html:text property="eilabel" size="18" style="width:85" errorStyleClass="inputError imeActive" tabindex="3" readonly="true"/>
			                <!--<html:button property="btn_entity" styleClass="button" value="查询" onclick="selectEntityItem();"/>
			                -->
			                 <img src="images/seek.gif" width="16" height="16" alt='<bean:message bundle="asmResources" key="img.IGCIM0107.search.alt"/>' onclick="selectEntityItem()" style="cursor: hand"/>
			                </logic:equal>
	                        <logic:equal name="IGCIM0107Form" property="mode" value="1">
	                        <html:text property="eilabel" size="18" style="width:85"  styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="1"/>
	                        </logic:equal>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong><bean:message bundle="asmResources" key="label.IGCIM0107.RelevanceName"/></strong>：</label>
	                        <logic:equal name="IGCIM0107Form" property="mode" value="0">
	                        <html:text property="einame" size="18" style="width:85" errorStyleClass="inputError imeActive" tabindex="4" readonly="true"/>
	                        </logic:equal>
	                        <logic:equal name="IGCIM0107Form" property="mode" value="1">
	                        <html:text property="einame" size="18" style="width:85"  styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="1"/>
	                        </logic:equal>
			                
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong><bean:message bundle="asmResources" key="label.IGCIM0107.RelevanceAssetRamark"/></strong>：</label>
			                <html:text property="eirdesc" size="30" styleId="eirdesc" tabindex="6" style="width:450px;" errorStyleClass="inputError"/>
			                <br>
			            </div>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert"  styleClass="button"  onclick="return confirmDisp();"  >
		                	<bean:message bundle="asmResources" key="button.IGCIM0107.btn_summit"/>
		                </html:submit>
		                <html:cancel styleClass="button" >
		                	<bean:message bundle="asmResources" key="button.IGCIM0107.btn_toback"/>
		                </html:cancel>
		            </div>
		             <html:hidden property="pareiid" styleId="pareiid"/>
		            <html:hidden property="elabel" styleId="elabel"/>
		            <html:hidden property="pareid" styleId="pareid"/>
                    <html:hidden property="eiridStr" styleId="eiridStr"/>
                    <html:hidden property="cldeiid" styleId="cldeiid"/>
                    <html:hidden property="cldeid" styleId="cldeid"/>
                    <html:hidden property="mode" styleId="mode"/>
                    <html:hidden property="eirrelationcode" styleId="eirrelationcode"/>
                    <html:hidden property="eirrelation" styleId="eirrelation"/>
                    <html:hidden property="eirinfo" styleId="eirinfo"/>
                    <html:hidden property="eirootmark" styleId="eirootmark"/>
		         </html:form>
		    </div>
        </div>
    </div>
</div>


</div>
</body>
</html:html>
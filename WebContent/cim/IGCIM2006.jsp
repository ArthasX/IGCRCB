<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM2006" toScope="request"/>

<bean:define id="title"   toScope="request">
	应用关系登记
</bean:define>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
        var alterRelationship= '<bean:message bundle="asmResources" key="message.IGCIM0127.001"/>';
        var alterNO= '<bean:message bundle="asmResources" key="message.IGCIM0127.002"/>';
        var alterArg0= '<bean:message bundle="asmResources" key="message.IGCIM0127.003"/>';
        var alterArg1= '<bean:message bundle="asmResources" key="message.IGCIM0127.004"/>';
        var arg0 = '<bean:message bundle="asmResources" key="message.IGCIM0127.005"/>';
		function confirmDisp(){
			
	    	if($F('tempeirrelation').trim()==""){
	    		alert(alterRelationship);
	    		return false;
	    	}if($F('eilabel').trim()==""){
	    		alert(alterNO);
	    		return false;
	    	}
	    	if($F('eirdesc').strlen()>64){
	    		alert(alterArg0+Math.floor(64/strByteFlag)+alterArg1);
	    		return false;
	    	}else {
				var msgConfirm = '';
				var message1 = '<bean:message key="IGCO10000.W001" arg0="'+arg0+'"/>';
	
			    msgConfirm = message1;
				
				if( window.confirm(msgConfirm)){
					return true;
				} else {
					return false;
				}
	    	}
		}
		
        function selectEntityItem(){
        	var alterRelationship= '<bean:message bundle="asmResources" key="message.IGCIM0127.001"/>';
        	 if($F('tempeirrelation').trim()==""){
		    		alert(alterRelationship);
		    		return false;
		    	}
        	 var eid=$F('pareid');
        	 var tmpCid=$F('tempeirrelation');
        	 var esyscoding,ename="";
        		switch(tmpCid){
        			case 'CR010100450001':
        				ename = 'VLAN';
        				esyscoding='999001028004';
        				break;
        			case 'CR010100450002':
        				ename = '端口';
        				esyscoding='999001028005';
        				break;
        			case 'CR010100460001':
        				ename = 'VLAN';
        				esyscoding='999001028004';
        				break;
        			case 'CR010100460002':
        				ename = '端口';
        				esyscoding='999001028005';
        				break;
        			case 'CR010100470001':
        				ename = '端口';
        				esyscoding='999001028005';
        				break;
        		}
        	 openSubIGCOM0327PARAM("?esyscoding="+esyscoding+"&flag=false");
        }

        function setParamIGCOM0327(eid, elabel, ename, eiid, eilabel, einame, ecategory) {
            $("cldeid").value = eid;
            $("elabel").value = elabel;
            $("cldeiid").value = eiid;
            $("eilabel").value = eilabel;
            $("einame").value = einame;
            
        }
        
        function toback(){
            form.action = getAppRootUrl() + "/IGCIM2005_Disp.do";
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
                		 配置管理 &gt;&gt;应用管理 &gt;&gt;应用维护 &gt;&gt;应用服务关系登记
                </p>
                <div class="back">
                	<html:link href="javascript:toback();">
                		返回
                	</html:link>
                </div> 
            </div>

		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGCIM2006" onsubmit="return checkSubmit(this);">
                    <!--  message -->
                    <ig:message/>
                    <!--  /message -->     
		            <fieldset>
			            <legend>应用关系信息添加</legend>
                        <div>
                            <label for="Name"><strong>搜索代码</strong>：</label>
                            <html:text property="pareilabel" size="18" style="width:85"  styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="1"/>
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong>应用名称</strong>：</label>
                            <html:text property="pareiname" size="18" style="width:300px;" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="2"/>
                            <br>
                        </div>
                         <div>
	                        <label for="Name"><strong><span class="red">*</span>关联关系</strong>：</label>
	                        <html:select property="tempeirrelation" style="width: 150px;" errorStyleClass="inputError"  tabindex="5" >
<%-- 	                            <html:options collection="ADrelationList"  labelProperty="CVALUE" /> --%>
	                            <html:optionsCollection label="cvalue" value="cid" name="ADrelationList" />
	                        </html:select>
	                        <br>
	                    </div>
	                  <div>
			                <label for="Name"><strong><span class="red">*</span>相关CI搜索代码</strong>：</label>
			                <html:text property="eilabel" size="18" style="width:85" errorStyleClass="inputError imeActive" tabindex="3" readonly="true"/>
			                 <img src="images/seek.gif" width="16" height="16" alt='查询' onclick="selectEntityItem()" style="cursor: hand"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong>相关CI名称</strong>：</label>
	                        <html:text property="einame" size="18" style="width:85" errorStyleClass="inputError imeActive" tabindex="4" readonly="true"/>
			                <br>
			            </div>
	                   
			            <div>
			                <label for="Name"><strong>说明</strong>：</label>
			                <html:text property="eirdesc" size="30" styleId="eirdesc" tabindex="6" style="width:450px;" errorStyleClass="inputError"/>
			                <br>
			            </div>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert"  styleClass="button"  onclick="return confirmDisp();"  >
		                	提交
		                </html:submit>
		                <html:cancel styleClass="button" onclick="toback()">
		                	返回
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
		         </html:form>
		    </div>
        </div>
    </div>
</div>


</div>
</body>
</html:html>
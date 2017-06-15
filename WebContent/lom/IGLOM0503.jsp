<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGLOM0503" toScope="request"/>
<logic:equal name="IGLOM0503Form" property="mode" value="0">
<bean:define id="title" value="工作餐登记" toScope="request"/>
</logic:equal>
<logic:equal name="IGLOM0503Form" property="mode" value="1">
<bean:define id="title" value="工作餐变更" toScope="request"/>
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

		function confirmDisp(){
			if($F('ewldate').trim()==""){
	    		alert("请选择日期！");
	    		return false;
	    	}
			var message = '';
            if ('${IGLOM0503Form.mode}' == '0'){
                message = '<bean:message key="IGCO10000.W001" arg0="食堂工作餐信息" />';
            } else {
                message = '<bean:message key="IGCO10000.W003" arg0="食堂工作餐信息" />';
            }
			if( window.confirm(message)){
				return true;
			} else {
				return false;
			}
			
		}
		
	    function toback(){
	    	form.action = getAppRootUrl() + "/IGLOM0503_RE.do";
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

	    function checkNum(obj,name){
	    	if(obj.value!=""){
	    		if(!checkIsNumberForCSE(obj.value)){
		    		if(obj.value==0){
		    			event.returnValue = true;	
			    	}else {
	    				alert(name + "请输入最大长度为12位的正整数！");
	    				obj.value = "";
	    				obj.focus();
	    				event.returnValue = false;
			    	}
	    		}
		    	
	    	}
	    	
	    }

	    function checkIsNumberForCSE(str){
	     	myReg = /^[1-9][0-9]{0,11}$/;
	    	
	     	return myReg.test(str);
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
                <p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 
	                <logic:equal name="IGLOM0503Form" property="mode" value="0">
	                                             工作餐登记
	                </logic:equal>
					<logic:equal name="IGLOM0503Form" property="mode" value="1">
					 工作餐管理 &gt;&gt;  工作餐变更
					</logic:equal>
                </p>
                <logic:equal name="IGLOM0503Form" property="mode" value="1">
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
                </logic:equal>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGLOM0503" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<fieldset>
				<logic:equal name="IGLOM0503Form" property="mode" value="0">
				    <legend>工作餐信息添加</legend>
				</logic:equal>
				<logic:equal name="IGLOM0503Form" property="mode" value="1">
                          <legend>工作餐信息变更</legend>
				</logic:equal>
				<div><label for="Name"><strong><span class="red">*</span>日期</strong>：</label>
				<html:text property="ewldate" styleId="ewldate"
						   errorStyleClass="inputError imeDisabled" size="18" readonly="true" />
				<logic:equal name="IGLOM0503Form" property="mode" value="0">
                    <img src="images/date.gif" align="middle"
						 onclick="calendar($('ewldate'))" border="0" style="cursor: hand" /><br/>
                </logic:equal>
				</div>		
				
				<logic:present name="IGLOM05181VO" property="lunchCardList" >
				
			    <logic:iterate id="bean" name="IGLOM05181VO" property="lunchCardList" indexId="index">
					<div>
						<label for="Name"><strong>${bean.typename}</strong>：</label>
						<logic:equal name="IGLOM0503Form" property="mode" value="0">
			                <html:hidden property="lunchcardnameList" value="${bean.typename}"/>
							<html:hidden property="icidList" value="${bean.icid}"/>
							<html:text name="IGLOM0503Form" property="lunchcardnumList" size="18" style="width:200px;" errorStyleClass="inputError" 
							onchange="checkNum(this,'餐卡数量');"/>
		                </logic:equal>
						<logic:equal name="IGLOM0503Form" property="mode" value="1">
						 	<html:hidden property="lunchcardname" value="${bean.typename}"/>
							<html:hidden property="icid" value="${bean.icid}"/>
							<html:text name="IGLOM0503Form" property="lunchcardnum" size="18" style="width:200px;" errorStyleClass="inputError" 
							onchange="checkNum(this,'餐卡数量');"/>
						</logic:equal>
						<br>
    				</div>
				</logic:iterate>
				</logic:present>
				</fieldset>
				<div class="enter">
					<logic:present name="IGLOM05181VO" property="lunchCardList" >
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
				    
				    <html:reset  property="btn_clear" styleClass="button" value="重置" />
				    </logic:present>
				</div>
				<html:hidden property="mode" styleId="mode" name="IGLOM0503Form"/>
				<html:hidden property="ewlid" styleId="ewlid" name="IGLOM0503Form"/>
				<logic:equal name="IGLOM0503Form" property="mode" value="1">
				</logic:equal>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.03 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGLOM0303" toScope="request" />
<bean:define id="title" value="借款申请画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		function timeShow(){
			time.style.display="";
	    }

		function confirmDisp(){
			var message = '';
            if ('${IGLOM0303Form.mode}' == '0'){
                message = '<bean:message key="IGCO10000.W001" arg0="借款基本信息" />';
            } else {
                message = '<bean:message key="IGCO10000.W003" arg0="借款基本信息" />';
            }

            if($F('lpduser').trim()==""){
	    		alert("请输入借款人姓名！");
	    		return false;
	    	}

            if($F('lpduserorg').trim()==""){
	    		alert("请选择借款人机构！");
	    		return false;
	    	}
	    	
    		if($F("lpdamount").trim() == ""){
    			alert("请输入借款金额！");
    			return false;
    		}
    		
    		if(isNaN($F("lpdamount").trim())){
    			alert("借款金额格式不正确！");
    			$("lpdamount").value = "";
    			return false;
    		} else {
    				if($("lpdamount").value == 0) {
    					alert("借款金额不能等于0！");
    					return false;
    				}
    				if($("lpdamount").value < 0) {
    					alert("借款金额不能小于0！");
    					return false;
    				}
    			}
    		if(parseFloat($F("lpdamount"),10) > parseFloat($F("availableAmount"),10)){
    			alert("借款金额不能大于可用金额！");
    			return false;
    		}

            if($F('lpdcomment').trim()==""){
	    		alert("请输入用途！");
	    		return false;
	    	}
	    	
	    	if($F('lpdcomment').strlen()>256){
	    		alert("用途不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
	    		return false;
	    	}

			if( window.confirm(message)){
				return true;
			} else {
				return false;
			}
		}

		
	    function setRoleDomain(url){
			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				document.forms[0].lpduserorg.value = "";
				document.forms[0].lpduserorgname.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
				document.forms[0].lpduserorg.value = temp.split("|")[0];
				document.forms[0].lpduserorgname.value = temp.split("|")[1];
			}		

		}

	    function init(){
		    
            if ('${IGLOM0303Form.mode}' == '0'){
                $('lpduser').value = "";
                $('lpduserorgname').value = "";
                $('lpduserorg').value = "";
                $('lpdamount').value = "";
                $('lpdcomment').value = "";
            }
			if($F('rid') > 0){
				//接待工作借款菜单
				SwitchMenu('sub2');
			}else{
				//预制管理借款菜单
				//SwitchMenu('sub4');
			}
		}

	    function checkLPDUSER(obj){
	    	if(obj.value){
				if(obj.value.length>32)
					{
						alert("借款人姓名输入超过11个汉字，请重新输入！");
						obj.value = "";
						obj.focus();
					}
			}
		    }
	   
	</script>
	

<body onload="init();">

<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
	            <logic:equal name="IGLOM0303Form" property="rid" value="">
                <p class="fonts1">后勤管理 &gt;&gt; 预支管理 &gt;&gt; 
	                <logic:equal name="IGLOM0303Form" property="mode" value="0">
	                                             借款申请
	                </logic:equal>
					<logic:equal name="IGLOM0303Form" property="mode" value="1">
					  借款变更
					</logic:equal>
                </p>
				</logic:equal>
                <c:if test="${IGLOM0303Form.rid > 0}">
                <p class="fonts1">后勤管理&gt;&gt; 接待管理 &gt;&gt; 接待工作管理 &gt;&gt;
	                <logic:equal name="IGLOM0303Form" property="mode" value="0">
	                                             借款申请
	                </logic:equal>
                </p>
                   <div class="back"><a href="IGLOM0314_Back.do" target="_self">返回</a></div> 
                </c:if>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGLOM0303" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
               	<fieldset>
					<logic:equal name="IGLOM0303Form" property="mode" value="0">
					    <legend> 借款申请信息</legend>
					</logic:equal>
					<logic:equal name="IGLOM0303Form" property="mode" value="1">
	                    <legend> 借款变更信息</legend>
					</logic:equal>
    				
	    				<div>
	              			<label for="Name"><strong><span class="red">*</span>借款人姓名</strong>：</label>
	              			<html:text property="lpduser" name="IGLOM0303Form"  size="20" tabindex="1" errorStyleClass="inputError" onchange="checkLPDUSER(this);"/>
	              		</div>
                        <div><label for="Name"><strong><span class="red">*</span>借款人机构</strong>：</label>
							<html:text property="lpduserorgname" readonly="true" errorStyleClass="inputError imeActive"></html:text>
							<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0101_TREE.do');" alt="请选择借款人机构"/>
							<html:hidden property="lpduserorg"/>
							<br/>
						</div> 
	   					<div>
	             			<label for="Name"><strong>可用金额</strong>：</label>
	             			<html:text property="availableAmount" name="IGLOM0303Form"  size="20" tabindex="3" errorStyleClass="inputError" styleClass="inputDisable" readonly="true"/>
	             		</div>
	   					<div>
	             			<label for="Name"><strong><span class="red">*</span>借款金额</strong>：</label>
	             			<html:text property="lpdamount" name="IGLOM0303Form"  size="20" tabindex="4" errorStyleClass="inputError"  onblur="checkFloatNum(this,'借款金额整数部分最大为10位，小数部分为2位！','请输入数字！');"/>
	             		</div>
						<div>
							<label for="Name"><strong><span class="red">*</span>借款日期</strong>：</label>
							<html:text name="IGLOM0303Form" property="lpddate" styleId="lpddate" size="15" tabindex="5" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" /> 
						</div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span>用途</strong>：</label>
           					<html:textarea property="lpdcomment" styleId="lpdcomment" errorStyleClass="inputError" rows="6" cols="60" tabindex="6"/>
			                <br>
			            </div>
              		            	
               	</fieldset>
              		  			
				<div class="enter">
				<c:if test="${IGLOM0303Form.availableAmount > 0}">
			    	<html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
			    	<html:reset property="btn_clear" styleClass="button" value="重置" />
			    </c:if>
				</div>
		    
			    <html:hidden property="mode" styleId="mode" name="IGLOM0303Form"/>
			    <html:hidden property="rid" styleId="rid" name="IGLOM0303Form"/>
			    
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
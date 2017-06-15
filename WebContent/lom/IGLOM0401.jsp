<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGLOM0401" toScope="request" />
<bean:define id="title" value="发票登记画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		function timeShow(){
			time.style.display="";
	    }

		function confirmDisp(){
			var message = '';
            if ('${IGLOM0401Form.mode}' == '0'){
                message = '<bean:message key="IGCO10000.W001" arg0="发票基本信息" />';
            } else {
                message = '<bean:message key="IGCO10000.W003" arg0="发票基本信息" />';
                
            }
            
            var reg = /^[\u4e00-\u9fa5]+$/i; 
            if (reg.test($F('inum').trim())) 
            { 
            alert("不能输入中文！"); 
            document.forms[0].inum.value="";
            document.forms[0].inum.focus();              
            return false; 
            } 
           
                       
            
            if($F('itype').trim()==""){
	    		alert("请选择发票类型！");
	    		return false;
	    	}
           
            if($F('idate').trim()==""){
	    		alert("请选择开票日期！");
	    		return false;
	    	}
            if($F('inum').trim()==""){
	    		alert("请输入发票号码！");
	    		return false;
	    	}
            if($F('iamount').trim()==""){
	    		alert("请输入金额！");
	    		return false;
	    	}


            if($F('ireqempid').trim()==""){
	    		alert("请选择申请部门！");
	    		return false;
	    	}
            if($F('irequsername').trim()==""){
	    		alert("请输入申请人！");
	    		return false;
	    	}
	    	if($F('irequsername').strlen()>32){
	    		alert("申请人不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	if($F('inum').strlen()>16){
	    		alert("发票号码长度过大！");
	    		document.forms[0].inum.value="";
	            document.forms[0].inum.focus(); 
	    		return false;
	    	}
	    	if($F('icomment').strlen()>256){
	    		alert("用途说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
	    		return false;
	    	}
            if($F('iamount') <= 0){
	    		alert("金额不能小于等于0！");
	    		return false;
	    	}
	    	if($F('icontractname').strlen()>64){
	    		alert("合同名称不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	if($F('icontractserial').strlen()>16){
	    		alert("请输入16位以内的合同编号！");
	    		document.forms[0].icontractserial.value="";
	            document.forms[0].icontractserial.focus();     
	    		return false;
	    	}
	    	if($F('icorporation').strlen()>64){
	    		alert("收款单位名称不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	if($F('ibank').strlen()>64){
	    		alert("开户银行名称不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	
	    	if(parseInt($F('iaccount').length)>16){
	    		alert("请输入16位以内的账号！");
	    		document.forms[0].iaccount.value="";
	            document.forms[0].iaccount.focus();        
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
				document.forms[0].ireqemp.value = "";
				document.forms[0].ireqempid.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
				document.forms[0].ireqemp.value = temp.split("|")[0];
				document.forms[0].ireqempid.value = temp.split("|")[1];
			}		
	    }
	    function checkNum(obj){
	    	if(isNaN(obj.value)){
	    		alert("账号请输入数字！");
	    		obj.value = "";
	    		return;
	    	}
	    }
	    function selectRoleUser(){
			openSubWindow('/IGSYM0408.do' , 'newpage', '800', '600');
		}
	    function setParamRoleUser(userid,username,roleid,orgid,orgname){
			$("irequser").value = userid;
			$("irequsername").value = username;
		}

	    function checkNegative(obj){
			if(obj.value<0){
				alert("金额输入为负数，请重新输入！");
				obj.value = "";
				obj.focus();
				}
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
                <p class="fonts1">后勤管理&gt;&gt; 发票管理 &gt;&gt; 
	                <logic:equal name="IGLOM0401Form" property="mode" value="0">
	                                             发票登记
	                </logic:equal>
					<logic:equal name="IGLOM0401Form" property="mode" value="1">
					发票变更
					</logic:equal>
                </p>
                <logic:equal name="IGLOM0401Form" property="mode" value="1">
                <div class="back"><a href="IGLOM0401_Back.do" target="_self">返回</a></div> 
                </logic:equal>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGLOM0401" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
               	<fieldset>
					<logic:equal name="IGLOM0401Form" property="mode" value="0">
					    <legend> 发票登记</legend>
					</logic:equal>
					<logic:equal name="IGLOM0401Form" property="mode" value="1">
	                          <legend>发票变更</legend>
					</logic:equal>
    				
	             		<div>
							<label for="Name"><strong><span class="red">*</span>发票类型</strong>：</label>	
							<span> 
								<html:select property="itype" style="width: 100px;" errorStyleClass="inputError imeActive" >
								<html:options collection="invoice_itype" property="value" name="" labelProperty="label" /></html:select>
							</span>&nbsp;&nbsp;
							<br>
    					</div>
	             		
	             		
	             		
                        <div>
                            <label for="Name"><strong><span class="red">*</span>开票日期</strong>：</label>
                            <html:text property="idate" styleId="rstime" readonly="true"  />
                            <img src="images/date.gif" align="middle" onClick="calendar($('idate'))" border="0"/>
                            <br>
                        </div>
                        
                        <div>
							<label for="Name"><strong><span class="red">*</span>发票号码</strong>：</label>
							<html:text  property="inum" tabindex="6" errorStyleClass="inputError"/>
							<br>
    					</div>
    					
    					<div> 
    					    <label for="Name"><span class="red">*</span><strong>金额</strong>：</label>
                            <html:text property="iamount"  onchange="checkNegative(this);" onblur="checkFloatNumForYZ(this,'金额整数部分最大为10位，小数部分为2位！','金额请输入数字！');" /> <br />
                        </div>
                       
                        <div> 
    					    <label for="Name"><strong>合同编号</strong>：</label>
                            <html:text property="icontractserial" /> <br />
                        </div>
                       
                        <div> 
    					    <label for="Name"><strong>合同名称</strong>：</label>
                            <html:text property="icontractname"/> <br />
                        </div>
                       
                        <div> 
    					    <label for="Name"><strong>收款单位名称</strong>：</label>
                            <html:text property="icorporation"  size="64"  /> <br />
                        </div>
                       
                        <div> 
    					    <label for="Name"><strong>开户银行</strong>：</label>
                            <html:text property="ibank"  size="64"  /> <br />
                        </div>
                       
                        <div> 
    					    <label for="Name"><strong>账号</strong>：</label>
                            <html:text property="iaccount" onchange="checkNum(this);" /> <br />
                        </div>
                       
                        <div> 
	                        <label for="Name"><span class="red">*</span><strong>申请部门</strong>：</label>
				            <html:text property="ireqempid" readonly="true"></html:text>
							<img src="images/tree.gif" style="cursor: hand;" alt="选择申请部门" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0101_TREE.do');"/>
							<html:hidden property="ireqemp"/>&nbsp;&nbsp;
                        </div>
 
                        
                       <div> 
    					    <label for="Name"><span class="red">*</span><strong>申请人</strong>：</label>
                            <html:text property="irequsername" /> 
                            <br/> 
                            
                       </div>
                       
   					   <div> 
   					       <label for="Name"><span class=""></span><strong>用途说明</strong>：</label>
                           <html:textarea property="icomment"  styleId="icomment" cols="60" rows="6" tabindex="6"
	                     		errorStyleClass="inputError imeActive" /> <br />
                       </div>
                       <html:hidden property="istatus" name="IGLOM0401Form"/>
   						
               	</fieldset>
              		
			  
    			
				<div class="enter">
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
				    <html:reset property="btn_clear" styleClass="button" value="重置" />
				    <html:hidden property="mode"/>
				    <html:hidden property="iid"/>
				</div>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
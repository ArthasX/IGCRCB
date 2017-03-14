<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGLOM0115" toScope="request" />
<bean:define id="title" value="外出就餐工作登记画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		function timeShow(){
			time.style.display="";
	    }

		function confirmDisp(){
			
			var message = '';
            if ('${IGLOM0115Form.mode}' == '0'){
                message = '<bean:message key="IGCO10000.W001" arg0="外出就餐基本信息" />';
            } else {
                message = '<bean:message key="IGCO10000.W003" arg0="外出就餐基本信息" />';
            }
            
            if($F('deptName').trim()==""){
	    		alert("请输入申请部门名称！");
	    		return false;
	    	}
            if($F('deptName').strlen()>128){
	    		alert("部门名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
	    		return false;
	    	}
            if($F('invoiceNumber').strlen()>64){
	    		alert("发票编号不能大于64个字符！");
	    		return false;
	    	}
            
            if($F('invoiceNumber').trim()==""){
	    		alert("请输入发票编号！");
	    		return false;
	    	}
            
            
            if($F('dealCash').trim()==""){
	    		alert("请输入就餐金额！");
	    		return false;
	    	}
            
			if(checkFloatNum($F('dealCash'))){
				alert('就餐金额必须为数字！');
				return false;
			}

            if($F('dealScale').trim()==""){
	    		alert("请选择就餐人数规模");
	    		return false;
	    	}
            if($F('dealTime').trim()==""){
	    		alert("请输入申请日期！");
	    		return false;
            }

	    	if($F('otherJoiner').strlen()>128){
	    		alert("其他参与者不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	if($F('dealDesc').strlen()>256){
	    		alert("内容描述不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
	    		return false;
	    	}

			if( window.confirm(message)){
				return true;
			} else {
				return false;
			}
		}
		
            function setRoleDomain(url){
    			url = url+"?roletype=IGAC01";
    			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
    			if("_resetall"==temp){
    				document.forms[0].rapporgid.value = "";
    				document.forms[0].deptName.value = "";
    				return false;
    			}
    			if(null!=temp && temp.split("|").length>1){
    				document.forms[0].rapporgid.value = temp.split("|")[0];
    				document.forms[0].deptName.value = temp.split("|")[1];
    			}		

    		}
            function checkNum(obj){
            	if(obj.value!=""){
            		if(!checkIsNumberForCSE(obj.value)){
            			alert("金额请输入最大长度为9位的整数！");
            			obj.value = "";
            			obj.focus();
            			event.returnValue = false;
            		}
            	}
            }

            function checkIsNumberForCSE(str){
        	 	myReg = /^[1-9][0-9]{0,8}$/;
        	 	return myReg.test(str);
        	}
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1">后勤管理&gt;&gt; 就餐管理  
	                <logic:equal name="IGLOM0115Form" property="mode" value="0">
	                &gt;&gt;外出就餐登记
	                </logic:equal>
					<logic:equal name="IGLOM0115Form" property="mode" value="1">
					&gt;&gt; 外出就餐管理 &gt;&gt;外出就餐信息变更
					</logic:equal>
                </p>
                  <logic:equal name="IGLOM0115Form" property="mode" value="1">
                <div class="back"><a href="IGLOM0107_Back.do" target="_self">返回</a></div> 
                </logic:equal>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGLOM0115" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
               	<fieldset>

					<logic:equal name="IGLOM0115Form" property="mode" value="0">
					    <legend> 外出就餐登记</legend>
    				
	   					<div><label for="Name"><strong><span class="red">*</span>主要申请部门</strong>：</label>
							<html:text property="deptName" readonly="true" errorStyleClass="inputError imeActive"></html:text>
							<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0101_TREE.do');" alt="请选主要申请部门"/>
							<html:hidden property="rapporgid"/>
							<br/>
						</div> 
						
					</logic:equal>
						
						
					<logic:equal name="IGLOM0115Form" property="mode" value="1">
	                    <legend>外出就餐信息变更</legend>
                        <div><label for="Name"><strong><span class="red">*</span>主要申请部门</strong>：</label>
							<html:text property="deptName" readonly="true"  styleClass="inputDisable" errorStyleClass="inputError imeActive"></html:text>	
							<html:hidden property="rapporgid"/>
							<br/>
						</div> 
						
					</logic:equal>	

						
                       <div>
                            <label for="Name"><strong><span class="red">*</span>申请时间</strong>：</label>
                            <html:text property="dealTime" styleId="rstime" size="12" readonly="true"  />
                            <img src="images/date.gif" align="middle" onClick="calendar($('rstime'))" border="0"/>
                            <br>
                        </div>
				
                        <div>
	             			<label for="Name"><strong><span class="red">*</span>就餐金额</strong>：</label>
	             			<html:text property="dealCash" name="IGLOM0115Form"  size="18" errorStyleClass="inputError"  tabindex="1" />
	             		</div>
    					<div>
							<label for="Name"><strong><span class="red">*</span>就餐人数规模</strong>：</label>
							<span> 
								<html:select property="dealScale" style="width: 100px;" errorStyleClass="inputError imeActive" >
								<html:options collection="recption_rscale" property="value" name="" labelProperty="label" /></html:select>
							</span>&nbsp;&nbsp;
							<br>
    					</div>
	             		
	             		<div>
	             			<label for="Name"><strong><span class="red">*</span>发票编号</strong>：</label>
	             			<html:text property="invoiceNumber" name="IGLOM0115Form"  size="18" errorStyleClass="inputError"  tabindex="1"/>
	             		</div>
	             		
	    				<div>
	              			<label for="Name"><strong>其他参与者</strong>：</label>
	              			<html:text property="otherJoiner" name="IGLOM0115Form"  size="18" tabindex="5" style="width:400px;" errorStyleClass="inputError" />
	              		</div>
			            <div>
			                <label for="Name"><strong>其他内容描述</strong>：</label>
           					<html:textarea property="dealDesc" styleId="rdescription" errorStyleClass="inputError" rows="6" cols="60"/>
			                <br>
			            </div>
              		
               	
               	</fieldset>
			  
    			
				<div class="enter">
					<c:if test="${IGLOM0115Form.rstatus != '2' }">
					
				    	<html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
				    	<html:reset property="btn_clear" styleClass="button" value="重置" />
					</c:if>
				</div>
		    
		        <html:hidden property="rid" styleId="rid" name="IGLOM0115Form"/>
		       
			    <html:hidden property="rstatus" styleId="rstatus" name="IGLOM0115Form"/>
			    <html:hidden property="mode" styleId="mode" name="IGLOM0115Form"/>
			    
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
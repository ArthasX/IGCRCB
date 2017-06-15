<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGLOM0101" toScope="request" />
<bean:define id="title" value="接待工作登记画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	 WebCalendar.timeShow   = true; 
		function timeShow(){
			time.style.display="";
	    }

		function confirmDisp(){
			var message = '';
            if ('${IGLOM0101Form.mode}' == '0'){
                message = '<bean:message key="IGCO10000.W001" arg0="接待工作基本信息" />';
            } else {
                message = '<bean:message key="IGCO10000.W003" arg0="接待工作基本信息" />';
            }
            if($F('rname').trim()==""){
	    		alert("请输入接待工作名称！");
	    		return false;
	    	}
	    	if($F('rname').strlen()>128){
	    		alert("接待工作名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
	    		return false;
	    	}
            if($F('rapporgid').trim()==""){
	    		alert("请选择主要申请部门！");
	    		return false;
	    	}
            if($F('rstime').trim()==""){
	    		alert("请输入开始日期！");
	    		return false;
	    	}
            if($F('retime').trim()==""){
	    		alert("请输入结束日期！");
	    		return false;
	    	}
			if(!checkDateByContent("rstime","retime")){
				alert("开始日期不能晚于结束日期！");
				return false;
			}
            if($F('rscale').trim()==""){
	    		alert("请选择接待人数规模！");
	    		return false;
	    	}
            if($F('rstandard').trim()==""){
	    		alert("请选择接待标准！");
	    		return false;
	    	}
            
			if(checkFloatNum($F('rlodgecost'))){
				alert('住宿费用整数部分最大为10位，小数部分为2位！');
				return false;
			}
            
	    	if($F('rpporg').strlen()>256){
	    		alert("其他参与部门不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	if($F('rdescription').strlen()>256){
	    		alert("接待内容描述不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	
			if( window.confirm(message)){
				if(document.forms[0].rlodgecost.value == ""){
					document.forms[0].rlodgecost.value = "0";
				}
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
				document.forms[0].rapporgname.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
				document.forms[0].rapporgid.value = temp.split("|")[0];
				document.forms[0].rapporgname.value = temp.split("|")[1];
			}		

		}
		

	   
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1">后勤管理&gt;&gt; 接待管理  
	                <logic:equal name="IGLOM0101Form" property="mode" value="0">
	                &gt;&gt;接待工作登记
	                </logic:equal>
					<logic:equal name="IGLOM0101Form" property="mode" value="1">
					&gt;&gt; 接待工作管理 &gt;&gt;接待工作变更
					</logic:equal>
                </p>
                <logic:equal name="IGLOM0101Form" property="mode" value="1">
                <div class="back"><a href="IGLOM0103_Back.do" target="_self">返回</a></div> 
                </logic:equal>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGLOM0101" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
               	<fieldset>
					<logic:equal name="IGLOM0101Form" property="mode" value="0">
					    <legend> 接待工作登记</legend>
    				
	   					<div>
	             			<label for="Name"><strong><span class="red">*</span>接待工作名称</strong>：</label>
	             			<html:text property="rname" name="IGLOM0101Form"  size="18" style="width:400px;" errorStyleClass="inputError"  tabindex="1"/>
	             		</div>
                        <div><label for="Name"><strong><span class="red">*</span>主要申请部门</strong>：</label>
							<html:text property="rapporgname" readonly="true" errorStyleClass="inputError imeActive"></html:text>
							<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0101_TREE.do');" alt="请选主要申请部门"/>
							<html:hidden property="rapporgid"/>
							<br/>
						</div> 
						
					</logic:equal>
					<logic:equal name="IGLOM0101Form" property="mode" value="1">
	                    <legend>接待工作变更</legend>
    				
	   					<div>
	             			<label for="Name"><strong><span class="red">*</span>接待工作名称</strong>：</label>
	             			<html:text property="rname" name="IGLOM0101Form"  size="18" style="width:400px;" styleClass="inputDisable" errorStyleClass="inputError" readonly="true"/>
	             		</div>
                        <div><label for="Name"><strong><span class="red">*</span>主要申请部门</strong>：</label>
							<html:text property="rapporgname" readonly="true"  styleClass="inputDisable" errorStyleClass="inputError imeActive"></html:text>
							<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0"/>
							<html:hidden property="rapporgid"/>
							<br/>
						</div> 
						
					</logic:equal>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>开始日期</strong>：</label>
                            <html:text property="rstime" styleId="rstime" size="20" readonly="true"  />
                            <img src="images/date.gif" align="middle" onClick="calendar($('rstime'))" border="0"/>
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>结束日期</strong>：</label>
                            <html:text property="retime" styleId="retime" size="20" readonly="true"  />
                            <img src="images/date.gif" align="middle" onClick="calendar($('retime'))" border="0"/>
                            <br>
                        </div>
                        <div>
							<label for="Name"><strong><span class="red">*</span>接待人数规模</strong>：</label>
							<span> 
								<html:select property="rscale" style="width: 100px;" errorStyleClass="inputError imeActive" >
								<html:options collection="recption_rscale" property="value" name="" labelProperty="label" /></html:select>
							</span>&nbsp;&nbsp;
							<br>
    					</div>
    					<div>
							<label for="Name"><strong><span class="red">*</span>接待标准</strong>：</label>
							<span> 
								<html:select property="rstandard" style="width: 100px;" errorStyleClass="inputError imeActive" >
								<html:options collection="recption_rstandard" property="value" name="" labelProperty="label" /></html:select>
							</span>&nbsp;&nbsp;
							<br>
    					</div>
    					<div>
							<label for="Name"><strong><span class="red"></span>住宿标准</strong>：</label>
							<span> 
								<html:select property="rlodgestandard" style="width: 100px;" errorStyleClass="inputError imeActive" >
								<html:options collection="lodge_standard" property="value" name="" labelProperty="label" /></html:select>
							</span>&nbsp;&nbsp;
							<br>
    					</div>
    					<div>
	              			<label for="Name"><strong>住宿费用</strong>：</label>
	              			<html:text property="rlodgecost" name="IGLOM0101Form"  size="20" tabindex="5" errorStyleClass="inputError" />
	              		</div>
	    				<div>
	              			<label for="Name"><strong>其他参与部门</strong>：</label>
	              			<html:text property="rpporg" name="IGLOM0101Form"  size="18" tabindex="5" style="width:400px;" errorStyleClass="inputError" />
	              		</div>
			            <div>
			                <label for="Name"><strong>接待内容描述</strong>：</label>
           					<html:textarea property="rdescription" styleId="rdescription" errorStyleClass="inputError" rows="6" cols="60"/>
			                <br>
			            </div>
              		
               	
               	</fieldset>
              		
			  
    			
				<div class="enter">
					<c:if test="${IGLOM0101Form.rstatus != '2' }">
				    	<html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
				    	<html:reset property="btn_clear" styleClass="button" value="重置" />
					</c:if>
				</div>
		    
		        <html:hidden property="rid" styleId="rid" name="IGLOM0101Form"/>
		        <html:hidden property="rdate" styleId="rdate" name="IGLOM0101Form"/>
			    <html:hidden property="rstatus" styleId="rstatus" name="IGLOM0101Form"/>
			    <html:hidden property="mode" styleId="mode" name="IGLOM0101Form"/>
			    
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
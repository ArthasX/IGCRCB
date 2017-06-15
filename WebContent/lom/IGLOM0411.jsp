<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<%@ page import="com.csebank.items.util.DefineUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0411" toScope="request" />
<bean:define id="title" value="发票付款信息修改画面" toScope="request" />

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
                if($F('ipaymentdate').trim()==""){
    	    		alert("请选择付款日期！");
    	    		return false;
    	    	}
               if($F('ipaymenttype').trim()==""){
    	    		alert("请选择付款方式！");
    	    		return false;
    	    	}
               if($F('ipaymenttypecode').trim()==""){
    	    		alert("请付款方式号码！");
    	    		return false;
    	    	}
            }
            
            if($F('ipaymenttypecode').strlen()>16){
	    		alert("付款方式号码不能大于16个字符！");
	    		return false;
	    	}
            if($F('istatus').trim()==""){
	    		alert("请选择状态！");
	    		return false;
	    	}
	    	if( window.confirm(message)){
				return true;
			} else {
				return false;
			}
	    	
		}
		function init(){
            var flag=$F('istatus');
              if(flag=='0'){
            	 document.forms[0].ipaymentdate.readOnly =true;
            	 document.forms[0].ipaymenttypecode.readOnly =true;
            	 document.forms[0].ipaymenttype.disabled =true;
                
                  }
			}
		function change(){
           
           if(document.forms[0].istatus.value=='1'){
        	   document.forms[0].ipaymentdate.readOnly =false;
          	  document.forms[0].ipaymenttypecode.readOnly =false;
          	  document.forms[0].ipaymenttype.disabled =false;
               }
		}
		  
	</script>
<body onload="init();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1">后勤管理&gt;&gt; 发票管理 &gt;&gt; 付款信息修改
                </p>
                <logic:equal name="IGLOM0401Form" property="mode" value="1">
                <div class="back"><a href="IGLOM0411_Back.do" target="_self">返回</a></div> 
                </logic:equal>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGLOM0411" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
               	<fieldset>
	                <legend>付款信息变更</legend>
					
    		   
    					
    				 <div>
                            <label for="Name"><strong><span class="red">*</span>付款日期</strong>：</label>
                            
                            <html:text property="ipaymentdate" styleId="rstime" size="10"   />
                            
                            <img src="images/date.gif" align="middle" onClick="calendar($('ipaymentdate'))" border="0"/>
                            <br>
                        </div>
	             		
						<div>
							<label for="Name"><strong><span class="red">*</span>付款方式</strong>：</label>	
							<span> 
								<html:select property="ipaymenttype" style="width: 100px;" errorStyleClass="inputError imeActive" >
								<html:options collection="invoice_ipaymenttype" property="value" name="" labelProperty="label" /></html:select>
							</span>&nbsp;&nbsp;
							<br>
    					</div>
						
                        <div>
                            <label for="Name"><strong><span class="red">*</span>付款方式号码</strong>：</label>
                            <html:text property="ipaymenttypecode" />
                            <br>
                        </div>
                   
	             		<div>
							<label for="Name"><strong>发票类型</strong>：</label>	
							<label style="text-align:left; width: 125px"> 
								<ig:cseCodeValue codeIndex="<%=CodeUtils.INVOICE_ITYPE%>" codeValue="${IGLOM0401Form.itype}" />
							</label>
							<html:hidden property="itype" name="IGLOM0401Form"/>
							<br>
    					</div>
                        <div>
                            <label for="Name"><strong>开票日期</strong>：</label>
                            <html:text property="idate" styleId="rstime" styleClass="inputDisable" readonly="true"/>
                            <br>
                        </div>
                        
                        <div>
							<label for="Name"><strong>发票号码</strong>：</label>
							<html:text  property="inum" tabindex="6" styleClass="inputDisable" readonly="true"/>
							<br>
    					</div>
    					
    					<div> 
    					    <label for="Name"><strong>金额</strong>：</label>
                            <html:text property="iamount" styleClass="inputDisable"  readonly="true" /> <br />
                        </div>
                       
                        <div> 
    					    <label for="Name"><strong>合同编号</strong>：</label>
                            <html:text property="icontractserial" styleClass="inputDisable" readonly="true"/> <br />
                        </div>
                       
                        <div> 
    					    <label for="Name"><strong>合同名称</strong>：</label>
                            <html:text property="icontractname" styleClass="inputDisable" readonly="true"/> <br />
                        </div>
                       
                        <div> 
    					    <label for="Name"><strong>收款单位名称</strong>：</label>
                            <html:text property="icorporation" styleClass="inputDisable" size="64"   readonly="true"/> <br />
                        </div>
                       
                        <div> 
    					    <label for="Name"><strong>开户银行</strong>：</label>
                            <html:text property="ibank" styleClass="inputDisable" size="64"  readonly="true" /> <br />
                        </div>
                       
                        <div> 
    					    <label for="Name"><strong>账号</strong>：</label>
                            <html:text property="iaccount" styleClass="inputDisable" readonly="true"  /> <br />
                        </div>
                       
                        <div> 
	                        <label for="Name"><strong>申请部门</strong>：</label>
				            <html:text property="ireqempid" styleClass="inputDisable" readonly="true"></html:text>
							<html:hidden property="ireqemp"/>&nbsp;&nbsp;
                        </div>
                       <div> 
    					    <label for="Name"><strong>申请人</strong>：</label>
                            <html:text property="irequsername" styleClass="inputDisable" readonly="true"/> 
                            <br/> 
                            
                       </div>
                       
   					   <div> 
   					       <label for="Name"><span class=""></span><strong>用途说明</strong>：</label>
                           <html:textarea property="icomment" styleClass="inputDisable" styleId="icomment" cols="60" rows="6" tabindex="6"
	                     		readonly="true" /> <br />
                       </div>
   
               	</fieldset>
              		
			  
    			
				<div class="enter">
				    <html:submit property="btn_insert" value="付款" styleClass="button"  onclick="return confirmDisp();"  />
				    <html:reset property="btn_clear" styleClass="button" value="重置" />
				    <html:hidden property="mode"/>
				    <html:hidden property="iid"/>
				     <html:hidden property="istatus" value ="1"/>
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
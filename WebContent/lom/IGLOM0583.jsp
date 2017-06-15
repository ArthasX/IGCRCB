<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGLOM0583" toScope="request"/>
<logic:equal name="IGLOM0506Form" property="mode" value="0">
<bean:define id="title" value="食堂接待登记" toScope="request"/>
</logic:equal>
<logic:equal name="IGLOM0506Form" property="mode" value="1">
<bean:define id="title" value="食堂接待变更" toScope="request"/>
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

		function confirmDisp(){

			if($F('eedate').trim()==""){
	    		alert("请选择日期！");
	    		return false;
	    	}
			var message = '';
            if ('${IGLOM0506Form.mode}' == '0'){
                message = '<bean:message key="IGCO10000.W001" arg0="食堂接待信息" />';
            } else {
                message = '<bean:message key="IGCO10000.W003" arg0="食堂接待信息" />';
            }
			if( window.confirm(message)){
				if(document.forms[0].eedrinkprice.value == ""){
					document.forms[0].eedrinkprice.value = "0";
				}
				if(document.forms[0].eesmokeprice.value == ""){
					document.forms[0].eesmokeprice.value = "0";
				}
				if(document.forms[0].eeotherprice.value == ""){
					document.forms[0].eeotherprice.value = "0";
				}
				if(document.forms[0].eetableprice.value == ""){
					document.forms[0].eetableprice.value = "0";
				}
				return true;
			} else {
				return false;
			}
			
		}
		
	    function toback(){
	    	if(document.forms[0].eedrinkprice.value == ""){
				document.forms[0].eedrinkprice.value = "0";
			}
			if(document.forms[0].eesmokeprice.value == ""){
				document.forms[0].eesmokeprice.value = "0";
			}
			if(document.forms[0].eeotherprice.value == ""){
				document.forms[0].eeotherprice.value = "0";
			}
			if(document.forms[0].eetableprice.value == ""){
				document.forms[0].eetableprice.value = "0";
			}
	    	form.action = getAppRootUrl() + "/IGLOM0507_RE.do";
			form.submit();
	    }
	    function setParentValue(rid,rname){
			document.forms[0].rid.value = rid;
			document.forms[0].rname.value = rname;
		}
	    function selectRid(){
			openSubWindow("/IGLOM0103ST_DISP.do?" , "_blank", "800", "600");
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

	    function checkNum(obj){
	    	if(isNaN(obj.value)){
	    		alert("请输入数字！");
	    		obj.value = "";
	    		return;
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
                <p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt; 
	                <logic:equal name="IGLOM0506Form" property="mode" value="0">
	                                             食堂接待登记
	                </logic:equal>
					<logic:equal name="IGLOM0506Form" property="mode" value="1">
					接待查询 &gt;&gt; 食堂接待变更
					</logic:equal>
                </p>
                <div class="back"><html:link action="/IGLOM0580.do">返回</html:link></div> 
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGLOM0583" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					<logic:equal name="IGLOM0506Form" property="mode" value="0">
					    <legend>食堂接待信息添加</legend>
					</logic:equal>
					<logic:equal name="IGLOM0506Form" property="mode" value="1">
	                          <legend>食堂接待信息变更</legend>
					</logic:equal>
					
					<div><label for="Name"><strong><span class="red">*</span>日期</strong>：</label>
					<html:text property="eedate" styleId="eedate"
							   errorStyleClass="inputError imeDisabled" size="18" readonly="true" />
					<logic:equal name="IGLOM0506Form" property="mode" value="0">
	                    <img src="images/date.gif" align="middle"
							 onclick="calendar($('eedate'))" border="0" style="cursor: hand" /><br />
	                </logic:equal>
					
					</div>
					
					<div>
						<label for="Name"><strong>主陪人</strong>：</label>
						<html:text name="IGLOM0506Form" property="eeuser" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="2" />
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><strong>每桌菜价格</strong>：</label>
						<html:text name="IGLOM0506Form" property="eetableprice" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="3" 
						onchange="checkNum(this);" onblur="checkFloatNum(this,'每桌菜价格整数部分最大为9位，小数部分为2位！');"/>
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><strong>桌数</strong>：</label>
						<html:text name="IGLOM0506Form" property="eetablenum" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="4" 
						onchange="checkNum(this);"/>
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><strong>酒价</strong>：</label>
						<html:text name="IGLOM0506Form" property="eedrinkprice" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="5" 
						onblur="checkFloatNum(this,'酒价整数部分最大为9位，小数部分为2位！');"/>
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><strong>烟价</strong>：</label>
						<html:text name="IGLOM0506Form" property="eesmokeprice" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="6" 
						onblur="checkFloatNum(this,'烟价整数部分最大为9位，小数部分为2位！');"/>
						<br>
    				</div>
    				
    				<div>
						<label for="Name"><strong>其他用品价格</strong>：</label>
						<html:text name="IGLOM0506Form" property="eeotherprice" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="7" 
						onblur="checkFloatNum(this,'其他用品价格整数部分最大为9位，小数部分为2位！');"/>
						<br>
    				</div>
    			</fieldset>
				<div class="enter">
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
				    <html:reset  property="btn_clear" styleClass="button" value="重置" />
				</div>
				<html:hidden property="mode" styleId="mode" name="IGLOM0506Form"/>
				<html:hidden property="eeid" styleId="eeid" name="IGLOM0506Form"/>
				<html:hidden property="rid" styleId="rid" name="IGLOM0506Form"/>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
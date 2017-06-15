<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1112" toScope="request"/>
<logic:equal name="IGASM1112Form" property="mode" value="0">
<bean:define id="title" value="机柜登记画面" toScope="request"/>
</logic:equal>
<logic:equal name="IGASM1112Form" property="mode" value="1">
<bean:define id="title" value="机柜变更画面" toScope="request"/>
</logic:equal>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
    var gid='IGASM1112';
	function confirmDisp(){
		var eimark=document.getElementById("eimark").value;
		
	if(eimark=="1") {   
		var jilabel=document.getElementById("jilabel").value;
		var jiname=document.getElementById("jiname").value;
		var jidesc=document.getElementById("jidesc").value;
		var j_total=document.getElementById("j_total").value;
		document.getElementById("eilabel").value=jilabel;
		document.getElementById("einame").value=jiname;
		document.getElementById("eidesc").value=jidesc;
		document.getElementById("u_total").value=j_total;
		var patrn = /[\/\\:*?<>|\"]+/;

		var s = $F('jilabel');

		if (patrn.exec(s)) {
			alert("机架编号不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		var s = $F('jiname');

		if (patrn.exec(s)) {
			alert("机架名称不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		var s = $F('jidesc');

		if (patrn.exec(s)) {
			alert("机架说明不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		var s = $F('x_value');

		if (patrn.exec(s)) {
			alert("机房中位置(X)不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		
		var s = $F('y_value');

		if (patrn.exec(s)) {
			alert("机房中位置(Y)不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		
		if($F('eimark').trim()==""){
			alert("请选择容器类型！");
    		return false;
    	}
		if($F('jilabel').trim()==""){
			alert("请输入机架编号！");
    		return false;
    	}
    	if($F('jiname').trim()==""){
    	     alert("请输入机架名称！");
    		return false;
    	}
    	if($F('eiinsdate').trim()==""){
    		alert("请选择登记日！");
    		return false;
    	}
    	if($F('jilabel').strlen()>32){
    		alert("机架编号不能大于32个字符！");
    		return false;
    	}
    	if($F('jiname').strlen()>120){
    		alert("机架名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
    		return false;
    	}
    	if($F('jidesc').strlen()>256){
    		alert("机架说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
    		return false;
    	}
    	if($F('x_value').strlen()>3){
    		alert("机架位置(X)不能大于3个字符！");
    		return false;
    	}
    	if($F('y_value').strlen()>3){
    		alert("机架位置(Y)不能大于3个字符！");
    		return false;
    	}
    	if($F('j_total').strlen()>3 || !checkIsNumber($F('u_total'))){
    		alert("机架高度(U)应输入正整数并且不能大于2位！");
    		return false;
    	}
    	if($F('w_total').strlen()>3 || !checkIsNumber($F('w_total'))){
    		alert("机架宽度(W)应输入正整数并且不能大于2位！");
    		return false;
    	}
    	if($F('x_width').trim()==""){
    		alert("请输入机架横向宽！");
    		return false;
    	}
    	if($F('y_width').trim()==""){
    	    alert("请输入机架纵向宽！");
    		return false;
    	}
    	if($F('x_width')>50|| !checkIsNumber($F('x_width'))){
    		alert("机架横向宽不能大于50！");
    		return false;
    	}
    	if($F('y_width')>50|| !checkIsNumber($F('y_width'))){
    		alert("机架纵向宽不能大于50！");
    		return false;
    	}
    	if($F('maxload').trim()==""){
    	    alert("请输入最大负载(KG)！");
    		return false;
    	}
    	if(!checkIsNumber($F('maxload'))){
    		alert("最大负载(KG)应输入正整数！");
    		return false;
    	}
    	if($F('maxload')>9999){
    		alert("最大负载(KG)不能大于9999！");
    		return false;
    	}
    	if($F('maxpower').trim()==""){
    	    alert("请输入最大电力(KW)！");
    		return false;
    	}
    	if(!checkIsNumber($F('maxpower'))){
    		alert("最大电力(KW)应输入正整数！");
    		return false;
    	}
    	if($F('maxpower')>9999){
    		alert("最大电力(KW)不能大于9999！");
    		return false;
    	}
        var message = '';
        if ('${IGASM1112Form.mode}' == '0') {
            message = '<bean:message key="IGCO10000.W001" arg0="机架信息" />';
        } else {
            message = '<bean:message key="IGCO10000.W003" arg0="机架信息" />';
        }
		if(window.confirm(message)){
			return true;
		} else {
			return false;
		}
	} else {
		
		var patrn = /[\/\\:*?<>|\"]+/;

		var s = $F('eilabel');

		if (patrn.exec(s)) {
			alert("机柜编号不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		var s = $F('einame');

		if (patrn.exec(s)) {
			alert("机柜名称不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		var s = $F('eidesc');

		if (patrn.exec(s)) {
			alert("机柜说明不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		
		
		var s = $F('x_value');

		if (patrn.exec(s)) {
			alert("机房中位置(X)不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		
		var s = $F('y_value');

		if (patrn.exec(s)) {
			alert("机房中位置(Y)不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		var s = $F('voltage');

		if (patrn.exec(s)) {
			alert("额定电压不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		var s = $F('weight');

		if (patrn.exec(s)) {
			alert("机柜重量不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		var s = $F('weight');

		if (patrn.exec(s)) {
			alert("机柜重量不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		var s = $F('standard');

		if (patrn.exec(s)) {
			alert("机柜规格不能包含下列字符:  " + "\/\\:*?\"<>|");
			return false;
		}
		
		if($F('eimark').trim()==""){
			alert("请选择容器类型！");
    		return false;
    	}
    	if($F('eilabel').trim()==""){
			alert("请输入机柜编号！");
    		return false;
    	}
    	if($F('einame').trim()==""){
    	     alert("请输入机柜名称！");
    		return false;
    	}
    	if($F('eiinsdate').trim()==""){
    		alert("请选择登记日！");
    		return false;
    	}
    	if($F('eilabel').strlen()>32){
    		alert("机柜编号不能大于32个字符！");
    		return false;
    	}
    	if($F('einame').strlen()>120){
    		alert("机柜名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
    		return false;
    	}
    	if($F('eidesc').strlen()>256){
    		alert("机柜说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
    		return false;
    	}
    	if($F('x_value').strlen()>3){
    		alert("机柜位置(X)不能大于3个字符！");
    		return false;
    	}
    	if($F('y_value').strlen()>3){
    		alert("机柜位置(Y)不能大于3个字符！");
    		return false;
    	}
    	if($F('u_total').strlen()>2 || !checkIsNumber($F('u_total'))){
    		alert("机柜高度(U)应输入正整数并且不能大于2位！");
    		return false;
    	}
    	if($F('x_width').trim()==""){
    		alert("请输入机柜横向宽！");
    		return false;
    	}
    	if($F('y_width').trim()==""){
    		alert("请输入机柜纵向宽！");
    		return false;
    	}
    	if($F('x_width')>50 || !checkIsNumber($F('x_width'))){
    		alert("机柜横向宽不能大于50！");
    		return false;
    	}
        if($F('y_width')>50|| !checkIsNumber($F('y_width'))){
    		alert("机柜纵向宽不能大于50！");
    		return false;
    	}
    	if($F('maxload').trim()==""){
    	    alert("请输入最大负载(KG)！");
    		return false;
    	}
    	if(!checkIsNumber($F('maxload'))){
    		alert("最大负载(KG)应输入正整数！");
    		return false;
    	}
    	if($F('maxload')>9999){
    		alert("最大负载(KG)不能大于9999！");
    		return false;
    	}
    	if($F('maxpower').trim()==""){
    	    alert("请输入最大电力(KW)！");
    		return false;
    	}
    	if(!checkIsNumber($F('maxpower'))){
    		alert("最大电力(KW)应输入正整数！");
    		return false;
    	}
    	if($F('maxpower')>9999){
    		alert("最大电力(KW)不能大于9999！");
    		return false;
    	}
        var message = '';
        if ('${IGASM1112Form.mode}' == '0') {
            message = '<bean:message key="IGCO10000.W001" arg0="机柜信息" />';
        } else {
            message = '<bean:message key="IGCO10000.W003" arg0="机柜信息" />';
        }
		if( window.confirm(message)){
			return true;
		} else {
			return false;
		}
	}
}

	function check_u_total(){
			if($F("u_total")==""){
				 $("u_total").value = "42";
			}
		}
	//自动获取机架高度
	function check_j_total(){
		if($F("j_total")==""){
			 $("j_total").value = "12";
		}
	}
	//自动获取机架宽度
	function check_w_total(){
		if($F("w_total")==""){
			 $("w_total").value = "14";
		}
	}
	function toback(){
        form.action = getAppRootUrl() + "/IGASM1111_Back.do?";
        form.submit();
    }

    function init(){
    	document.getElementById("potision_X").style.display = "none";
    	document.getElementById("potision_Y").style.display = "none";
    	document.getElementById("Type13").style.display = "none";
    }
    //下拉框变更事件
    function pulldown()
    {
        var eimark=document.getElementById("eimark").value;
        if(eimark=="1")
        {
        	document.getElementById("Type1").style.display = "none";
        	document.getElementById("Type2").style.display = "";
        	document.getElementById("Type3").style.display = "";
        	document.getElementById("Type4").style.display = "none";
        	document.getElementById("Type5").style.display = "none";
        	document.getElementById("Type6").style.display = "none";
        	document.getElementById("Type7").style.display = "none";
        	document.getElementById("Type8").style.display = "";
        	document.getElementById("Type9").style.display = "none";
        	document.getElementById("Type10").style.display = "";
        	document.getElementById("Type11").style.display = "none";
        	document.getElementById("Type12").style.display = "";

        	//登记页面不显示机柜中位置属性
        	<logic:equal name="IGASM1112Form" property="mode" value="0">
        		document.getElementById("Type13").style.display = "none";
        	</logic:equal>
        	
        	<logic:notEqual name="IGASM1112Form" property="mode" value="0">
	    		document.getElementById("Type13").style.display = "";
	    	</logic:notEqual>
        }
        else 
        {   
        	document.getElementById("Type1").style.display = "";
        	document.getElementById("Type2").style.display = "none";
        	document.getElementById("Type3").style.display = "none";
        	document.getElementById("Type4").style.display = "";
        	document.getElementById("Type5").style.display = "";
        	document.getElementById("Type6").style.display = "";
        	document.getElementById("Type7").style.display = "";
        	document.getElementById("Type8").style.display = "none";
        	document.getElementById("Type9").style.display = "";
        	document.getElementById("Type10").style.display = "none";
        	document.getElementById("Type11").style.display = "";
        	document.getElementById("Type12").style.display = "none";
        	document.getElementById("Type13").style.display = "none";
        }
    }
    //变更初始化事件
    function init_pulldown()
    {   
        if('${IGASM1112Form.eimark}'=="1")
        {
        	document.getElementById("Type1").style.display = "none";
        	document.getElementById("Type2").style.display = "";
        	document.getElementById("Type3").style.display = "";
        	document.getElementById("Type4").style.display = "none";
        	document.getElementById("Type5").style.display = "none";
        	document.getElementById("Type6").style.display = "none";
        	document.getElementById("Type7").style.display = "none";
        	document.getElementById("Type8").style.display = "";
        	document.getElementById("Type9").style.display = "none";
        	document.getElementById("Type10").style.display = "";
        	document.getElementById("Type11").style.display = "none";
        	document.getElementById("Type12").style.display = "";
        	document.getElementById("Type13").style.display = "";
        }
        else 
        {   
        	document.getElementById("Type1").style.display = "";
        	document.getElementById("Type2").style.display = "none";
        	document.getElementById("Type3").style.display = "none";
        	document.getElementById("Type4").style.display = "";
        	document.getElementById("Type5").style.display = "";
        	document.getElementById("Type6").style.display = "";
        	document.getElementById("Type7").style.display = "";
        	document.getElementById("Type8").style.display = "none";
        	document.getElementById("Type9").style.display = "";
        	document.getElementById("Type10").style.display = "none";
        	document.getElementById("Type11").style.display = "";
        	document.getElementById("Type12").style.display = "none";
        	document.getElementById("Type13").style.display = "none";
        }
    }
    function setRoleDomain(url){
		url = url+"?roletype=IGAC01";
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
</script>
<body onload="init_pulldown();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 
                <logic:equal name="IGASM1112Form" property="mode" value="0">
                                            机柜登记
                </logic:equal>
                
                <logic:equal name="IGASM1112Form" property="mode" value="1">
                                            机柜列表 &gt;&gt; 机柜变更
				<div class="back"><a href="IGASM1111_Back.do" target="_self">返回</a></div> 
                </logic:equal>
                </p>
            </div>
           
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGASM1112" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                    <logic:equal name="IGASM1112Form" property="mode" value="0">
			            	<legend>机柜信息添加</legend>
			            </logic:equal>
			             <div>
									<span style="color: red;">录入表单信息时，请不要使用特殊字符（如："&gt;"、"&lt;"、"/"等）</span>
								</div>
	                    <logic:equal name="IGASM1112Form" property="mode" value="1">
	                    	<legend>机柜信息变更</legend>
	                    </logic:equal>
	                  <logic:equal name="IGASM1112Form" property="mode" value="0">  
		                  <div>
		                  	<label for="Name"><strong><span class="red">*</span>容器类型</strong>：</label>
	                        <html:select property="eimark" style="width:70px;" onchange="pulldown();"  styleId="eimark" >
				                  <ig:optionsCollection ccid="SELF_CODE" isMakeBlankRow="false" isCodeLabel="true" />
			                </html:select>
			                <br />
		                  </div>
	                  </logic:equal>
	                  <logic:equal name="IGASM1112Form" property="mode" value="1">
	                  	  <div>
	                   		  <label for="Name"><strong><span class="red">*</span>容器类型</strong>：</label>
	                   		  <logic:equal name="IGASM1112Form" property="mode" value="1">
	                   		  	  <logic:equal name="IGASM1112Form" property="eimark" value="0">
			                		 <html:text property="ptemp" value="机柜" styleId="ptemp" size="4" tabindex="6" errorStyleClass="inputError" styleClass="inputDisable" readonly="true"/>
			                	  </logic:equal>
			                	  <logic:equal name="IGASM1112Form" property="eimark" value="1">
			                		 <html:text property="ptemp" value="机架" styleId="ptemp" size="4" tabindex="6" errorStyleClass="inputError" styleClass="inputDisable" readonly="true"/>
			                	  </logic:equal>
	                          </logic:equal>
	                   	   </div>
	                   </logic:equal>
			            <div id="Type7">
			                <label for="Name"><strong><span class="red">*</span>机柜编号</strong>：</label>
			                <html:text property="eilabel" styleId="eilabel" size="18" style="width:85" tabindex="1" errorStyleClass="inputError imeActive" />
			                <br>
			            </div>
			            <div id="Type8" style="display:none">
			                <label for="Name"><strong><span class="red">*</span>机架编号</strong>：</label>
			                <html:text property="jilabel"  styleId="jilabel" size="18" style="width:85" tabindex="1" errorStyleClass="inputError imeActive" />
			                <br>
			            </div>
			            <div id="Type9">
			                <label for="Name"><strong><span class="red">*</span>机柜名称</strong>：</label>
			                <html:text property="einame"  styleId="einame" size="18" style="width:300px;" errorStyleClass="inputError imeActive" tabindex="2"/>
			                <br>
			            </div>
			            <div id="Type10" style="display:none">
			                <label for="Name"><strong><span class="red">*</span>机架名称</strong>：</label>
			                <html:text property="jiname"  styleId="jiname" size="18" style="width:300px;" errorStyleClass="inputError imeActive" tabindex="2"/>
			                <br>
			            </div>
			            <div id="Type11">
			                <label for="Name"><strong>机柜说明</strong>：</label>
			                <html:text property="eidesc" styleId="eidesc" size="30" tabindex="3" style="width:450px;" errorStyleClass="inputError"/>
			                <br>
			            </div>
			             <div id="Type12" style="display:none">
			                <label for="Name"><strong>机架说明</strong>：</label>
			                <html:text property="jidesc" styleId="jidesc" size="30" tabindex="3" style="width:450px;" errorStyleClass="inputError"/>
			                <br>
			            </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>登记日</strong>：</label>
                            <html:text name="IGASM1112Form" property="eiinsdate" styleId="eiinsdate" size="12" tabindex="5" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" />
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiinsdate'))" border="0"/>
                            <br>
                        </div>
                        <div id="potision_X">
                            <label for="Name"><strong>机房中位置</strong>(X)：</label>
                            <logic:equal name="IGASM1112Form" property="mode" value="1">
                            <html:text property="x_value" styleId="x_value" size="4" tabindex="4" errorStyleClass="inputError" styleClass="inputDisable" readonly="true"/>
                            </logic:equal>
                            <logic:notEqual name="IGASM1112Form" property="mode" value="1">
                             <html:text property="x_value" styleId="x_value" size="4" tabindex="4" errorStyleClass="inputError" />
                            </logic:notEqual>
                            
                            <br>
                        </div>
                       	<div id="potision_Y">
                            <label for="Name"><strong>机房中位置</strong>(Y)：</label>
                            <logic:equal name="IGASM1112Form" property="mode" value="1">
                            <html:text property="y_value" styleId="y_value" size="4" tabindex="5" errorStyleClass="inputError" styleClass="inputDisable" readonly="true"/>
                            </logic:equal>
                             <logic:notEqual name="IGASM1112Form" property="mode" value="1">
                             <html:text property="y_value" styleId="y_value" size="4" tabindex="5" errorStyleClass="inputError" />
                            </logic:notEqual>
                            <br>
                        </div>
                        <div id="Type13">
                            <label for="Name"><strong>机柜中位置</strong>(U)：</label>
                            <logic:equal name="IGASM1112Form" property="mode" value="1">
                            <html:text property="wz_value" styleId="wz_value" size="4" tabindex="5" errorStyleClass="inputError" styleClass="inputDisable" readonly="true"/>
                            </logic:equal>
                            <logic:notEqual name="IGASM1112Form" property="mode" value="1">
                             <html:text property="wz_value" styleId="wz_value" size="4" tabindex="5" errorStyleClass="inputError" />
                            </logic:notEqual>
                            <br>
                        </div>
                        <div id="Type1">
                            <label for="Name"><strong><span class="red">*</span>机柜高度</strong>(U)：</label>
                            <logic:equal name="IGASM1112Form" property="mode" value="1">
                            <html:text property="u_total" styleId="u_total" size="4" tabindex="6" errorStyleClass="inputError" styleClass="inputDisable" readonly="true"/>
                            </logic:equal>
                             <logic:notEqual name="IGASM1112Form" property="mode" value="1">
                            <html:text property="u_total" styleId="u_total" size="4" tabindex="6" errorStyleClass="inputError"/>
                            </logic:notEqual>
                            <br>
                        </div>
                        <div id="Type2" style="display:none">
                            <label for="Name"><strong><span class="red">*</span>机架高度</strong>(U)：</label>
                            <logic:equal name="IGASM1112Form" property="mode" value="1">
                            <html:text property="j_total" styleId="j_total" size="4" tabindex="6" errorStyleClass="inputError" styleClass="inputDisable" readonly="true"/>
                            </logic:equal>
                             <logic:notEqual name="IGASM1112Form" property="mode" value="1">
                            <html:text property="j_total" styleId="j_total" size="4" tabindex="6" errorStyleClass="inputError"/>
                            </logic:notEqual>
                            <br>
                        </div>
                         <div id="Type3" style="display:none">
                            <label for="Name"><strong><span class="red">*</span>机架宽度</strong>(W)：</label>
                            <logic:equal name="IGASM1112Form" property="mode" value="1">
                            <html:text property="w_total" styleId="w_total" size="4" tabindex="6" errorStyleClass="inputError" styleClass="inputDisable" readonly="true"/>
                            </logic:equal>
                             <logic:notEqual name="IGASM1112Form" property="mode" value="1">
                            <html:text property="w_total" styleId="w_total" size="4" tabindex="6" errorStyleClass="inputError"/>
                            </logic:notEqual>
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>横向宽(地板)</strong>：</label>
                           	 <logic:equal name="IGASM1112Form" property="mode" value="1">
                            <html:text property="x_width" styleId="x_width" size="4" tabindex="6" errorStyleClass="inputError" styleClass="inputDisable" readonly="true"/>
                            </logic:equal>
                             <logic:notEqual name="IGASM1112Form" property="mode" value="1">
                            <html:text property="x_width" styleId="x_width" size="4" tabindex="6" errorStyleClass="inputError" />
                            </logic:notEqual>
                            	块
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>纵向宽(地板)</strong>：</label>
                            <logic:equal name="IGASM1112Form" property="mode" value="1">
                            <html:text property="y_width" styleId="y_width" size="4" tabindex="6" errorStyleClass="inputError" styleClass="inputDisable" readonly="true"/>
                            </logic:equal>
                            <logic:notEqual name="IGASM1112Form" property="mode" value="1">
                          	<html:text property="y_width" styleId="y_width" size="4" tabindex="6" errorStyleClass="inputError" />
                           </logic:notEqual>
                           	块
                           <br>
                        </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>最大负载</strong>：</label>
                          	<html:text property="maxload" styleId="maxload" size="4" tabindex="6" maxlength="10" errorStyleClass="inputError" />
                           	(KG)
                           <br>
                        </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>最大电力</strong>：</label>
                          	<html:text property="maxpower" styleId="maxpower" size="4" tabindex="6" maxlength="10" errorStyleClass="inputError" />
                           	(KW)
                           <br>
                        </div>
                         <div id="Type4">
                            <label for="Name"><strong>额定电压</strong>：</label>
                            <html:text property="voltage" styleId="voltage" size="18" tabindex="6" maxlength="32"/>
                            <br>
                        </div>
                        <div id="Type5">
                            <label for="Name"><strong>机柜重量</strong>：</label>
                           		<html:text property="weight" styleId="weight" size="18" tabindex="6" maxlength="32"/>
                            <br>
                        </div>
                        <div id="Type6">
                            <label for="Name"><strong>机柜规格</strong>：</label>
                            	<html:text property="standard" styleId="standard" size="18" tabindex="6" maxlength="32" />
                            <br>
                        </div>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
                        <logic:equal name="IGASM1112Form" property="mode" value="1">
                     <html:button styleClass="button" property="button" value="返回" onclick="toback();"/>
                        </logic:equal>
		            </div>
                    <html:hidden property="eid" styleId="eid"/>
                    <html:hidden property="eiid" styleId="eiid"/>
                    <html:hidden property="mode" styleId="mode"/>
                    <html:hidden property="eimark" styleId="eimark"/>
                    <html:hidden property="esyscoding" styleId="esyscoding" value="999008"/>
		         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
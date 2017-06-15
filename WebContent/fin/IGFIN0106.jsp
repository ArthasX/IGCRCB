<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGFIN0106" toScope="request" />
<bean:define id="title" value="预算修改画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">


function selectBudget(){
	openSubWindow('/IGFIN0106_Disp.do?', '_blank','1000','600');
}
function checkSubmint(){   
	if(document.forms[0].btype.value == ""){
		alert("请输入预算类别！");
		return false;
	}
	if(document.forms[0].btitle.value == ""){
		alert("请输入预算名称！");
		return false;
	}
	if(document.forms[0].byear.value == ""){
		alert("请输入预算年份！");
		return false;
	}
	if(document.forms[0].bdesc.value == ""){
		alert("请输入预算简介！");
		return false;
	}
	if(check()){
		if(document.forms[0].bamount_show.value == ""){
			alert("请计算预算金额！");
			return false;
		}
		
		if(0 == document.getElementById("bamount_show").value){
			alert("预算金额不能为0！");
			document.getElementById("bamount_show").value = "";
			return false;
		}

		if($F('btitle').strlen()>128){
			alert("预算名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
			return false;
		}
		if($F('bdesc').strlen()>512){
			alert("预算简介不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
			return false;
		}
		if($F('remark').strlen()>512){
			alert("预算备注不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
			return false;
		}
		
		if(confirm("是否确认提交")){
			document.forms[0].submit();
			return true;
		}else{
			return false;
		}
	}else{
		return false;
	}
} 

function sum(){
	if(check()){
		var bzdevelop = parseFloat(document.getElementById("bzdevelop").value);
		var bzhardware = parseFloat(document.getElementById("bzhardware").value);
		var bzsoftware = parseFloat(document.getElementById("bzsoftware").value);
		var bzproject = parseFloat(document.getElementById("bzproject").value);
		var bzelse = parseFloat(document.getElementById("bzelse").value);
		var bcimplement = parseFloat(document.getElementById("bcimplement").value);
		var bcelse = parseFloat(document.getElementById("bcelse").value);
		var bamount = bzdevelop + bzhardware + bzsoftware + bzproject + bzelse + bcimplement + bcelse;
		document.getElementById("bamount_show").value = bamount;
	}
}

function check(){
	var bzdevelop_check = document.forms[0].bzdevelop_check.value;
	var bzhardware_check = document.forms[0].bzhardware_check.value;
	var bzsoftware_check = document.forms[0].bzsoftware_check.value;
	var bzproject_check = document.forms[0].bzproject_check.value;
	var bzelse_check = document.forms[0].bzelse_check.value;
	var bcimplement_check = document.forms[0].bcimplement_check.value;
	var bcelse_check = document.forms[0].bcelse_check.value;
	var unit = "万元";
	if(document.forms[0].bzdevelop.value == ""){
		alert("请输入资本金中开发的金额！");
		return false;
	}else if (fIsNumber(document.forms[0].bzdevelop.value)){
        var bzdevelop = parseFloat(document.forms[0].bzdevelop.value);
        if(bzdevelop>1000000||bzdevelop==1000000){
			alert("资本金中开发的金额整数部分最多可以输入6位数字！");
			return false;
		}
		var r1;
		try{r1=bzdevelop.toString().split(".")[1].length}catch(e){r1=0}
		if(r1>2){
			alert("资本金中开发的金额小数部分最多可以输入2位数字！");
			return false;
		}
		if(bzdevelop < parseFloat(bzdevelop_check)){
			alert("资本金中开发的金额不能小于预算已用的开发金额" + parseFloat(bzdevelop_check) + unit + "！");
			return false;
		}
	}else{   
       alert("资本金中开发的金额请输入数字！");   
       return false;   
    }  
	
	if(document.forms[0].bzhardware.value == ""){
		alert("请输入资本金中硬件的金额！");
		return false;
	}else if (fIsNumber(document.forms[0].bzhardware.value)){   
		var bzhardware = parseFloat(document.forms[0].bzhardware.value);
        if(bzhardware>1000000||bzhardware==1000000){
			alert("资本金中硬件的金额整数部分最多可以输入6位数字！");
			return false;
		}
		var r1;
		try{r1=bzhardware.toString().split(".")[1].length}catch(e){r1=0}
		if(r1>2){
			alert("资本金中硬件的金额小数部分最多可以输入2位数字！");
			return false;
		}
    	if(bzhardware < parseFloat(bzhardware_check)){
			alert("资本金中硬件的金额不能小于预算已用的硬件金额" + parseFloat(bzhardware_check) + unit + "！");
			return false;
		}
	}else{   
       alert("资本金中开发的金额请输入数字！");   
       return false;   
    }  
	
	if(document.forms[0].bzsoftware.value == ""){
		alert("请输入资本金中软件的金额！");
		return false;
	}else if (fIsNumber(document.forms[0].bzsoftware.value)){   
		var bzsoftware = parseFloat(document.forms[0].bzsoftware.value);
        if(bzsoftware>1000000||bzsoftware==1000000){
			alert("资本金中软件的金额整数部分最多可以输入6位数字！");
			return false;
		}
		var r1;
		try{r1=bzsoftware.toString().split(".")[1].length}catch(e){r1=0}
		if(r1>2){
			alert("资本金中软件的金额小数部分最多可以输入2位数字！");
			return false;
		}
    	if(bzsoftware < parseFloat(bzsoftware_check)){
			alert("资本金中软件的金额不能小于预算已用的软件金额" + parseFloat(bzsoftware_check) + unit + "！");
			return false;
		}
	}else{   
       alert("资本金中软件的金额请输入数字！");   
       return false;   
    }  
	
	if(document.forms[0].bzproject.value == ""){
		alert("请输入资本金中工程的金额！");
		return false;
	}else if (fIsNumber(document.forms[0].bzproject.value)){   
		var bzproject = parseFloat(document.forms[0].bzproject.value);
        if(bzproject>1000000||bzproject==1000000){
			alert("资本金中工程的金额整数部分最多可以输入6位数字！");
			return false;
		}
		var r1;
		try{r1=bzproject.toString().split(".")[1].length}catch(e){r1=0}
		if(r1>2){
			alert("资本金中工程的金额小数部分最多可以输入2位数字！");
			return false;
		}
    	if(bzproject < parseFloat(bzproject_check)){
			alert("资本金中工程的金额不能小于预算已用的工程金额" + parseFloat(bzproject_check) + unit + "！");
			return false;
		}
	}else{   
       alert("资本金中工程的金额请输入数字！");   
       return false;   
    }  
	
	if(document.forms[0].bzelse.value == ""){
		alert("请输入资本金中其他的金额！");
		return false;
	}else if (fIsNumber(document.forms[0].bzelse.value)){   
		var bzelse = parseFloat(document.forms[0].bzelse.value);
        if(bzelse>1000000||bzelse==1000000){
			alert("资本金中其他的金额整数部分最多可以输入6位数字！");
			return false;
		}
		var r1;
		try{r1=bzelse.toString().split(".")[1].length}catch(e){r1=0}
		if(r1>2){
			alert("资本金中其他的金额小数部分最多可以输入2位数字！");
			return false;
		}
    	if(bzelse < parseFloat(bzelse_check)){
			alert("资本金中其他的金额不能小于预算已用的其他金额" + parseFloat(bzelse_check) + unit + "！");
			return false;
		}
	}else{   
       alert("资本金中其他的金额请输入数字！");   
       return false;   
    }  
	
	if(document.forms[0].bcimplement.value == ""){
		alert("请输入成本金中实施的金额！");
		return false;
	}else if (fIsNumber(document.forms[0].bcimplement.value)){   
		var bcimplement = parseFloat(document.forms[0].bcimplement.value);
        if(bcimplement>1000000||bcimplement==1000000){
			alert("成本金中实施的金额整数部分最多可以输入6位数字！");
			return false;
		}
		var r1;
		try{r1=bcimplement.toString().split(".")[1].length}catch(e){r1=0}
		if(r1>2){
			alert("成本金中实施的金额小数部分最多可以输入2位数字！");
			return false;
		}
    	if(bcimplement < parseFloat(bcimplement_check)){
			alert("成本金中实施的金额不能小于预算已用的实施金额" + parseFloat(bcimplement_check) + unit + "！ ");
			return false;
		}
	}else{   
       alert("成本金中实施的金额请输入数字！");   
       return false;   
    }  
	
	if(document.forms[0].bcelse.value == ""){
		alert("请输入成本金中其他的金额！");
		return false;
	}else if (fIsNumber(document.forms[0].bcelse.value)){   
		var bcelse = parseFloat(document.forms[0].bcelse.value);
        if(bcelse>1000000||bcelse==1000000){
			alert("成本金中其他的金额整数部分最多可以输入6位数字！");
			return false;
		}
		var r1;
		try{r1=bcelse.toString().split(".")[1].length}catch(e){r1=0}
		if(r1>2){
			alert("成本金中其他的金额小数部分最多可以输入2位数字！");
			return false;
		}
    	if(bcelse < parseFloat(bcelse_check)){
			alert("成本金中其他的金额不能小于预算已用的其他金额" + parseFloat(bcelse_check) + unit + "！");
			return false;
		}
	}else{   
       alert("成本金中其他的金额请输入数字！");   
       return false;   
    }
	return true;
}
function onloadFormat(){
	var bzdevelop = document.forms[0].bzdevelop.value;
	var bzhardware = document.forms[0].bzhardware.value;
	var bzsoftware = document.forms[0].bzsoftware.value;
	var bzproject = document.forms[0].bzproject.value;
	var bzelse = document.forms[0].bzelse.value;
	var bcimplement = document.forms[0].bcimplement.value;
	var bcelse = document.forms[0].bcelse.value;

	document.forms[0].bzdevelop.value = parseFloat(bzdevelop);
	document.forms[0].bzhardware.value = parseFloat(bzhardware);
	document.forms[0].bzsoftware.value = parseFloat(bzsoftware);
	document.forms[0].bzproject.value = parseFloat(bzproject);
	document.forms[0].bzelse.value = parseFloat(bzelse);
	document.forms[0].bcimplement.value = parseFloat(bcimplement);
	document.forms[0].bcelse.value = parseFloat(bcelse);
}
</script>

<body onload="onloadFormat()">

<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
<!--content  右侧内容-->
   <div id="contentWrap">
   <div id="content">
      <div id="location">
       <div class="image"></div>
        <p class="fonts1">服务管理 &gt;&gt; 预算管理 &gt;&gt; 预算修改</p>
       	<div class="back">
		<a href="IGFIN0102_BACK.do" target="_self">返回</a>

	</div>

     </div>
  
   <div id="formwrapper">
       <html:form styleId="form" action="/IGFIN0106">
	    <ig:message />
        <fieldset>
        <legend>预算信息</legend>
        <div>
            <label for="Name"><strong><span class="red">*</span>预算年度</strong>：</label>
          <html:select name="IGFIN0102Form" property="byear" style="width: 100px;">
            	 <html:options collection="byearList" property="value" name="" />
            </html:select>
          	<br/>
        </div>
        <div>
            <label for="Name"><strong>预算性质</strong>：</label>
            <html:select name="IGFIN0102Form" property="pquality" style="width: 100px;">
            	<ig:optionsCollection ccid="BUDGET_QUALITY_CODE" isMakeBlankRow="false" isCodeLabel="true" />
            </html:select>
          	<br/>
        </div>
        <div>
			<label for="Name"><strong><span class="red">*</span>预算类别</strong>：</label>
            <html:select name="IGFIN0102Form" property="btype" style="width: 100px;" errorStyleClass="inputError">
            <ig:optionsCollection ccid="BUDGET_TYPE_CATEGORY_CODE" isMakeBlankRow="false" isCodeLabel="true" />
             </html:select>
			<br>
		</div>
		  <div>
            <label for="Name"><strong>储备预算编号</strong>：</label>
            <html:text name="IGFIN0102Form" property="pstorecode" styleId="pstorecode" tabindex="3" size="40" errorStyleClass="inputError"/>
          <br/>
        </div>
         <div>
            <label for="Name"><strong>需求部门</strong>：</label>
            <html:select name="IGFIN0102Form" property="pneeddispart" style="width: 100px;" errorStyleClass="inputError">
            <ig:optionsCollection ccid="BUDGET_NEED_DISPART_CODE" isMakeBlankRow="false" isCodeLabel="true" />
             </html:select>
			<br>
        </div>
        <div>
            <label for="Name"><strong><span class="red">*</span>预算名称</strong>：</label>
            <html:text name="IGFIN0102Form" property="btitle" styleId="btitle" tabindex="3" size="40" errorStyleClass="inputError"/>
          <br/>
        </div>
  		 <div>
            <label for="Name"><strong><span class="red">*</span>预算简介</strong>：</label>
             <html:textarea name="IGFIN0102Form" property="bdesc" styleId="bdesc"  cols="50" rows="6"/>
          <br/>
        </div>
		<div>
            <label for="Name"><strong><span class="red">*</span>资本金</strong>：</label>
            <br />
            <div style=" margin-left:95px;">
	            <table>
	            	<tr>
	            		<td>
		           			开发:<html:text name="IGFIN0102Form" property="bzdevelop" styleId="bzdevelop" tabindex="3" size="20" errorStyleClass="inputError"/>(万元)
			           	</td>
		           	</tr>
		           	<tr>
	            		<td>
							硬件:<html:text name="IGFIN0102Form" property="bzhardware" styleId="bzhardware" tabindex="3" size="20" errorStyleClass="inputError"/>(万元)
					  	</td>
		           	</tr>
	           		<tr>
	            		<td>
							软件:<html:text name="IGFIN0102Form" property="bzsoftware" styleId="bzsoftware" tabindex="3" size="20" errorStyleClass="inputError"/>(万元)
						</td>
		           	</tr>
		           	<tr>
	            		<td>
							工程:<html:text name="IGFIN0102Form" property="bzproject" styleId="bzproject" tabindex="3" size="20" errorStyleClass="inputError"/>(万元)
						</td>
		           	</tr>
		           	<tr>
	            		<td>
							其他:<html:text name="IGFIN0102Form" property="bzelse" styleId="bzelse" tabindex="3" size="20" errorStyleClass="inputError"/>(万元)
						</td>
					</tr>
	        	</table>
        	</div>
        </div>
         <div>
            <label for="Name"><strong><span class="red">*</span>成本金</strong>：</label>
            <br />
            <div style=" margin-left:95px;">
	            <table>
	            	<tr>
	            		<td>
				           	实施:<html:text name="IGFIN0102Form" property="bcimplement" styleId="bcimplement" tabindex="3" size="20" errorStyleClass="inputError"/>(万元)
			           	</td>
		           	</tr>
		           	<tr>
	            		<td>
							其他:<html:text name="IGFIN0102Form" property="bcelse" styleId="bcelse" tabindex="3" size="20" errorStyleClass="inputError"/>(万元)
							<br/>
						</td>
					</tr>
				</table>
			</div>
        </div>
        <div>
            <label for="Name"><strong><span class="red">*</span>预算金额</strong>：</label>
           <html:text name="IGFIN0102Form" property="bamount_show" styleId="bamount_show" readonly="true" tabindex="3" size="20" errorStyleClass="inputError"/>
          (元)
           <html:button property="btn_count" value="计算预算金额" styleClass="button" onclick="sum()"></html:button>
          	<br/>
        </div>
        <div>
            <label for="Name"><strong>备注</strong>：</label>
			<html:textarea name="IGFIN0102Form" property="remark" styleId="remark"  cols="50" rows="6"/>
       	</div>
        </fieldset>
    <div class="enter">
    <html:hidden name="IGFIN0102Form" property="bid" />
    <html:hidden name="IGFIN0102Form" property="firstbamount" />
    
    <html:hidden name="IGFIN0102Form" property="bzdevelop_check" />
    <html:hidden name="IGFIN0102Form" property="bzhardware_check" />
    <html:hidden name="IGFIN0102Form" property="bzsoftware_check" />
    <html:hidden name="IGFIN0102Form" property="bzproject_check" />
    <html:hidden name="IGFIN0102Form" property="bzelse_check" />
    <html:hidden name="IGFIN0102Form" property="bcimplement_check" />
    <html:hidden name="IGFIN0102Form" property="bcelse_check" />
        <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkSubmint();"  />
		<html:reset styleClass="button"	value="重置" />
    </div>
    </html:form>
     </div>
   </div>

   </div>
  </div>


</div>

</body>
</html:html>
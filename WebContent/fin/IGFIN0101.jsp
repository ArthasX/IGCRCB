<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGFIN0101" toScope="request" />
<bean:define id="title" value="预算登记画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">


function confirmDisp(){

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
		if(document.forms[0].bamount.value == ""){
			alert("请计算预算金额！");
			return false;
		}
		
		if(0 == document.getElementById("bamount").value){
			alert("预算金额不能为0！");
			document.getElementById("bamount").value = "";
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
			return true;
		}else{
			return false;
		}
	}else{
		return false;
	}
}
function selectBudget(){
	openSubWindow('/IGFIN0106_Disp.do?', '_blank','1000','600');
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
		document.getElementById("bamount").value = parseFloat(bamount);
	}
}

function format(){
	document.getElementById("bzdevelop").value = 0;
	document.getElementById("bzhardware").value = 0;
	document.getElementById("bzsoftware").value = 0;
	document.getElementById("bzproject").value = 0;
	document.getElementById("bzelse").value = 0;
	document.getElementById("bcimplement").value = 0;
	document.getElementById("bcelse").value = 0;
}

function check(){
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

	}else{   
       alert("资本金中硬件的金额请输入数字！");   
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
	}else{   
       alert("成本金中其他的金额请输入数字！");   
       return false;   
    }
	return true;
}
</script>


<body onload="format()">
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
        <p class="fonts1">服务管理 &gt;&gt; 预算管理 &gt;&gt; 预算登记</p>
        
     </div>
      
   <div id="formwrapper">
       <html:form styleId="form" action="/IGFIN0101">
	    <ig:message />
        <fieldset>
        <legend>预算信息</legend>
        <div>
            <label for="Name"><strong><span class="red">*</span>预算年度</strong>：</label>
          <html:select property="byear" style="width: 100px;">
            	 <html:options collection="byearList" property="value" name="" />
            </html:select>
          	<br/>
        </div>
        <div>
            <label for="Name"><strong>预算性质</strong>：</label>
            <html:select property="pquality" style="width: 100px;">
            	<ig:optionsCollection ccid="BUDGET_QUALITY_CODE" isMakeBlankRow="true" isCodeLabel="true" />
            </html:select>
          	<br/>
        </div>
        <div>
			<label for="Name"><strong><span class="red">*</span>预算类别</strong>：</label>
            <html:select property="btype" style="width: 100px;" errorStyleClass="inputError">
            <ig:optionsCollection ccid="BUDGET_TYPE_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true" />
             </html:select>
			<br>
		</div>
		  <div>
            <label for="Name"><strong>储备预算编号</strong>：</label>
            <input type="text" id="pstorecode" name="pstorecode" size="40" />
          <br/>
        </div>
         <div>
            <label for="Name"><strong>需求部门</strong>：</label>
            <html:select property="pneeddispart" style="width: 100px;" errorStyleClass="inputError">
            <ig:optionsCollection ccid="BUDGET_NEED_DISPART_CODE" isMakeBlankRow="true" isCodeLabel="true" />
             </html:select>
			<br>
        </div>
        <div>
            <label for="Name"><strong><span class="red">*</span>预算名称</strong>：</label>
            <input type="text" id="btitle" name="btitle" size="40" />
          <br/>
        </div>
  		 <div>
            <label for="Name"><strong><span class="red">*</span>预算简介</strong>：</label>
            <textarea name="bdesc" id="textarea" cols="50" rows="6"></textarea>
          <br/>
        </div>
         <div>
            <label   for="Name"><strong><span class="red">*</span>资本金</strong>：</label>
            <br />
            <div style=" margin-left:95px;">
            <table >
            	<tr>
            		<td>
	           			开发:<input type="text" id="bzdevelop" name="bzdevelop" size="20" />(万元)
					</td>
				</tr>
				<tr>
					<td>
						硬件:<input type="text" id="bzhardware" name="bzhardware" size="20" />(万元)
					</td>
				</tr>
				<tr>
					<td>
						软件:<input type="text" id="bzsoftware" name="bzsoftware" size="20" />(万元)
					</td>
				</tr>
				<tr>
					<td>
						工程:<input type="text" id="bzproject" name="bzproject" size="20" />(万元)
					</td>
				</tr>
				<tr>
					<td>
						其他:<input type="text" id="bzelse" name="bzelse" size="20" />(万元)
					</td>
				</tr>
        	</table></div>
        </div>
         <div>
            <label for="Name"><strong><span class="red">*</span>成本金</strong>：</label>
            <br />
            <div style=" margin-left:95px;">
	            <table>
	            	<tr>
	            		<td>
				           	实施:<input type="text" id="bcimplement" name="bcimplement" size="20" />(万元)
			           	</td>
		           	</tr>
		           	<tr>
	      				<td>
							其他:<input type="text" id="bcelse" name="bcelse" size="20" />(万元)
						</td>
					</tr>
				</table>
			</div>
        </div>
        <div>
            <label for="Name"><strong><span class="red">*</span>预算金额</strong>：</label>
            <html:text property="bamount" styleId="bamount" size="20" readonly="true"></html:text>
            (万元)&nbsp;&nbsp;&nbsp;&nbsp;
            <html:button property="btn_count" value="计算预算金额" styleClass="button" onclick="sum()"></html:button>
          	<br/>
        </div>
        <div>
            <label for="Name"><strong>备注</strong>：</label>
            <textarea name="remark" id="textarea" cols="50" rows="6"></textarea>
          	<br />
       	</div>
        </fieldset>                                                                                                                                                                                                                                                                                                                                                                                                                                           
    <div class="enter">
    <html:hidden property="pcode" />
    <html:hidden property="pid" />
        <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
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
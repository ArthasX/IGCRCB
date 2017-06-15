<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@page import="com.deliverik.framework.utility.ResourceUtility" %>
<html:html>
<bean:define id="id" value="IGALM0201" toScope="request" />
<bean:define id="title" value="规则模板添加" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

function selectRadio(){
	 document.all("tempstate")[0].checked=true;
	 document.all("rulecondition")[0].checked=true;
}

var attachFileNum=0;
var count = 0;
function addWHMFile(index) 
{	
	var h1;
	if(index==-1){
		h1=index+2+count;
		count++;
	}
	else{
		h1=index+2+count;
		count++;
	}

	var h2='<html:select property="alarmconditions" styleId="alarmconditions" style="width: 110px;" errorStyleClass="inputError" value="${bean.alarmcondition}">'
	    +'<html:option value="0">&nbsp;</html:option>'
	    +'<html:option value="1">包含</html:option>'
	    +'<html:option value="2">等于</html:option>'
	    +'<html:option value="3">大于</html:option>'
	    +'<html:option value="4">小于</html:option>'
	    +'<html:option value="5">大于等于</html:option>'
	    +'<html:option value="6">小于等于</html:option>'
	    +'</html:select>';
	var h3='<html:text property="alarmmsgs" errorStyleClass="inputError imeActive" value="${bean.alarmmsg}" styleId="alarmmsgs${index}" />';
	var h4='<img src="images/delete.gif" onclick="deleteitem1(this);" border="0" alt="删除添加编辑框！" style="cursor: hand"/>';
	currRow=tb2.insertRow();
	cell0=currRow.insertCell();
	cell1=currRow.insertCell();
	cell2=currRow.insertCell();
	cell3=currRow.insertCell();
	cell0.innerHTML=h1;
	cell1.innerHTML=h2;
	cell2.innerHTML=h3;
	cell3.innerHTML=h4;

	attachFileNum++;
}

function deleteitem1(obj)
{
	var curRow= obj.parentNode.parentNode;
	tb2.deleteRow(curRow.rowIndex);
	attachFileNum--;
	count--;
}

function resetpage(){
	window.location.href = getAppRootUrl() + '/IGALM0201_Disp.do';
}

function changeType(typeid){
	var category = document.all.form1.category;
	category.options.length = 0; 
	if(typeid == "") return; 
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false,parameters:'type=searchCategorysByType&typeid='+typeid,
		 onSuccess:  function(req, json){
		 var categorys=req.responseText.split(",");
		 if(categorys!=null && categorys.length > 0){
			 for(var i=0;i<categorys.length;i++){
				 	if(categorys[i] != ""){
						var optionItem = new Option(categorys[i].split("_")[1],categorys[i].split("_")[0]);
						category.options.add(optionItem);
				 	}
				}
		 }
		}
	});
}

function confirmDisp(){
	if($("ruletempname").value.trim()==""){
		alert("请输入规则名称！");
		return false;
	}

	if($F('ruletempname').strlen()>128){
		alert("规则名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}
	if($("typeid").value.trim()==""){
		alert("请选监控对象类型！");
		return false;
	}
	if($("categoryid").value.trim()==""){
		alert("请选择监控指标！");
		return false;
	}
	if($("level").value.trim()==""){
		alert("请选择告警级别！");
		return false;
	}
	if($F('tempdesc').strlen()>256){
		alert("描述内容不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
		return false;
	}
	if(attachFileNum == 0){
		alert("请添加至少一个规则条件！");
		return false;
	}
	for(var i=0;i<attachFileNum;i++){

		if(document.getElementsByName("alarmmsgs")[i].value.strlen()>256){
			alert("内容不能大于256个字符！");
			return false;
		}

		var conditionValue = document.getElementsByName("alarmconditions")[i].value.trim();
		var msgValue = document.getElementsByName("alarmmsgs")[i].value.trim();
		if(conditionValue == "0"){
			alert("条件不能为空！");
			return false;
		}
		if( msgValue =="" ){
			alert("内容不能为空！");
			return false;
		}

		if(conditionValue == "2" || conditionValue == "3" || conditionValue == "4"){
			var numberReg = /^(-{0,1}[0-9]+\.?[0-9]*%{0,1}$|^\d+)%{0,1}$/;
			if(!numberReg.exec(msgValue)){
				alert("请输入数字或百分比！");
				return false;
			}
		}
	 }

	if( window.confirm('确认提交?')){
		return true;
	} else {
		return false;
	}
}
</script>
<body onload="selectRadio();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="formwrapper"><html:form styleId="form1"
	action="/IGALM0201_Insert" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset>
	
	<legend>添加规则</legend>
	<!-- 名称 -->
	<div>
		<label for="Name"><strong><span class="red">*</span>规则名称</strong>：</label> 
		<html:text
			property="ruletempname" 
			errorStyleClass="inputError imeActive" style="width: 145px;"/><br />

	</div>
	
	<!-- 监控对象类型 -->
	<div>
		<label for="Name"><strong><span class="red">*</span>监控对象类型</strong>：</label> 
	    <html:select name="IGALM0201Form" property="typeid" style="width: 150px;" errorStyleClass="inputError" tabindex="4" onchange="changeType(this.value);">
	    	<ig:optionsCollection ccid="PERF_MONITOR_TYPE" isMakeBlankRow="true" isCodeLabel="true"/>
	    </html:select><br />
	</div>
	
	<!-- 监控指标 -->
	<div>
		<label for="Name"><strong><span class="red">*</span>监控指标</strong>：</label> 
	    <html:select name="IGALM0201Form" property="categoryid" style="width: 150px;" tabindex="4" styleId="category">
	    </html:select><br />
	</div>
	
	<!-- 条件 -->
	<div>
		<label for="Name"><strong><span class="red">*</span>条件关系</strong>：</label> 
		<p class="p2">
			<html:radio property="rulecondition" styleId="rulecondition" value="0">与</html:radio>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<html:radio property="rulecondition" styleId="rulecondition" value="1">或</html:radio>
		</p><br />
	</div>
	
	<!-- 状态 -->
	<div>
		<label for="Name"><strong><span class="red">*</span>状态</strong>：</label> 
		<p class="p2">
			<html:radio property="tempstate" styleId="tempstate" value="1" >可用</html:radio>
			<html:radio property="tempstate" styleId="tempstate" value="0">停用</html:radio>
		</p><br />
	</div>
	
	<!-- 告警级别(0,1,2,3,4,5) -->
	<div>
		<label for="Name"><strong><span class="red">*</span>告警级别</strong>：</label> 
	    <html:select name="IGALM0201Form" property="level" style="width: 150px;" errorStyleClass="inputError" tabindex="4">
	           <ig:optionsCollection ccid="MOCHAALARM_PRIORITY" isMakeBlankRow="true" isCodeLabel="true"/>
	    </html:select><br />
	</div>
	
	<!-- 规则描述 -->
	<div>
		<label for="Name"><strong>描述</strong>：</label> 
		<html:textarea cols="50" rows="6"
			property="tempdesc" 
			errorStyleClass="inputError imeActive" /><br />
	</div>
	</fieldset>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<fieldset>
		<legend>规则条件</legend>
	<c:if test="${xh==null }">
			<c:set value="-1" var="xh"></c:set>
    </c:if>
    <div align="right">
  <input name="add" type="button" class="button" value="添加条件" onclick="addWHMFile(${xh});"/>

    </div>
	<br/>
	<table class="table_style" id="tb2">
		<tr align="center">
			<th width="16%">序号</th>
			<th width="28%">条件</th>
			<th width="28%">内容</th>
			<th>操作</th>
		</tr>
		</table>
		<br/><br />
    </fieldset>
	<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return confirmDisp();" /> <html:button
		property="btn_clear" styleClass="button" value="重置" onclick="resetpage();"></html:button></div>
    
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
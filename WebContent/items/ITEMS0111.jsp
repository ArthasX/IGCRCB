<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="ITEMS0111" toScope="request" />
<bean:define id="title" value="入库调整页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function checkboxSubmit(){
	message = "请选择要调整的批次！";
    if(window.confirm("是否确认调整？")){
    	count = checkNumber();
    	if(count==0){
    		alert(message);
            return;
    	}
    	if(count==2){
            return;
    	}
    	document.forms[0].submit();
    } else {
        return;
    }
}

function checkNumber(){
	var count=0;
	var checkbox = document.getElementsByName("checkbox");
	var subinnum = document.getElementsByName("subinnum");
	for(var i=0;i<checkbox.length;i++){
		if(checkbox[i].checked==true){
			count=1;
			if(subinnum[i].value == "" || 0 == subinnum[i].value){
				alert("请输入调整数量！");
				count=2;
				return count;
			}
			createHiddenInput("instockid",checkbox[i].value);
			createHiddenInput("inputSubInnum",subinnum[i].value);
		}
	}
	return count;
}	

function createHiddenInput(name,value){
    var inputElement=document.createElement("input");   
    inputElement.name=name;   
    inputElement.value=value;     
    inputElement.type="hidden";
    inputElement.id=name;
    document.forms[0].appendChild(inputElement);   
}

function checkNum(obj){
	if(isNaN(obj.value)){
		alert("请输入数字！");
		obj.value = "0";
		obj.focus();
		event.returnValue = false;
	}
	var intnum = /^(\+|-)?\d+$/;
	if(!intnum.test(obj.value)){
		alert("请输入整数！");
		obj.value = "0";
		obj.focus();
		event.returnValue = false;
	}
	if(obj.value > 99999999){
		alert("请输入最大长度为9位的整数！");
		obj.value = "0";
		obj.focus();
		event.returnValue = false;
	}
}

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/>  &gt;&gt; 入库批次</p>
<div class="back"><a href="ITEMS0109_BACK.do" target="_self">返回</a></div>
</div>
<html:form action="/ITEMS0111">
<div id="results_list">
<table class="table_style">
	<tr>
		<th width="10%"></th>
		<th width="12%">物品编号</th>
		<th width="12%">物品类型</th>
		<th width="12%">入库时间</th>
		<th width="12%">入库数量</th>
		<th width="10%">已出库数量</th>
		<th width="10%">已损耗数量</th>
		<th width="10%">已销毁数量</th>
		<th width="12%">变动数量</th>
	</tr>
	
	<logic:present name="ITEMS01011VO" property="inStockList">
		<logic:iterate id="bean" name="ITEMS01011VO" property="inStockList" indexId="index">
			<tr class="bgRow<%=index%2 %>">
				<td>
					<input name="checkbox" type="checkbox" value="${bean.instockid}" />
				</td>
				<td>${bean.seqcode}</td>
				<td><ig:cseCodeValue codeIndex="2" codeValue="${bean.type}" /></td>
				<td>${bean.intime}</td>
				<td>${bean.innum}</td>
				<td>${bean.outnum}</td>
				<td>${bean.lossnum}</td>
				<td>${bean.havocnum}</td>
				<td>
					<input name="subinnum" type="text" value="0" size="10" class="input1" onchange="checkNum(this);" />
				</td>
			</tr>
		</logic:iterate>
	</logic:present>
	
</table>
</div>
</html:form>

<div id="operate">
<div class="operate_btn">
	<span>
	<html:button property="checkBoxSubmit" value="调整" styleClass="button" onclick="checkboxSubmit();" />
	</span>
</div>
</div>

</div>
</div>
</div>
</div>
</body>
</html:html>
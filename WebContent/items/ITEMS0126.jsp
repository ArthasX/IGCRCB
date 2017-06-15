<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="ITEMS0126" toScope="request" />
<bean:define id="title" value="结账管理查询页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<script type="text/javascript">
function checkboxSubmit(obj){
	message = "请选择要结账的批次！";
	count = checkNumber();
	if(count==0){
		alert(message);
        return;
	}
	if(count==2){
        return;
	}
    if(window.confirm("是否确认结账？")){
    	document.forms[0].action=getAppRootUrl() + "/ITEMS0126_PAY.do";
		document.forms[0].submit();

    } else {
        return;
    }
}

function checkNumber(){
	var count=0;
	var checkbox = document.getElementsByName("checkbox_add");
	for(var i=0;i<checkbox.length;i++){
		if(checkbox[i].checked==true){
			count=1;
			createHiddenInput("outstockids",checkbox[i].value);
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
function setOrg(url){
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].reqorg.value = "";
		document.forms[0].reqorg_name.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].reqorg.value = temp.split("|")[0];
		document.forms[0].reqorg_name.value = temp.split("|")[1];
	}
}

function exportExcel() {
	document.forms[0].action = getAppRootUrl() + "/ITEMS0126.do?report=1";
	document.forms[0].submit();
}
function search() {
	document.forms[0].action = getAppRootUrl() + "/ITEMS0126.do";
	document.forms[0].submit();
}
</script>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form action="/ITEMS0126.do">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="search">

<div class="img"></div>
<div class="conditions">
<div>
<span>申领机构：</span><span><html:text property="reqorg_name" readonly="true"></html:text>
<img src="images/tree.gif" style="cursor: hand;" alt="选择申领机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_ROLETREE.do');"/>
<html:hidden property="reqorg"/>
</span>&nbsp;&nbsp; 
<span>物品种类：</span><html:select property="category" errorStyleClass="inputError imeActive" >
  <html:options collection="itemsCodesList" property="value" labelProperty="label" />
</html:select>&nbsp;&nbsp;

<span>出库时间：从</span><html:text property="outtime_f" styleId="outtime_f" errorStyleClass="inputError imeDisabled" size="16" 
            readonly="true" />
			<img src="images/date.gif" align="middle" onclick="calendar($('outtime_f'))"
			border="0" style="cursor: hand" />
<span>&nbsp;&nbsp;到</span><html:text property="outtime_t" styleId="outtime_t" errorStyleClass="inputError imeDisabled" size="16" 
            readonly="true" />
			<img src="images/date.gif" align="middle" onclick="calendar($('outtime_t'))"
			border="0" style="cursor: hand" />&nbsp;&nbsp;
<br />
<span>结账状态：</span><html:select property="accountstatus" errorStyleClass="inputError imeActive" >
   <html:options collection="accountstatusList" property="value" labelProperty="label" />
</html:select>&nbsp;&nbsp;
<input type="button" value="查询"  class="button" onclick="search();" />
<input type="button" value="导出"  class="button" onclick="exportExcel();" />

</div>
</div>
</div>

<div id="results_list">
	<ig:message />
<table class="table_style">
	<tr>
		<th width="3%">
			<label> 
				<input type="checkbox" name="checkbox" id="checkbox" onclick="selectAll('checkbox','checkbox_add')"/> 
			</label>
		</th>
		<th width="9%">所属机构</th>
		<th width="8%">使用人</th>
		<th width="7%">物品编号</th>
		<th width="9%">物品名称</th>
		<th width="7%">物品型号</th>
		<th width="7%">出库数量</th>
		<th width="7%">出库价格</th>
		<th width="7%">出库金额</th>
		<th width="11%">出库时间</th>
		<th width="11%">接收时间</th>
		<th width="7%">出库类型</th>
		<th width="7%">结账状态</th>
	</tr>

	<logic:present name="ITEMS01011VO" property="outStockList">
		<logic:iterate id="bean" name="ITEMS01011VO" property="outStockList" indexId="index">
			<bean:define id="map" name="ITEMS01011VO" property="editMap" type="java.util.Map"/>
			<bean:define id="inid" value="${bean.outstockid}"/>
			<tr class="bgRow<%=index%2 %>">
				<td>
					<logic:notEqual name="bean" property="rcvname" value="">
					<c:if test="${map[inid] == '1' }">
					<input name="checkbox_add" type="checkbox" value="${bean.outstockid}" />
					</c:if>
					</logic:notEqual>
				</td>
				<td>
					<ig:cseOrgValue orgsyscoding="${bean.reqorg}"/>
				</td>
				<td>
					${bean.rcvname}
				</td>
				<td>${bean.seqcode}</td>
				<td>${bean.itemsname}</td>
				<td>${bean.typecode}</td>
				<td>${bean.outnum}</td>
				<td>${bean.outprice}</td>
				<td>${bean.outamount}</td>
				<td>${bean.outtime}</td>
				<td>${bean.rcvtime}</td>
				<td><ig:cseCodeValue codeIndex="5" codeValue="${bean.outtype}" /></td>
				<td><ig:cseCodeValue codeIndex="7" codeValue="${bean.accountstatus}" /></td>
			</tr>
		</logic:iterate>
	</logic:present>

</table>
</div>

<div id="operate">
<div class="operate_btn">
	<span>
	<logic:present name="ITEMS01011VO" property="outStockList">
	<input type="button" value="结账"  class="button" onclick="checkboxSubmit(1);" />
	</logic:present>
	<jsp:include page="/include/paging.jsp" />
	</span>
</div>

</div>

</html:form>

</div>
</div>
</div>
</div>
</body>
</html:html>
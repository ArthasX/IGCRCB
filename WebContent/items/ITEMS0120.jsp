<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="ITEMS0120" toScope="request" />
<bean:define id="title" value="损毁审批页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<script type="text/javascript">
function checkboxSubmit(obj){
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
    	if(obj == 1){
    		document.getElementById("approve").value = "true";
    	} else if (obj == 0){
    		document.getElementById("approve").value = "false";
    	}
    	document.forms[1].submit();
    } else {
        return;
    }
}

function checkNumber(){
	var count=0;
	var checkbox = document.getElementsByName("checkbox");
	for(var i=0;i<checkbox.length;i++){
		if(checkbox[i].checked==true){
			count=1;
			createHiddenInput("outstockid",checkbox[i].value);
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
    document.forms[1].appendChild(inputElement);   
}

</script>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="search">
<html:form action="/ITEMS0120.do">
<div class="img"></div>
<div class="conditions">
<div><span>审批类型：</span><html:select property="reqstatus">
<html:option value="7">损耗审批</html:option>
<html:option value="9">销毁审批</html:option>
</html:select>&nbsp;&nbsp; 
<span>物品种类：</span><html:select property="category" errorStyleClass="inputError imeActive">
<html:options collection="itemsCodesList" property="value" labelProperty="label" />
</html:select>&nbsp;&nbsp;
<html:submit value="查询" styleClass="button" />
</div>
</div>
</html:form>
</div>

<html:form action="/ITEMS0121">
<div id="results_list">
<ig:message/>
<table class="table_style">
	<tr>
		<th width="5%"></th>
		<th width="12%">物品编号</th>
		<th width="12%">物品名称</th>
		<th width="12%">物品型号</th>
		<th width="15%">所属机构</th>
		<th width="12%">损毁数量</th>
		<th width="12%">说明</th>
		<th width="10%">状态</th>
	</tr>

	<logic:present name="ITEMS01011VO" property="outStockList">
		<logic:iterate id="bean" name="ITEMS01011VO" property="outStockList" indexId="index">
			<tr class="bgRow<%=index%2 %>">
				<td>
					<input name="checkbox" type="checkbox" value="${bean.outstockid}" />
				</td>
				<td>${bean.seqcode}</td>
				<td>${bean.itemsname}</td>
				<td>${bean.typecode}</td>
				<td><ig:cseOrgValue orgsyscoding="${bean.outstockorg}"/></td>
				<td>${bean.reqnum}</td>
				<td>${bean.pakreason}</td>
				<td><ig:cseCodeValue codeIndex="6" codeValue="${bean.reqstatus}" /></td>
			</tr>
		</logic:iterate>
		<html:hidden property="approveType" value="${approveType}" />
		<html:hidden property="approve" />
	</logic:present>

</table>
</div>
</html:form>

<div id="operate">
<div class="operate_btn">
	<logic:present name="ITEMS01011VO" property="outStockList">
	<span>
	<input type="button" value="通过"  class="button" onclick="checkboxSubmit(1);" />
    <input type="button" value="不通过" class="button" onclick="checkboxSubmit(0);" />
	
	</span>
	</logic:present><jsp:include page="/include/paging.jsp" />
</div>
</div>

</div>
</div>
</div>
</div>
</body>
</html:html>
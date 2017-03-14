<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0204" toScope="request" />
<bean:define id="title" value="入库管理页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function checkboxSubmit(obj){
	var mess = "";
	if(obj == 0){    	
		mess = "您确定要进行删除吗？";
	} else if (obj == 1){
		mess = "您确定要进行修改吗？";
	}
	message = "请选择要处理的批次！";
	
    if(window.confirm(mess)){
    	count = checkNumber();
    	if(count==0){
    		alert(message);
            return;
    	}
    	if(count==2){
            return;
    	}
    	if(obj == 0){    	
	    	document.forms[0].action = "IGLOM0204_Del.do";
    	} else if (obj == 1){
    		document.forms[0].action = "IGLOM0204_Edit.do";
    	}
    	document.forms[0].submit();
    } else {
        return;
    }
}

function checkNumber(){
	var count=0;
	var selectids = document.getElementsByName("selectid");
	var giodunits = document.getElementsByName("giodunit");
	var giodinprices = document.getElementsByName("giodinprice");
	var giodinnums = document.getElementsByName("giodinnum");
	
	for(var i=0;i<selectids.length;i++){
		if(selectids[i].checked==true){
			count=1;
			//if(giodunits[i].value.trim() == ""){
			//	alert("请输入单位！");
			//	count=2;
			//	return count;
			//}
			if(giodinprices[i].value.trim() == ""){
				alert("请输入价格！");
				count=2;
				return count;
			}
			if(giodinnums[i].value.trim() == "" || 0 == giodinnums[i].value){
				alert("请输入数量！");
				count=2;
				return count;
			}
			createHiddenInput("selectids",selectids[i].value);
			//createHiddenInput("giodunits",giodunits[i].value);
			createHiddenInput("giodinprices",giodinprices[i].value);
			createHiddenInput("giodinnums",giodinnums[i].value);
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
function checkSearch(){
	if(!checkDateByContent("giotime_f","giotime_t")){
		alert("开始日期不能晚于结束日期！");
		return false;
	}else{
		return true;
	}

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

function showIncident(){
	
	var ccid = "216";
	var cid = "";
	var syscode = "";
	if(null==syscode || ""==syscode){
		syscode = ccid;
	}else{
		ccid = syscode.substring(0,3);
	}

	url = "IGSYM1202_TREE_BY_STATUS.do" + "?ccid="+ccid+"&cid="+cid+"&syscode="+syscode;

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		$("giodcategory").value="";
		$("gcategoryname").value="";
			return false;
		}
	if(null!=temp && temp.split("|").length>1){
		var id = temp.split("|")[0];
		var name = temp.split("|")[1];
		var treeccid;
		var treecid;
		var treesyscode;
		
		if(id.split("_").length>1){
			treeccid = id.split("_")[0];
			treecid = id.split("_")[1];
			treesyscode = id.split("_")[2];
		}else{
			treeccid = id.split("_")[0];
			treecid = "";
			treesyscode = "";
		}

		$("giodcategory").value=treesyscode;
		$("gcategoryname").value=name;
		
	}		
	
}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form action="/IGLOM0204">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 入库管理</p>
</div>
<div id="search">
<div class="img"></div>
<div class="conditions">
<div><span>物品种类：</span>
		<html:text property="gcategoryname" size="18" readonly="true"/> 
		<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showIncident()" style="cursor: hand"/>
		<html:hidden property="giodcategory" />&nbsp;&nbsp;
<span>入库开始日期：</span><html:text property="giotime_f" />
<img src="images/date.gif" align="middle" onclick="calendar($('giotime_f'))" border="0" style="cursor: hand" />
<span>入库结束日期：</span><html:text property="giotime_t" />
<img src="images/date.gif" align="middle" onclick="calendar($('giotime_t'))" border="0" style="cursor: hand" />
<br><span>采购单号：</span><html:text property="giodreqnum" />
<input type="submit" value="查询" class="button"onclick="return checkSearch();" />
</div>
</div>
</div>
<!--</html:form>-->
<!--<html:form action="/IGLOM0204">-->
<div id="results_list">
<ig:message/>
<table class="table_style">
	<tr>
		<th width="4%"></th>
		<th width="21%">物品种类</th>
		<th width="20%">物品名称</th>
		<th width="15%">采购单号</th>
		<th width="12%">入库时间</th>
		<th width="10%">核销数量</th>
		<th width="10%">入库单价</th>
		<th width="10%">入库数量</th>
	</tr>
	<logic:present name="IGLOM02041VO" property="ginoutStockDetailVWList">
		<logic:iterate id="bean" name="IGLOM02041VO" property="ginoutStockDetailVWList" indexId="index">
		<bean:define id="gnum" value="${bean.giodhavocnum + bean.giodreliefnum + bean.giodoutnum}"/>	
			<tr> 
				<c:if test="${gnum==0}">
				<td>
					<input type="checkbox" name="selectid" value="${bean.giodid}" />
				</td>
				</c:if>
				<c:if test="${gnum!=0}">
				<td>
					
				</td>
				</c:if>
				<td>
					
					<ig:projectTypeValue ptype="${bean.giodcategory}" />
					
				</td>
				<td>${bean.giodname}</td>
				<td>${bean.giodreqnum}</td>
				<td>${bean.giodtime}</td> 
				<td>${bean.giodhavocnum}</td> 
                <td><c:if test="${gnum==0}">
                	<input name="giodinprice" type="text" value="${bean.giodinprice}" size="10" class="input1" onchange="checkFloatNum(this,'入库单价整数部分最大为9位，小数部分为2位！','请输入数字！');" />
                </c:if>
                <c:if test="${gnum!=0}">
                ${bean.giodinprice}
                </c:if>
                </td> 
                <td><c:if test="${gnum==0}">
                	<input name="giodinnum" type="text" value="${bean.giodinnum}" size="10" class="input1" onchange="checkNum(this);" />
                	</c:if>
                	<c:if test="${gnum!=0}">
                	${bean.giodinnum}
                	</c:if>
                </td> 
			</tr>
		</logic:iterate>
	</logic:present>

</table>
</div>

<div id="operate">
	<div class="operate_btn">
		<span>
			<html:button property="delSubmit" value="删除" styleClass="button" onclick="checkboxSubmit(0);" />
			<html:button property="EditSubmit" value="修改" styleClass="button" onclick="checkboxSubmit(1);" />
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
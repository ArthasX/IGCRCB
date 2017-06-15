<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGLOM0211" toScope="request" />
<bean:define id="title" value="核销申请页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function checkboxSubmit(obj){
	message = "请选择要处理的批次！";
    if(window.confirm("是否确认提交？")){
    	count = checkNumber();
    	if(count==0){
    		alert(message);
            return;
    	}
    	if(count==2){
            return;
    	}  	
	    document.forms[0].action = "IGLOM0211_Req.do"
    	document.forms[0].submit();
    } else {
        return;
    }
}

function checkNumber(){
	var count=0;
	var selectids = document.getElementsByName("selectid");
	var giodhavocnums = document.getElementsByName("giodhavocnum");
	var goreasons = document.getElementsByName("goreason");
	var giodnames = document.getElementsByName("giodname");
	
	for(var i=0;i<selectids.length;i++){
		if(selectids[i].checked==true){
			count=1;
			if(giodhavocnums[i].value.trim() == "" || giodhavocnums[i].value.trim() == "0" || Number(giodhavocnums[i].value.trim() == 0)){
				alert("请输入物品名称为\“"+giodnames[i].value+"\”的物品的核销数量！");
				count=2;
				return count;
			}
			if(goreasons[i].value != ""){
				if(goreasons[i].value.strlen()>40){
					alert("物品名称为\""+giodnames[i].value+"\"的物品的说明不能大于"+Math.floor(40/strByteFlag)+"个汉字！");
					count=2;
					return count;
				}
			}
			
			createHiddenInput("selectids",selectids[i].value);
			createHiddenInput("giodhavocnums",giodhavocnums[i].value);
			createHiddenInput("goreasons",goreasons[i].value);
		}
	}
	return count;
}
function checkSearch(){
	if(!checkDateByContent("giotime_f","giotime_t")){
		alert("开始日期不能晚于结束日期！");
		return false;
	}else{
		return true;
	}

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
		$("giodcategoryname").value="";
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
		$("giodcategoryname").value=name;
		
		
	}		
	
}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form action="/IGLOM0211">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 核销申请</p>
</div>
<div id="search">
<div class="img"></div>
<div class="conditions">
<div><span>物品种类：</span>
	<html:text property="giodcategoryname" size="18" readonly="true"/> 
	<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showIncident()" style="cursor: hand"/>
	<html:hidden property="giodcategory" />&nbsp;&nbsp;
<span>入库开始日期：</span><html:text property="giotime_f" readonly="true" />
<img src="images/date.gif" align="middle" onclick="calendar($('giotime_f'))" border="0" style="cursor: hand" />
<span>入库结束日期：</span><html:text property="giotime_t" readonly="true" />
<img src="images/date.gif" align="middle" onclick="calendar($('giotime_t'))" border="0" style="cursor: hand" />
<br><span>采购单号：</span><html:text property="giodreqnum" />
<input type="submit" value="查询" class="button" onclick="return checkSearch();"/>
</div>
</div>
</div>
<div id="results_list">
<ig:message/>
<table class="table_style">
	<tr>
		<th width="4%"></th>
		<th width="12%">物品种类</th>
		<th width="12%">物品名称</th>
		<th width="10%">入库时间</th>
		<th width="10%">入库数量</th>
		<th width="8%">已出库数量</th>
		<th width="10%">最新冻结数量</th>
		<th width="8%">入库单价</th>
		<th width="8%">核销数量</th>
		<th width="16%">说明</th>
		<th></th>
	</tr>
	<logic:present name="IGLOM02111VO" property="ginoutStockDetailVWList">
		<logic:iterate id="bean" name="IGLOM02111VO" property="ginoutStockDetailVWList" indexId="index">
		<bean:define id="gnum" value="${bean.giodhavocnum + bean.giodreliefnum + bean.giodoutnum}"/>
		<c:if test="${bean.giodinnum != gnum}">	
			<tr>
				<td>
					<input type="checkbox" name="selectid" value="${bean.giodid}"/>
				</td>
				<td>
					<ig:projectTypeValue ptype="${bean.giodcategory}" />
				</td>
				<td>${bean.giodname}</td>
				<td>${bean.giodtime}</td> 
				<td>
					${bean.giodinnum}
				</td> 
				<td>${gnum}</td> 
				<td>${bean.gsfreezenum}</td>
                <td>${bean.giodinprice}</td>
                <td>
                	<input name="giodhavocnum" type="text" value="0" size="10" class="input1" onchange="checkNum(this);" />
                </td> 
                <td>
                	<input name="goreason" type="text"  size="25" maxlength="25" class="input1" />
                </td> 
                <td>
                	<input name="giodname" type="hidden" value="${bean.giodname}"  />
                </td>
			</tr>
			</c:if>
		</logic:iterate>
	</logic:present>

</table>
</div>

<div id="operate">
	<div class="operate_btn">
		<span>
			<html:button property="delSubmit" value="申请核销" styleClass="button" onclick="checkboxSubmit();" />
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
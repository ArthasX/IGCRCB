<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0212" toScope="request" />
<bean:define id="title" value="核销管理页面" toScope="request" />
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
    	if(obj == 0){    	
	    	document.forms[0].action = "IGLOM0212_NoApprove.do";
    	} else if (obj == 1){
    		document.forms[0].action = "IGLOM0212_Approve.do";
    	}
    	document.forms[0].submit();
    } else {
        return;
    }
}

function checkNumber(){
	var count=0;
	var selectids = document.getElementsByName("selectid");
	for(var i=0;i<selectids.length;i++){
		if(selectids[i].checked==true){
			count=1;
			createHiddenInput("selectids",selectids[i].value);
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
		$("gocategory").value="";
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

		
		$("gocategory").value=treesyscode;
		$("gcategoryname").value=name;
		
		
	}		
	
}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form action="/IGLOM0212">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 核销管理</p>
</div>
<div id="search">
<div class="img"></div>
<div class="conditions">
<div><span>物品种类：</span>
	<html:text property="gcategoryname" size="18" readonly="true"/> 
	<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showIncident()" style="cursor: hand"/>
	<html:hidden property="gocategory" />&nbsp;&nbsp;&nbsp;&nbsp;
<span>状态：</span>
<html:select property="gostatus" errorStyleClass="inputError imeActive">
	<html:options collection="gostatusList" property="value" labelProperty="label" />
</html:select>
<input type="submit" value="查询" class="button" />
</div>
</div>
</div>
<div id="results_list">
<ig:message/>
<table class="table_style">
	<tr>
		<th width="4%"></th>
		<th width="8%">物品种类</th>
		<th width="10%">物品编号</th>
		<th width="12%">物品名称</th>
		<th width="15%">所属机构</th>
		<th width="7%">申请人</th>
		<th width="10%">最新库存数量</th>
		<th width="10%">最新冻结数量</th>
		<th width="7%">申请数量</th>
		<th width="10%">说明</th>
		<th width="10%">状态</th>
	</tr>
	<logic:present name="IGLOM02121VO" property="goutstockVWList">
		<logic:iterate id="bean" name="IGLOM02121VO" property="goutstockVWList" indexId="index">
			<tr>
				<td>
					<logic:equal value="1" name="IGLOM0212Form" property="gostatus">
						<input type="checkbox" name="selectid" value="${bean.goid}"/>
					</logic:equal>
				</td>
				<td>
					<ig:projectTypeValue ptype="${bean.gocategory}" />
				</td>
				<td>${bean.gocode}</td>
				<td>${bean.goname}</td>
				<td><ig:cseOrgValue orgsyscoding="${bean.goorg}"/></td>
				<td>${bean.gousername}</td> 
				<td>${bean.gsnum}</td> 
				<td>${bean.gsfreezenum}</td> 
				<td>${bean.gochknum}</td> 
				<td>${bean.goreason}</td> 
                <td>
                	<ig:cseCodeValue codeIndex="<%=CodeUtils.OUTSTOCK_STATUS %>" codeValue="${bean.gostatus}" />
                </td>
			</tr>
		</logic:iterate>
	</logic:present>

</table>
</div>

<div id="operate">
	<div class="operate_btn">
		<span>
			<logic:equal value="1" name="IGLOM0212Form" property="gostatus">
				<html:button property="aprovesubmit" value="审批通过" styleClass="button" onclick="checkboxSubmit(1);" />
				<html:button property="noaprovesubmit" value="审批不通过" styleClass="button" onclick="checkboxSubmit(0);" />
			</logic:equal>
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
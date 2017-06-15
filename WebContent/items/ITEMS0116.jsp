<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils" %>
<html:html>
<bean:define id="id" value="ITEMS0116" toScope="request" />
<bean:define id="title" value="物品使用调整页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function checkboxSubmit(){
	message = "请选择要提交的批次！";
    if(window.confirm("是否确认提交？")){
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
	var subreqorg = document.getElementsByName("subreqorg");
	var subreqname = document.getElementsByName("subreqname");
	
	for(var i=0;i<checkbox.length;i++){
		if(checkbox[i].checked==true){
			count=1;
			if(subinnum[i].value == "" || 0 == subinnum[i].value){
				alert("请输入调整数量！");
				count=2;
				return count;
			}
			if(subreqorg[i].value == "" ){
				alert("请选择使用机构！");
				count=2;
				return count;
			}
			if(subreqname[i].value.trim() == "" ){
				alert("请输入使用人！");
				count=2;
				return count;
			}

			
			createHiddenInput("instockid",checkbox[i].value);
			createHiddenInput("useNum",subinnum[i].value);
			createHiddenInput("reqorg",subreqorg[i].value);
			createHiddenInput("reqname",subreqname[i].value);
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
	if(obj.value < 0){
		alert("请输入正整数！");
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


function checkReqnameLength(obj){
	if(obj.value.strlen()>32){
		alert("使用人不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
		obj.value = "";
		return;
	}
}

function setOrg(url,count){
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		if(document.forms[0].subreqorg.length>1){
			document.forms[0].subreqorg[count].value = temp.split("|")[0];
			document.forms[0].subreqorgname[count].value = temp.split("|")[1];
		}else{
			document.forms[0].subreqorg.value = "";
			document.forms[0].subreqorgname.value = "";

		}
		return false;
	}
	
	if(null!=temp && temp.split("|").length>1){
		if(document.forms[0].subreqorg.length>1){
			document.forms[0].subreqorg[count].value = temp.split("|")[0];
			document.forms[0].subreqorgname[count].value = temp.split("|")[1];
		}else{
			document.forms[0].subreqorg.value = temp.split("|")[0];
			document.forms[0].subreqorgname.value = temp.split("|")[1];
		}

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
<p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 使用调整</p>
<div class="back"><a href="ITEMS0112_BACK.do" target="_self">返回</a></div>
</div>
<html:form action="/ITEMS0116">
<div id="results_list">
<table class="table_style">
	<tr>
		<th width="3%"></th>
		<th width="10%">物品编号</th>
		<th width="7%">物品类型</th>
		<th width="12%">入库时间</th>
		<th width="7%">入库数量</th>
		<th width="7%">出库数量</th>
		<th width="7%">损耗数量</th>
		<th width="7%">销毁数量</th>
		<th width="7%">使用数量</th>
		<th width="25%">使用人机构</th>
		<th width="8%">使用人</th>
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
				<td>
				<logic:equal name="updateOrg"  value="Y">
					<input name="subreqorgname" type="text" size="25" class="input1" readonly="readonly" value="<bean:write name="LOGIN_USER" property="orgname" />" />
					<img src="images/tree.gif" style="cursor: hand;" alt="选择使用人机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do',${index});"/>
					<input name="subreqorg" type="hidden" value="${LOGIN_USER.orgid}"/>
				</logic:equal>
				<logic:notEqual name="updateOrg" value="Y">
					<bean:write name="LOGIN_USER" property="orgname" />
					<input name="subreqorg" type="hidden" value="${LOGIN_USER.orgid}" />
				</logic:notEqual>
					
				</td>
				<td>
					<input name="subreqname" type="text" size="8" class="input1" onchange="checkReqnameLength(this);" />
				</td>
			</tr>
		</logic:iterate>
	</logic:present>
	
</table>


</div>
<div id="operate">
<div class="operate_btn">
<span>
	<html:button property="checkBoxSubmit" value="调整" styleClass="button" onclick="checkboxSubmit();" />
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
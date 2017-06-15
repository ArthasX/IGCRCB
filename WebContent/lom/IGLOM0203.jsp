<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0203" toScope="request" />
<bean:define id="title" value="物品入库页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var gid='IGLOM0203';
function checkForm() {
	if($F('giodreqnum').trim()==""){
		alert("采购申请单批号不能为空！");
		return false;
	}
	if($F('giodreqnum').strlen()>32){
		alert("采购申请单批号不能大于32个字符！");
		return false;
	}
	if($F('giodcategory').trim()==""){
		alert("物品种类不能为空！");
		return false;
	}
	if($F('giodcode').trim()==""){
		alert("物品编号不能为空！");
		return false;
	}
	if($F('giodname').trim()==""){
		alert("物品名称不能为空！");
		return false;
	}
	if($F('giodinnum').trim()==""){
		alert("数量不能为空！");
		return false;
	}
	if($F('giodunit').trim()==""){
		alert("计量单位不能为空！");
		return false;
	}
	if($F('giodunit').strlen()>4){
		alert("计量单位不能大于4个字符！");
		return false;
	}
	if($F('giodinprice').trim()==""){
		alert("入库单价不能为空！");
		return false;
	}
	if($F('giodprovider').strlen()>128){
		alert("供应商不能大于128个字符！");
		return false;
	}
	if($F('giodpurchaser').strlen()>32){
		alert("购买人不能大于32个字符！");
		return false;
	}
	if (confirm("是否确认提交?")) {
		return true;
	}
	return false;
}

function selectSeqCode(){
	if(document.getElementById("giodcategory").value==""){
		alert("请选择物品种类！");
		return;
	}
	
	var categoryValue = document.getElementById("giodcategory").value;
	openSubWindow("/IGLOM0202.do?gstatus=1&path=instock&gcategory="+categoryValue , "_blank", "800", "600");
}

function setParamLom0203(giodcode, giodname,gcategory) {
    $("giodcode").value = giodcode;
	$("giodname").value = giodname;
	$("giodcategory").value = gcategory;
}

function clearText(){
	$("giodcode").value = "";
	$("giodname").value = "";
}


function checkNum(obj){
	if(obj.value!=""){
		if(!checkIsNumberForCSE(obj.value)){
			alert("请输入最大长度为9位的正整数！");
			obj.value = "";
			obj.focus();
			event.returnValue = false;
		}
	}
	
}

function checkIsNumberForCSE(str){
 	myReg = /^[1-9][0-9]{0,8}$/;
	
 	return myReg.test(str);
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
		$("giodcode").value="";
		$("giodname").value="";
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

	$("giodcode").value="";
	$("giodname").value="";
	
}


</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 物品入库</p>
</div>
<div id="formwrapper">
<html:form action="/IGLOM0203" onsubmit="return checkForm();">
<fieldset><legend>物品信息</legend>
<ig:message/>
<div><label for="Name"><span class="red">*</span><strong>采购申请单批号</strong>：</label>
<html:text property="giodreqnum" size="30" /> <br />
</div>
<div><label for="Name"><span class="red">*</span><strong>物品种类</strong>：</label>
	<html:text property="gcategoryname" size="18" readonly="true"/> 
	<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showIncident()" style="cursor: hand"/>
	<html:hidden property="giodcategory" />
</div>
<div><label for="Name"><span class="red">*</span><strong>物品编号</strong>：</label>
<html:text property="giodcode"  size="30" readonly="true" styleClass="inputDisable" />
<img src="images/seek.gif" style="cursor: hand;" alt="物品模型" width="16" height="16" onclick="selectSeqCode();" /> 
</div>
<div><label for="Name"><span class="red">*</span><strong>物品名称</strong>：</label>
<html:text property="giodname"  size="30" readonly="true" styleClass="inputDisable" />
</div>
<div><label for="Name"><span class="red">*</span><strong>数量</strong>：</label>
<html:text property="giodinnum"  size="30" onblur="checkNum(this);" /> <br />
</div>
<div><label for="Name"><span class="red">*</span><strong>计量单位</strong>：</label>
<html:text property="giodunit"  size="30" /> <br />
</div>
<div><label for="Name"><span class="red">*</span><strong>入库单价</strong>：</label>
<html:text property="giodinprice"  size="30" onblur="checkFloatNum(this,'入库单价整数部分最大为9位，小数部分为2位！','请输入数字！');" /> <br />
</div>
<div><label for="Name"><strong>供应商</strong>：</label>
<html:text property="giodprovider"  size="30" /> <br />
</div>
<div><label for="Name"><strong>购买人</strong>：</label>
<html:text property="giodpurchaser"  size="30" /> <br />
</div>
</fieldset>
<div class="enter">
	<html:submit styleClass="button" value="提交" />
	<html:reset styleClass="button" value="重置" />
</div>
</html:form>
</div>

</div>
</div>
</div>
</div>
</body>
</html:html>
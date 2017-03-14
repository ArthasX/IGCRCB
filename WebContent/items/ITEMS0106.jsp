<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="ITEMS0106" toScope="request" />
<bean:define id="title" value="物品入库页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var gid='ITEMS0106';
function checkForm() {

	if($F('category').trim()==""){
		alert("物品种类不能为空！");
		return false;
	}
	if($F('seqcode').trim()==""){
		alert("物品编号不能为空！");
		return false;
	}
	if($F('itemsname').trim()==""){
		alert("物品名称不能为空！");
		return false;
	}
	if($F('type').trim()==""){
		alert("物品类型不能为空！");
		return false;
	}
	if($F('packnum').trim()==""){
		alert("包装大小不能为空！");
		return false;
	}
	if($F('bigpacknum').trim()==""){
		alert("大包装数量不能为空！");
		return false;
	}
	if($F('innum').trim()==""){
		alert("入库数量不能为空！");
		return false;
	}
	if($F('inprice').trim()==""){
		alert("入库单价不能为空！");
		return false;
	}
	if($F('outprice').trim()==""){
		alert("出库单价不能为空！");
		return false;
	}
	if($F('itemversion').strlen()>32){
		alert("凭证版本输入的长度不能大于32位字符！");
		return false;
	}
	if($F('printinside').strlen()>32){
		alert("印制部门输入的长度不能大于32位字符！");
		return false;
	}
	if($F('printexternal').strlen()>32){
		alert("外来凭证单位输入的长度不能大于32位字符！");
		return false;
	}
	if($F('printcompany').strlen()>32){
		alert("印刷厂家输入的长度不能大于32位字符！");
		return false;
	}
	if (confirm("是否确认提交?")) {
		return true;
	}
	
	return false;
}

function showDiv(obj){
	if(obj.value == "2"){
//		document.getElementById("printexternal").style.display = ""; 
//		document.getElementById("printcompany").style.display = ""; 
		document.getElementById("divtype").style.display = ""; 
	} else if (obj.value == "1"){
//		document.getElementById("printexternal").style.display = "none"; 
//		document.getElementById("printcompany").style.display = "none"; 
		document.getElementById("divtype").style.display = "none"; 
	}
}

function selectSeqCode(){
	if(document.getElementById("category").value==""){
		alert("请选择物品种类！");
		return;
	}
	var categoryValue = document.getElementById("category").value;
	openSubWindow("/ITEMS0101.do?status=1&path=instock&category="+categoryValue , "_blank", "800", "600");
}

function setParamItems0106(seqcode, typecode, type) {
    $("seqcode").value = seqcode;
	$("itemsname").value = typecode;
	$("typecode").value = type;
	searchOldStock();
}

function clearText(){
	$("seqcode").value = "";
	$("itemsname").value = "";
	$("typecode").value = "";
}

function checkNum(obj){
	if(isNaN(obj.value)){
		alert("请输入数字！");
		obj.value = "";
		return;
	}
}


function searchOldStock(){
	var seqcode = document.forms[0].seqcode.value;//物品编号
	var category = document.forms[0].category.value;//物品种类
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'seqcode='+ seqcode + '&category='+ category + '&type=searchOldStock',
		 onSuccess:  function(req, json){
		 var result=req.responseText;
			if(result!=null && result!=""){
				var strs= new Array(); 
				strs = result.split(",");
				//$("packnum").value = strs[1];
				//$("bigpacknum").value = strs[2];
				$("inprice").value = strs[3];
				$("outprice").value = strs[4];
				$("itemversion").value = strs[5];
				$("printinside").value = strs[6];
				$("nature").value = strs[7];
				if($("nature").value == "2"){
					document.getElementById("divtype").style.display = ""; 
				}
				$("printexternal").value = strs[8];
				$("printcompany").value = strs[9];
				$("type").value = strs[10];
				
				
			}
					
	     }
		});
}



</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="formwrapper">
<html:form action="/ITEMS0106" onsubmit="return checkForm();">
<fieldset><legend>物品信息</legend>
<div><label for="Name"><span class="red">*</span><strong>物品种类</strong>：</label>
<html:select property="category" errorStyleClass="inputError imeActive" onchange="clearText();">
	<html:options collection="itemsCodesList" property="value" labelProperty="label" />
</html:select> 
<br />
</div>
<div><label for="Name"><span class="red">*</span><strong>物品编号</strong>：</label>
<html:text property="seqcode"  size="30" readonly="true" styleClass="inputDisable" />
<img src="images/seek.gif" style="cursor: hand;" alt="物品模型" width="16" height="16" onclick="selectSeqCode();" /> 
<br />
</div>
<div><label for="Name"><span class="red">*</span><strong>物品名称</strong>：</label>
<html:text property="itemsname"  size="30" readonly="true" styleClass="inputDisable" />
</div>
<div><label for="Name"><strong>物品型号</strong>：</label>
<html:text property="typecode"  size="30" readonly="true" styleClass="inputDisable" /> <br />
</div>
<div><label for="Name"><span class="red">*</span><strong>物品类型</strong>：</label>

<html:select property="type" errorStyleClass="inputError imeActive">
	<html:options collection="itemTypeList" property="value" labelProperty="label" />
</html:select> 
<br />
</div>

<div><label for="Name"><span class="red">*</span><strong>包装大小</strong>：</label>
<html:text property="packnum"  size="30" onchange="checkNum(this);" /> <br />
</div>
<div><label for="Name"><span class="red">*</span><strong>大包装数量</strong>：</label>
<html:text property="bigpacknum"  size="30" onchange="checkNum(this);" /> <br />
</div>
<div><label for="Name"><span class="red">*</span><strong>入库数量</strong>：</label>
<html:text property="innum"  size="30" onchange="checkNum(this);" /> <br />
</div>
<div><label for="Name"><span class="red">*</span><strong>入库单价</strong>：</label>
<html:text property="inprice"  size="30" onchange="checkNum(this);" /> <br />
</div>
<div><label for="Name"><span class="red">*</span><strong>出库单价</strong>：</label>
<html:text property="outprice"  size="30" onchange="checkNum(this);" /> <br />
</div>
<div><label for="Name"><strong>凭证版本</strong>：</label> 
<html:text property="itemversion"  size="30" /><br />
</div>
<div><label for="Name"><strong>印制部门</strong>：</label> 
<html:text property="printinside"  size="30" /> <br />
</div>

<div><label for="Name"><strong>物品性质</strong>：</label>

<html:select property="nature" errorStyleClass="inputError imeActive" onchange="showDiv(this);">
	<html:options collection="natureList" property="value" labelProperty="label" />
</html:select> 
<br />
</div>

<div id="divtype" style="display:none">
<label for="Name"><strong>外来凭证单位</strong>：</label>
<html:text property="printexternal"  size="30" /> <br />

<label for="Name"><strong>印刷厂家</strong>：</label>
<html:text property="printcompany"  size="30" /><br />
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<%@ page import="com.csebank.lom.bl.IGLOMCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGLOM0201" toScope="request" />
<bean:define id="title" value="物品登记页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function checkForm(){
	if($("mode").value==0){
		if($F('gcategory').trim()==""){
			alert("物品种类不能为空！");
			return false;
		}
		if($F('gcode').trim()==""){
			alert("物品编号不能为空！");
			return false;
		}
	}
	if($F('gname').trim()==""){
		alert("物品名称不能为空！");
		return false;
	}
	
	if($F('gstatus').trim()==""){
		alert("状态不能为空！");
		return false;
	} 
	if($F('gunit').trim()==""){
		alert("单位不能为空！");
		return false;
	}
	if($F('gunit').strlen()>4){
		alert("单位不能大于4个字符！");
		return false;
	}
	if($F('gwarningnum').trim()==""){
		alert("预警提示数量不能为空！");
		return false;
	} 
	if($F('gprice').trim()==""){
		alert("内部转移定价不能为空！");
		return false;
	}
	if($F('gname').strlen()>120){
		alert("物品名称不能大于"+Math.floor(120/3)+"个汉字！");
		return false;
	}
	if($("mode").value==1){
		if($F('greason').strlen()>39){
			alert("状态改变原因不能大于"+Math.floor(39/3)+"个汉字！");
			return false;
		}
	}
	if(window.confirm("请确认是否要进行物品登记处理?")){
		return true;
	}
	return false;
}

function checkNum(obj){
	if(obj.value!=""){
		if(!checkIsNumberForCSE(obj.value)){
			alert("预警提示数量请输入最大长度为9位的正整数！");
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

	function searchGoodCode(treesyscode){
		if(treesyscode!="" && treesyscode !=null){
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'gcategory='+ treesyscode + '&type=searchGoodsCode',
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result!=null && result!=""){
						$("gcode").value = result;
					}
			     }
				});
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
			$("gcategory").value="";
			$("gcategoryname").value="";
			$("gcode").value="";
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
			searchGoodCode(treesyscode);
			$("gcategory").value=treesyscode;
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
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 
<logic:equal name="IGLOM0201Form" property="mode" value="0">
物品登记
</logic:equal>
<logic:equal name="IGLOM0201Form" property="mode" value="1">
物品编辑
</logic:equal>
</p>
</div>
<div id="formwrapper">
<html:form action="/IGLOM0201" onsubmit="return checkForm();">
<fieldset><legend>物品信息</legend>
<ig:message/>
<div><label for="Name"><span class="red">*</span><strong>物品种类</strong>：</label>
	<input type="text" name="gcategoryname" size="18" value="<ig:projectTypeValue ptype="${IGLOM0201Form.gcategory}" />" readonly="readonly"> 
	<logic:equal name="IGLOM0201Form" property="mode" value="0">
	<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showIncident()" style="cursor: hand"/><br />
	</logic:equal>
	<html:hidden property="gcategory" name="IGLOM0201Form"/>
</div>
<div><label for="Name"><span class="red">*</span><strong>物品编号 </strong>：</label>

<html:text property="gcode" size="30" readonly="true" styleClass="inputDisable" value="${IGLOM0201Form.gcode}"/>
<logic:equal name="IGLOM0201Form" property="mode" value="0">
<html:link onclick="searchGoodCode($(gcategory).value)" href="javascript:void(0)">获取物品编号</html:link><span class="red" id="labelMessage"></span>
</logic:equal>
<br />
</div>
<div><label for="Name"><span class="red">*</span><strong>物品名称</strong>：</label>
<html:text property="gname" size="30" value="${IGLOM0201Form.gname}"/> <br />
</div>
<div>
<logic:equal name="IGLOM0201Form" property="mode" value="0">
	<label for="Name"><span class="red">*</span><strong>状态</strong>：</label>
	<html:select property="gstatus" errorStyleClass="inputError" value="<%=IGLOMCONSTANTS.GOODS_STATUS_ENABLE %>">
		 <html:options collection="statusList" property="value" labelProperty="label" />
	</html:select><br />
</logic:equal>
<logic:equal name="IGLOM0201Form" property="mode" value="1">
	<label for="Name"><span class="red">*</span><strong>状态</strong>：</label>
	<html:select property="gstatus" errorStyleClass="inputError" value="${IGLOM0201Form.gstatus}">
		 <html:options collection="statusList" property="value" labelProperty="label" />
	</html:select><br />
</logic:equal>
</div>
<logic:equal name="IGLOM0201Form" property="mode" value="1">
<div><label for="Name"><strong>状态改变原因</strong>：</label>
<html:text property="greason" size="30" value="${IGLOM0201Form.greason}"/> <br />
</div>
</logic:equal>
<div><label for="Name"><span class="red">*</span><strong>单位</strong>：</label>
<html:text property="gunit" size="30" value="${IGLOM0201Form.gunit}"/> <br />
</div>
<div><label for="Name"><span class="red">*</span><strong>预警提示数量</strong>：</label>
<html:text property="gwarningnum" size="30" value="${IGLOM0201Form.gwarningnum}" onblur="checkNum(this)"/><br />
</div>
<div><label for="Name"><span class="red">*</span><strong>内部转移定价</strong>：</label>
<html:text property="gprice" size="30" value="${IGLOM0201Form.gprice}" onblur="checkFloatNum(this,'内部转移定价整数部分最大为9位，小数部分为2位！','内部转移定价请输入数字！')"/>(%)<br />
</div>

</fieldset>
<div class="enter">
	<html:hidden property="gid" value="${IGLOM0201Form.gid}"/>
	<html:hidden property="mode" value="${IGLOM0201Form.mode}"/>
	<input name="save" type="submit" class="button" value="提交" />
	<logic:equal name="IGLOM0201Form" property="mode" value="1">
		<input name="back" type="button" class="button" value="返回" onclick="window.location='IGLOM0202_Back.do'" />
	</logic:equal>
</div>
</html:form>
</div>

</div>
</div>
</div>
</div>
</body>
</html:html>
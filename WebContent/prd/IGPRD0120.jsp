<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGPRD0120" toScope="request" />
<logic:equal name="IGPRD0118Form" property="mode" value="0">
	<bean:define id="title" value="通用表单信息登记画面" toScope="request" />
</logic:equal>
<logic:equal name="IGPRD0118Form" property="mode" value="1">
	<bean:define id="title" value="通用表单信息变更画面" toScope="request" />
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function showDIV(obj){
	if(obj.value == "2" || obj.value == "B" || obj.value == "C"){
		document.getElementById("option").style.display = "";
		document.getElementById("default").style.display = "";
		document.getElementById("defaultValue").style.display = "";
		document.getElementById("spanRow").style.display = "none";
		document.getElementById("tree").style.display = "none";
		document.getElementById("ccid").value = "";
		document.getElementById("pidoption").value = "";
		document.getElementById("piddefault").value = "";
		document.getElementById("selectAddValue").value = "";
		document.getElementById("selectDefaultValue").options.length = 0;
		document.getElementById("selectValue").options.length = 0;
		if(document.getElementById("pidmode").value == "0"){
			document.getElementById("private").style.display="";
			document.getElementById("public").style.display="none";
		}
		var selectdefaultObj = document.getElementById("selectDefaultValue");
		selectdefaultObj.options.length = 0;
		var varItemEmpty = new Option("<空>", "");      
		selectdefaultObj.options.add(varItemEmpty);
		if(obj.value == "C"){
			document.getElementById("defaultValue").style.display = "none";
		}
		if(obj.value == "2"){
			document.getElementById("spanRow").style.display = "";
			if(document.getElementById("pidmode").value == "0"){
				document.getElementById("private").style.display="none";
				document.getElementById("public").style.display="";
			}
		}
	} else if(obj.value == "T"){
		document.getElementById("tree").style.display = "";
		document.getElementById("option").style.display = "none";
		document.getElementById("default").style.display = "none";
		document.getElementById("defaultValue").style.display = "none";
		document.getElementById("pidoption").value = "";
		document.getElementById("piddefault").value = "";
		document.getElementById("selectAddValue").value = "";
		document.getElementById("selectDefaultValue").options.length = 0;
		document.getElementById("selectValue").options.length = 0;
		if(document.getElementById("pidmode").value == "0"){
			document.getElementById("private").style.display="none";
			document.getElementById("public").style.display="";
		}
	}else {
		document.getElementById("option").style.display = "none";
		document.getElementById("default").style.display = "none";
		document.getElementById("defaultValue").style.display = "none";
		document.getElementById("pidoption").value = "";
		document.getElementById("piddefault").value = "";
		document.getElementById("selectAddValue").value = "";
		document.getElementById("selectDefaultValue").options.length = 0;
		document.getElementById("selectValue").options.length = 0;
		document.getElementById("tree").style.display = "none";
		document.getElementById("ccid").value = "";
		if(document.getElementById("pidmode").value == "0"){
			document.getElementById("private").style.display="none";
			document.getElementById("public").style.display="";
		}
	}
}

function setCcidParams(ccid,ccname) {
	 if(ccid==null || ""==ccid){
		 form.ccid_name.value = "";
		 form.ccid.value = "";
	 }else{
		 form.ccid_name.value = ccname;
		 form.ccid.value = ccid+"_tree_"+ccname;
	 }
}

function showModeDIV(obj){
	if(obj.value == "1"){
		document.getElementById("div_privatescope").style.display="";
		document.getElementById("private").style.display="";
		document.getElementById("public").style.display="none";
		document.getElementById("rowwidth").value = "0";
	}
	else
	{
		document.getElementById("private").style.display="none";
		document.getElementById("div_privatescope").style.display="none";
		$("privatescope").value = "";
		document.getElementById("public").style.display="";
		document.getElementById("rowwidth").value = "1";
	}	
}
function selectTree(){
    //openSubIGSYM1108();
    openSubWindow('/IGSYM1506_Disp.do' , '', '850', '600');
}

function setDefaultDIV(){
	if($F("pidmode") == "1"){
		document.getElementById("div_privatescope").style.display="";
		document.getElementById("private").style.display="";
		document.getElementById("public").style.display="none";
	} else {
		document.getElementById("private").style.display="none";
		$("privatescope").value = "";
		document.getElementById("div_privatescope").style.display="none";
		document.getElementById("public").style.display="";
	}
	if($F("mode") == "1"){
		if($F("pidtype") == "2" || $F("pidtype") == "B" || $F("pidtype") == "C"){
			document.getElementById("option").style.display = "";
			document.getElementById("default").style.display = "";
			document.getElementById("defaultValue").style.display = "";
			document.getElementById("spanRow").style.display = "none";
			document.getElementById("tree").style.display = "none";
			document.getElementById("ccid").value = "";
			
			var selectObj = document.getElementById("selectValue");
			var selectdefaultObj = document.getElementById("selectDefaultValue");
			var varItemEmpty = new Option("<空>", "");      
			selectdefaultObj.options.add(varItemEmpty);
			var str = "${IGPRD0118Form.pidoption}".split("#");
			for(var i=0;i<str.length;i++){
				var varItem = new Option(str[i], str[i]);
				if(str[i] != ""){
					selectdefaultObj.options.add(varItem);
					var varItemA = new Option(str[i], str[i]);
					selectObj.options.add(varItemA);
				}else{
					document.getElementById("isNullRow").checked = true;
				}
			}
			document.getElementById("selectDefaultValue").value="${IGPRD0118Form.piddefault}";
			if($F("pidtype") == "C"){
				document.getElementById("defaultValue").style.display = "none";
			}
			if($F("pidtype") == "2"){
				document.getElementById("spanRow").style.display = "";
			}
		} else if($F("pidtype") == "T"){
			document.getElementById("tree").style.display = "";
			document.getElementById("option").style.display = "none";
			document.getElementById("default").style.display = "none";
			document.getElementById("defaultValue").style.display = "none";
			document.getElementById("pidoption").value = "";
			document.getElementById("piddefault").value = "";
			if($F("ccid") != null){
				document.getElementById("ccid_name").value = $F("ccid").split("_tree_")[1];
			}
		}else {
			document.getElementById("option").style.display = "none";
			document.getElementById("default").style.display = "none";
			document.getElementById("defaultValue").style.display = "none";
			document.getElementById("pidoption").value = "";
			document.getElementById("piddefault").value = "";
			document.getElementById("tree").style.display = "none";
			document.getElementById("ccid").value = "";
		}
	}
}

 function toback(){
	 IGPRD0118Form.action = getAppRootUrl() + "/IGPRD0117_Back.do";
	 IGPRD0118Form.submit();
 }

 function checkForm(){
 	if($F('pidlabel').trim() == ""){
 		alert("请输入表单名称！");
 		return false;
 	}
 	if($F('pidtype').trim() == ""){
 	 	if('${IGPRD0118Form.mode}' == '0'){
	 		alert("请输入表单类型！");
	 		return false;
 	 	 }
 	}
 	if($F('pidmode').trim() == "1" && $F('privatescope').trim() == ""){
 		alert("请选择权限范围！");
 		return false;
 	}
 	if(document.getElementById("pidtype").value == "2" || document.getElementById("pidtype").value == "C" || document.getElementById("pidtype").value == "B"){
 	 	var value = "";
 	 	var objSelect = document.getElementById("selectValue");
 		for (var i = 0; i < objSelect.options.length; i++) {
 	 		if(i==0){
 	 	 		value = objSelect.options[i].value;
 	 	 	}else
 	 	 	{
 	 	 		value+="#"+objSelect.options[i].value;
 	 	 	 }        
	    }
		if("" == value){
			alert("请输入取值范围");
			return false;
		}
		if(document.getElementById("isNullRow").checked == true){
			value = "#"+value;
		}
		document.getElementById("pidoption").value = value;
		document.getElementById("piddefault").value = document.getElementById("selectDefaultValue").value;
	}
 	if($F('pidlabel').strlen()>128){
 		alert("表单名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
 		return false;
 	}
 	if($F('piddesc').strlen()>2000){
 		alert("表单说明不能大于"+Math.floor(2000/strByteFlag)+"个汉字！");
 		return false;
 	}
 	if($F('pidoption').trim().strlen()>512){
		alert("取值范围不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
		return false;
	}
	
	if($F('piddefault').trim().strlen()>64){
		alert("默认值不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
		return false;
	} 
 	var message = '';
    if ('${IGPRD0118Form.mode}' == '0'){
            message = '<bean:message key="IGCO10000.W001" arg0="表单基本信息" />';
     } else {
            message = '<bean:message key="IGCO10000.W003" arg0="表单基本信息" />';
    }
	if( window.confirm(message)){
			return true;
	} else {
			return false;
	}
 }

 
//************************select 标签控制************************
//添加
 function addSelectInfo(){
	var addValue = document.getElementById("selectAddValue").value.trim();
	if(addValue == ""){
		alert("内容不允许为空！");
		return;
	}
	
	 //**********取值范围
	var selectObj = document.getElementById("selectValue");
	//判断是否存在        
	if (jsSelectIsExitItem(selectObj, addValue)) {        
	      alert(addValue+"已经存在");
	      return;         
	} else {        
	     var varItem = new Option(addValue, addValue);      
	     selectObj.options.add(varItem);     
	}
	var selectObjnew = document.getElementById("selectValue");
	
	
	jsSelectItemFromSelect(selectObjnew);
	
	//*********默认值
	if(addValue == ""){
		return;
	}
	var selectdefaultObj = document.getElementById("selectDefaultValue");
	//判断是否存在        
	if (jsSelectIsExitItem(selectdefaultObj, addValue)) {        
	     return;         
	} else {        
	     var varItem = new Option(addValue, addValue);      
	     selectdefaultObj.options.add(varItem);     
	}
	document.getElementById("selectAddValue").value = "";
	document.getElementById("selectAddValue").focus();
 }
//删除
 function deleteSelectInfo(){
	 //****************取值范围
	 var selectObj = document.getElementById("selectValue");
	 var currSelectIndex = selectObj.selectedIndex;
	 if(currSelectIndex < 0){
		alert("无法删除");
		return;
	 }
	 var currSelectValue = selectObj.value;
	 jsRemoveSelectedItemFromSelect(selectObj);
	 var selectObjnew = document.getElementById("selectValue");
	 jsSelectItemFromSelect(selectObjnew);

	 //****************默认值
	 if(currSelectValue == ""){
		 return;
	 }
	 var selectdefaultObj = document.getElementById("selectDefaultValue");
	 jsRemoveItemFromSelect(selectdefaultObj,currSelectValue);
 }
//上移
 function upSelectInfo(){
	 //*************取值范围
	 var selectObj = document.getElementById("selectValue");
	 var currSelectIndex = selectObj.selectedIndex;
	 if(currSelectIndex <= 0){
		alert("无法上移");
		return;
	 }
	 var currSelectValue = selectObj.value; 
	 var changeValue = selectObj.options[parseInt(currSelectIndex)-1].value;
	 selectObj.options[parseInt(currSelectIndex)].value = changeValue;
	 selectObj.options[parseInt(currSelectIndex)].text = changeValue;
	 selectObj.options[parseInt(currSelectIndex)-1].value = currSelectValue;
	 selectObj.options[parseInt(currSelectIndex)-1].text = currSelectValue;
	 selectObj.options[parseInt(currSelectIndex)-1].selected = true;

	 //************默认值
	 var selectObjnew = document.getElementById("selectValue");
	 var selectdefaultObj = document.getElementById("selectDefaultValue");
	 var defaultvalue = selectdefaultObj.value;
	 selectdefaultObj.options.length = 0;
	 var varItemEmpty = new Option("<空>", "");      
	 selectdefaultObj.options.add(varItemEmpty);  
	 for (var i = 0; i < selectObjnew.options.length; i++) {        
         if (selectObjnew.options[i].value != "") {        
        	 var varItem = new Option(selectObjnew.options[i].value, selectObjnew.options[i].value);      
        	 selectdefaultObj.options.add(varItem);      
         }        
     } 
	 selectdefaultObj.value = defaultvalue;
}
//下移
 function downSelectInfo(){
	 var selectObj = document.getElementById("selectValue");
	 var currSelectIndex = selectObj.selectedIndex;
	 if(currSelectIndex < 0){
			alert("无法下移");
			return;
	}
	 if(currSelectIndex == selectObj.options.length-1){
		alert("无法下移");
		return;
	 }
	 var currSelectValue = selectObj.value; 
	 var changeValue = selectObj.options[parseInt(currSelectIndex)+1].value;
	 selectObj.options[parseInt(currSelectIndex)].value = changeValue;
	 selectObj.options[parseInt(currSelectIndex)].text = changeValue;
	 selectObj.options[parseInt(currSelectIndex)+1].value = currSelectValue;
	 selectObj.options[parseInt(currSelectIndex)+1].text = currSelectValue;
	 selectObj.options[parseInt(currSelectIndex)+1].selected = true;

	 //************默认值
	 var selectObjnew = document.getElementById("selectValue");
	 var selectdefaultObj = document.getElementById("selectDefaultValue");
	 var defaultvalue = selectdefaultObj.value;
	 selectdefaultObj.options.length = 0;
	 var varItemEmpty = new Option("<空>", "");   
	 selectdefaultObj.options.add(varItemEmpty);  
	 for (var i = 0; i < selectObjnew.options.length; i++) {        
         if (selectObjnew.options[i].value != "") {        
        	 var varItem = new Option(selectObjnew.options[i].value, selectObjnew.options[i].value);      
        	 selectdefaultObj.options.add(varItem);      
         }        
     } 
	 selectdefaultObj.value = defaultvalue;
}

//判断select选项中 是否存在Value="paraValue"的Item
 function jsSelectIsExitItem(objSelect, objItemValue) {        
	    var isExit = false;        
	    for (var i = 0; i < objSelect.options.length; i++) {        
	        if (objSelect.options[i].value == objItemValue) {        
	            isExit = true;        
	            break;        
	        }        
	    }        
	    return isExit;        
	}
//删除select中选中的项    
 function jsRemoveSelectedItemFromSelect(objSelect) {        
     var length = objSelect.options.length - 1;    
     for(var i = length; i >= 0; i--){    
         if(objSelect[i].selected == true){    
             objSelect.options[i] = null;    
         }    
     }    
 }
//3.从select选项中 删除一个Item        
 function jsRemoveItemFromSelect(objSelect, objItemValue) {        
     //判断是否存在        
     if (jsSelectIsExitItem(objSelect, objItemValue)) {        
         for (var i = 0; i < objSelect.options.length; i++) {        
             if (objSelect.options[i].value == objItemValue) {        
                 objSelect.options.remove(i);        
                 break;        
             }        
         }        
     }         
 }  
//设置select中最后一个为选中项
function jsSelectItemFromSelect(objSelect){
	var length = objSelect.options.length - 1;
	if(length >= 0){
		objSelect.options[length].selected = true;
	}
}
      
</script>
<body onload="setDefaultDIV()">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 通用表单管理 &gt;&gt; 
<logic:equal name="IGPRD0118Form" property="mode" value="0">表单登记</logic:equal>
<logic:equal name="IGPRD0118Form" property="mode" value="1">表单变更</logic:equal>

	               </p>

<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>

<div id="formwrapper"><html:form styleId="form"
	action="/IGPRD0118" onsubmit="return checkSubmit(this);">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset><logic:equal name="IGPRD0118Form" property="mode"
		value="0">
		<legend>基本信息添加</legend>
	</logic:equal> <logic:equal name="IGPRD0118Form" property="mode" value="1">
		<legend>基本信息变更</legend>
	</logic:equal>


	<div><label for="Name"><strong><span class="red">*</span>表单名称</strong>：</label>
	<html:text name="IGPRD0118Form" property="pidlabel" styleId="pidlabel"
		size="18" style="width:200px;" errorStyleClass="inputError"
		tabindex="1" /> <br>
	</div>
		
	<div><label for="Name"><strong><span class="red">*</span>表单模式</strong>：</label>
		<html:select name="IGPRD0118Form" property="pidmode" style="width: 85px;" errorStyleClass="inputError" onchange="showModeDIV(this)">
	        <ig:optionsCollection ccid="PROCESSINFODEF_MODE_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
	    </html:select>
	<br />
	</div>
	<div style="display: none" id="div_privatescope"><label for="Name"><strong><span class="red">*</span>权限范围</strong>：</label>
		<html:select name="IGPRD0118Form" property="privatescope" style="width: 85px;" errorStyleClass="inputError">
	        <ig:optionsCollection ccid="PROCESSINFODEF_PRIVATEACCESS_SCOPE" isMakeBlankRow="true" isCodeLabel="true"/>
	    </html:select>
	<br />
	</div>
	<div><label for="pidtype"><span class="red">*</span><strong>表单类型</strong>：</label>
		<logic:equal name="IGPRD0118Form" property="mode" value="0">
			<html:select name="IGPRD0118Form" property="pidtype" style="width: 85px;" errorStyleClass="inputError" onchange="showDIV(this)">
	        <ig:optionsCollection ccid="PROCESSINFODEF_TYPE_CODE_WD" isMakeBlankRow="true" isCodeLabel="true"/>
	    	</html:select>
	    </logic:equal>
	    <logic:equal name="IGPRD0118Form" property="mode" value="1">
	    	<html:select name="IGPRD0118Form" property="pidtype" style="width: 85px;" disabled="true">
	       		<ig:optionsCollection ccid="PROCESSINFODEF_TYPE_CODE_WD" isMakeBlankRow="true" isCodeLabel="true"/>
	    	</html:select>
	    </logic:equal>
	<br />
	</div>
     <div id="tree" style="display:none">
       <label for="ccid"><span class="red">*</span><strong>定义树</strong>：</label>
       	 	<input type="text" name="ccid_name"  readonly="readonly"  value=""/>
			<img src="images/seek.gif" alt='查询' onclick="selectTree()" style="cursor: hand"/>
			<html:hidden property="ccid" styleId="ccid" name="IGPRD0118Form" />
       <br />
     </div>
	<html:hidden property="pidoption" value="${IGPRD0118Form.pidoption}"/>
	<html:hidden property="piddefault" value="${IGPRD0118Form.piddefault}"/>
	 <div id="option" style="display:none">
       <label for="pidoption"><strong>取值范围</strong>：</label>
        <input type="text" id="selectAddValue" style="width:200px;" tabindex="1" value=""/>
     	<html:link href="javascript:addSelectInfo()">
			<img src="images/addinfo.gif" width="20" height="18" border="0" alt="增加" />
		</html:link>
       <br />
     </div>
     <div id="default" style="display:none">
	  <label for="piddefault" style="background-color: white"><strong></strong></label>
       <select size="5" id="selectValue" style="width: 207px;">
       </select>
       <html:link href="javascript:upSelectInfo()">
			<img src="images/upinfo.gif" width="16" height="20" border="0" alt="向上" />
		</html:link>
		<html:link href="javascript:downSelectInfo()">
			<img src="images/downinfo.gif" width="16" height="20" border="0" alt="向下"/>
		</html:link>
		<html:link href="javascript:deleteSelectInfo()">
			<img src="images/delete.gif" width="16" height="16" border="0" alt="删除" />
		</html:link>
		<span class="red" id="spanRow"><input type="checkbox" id="isNullRow"/>包含空行</span>
       <br />
     </div>
     <div id="defaultValue" style="display:none"> 
		<label for="piddefault"><strong>默认值</strong>：</label>
       <select id="selectDefaultValue" style="width: 207px;">
       </select>
	</div>
	<div style="display:none">
       <label for="pidrequired"><span class="red">*</span><strong>是否必填</strong>：</label>
        <select name="pidrequired">
        	<option value="0">否</option>
        	<option value="1">是</option>
        </select>
       <br />
    </div>
    
    <div style="display:none">
       <label for="pidsortid"><span class="red">*</span><strong>排序位置</strong>：</label>
        <select name="pidsortid">
        	<option value="99">99</option>
        </select>
       <br />
    </div>
	
	<div id="public" style="display:true">
       <label for="rowwidth"><span class="red">*</span><strong>显示模式</strong>：</label>
        <html:select name="IGPRD0118Form" property="rowwidth" style="width: 85px;" errorStyleClass="inputError">
	       <ig:optionsCollection ccid="PROCESSINFODEF_ROWWIDTH_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
	    </html:select>
	    <br />
    </div>
    <div id="private" style="display:none">
    	<label for="rowwidth"><span class="red">*</span><strong>显示模式</strong>：</label>
	    <select name="rowwidthDispaly" style="width: 85px;" disabled="disabled">
	        <option value="<%=IGPRDCONSTANTS.PIDROWWIDTH_FULL %>"><ig:codeValue ccid="PROCESSINFODEF_ROWWIDTH_CODE" cid="<%=IGPRDCONSTANTS.PIDROWWIDTH_FULL %>" /></option>
	    </select>
	    <html:hidden name="IGPRD0118Form" property="rowwidth" value="<%=IGPRDCONSTANTS.PIDROWWIDTH_FULL %>"/>
	    <br />
	</div>
	<div><label for="Name"><strong>表单说明</strong>：</label> <html:textarea
		name="IGPRD0118Form" property="piddesc" styleId="piddesc"
		rows="7" cols="60" errorStyleClass="inputError" /> <br>
	</div>
	</fieldset>
	<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return checkForm();" /></div>
	<html:hidden property="pidid" styleId="pidid" name="IGPRD0118Form" />
	<html:hidden property="mode" styleId="mode" name="IGPRD0118Form" />
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>

</body>
</html:html>
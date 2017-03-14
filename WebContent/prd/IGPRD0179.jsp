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
<bean:define id="id" value="IGPRD0179" toScope="request" />
<logic:equal name="IGPRD0111Form" property="mode" value="0">
	<bean:define id="title" value="列基本信息登记画面" toScope="request" />
</logic:equal>
<logic:equal name="IGPRD0111Form" property="mode" value="1">
	<bean:define id="title" value="列基本信息变更画面" toScope="request" />
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function showDIV(obj){
	document.getElementById("piddefaults").style.display = "none";
	document.getElementById("textdefault").value="";
	if(obj.value == "2" || obj.value == "B" || obj.value == "E" || obj.value == "C" || obj.value == "L" || obj.value == "S"){
		document.getElementById("processRows").style.display = "none";
		document.getElementById("rawDefault").style.display = "none";
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
		document.getElementById("entityRows").style.display = "none";
		document.getElementById("entitySyscoding").style.display = "none";
		document.getElementById("isShowLine").style.display = "none";
		document.getElementById("titleShowModel").style.display = "none";
		document.getElementById("treeSelecedLast").style.display = "none";
		document.getElementById("numberTypeDiv").style.display = "none";
		document.getElementById("decimalsDiv").style.display = "none";
		// 清理表格类列数据
		document.getElementById("tabledisplay").style.display = "none";
		document.getElementById("tableuse").style.display = "none";
		document.getElementById("piddisplay").value = "";
		document.getElementById("piduse").value = "";
		document.getElementById("pidwidth").value = "";
		document.getElementById("tablerows").style.display = "none";
		document.getElementById("pidrows").value = "";
		document.getElementById("tablehide").style.display = "";
		if(document.getElementById("pidmode").value == "0"){
			document.getElementById("rowwidth").value = <%=IGPRDCONSTANTS.PIDROWWIDTH_FULL%>
		}
		
		var selectdefaultObj = document.getElementById("selectDefaultValue");
		selectdefaultObj.options.length = 0;
		var varItemEmpty = new Option("<空>", "");      
		selectdefaultObj.options.add(varItemEmpty);
		if(obj.value == "C" || obj.value == "S"){
			document.getElementById("defaultValue").style.display = "none";
		}
		if(obj.value == "2"){
			document.getElementById("spanRow").style.display = "";
			if(document.getElementById("pidmode").value == "0"){
			}
		}
		if(obj.value == "B" || obj.value == "E" || obj.value == "C"){
			document.getElementById("showstyle").style.display = "";
			document.getElementById("showstyles").value = "0";
		}
		document.getElementById("fileDefaultValue").style.display = "none";
		document.getElementById("asmDefaultValue").style.display = "none";
	} else if(obj.value == "T"){
		document.getElementById("processRows").style.display = "none";
		document.getElementById("rawDefault").style.display = "";
		document.getElementById("showstyle").style.display = "none";
		document.getElementById("tree").style.display = "";
		document.getElementById("option").style.display = "none";
		document.getElementById("default").style.display = "none";
		document.getElementById("defaultValue").style.display = "none";
		document.getElementById("pidoption").value = "";
		document.getElementById("piddefault").value = "";
		document.getElementById("selectAddValue").value = "";
		document.getElementById("selectDefaultValue").options.length = 0;
		document.getElementById("selectValue").options.length = 0;
		document.getElementById("entityRows").style.display = "none";
		document.getElementById("entitySyscoding").style.display = "none";
		document.getElementById("isShowLine").style.display = "none";
		document.getElementById("titleShowModel").style.display = "none";
		document.getElementById("treeSelecedLast").style.display = "";
		document.getElementById("numberTypeDiv").style.display = "none";
		document.getElementById("decimalsDiv").style.display = "none";
		// 清理表格类列数据
		document.getElementById("tabledisplay").style.display = "none";
		document.getElementById("tableuse").style.display = "none";
		document.getElementById("piddisplay").value = "";
		document.getElementById("piduse").value = "";
		document.getElementById("pidwidth").value = "";
		document.getElementById("tablerows").style.display = "none";
		document.getElementById("pidrows").value = "";
		document.getElementById("tablehide").style.display = "";
		document.getElementById("fileDefaultValue").style.display = "none";
		document.getElementById("asmDefaultValue").style.display = "none";
	} else if(obj.value == "8"){
		document.getElementById("processRows").style.display = "none";
		document.getElementById("rawDefault").style.display = "none";
		document.getElementById("showstyle").style.display = "none";
		document.getElementById("tabledisplay").style.display = "";
		document.getElementById("tableuse").style.display = "";
		document.getElementById("option").style.display = "none";
		document.getElementById("default").style.display = "none";
		document.getElementById("defaultValue").style.display = "none";
		document.getElementById("treeSelecedLast").style.display = "none";
		document.getElementById("pidoption").value = "";
		document.getElementById("piddefault").value = "";
		document.getElementById("selectAddValue").value = "";
		document.getElementById("selectDefaultValue").options.length = 0;
		document.getElementById("selectValue").options.length = 0;
		document.getElementById("tree").style.display = "none";
		document.getElementById("numberTypeDiv").style.display = "none";
		document.getElementById("decimalsDiv").style.display = "none";
		document.getElementById("ccid").value = "";
		document.getElementById("private").style.display="";
		document.getElementById("public").style.display="none";
		document.getElementById("rowwidth").value = "0";
		document.getElementById("entityRows").style.display = "none";
		document.getElementById("entitySyscoding").style.display = "none";
		document.getElementById("titleShowModel").style.display = "";
		var piddisplay = document.getElementById("piddisplay").value;
		document.getElementById("tablehide").style.display = "none";
		document.getElementById("isShowLine").style.display = "";
		if(piddisplay == ""){
			document.getElementById("piddisplay").value ="1";
		}
		//二维表显示是否显示行号选项
		if(document.getElementById("piddisplay").value == "1"){
			document.getElementById("isShowRowNum").style.display = "";
		}else{
			document.getElementById("isShowRowNum").style.display = "none";
		}
		var piduse = document.getElementById("piduse").value;
		if(piduse == ""){
			document.getElementById("piduse").value ="1";
		}
		if(piduse == "2"){ // 固定行
			document.getElementById("tablerows").style.display = "";
		}
		if(obj.value == "B" || obj.value == "E" || obj.value == "C" || obj.value == "S"){
			document.getElementById("showstyle").style.display = "";
			document.getElementById("showstyles").value = "0";
		}
		document.getElementById("fileDefaultValue").style.display = "none";
		document.getElementById("asmDefaultValue").style.display = "none";
	}else {
		document.getElementById("showstyle").style.display = "none";
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
		document.getElementById("isShowLine").style.display = "none";
		document.getElementById("titleShowModel").style.display = "none";
		document.getElementById("treeSelecedLast").style.display = "none";
		// 清理表格类列数据
		document.getElementById("tabledisplay").style.display = "none";
		document.getElementById("tableuse").style.display = "none";
		document.getElementById("piddisplay").value = "";
		document.getElementById("piduse").value = "";
		document.getElementById("pidwidth").value = "";
		document.getElementById("tablerows").style.display = "none";
		document.getElementById("pidrows").value = "";
		document.getElementById("tablerows").style.display = "none";
		document.getElementById("pidrows").value = "";
		document.getElementById("tablehide").style.display = "";
		if(obj.value == "F"){
			document.getElementById("entityRows").style.display = "none";
			document.getElementById("entitySyscoding").style.display = "none";
			document.getElementById("attmobel").style.display = "";
	    	document.getElementById("pidrows").value = "1";
	    	document.getElementById("fileDefaultValue").style.display = "";
			fileDefaultValueContent($F("attMobelSelecter"));
			document.getElementById("asmDefaultValue").style.display = "none";
		}else if(obj.value == "4"){
	    	document.getElementById("fileDefaultValue").style.display = "none";
			document.getElementById("entityRows").style.display = "";
			document.getElementById("entitySyscoding").style.display = "";
			document.getElementById("attmobel").style.display = "none";
			document.getElementById("pidrows").value = "1";
			document.getElementById("asmDefaultValue").style.display = "";
			asmDefaultValue($F("entityRowsSelecter"));
		}else{
	    	document.getElementById("fileDefaultValue").style.display = "none";
			document.getElementById("entityRows").style.display = "none";
			document.getElementById("attmobel").style.display = "none";
			document.getElementById("entitySyscoding").style.display = "none";
			document.getElementById("asmDefaultValue").style.display = "none";
		}
		if(obj.value == "5"){
			document.getElementById("processRows").style.display = "";
			document.getElementById("pidrows").value = "1";
		}else{
			document.getElementById("processRows").style.display = "none";
		}
		if(obj.value == "0" || obj.value == "9"){
			document.getElementById("rawDefault").style.display = "none";
			document.getElementById("piddefaults").style.display = "";
			document.getElementById("pidsizediv").style.display = "";
		}else if(obj.value == "7"){
			document.getElementById("rawDefault").style.display = "";
			document.getElementById("pidsizediv").style.display = "";
		}else{
			document.getElementById("rawDefault").style.display = "none";
			document.getElementById("pidsizediv").style.display = "none";
		}
		if(obj.value == "0"){
			document.getElementById("writeablediv").style.display = "";
		}else{
			document.getElementById("writeablediv").style.display = "none";
		}
		if(obj.value == "7"){
			document.getElementById("numberTypeDiv").style.display = "";
			document.getElementById("decimalsDiv").style.display = "";
			$("decimals").value = "2";
		}else{
			document.getElementById("numberTypeDiv").style.display = "none";
			document.getElementById("decimalsDiv").style.display = "none";
			$("decimals").value = "";
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
		document.getElementById("private").style.display="";
		document.getElementById("public").style.display="none";
		document.getElementById("rowwidth").value = "0";
	}
	else
	{
		document.getElementById("private").style.display="none";
		document.getElementById("public").style.display="";
		document.getElementById("rowwidth").value = "1";
	}	
}
function selectTree(){
    //openSubIGSYM1108();
    openSubWindow('/IGSYM1506_Disp.do' , '', '850', '600');
}

function setDefaultDIV(){
	var pdid = document.getElementById("pdid").value;
	if(pdid != null && pdid != "" && pdid.length > 0){
		if(parseInt(pdid.substring(0,1)) > 0){
			document.getElementById("isNeedIdea").style.display = "";
		}
	}
	var pidsize = '${IGPRD0111Form.pidsize}';
	if("0" == pidsize){
		document.getElementById("pidsize").value = "";
	}
	if($F("pidmode") == "1"){
		document.getElementById("private").style.display="";
		document.getElementById("public").style.display="none";
	} else {
		document.getElementById("private").style.display="none";
		document.getElementById("public").style.display="";
	}
	if($F("piddisplay") == "1" || $F("piddisplaya") == "1"){
		document.getElementById("tablewidth").style.display="";
		document.getElementById("private").style.display="";
		document.getElementById("public").style.display="none";
	}else{
		document.getElementById("tablewidth").style.display="none";
		document.getElementById("private").style.display="none";
		document.getElementById("public").style.display="";
	}
	if($F("mode") == "1"){
		if($F("pidtype") == "2" || $F("pidtype") == "B" || $F("pidtype") == "E" || $F("pidtype") == "C" || $F("pidtype") == "L" || $F("pidtype") == "S"){
			document.getElementById("rawDefault").style.display = "none";
			document.getElementById("option").style.display = "";
			document.getElementById("default").style.display = "";
			document.getElementById("defaultValue").style.display = "";
			document.getElementById("spanRow").style.display = "none";
			document.getElementById("tree").style.display = "none";
			document.getElementById("ccid").value = "";
			document.getElementById("entityRows").style.display = "none";
			document.getElementById("entitySyscoding").style.display = "none";
			document.getElementById("isShowLine").style.display = "none";
			document.getElementById("titleShowModel").style.display = "none";
			document.getElementById("treeSelecedLast").style.display = "none";
			document.getElementById("numberTypeDiv").style.display = "none";
			document.getElementById("decimalsDiv").style.display = "none";
			document.getElementById("tablehide").style.display = "";
			var selectObj = document.getElementById("selectValue");
			var selectdefaultObj = document.getElementById("selectDefaultValue");
			var varItemEmpty = new Option("<空>", "");      
			selectdefaultObj.options.add(varItemEmpty);
			var str = "${IGPRD0111Form.pidoption}".split("#");
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
			document.getElementById("selectDefaultValue").value="${IGPRD0111Form.piddefault}";
			if($F("pidtype") == "C" || $F("pidtype") == "S"){
				document.getElementById("defaultValue").style.display = "none";
			}
			if($F("pidtype") == "2"){
				document.getElementById("spanRow").style.display = "";
			}
			if($F("pidtype") == "B" || $F("pidtype") == "E" || $F("pidtype") == "C" || $F("pidtype") == "S"){
				document.getElementById("showstyle").style.display = "";
			}			
		} else if($F("pidtype") == "T"){
			document.getElementById("rawDefault").style.display = "";
			document.getElementById("tree").style.display = "";
			document.getElementById("option").style.display = "none";
			document.getElementById("default").style.display = "none";
			document.getElementById("defaultValue").style.display = "none";
			document.getElementById("pidoption").value = "";
			document.getElementById("piddefault").value = "";
			document.getElementById("entityRows").style.display = "none";
			document.getElementById("treeSelecedLast").style.display = "";
			document.getElementById("numberTypeDiv").style.display = "none";
			document.getElementById("decimalsDiv").style.display = "none";
			document.getElementById("entitySyscoding").style.display = "none";
			document.getElementById("isShowLine").style.display = "none";
			document.getElementById("titleShowModel").style.display = "none";
			document.getElementById("tablehide").style.display = "";
			if($F("ccid") != null){
				document.getElementById("ccid_name").value = $F("ccid").split("_tree_")[1];
			}
			if($F("piddefault") != null && $F("piddefault") != ""){
				document.getElementById("rawDefaultValue").value = $F("piddefault").split("_tree_")[1];
			}
		} else if($F("pidtype") == "8"){
			document.getElementById("tabledisplay").style.display = "";
			document.getElementById("tableuse").style.display = "";
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
			document.getElementById("private").style.display="";
			document.getElementById("public").style.display="none";
			document.getElementById("rowwidth").value = "0";
			var piddisplay = document.getElementById("piddisplay").value;
			document.getElementById("entityRows").style.display = "none";
			document.getElementById("numberTypeDiv").style.display = "none";
			document.getElementById("decimalsDiv").style.display = "none";
			document.getElementById("entitySyscoding").style.display = "none";
			document.getElementById("isShowLine").style.display = "";
			document.getElementById("titleShowModel").style.display = "";
			document.getElementById("tablehide").style.display = "none";
			document.getElementById("treeSelecedLast").style.display = "none";
			if(piddisplay == ""){
				document.getElementById("piddisplay").value ="1";
				//document.getElementById("tablewidth").style.display = "";
				//document.getElementById("rowwidth").value = "0";
			}
			//二维表显示是否显示行号选项
			if(document.getElementById("piddisplay").value == "1"){
				document.getElementById("ratio").style.display = "none";
				document.getElementById("isShowRowNum").style.display = "";
			}else{
				document.getElementById("ratio").style.display = "";
				document.getElementById("isShowRowNum").style.display = "none";
			}
			//if(piddisplay == "1"){ // 二维表模式
				//document.getElementById("tablewidth").style.display = "";
				//document.getElementById("rowwidth").value = "0";
			//}
			var piduse = document.getElementById("piduse").value;
			if(piduse == ""){
				document.getElementById("piduse").value ="1";
			}
			if(piduse == "2"){ // 固定行
				document.getElementById("tablerows").style.display = "";
			}
		}else{
			document.getElementById("option").style.display = "none";
			document.getElementById("default").style.display = "none";
			document.getElementById("defaultValue").style.display = "none";
			document.getElementById("pidoption").value = "";
			document.getElementById("piddefault").value = "";
			document.getElementById("tree").style.display = "none";
			document.getElementById("ccid").value = "";
			document.getElementById("isShowLine").style.display = "none";
			document.getElementById("treeSelecedLast").style.display = "none";
			document.getElementById("titleShowModel").style.display = "none";
			document.getElementById("tablehide").style.display = "";
			if($F("pidtype") == "F"){
				document.getElementById("attmobel").style.display = "";
				document.getElementById("entityRows").style.display = "none";
				document.getElementById("entitySyscoding").style.display = "none";
				document.getElementById("fileDefaultValue").style.display = "";
				fileDefaultValueContent($F("attMobelSelecter"));
			}else if($F("pidtype") == "4"){
				document.getElementById("entityRows").style.display = "";
				document.getElementById("entitySyscoding").style.display = "";
				document.getElementById("attmobel").style.display = "none";
				var ccid = "${IGPRD0111Form.ccid}";
				if(ccid != ""){
					document.getElementById("entity_name").value = ccid.split("_entity_")[1];
					document.getElementById("ccid").value = ccid;
				}
				document.getElementById("entityRowsSelecter").value = "${IGPRD0111Form.pidrows}";
				document.getElementById("asmDefaultValue").style.display = "";
				asmDefaultValue(${IGPRD0111Form.pidrows});
			}else{
				document.getElementById("entityRows").style.display = "none";
				document.getElementById("entitySyscoding").style.display = "none";
				document.getElementById("attmobel").style.display = "none";
			}
			if($F("pidtype") == "0" || $F("pidtype") == "9"){
				document.getElementById("piddefaults").style.display = "";
				document.getElementById("textdefault").value = "${IGPRD0111Form.piddefault}";
				document.getElementById("pidsizediv").style.display = "";
			}else if($F("pidtype") == "7"){
				document.getElementById("pidsizediv").style.display = "";
			}else{
				document.getElementById("pidsizediv").style.display = "none";
			}
			if($F("pidtype") == "0"){
				document.getElementById("writeablediv").style.display = "";
			}else{
				document.getElementById("writeablediv").style.display = "none";
			}
			if($F("pidtype") == "7"){
				document.getElementById("rawDefault").style.display = "";
				document.getElementById("numberTypeDiv").style.display = "";
				document.getElementById("decimalsDiv").style.display = "";
				document.getElementById("rawDefaultValue").value = $F("piddefault");
			}else{
				document.getElementById("numberTypeDiv").style.display = "none";
				document.getElementById("decimalsDiv").style.display = "none";
			}
		}
	}
}

 function toback(){
	 IGPRD0111Form.action = getAppRootUrl() + "/IGPRD0178_Back.do";
	 IGPRD0111Form.submit();
 }

 function checkForm(){
 	if($F('pidlabel').trim() == ""){
 		alert("请输入列名称！");
 		return false;
 	}
 	if($F('pidtype').trim() == ""){
 	 	if('${IGPRD0111Form.mode}' == '0'){
	 		alert("请输入列类型！");
	 		return false;
 	 	 }
 	}
	if($F("jsfunction") != ""){
		if(checkStr($F("jsfunction"))){
			alert("请输入正确格式的js方法名称！");
			return false;
		}
		if($F("jsfunction").length > 128){
			alert("js方法名称不能超过128个字符");
			return false;
		}
	}
	if(document.getElementById("pidsizediv").style.display != "none"){
		if($F("pidsize") != ""){
			if(!checkIsNumber($F("pidsize"))){
				alert("限制长度为数字！");
				return false;
			}
		}
	}
 	if(document.getElementById("pidtype").value == "2" 
 	 	|| document.getElementById("pidtype").value == "C" 
 	 	 	|| document.getElementById("pidtype").value == "B" 
 	 	 	 	|| document.getElementById("pidtype").value == "E" 
 	 	 	 	 	|| document.getElementById("pidtype").value == "L"
 	 	 	 	 		|| document.getElementById("pidtype").value == "S"){
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
 	if(document.getElementById("pidtype").value == "8"){
 		if($F('piddisplay').trim() == ""){
	 		alert("请选择表格模式！");
	 		return false;
 		 }
 		if($F('piduse').trim() == ""){
	 		alert("请选择使用模式！");
	 		return false;
 		 }
 		if($F('piduse') == "2"){
	 		if($F('pidrows').trim() == ""){
		 		alert("请输入行数！");
		 		return false;
	 		 }else{
	 			if(!checkIsNumberForCSE($F('pidrows'))){
					alert("行数请输入正整数！");
					$F('pidrows').value = "";				
					return false;
				}
	 		 }
 		}
 		
 	}
 	if(document.getElementById("pidtype").value == "0" || document.getElementById("pidtype").value == "9"){
 		document.getElementById("piddefault").value = document.getElementById("textdefault").value;
 	 }
 	if($F('pidlabel').strlen()>128){
 		alert("列名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
 		return false;
 	}
 	if($F('piddesc').strlen()>2000){
 		alert("列说明不能大于"+Math.floor(2000/strByteFlag)+"个汉字！");
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
    if ('${IGPRD0111Form.mode}' == '0'){
            message = '<bean:message key="IGCO10000.W001" arg0="列基本信息" />';
     } else {
            message = '<bean:message key="IGCO10000.W003" arg0="列基本信息" />';
    }
	if( window.confirm(message)){
			return true;
	} else {
			return false;
	}
 }

function checkIsNumberForCSE(str){
	 	myReg = /^[0-9]{0,}$/;
	 	return myReg.test(str);
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


function showWidth(obj){
	if(obj.value == "1"){ // 二维表模式
		document.getElementById("tablewidth").style.display = "";
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
		document.getElementById("private").style.display="";
		document.getElementById("public").style.display="none";
		document.getElementById("rowwidth").value = "0";
	}else if(obj.value == "2"){ // 组模式
		document.getElementById("tablewidth").style.display = "none";
		document.getElementById("pidwidth").value = "";
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
		document.getElementById("private").style.display="";
		document.getElementById("public").style.display="none";
		document.getElementById("rowwidth").value = "0";
	}
}

function showRows(obj){
	if(obj.value == "1"){ // 可变行
		document.getElementById("tablerows").style.display = "none";
		document.getElementById("pidrows").value = "";
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
	}else if(obj.value == "2"){ // 固定行
		document.getElementById("tablerows").style.display = "";
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
	}
}
function changeTableMobel(value){
	if(value == "1"){
		document.getElementById("isShowRowNum").style.display = "";
		document.getElementById("ratio").style.display = "none";
	}else{
		document.getElementById("isShowRowNum").style.display = "none";
		document.getElementById("ratio").style.display = "";
	}
}

function changePidRows(obj){
	if(document.getElementById("pidtype").value == "F"){
		if(obj.value == "1"){
			var attids = document.getElementsByName("attids");
			var attdel = document.getElementsByName("attdel");
			var flag = false;
			if(attids != null && attdel != null){
				for(var i=0;i<attdel.length;i++){
					if(attdel[i].value == "N"){
						flag = true;
						break;
					};
				};
			}
			if(flag){
				if(window.confirm("执行该操作将删除原有附件，\n是否确认？")){
					for(var i=0;i<attdel.length;i++){
						attdel[i].value = "Y";
						document.getElementById(attids[i].value + "").style.display= "none";
						document.getElementById(attids[i].value + "IMG").style.display= "none";
					};
				}else{
					obj.selectedIndex = 1;
					return;
				};
			};
		}
		var tb = document.getElementById("fileDefaultValueContent");
		tb.outerHTML = "<table id='fileDefaultValueContent'></table>";
		fileDefaultValueContent(obj.value);
	}else if(document.getElementById("pidtype").value == "4"){
		var tb = document.getElementById("asmDefaultValueContent");
		tb.outerHTML = "<table id='asmDefaultValueContent'></table>";
		asmDefaultValue(obj.value);
	}
	document.getElementById("pidrows").value = obj.value;
}

function setEntity(url){

	 var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	 if("_resetall"==temp){
		 document.getElementById("entity_name").value = "";
			document.getElementById("ccid").value = "";
			return false;
	 }
		if(null!=temp && temp.split("|").length>1){
			var syscode_eid = temp.split("|")[0];
			var name = temp.split("|")[1];
			var syscode;
			var eid;
			if(syscode_eid =="999")
			{
				alert("资产模型不可用！请选择其他模型！");
				return false;
				
			}else if(syscode_eid.split("_").length>1){
				eid = syscode_eid.split("_")[0];
				syscode = syscode_eid.split("_")[1];
			}
			document.getElementById("entity_name").value = name;
			document.getElementById("ccid").value = syscode + "_entity_" + name; 
		}			
		
	}

function checkStr(str){
	var patrn=/^([a-zA-Z0-9]|[_]|[?]|[=]){0,128}$/;
	if (!patrn.test(str)){
		return true;
	}else{
		return false;  
	} 
}
var filenum = 0;
function addSingleFileDefault(){
	var tb = document.getElementById("fileDefaultValueContent");
	var td = tb.insertRow().insertCell();
	td.innerHTML = "<input type='file' style='width:450px;' name='attachFileMuti[" + 
                   attachFileNumMuti +
                   "]' class='fileMuti' contentEditable='false'>";
	filenum ++;
}
function addFileDefault(){
	var tb = document.getElementById("fileDefaultValueContent");
	var td = tb.insertRow().insertCell();
	td.innerHTML = "<input type='file' style='width:450px;' name='attachFileMuti[" + 
                   attachFileNumMuti +
                   "]' class='fileMuti' contentEditable='false'>" +
                   "<input type='button' class='delbutton' value='\u5220\u9664' onclick='deleteFileDefault(this);'>";
	filenum ++;
}
function deleteFileDefault(obj){
	obj.parentElement.parentElement.parentElement.deleteRow(obj.parentElement.parentElement.rowIndex);
}
function fileDefaultValueContent(model){
	if(model == 1){
		var obj = document.getElementById("addFileDefaultValue");
		obj.innerHTML = "";
		var attids = document.getElementsByName("attids");
		var attdef = document.getElementsByName("attdel");
		var flag = true;
		if(attids != null && attdef != null){
			for(var i=0;i<attids.length;i++){
				if(attdef[i].value == "N"){
					flag = false;
					break;
				}
			}
		}
		if(flag){
			addSingleFileDefault();
		}
	}else{
		var obj = document.getElementById("addFileDefaultValue");
		obj.innerHTML = "<img src=\"images/attachment.gif\" /><a href='javascript:addFileDefault();'>添加附件</a>";
	}
}
function delFile(attid){
	if(window.confirm("是否确认删除附件?")){
		document.getElementById(attid).style.display = "none";
		document.getElementById(attid + "IMG").style.display = "none";
		var attids = document.getElementsByName("attids");
		var attdel = document.getElementsByName("attdel");
		if(attids != null && attdel != null){
			for(var i=0;i<attids.length;i++){
				if(attids[i].value == attid){
					attdel[i].value = "Y";
					break;
				}
			}
		}
		if(document.getElementById("attMobelSelecter").value == "1"){
			addSingleFileDefault();
		}
	}
}
function asmDefaultValue(model){
	if(model == 1){
		var obj = document.getElementById("addAsmDefaultValue");
		obj.innerHTML = "";
		var flag = true;
		var objs = document.getElementsByName("asminfo");
		if(objs != null && objs.length > 0){
			flag = false;
		}
		if(flag){
			addSingleAsmDefault();
		}
	}else{
		var obj = document.getElementById("addAsmDefaultValue");
		obj.innerHTML = "<img src='images/addasm.gif' alt='查询' style='cursor:hand;'/><a href='javascript:addAsmDefault();'>添加资产</a>";
	}
}
function addSingleAsmDefault(){
	var tb = document.getElementById("asmDefaultValueContent");
	var td = tb.insertRow().insertCell();
	td.innerHTML = "<input type='text' name='asmname' readonly='true'/>" +
				   "<input type='hidden' name='asminfo'/>" + 
				   "&nbsp;&nbsp;<img src='images/seek.gif' width='16' height='16' style='cursor: hand;' onclick='selectEntity(this);'/>";
}
function addAsmDefault(){
	var tb = document.getElementById("asmDefaultValueContent");
	var td = tb.insertRow().insertCell();
	td.innerHTML = "<input type='text' name='asmname' readonly='true'/>" +
				   "<input type='hidden' name='asminfo'/>" +
				   "&nbsp;&nbsp;<img src='images/seek.gif' width='16' height='16' style='cursor: hand;' onclick='selectEntity(this);'/>" +
				   "&nbsp;&nbsp;<img src='images/delate.gif' style='cursor: hand;' alt='删除' onclick='deleteFileDefault(this);'/>";
}
var entityObj = null;
var entityNameObj = null;
function selectEntity(obj){
	openSubIGCOM0302PARAM('?pidid=${IGPRD0111Form.pidid}&esyscoding=');
	var objs = obj.parentElement.childNodes;
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			if(objs[i].name == "asmname"){
				entityNameObj = objs[i];
			}
			if(objs[i].name == "asminfo"){
				entityObj = objs[i];
			}
		}
	}
}
function setParamIGCOM0302(eid, elabel, ename, eiid, eilabel, einame ,ecategory){
	entityObj.value = eiid;
	entityNameObj.value = einame;
	entityObj = null;
	entityNameObj = null;
}

function rawDefault(obj){
	if($F("pidtype") == "7"){
		rawDefaultNumber(obj);
	}
	if($F("pidtype") == "T"){
		rawDefaultTree(obj);
	}
}
function rawDefaultNumber(obj){
	var index = document.getElementById("numbertype").value == "" ? 0 : document.getElementById("numbertype").value;
	var decimals = document.getElementById("decimals").value == "" ? 2 : document.getElementById("decimals").value;
	showKeyboard(obj,index,decimals);
	obj.onchange = function(){
		document.getElementById("piddefault").value = this.value;
	};
}
function rawDefaultTree(obj){
	obj.onchange = "";
	var ccid = document.getElementById("ccid").value;
	if(ccid == ""){
		alert("请选择树定义");
	}else{
		var url = "IGSYM1505_TREE.do" + "?ccid="+ccid.split("_tree_")[0];
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			obj.value = "";
			document.getElementById("piddefault").value = "";
		}else{
			var id = temp.split("|")[0];
			var name = temp.split("|")[1];
			var treesyscode;
			if(id.split("_").length>1){
				treesyscode = id.split("_")[2];
			}else{
				treesyscode = "";
			}
			obj.value = name;
			document.getElementById("piddefault").value = treesyscode + "_tree_" + name;
		};
	};
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
<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 流程管理 &gt;&gt; 表格式表单管理&gt;&gt; 
<logic:equal name="IGPRD0111Form" property="mode" value="0">列登记</logic:equal>
<logic:equal name="IGPRD0111Form" property="mode" value="1">列变更</logic:equal>

	               </p>

<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>

<div id="formwrapper"><html:form styleId="form" enctype="multipart/form-data"
	action="/IGPRD0179" onsubmit="return checkSubmit(this);">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset><logic:equal name="IGPRD0111Form" property="mode" value="0">
		<legend>基本信息添加</legend>
	</logic:equal> <logic:equal name="IGPRD0111Form" property="mode" value="1">
		<legend>基本信息变更</legend>
	</logic:equal>


	<div><label for="Name"><strong><span class="red">*</span>列名称</strong>：</label>
	<html:text name="IGPRD0111Form" property="pidlabel" styleId="pidlabel"
		size="18" style="width:200px;" errorStyleClass="inputError"
		tabindex="1" /> <br>
	</div>
		
	<div style="display: none"><label for="Name"><strong><span class="red">*</span>列模式</strong>：</label>
		<html:select name="IGPRD0111Form" property="pidmode" style="width: 85px;" errorStyleClass="inputError" onchange="showModeDIV(this)">
	        <ig:optionsCollection ccid="PROCESSINFODEF_MODE_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
	    </html:select>
	<br />
	</div>
	<div><label for="pidtype"><span class="red">*</span><strong>列类型</strong>：</label>
		<logic:equal name="IGPRD0111Form" property="mode" value="0">
			<html:select name="IGPRD0111Form" property="pidtype" style="width: 85px;" errorStyleClass="inputError" onchange="showDIV(this)">
	        <ig:optionsCollection ccid="TABLEFORM_PROCESSINFODEF_TYPE_CODE_WD" isMakeBlankRow="true" isCodeLabel="true"/>
	    	</html:select>
	    </logic:equal>
	    <logic:equal name="IGPRD0111Form" property="mode" value="1">
	    	<html:select name="IGPRD0111Form" property="pidtype" style="width: 85px;" disabled="true">
	       		<ig:optionsCollection ccid="TABLEFORM_PROCESSINFODEF_TYPE_CODE_WD" isMakeBlankRow="true" isCodeLabel="true"/>
	    	</html:select>
	    </logic:equal>
	<br />
	</div>
	<div>
		<label><span class="">*</span><strong>对齐方式</strong>：</label>
		<html:select name="IGPRD0111Form" property="align" styleId="align" style="width:85px;">
			<html:option value="L">左对齐</html:option>
			<html:option value="C">居中对齐</html:option>
			<html:option value="R">右对齐</html:option>
		</html:select>
	</div>
	<div id="numberTypeDiv" style="display:none;">
		<label for="Name"><span class="red">*</span><strong>数字类型</strong>：</label>
		<html:select property="numbertype" name="IGPRD0111Form" styleId="numbertype" style="width:85px;">
			<html:option value="0">普通</html:option>
			<html:option value="1">整数</html:option>
			<html:option value="2">非负整数</html:option>
		</html:select>
	<br/>
	</div>
	<div id="decimalsDiv" style="display:none;">
		<label for="Name"><strong>小数位数</strong>：</label>
		<html:text name="IGPRD0111Form" property="decimals" styleId="decimals"
		size="18" style="width:80px;" errorStyleClass="inputError"/> 
		<br/>
	</div>
     <div id="tree" style="display:none">
       <label for="ccid"><span class="red">*</span><strong>定义树</strong>：</label>
       	 	<input type="text" name="ccid_name"  readonly="readonly"  value=""/>
			<img src="images/seek.gif" alt='查询' onclick="selectTree()" style="cursor: hand"/>
			<html:hidden property="ccid" styleId="ccid" name="IGPRD0111Form" />
       <br />
     </div>
     <div id="treeSelecedLast" style="display:none;">
     	<label><span class="red">*</span><strong>只选末级</strong>：</label>
     	<html:select property="selecedlast" name="IGPRD0111Form" styleId="selecedlast" style="width:85px;">
     		<html:option value="N">否</html:option>
     		<html:option value="Y">是</html:option>
     	</html:select>
     </div>
	<html:hidden property="pidoption" value="${IGPRD0111Form.pidoption}"/>
	<html:hidden property="piddefault" value="${IGPRD0111Form.piddefault}"/>
     <div id="tabledisplay" style="display:none">       
        <label for="rowwidth"><span class="red">*</span><strong>表格模式</strong>：</label>
        <html:select name="IGPRD0111Form" property="piddisplay" style="width: 85px;" errorStyleClass="inputError" onchange="changeTableMobel(this.value);">
	       <ig:optionsCollection ccid="TABLEFORM_DISPLAY" isMakeBlankRow="true" isCodeLabel="true"/>
	    </html:select>
	     <br />
	     <html:hidden property="piddisplaya" styleId="piddisplaya" name="IGPRD0111Form" />
	  </div>
      <div id="tableuse" style="display:none">  
	    <label for="rowwidth"><span class="red">*</span><strong>使用模式</strong>：</label>
        <html:select name="IGPRD0111Form" property="piduse" style="width: 85px;" errorStyleClass="inputError" onchange="showRows(this)">
	       <ig:optionsCollection ccid="TABLEFORM_USE" isMakeBlankRow="true" isCodeLabel="true"/>
	    </html:select>
	    <br />
     </div>
     <div id="tablewidth" style="">       
        <label for="rowwidth"><span class="red">*</span><strong>宽度</strong>：</label>
       <html:text name="IGPRD0111Form" property="pidwidth" styleId="pidwidth" size="18" style="width:80px;" errorStyleClass="inputError"
		tabindex="1" /> <br>
     </div>
     <div id="tablerows" style="display:none">       
        <label for="rowwidth"><span class="red">*</span><strong>行数</strong>：</label>
       <html:text name="IGPRD0111Form" property="pidrows" styleId="pidrows" size="18" style="width:80px;" errorStyleClass="inputError"
		tabindex="1" /> <br>
     </div>
     <div id="isShowRowNum" style="display:none;">
     	<label><span class="red">*</span><strong>行号显示</strong>：</label>
     	<html:select name="IGPRD0111Form" property="showrownum" styleId="showrownum" style="width:85px;">
     		<html:option value="Y">是</html:option>
     		<html:option value="N">否</html:option>
     	</html:select>
     </div>
     <div id="titleShowModel" style="display:none;">
     	<label><span class="red">*</span><strong>标题显示</strong>：</label>
     	<html:select property="titledisplay" name="IGPRD0111Form" style="width:85px;">
     		<html:option value="L">左侧显示</html:option>
     		<html:option value="T">上侧显示</html:option>
     		<html:option value="Y">隐藏标题</html:option>
     	</html:select>
     </div>
     <div id="ratio" style="display:none;">
     	<label><strong>显示比例</strong>：</label>
		<html:select property="pidratio" name="IGPRD0111Form" size="width:85px;">
			<html:option value="3_5">3:5</html:option>
			<html:option value="1_1">1:1</html:option>
			<html:option value="3_1">3:1</html:option>
		</html:select>     
     </div>
     <div id="tablehide" style="display:none;">  
	    <label for="rowwidth"><span class="red">*</span><strong>是否隐藏列名</strong>：</label>
        <html:select name="IGPRD0111Form" property="pidhide" style="width: 39px;" errorStyleClass="inputError" >
        	<html:option value="N">否</html:option>
        	<html:option value="Y">是</html:option>
	    </html:select>
	    <br />
     </div>
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
	<div id="fileDefaultValue" style="display:none">
		<label><strong>默认值</strong>：</label>
		<logic:present name="IGPRD0111Form" property="attList">
			<logic:iterate id="bean" name="IGPRD0111Form" property="attList">
				<input type="hidden" name="attids" value="${bean.attid }"/>
				<input type="hidden" name="attdel" value="N"/>
				<html:link styleId="${bean.attid }" action="downloadSvcFile.do?attId=${bean.attid}&type=svc">
					<bean:define id="attname" name="bean" property="attname" />
					<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
				</html:link>
				<img id="${bean.attid }IMG" src="images/delate.gif" align="middle" style="cursor: hand;" alt="删除" onclick="delFile('${bean.attid}');"/>
			</logic:iterate>
		</logic:present>
		<table id="fileDefaultValueContent"></table>
		<span id="addFileDefaultValue"></span>
	</div>
	<div id="asmDefaultValue" style="display:none;">
		<label><strong>默认值</strong>：</label>
		<table id="asmDefaultValueContent">
			<logic:present name="IGPRD0111Form" property="entityInfoMap">
				<logic:iterate id="map" name="IGPRD0111Form" property="entityInfoMap">
					<tr>
						<td>
							<input type="text" name="asmname" value="${map.value }"/>
							<input type="hidden" name="asminfo" value="${map.key }"/>
							<img src="images/seek.gif" style="cursor:hand;" width="16" height="16" alt="查询" onclick="selectEntity(this);"/>
							<logic:equal value="2" name="IGPRD0111Form" property="pidrows">
								<img src="images/delate.gif" style="cursor:hand;" alt="删除" onclick="deleteFileDefault(this);"/>
							</logic:equal>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
		<span id="addAsmDefaultValue"></span>
	</div>
	<div id="rawDefault" style="display:none;">
		<label><strong>默认值</strong>：</label>
		<input type="text" id="rawDefaultValue" readonly="true" onclick="rawDefault(this);" style="width:200px;"/>
	</div>
	<div id="showstyle" style="display:none">
       <label for="showstyle"><span class="red">*</span><strong>显示方式</strong>：</label>
        <select name="showstyles" id="showstyles">
            <logic:equal name="IGPRD0111Form" property="showstyles" value="1">
	        	<option value="0">横行</option>
	        	<option value="1" selected="selected">竖行</option>       		
       		</logic:equal>
 		    <logic:notEqual name="IGPRD0111Form" property="showstyles" value="1">
	        	<option value="0">横行</option>
	        	<option value="1">竖行</option>       		
       		</logic:notEqual>
        </select>
       <br />
    </div>
	<div style="">
       <label for="pidrequired"><span class="red">*</span><strong>是否必填</strong>：</label>
        <logic:equal name="IGPRD0111Form" property="pidrequired" value="1">
        <select name="pidrequired">
        	<option value="0">否</option>
        	<option value="1" selected="selected">是</option>
        </select>
        </logic:equal>
        <logic:notEqual name="IGPRD0111Form" property="pidrequired" value="1">
        <select name="pidrequired">
        	<option value="0" selected="selected">否</option>
        	<option value="1">是</option>
        </select>
        </logic:notEqual>
       <br />
    </div>
    
    <div style="display:none">
       <label for="pidsortid"><span class="red">*</span><strong>排序位置</strong>：</label>
        <select name="pidsortid">
        	<option value="99">99</option>
        </select>
       <br />
    </div>
    <div id="entitySyscoding" style="display:none;">
		<label for="Name"><span class="red">*</span><strong>资产模型</strong>：</label>
		<input type="text" name="entity_name" id="entity_name" readonly="true"  style="width:80px;"/> 
		<img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity('IGSYM1201_ENTITY_TREE.do?levelnode=999&type=0');"/>
	</div>
	<div id="entityRows" style="display:none;">
		<label for="Name"><span class="red">*</span><strong>资产模式</strong>：</label>
		<select name="entityRowsSelecter" style="width:85px;" id="entityRowsSelecter" onchange="changePidRows(this);">
			<option value="1">单资产</option>
			<option value="2">多资产</option>
		</select>
	</div>
	<div id="processRows" style="display:none;">
		<label for="Name"><span class="red">*</span><strong>流程模式</strong>：</label>	
		<select name="processRowsSelecter" style="width:85px;" id="processRowsSelecter" onchange="changePidRows(this);">
			<option value="1">单流程</option>
			<option value="2">多流程</option>
		</select>
	</div>
	<div id="isShowLine" style="display:none;">
		<label for="Name"><span class="red">*</span><strong>显示边线</strong>：</label>
		<html:select property="showline" name="IGPRD0111Form" styleId="showline" style="width:85px;">
			<html:option value="1">完全显示</html:option>
			<html:option value="2">隐藏内边线</html:option>
			<html:option value="3">隐藏边线</html:option>
		</html:select>
	</div>
	<div id="writeablediv" style="display:none;">
		<label for="Name"><span class="red">*</span><strong>可写标识</strong>：</label>
		<html:select property="writeable" name="IGPRD0111Form" style="width:85px;">
			<html:option value="Y">可写</html:option>
			<html:option value="N">只读</html:option>
		</html:select>
	</div>
	<div id="isNeedIdea" style="display:none;">
		<label for="Name"><span class="red">*</span><strong>包含审批意见</strong>：</label>
		<html:select property="needidea" name="IGPRD0111Form" styleId="needidea" style="width: 85px;">
			<html:option value="N">否</html:option>
			<html:option value="Y">是</html:option>
		</html:select>
	</div>
	<div id="pidsizediv" style="display:none;">
		<label><strong>限制长度</strong>：</label>
		<html:text property="pidsize"  name="IGPRD0111Form" styleId="pidsize" style="width:85px;"/>
	</div>
	<div id="attmobel" style="display:none">
		<label for="Name"><span class="red">*</span><strong>附件模式</strong>：</label>
		<select name="attMobelSelecter" onchange="changePidRows(this);" id="attMobelSelecter" style="width: 85px;">
			<option value="1">单附件</option>
			<option value="2">多附件</option>
		</select>
	</div>
	<div id="public" style="">
       <label for="rowwidth"><span class="red">*</span><strong>显示模式</strong>：</label>
        <html:select name="IGPRD0111Form" property="rowwidth" style="width: 85px;" errorStyleClass="inputError">
	       <ig:optionsCollection ccid="PROCESSINFODEF_ROWWIDTH_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
	    </html:select>
	    <br />
    </div>
    <div id="private" style="display:none">
    	<label for="rowwidth"><span class="red">*</span><strong>显示模式</strong>：</label>
	    <select name="rowwidthDispaly" style="width: 85px;" disabled="disabled">
	        <option value="<%=IGPRDCONSTANTS.PIDROWWIDTH_FULL %>"><ig:codeValue ccid="PROCESSINFODEF_ROWWIDTH_CODE" cid="<%=IGPRDCONSTANTS.PIDROWWIDTH_FULL %>" /></option>
	    </select>
	    <html:hidden name="IGPRD0111Form" property="rowwidth" value="<%=IGPRDCONSTANTS.PIDROWWIDTH_FULL %>"/>
	    <br />
	</div>
	<div id="piddefaults" style="display:none"><label for="Name"><strong>默认值</strong>：</label>
	<input type="text" name="IGPRD0111Form" name="textdefault" id="textdefault"
		size="18" style="width:200px;" 
		tabindex="1" /> <br>
	</div>
	<div><label for="Name"><strong>表单单位</strong>：</label>
	<html:text name="IGPRD0111Form" property="pidunit" styleId="pidunit"
		size="18" style="width:200px;" errorStyleClass="inputError"
		tabindex="1" /> <br>
	</div>
	<div>
		<label for="Name"><strong>JS方法</strong>：</label>
		<html:text property="jsfunction" name="IGPRD0111Form" styleId="jsfunction" size="18" style="width:200px;" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<span class="red">只能包含字母、数字、"_"、"?"、"="</span>
	</div>
	<div><label for="Name"><strong>列说明</strong>：</label> <html:textarea
		name="IGPRD0111Form" property="piddesc" styleId="piddesc" rows="7" cols="60"
		errorStyleClass="inputError" /> <br>
	</div>
	</fieldset>
	<div class="enter"><html:submit property="btn_insert" value="提交"
		styleClass="button" onclick="return checkForm();" /></div>
	<html:hidden property="pdid" styleId="pdid" name="IGPRD0111Form" />
	<html:hidden property="pidid" styleId="pidid" name="IGPRD0111Form" />
	<html:hidden property="mode" styleId="mode" name="IGPRD0111Form" />
	<html:hidden property="ppidid" styleId="ppidid" name="IGPRD0111Form" />
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>

</body>
</html:html>
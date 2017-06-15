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
<bean:define id="id" value="IGPRD0111h" toScope="request" />
<logic:equal name="IGPRD0111Form" property="mode" value="0">
	<bean:define id="title" value="表单基本信息登记画面" toScope="request" />
</logic:equal>
<logic:equal name="IGPRD0111Form" property="mode" value="1">
	<bean:define id="title" value="表单基本信息变更画面" toScope="request" />
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function showDIV(obj){
	document.getElementById("piddefaults").style.display = "none";
	document.getElementById("textdefault").value="";
		
	if(obj.value == "2" || obj.value == "B" || obj.value == "E" || obj.value == "C" || obj.value == 'S'){
		document.getElementById("option").style.display = "";
		document.getElementById("participantRoleTypeDiv").style.display = "none";
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
		document.getElementById("div_pidmode").style.display="";
		document.getElementById("entityRows").style.display = "none";
		document.getElementById("entitySyscoding").style.display = "none";
		document.getElementById("isShowLine").style.display = "none";
		document.getElementById("titleShowModel").style.display = "none";
		document.getElementById("treeSelecedLast").style.display = "none";
		document.getElementById("numberTypeDiv").style.display = "none";
		document.getElementById("decimalsDiv").style.display = "none";
		
		// 清理表格类表单数据
		document.getElementById("attachment").style.display = "";
		document.getElementById("tabledisplay").style.display = "none";
		document.getElementById("tableuse").style.display = "none";
		document.getElementById("tablewidth").style.display = "none";
		document.getElementById("piddisplay").value = "";
		document.getElementById("piduse").value = "";
		document.getElementById("pidwidth").value = "";
		document.getElementById("tablerows").style.display = "none";
		document.getElementById("pidrows").value = "";
		document.getElementById("processRows").style.display = "none";
		document.getElementById("attmobel").style.display = "none";
		document.getElementById("isShowRowNum").style.display = "none";
		if(document.getElementById("pidmode").value == "1"){
			document.getElementById("private").style.display="";
			document.getElementById("public").style.display="none";
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
				document.getElementById("private").style.display="none";
				document.getElementById("public").style.display="";
			}
		}
		if(obj.value == "B" || obj.value == "E" || obj.value == "C" || obj.value == "S"){
			document.getElementById("showstyle").style.display = "";
			document.getElementById("showstyles").value = "0";
		}
	} else if(obj.value == "T"){
		document.getElementById("showstyle").style.display = "none";
		document.getElementById("participantRoleTypeDiv").style.display = "none";
		document.getElementById("tree").style.display = "";
		document.getElementById("option").style.display = "none";
		document.getElementById("default").style.display = "none";
		document.getElementById("defaultValue").style.display = "none";
		document.getElementById("pidoption").value = "";
		document.getElementById("piddefault").value = "";
		document.getElementById("selectAddValue").value = "";
		document.getElementById("selectDefaultValue").options.length = 0;
		document.getElementById("selectValue").options.length = 0;
		document.getElementById("div_pidmode").style.display="";
		document.getElementById("entityRows").style.display = "none";
		document.getElementById("entitySyscoding").style.display = "none";
		document.getElementById("titleShowModel").style.display = "none";
		document.getElementById("processRows").style.display = "none";
		document.getElementById("treeSelecedLast").style.display = "";
		document.getElementById("numberTypeDiv").style.display = "none";
		document.getElementById("decimalsDiv").style.display = "none";
		// 清理表格类表单数据
		document.getElementById("attachment").style.display = "";
		document.getElementById("tabledisplay").style.display = "none";
		document.getElementById("tableuse").style.display = "none";
		document.getElementById("tablewidth").style.display = "none";
		document.getElementById("piddisplay").value = "";
		document.getElementById("piduse").value = "";
		document.getElementById("pidwidth").value = "";
		document.getElementById("tablerows").style.display = "none";
		document.getElementById("pidrows").value = "";
		document.getElementById("attmobel").style.display = "none";
		document.getElementById("isShowRowNum").style.display = "none";
		document.getElementById("isShowLine").style.display = "none";
		if(document.getElementById("pidmode").value == "0"){
			document.getElementById("private").style.display="none";
			document.getElementById("public").style.display="";
		}
	} else if(obj.value == "8"){
		document.getElementById("showstyle").style.display = "none";
		document.getElementById("participantRoleTypeDiv").style.display = "none";
		document.getElementById("tabledisplay").style.display = "";
		document.getElementById("tableuse").style.display = "";
		document.getElementById("attachment").style.display = "none";
		document.getElementById("option").style.display = "none";
		document.getElementById("default").style.display = "none";
		document.getElementById("defaultValue").style.display = "none";
		document.getElementById("pidoption").value = "";
		document.getElementById("piddefault").value = "";
		document.getElementById("selectAddValue").value = "";
		document.getElementById("selectDefaultValue").options.length = 0;
		document.getElementById("processRows").style.display = "none";
		document.getElementById("selectValue").options.length = 0;
		document.getElementById("tree").style.display = "none";
		document.getElementById("ccid").value = "";
		document.getElementById("private").style.display="";
		document.getElementById("public").style.display="none";
		document.getElementById("div_pidmode").style.display="none";
		document.getElementById("div_privatescope").style.display="none";
		document.getElementById("pidmode").value = "0";
		document.getElementById("privatescope").value = "";
		document.getElementById("treeSelecedLast").style.display = "none";
		document.getElementById("rowwidth").value = "0";
		var piddisplay = document.getElementById("piddisplay").value;
		document.getElementById("attmobel").style.display = "none";
		document.getElementById("entityRows").style.display = "none";
		document.getElementById("entitySyscoding").style.display = "none";
		document.getElementById("isShowLine").style.display = "";
		document.getElementById("titleShowModel").style.display = "";
		document.getElementById("numberTypeDiv").style.display = "none";
		document.getElementById("decimalsDiv").style.display = "none";
		if(piddisplay == ""){
			document.getElementById("piddisplay").value ="1";
			//document.getElementById("tablewidth").style.display = "";
			//document.getElementById("rowwidth").value = "0";
		}
		//二维表显示是否显示行号选项
		if(document.getElementById("piddisplay").value == "1"){
			document.getElementById("isShowRowNum").style.display = "";
		}else{
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
	}else if(obj.value == "F"){
		document.getElementById("showstyle").style.display = "none";
		document.getElementById("participantRoleTypeDiv").style.display = "none";
		document.getElementById("option").style.display = "none";
		document.getElementById("default").style.display = "none";
		document.getElementById("defaultValue").style.display = "none";
		document.getElementById("pidoption").value = "";
		document.getElementById("piddefault").value = "";
		document.getElementById("selectAddValue").value = "";
		document.getElementById("selectDefaultValue").options.length = 0;
		document.getElementById("selectValue").options.length = 0;
		document.getElementById("tree").style.display = "none";
		document.getElementById("processRows").style.display = "none";
		document.getElementById("ccid").value = "";
		document.getElementById("div_pidmode").style.display="";
		document.getElementById("isShowRowNum").style.display = "none";
		document.getElementById("entityRows").style.display = "none";
		document.getElementById("entitySyscoding").style.display = "none";
		document.getElementById("titleShowModel").style.display = "none";
		document.getElementById("treeSelecedLast").style.display = "none";
		document.getElementById("numberTypeDiv").style.display = "none";
		document.getElementById("decimalsDiv").style.display = "none";
		// 清理表格类表单数据
		document.getElementById("attachment").style.display = "";
		document.getElementById("tabledisplay").style.display = "none";
		document.getElementById("tableuse").style.display = "none";
		document.getElementById("tablewidth").style.display = "none";
		document.getElementById("piddisplay").value = "";
		document.getElementById("piduse").value = "";
		document.getElementById("pidwidth").value = "";
		document.getElementById("tablerows").style.display = "none";
		document.getElementById("pidrows").value = "";
		document.getElementById("tablerows").style.display = "none";
		document.getElementById("pidrows").value = "";
		document.getElementById("isShowLine").style.display = "none";
		if(document.getElementById("pidmode").value == "0"){
			document.getElementById("private").style.display="none";
			document.getElementById("public").style.display="";
		}
		document.getElementById("attmobel").style.display = "";
    	document.getElementById("pidrows").value = "1";
	}
	else {
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
		document.getElementById("treeSelecedLast").style.display = "none";
		document.getElementById("div_pidmode").style.display="";
		document.getElementById("isShowRowNum").style.display = "none";
		document.getElementById("titleShowModel").style.display = "none";
		// 清理表格类表单数据
		document.getElementById("attachment").style.display = "";
		document.getElementById("tabledisplay").style.display = "none";
		document.getElementById("tableuse").style.display = "none";
		document.getElementById("tablewidth").style.display = "none";
		document.getElementById("piddisplay").value = "";
		document.getElementById("piduse").value = "";
		document.getElementById("pidwidth").value = "";
		document.getElementById("tablerows").style.display = "none";
		document.getElementById("pidrows").value = "";
		document.getElementById("tablerows").style.display = "none";
		document.getElementById("pidrows").value = "";
		document.getElementById("attmobel").style.display = "none";
		if(document.getElementById("pidmode").value == "0"){
			document.getElementById("private").style.display="none";
			document.getElementById("public").style.display="";
		}
		if(obj.value == "4"){
			document.getElementById("entityRows").style.display = "";
			document.getElementById("entitySyscoding").style.display = "";
			document.getElementById("pidrows").value = "1";
		}else{
			document.getElementById("entityRows").style.display = "none";
			document.getElementById("entitySyscoding").style.display = "none";
		}
		if(obj.value == "0" || obj.value == "9"){
			document.getElementById("piddefaults").style.display = "";
		}
		
		if(obj.value == "5"){
			document.getElementById("processRows").style.display = "";
			document.getElementById("pidrows").value = "1";
		}else{
			document.getElementById("processRows").style.display = "none";
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
		if(obj.value == "P"){
			document.getElementById("participantRoleTypeDiv").style.display = "";
		}else{
			document.getElementById("participantRoleTypeDiv").style.display = "none";
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
	var pidtype = document.getElementById("pidtype").value;
	if(obj.value == "1"){
		document.getElementById("div_privatescope").style.display="";
		document.getElementById("private").style.display="";
		document.getElementById("public").style.display="none";
		document.getElementById("rowwidth").value = "0";
	}
	else
	{
		document.getElementById("div_privatescope").style.display="none";
		$("privatescope").value = "";
		document.getElementById("rowwidth").value = "1";
		if(pidtype == "8"){
			document.getElementById("private").style.display="";
			document.getElementById("public").style.display="none";
		}else{
			document.getElementById("private").style.display="none";
			document.getElementById("public").style.display="";
		}
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
		if($F("pidtype") == "2" || $F("pidtype") == "B" || $F("pidtype") == "E" || $F("pidtype") == "C" || $F("pidtype") == "S"){
			document.getElementById("option").style.display = "";
			document.getElementById("default").style.display = "";
			document.getElementById("defaultValue").style.display = "";
			document.getElementById("spanRow").style.display = "none";
			document.getElementById("tree").style.display = "none";
			document.getElementById("participantRoleTypeDiv").style.display = "none";
			document.getElementById("ccid").value = "";
			document.getElementById("div_pidmode").style.display="";
			document.getElementById("isShowRowNum").style.display = "none";
			document.getElementById("entityRows").style.display = "none";
			document.getElementById("entitySyscoding").style.display = "none";
			document.getElementById("isShowLine").style.display = "none";
			document.getElementById("titleShowModel").style.display = "none";
			document.getElementById("processRows").style.display = "none";
			document.getElementById("treeSelecedLast").style.display = "none";
			document.getElementById("numberTypeDiv").style.display = "none";
			document.getElementById("decimalsDiv").style.display = "none";
			
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
			if(obj.value == "B" || obj.value == "E" || obj.value == "C" || obj.value == "S"){
				document.getElementById("showstyle").style.display = "";
			}
		} else if($F("pidtype") == "T"){
			document.getElementById("tree").style.display = "";
			document.getElementById("option").style.display = "none";
			document.getElementById("default").style.display = "none";
			document.getElementById("defaultValue").style.display = "none";
			document.getElementById("pidoption").value = "";
			document.getElementById("participantRoleTypeDiv").style.display = "none";
			document.getElementById("piddefault").value = "";
			document.getElementById("div_pidmode").style.display="";
			document.getElementById("isShowRowNum").style.display = "none";
			document.getElementById("entityRows").style.display = "none";
			document.getElementById("processRows").style.display = "none";
			document.getElementById("entitySyscoding").style.display = "none";
			document.getElementById("isShowLine").style.display = "none";
			document.getElementById("titleShowModel").style.display = "none";
			document.getElementById("numberTypeDiv").style.display = "none";
			document.getElementById("decimalsDiv").style.display = "none";
			document.getElementById("treeSelecedLast").style.display = "";
			if($F("ccid") != null){
				document.getElementById("ccid_name").value = $F("ccid").split("_tree_")[1];
			}
		} else if($F("pidtype") == "8"){
			document.getElementById("tabledisplay").style.display = "";
			document.getElementById("tableuse").style.display = "";
			document.getElementById("attachment").style.display = "none";
			document.getElementById("option").style.display = "none";
			document.getElementById("default").style.display = "none";
			document.getElementById("defaultValue").style.display = "none";
			document.getElementById("processRows").style.display = "none";
			document.getElementById("pidoption").value = "";
			document.getElementById("piddefault").value = "";
			document.getElementById("selectAddValue").value = "";
			document.getElementById("selectDefaultValue").options.length = 0;
			document.getElementById("participantRoleTypeDiv").style.display = "none";
			document.getElementById("selectValue").options.length = 0;
			document.getElementById("tree").style.display = "none";
			document.getElementById("ccid").value = "";
			document.getElementById("private").style.display="";
			document.getElementById("public").style.display="none";
			document.getElementById("div_pidmode").style.display="none";
			document.getElementById("div_privatescope").style.display="none";
			document.getElementById("pidmode").value = "0";
			document.getElementById("privatescope").value = "";
			document.getElementById("rowwidth").value = "0";
			var piddisplay = document.getElementById("piddisplay").value;
			document.getElementById("entityRows").style.display = "none";
			document.getElementById("entitySyscoding").style.display = "none";
			document.getElementById("numberTypeDiv").style.display = "none";
			document.getElementById("decimalsDiv").style.display = "none";
			document.getElementById("isShowLine").style.display = "";
			document.getElementById("titleShowModel").style.display = "";
			document.getElementById("treeSelecedLast").style.display = "none";
			if(piddisplay == ""){
				document.getElementById("piddisplay").value ="1";
				//document.getElementById("tablewidth").style.display = "";
				//document.getElementById("rowwidth").value = "0";
			}
			//二维表显示是否显示行号选项
			if(document.getElementById("piddisplay").value == "1"){
				document.getElementById("isShowRowNum").style.display = "";
				document.getElementById("ratio").style.display = "none";
			}else{
				document.getElementById("isShowRowNum").style.display = "none";
				document.getElementById("ratio").style.display = "";
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
		}else if($F("pidtype") == "F"){
			document.getElementById("option").style.display = "none";
			document.getElementById("participantRoleTypeDiv").style.display = "none";
			document.getElementById("default").style.display = "none";
			document.getElementById("defaultValue").style.display = "none";
			document.getElementById("pidoption").value = "";
			document.getElementById("piddefault").value = "";
			document.getElementById("tree").style.display = "none";
			document.getElementById("ccid").value = "";
			document.getElementById("div_pidmode").style.display="";
			document.getElementById("attachment").style.display="none";
			document.getElementById("attmobel").style.display = "";
			document.getElementById("isShowRowNum").style.display = "none";
			document.getElementById("entityRows").style.display = "none";
			document.getElementById("entitySyscoding").style.display = "none";
			document.getElementById("isShowLine").style.display = "none";
			document.getElementById("titleShowModel").style.display = "none";
			document.getElementById("processRows").style.display = "none";
			document.getElementById("treeSelecedLast").style.display = "none";
			document.getElementById("numberTypeDiv").style.display = "none";
			document.getElementById("decimalsDiv").style.display = "none";
			var attmobelValue = '${IGPRD0111Form.pidrows}';
			if(attmobelValue == "2"){
				document.getElementById("attMobelSelecter").selectedIndex = 1;
			}else{
				document.getElementById("attMobelSelecter").selectedIndex = 0;
			}
			if(attmobelValue == ""){
				document.getElementById("pidrows").value = "1";
			}
		}
		else {
			document.getElementById("option").style.display = "none";
			document.getElementById("default").style.display = "none";
			document.getElementById("defaultValue").style.display = "none";
			document.getElementById("pidoption").value = "";
			document.getElementById("piddefault").value = "";
			document.getElementById("tree").style.display = "none";
			document.getElementById("ccid").value = "";
			document.getElementById("div_pidmode").style.display="";
			document.getElementById("isShowRowNum").style.display = "none";
			document.getElementById("isShowLine").style.display = "none";
			document.getElementById("titleShowModel").style.display = "none";
			document.getElementById("treeSelecedLast").style.display = "none";
			if($F("pidtype") == "4"){
				document.getElementById("entityRows").style.display = "";
				document.getElementById("entitySyscoding").style.display = "";
				var ccid = "${IGPRD0111Form.ccid}";
				if(ccid != ""){
					document.getElementById("entity_name").value = ccid.split("_entity_")[1];
					document.getElementById("ccid").value = ccid;
				}
				document.getElementById("entityRowsSelecter").value = "${IGPRD0111Form.pidrows}";
			}else{
				document.getElementById("entityRows").style.display = "none";
				document.getElementById("entitySyscoding").style.display = "none";
			}
			if($F("pidtype") == "0" || $F("pidtype") == "9"){
				document.getElementById("piddefaults").style.display = "";
				document.getElementById("textdefault").value = "${IGPRD0111Form.piddefault}";
			}
			if($F("pidtype") == "5"){
				document.getElementById("processRows").style.display = "";
				document.getElementById("processRowsSelecter").value =  "${IGPRD0111Form.pidrows}";
			}else{
				document.getElementById("processRows").style.display = "none";
			}
			if($F("pidtype") == "7"){
				document.getElementById("numberTypeDiv").style.display = "";
				document.getElementById("decimalsDiv").style.display = "";
			}else{
				document.getElementById("numberTypeDiv").style.display = "none";
				document.getElementById("decimalsDiv").style.display = "none";
			}
			if($F("pidtype") == "P"){
				document.getElementById("participantRoleTypeDiv").style.display = "";
			}else{
				document.getElementById("participantRoleTypeDiv").style.display = "none";
			}
		}
	}
}

 function toback(){
	 IGPRD0111Form.action = getAppRootUrl() + "/IGPRD0110_Back.do?viewhistory=1";
	 IGPRD0111Form.submit();
 }

 function checkForm(){
 	if($F('pidlabel').trim() == ""){
 		alert("请输入表单名称！");
 		return false;
 	}
 	if($F('pidtype').trim() == ""){
 	 	if('${IGPRD0111Form.mode}' == '0'){
	 		alert("请输入表单类型！");
	 		return false;
 	 	 }
 	}
 	if($F('pidmode').trim() == "1" && $F('privatescope').trim() == ""){
 		alert("请选择权限范围！");
 		return false;
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
 	if(document.getElementById("pidtype").value == "2" 
 	 	|| document.getElementById("pidtype").value == "C" 
 	 	 	|| document.getElementById("pidtype").value == "B" 
 	 	 	 	|| document.getElementById("pidtype").value == "E"
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
    if ('${IGPRD0111Form.mode}' == '0'){
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
function changePidRows(obj){
	document.getElementById("pidrows").value = obj.value;
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
</script>
<body onload="setDefaultDIV()">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt;流程管理 &gt;&gt; 历史版本 &gt;&gt; 
	<logic:equal name="IGPRD0111Form" property="mode" value="0">
	          表单登记
	</logic:equal>
	<logic:equal name="IGPRD0111Form" property="mode" value="1">
	          表单变更
	</logic:equal>
	</p>

<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>

<div id="formwrapper"><html:form styleId="form"
	action="/IGPRD0111" onsubmit="return checkSubmit(this);">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset><logic:equal name="IGPRD0111Form" property="mode"
		value="0">
		<legend>基本信息添加</legend>
	</logic:equal> <logic:equal name="IGPRD0111Form" property="mode" value="1">
		<legend>基本信息变更</legend>
	</logic:equal>


	<div><label for="Name"><strong><span class="red">*</span>表单名称</strong>：</label>
	<html:text name="IGPRD0111Form" property="pidlabel" styleId="pidlabel"
		size="18" style="width:200px;" errorStyleClass="inputError"
		tabindex="1" /> <br>
	</div>
	<div><label for="pidtype"><span class="red">*</span><strong>表单类型</strong>：</label>
		<logic:equal name="IGPRD0111Form" property="mode" value="0">
			<html:select name="IGPRD0111Form" property="pidtype" style="width: 85px;" errorStyleClass="inputError" onchange="showDIV(this)">
	        <ig:optionsCollection ccid="PROCESSINFODEF_TYPE_CODE_WD" isMakeBlankRow="true" isCodeLabel="true"/>
	    	</html:select>
	    </logic:equal>
	    <logic:equal name="IGPRD0111Form" property="mode" value="1">
	    	<html:select name="IGPRD0111Form" property="pidtype" style="width: 85px;" disabled="true">
	       		<ig:optionsCollection ccid="PROCESSINFODEF_TYPE_CODE_WD" isMakeBlankRow="true" isCodeLabel="true"/>
	    	</html:select>
	    </logic:equal>
	<br />
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
	<div id="div_pidmode" style=""><label for="Name"><strong><span class="red">*</span>表单模式</strong>：</label>
		<html:select name="IGPRD0111Form" property="pidmode" style="width: 85px;" errorStyleClass="inputError" onchange="showModeDIV(this)">
	        <ig:optionsCollection ccid="PROCESSINFODEF_MODE_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
	    </html:select>
	<br />
	</div>
	<div style="display: none" id="div_privatescope"><label for="Name"><strong><span class="red">*</span>权限范围</strong>：</label>
		<html:select name="IGPRD0111Form" property="privatescope" style="width: 85px;" errorStyleClass="inputError">
	        <ig:optionsCollection ccid="PROCESSINFODEF_PRIVATEACCESS_SCOPE" isMakeBlankRow="true" isCodeLabel="true"/>
	    </html:select>
	<br />
	</div>
     <div id="tree" style="display:none">
       <label for="ccid"><span class="red">*</span><strong>定义树</strong>：</label>
       	 	<input type="text" name="ccid_name"  readonly="readonly"  value=""/>
			<img src="images/seek.gif" alt='查询' onclick="selectTree()" style="cursor: hand"/>
			<html:hidden property="ccid" styleId="ccid" name="IGPRD0111Form" />
       <br />
     </div>
     <div id="participantRoleTypeDiv" style="display:none;">
     	<label for="Name"><strong>角色类型</strong>：</label>
     	<html:select property="participantRoleType" name="IGPRD0111Form" styleId="participantRoleType">
     		 <ig:optionsCollection ccid="ROLE_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
     	</html:select>
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
	 <div id="option" style="display:none">
       <label for="pidoption"><strong>取值范围</strong>：</label>
        <input type="text" id="selectAddValue" style="width:200px;" tabindex="1" value=""/>
     	<html:link href="javascript:addSelectInfo()">
			<img src="images/addinfo.gif" width="20" height="18" border="0" alt="增加" />
		</html:link>
       <br />
     </div>
     <div id="tabledisplay" style="display:none">       
        <label for="rowwidth"><span class="red">*</span><strong>表格模式</strong>：</label>
        <html:select name="IGPRD0111Form" property="piddisplay" style="width: 85px;" errorStyleClass="inputError" onchange="changeTableMobel(this.value);">
	       <ig:optionsCollection ccid="TABLEFORM_DISPLAY" isMakeBlankRow="false" isCodeLabel="true"/>
	    </html:select>
	     <br />
	  </div>
      <div id="tableuse" style="display:none">  
	    <label for="rowwidth"><span class="red">*</span><strong>使用模式</strong>：</label>
        <html:select name="IGPRD0111Form" property="piduse" style="width: 85px;" errorStyleClass="inputError" onchange="showRows(this)">
	       <ig:optionsCollection ccid="TABLEFORM_USE" isMakeBlankRow="false" isCodeLabel="true"/>
	    </html:select>
	    <br />
     </div>
     <div id="tablewidth" style="display:none">       
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
     	<html:select property="titledisplay" name="IGPRD0111Form" style="width:85px;" >
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
     <html:hidden property="pidhide" styleId="pidhide" name="IGPRD0111Form" />
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
	<div id="attachment">
		<label for="Name"><span class="red">*</span><strong>包含附件</strong>：</label>
		<html:select name="IGPRD0111Form" property="hasattach" styleId="hasattach" style="width: 85px;">
			<ig:optionsCollection ccid="HASATTACH" isMakeBlankRow="false" isCodeLabel="true"/>
		</html:select>
	</div>
	<div id="isNeedIdea" style="display:none;">
		<label for="Name"><span class="red">*</span><strong>包含审批意见</strong>：</label>
		<html:select property="needidea" name="IGPRD0111Form" styleId="needidea" style="width: 85px;">
			<html:option value="N">否</html:option>
			<html:option value="Y">是</html:option>
		</html:select>
	</div>
	<div id="attmobel" style="display:none">
		<label for="Name"><span class="red">*</span><strong>附件模式</strong>：</label>
		<select name="attMobelSelecter" onchange="changePidRows(this);" id="attMobelSelecter" style="width: 85px;">
			<option value="1">单附件</option>
			<option value="2">多附件</option>
		</select>
	</div>
	<div>
	<label for="Name"><span class="red">*</span><strong>包含备注</strong>：</label>
       <select name="remarks" >
       		<logic:equal name="IGPRD0111Form" property="remarks" value="1">
	        	<option value="0">否</option>
	        	<option value="1" selected="selected">是</option>       		
       		</logic:equal>
 		    <logic:notEqual name="IGPRD0111Form" property="remarks" value="1">
	        	<option value="0">否</option>
	        	<option value="1">是</option>       		
       		</logic:notEqual>

        </select>
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
	<div><label for="Name"><strong>表单说明</strong>：</label> <html:textarea
		name="IGPRD0111Form" property="piddesc" styleId="piddesc" rows="7" cols="60"
		errorStyleClass="inputError" /> <br>
	</div>
	</fieldset>
	<html:hidden property="pdid" styleId="pdid" name="IGPRD0111Form" />
	<html:hidden property="pidid" styleId="pidid" name="IGPRD0111Form" />
	<html:hidden property="mode" styleId="mode" name="IGPRD0111Form" />
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>

</body>
</html:html>
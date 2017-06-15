<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGMNT0103" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="mntResources" key="ietitle.IGMNT0103" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
function checkForm(){
	var moName= '<bean:message bundle="mntResources" key="message.IGMNT0103.moName"/>';
	var mtId= '<bean:message bundle="mntResources" key="message.IGMNT0103.mtId"/>';
	var modValue1='<bean:message bundle="mntResources" key="message.IGMNT0103.modValue1"/>';
	var modValue2='<bean:message bundle="mntResources" key="message.IGMNT0103.modValue2"/>';
	var argSymm_model='<bean:message bundle="mntResources" key="message.IGMNT0103.001"/>';
	var argSymm_version='<bean:message bundle="mntResources" key="message.IGMNT0103.002"/>';
	var argSymm_cachesize='<bean:message bundle="mntResources" key="message.IGMNT0103.003"/>';
	
	var obj=document.getElementById("tab").getElementsByTagName("input");
    if($F('symm_id').trim()==""){
        alert(moName);
        return false;
    }
    if($F('mtId').trim()==""){
        alert(mtId);
        return false;
    }
    
    for(var i=0;i<obj.length;i++){
		if(obj[i].type=="text"){
			if(obj[i].value.trim()==""){
				alert(modValue1);
				return false;
			}
			var reg=/^\d+(.\d+)?$/;
			if(!reg.test(obj[i].value)){
				alert(modValue2);
				return false;
			}
		}
	}

    if($F('symm_model').strlen()>20){
		alert(argSymm_model);
		return false;
	}
    if($F('symm_version').strlen()>20){
		alert(argSymm_version);
		return false;
	}
    if($F('symm_cachesize').strlen()>20){
		alert(argSymm_cachesize);
		return false;
	}
	
	for(var i=0;i<obj.length;i++){
		if(obj[i].type=="checkbox"){
			if(obj[i].checked){
				obj[i].value="0";
			}else{
				obj[i].value="1";
			}
			obj[i].checked="checked";
		}
	}
    return true;
}

function showKPI(){
	var tab=document.getElementById("tab");
	for ( var i = tab.rows.length-1; i >0; i--) {
		tab.deleteRow(i);
	}
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ parameters: "type=KPI&mtId="+$F('mtId'),
		 onSuccess:  function(req, json){
		 	var result = req.responseText;
		 	if(result){
		 		result=result.substring(0,result.length-1);
		 		var kpi=result.split(",");
		 		for ( var i = 0; i < kpi.length; i++) {
				 	var mtdInfo=kpi[i].split("|");
		 			currRow=tab.insertRow();
		 			cell=currRow.insertCell();
		 			cell.innerHTML=mtdInfo[0];
		 			cell=currRow.insertCell();
		 			cell.innerHTML="<input type='text' maxlength='15' name='modValue' value='"+mtdInfo[1]+"' class='input1'/>";
		 			cell=currRow.insertCell();
		 			cell.innerHTML=mtdInfo[2];
		 			cell=currRow.insertCell();
		 			cell.innerHTML=mtdInfo[3];
		 			cell=currRow.insertCell();
		 			if(mtdInfo[4]==0){
		 				cell.innerHTML="<input type='checkbox' name='modDeleteFlag' checked='checked' value='0'/>";
		 			}
		 			if(mtdInfo[4]==1){
		 				cell.innerHTML="<input type='checkbox' name='modDeleteFlag' value='0'/>";
		 			}
				}
		 	}
	    }
		});
	if($F('mtId').trim()=="6"){//brocade交换机
		document.getElementById("model").style.display="block";
		document.getElementById("version").style.display="none";
		document.getElementById('symm_version').value="";
		document.getElementById("cachesize").style.display="none";
		document.getElementById('symm_cachesize').value="";
    }else if($F('mtId').trim()=="8"){//Mcdata交换机
		document.getElementById("model").style.display="block";
		document.getElementById("version").style.display="none";
		document.getElementById('symm_version').value="";
		document.getElementById("cachesize").style.display="none";
		document.getElementById('symm_cachesize').value="";
	}
	else if($F('mtId').trim()=="4"){//CX
		document.getElementById("model").style.display="block";
		document.getElementById("version").style.display="block";
		document.getElementById("cachesize").style.display="block";
    }
	else if($F('mtId').trim()=="2"){//DMX
		document.getElementById("model").style.display="block";
		document.getElementById("version").style.display="block";
		document.getElementById("cachesize").style.display="block";
    }
	else if($F('mtId').trim()=="3"){//IBM
		document.getElementById("model").style.display="block";
		document.getElementById("version").style.display="block";
		document.getElementById("cachesize").style.display="block";
    }
	else {
		document.getElementById("model").style.display="none";
		document.getElementById('symm_model').value="";
		document.getElementById("version").style.display="none";
		document.getElementById('symm_version').value="";
		document.getElementById("cachesize").style.display="none";
		document.getElementById('symm_cachesize').value="";
    }
}

function selectEntityItem(){
	var mtId=document.getElementById("mtId").value;
	openSubWindow('/IGMNT0106_Disp.do?mtId='+mtId, '_blank', '850', '600');
}

function setParamIGMNT0106(eid, elabel, ename, eiid, eilabel, einame, ecategory) {
       $("symm_id").value = einame;
}

function toback(flag){
	if(flag==0){
		form.action = getAppRootUrl() + "/IGMNT0101_Disp.do?mtId=${mtId}&mtName=${mtName}";
	}else{
		form.action = getAppRootUrl() + "/IGMNT0104_Disp.do";
	}
	form.submit();
}

</script>
<body onload="showKPI()">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	<div class="back">
	<a href="javascript:toback(${IGMNT0103Form.flag});" target="_self"><bean:message
		bundle="mntResources" key="label.IGMNT0103.back" /></a>
	</div>
</div>

<div id="formwrapper"><html:form styleId="form"
	action="/IGMNT0103_Insert" onsubmit="return checkSubmit(this);">
	<div class="message"><ig:message/></div>
	<fieldset>
		<legend><bean:message bundle="mntResources" key="label.IGMNT0103.addMonitorObject" /></legend>
	<div>
	<label for="Name">
	<strong>
	<span class="red">*</span>
	<bean:message bundle="mntResources" key="label.IGMNT0103.monitorType" />
	</strong>：
	 </label> 
        <html:select name="IGMNT0103Form" styleId="impcitype" property="mtId" style="width: 130px;" errorStyleClass="inputError" onchange="showKPI()">
		<html:options collection="monitorTypeList" property="value" name="" labelProperty="label" />
		</html:select>
	</div>
	<div>
	<label for="Name">
	<strong>
	<span class="red">*</span>
	<bean:message bundle="mntResources" key="label.IGMNT0103.moName"/>
	</strong>：
	</label>
	<html:text property="symm_id" style="width: 130px;" name="IGMNT0103Form"/>
	 <img src="images/seek.gif" width="16" height="16" alt='<bean:message bundle="mntResources" key="img.IGMNT0103.search.alt"/>' onclick="selectEntityItem()" style="cursor: hand"/>
	<br>
	</div>
	<div>
	<label for="Name">
	<strong>
	<bean:message bundle="mntResources" key="label.IGMNT0103.ip"/>
	</strong>：
	</label> 
	<html:text property="ip" maxlength="15" style="width: 130px;" name="IGMNT0103Form"/>
	<br>
	</div>
	<div id="model" style="display: none">
	<label for="Name">
	<strong>
	<bean:message bundle="mntResources" key="label.IGMNT0103.symm_model"/>
	</strong>：
	</label> 
		<html:text property="symm_model" tabindex="2" style="width: 200px;" name="IGMNT0103Form" styleId="symm_model"/>
	<br>
	</div>
	<div id="version" style="display: none">
	<label for="Name">
	<strong>
	<bean:message bundle="mntResources" key="label.IGMNT0103.symm_version"/>
	</strong>：
	</label> 
		<html:text property="symm_version" tabindex="2" style="width: 200px;" name="IGMNT0103Form" styleId="symm_version"/>
	<br>
	</div>
	<div id="cachesize" style="display: none">
	<label for="Name">
	<strong>
	<bean:message bundle="mntResources" key="label.IGMNT0103.symm_cachesize"/>
	</strong>：
	</label> 
		<html:text property="symm_cachesize" tabindex="2" style="width: 200px;" name="IGMNT0103Form" styleId="symm_cachesize"/>
	<br>
	</div>
	</fieldset>
	<fieldset>
	<legend><bean:message bundle="mntResources" key="label.IGMNT0103.modName"/></legend>
	<div>
	<table id="tab" class="table_style">
	<tr>
	<th><bean:message bundle="mntResources" key="label.IGMNT0103.modName"/></th>
	<th><bean:message bundle="mntResources" key="label.IGMNT0103.modValue"/></th>
	<th><bean:message bundle="mntResources" key="label.IGMNT0103.compare"/></th>
	<th><bean:message bundle="mntResources" key="label.IGMNT0103.modDes"/></th>
	<th><bean:message bundle="mntResources" key="label.IGMNT0103.deleteFlag"/></th>
	</tr>
	</table>
	</div>
	</fieldset>
	<div class="enter">
	<html:submit property="btn_insert"
		styleClass="button" onclick="return checkForm();" styleId="btn_insert">
		<bean:message bundle="mntResources" key="button.IGMNT0103.btn_commit"/>
	</html:submit>
	<html:reset property="btn_clear" styleClass="button" >
			<bean:message bundle="mntResources" key="button.IGMNT0103.btn_reset"/>
		</html:reset>
	</div>
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>

</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGIAM0403" toScope="request" />
<bean:define id="title" value="审计报告修改画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--sidebar  左菜单--> 
<div id="contentWrap">
<div id="content">
	
<div id="location">
<div class="image"></div>
<p class="fonts1">审计管理 &gt;&gt; 审计报告管理 &gt;&gt; 审计报告管理 &gt;&gt; 审计报告修改</p>
<div class="back"><a href="IGIAM0403_Back.do" target="_self">返回</a></div>
</div>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">	

function checktext(){
	if($F("apreporttype").trim()==""){
        alert('审计报告类型不能为空！');
        return false;
    }
	if($F("approjectyear").trim()==""){
    	alert('项目年度不能为空！');
        return false;
    }
	if($F("approjectname").trim()==""){
		if(type==0){
			alert('审计项目不能为空！');
		}else{
			alert('项目名称不能为空！');
		}
        return false;
    }
	if($F('approjectname').strlen()>128){
		alert("项目名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}
	if(attachFileNum==0){
		alert("请添加附件！");
		return false ;
	}else{
		var sign = 0;
		var tags = document.getElementsByTagName("input") ;
		for(var i = 0 ; i < tags.length ; i++){
			if(tags[i].type=="file"&&tags[i].value==""){
				sign++;
			}
		}
		if(sign == attachFileNum){
			alert("请添加附件！");
			return false ;
		}
		
	}
    return true;
}
function saveMessage() {
	if(checktext()!=true){
		return false;
	}
	if(window.confirm("是否保存当前信息？")){
		form.action="IGIAM0403_Update.do?forward=back";
		form.submit();
	} else {
		return false;
	}

}

function onSubmit() {
	if (window.confirm("是否删除当前信息？")) {
		form.action="IGIAM0403_ONEDELETE.do?apids="+$F("apid");
		return true ;
	} else {
		return false;
	}
}
function delFile(attid){
	 if( window.confirm("是否删除附件？")){
		document.getElementById(attid).style.display = "none";
		attachFileNum--;
		if($("deletekeys").value !=""){
			$("deletekeys").value = $("deletekeys").value + ','+attid;
		}else{
			$("deletekeys").value = attid;
		}
	 }
}
function changeProjectName(obj){
	var value = obj.value ;
	if(value == 0 || value == 1){
		document.getElementById("textname").setAttribute("readOnly", "true");
		document.getElementById("textname").value = '';
		document.getElementById("pid").value = '';
		//document.getElementsByName("image")[0].style.visibility="visible";
		document.getElementById("stronginfo").innerHTML = "审计项目";
		document.getElementById("audit").style.display="block";		
	}else if(value == 2){
		//document.getElementsByName("image")[0].style.visibility="hidden";
		document.getElementById("textname").removeAttribute("readOnly");
		document.getElementById("textname").value = '';
		document.getElementById("pid").value = '';
		document.getElementById("stronginfo").innerHTML = "项目名称";
		document.getElementById("audit").style.display="block";		
	}
	type = value ;
}
function setprj(){
	if(type == 0){
		url = "/IGIAM0101_PROJECTSEARCH.do" + "?iapStatus=2&iapType="+type;
	}else{
		url = "/IGIAM0101_PROJECTSEARCH.do" + "?iapType="+type;
	}
	openSubWindow(url,'_blank','850','400');
}
function setPrjParams(iapid, iapName, iapstatus){
	document.forms[0].approjectid.value = iapid;
	document.forms[0].approjectname.value = iapName;
}
function deleteitem(obj){
	var curRow= obj.parentNode.parentNode;
	tb.deleteRow(curRow.rowIndex);
	attachFileNum--;
}
</script>
</head>
<div id="formwrapper">
<html:form styleId="form" action="/IGIAM0403_DetailedToUpdate" enctype="multipart/form-data">
	<ig:message />
	<fieldset>
		<legend>修改审计报告信息</legend>
		<div><label for="Name"><span class="red">*</span><strong>审计报告类型</strong>：</label>
		<html:select property="apreporttype" style="WIDTH:130px" onchange="changeProjectName(this)" disabled="true">
			<ig:optionsCollection ccid="AUDITREPORTTYPE"/>
		</html:select>
		<html:hidden property="apreporttype"/>
		</div>
		<div><label for="Name"><span class="red">*</span><strong>项目年度</strong>：</label>
		<html:select property="approjectyear" style="WIDTH:130px" disabled="true">
			<ig:optionsCollection ccid="YEAR_CODE"/>
		</html:select>
		<html:hidden property="approjectyear"/>
		</div>
		<div id="audit" style="display:none;"><label for="Name"><span class="red">*</span><strong id="stronginfo"></strong>：</label>
			<html:text property="approjectname" styleId="textname" size="20" readonly="true"/>
<!-- 			<img name="image" src="images/tree.gif" style="visibility:hidden;cursor: hand;" alt="选择审计项目" width="16" height="16" border="0" onclick="setprj();"/> -->
			<html:hidden property="approjectid" styleId="pid"/>
		</div>
		 <logic:present name="IGIAM03011VO" property="attkeyList">
	     <div>
	     <logic:notEmpty name="IGIAM03011VO" property="attkeyList">
	     <label for="Name"><strong>附件</strong>：</label>
	       <table id="tb2">	
	     	<logic:iterate id="attkey" name="IGIAM03011VO" property="attkeyList">
	     		<script>
	     			attachFileNum=attachFileNum+1;
	     		</script>
				<tr id="${attkey.attid}">
				     <td>
						<html:link action="IGIAM0102_LoadFile.do?attId=${attkey.attid}" styleId='attach${attkey.attid}'>
							<bean:define id="attname" name="attkey" property="attname" />
							<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
						</html:link>
						<img alt="删除" align="middle" onClick="delFile('${attkey.attid}')" border="0" style="cursor: hand" src="images/delate.gif">
					 </td>
				</tr>
		</logic:iterate>
		</table>
		</logic:notEmpty>
	     </div>
	     </logic:present>
		<div style="padding-left: 50px"><img src="images/attachment.png" /><a
			href="javascript:addFile();" id="attachFile">添加附件</a>
			<table id="tb">
			</table>
		</div>
	    <html:hidden property="deletekeys"/>
	    <html:hidden property="apid" name="IGIAM0403Form"/>
	    <html:hidden property="apattkey" name="IGIAM0403Form"/>
	</fieldset>
	    <div class="enter">
	    	<html:button property="btn_save" value="保存" onclick="return saveMessage();" styleClass="button"  />
	    	<html:submit property="btn_delete" value="删除" onclick="return onSubmit();" styleClass="button" />
	    </div>
</html:form>
</div>
	<div id="operate">
	<!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
<script>
	var type = -1 ;
	var oldFileNum = 0 ;
	function showName(){
		if($F("apreporttype")==0||$F("apreporttype")==1){
			document.getElementById("textname").setAttribute("readOnly", "true");
			//document.getElementsByName("image")[0].style.visibility="visible";
			document.getElementById("stronginfo").innerHTML = "审计项目";
			document.getElementById("audit").style.display="block";	
		}else{
			//document.getElementsByName("image")[0].style.visibility="hidden";
			document.getElementById("textname").removeAttribute("readOnly");
			document.getElementById("stronginfo").innerHTML = "项目名称";
			document.getElementById("audit").style.display="block";		
		}
		type = $F("apreporttype") ;
		oldFileNum = attachFileNum;
	}
	showName() ;
</script>
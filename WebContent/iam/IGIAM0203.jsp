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
<bean:define id="id" value="IGIAM0203" toScope="request" />
<bean:define id="title" value="内审工作修改画面" toScope="request" />
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
<p class="fonts1">审计管理 &gt;&gt; 内审工作管理 &gt;&gt; 内审工作修改</p>
<div class="back"><a href="IGIAM0201.do" target="_self">返回</a></div>
</div>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">	
function checktext(){
	if($F("iajyear").trim()==""){
        alert('年度计划不能为空!');
        return false;
    }
	if($F("iajiapid").trim()==""){
    	alert('内审项目不能为空！');
        return false;
    }
	if($F("iajname").trim()==""){
    	alert('工作名称不能为空！');
        return false;
    }
	if($F('iajname').strlen()>128){
		alert("工作名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}
	if($F("iajstarttime").trim()==""){
    	alert('实际工作开始日期不能为空！');
        return false;
    }
    if($F("iajovertime").trim()==""){
    	alert('实际工作结束日期不能为空！');
        return false;
    }
    if(document.forms[0].iajstarttime.value > document.forms[0].iajovertime.value){
    	alert('实际工作开始日期不能大于实际工作结束日期！');
        return false;
    }
    if($F("iajdesc").trim()==""){
        alert('工作内容描述不能为空！');
        return false;
    }
    if($F('iajdesc').strlen()>512){
		alert("工作内容描述不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
		return false;
	}
    return true;
}
function saveMessage() {
	if(checktext()){
		if(window.confirm("是否提交当前内审工作信息?")){
			return true;
		} else {
			return false;
		}
	}else{
		return false;
	}
}
function setprj(){
	url = "/IGIAM0101_HELPSEARCH.do" + "?iapStatus=2";
	openSubWindow(url,'_blank','850','400');
}
function setPrjParams(iapid, iapName, iapstatus){
	document.forms[0].iajiapid.value = iapid;
	document.forms[0].iajiapname.value = iapName;
}
function delFile(attid){
	 if( window.confirm("您是否确定删除附件？")){
		document.getElementById(attid).style.display = "none";
		if($("deletekeys").value !=""){
			$("deletekeys").value = $("deletekeys").value + ','+attid;
		}else{
			$("deletekeys").value = attid;
		}
	 }
}
</script>
</head>
<div id="formwrapper">
<html:form styleId="form" action="/IGIAM0203_Update" onsubmit="return saveMessage();" enctype="multipart/form-data">
		<ig:message />
		<fieldset>
		<legend>修改内审工作信息</legend>
		<div><label for="Name" style="width:130px;"><span class="red">*</span><strong>年度计划</strong>：</label>
		<html:select property="iajyear" name="IGIAM0203Form">
			<ig:optionsCollection ccid="YEAR_CODE"/>
		</html:select>
		</div>
		<div>
			<label for="Name" style="width:130px;"><span class="red">*</span><strong>内审项目</strong>：</label>
			<input type="text" value="${IGIAM0203Form.internalauditprjTB.iapName }" name="iajiapname" readonly="readonly" size="20">
			<img src="images/tree.gif" style="cursor: hand;" alt="选择内审项目" width="16" height="16" border="0" onclick="setprj();"/>
		</div>
		<div>
			<label for="Name" style="width:130px;"><span class="red">*</span><strong>工作名称</strong>：</label>
			<html:text property="iajname" styleId="iajname" name="IGIAM0203Form"></html:text>				
		</div>
		<div>
			<label for="Name" style="width:130px;"><span class="red">*</span><strong>实际工作开始日期</strong>：</label>
			<html:text 	property="iajstarttime" styleId="iajstarttime" name="IGIAM0203Form" size="20" readonly="true"/>
			<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('iajstarttime'))"/>
		</div>
		<div>
			<label for="Name" style="width:130px;"><span class="red">*</span><strong>实际工作结束日期</strong>：</label>
			<html:text 	property="iajovertime" styleId="iajovertime" name="IGIAM0203Form" size="20" readonly="true"/>
			<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('iajovertime'))" border="0" />
		</div>
		<div>
			<label for="Name" style="width:130px;"><span class="red">*</span><strong>工作内容描述</strong>：</label>
			<html:textarea property="iajdesc" styleId="iajdesc" name="IGIAM0203Form" rows="5" cols="50"></html:textarea>		
		</div>
		 <logic:present name="IGIAM02011VO" property="attkeyList">
	     <div>
	     <logic:notEmpty name="IGIAM02011VO" property="attkeyList">	
	     <label for="Name" style="width:130px;"><strong>附件</strong>：</label>
	       <table id="tb2">	
	     	<logic:iterate id="attkey" name="IGIAM02011VO" property="attkeyList">
				<tr id="${attkey.attid}">
				     <td>
						<html:link action="downloadSvcFile.do?type=svc&attId=${attkey.attid}" styleId='attach${attkey.attid}'>
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
			href="javascript:addFile();" id="aAddAttach">添加附件</a>
			<table id="tb">
			</table>
		</div>
		<html:hidden property="iajiapid"/>
		<html:hidden property="iajid"/>
		<html:hidden property="iajuserid"/>
		<html:hidden property="iajinserttime"/>
		<html:hidden property="iajattkey"/>
		<html:hidden property="deletekeys"/>
	</fieldset>
	<div class="enter">
	     <html:submit property="btn_commit" value="提交" styleClass="button"/>
   		 <html:reset value="重置" styleClass="button"/>
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
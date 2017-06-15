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
<bean:define id="id" value="IGIAM0103" toScope="request" />
<bean:define id="title" value="内审项目修改画面" toScope="request" />
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
<p class="fonts1">审计管理 &gt;&gt; 内审项目管理 &gt;&gt; 内审项目管理 &gt;&gt; 内审项目修改</p>
<div class="back"><a href="IGIAM0102_Back.do" target="_self">返回</a></div>
</div>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">	

function checktext(){
	if($F("iapYear").trim()==""){
        alert('年度不为空！');
        return false;
    }
    if($F("iapName").trim()==""){
        alert('内审项目名称不为空！');
        return false;
    }
    if($F("iapObject").trim()==""){
        alert('审计对象不为空！');
        return false;
    }
    if($F("iapWay").trim()==""){
        alert('审计方式不为空！');
        return false;
    }
    if($F("iapUserName").trim()==""){
        alert('审计人员不为空！');
        return false;
    }
    if($F("iapOpenTime").trim()==""){
        alert('审计开始日期不为空！');
        return false;
    }
    if($F("iapCloseTime").trim()==""){
        alert('审计结束日期不为空！');
        return false;
    }
    if($F("iapObjective").trim()==""){
        alert('审计目的不为空！');
        return false;
    }
    if($F("iapScope").trim()==""){
        alert('审计范围不为空！');
        return false;
    }
    if($F("iapBasis").trim()==""){
        alert('审计依据不为空！');
        return false;
    }
    if($F("iapDesc").trim()==""){
        alert('审计内容及要点不为空！');
        return false;
    }
	return true;
}
function saveMessage() {
	if($F("iapYear").trim()==""){
        alert('年度不为空！');
        return false;
    }
    if($F("iapName").trim()==""){
        alert('内审项目名称不为空！');
        return false;
    }
	if(window.confirm("是否保存当前信息？")){
		form.action="IGIAM0102_Update.do?forward=back&iapStatus=0";
		form.submit();
	} else {
		return false;
	}

}
function submitMessage() {
	if(checktext()!=true){
		return false;
	}
	if(window.confirm("是否提交当前信息？")){
		form.action="IGIAM0102_Update.do?forward=back&iapStatus=1";
		form.submit();
	} else {
		return false;
	}
}
function onSubmit() {
	if (window.confirm("是否删除当前信息？")) {
		return true;
	} else {
		return false;
	}
}
function delFile(attid){
	 if( window.confirm("是否删除附件？")){
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
<html:form styleId="form" action="/IGIAM0102_Delete" enctype="multipart/form-data">
	<ig:message />
	<fieldset>
		<legend>修改内审项目信息</legend>
		<div><label for="Name"><span class="red">*</span><strong>年度</strong>：</label>
		<html:select property="iapYear" style="WIDTH:130px">
			<ig:optionsCollection ccid="YEAR_CODE"/>
		</html:select>
		</div>
		<div><label for="Name"><span class="red">*</span><strong>内审项目名称</strong>：</label>
			<html:text property="iapName" styleId="iapName" name="IGIAM0101Form" size="82"></html:text>
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计对象</strong>：</label>
		<html:text property="iapObject" styleId="iapObject" name="IGIAM0101Form"></html:text>				
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计方式</strong>：</label>
		<html:text property="iapWay" styleId="iapWay" name="IGIAM0101Form"></html:text>
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计开始日期</strong>：</label>
		<html:text 	property="iapOpenTime"  styleId="iapOpenTime" size="20" name="IGIAM0101Form" readonly="true"/>
		<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('iapOpenTime'))" border="0" />
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计结束日期</strong>：</label>
		<html:text 	property="iapCloseTime"  styleId="iapCloseTime" size="20" name="IGIAM0101Form" readonly="true"/>
		<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('iapCloseTime'))" border="0" />
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计人员</strong>：</label>
		<html:text property="iapUserName" styleId="iapUserName" name="IGIAM0101Form" size="82"></html:text>
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计目的</strong>：</label>
		<html:textarea property="iapObjective" styleId="iapObjective" name="IGIAM0101Form" cols="60" rows="5" tabindex="7"></html:textarea>
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计范围</strong>：</label>
		<html:textarea property="iapScope" styleId="iapScope" name="IGIAM0101Form"  cols="60" rows="5" tabindex="7"></html:textarea>
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计依据</strong>：</label>
		<html:textarea property="iapBasis" styleId="iapBasis" name="IGIAM0101Form"  cols="60" rows="5" tabindex="7"></html:textarea>
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计内容及要点</strong>：</label>
		<html:textarea property="iapDesc" styleId="iapDesc" name="IGIAM0101Form"  cols="60" rows="5" tabindex="7"></html:textarea>
		</div>
		 <logic:present name="IGIAM01011VO" property="attkeyList">
	     <div>
	     <logic:notEmpty name="IGIAM01011VO" property="attkeyList">
	     <label for="Name"><strong>附件</strong>：</label>
	       <table id="tb2">	
	     	<logic:iterate id="attkey" name="IGIAM01011VO" property="attkeyList">
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
	    <html:hidden property="iapId" name="IGIAM0101Form"/>
	    <html:hidden property="iapType" name="IGIAM0101Form"/>
	    <html:hidden property="iapAttKey" name="IGIAM0101Form"/>
	</fieldset>
	    <div class="enter"><html:button property="btn_save" value="保存" onclick="return saveMessage();" styleClass="button"  />
	    <html:submit property="btn_delete" value="删除" onclick="return onSubmit();" styleClass="button" />
	    <html:button property="btn_commit" value="提交确认" onclick="return submitMessage();" styleClass="button"  /></div>
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
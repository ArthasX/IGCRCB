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
<bean:define id="id" value="IGIAM0104" toScope="request" />
<bean:define id="title" value="内审项目登记画面" toScope="request" />
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
<p class="fonts1">审计管理 &gt;&gt; 内审项目管理 &gt;&gt; 内审项目登记</p>
</div>
<script type="text/javascript">	

function checktext(){
	if($F("iapYear").trim()==""){
        alert('年度不能为空！');
        return false;
    }
    if($F("iapName").trim()==""){
        alert('内审项目名称不能为空！');
        return false;
    }
    if($F("iapObject").trim()==""){
        alert('审计对象不能为空！');
        return false;
    }
    if($F("iapWay").trim()==""){
        alert('审计方式不能为空！');
        return false;
    }
    if($F("iapUserName").trim()==""){
        alert('审计人员不能为空！');
        return false;
    }
    if($F("iapOpenTime").trim()==""){
        alert('审计开始日期不能为空！');
        return false;
    }
    if($F("iapCloseTime").trim()==""){
        alert('审计结束日期不能为空！');
        return false;
    }
    if($F("iapObjective").trim()==""){
        alert('审计目的不能为空！');
        return false;
    }
    if($F("iapScope").trim()==""){
        alert('审计范围不能为空！');
        return false;
    }
    if($F("iapBasis").trim()==""){
        alert('审计依据不能为空！');
        return false;
    }
    if($F("iapDesc").trim()==""){
        alert('审计内容及要点不能为空！');
        return false;
    }
    if(!checkDate("iapOpenTime","iapCloseTime")){
    	alert('审计结束日期必须大于审计开始日期！');
        return false;
    }
    if($F('iapName').strlen()>128){
		alert("项目名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}if($F('iapObject').strlen()>32){
		alert("审计对象不能大于32个字符！");
		return false;
	}if($F('iapWay').strlen()>32){
		alert("审计方式不能大于32个字符！");
		return false;
	}if($F('iapUserName').strlen()>128){
		alert("审计人员不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}if($F('iapObjective').strlen()>256){
		alert("审计目的不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
		return false;
	}if($F('iapScope').strlen()>256){
		alert("审计范围不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
		return false;
	}if($F('iapBasis').strlen()>256){
		alert("审计依据不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
		return false;
	}if($F('iapDesc').strlen()>512){
		alert("审计内容及要点不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
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
		form.action="IGIAM0103_Insert.do?forward=back&iapStatus=0";
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
		form.action="IGIAM0103_Insert.do?forward=back&iapStatus=1";
		form.submit();
	} else {
		return false;
	}
}
</script>
<div id="formwrapper">
<html:form styleId="form" action="/IGIAM0103_Disp" enctype="multipart/form-data">
	<ig:message />
	<fieldset>
		<legend>新增内审项目信息</legend>
		<div><html:hidden property="iapId"/></div>
		<div><label for="Name"><span class="red">*</span><strong>年度</strong>：</label>
		<html:select property="iapYear" style="WIDTH:130px">
			<ig:optionsCollection ccid="YEAR_CODE"/>
		</html:select>
		</div>
		<div><label for="Name"><span class="red">*</span><strong>内审项目名称</strong>：</label>
			<html:text property="iapName" styleId="iapName" size="82"></html:text>
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计对象</strong>：</label>
		<html:text property="iapObject" styleId="iapObject"></html:text>
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计方式</strong>：</label>
		<html:text property="iapWay" styleId="iapWay"></html:text>
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计开始日期</strong>：</label>
		<html:text 	property="iapOpenTime" styleId="iapOpenTime" size="20" readonly="true"/>
		<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('iapOpenTime'))" border="0" />
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计结束日期</strong>：</label>
		<html:text 	property="iapCloseTime" styleId="iapCloseTime" size="20" readonly="true"/>
		<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('iapCloseTime'))" border="0" />
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计人员</strong>：</label>
		<html:text property="iapUserName" styleId="iapUserName" size="82"></html:text>				
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计目的</strong>：</label>
		<html:textarea property="iapObjective" styleId="iapObjective" cols="60" rows="5" tabindex="7"></html:textarea>		
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计范围</strong>：</label>
		<html:textarea property="iapScope" styleId="iapScope" cols="60" rows="5" tabindex="7"></html:textarea>		
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计依据</strong>：</label>
		<html:textarea property="iapBasis" styleId="iapBasis" cols="60" rows="5" tabindex="7"></html:textarea>		
		</div>
		<div><label for="Name"><span class="red">*</span><strong>审计内容及要点</strong>：</label>
		<html:textarea property="iapDesc" styleId="iapDesc" cols="60" rows="5" tabindex="7"></html:textarea>		
		</div>
		<div style="padding-left: 50px"><img src="images/attachment.png" /><a
			href="javascript:addFile();" id="attachFile">添加附件</a>
			<table id="tb">
			</table>
		</div>
	</fieldset>
	<html:hidden property="iapType" styleId="iapType" value="0"/>
    <div class="enter"><html:button property="btn_save" value="保存" onclick="return saveMessage();" styleClass="button"  />
    <html:button property="btn_commit" value="提交确认" onclick="return submitMessage();" styleClass="button"/>
    <html:reset value="重置" styleClass="button"/></div>
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
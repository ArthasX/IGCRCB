<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGIAM0202" toScope="request" />
<bean:define id="title" value="内审工作登记" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
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
	var iajyear=document.getElementById("iajyear").value;
	url = "/IGIAM0101_HELPSEARCH.do" + "?iapStatus=2&iapType=0&iapYear="+iajyear;
	openSubWindow(url,'_blank','850','400');
}
function setPrjParams(iapid, iapName, iapstatus){
	document.forms[0].iajiapid.value = iapid;
	document.forms[0].iajiapname.value = iapName;
}
function setYear_Code(){
	var date = new Date();
	document.getElementById("iajyear").value = date.getYear();
}
</script>
<body onload="setYear_Code();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--sidebar  左菜单--> 
    <div id="contentWrap">
        <div id="content">
            
            <div id="location">
                <div class="image"></div>
               	<p class="fonts1">审计管理 &gt;&gt; 内审工作管理 &gt;&gt; 内审工作登记</p>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGIAM0202" onsubmit="return saveMessage();"  enctype="multipart/form-data">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
                <legend>新增内审工作信息</legend>
					<div><label for="Name" style="width:130px;"><span class="red">*</span><strong>年度计划</strong>：</label>
						<html:select property="iajyear" style="width:130px;" styleId="iajyear">
							<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false"/>
						</html:select>
					</div>
					<div><label for="Name" style="width:130px;"><span class="red">*</span><strong>内审项目</strong>：</label>
						<input type="text" name="iajiapname" readonly="readonly" size="20">
						<img src="images/tree.gif" style="cursor: hand;" alt="选择内审项目" width="16" height="16" border="0" onclick="setprj();"/>
						<html:hidden property="iajiapid"/>
					</div>
					<div><label for="Name" style="width:130px;"><span class="red">*</span><strong>工作名称</strong>：</label>
					<html:text property="iajname" styleId="iajname"></html:text>				
					</div>
					<div><label for="Name" style="width:130px;"><span class="red">*</span><strong>实际工作开始日期</strong>：</label>
					<html:text 	property="iajstarttime" styleId="iajstarttime" size="20" readonly="true"/>
					<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('iajstarttime'))"/>
					</div>
					<div><label for="Name" style="width:130px;"><span class="red">*</span><strong>实际工作结束日期</strong>：</label>
					<html:text 	property="iajovertime" styleId="iajovertime" size="20" readonly="true"/>
					<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('iajovertime'))" border="0" />
					</div>
					<div><label for="Name" style="width:130px;"><span class="red">*</span><strong>工作内容描述</strong>：</label>
					<html:textarea property="iajdesc" styleId="iajdesc" rows="5" cols="50"></html:textarea>		
					</div>
					<div style="padding-left: 50px"><img src="images/attachment.png" /><a
						href="javascript:addFile();" id="aAddAttach">添加附件</a>
						<table id="tb">
						</table>
					</div>
    			</fieldset>
				<div class="enter">
				     <html:submit property="btn_commit" value="提交" styleClass="button"/>
			   		 <html:reset value="重置" styleClass="button"/>
				</div>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>

</div>
</body>
</html:html>
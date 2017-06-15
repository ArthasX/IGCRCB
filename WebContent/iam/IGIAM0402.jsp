<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGIAM0402" toScope="request" />
<bean:define id="title" value="审计报告登记" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
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
		alert("请添加附件");
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
	if(checktext()){
		if(window.confirm("是否提交当前审计报告信息?")){
			return true;
		} else {
			return false;
		}
	}else{
		return false;
	}
}

var type = -1 ;
function changeProjectName(obj){
	var value = obj.value ;
	if(value == 0 || value == 1){
		document.getElementById("textname").setAttribute("readOnly", "true");
		document.getElementById("textname").value = '';
		document.getElementById("pid").value = '';
		document.getElementsByName("image")[0].style.visibility="visible";
		document.getElementById("stronginfo").innerHTML = "审计项目";
		document.getElementById("audit").style.display="block";		
	}else if(value == 2){
		document.getElementsByName("image")[0].style.visibility="hidden";
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
		url = "/IGIAM0301_HELPSEARCH.do" + "?iapStatus=2&iapType="+type;
	}else{
		url = "/IGIAM0301_HELPSEARCH.do" + "?iapType="+type;
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
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--sidebar  左菜单--> 
    <div id="contentWrap">
        <div id="content">
            
            <div id="location">
                <div class="image"></div>
               	<p class="fonts1">审计管理 &gt;&gt; 审计报告管理 &gt;&gt; 审计报告登记</p>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGIAM0402_INSERT" onsubmit="return saveMessage();"  enctype="multipart/form-data">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
                <legend>新增审计报告信息</legend>
					<div><label for="Name" style="width:130px;"><span class="red">*</span><strong>审计报告类型</strong>：</label>
						<html:select property="apreporttype" style="width:130px;" onchange="changeProjectName(this)">
							<ig:optionsCollection ccid="AUDITREPORTTYPE"/>
						</html:select>
					</div>
					<div><label for="Name" style="width:130px;"><span class="red">*</span><strong>项目年度</strong>：</label>
						<html:select property="approjectyear" style="width:130px;">
							<ig:optionsCollection ccid="YEAR_CODE"/>
						</html:select>
					</div>
					<div id="audit" style="display:none;"><label for="Name" style="width:130px;"><span class="red">*</span><strong id="stronginfo"></strong>：</label>
						<input type="text" name="approjectname" size="20" id="textname" /> 
						<img name="image" src="images/tree.gif" style="visibility:hidden;cursor: hand;" alt="选择审计项目" width="16" height="16" border="0" onclick="setprj();"/>
						<html:hidden property="approjectid" styleId="pid"/>
					</div>
					<div style="padding-left: 50px"><span class="red">*</span><img src="images/attachment.png" /><a
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
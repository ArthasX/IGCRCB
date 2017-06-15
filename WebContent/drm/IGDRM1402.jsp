<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM1402" toScope="request" />
<bean:define id="title" value="通知发布" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var attachFileNum=0;
var attach="";
var prtype;

function addFile() {
	currRow= tb.insertRow();
	cell=currRow.insertCell();
	cell.innerHTML= "<input type='file' name='fileList["+attachFileNum+"].file' class='inputbutton' contentEditable='false'><input type='button' class='delbutton' value='\u5220\u9664' onclick='deleteitem(this)'>";
	attachFileNum++;
}

function deleteAttach(td,obj) {
	//alert(obj);
	if(window.confirm("确定要删除附件吗？")) {
		var attachLink = document.getElementById("attach"+obj);
		attachLink.linkName="";
		//alert(attachLink);
		if(attach=="") {
			attach = obj;
		} else {
			attach = attach+'_'+obj;
		}
		//alert(attach);
		var curRow= td.parentNode.parentNode;
		tb2.deleteRow(curRow.rowIndex);
	}
}

function deleteitem(obj) {
	var curRow= obj.parentNode.parentNode;
	tb.deleteRow(curRow.rowIndex);
}

//提交所选校验
function confirmDisp() {
	var message = '';
	if ('${IGDRM1402Form.mode}' == '0') {
		message = '<bean:message key="IGCO10000.W001" arg0="通知基本信息" />';
	} else {
		message = '<bean:message key="IGCO10000.W003" arg0="通知基本信息" />';
	}
	
	if($("nname").value.trim()=="") {
		alert("请输入通知名称！");
		return false;
	}
	if($("ndesc").value.trim()=="") {
		alert("请输入通知内容！");
		return false;
	}
	
	if($F('nname').strlen()>128) {
		alert("通知名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('ndesc').strlen()>256) {
		alert("通知内容不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
		return false;
	}
	<logic:equal name="IGDRM1402Form" property="mode" value="0">
		if($("isPush").value=="1") {
			if($("selType").value.trim()=="") {
				alert("请选择Dashboard类型！");
				return false;
			}
			if($("pushPrtitle").value.trim()=="") {
				alert("请选择Dashboard名称！");
				return false;
			}
		}
		var isSend = jQuery("#isSend").val();
		if(isSend == "1"){
			if(!jQuery("input[name='ntargettype']:checked").val()){
				alert("推送通知需要选择发布对象");
				return false;
			}
			var isSendSMS = jQuery("input[name='sendSMS']:checked").val();
			var isSendEML = jQuery("input[name='sendEML']:checked").val();
			if(isSendSMS != "1" && isSendEML != "1"){
				alert("推送通知需要选择发送方式");
				return false;
			}
			
			var type = jQuery("input[name='ntargettype']:checked").val();
			if(type=="1") {
				if($("ntargetuserid").value.trim()=="") {
					alert("请选择人员！");
					return false;
				}
			}
			if(type=="2") {
				if($("ntargetroleid").value.trim()=="") {
					alert("请选择角色！");
					return false;
				}
			}
		}
	</logic:equal>
	if( window.confirm(message)) {
		return true;
	} else {
		return false;
	}
}

function deleteitem(obj) {
	var curRow= obj.parentNode.parentNode;
	tb.deleteRow(curRow.rowIndex);
}

//删除附件
function delFile(attid) {
	if( window.confirm("您是否确定删除附件？")) {
		document.getElementById(attid).style.display = "none";
		if($("deletekeys").value !="") {
			$("deletekeys").value = $("deletekeys").value + ','+attid;
		} else {
			$("deletekeys").value = attid;
		}
	}
}

//判断是否推送通知
function changeTargettype(obj) {
	if(obj.value == "0") {
		document.getElementById("targettype").style.display = "none";
		document.getElementById("sendType").style.display = "none";
		document.getElementById("targetuser").style.display = "none";
		document.getElementById("targetrole").style.display = "none";
	} else if(obj.value == "1") {
		document.getElementById("targettype").style.display = "";
		document.getElementById("sendType").style.display = "";
		var type = jQuery("input[name='ntargettype']:checked").val();//获取是否隐藏的标识
		if(type == "1") {
			document.getElementById("targetuser").style.display = "";
			document.getElementById("targetrole").style.display = "none";
		}else if(type == "2") {
			document.getElementById("targetuser").style.display = "none";
			document.getElementById("targetrole").style.display = "";
		}
	}
}
//选择发布对象时进行相应控制原来的全部逻辑被去掉
function changTargetType(obj) {
	var type = obj.value;
	if(type == "1") {
		document.getElementById("targetuser").style.display = "";
		document.getElementById("targetrole").style.display = "none";
		document.getElementById("sendType").style.display = "";
	} else if(type == "2") {
		document.getElementById("targetuser").style.display = "none";
		document.getElementById("targetrole").style.display = "";
		document.getElementById("sendType").style.display = "";
	}
}


function selectProcess() {
	if(prtype) {
		if(prtype=="WDC"){
			openSubWindow('/IGDRM0903_Sel.do?prtype=WDC', '_blank', '1000', '600');
		}else if(prtype=="WDP"){
			openSubWindow('/IGDRM0903_Sel.do?prtype=WDP', '_blank', '1000', '600');
		}
	} else {
		alert("请选择推送屏幕选择！");
	}
}

function selectUser() {
	openSubWindow('/IGSYM0205_NoPage.do', '_blank','1000','600');
}
function selectRole() {
	openSubWindow('/IGSYM0305_NoPage.do', '_blank','1000','600');
}

//设置人员ID和人员姓名
function setParamUser(userid, username, pos) {
	$("ntargetuserid").value = userid;
	$("ntargetusername").value = username;
}
//设置角色ID和角色姓名
function setParamRole(roleid, rolename) {
	$("ntargetroleid").value = roleid;
	$("ntargetrolename").value = rolename;
}

function setPrid(prcorid, prcortitle) {
	$("pushPrid").value = prcorid;
	$("pushPrtitle").value = prcortitle;
}
//返回按钮点击事件
function toback(){
	window.location.href =getAppRootUrl() + "/IGDRM1401_RE.do";
}
// jQuery(function() {
// 	jQuery("#selType").change(function() {
// 		prtype = this.value;
// 	});
// });
function changevalue(obj){
	prtype = obj.value;
	if($("pushPrtitle").value.trim()!="") {
		$("pushPrtitle").value = "";
		$("pushPrid").value = "";
	}
}

</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="location">
		<div class="image"></div>
		<p class="fonts1"><ig:navigation/></p>
	</div>
	
	<div id="formwrapper">
		<html:form styleId="form" action="/IGDRM1402" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
		<!--  message -->
		<ig:message />
		<!--  /message -->
		<fieldset>
		<logic:equal name="IGDRM1402Form" property="mode" value="0">
			<legend>新增通知信息</legend>
		</logic:equal>
		<logic:equal name="IGDRM1402Form" property="mode" value="1">
			<legend>修改通知信息</legend>
		</logic:equal>
		<div>
			<label for="Name"><strong><span class="red">*</span>通知名称</strong>：</label>
			<html:text property="nname" size="18" style="width:300px;" errorStyleClass="inputError imeActive" tabindex="1" /><br/>
		</div>
		<div>
			<label for="Name"><strong>发布者姓名</strong>：</label>
			<p class="p2">&nbsp;&nbsp;<bean:write property="nusername" name="IGDRM1402Form"/></p><br/>
		</div>
		<div>
			<label for="Name"><strong>发布者部门</strong>：</label>
			<p class="p2">&nbsp;&nbsp;<bean:write property="norgname" name="IGDRM1402Form"/></p><br/>
		</div>
		<div>
			<label for="Name"><strong>发布日期</strong>：</label>
			<p class="p2">&nbsp;&nbsp;<bean:write property="ntime" name="IGDRM1402Form"/></p><br/>
		</div>
		<div>
			<label for="Name"><strong><span class="red">*</span>通知内容</strong>：</label>
			<html:textarea property="ndesc" cols="60" rows="5" tabindex="7" errorStyleClass="inputError imeActive"/><br/>
		</div>
		
		<logic:equal name="IGDRM1402Form" property="mode" value="0">
			<html:select style="display:none;" property="isPush">
				<html:option value="1" >是</html:option>
			</html:select>
		<div id="prTypeBox" >
			<label for="Name"><strong><span class="red">*</span>推送屏幕选择</strong>：</label>
			<select id="selType" onchange="changevalue(this);">
				<option></option>
				<option value="WDC">应急指挥图</option>
				<option value="WDP">技术处理图</option>
			</select>
		</div>
		<div id="process">
			<label for="Name"><strong><span class="red">*</span>推送流程选择</strong>：</label>
			<input type="text" name="pushPrtitle" id="pushPrtitle" readonly="true"><a href="javascript:;" onclick="javascript:selectProcess()"><img alt="选择应急指挥流程" src="images/seek.gif" border="0"/></a>
			<html:hidden property="pushPrid" />
		</div>
		
		<div><!-- 推送通知判断 -->
<!-- 			<label for="Name"><strong><span class="red">*</span>推送通知</strong>：</label> -->
			<html:select style="display:none;" property="isSend" styleId="isSend">
				<html:option value="0">否</html:option>
<%-- 				<html:option value="1">是</html:option> --%>
			</html:select>
		</div>
<!-- 		<div id="targettype" style="display: none;"> -->
<!-- 			<label for="Name"><strong><span class="red">*</span>发布对象</strong>：</label> -->
<!-- 			<input type="radio" name="ntargettype" value="1" onclick="changTargetType(this);">&nbsp;&nbsp;人员 -->
<!-- 			<input type="radio" name="ntargettype" value="2" onclick="changTargetType(this);">&nbsp;&nbsp;角色 -->
<!-- 		</div> -->
		
		<div id="sendType" style="display: none;">
			<label for="Name"><strong><span class="red">*</span>发送方式</strong>：</label>
			<input type="checkbox" name="sendSMS" value="1">&nbsp;&nbsp;短信
			<input type="checkbox" name="sendEML" value="1">&nbsp;&nbsp;邮件
		</div>
		
		<div id="targetuser" style="display: none;">
			<label for="Name"><strong><span class="red">*</span>人员</strong>：</label>
			<input type="text" name="ntargetusername" size="80" readonly="readonly"><a href="javascript:;" onclick="javascript:selectUser()"><img alt="选择人员" src="images/seek.gif" border="0"/></a>
			<input type="hidden" name="ntargetuserid">
		</div>
		
		<div id="targetrole" style="display: none;">
			<label for="Name"><strong><span class="red">*</span>角色</strong>：</label>
			<input type="text" name="ntargetrolename" size="80" readonly="readonly"><a href="javascript:;" onclick="javascript:selectRole()"><img alt="选择角色" src="images/seek.gif" border="0"/></a>
			<input type="hidden" name="ntargetroleid">
		</div>
		</logic:equal>
		
		<div>
<!-- 			<label for="Name"><strong>附件</strong>：</label> -->
			<logic:equal name="IGDRM1402Form" property="mode" value="1">
				<logic:notEmpty name="IGDRM1402Form" property="attachmentList">
					<table id="tb2">
						<logic:iterate id="attachment" name="IGDRM1402Form" property="attachmentList" indexId="index">
							<tr id="${attachment.attid}">
								<td>
									<img src="images/attachment.png" />
									<html:link action="/IGDRM1402_loadFIle.do?attid=${attachment.attid}" styleId='attach${attachment.attid}'>
									<bean:define id="attname" name="attachment" property="attname" />
									<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
									</html:link>&nbsp;&nbsp;&nbsp;&nbsp;
									<img src="images/delate.gif" align="middle" onClick="delFile('${attachment.attid}')" border="0" style="cursor: hand" alt="删除"/><br/>
								</td>
							</tr>
						</logic:iterate>
					</table>
				</logic:notEmpty>
			</logic:equal><br/>
		</div>
<!-- 		<div style="padding-left: 50px"> -->
<!-- 			<img src="images/attachment.png" /> -->
<!-- 			<a href="javascript:addFile();" id="aAddAttach">添加附件</a> -->
<!-- 			<table id="tb"></table> -->
<!-- 		</div> -->
		
		<div><input type='hidden' name='exattkey'/></div>
		</fieldset>
		
		<div class="enter">
			<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp();" />
			<html:reset property="btn_clear" styleClass="button" value="重置" />
			<logic:equal name="IGDRM1402Form" property="mode" value="1">
				<!-- <div class="back"><a href="IGSYM0501_RE.do" target="_self">返回</a></div> --> 
				<html:button property="btn_back" styleClass="button" value="返回" onclick="toback()"/>
			</logic:equal>
		</div>
		
		<html:hidden property="nid"/>
		<html:hidden property="nuserid"/>
		<html:hidden property="norgid"/>
		<html:hidden property="mode"/>
		<html:hidden property="nusername"/>
		<html:hidden property="norgname"/>
		<html:hidden property="ntime"/>
		<html:hidden property="delfile"/>
		<html:hidden property="nattkey"/>
		<html:hidden property="attachDel"/>
		<html:hidden property="deletekeys"/>
		</html:form>
	</div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>
<html:html>
<bean:define id="id" value="IGSYA0102" toScope="request" />
<bean:define id="title" value="制度发起" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var gid='IGSYA0102';

function checkForm(){
	
	if($F('tree_show_value').trim()==""){
		alert("请选择制度分类！");
		return false;
	}
	if($F('inname').trim()==""){
		alert("请输入制度名称！");
		return false;
	}
	if($F('indesc').trim()==""){
		alert("请输入制度内容！");
		return false;
	}
	if($F('inname').strlen()>128){
		alert("制度名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('indesc').strlen()>512){
		alert("制度内容不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
		return false;
	}
	if( window.confirm("您是否确认提交？")){
		return true;
	} else {
		return false;
	}
}
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

function setTree(){
	var temp = window.showModalDialog("IGSYM1505_TREE.do?ccid=300&selecedlast=0",null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.getElementById("tree_show_value").value = "";
		document.getElementById("tree_value").value = "";
	}else if(null!=temp && temp.split("|").length>1){
		var id = temp.split("|")[0];
		var name = temp.split("|")[1];
		var treesyscode;
		
		if(id.split("_").length>1){
			treeccid = id.split("_")[0];
			treecid = id.split("_")[1];
			treesyscode = id.split("_")[2];
		}else{
			treeccid = id.split("_")[0];
			treecid = "";
			treesyscode = "";
		}
		
		if(treesyscode!=null && name!=null && treesyscode != ''){
			document.getElementById("tree_show_value").value = name;
			document.getElementById("tree_value").value =treesyscode + "_tree_" + name;
		}else{
			document.getElementById("tree_show_value").value = "";
			document.getElementById("tree_value").value = "";
		}
		
	}	
}
jQuery(document).ready(function() {
	var typeValue ='${IGSYA0102Form.intype}';
	if(typeValue != ''){
		var typeName = typeValue.split("_tree_")[1];
		jQuery("#tree_show_value").val(typeName);
	}
});

</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<html:form action="/IGSYA0102_INSERT" styleId="form" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
		<logic:equal name="IGSYA0102Form" property="mode" value="0"> 制度汇编 &gt;&gt; 制度汇编 &gt;&gt;制度发起</logic:equal>
		<logic:equal name="IGSYA0102Form" property="mode" value="1"> 制度汇编 &gt;&gt; 制度汇编 &gt;&gt;制度编辑</logic:equal>
	
	    </p>
	<div class="back"><a href="IGSYA0103_Back.do" target="_self">返回</a></div> 
	</div>
	<div id="formwrapper">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset><legend>
		<logic:equal name="IGSYA0102Form" property="mode" value="0">制度发起</logic:equal>
		<logic:equal name="IGSYA0102Form" property="mode" value="1">制度编辑</logic:equal>
	</legend>
	<%-- <logic:equal name="IGSYA0102Form" property="mode" value="0">
		<div><label for="Name"><strong><span class="red">*</span>制度名称</strong>：</label> <html:text
			property="inname" size="82" errorStyleClass="inputError imeActive"/> <br />
		</div>
		<div><label for="Name"><strong><span class="red">*</span>制度内容</strong>：</label> <html:textarea
			property="indesc" cols="60" rows="6" errorStyleClass="inputError imeActive"></html:textarea> <br />
		</div>
		
		
		<div style="padding-left: 50px"><img src="images/attachment.gif" /><a
			href="javascript:addFile();" id="aAddAttach">添加附件</a>
		<table id="tb">
		</table>
		</div>
		</fieldset>
		<div><input type='hidden' name='exattkey'/></div>
		<div class="Placeholder"></div>
		</div>
	</logic:equal>
	
	<logic:equal name="IGSYA0102Form" property="mode" value="1"> --%>
		<div>
			<label for="Name"><strong><span class="red">*</span>制度分类</strong>：</label>
			<input type="text" name="show_tree" id="tree_show_value" readonly="readonly"/>
			<img src="images/seek.gif" align="middle" alt="查询" onclick="setTree();" style="cursor: hand;" border="0"/>
			<input type="hidden" name="varnames" id="tree_name" value="制度分类"/>
			<input type="hidden" name="intype" id="tree_value" value="${IGSYA0102Form.intype }"/>
		</div>
		<div><label for="Name"><strong><span class="red">*</span>制度名称</strong>：</label> 
		<html:text property="inname" size="82" name="IGSYA0102Form" errorStyleClass="inputError imeActive"/> <br />
		</div>
		<div><label for="Name"><strong><span class="red">*</span>制度内容</strong>：</label> <html:textarea
			property="indesc" cols="60" name="IGSYA0102Form" rows="6" errorStyleClass="inputError imeActive"></html:textarea> <br />
		</div>
		<div>
			<label for="Name"><strong>附件</strong>：</label>
			<logic:equal name="IGSYA0102Form" property="mode" value="1">
				<logic:notEmpty name="IGSYA0102Form" property="attachmentList">
					<table id="tb2">
						<logic:iterate id="attachment" name="IGSYA0102Form" property="attachmentList" indexId="index">
							<tr id="${attachment.attid}">
								<td>
									<img src="images/attachment.png" />
									<html:link action="/IGSYA0101_loadFIle.do?attid=${attachment.attid}" styleId='attach${attachment.attid}'>
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
		<div style="padding-left: 50px"><img src="images/attachment.gif" /><a
			href="javascript:addFile();" id="aAddAttach">添加附件</a>
		<table id="tb">
		</table>
		</div>
	<%-- </logic:equal> --%>
	<html:hidden property="deletekeys"/>
	<html:hidden property="attkey"/>
	<html:hidden property="mode"/>
	<html:hidden property="inid"/>
	<div class="enter"><html:submit styleClass="button" value="提交" onclick="return checkForm();"/>
		<html:reset styleClass="button" value="重置" /></div>
</html:form></div>
</div>
</div>
</div>
</body>
</html:html>


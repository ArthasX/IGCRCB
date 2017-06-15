<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>
<html:html>
<bean:define id="id" value="IGSYA0105" toScope="request" />
<bean:define id="title" value="制度查看" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var gid='IGSYA0102';
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
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	<div class="back"><a href="IGSYA0101_Back.do" target="_self">返回</a></div> 
	</div>
	<div id="formwrapper">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset><legend>
		制度查看
	</legend>
		<div>
			<label for="Name"><strong>制度分类</strong>：</label>
			<input type="text" name="show_tree" id="tree_show_value" readonly="readonly"/>
			<input type="hidden" name="varnames" id="tree_name" value="制度分类"/>
			<input type="hidden" name="intype" id="tree_value" value="${IGSYA0102Form.intype }"/>
		</div>
		<div><label for="Name"><strong>制度名称</strong>：</label> 
		<html:text property="inname" size="82" name="IGSYA0102Form" errorStyleClass="inputError imeActive" readonly="true"/> <br />
		</div>
		<div><label for="Name"><strong>制度内容</strong>：</label> 
		<html:textarea property="indesc" cols="60" name="IGSYA0102Form" rows="6" errorStyleClass="inputError imeActive" readonly="true"></html:textarea> <br />
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
									<br/>
								</td>
							</tr>
						</logic:iterate>
					</table>
				</logic:notEmpty>
			</logic:equal><br/>
		</div>
		<div style="padding-left: 50px">
		<table id="tb">
		</table>
		</div>
	<html:hidden property="deletekeys"/>
	<html:hidden property="attkey"/>
	<html:hidden property="mode"/>
	<html:hidden property="inid"/>
</html:form></div>
</div>
</div>
</div>
</body>
</html:html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGAIM0301" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0301" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	function openAuditWaitTaskDetail(auwtid){
	 	openSubWindow( '/IGAIM0303_Disp.do?auwtid='+ auwtid,"auditWaitTask","800","600");
	}

	function importEI(){
		if(checkNum("auwtids") == 0){
			alert('<bean:message bundle="asmResources" key="message.IGCIM0301.001"/>');
	        return false;
		}
	    if(window.confirm('<bean:message bundle="asmResources" key="message.IGCIM0301.002"/>')){
	    	//disableAllButton();
	        form.action = getAppRootUrl() + "/IGAIM0301_Import.do";
	        //document.forms[0].submit();
	        return true;
	    } else {
	        return false;
	    }
	}

	function compareEI(){
	    if(window.confirm('<bean:message bundle="asmResources" key="message.IGCIM0301.006"/>')){
	        form.action = getAppRootUrl() + "/IGAIM0301_Compare.do";
	        return true;
	    } else {
	        return false;
	    }
	}
	
	function deleteTask(){
		if(checkNum("auwtids") == 0){
			alert('<bean:message bundle="asmResources" key="message.IGCIM0301.003"/>');
	        return false;
		}
	    if(window.confirm('<bean:message bundle="asmResources" key="message.IGCIM0301.004"/>')){
	    	//disableAllButton();
	        form.action = getAppRootUrl() + "/IGAIM0301_Delete.do";
	        //document.forms[0].submit();
	        return true;
	    } else {
	        return false;
	    }
	}

	function disableAllButton(){
	 	var el = document.getElementsByTagName("input");

 		for(var i = 0;i<el.length;i++)
 		{
 			if(el[i].type=="button" || el[i].type=="submit" || el[i].type=="reset")
 			{
 				el[i].disabled=true;
 			}
 		}
 		try
 		{
 			//显示请等候的DIV
 			var bodyel = document.getElementsByTagName("body");
 			bodyel[0].innerHTML +="<div id=\"disableAllButtonWaitDIV\" class=\"layer\"><div><div><img src=\"images/loding.gif\" /><br /><bean:message key='IGASM0331.I001' /><br><br></div></div><iframe src=\"javascript:false\" style=\"position:absolute; visibility:inherit; top:0px; left:0px; width:100%; height:100%; z-index:-2; filter='progid:DXImageTransform.Microsoft.Alpha(style=0,opacity=0)';\"></iframe></div>"

 		}catch(ex)
 		{
 			//由于这不是一个主要功能所以隐藏这个异常
 			//alert("函数发生异常。\n异常内容为:"+ex.description+"\n错误号："+ex.number); 
 			//throw ex;
 		}

	 }
	</script>

<body>
<c:set var="importFlag" value="0"/>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGAIM0301_Disp"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
		<ig:navigation extname1="${urlable}"/>
	</p>
	</div>
	<div id="search">
		<div class="img"></div>
		<div class="conditions">
			<div class="conditions_border1">
				<div>
					<label><bean:message bundle="asmResources" key="label.IGCIM0301.auwtstatus"/></label>
					<html:select property="taskDone" name="IGCIM0301Form" styleId="taskDone">
						<html:option value="0"><bean:message bundle="asmResources" key="label.IGCIM0301.taskToDo"/></html:option>
						<html:option value="1"><bean:message bundle="asmResources" key="label.IGCIM0301.taskDone"/></html:option>
						<html:option value="2"><bean:message bundle="asmResources" key="label.IGCIM0301.taskError"/></html:option>
					</html:select>
					&nbsp;&nbsp;	
					<html:submit property="btn_search" styleClass="button">
					<bean:message bundle="asmResources" key="button.IGCIM0301.btn_search"/>
					</html:submit>
					<html:submit property="btn_compare" styleClass="button"
						onclick="return compareEI();">
						<bean:message bundle="asmResources" key="button.IGCIM0301.btn_compare"/>
					</html:submit>
				</div>
			</div>
		</div>
    </div>
    <logic:present name="IGCIM03011VO" property="soc0104Info">
	<div class="title">
		<div class="name"><bean:message bundle="asmResources" key="title.IGCIM0301.AuditTask"/></div>
	</div>
	<div id="results_list">
		<table class="table_style">
			<tr>
				<th width="40%"><bean:message bundle="asmResources" key="label.IGCIM0301.autdesc"/></th>
				<th width="20%"><bean:message bundle="asmResources" key="label.IGCIM0301.autstatus"/></th>
				<th width="20%"><bean:message bundle="asmResources" key="label.IGCIM0301.autcomptime"/></th>
				<th width="20%"><bean:message bundle="asmResources" key="label.IGCIM0301.autupdtime"/></th>
			</tr>
			<tr>
				<td>${IGCIM03011VO.soc0104Info.autdesc}</td>
				<td><ig:codeValue ccid="AUTSTATUS" cid="${IGCIM03011VO.soc0104Info.autstatus}" /></td>
				<td>${IGCIM03011VO.soc0104Info.autcomptime}</td>
				<td>${IGCIM03011VO.soc0104Info.autupdtime}</td>
			</tr>
		</table>
	</div>
	</logic:present>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="5%"><label><input type="checkbox" name="allbox" id="allbox" onclick="selectAll('allbox','auwtids')"/></label></th>
			<th width="20%"><bean:message bundle="asmResources" key="title.IGCIM0301.auwttopci"/></th>
			<th width="10%"><bean:message bundle="asmResources" key="title.IGCIM0301.impTypeid"/></th>
			<th width="35%"><bean:message bundle="asmResources" key="title.IGCIM0301.auwtfilename"/></th>
			<th width="10%"><bean:message bundle="asmResources" key="title.IGCIM0301.auwtstatus"/></th>
			<th width="20%"><bean:message bundle="asmResources" key="title.IGCIM0301.auwtcreatetime"/></th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGCIM03011VO" property="soc0105List">
			<logic:iterate id="bean" name="IGCIM03011VO"
				property="soc0105List" indexId="index">
				<c:if test="${importFlag == '0' && bean.auwtstatus != '1'}"><c:set var="importFlag" value="1"/></c:if>
				<tr class="<ig:rowcss index="${index}"/>">
					<td><html:checkbox property="auwtids" value="${bean.auwtid}" name="IGCIM0301Form" styleId="auwtids"/></td>
					<c:if test="${bean.auwtstatus != '1'}">
						<td><a href="javascript:openAuditWaitTaskDetail('${bean.auwtid}')">${bean.auwttopci}</a></td>
					</c:if>
					<c:if test="${bean.auwtstatus == '1'}">
						<td>${bean.auwttopci}</td>
					</c:if>
					<td>${bean.eiImportProgrammeTB.impTypename}</td>
					<td>${bean.auwtfilename}</td>
					<td><ig:codeValue ccid="AUDITWAITTASK_STATUS" cid="${bean.auwtstatus}" /></td>
					<td>${bean.auwtcreatetime}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<logic:present name="IGCIM03011VO" property="soc0105List">
	<c:if test="${IGCIM0301Form.taskDone == '0' && importFlag == '0'}">
	<bean:define name="IGCIM03011VO" property="soc0104Info" id="auditTaskBean" />
	
	<logic:equal name="auditTaskBean" property="autstatus" value="0">
	<div id="operate">
		<html:submit property="btn_import" styleClass="button"
			onclick="return importEI();">
			<bean:message bundle="asmResources" key="button.IGCIM0301.btn_import"/>
		</html:submit>
		<html:submit property="btn_import" styleClass="button"
			onclick="return deleteTask();">
			<bean:message bundle="asmResources" key="button.IGCIM0301.btn_delete"/>
		</html:submit>
	</div>
	</logic:equal>
	</c:if>
	</logic:present>
	<html:hidden property="autid" value="${IGCIM03011VO.soc0104Info.autid}"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
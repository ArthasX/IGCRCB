<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0803" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0803" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function openEiWaitTaskDetail(eitid){
	 	openSubWindow( '/IGAIM0210_Disp.do?eitid='+ eitid,"eiWaitTask","800","600");
	}
	//获取选中的第几行
	function getNumNo(obj){
		var arr = new Array;
		var count = 0;
		var check=document.getElementsByName(obj);
		if(check != null) {
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					arr[count] = i;
					count++;
				}
			}
		}
		return arr;
	}
	function importEI(){
		
		if(checkNum("eitids") == 0){
			alert('<bean:message bundle="asmResources" key="message.IGCIM0803.001"/>');
	        return false;
		}
		for(var i=0;i<getNumNo("eitids").length;i++){
			var str = getNumNo("eitids")[i];
			var obj = document.getElementById("host_"+str);
			var len = 0;
			for(var j=0;j<getNumNo("eitids").length;j++){
				var str_j = getNumNo("eitids")[j];
				var obj_j = document.getElementById("host_"+str_j);
				if(obj.innerHTML==obj_j.innerHTML){
					len++;
				}
			}
			if(len>1){
				alert('不能导入相同的CI任务！');
				return false;
			}
		}
	    if(window.confirm('<bean:message bundle="asmResources" key="message.IGCIM0803.002"/>')){
	    	//disableAllButton();
	        form.action = getAppRootUrl() + "/IGCIM0803_Import.do";
	        //document.forms[0].submit();
	        return true;
	    } else {
	        return false;
	    }
	}
	
	function deleteTask(){
		if(checkNum("eitids") == 0){
			alert('<bean:message bundle="asmResources" key="message.IGCIM0803.003"/>');
	        return false;
		}
	    if(window.confirm('<bean:message bundle="asmResources" key="message.IGCIM0803.004"/>')){
	    	//disableAllButton();
	        form.action = getAppRootUrl() + "/IGCIM0803_Delete.do";
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
	 function checkUp(){
		 var taskDonesss='0';
		 var check=document.getElementsByName("taskDones");
			if(check != null) {
				for(var i=0;i<check.length;i++){
					if(check[i].checked==true){
						if(taskDonesss=='0')
							taskDonesss = check[i].value;
						else
							taskDonesss=taskDonesss+','+check[i].value;
					}
				}
			}
			document.getElementById("taskDonesss").value=taskDonesss;
	}
	</script>

<body>
<c:set var="importFlag" value="0"/>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGCIM0803_Disp"
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
				           &nbsp;&nbsp;状态：
					<input type="checkbox" name="taskDones" id="taskError" <c:if test="${IGCIM0201Form.taskError}">checked</c:if> value="1"/>
					<bean:message bundle="asmResources" key="label.IGCIM0803.taskError"/>
					<input type="checkbox" name="taskDones" id="taskToDos" <c:if test="${IGCIM0201Form.taskToDos}">checked</c:if> value="2"/>
					<bean:message bundle="asmResources" key="label.IGCIM0803.taskToDo"/>
					<input type="checkbox" name="taskDones" id="taskBeing" <c:if test="${IGCIM0201Form.taskBeing}">checked</c:if> value="3"/>
					<bean:message bundle="asmResources" key="label.IGCIM0803.taskBeing"/>
					<input type="checkbox" name="taskDones" id="taskDones" <c:if test="${IGCIM0201Form.taskDoness}">checked</c:if> value="4"/>
					<bean:message bundle="asmResources" key="label.IGCIM0803.taskDone"/>
					<input type="checkbox" name="taskDones" id="taskAgnore" <c:if test="${IGCIM0201Form.taskAgnore}">checked</c:if> value="5"/>
					<bean:message bundle="asmResources" key="label.IGCIM0803.taskAgnore"/>
					<html:hidden property="status" name="IGCIM0201Form" styleId="taskDonesss"/>
					&nbsp;&nbsp;<br>	
				    <span>采集时间：</span>从<html:text property="impcreatetime_s" readonly="true"/>&nbsp;&nbsp;
	                <img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('impcreatetime_s'))" border="0" />&nbsp;&nbsp;
	                                           到<html:text property="impcreatetime_e" readonly="true"/>&nbsp;&nbsp;
	                <img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="showDate($('impcreatetime_e'))" border="0" />&nbsp;&nbsp;
					&nbsp;&nbsp;
					<html:submit property="btn_search" styleClass="button" onclick="checkUp();">
					<bean:message bundle="asmResources" key="button.IGCIM0803.btn_search"/>
					</html:submit>
				</div>
			</div>
			
		</div>
    </div>
	<div id="results_list"><!--  message <ig:message /> /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="5%"><label><input type="checkbox" name="allbox" id="allbox" onclick="selectAll('allbox','eitids')"/></label></th>
			<th width="20%"><bean:message bundle="asmResources" key="title.IGCIM0803.eittopci"/></th>
			<th width="10%"><bean:message bundle="asmResources" key="title.IGCIM0803.impTypeid"/></th>
			<th width="10%"><bean:message bundle="asmResources" key="title.IGCIM0803.eitstatus"/></th>
			<th width="20%"><bean:message bundle="asmResources" key="title.IGCIM0803.eitcreatetime"/></th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGCIM02011VO" property="cr03InfoList">
			<logic:iterate id="bean" name="IGCIM02011VO"
				property="cr03InfoList" indexId="index">
				<c:if test="${importFlag == '0' && bean.status == '3'}"><c:set var="importFlag" value="1"/></c:if>
				<tr class="<ig:rowcss index="${index}"/>">
					<td><html:checkbox property="eitids" value="${bean.fingerPrint}" name="IGCIM0201Form" styleId="eitids"/></td>
					<td id="host_${index}">${bean.host}</td>
					<td>${bean.soc0113TB.impTypename}</td>
					<td><ig:codeValue ccid="CIWAITTASK_TWO_STATUS" cid="${bean.status}" /></td>
					<td>${bean.showtime}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<logic:present name="IGCIM02011VO" property="cr03InfoList">
	<c:if test="${!IGCIM0201Form.taskBeing}">
	<div id="operate">
		<html:submit property="btn_import" styleClass="button"
			onclick="return importEI();">
			<bean:message bundle="asmResources" key="button.IGCIM0803.btn_import"/>
		</html:submit>
		<html:submit property="btn_import" styleClass="button"
			onclick="return deleteTask();">
			<bean:message bundle="asmResources" key="button.IGCIM0803.btn_delete"/>
		</html:submit>
	</div>
	</c:if>
	</logic:present>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
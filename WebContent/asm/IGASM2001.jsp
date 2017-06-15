<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2001" toScope="request" />
<bean:define id="title" value="控制台画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	function openEiWaitTaskDetail(eitid){
	 	openSubWindow( '/IGASM2010_Disp.do?eitid='+ eitid,"eiWaitTask","800","600");
	}

	function importEI(){
		if(checkNum("eitids") == 0){
			alert("请选择要处理的任务！");
	        return false;
		}
	    if(window.confirm("请确认是否执行导入操作？")){
	    	//disableAllButton();
	        form.action = getAppRootUrl() + "/IGASM2001_Import.do";
	        //document.forms[0].submit();
	        return true;
	    } else {
	        return false;
	    }
	}
	
	function deleteTask(){
		if(checkNum("eitids") == 0){
			alert("请选择要删除的任务！");
	        return false;
		}
	    if(window.confirm("请确认是否执行删除操作？")){
	    	//disableAllButton();
	        form.action = getAppRootUrl() + "/IGASM2001_Delete.do";
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
 			bodyel[0].innerHTML +="<div id=\"disableAllButtonWaitDIV\" class=\"layer\"><div><div><img src=\"images/loding.gif\" /><br />操作执行中，请您不要进行其它操作，耐心等候...<br><br></div></div><iframe src=\"javascript:false\" style=\"position:absolute; visibility:inherit; top:0px; left:0px; width:100%; height:100%; z-index:-2; filter='progid:DXImageTransform.Microsoft.Alpha(style=0,opacity=0)';\"></iframe></div>"

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
<div id="content"><html:form styleId="form" action="/IGASM2001_Disp"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	</div>
	<div id="search">
		<div class="img"></div>
		<div class="conditions">
			<div class="conditions_border1">
				<div>
					<label>状态</label>
					<html:select property="taskDone" name="IGASM2001Form" styleId="taskDone">
						<html:option value="0">待处理</html:option>
						<html:option value="1">已完成</html:option>
						<html:option value="2">异常</html:option>
					</html:select>
					&nbsp;&nbsp;	
					<html:submit property="btn_search" styleClass="button" value="查询"/>
				</div>
			</div>
		</div>
    </div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="5%"><label><input type="checkbox" name="allbox" id="allbox" onclick="selectAll('allbox','eitids')"/></label></th>
			<th width="20%">顶级CI</th>
			<th width="10%">类型</th>
			<th width="35%">源文件名</th>
			<th width="10%">状态</th>
			<th width="20%">任务创建时间</th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGASM20011VO" property="eiWaitTaskList">
			<logic:iterate id="bean" name="IGASM20011VO"
				property="eiWaitTaskList" indexId="index">
				<c:if test="${importFlag == '0' && bean.eitstatus != '1'}"><c:set var="importFlag" value="1"/></c:if>
				<tr class="<ig:rowcss index="${index}"/>">
					<td><html:checkbox property="eitids" value="${bean.eitid}" name="IGASM2001Form" styleId="eitids"/></td>
					<c:if test="${bean.eitstatus != '1'}">
						<td><a href="javascript:openEiWaitTaskDetail('${bean.eitid}')">${bean.eittopci}</a></td>
					</c:if>
					<c:if test="${bean.eitstatus == '1'}">
						<td>${bean.eittopci}</td>
					</c:if>
					<td>${bean.eiImportProgrammeTB.impTypename}</td>
					<td>${bean.eitfilename}</td>
					<td><ig:codeValue ccid="EIWAITTASK_STATUS" cid="${bean.eitstatus}" /></td>
					<td>${bean.eitcreatetime}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<logic:present name="IGASM20011VO" property="eiWaitTaskList">
	<c:if test="${IGASM2001Form.taskDone == '0' && importFlag == '0'}">
	<div id="operate">
		<html:submit property="btn_import" styleClass="button"
			onclick="return importEI();" value="导入"/>
		<html:submit property="btn_import" styleClass="button"
			onclick="return deleteTask();" value="删除"/>
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
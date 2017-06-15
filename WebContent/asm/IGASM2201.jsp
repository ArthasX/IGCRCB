<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2201" toScope="request" />
<bean:define id="title" toScope="request">
	控制台画面
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	function openAuditWaitTaskDetail(ciwtid){
	 	openSubWindow( '/IGASM2203_Disp.do?ciwtid='+ ciwtid,"ciditWaitTask","800","600");
	}

	function importEI(){
		if(checkNum("ciwtids") == 0){
			alert('请选择要处理的任务！');
	        return false;
		}
	    if(window.confirm('请确认是否执行导入操作？')){
	    	//disableAllButton();
	        form.action = getAppRootUrl() + "/IGASM2201_Import.do";
	        //document.forms[0].submit();
	        return true;
	    } else {
	        return false;
	    }
	}

	function compareEI(){
	    if(window.confirm('请确认是否执行对比操作？')){
	        form.action = getAppRootUrl() + "/IGASM2201_Compare.do";
	        return true;
	    } else {
	        return false;
	    }
	}
	
	function deleteTask(){
		if(checkNum("ciwtids") == 0){
			alert('请选择要删除的任务！');
	        return false;
		}
	    if(window.confirm('请确认是否执行删除操作？')){
	    	//disableAllButton();
	        form.action = getAppRootUrl() + "/IGASM2201_Delete.do";
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
<div id="content"><html:form styleId="form" action="/IGASM2201_Disp"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">资产管理 &gt;&gt; CI更新管理 &gt;&gt; 导入控制台</p>
	</div>
	<div id="search">
		<div class="img"></div>
		<div class="conditions">
			<div class="conditions_border1">
				<div>
					<label>状态</label>
					<html:select property="taskDone" name="IGASM2201Form" styleId="taskDone">
						<html:option value="0">待处理</html:option>
						<html:option value="1">已完成</html:option>
						<html:option value="2">异常</html:option>
					</html:select>
					&nbsp;&nbsp;	
					<html:submit property="btn_search" styleClass="button">
					查询
					</html:submit>
					<html:submit property="btn_compare" styleClass="button"
						onclick="return compareEI();">
						对比
					</html:submit>
				</div>
			</div>
		</div>
    </div>
    <logic:present name="IGASM22011VO" property="ciTask">
	<div class="title">
		<div class="name">审计任务信息</div>
	</div>
	<div id="results_list">
		<table class="table_style">
			<tr>
				<th width="40%">审计任务描述</th>
				<th width="20%">状态</th>
				<th width="20%">对比时间</th>
				<th width="20%">更新时间</th>
			</tr>
			<tr>
				<td>${IGASM22011VO.ciTask.citdesc}</td>
				<td><ig:codeValue ccid="CISTATUS" cid="${IGASM22011VO.ciTask.citstatus}" /></td>
				<td>${IGASM22011VO.ciTask.citcomptime}</td>
				<td>${IGASM22011VO.ciTask.citupdtime}</td>
			</tr>
		</table>
	</div>
	</logic:present>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="5%"><label><input type="checkbox" name="allbox" id="allbox" onclick="selectAll('allbox','ciwtids')"/></label></th>
			<th width="20%">顶级CI</th>
			<th width="10%">类型</th>
			<th width="35%">源文件名</th>
			<th width="10%">状态</th>
			<th width="20%">任务创建时间</th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGASM22011VO" property="ciWaitTaskList">
			<logic:iterate id="bean" name="IGASM22011VO"
				property="ciWaitTaskList" indexId="index">
				<c:if test="${importFlag == '0' && bean.ciwtstatus != '1'}"><c:set var="importFlag" value="1"/></c:if>
				<tr class="<ig:rowcss index="${index}"/>">
					<td><html:checkbox property="ciwtids" value="${bean.ciwtid}" name="IGASM2201Form" styleId="ciwtids"/></td>
					<c:if test="${bean.ciwtstatus != '1'}">
						<td><a href="javascript:openciditWaitTaskDetail('${bean.ciwtid}')">${bean.ciwttopci}</a></td>
					</c:if>
					<c:if test="${bean.ciwtstatus == '1'}">
						<td>${bean.ciwttopci}</td>
					</c:if>
					<td>${bean.eiImportProgrammeTB.impTypename}</td>
					<td>${bean.ciwtfilename}</td>
					<td><ig:codeValue ccid="CIWAITTASK_STATUS" cid="${bean.ciwtstatus}" /></td>
					<td>${bean.ciwtcreatetime}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<logic:present name="IGASM22011VO" property="ciWaitTaskList">
	<c:if test="${IGASM2201Form.taskDone == '0' && importFlag == '0'}">
	<div id="operate">
		<html:submit property="btn_import" styleClass="button"
			onclick="return importEI();">
			导入
		</html:submit>
		<html:submit property="btn_import" styleClass="button"
			onclick="return deleteTask();">
			删除
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
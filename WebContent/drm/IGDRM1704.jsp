<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html:html>
<bean:define id="id" value="IGDRM1704" toScope="request" />
	<bean:define id="title" value="培训记录查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>
.table_style tr:HOVER {
	background-color: #acacac;
	cursor: pointer;
}
.ellips{
width:100%; 
white-space:nowrap; 
text-overflow:ellipsis; 
overflow:hidden;
}
</style>
<script type="text/javascript">
//机构选择
function setOrg(url){
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.getElementById("tarorgid").value="";
		document.forms[0].tarorgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.getElementById("tarorgid").value = temp.split("|")[0];
		document.forms[0].tarorgname.value = temp.split("|")[1];
	}	
}
function deleteinfo(trid){
	if(confirm("确认删除培训记录")){
		document.forms[0].action=getAppRootUrl() + "/IGDRM1701_DELETE.do?trid="+trid;
		document.forms[0].submit();
	}
}
function edit(trid){
	document.forms[0].action=getAppRootUrl() + "/IGDRM1702_Disp.do?trid="+trid;
	document.forms[0].submit();
}
function showDetail(trid){
	window.location.href = getAppRootUrl()+"/IGDRM1702_Disp.do?backUrl=1&trid="+trid;
}
</script>
<body onload="">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGDRM1701" styleId="form">
		<html:hidden property="mode"/>
	<div id="location">
	<div class="image"></div>
		<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
		
	</div>
	<div id="search">
		<div class="img"></div>
		<div class="conditions">
			<div>
				<table>
					<tr>
						<td>培训名称：</td>
						<td><html:text property="trname" styleId="trname" /></td>
						<td>开始时间：</td>
						<td><html:text property="trstimeFrom" readonly="true" styleId="trstimeFrom" onclick="showDate(this)"/>
							到：
							<html:text property="trstimeTo" readonly="true"  styleId="trstimeTo" onclick="showDate(this)" />
						</td>
						<td>
							<html:submit styleClass="button">查询</html:submit>
						</td>
					</tr>
					
				</table>
			</div>
		</div>
	</div>
	<div id="results_list">   <ig:message />  
	<table class="table_style">
		<tr>
					<th width="9%">培训名称</th>
					<th width="9%">计划开始时间</th>
					<th width="9%">计划结束时间</th> 	
					<th width="9%">培训内容</th>
					<th width="9%">培训地点</th>
					<th width="9%">讲师</th>
		</tr>
		
		<logic:present name="IGDRM17011VO" property="trainrecordList">
			
			<logic:iterate id="bean" name="IGDRM17011VO" property="trainrecordList" indexId="index">
				<tr onclick="showDetail('${bean.trid}')" class="<ig:rowcss index="${index}"/>">
												<td title="${bean.trname}"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.trname}</div></td>
					<td>${bean.trstime}</td>
					<td>${bean.tretime}</td>
					<td title="${bean.trside}"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.trside}</div></td>
					<td title="${bean.tpcontent}"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.tpcontent}</div></td>
					<td title="${bean.trlecturer}"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.trlecturer}</div></td>
				</tr>
        	</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	</html:form>
</div>
</div>
</div>
<div class="zishiying"></div>
</div>
</body>
</html:html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSDL0401" toScope="request" />
<bean:define id="title" value="信息查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	var gid = "IGSDL0401";
	//删除所选
	function deleteRec(obj){
		var message = '<bean:message key="IGCO10000.E002"/>';
	    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="信息基本信息" />';
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
	    if(window.confirm(confirmMsg)){
	        form.action = getAppRootUrl() + "/IGSDL0401_Del.do";
	        return true;
	    } else {
	        return false;
	    }
	}

	//选择资产
	function selectEntity(){
		openSubIGCOM0302PARAM("?ecategory=SDL");
	}

	function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory) {
	    $("sieiid").value = eiid;
		$("sieiname").value = einame;
	}
	//选择工作
	function openSVCPage(){
		openSubWindow('/IGSVC0107_Disp.do?prtype=I', '_blank','1000','600');
	}

	function setParams(prcorid,prcortype,prcortitle){
		$("siprid").value = prcorid;
	    $("siprtitle").value = prcortitle;
	}
//-->
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGSDL0401"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>类别：</span><html:select property="sitype" errorStyleClass="inputError imeActive">
	<ig:optionsCollection ccid="SERVER_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true" />
	</html:select> 
	<span>&nbsp;&nbsp;相关资产：</span><html:text property="sieiname" size="18" readonly="true" errorStyleClass="inputError imeActive" />
	<img src="images/seek.gif" border="0" width="16" height="16" alt="查询" onclick="selectEntity()" style="cursor: hand" />
	<span>&nbsp;&nbsp;相关事件：</span><html:text property="siprtitle" size="18" readonly="true" errorStyleClass="inputError imeActive" />
	<html:hidden property="siprid"/>
	<img src="images/seek.gif" border="0" width="16" height="16" alt="查询" onclick="openSVCPage()" style="cursor: hand" />&nbsp;&nbsp;
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="3%"><label> <input
				type="checkbox" name="checkbox" id="checkbox"
				onclick="selectAll('checkbox','deleteSdlInfoid')" /></label></th>
			<th width="13%">类别</th>
			<th width="20%">相关资产</th>
			<th width="23%">相关事件</th>
			<th width="12%">开始时间</th>
			<th width="12%">结束时间</th>
			<th width="7%">评分</th>
			<th width="10%">详细信息</th>
			<!--<th width="6%">修改</th>
		--></tr>
		<logic:present name="IGSDL04011VO" property="sdlInfoList">
			<logic:iterate id="bean" name="IGSDL04011VO"
				property="sdlInfoList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><label><html:checkbox
						property="deleteSdlInfoid" value="${bean.siid}" /> </label></td>
					<td><ig:codeValue ccid="SERVER_CATEGORY_CODE" cid="${bean.sitype}" /></td>
					<td>${bean.sieiname}</td>
					<td>${bean.siprtitle}</td>
					<td>${bean.sibegin}</td>
					<td>${bean.siend}</td>
					<td><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${bean.simark}" /></td>
					<td>
						<div align="center"><html:link
							action="/IGSDL0404.do?siid=${bean.siid}">
							<img src="images/look.gif" alt="显示详细信息" width="16" height="16"
								border="0" />
						</html:link></div>
					</td>
					<!--<td><html:link
						action="/IGSDL0402_Edit_Disp.do?siid=${bean.siid}">
						<img src="images/edit.gif" width="16" height="16" border="0" />
					</html:link></td>
				--></tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGSDL04011VO"
		property="sdlInfoList">
		<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button"
			onclick="return deleteRec('deleteSdlInfoid');" /></span>
	</logic:present> <!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
	<html:hidden property="sieiid" styleId="sieiid" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
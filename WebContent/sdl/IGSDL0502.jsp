<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSDL0502" toScope="request" />
<bean:define id="title" value="信息查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	var gid = "IGSDL0502";
	//删除所选
	function deleteRec(obj){
		var message = '<bean:message key="IGCO10000.E002"/>';
	    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="信息基本信息" />';
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
	    if(window.confirm(confirmMsg)){
	        form.action = getAppRootUrl() + "/IGSDL0502_Del.do";
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
		openSubWindow('/IGSVC0107.do?', '_blank','1000','600');
	}

	function setParams(prcorid,prcortype,prcortitle){
		$("siprid").value = prcorid;
	    $("siprtitle").value = prcortitle;
	}
	function openSubIGSDL0503(siid){
		openSubWindow('/IGSDL0502_Detail.do?siid='+siid, '', '800', '600');
	}
//-->
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGSDL0502"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	<div class="back"><a href="IGSDL0501.do" target="_self">返回</a></div>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div><span>类别：</span><html:select property="sitype" onchange="changeDiv(this)" errorStyleClass="inputError imeActive">
		<ig:optionsCollection ccid="SERVER_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true" />
		</html:select>&nbsp;&nbsp;
		<span>月份：</span><html:select property="month">
				<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="true" isCodeLabel="true" />
			</html:select>
			<html:submit property="btn_search" styleClass="button" value="查询" /></div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="9%">类别</th>
			<th width="25%">相关资产</th>
			<th width="25%">相关事件</th>
			<th width="10%">开始时间</th>
			<th width="10%">结束时间</th>
			<th width="6%">评分</th>
		</tr>
		<logic:present name="IGSDL05011VO" property="sdlInfoList">
			<logic:iterate id="bean" name="IGSDL05011VO"
				property="sdlInfoList" indexId="index">
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" 
				onclick="openSubIGSDL0503('${bean.siid}')">
					<td><ig:codeValue ccid="SERVER_CATEGORY_CODE" cid="${bean.sitype}" /></td>
					<td>${bean.sieiname}</td>
					<td>${bean.siprtitle}</td>
					<td>${bean.sibegin}</td>
					<td>${bean.siend}</td>
					<td><ig:codeValue ccid="SERVICE_LEVEL_GRADE" cid="${bean.simark}" /></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter">
<html:button property="button" value="返回" styleClass="button" 
onclick="window.location='IGSDL0501.do'"></html:button>
</div>
	<html:hidden property="sieiid" styleId="sieiid" />
	<html:hidden property="year" styleId="year" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
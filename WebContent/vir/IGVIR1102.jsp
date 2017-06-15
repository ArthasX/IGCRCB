<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGVIR1102" toScope="request" />
<bean:define id="title" value="部门计费 " toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

function setOrg(url){
	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].orgsyscoding_like.value = "";
		document.forms[0].orgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].orgsyscoding_like.value = temp.split("|")[0];
		document.forms[0].orgname.value = temp.split("|")[1];
	}		

}

function particulars(orgcode){
// 	alert(orgcode);
	location.href = "IGVIR1104.do?showType=ctrl&searchType=org&orgsyscoding="+orgcode;
}
</script><body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGVIR1102_SEARCH"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">统计分析 >> 计费统计 >> 部门计费</p>
</div>
	<div id="search" style="width: 98%;float: center;">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>部门名称：</span><html:text property="orgname" readonly="true" name="IGVIR1102Form"/>
		<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" alt="请选择机构"/>
	<html:hidden property="orgsyscoding_like" name="IGVIR1102Form"/>
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list" >
		<ig:message />
		<table class="table_style" style="width: 98%;float: center;">
			<logic:present name="IGVIR11021VO" property="vim03oList">
				<tr>
					<th style="text-align: center;" width="10%">序号</th>
					<th style="text-align: center;" width="60%" >部门名称</th>
					<th style="text-align: center;" width="40%">总费用</th>
				</tr>
				<logic:iterate id="bean" name="IGVIR11021VO"
 					property="vim03oList" indexId="index"> 
					<tr style='cursor:hand' onmouseover="mouseOver(this);" onmouseout="mouseOut(this);"
 					onclick="particulars('${bean.orgsyscoding}');"> 
 						<td>${index+1}</td>
 						<td>${bean.orgname}</td> 
 						<td>${bean.cost}元</td>
					</tr>
				</logic:iterate>
 			</logic:present>
 		</table>
	</div>
	<div id="operate" style="width: 98%;">
	<!-- paging -->
	<jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
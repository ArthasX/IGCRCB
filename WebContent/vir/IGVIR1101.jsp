<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGVIR1101" toScope="request" />
<bean:define id="title" value="人员计费" toScope="request" />
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

function particulars(userid){
	location.href = "IGVIR1104.do?showType=ctrl&searchType=user&userid="+userid;
}
</script><body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGVIR1101_SEARCH"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">统计分析 >> 计费统计 >> 人员计费</p>
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>用户姓名：</span><span><html:text
		property="username_like" styleId="username_q"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="16" name="IGVIR1101Form"/>
	</span>
	<span>&nbsp;&nbsp;所属部门：</span><html:text property="orgname" readonly="true" name="IGVIR1101Form"/>
		<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" alt="请选择机构"/>
	<html:hidden property="orgsyscoding_like" name="IGVIR1101Form"/>
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list">
		<ig:message />
		<table class="table_style">
			<logic:present name="IGVIR11011VO" property="vim03uList">
				<tr>
					<th width="10%">序号</th>
<!-- 					<th width="15%">用户ID</th> -->
					<th width="30%">用户姓名</th>
					<th width="30%">所属部门</th>
					<th width="30%">总费用</th>
				</tr>
				<logic:iterate id="bean" name="IGVIR11011VO"
					property="vim03uList" indexId="index">
					<tr style='cursor:hand' onmouseover="mouseOver(this);" onmouseout="mouseOut(this);"
					onclick="particulars('${bean.userid}');">
						<td>${index+1}</td>
<%-- 						<td>${bean.userid}</td> --%>
						<td>${bean.username}</td>
						<td>${bean.orgname}</td>
						<td>${bean.cost}元</td>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
	</div>
	<div id="operate">
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
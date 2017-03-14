<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGDUT0305" toScope="request" />
<bean:define id="title" value="日常维护查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">


function cfm_up(){
	return true;
}
function cfm_dl(){
	if(confirm('确定执行删除操作?')){
			return true;
	}
	return false;
}
function cfm_dt(){
	if(!checkDateWithTimeShow("odprctime_ge","odprctime_le")){
		 alert("周期开始时间不能晚于结束时间！");
		 return false;
	 }
}
</script>

<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">服务管理 &gt;&gt; 值班管理 &gt;&gt; 日常维护查询</p>
	</div>
<html:form styleId="form" action="/IGDUT0305_Select"
	onsubmit="">
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div> &nbsp;&nbsp;<span>进入时间：从</span>&nbsp;<span><html:text
		property="odprctime_ge" readonly="true"
		errorStyleClass="inputError imeActive" /></span> <img src="images/date.gif"
		align="middle" onClick="showTime($('odprctime_ge'))" border="0" /> <span>&nbsp;&nbsp;到&nbsp;</span><span><html:text
		property="odprctime_le" readonly="true"
		errorStyleClass="inputError imeActive" /></span> <img src="images/date.gif"
		align="middle" onClick="showTime($('odprctime_le'))" border="0" /> <html:submit
		property="btn_search" styleClass="button" value="查询"
		onclick="return cfm_dt()" /></div>
	</div>
	</div>
</html:form>
		<html:form action="IGDUT0305_Delete.do" method="post">
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<!-- header -->

		<tr>
			<th width="2%"><input id="checkbox" name="checkbox" type="checkbox" onclick="selectAll('checkbox','delall')"/></th>
			<th width="5%">来访人员</th>
			<th width="6%">所属单位</th>
			<th width="8%">身份证明</th>
			<th width="5%">操作人</th>
			<th width="5%">批准人</th>
			<th width="6%">录入时间</th>
			<th width="2%">更新</th>
			
		</tr>

		<!-- body部 -->

		<logic:present name="IGDUT03051VO" property="onDutyPersonRecordInfoList">
			<logic:iterate id="bean" name="IGDUT03051VO"
				property="onDutyPersonRecordInfoList" indexId="odprid">
			<tr>
			<td width="2%"><input name="delall" type="checkbox" value="${bean.odprid}"/></td>
			<td width="5%">${bean.odprguest}</td>
			<td width="6%">${bean.odprguestorg}</td>
			<td width="8%">${bean.odprguestidnum}</td>
			<td width="5%">${bean.odpropter}</td>
			<td width="5%">${bean.odpracter}</td>
			<td width="6%">${bean.odprinserttime}</td>
			<td width="2%"><a href="IGDUT0304_ToUpdate.do?odprid=${bean.odprid}" onclick="return cfm_up()"><img alt="修改" src="images\edit.gif" border="0"/></a></td>
			</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><logic:present name="IGDUT03051VO" property="onDutyPersonRecordInfoList">&nbsp;&nbsp;<span><html:submit styleClass="button" onclick="return cfm_dl()">删除</html:submit></span>&nbsp;&nbsp;&nbsp;&nbsp;</logic:present><jsp:include page="/include/paging.jsp" /></div>
		</html:form>

</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
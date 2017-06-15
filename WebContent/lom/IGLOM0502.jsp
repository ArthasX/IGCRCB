<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0502" toScope="request" />
<bean:define id="title" value="成本管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script>
function checkNum(obj){
	if(isNaN(obj.value)){
		alert("请输入数字！");
		obj.value = "";
		return;
	}
}

function checkSearch(){
	if(!checkDateByContent("etime_from","etime_to")){
		alert("开始日期不能晚于结束日期！");
		return false;
	}else{
		return true;
	}

}

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGLOM0502" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 成本管理</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	
	<div>
	<span>采购日期：从</span><span><html:text
		property="etime_from" styleId="etime_from"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('etime_from'))" border="0" style="cursor: hand" />
	</span>
	<span>&nbsp;&nbsp;到</span><span><html:text
		property="etime_to" styleId="etime_to"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('etime_to'))" border="0" style="cursor: hand" /></span>
	<span> <html:submit
		styleClass="button" value="查询" onclick="return checkSearch();"/></span></div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="10%">序号</th>
			<th width="20%">日期</th>
			<th width="20%">采购原料成本</th>
			<th width="20%">酒成本</th>
			<th width="20%">其他成本</th>
			<th width="10%">修改</th>
		</tr>
		<logic:present name="IGLOM05011VO" property="eateryList">
			<logic:iterate id="bean" name="IGLOM05011VO" property="eateryList"
				indexId="index">
				<tr>
					<td>${PagingDTO.viewStartCount+index}</td>
					<td><bean:write name="bean" property="edate" /></td>
					<td><bean:write name="bean" property="estaplecost" /></td>
					<td><bean:write name="bean" property="eflavouringcost" /></td>
					<td><bean:write name="bean" property="eothercost" /></td>
					<td>							
							<html:link action="/IGLOM0502_Edit_Disp.do?eid=${bean.eid}">
								<img src="images/edit.gif" width="16" height="16" border="0"/>
							</html:link>			
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>

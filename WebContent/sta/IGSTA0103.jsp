<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSTA0103" toScope="request" />
<bean:define id="title" value="科技投入统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">

function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory) {
	if(eiid){
		$("facilitator").value = einame+"("+eiid+")";
		$("einame").value = einame;
	}else{
		$("facilitator").value = "";
		$("einame").value = "";
	}
}
function fetchData(esyscoding){
	openSubWindow('/IGSTA0103_FetchData.do?esyscoding='+esyscoding+'&curYear='+$("curYear").value+'&facilitator='+encodeURI(encodeURI($("facilitator").value)), '_blank', '1000', '500');

}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> 
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
<!--sidebar  左菜单--> 
<div id="contentWrap">
<div id="content">
	<html:form action="/IGSTA0103" styleId="form" >
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
	<ig:navigation extname1="${urlable}"/> 
	</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>年度：</span>
	<span>
		<html:select property="curYear" styleId="curYear"  name="IGSTA0103Form" style="width: 80px;" errorStyleClass="inputError" >
             <ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
        </html:select>
	</span>
	<span>投入分类：</span>
	<html:select name="IGSTA0103Form" property="contractType" style="width: 95px;" errorStyleClass="inputError">
		<html:options collection="contractLabel" name="IGSTA0103Form" property="value" labelProperty="label"/>
	</html:select>
	<span>服务商：</span>
	<html:text property="einame" styleId="einame" name="IGSTA0103Form" errorStyleClass="inputError imeDisabled" size="20" readonly="true" />
	<html:hidden property="facilitator" name="IGSTA0103Form"/>
		<img src="images/seek.gif" border="0" width="16" height="16" alt="查询" onclick="openSubIGCOM0302PARAM('?esyscoding=999005');" style="cursor: hand" />
	<span style="padding-left: 10px;"><html:submit styleClass="button" value="查询" /></span>
	</div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="17%">投入分类 </th>
			<th width="17%">当前年度投入(元)</th>
			<th width="18%">上年度投入(元)</th>
			<th width="18%">投入同比(元)</th>
		</tr>
		<logic:present name="IGSTA01031VO" property="contracts">
			<logic:iterate id="bean" name="IGSTA01031VO" property="contracts"
				indexId="index"	>			
				<tr >
					<td><a href="###" onclick="fetchData(${bean.esyscoding});"><bean:write name="bean" property="ename" /></a></td>
					<td><bean:write name="bean" property="currentinvestment" /></td>
					<td><bean:write name="bean" property="lastinvestment" /></td>
					<td><bean:write name="bean" property="diff" /></td>					
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>

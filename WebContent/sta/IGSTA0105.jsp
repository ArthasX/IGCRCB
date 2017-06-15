<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSTA0105" toScope="request" />
<bean:define id="title" value="项目进展统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">

function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory) {
	$("prjOutsourcers").value = einame;
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
	<html:form action="/IGSTA0105" styleId="form" >
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
	<span>项目名称：</span>
	<span>
		<html:text property="prTitle" name="IGSTA0105Form" errorStyleClass="inputError imeActive"/>
	</span>
	<span>项目级别：</span>
	<span>
		<html:select property="prjLevel" styleId="prjLevel"  style="width: 80px;" errorStyleClass="inputError" >
             <ig:ig007Option pdid="01400" pidlabel="项目级别" />
        </html:select>
	</span>
	<span>项目阶段：</span>
		<span>
		<html:text property="prjStage" name="IGSTA0105Form" errorStyleClass="inputError imeActive"/>
		</span>
	<span>外包商：</span>
	<span>
		<html:text property="prjOutsourcers" styleId="prjOutsourcers" name="IGSTA0105Form" errorStyleClass="inputError imeDisabled" size="20" readonly="true" />
		<img src="images/seek.gif" border="0" width="16" height="16" alt="查询" onclick="openSubIGCOM0302PARAM('?esyscoding=999005');" style="cursor: hand" />
	</span>
	</br>
	<span>预计开始时间：</span><span><html:text property="planStartTime_from" readonly="true" style="width: 70px;" /></span>
	<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('planStartTime_from'))" border="0" />&nbsp;&nbsp;&nbsp;
	<span>&nbsp;到</span><span><html:text property="planStartTime_to" readonly="true" style="width: 70px;"/></span>
	<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('planStartTime_to'))" border="0" />&nbsp;&nbsp;&nbsp;
	<span>预计完成时间：</span><span><html:text property="planFinishTime_from" readonly="true" style="width:70px;"/></span>
	<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('planFinishTime_from'))" border="0" />&nbsp;&nbsp;&nbsp;
	<span>&nbsp;到</span><span><html:text property="planFinishTime_to" readonly="true" style="width: 70px;"/></span>
	<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('planFinishTime_to'))" border="0" />&nbsp;&nbsp;&nbsp;
	<span>上报监管机构：</span>
	<span>
		<html:select property="prjReport" styleId="prjReport"  name="IGSTA0105Form" style="width: 50px;" errorStyleClass="inputError" >
             <ig:ig007Option pdid="01400" pidlabel="是否上报监管机构" />
        </html:select>
	</span>
	<span style="padding-left: 10px;"><html:submit styleClass="button" value="查询" /></span>
	</div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="19%">项目名称 </th>
			<th width="9%">项目级别</th>
			<th width="9%">项目类型</th>
			<th width="9%">项目性质</th>
			<th width="9%">预计开始时间</th>
			<th width="9%">预计完成时间</th>
			<th width="9%">项目阶段</th>
			<th width="9%">项目经理</th>
			<th width="9%">外包商</th>
			<th width="9%">上报监管机构</th>
		</tr>
		<logic:present name="IGSTA01051VO" property="projectInfo">
			<logic:iterate id="bean" name="IGSTA01051VO" property="projectInfo"
				indexId="index"	>			
				<tr>
					<td><a href="###" onclick="openRelatedProcess('${bean.prid}','WD');"><bean:write name="bean" property="prTitle" /></a></td>
					<td><bean:write name="bean" property="prjLevel" /></td>
					<td><bean:write name="bean" property="prjCategory" /></td>
					<td><bean:write name="bean" property="prjProperty" /></td>					
					<td><bean:write name="bean" property="planStartTime" /></td>					
					<td><bean:write name="bean" property="planFinishTime" /></td>					
					<td><bean:write name="bean" property="prjStage" /></td>					
					<td><bean:write name="bean" property="prjManager" /></td>					
					<td><bean:write name="bean" property="prjOutsourcers" /></td>					
					<td><bean:write name="bean" property="prjReport" /></td>					
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
     <div id="operate">
                <!-- paging -->
                <jsp:include page="/include/paging.jsp"/>
                <!-- /paging -->
    </div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>

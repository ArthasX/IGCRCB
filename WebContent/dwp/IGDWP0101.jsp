<%@page import="java.util.Date"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDWP0101" toScope="request" />
<bean:define id="title"	value="任务查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function deleteTask(id){
	if(window.confirm("是否确认删除？")){
		form.action = "IGDWP0101_Delete.do?planid=" + id;
		form.submit(); 
	}
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGDWP0101.do" onsubmit="return checkSubmit(this);">
<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	<ig:ProcessBackUrlTag jump="${jump}"/>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions" style="width:900px;">
		<span>时间：从</span>
		<html:text name="IGDWP0101Form" property="startdate_from" styleId="startdate_from" readonly="true"/>
		<img alt="" src="images/date.gif" onclick="showDate($('startdate_from'));" style="cursor: hand;" border="0">
		<span>&nbsp;&nbsp;到&nbsp;&nbsp;</span>
		<html:text name="IGDWP0101Form" property="startdate_to" styleId="startdate_to" readonly="true"/>
		<img alt="" src="images/date.gif" onclick="showDate($('startdate_to'));" style="cursor: hand;" border="0">
		<html:submit value="查询" styleClass="button"/>
	</div>
</div>
<div id="results_list" style="overflow-x:auto;overflow-y: hidden; "><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="6%">序号</th>
			<th width="22%">任务名称</th>
			<th width="30%">任务描述</th>
			<th width="8%">操作员</th>
			<th width="10%">开始时间</th>
			<th width="10%">结束时间</th>
			<th width="8%" colspan="2">操作</th>
		</tr>
		<logic:present name="IGDWP01011VO" property="dayWorkPlanList">
			<logic:iterate id="bean" name="IGDWP01011VO" property="dayWorkPlanList" indexId="index" type="com.deliverik.infogovernor.dwp.model.entity.IGDWP0001TB">
				<tr>
					<td>${index + 1 }</td>
					<td title="${bean.pname }"><ig:SubstringShowEllipsisWriteTag len="16" showEllipsis="true">${bean.pname }</ig:SubstringShowEllipsisWriteTag></td>
					<td title="${bean.pdesc }"><ig:SubstringShowEllipsisWriteTag len="25" showEllipsis="true">${bean.pdesc }</ig:SubstringShowEllipsisWriteTag></td>
					<td>${bean.pusername }</td>
					<td>${bean.startdate }</td>
					<td>${bean.enddate }</td>
					<td>
						<logic:equal name="bean" property="puserid"  value="${LOGIN_USER.userid}">
							<%
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
								boolean f = true;
								if(StringUtils.isNotBlank(bean.getEnddate())){
									Date now = new Date();
									Date old = sdf.parse(bean.getEnddate());
									if(now.getTime()>=old.getTime()){
					      	 			//当前时间大于等于结束时间则不可修改
					      	 			f = false;
					      	 		}
								}else{
									f = false;
								}
								if(f){
									%>
										<a href="IGDWP0107_Disp.do?id=${bean.id }&viewstate=0">
											<img alt="修改" src="images/edit.gif" border="0">
										</a>
									<%
								}else{
									%>
										<a href="IGDWP0107_Disp.do?id=${bean.id }&viewstate=1">
											<img alt="查看" src="images/d1.gif" border="0">
										</a>
									<%
								}
							%>
						</logic:equal>
						<logic:notEqual name="bean" property="puserid"  value="${LOGIN_USER.userid}">
							<img alt="不可修改" src="images/noedit.gif" style="cursor: pointer;">
						</logic:notEqual>
					</td>
					<td>
					 <logic:equal name="bean" property="puserid"  value="${LOGIN_USER.userid}">
				      	<a href="javascript:deleteTask(${bean.id });">
				      		<img alt="删除" src="images/delete.gif" border="0" style="cursor: pointer;">
				      	</a>
				      </logic:equal>
				      
				      <logic:notEqual name="bean" property="puserid"  value="${LOGIN_USER.userid}">
				      	<img alt="不可删除" src="images/nodelete.gif" style="cursor: pointer;">
				      </logic:notEqual>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	<div id="operate">
		<jsp:include page="/include/paging.jsp" />
	</div>
</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
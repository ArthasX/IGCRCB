<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils"%>

<html:html>
<head>
<bean:define id="id" value="IGWKI0101" toScope="request" />
<bean:define id="title" value="工作信息" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<script type="text/javascript">
function onsearch() {
		document.forms[0].action = getAppRootUrl() + "/IGWKI0101_Search.do";
		document.forms[0].submit();
	}


</script>
</head>

<body>


	<div id="maincontent">
		<jsp:include page="/include/header2.jsp" />
	</div>
	
	<div id="container">
		<!--content  右侧内容-->
		<div id="contentWrap">
			<div id="content">
				<html:form styleId="form" action="/IGWKI0101_Search"
					onsubmit="return checkSubmit(this);">
					<div id="search">
						<div class="img"></div>
						<div class="conditions">
							<div>
								<span style="font-size:15px;"><strong>查询条件</strong></span>
							</div>
							<div>
								<span class="subscribe">工作名称：</span>
								<html:text property="workname" styleId="workname"
									errorStyleClass="inputError imeDisabled" size="15"
									maxlength="32" tabindex="1" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class="subscribe">发起人：</span>
								<html:text property="initname" styleId="initname"
									errorStyleClass="inputError imeDisabled" size="15"
									maxlength="32" tabindex="1" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class="subscribe">状态：</span>
								<html:select property="workstatus">
									<html:option value=""></html:option>
									<html:option value="0">未完成</html:option>
									<html:option value="1">已完成</html:option>
								</html:select>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class="subscribe">发起人：</span>
								<html:text property="execname" size="15" styleId="execname" />
								<br /> <span class="subscribe">发起时间：</span>
								<html:text property="startdate_from" styleId="startdate_from"
									errorStyleClass="inputError imeDisabled" size="16"
									readonly="true" style="width:116px;" />
								<img src="images/date.gif" align="middle"
									onclick="calendar($('startdate_from'))" border="0"
									style="cursor: hand" /> <span>&nbsp;--&nbsp;</span>
								<html:text property="startdate_to" styleId="startdate_to"
									errorStyleClass="inputError imeDisabled" size="16"
									readonly="true" style="width:116px;" />
								<img src="images/date.gif" align="middle"
									onclick="calendar($('startdate_to'))" border="0"
									style="cursor: hand" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<span class="subscribe">工作周期：</span>
								<html:select property="workperiod">
									<html:option value=""></html:option>
									<%--        	<html:option value="once">立即发起</html:option> --%>
									<html:option value="day">每日</html:option>
									<html:option value="week">每周</html:option>
									<html:option value="month">每月</html:option>
									<html:option value="quarter">每季度</html:option>
									<html:option value="halfyear">每半年</html:option>
									<html:option value="year">每年</html:option>
								</html:select>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<html:submit property="btn_search" styleClass="button"
									value="查询" onclick="onsearch()" />
								&nbsp;&nbsp;&nbsp;&nbsp;
								<html:button property="btn_search" styleClass="button"
									value="导出" onclick="exportExcel()" />
							</div>
						</div>
					</div>



					<div id="result_list">
						<ig:message />
						<table class="table_style">
							<tr>
								<th width="16%">工作名称</th>
								<th width="8%">工作周期</th>
								<th width="8%">发起人</th>
								<th width="8%">执行人</th>
								<th width="10%">发起时间</th>
								<th width="10%">预计完成时间</th>
								<th width="10%">实际完成时间</th>
								<th width="10%">备注</th>
								<th width="10%">状态</th>
								<th width="10%">操作</th>
							</tr>
							<logic:present name="IGWKI01011VO" property="wkiList">
								<logic:iterate id="bean" name="IGWKI01011VO" property="wkiList"
									indexId="index">
									<tr class="<ig:rowcss index="${index}"/>">
										<td title="${bean.workname}"><ig:SubstringShowEllipsisWriteTag
												len="10" showEllipsis="true">
							${bean.workname}	
							</ig:SubstringShowEllipsisWriteTag></td>
										<td title="${bean.workperiod}"><ig:SubstringShowEllipsisWriteTag
												len="10" showEllipsis="true">
							${bean.workperiod}	
							</ig:SubstringShowEllipsisWriteTag></td>
										<td title="${bean.initname}"><ig:SubstringShowEllipsisWriteTag
												len="10" showEllipsis="true">
							${bean.initname}
							</ig:SubstringShowEllipsisWriteTag></td>
										<td title="${bean.execname}"><ig:SubstringShowEllipsisWriteTag
												len="10" showEllipsis="true">
							${bean.execname}
							</ig:SubstringShowEllipsisWriteTag></td>
										<td title="${bean.startdate}"><ig:SubstringShowEllipsisWriteTag
												len="10" showEllipsis="true">
							${bean.startdate}
							</ig:SubstringShowEllipsisWriteTag></td>
										<td title="${bean.estFinDate}"><ig:SubstringShowEllipsisWriteTag
												len="10" showEllipsis="true">
							${bean.estFinDate}
							</ig:SubstringShowEllipsisWriteTag></td>
										<td title="${bean.actFinDate}"><ig:SubstringShowEllipsisWriteTag
												len="10" showEllipsis="true">
							${bean.actFinDate}
							</ig:SubstringShowEllipsisWriteTag></td>
										<td title="${bean.remark}"><ig:SubstringShowEllipsisWriteTag
												len="10" showEllipsis="true">
							${bean.remark}
							</ig:SubstringShowEllipsisWriteTag></td>

										<td>
											<!-- 状态 --> <c:if test="${bean.workstatus=='0' }">未完成</c:if>
											<c:if test="${bean.workstatus=='1'}">已完成</c:if>
										</td>

										<td><logic:equal name="bean" property="workstatus"
												value="0">
												<a
													onclick="return check('/IGWKI0101_Finish.do?workinfoid=${bean.workinfoid}','是否完成？');"
													style="cursor: pointer;">完成</a>
											</logic:equal> <logic:equal name="bean" property="workstatus" value="0">
												<html:link
													action="/IGWKI0101_Edit.do?workinfoid=${bean.workinfoid}">修改</html:link>
											</logic:equal> <c:if test="${bean.workinfoid=='0'}">
												<a
													onclick="return check('/IGWKI0101_Remind.do?workinfoid=${bean.workinfoid}','是否不再提醒？');"
													style="cursor: pointer;">不再提醒</a>
											</c:if></td>
									</tr>
								</logic:iterate>
							</logic:present>
						</table>

					</div>
					<div id="operate">
						<!-- paging -->
						<jsp:include page="/include/paging.jsp" />
					</div>

				</html:form>
			</div>
		</div>
	</div>

</body>
</html:html>

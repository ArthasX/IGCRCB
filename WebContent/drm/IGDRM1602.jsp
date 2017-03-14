<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.drm.vo.IGDRM16021VO"%>
<html:html>
<bean:define id="id" value="IGDRM1602" toScope="request" />
<bean:define id="title" value="事件查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<style>
	.ellips{
width:100%; 
white-space:nowrap; 
text-overflow:ellipsis; 
overflow:hidden;
}
</style>

<!-- /header1 -->
<script type="text/javascript">	
    var delAttachList = "1";
<!--
	

//条件查询
function searchFunction(){
	 form.action = getAppRootUrl() + "/IGDRM1602_Disp.do";
	
	return true;
}
function deleteinfo(trid){
	if(confirm("确认删除培训记录")){
		
		document.forms[0].action=getAppRootUrl() + "/IGDRM1602_Del.do?eventId="+trid;
		document.forms[0].submit();
	}
		(window.event)&&(window.event.cancelBubble=true); 
}
//-->
WebCalendar.timeShow   = true;          //是否返回时间
	</script>
<body>
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />
		<!--container 左菜单 右侧内容-->
		<div id="container">
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<html:form styleId="form" action="/IGDRM1602_Del"
						onsubmit="return checkSubmit(this);">
						<div id="location">
							<div class="image"></div>
							<p class="fonts1">
								<%-- <ig:navigation extname1="${urlable}" /> --%>
								应急管理 >> 总体预案管理 >> 事件级别查询
							</p>
						</div>

						<div id="search">
							<div class="img"></div>
							<div class="conditions">
								<div>
									<span>事件等级名称：</span> <span> <html:text
											property="seventName" styleId="eventName"
											errorStyleClass="inputError imeDisabled" size="15"
											maxlength="32" tabindex="1" />
									</span>
									&nbsp;&nbsp;&nbsp;
										<span>事件描述：</span> 
										<span>
											<html:text
												property="seventDes" styleId="eventDes"
												errorStyleClass="inputError imeDisabled" size="15"
												maxlength="32" tabindex="1" />
										</span> <span> <html:submit property="btn_search"
												styleClass="button" value="查询"
												onclick="return searchFunction();" />
										</span>
								</div>
							</div>
						</div>
						<div id="results_list">
							<ig:message />
							<table class="table_style" id="table1">
								<tr>
									<th width="2%"></th>
									<th width="28%">事件等级名称</th>
									<th width="50%">事件描述</th>
									<th width="10%">影响范围</th>
									<th width="5%">修改</th>
									<th width="5%">刪除</th>

								</tr>
								<logic:present name="IGDRM16021VO" property="eventssInfoList">
									<logic:iterate id="bean" name="IGDRM16021VO"
										property="eventssInfoList" indexId="index">
										<tr class="<ig:rowcss index="${index}"/>">
											<td align="left"></td>
											<td align="left">${bean.eventname}</td>
											<td align="left" title="${bean.eventdes}"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.eventdes}</div></td>
											<td align="center">
											
											<html:link action="/IGDRM1604_Toedit.do?upEventid=${bean.eventid}">
											&nbsp;<img alt="影响范围" src="images/igsvc0109.gif" width="16" height="16"
														border="0" >
											</html:link>
											</td>
											<td><html:link
													action="/IGDRM1603_Toedit.do?upEventid=${bean.eventid}">
													<img src="images/edit.gif" width="16" height="16"
														border="0" />
												</html:link></td>
											<td>
												<a href="javascript:void(0);" onclick="deleteinfo('${bean.eventid}')">
														<img src="images/delete_16x16.gif" width="16" height="16" border="0" />
												</a>
											</td>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
						</div>
						<div id="operate">
							<logic:present name="IGDRM16021VO" property="eventssInfoList">

							</logic:present>
							<!-- paging -->
							<jsp:include page="/include/paging.jsp" />
						</div>
					</html:form>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>
	</div>
</body>
</html:html>
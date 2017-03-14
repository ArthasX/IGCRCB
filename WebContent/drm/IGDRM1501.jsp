<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.drm.vo.IGDRM15011VO"%>
<html:html>
<bean:define id="id" value="IGDRM1501" toScope="request" />
<bean:define id="title" value="培训计划查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<style>
.table_style tr:HOVER {
	background-color: #acacac;
	cursor: pointer;
}
</style>
<!-- /header1 -->
<script type="text/javascript">	
    var delAttachList = "1";
<!--
function showDetail(tpid){
	window.location.href = getAppRootUrl()+"/IGDRM1502_Disp.do?backUrl=1&tpid="+tpid;
}

//条件查询
function searchFunction(){
	 form.action = getAppRootUrl() + "/IGDRM1501_Disp.do";
	
	return true;
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
					<html:form styleId="form" action="/IGDRM1501_Search"
						onsubmit="return checkSubmit(this);">
						<div id="location">
							<div class="image"></div>
							<p class="fonts1">
								<ig:navigation extname1="${urlable}" />
							</p>
						</div>

						<div id="search">
							<div class="img"></div>
							<div class="conditions">
							
							         <span>创建时间：</span> 
							         <span> <html:text name="IGDRM1501Form" property="startTimeBegin" styleId="startTimeBegin" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
												<img src="images/date.gif" align="middle" onclick="calendar($('startTimeBegin'))" border="0" style="cursor: hand;"/>
												<span>&nbsp;&nbsp;<font style="font-weight: bold;">到</font></span>
												<html:text name="IGDRM1501Form" property="startTimeEnd" styleId="startTimeEnd" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
												<img src="images/date.gif" align="middle" onclick="calendar($('startTimeEnd'))" border="0" style="cursor: hand;"/>
									</span>
							         <span>创建人：</span> 
							         <span> <html:text
											property="tpusername" styleId="tpusername"
											errorStyleClass="inputError imeDisabled" size="15"
											maxlength="32" tabindex="1" />
									</span>
									<span>创建部门：</span> 
							         <span> <html:text
											property="tporgname" styleId="tporgname"
											errorStyleClass="inputError imeDisabled" size="15"
											maxlength="32" tabindex="1" />
									</span>
									
									
									<span> <html:submit property="btn_search"
												styleClass="button" value="查询" />
										</span>
							
							</div>
						</div>
						<div id="results_list">
							<ig:message />
							<table class="table_style" id="table1">
								<tr>
									<th width="2%"></th>
									<th width="13%" align="left">培训计划名称</th>
									<th width="13%" align="left">发起部门</th>
									<th width="9%" align="left">发起人</th>
									<th width="9%" align="left">发起时间</th>
									
									

								</tr>
								<logic:present name="IGDRM15011VO" property="trainplanInfoList">
									<logic:iterate id="bean" name="IGDRM15011VO"
										property="trainplanInfoList" indexId="index">
										<tr onclick="showDetail('${bean.tpid}')" class="<ig:rowcss index="${index}"/>">
											<td align="left"></td>
											<td align="left">${bean.tpname}</td>
											<td align="left">${bean.tporgname}</td>
											<td align="left">${bean.tpusername}</td>
											<td align="left">${bean.tptime}</td>
											

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
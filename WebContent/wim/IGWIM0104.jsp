<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGWIM0104" toScope="request" />
<bean:define id="title" value="工作项查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	

//工作项查看
function modifyWD(wdid){
	window.location.href="IGWIM0101_Detail.do?wdid="+wdid+"&mode=1";
}

//校验开始日期是否大于结束日期
function ckRange(){
	var start = jQuery("#beginDateStart").val();
	var over = jQuery("#beginDateOver").val();
	if(start && over){
		if(start>over){
			alert("开始日期不能晚于结束日期，请重新选择！");
			jQuery("#beginDateStart").val("");
			jQuery("#beginDateOver").val("");
			return;
		}
	}
}

</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<style type="text/css">
.rlcomment{cursor: hand;}
#rlshowvaluediv{
	word-wrap:break-word;
	position:absolute;
	z-index: 9999;
	width: 400px;
	min-height: 50px;
	background-color: #eee;
	border:1px solid #ccc;
}
#rlshowvaluediv #title{
	width:395px;
	height:23px;
	line-height:23px;
	font-weight: bold;
	background:url(images/title-23.gif);
	padding-left:5px;
}
#rlshowvaluediv #title #fountDiv{
	width:100px;
	height:23px;
	float: left;
}
#rlshowvaluediv #title #imgDiv{
	width:30px;
	height:23px;
	float: right;
	padding-top:3px;
	cursor: hand;
}
#rlshowvaluediv #content{
	width:395px;
	padding:5px;
	line-height: 20px;
}
</style>
<body>
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />
		<!--container 左菜单 右侧内容-->
		<div id="container">

			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<html:form styleId="form" action="/IGWIM0102_Search"
						onsubmit="return checkSubmit(this);">
						<div id="location">
							<div class="image"></div>
							<p class="fonts1">
								工作管理 &gt;&gt; 工作项管理 &gt;&gt; 工作项查询
							</p>
						</div>
						<div id="search">
							<div class="img"></div>
							<div class="conditions">
								<div>
									<span style="font-size: 15px;"><strong>查询条件</strong></span>

								</div>
								<div style="margin-top: 4px">
									<span class="subscribe">工作项名称：</span>
									<html:text property="wdname" styleId="wdname" />
									
									<!-- 普通用户不可以操作发起人 -->
									<c:if test="${IGWIM0102Form.isNormalUser=='1' }">
										<span class="subscribe">发起人 ：</span>
										<input type="text" readonly="readonly" value="${IGWIM0102Form.initiatorId }">
									</c:if>
									<!-- 中心负责人以上可以操作发起人 -->
									<c:if test="${IGWIM0102Form.isNormalUser!='1' }">
										<span class="subscribe">发起人 ：</span>
										<html:text property="initiatorId" styleId="initiatorId" />
									</c:if>
									
									<span class="subscribe">负责人 ：</span>
									<html:text property="leaderName" styleId="leaderName" />
							    	<!-- 查询按钮 -->
									<html:submit property="btn_search" style="margin-left:5px" styleClass="button" value="查询" />
							    	<br/><span class="subscribe">启用状态 ：</span>
									<html:select property="wdstatus" style="width: 105px;" styleId="wdstatus">
							    		<html:option value=""></html:option>
							    		<html:option value="0">未启用</html:option>
							    		<html:option value="1">已启用</html:option>
							    	</html:select>	
							    	<span class="subscribe">开始日期从 ：</span>
							    	<html:text property="beginDateStart" onchange="ckRange()" styleId="beginDateStart" errorStyleClass="inputError imeDisabled" size="20" readonly="true"/>
									<img src="images/date.gif" align="middle" onclick="calendar(document.forms[0].beginDateStart)" border="0" style="cursor: hand" />
									
							    	<span class="subscribe">到 ：</span>
							    	<html:text property="beginDateOver" onchange="ckRange()" styleId="beginDateOver" errorStyleClass="inputError imeDisabled" size="20" readonly="true"/>
									<img src="images/date.gif" align="middle" onclick="calendar(document.forms[0].beginDateOver)" border="0" style="cursor: hand" />
									
									
								</div>
							</div>
						</div>

						<div id="results_list">
							<ig:message />
							<table class="table_style">
								<!-- header部 -->

								<tr>
									<th width="15%">工作项名称</th>
									<th width="10%">周期</th>
									<th width="10%">开始日期</th>
									<th width="10%">负责人</th>
									<th width="13%">执行人</th>
									<th width="10%">启用状态</th>
									<th width="10%">预计完成时间</th>
									<th width="10%">发起人</th>
								</tr>

								<logic:present name="IGWIM01012VO" property="definitionInfos">
									<logic:iterate id="bean" name="IGWIM01012VO"
										property="definitionInfos" indexId="index">
										<tr onclick="modifyWD('${bean.wdid}')" class="<ig:rowcss index="${index}"/>" style="cursor: pointer;">
											<!-- 工作项名称 -->
											<td>
												${bean.wdname }
											</td>
											<!-- 周期 -->
											<td>
												<c:if test="${bean.cycle=='day' }">
													日
												</c:if>
												<c:if test="${bean.cycle=='week' }">
													周
												</c:if>
												<c:if test="${bean.cycle=='month' }">
													月
												</c:if>
												<c:if test="${bean.cycle=='quarter' }">
													季度
												</c:if>
												<c:if test="${bean.cycle=='halfyear' }">
													半年
												</c:if>
												<c:if test="${bean.cycle=='year' }">
													年
												</c:if>
											</td>
											<!-- 开始日期 -->
											<td>
												<c:out value="${fn:substring(bean.beginDate, 0, 10)}"/>
											</td>
											<!-- 负责人 -->
											<td>
												${bean.leaderName}
											</td>
											<!-- 执行人 -->
											<td>
												${bean.excutorName }
											</td>
											<!-- 启用状态 -->
											<td>
												<c:if test="${bean.wdstatus == 1}">
													已启用
												</c:if>	
												<c:if test="${bean.wdstatus != 1}">
													已停用
												</c:if>	
											</td>
											<!-- 预计完成时间 -->
											<td>
												${bean.estimateFinishDate }
											</td>
											<!-- 发起人 -->
											<td>
												${bean.initiatorId }
											</td>
										</tr>

									</logic:iterate>
								</logic:present>
							</table>
						</div>
						<div id="operate">
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGDRM04021" toScope="request"/>
<bean:define id="title" value="应急资源查看画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<link type="text/css" rel="stylesheet"	href="<html:rewrite forward='tree.css'/>">
<script src="<html:rewrite forward='tree.js'/>"></script>
<style type="text/css">
.conditions a img{
	border: 0px;
}
.conditions .hover{
	background-color: #d3d3d3;
	cursor: pointer;
}
.conditions .leftd{
	text-align: left;
}
.conditions .delFlag{
	display: none;
}
.conditions .titBox{
	background-color: #FFB1BB;
	font-size: 14px; 
	font-weight: bold;
	color:#fff;
	border-bottom: 1px solid #BB0500;
	line-height: 30px;
	height: 30px;
	text-indent: 10px;
}
.conditions a{
	text-decoration: none;
	color: #f00;
}
.conditions a:HOVER{
	text-decoration: none;
}
.conditions a:VISITED {
	color:#f00;
}
.ellips{
	width:100%; 
	white-space:nowrap; 
	text-overflow:ellipsis; 
	overflow:hidden;
}
</style>
<!-- /header1 -->
<script type="text/javascript">
WebCalendar.yearFall   = 50;           //定义年下拉框的年差值
WebCalendar.format     = "yyyy/mm/dd"; //回传日期的格式
WebCalendar.timeShow   = false;        //是否返回时间
WebCalendar.drag       = true;         //是否允许拖动
WebCalendar.darkColor  = "#014DB4";    //控件的暗色
WebCalendar.lightColor = "#FFFFFF";    //控件的亮色
WebCalendar.btnBgColor = "#FFFFF5";    //控件的按钮背景色
WebCalendar.wordColor  = "#000080";    //控件的文字颜色
WebCalendar.wordDark   = "#DCDCDC";    //控件的暗文字颜色
WebCalendar.dayBgColor = "#E6E6FA";    //日期数字背景色
WebCalendar.todayColor = "#FF0000";    //今天在日历上的标示背景色
WebCalendar.DarkBorder = "#D4D0C8";    //日期显示的立体表达色



function checkForm(){
	if($F('eiorgname').trim()=="") {
		alert("请选择所属机构！");
			return false;
	} else {
		return true;
	}
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container" style="width:730px;">
	<!--content  右侧内容-->
	<div id="contentWrap">
			<html:form styleId="form" action="/IGDRM0402_Search" onsubmit="">			
<!-- <div id="content"  style="width:730px;float:left; border:1px solid #BB0500; margin-left: 10px;padding-top: 10px;"> -->
			<div id="search" >
				<div class="img"></div>
				<div class="conditions">
					<div>
						<label>应急资源名称：</label>
						<html:text property="einame" styleId="einame" style="width:110px;"  errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp;
						<label>负责人：</label><html:text property="eiusername" styleId="eiusername" style="width:110px;" errorStyleClass="inputError imeDisabled" size="10" />
						<br><span>时间：从</span><html:text property="propentime" styleId="propentime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
						<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))" border="0" style="cursor: hand" />
						<span>&nbsp;&nbsp;到</span><html:text property="prclosetime" styleId="prclosetime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
						<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" />
							
						<html:hidden property="eistatus" value="1"/>
						<html:submit property="btn_search" value="查询" styleClass="button" onclick=""/>
					</div>
				</div>
			</div>
			
			<div id="results_list">
				<!--  message -->
				<ig:message/>
				<!--  /message -->
				<table width="100%" class="table_style">
					<!-- header部 -->
					<tr>
						<th width="3%">
							<label>
<!-- 								<input type="checkbox" class="delFlag" name="allbox" id="allbox" onclick="selectAll('allbox','deleteEiid')"/> -->
							</label>
						</th>
<!-- 						<th width="20%">应急资产编号</th> -->
						<th style="text-align: left;padding-left: 60px;width: 30%">应急资源名称</th>
						<th width="15%">应急资源模型</th>
<!-- 						<th width="11%">资产模型</th> -->
						<th width="12%">负责人</th>
						<th width="15%">登记日期</th>
<!-- 						<th width="10%">历史版本</th> -->
<!-- 						<th width="8%">修订</th> -->
<!-- 						<th width="10%">历史版本</th> -->
<!-- 						<th width="8%">修订</th> -->
					</tr>
					<!-- body部 -->
					<logic:present name="IGDRM04021VO" property="entityVWItemList" >
						<logic:iterate id="bean" name="IGDRM04021VO" property="entityVWItemList" indexId="index">
							<tr class="<ig:rowcss index="${index}"/>">
								<td>
<%-- 									<html:checkbox property="deleteEiid" styleClass="delFlag" value="${bean.id}_${bean.eiid}_${bean.fingerPrint.split('_')[0]}"/> --%>
								<td>
									<div class="nowrapDiv" style="text-align: left;">
										<logic:empty name="bean" property="einame">&nbsp;</logic:empty>
									<div style="padding-left:20px; width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">
										${bean.einame}
									</div>
									</div>
								</td>
								<td>
								${fn:split(bean.fingerPrint,"_")[1]}
								</td>
<!-- 								<td> -->
<%-- 								<ig:GetMOdelNameByEiid eiid="${bean.eiid}" id="${bean.id}"/> --%>
<!-- 								</td> -->
								<!-- 说明 -->
								<!-- 管理人-->
								<td>
									<div class="nowrapDiv">
										<logic:empty name="bean" property="eiusername">&nbsp;</logic:empty>
										${bean.eiusername}
									</div>
								</td>
								<!-- 登记日期 -->
								<td>
									<div class="nowrapDiv">
										<logic:empty name="bean" property="eiinsdate">&nbsp;</logic:empty>
										${bean.eiinsdate}
									</div>
								</td>
										
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
<%-- 			<html:hidden property="ecategory" styleId="ecategory" value="${IGASM0501Form.ecategory}"/> --%>
				<input type="hidden" name="ercode" id="ercode" value="${IGDRM0402Form.ercode}"/>
				<input type="hidden" name="erid" id="erid"/>
			</div>
		</html:form>
	</div>
</div>

<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
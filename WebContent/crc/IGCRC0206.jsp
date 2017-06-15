<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGCRC0206" toScope="request" />
<bean:define id="title" value="详细告警信息" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
.ellips {
	width: 100%;
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
}
.noBorder{
	border:0px;
}
/*生成事件单按钮样式*/
.button1{
	background-image: url(images/chxun.gif);
	width:70px;
	height:24px;
	margin-left:1px;
	border:0px;
	cursor:pointer;
	color:#fff;
	font-weight: bold;
}
.subscribe{
	background-color:url(images/sub_bg.gif) 0 0 no-repeat; 
	width:84px;
	font:12px "Trebuchet MS",Arial, Helvetica, sans-serif;
	background-color:#EEEEEE;
	color:#000000;
	text-align:right;
	text-transform:uppercase;
	text-decoration:none;
	padding-top:2px;
	display:inline-block;
	padding-bottom:1px;
	margin-left:2px;
	line-height:18px;
	height:18px;
	vertical-align:middle;
	position: relative;
	top: -2px;
}

input {
width:100px;
margin-left:1px;
border:1px solid #ccc;
}
#checkbox{
width:30px;
margin-left:1px;
border:1px none #ccc;
}
</style>
<script type="text/javascript">
	function checkForm() {
		var startDate = $("startDate").value;
		var endDate = $("endDate").value;

		if ((startDate != null && startDate != '')
				&& (endDate != null && endDate != '')) {
			if (startDate > endDate) {
				alert("开始时间不能大于结束时间");
				return false;
			}
		}

		return true;
	}
	/*
	功能：跳转到事件发起页面，将复选框中选中的行信息初始化到表格式表单
	参数：
	 */
	function beenIncident() {

		pk = "";//记录选中主键
		var check = document.getElementsByName("alarmId");
		var count = 0;//记录复选框被选中个数
		if (check != null && check.length > 0) {
			for (var i = 0; i < check.length; i++) {
				if (check[i].checked) {
					count++;
				}
			}
		}
		if (count > 0) {
			for (var i = 0; i < check.length; i++) {
				if (check[i].checked == true) {
					pk = pk + "," + check[i].value;
				}
			}
			pk = pk.substring(1, pk.length);
			location.href = 'IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01080&ptid=8&actname=ACT02SVC0202&parameters='+ pk;
		} else {
			window.alert("请选择告警信息");
			return false;
		}
	}
	//修改
	function checkitem(pkId){
		alert(pkId);
		//openSubWindow('IGCRC0203_Edit_SUB.do?pk='+pedeventid, '_blank','900','650');
		//window.location.href="IGCRC0203_Edit_SUB.do?pk="+pkId;
	}
	//删除
	function toDel(pkId){
		if (confirm("确认要删除？")) {
			window.location.href="IGCRC0203_Delete.do?pk="+pkId;
		}
	}
	
	//记录告警id
	var savePkId = "";
	//关联工单按钮
	function relevance(pkId){
		savePkId = pkId;
		openSubWindow('/IGCRC0203_SEARCH.do?prpdid=0108002', '_blank','1000','600');
	}
	//关联工单赋值
	function setParams(prcorid, prserialnum, prcortitle){
		window.location.href="IGCRC0203_RELEVANCE.do?prcorid="+prcorid+"&pk="+savePkId+"&pedeventid="+prserialnum;
	}
	function openProcessByPrserialnum(prserialnum){
		openSubWindow('/IGPRR0112_Disp.do?prserialnum='+prserialnum, '_blank','900','650');
	}
	function alarmInformation(prserialnum){
		openSubWindow('/IGPRR0112_Disp.do?prserialnum='+prserialnum, '_blank','900','650');
	}
</script>

<body>
	<div id="maincontent">
		<div id="container">
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<html:form styleId="form" action="/IGCRC0203_Alarm"
						onsubmit="return checkSubmit(this);">
						<div id="location">
							<div class="image"></div>
							<p class="fonts1">告警管理 &gt;&gt; 告警管理查询 &gt;&gt; 详细告警信息</p>
						</div>
						<!-- 接收人员部门、接收人员 -->
						<div id="search">
							<div class="img"></div>
							<div class="conditions">
								<div>
									<span style="font-size:15px;"><strong>查询条件</strong></span>
								</div>
								<div style="margin-top:4px">
									<span class="subscribe">&nbsp;&nbsp;起始时间：</span>
									<html:text property="startDate" name="IGCRC0203Form"
										styleId="startDate" errorStyleClass="inputError imeDisabled"
										size="16" readonly="true" />
									<img src="images/date.gif" align="middle"
										onclick="calendar($('startDate'))" border="0"
										style="cursor: hand" /> <span class="subscribe">结束时间：</span>
									<html:text property="endDate" name="IGCRC0203Form"
										styleId="endDate" errorStyleClass="inputError imeDisabled"
										size="16" readonly="true" />
									<img src="images/date.gif" align="middle"
										onclick="calendar($('endDate'))" border="0"
										style="cursor: hand" /> <span class="subscribe">主机名称：</span>
									<html:text property="appname" name="IGCRC0203Form" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<html:hidden property="pedeventid" value="${IGCRC0203Form.pedeventid }"/>
								</div>
								<div style="margin-top:12px">
									<span class="subscribe">事件内容：</span>
									<html:text property="summary" name="IGCRC0203Form" />
									<span class="subscribe">状态：</span>
									<html:select
										name="IGCRC0203Form" styleId="status" property="status"
										style="width: 65px;" errorStyleClass="inputError">
										<html:option value=""></html:option>
										<html:option value="0">告警</html:option>
										<html:option value="1">恢复</html:option>
										<html:option value="2">关闭</html:option>
									</html:select>
									<html:submit property="btn_search"
											styleClass="button" value="查询" onclick="return checkForm();" />
								</div>
							</div>
						</div>
						<ig:message />
						<div id="results_list">
							<table class="table_style" style="width:auto">
								<tr>
									<th width="7%">事件单编号</th>
									<th width="8%">工单名称</th>
									<th width="4%">告警序号</th>
									<th width="9%">主机名称</th>
									<th width="8%">IP地址</th>
									<th width="14%">事件内容</th>
									<th width="6%">故障联系人</th>
									<th width="6%">触发时间</th>
									<th width="8%">恢复时间</th>
									<th width="4%">是否生成工单</th>
									<th width="5%">状态</th>
									<th width="6%">描述</th>
								</tr>
								<logic:present name="IGCRC0203VO" property="igalarmInfos">
									<logic:iterate id="info" name="IGCRC0203VO"
										property="igalarmInfos" indexId="index">
										<tr>
										<td>
											<a href="javascript:void(0);" onclick="openProcessByPrserialnum('${info.pedeventid}');">
												${info.pedeventid}
											</a>
										</td>
										<td title="<ig:prtitle prid="${info.pedeventid}"/>"><ig:prtitle prid="${info.pedeventid}"  /></td>
										<%-- <td><a href="javascript:void(0)" onclick="checkitem('${info.pk}')">${info.serial}</a></td> --%>
										<td><a href="IGCRC0203_Edit_SUB.do?pk=${info.pk}&pedeventid=${info.pedeventid}" >${info.serial}</a></td>
										<td>${info.appname }</td>
										<td >${info.ipaddr }</td>
										<td title="${info.summary}">${fn:substring(info.summary,0,40)}${fn:length(info.summary)>40?'...':''}</td>
										<td>${info.faultContact}</td>
										<td>${info.lasttime }</td>
										<td>${info.recoveryTime }</td>
										<td>${info.isCreateOrder == 1?'是':'否' }</td>
										<td>
											<c:if test="${info.status==0}">告警</c:if>
											<c:if test="${info.status==1}">恢复</c:if>
											<c:if test="${info.status==2}">关闭</c:if>
										</td>
										<td title="${info.description}">${fn:substring(info.description,0,19)}${fn:length(info.description)>19?'...':''}</td>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
						</div>
					</html:form>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>


	</div>
</body>
</html:html>
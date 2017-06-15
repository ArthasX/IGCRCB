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
<bean:define id="id" value="IGCRC0203" toScope="request" />
<bean:define id="title" value="告警信息查询" toScope="request" />
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
	
	/*
	功能：批量删除页面，将复选框中选中的行删除
	参数：
	 */
	function beenIncidentDelete() {

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
			if(window.confirm("是否确认删除？")){
				location.href = 'IGCRC0203_DELETE_SUB.do?pk='+ pk;
			}
		} else {
			window.alert("请选择告警信息");
			return false;
		}
	}
	
	
	//修改
	function checkitem(pkId){
		window.location.href="IGCRC0203_Edit.do?pk="+pkId;
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
		openSubWindow('/IGCRC0203_SEARCH.do?prpdid=01080', '_blank','1000','600');
	}
	//关联工单赋值
	function setParams(prcorid, prserialnum, prcortitle){
		window.location.href="IGCRC0203_RELEVANCE.do?prcorid="+prcorid+"&pk="+savePkId+"&pedeventid="+prserialnum;
	}
	function openProcessByPrserialnum(prserialnum){
		openSubWindow('/IGPRR0112_Disp.do?prserialnum='+prserialnum, '_blank','900','650');
	}
	function alarmInformation(pedeventid){
		openSubWindow('/IGCRC0203_Alarm.do?pedeventid='+pedeventid, '_blank','900','650');
	}
	//导出excel
	function onExcel(temp){
		var form  = document.getElementById("form");
		if(temp == '1'){
			form.action = "IGCRC0203_EXCEL.do";
		}else{
			form.action = "IGCRC0203_Disp.do";
		}
		form.submit();
	}
	//主机名称升序排序
	function changeAppName(obj){
		//(1为降序 2为升序)
		if(obj == 1){
			j$("#chagneAppnameStatus2").show();
			j$("#chagneAppnameStatus1").hide();
			form.action = "IGCRC0203_Disp.do?appnamestatus=1&type=appname";
			form.submit();
		}else if(obj == 2){
			j$("#chagneAppnameStatus1").show();
			j$("#chagneAppnameStatus2").hide();
			form.action = "IGCRC0203_Disp.do?appnamestatus=2&type=appname";
			form.submit();
		}
	}
	//ip地址升序排序
	function changeIpaddres(obj){
		//(1为降序 2为升序)
		if(obj == 1){
			j$("#chagneIpaddresStatus2").show();
			j$("#chagneIpaddresStatus1").hide();
			form.action = "IGCRC0203_Disp.do?ipaddrstatus=1&type=ipaddr";
			form.submit();
		}else if(obj == 2){
			j$("#chagneIpaddresStatus1").show();
			j$("#chagneIpaddresStatus2").hide();
			form.action = "IGCRC0203_Disp.do?ipaddrstatus=2&type=ipaddr";
			form.submit();
		}
	}
	//触发时间/恢复时间升序排序
	function changeLasttime(obj){
		//(1为降序 2为升序)
		if(obj == 1){
			j$("#chagneLasttimeStatus2").show();
			j$("#chagneLasttimeStatus1").hide();
			form.action = "IGCRC0203_Disp.do?lasttimestatus=1&type=lasttime";
			form.submit();
		}else if(obj == 2){
			j$("#chagneLasttimeStatus1").show();
			j$("#chagneLasttimeStatus2").hide();
			form.action = "IGCRC0203_Disp.do?lasttimestatus=2&type=lasttime";
			form.submit();
		}
		
	}
	function changeRecoverytime(obj){
		//(1为降序 2为升序)
		if(obj == 1){
			j$("#chagneRecoverytimeStatus2").show();
			j$("#chagneRecoverytimeStatus1").hide();
			form.action = "IGCRC0203_Disp.do?recoverytimestatus=1&type=recoverytime";
			form.submit();
		}else if(obj == 2){
			j$("#chagneRecoverytimeStatus1").show();
			j$("#chagneRecoverytimeStatus2").hide();
			form.action = "IGCRC0203_Disp.do?recoverytimestatus=2&type=recoverytime";
			form.submit();
		}
	}
	
	
	//初始化
	jQuery(document).ready(function() {
		
		var appname = "${IGCRC0203VO.appnamestatus}"
		var ipaddr = "${IGCRC0203VO.ipaddrstatus}"
		var lasttime = "${IGCRC0203VO.lasttimestatus}"
		var recoverytime = "${IGCRC0203VO.recoverytimestatus}"
		//判断主机地址(为空是不排序,1为降序 2为升序)
		if(appname == null || appname == ""){
			j$("#chagneAppnameStatus1").show();
			j$("#chagneAppnameStatus2").hide();
		}else if(appname == "1"){
			j$("#chagneAppnameStatus2").show();
			j$("#chagneAppnameStatus1").hide();
		}else if(appname == "2"){
			j$("#chagneAppnameStatus1").show();
			j$("#chagneAppnameStatus2").hide();
		}
		
		//判断IP地址状态(为空是不排序,1为降序 2为升序)
		if(ipaddr == null || ipaddr == ""){
			j$("#chagneIpaddresStatus1").show();
			j$("#chagneIpaddresStatus2").hide();
		}else if(ipaddr == "1"){
			j$("#chagneIpaddresStatus2").show();
			j$("#chagneIpaddresStatus1").hide();
		}else if(ipaddr == "2"){
			j$("#chagneIpaddresStatus1").show();
			j$("#chagneIpaddresStatus2").hide();
		}
		
		
		//判断触发时间(为空是不排序,1为降序 2为升序)
		if(lasttime == null || lasttime == ""){
			j$("#chagneLasttimeStatus1").show();
			j$("#chagneLasttimeStatus2").hide();
		}else if(lasttime == "1"){
			j$("#chagneLasttimeStatus2").show();
			j$("#chagneLasttimeStatus1").hide();
		}else if(lasttime == "2"){
			j$("#chagneLasttimeStatus1").show();
			j$("#chagneLasttimeStatus2").hide();
		}
		
		
		//判断恢复时间状态(为空是不排序,1为降序 2为升序)
		if(recoverytime == null || recoverytime == ""){
			j$("#chagneRecoverytimeStatus1").show();
			j$("#chagneRecoverytimeStatus2").hide();
		}else if(recoverytime == "1"){
			j$("#chagneRecoverytimeStatus2").show();
			j$("#chagneRecoverytimeStatus1").hide();
		}else if(recoverytime == "2"){
			j$("#chagneRecoverytimeStatus1").show();
			j$("#chagneRecoverytimeStatus2").hide();
		}
	});
	
	
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
					<html:form styleId="form" action="/IGCRC0203_Disp"
						onsubmit="return checkSubmit(this);">
						<div id="location">
							<div class="image"></div>
							<p class="fonts1">告警管理 &gt;&gt; 告警管理查询</p>
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
									<html:text property="appname" name="IGCRC0203Form" />&nbsp;&nbsp;
									<span class="subscribe">事件单编号：</span>
									<html:text property="pedeventid" name="IGCRC0203Form" />
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
									<span class="subscribe">预期告警:</span>
									<span class="subscribe" style="background-color: #2CD349;">  </span>
									<input type="button" value="查询" class="button" onclick="onExcel(0)" />
									<input type="button" value="导出" class="button" onclick="onExcel(1)">
								</div>
							</div>
						</div>
						<ig:message />
							<table class="table_style" style="width:auto">
								<tr>
									<th width="4%"> 
									<label><input type="checkbox"
											name="checkbox" id="checkbox"
											onclick="selectAll('checkbox','alarmId')" />
									</label></th>
									<th width="6%">事件单编号</th>
									<th width="6%">工单名称</th>
									<th width="4%">告警序号</th>
									<th width="8%">主机名称<img id="chagneAppnameStatus1" style="cursor:pointer" src="images/timeup.gif" onclick="changeAppName(1);"><img id="chagneAppnameStatus2" style="cursor:pointer" src="images/timedown.gif" onclick="changeAppName(2);"></th>
									<th width="8%">IP地址<img id="chagneIpaddresStatus1" style="cursor:pointer" src="images/timeup.gif" onclick = "changeIpaddres(1);"><img id="chagneIpaddresStatus2" style="cursor:pointer" src="images/timedown.gif" onclick = "changeIpaddres(2);"></th>
									<th width="12%">事件内容</th>
									<th width="4%">故障联系人</th>
									<th width="8%">触发时间<img id="chagneLasttimeStatus1" style="cursor:pointer" src="images/timeup.gif" onclick = "changeLasttime(1);"><img id="chagneLasttimeStatus2" style="cursor:pointer" src="images/timedown.gif" onclick = "changeLasttime(2);"></th>
									<th width="6%">最后告警时间</th>
									<th width="8%">恢复时间<img id="chagneRecoverytimeStatus1" style="cursor:pointer" src="images/timeup.gif" onclick = "changeRecoverytime(1);"><img id="chagneRecoverytimeStatus2" style="cursor:pointer" src="images/timedown.gif" onclick = "changeRecoverytime(2);"></th>
									<th width="4%">告警次数</th>
									<th width="4%">是否生成工单</th>
									<th width="4%">状态</th>
									<th width="4%">描述</th>
									<th width="3%">删除</th>
									<th width="3%">关联</th>
									<th width="4%"></th>
								</tr>
							</table>
							<div style="overflow-x: hidden; padding-left: 0px; padding-right: 10px; height: 350px; overflow: auto;"  id="results_list">
							<table class="table_style" style="width:auto">
								<logic:present name="IGCRC0203VO" property="igalarmInfos">
									<logic:iterate id="info" name="IGCRC0203VO"
										property="igalarmInfos" indexId="index">
										<c:if test="${info.shieldflag=='1'}">
											<tr style="background-color: #2CD349;">
										</c:if>
										<c:if test="${info.shieldflag=='0'}">
											<tr>
										</c:if>
										<td width="4%">
											<c:if test="${info.pedeventid == '' || info.pedeventid == null}">
												<label> 
												<html:checkbox styleId="checkbox" property="alarmId" value="${info.pk}" />
												</label>
											</c:if>
											<c:if test="${info.pedeventid != '' && info.pedeventid != null}">
												<label> 
												<html:link href="javascript:void(0)" onclick="alarmInformation('${info.pedeventid}')">
													<img src="images/xx.gif" width="16" height="16" border="0" alt="详细告警信息" />
												</html:link>
												</label>
											</c:if>
										</td>
										<td width="6%">
											<a href="javascript:void(0);" onclick="openProcessByPrserialnum('${info.pedeventid}');">
												${info.pedeventid}
											</a>
										</td>
										<td width="6%" title="<ig:prtitle prid="${pedeventid}"/>"><ig:prtitle prid="${info.pedeventid}"  /></td>
										<td width="4%"><a href="javascript:void(0)" onclick="checkitem('${info.pk}')">${info.serial}</a></td>
										<td width="8%">${info.appname }</td>
										<td width="8%">${info.ipaddr }</td>
										<td width="14%" title="${info.summary}">${fn:substring(info.summary,0,40)}${fn:length(info.summary)>40?'...':''}</td>
										<td width="4%">${info.faultContact}</td>
										<td width="6%">${info.lasttime }</td>
										<td width="6%">${info.prealarmtime }</td>
										<td width="6%">${info.recoveryTime }</td>
										<td width="4%">${info.alarmcount }</td>
										<td width="4%">${info.isCreateOrder == 1?'是':'否' }</td>
										<td width="4%">
											<c:if test="${info.status==0}">告警</c:if>
											<c:if test="${info.status==1}">恢复</c:if>
											<c:if test="${info.status==2}">关闭</c:if>
										</td>
										<td width="6%" title="${info.description}">${fn:substring(info.description,0,19)}${fn:length(info.description)>19?'...':''}</td>
										<td width="3%">
											<c:if test="${info.pedeventid == '' || info.pedeventid == null}">
												<c:if test="${info.pedeventid == null || info.pedeventid == ''}">
												<html:link  href="javascript:toDel('${info.pk}')">
													<img src="images/stop.gif" width="16" height="16" border="0" alt="删除" />
												</html:link>
												</c:if>
											</c:if>
										</td>
										<td width="3%">
											<c:if test="${info.pedeventid == '' || info.pedeventid == null}">
												<html:link href="javascript:void(0)" onclick="relevance('${info.pk}')">
													<img src="images/copy.gif" width="16" height="16" border="0" alt="和关联工单" />
												</html:link>
											</c:if>
										</td>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
						</div>
						<!-- 添加生成事件单按钮 -->
						<table class="table_style1">
							<tr>
								<td align="left" width="200" style="border: 0px"> 
									<!-- <div id="results_list1"> --> 
									<input type="button" value="生成事件单" class="button1" onclick="beenIncident()">
									<input type="button" value="批量删除" class="button1" onclick="beenIncidentDelete()">
								</td>

								<%-- <td align="left" style="border: 0px">
									<!-- <div id="operate"> --> 
									<jsp:include page="/include/paging.jsp" />
								</td> --%>
							<tr>
						</table>
					</html:form>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>


	</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html:html>
<bean:define id="id" value="IGDRM1010" toScope="request" />
<bean:define id="title" value="应急工作台" toScope="request" />
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="zh-CN">
<link rel="stylesheet" href="<html:rewrite forward='master.css'/>" type="text/css">
<link rel="stylesheet" type="text/css" href="css/select2/select2.min.css">
<link type="text/css" href="css/drm/workflow_drm.css" rel="stylesheet" charset="UTF-8"/>
<link type="text/css" href="css/drm/mask.css" rel="stylesheet" charset="UTF-8"/>
<script src="<html:rewrite forward='common.js'/>"></script>
<script language="JavaScript" src="<html:rewrite forward='SoftKey.js'/>" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script>
	var jQ  = jQuery.noConflict(true);//jquery与prototype冲突
	jQuery = jQ;
	var $ = jQ;
</script>
<script type="text/javascript" src="js/laydate/laydate.js"></script> 
<script>laydate.skin('yalan');</script>
<script  type="text/javascript"  src="js/jQueryFileUpload/js/vendor/jquery.ui.widget.js"></script>
<script type="text/javascript"  src="js/jQueryFileUpload/js/jquery.iframe-transport.js"></script>
<script type="text/javascript" src="js/jQueryFileUpload/js/jquery.fileupload.js"></script>
<script type="text/javascript" src="js/drm/mask.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/drm/WorkFlow.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/drm/tab.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/drm/WorkFlow_Other.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/json.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/tableform.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/select2/select2.full.js"></script>
<script type="text/javascript" src="js/select2/i18n/es.js"></script>
<title><bean:write name="id"/><bean:write name="title"/></title>
</head>
<body style="overflow-y: hidden;">
<div class="box" id="databox">
<div class="main">
<logic:present name="IGDRM10101VO" property="workbenchMap">
	<div id="tabTit" class="tabBox">
		<ul>
			<logic:iterate id="map" name="IGDRM10101VO" property="workbenchMap" indexId="idx">
				<c:if test="${idx == 0 }">
					<li class="this" data-prid="${map.key }">${map.value }</li>
				</c:if>
				<c:if test="${idx > 0 }">
					<li data-prid="${map.key }">${map.value }</li>
				</c:if>
			</logic:iterate>
		</ul>
		&nbsp;
	</div>
	<div id="tabContent" class="tabContentGroup">
		<logic:iterate id="map" name="IGDRM10101VO" property="workbenchMap" indexId="index">
			<div class="tabContent" prid="${map.key }" data-emename="${map.value }">
				<div class="process_detail">
				<div class="titleBox">
					<table class="table">
						<tr>
							<td id="titlename" width="40%"></td>
							<td width="20%">
								<div id="startTimeBox">开始时间 <span id="startTime"></span></div>
							</td>
							<td width="20%">
								<div id="usedTimeBox"><span class="icon icon1">&nbsp;</span>已用时间 <span id="usedTime"></span></div>
							</td>
							<td width="20%">
								<div id="endTimeBox">结束时间 <span id="endTime"></span></div>
							</td>
						</tr>
					</table>
				</div>
				<div class="tabBox">
					<ul >
						<li class="this">处理日志</li>
						<li>推送短信</li>
						<li>推送通知</li>
					</ul>
				<div class="curStatusBox">
					当前状态:
					<select id="prstatus">
					</select>
				</div>
				</div>
				<div id="crlBox" class="tabContentGroup">
					<div class="tabContent">
						<div class="process_detail">
							<table class="table">
								<tr>
									<td width="90%">
										<table class="table" id="formscontent">
											<tr>
												<th >&nbsp;</th>
												<td >&nbsp;</td>
												<th >&nbsp;</th>
												<td >&nbsp;</td>
											</tr>									
										</table>
									</td>
									<td id="btnTd" width="10%" rowspan="2">
									</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="tabContent" style="display: none;">
						<div class="process_detail" >
							<table class="table">
								<tr>
									<th width="15%">短信内容</th>
									<td><textarea rows="" cols=""></textarea></td>
									<td width="6%"  class="bottomtd">
										<button  id="btn_sendsms" data-sendtype="sms" class="btn sendbtn" >提交</button>
									</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="tabContent" style="display: none;">
						<div class="process_detail" >
							<table class="table">
								<tr>
									<th width="15%">通知内容</th>
									<td><textarea rows="" cols=""></textarea></td>
									<td width="6%"  class="bottomtd"><button id="btn_sendnotice" data-sendtype="notice"  class="btn sendbtn" >提交</button></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<div class="statusBox">
					<table class="table">
						<tr>
							<td width="20%" style="font-size: 18px;text-indent: 2em;">节点信息</td>
							<th width="8%">节点名称</th>
							<td width="13%">
								<select data-filter="psdname">
									<option></option>
								</select> 
							</td>
							<th width="8%">参与人 </th>
							<td width="13%">
								<select data-filter="people">
									<option></option>
								</select> 
							</td>
							<th width="8%">节点状态</th>
							<td width="13%">
								<select data-filter="status">
									<option></option>
									<option value="cur">处置中</option>
									<option value = "his">处置完成</option>
									<option value="wait">未开始</option>
								</select>
							</td>
							<td width="17%" style="text-align: center;" > <button  id="showLog"  class="btn hbth" >查看日志</button></td>
						</tr>
					</table>
				</div>
				<div class="statusList">
					<table id="statusContent">
						<tr class="statusListth">
							<th width="40px" ><span >&nbsp;</span><input class="ckeckall" type="checkbox"  ></th>
							<th data-name="psdname">节点名称</th>
							<th data-name="people">参与人 </th>
							<th class="eme" data-name="expectStartTime">预计开始时间</th>
							<th class="eme" data-name="expectStartTime_expectUseTime">预计结束时间</th>
							<th class="eme" data-name="expectUseTime">预计用时</th>
							<th data-name="factStartTime" data-checkstart="1">开始时间</th>
							<th data-name="factStartTime_factUseTime" data-checkend="1">结束时间</th>
							<th data-name="factUseTime">实际用时</th>
<!-- 							<th data-name="name">处置日志</th> -->
						</tr>
					</table>
				</div>
				</div>
			</div>
		</logic:iterate>
	</div>
</logic:present>
</div>
</div>
	<div  id = "maskbox" style="display: none;">
		<div style="width: 100%; height: 100%; ">&nbsp;</div>
	</div>
</body>
</html:html>
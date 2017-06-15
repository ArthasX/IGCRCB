<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCRC0207" toScope="request" />
<bean:define id="title" value="告警信息修改" toScope="request" />
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
width:100px;
margin-left:1px;
border:1px none #ccc;
}
</style>
<script type="text/javascript">
function confirmDisp(){
	//window.close();
	return true;
}
</script>

<body>
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<!--container 左菜单 右侧内容-->
		<div id="container">
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<div id="location">
						<div class="image"></div>
						<p class="fonts1">告警管理 &gt;&gt; 告警管理查询 &gt;&gt; 告警信息修改</p>
						<div class="back"><a href="IGCRC0203_Alarm.do?pedeventid=${IGCRC0204Form.pedeventid }" target="_self">返回</a></div> 
					</div>
					
					<div id="formwrapper">
						<html:form styleId="form"
							action="/IGCRC0203_Upadte_SUB.do">
							<!--  message -->
							<ig:message />
							<!--  /message -->
							<fieldset>
								<legend>修改告警信息</legend>


								<div>
									<label for="Name"><strong>事件单编号</strong>：</label>
									<p class="p2">${IGCRC0203VO.igalarmInfo.pedeventid}</p>
									<html:hidden property="pk"/>
									<html:hidden property="isShow" value="${IGCRC0203VO.igalarmInfo.isShow}"/>
									<html:hidden property="pedeventid" value="${IGCRC0204Form.pedeventid }"/>
								</div>
								
								<div>
									<label for="Name"><strong>工单名称</strong>：</label>
									<p class="p2"><ig:prtitle prid="${IGCRC0203VO.igalarmInfo.pedeventid}"  /></p>
								</div>
								
								<div>
									<label for="Name"><strong>告警序号</strong>：</label>
									<p class="p2">${IGCRC0203VO.igalarmInfo.serial}</p>
									<input type="hidden" name="serial" value="${IGCRC0203VO.igalarmInfo.serial}" />
								</div>
								
								<div>
									<label for="Name"><strong>主机名称</strong>：</label>
									<p class="p2">${IGCRC0203VO.igalarmInfo.appname}</p>
									<input type="hidden" name="appname" value="${IGCRC0203VO.igalarmInfo.appname}" />
								</div>
								
								<div>
									<label for="Name"><strong>IP地址</strong>：</label>
									<p class="p2">${IGCRC0203VO.igalarmInfo.ipaddr}</p>
									<input type="hidden" name="ipaddr" value="${IGCRC0203VO.igalarmInfo.ipaddr}" />
								</div>

								<div>
									<label for="Name"><strong>事件内容</strong>：</label>
									<p class="p2">${IGCRC0203VO.igalarmInfo.summary}</p>
									<input type="hidden" name="summary" value="${IGCRC0203VO.igalarmInfo.summary}" />
								</div>

								<div>
									<label for="Name"><strong>故障联系人</strong>：</label>
									<input name="faultContact" type="text" value="${IGCRC0203VO.igalarmInfo.faultContact}">
								</div>

								<div>
									<label for="Name"><strong>触发时间</strong>：</label>
									<p class="p2">${IGCRC0203VO.igalarmInfo.lasttime}</p>
									<input type="hidden" name="lasttime" value="${IGCRC0203VO.igalarmInfo.lasttime}">
								</div>

								<div>
									<label for="Name"><strong>恢复时间</strong>：</label>
									<input size="16" readonly="true" style="width:116px;" name="recoveryTime" value="${IGCRC0203VO.igalarmInfo.recoveryTime}">
									<img src="images/date.gif" align="middle" onclick="showTime($('recoveryTime'))" border="0" style="cursor: hand" />
								</div>

								<div>
									<label for="Name"><strong>是否生成工单</strong>：</label>
									<select name="isCreateOrder">
										<option value="0" <c:if test="${IGCRC0203VO.igalarmInfo.isCreateOrder == 0 || IGCRC0203VO.igalarmInfo.isCreateOrder == ''}">selected="selected"</c:if> >否</option>
										<option value="1" <c:if test="${IGCRC0203VO.igalarmInfo.isCreateOrder == 1 }">selected="selected"</c:if> >是</option>
									</select>
								</div>

								<div>
									<label for="Name"><strong>状态</strong>：</label>
										<select name="status">
										<option value="0" <c:if test="${IGCRC0203VO.igalarmInfo.status == 0 }">selected="selected"</c:if> >告警</option>
										<option value="1" <c:if test="${IGCRC0203VO.igalarmInfo.status == 1 }">selected="selected"</c:if> >恢复</option>
										<option value="2" <c:if test="${IGCRC0203VO.igalarmInfo.status == 2 }">selected="selected"</c:if> >关闭</option>
									</select>
								</div>

								<div>
									<label for="Name"><strong>描述</strong>：</label>
									<textarea cols="60" rows="6" name="description">${IGCRC0203VO.igalarmInfo.description}</textarea>
								</div>
								
							</fieldset>
							
							<div class="enter">
								<html:submit property="btn_insert" value="提交"
									styleClass="button" onclick="return confirmDisp();" />
								<html:reset property="btn_clear" onclick="setAssetDiv(1);"
									styleClass="button" value="重置" />
							</div>

						</html:form>
					</div>
					
					
					
				</div>
			</div>
			<div class="zishiying"></div>
		</div>


	</div>
</body>
</html:html>
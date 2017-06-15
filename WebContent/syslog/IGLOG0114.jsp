<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.syslog.vo.IGLOG0102VO"%>
<html:html>
<head>
<bean:define id="id" value="" toScope="request" />
<bean:define id="title" toScope="request">
	IGLOG0114
</bean:define>
<script src="js/menu/jquery.js" type="text/javascript"></script>
<script src="js/alerts/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="js/alerts/jquery.alerts.js" type="text/javascript"
	charset="gbk"></script>
<link href="js/alerts/jquery.alerts.css" rel="stylesheet"
	type="text/css" media="screen" />
<link href="js/menu/menu.css" rel="stylesheet" type="text/css" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- header1 -->
<script type="text/javascript">
	function checkForm() {
		form.submit();
		//return true;
	}
	function toDel(name) {
		var objs = document.getElementsByName(name);
		var id = "";
		var length = 0;
		if(objs!=null){	
			
			for(var i=0;i<objs.length;i++){
				if(objs[i].checked){
					id = objs[i].value;
					length++;
				}
			}

		if(length >= 1)
		{
			if (window.confirm("是否删除所选")) 
				{
			form.action = getAppRootUrl() + "/IGLOG0114_Del.do";
			return true;
				}
		}
		 else {
			    alert("至少选择一条信息");
			return false;
		 }
	  
		}
		else {
				alert("至少选择一条信息");
		    return false;
			 }
		} 
	
	
	WebCalendar.timeShow = true;//是否返回时间
</script>
</head>
<body>
	<br>
	<html:form styleId="form" action="/IGLOG0114_Clear">

		<div>
		<div id="search">
			<div class="img"></div>
			<div style="text-align: left;">
				<!--告警IP--> 
				<bean:message bundle="mtmResources"
					key="label.IGLOG0001.AlarmIP" />： <html:text property="ip_like"
					styleId="ip_like" errorStyleClass="inputError imeDisabled"
					size="15" maxlength="16" tabindex="2">
				</html:text>&nbsp;&nbsp;&nbsp;
				<!--关键字--> 
				关键字: <html:text property="content_like" styleId="content_like"
					errorStyleClass="inputError imeDisabled" size="15"
					maxlength="16" tabindex="2">
				</html:text><br/>
				<logic:present name="IGLOG0114VO"
					property="ruleli"> 
					                       告警等级：
					<logic:iterate id="bean" name="IGLOG0114VO" property="ruleli"
						indexId="index">
						<input type="checkbox" name="cvalue" value="${bean.cid}">${bean.cvalue}
				 </logic:iterate>
				</logic:present>&nbsp;&nbsp;&nbsp;&nbsp;
				<html:submit property="btn_search" styleClass="button"
					value="查询">
				</html:submit>
			</div>
			</div>
			<div style="width: 98%;" align="center">
				<div id="alarmList">
					<table class="table_style" style="width: auto">
						<tr>

							<th width="4%"><logic:present name="IGLOG0114VO"
									property="li">
									<label><input type="checkbox" name="allbox" id="allbox"
										onclick="selectAll('allbox','id')" /></label>
								</logic:present></th>

							<th width="15%">级别</th>
							<th width="12%" style="text-align: left;">IP</th>
							<th style="text-align: left;">关键字</th>

						</tr>
					</table>
					<div>
						<table class="table_style" style="width: auto">
							<logic:present name="IGLOG0114VO" property="li">
								<logic:iterate id="bean" name="IGLOG0114VO" property="li"
									indexId="index">
									<tr class="alarmcolor_level${bean.rulelevel}">
										<td width="4%"><input type="checkbox" name="id"
											value="${bean.id}"></td>
										<td width="15%"><span style="text-align: center;"><ig:codeValue
													ccid='SYSLOGALARM_PRIORITY' cid='${bean.rulelevel}' /></span></td>
										<td style="text-align: left;" width="12%">${bean.deviceip}</td>
										<td style="text-align: left;">${bean.alarmmsg}</td>
									</tr>
								</logic:iterate>
							</logic:present>


						</table>
						<table>
							<logic:present name="IGLOG0114VO" property="li">
								<html:submit property="btn_delete" value="删除所选"
										styleClass="button" onclick="return toDel('id');" />
							</logic:present>
						</table>
					</div>
					<div id="operate">
						<!-- paging -->
						<div style="float: right; width: 80%; text-align: right;"><jsp:include
								page="/include/paging.jsp" /></div>
						<!-- /paging -->
					</div>

				</div>
			</div>
			<!-- </div> -->
		</div>
	</html:form>
	<div class="zishiying"></div>

</body>
</html:html>
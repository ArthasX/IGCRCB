<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="MSS00002" toScope="request" />
<bean:define id="title" value="告警规则管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<%

%>

<!-- /header1 -->
<script type="text/javascript">	
<!--
	//删除所选
	function deleteRec(obj){
		var message = '<bean:message key="IGCO10000.E002"/>';
	    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="条件模板" />';
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
	    if(window.confirm(confirmMsg)){
	        form.action = getAppRootUrl() + "/IGLOG0021_Del.do";
	        return true;
	    } else {
	        return false;
	    }
	}

	function setEntity(url){

	 var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		 if("_resetall"==temp){
			 document.forms[0].ename.value = "";
//			 document.forms[0].eid.value = "";
			 document.forms[0].esyscoding.value = "";
			 return false;
		 }
		if(null!=temp && temp.split("|").length>1){
			var syscode_eid = temp.split("|")[0];
			var name = temp.split("|")[1];
			var syscode;
			var eid;
			if(syscode_eid =="999")
			{
				alert("资产模型不可用！请选择其他模型！");
				return false;
				
			}else if(syscode_eid.split("_").length>1){
				eid = syscode_eid.split("_")[0];
				syscode = syscode_eid.split("_")[1];
			}
			document.forms[0].ename.value = name;
		//	document.forms[0].eid.value = eid;
			document.forms[0].esyscoding.value = syscode;
		}			
	}
	function changeStatus(ruleid,state){
		//"是否改变状态？"
		if(confirm("是否改变状态？")){
			var form = document.getElementById("form");
			form.action="IGLOG0021_ChangeState.do?deviceid=" + ruleid +"&devicestate="+state;
			form.submit();
		}
	}
//-->
	</script><body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGLOG0021"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">监控管理 &gt;&gt; 监控配置 &gt;&gt; 告警规则管理</p>
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>设备名称：</span>
	<span>
	<html:text property="name_like" styleId="name_like"
				errorStyleClass="inputError imeDisabled" size="15" maxlength="16"
				tabindex="2">
	</html:text>
	</span>
	&nbsp;&nbsp;
	<span>设备类型：</span>
	<span>
	<html:select name="IGLOG0021Form" property="type_eq" styleId="type_eq" errorStyleClass="inputError imeActive" >
		<ig:optionsCollection ccid="SYSLOG_DEVICETYPE" isMakeBlankRow="true" isCodeLabel="true"/>
	</html:select>
	</span>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
	
			<tr>
				<th width="4%"><label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','deleteId')"/> </label>
				</th>
				<th width="22%">设备名称</th>
				<th width="17%">设备类型</th>
				<th width="14%">规则个数</th>
				<th width="15%">状态</th>
				<th>修改/详细</th>
			</tr>
			
			<logic:present name="IGLOG0021VO" property="deviceTempList">
			
				<logic:iterate id="bean" name="IGLOG0021VO"
					property="deviceTempList" indexId="index" type="com.deliverik.infogovernor.syslog.model.Mss00011Info">
					<tr class="<ig:rowcss index="${index}"/>">
						<td>
							<html:checkbox property="deleteId" value="${bean.deviceid}"/>
						</td>
						<td>
							<div class="nowrapDiv">
			                	<logic:empty name="bean" property="devicename">&nbsp;</logic:empty> ${bean.devicename}
			            	</div>
						</td>
						<td>
							<div class="nowrapDiv">
			                	<logic:empty name="bean" property="devicetype">&nbsp;</logic:empty> ${bean.devicetype}
			            	</div>
						</td>
						<td>
							<div class="nowrapDiv">
			                	${bean.tempcounts}
			            	</div>
						</td>
						<td>
							<div class="nowrapDiv">
			                	<logic:empty name="bean" property="devicestate">&nbsp;</logic:empty> 
			                	<logic:equal name="bean" property="devicestate" value="1">
			                	<a href="javascript:changeStatus('${bean.deviceid}','${bean.devicestate}');"> <img
									src="images/start.gif" border="0"
									alt="启用" />
								</a>
			                	</logic:equal>
			                	<logic:equal name="bean" property="devicestate" value="0">
									<a href="javascript:changeStatus('${bean.deviceid}','${bean.devicestate}');"> <img
										src="images/stop.gif" border="0"
										alt="停用" />
									</a>
								</logic:equal>
			            	</div>
						</td>
						<td><html:link action="/IGLOG0021_EDIT_DISP.do?deviceid=${bean.deviceid}&typeid=${bean.typeid}">
									<img src="images/edit.gif" alt="修改" width="16" height="16" border="0"/>
								</html:link>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
			
	</table>
	</div>
	<div id="operate">
	<!-- 
	<span> 
	<html:submit property="btn_add" value=" 添加  "
			styleClass="button" onclick="return deleteRec('deleteId');" />
	</span>
	 -->
	<logic:present name="IGLOG0021VO"
		property="deviceTempList">
		<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return deleteRec('deleteId');" />
		</span>
	</logic:present>  <jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
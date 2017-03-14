<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.infogovernor.util.SVCHelper"%>
<html:html>
<bean:define id="id" value="IGVIR1301" toScope="request" />
<bean:define id="title" value="虚机资源管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	var jQ = jQuery.noConflict();
	function getHosts(value){
		var obj = document.getElementById("hostname");
		obj.options.length = 1;
		if(value != ""){
			jQ.post(getAppRootUrl() + "/IGVIR1301_GetHosts.do", "vcid=" + value,
					function(data){
					var info = eval("(" +data + ")");
						jQuery.each(info, function (i, value) { 
							var item = new Option(value,value);
							if(value == "${IGVIR1301Form.hostname}"){
								item.selected = true;
							}
							obj.options.add(item);
						});
					}
			);
		}
	}
	jQ(document).ready(function(){
		getHosts(jQ("#vcid").val());
	});
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGVIR1301" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">虚机资源管理</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
		<div>
			<span>
				vCenter：
				<html:select styleId="vcid" property="vcid" style="width:150px;" onchange="getHosts(this.value);">
					<html:option value=""></html:option>
					<logic:present name="AD_vCenterList">
						<html:options collection="AD_vCenterList" property="value" name="" labelProperty="label"/>
					</logic:present>
				</html:select>
			</span>
			&nbsp;&nbsp;
			<span>
				Host：
				<html:select styleId="hostname" property="hostname" style="width:150px;">
					<html:option value=""></html:option>
				</html:select>
			</span>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<html:submit value="查询" styleClass="button"/>
		</div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="12%">Host</th>
			<th width="22%">虚机名称</th>
			<th width="12%">管理人</th>
			<th width="12%">所属机构</th>
			<th width="12%">IP</th>
			<th width="5%">CPU（G）</th>
			<th width="5%">内存（G）</th>
			<th width="5%">硬盘（G）</th>
			<th width="5%">操作</th>
		</tr>
		<logic:present name="IGVIR13011VO" property="vim03List">
			<logic:iterate id="bean" name="IGVIR13011VO" property="vim03List">
				<tr>
					<td>${bean.hostName }</td>
					<td>${bean.vmName }</td>
					<td>${bean.userName }</td>
					<td>${bean.orgname }</td>
					<td>${bean.ip }</td>
					<td>${bean.vmCpus }</td>
					<td>${bean.vmMem }</td>
					<td>${bean.vmDisk }</td>
					<td>
						<html:link action="/IGVIR1302_Disp.do?id=${bean.id }">
							<img src="images/edit.gif" width="16" height="16" border="0"/>
						</html:link>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>

</div>
</body>
</html:html>

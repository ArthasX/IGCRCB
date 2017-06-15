<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.util.SVCHelper"%>
<html:html>
<bean:define id="id" value="IGVIR1202" toScope="request" />
<bean:define id="title" toScope="request" value="资源使用情况" />
<title><bean:write name="id"/><bean:write name="title"/></title>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/vim_Index.css" rel="stylesheet"/>
<style type="text/css">
	.vcnameLabel{
		height:20px;
		border:1px solid #ccc;
		text-align:center;
		line-height:20px;
		cursor: hand;
	}
</style>
<script type="text/javascript">
	function gotoLink(vcid){
		window.location.href = "IGVIR1202.do?vcid=" + vcid;
	}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
	<div id="Content" >
		<div id="LeftPanel" class="dvPanel">
			<div id="Navi" class="dvSerMenu" style="min-height: 400px">
				<logic:present name="IGVIR12021VO" property="vim01List">
					<logic:iterate id="bean" name="IGVIR12021VO" property="vim01List">
						<div class="vcnameLabel" 
						<logic:notEqual value="${IGVIR12021VO.vcid }" name="bean" property="vcid">
							style="background-image:url(images/divtitlebg.jpg);" 
						</logic:notEqual>
						<logic:equal value="${IGVIR12021VO.vcid }" name="bean" property="vcid">
							style="border-left:5px solid #1c87e1;"
						</logic:equal>
						onclick="gotoLink(${bean.vcid });">${bean.vcname }</div>
					</logic:iterate>
				</logic:present>
			</div>
		</div>
		<div id="Main" class="dvPanel">
			<div id="Resouce" class="dvblock">
				<div class="dvTitle">
					<div class="titText">主机资源配置及使用情况</div>
				</div>
				<div class="dvContent">
					<table class="rs_tb_style1">
						<tr>
							<th>HostIP</th>
							<th>CPU个数</th>
							<th>内存信息</th>
							<th>存储信息</th>
							<th>CPU使用率</th>
							<th>内存使用率</th>
							<th>存储使用率</th>
							<th>vm个数</th>
						</tr>
						<logic:present name="IGVIR12021VO" property="hostList">
							<logic:iterate id="bean" name="IGVIR12021VO" property="hostList">
								<tr>
									<td>${bean.name }</td>
									<td>${bean.cpuCores }</td>
									<td>${bean.memoryMB }MB</td>
									<td>${bean.capacity }GB</td>
									<td>${bean.cpuUseRate }</td>
									<td>${bean.memoryUseRate }</td>
									<td>${bean.diskUseRate }</td>
									<td>${bean.vm_num }</td>
								</tr>
							</logic:iterate>
						</logic:present>
					</table>
				</div>
			</div>
		</div>
		</div>
	</div>
</body>
</html:html>

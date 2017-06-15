<%@ page buffer="2048kb" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="java.util.Map"%>
<%@ page import="java.net.URLEncoder" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.deliverik.framework.asset.FsLvVgInfo"%><html:html>
<bean:define id="id" value="IGCOM0319" toScope="request"/>
<bean:define id="title" value = "资产详细画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<link rel="stylesheet" href="<html:rewrite forward='pop.css'/>" type="text/css">
	
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<STYLE>
html{
  overflow-x: hidden;
}

</STYLE>
<script type="text/javascript">
    var gid='IGCOM0319';

	function initSolt(name,type){
		document.forms[0].screenWidth.value = window.screen.width;
		document.forms[0].soltName.value = name;
		document.forms[0].soltType.value = type;
		
		document.forms[0].action =  getAppRootUrl()+"/IGCOM0319_Relation.do";
		document.forms[0].submit();
	}
	
	function initSoltVg(name,type){
		document.forms[0].screenWidth.value = window.screen.width;
		document.forms[0].soltNameVg.value = name;
		document.forms[0].soltType.value = type;
		
		document.forms[0].action =  getAppRootUrl()+"/IGCOM0319_Relation.do";
		document.forms[0].submit();
	}

</script>
<style>
  html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	font-size: 12px;
	overflow-x: hidden;
	background-color: #FFFFFF;
	background-image:none;
 }
</style>
<body onload="">
<% 
    int capacityTotal = 0;
%>
<html:form styleId="form" action="/IGCOM0319_Relation" onsubmit="return checkSubmit(this);">
		<html:hidden name="IGCOM0319Form" property="srpareiid_eq" value="${IGCOM0319Form.srpareiid_eq}"/>
		<html:hidden name="IGCOM0319Form" property="screenWidth" />
		<html:hidden name="IGCOM0319Form" property="soltNameVg" />
		<html:hidden name="IGCOM0319Form" property="soltName" />
		<html:hidden name="IGCOM0319Form" property="soltType" />
		<html:hidden name="IGCOM0319Form" property="attrName" />
		<html:hidden name="IGCOM0319Form" property="attrValue" />
		<html:hidden name="IGCOM0319Form" property="srdomainid_eq" value="${IGCOM0319Form.srdomainid_eq}"/>
		<html:hidden name="IGCOM0319Form" property="srdomainversion_eq" value="${IGCOM0319Form.srdomainversion_eq}"/>
		<html:hidden name="IGCOM0319Form" property="srparversion_eq" value="${IGCOM0319Form.srparversion_eq}"/>
		<html:hidden name="IGCOM0319Form" property="srparsmallversion_eq" value="${IGCOM0319Form.srparsmallversion_eq}"/>
		<html:hidden name="IGCOM0319Form" property="srcreatetime_eq" value="${IGCOM0319Form.srcreatetime_eq}"/>
</html:form>
<div id="maincontent" style="background-color: #FFFFFF;background-image:none;">
 <div class="message" ><ig:message /></div>
<div id="container">
	    <div class="title">
	<div class="name">设备基本信息</div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="10%">模型名称</th>
			<th width="14%">设备编号</th>
			<th width="15%">设备名称</th>
			<th width="15%">设备所属机构</th>
			<th width="18%">设备说明</th>
			<!--<th width="8%">设备状态</th>-->
			<th width="10%">管理人</th>
			<th width="10%">登记日</th>
		</tr>
		<tr>
			<td align="center">${IGCOM03191VO.ename}</td>
			<td>${IGCOM03191VO.soc0118Info.eilabel}</td>
			<td>${IGCOM03191VO.soc0118Info.einame}</td>
			<td>${IGCOM03191VO.eiorgname}</td>
			<td>${IGCOM03191VO.soc0118Info.eidesc}</td>
			<td>${IGCOM03191VO.soc0118Info.eiusername}</td>
			<td>${IGCOM03191VO.soc0118Info.eiinsdate}</td>
		</tr>
	</table>
</div>
<!-- 将上句移动到container的div外面，解决当最大化窗口时无信息提示的位置变动问题-->
		<div id="TabbedPanels1" class="TabbedPanels" style="margin-top: 5px;">
			<ul class="TabbedPanelsTabGroup">
				<li class="TabbedPanelsTab">
				FS-LV-VG
				</li>
		</ul>
		<div class="TabbedPanelsContentGroup">
				<div class="TabbedPanelsContent" style="width:960px;overflow-x:auto;overflow-y:hidden;">
				<div class="record_list" style="height:380px;width:940px">
				
				<table class="table_style2_SOC">
					<tr>
						<th width="50px">No.</th>
						<th width="150px">
							<table class="table_style3_SOC">
								<tr>
									<td rowspan="2" >
											VG Name
									</td>
									<td  valign="bottom"><img style="cursor: hand" src="images/timeup.gif" border="0" onclick="initSolt('vgNameLv','0')"></td>
								</tr>
								<tr>
									<td  valign="top"><img style="cursor: hand" src="images/timedown.gif" border="0" onclick="initSolt('vgNameLv','1')"></td>
								</tr>
							</table>
						</th>
						
						<th width="150px">
							<table class="table_style3_SOC">
								<tr>
									<td rowspan="2">
											LV Name
									</td>
									<td valign="bottom"><img style="cursor: hand" src="images/timeup.gif" border="0" onclick="initSolt('lvName','0')"></td>
								</tr>
								<tr>
									<td valign="top"><img style="cursor: hand" src="images/timedown.gif" border="0" onclick="initSolt('lvName','1')"></td>
								</tr>
							</table>
						</th>
												
						<th width="100px">
							<table class="table_style3_SOC">
								<tr>
									<td rowspan="2">
											Mount Point
									</td>
									<td valign="bottom"><img style="cursor: hand" src="images/timeup.gif" border="0" onclick="initSolt('mountPoint','0')"></td>
								</tr>
								<tr>
									<td valign="top"><img style="cursor: hand" src="images/timedown.gif" border="0" onclick="initSolt('mountPoint','1')"></td>
								</tr>
							</table>
						</th>
																							
						<th width="100px">
							<table class="table_style3_SOC">
								<tr>
									<td rowspan="2">
											FS Type
									</td>
									<td valign="bottom"><img style="cursor: hand" src="images/timeup.gif" border="0" onclick="initSolt('fsType','0')"></td>
								</tr>
								<tr>
									<td valign="top"><img style="cursor: hand" src="images/timedown.gif" border="0" onclick="initSolt('fsType','1')"></td>
								</tr>
							</table>
						</th>
						
						<th width="100px">
							<table class="table_style3_SOC">
								<tr>
									<td rowspan="2">
											Capacity (MB)
									</td>
									<td valign="bottom"><img style="cursor: hand" src="images/timeup.gif" border="0" onclick="initSolt('','0')"></td>
								</tr>
								<tr>
									<td valign="top"><img style="cursor: hand" src="images/timedown.gif" border="0" onclick="initSolt('','1')"></td>
								</tr>
							</table>
						</th>
						</tr>
					</table>
					
						
						<div style="overflow-y:auto;height:350px;">
						<table class="table_style2_SOC" style="" >
						<logic:present name="IGCOM03191VO" property="fsLvVgInfoList">
							<logic:iterate id="bean" name="IGCOM03191VO" property="fsLvVgInfoList" indexId="index" type="com.deliverik.framework.soc.asset.SOC0130Info">
							<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
									<!-- 序号 -->
									<td width="50px">
										${index+1}
									</td>
									<% 
										String[] vgNamelv=bean.getVgNameLv().split("_");
										String[] lvName=bean.getLvName().split("_");
									%>
									<td width="150px">
									<%=vgNamelv[vgNamelv.length-1]%>
									</td>
									<td width="150px">
									<%=lvName[lvName.length-1]%>
									</td>
									<td width="100px">${bean.mountPoint}</td>
									<td width="100px">${bean.fsType}</td>
									<td width="100px"></td>
							</tr>
							</logic:iterate>
							<tr>  
							   <td width="50px" >total:</td>
							   <td width="100px" ></td>
							   <td width="100px" ></td>
							   <td width="100px" ></td>
							   <td width="100px" ></td>
							   <td width="100px" ><%=capacityTotal%></td>				
							</tr>
							</logic:present>
						</table>
						</div>
				</div>
				</div>
		</div>
		</div>
		<div id="TabbedPanels2" class="TabbedPanels" style="margin-top: 5px;margin-bottom: 0px;">
			<ul class="TabbedPanelsTabGroup">
				<li class="TabbedPanelsTab">
				VG-PV-Meta
				</li>
			</ul>
		<div class="TabbedPanelsContentGroup">
				<div class="TabbedPanelsContent" style="width:960px;overflow-x:auto;overflow-y:hidden;">
				<div class="record_list" style="height:380px;width:940px">
				
				<table class="table_style2_SOC">
					<tr>
						<th width="50px">No.</th>
						<th width="90px">
							<table class="table_style3_SOC">
								<tr>
									<td rowspan="2" >
											VG Name
									</td>
									<td  valign="bottom"><img style="cursor: hand" src="images/timeup.gif" border="0" onclick="initSoltVg('vgName','0')"></td>
								</tr>
								<tr>
									<td  valign="top"><img style="cursor: hand" src="images/timedown.gif" border="0" onclick="initSoltVg('vgName','1')"></td>
								</tr>
							</table>
						</th>
						
						<th width="100px">
							<table class="table_style3_SOC">
								<tr>
									<td rowspan="2">
											Pseudo Name
									</td>
									<td valign="bottom"><img style="cursor: hand" src="images/timeup.gif" border="0" onclick="initSoltVg('pseudoName','0')"></td>
								</tr>
								<tr>
									<td valign="top"><img style="cursor: hand" src="images/timedown.gif" border="0" onclick="initSoltVg('pseudoName','1')"></td>
								</tr>
							</table>
						</th>
												
						<th width="90px">
							<table class="table_style3_SOC">
								<tr>
									<td rowspan="2">
											I/O Paths
									</td>
									<td valign="bottom"><img style="cursor: hand" src="images/timeup.gif" border="0" onclick="initSoltVg('ioPaths','0')"></td>
								</tr>
								<tr>
									<td valign="top"><img style="cursor: hand" src="images/timedown.gif" border="0" onclick="initSoltVg('ioPaths','1')"></td>
								</tr>
							</table>
						</th>
																							
						<th width="90px">
							<table class="table_style3_SOC">
								<tr>
									<td rowspan="2">
											HBA Path
									</td>
									<td valign="bottom"><img style="cursor: hand" src="images/timeup.gif" border="0" onclick="initSoltVg('hbaPath','0')"></td>
								</tr>
								<tr>
									<td valign="top"><img style="cursor: hand" src="images/timedown.gif" border="0" onclick="initSoltVg('hbaPath','1')"></td>
								</tr>
							</table>
						</th>
						
						<th width="90px">
							<table class="table_style3_SOC">
								<tr>
									<td rowspan="2">
											Symm SN
									</td>
									<td valign="bottom"><img style="cursor: hand" src="images/timeup.gif" border="0" onclick="initSoltVg('symmSn','0')"></td>
								</tr>
								<tr>
									<td valign="top"><img style="cursor: hand" src="images/timedown.gif" border="0" onclick="initSoltVg('symmSn','1')"></td>
								</tr>
							</table>
						</th>
						<th width="90px">
							<table class="table_style3_SOC">
								<tr>
									<td rowspan="2">
											Sym FA Port
									</td>
									<td valign="bottom"><img style="cursor: hand" src="images/timeup.gif" border="0" onclick="initSoltVg('symFaPort','0')"></td>
								</tr>
								<tr>
									<td valign="top"><img style="cursor: hand" src="images/timedown.gif" border="0" onclick="initSoltVg('symFaPort','1')"></td>
								</tr>
							</table>
						</th>
						<th width="150px">
							<table class="table_style3_SOC">
								<tr>
									<td rowspan="2">
											Sym Logical Device
									</td>
									<td valign="bottom"><img style="cursor: hand" src="images/timeup.gif" border="0" onclick="initSoltVg('symLogicalDevice','0')"></td>
								</tr>
								<tr>
									<td valign="top"><img style="cursor: hand" src="images/timedown.gif" border="0" onclick="initSoltVg('symLogicalDevice','1')"></td>
								</tr>
							</table>
						</th>
						</tr>
					</table>
					
						
						<div style="overflow-y:auto;height:350px;">
						<table class="table_style2_SOC" style="" >
						<logic:present name="IGCOM03191VO" property="vgPvMetaInfoList">
							<logic:iterate id="beanList" name="IGCOM03191VO" property="vgPvMetaInfoList" indexId="index" type="com.deliverik.framework.soc.asset.SOC0131Info">
							<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
									<td width="50px">
										${index+1}
									</td>
									<% 
										String[] vgName=beanList.getVgName().split("_");
									%>
									<td width="90px"><%=vgName[vgName.length-1]%></td>
									<td width="100px">${beanList.pseudoName}</td>
									<td width="90px">${beanList.ioPaths}</td>
									<td width="90px">${beanList.hbaPath}</td>
									<td width="90px">${beanList.symmSn}</td>
									<td width="90px">${beanList.symFaPort}</td>
									<td width="150px">${beanList.symLogicalDevice}</td>
							</tr>
							</logic:iterate>
							</logic:present>
						</table>
						</div>
				</div>
				</div>
		</div>
		</div>
<script type="text/javascript">
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
var TabbedPanels2 = new Spry.Widget.TabbedPanels("TabbedPanels2");
</script>

</div>
<!--footer 底部-->
</div>

</body>
</html:html>
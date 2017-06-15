<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.util.SVCHelper"%>
<html:html>
<bean:define id="id" value="IGVIR1004" toScope="request" />
<bean:define id="title" value="首页"  toScope="request" >

</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<link type="text/css" href="css/vim_Index.css" rel="stylesheet"/>

<!-- /header1 -->


<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />

	<div id="Content" >
		<div id="LeftPanel" class="dvPanel">
			<div id="Navi" class="dvSerMenu">
				<div class="dvTitle"><div class="titText">服务目录</div></div>
				<div id="Menu">
					<ul>
						<li><a href="IGVIR0801.do"><img alt="" src="./images/vim04.gif"/> 个人资源情况</a></li>
						<li><a href="IGVIR0803.do"><img alt="" src="./images/vim05.gif"/> 部门资源情况</a></li>
						<li><a href="IGCOM0202.do?linkID=IGVIR1104"><img alt="" src="./images/vim08.gif"/> 项目资源情况</a></li>
						<li><a href="IGCOM0202.do?linkID=IGVIR1104"><img alt="" src="./images/vim09.gif"/> 个人资源计费</a></li>
						<li><a href="IGCOM0202.do?linkID=IGVIR1105"><img alt="" src="./images/vim10.gif"/> 部门资源计费</a></li>
						<li><a href="IGCOM0202.do?linkID=IGVIR1103"><img alt="" src="./images/vim11.gif"/> 项目资源计费</a></li>
						<li><a href="IGVIR1201.do"><img alt="IGVIR1201.do" src="./images/vim12.gif"/> 资源分配情况</a></li>
					</ul>
				</div>
			</div>
			<div id="ResouceInfo" class="dvblock">
				<div class="dvTitle">
					<div class="titText">资源概况</div>
<!-- 					<div class="dvMore"><a href="#">more&gt;&gt;</a></div> -->
				</div>
				<div class="dvContent" >
					<table class="rs_tb_style" style="height: 170px;">
						<tr>
						<th>Host总数</th><td>3个</td></tr><tr>
						<th>VM总数</th><td>3个</td></tr><tr>
						<th>用户总数</th><td>5人</td></tr><tr>
						<th>部门总数</th><td>1个</td></tr><tr>
						<th>项目总数</th><td>4个</td></tr><tr>
						</tr>
					</table>
				</div>
			</div>
			
		</div>
		<div id="Main" class="dvPanel">
			
			<div id="My" style="width:453px; height:131px;float: left;" class="dvblock">
				<div class="dvTitle">
					<div class="titText">待处理工作</div>
<!-- 					<div class="dvMore"><a href="#">more&gt;&gt;</a></div> -->
				</div>
				<div class="dvContent">
					<table class="table_style">
						<tr>
							<th>状态</th><th>申请内容</th><th>申请时间</th><th>处理人</th><th>项目名称</th>
						</tr>
						<tr>
							<td></td>		
							<td>111</td>
							<td>111</td>
							<td>111</td>
							<td><ig:publicProcessInfoValue pidname="项目名称" prid="1111"/> </td>
						</tr>
					</table>
				</div>
			</div>
			<!-- 模板信息 -->
			<div id="MyTemplate" class="dvblock" style="width: 290px;height:131px; margin: 0px;">
				<div class="dvTitle">
					<div class="titText">模板资源</div>
				</div>
				<div class="dvContent">
					<table class="table_style" >
						<tr><th>模板名称</th><th>CPU数量</th><th>内存(Gb)</th><th>硬盘(Gb)</th></tr>
						<tr>
							<td title="111"  style="overflow: hidden; white-space:nowrap; text-overflow:ellipsis;">111</td>
							<td>111</td>
							<td>111</td>
							<td>1111</td>
						</tr>
						<tr>
							<td title="111"  style="overflow: hidden; white-space:nowrap; text-overflow:ellipsis;">111</td>
							<td>111</td>
							<td>111</td>
							<td>1111</td>
						</tr>
						<tr>
							<td title="111"  style="overflow: hidden; white-space:nowrap; text-overflow:ellipsis;">111</td>
							<td>111</td>
							<td>111</td>
							<td>1111</td>
						</tr>
					</table>
				</div>
			</div>
			<div id="Resouce" class="dvblock" style="width: 758px;height:160px; margin: 0px;">
				<div class="dvTitle">
					<div class="titText">虚机资源</div>
				</div>
				<div style="overflow-x:scroll; overflow-y:hidden; height:130px;width: 758px;">
					<div style=" height:122px; width:1010px;">
					<div class="dvblock_vcd_vm" style="width: 240px;height:100px; margin: 5px;">
						<table align="left">
							<tr>
								<td rowspan="2">
									<img src="images/vim/vm.png" width="75" height="50" style="vertical-align: middle;"/>
								</td>
								<td style="text-align: left;">
								<span style="font-weight: bold;font-size: 15px;">VM_V001</span>
								</td>
							</tr>
							<tr>
								<td>
								<img src="images/vim/start.png" width="15" height="15" style="vertical-align: middle;"/>启动 
								&nbsp;&nbsp;
								<img src="images/vim/stop.png" width="15" height="15" style="vertical-align: middle;"/>停止
								</td>
							</tr>
							<tr >
								<td>&nbsp;<img src="images/vim/cpu.png" width="18" height="18" style="vertical-align: middle;"/>
								CPU:2.52GHZ&nbsp;&nbsp;&nbsp;</td>
								
								<td><img src="images/vim/mem.png" width="18" height="18" style="vertical-align: middle;"/>
								内存:2.0GB</td>
							</tr>
							<tr>
								<td><img src="images/vim/storage.png" width="18" height="18" style="vertical-align: middle;"/>
								硬盘:250.2GB</td>
							</tr>
						</table>
					</div>
					
					<div class="dvblock_vcd_vm" style="width: 240px;height:100px; margin: 5px;">
						<table align="left">
							<tr>
								<td rowspan="2">
									<img src="images/vim/vm.png" width="75" height="50" style="vertical-align: middle;"/>
								</td>
								<td style="text-align: left;">
								<span style="font-weight: bold;font-size: 15px;">VM_V002</span>
								</td>
							</tr>
							<tr>
								<td>
								<img src="images/vim/start.png" width="15" height="15" style="vertical-align: middle;"/>启动 
								&nbsp;&nbsp;
								<img src="images/vim/stop.png" width="15" height="15" style="vertical-align: middle;"/>停止
								</td>
							</tr>
							<tr >
								<td>&nbsp;<img src="images/vim/cpu.png" width="18" height="18" style="vertical-align: middle;"/>
								CPU:2.52GHZ&nbsp;&nbsp;&nbsp;</td>
								
								<td><img src="images/vim/mem.png" width="18" height="18" style="vertical-align: middle;"/>
								内存:2.0GB</td>
							</tr>
							<tr>
								<td><img src="images/vim/storage.png" width="18" height="18" style="vertical-align: middle;"/>
								硬盘:250.2GB</td>
							</tr>
						</table>
					</div>
					<div class="dvblock_vcd_vm" style="width: 240px;height:100px; margin: 5px;">
						<table align="left">
							<tr>
								<td rowspan="2">
									<img src="images/vim/vm.png" width="75" height="50" style="vertical-align: middle;"/>
								</td>
								<td style="text-align: left;">
								<span style="font-weight: bold;font-size: 15px;">VM_V003</span>
								</td>
							</tr>
							<tr>
								<td>
								<img src="images/vim/start.png" width="20" height="20" style="vertical-align: middle;"/>启动 
								&nbsp;&nbsp;
								<img src="images/vim/stop.png" width="20" height="20" style="vertical-align: middle;"/>停止
								</td>
							</tr>
							<tr >
								<td>&nbsp;<img src="images/vim/cpu.png" width="18" height="18" style="vertical-align: middle;"/>
								CPU:2.52GHZ&nbsp;&nbsp;&nbsp;</td>
								
								<td><img src="images/vim/mem.png" width="18" height="18" style="vertical-align: middle;"/>
								内存:2.0GB</td>
							</tr>
							<tr>
								<td><img src="images/vim/storage.png" width="18" height="18" style="vertical-align: middle;"/>
								硬盘:250.2GB</td>
							</tr>
						</table>
					</div>
					<div class="dvblock_vcd_vm" style="width: 240px;height:100px; margin: 5px;">
						<table align="left">
							<tr>
								<td rowspan="2">
									<img src="images/vim/vm.png" width="75" height="50" style="vertical-align: middle;"/>
								</td>
								<td style="text-align: left;">
								<span style="font-weight: bold;font-size: 15px;">VM_V004</span>
								</td>
							</tr>
							<tr>
								<td>
								<img src="images/vim/start.png" width="15" height="15" style="vertical-align: middle;"/>启动 
								&nbsp;&nbsp;
								<img src="images/vim/stop.png" width="15" height="15" style="vertical-align: middle;"/>停止
								</td>
							</tr>
							<tr >
								<td>&nbsp;<img src="images/vim/cpu.png" width="18" height="18" style="vertical-align: middle;"/>
								CPU:2.52GHZ&nbsp;&nbsp;&nbsp;</td>
								
								<td><img src="images/vim/mem.png" width="18" height="18" style="vertical-align: middle;"/>
								内存:2.0GB</td>
							</tr>
							<tr>
								<td><img src="images/vim/storage.png" width="18" height="18" style="vertical-align: middle;"/>
								硬盘:250.2GB</td>
							</tr>
						</table>
					</div>
					
					</div>
				</div>
			</div>
			
			<div class="dvblock" style="width:758px; height:110px;float: left;margin-top: 10px;" >
				<div class="dvTitle">
					<div class="titText">资源使用状况</div>
				</div>
				<div class="dvContent">
					<table class="table_style">
						<tr>
							<th>序号</th><th>VDC名称</th><th>CPU使用</th><th>内存使用</th><th>硬盘使用</th>
						</tr>
						<tr>
							<td>1</td>		
							<td>test</td>
							<td>2.42GHZ</td>
							<td>4.0GB</td>
							<td>200.0GB</td>
						</tr>
						<tr>
							<td>2</td>		
							<td>test</td>
							<td>2.42GHZ</td>
							<td>4.0GB</td>
							<td>200.0GB</td>
						</tr>
					</table>
				</div>
			</div>
			
			<div id="Resouce" class="dvblock" style="width: 758px;height:160px; margin: 0px;">
				<div class="dvTitle">
					<div class="titText">主机资源</div>
				</div>
				<div style="overflow-x:scroll; overflow-y:hidden; height:130px;width: 758px;">
					<div style=" height:122px; width:1010px;">
					<div class="dvblock_vcd_host" style="width: 365px;height:100px; margin: 5px;">
						<table align="left">
							<tr>
								<td rowspan="2">
									<img src="images/vim/vm.png" width="75" height="50" style="vertical-align: middle;"/>
								</td>
								<td style="text-align: left;">
								<span style="font-weight: bold;font-size: 15px;">HOST001</span>
								</td>
							</tr>
							<tr>
								<td>
									<span>IP：192.168.1.106</span>
								</td>
							</tr>
							<tr >
								<td>&nbsp;<img src="images/vim/cpu.png" width="18" height="18" style="vertical-align: middle;"/>
								CPU:2.52GHZ&nbsp;&nbsp;&nbsp;</td>
								
								<td><img src="images/vim/mem.png" width="18" height="18" style="vertical-align: middle;"/>
								内存:2.0GB</td>
							</tr>
							<tr>
								<td><img src="images/vim/storage.png" width="18" height="18" style="vertical-align: middle;"/>
								硬盘:250.2GB</td>
							</tr>
						</table>
					</div>
					<div class="dvblock_vcd_host" style="width: 365px;height:100px; margin: 5px;">
						<table align="left">
							<tr>
								<td rowspan="2">
									<img src="images/vim/vm.png" width="75" height="50" style="vertical-align: middle;"/>
								</td>
								<td style="text-align: left;">
								<span style="font-weight: bold;font-size: 15px;">HOST002</span>
								</td>
							</tr>
							<tr>
								<td>
									<span>IP：192.168.1.106</span>
								</td>
							</tr>
							<tr >
								<td>&nbsp;<img src="images/vim/cpu.png" width="18" height="18" style="vertical-align: middle;"/>
								CPU:2.52GHZ&nbsp;&nbsp;&nbsp;</td>
								
								<td><img src="images/vim/mem.png" width="18" height="18" style="vertical-align: middle;"/>
								内存:2.0GB</td>
							</tr>
							<tr>
								<td><img src="images/vim/storage.png" width="18" height="18" style="vertical-align: middle;"/>
								硬盘:250.2GB</td>
							</tr>
						</table>
					</div>
					</div>
				</div>
			</div>

		</div>
		</div>
	</div>
	
</body>


<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	var jQ = jQuery.noConflict(true);
</script>

<script type="text/javascript" src="js/highcharts/highcharts.js"></script>
<script type="text/javascript" src="js/highcharts/modules/exporting.js"></script>
<script type="text/javascript">

</script>
</html:html>

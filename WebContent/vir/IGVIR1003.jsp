<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.util.SVCHelper"%>
<html:html>
<bean:define id="id" value="IGVIR1003" toScope="request" />
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

	<div id="Content">
		<div id="LeftPanel" class="dvPanel">
			<div id="Navi"  class="dvSerMenu">
			<div class="dvTitle"><div class="titText">服务目录</div></div>
			<div id="Menu">
				<ul>
					
					<li><a href="IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01002&ptid=8&actname=ACT17VIR0201"><img alt="" src="./images/vim01.gif"/> 资源使用申请</a></li>
					<li><a href="IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01003&ptid=8&actname=ACT17VIR0301"><img alt="" src="./images/vim02.gif"/> 资源调整申请</a></li>
					<li enable ="false"><a ><img alt="" src="./images/vim03g.gif"/> 资源回收申请</a></li>
					<li><a href="IGVIR0802.do?searchType=user"><img alt="" src="./images/vim04.gif"/> 我的个人资源</a></li>
					<li><a href="IGVIR0802.do?searchType=org"><img alt="" src="./images/vim05.gif"/> 我的部门资源</a></li>
					<li enable ="false"><a><img alt="" src="./images/vim06g.gif"/> 我的待回收资源</a></li>
					<li enable ="false"><a><img alt="" src="./images/vim07g.gif"/> 部门待回收资源</a></li>
				</ul>
			</div>
			</div>
			<div id ="Figure"  class="dvblock">
				<div class="dvTitle"><div class="titText">虚拟化资源费用统计</div></div>
				<div class="dvContent">
					<table class="tbFigure" >
						<tr><td class="tdTitle">个人状况统计(单位:元)</td></tr>
						<tr><td id="tdPerFigure" class="tdContent">0</td></tr>
					</table>
					<table class="tbFigure" >
						<tr><td class="tdTitle">部门状况统计(单位:元) </td></tr>
						<tr><td id="tdOrgFigure" class="tdContent">0</td></tr>
					</table>
				</div>
			</div>
		</div>
		<div id="Main" class="dvPanel">
			<div id="My"  class="dvblock" style="width:453px; height:251px;">
				<div class="dvTitle">
					<div class="titText">资源申请状况</div>
				</div>
				<div class="dvContent">
					<table class="table_style">
						<tr>
							<th>序号</th><th>状态</th><th>申请内容</th><th>申请时间</th><th>项目名称</th>
						</tr>
								<tr>
								<td>1</td>
									<!-- 状态 -->
									<td>审批</td>
									<!-- 申请内容 -->
									<td>111111 </td>
									<!-- 申请时间 -->
									<td>1111</td>
									<!-- 项目名称 -->
									<td>1111</td>
								</tr>
					</table>
				</div>
			</div>
			<div id="MyTemplate" class="dvblock" style="width: 290px;height:251px; margin: 0px;">
				<div class="dvTitle">
					<div class="titText">模板资源</div>
				</div>
				<div class="dvContent">
					<table class="table_style" >
						<tr><th>模板名称</th><th>CPU数量</th><th>内存(Gb)</th><th>硬盘(Gb)</th></tr>
								<tr>
									<td style="overflow: hidden; white-space:nowrap; text-overflow:ellipsis;">23111</td>
									<td>1111</td>
									<td>1111</td>
									<td>1111</td>
								</tr>
						
					</table>
				</div>
			</div>
			<div id="Resouce" class="dvblock" style="width: 758px;height:250px; margin: 0px;">
				<div class="dvTitle">
					<div class="titText">虚机资源</div>
				</div>
				<div style="overflow-x:scroll; overflow-y:hidden; height:130px;width: 758px;">
					<div style=" height:122px; width:1010px;">
					<div class="dvblock_vcd_vm" style="width: 240px;height:100px; margin: 5px;background-color:#EEEEEE;">
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
					<div class="dvblock_vcd_vm" style="width: 240px;height:100px; margin: 5px;background-color:#EEEEEE;">
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
					<div class="dvblock_vcd_vm" style="width: 240px;height:100px; margin: 5px;background-color:#EEEEEE;">
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
					<div class="dvblock_vcd_vm" style="width: 240px;height:100px; margin: 5px;background-color:#EEEEEE;">
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


jQ(function () {
    
   jQ(document).ready(function () {
	   
 	   var preCount = 3213;
 	   var orgCount = 37132;
	   
	   showCount(jQ("#tdPerFigure"),preCount);
	   showCount(jQ("#tdOrgFigure"),orgCount);
    	
	   //流程表格绑定点击事件
	   jQ("tr[prid]").each(function(i,t){
		   jQ(t).bind({
			   click:function(){
				   doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid='+jQ(this).attr("prid")+'&jump=78');
				   
			   },
			   mouseover:function(){
				   jQ(this).addClass("hover_td");
			   },
			   mouseout:function(){
				   jQ(this).removeClass("hover_td");
			   }
		   });
	   });
    });
    
});

//缓冲效果显示金额
function showCount(obj,targer){
	obj.timer=setTimeout(function(){
		var speed = Math.round((targer-parseInt(obj.html()))*0.8);
		if(obj.html()==targer){
			clearTimeout(obj.timer);
		}else{
			var content = (parseInt(obj.html())+speed);
			obj.html(content);
			showCount(obj,targer);
		}
		
	},15);
	
}
</script>
</html:html>

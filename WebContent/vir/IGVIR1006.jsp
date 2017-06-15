<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List" %>
<%@ page import="com.deliverik.framework.user.model.Organization" %>
<%@ page import="com.deliverik.framework.workflow.prr.model.IG160Info" %>
<%@ page import="com.deliverik.infogovernor.svc.vo.IGSVC05131VO" %>
<html:html>
<bean:define id="id" value="IGVIR1006" toScope="request" />
<bean:define id="title" value="虚拟化用户首页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link  href="css/vir/homepage/1006.css" rel="stylesheet" type="text/css"/>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
<!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="serviceCatalog">
		<div id="serviceCatelogTitle">
			服务目录
		</div>
		<div class="serviceCatelogContent">
			<ig:menuAuth actname="ACT17VIR0201">
				<img  src="images/vim/vim01.gif" align="middle">
				<a href="IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01002&ptid=8&actname=ACT17VIR0201">
					资源使用申请
				</a>				
			</ig:menuAuth>
			<ig:menuAuth actname="ACT17VIR0201" permission="false">
				<img  src="images/vim/vim01-1.gif" align="middle">
				资源使用申请				
			</ig:menuAuth>
		</div>
		<div class="serviceCatelogContent">
			<ig:menuAuth actname="ACT17VIR0301">
				<img  src="images/vim/vim02.gif" align="middle">
				<a href="IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01003&ptid=8&actname=ACT17VIR0301">
					资源调整申请
				</a>				
			</ig:menuAuth>
			<ig:menuAuth actname="ACT17VIR0301" permission="false">
				<img  src="images/vim/vim02-1.gif" align="middle">
				资源调整申请				
			</ig:menuAuth>
		</div>
		<div class="serviceCatelogContent">
			<ig:menuAuth actname="ACT17VIR0401">
				<img  src="images/vim/vim03.gif" align="middle">
				<a href="IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01004&ptid=8&actname=ACT17VIR0401">
					资源回收申请
				</a>				
			</ig:menuAuth>
			<ig:menuAuth actname="ACT17VIR0401" permission="false">
				<img  src="images/vim/vim03g.gif" align="middle">
				资源回收申请				
			</ig:menuAuth>
		</div>
		<div class="serviceCatelogContent">
			<ig:menuAuth actname="ACT20VIR0801">
				<img  src="images/vim/vim04.gif" align="middle">
				<a href="IGCOM0202.do?linkID=IGVIR0801&actname=ACT20VIR0801">
					我的个人资源
				</a>				
			</ig:menuAuth>
			<ig:menuAuth actname="ACT20VIR0801" permission="false">
				<img  src="images/vim/vim04-1.gif" align="middle">
				我的个人资源			
			</ig:menuAuth>
		</div>
		<div class="serviceCatelogContent">
			<ig:menuAuth actname="ACT20VIR0803">
				<img  src="images/vim/vim01.gif" align="middle">
				<a href="IGCOM0202.do?linkID=IGVIR0803&actname=ACT20VIR0803">
					我的部门资源
				</a>				
			</ig:menuAuth>
			<ig:menuAuth actname="ACT20VIR0803" permission="false">
				<img  src="images/vim/vim05-1.gif" align="middle">
				我的部门资源			
			</ig:menuAuth>
		</div>
		<div class="serviceCatelogContent">
			<img  src="images/vim/vim06g.gif" align="middle">
			我的待回收资源		
		</div>
		<div class="serviceCatelogContent">
			<img  src="images/vim/vim07g.gif" align="middle">
			部门待回收资源		
		</div>
	</div>
	<div id="applyforme">
		<div class="divTitle">
			<span style="display:block;float:left;">我的申请</span>
			<a style="display:block;float:right;margin-right:10px;" href="IGCOM0202.do?linkID=IGSVC0101&actname=ACT02SVC0101">更多</a>
		</div>
		<table class="table_css">
			<tr>
				<th width="15%">序号</th>
				<th width="20%">状态</th>
				<th width="40%">申请内容</th>
				<th width="25%">申请时间</th>
			</tr>
			<logic:present name="IGVIR10061VO" property="myOpenProcessList">
				<bean:size id="prSize" name="IGVIR10061VO" property="myOpenProcessList"/>
				<logic:iterate id="bean" name="IGVIR10061VO" property="myOpenProcessList" indexId="idx" 
					type="com.deliverik.framework.workflow.prr.model.IG677Info">
					<c:if test="${idx < 7 }">
						<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" style="cursor:hand;" onclick="doLook('IGPRR0102_Disp.do?prid=${bean.prid}');">
							<td>${bean.prserialnum }</td>
							<td><ig:processDefineTypeValue prid="${bean.prid}"/></td>
							<td><span style="display:block;width:100%;height:25px;line-height:25px;overflow:hidden;" title="${bean.prtitle }">${bean.prtitle }</span></td>
							<td>${bean.propentime }</td>
						</tr>
					</c:if>
				</logic:iterate>
				<c:if test="${prSize > 7 }">
					
				</c:if>
			</logic:present>
		</table>
	</div>
	<div id="template">
		<div class="divTitle">
			<span style="display:block;float:left;">模板资源</span>
			<a style="display:block;float:right;margin-right:10px;" href="javascript:openTemplateWindow();">更多</a>
		</div>
		<table class="table_css">
			<tr>
				<th width="49%">模板名称</th>
				<th width="17%">CPU</th>
				<th width="17%">内存(G)</th>
				<th width="17%">硬盘(G)</th>
			</tr>
			<logic:present name="IGVIR10061VO"  property="templateList">
				<logic:iterate id="bean" name="IGVIR10061VO"  property="templateList" indexId="idx">
					<c:if test="${idx < 7 }">
						<tr>
							<td><span title="${bean.name }" style="display:block;height:20px;width:100%;line-hieght:20px;margin-top:5px;margin-left:3px;">${bean.name }</span></td>
							<td align="center">${bean.numCPU }</td>
							<td align="center">${bean.memoryGB }</td>
							<td align="center">${bean.diskGB }</td>
						</tr>
					</c:if>
				</logic:iterate>
			</logic:present>
		</table>
	</div>
	<div id="vminfo">
		<div class="divTitle">
			虚机资源
		</div>
		<div style="height:260px;" id="slideBox" class="slideBox">
			<div id="towardsleft">
				<img src="images/towardsleft_a.gif" class="prev">
			</div>
			<div id="vmContent">
				<ul>
					<logic:present name="IGVIR10061VO" property="showOwnVMList">
						<logic:iterate id="list" name="IGVIR10061VO" property="showOwnVMList">
							<li>
								<div class="vmContentPanel">
									<logic:present name="list">
										<logic:iterate id="bean" name="list" indexId="idx">
											<div class="vmContent" style="margin-top:5px;
											<c:if test="${idx != 0 || idx != 3 }">
											margin-left:11px;
											</c:if>
											"
											>
											<div class="vmContentHead">
												<logic:equal value="poweredOn" name="bean" property="powerState">
													<img alt="状态：开机" class="vm_status" status="${bean.powerState }" name="${bean.name }" ostype="${bean.osType }" vcid="${bean.vcid }" src="images/vim/${bean.osType }on.gif" width="32" height="32" align="middle"/>
												</logic:equal>
												<logic:notEqual value="poweredOn" name="bean" property="powerState">
													<img alt="状态：关机" class="vm_status" status="${bean.powerState }" name="${bean.name }" ostype="${bean.osType }" vcid="${bean.vcid }" src="images/vim/${bean.osType }off.gif" width="32" height="32" align="middle"/>
												</logic:notEqual>
												<img alt="即将过期" src="images/AlarmClock.gif" >
												<div class="vmName">${bean.name }</div>
												<div class="vmIp">${bean.ip }</div>
											</div>
											<div class="HostContentBody">
												<table style="width: 210px;">
													<tr>
														<td valign="middle" style="width: 39px;">CUP：</td>
														<td style="width:170px;">
															<span class="vmInfoFount">${bean.cpuCores }个CPU ，已使用${bean.cpuUsage }MHz </span>
														</td>
													</tr>
													<tr>
														<td valign="middle">内存：</td>
														<td>
															<span class="vmInfoFount">${bean.memoryMB }MB ，已使用${bean.memoryUsage }MB</span>
														</td>
													</tr>
													<tr>
														<td valign="middle">硬盘：</td>
														<td>
															<span class="vmInfoFount">${bean.capacity }GB</span>
														</td>
													</tr>
												</table>
											</div>
											</div>
										</logic:iterate>
									</logic:present>
								</div>
							</li>
						</logic:iterate>
					</logic:present>
				</ul>
			</div>
			<div id="towardsright">
				<img src="images/towardsright_a.gif" class="next">
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
jQ(document).ready(function () {
	jQ(".prev").mousemove(function(){
		jQ(this).attr("src","images/towardsleft_b.gif");
	});
	jQ(".prev").mouseout(function(){
		jQ(this).attr("src","images/towardsleft_a.gif");
	});
	jQ(".next").mousemove(function(){
		jQ(this).attr("src","images/towardsright_b.gif");
	});
	jQ(".next").mouseout(function(){
		jQ(this).attr("src","images/towardsright_a.gif");
	});

	jQ(".vm_status").bind("contextmenu",function(e){   
        return false;   
	});   

	jQ(".vm_status").mousedown(function(event){
		var event = event || window.event;
		if(event.button == "2"){
			oPopUp = window.createPopup();
			var vmname = jQ(this).attr("name");
			var status = jQ(this).attr("status");
			var ostype = jQ(this).attr("ostype");
			var vcid = jQ(this).attr("vcid");
			if(status == "") return ;
			var showText = status == 'poweredOn' ? "关机" : "开机";
			var popBody = oPopUp.document.body;
			popBody.style.backgroundColor = "#FFFF99";
			popBody.style.border = "none";
			var outStr = '<html><head><meta http-equiv="Content-Type" content="text/html; charset=gb2312"><style>';
				outStr += 'html,body{margin:0px;padding:0px;border:none;}';
			    outStr += '*{font-size: 12px; font-weight:800; font-family: 宋体;color:#666666}';
			    outStr += 'a{display:blok;width:100%;height:20px;background:#fff;text-align:center;margin:0px;line-height:20px;text-decoration:none;}';
			    outStr += 'a:hover{display:blok;width:100%;height:20px;background:#ccc;text-align:center;margin:0px;line-height:20px;text-decoration:none;}';
				outStr += '</style></head>';
				outStr += '<body style="overflow:hidden;padding:0px;">';
				outStr += '<div style="border:1px solid #ccc;">';
				outStr += '<a href="javascript:parent.changeVM(\'' + vmname + '\',\'' + status + '\',\'' + ostype + '\',\'' + vcid + '\')">'+showText+'</a>';
				outStr += '</div>';
				outStr += '</body></html>';
			oPopUp.document.write(outStr);
			oPopUp.show(event.clientX,event.clientY + document.documentElement.scrollTop, 60, 22, document.body);
		}
	});
});
function changeVM(name,status, ostype, vcid){
	jQ(".vm_status[name='"+name+"']").attr("status","");
	
	jQuery.post(getAppRootUrl() + "/IGVIR1006_ChangeVM.do", "vmname=" + name + "&powerState=" + status +"&vcid=" + vcid,
		function(data){
			if("success" == data){
				if('poweredOn' == status){
					jQ(".vm_status[name='"+name+"']").attr("src","images/vim/" + ostype + "off.gif");
					jQ(".vm_status[name='"+name+"']").attr("alt","状态：关机");
					jQ(".vm_status[name='"+name+"']").attr("status","poweredOff");
				}else{
					jQ(".vm_status[name='"+name+"']").attr("src","images/vim/" + ostype + "on.gif");
					jQ(".vm_status[name='"+name+"']").attr("alt","状态：开机");
					jQ(".vm_status[name='"+name+"']").attr("status","poweredOn");
				}
			}else{
				alert("操作失败!");
				jQ(".vm_status[name='"+name+"']").attr("status",status);
			}
		}
	);
	oPopUp.hide();
}
</script>
<script type="text/javascript" src="js/SuperSlide/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript">
jQ(".slideBox").slide( { 
	mainCell:"#vmContent ul", 
	effect:"left",
	autoPlay:false,
	trigger:"click",
	easing:"swing",
	delayTime:500,
	mouseOverStop:true,
	pnLoop:false 
});
</script>
</html:html>
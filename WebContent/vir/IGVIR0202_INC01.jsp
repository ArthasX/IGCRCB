<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="title">
	<div class="name">项目信息</div>
	</div>
	<table class=table_style1 cellspacing=2 style="margin-top: 5px; width: 98%;">
		<tbody>
			
			<tr style="display: none"><th width="15%"></th>
			<td width="35%"></td>
			<th width="15%"></th>
			<td width="35%"></td>
			</tr>
			<tr>
				<th><label style="float: right" for=name><strong><span
							class=red>*</span> 项目名称：</strong></label></th>
				<td id="projectName">
				</td>
				<th><label style="float: right" for=name><strong><span
							class=red>*</span> 期望部署时间：</strong></label></th>
				<td id="expectDeployTime">
				</td>
			</tr>
			<tr>
				<th><label style="float: right" for=name><strong><span
							class=red>*</span> 项目类别：</strong></label></th>
				<td id="projectType">
				</td>
				<th><label style="float: right" for=name><strong><span
							class=red>*</span> 项目到期时间：</strong></label></th>
				<td id="projectExpireTime">
				</td>
			</tr>
			<input type="hidden" name="pid" id = "pid" />
		</tbody>
	</table>
	<div class="title">
	<div class="name"><font style="float: left;">虚机信息</font></div> 
	</div>
	<div id="vminfodiv" style="width: 98%; margin: 0 auto; height:auto!important; padding-bottom: 20px; ">
		<table id="vminfo" cellspacing="0" class="table_form" style="margin-top: 5px;" >
			<tr>
				<td><img alt="" src="./images/loding.gif"></td>
			</tr>
		</table>
	</div>
<script type="text/javascript">

	var proMap = new Array();
	function setSelVal(sel){
		sel.options[sel.selectedIndex].selected = true;
		
	}
	function getVmInfo(){
		var pid = getFormObj("项目主键").value;
		var prid = '${IGPRR01021VO.process.prid}';
		jQuery.post(getAppRootUrl() + "/IGVIR0202_GetVM.do", "pid=" + pid + "&prid=" + prid,
			function(data) {
				var table = document.getElementById("vminfo");
				var progressTable = document.getElementById("progressTable");
				var vmInfo = eval("(" +data + ")");
				var prstatus = '${IGPRR01021VO.process.prstatus}';
				// 项目信息
				var porjectInfo = vmInfo.ProjectInfo;
			 	document.getElementById("projectName").innerHTML = porjectInfo.projectName;
			 	document.getElementById("expectDeployTime").innerHTML = porjectInfo.expectDeployTime;
			 	document.getElementById("projectExpireTime").innerHTML = porjectInfo.projectExpireTime;
			 	document.getElementById("projectType").innerHTML = porjectInfo.projectType;
			 	document.getElementById("pid").value = porjectInfo.id;
				table.deleteRow(0);
				
				// 遍历虚拟信息
				jQuery.each(vmInfo.VmInfo, function (i, value) {
					var str = "<tr>" + 
							  "<td rowspan='4' align='center' style='width:50px;'>" + 
							  (i + 1) + 
							  "<input type='hidden' name='vmids' value='" + 
							  value.id + 
							  "'/>" + 
							  "</td>" + 
							  "<th align='center' style='width:150px;'>vCenter</th>" + 
							  "<td align='center' style='width:150px;'>" + 
							  value.vcName + 
							  "</td>" +
							  "<th align='center' style='width:150px;'>虚机模板</th>" + 
							  "<td align='center' style='width:150px;'>" + 
							  value.templateName + 
							  "</td>" + 
							  "<th align='center' style='width:150px;'>虚机名称</th>" + 
							  "<td align='center' style='width:150px;'>" + 
							  value.vmName + 
							  "</td>" + 
							  "</tr>";
					if(prstatus == "Y"){
						var dc_sels = "<option value=''></option>";
						var par = {};
						par.vcid = value.vcid;
						jQuery.ajax({
							url:"IGVIR0202_GetDataCenter.do",
							type:"POST",
							dataType :"json",
							data:par,
							cache:false,
							async:false,  
							success:function(res){
								jQuery(res).each(function(i,t){
									dc_sels += "<option value='" + t.name + "'>" + t.name + "</option>";
								});
							},
							error:function(XMLHttpRequest, textStatus, errorThrown){
								//alert('出错了');
							}
						});
						var resourcePoolName = "<option value=''></option>";
						jQuery.ajax({
							url:"IGVIR0202_GetResourcePool.do",
							type:"POST",
							dataType :"json",
							data:par,
							cache:false,
							async:false,  
							success:function(res){
								jQuery(res).each(function(i,t){
									resourcePoolName += "<option value='" + t.value + "'>" + t.label + "</option>";
								});
							},
							error:function(XMLHttpRequest, textStatus, errorThrown){
								//alert('出错了');
							}
						});
						str += "<tr>" + 
							   "<th align='center' style='width:150px;'>数据中心</th>" + 
							   "<td align='center' style='width:150px;'>" + 
							   "<select name='datacenterNames' style='width:100px;' onchange=\"getNetWorkList(this, '" + 
							   value.vcid + 
							   "')\">" + 
							   dc_sels + 
							   "</select>" + 
							   "</td>" + 
							   "<th align='center' style='width:150px;'>资源池</th>" + 
							   "<td align='center' style='width:150px;'>" + 
							   "<select name='resourcePoolNames' style='width:100px;'>" + 
							   resourcePoolName + 
							   "</select>" + 
							   "</td>" + 
							   "<th align='center' style='width:150px;'>所在网络</th>" +
							   "<td align='center' style='width:150px;'>" + 
							   "<select name='networkNames' style='width:100px;'><option></option></select>" +
							   "</td>" + 
							   "</tr>";
							   
					} else {
						str += "<tr>" +
							   "<th align='center' style='width:150px;'>数据中心</th>" + 
							   "<td align='center' style='width:150px;'>" + 
							   value.datacenterName + 
							   "</td>" + 
							   "<th align='center' style='width:150px;'>资源池</th>" + 
							   "<td align='center' style='width:150px;'>" + 
							   value.resourcePoolName +
							   "</td>" +
							   "<th align='center' style='width:150px;'>所在网络</th>" +
							   "<td align='center' style='width:150px;'>" + 
							   value.networkName +
							   "</td>" + 
							   "</tr>";
					}
					str += "<tr>" + 
						   "<th align='center' style='width:150px;'>CPU（个）</th>" + 
						   "<td align='center' style='width:150px;'>" + 
						   value.vmCpus +
						   "</td>" + 
						   "<th align='center' style='width:150px;'>内存（G）</th>" +
						   "<td align='center' style='width:150px;'>" + 
						   value.vmMem + 
						   "</td>" + 
						   "<th align='center' style='width:150px;'>硬盘（G）</th>" + 
						   "<td align='center' style='width:150px;'>" + 
						   value.vmDisk + 
						   "</td>" + 
						   "</tr>";
				    var applyTime = value.applyTime;
					if ("undefined" == value.applyTime || undefined == value.applyTime) {
						applyTime = "";
					}
					var pro = "";
					if ("-1" === value.progress) {
						pro = "失败";
					} else if ("100" === value.progress) {
						pro = "成功";
					}
					str += "<tr>" + 
						   "<th align='center' style='width:150px;'>部署时间</th>" + 
						   "<td align='center' style='width:150px;'>" + 
						   applyTime + 
						   "</td>" + 
						   "<th align='center' style='width:150px;'>到期时间</th>" + 
						   "<td align='center' style='width:150px;'>" + 
						   value.expiryTime + 
						   "</td>" + 
						   "<th align='center' style='width:150px;'>进度</th>" + 
						   "<td align='center' style='width:150px;'>" + 
						   "<div style='foat:left;' id='progressBar_" +
						   value.id + 
						   "'>" +
						   "</div>" +
						   "<div style='foat:left;' id='vmprogress_" + 
						   value.id + 
						   "'>" + 
						   pro +
						   "</div>" +
						   "</td>" + 
						   "</tr>";
					jQuery(table).append(str);
				 });
			});
	}
	getVmInfo();
	
	
	function getNetWorkList(hostSel, vcid){
		var tr = hostSel.parentNode.parentNode;
		var netList_sel = tr.cells[5].childNodes[0]; // 硬盘
		netList_sel.options.length = 0;  
		netList_sel.options.add(new Option("", ""));
		if(hostSel.value === ""){
			return;
		}
		jQuery.post(getAppRootUrl() + "/IGVIR0202_GetNetList.do", "vcid=" + vcid + "&hostip=" + hostSel.value, function (data) {
			var netList_json = eval("(" +data + ")");
			jQuery.each(netList_json, function (i, value) { 
				netList_sel.add(new Option(value.name, value.name));
			});
		});
	}
	
	var test = 1;
	var intId;
	jQuery(document).ready(function(){
		var prstatus = '${IGPRR01021VO.process.prstatus}';
		if (prstatus == "W") {
			intId=self.setInterval("getProgress()",4000);
		}
	});
	function getProgress(){
		var pid = getFormObj("项目主键").value;
		var refreshFlag = '0';
		jQuery("div[id^='vmprogress_']").each(function(){
			if(jQuery(this).text()!='成功'){
				refreshFlag = '1';
				return;
			}
		});
		if (refreshFlag == '0') {
			window.location = "IGPRR0102_Disp.do?prid=" + ${IGPRR01021VO.process.prid};
		}
		if(refreshFlag == '1'){
			var par = {};
			par.pid = pid;
			jQuery.ajax({
				url:"IGVIR0203_GETPROGRESS.do",
				type:"POST",
				dataType :"json",
				data:par,
				cache:false,
				success:function(res){
					jQuery(res).each(function(i,t){
						if(jQuery("#vmprogress_"+t.id).length>0){
							var str = t.progress;
							if(str==null || str==undefined || str==''){
								str = '0';
							}
							var id = "progressBar_" + t.id;
							if(!proMap[t.id]){
								manualPB2 = new JS_BRAMUS.jsProgressBar(
										$(id), 0,
										{barImage	: Array(
												'js/jsprogressbar/images/bramus/percentImage_back4.png',
												'js/jsprogressbar/images/bramus/percentImage_back3.png',
												'js/jsprogressbar/images/bramus/percentImage_back2.png',
												'js/jsprogressbar/images/bramus/percentImage_back1.png'
											),
											onTick : function(pbObj) {
												switch(pbObj.getPercentage()) {
													case 98:
	//				 									alert('Hey, we\'re at 98!');
													break;
													case 100:
	//				 									alert('Progressbar full at 100% ... maybe do a redirect or sth like that here?');
													break;
	
												}
												return true;
											}
										}
									);
								proMap[t.id] = manualPB2;
							}
							var pro ;
							if ("-1" == str) {
								pro = "异常";
							} else if ("100" == str) {
								pro = "成功";
								proMap[t.id].setPercentage(100);
							} else {
								proMap[t.id].setPercentage(str);
								pro = "";
							}
							jQuery("#vmprogress_"+t.id).text(pro);
						}
					});
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					//alert('出错了');
				}
			});
		}else{
				
		}
	}
	
</script>
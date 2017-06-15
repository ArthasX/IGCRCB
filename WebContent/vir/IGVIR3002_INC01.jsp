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
	<div class="name"><font style="float: left;">虚机信息</font> <c:if test="${IGPRR01021VO.process.prstatus == 'W'}"> <a style="float: right; cursor: pointer;" onclick="showlayer_notice()">查看进度</a></c:if></div> 
	</div>
	<div id="vminfodiv" style="width: 98%; margin: 0 auto; height:auto!important; padding-bottom: 20px; ">
		<table id="vminfo" cellspacing="0" class="table_form" style="margin-top: 5px; width: 960px;" >
			<tr>
				<th style="text-align: center;" width="3%">序号</th>
				<th style="text-align: center;" width="10%">vCenter</th>
				<th style="text-align: center;" width="10%">虚机模板</th>
				<th style="text-align: center;" width="10%">虚机名称</th>
				<th style="text-align: center;" width="5%">CPU&#40;个&#41; </th>
				<th style="text-align: center;" width="5%">内存&#40;G&#41;</th>
				<th style="text-align: center;" width="5%">硬盘&#40;G&#41;</th>
				<th style="text-align: center;" width="5%">部署时间</th>
				<th style="text-align: center;" width="5%">到期时间</th>
				<th style="text-align: center;" width="5%">进度</th>
			</tr>
			<tr>
				<td colspan="11"> <img alt="" src="./images/loding.gif"></td>
			</tr>
		</table>
	</div>

<style type="text/css">
<!--
.layer_notice{
	float:left; 
	height:225px; 
	width:530px;  
	overflow:hidden;  
	background:#ffffff; 
	padding:10px; 
	overflow: auto; 
	display: none; 
	z-index: 29891015;
	border-bottom: solid 1px #919EAF;
}

-->
</style>
<div class="layer_notice" >

	<table id="progressTable" width="98%" cellspacing="0" class="table_form" style="background-color: white;">
		<tr>
			<th width="20%">虚机名称</th>
			<th width="20%" style="display: none;">所在主机</th>
			<th width="60%">进度</th>
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
		jQuery.post(getAppRootUrl() + "/IGVIR3002_GetVM.do", "pid=" + pid + "&prid=" + prid,
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
				table.deleteRow(1);
				
				
				// 遍历虚拟信息
				jQuery.each(vmInfo.VmInfo, function (i, value) { 
					var currentRows = table.rows.length; 
					var insertTr = table.insertRow(currentRows);
					var insertTd = insertTr.insertCell(0);
					insertTd.style.textAlign="center";
					insertTd.innerHTML = (i+1) + "<input type='hidden' name='vmids' value='" + value.id + "'>";
					
					insertTd = insertTr.insertCell(1);
					insertTd.style.textAlign="center";
					insertTd.innerHTML = value.vcname;
					
					insertTd = insertTr.insertCell(2);
					insertTd.style.textAlign="center";
					insertTd.innerHTML = value.templateid;
					
					insertTd = insertTr.insertCell(3);
					insertTd.style.textAlign="center";
					insertTd.innerHTML = value.vmName;							
					
					insertTd = insertTr.insertCell(4);
					insertTd.style.textAlign="center";
					insertTd.innerHTML = value.vmCpus;
					
					insertTd = insertTr.insertCell(5);
					insertTd.style.textAlign="center";
					insertTd.innerHTML = value.vmMem;
					
					insertTd = insertTr.insertCell(6);
					insertTd.style.textAlign="center";
					insertTd.innerHTML = value.vmDisk;
					
					insertTd = insertTr.insertCell(7);
					var applyTime = value.applyTime;
					if ("undefined" == value.applyTime || undefined == value.applyTime) {
						applyTime = "";
					}
					insertTd.innerHTML = applyTime;
					insertTd = insertTr.insertCell(8);
					insertTd.innerHTML = value.expiryTime;
					insertTd = insertTr.insertCell(9);
					insertTd.style.textAlign="center";
					insertTd.id = "vmprogress_" + value.id;
					var pro = "";
					if ("-1" === value.progress) {
						pro = "失败";
					} else if ("100" === value.progress) {
						pro = "成功";
					}
					insertTd.innerHTML = pro;
					//alert(key + "   " + value.vcName);
					
					// 创建进度查询弹出层
					createProgressBar(progressTable, value);
				 });
			});
	}
	var lay ;
	function showlayer_notice(){
		lay = jQ.layer({
			shade : false,
			type : 1,
			border : [5, 0.5, '#666', true],
			area : ['auto','auto'],
			title : '部署进度',
			page : {dom : '.layer_notice'},
			zIndex : 19891,
			close : function(index){
				layer.close(index);
				//jQ('.layer_notice').show();
			}
		});

	}
	
	function createProgressBar(progressTable, vminfo){
		var currentRows = progressTable.rows.length; 
		var progressTr = progressTable.insertRow(currentRows);
		var progressTd = progressTr.insertCell(0);
		progressTd.style.textAlign="center";
		progressTd.innerHTML = vminfo.vmName;
		progressTd = progressTr.insertCell(1);
		progressTd.style.textAlign="center";
		progressTd.innerHTML = vminfo.hostName;
		progressTd.style.display="none";
		
		progressTd = progressTr.insertCell(2);
		progressTd.style.textAlign="center";
		var id = "progressBar_" + vminfo.id;
		progressTd.innerHTML = "<span id='" + id + "'>[ Loading Progress Bar ]</span>";
		
		
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
// 									alert('Hey, we\'re at 98!');
								break;
								case 100:
// 									alert('Progressbar full at 100% ... maybe do a redirect or sth like that here?');
								break;

							}
							return true;
						}
					}
				);
		proMap[vminfo.id] = manualPB2;
		//alert(proMap.length);
	}
	getVmInfo();
	
	var intId;
	jQuery(document).ready(function(){
		var prstatus = '${IGPRR01021VO.process.prstatus}';
		if (prstatus == "W") {
			showlayer_notice();
			intId=self.setInterval("getProgress()",4000);
		}
	});
	function getProgress(){
		var pid = getFormObj("项目主键").value;
		var refreshFlag = '0';
		jQuery("td[id^='vmprogress_']").each(function(){
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
						//alert(t.id);
						if(jQuery("#vmprogress_"+t.id).length>0){
							var str = t.progress;
							if(str==null || str==undefined || str==''){
								str = '0';
							}
							var pro ;
							var proSta;
							if ("-1" == str) {
								pro = "异常";
								proSta = "异常";
							} else if ("100" == str) {
								pro = "成功";
								proSta = "成功";
								proMap[t.id].setPercentage(100);
							} else {
								proMap[t.id].setPercentage(str);
								pro = str+"%";
								proSta = "部署中……";
							}
							jQuery("#vmprogress_"+t.id).text(pro);
							
							jQuery("#progressstatus_"+t.id).text(proSta);
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
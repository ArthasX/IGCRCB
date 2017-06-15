<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.util.SVCHelper"%>
<html:html>
<head>
<bean:define id="id" value="IGVIR1201" toScope="request" />
<bean:define id="title" toScope="request" value="资源分配情况" />
<title><bean:write name="id"/><bean:write name="title"/></title>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<!-- header1 -->
<link type="text/css" href="css/vim_Index.css" rel="stylesheet"/>
<link href="css/monitor/brmm.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/accordian.pack.js"></script>
<link rel="stylesheet" href="css/monitor/demo.css" type="text/css">
<link rel="stylesheet" href="css/monitor/zTreeStyle/zTreeStyle.css" type="text/css">
<script src="<html:rewrite forward='prototype-1.1.js'/>"></script>
<script src="<html:rewrite forward='common.js'/>"></script>

<style>
.table_style{    
    width:100%;    
    margin:0 auto;    
    border-collapse:collapse;     
    text-align:center; 
    table-layout:fixed;  

}    
.table_style th{ 
	color:#000000;   
    border-top:1px solid #CCCCCC;
    border-bottom:1px solid #CCCCCC; 
    background-color:#EEEEEE;
    height:20px;      
}    
.table_style td{ 
    border-bottom:1px solid #D3D3D3;
    height:18px;
    word-break: break-all; 
    word-wrap:break-word;
}
th{
	font-weight: bold;
	text-align: center;
}
</style>
</head>

<!-- /header1 -->
<body onload="init()">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script>var jQ4=jQuery.noConflict(true);</script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<!-- <script type="text/javascript"> -->
<!-- </script> -->

<script>var jQ=jQuery.noConflict(true);</script>
<script type="text/javascript" src="js/jsprogressbar/bramus/jsProgressBarHandler.js"></script>

<script type="text/javascript" src="js/jquery.ztree.core-3.4.min-vim.js"></script>
<script type="text/javascript">
var zNodes;
function getTreeData(){
	jQuery.ajax({
		url:"IGVIR1201_TREEDATA.do",
		type:"POST",
		dataType :"json",
		data:{},
		async:false,
		cache:false,
		success:function(res){
			zNodes = res;
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			//alert('出错了');
		}
	});
}
getTreeData();
var setting = {
		view: {
			selectedMulti: false,
			fontCss: getFontCss
			//showIcon: false
		},
		async: {
			enable: true,
			url:null,
			autoParam:["id=nid", "name=nname"],
			dataFilter: null
		},
		callback: {
			beforeClick: beforeClick,
			beforeAsync:beforeAsync,
			onAsyncSuccess:onAsyncSuccess
			//onClick:ztreeOnClick
		},
		data: {
			simpleData: {
				enable: true
			}
		}
	};
	function filter(treeId, parentNode, childNodes) {
		if (!childNodes) return null;
		return childNodes;
		
	}
	function ztreeOnClick(treeId, treeNode){
	}
	function beforeClick(treeId, treeNode) {
		var nlv=treeNode.level;
		var nid=treeNode.id;
		if(nlv>0){//判断不是第一个结点
			//alert(nid);
			//jQuery("#Main").show();
			getPageData(nid);
		}
	}
	function onAsyncSuccess(event, treeId, treeNode, msg){
	} 


	//
	function beforeAsync(treeId, treeNode){
		var nlv=treeNode.level;
		var nid=treeNode.id;
		if(nlv>0){//判断不是第一个结点
			return true;
		}else{
			return false;
		}
	}
	//修改结点样式
	function updateNodes(highlight,type) {
		var zTree = $.fn.zTree.getZTreeObj("ztreemenu");
		for( var i=0, l=nodeList.length; i<l; i++) {
			//判断是否是第二结点
			var level=nodeList[i].level;
			if(level==0){
				nodeList[i].highlight = highlight;
				zTree.updateNode(nodeList[i]);
				if(type==0){
					//zTree.selectNode(nodeList[i],false);
					if(i==0){
						var curNodes=nodeList[i].children;
						for(var j=0;j<curNodes.length;j++){
								zTree.selectNode(curNodes[j],false);
								beforeClick(curNodes[j].id,curNodes[j]); 
						}
					}
				}
			}
			else if(level==1){ 
				nodeList[i].highlight = highlight;
				zTree.updateNode(nodeList[i]);
				zTree.selectNode(nodeList[i],false);
				zTree.cancelSelectedNode(nodeList[i]);
			}
		}
	}
	//样式
	function getFontCss(treeId, treeNode) {
		return (!!treeNode.highlight) ? {color:"red", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
	}

	function oprateVM(treeId,vmName,type){
		//alert(231);
		//return;
		var par = {};
		par.treeId = treeId;
		par.vmName = vmName;
		par.type = type;
		jQuery.ajax({
			url:"IGVIR1201_OPRATE.do",
			type:"POST",
			//dataType :"json",
			data:par,
			async:false,
			cache:false,
			success:function(res){
				//刷新页面
				getPageData(treeId);
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert('出错了');
			}
		});
	}
	
	function getPageData(treeId){
		var par = {};
		par.treeId = treeId;
		jQuery.ajax({
			url:"IGVIR1201_PAGEDATA.do",
			type:"POST",
			dataType :"json",
			data:par,
			cache:false,
			success:function(res){
				var connectionState = '已连接';
				if('disconnected' == res.connectionState){
					connectionState = '未连接';
					jQuery("#connectionState_p").attr('res','images/stop.gif');
				}
				
				jQuery("#cpuStatus").text('使用:'+res.cpuUsage+'MHz  全部:'+res.cpuHz+'MHz x'+' '+res.cpuCores);
				jQuery("#memoryStatus").text('使用:'+res.memoryUsage+'MB  全部:'+res.memoryMB+'MB');
				jQuery("#capacityStatus").text('空闲:'+res.freeSpace+'GB  全部:'+res.capacity+"GB");
				jQuery("#connectionState").text(connectionState);
				
				
				var cpu_p = parseInt((parseInt(res.cpuUsage)*100)/(parseInt(res.cpuHz)*parseInt(res.cpuCores)));
				loadProgressBar('cpuStatus_p',cpu_p);
				
				var memory_p = parseInt((parseInt(res.memoryUsage)*100)/parseInt(res.memoryMB));
				loadProgressBar('memoryStatus_p',memory_p);
				
				var capacity_p = parseInt(((parseInt(res.capacity)-parseInt(res.freeSpace))*100)/parseInt(res.capacity));
				loadProgressBar('capacityStatus_p',capacity_p);
				
				jQuery("#cpu").text(res.cpuHz+'MHz x'+' '+res.cpuCores);
				jQuery("#memoryMB").text(res.memoryMB+"MB");
				jQuery("#capacityGB").text(res.capacity+"GB");
				jQuery("#vmNum").text(res.vm_num+"个");
				jQuery("#vmOnNum").text(res.vm_powereOn_num+"个");
				jQuery("#vmOffNum").text(res.vm_powereOff_num+"个");
				
				jQuery("tr[tr_flag='vm']").remove();
				jQuery(res.vmsList).each(function(i,t){
// 					var powerState = '关机';
					var powerState = '<img src="images/red_ball.png" title="已关机"/>';
					var oprate = '<img src="images/vim/start.png" style="width:20px;height:20px;cursor: pointer;" title="启动" onclick="oprateVM(\''+treeId+'\',\''+t.name+'\',1);" />';
					if('poweredOn' == t.powerState){
						powerState = '<img src="images/green_ball.png" title="已开机"/>';
						var oprate = '<img src="images/vim/stop.png" style="width:20px;height:20px;cursor: pointer;" title="关闭" onclick="oprateVM(\''+treeId+'\',\''+t.name+'\',2);" />';
					}

					var trstr = '<tr tr_flag="vm"><td>'+(i+1)+'</td><td style="text-align: center;">'
								+t.name+'</td><td>'+t.memoryMB+'MB</td><td>'+t.cpuCores+
								'个</td><td>'+t.capacity+'GB</td><td>'+t.netLabels+'</td><td>'+powerState+'</td><td>'+oprate+'</td></tr>';
					jQuery('#vmTable').append(trstr);

				});
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				//alert('出错了');
			}
		});
	}


	
	function loadProgressBar(id,percentage){
		manualPB2 = new JS_BRAMUS.jsProgressBar(
				$(id), 0,
				{barImage	: Array(
						'js/jsprogressbar/images/bramus/percentImage_back1.png',
						'js/jsprogressbar/images/bramus/percentImage_back2.png',
						'js/jsprogressbar/images/bramus/percentImage_back3.png',
						'js/jsprogressbar/images/bramus/percentImage_back4.png'
					)
				}
			);
		manualPB2.setPercentage(percentage);
	}
	
	function init(){
		jQ4.fn.zTree.init(jQ4("#ztreemenu"),setting,zNodes);
		var zTree = jQ4.fn.zTree.getZTreeObj("ztreemenu");
		var hostname = '<%=request.getParameter("hostname") %>';
		if ("" == hostname || null == hostname || 'null' == hostname) {
			jQuery(zNodes).each(function(i,t){
				if(t.pId != 0){
					zTree.selectNode(zTree.getNodeByParam("id", t.id));
					getPageData(t.id);
					return false;
				}
			});
		} else {
			zTree.selectNode(zTree.getNodeByParam("id", hostname));
			getPageData(hostname);
		}
		
	}
</script>

	<div id="Content" >
		<div id="LeftPanel" class="dvPanel">
			<div id="Navi" class="dvSerMenu" style="min-height: 400px">
<!-- 				<div class="dvTitle"><div class="titText">xxx</div></div> -->
				<div id="ztreemenu" class="ztree">
					
				</div>
			</div>
			
		</div>
		<div id="Main" class="dvPanel">
			<div id="ResouceInfo" class="dvblock">
				<div class="dvTitle">
					<div class="titText">性能</div>
<!-- 					<div class="dvMore"><a href="#">more&gt;&gt;</a></div> -->
				</div>
				<div class="dvContent" >
					<table class="rs_tb_style1">
						<tr>
							<th><img src="images/vim/cpu.png" width="18" height="18" style="vertical-align: middle;"/><label>CPU使用率</label></th>
							<th><img src="images/vim/mem.png" width="18" height="18" style="vertical-align: middle;"/>内存使用率</th>
							<th><img src="images/vim/storage.png" width="18" height="18" style="vertical-align: middle;"/>存储状态</th>
							<th><img src="images/vim/router.png" width="18" height="18" style="vertical-align: middle;"/>网络状态</th>
						</tr>
						<TR style="height: 55px">
							<TD><div id="cpuStatus_p">[ Loading Progress Bar ]</div><div id="cpuStatus">&nbsp;</div></TD>
							<TD><div id="memoryStatus_p">[ Loading Progress Bar ]</div><div id="memoryStatus">&nbsp;</div></TD>
							<TD><div id="capacityStatus_p">[ Loading Progress Bar ]</div><div id="capacityStatus">&nbsp;</div></TD>
							<TD style="width: 15%"><div><img id="connectionState_p" src="	" width="15" height="15" style="vertical-align: middle;"/></div><div id="connectionState">&nbsp;</div></TD>
						</TR>
					</table>
				</div>
			</div>
		
			<div id="Resouce" class="dvblock">
				<div class="dvTitle">
					<div class="titText">自身配置情况</div>
				</div>
				<div class="dvContent">
					<table class="rs_tb_style1">
						<tr>
							<th>CPU</th><th>内存</th><th>硬盘</th><th>vm个数</th><th>开机个数</th><th>关机个数</th>
						</tr>
						<TR>
							<TD id="cpu">&nbsp;</TD>
							<TD id="memoryMB">&nbsp;</TD>
							<TD id="capacityGB">&nbsp;</TD>
							<TD id="vmNum">&nbsp;</TD>
							<TD id="vmOnNum">&nbsp;</TD>
							<TD id="vmOffNum">&nbsp;</TD>
						</TR>
					</table>
				</div>
			</div>
			<div id="My" style="min-height:220px" class="dvblock">
				<div class="dvTitle">
					<div class="titText">VM配置列表</div>
<!-- 					<div class="dvMore"><a href="#">more&gt;&gt;</a></div> -->
				</div>
				<div class="dvContent">
					<table class="table_style" id="vmTable">
						<tr>
							<th style="width:8%;">序号</th><th style="width: 15%;">名称</th><th>内存</th><th>CPU</th><th>硬盘</th><th style="width: 15%;">网络</th><th>状态</th><th>操作</th>
						</tr>
					</table>
				</div>
			</div>
<!-- 			<input type="button" onclick="getTreeData()" value="xxxxxxxxxxx"> -->
<!-- 			<input type="button" onclick="getPageData('1_192.168.1.106')" value="yyyyyyyyyyy"> -->
		</div>
		</div>
	</div>
</body>

<script type="text/javascript">

// jQuery("#Main").hide();
// alert(jQuery(".level1").length);
// if(jQuery(".level1").length > 0){
// 	jQuery(".level1:first").attr("id");
// }	
// 	jQuery(document).ready(function(){
// 		alert(jQuery(".level1").length);
// 	});
	

</script>

</html:html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGNMS0101" toScope="request"/>
<bean:define id="title"  toScope="request">
	应用维护画面
</bean:define>
<title>IGNMS0101网络拓扑</title>
<jsp:include page="/include/header1.jsp"/>
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="js/ajax-pushlet-client.js"></script>
<script type="text/javascript" src="images/dbmswf/swfobject.js"></script>
<script type="text/javascript">
	var gid='${IGNMS0101Form.gid}';
	var gversion='${IGNMS0101Form.gversion}';
	var topotype='${IGNMS0101Form.topotype}';;
	var editModeType = '${IGNMS0101Form.editModeType}';
	var swfVersionStr = "11.0.0";
	var xiSwfUrlStr = "images/dbmswf/TopoMapNew.swf";
	var flashvars = {};
	var params = {};
	var attributes = {};
	attributes.id = "TopoMapNew";
	attributes.name = "TopoMapNew";
	params.wmode = "Opaque";
	params.allowFullScreen = "true";
	var winWidth = 1002;
    var winHeight = 742;
	
    var showtype = "";
	swfobject.embedSWF(xiSwfUrlStr,"flashContent", "1002", "742", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);
	
	//允许添加的设备类型
// 	var devType = new Array(
// 			{type:0,name:'AIX主机'},
// 			{type:1,name:'Linux主机'},
// 			{type:2,name:'Win主机'},
// 			{type:3,name:'多层交换机'},
// 			{type:4,name:'交换机'},
// 			{type:5,name:'路由器'},
// 			{type:6,name:'防火墙'},
// 			{type:7,name:'计算机'});
	
    function initApp(){
    	setTopoMapXMLStr('1');
    	//setEditModeType();
    	//setWarnPie();
    	//setWarnDG();
    }
    
	function playMovie() {
	    	//setWarnPie();
	    	//setWarnDG();
	}
	
	function setTopoMapXMLStr(showtype){
		if("undefined" === showtype){
			return;
		}
	//	alert("获取拓扑图信息");
		try{
			var res="";
			var objAjax = new Ajax.Request(getAppRootUrl() + "/IGNMS0101_ShowTopo.do",{asynchronous:false, 
				parameters: 'type=getTopoMapXML&gid=' + gid + '&gversion='+gversion + '&topotype=' + topotype + '&showtype=' + showtype,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return "";
					}
			    }
			});
			TopoMapNew.setTopoMapXMLStr(res);
		}catch(err){
			//alert("setTopoMapXMLStr('" + showtype + "')");
			setTimeout("setTopoMapXMLStr('" + showtype + "')",1000);
		}
	}
	
	function setEditModeType(){
		return editModeType + "|" + topotype;
//		TopoMapNew.setEditMode(editModeType);
		
	}
	//WarnPie
	function setWarnPie(){
		try{
			var res="";
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=WarnPieTopo',
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return "";
					}
			    }
			});
			var processArry = res.split("|");
			TopoMapNew.setWarnPie(processArry[0],processArry[1],processArry[2]);
		}catch(err){
			setTimeout("setWarnPie()",1000);
		}
	}
	//WarningDG
	function setWarnDG(){
		try{
			var res="";
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=WarnDGTopo',
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return "";
					}
			    }
			});
			TopoMapNew.setWarnDG(res);
		}catch(err){
			setTimeout("setWarnDG()",1000);
		}
	}
	
	/**
	* 保存拓扑信息
	*/
	function saveXML(updateDevice, addDevice, addRela, delDevice, delRela, renameDevice, regionStr, updateRegionStr, delRegionStr, showtype){
		//alert(updateDevice + "------" + addDevice + "------" +  addRela + "------" +  delDevice + "------" +  delRela);
		//alert(addDevice);
		var res="";
		var objAjax = new Ajax.Request(getAppRootUrl() + "/IGNMS0101_UpdateAixs.do",{asynchronous:false, 
			parameters: 'updateDevice=' + updateDevice + '&addDevice=' + addDevice + '&addRela=' + addRela + '&delDevice=' 
			+ delDevice + '&delRela=' + delRela + '&gid=' + gid + "&gversion="+gversion + "&topotype=" + topotype 
			+ "&renameDevice=" + renameDevice + "&regionStr=" + regionStr + "&updateRegionStr=" + updateRegionStr + "&delRegionStr=" + delRegionStr + "&showtype=" + showtype,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res=result;
				}else{
					return "";
				}
		    }
		});
		//alert("保存结果" + res);
		return res;
	}
	
	function addDeviceTest(){
		var ran = Math.floor(Math.random()*10+1);
		var device = "Dev" + ran + ran + "@1@192.168." + ran + "." + ran + "@aa-aa-aa-aa-aa";
		saveXML("", device, "", "", "");
	}
	//manualScanByAjax
	function manualScanByAjax(str){
		//alert("启动手动扫描");
		var res="";
		var objAjax = new Ajax.Request(getAppRootUrl() + "/manualScanByAjax.do",{asynchronous:false, 
			parameters: 'gid=' + gid,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res=result;
				}else{
					res="服务器未响应！";
				}
		    }
		});
		test();
		return res;
	}
	
	/**
	* 更新面板大小
	*/
	function updtePanelSize(panelSize){
		//alert(updateDevice + "------" + addDevice + "------" +  addRela + "------" +  delDevice + "------" +  delRela);
		var res="";
		var objAjax = new Ajax.Request(getAppRootUrl() + "/IGNMS0101_UpdatePanelSize.do",{asynchronous:false, 
			parameters: 'gid=' + gid + "&gversion="+gversion + "&topotype=" + topotype + "&panelSize=" + panelSize,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res=result;
				}else{
					return "";
				}
		    }
		});
		return res;
	}
	
	/**
	* 查询面板大小
	*/
	function getPanelSize(){
		//alert(updateDevice + "------" + addDevice + "------" +  addRela + "------" +  delDevice + "------" +  delRela);
		var res="";
		var objAjax = new Ajax.Request(getAppRootUrl() + "/IGNMS0101_getPanelSize.do",{asynchronous:false, 
			parameters: 'gid=' + gid + "&gversion="+gversion + "&topotype=" + topotype ,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res=result;
				}else{
					return "";
				}
		    }
		});
		return res;
	}
	
	//弹出页
	function showDetailInfo(eiid,eirootmark,version,smallversion){
		//openSubIGCIM0137(eiid);
		openSubIGAIM0146(eirootmark,eiid,version,smallversion,'0');
	}

	//查看性能
	function showMonitorData(eiid,eirootmark,version,smallversion){
		openSubIGMTM0603(eirootmark,eiid,version,smallversion,'0');
	}
	
	function test() {
		//alert("注册推送监听");
		PL._init();
		PL.joinListen('/Push_IGNMS0101');
	}
	
	function onData(event) {
		if('1' == event.get('doClose')){
			PL.leave();
			gversion = event.get('gversion');
			//alert("ddd" + gversion);
			TopoMapNew.scanSucessed();
		}else{
			TopoMapNew.setScanDevice(event.get('pushXML'));
		}
	}
	
// 	//设置允许添加的设备
// 	function setDevTypeMap(){
		
// 		var devTypesStr = "<?xml version='1.0' encoding='utf-8'?><root>";
// 		jQuery(devType).each(function(i,t){
// 			devTypesStr += "<date type='" + t.type + "' name='" + t.name + "' />";
// 		});
// 		devTypesStr += "</root>";
// 		return devTypesStr;
// 	}
	
	//取得设备图片途径
	function getImgUrl(){
		try{
			var res="";
			var objAjax = new Ajax.Request(getAppRootUrl() + "/IGNMS0104_GETIMGURL.do",{asynchronous:false, 
				parameters: 'type=GETIMGURL',
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}
			    }
			});
			return res;
		}catch(err){
			setTimeout("getImgUrl()",1000);
		}
	}
	
	//取得设备类型
	function getDevType(){
		try{
			var res="";
			var objAjax = new Ajax.Request(getAppRootUrl() + "/IGNMS0104_GETDEVTYPE.do",{asynchronous:false, 
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}
			    }
			});
			return res;
		}catch(err){
			setTimeout("getDevType()",1000);
		}
	}
	
	
</script>
<body style="margin: 0px;padding: 0px;" onload="window.setInterval(playMovie,300000);initApp()">
<ig:message/>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<div id="container">
<div id="flashContent">
</div>
</div>
</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<bean:define id="id" value="IGAIM0140" toScope="request" />
<bean:define id="title" value="业务应用关系分析" toScope="request" />
<!-- <title>IGAIM0140 - 业务应用关系分析</title> -->
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header1.jsp" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="images/dbmswf/swfobject.js"></script>
<script type="text/javascript">
	var gid='IGAIM0140';
	var swfVersionStr = "10.0.0";
	var xiSwfUrlStr = "images/dbmswf/BussTopoMap.swf";
	var flashvars = {};
	var params = {};
	var attributes = {};
	attributes.id = "BussTopoMap";
	attributes.name = "BussTopoMap";
	params.wmode = "Opaque";
	params.allowFullScreen = "true";
	//var winWidth = window.screen.width;
    //var winHeight = window.screen.height;

	swfobject.embedSWF(xiSwfUrlStr,"flashContent", 1002, 700, swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);
	
    function initApp(){
    	setBussTopoMapXMLStr();
    }
    
	function setBussTopoMapXMLStr(){
		try{
			var res="";
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=getBussTopoMapXML&FLEXID=BussTopoMap.swf',
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return "";
					}
			    }
			});
 			//res='<?xml version="1.0" encoding="utf-8"?><root>'
			//+'<NODE id="88888" name="中心业务系统" x="100" y="100" imgUrl="resource/image/monitor/pt.png" />'
 			//+'<NODE id="99999" name="中心服务1" x="100" y="150" imgUrl="resource/image/monitor/ywxt.png" />'
 			//+'<NODE id="66666" name="中心服务2" x="100" y="250" imgUrl="resource/image/monitor/ywxt.png" />'
 			//+'<NODE id="77777" name="OA" x="200" y="200" imgUrl="resource/image/monitor/ywxt.png" />'
 			//+'<NODE id="10101" name="test" x="200" y="200" imgUrl="resource/image/monitor/ywxt.png" />'
 			//+'<LINE id="jskfj8sfil" fromNode="88888" toNode="99999" />'
 			//+'<LINE id="jskfj8sfil23" fromNode="88888" toNode="66666" />'
 			//+'</root>';
			//alert(res);
			BussTopoMap.setBussTopoMapXMLStr(res);
		}catch(err){
			setTimeout("setBussTopoMapXMLStr()",1000);
		}
	}
	//save xml
	function saveXML(str,addRegionStr,modRegionStr, delRegionStr){
		var res="";
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=saveBussTopoMapXML&xmlstr='+str+'&isellipsis=a&FLEXID=BussTopoMap.swf'+'&addRegionStr='+addRegionStr+"&modRegionStr="+modRegionStr + "&delRegionStr=" + delRegionStr,
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					res=result;
				}else{
					return "";
				}
		    }
		});
		alert(res);
		return res;
	}
	//弹出页
	function showDetailInfo(eiid){
		//window.showModalDialog('IGAIM0148.do?EIID='+eiid, null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		location.href="IGCIM0150_Disp.do?eiid="+eiid;
		//location.href="IGAIM0149.do?EIID="+eiid;
		//openSubWindow('/IGCIM0150_Disp.do?EIID='+eiid, null, '1000', '800');
	}
</script>
<body onload="initApp()">
<jsp:include page="/include/header2.jsp" />
<div id="container" align="center">
<div id="flashContent">
</div>
</div>
</body>
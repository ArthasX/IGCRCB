<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>IGDBM0111拓扑域监控</title>
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="images/dbmswf/swfobject.js"></script>
<script type="text/javascript">
	var gid='IGDBM0111';
	var swfVersionStr = "10.0.0";
	var xiSwfUrlStr = "images/dbmswf/TopoMap.swf";
	var flashvars = {};
	var params = {};
	var attributes = {};
	attributes.id = "TopoMap";
	attributes.name = "TopoMap";
	params.wmode = "Opaque";
	//var winWidth = window.screen.width;
    //var winHeight = window.screen.height;

	swfobject.embedSWF(xiSwfUrlStr,"flashContent", 1366, 768, swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);
	
    function initApp(){
    	setTopoMapXMLStr();
    	setWarnPie();
    	setWarnDG();
    	setToolsBar();
    }
    
	function playMovie() {
	    	setWarnPie();
	    	setWarnDG();
	}
	
	function setTopoMapXMLStr(){
		//parameters: 'type=getTopoMapXMLIG'//for IGDev0.3
		//parameters: 'type=getTopoMapXML'//for zjg
		
		try{
			var res="";
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=getTopoMapXML',
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return "";
					}
			    }
			});
			TopoMap.setTopoMapXMLStr(res);
		}catch(err){
			setTimeout("setTopoMapXMLStr()",1000);
		}
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
			TopoMap.setWarnPie(processArry[0],processArry[1],processArry[2]);
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
			TopoMap.setWarnDG(res);
		}catch(err){
			setTimeout("setWarnDG()",1000);
		}
	}
	//save xml
	function saveXML(str){
		var res="";
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=saveBussTopoMapXML&xmlstr='+str+'&isellipsis=z',
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
	
	
	function setToolsBar(){
		try{
			TopoMap.setToolsBar('平台','监控','告警','摩卡','系统','机房','保存');
		}catch(err){
			setTimeout("setToolsBar('平台','监控','告警','摩卡','系统','机房','保存')",1000);
		}
	}
	
	
	//header menu
	function headerMenu(str){
		 var url = document.referrer;
		switch(str){
			case 1:setTimeout(function lk(){location.href="IGCOM0105.do?index=1";},800);break;
			case 2:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGMTM0501&actname=ACT13MTM05";},800);break;
			case 3:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGMTM0101&actname=ACT13MTM0101";},800);break;
			case 4:setTimeout(function lk(){window.open("IGCOM0202.do?linkID=IGATL0102");});break;
			case 5:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGSYS0001&actname=ACT13MTM0503";},800);break;//sys
			case 6:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGASM1101&actname=ACT01ASM1201";},800);break;
			case 7:break;//saveXML
			case 8:setTimeout(function lk(){location.href=url;},800);break;
		}
	}
	

</script>
<body style="margin: 0px;padding: 0px;" onload="window.setInterval(playMovie,300000);initApp()">
<ig:message/>
<div id="flashContent">
</div>
</body>
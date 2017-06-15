<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>IGDBM0301 - HQ监控</title>
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="images/dbmswf/swfobject.js"></script>
<script type="text/javascript">
	var gid='IGDBM0301';
	var swfVersionStr = "10.0.0";
	var xiSwfUrlStr = "images/dbmswf/HQ_DashBoard.swf";
	var flashvars = {};
	var params = {};
    params.quality = "high";
    params.bgcolor = "#ffffff";
    params.allowscriptaccess = "*";
    params.allowfullscreen = "true";
	var attributes = {};
	attributes.id = "HQDashBoard";
	attributes.name = "HQDashBoard";
	attributes.align = "middle";
	params.wmode = "Opaque";
	//var winWidth = window.screen.width;
    //var winHeight = window.screen.height;

	swfobject.embedSWF(xiSwfUrlStr,"flashContent", "1005", "742", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);

	function initApp(){
	}
	//树 列表
	function setFlexTreeData(){
		try{
 			var res="";
// 			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
// 				parameters: 'type=getTopoMapXML',
// 				 onSuccess:  function(req, json){
// 				 var result=req.responseText;
// 					if(result != null && result != ""){
// 						res=result;
// 					}else{
// 						return "";
// 					}
// 			    }
// 			});
			res="<?xml version='1.0' encoding='UTF-8' ?><root><node index='-1' name='首页列表' desc='首页列表' icon='bussImage'><node index='0' name='Mars首页' desc='呵呵' icon='appImage'></node></node></root>";
			return res;
		}catch(err){
			setTimeout("setTreeData()",1000);
		}
	}
	function setDatas(index){
		try{
 			var res="";
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=getDatasXML',
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
		}catch(err){
			setTimeout("setDatas("+index+")",1000);
		}
	}
</script>
<body style="margin:0; padding:0; overflow:auto; text-align:center; background-color: #ffffff;" onload="initApp()" >
<div id="flashContent">
</div>
</body>
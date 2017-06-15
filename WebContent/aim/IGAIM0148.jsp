<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>IGAIM0148 - 业务拓扑关系图</title>
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="images/dbmswf/swfobject.js"></script>
<script type="text/javascript">
	var gid='IGAIM0148';
	var swfVersionStr = "10.0.0";
	var xiSwfUrlStr = "images/dbmswf/Buss_FuXin_Flex_tanchu_app.swf";
	var flashvars = {};
	var params = {};
	var attributes = {};
	attributes.id = "BussTopoMap";
	attributes.name = "BussTopoMap";
	params.wmode = "Opaque";
	//var winWidth = window.screen.width;
    //var winHeight = window.screen.height;

	swfobject.embedSWF(xiSwfUrlStr,"flashContent", 1005, 705, swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);
	
    function initApp(){
    	setBussTopoMapXMLStr();
    }
    
	function setBussTopoMapXMLStr(){
		var eiidTemp="<%=request.getAttribute("RESP_EIID")%>";
		var TOPOMAP_XMLSTR = null;
 		try{
 			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=getBusinessTopoXML&eiid=' + eiidTemp,
				onSuccess:  function(req, json){
					var result=req.responseText;
					if(result != null && result != ""){
						var xmlArr = result;
						TOPOMAP_XMLSTR = xmlArr.replace("\\", "\\\\");
					}
				}
			});
			BussTopoMap.setBussTopoMapXMLStr(TOPOMAP_XMLSTR);
		}catch(err){
			setTimeout("setBussTopoMapXMLStr()",1000);
		}
	}

	//弹出页
	function showDetailInfo(eiid,eirootmark,version,smallversion){
		//openSubIGCIM0137(eiid);
		openSubIGAIM0146(eirootmark,eiid,version,smallversion);
	}

</script>
<body style="margin: 0px;padding: 0px;" onload="initApp()">
<ig:message/>
<div id="flashContent">
</div>
</body>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>IGCIM1634 - 密码拓扑关系图</title>
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="images/dbmswf/swfobject.js"></script>
<script type="text/javascript">
	var gid='IGCIM1634';
	var swfVersionStr = "10.0.0";
	var xiSwfUrlStr = "images/dbmswf/BussTopoMap_FuXinApp_tanchu_pass.swf";
	var flashvars = {};
	var params = {};
	var attributes = {};
	attributes.id = "BussTopoMap";
	attributes.name = "BussTopoMap";
	params.wmode = "Opaque";
	//var winWidth = window.screen.width;
    //var winHeight = window.screen.height;

	swfobject.embedSWF(xiSwfUrlStr,"flashContent", 800, 600, swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);
	
    function initApp(){
    	setBussTopoMapXMLStr();
    }
    
	function setBussTopoMapXMLStr(){
		var aaa="<%=request.getAttribute("topoXML")%>";
 		try{
// 			var res="";
// 			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
// 				parameters: 'type=getBussTopoMapXML',
// 				 onSuccess:  function(req, json){
// 				 var result=req.responseText;
// 					if(result != null && result != ""){
// 						res=result;
// 					}else{
// 						return "";
// 					}
// 			    }
// 			});
			BussTopoMap.setBussTopoMapXMLStr(aaa);
		}catch(err){
			setTimeout("setBussTopoMapXMLStr()",1000);
		}
	}
	//save xml
// 	function saveXML(str){
// 		var res="";
// 		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
// 			parameters: 'type=saveBussTopoMapXML&xmlstr='+str+'&isellipsis=b',
// 			 onSuccess:  function(req, json){
// 			 var result=req.responseText;
// 				if(result != null && result != ""){
// 					res=result;
// 				}else{
// 					return "";
// 				}
// 		    }
// 		});
// 		alert(res);
// 		return res;
// 	}
 	//header menu
// 	function headerMenu(str){
// 		var url = "IGCOM0202.do?linkID=IGCOM0219&actname=ACT04CIM";
// 		switch(str){
// 			//case 1:setTimeout(function lk(){location.href="IGCOM0105.do?index=1";},800);break;
// 			//case 2:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGMTM0501&actname=ACT13MTM05";},800);break;
// 			//case 3:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGMTM0101&actname=ACT13MTM0101";},800);break;
// 			//case 4:setTimeout(function lk(){window.open("IGCOM0202.do?linkID=IGATL0102");});break;
// 			//case 5:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGSYS0001&actname=ACT13MTM0503";},800);break;//sys
// 			//case 6:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGASM1101&actname=ACT01ASM1201";},800);break;
// 			case 7:break;//saveXML
// 			//case 8:setTimeout(function lk(){location.href=url;},800);break;
// 			case 8:setTimeout(function lk(){window.close();},800);break;
// 		}
// 	}
	//
// 	function initLegend(){
<%-- 		var aaa="<%=request.getAttribute("LEGEND_XMLSTR")%>"; --%>
// 		try{
// 			return aaa;
// 		}catch(err){
// 			setTimeout("initLegend()",1000);
// 		}
// 	}
// 	//弹出页
// 	function clickLegend(eiid,eirootmark,version,smallversion){
// 		//openSubIGCIM0137(eiid);
// 		openSubIGAIM0146(eirootmark,eiid,version,smallversion,'0');
// 	}

	//弹出页
	function showDetailInfo(eiid,eirootmark,version,smallversion){
		//openSubIGCIM0137(eiid);
		openSubIGAIM0146(eirootmark,eiid,version,smallversion,'0');
	}
</script>
<body style="margin: 0px;padding: 0px;" onload="initApp()">
<ig:message/>
<div id="flashContent">
</div>
</body>
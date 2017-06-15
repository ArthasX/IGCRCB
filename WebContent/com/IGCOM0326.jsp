<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Locale"%>
<%@ page import="org.apache.struts.Globals;"%>
<%
	Locale loc = Locale.getDefault();
	if (request.getSession().getAttribute(Globals.LOCALE_KEY) != null) {
		loc = (Locale) request.getSession().getAttribute(
				Globals.LOCALE_KEY);
	}
%>

<title><bean:message bundle="comResources" key="ietitle.IGCOM0326"/></title>
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<script type="text/javascript">
<!--
	var gid='IGCOM0314';
	var swfVersionStr = "10.0.0";
	var xiSwfUrlStr = "images/dbmswf/EnhancedRavisGraph_STORAGE.swf";

	<% if(loc.getLanguage().equalsIgnoreCase("en")) {%>
		xiSwfUrlStr = "images/dbmswf/EnhancedRavisGraph.swf";
	<%}%>
	var flashvars = {};
	var params = {};
	var attributes = {};
	attributes.id = "EnhancedRavisGraph";
	attributes.name = "EnhancedRavisGraph";
	params.wmode = "Opaque";
	var winWidth = 0;
    var winHeight = 0;
    //获取窗口宽度
    if (window.innerWidth)
          winWidth = window.innerWidth;
    else if ((document.body) && (document.body.clientWidth))
          winWidth = document.body.clientWidth;
    //获取窗口高度
    if (window.innerHeight)
          winHeight = window.innerHeight;
    else if ((document.body) && (document.body.clientHeight))
          winHeight = document.body.clientHeight;
  
    //通过深入Document内部对body进行检测，获取窗口大小
    if (document.documentElement  && document.documentElement.clientHeight &&
                                         document.documentElement.clientWidth)
    {
        winHeight = document.documentElement.clientHeight;
        winWidth = document.documentElement.clientWidth;
    }

	swfobject.embedSWF(xiSwfUrlStr,"flashContent", window.screen.width, window.screen.height, swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);

	function checkEntityItemInfo(eiid,eiversion,eismallversion){
		openSubIGCOM0316(eiid, eiversion, eismallversion);
	}

	function setShowDataIO(eirootmark,domainversion){
		 var res;
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=showDataIO&eirootmark='+eirootmark+'&domainversion='+domainversion,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return "";	
					}
			    }
			});
		 EnhancedRavisGraph.setShowDataIO(res);
	}

	function setShowStorageIO(eiid,domainversion){
		 var res;
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=showStorageIO&eiid='+eiid+'&domainversion='+domainversion,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return "";	
					}
			    }
			});
		 EnhancedRavisGraph.setShowStorageIO(res);
	}
	
	function changeColorByFaPort(eiid,domainversion){
		 var res;
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=changeColorByFaPort&eiid='+eiid+'&domainversion='+domainversion,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return "";	
					}
			    }
			});
		 EnhancedRavisGraph.setShowDataIOByFaPort(res);
	}

	function changeColorByFa(eiid,domainversion){
		 var res;
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=changeColorByFa&eiid='+eiid+'&domainversion='+domainversion,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return "";	
					}
			    }
			});
		 EnhancedRavisGraph.setShowDataIOByFa(res);
	}

	function changeColorByMeta(eiid,domainversion){
		 var res;
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=changeColorByMeta&eiid='+eiid+'&domainversion='+domainversion,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return "";	
					}
			    }
			});
		 EnhancedRavisGraph.setShowDataIOByMeta(res);
	}

	function changeColorByHyper(eiid,domainversion){
		 var res;
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=changeColorByHyper&eiid='+eiid+'&domainversion='+domainversion,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return "";	
					}
			    }
			});
		 EnhancedRavisGraph.setShowDataIOByHyper(res);
	}

	function changeColorByDa(eiid,domainversion){
		 var res;
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=changeColorByDa&eiid='+eiid+'&domainversion='+domainversion,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return "";	
					}
			    }
			});
		 EnhancedRavisGraph.setShowDataIOByDa(res);
	}

	function changeColorByDisk(eiid,domainversion){
		 var res;
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=changeColorByDisk&eiid='+eiid+'&domainversion='+domainversion,
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return "";	
					}
			    }
			});
		 EnhancedRavisGraph.setShowDataIOByDisk(res);
	}
	
	function checkEIRelationInfo(srpareiid,srdomainid,srdomainversion,srparversion,srparsmallversion,srcreatetime){
		//openSubIGCOM0303_Relation(eiid);
		//alert(srpareiid+","+srdomainid+","+srdomainversion+","+srparversion+","+srparsmallversion+","+srcreatetime);
		openSubIGCOM0318_Relation(srpareiid,srdomainid,srdomainversion,srparversion,srparsmallversion,srcreatetime);
	}
	
    function initApp(){
    	<logic:present name="IGCOM0314Form" property="graphXml">
        var graphXml = '<bean:write name="IGCOM0314Form" property="graphXml" filter="false"/>'; 
        EnhancedRavisGraph.initXml(graphXml);
        </logic:present>
    }
	//双击事件
	function OpenWindowByEiid(eiid){
		self.location="IGCOM0310.do?eiid="+eiid+"&domainid=&domainversion=&updatetime=&diskeiid=";//20120725 add
	}

	
//-->
</script>
<body style="margin: 0px;padding: 0px;">
<ig:message/>
<div id="flashContent">
</div>
</body>
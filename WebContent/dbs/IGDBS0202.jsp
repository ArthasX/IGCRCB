<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.Locale"%>
<%@ page import="org.apache.struts.Globals;"%>
<%
	Locale loc = Locale.getDefault();
	if (request.getSession().getAttribute(Globals.LOCALE_KEY) != null) {
		loc = (Locale) request.getSession().getAttribute(
				Globals.LOCALE_KEY);
	}
%>
<html:html>
<bean:define id="id" value="IGDBM0202" toScope="request" />
<bean:define id="title" value="EMCPerformanceChart" toScope="request" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common_<%=loc %>.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />

<script type="text/javascript">

var type = "<bean:write name='type' filter='false' />"; 
var swfVersionStr = "10.0.0";
var xiSwfUrlStr;
if("CX"==type)
{
	 xiSwfUrlStr = "images/dbmswf/SOCPerformance_CX1.swf";
}
else
{
	 var version = "<bean:write name='symm_version' filter='false' />"; 
     if(version != "" && version == "5874"){
    	 xiSwfUrlStr = "images/dbmswf/SOCPerformance2_5874.swf";
     }
     else
     {
    	 xiSwfUrlStr = "images/dbmswf/SOCPerformance2.swf";
     }
}
         var flashvars = {};
         var params = {};
         var attributes = {};
         attributes.id = "SOCPerformance2";
         attributes.name = "SOCPerformance2";
         params.wmode = "Opaque";
         swfobject.embedSWF(xiSwfUrlStr,"flashContent", "1300", "742", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);
    
		//程序初始化入口
         function initApp(){
             var strXML = "<bean:write name='strXML' filter='false' />";  

             try{        	               
            	setSOCPerformance(strXML);
	          // window.setInterval(setSOCPerformance,300000);
             }catch(err){
                // alert(err.message);
            	 setTimeout("initApp()",2000);
             }
             
         }
 
		   function getBusy(dataid,date_from,date_to,flag){
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCPerformance_V2&dataid='+dataid+'&date_from='+date_from+'&date_to='+date_to+'&flag='+flag,
	    				 onSuccess:  function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
	    			//alert(res);
				 SOCPerformance2.initXml(res);
			}		
			
			function setSOCPerformance(strXML){
				//alert(SOCPerformance2);
				SOCPerformance2.initXml(strXML);
			}		
			//调用时间查询
			function selectbytime(dataid,date_from,date_to,flag){
				//alert(dataid);
				//alert(date_from);
				//alert(date_to);
				//alert(flag);
				getBusy(dataid,date_from,date_to,flag);
			}
			//CX查询
			function selectbytime_cx(dataid,date_from,date_to,flag){
				//alert(dataid);
				//alert(date_from);
				//alert(date_to);
				getBusy_cx(dataid,date_from,date_to,flag);
			}


			function getBusy_cx(dataid,date_from,date_to,flag){
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCPerformance_cx&dataid='+dataid+'&date_from='+date_from+'&date_to='+date_to+'&flag='+flag,
	    				 onSuccess:  function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
				 SOCPerformance2.initXml(res);
			}		

</script>
        
<title><bean:write name="id"/><bean:write name="title"/></title>
<STYLE>
html{
  overflow-y: auto;
  overflow-x: auto;
}

</STYLE>
<body onload="initApp();">
<div class="box">
  <div id="flashContent">
  </div>
 </div>
</body>

</html:html>
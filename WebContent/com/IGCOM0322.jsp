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

<html:html>
<bean:define id="id" value="IGCOM0322" toScope="request" />
<bean:define id="title" value="存储关系图" toScope="request" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />
<STYLE>
 html{
  overflow-y: auto;
  overflow-x: auto;
}

</STYLE>
<script type="text/javascript">

         var swfVersionStr = "10.0.0";
         var xiSwfUrlStr = "images/dbmswf/SOCStorage.swf";
         var flashvars = {};
         var params = {};
         var attributes = {};
         attributes.id = "SOCStorage";
         attributes.name = "SOCStorage";
         params.wmode = "Opaque";
         swfobject.embedSWF(xiSwfUrlStr,"flashContent", "1000", "742", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);
    
		//程序初始化入口
         function initApp(){
           var strXML = "<bean:write name='strXML' filter='false' />";  
             try{        	               
            	setSOCStorage(strXML);

             }catch(err){

            	 setTimeout("initApp()",2000);
             }
             
         }
 
		   function getBusy(dataid,date_from,date_to,flag){
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCStorage&dataid='+dataid+'&date_from='+date_from+'&date_to='+date_to+'&flag='+flag,
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
				 SOCStorage.initXml(res);
			}		
			
			function setSOCStorage(strXML){
				//alert(SOCStorage);
				SOCStorage.initXml(strXML);
			}		
			function selectbycond(hosteiid,hostversion,hostsmallversion,metaeiid,metaversion,metasmallversion){				   
               // alert(hosteiid+","+hostversion+","+hostsmallversion+","+metaeiid+","+metaversion+","+metasmallversion);
				var content1;
		    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
		    				parameters: 'type=SOCStorage_XML&metaeiid='+metaeiid+'&metaversion='+metaversion+'&metasmallversion='+metasmallversion+
		    				                               '&hosteiid='+hosteiid+'&hostversion='+hostversion+'&hostsmallversion='+hostsmallversion,
		    				 onSuccess:  function(req, json){
		    				 var result=req.responseText;
		    					if(result != null && result != ""){
		    						content1=result;
		    					}else{
		    						return "";	
		    					}
		    		    }
		        		});				
				SOCStorage.showXml(content1);
				}	
		    function selectList(eiid,version,smallversion){
					var content1;
		    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
		    				parameters: 'type=SOCStorage_App&eiid='+eiid+'&version='+version+'&smallversion='+smallversion,
		    				 onSuccess:  function(req, json){
		    				 var result=req.responseText;
		    					if(result != null && result != ""){
		    						content1=result;
		    					}else{
		    						return "";	
		    					}
		    			    }
		    			});
		    		 var content2;
		    		  objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
		    				parameters: 'type=SOCStorage_Meta&eiid='+eiid+'&version='+version+'&smallversion='+smallversion,
		    				 onSuccess:  function(req, json){
		    				 var result=req.responseText;
		    					if(result != null && result != ""){
		    						content2=result;
		    					}else{
		    						return "";	
		    					}
		    			    }
		    			});
					SOCStorage.createMetaList(content2);
			}	
		    function selectbydisk(eiid,version,smallversion){
			    //alert(eiid+","+version+","+smallversion);
		    	 var content2;
	    		  objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCStorage_Disk&eiid='+eiid+'&version='+version+'&smallversion='+smallversion,
	    				 onSuccess:  function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						content2=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});					 
				return content2; 
			 }
</script>
    
<title><bean:write name="id"/><bean:write name="title"/></title>
<body onload="initApp();">
<div class="box">
  <div id="flashContent">
  </div>
 </div>
</body>

</html:html>
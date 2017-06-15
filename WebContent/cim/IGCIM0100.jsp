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
<bean:define id="id" value="IGCIM0100" toScope="request" />
<bean:define id="title" value="拓扑关系展示图" toScope="request" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common_<%=loc %>.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />

<script type="text/javascript">
         var swfVersionStr = "12.0.0";
         var xiSwfUrlStr = "images/dbmswf/SANMapingsForMSBANK.swf";
         var flashvars = {};
         flashvars.locale ="<%=loc %>";
         var params = {};
         var attributes = {};
         attributes.id = "SANMapingsForMSBANK";
         attributes.name = "SANMapingsForMSBANK";
         params.wmode = "Opaque";
         swfobject.embedSWF(xiSwfUrlStr,"flashContent", "954", "1270", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);

         function initApp(){
             try{
            	setStorageID('${EIID_ID}','${STORAGE_ID}');
            	faPortSearchByAjax('${EIID_ID}'); 
             }catch(err){
            	setTimeout("initApp()",5000);
             }
         }
        //Ajax function//
		
        //业务系统关键字查询
		function BussSearchByAjax(keyword1,eiid){
 	   		 var res;
 			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=bussSearchByAjax&eiid='+eiid+'&einame='+keyword1,
 					 onSuccess: function(req, json){
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

        //主机&HBA关键字查询
		function HostHbaSearchByAjax(keyword1,keyword2,eiid){
	   		 var res;
 			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
 					parameters: 'type=hostHbaSearchByAjax&eiid='+eiid+'&hba='+keyword1+'&wwn='+keyword2,
 					 onSuccess: function(req, json){
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
        //交换机关键字查询
		function switchPortSearchByAjax(keyword1,eiid){
	   		 var res;				
 			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
 					parameters: 'type=switchPortSearchByAjax&eiid='+eiid+'&switch='+keyword1,
 					 onSuccess: function(req, json){
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
	     //FA初始化
		function faPortSearchByAjax(eiid){
	   		 var res;
	 		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:true, 
					parameters: 'type=faPortSearchByAjax&eiid='+eiid,
					 onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							try{
								setFAData(result);
							}catch(err){
								setTimeout("setCounter()",1000);
							}
						}else{
							setTimeout("setCounter()",1000);
						}	
				    }
				});	
		}
		
        //剩余Hyper
		function RemainHyperByAjax(eiid){
	   		 var res;
 			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
 					parameters: 'type=remainHyperByAjax&eiid='+eiid,
 					 onSuccess: function(req, json){
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

		function searchRelationByAjax(eiid,storageEiid,typeId){
	   		 var res;
			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=searchRelationByAjax&eiid='+eiid+"&storageEiid="+storageEiid+"&typeId="+typeId,
					 onSuccess: function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							setRelation(result);
						}else{
							return "";
						}
				    }
				});
			return res;
		}

		//Dev/Meta
		function DevSearchByAjax(keyword1,eiid){
	 		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:true, 
					parameters: 'type=hyperPortSearchByAjax&eiid='+eiid+'&style=Meta Head&einame='+keyword1+'&symmetrixid='+'${STORAGE_ID}',
					 onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							try{
								setDevHyperData(result);
							}catch(err){
								setTimeout("setCounter()",1000);
							}
						}else{
							setTimeout("setCounter()",1000);
						}	
				    }
				});			
		}
       //GateKeeper
		function GateKeepSearchByAjax(keyword1,eiid){
	 		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:true, 
					parameters: 'type=hyperPortSearchByAjax&eiid='+eiid+'&style=GateKeeper&einame='+keyword1+'&symmetrixid='+'${STORAGE_ID}',
					 onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							try{
								setGKHyperData(result);
							}catch(err){
								setTimeout("setCounter()",1000);
							}
						}else{
							setTimeout("setCounter()",1000);
						}	
				    }
				});
			
		}
	  	function setCounter(type,eiid,StorageEiid,style,bs){

			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:true, 
					parameters: 'type='+type+'&eiid='+StorageEiid+'&bussid='+eiid+'&bs='+bs+'&style='+style+'&symmetrixid='+'${STORAGE_ID}',
					 onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							try{
								//alert(style);
								if(style=="buss")
								   setBussData(result);
								if(style=="host")
								   setHostHbaValue(result);
								if(style=="switch")
								   setSwData(result);
								if(style=="fa")
								   setFAData(result);
								 if(style=="mate")
								   setDevHyperData(result);
								 if(style=="gk")
								   setGKHyperData(result);
							}catch(err){
								setTimeout("setCounter()",1000);
							}
						}else{
							setTimeout("setCounter()",1000);
						}	
				    }
				});
	 	}
	  	function setCounterFalse(type,eiid,StorageEiid,style,bs){
	   		 var res;				
			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type='+type+'&eiid='+StorageEiid+'&bussid='+eiid+'&bs='+bs+'&style='+style+'&symmetrixid='+'${STORAGE_ID}',
					 onSuccess: function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							res=result;
						}else{
							return "";
						}
				    }
				});
				if(style=="buss")
				    setBussData(res);
				if(style=="host")
					setHostHbaValue(res);
				if(style=="switch")
					setSwData(res);
				if(style=="fa")
					setFAData(res);
				if(style=="mate")
				    setDevHyperData(res);
				if(style=="gk")
					setGKHyperData(res);
		}
	  	//buss
	  	function BussClickSearchByAjax(bussEiid,StorageEiid){
	  		searchRelationByAjax(bussEiid,StorageEiid,"0");
	  		setCounter("bussSearchByAjax",bussEiid,StorageEiid,"buss","buss");		  	
	  		setCounter("hostHbaSearchByAjax",bussEiid,StorageEiid,"host","buss");
	  		setCounter("switchPortSearchByAjax",bussEiid,StorageEiid,"switch","buss");
	  		setCounter("faPortSearchByAjax",bussEiid,StorageEiid,"fa","buss");
	  		setCounter("hyperPortSearchByAjax",bussEiid,StorageEiid,"gk","buss");
	  		setCounter("hyperPortSearchByAjax",bussEiid,StorageEiid,"mate","buss");
	  		
	  		
		}
	  	//other host to be used
	  	function HostHbaClickSearchByAjax(hostEiid,StorageEiid){
	  		searchRelationByAjax(hostEiid,StorageEiid,"0");
	  		setCounter("bussSearchByAjax",hostEiid,StorageEiid,"buss","host");		  	
	  		setCounter("hostHbaSearchByAjax",hostEiid,StorageEiid,"host","host");
	  		setCounter("switchPortSearchByAjax",hostEiid,StorageEiid,"switch","host");
	  		setCounter("faPortSearchByAjax",hostEiid,StorageEiid,"fa","host");
	  		setCounter("hyperPortSearchByAjax",hostEiid,StorageEiid,"mate","host");
	  		setCounter("hyperPortSearchByAjax",hostEiid,StorageEiid,"gk","host");
	  	}
	  	//only wwn
	  	function unknownHostHbaClickSearchByAjax(WWN,StorageEiid){
	  	}
	  	//switch
	  	function SwClickSearchByAjax(swEiid,StorageEiid){
	  		searchRelationByAjax(swEiid,StorageEiid,"0");
	  		setCounter("bussSearchByAjax",swEiid,StorageEiid,"buss","switch");		  	
	  		setCounter("hostHbaSearchByAjax",swEiid,StorageEiid,"host","switch");
	  		setCounter("switchPortSearchByAjax",swEiid,StorageEiid,"switch","switch");
	  		setCounter("faPortSearchByAjax",swEiid,StorageEiid,"fa","switch");
	  		setCounter("hyperPortSearchByAjax",swEiid,StorageEiid,"mate","switch");
	  		setCounter("hyperPortSearchByAjax",swEiid,StorageEiid,"gk","switch");
	  	}
	  	//FA
	  	function FaClickSearchByAjax(faEiid,StorageEiid){
	  		searchRelationByAjax(faEiid,StorageEiid,"0");
	  		setCounter("bussSearchByAjax",faEiid,StorageEiid,"buss","fa");		  	
	  		setCounter("hostHbaSearchByAjax",faEiid,StorageEiid,"host","fa");
	  		setCounter("switchPortSearchByAjax",faEiid,StorageEiid,"switch","fa");
	  		setCounter("faPortSearchByAjax",faEiid,StorageEiid,"fa","fa");
	  		setCounter("hyperPortSearchByAjax",faEiid,StorageEiid,"mate","fa");
	  		setCounter("hyperPortSearchByAjax",faEiid,StorageEiid,"gk","fa");
	  	}
	  	//filter remain hyper already
	  	function HyperClickSearchByAjax(bussEiid,StorageEiid){
	  		searchRelationByAjax(bussEiid,StorageEiid,"1");
	  		setCounterFalse("bussSearchByAjax",bussEiid,StorageEiid,"buss","gk");		  	
	  		setCounterFalse("hostHbaSearchByAjax",bussEiid,StorageEiid,"host","gk");
	  		setCounterFalse("switchPortSearchByAjax",bussEiid,StorageEiid,"switch","gk");
	  		setCounterFalse("faPortSearchByAjax",bussEiid,StorageEiid,"fa","gk");
	  		setCounterFalse("hyperPortSearchByAjax",bussEiid,StorageEiid,"gk","gk");
	  		setCounterFalse("hyperPortSearchByAjax",bussEiid,StorageEiid,"mate","gk");
	  	}
	  	function DevClickSearchByAjax(hyperEiid,StorageEiid){
	  		searchRelationByAjax(hyperEiid,StorageEiid,"1");
	  		setCounterFalse("bussSearchByAjax",hyperEiid,StorageEiid,"buss","mate");		  	
	  		setCounterFalse("hostHbaSearchByAjax",hyperEiid,StorageEiid,"host","mate");
	  		setCounterFalse("switchPortSearchByAjax",hyperEiid,StorageEiid,"switch","mate");
	  		setCounterFalse("faPortSearchByAjax",hyperEiid,StorageEiid,"fa","mate");
	  		setCounterFalse("hyperPortSearchByAjax",hyperEiid,StorageEiid,"gk","mate");
	  		setCounterFalse("hyperPortSearchByAjax",hyperEiid,StorageEiid,"mate","mate");	 			  	
	  	}
        
        
//callback function //
		function setStorageID(eiid,storageid){
			SANMapingsForMSBANK.setStorageID(eiid,storageid);
		}
		function setBussData(str){
			SANMapingsForMSBANK.setBussData(str);
		}
		function setHostHbaValue(str){
			SANMapingsForMSBANK.setHostHbaValue(str);
		}
		function setSwData(str){
			SANMapingsForMSBANK.setSwData(str);
		}
		function setFAData(str){
			SANMapingsForMSBANK.setFAData(str);
		}
		function setDevHyperData(str){
			SANMapingsForMSBANK.setDevHyperData(str);
		}
		function setGKHyperData(str){
			SANMapingsForMSBANK.setGKHyperData(str);
		}
		function setRelation(str){
			SANMapingsForMSBANK.setRelation(str);
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
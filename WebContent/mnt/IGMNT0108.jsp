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
<bean:define id="id" value="IGMNT0108 " toScope="request" />
<script language="JavaScript" src="js/common.js" type="text/javascript" charset="gbk"></script>
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script type="text/javascript" src="js/swfobject.js"></script>


<script type="text/javascript">
         var swfVersionStr = "11.0.0";
         var xiSwfUrlStr = "images/mntswf/DMXRealTime.swf";
         var flashvars = {};
         var params = {};
         var attributes = {};
         attributes.id = "DMXRealTime";
         attributes.name = "DMXRealTime";
         params.wmode = "Opaque";
         swfobject.embedSWF(xiSwfUrlStr,"flashContent", "100%", "670", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);

         //程序初始化入口
    	 var mtId = <%=request.getParameter("mtId")%>;
    	 var isexitflag = <%=request.getParameter("isExitFlag")%>;
     	
     	function exportExcel(){
    		window.location=getAppRootUrl() + "/IGMNT0109.do?MtId="+mtId;
    	}

     	function tryClose(){
         	if(isexitflag==0){            	
     			var date=new Date();
     			setMtStatusByAjax(mtId,"1");
     			setMtstoptimeByAjax(mtId,date.toTimeString().substring(0,8),"1");
     			clrDataByAjax(mtId);
            }
        }
		
        function initApp(){
        	setMtId(mtId);
        	setMtStatus(isexitflag);
        	setInfo(getInfoByAjax(mtId));//ssn,kpi,pstoptime
        	setMtinterval(getMtintervalByAjax(mtId));
        	setInitLinesData(initCurveDateByAjax(mtId));
        }
         
    	//DMX实时监控回调方法
		function BeUsedCycle(){
			setInitLinesData(initCurveDateByAjax(mtId));
            setInfo(getInfoByAjax(mtId));//ssn,kpi,pstoptime
		}

		//ajax初始化data多点
		function initCurveDateByAjax(mtId){
	 		 var res;
			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=DMXRealTime&requestMode=initCurveDate&mtId='+mtId,
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

		//ajax获取info：ssn,kpi，mtpstoptime
		function getInfoByAjax(mtId){
	   		 var res;
			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=DMXRealTime&requestMode=getInfo&MtId='+mtId,
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
		//ajax延时
		function setMtPstoptimeByAjax(mtId){
	   		 var res;
			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=setMtPstoptime&MtId='+mtId,
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
		//ajax获取interval
		function getMtintervalByAjax(mtId){
	   		 var res;
			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=DMXRealTime&requestMode=Mtinterval&MtId='+mtId,
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
		//ajax生成elx
		function ExportReportByAjax(mtId){
   		 var res;
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=DMXRealTime&requestMode=Export_Report&MtId='+mtId,
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

			//设置监控任务状态 0运行状态 1关闭状态
			function setMtStatusByAjax(mtId,MtStatus){
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=DMXRealTime&requestMode=MtStatus&MtId='+mtId+'&MtStatus='+MtStatus,
	    				 onSuccess:  function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
					//no return 
			}

			//设置监控任务关闭时间 
			function setMtstoptimeByAjax(mtId,mtstoptime,isexitflag){
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=DMXRealTime&requestMode=Mtstoptime&MtId='+mtId+'&StopTime='+mtstoptime+'&IsExitFlag='+isexitflag,
	    				 onSuccess:  function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
				//no return
			}
			//清理监控任务数据
			function clrDataByAjax(mtId){
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=DMXRealTime&requestMode=clrData&MtId='+mtId,
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
			
			

			//传向flash------------------------------------------
			
			//预计结束时间
			function setMtpstoptime(mtstoptime){
				DMXRealTime.setMtpstoptime(mtstoptime);
			}
			//设置主键
			function setMtId(mtId){
				DMXRealTime.setMtId(mtId);
			}
			//设置状态
			function setMtStatus(isexitflag){				
				DMXRealTime.setMtStatus(isexitflag);
			}
			function setMtinterval(inv){
				DMXRealTime.setMtinterval(inv);
			}
			//id 间隔 状态 info：ssn,kpi，mtpstoptime
			function setInfo(info){
				DMXRealTime.setInfo(info);
			}
			//初始化查看data
			function setInitLinesData(str){
				DMXRealTime.setInitLinesData(str);
			}




</script>
        
<title><bean:write name="id"/><bean:message bundle="mntResources" key="ietitle.IGMNT0108"/></title>
<body>

<div class="box">

	
<div id="flashContent">
</div>
</div>


</body>
</html:html>
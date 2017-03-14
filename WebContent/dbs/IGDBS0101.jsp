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
<bean:define id="id" value="IGDBS0101" toScope="request" />
<bean:define id="title" value="运维存储管理平台" toScope="request" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />

<script type="text/javascript">
         var swfVersionStr = "12.0.0";
         var xiSwfUrlStr = "images/dbmswf/SocEmc_VG_FS.swf";
         var flashvars = {};
         flashvars.locale ="<%=loc %>";
         var params = {};
         var attributes = {};
         attributes.id = "SocEmc_VG_FS";
         attributes.name = "SocEmc_VG_FS";
         params.wmode = "Opaque";
         swfobject.embedSWF(xiSwfUrlStr,"flashContent", "1005", "742", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);


         var host1 ="";
         var host2 ="";
         var type1 ="";
         var type2 ="";
        
     	function quit(){
    		if(window.confirm("您确定要退出系统吗？")){
    			window.location="./IGCOM0102.do";
    			  //window.location = url;
    		}
    	}
    	//实时监控方法
		function playForCycle(){
	        //实时更细流程KPI
	        setMonitor(getMonitorByAjax());
	        getHost1ByAjax(host1,type1);
	        getHost2ByAjax(host2,type2);
	        //实时告警
	        setDataGridByAjax(getDataGridByAjax());
		}
    	//报表跳转
    	function toReportIndex(idStr,name){
        	//alert(idStr+"=="+name);
        	var idArr=idStr.split("|");
        	var id=idArr[0];
        	var flag=idArr[1];
        	//if(flag=="DMX"){
			//	location.href=getAppRootUrl()+"/IGMNT0111_Disp.do";
            //}else{
        		location.href = "IGCOM0202.do?linkID=IGRPT0301&actname=ACT05STA02&id="+id+"&name="+name+"&host1="+host1+"&type1="+type1+"&host2="+host2+"&type2="+type2;
           // }

    	}
    	//性能总图跳转
    	function toSocPerformance(id,name,version){
        	window.open("IGDBS0201.do?dataid="+name+"&type="+version,'','resizable=yes,left=180,top=150,width=1100,height=768,scrollbars=yes');       	  
 	    }
    	//业务运行查看跳转
		function callHref(url){
			 window.showModalDialog("IGPRR0102_Disp.do?prtype=ID&prid="+url,null,"dialogWidth:1024px;dialogHeight:650px;status:no;help:no;resizable:yes");
			 setMonitor(getMonitorByAjax());
		}

		//程序初始化入口
     	 var pn1Str = "<bean:write name='AD_PN1RETURN' filter='false' />";
     	 var pn2Str = "<bean:write name='AD_PN2RETURN' filter='false' />";
     	 var pn3Str = "<bean:write name='AD_PN3RETURN' filter='false' />";
     	 var pn4Str = "<bean:write name='AD_PN4RETURN' filter='false' />";
     	 var pn5Str = "<bean:write name='AD_PN5RETURN' filter='false' />";
     	 var pn6Str = "<bean:write name='AD_PN6RETURN' filter='false' />";
     	 var pn7Str = "<bean:write name='AD_PN7RETURN' filter='false' />";
     	 var pn10Str = "<bean:write name='AD_PN10RETURN' filter='false' />";
     	 var pn11Str = "<bean:write name='AD_PN11RETURN' filter='false' />";
         function initApp(){
             try{
	             setProcessLineLeft1(pn1Str);
	             setHostinfoLeft(pn2Str);
	             setProcessLineLeft2(pn3Str);
	             setProcessLineRight1(pn4Str);
	             setHostinfoRight(pn5Str);
	             setProcessLineRight2(pn6Str);

		       	 setDataGridByAjax(pn11Str); //告警
	           	 setPie(pn10Str); //all 存储

				setMonitor(pn7Str);
	            window.setInterval(playForCycle,300000);
             }catch(err){
            	setTimeout("initApp()",2000);
             }
             
         }
         //单个存储查询业务系统
 		function getSystemPieValue(id){
 	   		 var res;
 			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
 					parameters: 'type=getPieSingle&SSID='+id,
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
 		
		//获取圆环主数据20120704
		function getPieDataALLByAjax(){
			return pn10Str;
		}
		
		//获取告警信息20120704
		function getDataGridByAjax(){
	   		 var res;
			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=SOCEMC&requestMode=WarningType',
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
       //ajax业务运行
         function getMonitorByAjax() {
    		 var res;
    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
    				parameters: 'type=SOCEMC&requestMode=BusinessRus',
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

         //流程KPI回调函数
         function getProcessKPIByAjax() {
    		 var res;
    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
    				parameters: 'type=SOCEMC&requestMode=ProcessKPI',
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
			//左边主机的选择回调函数
			function getHost1ByAjax(id,type){
				//host1 = id;
				//type1 = type;
				//alert(host1+","+type1);
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCEMC&requestMode=hostinfo&id='+id+'&choose='+type+'&host=host1',
	    				 onSuccess: function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
	    		SocEmc_VG_FS.setHostinfoLeft(res);
	    		setProcessLineLeft1byajax(id,type);
	    		setProcessLineLeft2byajax(id,type);
			}

			//左上线图ajax
			function setProcessLineLeft1byajax(id,type){
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCEMC&requestMode=iops&id='+id+'&choose='+type,
	    				 onSuccess: function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
				SocEmc_VG_FS.setProcessLineLeft1(res);
			}

			//左下线图ajax
			function setProcessLineLeft2byajax(id,type){
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCEMC&requestMode=readwrite&id='+id+'&choose='+type,
	    				 onSuccess: function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
				SocEmc_VG_FS.setProcessLineLeft2(res);
			}
			
			//右边主机的选择回调函数
			function getHost2ByAjax(id,type){
				host2 = id;
				type2 = type;
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCEMC_A&requestMode=hostinfo&id='+id+'&choose='+type+'&host=host2',
	    				 onSuccess: function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
	    		SocEmc_VG_FS.setHostinfoRight(res);
	    		setProcessLineRight1byajax(host2,type2);
	    		setProcessLineRight2byajax(host2,type2);
			}

			//右上线图ajax
			function setProcessLineRight1byajax(id,type){
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCEMC_A&requestMode=iops&id='+id+'&choose='+type,
	    				 onSuccess: function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
				SocEmc_VG_FS.setProcessLineRight1(res);
			}

			//右下线图ajax
			function setProcessLineRight2byajax(id,type){
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCEMC_A&requestMode=readwrite&id='+id+'&choose='+type,
	    				 onSuccess: function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
				SocEmc_VG_FS.setProcessLineRight2(res);
			}
			
			//右上线图
			function setProcessLineRight1(strXml){
				SocEmc_VG_FS.setProcessLineRight1(strXml);
			}

			//右下线图
			function setProcessLineRight2(strXml){
				SocEmc_VG_FS.setProcessLineRight2(strXml);
			}
			
			//左上线图
			function setProcessLineLeft1(strXml){
				SocEmc_VG_FS.setProcessLineLeft1(strXml);
			}

			//左下线图
			function setProcessLineLeft2(strXml){
				SocEmc_VG_FS.setProcessLineLeft2(strXml);
			}
			
			//左主机图
			function setHostinfoLeft(strXml){
				SocEmc_VG_FS.setHostinfoLeft(strXml);
			}
			//右主机图
			function setHostinfoRight(strXml){
				SocEmc_VG_FS.setHostinfoRight(strXml);
			}
			//业务运行情况
			function setMonitor(strXml){
				SocEmc_VG_FS.setMonitor(strXml);
			}
			//主页第一个圆环
			function setPie(pieXmlStr){
				SocEmc_VG_FS.setPie(pieXmlStr);
			}
			//告警
			function setDataGridByAjax(xmlList){
				SocEmc_VG_FS.setDataGridByAjax(xmlList);
			}
			//get业务系统下所有Host
			function setHostData(systemId,storageId,bcName){
		   		 var res;
				 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
						parameters: 'type=showHostList&bcid='+systemId+'&SSID='+storageId+'&bcName='+bcName,
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
			//getHost下所有VG
			function setVGData(systemId){
		   		 var res;
				 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
						parameters: 'type=showHostVG&hostName='+systemId,
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
			//getVG下所有TS
			function setTSData(hostId){
		   		 var res;
				 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
						parameters: 'type=showVGTS&hostName='+hostId,
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
			//getVG下所有FS
			function setFSData(hostName,vgName){
		   		 var res;
				 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
						parameters: 'type=showVGFS&hostName='+hostName+'&vgName='+vgName,
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
			//get Host LUNID
			function setLunData(hostName,sName){
		   		 var res;
				 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
						parameters: 'type=showHostLUNID&hostName='+hostName+'&sName='+sName,
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
						//LV告警
			function setLVDataGridByAjax(hostName){
		   		 var res;
				 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
						parameters: 'type=showLVWarning&hostName='+hostName,
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
			//VIO LUNID
			function setVIOData(sName,vioName){
		   		 var res;
				 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
						parameters: 'type=showVIOLUNID&sName='+sName+'&vioName='+vioName,
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
</script>
        
<title><bean:write name="id"/><bean:write name="title"/></title>
<body onload="initApp();">

<div class="box">

		<!-- 在此显示菜单 -->
		<ul id="flyout">
		<li><a href="#" class="nikon"><!--[if gte IE 7]><!--></a><!--<![endif]-->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
		<b></b>
		<ul>
		<ig:dbMenu acturl="<%=request.getContextPath()%>"/>
		</ul>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
		</ul>		
<div id="flashContent">
</div>
</div>
</body>

</html:html>
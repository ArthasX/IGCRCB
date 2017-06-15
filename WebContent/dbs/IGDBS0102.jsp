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
<bean:define id="id" value="IGDBM0102" toScope="request" />
<bean:define id="title" value="EMCStorage Operation Center" toScope="request" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script language="JavaScript" src="js/common_<%=loc %>.js" type="text/javascript" charset="gbk"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />

<script type="text/javascript">
         var swfVersionStr = "10.0.0";
         var xiSwfUrlStr = "images/dbmswf/SocEmc2.swf";
         var flashvars = {};
         var params = {};
         var attributes = {};
         attributes.id = "SocEmc2";
         attributes.name = "SocEmc2";
         params.wmode = "Opaque";
         swfobject.embedSWF(xiSwfUrlStr,"flashContent", "1005", "742", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);


         var host1 ="";
         var host2 ="";
         var type1 ="";
         var type2 ="";       
         function quit(url){
     		if(window.confirm('<bean:message bundle="comResources" key="menu.Exit.IGDBM0101"/>')){
     			//window.location="./IGCOM0102.do";
     			  window.location = url;
     		}
     	}

    	//实时监控方法
		function playForCycle(){
	        //实时更细流程KPI
			setMeter(getProcessKPIByAjax());
	        setMonitor(getMonitorByAjax());
	        getHost1ByAjax(host1,type1);	
	        getHost2ByAjax(host2,type2);
		}


    	//报表跳转
    	function toReportIndex(id,name){
        	//alert(id);
        	//alert(name);
        	location.href = "IGCOM0211.do?actname=ACT05STA&id="+id+"&name="+name+"&host1="+host1+"&type1="+type1+"&host2="+host2+"&type2="+type2;

    	}
    	//性能总图跳转
    	function toSocPerformance(id,name,version){
    		window.open("IGDBM0201.do?dataid="+name+"&type="+version,'','resizable=yes,left=180,top=150,width=1100,height=768,scrollbars=yes');          	  
 	    }
    	//业务运行查看跳转
		function callHref(url){
			 window.showModalDialog("IGPRR0102_Disp.do?prtype=ID&prid="+url,null,"dialogWidth:1024px;dialogHeight:650px;status:no;help:no;resizable:yes");
			 setMonitor(getMonitorByAjax());
		}

		//程序初始化入口
         function initApp(){
             try{
            	 var pn1Str = "<bean:write name='AD_PN1RETURN' filter='false' />";
            	 var pn2Str = "<bean:write name='AD_PN2RETURN' filter='false' />";
            	 var pn3Str = "<bean:write name='AD_PN3RETURN' filter='false' />";

            	 var pn4Str = "<bean:write name='AD_PN4RETURN' filter='false' />";
            	 var pn5Str = "<bean:write name='AD_PN5RETURN' filter='false' />";
            	 var pn6Str = "<bean:write name='AD_PN6RETURN' filter='false' />";
            	 
            	 var pn7Str = "<bean:write name='AD_PN7RETURN' filter='false' />";
            	 var pn8Str = "<bean:write name='AD_PN8RETURN' filter='false' />";
	             var pn9Str = '<bean:write name="AD_PN9RETURN" filter="false" />';
	 
	             setProcessLineLeft1(pn1Str);
	             setHostinfoLeft(pn2Str);
	             setProcessLineLeft2(pn3Str);

	             setProcessLineRight1(pn4Str);
	             setHostinfoRight(pn5Str);
	             setProcessLineRight2(pn6Str);

	             
				setCalendar(pn9Str);
				setMonitor(pn7Str);
				setMeter(pn8Str);
				
	             window.setInterval(playForCycle,300000);
             }catch(err){
            	 setTimeout("initApp()",2000);
             }
             
         }

       //ajax业务运行
         function getMonitorByAjax() {
    		 var res;
    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
    				parameters: 'type=SOCEMC&requestMode=BusinessRus',
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

         //流程KPI回调函数
         function getProcessKPIByAjax() {
    		 var res;
    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
    				parameters: 'type=SOCEMC&requestMode=ProcessKPI',
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

		//运维管理日历回调函数
         function getCalendarDayByAjax(valueOfDate) {
    		 var res;
    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
    				parameters: 'type=SOCEMC&requestMode=operationManagement&date='+ valueOfDate,
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

			//左边主机的选择回调函数
			function getHost1ByAjax(id,type){
				//host1 = id;
				//type1 = type;
				//alert(host1+","+type1);
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCEMC&requestMode=hostinfo&id='+id+'&choose='+type+'&host=host1',
	    				 onSuccess:  function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
	    		SocEmc2.setHostinfoLeft(res);
	    		setProcessLineLeft1byajax(id,type);
	    		setProcessLineLeft2byajax(id,type);
			}

			//左上线图ajax
			function setProcessLineLeft1byajax(id,type){
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCEMC&requestMode=iops&id='+id+'&choose='+type,
	    				 onSuccess:  function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
				SocEmc2.setProcessLineLeft1(res);
			}

			//左下线图ajax
			function setProcessLineLeft2byajax(id,type){
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCEMC&requestMode=readwrite&id='+id+'&choose='+type,
	    				 onSuccess:  function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
				SocEmc2.setProcessLineLeft2(res);
			}
			
			//右边主机的选择回调函数
			function getHost2ByAjax(id,type){
				host2 = id;
				type2 = type;
				//alert(host2+","+type2);
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCEMC&requestMode=hostinfo&id='+id+'&choose='+type+'&host=host2',
	    				 onSuccess:  function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
	    		SocEmc2.setHostinfoRight(res);
	    		setProcessLineRight1byajax(id,type);
	    		setProcessLineRight2byajax(id,type);
			}

			//右上线图ajax
			function setProcessLineRight1byajax(id,type){
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCEMC&requestMode=iops&id='+id+'&choose='+type,
	    				 onSuccess:  function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
				SocEmc2.setProcessLineRight1(res);
			}

			//右下线图ajax
			function setProcessLineRight2byajax(id,type){
				var res;
	    		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	    				parameters: 'type=SOCEMC&requestMode=readwrite&id='+id+'&choose='+type,
	    				 onSuccess:  function(req, json){
	    				 var result=req.responseText;
	    					if(result != null && result != ""){
	    						res=result;
	    					}else{
	    						return "";	
	    					}
	    			    }
	    			});
				SocEmc2.setProcessLineRight2(res);
			}
			
			//右上线图
			function setProcessLineRight1(strXml){
				SocEmc2.setProcessLineRight1(strXml);
			}

			//右下线图
			function setProcessLineRight2(strXml){
				SocEmc2.setProcessLineRight2(strXml);
			}
			
			//左上线图
			function setProcessLineLeft1(strXml){
				SocEmc2.setProcessLineLeft1(strXml);
			}

			//左下线图
			function setProcessLineLeft2(strXml){
				SocEmc2.setProcessLineLeft2(strXml);
			}
			
			//左主机图
			function setHostinfoLeft(strXml){
				SocEmc2.setHostinfoLeft(strXml);
			}
			//右主机图
			function setHostinfoRight(strXml){
			SocEmc2.setHostinfoRight(strXml);
			}
			//业务运行情况
			function setMonitor(strXml){
			SocEmc2.setMonitor(strXml);
			}
			//运维管理
			function setCalendar(strXml){
				SocEmc2.setCalendar(strXml);
			}
			//仪表控件
			function setMeter(processKPI){
			//processKPI
            //alert(processKPI);
				var array = processKPI.split(";");
				SocEmc2.setMeter(array[0],array[1],array[2],array[3],array[4]);
			}
</script>
        
<title><bean:write name="id"/><bean:write name="title"/></title>
<body onload="initApp();">

<div class="box">

		<!-- 在此显示菜单 -->
		<ul id="flyout">
		<li><a href="#" class="li_en"><!--[if gte IE 7]><!--></a><!--<![endif]-->
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
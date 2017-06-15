<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDBM0102" toScope="request" />
<bean:define id="title" value="决策层首页" toScope="request" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script src="<html:rewrite forward='common.js'/>"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />

<script type="text/javascript">
	function quit(){
		if(window.confirm("您确定要退出系统吗？")){
			window.location="./IGCOM0102.do";
		}
	}
	
	function playMovie() {
		 try{
			 setCounter();
			 setMonitor();
		 }catch(err){
				
		}
	}
	function initFlex(){
		setMonitor();
		setCounter();
		setMeterhalfI();
		setMeterhalfP();
		setRedMeter();
		setBlueMeter();
		setZiMeter();
		setProcessPLine("PLine");
		setPillar4();
		setCalendar2();
	}
	function setCounter(){
		try{
		 var res;
			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=DepartmentMaster&requestMode=processCount',
					 onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							res=result;
						}else{
							return true;	
						}	
				    }
				});
			var processArry = res.split("|");
			all.setCounter(processArry[0],processArry[1],processArry[2]);
		}catch(err){
			setTimeout("setCounter()",1000);
		}
	}
	function setMeterhalfI(){
		try{
			all.setMeterhalfI(${eventcount});
		}catch(err){
			setTimeout("setMeterhalfI()",1000);
		}
	}
	function setMeterhalfP(){
		try{
			all.setMeterhalfP(${problemcount});
		}catch(err){
			setTimeout("setMeterhalfP()",1000);
		}
	}
	function setMonitor(){
		try{
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=DepartmentMaster&requestMode=monitor',
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return true;	
					}	
			    }
			});
			all.setMonitor(res);
		}catch(err){
			setTimeout("setMonitor()",1000);
		}
	}

	//纵向柱图取得数据函数
	function getPLineDataByAjax(selectId){
		if("1"==selectId){
			setProcessPLine('PLine');
		}
		if("2"==selectId){
			setProcessPLine('PLine');
		}
		if("3"==selectId){
			setProcessPLine('PLine');
		}
	}
	
	//初始化纵向线图
	 function setProcessPLine(pillartype){
		 var res;
		 var flexrel="";
			try{
				var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=DepartmentMaster&requestMode='+pillartype,
					 onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							res=result;
						}else{
							return true;	
						}	
				    }
				});
				flexrel = all.setPLine(res);
				if(flexrel != "ok"){
					setTimeout("setProcessPLine('PLine')",1000);
				}
			}catch(err){
				setTimeout("setProcessPLine('PLine')",1000);
			}	
			
	 }
	
	function setPillar4(){
		try{
			all.setPillar4('${workcount}','${workCenter}');
		}catch(err){
			setTimeout("setPillar4()",1000);
		}
	}
	function setCalendar2(){
		try{
			var strXml = getCalendarDayByAjax("");
			all.setCalendar2(strXml);
		}catch(err){
			setTimeout("setCalendar2()",1000);
		}
	}

	//初始化红色指针仪表盘
	 function setRedMeter() {
		 var res;
		 var flexrel="";
			try{
				var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=DepartmentMaster&requestMode=Study',
					 onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							res=result;
						}else{
							return true;	
						}	
				    }
				});
				flexrel = all.setRedMeter(res);
				if(flexrel != "ok"){
					setTimeout("setRedMeter()",1000);
				}
			}catch(err){
				setTimeout("setRedMeter()",1000);
			}	
			
	}
	//初始化紫色指针仪表盘
	 function setZiMeter() {
		 var res;
		var flexrel;	
		try{
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=DepartmentMaster&requestMode=Study',
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return true;	
					}	
			    }
			});
			flexrel = all.setZiMeter(res);
			if(flexrel != "ok"){
				setTimeout("setZiMeter()",1000);
			}
		}catch(err){
			setTimeout("setZiMeter()",1000);
		}	
			
	}
	//初始化蓝指针仪表盘
	 function setBlueMeter() {
		 var res;
		 var flexrel="";
			try{
				var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=DepartmentMaster&requestMode=Study',
					 onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							res=result;
						}else{
							return true;	
						}	
				    }
				});
				flexrel = all.setBlueMeter(res);
				if(flexrel != "ok"){
					setTimeout("setBlueMeter()",1000);
				}
			}catch(err){
				setTimeout("setBlueMeter()",1000);
			}	
	}
	
	function getCalendarDayByAjax(valueOfDate) {
		 var res;
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=DepartmentMaster&requestMode=changeplan&date='+ valueOfDate,
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
</script>
<body onload="window.setInterval(playMovie,120000);initFlex();">

<div class="box">
		<ul id="flyout">
		<li><a href="#" class="nikon"><!--[if gte IE 7]><!--></a><!--<![endif]-->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
		<b></b>
		<ul>
							<ig:dbMenu acturl="<%=request.getContextPath()%>" noDisplayActName="ACT04STA03|" actName="ACT04STA" showtitle="true" />
		</ul>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
		</ul>
  	  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  width="1005" height="742"
		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" id="all">
          <param name="movie" value="images/dbmswf/All02.swf" />
          <param name="wmode" value="transparent" />
        </object>
</div>
<input type="hidden" id="lfy1" value="${lfy1 }"/>
<input type="hidden" id="lfy2" value="${lfy2 }"/>
<input type="hidden" id="lfy3" value="${lfy3 }"/>
</body>
</html:html>

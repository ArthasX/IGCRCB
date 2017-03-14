<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDBM0101" toScope="request" />
<bean:define id="title" value="决策层首页" toScope="request" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script src="<html:rewrite forward='common.js'/>"></script>
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />

<script type="text/javascript">
			function quit(){
				if(window.confirm("您确定要退出系统吗？")){
					window.location="./IGCOM0102.do";
				}
			}

			function playForMovie() {
				setMonitor();
			}

			function initApp() {
				setCalendar();
				setMonitor();
				setPillar2("pillar2");
				setChart();
				setRedMeter();
				setBlueMeter();
				setZiMeter();
				setProcessPLine("PLine");
			 }

			//初始化变更计划日历
			function setCalendar(){
				var flexrel="";
				try{
					flexrel = all.setCalendar();
					if(flexrel != "ok"){
						setTimeout("setCalendar()",1000);
					}
				}catch(err){
					setTimeout("setCalendar()",1000);
				}
			}

			//变更计划日历点下一月时回调函数
			function getDateByAjax(showTitleText) {
				var res;
				var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=BankMaster&requestMode=calendar&thedate='+showTitleText,
					 onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							res = result;
					   }	
				    }
				});
				return res;
			}

			//初始化系统监控函数
			 function setMonitor() {
				 var res;
				 var flexrel="";
					try{
						var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
							parameters: 'type=BankMaster&requestMode=monitor',
							 onSuccess:  function(req, json){
							 var result=req.responseText;
								if(result != null && result != ""){
									res=result;
								}else{
									return true;	
								}	
						    }
						});
						flexrel = all.setMonitor(res);
						if(flexrel != "ok"){
							setTimeout("setMonitor()",1000);
						}
					}catch(err){
						setTimeout("setMonitor()",1000);
					}	
			}

			//初始化横向柱图函数
			 function setPillar2(pillartype){
				 var per = new Array;
				 var res;
				 var flexrel="";
					try{
						var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
							parameters: 'type=BankMaster&requestMode='+pillartype,
							 onSuccess:  function(req, json){
							 var result=req.responseText;
								if(result != null && result != ""){
									res=result;
								}else{
									return true;	
								}	
						    }
						});
						per = res.split(",");
						flexrel = all.setPillar2(per[0],per[1],per[2],per[3]);
						if(flexrel != "ok"){
							setTimeout("setPillar2('pillar2')",1000);
						}
					}catch(err){
						setTimeout("setPillar2('pillar2')",1000);
					}	
			 }
			 
			//初始化 三个区域坐标图
			function setChart(){
				var flexrel="";
				try{
					flexrel = all.setChart(document.getElementById("chartxml").value);
				}catch(err){
					setTimeout("setChart()",3000);
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
			//地图数据取得函数
			function getMapDataByAjax(showTitleText) {
				var res;
				var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=BankMaster&requestMode=map&mapname='+showTitleText,
					 onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							res=result;
						}else{
							return true;	
						}	
				    }
				});
				return res;
			 }
			//初始化纵向线图
			 function setProcessPLine(pillartype){
				 var res;
				 var flexrel="";
					try{
						var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
							parameters: 'type=BankMaster&requestMode='+pillartype,
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
				//初始化红色指针仪表盘
			 function setRedMeter() {
				 var res;
				 var flexrel="";
					try{
						var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
							parameters: 'type=BankMaster&requestMode=Study',
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
						parameters: 'type=BankMaster&requestMode=Study',
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
							parameters: 'type=BankMaster&requestMode=Study',
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
</script>
<title><bean:write name="id"/><bean:write name="title"/></title>
<body onload="initApp();">
<div class="box">
		<ul id="flyout">
		<li><a href="#" class="nikon"><!--[if gte IE 7]><!--></a><!--<![endif]-->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
		<b></b>
		<ul>
				<ig:dbMenu acturl="<%=request.getContextPath()%>" noDisplayActName="ACT04STA03|" actName="ACT04STA" />
		</ul>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
		</ul>
		
	  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  width="1005" height="742"
		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" id="all">
          <param name="movie" value="images/dbmswf/All01.swf" />
          <param name="wmode" value="transparent" />
      </object>
</div>
<input type="hidden" id="chartxml" value="${chart }"/>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDBM0103" toScope="request" />
<bean:define id="title" value="领导首页" toScope="request" /><!-- 行长首页zjg——ds -->
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script src="<html:rewrite forward='common.js'/>"></script>
 <link type="text/css" href="css/dashboard.css" rel="stylesheet" />
 
<script type="text/javascript">
	function quit(){
		if(window.confirm("您确定要退出系统吗？")){
			window.location="./IGCOM0102.do";
		}
	}

	function playMovie() {
		 try{
			setPieAll();
			setValueMonitorCount();
			setValueMeasurementCount();
			setTopoMapXMLStr();
			setMonitor();
			setChartMode();
		 }catch(err){
			
		}
	}
	
		
	function setTopoMapXMLStr(){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:true, 
			parameters: 'type=getTopoMapXML',
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					try{
						hangzhang.setTopoMapXMLStr(result);
					}catch(err){
						setTimeout("setTopoMapXMLStr()",1000);
					}
				}else{
					setTimeout("setTopoMapXMLStr()",1000);
				}
		    }
		});
	}
	
	function setMonitor(){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:true, 
			parameters: 'type=PlatformAvailable',
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					try{
						hangzhang.setMonitor(result);
					}catch(err){
						setTimeout("setMonitor()",1000);
					}
				}else{
					setTimeout("setMonitor()",1000);
				}	
		    }
		});
	}
	function setChartMode(){
		try{
			hangzhang.setChartMode($('chartxml').value);
		}catch(err){
			setTimeout("setChartMode()",1000);
		}
	}
	
	function setPieAll(){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:true, 
			parameters: 'type=HangZhangPieAll',
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					try{
						var resArr=result.split("@");
						hangzhang.setPieAll(resArr[0],resArr[1]);
					}catch(err){
						setTimeout("setPieAll()",1000);
					}
				}else{
					setTimeout("setPieAll()",1000);
				}
		    }
		});
	}
	
	function setValueMonitorCount(){
		try{
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=PlatformCount',
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return true;
					}	
			    }
			});
			var countArr = res.split("|");
			hangzhang.setValueMonitorCount(countArr[0],countArr[1],countArr[2]);
		}catch(err){
			setTimeout("setValueMonitorCount()",1000);
		}
	}
	
	function setValueMeasurementCount(){
		try{
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=PlatformMeasurementCount',
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						res=result;
					}else{
						return true;
					}	
			    }
			});
			var countArr = res.split("|");
			hangzhang.setValueMeasurementCount(countArr[0],countArr[1],countArr[2],countArr[3],countArr[4]);
		}catch(err){
			setTimeout("setValueMeasurementCount()",1000);
		}
	}
	function gotoSystemUrl(systemName){
		systemName = encodeURI(systemName);
		window.location = "IGMTM0501_Disp.do?searchName="+systemName;
	}
	
	function initFlex(){
		setValueMonitorCount();
		setValueMeasurementCount();
		setTopoMapXMLStr();
		setMonitor();
		setChartMode();
		setPieAll();
		setToolsBar();
	}
	function setToolsBar(){
		try{
			hangzhang.setToolsBar('平台','监控','告警','摩卡','系统','机房','资产');
		}catch(err){
			setTimeout("setToolsBar('平台','监控','告警','摩卡','系统','机房','资产')",1000);
		}
	}
	
	
	 //header menu
	function headerMenu(str){
		 var url = document.referrer;
		switch(str){
			case 1:setTimeout(function lk(){location.href="IGCOM0105.do?index=1";},800);break;
			case 2:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGMTM0501&actname=ACT13MTM05";},800);break;
			case 3:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGMTM0101&actname=ACT13MTM0101";},800);break;
			case 4:setTimeout(function lk(){window.open("IGCOM0202.do?linkID=IGATL0102");});break;
			case 5:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGSYS0001&actname=ACT13MTM0503";},800);break;//sys
			case 6:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGASM1101&actname=ACT01ASM1201";},800);break;
			case 7:setTimeout(function lk(){location.href="IGCOM0202.do?linkID=IGCOM0209&actname=ACT01ASM";},800);break;
			case 8:setTimeout(function lk(){location.href=url;},800);break;
		}
	}
</script>
<body onload="window.setInterval(playMovie,300000);initFlex();">

<div class="box">
  	  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  width="1005" height="742"
		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" id="hangzhang">
          <param name="movie" value="images/dbmswf/HangZhang.swf" />
          <param name="wmode" value="transparent" />
      </object>
</div>
<input type="hidden" id="chartxml" value="${IICHART }"/>
</body>
</html:html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDBM0112" toScope="request" />
<bean:define id="title" value="处长首页" toScope="request" /><!--zjg——dashboard -->
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
			 setCounter();
			 setMeterhalfI();
			 setMeterhalfP();
			 setMonitor();
//			 setPie();
		 }catch(err){
				
		}
	 }

	 	
	function initFlex(){
		initWarning();
		setCounter();
		setMeterhalfI();
		setMeterhalfP();
		setMonitor();
		setCalendar2();
		//setPie();
		setToolsBar();
	}

	//告警TAB显示控制
	function initWarning(){
		try{
		all.initWarning('true','true');
		}catch(err){
			setTimeout("initWarning('true','true')",1000);
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
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:true, 
				parameters: 'type=PlatformAvailableForWidth',
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
					try{
						all.setMonitor(result);
					}catch(err){
						setTimeout("setMonitor()",2000);
					}
					}else{
						setTimeout("setMonitor()",2000);
					}
			    }
			});
	}
	function setCounter(){
			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:true, 
					parameters: 'type=DepartmentMaster&requestMode=processCount',
					 onSuccess:  function(req, json){
					 var result=req.responseText;
						if(result != null && result != ""){
							try{
								var processArry = result.split("|");
								all.setCounter(processArry[0],processArry[1],processArry[2]);
							}catch(err){
								setTimeout("setCounter()",1000);
							}
						}else{
							setTimeout("setCounter()",1000);
						}	
				    }
				});
	}
	/**
	function setPie(){
				 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:true, 
						parameters: 'type=WarningPie',
						 onSuccess:  function(req, json){
						 var result=req.responseText;
							if(result != null && result != ""){
							try{
								var processArry = result.split("|");
								all.setPie(processArry[0],processArry[1],processArry[2]);//预留
							}catch(err){
								setTimeout("setPie()",1000);
							}
							}else{
								setTimeout("setPie()",1000);	
							}	
					    }
					});
	
	}
	**/
	var strType="HQ";
	function setWarningTextMode(strType){
		var res="";
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=WarningInfo&WarnType='+strType,
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

	function setCalendar2(){
		try{
			var strXml = getCalendarDayByAjax("");
			all.setCalendar2(strXml);
		}catch(err){
			setTimeout("setCalendar2()",1000);
		}
	}
	
	function getCalendarDayByAjax(valueOfDate) {
		 var res;
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type=ProcessTopics&requestMode=changeplan&date='+ valueOfDate,
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
	
	function setToolsBar(){
		try{
			all.setToolsBar('平台','监控','告警','摩卡','系统','机房','资产');
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
	 
	function goToLink(paicode) {
        if(paicode == "W"){
            window.location = "IGWKM0101.do?prpdid=&prtype=WB&selectstatus=1";//"IGCOM0202.do?linkID=IGWKM0101&prtype=WB&actname=ACT02SVC0901";
        }
        if(paicode == "I"){
            window.location = "IGSVC0201.do?selectstatus=1";
        }
        if(paicode == "S"){
            window.location = "IGCOM0202.do?linkID=IGSVC0801&actname=ACT02SVC0601";
        }
        if(paicode == "C"){
            window.location = "IGSVC0401.do?selectstatus=1";
        }
    }
	
	function gotoSystemUrl(systemName){
		systemName = encodeURI(systemName);
		window.location = "IGMTM0501_Disp.do?searchName="+systemName;
	}
</script>
<body onload="window.setInterval(playMovie,120000);initFlex();">

<div class="box">

  	  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  width="1005" height="742"
		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" id="all">
          <param name="movie" value="images/dbmswf/ChuZhang.swf" />
          <param name="wmode" value="transparent" />
      </object>
</div>
<input type="hidden" id="lfy1" value="${lfy1 }"/>
<input type="hidden" id="lfy2" value="${lfy2 }"/>
<input type="hidden" id="lfy3" value="${lfy3 }"/>
</body>
</html:html>

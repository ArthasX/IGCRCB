<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0406" toScope="request" />
<bean:define id="title" value="流程综合分析" toScope="request" />
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
			 setFailStat();
		 }catch(err){
				
		}
	 }

		
	function initFlex(){

		setMeterhalfI();
		setMeterhalfP();
		setCounter();
		setLineForYear1();
		setLineForYear();
		setCalendar2();
		setIncidentPieGraph();
		setChart();
	}

    function setIncidentPieGraph(){
        try{
            all.setIncidentPieGraph("${incidentPie}",1);
        }catch(err){
            setTimeout("setIncidentPieGraph()",1000);
        }
    }


    function setKnowPieGraph(){
        try{
            all.setKnowPieGraph("${knowPie}",0);
        }catch(err){
            setTimeout("setKnowPieGraph()",1000);
        }
    }
	
	function setMeterhalfI(){
        try{
            all.setMeterhalfI(${eventcount});
        }catch(err){
            setTimeout("setMeterhalfI()",1000);
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
	function setCounter(){
		try{
		 var res;
			 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
					parameters: 'type=ProcessTopics&requestMode=processCount',
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
			all.setCounter(processArry[0],processArry[1],processArry[2],processArry[3],processArry[4]);
		}catch(err){
			setTimeout("setCounter()",1000);
		}
	}
	function setLineForYear1(){
		try{
			all.setLineForYear1(document.getElementById("lfy1").value);
		}catch(err){
			setTimeout("setLineForYear1()",1000);
		}
	}
	
	function setLineForYear(){
		try{
			all.setLineForYear(document.getElementById("lfy3").value);
		}catch(err){
			setTimeout("setLineForYear()",1000);
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
	  //初始化 三个区域坐标图
	function setChart(){
		var flexrel="";
		try{
			flexrel = all.setChart(document.getElementById("chartxml").value);
		}catch(err){
			setTimeout("setChart()",3000);
		}
		
	}
	
	function goToLink(paicode) {
		if(paicode == 'I'){
			window.location.href = "IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01080&actname=ACT02SVC0201";
		}
		if(paicode == 'C'){
			window.location.href = "IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01084&actname=ACT02SVC0401";
		}
		if(paicode == 'WA'){
			window.location.href = "IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01083&actname=ACT02SVC0301";
		}
		if(paicode == 'V'){
			window.location.href = "IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01100&actname=ACT02SVC0601";
		}
		if(paicode == 'E'){
			window.location.href = "IGCOM0202.do?linkID=IGSVC1001&actname=ACT02SVC0115";
		}
    }
</script>
<body onload="window.setInterval(playMovie,120000);initFlex();">

<div class="box">
		<ul id="flyout">
		<li><a href="#" class="nikon"><!--[if gte IE 7]><!--></a><!--<![endif]-->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
		<b></b>
		<ul>
			<ig:dbMenu acturl="<%=request.getContextPath()%>" noDisplayActName="ACT04STA03|" actName="ACT04STA"  showtitle="true"/>
		</ul>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
		</ul>
  	  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  width="1005" height="742"
		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" id="all">
          <param name="movie" value="images/dbmswf/Fxb03.swf" />
          <param name="wmode" value="transparent" />
      </object>
</div>
<input type="hidden" id="lfy1" value="${lfy1 }"/>
<input type="hidden" id="lfy2" value="${lfy2 }"/>
<input type="hidden" id="lfy3" value="${lfy3 }"/>
<input type="hidden" id="chartxml" value="${chartxml }"/>
</body>
</html:html>

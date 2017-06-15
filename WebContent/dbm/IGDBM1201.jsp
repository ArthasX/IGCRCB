<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDBM1201" toScope="request" />
<bean:define id="title" value="科技运行综合分析(一)" toScope="request" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script src="<html:rewrite forward='common.js'/>"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	function quit(){
		if(window.confirm("您确定要退出系统吗？")){
			window.location="./IGCOM0102.do";
		}
	}
	
	function playMovie() {
		 try{
			 setCounterRight();
			 setCounterLeft();
		 }catch(err){
				
		}
	}
	function initFlex(){
		setCounterRight();
		setCounterLeft();
		/* setMeterhalfI();
		setMeterhalfP();
		setRedMeter();
		setBlueMeter();
		setZiMeter();
		setProcessPLine("PLine");
		setPillar4();
		setCalendar2(); */
	}
	function setCounterRight(){
		try{
			$.ajax({
				url:getAppRootUrl()+"/IGDBM1201_ProcessCountKJ.do",
				type:"POST",
				dataType :"text",
				cache:false,
				async:false,
				//成功回调函数
				success:function(result){
					var processArry = result.split("|");
					all.setCounterRight(processArry[0],processArry[1],processArry[2],processArry[3],processArry[4]);
				},
				//失败回调函数
				error:function(XMLHttpRequest, textStatus, errorThrown){
					alert("获取初始化数据异常");
				}
			});
		}catch(err){
			setTimeout("setCounterRight()",1000);
		}
	}
	function setCounterLeft(){
		try{
			$.ajax({
				url:getAppRootUrl()+"/IGDBM1201_ProcessCountYW.do",
				type:"POST",
				dataType :"text",
				cache:false,
				async:false,
				//成功回调函数
				success:function(result){
					var processArry = result.split("|");
					all.setCounterLeft(processArry[0],processArry[1],processArry[2]);
				},
				//失败回调函数
				error:function(XMLHttpRequest, textStatus, errorThrown){
					alert("获取初始化数据异常");
				}
			});
		}catch(err){
			setTimeout("setCounterLeft()",1000);
		}
	}
	function setLineForYear1(prtype){
		var rc="";
		var params="";
		if(prtype==null || prtype==""){
			params="I";
		}else{
			params=prtype;
		}
		$.ajax({
				url:getAppRootUrl()+"/IGDBM1201_Line.do?prtype="+params,
				type:"POST",
				dataType :"text",
				cache:false,
				async:false,
				//成功回调函数
				success:function(result){
					rc=result;
				},
				//失败回调函数
				error:function(XMLHttpRequest, textStatus, errorThrown){
					alert("获取初始化数据异常");
				}
			});
		return rc;
	}
	//初始化业务部门各类工单对比
 	function getBusinessDepart() {
 		var rcclass="";
 		$.ajax({
 			url:getAppRootUrl()+"/IGDBM1201_businessdepart.do",
 			type:"POST",
 			dataType :"text",
 			cache:false,
 			async:false,
 			//成功回调函数
 			success:function(xml){
 				rcclass=xml;
 			},
 			//失败回调函数
 			error:function(XMLHttpRequest, textStatus, errorThrown){
 				alert("获取初始化数据异常");
 			}
 		});
 		return rcclass;
 	}
 	//初始化科技部门各类工单对比
 	function getScienceDepart() {
 		var rcclass="";
 		$.ajax({
 			url:getAppRootUrl()+"/IGDBM1201_sciencedepart.do",
 			type:"POST",
 			dataType :"text",
 			cache:false,
 			async:false,
 			//成功回调函数
 			success:function(xml){
 				rcclass=xml;
 			},
 			//失败回调函数
 			error:function(XMLHttpRequest, textStatus, errorThrown){
 				alert("获取初始化数据异常");
 			}
 		});
 		return rcclass;
 	}
 	function goToLink(params){
 		var url = "/IGDBM1200.do";
 		if(params){
			var ps = params.split("#");
			if(ps.length > 0){
				url += "?";
				for(var i=0;i<ps.length;i++){
					if(i > 0){
						url += "&";
					}
					url += ps[i];
				}
			}
 		}
 		url = encodeURI(encodeURI(url));
 		openSubWindow(url, "_blank", 1100, 600);
 	}
</script>
<body onload="window.setInterval(playMovie,120000);initFlex();">

<div class="box">
		<ul id="flyout">
		<li><a href="#" class="nikon"><!--[if gte IE 7]><!--></a><!--<![endif]-->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
		<b></b>
		<ul>
		　　　　　　　　　　　<!--	<li><a href="/InfoGovernor/IGDBM1202.do">综合分析二</a></li>
		　	　　　　　　　　　<li><a href="/InfoGovernor/IGDBM1203.do">信息安全</a></li>-->
							<ig:dbMenu acturl="<%=request.getContextPath()%>" noDisplayActName="ACT04STA03|" actName="ACT16DBM" showtitle="false" />
							
		</ul>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
		</ul>
  	  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  width="1005" height="742"
		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" id="all">
          <param name="movie" value="images/dbmswf/crcb/crcb01.swf" />
          <param name="wmode" value="transparent" />
        </object>
</div>
</body>
<script type="text/javascript">
	$(function(){
		var b = $("#flyout").find("b");
		var licount = b.next("ul").children().length;
		b.height(licount>4?(licount+1)*20:100);
	});
</script>
</html:html>

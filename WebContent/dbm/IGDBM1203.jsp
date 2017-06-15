<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<html:html>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/swfobject.js"></script>
<script type="text/javascript">

var swfVersionStr = "11.1.0";
var xiSwfUrlStr = "playerProductInstall.swf";
var flashvars = {};
var params = {};
params.quality = "high";
params.bgcolor = "#ffffff";
params.allowscriptaccess = "sameDomain";
params.allowfullscreen = "true";
var attributes = {};
params.wmode = "opaque";
attributes.id = "infosafeDashBoardSWF";
attributes.name = "infosafeDashBoardSWF";
attributes.align = "middle";
swfobject.embedSWF("images/dbmswf/infosafe.swf", "infosafeDashBoard", "1100", "800", swfVersionStr, xiSwfUrlStr,flashvars, params, attributes);
swfobject.createCSS("#infosafeDashBoard", "display:block;text-align:left;");



//DashBoardMenu-quit
function quit(){
	if(window.confirm("您确定要退出系统吗？")){
		window.location="./IGCOM0102.do";
	}
}
//变更计划日历点下一月时回调函数
	function getRcclassByAjax() {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1203_rcclass.do",
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
	function getRcclassByMonth(year,month) {
		var rcclass="";
		var params=year+"-"+month;
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1203_rcclassbymonth.do?params="+params,
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
				alert("获取饼图数据异常");
			}
		});
		return rcclass;
	}
	function initRcclass() {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1203_rcclassbymonth.do",
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
	function getRcTestMode() {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1203_rctestmode.do",
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
	function getRiskCheckResult() {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1203_riskcheckresult.do",
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
	function getQuestions() {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1203_questions.do",
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
	
	
	function openRisk(params){
		var url = "/IGDBM1200_Risk.do";
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
<link type="text/css" href="css/dashboard.css" rel="stylesheet" />
<title></title>
<body>
<div class="box" >
<ul id="flyout">
		<li><a href="#" class="nikon"><!--[if gte IE 7]><!--></a><!--<![endif]-->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
		<b></b>
		<ul>
		 　　　　　　　　　　　　　　<!-- <li><a href="/InfoGovernor/IGDBM1201.do">综合分析一</a></li>
		 　　	　　　　　　　　　　　<li><a href="/InfoGovernor/IGDBM1202.do">综合分析二</a></li>-->
							<ig:dbMenu acturl="<%=request.getContextPath()%>" noDisplayActName="ACT04STA03|" actName="ACT16DBM" showtitle="false" />
		</ul>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
		</ul>
		<center>
		<div id="infosafeDashBoard"></div>
<!-- 	  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  width="1100" height="800" -->
<!-- 		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" id="all"> -->
<%--           <param name="movie" value="<%=basePath %>images/dbmswf/infosafe.swf" /> --%>
<!--           <param name="wmode" value="transparent" /> -->
<!--       </object> -->
      </center>
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
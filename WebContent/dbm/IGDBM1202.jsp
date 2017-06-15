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
<script type="text/javascript">

//问题解决数量对比情况
	function quit(){
		if(window.confirm("您确定要退出系统吗？")){
			window.location="./IGCOM0102.do";
		}
	}
	function getQotn() {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1202_qotn.do",
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
	//初始化工单各类别数量占比
	function getInitWorkOrder() {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1202_getWorkOrder.do",
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
	//工单各类别数量占比
	function getWorkOrder(year,month) {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1202_getWorkOrder.do?year="+year+"&&month="+month,
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
	//初始化变更结果占比统计
	function getInitChangeResult() {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1202_changeresult.do",
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
	//变更结果占比统计
	function getChangeResult(year,month) {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1202_changeresult.do?year="+year+"&&month="+month,
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
	//事件走势分析
	function getEventTrend() {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1202_eventtrend.do",
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
	function setCalendar(){
			var strXml = getCalendarDayByAjax("");
			return strXml;
			
	}
	//日历
	function getCalendarDayByAjax(valueOfDate) {
		
		var rcclass="";
		var data=valueOfDate;
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1202_setCalendar.do?date="+data,
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
//  			console.log(params);
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
<body >
<div class="box" >
<ul id="flyout">
		<li><a href="#" class="nikon"><!--[if gte IE 7]><!--></a><!--<![endif]-->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
		<b></b>
		<ul>
		                        　	  <!--  <li><a href="/InfoGovernor/IGDBM1201.do">综合分析一</a></li>
		                      　　　　  　<li><a href="/InfoGovernor/IGDBM1203.do">信息安全</a></li>-->
							<ig:dbMenu acturl="<%=request.getContextPath()%>" noDisplayActName="ACT04STA03|" actName="ACT16DBM" showtitle="false" />
		</ul>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
		</ul>
	  <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"  width="1100" height="800"
		codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" id="all">
          <param name="movie" value="<%=basePath %>images/dbmswf/science2.swf" />
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
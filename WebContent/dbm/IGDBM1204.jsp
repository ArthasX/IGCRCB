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
<bean:define id="id" value="IGDBM1204" toScope="request" />
<bean:define id="title" value="科技风险综合分析" toScope="request" />
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script type="text/javascript" src="js/swfobject.js"></script>

<link type="text/css" href="css/dashboard.css" rel="stylesheet" />
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
//DashBoardMenu-quit
	function quit(){
		if(window.confirm("您确定要退出系统吗？")){
			window.location="./IGCOM0102.do";
		}
	}
	
	/**
	* 获取 风险部门工作情况-电子表数据
	* @return rcclass String 电子表-xml字符串
	*
	*/
	function getCounter(){
		var countStr = "";
		try{
			
			$.ajax({
				url:getAppRootUrl()+"/IGDBM1204_getCounter.do",
				type:"POST",
				dataType :"text",
				cache:false,
				async:false,
				//成功回调函数
				success:function(result){
					countStr = result;
				},
				//失败回调函数
				error:function(XMLHttpRequest, textStatus, errorThrown){
					alert("获取初始化数据异常");
				}
			});
			
		}catch(err){
			//setTimeout("getCounter()",1000);
		}
		return countStr;
	}
	
	/**
	* 获取 本年度风险工作覆盖情况-检查
	* @return rcclass String 检查-xml字符串
	*
	*/
	function getRiskCheck() {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1204_getRiskCheck.do",
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
	/**
	* 获取 本年度风险问题及整改占比-问题及整改
	* @return rcclass String 问题及整改-xml字符串
	*
	*/
	function getRiskProblem() {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1204_getRiskProblem.do",
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
	/**
	* 获取 风险库分布情况-风险库
	* @return rcclass String 风险库-xml字符串
	*
	*/
	function getRiskRepository() {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1204_getRiskRepository.do",
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
	/**
	*获取 风险评估工作总体情况-问题及整改完成-柱图
	* @return rcclass String 柱图-xml字符串
	*
	*/
	function getRiskRectification() {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1204_getRiskRectification.do",
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
	/**
	* 获取 风险评估工作总体情况-线图-检查工作
	* @return rcclass String 线图-xml字符串
	*
	*/
	function getRiskAssess() {
		var rcclass="";
		$.ajax({
			url:getAppRootUrl()+"/IGDBM1204_getRiskAssess.do",
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
	/**
	* 获取问题整改各领域占比的钻取数据
	* @return rcclass String 
	*
	*/
	function goToLink(params){
		var url = "/IGDBM1200_ris.do";
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
	/**
	* 获取 电子表钻取数据
	* @return rcclass
	*
	*/
	function goToLinkCount(params){
		var url = "/IGDBM1200_count.do";
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
<body onload="window.setInterval(getCounter,120000);">
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
          <param name="movie" value="images/dbmswf/scienceRisk.swf" />
          <param name="wmode" value="transparent" />
        </object>
</div>
</body>
<script type="text/javascript">
jQuery(function(){
	var b = jQuery("#flyout").find("b");
	var licount = b.next("ul").children().length;
	b.height(licount>4?(licount+1)*20:100);
});

 
function openRiskRepository(param){
	var url="/IGDBM1200_RiskRiskrepository.do"+"?"+param.replace(/syscoding/,"esyscoding").replace(/#/g, "&");
	url = encodeURI(encodeURI(url));
	openSubWindow(url, "_blank", 1100, 600);
}
/**
 * 	风险评估工作总体砖取
 *
 */
function openPrInfo(param){
	var url="/IGDBM1200.do"+"?"+param.replace(/#/g, "&");
	url = encodeURI(encodeURI(url));
	openSubWindow(url, "_blank", 1100, 600);
}

</script>
</html:html>
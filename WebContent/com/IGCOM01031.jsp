<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>


<%@page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%><html:html>
<bean:define id="id" value="IGCOM0103" toScope="request" />
<bean:define id="title" value="首页" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	var jQ = jQuery.noConflict(true);
</script>

<script type="text/javascript" src="js/Highcharts/highcharts.js"></script>
<script type="text/javascript" src="js/Highcharts/modules/exporting.js"></script>

<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css"/>
<script type="text/javascript" src="js/Highcharts/com/igcom0103.js" charset="GBK"></script> 
<style>
	#tbTemp td{
		height: 20px;
		border-bottom: 1px solid #f0f0f0;
		text-align: center;
	}
	#tbTemp th{
		text-align: center; 
		height: 30px;
		border-bottom: 1px solid #f0f0f0;
		font-size: 13px;
	}
	.tdSum{
		color:red;
	}
	.trBg{
		background-color: #f0f0f0;
	}
	
.service {
width: 130px;
float: left;
margin-top: 15px;
margin-left: 10px;
}

.service a {
color: #666666;
text-decoration: none;
}
.more_img {
margin-top: 6px;
margin-right: 14px;
float: right;
clear: both;
display:block;

}

.texthidden{
clear:both;
width:190px;
 overflow:hidden;
 text-overflow:ellipsis;
 white-space:nowrap;
 }
.ball_0{ width:16px; height:16px;float:left; background:url(images/red_ball.png) no-repeat;} 
.ball_1{ width:16px; height:16px;float:left; background:url(images/green_ball.png) no-repeat;} 
</style>

<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script> 

<script type="text/javascript">
function goToNoticeInfoDetail(k){
	// alert("传递的值是"+k);
	var  nid=window.document.getElementsByName("nid")[k].value;
	//alert("nid值是"+nid);
	openSubWindow('/IGSYM0504.do?nid='+nid,"Notice","500","300");
	
}
function goToNoticeInfo(){
	openSubWindow('/IGSYM0504.do',"Notice","1000","600");
	
}
function goToKnowledgeInfo(url){
	openSubWindow(url,"Knowledge","1000","600");
}
function back(year,month){
	var form = document.getElementById("submitForm");

	var curmonth = month;
	var curyear = year;
    if(curmonth < 1){
    	curmonth = 12;
    	curyear = year - 1;
    }
	if(curmonth < 10){
		curmonth = "0" + curmonth;
	}
	
	form.action="IGCOM0403_DW.do?forward=back&year=" + year + "&month=" + month + "&curmonth=" + curmonth + "&curyear=" + curyear;
	form.submit();
}

function next(year,month){
	var form = document.getElementById("submitForm");

	var curmonth = month + 2;
	var curyear = year;
	if(curmonth > 12){
		curmonth = 1;
		curyear = year + 1;
	}
	if(curmonth < 10){
		curmonth = "0" + curmonth;
	}

	form.action="IGCOM0403_DW.do?forward=next&year=" + year + "&month=" + month + "&curmonth=" + curmonth + "&curyear=" + curyear;
	form.submit();
}

function goPage(year,month,date){
	var form = document.getElementById("submitForm");
//	form.action="IGCOM0202.do?linkID=IGCOM0402_POP&actname=ACT02SVC&year=" + year + "&month=" + month + "&date=" + date + "&prtype=C_D";

	if(month.length < 2){
		month = "0" + month;
	}
	if(date < 10){
		date = "0" + date;
	}
	form.action="IGSDL0110.do?date=" + year + "/" + month + "/" + date;
	form.submit();
}

//没有计划的日期跳转到服务策略登记页面
function goPageSDL(year,month,date){
	var form = document.getElementById("submitForm");
	if(month.length < 2){
		month = "0" + month;
	}
	if(date < 10){
		date = "0" + date;
	}
	//form.action="IGSDL0106_Disp.do?date=" + year + "/" + month + "/" + date;
	form.action="IGMTP0103_Disp.do?date=" + year + "/" + month + "/" + date;
	form.submit();
}



function showPersionList(){
	document.getElementById('persion').style.display='';
	document.getElementById('persionAsc').style.display='none';
	document.getElementById('group').style.display='none';
	document.getElementById('groupAsc').style.display='none';
	document.getElementById('discontinue').style.display='none';
	document.getElementById('discontinueAsc').style.display='none';
}
function showPersionListAsc(){
	document.getElementById('persion').style.display='none';
	document.getElementById('persionAsc').style.display='';
	document.getElementById('group').style.display='none';
	document.getElementById('groupAsc').style.display='none';
	document.getElementById('discontinue').style.display='none';
	document.getElementById('discontinueAsc').style.display='none';
}
function showGroupList(){
	document.getElementById('persion').style.display='none';
	document.getElementById('persionAsc').style.display='none';
	document.getElementById('group').style.display='';
	document.getElementById('groupAsc').style.display='none';
	document.getElementById('discontinue').style.display='none';
	document.getElementById('discontinueAsc').style.display='none';
}
function showGroupListAsc(){
	document.getElementById('persion').style.display='none';
	document.getElementById('persionAsc').style.display='none';
	document.getElementById('group').style.display='none';
	document.getElementById('groupAsc').style.display='';
	document.getElementById('discontinue').style.display='none';
	document.getElementById('discontinueAsc').style.display='none';
}
function showDiscontinueList(){
	document.getElementById('persion').style.display='none';
	document.getElementById('persionAsc').style.display='none';
	document.getElementById('group').style.display='none';
	document.getElementById('groupAsc').style.display='none';
	document.getElementById('discontinue').style.display='';
	document.getElementById('discontinueAsc').style.display='none';
}
function showDiscontinueListAsc(){
	document.getElementById('persion').style.display='none';
	document.getElementById('persionAsc').style.display='none';
	document.getElementById('group').style.display='none';
	document.getElementById('groupAsc').style.display='none';
	document.getElementById('discontinue').style.display='none';
	document.getElementById('discontinueAsc').style.display='';
}
function showCopyListAsc(){
	document.getElementById('persion').style.display='none';
	document.getElementById('persionAsc').style.display='none';
	document.getElementById('group').style.display='none';
	document.getElementById('groupAsc').style.display='none';
	document.getElementById('discontinue').style.display='none';
	document.getElementById('discontinueAsc').style.display='none';
}
function showCopyList(){
	document.getElementById('persion').style.display='none';
	document.getElementById('persionAsc').style.display='none';
	document.getElementById('group').style.display='none';
	document.getElementById('groupAsc').style.display='none';
	document.getElementById('discontinue').style.display='none';
	document.getElementById('discontinueAsc').style.display='none';
}
function switchShowJob(str){
	if(str == 1){
		document.getElementById('persion').style.display='none';
		document.getElementById('persionAsc').style.display='';
		document.getElementById('group').style.display='none';
		document.getElementById('groupAsc').style.display='none';
		document.getElementById('discontinue').style.display='none';
		document.getElementById('discontinueAsc').style.display='none';
		document.getElementById('showJobPersion').style.display='';
		document.getElementById('showJobGrpup').style.display='none';
		document.getElementById('showJobDiscontinue').style.display='none';
		document.getElementById('showJobCopyRead').style.display='none';
	}else if(str==2){
		document.getElementById('persion').style.display='none';
		document.getElementById('persionAsc').style.display='none';
		document.getElementById('group').style.display='';
		document.getElementById('groupAsc').style.display='none';
		document.getElementById('discontinue').style.display='none';
		document.getElementById('discontinueAsc').style.display='none';
		document.getElementById('showJobPersion').style.display='none';
		document.getElementById('showJobGrpup').style.display='';
		document.getElementById('showJobDiscontinue').style.display='none';
		document.getElementById('showJobCopyRead').style.display='none';
	}else if(str==3){
		document.getElementById('persion').style.display='none';
		document.getElementById('persionAsc').style.display='none';
		document.getElementById('group').style.display='none';
		document.getElementById('groupAsc').style.display='none';
		document.getElementById('discontinue').style.display='';
		document.getElementById('discontinueAsc').style.display='none';
		document.getElementById('showJobPersion').style.display='none';
		document.getElementById('showJobGrpup').style.display='none';
		document.getElementById('showJobDiscontinue').style.display='';
		document.getElementById('showJobCopyRead').style.display='none';
	}else if(str==4){
		document.getElementById('persion').style.display='none';
		document.getElementById('persionAsc').style.display='none';
		document.getElementById('group').style.display='none';
		document.getElementById('groupAsc').style.display='none';
		document.getElementById('discontinue').style.display='none';
		document.getElementById('discontinueAsc').style.display='none';
		document.getElementById('showJobPersion').style.display='none';
		document.getElementById('showJobGrpup').style.display='none';
		document.getElementById('showJobDiscontinue').style.display='none';
		document.getElementById('showJobCopyRead').style.display='';
		
	}else if(str==5){
		document.getElementById('persion').style.display='none';
		document.getElementById('persionAsc').style.display='none';
		document.getElementById('group').style.display='none';
		document.getElementById('groupAsc').style.display='none';
		document.getElementById('discontinue').style.display='none';
		document.getElementById('discontinueAsc').style.display='none';
		document.getElementById('showJobPersion').style.display='none';
		document.getElementById('showJobGrpup').style.display='none';
		document.getElementById('showJobDiscontinue').style.display='none';
		document.getElementById('showJobCopyRead').style.display='none';
	}
}

function switchShowAlert(str){
	if(str == 1){
		document.getElementById('BussinessAlertDesc').style.display='none';
		document.getElementById('bussinessGroup').style.display='none';
		document.getElementById('hqAlertDesc').style.display='';
		document.getElementById('hqAlertGroup').style.display='';
	}else if(str==2){
		document.getElementById('hqAlertGroup').style.display='none';
		document.getElementById('hqAlertDesc').style.display='none';
		document.getElementById('bussinessGroup').style.display='';
		document.getElementById('BussinessAlertDesc').style.display='';
	}
}


function searchprocessJC(prid,jc){
	if(prid!="" && prid !=null){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'prid='+ prid + '&type=searchprocessJC',
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result!=null && result!=""){
					jQ(jc).title = result;
				}
		     }
			});
	}
}

function searchprocessOP(prid,op){
	if(prid!="" && prid !=null){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'prid='+ prid + '&type=searchprocessOP',
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result!=null && result!=""){
					jQ(op).title = result;
				}
		     }
			});
	}
}

function initPlay() { 
	
	try{
		var workcount = '${workcount}';
		var orgname = '${orgname}'
	    if(workcount=="" || workcount ==null){
	    	workcount = "0|0|0|"
	    }

		 if(orgname=="" || orgname ==null){
		    orgname = " | | |"
		 }
	    
		Pillar.playPillarValue(workcount,orgname);
		
	}catch(err){

		setTimeout("initPlay()", 2000);	
	}
	
 }
//手动刷新
function switchIndex(){
	window.location="IGCOM0104.do";
}

//按钮置灰	
function initcheckio(){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'type=checkIo',onSuccess:  function(req, json){
			 var result=req.responseText;
	//alert(result);
			 //显示签到
				if(result == 1){
					//蓝色签到
					var pic1 = document.getElementById("pica").style.display="";
					//灰色签到
					var pic1 = document.getElementById("picb").style.display="none";
					//蓝色签出
					var pic3 = document.getElementById("picc").style.display="none";
					//灰色签出
					var pic4 = document.getElementById("picd").style.display="";
				}
				//显示签出
				if(result == 2){
					//蓝色签到
					var pic1 = document.getElementById("pica").style.display="none";
					//灰色签到
					var pic1 = document.getElementById("picb").style.display="";
					//蓝色签出
					var pic3 = document.getElementById("picc").style.display="";
					//灰色签出
					var pic4 = document.getElementById("picd").style.display="none";
				}
				//已签到已签出
				if(result ==3){
					//蓝色签到
					var pic1 = document.getElementById("pica").style.display="none";
					//灰色签到
					var pic1 = document.getElementById("picb").style.display="";
					//蓝色签出
					var pic3 = document.getElementById("picc").style.display="none";
					//灰色签出
					var pic4 = document.getElementById("picd").style.display="";
				}
		     }
		});
	}
	//定时刷新
	setTimeout("switchIndex()", 300000);
	
	function openProcess(pdid,ptid){
		var pdiddel = pdid.substring(0,5);
		window.location.href = "<%=request.getContextPath()%>/IGPRR0101_Disp.do?psdcode=<%=IGPRDCONSTANTS.PROCESS_START_STATUS%>&pdid="+pdiddel+"&ptid="+ptid;
	}
	function onLoadCharts(){
// 		set_line_chart();
// 		radar();
	} 
</script>
<style type="text/css">
.ql {
	float: left;
	height: auto;
	width: 713px;
	overflow: hidden;
}
.quick li a:hover{
	background-position: 50% 0%;
	border: 1px solid #005da1;
}
.quick {
	list-style-type: none;
	margin-top: 0;
	margin-right: 0px;
	margin-bottom: 0px;
	margin-left: 0;
	padding: 0px;
}
.quick li {
	display: inline-block;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 7px;
	margin-left: 0;
	padding: 0px;
	float: left;
}
.quick li a {
	font-size: 12px;
	color: #555;
	border: 1px solid #cccccc;
	display: block;
	text-align: center;
	text-decoration: none;
	background: -webkit-gradient(linear, 50% 0%, 50% 100%, color-stop(0%, #F6F6F6), color-stop(100%, #E6E6E6));
	width: 78px;
	padding-top: 8px;
	/* [disabled]padding-right: 5px; */
	padding-bottom: 8px;
	/* [disabled]padding-left: 5px; */
	height: 52px;
	margin-top: 0px;
	margin-right: 9px;
	margin-left: 0px;
	background-color: #f8f8f8;
}
.quick ul {
	margin: 0px;
	padding: 0px;
}

.quick li a img {
	width: 32px;
	height: 32px;
	margin: 0 auto;
	border-top-width: 0px;
	border-right-width: 0px;
	border-bottom-width: 0px;
	border-left-width: 0px;
}
.quick li a span {
	margin-top: 10px;
	display: block;
}
.quick li a {
font-size: 12px;
color: #555;
text-align: center;
}
</style>
<body onload="initPlay();initcheckio();onLoadCharts();">
<div id="maincontent">
<jsp:include page="/include/header2.jsp" />
 <div class="new_content">
  <div class="new_left">
   <div class="ql">
      <ul class="quick" data-collapse="collapse">
        <li> 
        	<ig:menuAuth actname="ACT02SVC0202">
        		<html:link action="/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01080&ptid=8&actname=ACT02SVC0202">
        			<img src="image/icon01.jpg" alt=""/><span>故障申报</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT02SVC0202" permission="false">
				<a href="###"><img src="image/icon01.jpg" alt=""/><span>故障申报</span></a>
			</ig:menuAuth>
        </li>
        <li>
        	<ig:menuAuth actname="ACT02SVC0202">
        		<html:link action="/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01083&ptid=8&actname=ACT02SVC0302">
        			<img src="image/icon02.jpg" alt=""/><span>问题建立</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT02SVC0302" permission="false">
				<a href="###"><img src="image/icon02.jpg" alt=""/><span>问题建立</span></a>
			</ig:menuAuth>
        </li>
        <li>
        	<ig:menuAuth actname="ACT02SVC0402">
        		<html:link action="/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01084&ptid=8&actname=ACT02SVC0402">
        			<img src="image/icon03.jpg" alt=""/><span>变更实施</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT02SVC0402" permission="false">
				<a href="###"><img src="image/icon03.jpg" alt=""/><span>变更实施</span></a>
			</ig:menuAuth>
        </li>
        <li>
        	<ig:menuAuth actname="ACT02SVC1304">
        		<html:link action="/IGCOM0202.do?linkID=IGKGM0205&actname=ACT02SVC1304">
        			<img src="image/icon04.jpg" alt=""/><span>知识库</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT02SVC1304" permission="false">
				<a href="###"><img src="image/icon04.jpg" alt=""/><span>知识库</span></a>
			</ig:menuAuth>
        </li>
        <li>
        	<ig:menuAuth actname="ACT02SVC1502">
        		<html:link action="/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01320&ptid=8&actname=ACT02SVC1502">
        			<img src="image/icon05.jpg" alt=""/><span>机房进入</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT02SVC1502" permission="false">
				<a href="###"><img src="image/icon05.jpg" alt=""/><span>机房进入</span></a>
			</ig:menuAuth>
        </li>
        <li>
        	<ig:menuAuth actname="ACT15BUS0101">
        		<html:link action="/IGCOM0202.do?linkID=IGAIM0102&actname=ACT15BUS0101">
        			<img src="image/icon06.jpg" alt=""/><span>应用拓扑</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT15BUS0101" permission="false">
				<a href="###"><img src="image/icon06.jpg" alt=""/><span>应用拓扑</span></a>
			</ig:menuAuth>
        </li>
        <li>
        	<ig:menuAuth actname="ACT13MTM0305">
        		<html:link action="/IGCOM0202.do?linkID=IGMTM0501&actname=ACT13MTM0305">
        			<img src="image/icon07.jpg" alt=""/><span>实时监控</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT13MTM0305" permission="false">
				<a href="###"><img src="image/icon07.jpg" alt=""/><span>实时监控</span></a>
			</ig:menuAuth>
        </li>
        <li>
        	<ig:menuAuth actname="ACT03SDL0808">
        		<html:link action="/IGCOM0202.do?linkID=IGDUT0301&actname=ACT03SDL0808">
        			<img src="image/icon08.jpg" alt=""/><span>值班情况</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT03SDL0808" permission="false">
				<a href="###"><img src="image/icon08.jpg" alt=""/><span>值班情况</span></a>
			</ig:menuAuth>
        </li>
      </ul>
      <div style="clear:both;"></div>
    </div>
    <div class="new_working">
      <div class="new_wtitle">
     		<div id="showJobPersion" >
        	    <h1 style="float:left; font-size:12px; font-weight:bold; color:#006BC6; padding-left:5px; line-height:22px;"><img src="images/work1.gif" style="vertical-align: middle;"/>&nbsp;处理中工作</h1>
        	    <div style="float:right; padding-right:20px; line-height:22px;">
	        	    <font style="font-family:Arial, Helvetica, sans-serif">个人工作&nbsp;|&nbsp;
	        	    <a href="javascript:switchShowJob('2')" style="color: #006BC6">相关工作</a>
	        	    &nbsp;|&nbsp;
	        	    <a href="javascript:switchShowJob('3')" style="color: #006BC6">被中止工作</a>
<!-- 	        	    &nbsp;|&nbsp; -->
<!-- 	        	    <a href="javascript:switchShowJob('4')" style="color: #006BC6">抄阅</a> -->
	        	    <%-- <c:if test="${IGCOM01031VO.islimit }">
	        	    &nbsp;|&nbsp;
	        	    <a href="javascript:switchShowJob('5')" style="color: #006BC6">监管报表</a>
	        	    </c:if> --%>
	        	    </font>
        	    </div>
			</div>
			<div id="showJobGrpup" style="display:none">
				<h1 style="float:left; font-size:12px; font-weight:bold; color:#006BC6; padding-left:5px; line-height:22px;"><img src="images/work1.gif" style="vertical-align: middle;"/>&nbsp;处理中工作</h1>
				<div style="float:right; padding-right:20px; line-height:22px;">
					<font style="font-family:Arial, Helvetica, sans-serif">
					<a href="javascript:switchShowJob('1')" style="color: #006BC6">个人工作</a>
					&nbsp;|&nbsp;相关工作&nbsp;|&nbsp;
					<a href="javascript:switchShowJob('3')" style="color: #006BC6">被中止工作</a>
<!-- 					&nbsp;|&nbsp; -->
<!-- 	        	    <a href="javascript:switchShowJob('4')" style="color: #006BC6">抄阅</a> -->
	        	     <%-- <c:if test="${IGCJQM01031VO.islimit }">
	        	    &nbsp;|&nbsp;
	        	    <a href="javascript:switchShowJob('5')" style="color: #006BC6">监管报表</a>
	        	    </c:if> --%>
					</font>
				</div>
			</div>
			<div id="showJobDiscontinue" style="display:none">
				<h1 style="float:left; font-size:12px; font-weight:bold; color:#006BC6; padding-left:5px; line-height:22px;"><img src="images/work1.gif" style="vertical-align: middle;"/>&nbsp;处理中工作</h1>
				<div style="float:right; padding-right:20px; line-height:22px;">
					<font style="font-family:Arial, Helvetica, sans-serif">
					<a href="javascript:switchShowJob('1')" style="color: #006BC6">个人工作</a>
					&nbsp;|&nbsp;
					<a href="javascript:switchShowJob('2')" style="color: #006BC6">相关工作</a>
					&nbsp;|&nbsp;被中止工作
<!-- 					&nbsp;|&nbsp; -->
<!-- 	        	    <a href="javascript:switchShowJob('4')" style="color: #006BC6">抄阅</a> -->
	        	    <%--  <c:if test="${IGCOM01031VO.islimit }">
	        	    &nbsp;|&nbsp;
	        	    <a href="javascript:switchShowJob('5')" style="color: #006BC6">监管报表</a>
	        	    </c:if> --%>
					</font>
				</div>
			</div>
			<div id="showJobCopyRead" style="display:none">
				<h1 style="float:left; font-size:12px; font-weight:bold; color:#006BC6; padding-left:5px; line-height:22px;"><img src="images/work1.gif" style="vertical-align: middle;"/>&nbsp;处理中工作</h1>
				<div style="float:right; padding-right:20px; line-height:22px;">
					<font style="font-family:Arial, Helvetica, sans-serif">
					<a href="javascript:switchShowJob('1')" style="color: #006BC6">个人工作</a>
					&nbsp;|&nbsp;
					<a href="javascript:switchShowJob('2')" style="color: #006BC6">相关工作</a>
					&nbsp;|&nbsp;
					<a href="javascript:switchShowJob('3')" style="color: #006BC6">被中止工作</a>
<!-- 					&nbsp;|&nbsp; -->
<!-- 	        	          抄阅	 -->
	        	    <%-- <c:if test="${IGCOM01031VO.islimit }">
	        	    &nbsp;|&nbsp;
	        	    <a href="javascript:switchShowJob('5')" style="color: #006BC6">监管报表</a>	
	        	    </c:if>	 --%>		
					</font>
				</div>
			</div>
			<div id="supervisereport" style="display:none">
				<h1 style="float:left; font-size:12px; font-weight:bold; color:#006BC6; padding-left:5px; line-height:22px;"><img src="images/work1.gif" style="vertical-align: middle;"/>&nbsp;处理中工作</h1>
				<div style="float:right; padding-right:20px; line-height:22px;">
					<font style="font-family:Arial, Helvetica, sans-serif">
					<a href="javascript:switchShowJob('1')" style="color: #006BC6">个人工作</a>
					&nbsp;|&nbsp;
					<a href="javascript:switchShowJob('2')" style="color: #006BC6">相关工作</a>
					&nbsp;|&nbsp;
					<a href="javascript:switchShowJob('3')" style="color: #006BC6">被中止工作</a>
<!-- 					&nbsp;|&nbsp; -->
<!-- 	               <a href="javascript:switchShowJob('4')" style="color: #006BC6">抄阅</a> -->
	               <%--  <c:if test="${IGCOM01031VO.islimit }">	
	               &nbsp;|&nbsp;
	                                          监管报表	
	                </c:if>		 --%>
					</font>
				</div>
			</div>
      </div>
      <div class="new_wcont">
            <div id="persionAsc">
            <table width="670" border="0" cellspacing="0" cellpadding="0" style="margin-left:26px;">
				<tr align="left" height="28">
<!--                <th width="20"></th>-->
<!--                <th width="20"></th>-->
                <!-- <th width="20"></th> -->
                <th width="100" align="left">编号</th>
                <th width="155" align="left">名称</th>
                <th width="75" align="left">类型</th>
                <th width="105" align="left"><span><a href="javascript:showPersionList();">开始时间<img src="images/timedown.gif" border="0"></a></span></th>
                <th width="80" align="left">处理角色</th>
                <th width="75" align="left">处理人</th>
                <th width="105" align="left">状态</th>
				</tr>
	<logic:iterate id="processRecordInfo" name="IGCOM01031VO" indexId="index" length="7" property="processInHandDesc" type="com.deliverik.infogovernor.com.model.ProcessInHandVWInfo">
		<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${processRecordInfo.prid }"/>" class="my_work" onmouseover="mouseOver(this);"  height="27" onmouseout="mouseOut(this,'my_work');"  onclick="doLook('${processRecordInfo.showurl }${processRecordInfo.prid }&prstatus=${processRecordInfo.prstatus}&jump=77');">
<!--			<td valign="middle">-->
<!--				<ig:ProcessInfoValueLevelImgTag pdname="${processRecordInfo.prpdname}" prid="${processRecordInfo.prid}" />-->
<!--			</td>-->
<!--			<td valign="middle">-->
<!--				<ig:ProcessOverdueLevelImgTag prstatus="${processRecordInfo.prstatus}" prid="${processRecordInfo.prid}" />-->
<!--			</td>-->
			<!-- <td>
			<logic:equal name="processRecordInfo" property="showtype" value="1">	
				<img src="images/${processRecordInfo.prurgency}.gif" alt="紧急程度：<ig:codeValue ccid='${processRecordInfo.prtype}URGENCY_GRADE_CODE' cid="${processRecordInfo.prurgency}"/>" width="10" height="16" />
			</logic:equal>
			<logic:equal name="processRecordInfo" property="showtype" value="2">	
				<c:if test="${processRecordInfo.prurgency != null and processRecordInfo.prurgency > ' '}">
					<img src="images/${processRecordInfo.prurgency}.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="${processRecordInfo.prurgency}"/>" width="10" height="16" />
				</c:if>
			</logic:equal>
			</td> -->
    		<td>${processRecordInfo.prserialnum}</td>
    		<td>
	    		<span title="${processRecordInfo.prtitle}">${processRecordInfo.showtitle}</span>
			</td>
    		<td style="text-align: left"><span title="${processRecordInfo.prpdname }">${processRecordInfo.showpdname }</span></td>
    		<td>${processRecordInfo.propentime}</td>
    		<td onmouseover="searchprocessJC('${processRecordInfo.prid}','jca${index}');" id="jca${index}">${processRecordInfo.showrolename}</td>
    	
			<td title="<ig:ProcessParticipantForStatusWriteTag prstatus="${processRecordInfo.prstatus }" prid="${processRecordInfo.prid }" />">
			<ig:SubstringShowEllipsisWriteTag len="4" showEllipsis="true">
				<ig:ProcessParticipantForStatusWriteTag prstatus="${processRecordInfo.prstatus }" prid="${processRecordInfo.prid }" />
			</ig:SubstringShowEllipsisWriteTag>
			</td>
		
    		<td>
	    		<logic:equal name="processRecordInfo" property="showtype" value="2">	
					<ig:processDefineTypeValue prid="${processRecordInfo.prid}"/>
				</logic:equal>
	    		<logic:notEqual name="processRecordInfo" property="showtype" value="2">	
	    		<ig:codeValue
					ccid="${processRecordInfo.prtype }"
					cid="${processRecordInfo.prstatus}" /> 
				</logic:notEqual>		
				
				<ig:ProcessStatusWarningImgTag 
	                        processType="${processRecordInfo.prtype}" prid = "${processRecordInfo.prid}" prStatus = "${processRecordInfo.prstatus}" 
	                        prStrategyVersion="${processRecordInfo.prstrategyversion}" prPdid="${processRecordInfo.prpdid}" prUrgency="${processRecordInfo.prurgency}"/>
			</td>
		</tr>
        <tr>
          <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
     	</tr>
     	<logic:equal name="index" value="9">
     		<tr>
            <td colspan="9">
             <a href="IGCOM0202.do?linkID=IGSVC0101&actname=ACT02SVC0101"><img src="images/main_more.gif" border="0" class="more_img"/></a>
          &nbsp;</td>
     	</tr>
     	</logic:equal>
	</logic:iterate>
 		
    </table>
    </div>
<div id="persion" style="display:none">
<table width="670" border="0" cellspacing="0" cellpadding="0" style="margin-left:26px">
	<tr align="left" height="28">
<!--          <th width="20"></th>-->
<!--          <th width="20"></th>-->
          <!-- <th width="20"></th> -->
          <th width="100" align="left">编号</th>
          <th width="155" align="left">名称</th>
          <th width="75" align="left">类型</th>
          <th width="105" align="left"><span><a href="javascript:showPersionListAsc();">开始时间<img src="images/timeup.gif" border="0"/></a></span></th>
          <th width="80" align="left">处理角色</th>
          <th width="75" align="left">处理人</th>
          <th width="105" align="left">状态</th>
	</tr>
	<logic:iterate id="processRecordInfo" name="IGCOM01031VO" indexId="index" length="7" property="processInHandAsc" type="com.deliverik.infogovernor.com.model.ProcessInHandVWInfo">
		<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${processRecordInfo.prid }"/>" class="my_work" onmouseover="mouseOver(this);"  height="27" onmouseout="mouseOut(this,'my_work');"  onclick="doLook('${processRecordInfo.showurl }${processRecordInfo.prid }&prstatus=${processRecordInfo.prstatus}&jump=77');">
<!--			<td valign="middle">-->
<!--				<ig:ProcessInfoValueLevelImgTag pdname="${processRecordInfo.prpdname}"  prid="${processRecordInfo.prid}" />-->
<!--			</td>-->
<!--			<td valign="middle">-->
<!--				<ig:ProcessOverdueLevelImgTag prstatus="${processRecordInfo.prstatus}" prid="${processRecordInfo.prid}" />-->
<!--			</td>-->
			<!-- <td>
			<logic:equal name="processRecordInfo" property="showtype" value="1">	
				<img src="images/${processRecordInfo.prurgency}.gif" alt="紧急程度：<ig:codeValue ccid='${processRecordInfo.prtype}URGENCY_GRADE_CODE' cid="${processRecordInfo.prurgency}"/>" width="10" height="16" />
			</logic:equal>
			<logic:equal name="processRecordInfo" property="showtype" value="2">
				<c:if test="${processRecordInfo.prurgency != null and processRecordInfo.prurgency > ' '}">
					<img src="images/${processRecordInfo.prurgency}.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="${processRecordInfo.prurgency}"/>" width="10" height="16" />
				</c:if>	
			</logic:equal>
			</td> -->
    		<td>${processRecordInfo.prserialnum}</td>
    		<td>
	    		<span title="${processRecordInfo.prtitle}">${processRecordInfo.showtitle}</span>
			</td>
    		<td style="text-align: left"><span title="${processRecordInfo.prpdname }">${processRecordInfo.showpdname }</span></td>
    		<td>${processRecordInfo.propentime}</td>
    		<td onmouseover="searchprocessJC('${processRecordInfo.prid}','jcb${index}');" id="jcb${index}">${processRecordInfo.showrolename}</td>
    	
			<td title="<ig:ProcessParticipantForStatusWriteTag prstatus="${processRecordInfo.prstatus }" prid="${processRecordInfo.prid }" />">
			<ig:SubstringShowEllipsisWriteTag len="4" showEllipsis="true">
				<ig:ProcessParticipantForStatusWriteTag prstatus="${processRecordInfo.prstatus }" prid="${processRecordInfo.prid }" />
			</ig:SubstringShowEllipsisWriteTag>
			</td>
		
    		<td>
	    		<logic:equal name="processRecordInfo" property="showtype" value="2">	
					<ig:processDefineTypeValue prid="${processRecordInfo.prid}"/> 
				</logic:equal>
	    		<logic:notEqual name="processRecordInfo" property="showtype" value="2">	
	    		<ig:codeValue
					ccid="${processRecordInfo.prtype }"
					cid="${processRecordInfo.prstatus}" /> 
				</logic:notEqual>		
				
				<ig:ProcessStatusWarningImgTag 
	                        processType="${processRecordInfo.prtype}" prid = "${processRecordInfo.prid}" prStatus = "${processRecordInfo.prstatus}" 
	                        prStrategyVersion="${processRecordInfo.prstrategyversion}" prPdid="${processRecordInfo.prpdid}" prUrgency="${processRecordInfo.prurgency}"/>
			</td>
		</tr>
        <tr>
          <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
     	</tr>
     	<logic:equal name="index" value="9">
     		<tr>
           <td colspan="9">
             <a href="IGCOM0202.do?linkID=IGSVC0101&actname=ACT02SVC0101"><img src="images/main_more.gif" border="0" class="more_img"/></a>
          &nbsp;</td>
     	</tr>
     	</logic:equal>
	</logic:iterate>
 		
		</table>
	</div>
 <div id="groupAsc" style="display:none">
	 <table width="670" border="0" cellspacing="0" cellpadding="0" style="margin-left:26px">
	<tr align="left" height="28">
<!--          <th width="20"></th>-->
<!--          <th width="20"></th>-->
          <!-- <th width="20"></th> -->
          <th width="100" align="left">编号</th>
          <th width="155" align="left">名称</th>
          <th width="75" align="left">类型</th>
          <th width="105" align="left"><span><a href="javascript:showGroupList();">开始时间<img src="images/timeup.gif" border="0"/></a></span></th>
          <th width="80" align="left">处理角色</th>
          <th width="75" align="left">处理人</th>
          <th width="105" align="left">状态</th>
	</tr>
		<logic:iterate id="processRecordInfo" name="IGCOM01031VO" indexId="index" length="7" property="processInHandGroupAsc" type="com.deliverik.infogovernor.com.model.ProcessInHandVWInfo">
		<c:if test="${processRecordInfo.prtype != 'WB'}">
		<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${processRecordInfo.prid }"/>"  class="my_work" onmouseover="mouseOver(this);"  height="27" onmouseout="mouseOut(this,'my_work');"  onclick="doLook('${processRecordInfo.showurl }${processRecordInfo.prid }&prstatus=${processRecordInfo.prstatus}&jump=77');">
<!--			<td valign="middle">-->
<!--				<ig:ProcessInfoValueLevelImgTag pdname="${processRecordInfo.prpdname}"  prid="${processRecordInfo.prid}" />-->
<!--			</td>-->
<!--			<td valign="middle">-->
<!--				<ig:ProcessOverdueLevelImgTag prstatus="${processRecordInfo.prstatus}" prid="${processRecordInfo.prid}" />-->
<!--			</td>-->
			<!-- <td>
			<logic:equal name="processRecordInfo" property="showtype" value="1">	
				<img src="images/${processRecordInfo.prurgency}.gif" alt="紧急程度：<ig:codeValue ccid='${processRecordInfo.prtype}URGENCY_GRADE_CODE' cid="${processRecordInfo.prurgency}"/>" width="10" height="16" />
			</logic:equal>
			<logic:equal name="processRecordInfo" property="showtype" value="2">
				<c:if test="${processRecordInfo.prurgency != null and processRecordInfo.prurgency > ' '}">
					<img src="images/${processRecordInfo.prurgency}.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="${processRecordInfo.prurgency}"/>" width="10" height="16" />
				</c:if>
			</logic:equal>
			</td> -->
    		<td>${processRecordInfo.prserialnum}</td>
    		<td>
	    		<span title="${processRecordInfo.prtitle}">${processRecordInfo.showtitle}</span>
			</td>
    		<td style="text-align: left"><span title="${processRecordInfo.prpdname }">${processRecordInfo.showpdname }</span></td>
    		<td>${processRecordInfo.propentime}</td>
    		<td onmouseover="searchprocessJC('${processRecordInfo.prid}','jcc${index}');" id="jcc${index}">${processRecordInfo.showrolename}</td>
    	
			<td >
				<logic:empty name="processRecordInfo" property="ppusername"><img src="images/noimplementor.gif" width="16" height="16" alt="无执行人"/></logic:empty>
				<logic:notEmpty name="processRecordInfo" property="ppusername">
					<ig:SubstringShowEllipsisWriteTag len="4" showEllipsis="true">
						<ig:ProcessParticipantForStatusWriteTag prstatus="${processRecordInfo.prstatus }" prid="${processRecordInfo.prid }" />
					</ig:SubstringShowEllipsisWriteTag>
				</logic:notEmpty>
			</td>
		
    		<td>
	    		<logic:equal name="processRecordInfo" property="showtype" value="2">	
					<ig:processDefineTypeValue prid="${processRecordInfo.prid}"/> 
				</logic:equal>
	    		<logic:notEqual name="processRecordInfo" property="showtype" value="2">	
	    		<ig:codeValue
					ccid="${processRecordInfo.prtype }"
					cid="${processRecordInfo.prstatus}" /> 
				</logic:notEqual>		
				
				<ig:ProcessStatusWarningImgTag 
	                        processType="${processRecordInfo.prtype}" prid = "${processRecordInfo.prid}" prStatus = "${processRecordInfo.prstatus}" 
	                        prStrategyVersion="${processRecordInfo.prstrategyversion}" prPdid="${processRecordInfo.prpdid}" prUrgency="${processRecordInfo.prurgency}"/>
			</td>
		</tr>
        <tr>
          <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
     	</tr>
     	</c:if>
	</logic:iterate>
	 <logic:equal name="index" value="9">
		<tr>
             <td colspan="9">
             <a href="IGCOM0202.do?linkID=IGSVC0102&actname=ACT02SVC0102"><img src="images/main_more.gif" border="0" class="more_img"/></a>
          &nbsp;</td>
     	</tr>
	 </logic:equal>	
     	
	</table>
 </div>
	<div id="group" style="display:none">
	<table width="670" border="0" cellspacing="0" cellpadding="0" style="margin-left:26px">
	<tr align="left" height="28">
<!--          <th width="20"></th>-->
<!--          <th width="20"></th>-->
          <!-- <th width="20"></th> -->
          <th width="100" align="left">编号</th>
          <th width="155" align="left">名称</th>
          <th width="75" align="left">类型</th>
          <th width="105" align="left"><span><a href="javascript:showGroupListAsc();">开始时间<img src="images/timedown.gif" border="0"/></a></span></th>
          <th width="80" align="left">处理角色</th>
          <th width="75" align="left">处理人</th>
          <th width="105" align="left">状态</th>
	</tr>
		<logic:iterate id="processRecordInfo" name="IGCOM01031VO" indexId="index" length="7" property="processInHandGroupDesc" type="com.deliverik.infogovernor.com.model.ProcessInHandVWInfo">
		<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${processRecordInfo.prid }"/>" class="my_work" onmouseover="mouseOver(this);"  height="27" onmouseout="mouseOut(this,'my_work');"  onclick="doLook('${processRecordInfo.showurl }${processRecordInfo.prid }&prstatus=${processRecordInfo.prstatus}&jump=77');">
<!--			<td valign="middle">-->
<!--				<ig:ProcessInfoValueLevelImgTag pdname="${processRecordInfo.prpdname}"  prid="${processRecordInfo.prid}" />-->
<!--			</td>-->
<!--			<td valign="middle">-->
<!--				<ig:ProcessOverdueLevelImgTag prstatus="${processRecordInfo.prstatus}" prid="${processRecordInfo.prid}" />-->
<!--			</td>-->
			<!-- <td>
			<logic:equal name="processRecordInfo" property="showtype" value="1">	
				<img src="images/${processRecordInfo.prurgency}.gif" alt="紧急程度：<ig:codeValue ccid='${processRecordInfo.prtype}URGENCY_GRADE_CODE' cid="${processRecordInfo.prurgency}"/>" width="10" height="16" />
			</logic:equal>
			<logic:equal name="processRecordInfo" property="showtype" value="2">
				<c:if test="${processRecordInfo.prurgency != null and processRecordInfo.prurgency > ' '}">
					<img src="images/${processRecordInfo.prurgency}.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="${processRecordInfo.prurgency}"/>" width="10" height="16" />
				</c:if>
			</logic:equal>
			</td> -->
    		<td>${processRecordInfo.prserialnum}</td>
    		<td>
	    		<span title="${processRecordInfo.prtitle}">${processRecordInfo.showtitle}</span>
			</td>
    		<td style="text-align: left"><span title="${processRecordInfo.prpdname }">${processRecordInfo.showpdname }</span></td>
    		<td>${processRecordInfo.propentime}</td>
    		<td onmouseover="searchprocessJC('${processRecordInfo.prid}','jcd${index}');" id="jcd${index}">${processRecordInfo.showrolename}</td>
    	
			<td>
			<logic:empty name="processRecordInfo" property="ppusername"><img src="images/noimplementor.gif" width="16" height="16" alt="无执行人"/></logic:empty>
			<logic:notEmpty name="processRecordInfo" property="ppusername">
				<ig:SubstringShowEllipsisWriteTag len="4" showEllipsis="true">
					<ig:ProcessParticipantForStatusWriteTag prstatus="${processRecordInfo.prstatus }" prid="${processRecordInfo.prid }" />
				</ig:SubstringShowEllipsisWriteTag>
			</logic:notEmpty>
			</td>
		
    		<td>
	    		<logic:equal name="processRecordInfo" property="showtype" value="2">	
					<ig:processDefineTypeValue prid="${processRecordInfo.prid}"/> 
				</logic:equal>
	    		<logic:notEqual name="processRecordInfo" property="showtype" value="2">	
	    		<ig:codeValue
					ccid="${processRecordInfo.prtype }"
					cid="${processRecordInfo.prstatus}" /> 
				</logic:notEqual>		
				
				<ig:ProcessStatusWarningImgTag 
	                        processType="${processRecordInfo.prtype}" prid = "${processRecordInfo.prid}" prStatus = "${processRecordInfo.prstatus}" 
	                        prStrategyVersion="${processRecordInfo.prstrategyversion}" prPdid="${processRecordInfo.prpdid}" prUrgency="${processRecordInfo.prurgency}"/>
			</td>
		</tr>
        <tr>
          <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
     	</tr>
     	<logic:equal name="index" value="9">
     			<tr>
	           <td colspan="9">
             <a href="IGCOM0202.do?linkID=IGSVC0102&actname=ACT02SVC0102"><img src="images/main_more.gif" border="0" class="more_img"/></a>
          &nbsp;</td>
	   	</tr>
     	</logic:equal>
	</logic:iterate>
	   
	</table>
	</div>
	<div id="discontinueAsc" style="display:none">
	<table width="670" border="0" cellspacing="0" cellpadding="0" style="margin-left:26px">
	<tr align="left" height="28">
<!--          <th width="20"></th>-->
<!--          <th width="20"></th>-->
          <!-- <th width="20"></th> -->
          <th width="100" align="left">编号</th>
          <th width="155" align="left">名称</th>
          <th width="75" align="left">类型</th>
          <th width="105" align="left"><span><a href="javascript:showDiscontinueList();">开始时间<img src="images/timeup.gif" border="0"/></a></span></th>
          <th width="80" align="left">处理角色</th>
          <th width="75" align="left">处理人</th>
          <th width="105" align="left">状态</th>
	</tr>
		<logic:present name="IGCOM01031VO" property="processInHandDiscontinueAsc">
		<logic:iterate id="processRecordInfo" name="IGCOM01031VO" indexId="index" length="7" property="processInHandDiscontinueAsc" type="com.deliverik.infogovernor.com.model.ProcessInHandVWInfo">
		<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${processRecordInfo.prid }"/>" class="my_work" onmouseover="mouseOver(this);"  height="27" onmouseout="mouseOut(this,'my_work');"  onclick="doLook('${processRecordInfo.showurl }${processRecordInfo.prid }&prstatus=${processRecordInfo.prstatus}&flag=1&jump=77');">
<!--			<td valign="middle">-->
<!--				<ig:ProcessInfoValueLevelImgTag pdname="${processRecordInfo.prpdname}"  prid="${processRecordInfo.prid}" /> -->
<!--			</td>-->
<!--			<td valign="middle">-->
<!--				<ig:ProcessOverdueLevelImgTag prstatus="${processRecordInfo.prstatus}" prid="${processRecordInfo.prid}" />-->
<!--			</td>-->
			<!-- <td>
			<logic:equal name="processRecordInfo" property="showtype" value="1">	
				<img src="images/${processRecordInfo.prurgency}.gif" alt="紧急程度：<ig:codeValue ccid='${processRecordInfo.prtype}URGENCY_GRADE_CODE' cid="${processRecordInfo.prurgency}"/>" width="10" height="16" />
			</logic:equal>
			<logic:equal name="processRecordInfo" property="showtype" value="2">
				<c:if test="${processRecordInfo.prurgency != null and processRecordInfo.prurgency > ' '}">
					<img src="images/${processRecordInfo.prurgency}.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="${processRecordInfo.prurgency}"/>" width="10" height="16" />
				</c:if>
			</logic:equal>
			</td> -->
    		<td>${processRecordInfo.prserialnum}</td>
    		<td>
	    		<span title="${processRecordInfo.prtitle}">${processRecordInfo.showtitle}</span>
			</td>
    		<td style="text-align: left"><span title="${processRecordInfo.prpdname }">${processRecordInfo.showpdname }</span></td>
    		<td>${processRecordInfo.propentime}</td>
    		<td onmouseover="searchprocessJC('${processRecordInfo.prid}','jcc${index}');" id="jcc${index}">${processRecordInfo.showrolename}</td>
    	
			<td>
			<logic:empty name="processRecordInfo" property="ppusername"><img src="images/noimplementor.gif" width="16" height="16" alt="无执行人"/></logic:empty>
			<logic:notEmpty name="processRecordInfo" property="ppusername">${processRecordInfo.ppusername}</logic:notEmpty>
			</td>
		
    		<td>
	    		<logic:equal name="processRecordInfo" property="showtype" value="2">	
					<ig:processDefineTypeValue prid="${processRecordInfo.prid}"/> 
				</logic:equal>
	    		<logic:notEqual name="processRecordInfo" property="showtype" value="2">	
	    		<ig:codeValue
					ccid="${processRecordInfo.prtype }"
					cid="${processRecordInfo.prstatus}" /> 
				</logic:notEqual>		
				
				<ig:ProcessStatusWarningImgTag 
	                        processType="${processRecordInfo.prtype}" prid = "${processRecordInfo.prid}" prStatus = "${processRecordInfo.prstatus}" 
	                        prStrategyVersion="${processRecordInfo.prstrategyversion}" prPdid="${processRecordInfo.prpdid}" prUrgency="${processRecordInfo.prurgency}"/>
			</td>
		</tr>
        <tr>
          <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
     	</tr>
     	 <logic:equal name="index" value="9">
     	 	<tr>
             <td colspan="9">
             <a href="IGCOM0202.do?linkID=IGSVC0111&actname=ACT02SVC0102"><img src="images/main_more.gif" border="0" class="more_img"/></a>
          &nbsp;</td>
     	</tr>
     	 </logic:equal>
	</logic:iterate>
	</logic:present>
		
	</table>
 </div>
	<div id="discontinue" style="display:none">
	<table width="670" border="0" cellspacing="0" cellpadding="0" style="margin-left:26px">
	<tr align="left" height="28">
<!--          <th width="20"></th>-->
<!--          <th width="20"></th>-->
          <!-- <th width="20"></th> -->
          <th width="100" align="left">编号</th>
          <th width="155" align="left">名称</th>
          <th width="75" align="left">类型</th>
          <th width="105" align="left"><span><a href="javascript:showDiscontinueListAsc();">开始时间<img src="images/timedown.gif" border="0"/></a></span></th>
          <th width="80" align="left">处理角色</th>
          <th width="75" align="left">处理人</th>
          <th width="105" align="left">状态</th>
	</tr>
		<logic:present name="IGCOM01031VO" property="processInHandDiscontinueDesc">
		<logic:iterate id="processRecordInfo" name="IGCOM01031VO" indexId="index" length="7" property="processInHandDiscontinueDesc" type="com.deliverik.infogovernor.com.model.ProcessInHandVWInfo">
		<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${processRecordInfo.prid }"/>" class="my_work" onmouseover="mouseOver(this);"  height="27" onmouseout="mouseOut(this,'my_work');"  onclick="doLook('${processRecordInfo.showurl }${processRecordInfo.prid }&prstatus=${processRecordInfo.prstatus}&flag=1&jump=77');">
<!--			<td valign="middle">-->
<!--				<ig:ProcessInfoValueLevelImgTag pdname="${processRecordInfo.prpdname}"  prid="${processRecordInfo.prid}" /> -->
<!--			</td>-->
<!--			<td valign="middle">-->
<!--				<ig:ProcessOverdueLevelImgTag prstatus="${processRecordInfo.prstatus}" prid="${processRecordInfo.prid}" />-->
<!--			</td>-->
			<!-- <td>
			<logic:equal name="processRecordInfo" property="showtype" value="1">	
				<img src="images/${processRecordInfo.prurgency}.gif" alt="紧急程度：<ig:codeValue ccid='${processRecordInfo.prtype}URGENCY_GRADE_CODE' cid="${processRecordInfo.prurgency}"/>" width="10" height="16" />
			</logic:equal>
			<logic:equal name="processRecordInfo" property="showtype" value="2">
				<c:if test="${processRecordInfo.prurgency != null and processRecordInfo.prurgency > ' '}">
					<img src="images/${processRecordInfo.prurgency}.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE" cid="${processRecordInfo.prurgency}"/>" width="10" height="16" />
				</c:if>
			</logic:equal>
			</td> -->
    		<td>${processRecordInfo.prserialnum}</td>
    		<td>
	    		<span title="${processRecordInfo.prtitle}">${processRecordInfo.showtitle}</span>
			</td>
    		<td style="text-align: left"><span title="${processRecordInfo.prpdname }">${processRecordInfo.showpdname }</span></td>
    		<td>${processRecordInfo.propentime}</td>
    		<td onmouseover="searchprocessJC('${processRecordInfo.prid}','jcd${index}');" id="jcd${index}">${processRecordInfo.showrolename}</td>
    	
			<td>
			<logic:empty name="processRecordInfo" property="ppusername"><img src="images/noimplementor.gif" width="16" height="16" alt="无执行人"/></logic:empty>
			<logic:notEmpty name="processRecordInfo" property="ppusername">${processRecordInfo.ppusername}</logic:notEmpty>
			</td>
		
    		<td>
	    		<logic:equal name="processRecordInfo" property="showtype" value="2">	
					<ig:processDefineTypeValue prid="${processRecordInfo.prid}"/>  
				</logic:equal>
	    		<logic:notEqual name="processRecordInfo" property="showtype" value="2">	
	    		<ig:codeValue
					ccid="${processRecordInfo.prtype }"
					cid="${processRecordInfo.prstatus}" /> 
				</logic:notEqual>		
				
				<ig:ProcessStatusWarningImgTag 
	                        processType="${processRecordInfo.prtype}" prid = "${processRecordInfo.prid}" prStatus = "${processRecordInfo.prstatus}" 
	                        prStrategyVersion="${processRecordInfo.prstrategyversion}" prPdid="${processRecordInfo.prpdid}" prUrgency="${processRecordInfo.prurgency}"/>
			</td>
		</tr>
        <tr>
          <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
     	</tr>
     	 <logic:equal name="index" value="9">
     	 	<tr>
	           <td colspan="9">
             <a href="IGCOM0202.do?linkID=IGSVC0111&actname=ACT02SVC0102"><img src="images/main_more.gif" border="0" class="more_img"/></a>
         	 &nbsp;</td>
	   		</tr>
     	 </logic:equal>
	</logic:iterate>
	</logic:present>
	   	
	</table>
	</div>
     </div>
    </div>
    
    <div class="new_current" id="newKnowledge">
      <div class="new_wtitle">
	
			<div>
        	    <h1 style="float:left; font-size:12px; font-weight:bold; color:#006BC6; padding-left:5px; line-height:22px;"><img src="images/fengxianjianchaqingkuang.gif" style="vertical-align: middle;"/>&nbsp;告警</h1>
        	  	<div id="hqAlertGroup" style="float:right; padding-right:20px; line-height:22px;">
	        	    <font style="font-family:Arial, Helvetica, sans-serif">业务系统&nbsp;|&nbsp;
	        	    	<a href="javascript:switchShowAlert('2')" style="color: #006BC6">Oracle活动</a>
	        	    </font>
        	    </div>
        	  	<div id="bussinessGroup" style="float:right; padding-right:20px; line-height:22px; display: none">
	        	    <font style="font-family:Arial, Helvetica, sans-serif">
	        	    <a href="javascript:switchShowAlert('1')" style="color: #006BC6">业务系统</a>&nbsp;|&nbsp;
	        	    	Oracle活动
	        	    </font>
        	    </div>
			</div>

      </div>
      <div class="new_ccont">
<!--       	<div id="container" style="width: 680px; height: 205px; margin: 15px auto"></div> -->
      	<div id="hqAlertDesc"  style=" height: 205px; overflow: auto;">
            <table width="670" border="0" cellspacing="0" cellpadding="0" style="margin-left:26px;overflow: auto;">
				<tr align="left" height="28">
	                <th width="30"></th>
					<th width="105" style="text-align:left;">告警触发时间</th>
					<th width="105" style="text-align:left;">告警IP</th>
					<th width="165" style="text-align:left;">业务系统</th>
					<th width="190" style="text-align:left;">告警触发原因</th>
					<th width="75" style="text-align:left;">当前值</th>
				</tr>
				<logic:present name="IGCOM01031VO" property="hqAlertListDetailVWList" >
	<logic:iterate id="hqAlert" name="IGCOM01031VO" indexId="index" property="hqAlertListDetailVWList" type="com.deliverik.plugin.alert.hq.model.HQAlertListDetailVWInfo">
<%-- 		<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${hqAlert.prid }"/>" class="my_work" onmouseover="mouseOver(this);"  height="27" onmouseout="mouseOut(this,'my_work');"  onclick="doLook('${hqAlert.showurl }${hqAlert.prid }&jump=77');"> --%>
		<tr class="<ig:rowcss index="${index}"/>">
			<td><img src="images/plugin/hq${hqAlert.priority}.png" align="middle" style="cursor: pointer;" alt="<bean:message bundle="mtmResources" key="label.IGMTM0101.ALARM" /><ig:codeValue ccid='ALARM_PRIORITY' cid='${hqAlert.priority}'/>" /></td>
			<td style="text-align:left;">${hqAlert.tranToTime }</td>
			<td style="text-align:left;">${hqAlert.ip}</td>
			<td style="text-align:left;">${hqAlert.bname}</td>
			<td style="text-align:left;">${hqAlert.defName}</td>
			<td style="text-align:left;">${hqAlert.value}</td>
		</tr>
        <tr>
          <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
     	</tr>
	</logic:iterate>
 		</logic:present>
    </table>
    </div>
      	<div id="bussinessAlertDesc"  style=" height: 205px; overflow: auto; display: none">
            <table width="670" border="0" cellspacing="0" cellpadding="0" style="margin-left:26px;overflow: auto;">
				<tr align="left" height="28">
					<th width="105" style="text-align:left;">告警触发时间</th>
					<th width="105" style="text-align:left;">告警实例</th>
					<th width="100" style="text-align:left;">告警类型</th>
					<th width="135" style="text-align:left;">告警来源</th>
					<th width="190" style="text-align:left;">告警触发原因</th>
					<th width="75" style="text-align:left;">当前值</th>
				</tr>
				<logic:present name="IGCOM01031VO" property="lst_CRM06Info" >
	<logic:iterate id="oracleAlert" name="IGCOM01031VO" indexId="index" property="lst_CRM06Info" type="com.deliverik.infogovernor.soc.alarm.model.CRM06Info">
<%-- 		<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${oracleAlert.prid }"/>" class="my_work" onmouseover="mouseOver(this);"  height="27" onmouseout="mouseOut(this,'my_work');"  onclick="doLook('${oracleAlert.showurl }${oracleAlert.prid }&jump=77');"> --%>
		<tr class="<ig:rowcss index="${index}"/>">
			<td style="text-align:left;">${oracleAlert.tranToTime }</td>
			<td style="text-align:left;">${oracleAlert.hqservername}</td>
			<td style="text-align:left;">${oracleAlert.servertype}</td>
			<td style="text-align:left;">${oracleAlert.host}</td>
			<td style="text-align:left;"><div class="texthidden" title="${oracleAlert.createmessage}" style="cursor: hand">${oracleAlert.createmessage}</div></td>
			<td style="text-align:left;">${oracleAlert.ip2}</td>
		</tr>
        <tr>
          <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
     	</tr>
	</logic:iterate>
 		</logic:present>
    </table>
    </div>
      </div>

    </div>
    </div>
  <div class="new_right" >
    <div class="mesg" > 
      <div class="right_til"><span class="bluetitle"><img src="images/tongzhi.gif" style="vertical-align: middle;"/>&nbsp;通知</span></div>
      
      <div class="mesg_cont">
			<logic:present name="IGCOM01031VO" property="noticeList">
				<bean:size id="listSize" name="IGCOM01031VO" property="noticeList" />
	            <logic:greaterEqual name="listSize" value="5">
	             <a href='javascript:goToNoticeInfo()'><img src="images/main_more.gif" border="0" class="more_img"/></a>
				</logic:greaterEqual>
			</logic:present>
			<ul>
			<logic:present name="IGCOM01031VO" property="noticeList">
				<logic:iterate id="notice" name="IGCOM01031VO" indexId="index" property="noticeList">
					<li><a href='javascript:goToNoticeInfoDetail(${index })'>${notice}</a>
				</li>
				</logic:iterate>
			</logic:present>
			<logic:notPresent name="IGCOM01031VO" property="noticeList">
			<li>目前没有通知！</li>
			</logic:notPresent>
			
			</ul>
      </div>
    </div>
    
    

    <div class="plan"> 
      <div class="plan_til"><span class="bluetitle"><img src="images/baobiao.gif" style="vertical-align: middle;"/>&nbsp;我的报表</span></div>
      <div class="plan_cont">
		<div class="service">
			<img src="images/color.png" />
			<span>
				<ig:menuAuth actname="ACT02SVC1112">
					<html:link action="/IGCOM0202.do?linkID=IGSVC0637&actname=ACT02SVC1112">
						部门服务Top5
					</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT02SVC1112" permission="false">
					<a href="###">部门服务Top5</a>
				</ig:menuAuth>
			</span>
		</div>
		<div class="service">
			<img src="images/chart.png" />
			<span>
				<ig:menuAuth actname="ACT02SVC1104">
					<html:link action="/IGCOM0202.do?linkID=IGSVC0608&type=user&actname=ACT02SVC1104">
						人员工作报告
					</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT02SVC1104" permission="false">
					<a href="###">人员工作报告</a>
				</ig:menuAuth>
			</span>
		</div>
		<div class="service">
			<img src="images/color.png" />
			<span>
				<ig:menuAuth actname="ACT02SVC1115">
					<html:link action="/IGCOM0202.do?linkID=IGSVC0640&actname=ACT02SVC1115">
						年度工作趋势
					</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT02SVC1115" permission="false">
					<a href="###">年度工作趋势</a>
				</ig:menuAuth>
			</span>
		</div>
		<div class="service">
			<img src="images/chart.png" />
			<span>
				<ig:menuAuth actname="ACT02SVC1103">
					<html:link action="/IGCOM0202.do?linkID=IGSVC0606&type=001&actname=ACT02SVC1103">
						设备运行报告
					</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT02SVC1103" permission="false">
					<a href="###">设备运行报告</a>
				</ig:menuAuth>
			</span>
		</div>
		<div class="service">
			<img src="images/color.png" />
			<span>
				<ig:menuAuth actname="ACT02SVC1114">
					<html:link action="/IGCOM0202.do?linkID=IGSVC0641&actname=ACT02SVC1114">
						部门服务年度趋势
					</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT02SVC0114" permission="false">
					<a href="###">部门服务年度趋势</a>
				</ig:menuAuth>
			</span>
		</div>
		<div class="service">
			<img src="images/chart.png" />
			<span>
				<ig:menuAuth actname="ACT02SVC1110">
					<html:link action="/IGCOM0202.do?linkID=IGSVC0635&actname=ACT02SVC1110">
						故障类型统计
					</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT02SVC1110" permission="false">
					<a href="###">故障类型统计</a>
				</ig:menuAuth>
			</span>
		</div>
		<div class="service">
			<img src="images/color.png" />
			<span>
				<ig:menuAuth actname="ACT03SVC1116">
					<html:link action="/IGCOM0202.do?linkID=IGSVC0639&actname=ACT03SVC1116">
						工作量排名
					</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT03SVC1116" permission="false">
					<a href="###">工作量排名</a>
				</ig:menuAuth>
			</span>
		</div>
		<div class="service">
			<img src="images/chart.png" />
			<span>
				<ig:menuAuth actname="ACT02SVC1111">
					<html:link action="/IGCOM0202.do?linkID=IGSVC0636&actname=ACT02SVC1111">
						部门服务统计
					</html:link>
				</ig:menuAuth>
				<ig:menuAuth actname="ACT02SVC1111" permission="false">
					<a href="###">部门服务统计</a>
				</ig:menuAuth>
			</span>
		</div>
      </div>
    </div>
        <div class="manage1"> 
      <div class="manage_til1"><span class="bluetitle"><img src="images/zhenggailv.gif" style="vertical-align: middle;"/>&nbsp;业务系统可用性</span></div>
      <div class="manage_cont1">
       <div id="container1" style="width: 280px; height: 218px; margin: 0px auto; overflow: auto;">
       		<ul style="list-style:none; margin-left: 20px">
       		<logic:present name="IGCOM01031VO" property="lst_BussinessAvailval">
       		<logic:iterate id="bussinessAvailval" name="IGCOM01031VO" indexId="index" property="lst_BussinessAvailval" type="com.deliverik.infogovernor.dbm.model.BussinessAvailval">
		        <li><span class="ball_${bussinessAvailval.availval}"></span>&nbsp;&nbsp;&nbsp;&nbsp;${bussinessAvailval.gname}</li>
			</logic:iterate>
			</logic:present>
		    </ul>
       </div>
      </div>
    </div>
    
  </div>
</div>
</div> 
<script type="text/javascript">
	jQuery("#tbTemp tr").each(function(i,t){
		if(i>0){
			if(i%2==0){
				jQuery(t).addClass("trBg");
			}
			jQuery(t).children("td:first-child").css({"text-align":"left","padding-left":"40px"});
		}
	});
</script>
</body>
</html:html>

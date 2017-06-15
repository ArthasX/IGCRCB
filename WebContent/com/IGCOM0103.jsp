<%@page import="com.deliverik.infogovernor.vo.IGCOM01031VO"%>
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
<style>
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
.ellips{
width:100%; 
white-space:nowrap; 
text-overflow:ellipsis; 
overflow:hidden;
}
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
function showCopyListAsc(){
	document.getElementById('persion').style.display='none';
	document.getElementById('group').style.display='none';
	document.getElementById('discontinue').style.display='none';
	document.getElementById('discontinuegrpup').style.display='none';
}
function showCopyList(){
	document.getElementById('persion').style.display='none';
	document.getElementById('group').style.display='none';
	document.getElementById('discontinue').style.display='none';
	document.getElementById('discontinuegrpup').style.display='none';
}
function switchShowJob(str){
	if(str == 1){
		document.getElementById('persion').style.display='';
		document.getElementById('group').style.display='none';
		document.getElementById('discontinue').style.display='none';
		document.getElementById('discontinuegrpup').style.display='none';
		document.getElementById('showJobPersion').style.display='';
		document.getElementById('showJobGrpup').style.display='none';
		document.getElementById('showJobDiscontinue').style.display='none';
		document.getElementById('showJobDiscontinueGrpup').style.display='none';
	}else if(str==2){
		document.getElementById('persion').style.display='none';
		document.getElementById('group').style.display='';
		document.getElementById('discontinue').style.display='none';
		document.getElementById('discontinuegrpup').style.display='none';
		document.getElementById('showJobPersion').style.display='none';
		document.getElementById('showJobGrpup').style.display='';
		document.getElementById('showJobDiscontinue').style.display='none';
		document.getElementById('showJobDiscontinueGrpup').style.display='none';
	}else if(str==3){
		document.getElementById('persion').style.display='none';
		document.getElementById('group').style.display='none';
		document.getElementById('discontinue').style.display='';
		document.getElementById('discontinuegrpup').style.display='none';
		document.getElementById('showJobPersion').style.display='none';
		document.getElementById('showJobGrpup').style.display='none';
		document.getElementById('showJobDiscontinue').style.display='';
		document.getElementById('showJobDiscontinueGrpup').style.display='none';
	}else if(str==4){
		document.getElementById('persion').style.display='none';
		document.getElementById('group').style.display='none';
		document.getElementById('discontinue').style.display='none';
		document.getElementById('discontinuegrpup').style.display='none';
		document.getElementById('showJobPersion').style.display='none';
		document.getElementById('showJobGrpup').style.display='none';
		document.getElementById('showJobDiscontinue').style.display='none';
		document.getElementById('showJobDiscontinueGrpup').style.display='none';
		
	}else if(str==5){
		document.getElementById('persion').style.display='none';
		document.getElementById('group').style.display='none';
		document.getElementById('discontinue').style.display='none';
		document.getElementById('discontinuegrpup').style.display='none';
		document.getElementById('showJobPersion').style.display='none';
		document.getElementById('showJobGrpup').style.display='none';
		document.getElementById('showJobDiscontinue').style.display='none';
		document.getElementById('showJobDiscontinueGrpup').style.display='none';
	}else if(str==6){
		document.getElementById('persion').style.display='none';
		document.getElementById('group').style.display='none';
		document.getElementById('discontinue').style.display='none';
		document.getElementById('discontinuegrpup').style.display='';
		document.getElementById('showJobPersion').style.display='none';
		document.getElementById('showJobGrpup').style.display='none';
		document.getElementById('showJobDiscontinue').style.display='none';
		document.getElementById('showJobDiscontinueGrpup').style.display='';
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

function switchShowKnowledge(str){

	if(str == 1){
		document.getElementById('newKnowledge').style.display='';
		document.getElementById('approveKnowledge').style.display='none';
	}else{
		document.getElementById('newKnowledge').style.display='none';
		document.getElementById('approveKnowledge').style.display='';
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
	//定时刷新
	setTimeout("switchIndex()", 300000);
	
	function openProcess(pdid,ptid){
		var pdiddel = pdid.substring(0,5);
		window.location.href = "<%=request.getContextPath()%>/IGPRR0101_Disp.do?psdcode=<%=IGPRDCONSTANTS.PROCESS_START_STATUS%>&pdid="+pdiddel+"&ptid="+ptid;
	}
	function openRiskCheck(){
		window.location.href = "<%=request.getContextPath()%>/IGCOM0202.do?linkID=IGRIS0203&actname=ACT04RIS0301";
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
	margin-top: 1px;
	display: block;
}
.quick li a {
font-size: 12px;
color: #555;
text-align: center;
}
</style>
<body onload="initPlay();">
<div id="maincontent">
<jsp:include page="/include/header2.jsp" />
 <div class="new_content">
  <div class="new_left">
   <div class="ql">
      <ul class="quick" data-collapse="collapse">
        <li> 
        	<ig:menuAuth actname="ACT02SVC0202">
        		<html:link action="/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01080&ptid=8&actname=ACT02SVC0202">
        			<img src="image/ywpic_01.jpg" alt="" style="height:44px; width:44px;"/><span>事件发起</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT02SVC0202" permission="false">
				<a href="###"><img src="image/ywpic_011.jpg" alt="" style="height: 44px;width: 44px"/><span>事件发起</span></a>
			</ig:menuAuth>
        </li>
        <li>
        	<ig:menuAuth actname="ACT02SVC0201">
        		<html:link action="/IGCOM0202.do?linkID=IGCRC0208&prtype=WD&prpdid=01080&actname=ACT02SVC0201">
        			<img src="image/ywpic_02.jpg" alt=""style="height: 44px;width: 44px"/><span>事件查询</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT02SVC0201" permission="false">
				<a href="###"><img src="image/ywpic_021.jpg" alt="" style="height: 44px;width: 44px"/><span>事件查询</span></a>
			</ig:menuAuth>
        </li>
        <li>
        	<ig:menuAuth actname="ACT02SVC0302">
        		<html:link action="/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01083&ptid=8&actname=ACT02SVC0302">
        			<img src="image/ywpic_03.jpg" alt="" style="height: 44px;width: 44px"/><span>问题发起</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT02SVC0302" permission="false">
				<a href="###"><img src="image/ywpic_031.jpg" alt="" style="height: 44px;width: 44px"/><span>问题发起</span></a>
			</ig:menuAuth>
        </li>
        <li>
        	<ig:menuAuth actname="ACT02SVC0301">
        		<html:link action="/IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01083&actname=ACT02SVC0301">
        			<img src="image/ywpic_04.jpg" alt="" style="height: 44px;width: 44px"/><span>问题查询</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT02SVC0301" permission="false">
				<a href="###"><img src="image/ywpic_041.jpg" alt="" style="height: 44px;width: 44px"/><span>问题查询</span></a>
			</ig:menuAuth>
        </li>
        <li>
        	<ig:menuAuth actname="ACT02SVC0402">
        		<html:link action="/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01084&ptid=8&actname=ACT02SVC0402">
        			<img src="image/ywpic_05.jpg" alt="" style="height: 44px;width: 44px"/><span>变更发起</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT02SVC0402" permission="false">
				<a href="###"><img src="image/ywpic_051.jpg" alt="" style="height: 44px;width: 44px"/><span>变更发起</span></a>
			</ig:menuAuth>
        </li>
        <li>
        	<ig:menuAuth actname="ACT02SVC0401">
        		<html:link action="/IGCOM0202.do?linkID=IGCRC1401&actname=ACT02SVC0401">
        			<img src="image/ywpic_06.jpg" alt="" style="height: 44px;width: 44px"/><span>变更查询</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT02SVC0401" permission="false">
				<a href="###"><img src="image/ywpic_061.jpg" alt="" style="height: 44px;width: 44px"/><span>变更查询</span></a>
			</ig:menuAuth>
        </li>
        <li>
        	<ig:menuAuth actname="ACT02SVC0602">
        		<html:link action="/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01100&ptid=8&actname=ACT02SVC0602">
        			<img src="image/ywpic_07.gif" alt="" style="height: 44px;width: 44px"/><span>请求发起</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT02SVC0602" permission="false">
				<a href="###"><img src="image/ywpic_071.jpg" alt="" style="height: 44px;width: 44px"/><span>请求发起</span></a>
			</ig:menuAuth>
        </li>
        <li>
        	<ig:menuAuth actname="ACT02SVC0601">
        		<html:link action="/IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01100&actname=ACT02SVC0601">
        			<img src="image/ywpic_08.jpg" alt="" style="height: 44px;width: 44px"/><span>请求查询</span>
        		</html:link>
        	</ig:menuAuth>
        	<ig:menuAuth actname="ACT02SVC0601" permission="false">
				<a href="###"><img src="image/ywpic_081.jpg" alt="" style="height: 44px;width: 44px"/><span>请求查询</span></a>
			</ig:menuAuth>
        </li>
      </ul>
      <div style="clear:both;"></div>
    </div>
    <div class="new_working">
      <div class="new_wtitle">
      
      		<!-- 个人工作Tab标题 Begin -->
     		<div id="showJobPersion" >
        	    <h1 style="float:left; font-size:12px; color:#FFFFFF; padding-left:15px; line-height:22px;">&nbsp;&nbsp;&nbsp;&nbsp;处理中工作</h1>
        	    <div style="float:left; padding-left:150px; line-height:22px;">
	        	    <font style="font-family:Arial, Helvetica, sans-serif">个人工作&nbsp;|&nbsp;
	        	    <a href="javascript:switchShowJob('2')" style="text-decoration: none;color: #b90216">相关工作</a>
	        	    &nbsp;|&nbsp;
	        	     <a href="javascript:switchShowJob('3')" style="text-decoration: none;color: #b90216">个人检查工作</a>
	        	      &nbsp;|&nbsp;
	        	     <a href="javascript:switchShowJob('6')" style="text-decoration: none;color: #b90216">相关检查工作</a>
	        	    </font>
        	    </div>
        	    <div style="float:right; width:50px;line-height:22px;">
	        	    <font style="font-family:Arial, Helvetica, sans-serif">
	        	    	<a href="/InfoGovernor/IGCOM0202.do?linkID=IGSVC0101&actname=ACT02SVC0101" style="text-decoration: none;color: #b90216;">
	        	    	更多>>
	        	    	</a>
	        	    </font>
        	    </div>
			</div>
			<!-- 个人工作Tab标题 End -->
			
			<!-- 相关工作Tab标题 Begin -->
			<div id="showJobGrpup" style="display:none">
				<h1 style="float:left; font-size:12px; color:#FFFFFF; padding-left:15px; line-height:22px;">&nbsp;&nbsp;&nbsp;&nbsp;处理中工作</h1>
				<div style="float:left; padding-left:150px; line-height:22px;">
					<font style="font-family:Arial, Helvetica, sans-serif">
					<a href="javascript:switchShowJob('1')" style="text-decoration: none;color: #b90216">个人工作</a>
					&nbsp;|&nbsp;相关工作
					&nbsp;|&nbsp;
					<a href="javascript:switchShowJob('3')" style="text-decoration: none;color: #b90216">个人检查工作</a>
					&nbsp;|&nbsp;
					<a href="javascript:switchShowJob('6')" style="text-decoration: none;color: #b90216">相关检查工作</a>
					</font>
				</div>
				<div style="float:right; width:50px;line-height:22px;">
	        	    <font style="font-family:Arial, Helvetica, sans-serif">
	        	    	<a href="/InfoGovernor/IGCOM0202.do?linkID=IGSVC0102&actname=ACT02SVC0102" style="text-decoration: none;color: #b90216;">
	        	    	更多>>
	        	    	</a>
	        	    </font>
        	    </div>
			</div>
			<!-- 相关工作Tab标题 End -->
			
			<!-- 个人检查工作Tab标题 Begin -->
			<div id="showJobDiscontinue" style="display:none">
				<h1 style="float:left; font-size:12px; color:#FFFFFF; padding-left:15px; line-height:22px;">&nbsp;&nbsp;&nbsp;&nbsp;处理中工作</h1>
				<div style="float:left; padding-left:150px; line-height:22px;">
					<font style="font-family:Arial, Helvetica, sans-serif">
					<a href="javascript:switchShowJob('1')" style="text-decoration: none;color: #b90216">个人工作</a>
					&nbsp;|&nbsp;
					<a href="javascript:switchShowJob('2')" style="text-decoration: none;color: #b90216">相关工作</a>
					&nbsp;|&nbsp;个人检查工作 
					&nbsp;|&nbsp;
					<a href="javascript:switchShowJob('6')" style="text-decoration: none;color: #b90216">相关检查工作</a>
					</font>
				</div>
				<div style="float:right; width:50px;line-height:22px;">
	        	    <font style="font-family:Arial, Helvetica, sans-serif">
	        	    	<a href="###" style="text-decoration: none;color: #b90216;">
	        	    	更多>>
	        	    	</a>
	        	    </font>
        	    </div>
			</div>
			<!-- 个人检查工作Tab标题 End -->
			
			<!-- 相关检查工作Tab标题 Begin -->
			<div id="showJobDiscontinueGrpup" style="display:none">
				<h1 style="float:left; font-size:12px; color:#FFFFFF; padding-left:15px; line-height:22px;">&nbsp;&nbsp;&nbsp;&nbsp;处理中工作</h1>
				<div style="float:left; padding-left:150px; line-height:22px;">
					<font style="font-family:Arial, Helvetica, sans-serif">
					<a href="javascript:switchShowJob('1')" style="text-decoration: none;color: #b90216">个人工作</a>
					&nbsp;|&nbsp;
					<a href="javascript:switchShowJob('2')" style="text-decoration: none;color: #b90216">相关工作</a>
					&nbsp;|&nbsp;
					<a href="javascript:switchShowJob('3')" style="text-decoration: none;color: #b90216">个人检查工作</a>
					&nbsp;|&nbsp;相关检查工作 
					</font>
				</div>
				<div style="float:right; width:50px;line-height:22px;">
	        	    <font style="font-family:Arial, Helvetica, sans-serif">
	        	    	<a href="###" style="text-decoration: none;color: #b90216;">
	        	    	更多>>
	        	    	</a>
	        	    </font>
        	    </div>
			</div>
			<!-- 相关检查工作Tab标题 End -->
			<div id="supervisereport" style="display:none">
				<h1 style="float:left; font-size:12px; color:#FFFFFF; padding-left:15px; line-height:22px;">&nbsp;&nbsp;&nbsp;&nbsp;处理中工作</h1>
				<div style="float:left; padding-left:150px; line-height:22px;">
					<font style="font-family:Arial, Helvetica, sans-serif">
					<a href="javascript:switchShowJob('1')" style="text-decoration: none;color: #b90216">个人工作</a>
					&nbsp;|&nbsp;
					<a href="javascript:switchShowJob('2')" style="text-decoration: none;color: #b90216">相关工作</a>
					</font>
				</div>
				<div style="float:right; width:50px;line-height:22px;">
	        	    <font style="font-family:Arial, Helvetica, sans-serif">
	        	    	<a href="###" style="text-decoration: none;color: #b90216;">
	        	    	更多>>
	        	    	</a>
	        	    </font>
        	    </div>
			</div>
      </div>
      <div class="new_wcont">
    <div id="persion" style="margin-top:5px;">
            <table width="670px" border="0" cellspacing="0" cellpadding="0" style="margin-left:15px;">
				<tr align="left" height="28" style=" background-color: #eeeeee;width: 670px">
				  <th width="25px" align="left"></th>
		          <th width="90px" align="left"><span style="color: #b90216">编号</span></th>
		          <th width="145px" align="left"><span style="color: #b90216">名称</span></th>
		          <th width="75px" align="left"><span style="color: #b90216">类型</span></th>
		          <th width="105px" align="left"><span style="color: #b90216">开始时间</span></th>
		          <th width="80px" align="left"><span style="color: #b90216">处理角色</span></th>
		          <th width="70px" align="left"><span style="color: #b90216">处理人</span></th>
		          <th width="80px" align="left"><span style="color: #b90216">状态</span></th>
				</tr>
	<logic:iterate id="processRecordInfo" name="IGCOM01031VO" indexId="index" length="6" property="processInHandDesc" type="com.deliverik.infogovernor.com.model.ProcessInHandVWInfo">
		<c:if test="${processRecordInfo.prtype != 'WDP'}">
			<tr style='cursor:hand' class="my_work" onmouseover="mouseOver(this);"  height="27" onmouseout="mouseOut(this,'my_work');"  onclick="doLook('${processRecordInfo.showurl }${processRecordInfo.prid }&jump=77');">
				<td width="25px"><!-- 这里先判断是否为变更然后自定义标签再查是否为紧急变更 --> 
					<c:if test="${processRecordInfo.prpdname =='变更'}">
						<bean:define id="changeType"><ig:publicProcessInfoValue pidname="变更类别" prid="${processRecordInfo.prid}"/></bean:define>		
						<c:if test="${changeType == '紧急变更'}">
							<img src="images/flag_red.gif" alt="紧急变更" border="0" align="middle"/>
						</c:if>
					</c:if>
				</td>
	    		<td title="${processRecordInfo.prserialnum}" width="90px"><div style="width:90; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.prserialnum}</div></td>
	    		<td title="${processRecordInfo.showtitle}" width="145px">
		    		<span ><div style="width:145px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.showtitle}</div></span>
				</td>
	    		<td style="text-align: left" title="${processRecordInfo.showpdname}" width="75px"><span ><div style="width:75px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.showpdname }</div></span></td>
	    		<td title="${processRecordInfo.propentime}" width="105px"><div style="width:105px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.propentime}</div></td>
	    		<td onmouseover="searchprocessJC('${processRecordInfo.prid}','jcb${index}');" id="jcb${index}" title="${processRecordInfo.showrolename}" width="80px"><div style="width:80px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.showrolename}</div></td>
				<td title="${processRecordInfo.ppusername}" width="70px"><div style="width:70px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.ppusername}</div></td>
			
	    		<td title="<ig:processDefineTypeValue prid="${processRecordInfo.prid}"/>" width="80px">
					<div style="width:80px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;"><ig:processDefineTypeValue prid="${processRecordInfo.prid}"/></div>
				</td>
			</tr>
		</c:if>
		<c:if test="${processRecordInfo.prtype == 'WDP'}">
			<tr style='cursor:hand' class="my_work" onmouseover="mouseOver(this);"  height="27" onmouseout="mouseOut(this,'my_work');"  onclick="showConsole('${processRecordInfo.prid }');">
				<td width="25px"><!-- 这里先判断是否为变更然后自定义标签再查是否为紧急变更 --> 
					<c:if test="${processRecordInfo.prpdname =='变更'}">
						<bean:define id="changeType"><ig:publicProcessInfoValue pidname="变更类别" prid="${processRecordInfo.prid}"/></bean:define>		
						<c:if test="${changeType == '紧急变更'}">
							<img src="images/flag_red.gif" alt="紧急变更" border="0" align="middle"/>
						</c:if>
					</c:if>
				</td>
	    		<td title="${processRecordInfo.prserialnum}" width="90px"><div style="width:90; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.prserialnum}</div></td>
	    		<td title="${processRecordInfo.showtitle}" width="145px">
		    		<span ><div style="width:145px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.showtitle}</div></span>
				</td>
	    		<td style="text-align: left" title="${processRecordInfo.showpdname}" width="75px"><span ><div style="width:75px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.showpdname }</div></span></td>
	    		<td title="${processRecordInfo.propentime}" width="105px"><div style="width:105px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.propentime}</div></td>
	    		<td onmouseover="searchprocessJC('${processRecordInfo.prid}','jcb${index}');" id="jcb${index}" title="${processRecordInfo.showrolename}" width="80px"><div style="width:80px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.showrolename}</div></td>
				<td title="${processRecordInfo.ppusername}" width="70px"><div style="width:70px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.ppusername}</div></td>
			
	    		<td title="<ig:processDefineTypeValue prid="${processRecordInfo.prid}"/>" width="80px">
					<div style="width:80px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;"><ig:processDefineTypeValue prid="${processRecordInfo.prid}"/></div>
				</td>
			</tr>
		</c:if>
		
        <tr>
          <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
     	</tr>
     	<logic:equal name="index" value="5">
     		<tr>
           <td colspan="9">
             <a href="IGCOM0202.do?linkID=IGSVC0101&actname=ACT02SVC0101"><img src="images/main_more.gif" border="0" class="more_img"/></a>
          &nbsp;</td>
     	</tr>
     	</logic:equal>
	</logic:iterate>
 		
		</table>
	</div>
	<div id="group" style="display:none;margin-top:5px">
            <table width="670px" border="0" cellspacing="0" cellpadding="0" style="margin-left:15px;">
				<tr align="left" height="28" style=" background-color: #eeeeee;width: 670px">
				  <th width="25px" align="left"></th>
		          <th width="90px" align="left"><span style="color: #b90216">编号</span></th>
		          <th width="145px" align="left"><span style="color: #b90216">名称</span></th>
		          <th width="75px" align="left"><span style="color: #b90216">类型</span></th>
		          <th width="105px" align="left"><span style="color: #b90216">开始时间</span></th>
		          <th width="80px" align="left"><span style="color: #b90216">处理角色</span></th>
		          <th width="70px" align="left"><span style="color: #b90216">处理人</span></th>
		          <th width="80px" align="left"><span style="color: #b90216">状态</span></th>
				</tr>
		<logic:iterate id="processRecordInfo" name="IGCOM01031VO" indexId="index" length="6" property="processInHandGroupDesc" type="com.deliverik.infogovernor.com.model.ProcessInHandVWInfo">
		<tr style='cursor:hand' class="my_work" onmouseover="mouseOver(this);"  height="27" onmouseout="mouseOut(this,'my_work');"  onclick="doLook('${processRecordInfo.showurl }${processRecordInfo.prid }&jump=77');">
			<td width="25px"></td>
    		<td width="90px" title="${processRecordInfo.prserialnum}"><div style="width:80px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.prserialnum}</div></td>
    		<td width="145px" title="${processRecordInfo.prtitle}">
	    		<span ><div style="width:145px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.showtitle}</div></span>
			</td>
    		<td style="text-align: left" title="${processRecordInfo.prpdname }" width="80px"><span ><div style="width:80px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.showpdname }</div></span></td>
    		<td width="70px" title="${processRecordInfo.propentime}"><div style="width:80px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.propentime}</div></td>
    		<td onmouseover="searchprocessJC('${processRecordInfo.prid}','jcd${index}');" id="jcd${index}" width="70px" title="${processRecordInfo.showrolename}"><div style="width:70px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${processRecordInfo.showrolename}</div></td>
			<td>
				<logic:empty name="processRecordInfo" property="ppusername">
				未指定
				</logic:empty>
				<logic:notEmpty name="processRecordInfo" property="ppusername">
				${processRecordInfo.ppusername }
				</logic:notEmpty>
			</td>
		
    		<td title="<ig:processDefineTypeValue prid="${processRecordInfo.prid}"/>" width="80px">
				 <div style="width:80px; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">
					 <ig:processDefineTypeValue prid="${processRecordInfo.prid}"/>
				 </div>
			</td>
		</tr>
        <tr>
          <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
     	</tr>
     	<logic:equal name="index" value="5">
     			<tr>
	           <td colspan="9">
             <a href="IGCOM0202.do?linkID=IGSVC0102&actname=ACT02SVC0102"><img src="images/main_more.gif" border="0" class="more_img"/></a>
          &nbsp;</td>
	   	</tr>
     	</logic:equal>
	</logic:iterate>
	   
	</table>
	</div>
 	
 	<!-- 个人检查工作 倒序查询结果 Begin -->
	<div id="discontinue" style="display:none;margin-top:5px">
		<table width="670" border="0" cellspacing="0" cellpadding="0" style="margin-left:15px;">
			<tr align="left" height="28" style=" background-color: #eeeeee;width: 670px">
	          <th width="70" align="left"><span style="color: #b90216">超时</span></th>
	          <th width="155" align="left"><span style="color: #b90216">检查项名称</span></th>
	          <th width="115" align="left"><span style="color: #b90216">计划检查时间</span></th>
	          <th width="85" align="left"><span style="color: #b90216">责任组</span></th>
	          <th width="80" align="left"><span style="color: #b90216">责任人</span></th>
	          <th width="85" align="left"><span style="color: #b90216">合作组</span></th>
	          <th width="105" align="left"><span style="color: #b90216">合作人</span></th>
			</tr>
			<logic:present name="IGCOM01031VO" property="lst_RiskCheckResult_Desc">
			<logic:iterate id="riskCheckResult" name="IGCOM01031VO" indexId="index" length="6" property="lst_RiskCheckResult_Desc" type="com.deliverik.infogovernor.risk.model.RiskCheckResult">
			<tr style='cursor:hand' class="my_work" onmouseover="mouseOver(this);"  height="27" onmouseout="mouseOut(this,'my_work');"  onclick="openRiskCheck();">
	    		<td>
	    		<c:if test="${IGCOM01031VO.riskChecktime > riskCheckResult.riskCheck.rcenddate}">
	    			<img src='images/cs1.png' align='middle' style='cursor:pointer;'  border='0' id='cs' />
	    		</c:if>
	    		</td>
	    		<td>
		    		<span title="${riskCheckResult.riskCheck.rcdesc}">
						${riskCheckResult.riskCheck.rcname}
					</span>
				</td>
	    		<td style="text-align: left">${riskCheckResult.rcrplandate}</td>
	    		<td>${riskCheckResult.riskCheck.rcrolename}</td>
	    		<td>${riskCheckResult.riskCheck.rcusername}</td>
				<td>${riskCheckResult.riskCheck.cog}</td>
	    		<td>${riskCheckResult.riskCheck.ciiop}</td>
			</tr>
	        <tr>
	          <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
	     	</tr>
     	 	<logic:equal name="index" value="5">
     	 	<tr>
	           <td colspan="9">
             <a href="IGCOM0202.do?linkID=IGRIS0203&actname=ACT04RIS0301"><img src="images/main_more.gif" border="0" class="more_img"/></a>
         	 &nbsp;</td>
	   		</tr>
     	 	</logic:equal>
			</logic:iterate>
			</logic:present>
	   	
	</table>
	</div>
	<!-- 个人检查工作 倒序查询结果 End -->
 	
 	<!-- 相关检查工作 倒序查询结果 Begin -->
	<div id="discontinuegrpup" style="display:none;margin-top:5px">
		<table width="670" border="0" cellspacing="0" cellpadding="0" style="margin-left:15px;">
			<tr align="left" height="28" style=" background-color: #eeeeee;width: 670px">
	          <th width="70" align="left"><span style="color: #b90216">超时</span></th>
	          <th width="155" align="left"><span style="color: #b90216">检查项名称</span></th>
	          <th width="115" align="left"><span style="color: #b90216">计划检查时间</span></th>
	          <th width="85" align="left"><span style="color: #b90216">责任组</span></th>
	          <th width="80" align="left"><span style="color: #b90216">责任人</span></th>
	          <th width="85" align="left"><span style="color: #b90216">合作组</span></th>
	          <th width="105" align="left"><span style="color: #b90216">合作人</span></th>
			</tr>
			<logic:present name="IGCOM01031VO" property="lst_RiskCheckResultGroup_Desc">
			<logic:iterate id="riskCheckResult" name="IGCOM01031VO" indexId="index" length="6" property="lst_RiskCheckResultGroup_Desc" type="com.deliverik.infogovernor.risk.model.RiskCheckResult">
			<tr style='cursor:hand' class="my_work" onmouseover="mouseOver(this);"  height="27" onmouseout="mouseOut(this,'my_work');"  onclick="openRiskCheck();">
	    		<td>
	    		<c:if test="${IGCOM01031VO.riskChecktime > riskCheckResult.riskCheck.rcenddate}">
	    			<img src='images/cs1.png' align='middle' style='cursor:pointer;'  border='0' id='cs' />
	    		</c:if>
	    		</td>
	    		<td>
		    		<span title="${riskCheckResult.riskCheck.rcdesc}">
						${riskCheckResult.riskCheck.rcname}
					</span>
				</td>
	    		<td style="text-align: left">${riskCheckResult.rcrplandate}</td>
	    		<td>${riskCheckResult.riskCheck.rcrolename}</td>
	    		<td>${riskCheckResult.riskCheck.rcusername}</td>
				<td>${riskCheckResult.riskCheck.cog}</td>
	    		<td>${riskCheckResult.riskCheck.ciiop}</td>
			</tr>
	        <tr>
	          <td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
	     	</tr>
     	 	<logic:equal name="index" value="5">
     	 	<tr>
	           <td colspan="9">
             <a href="IGCOM0202.do?linkID=IGRIS0203&actname=ACT04RIS0301"><img src="images/main_more.gif" border="0" class="more_img"/></a>
         	 &nbsp;</td>
	   		</tr>
     	 	</logic:equal>
			</logic:iterate>
			</logic:present>
	   	
	</table>
	</div>
	<!-- 相关检查工作 倒序查询结果 End -->
	
     </div>
    </div>
    
    
    <div class="new_current" id="approveKnowledge" style="">
      <div class="new_wtitle">
      <h1 style="float:left; font-size:12px; color:#FFFFFF; padding-left:15px; line-height:22px;">&nbsp;&nbsp;&nbsp;&nbsp;最新知识</h1>
      			<logic:equal value="IGKG02" name="roleType">
				</logic:equal>
				<logic:present name="IGCOM01031VO" property="knvoList">
				<bean:size id="listSize" name="IGCOM01031VO" property="appKnList" />
				<c:if test="${listSize>5}">
				<div style="float:right; padding-left:50px; line-height:22px;">
				<a href="IGCOM0202.do?linkID=IGKGM0205&actname=ACT02SVC1304" style="text-decoration: none;cursor: pointer;">
					<font style="font-family:Arial, Helvetica, sans-serif;color: #b90216; font-size: 12px">
	        	    	更多>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</font>
				</a>
				</div>
				</c:if>
				</logic:present>
      </div>

      <div class="new_ccont">
			<table width="675" border="0" cellspacing="0" cellpadding="0" style="margin-left: 13px;">
				<tr align="left" height="28" style="background-color: #eeeeee;">
					<th width="2%"></th>
					<th width="10%"><span style="color: #b90216">编号</span></th>
					<th width="35%"><span style="color: #b90216">标题</span></th>
					<th width="15%"><span style="color: #b90216">分类</span></th>
					<th width="15%"><span style="color: #b90216">贡献人</span></th>
					<th width="13%"><span style="color: #b90216">归档日期</span></th>
				</tr>
        		<logic:present name="IGCOM01031VO" property="knvoList">
					<logic:iterate id="bean" name="IGCOM01031VO" property="knvoList" indexId="index">
					<tr class="my_work" onmouseover="mouseOver(this);" height="27" style="cursor: hand;"
						onmouseout="mouseOut(this,'my_work');"  onclick="doLook('IGKGM0214_LCHECK.do?knid=${bean.knid}&knversion=${bean.knversion}');">
			            <td></td>
			            <td>${bean.knserial}</td>
						<td>${bean.title}</td>
						<td>${bean.knclassname}</td>
						<td>${bean.knproffername}</td>
						<td>${bean.time}</td>
					</tr>
					<!-- <tr>
						<td colspan="9"><img src="images/td_line_bg.gif" border="0" height="1" /></td>
					</tr> -->
				</logic:iterate>
	 			<tr>
	            	<td colspan="5">
		            	<bean:size id="listSize" name="IGCOM01031VO" property="appKnList" />
							<logic:greaterEqual name="listSize" value="5">
								 <a href="IGKGM0208.do"><img src="images/main_more.gif" border="0" class="more_img"/></a>
							</logic:greaterEqual>&nbsp;
					</td>
	     		</tr>
			</logic:present>
			</table>
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
      <div class="plan_til"><img src="images/2.gif" style="vertical-align: middle;padding-left: 5px"/><span class="bluetitle">日常工作计划</span></div>
      
      <div class="plan_cont">
		 <form id="submitForm" method="post">
					
			<table width="244" border="0" align="center" cellpadding="0" cellspacing="0" style="margin-top: 10px;">
			<tr>
				<td>
				<table width="90" border="0" cellspacing="0" cellpadding="0"
					align="center">
					<tr>
						<td width="15"><a href="#"
							onclick="back(${IGCOM01031VO.backyear},${IGCOM01031VO.backmonth});"><img
							src="images/8.gif" alt="上月" border="0" /></a></td>
						<td width="60" align="center">${IGCOM01031VO.year}年${IGCOM01031VO.month}月</td>
						<td width="15"><a href="#"
							onclick="next(${IGCOM01031VO.afteryear},${IGCOM01031VO.aftermonth});"><img
							src="images/9.gif" alt="下月" border="0" /></a></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td>
				<table width="280" border="0" cellpadding="0" cellspacing="1"
					class="change_date" style="margin-top: 5px;">
					<tr>
						<th>日</th>
						<th>一</th>
						<th>二</th>
						<th>三</th>
						<th>四</th>
						<th>五</th>
						<th>六</th>
					</tr>
					${IGCOM01031VO.dayplans }
					
					
				</table>
				</td>
			</tr>
		</table>
		</form>
      </div>
    </div>
      

      <div class="manage1"> 
      <div class="manage_til1"><span class="bluetitle"><img src="images/000222.gif" style="vertical-align: middle;"/>&nbsp;我的服务台</span></div>
      <div class="manage_cont1" >
				<div class="service"><img src="images/2.gif" /><span><html:link
					action="/IGCOM0202.do?linkID=IGSVC0101&actname=ACT02SVC0101">我的工作</html:link></span></div>

				<div class="service"><img src="images/4.gif" /><span><html:link
					action="/IGCOM0202.do?linkID=IGSVC0103&actname=ACT02SVC0103">我的发起</html:link></span></div>
					
				<div class="service"><img src="images/a1.gif" /><span><html:link
					action="/IGCOM0202.do?linkID=IGSVC0102&actname=ACT02SVC0102">相关工作</html:link></span></div>

				<div class="service"><img src="images/d1.gif" /><span><html:link
					action="/IGCOM0202.do?linkID=IGSVC0110&actname=ACT02SVC0114">历史工作</html:link></span></div>
			<ig:menuAuth actname="ACT02SVC0115">
				<div class="service"><img src="images/c1.gif" /><span><html:link
					action="/IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01380&type=3&actname=ACT02SVC0115">工单查询</html:link></span></div>
			</ig:menuAuth> 
			<ig:menuAuth actname="ACT02SVC0116">
				<div class="service"><img src="images/01_09.gif" /><span><html:link
					action="/IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01380&ptid=8&actname=ACT02SVC0116">服务工单</html:link></span></div>
			</ig:menuAuth>
      </div>
    </div>
    
  </div>
</div>
</div> 
</body>
<script type="text/javascript">

/**
 * @Description：如果是演练处置流程，弹出工作台页面
 * @Date：2017年5月16日13:48:38
 * @Author wangliang@deliverik.com
 */
function showConsole(prid){
	window.open('IGDRM1010.do?prid='+prid, '应急工作台', 'width=1024, height=768, scrollbars=yes, status=no, top=0, left=0').focus();
	//阻止事件冒泡
// 	(window.event)&&(window.event.cancelBubble=true); 
}
</script>
</html:html>

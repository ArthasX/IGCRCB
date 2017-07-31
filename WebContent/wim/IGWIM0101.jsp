<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.risk.model.RiskCheck"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>
<%
	String contextPath = request.getContextPath();
%>
<html:html>
<bean:define id="id" value="IGWIM0101" toScope="request" />
<bean:define id="title" value="工作项定义页面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>

<style type="text/css">
FIELDSET DIV {
    clear: left;
    margin-bottom: 2px;
    margin-top: 2px;
    margin-left: 0px;
}

.clearLabel{
	float: none;
    width: auto;
    text-align: center;
    margin: 0px;
    background-color: white;
    padding-top: 4px;
    padding-right: 2px;
    padding-bottom: 2px;
    padding-left: 4px;
}


.test1,.test3{border-collapse:separate;border-spacing:10px 20px;}
.test2{border-collapse:collapse;border-spacing:10px 20px;}

</style>
<!-- /header1 -->
<%
RiskCheck rc = (RiskCheck)request.getAttribute("riskcheck");
String onceChecked="";
String dayChecked = "";
String weekChecked = "";
String monthChecked = "";
String quarterChecked = "";
//增加频率 每半年，每年
String halfyearChecked = "";
String yearChecked = "";
String day = null;
String rcrtestmode="0";
if(rc!=null){
	rcrtestmode=rc.getRcrtestmode();
	String cron = rc.getRccron();
	if(cron!=null){
		String hour = cron.split(" ")[2];
		int qjhour = Integer.valueOf(hour);
		String minute = cron.split(" ")[1];
		int qjminute = Integer.valueOf(minute);
		
		if(cron.contains("/")){
			quarterChecked = "checked=\"checked\"";
			day = cron.split("/")[1].split(" ")[0];
		}else{
			day = cron.split(" ")[3];
		}

		if(!"?".equals(day) && "*".equals(day)){
			dayChecked = "checked=\"checked\"";
		}else if("?".equals(day)){
			weekChecked = "checked=\"checked\"";
		}else {
			if("".equals(quarterChecked)){
				//每半年，每年频率 根据 IGRIS02BLImpl 136 行
				String month =  cron.split(" ")[4];
				if(month.contains("*"))
				{
					monthChecked = "checked=\"checked\"";
				}
				else if(month.contains(","))
				{
					halfyearChecked = "checked=\"checked\"";
				}
				else if(rc.getRcfrequency().equals("once")){
					onceChecked="checked=\"checked\"";
				}
				else 
				{
					yearChecked = "checked=\"checked\"";
				}
				
			}
		}
	}else{
		dayChecked = "checked=\"checked\"";
		
	}
}else{
	dayChecked = "checked=\"checked\"";
}

%>

<script type="text/javascript">	
var gid='IGWIM0101';
	
	function confirmDisp(){
		var message = '';
		if ('${IGWIM0101Form.mode}' == '0'){
			message = '请确认是否要进行工作项登记处理？';
		} else {
			message = '请确认是否要进行工作项修改处理？';
		}
		if(document.forms[0].wdname.value.trim()==""){
			alert("请输入工作项名称！");
			return false;
		} 
		if(document.forms[0].wdname.value.strlen()>128){
			alert("工作项名称不能大于42个汉字！");
			return false;
		} 
// 		if(document.forms[0].wdstatus.value.trim()==""){
// 			alert("请选择启用状态！");
// 			return false;
// 		} 
		if(document.forms[0].beginDate.value.trim()==""){
			alert("请选择开始日期！");
			return false;
		}
		if(document.forms[0].estimateFinishDate.value.trim()==""){
			alert("请选择预计完成时间！");
			return false;
		}
		if(jQuery("#everyQuarter").attr("checked")==true || jQuery("#everyHalfyear").attr("checked")==true || jQuery("#everyYear").attr("checked")==true){
			
			if(document.forms[0].beginDate.value > document.forms[0].estimateFinishDate.value){
				alert("预计完成时间不能早于开始时间，请重新选择！");
				return false;
			}
		}else{
			var beginDate = jQuery("#beginDate").val().substring(0,10);	//获取开始日期（yyyy/MM/dd）
			beginDate += " "+jQuery("#wdhour").val()+":"+jQuery("#wdminute").val();
			if(beginDate > document.forms[0].estimateFinishDate.value){
				alert("预计完成时间不能早于开始时间，请重新选择！");
				return false;
			}
			
		}
// 		if(document.forms[0].actualFinishDate.value.trim()==""){
// 			alert("请选择实际完成时间！");
// 			return false;
// 		}
		if(document.forms[0].leaderId.value.trim()=="" || document.forms[0].leaderId.value.trim()=='undefined'){
			alert("请选择负责人！");
			return false;
		}
		if(document.forms[0].overtimeStopDealTime.value.trim()==""){
			alert("请输入超时停止处理时间！");
			return false;
		}else{
			//校验超时提醒输入范围必须是正整数
			var reg = /^[0-9]*[1-9][0-9]*$/;
			if(!reg.test(document.forms[0].overtimeStopDealTime.value.trim())){
				alert("请输入有效的时间（天数）！");
				return false;
			}
		}
		if((document.forms[0].excutorId.value.trim()=="" || document.forms[0].excutorId.value.trim()=='undefined')
				&& document.forms[0].excutorName.value.trim()=="" || document.forms[0].excutorName.value.trim()=='undefined'){
			alert("请选择执行人！");
			return false;
		}
		if(document.forms[0].overtimeTipsTime.value.trim()==""){
			alert("请输入超时提醒时间！");
			return false;
		}else{
			//校验超时提醒输入范围必须是正整数
			var reg = /^[0-9]*[1-9][0-9]*$/;
			if(!reg.test(document.forms[0].overtimeTipsTime.value.trim())){
				alert("请输入有效的时间（天数）！");
				return false;
			}
		}
		if(document.forms[0].description.value.strlen()>4000){
			alert("工作项描述不能大于1000个汉字！");
			return false;
		}
		//频率
		var count=document.forms[0].cycle.length;
		for(var i=0;i<count;i++) 
		{
			if(document.forms[0].cycle[i].checked){
				var radio = document.forms[0].cycle[i].value; 
			}
		}
		//频率周
		if(radio=="week"){
			var count=document.forms[0].wdweek.length; 
			var j=0; 
			for(var i=0;i<count;i++) 
			{ 
			if (document.forms[0].wdweek[i].checked) 
			++j; 
			} 
			if(j==0){
				alert("请选择每周频率内容！"); 
				return false;
			}
		}
		//频率月
		if(radio=="month"){
			var count=document.forms[0].wdmonth.length;
			var j=0; 
			var x=0;
			for(var i=0;i<count;i++) 
			{ 
			if (document.forms[0].wdmonth[i].checked) 
			++j; 
			}
			if (document.forms[0].monthLastDay.checked){ 
			++x; 
			}
			if(j==0 && x==0){
				alert("请选择每月频率内容！"); 
				return false;
			}
			if(j!=0 && x!=0){
				alert("不能同时选择月份天数及每月最后一天，请重新选择！");
				return false;
			}
		}
		
		//Quartz触发是否有效标识：false→有效，true→无效
		var isInvalid = false;
		
		//校验工作项定义的Quartz触发时间是否合法
		isInvalid = checkQuartzIslegitimate(isInvalid);
		
		if(!isInvalid){
			if(window.confirm(message)){
				//处理执行人最后一个、
				if(jQuery("#excutorId").val().substring(jQuery("#excutorId").val().length-1,1)=='、'){
					jQuery("#excutorId").val(jQuery("#excutorId").val().substring(0,jQuery("#excutorId").val().length-1));
				}
				if(jQuery("#excutorName").val().substring(jQuery("#excutorName").val().length-1,1)=='、'){
					jQuery("#excutorName").val(jQuery("#excutorName").val().substring(0,jQuery("#excutorName").val().length-1));
				}
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}
		
	}
	
	//校验工作项定义的Quartz触发时间是否合法
	function checkQuartzIslegitimate(isInvalid){
		
		//定义系统当前时间
		var currentTime = "";
		//Ajax请求取得服务器时间
	    var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ asynchronous:false,parameters: 'type=servertime',
			 onSuccess:  function(req, json){
			 	result = req.responseText;
			 	currentTime=result;
		     }
		});
		
		//获取预计完成时间
		var estimateFinishDate = jQuery("#estimateFinishDate").val();
		
		//定义循环查找次数标识
		var loopNum = 0;
		
		//获取开始日期（yyyy/MM/dd hh:ss）
		var beginTime = jQuery("#beginDate").val();
		
		//若周期为日、月或周
		var startTime = jQuery("#beginDate").val().substring(0,10);	//获取开始日期（yyyy/MM/dd）
		//拼接开始日期和时间表单，拼接后格式为（yyyy/MM/dd hh:mm）
		if(startTime){
			startTime += " "+jQuery("#wdhour").val()+":"+jQuery("#wdminute").val();
		}
		
		//<<<<<根据周期的几种情况比较服务器时间和开始日期（开始日期不能早于服务器时间）>>>>>
		if(jQuery("#everyQuarter").attr("checked")==true || jQuery("#everyHalfyear").attr("checked")==true || jQuery("#everyYear").attr("checked")==true){
			
			//若周期为季度、半年或年
			if(jQuery("#beginDate").val()<=currentTime){
				isInvalid = true;
				alert("开始日期应该晚于系统日期！");
				return isInvalid;
			}
			
			if(jQuery("#everyQuarter").attr("checked")==true){
				
				//周期为季度
				loopNum = 92;
				
			}else if(jQuery("#everyHalfyear").attr("checked")==true){
				
				//周期为半年
				loopNum = 183;
				
			}else if(jQuery("#everyYear").attr("checked")==true){
				
				//周期为年
				loopNum = 366;
			}
			
			//2017年7月12日和FXy确认的逻辑为保证Quartz至少能执行一次为基准的验证，季度、半年、年则无需校验
			//<<<<<结束循环校验>>>>>
			
		}else{
			
			if(startTime <= currentTime){
				isInvalid = true;
				alert("开始日期应该晚于系统日期！");
				return isInvalid;
			}
			
			if(jQuery("#everyDay").attr("checked")==true){
				
				//周期为日。不需要循环查找，因为以每天为周期，只要验证开始日期大于系统日期和预计完成日期小于开始日期通过即可。
				
			}else if(jQuery("#everyWeek").attr("checked")==true){
				
				//周期为周
				loopNum = 7;
				
			}else{
				
				//周期为月
				loopNum = 31;
			}
			
			//取得用户选择的日期号
			var chooseDay = jQuery("input[name='wdmonth'][checked=true]").val();
			if(chooseDay && chooseDay.length < 2){
				//日期（d）如果是一位补零
				chooseDay = "0"+chooseDay;
			}
			//日期最后一天
			var chooseLastday = jQuery("input[name='monthLastDay'][checked=true]").val();
			
			//定义选择的周
			var wdweek = jQuery("input[name='wdweek'][checked=true]").val();
			//定义周转换成0~6的值类型
			var chooseWeek = "";
			
			if(wdweek){
				
				if(wdweek=="MON"){
					
					chooseWeek = 1;
					
				}else if(wdweek=="TUE"){
					
					chooseWeek = 2;
					
				}else if(wdweek=="WED"){
					
					chooseWeek = 3;
					
				}else if(wdweek=="THU"){
					
					chooseWeek = 4;
					
				}else if(wdweek=="FRI"){
					
					chooseWeek = 5;
					
				}else if(wdweek=="SAT"){
					
					chooseWeek = 6;
					
				}else if(wdweek=="SUN"){
					
					chooseWeek = 0;
				}
			}
			
			//计算预计完成日期和开始日期的差值（其中循环条件是差值不能小于1），若小于31天，则需要得到每天的日期（号）与选择的进行对比，没有相等验证未通过；
			//若差值>=31，则一定存在Quartz至少执行一次的规则，通过验证
			
			var startDate = new Date(startTime);	//把开始日期转成日期格式
			
			var estimatedDate = new Date(estimateFinishDate);	//把预计完成日期转成日期格式
			
			var diff = DateDiff(startTime, estimateFinishDate);	//计算两个日期的差（天）
			
			//<<<<<开始循环校验>>>>>
			if(diff > 0){
				//日期差小于31天，根据日期差次数遍历进行一一对比
				if(diff < loopNum){
					
					//定义是否匹配日期的标识（0：否；1：是）；
					var equalFlag = 0;
					
					for (var i = 0; i < diff; i++) {
						
						//比较月最后一天
						if(chooseLastday){
							if(i!=0){
								
								//获取开始日期的下一天和用户选择的日期比较
								if(getNextDay(startTime,i+1).substring(5,7) != startTime.substring(5,7)){
									//如果下一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
									equalFlag = 1;
									break;
								}
							}else{
								//比较第一天
								if(getNextDay(startTime,0).substring(5,7) != startTime.substring(5,7)){
									//如果第一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
									equalFlag = 1;
									break;
								}
								
							}
						}
						
						//比较月
						if(chooseDay){
							//读取1~30天
							if(i!=0){
								
								//获取开始日期的下一天和用户选择的日期比较
								if(getNextDay(startTime,i).substring(8,10) == chooseDay){
									//如果下一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
									equalFlag = 1;
									break;
								}
							}else{
								//比较第一天
								if(startTime.substring(8,10) == chooseDay){
									//如果第一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
									equalFlag = 1;
									break;
								}
								
							}
						}
						
						//比较周
						if(wdweek){
							if(i!=0){
								
								//获取开始日期是星期几
								var whichWeek = new Date(getNextDay(startTime,i)).getDay();
								
								//获取开始日期的下一天和用户选择的日期比较
								if(whichWeek == chooseWeek){
									//如果下一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
									equalFlag = 1;
									break;
								}
							}else{
								
								//获取开始日期是星期几
								var whichWeek = startDate.getDay();
								
								//比较第一天
								if(whichWeek == chooseWeek){
									//如果第一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
									equalFlag = 1;
									break;
								}
								
							}
						}else{
							//比较季度、半年、年
							if(i!=0){
								
								//获取开始日期的下一天和用户选择的日期比较
								if(getNextDay(beginTime,i).substring(8,10) == chooseDay){
									//如果下一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
									equalFlag = 1;
									break;
								}
							}else{
								//比较第一天
								if(beginTime.substring(8,10) == chooseDay){
									//如果第一天的时间（hh:mm）大于等于用户选择的日期（dd）并且下一天的日期（号）匹配到用户选择的日期号，则视为有效，否则无效
									equalFlag = 1;
									break;
								}
								
							}
						}
						
					}
					//循环结束后
					if(equalFlag==0){
						isInvalid = true;
						alert("您选择的日期超出范围，请重新选择！");
						return isInvalid;
					}
				}
			}else{
				//比较用户所选日期（dd）是否和开始日期为同一天，如果不是，则非法
				if(startTime.substring(8,10) != chooseDay){
					isInvalid = true;
					alert("您选择的日期超出范围，请重新选择！");
					return isInvalid;
				}
			}
			//<<<<<结束循环校验>>>>>
			
		}
		

		//<<<<<根据周期的几种情况判断比较服务器时间和开始日期（开始日期不能早于服务器时间）>>>>>
		
		return isInvalid;
	}
	
	//获取日期下一天，返回格式yyyy/MM/dd hh:mm
	//参数d：传入的日期（yyyy/MM/dd hh:ss）
	//参数s：传入的天数跨度，例：s=3，则表示获取d的后3天，传入0默认为只获取下一天
	function getNextDay(d,s){		
		d = new Date(d);		
		if(s>0){
			d = +d + 1000*60*60*24*s;		
		}else{
			d = +d + 1000*60*60*24;		
		}
		d = new Date(d);
		//格式化		
		var month = d.getMonth()+1;
		var date = d.getDate();
		if(month < 10){
			month = "0"+month;
		}
		if(date < 10){
			date = "0"+date;
		}
		var hours = d.getHours();
		var minutes = d.getMinutes();
		if(hours < 10){
			hours = "0"+hours;
		}
		if(minutes < 10){
			minutes = "0"+minutes;
		}
		return d.getFullYear()+"/"+month+"/"+date+" "+hours+":"+minutes;			
	}
	
	//计算两个日期相差的天数
	function DateDiff(sDate1, sDate2) {  
		
		//sDate1和sDate2是yyyy-MM-dd格式

	    var aDate, oDate1, oDate2, iDays;

	    aDate = sDate1.split("/");

	    oDate1 = new Date(aDate[1] + '/' + aDate[2] + '/' + aDate[0]);  //转换为yyyy/MM/dd格式

	    aDate = sDate2.split("/");

	    oDate2 = new Date(aDate[1] + '/' + aDate[2] + '/' + aDate[0]);

// 	    iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24); //把相差的毫秒数转换为天数
	    iDays = Math.ceil(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24); //把相差的毫秒向上取转换为天数

	    return iDays;  //返回相差天数
	}


	function toQuency(quency){
		var page = document.getElementById("page");
		if(quency == 'week' || quency == 'month'){
			 document.getElementById("page").style.display='';
			 var divArray = page.getElementsByTagName("div");
			 for (var i=0;i<divArray.length;i++) {
			  if (divArray[i].id == quency) {
			   divArray[i].style.display='';
			  }else {
			   divArray[i].style.display='none';
			  }
			 }
			 if(quency == 'month'){
				 document.getElementById("month1").style.display='';
			}else{
				 document.getElementById("month1").style.display='none';
			}
		}else{
			document.getElementById("page").style.display='none';
			document.getElementById("month1").style.display='none';
		}
		if(quency == 'quarter' || quency == 'halfyear' || quency == 'year'){
			document.getElementById("time").style.display='none';
			jQuery("#beginDate").next("img").removeAttr('onclick');
 			jQuery("#beginDate").next("img").click(function (){
 				showTime(document.forms[0].beginDate);
 			});		
		}else{
			jQuery("#time").show();
			jQuery("#beginDate").next("img").removeAttr('onclick');
 			jQuery("#beginDate").next("img").click(function (){
	 				showDate(document.forms[0].beginDate);
 			});
		}
	}
	
	jQuery(document).ready(function(){
		var quency = jQuery("input[name='cycle']:checked").val();
		toQuency(quency);
	});
	
	
	//设置负责人
	function searchFzr(){
		openSubWindow('/IGSYM1905_Open.do', '_blank','1000','600','center:1');
	}
	//负责人回显
    function setIGCYB0101Params(username,orgname,orgid,useremail,userphone,usermobile,userid){
    	document.getElementById("leaderName").value = username;
		document.getElementById("leaderId").value = userid;
	}
    
    var tempId = "";	//定义tempId变量
  	var tempName = "";	//定义tempName变量
  	
  	//页面加载方法
    jQuery(document).ready(function(){
    	
    	//测试tzCheckBox专用（预留）：jQuery("input[name='wdweek'][checked=true]").val();
    	
    	//设置文本框的宽度
    	jQuery("input[type='text']").width(200);
    	
 		//设置tzCheckBox只能单选
		jQuery(".tzCheckBox").click(function(){
			jQuery(".tzCheckBox").removeClass("checked").prev().attr("checked",false);
		});
 		
 		//根据周期判断时间元素是否选中，决定开始日期的选取范围
 		if(jQuery("#everyQuarter").checked || jQuery("#everyHalfyear").checked || jQuery("#everyYear").checked){
 			jQuery("#beginDate").next("img").removeAttr('onclick');
 			jQuery("#beginDate").next("img").click(function (){
 				showTime(document.forms[0].beginDate);
 			});
	 		jQuery("#time").hide();
 		}else{
			jQuery("#beginDate").next("img").removeAttr('onclick');
 			jQuery("#beginDate").next("img").click(function (){
	 				showDate(document.forms[0].beginDate);
 			});
	 		jQuery("#time").show();
 			
 		}
 		
 		//如果是修改，设置radio默认选中
 		var modifyFlag = jQuery("#mode").val();
 		//mode=1为修改；否则为新增
 		if(modifyFlag=="1"){
 			
 			//获取周期
 			var cycle = jQuery("#cycyleHide").val();
 			//获取周
 			var week = jQuery("#weekHide").val();
 			//获取月份
 			var month = jQuery("#monthHide").val();
 			//获取是否最后一月
 			var lastMonth = jQuery("#lastMonthHide").val();
 			//设置周期默认选中
 			jQuery("input[name='cycle'][value='"+cycle+"']").attr("checked",true);
 			if(cycle=='week'){
 				
 				toQuency('week');
 				//设置周默认值选中
 				jQuery("input[weekCk=1][value='"+week+"']").attr("checked",true);
 				//设置选中样式
 				jQuery("input[weekCk=1][value='"+week+"']").next().removeClass().addClass("tzCheckBox checked");
 				
 			}else if(cycle=='month'){
 				
				toQuency('month');
 				if(lastMonth=="Y"){
 					//设置是否月最后一天选中？？？
 					jQuery("input[name='monthLastDay']").next().click();
 				}else{
 					//设置月份对应的日期选中
 					jQuery("input[monthCk=1][value='"+month+"']").attr("checked",true);
 					jQuery("input[monthCk=1][value='"+month+"']").next().removeClass().addClass("tzCheckBox checked");
 				}
 			}
 			//设置时
 			jQuery("#wdhour").val(jQuery("#hour").val());
 			//设置分
 			jQuery("#wdminute").val(jQuery("#minutes").val());
//  			//设置启用状态
//  			if(jQuery("#status").val()!='' && jQuery("#status").val()!='0'){
//  				jQuery("#wdstatus").val(1);
//  			}else{
//  				jQuery("#wdstatus").val(0);
//  			}
 			
 			//显示执行人
 			var userid = jQuery("#excutorId").val();	//获取userid
 			var username = jQuery("#excutorName").val();	//获取username
 			//给变量赋值
 			tempId = userid;
 			tempName = username;
 			//拆分字符串
 			var ids = userid.split("、");	
 	  		var names = username.split("、");
 	  		if(userid.length>0){
 		  		for(var i = 0;i<ids.length;i++){
 		  			jQuery("#zxrArea").append("<a href='javascript:;' uid='"+ids[i]+"' style='cursor:text;text-decoration:none'>"+names[i]+"</a>"
 		  							+"<img src='images/wim/redDel.jpg' width='10' height='10' onclick='removeUser(this)'/>");
 		  			
 		  		}
 	  		}
 		}
    });
    
  	//选择执行人
	function addUser(){
		openSubWindow('/IGZWJ0101_Open.do', '_blank', '800', '600');
	}
    
  	//回调函数
  	function setIGZWJ0103Params(userid,username){
  		
  		//获取用户id
  		var ids = userid.split("、");
  		//获取用户名
  		var names = username.split("、");
  		
  		//执行人列表是否已存在的用户标识
  		var isExits = false;
  		
  		if(ids.length>0){
	  		//校验所选值是否已存在
	  		for(var i = 0;i<ids.length;i++){
		  		if(jQuery("#excutorId").val().indexOf(ids[i])>-1){
		  			alert("执行人列表中已存在用户名为“"+names[i]+"”的用户，请重新选择！");
		  			isExits = true;
		  			return;
		  		}
	  		}
	  		
	  		if(!isExits){
	  			//循环追加
		  		for(var i = 0;i<ids.length;i++){
		  			jQuery("#zxrArea").append("<a href='javascript:;' uid='"+ids[i]+"' style='cursor:text;text-decoration:none'>"+names[i]+"</a>"
		  							+"<img src='images/wim/redDel.jpg' width='10' height='10' onclick='removeUser(this)'/>");
		  			
		  		}
	  		}
  		}
  		
  		//设置userid的值
  		if(tempId!='' && jQuery("#excutorId").val().substring(jQuery("#excutorId").val().length-1,1)!='、'){
  			tempId += "、"+userid;
  		}else{
	  		tempId += userid;
  		}
  		jQuery("#excutorId").val(tempId);
  		
  		//设置username的值
  		if(tempName!='' && jQuery("#excutorName").val().substring(jQuery("#excutorName").val().length-1,1)!='、'){
	  		tempName += "、"+username;
  		}else{
	  		tempName += username;
  		}
  		jQuery("#excutorName").val(tempName);
  	}
  	
  	//移除执行人
  	function removeUser(obj){
  		
//   		<!--操作用户id-->
  		//获取用户id
  		var userid = jQuery(obj).prev("a").attr("uid");
  		//获取执行人userid隐藏域的值
  		var hideId = jQuery("#excutorId").val();
  		
  		if(hideId.indexOf(userid+'、')>-1){
  			//若userid隐藏域中的值包含userid、则将其替换成空
	  		hideId = hideId.replace(userid+"、","");
	  		tempId = tempId.replace(userid+"、","");
	  		
  		}else{
  			//若userid隐藏域中的值包含userid则将其替换成空
	  		hideId = hideId.replace(userid,"");
	  		tempId = tempId.replace(userid,"");
  		}
  		//对userid隐藏域重新赋值
  		jQuery("#excutorId").val(hideId);
  		
//   		<!--操作用户名-->
  		//获取用户名
  		var username = jQuery(obj).prev("a").text();
  		//获取执行人username隐藏域的值
  		var hideName = jQuery("#excutorName").val();
  		
  		if(hideName.indexOf(username+'、')>-1){
  			//若username隐藏域中的值包含username、则将其替换成空
	  		hideName = hideName.replace(username+"、","");
	  		tempName = tempName.replace(username+"、","");
  		}else{
  			//若username隐藏域中的值包含username则将其替换成空
	  		hideName = hideName.replace(username,"");
	  		tempName = tempName.replace(username,"");
  		}
  		//对hideName隐藏域重新赋值
  		jQuery("#excutorName").val(hideName);
		
  		//移除红叉和红叉前一个用户名
  		jQuery(obj).prev("a").remove();
  		jQuery(obj).remove();
  	}
//-->
</script>
<link rel="stylesheet" href="<html:rewrite forward='jquery.tzCheckbox.css'/>" type="text/css">
<body>
<script src="<html:rewrite forward='jquery.min.js'/>"></script>
<script>
var jQ = jQuery.noConflict(true);//jquery与prototype冲突
</script>
<script src="<html:rewrite forward='jquery.tzCheckbox.js'/>"></script>
<script src="<html:rewrite forward='jquery.script.js'/>"></script>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> 
<!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location" style="cursor: text;">
                <div class="image"></div>
                <p class="fonts1">
                	流程管理 &gt;&gt; 工作管理 &gt;&gt;
                	<logic:equal name="IGWIM0101Form" property="mode" value="0"> 
                		工作项定义
                	</logic:equal>
                	<logic:equal name="IGWIM0101Form" property="mode" value="1"> 
                		工作项修改
                	</logic:equal>
                </p>
                <logic:equal name="IGWIM0101Form" property="mode" value="1">
					<div class="back"><a href="IGWIM0102_Back.do" target="_self">返回</a></div>
				</logic:equal>
            </div>
            
		    <div id="formwrapper">
				<html:form styleId="form" action="/IGWIM0101" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
					    <logic:equal name="IGWIM0101Form" property="mode" value="0">
							<legend>新增工作项信息</legend>
						</logic:equal> 
						<logic:equal name="IGWIM0101Form" property="mode" value="1">
							<legend>修改工作项信息</legend>
						</logic:equal>
	                   
				<logic:equal name="IGWIM0101Form"  property="mode" value="0">
					<!-- 新增 -->
					 <table  width="860px" style="margin-left:60px;margin-top:20px;" cellspacing="8">
			            	<tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>发起人：</strong></td>
				            	<td align="left" width="254px"> 
				            		<html:text property="initiatorId" tabindex="1" readonly="true" value="${IGWIM0101Form.initiatorName }"/>
				            	</td>
				            	<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
			            		<td align="right" width="150px" style="background-color: #EEEEEE;"><span class="red">*</span><strong>工作项名称：</strong></td>
				            	<td align="left" width="254px"> <html:text property="wdname" tabindex="1" maxlength="72"/></td>
				            	<td align="right" width="16px"/>
				            	<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><strong>工作项描述：</strong></td>
				            	<td align="left" width="254px" colspan="6"> 
				            	<html:textarea property="description" rows="3" style="width:635px" cols="88" tabindex="3"/></td>
<!-- 				            	<td align="right" width="16px"/> -->
			            	</tr>
			            	<tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>周期：</strong></td>
				            	<td colspan="5">
				            		<label for="everyDay" class="clearLabel">
										<input name="cycle" type="radio" id="everyDay" value="day" onclick="toQuency(this.value)" <%=dayChecked %> />每日
				            		</label>
				            		<label for="everyWeek" class="clearLabel">
								        <input name="cycle" type="radio" id="everyWeek" value="week" onclick="toQuency(this.value)" <%=weekChecked %> />每周
				            		</label>
				            		<label for="everyMonth" class="clearLabel">
								        <input name="cycle" type="radio" id="everyMonth" value="month" onclick="toQuency(this.value)" <%=monthChecked %> />每月
				            		</label>
				            		<label for="everyQuarter" class="clearLabel">
								        <input name="cycle" type="radio" id="everyQuarter" value="quarter" onclick="toQuency(this.value)" <%=quarterChecked %> />每季度
				            		</label>
				            		<label for="everyHalfyear" class="clearLabel">
								        <input name="cycle" type="radio" id="everyHalfyear" value="halfyear" onclick="toQuency(this.value)" <%=halfyearChecked %> />每半年
				            		</label>
				            		<label for="everyYear" class="clearLabel">
								        <input name="cycle" type="radio" id="everyYear" value="year" onclick="toQuency(this.value)" <%=yearChecked %> />每年
				            		</label>
						    		    	<!-- 隐藏选项 -->
    								<div id="page" style="display:none;height:auto;">
						    		<!-- 每周 -->
						   			<div id="week" style="display:none ">
							    		<logic:present name="IGWIM01011VO" property="weekList">
											<logic:iterate id="bean" name="IGWIM01011VO" property="weekList" indexId="index">
												<c:if test="${bean.ischecked != null }">
													<input type="checkbox" weekCk="1" style="border-color: red;" name="wdweek" id="wdweek" data-on="${bean.weekdata }" data-off="${bean.weekdata }" value="${bean.weekvalue }" checked="checked"/>
												</c:if>
												<c:if test="${bean.ischecked == null }">
													<input type="checkbox" weekCk="1" name="wdweek" id="wdweek" data-on="${bean.weekdata }" data-off="${bean.weekdata }" value="${bean.weekvalue }"/>
												</c:if>
											</logic:iterate>
										</logic:present>
									</div>
									<!-- 每月 -->
									<div id="month" style="display:none; height:auto;">
									<logic:present name="IGWIM01011VO" property="monthList">
										<logic:iterate id="bean" name="IGWIM01011VO" property="monthList" indexId="index">
											<c:if test="${bean.ischecked != null }">
												<input type="checkbox" monthCk="1" name="wdmonth" id="wdmonth" data-on="${bean.dayvalue }" data-off="${bean.dayvalue }" value="${bean.dayvalue }" checked="checked" />
											</c:if>
											<c:if test="${bean.ischecked == null }">
												<input type="checkbox" monthCk="1" name="wdmonth" id="wdmonth" data-on="${bean.dayvalue }" data-off="${bean.dayvalue }" value="${bean.dayvalue }" />
											</c:if>
										</logic:iterate>
									</logic:present>
									</div>
								</div>
								<!-- 月末是否发起检查 -->
								<div id="month1" style="display:none; height:42px;">
									<span style="display:block; float:left;height:42px;vertical-align: middle;">
										请确认每月最后一天是否发起检查：
									</span>
									<span style="display:block; float:left; height:42px; width:42px;">
										<c:if test="${IGWIM0101Form.monthLastDay != null }">
											<input  type="checkbox" name="monthLastDay" monthCk="2" id="monthLastDay" data-on="是" data-off="否" value="Y" checked="checked"/>
										</c:if>
										<c:if test="${IGWIM0101Form.monthLastDay == null }">
											<input type="checkbox" name="monthLastDay" monthCk="2" id="monthLastDay" data-on="是" data-off="否" value="Y"/>
										</c:if>
									</span>	
								</div>
				            	</td>
			            	</tr>
			            	<tr id="time">
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>时间：</strong></td>
				            	<td align="left" width="254px"> 
									<select id="wdhour" name="wdhour">
										<option value="00">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
										<option value="16">16</option>
										<option value="17">17</option>
										<option value="18">18</option>
										<option value="19">19</option>
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
									</select>
									时
									<select id="wdminute" name="wdminute">
										<option value="00">00</option>
										<option value="15">15</option>
										<option value="30">30</option>
										<option value="45">45</option>
									</select>
									分
				            	</td>
				            	<td align="right" width="16px"></td>
				            </tr>	 
				            <tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>启用状态：</strong></td>
				            	<td align="left" width="254px"> 
									<select id="wdstatus" name="wdstatus">
										<option value="0">停用</option>
										<option value="1">启用</option>
									</select>
								</td>
								<td align="right" width="16px"/>
				            	
			            	</tr>
			            	<tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>开始日期：</strong></td>
				            	<td align="left" width="254px"> 
								<html:text property="beginDate" styleId="beginDate" errorStyleClass="inputError imeDisabled" size="20" readonly="true"/>
								<img src="images/date.gif" align="middle" onclick="showDate(document.forms[0].beginDate)" border="0" style="cursor: hand" /> <br />				            	</td>
				            	<td align="right" width="16px"/>
<!-- 				            	<td align="right" width="150px" style="background-color: #EEEEEE; "> -->
<!-- 				            		<strong>实际完成时间：</strong> -->
<!-- 				            	</td> -->
<!-- 				            	<td align="left" width="254px">  -->
<%-- 									<html:text property="actualFinishDate" styleId="actualFinishDate" errorStyleClass="inputError imeDisabled" size="20" disabled="true"/> --%>
<!-- 								</td> -->
								<td align="right" width="160px" style="background-color: #EEEEEE; ">
				            		<span class="red">*</span>
				            		<strong>预计完成时间：</strong>
				            	</td>
				            	<td align="left" width="254px"> 
									<html:text property="estimateFinishDate" value="${IGWIM01011VO.workDefinitionInfo.estimateFinishDate }" styleId="estimateFinishDate" errorStyleClass="inputError imeDisabled" size="20" readonly="true"/>
									<img src="images/date.gif" align="middle" onclick="showTime(document.forms[0].estimateFinishDate)" border="0" style="cursor: hand" /> <br />
								</td>
								<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; ">
				            		<span class="red">*</span><strong>负责人：</strong>
				            	</td>
				            	<td align="left" width="254px"> 
				            		<!--对于中心负责人及以上的岗位，发起人为自己，负责人、执行人可以从现有用户列表中选择，且可以选择多个执行人-->
				            		<c:if test="${IGWIM0101Form.isLeader=='1' }">
							   			<html:text property="leaderName" tabindex="15"  readonly="true"></html:text>
										<input type="hidden" width="0px" name="leaderId" id="leaderId" />
							   			<img src="images/seek.gif" style="cursor: hand;" alt="选择负责人" width="16" height="16" border="0" onclick="searchFzr();"/>								
				            		</c:if>
				            		<!-- 对于普通员工，发起人、负责人、执行人只能是自己。 -->
				            		<c:if test="${IGWIM0101Form.isLeader=='0' }">
										<input type="hidden" width="0px" name="leaderId" id="leaderId" value="${IGWIM0101Form.initiatorId }"/>
							   			<html:text property="leaderName" styleId="leaderName" readonly="true" value="${IGWIM0101Form.initiatorName }"/>
				            		</c:if>
						   		</td>
								<td align="right" width="16px">
								<td align="right" width="150px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>超时停止处理时间：</strong></td>
				            	<td align="left" width="254px"> 
				            	<html:text property="overtimeStopDealTime" styleId="overtimeStopDealTime"/>日
								</td>
			            	</tr>
			            	<tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; ">
				            		<span class="red">*</span><strong>执行人：</strong>
				            	</td>
				            	<td align="left" width="254px"> 
				            		<!--对于中心负责人及以上的岗位，发起人为自己，负责人、执行人可以从现有用户列表中选择，且可以选择多个执行人-->
				            		<c:if test="${IGWIM0101Form.isLeader=='1' }">
					            		<span id="zxrArea">
					            		</span>
					            		<br/>
										<html:hidden property="excutorName" styleId="excutorName"></html:hidden>
										<html:hidden property="excutorId" styleId="excutorId"></html:hidden>
							   			<img src="images/seek.gif" style="cursor: hand;" alt="选择执行人" width="16" height="16" border="0" onclick="addUser();"/>
				            		</c:if>
				            		<!-- 对于普通员工，发起人、负责人、执行人只能是自己。 -->
				            		<c:if test="${IGWIM0101Form.isLeader=='0' }">
										<html:hidden property="excutorId" styleId="excutorId" value="${IGWIM0101Form.initiatorId }"/>
				            			<html:text property="excutorName" styleId="excutorName" readonly="true" tabindex="15" value="${IGWIM0101Form.initiatorName }"/>
				            		</c:if>
								</td>
				            	<td align="right" width="16px"/>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>超时提醒时间：</strong></td>
				            	<td align="left" width="254px"> 
				            	<html:text property="overtimeTipsTime" tabindex="1"/>日
								</td>
								<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><strong>备注：</strong></td>
				            	<td align="left" width="254px" colspan="6"> 
				            		<html:textarea property="remarks" style="width:635px" rows="3" cols="88" tabindex="13" />
								</td>
			            	</tr>
			            </table>
				</logic:equal>
			
				<logic:equal name="IGWIM0101Form"  property="mode" value="1">
					<!-- 修改 -->
					 <table  width="860px" style="margin-left:60px;margin-top:20px;" cellspacing="8">
					 		<tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>发起人：</strong></td>
				            	<td align="left" width="254px"> 
				            		<html:text property="initiatorId" tabindex="1" readonly="true" value="${IGWIM01011VO.workDefinitionInfo.initiatorId }"/>
				            		<!-- 主键wdid -->
					            	<html:hidden property="wdid" value="${IGWIM01011VO.workDefinitionInfo.wdid }"/>
				            	</td>
				            	<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
			            		<td align="right" width="150px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>工作项名称：</strong></td>
				            	<td align="left" width="254px">
				            		<html:text property="wdname" tabindex="1" maxlength="72" value="${IGWIM01011VO.workDefinitionInfo.wdname }"/>
				            	</td>
			            	</tr>
			            	<tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><strong>工作项描述：</strong></td>
				            	<td align="left" width="254px" colspan="6"> 
				            	<html:textarea property="description" rows="4" cols="88" style="width:635px" tabindex="3" value="${IGWIM01011VO.workDefinitionInfo.description }"/></td>
				            	<td align="right" width="16px"/>
			            	</tr>
			            	<tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>周期：</strong></td>
				            	<td colspan="5">
									<label for="everyDay" class="clearLabel">
										<input name="cycle" type="radio" id="everyDay" value="day" onclick="toQuency(this.value)" <%=dayChecked %> />每日
				            		</label>
				            		<label for="everyWeek" class="clearLabel">
								        <input name="cycle" type="radio" id="everyWeek" value="week" onclick="toQuency(this.value)" <%=weekChecked %> />每周
				            		</label>
				            		<label for="everyMonth" class="clearLabel">
								        <input name="cycle" type="radio" id="everyMonth" value="month" onclick="toQuency(this.value)" <%=monthChecked %> />每月
				            		</label>
				            		<label for="everyQuarter" class="clearLabel">
								        <input name="cycle" type="radio" id="everyQuarter" value="quarter" onclick="toQuency(this.value)" <%=quarterChecked %> />每季度
				            		</label>
				            		<label for="everyHalfyear" class="clearLabel">
								        <input name="cycle" type="radio" id="everyHalfyear" value="halfyear" onclick="toQuency(this.value)" <%=halfyearChecked %> />每半年
				            		</label>
				            		<label for="everyYear" class="clearLabel">
								        <input name="cycle" type="radio" id="everyYear" value="year" onclick="toQuency(this.value)" <%=yearChecked %> />每年
				            		</label>
						    		    	<!-- 隐藏选项 -->
    								<div id="page" style="display:none;height:auto;">
						    		<!-- 每周 -->
						   			<div id="week" style="display:none ">
							    		<logic:present name="IGWIM01011VO" property="weekList">
											<logic:iterate id="bean" name="IGWIM01011VO" property="weekList" indexId="index">
												<c:if test="${bean.ischecked != null }">
													<input type="checkbox" weekCk="1" style="border-color: red;" name="wdweek" id="wdweek" data-on="${bean.weekdata }" data-off="${bean.weekdata }" value="${bean.weekvalue }" checked="checked"/>
												</c:if>
												<c:if test="${bean.ischecked == null }">
													<input type="checkbox" weekCk="1" name="wdweek" id="wdweek" data-on="${bean.weekdata }" data-off="${bean.weekdata }" value="${bean.weekvalue }"/>
												</c:if>
											</logic:iterate>
										</logic:present>
									</div>
									<!-- 每月 -->
									<div id="month" style="display:none; height:auto;">
									<logic:present name="IGWIM01011VO" property="monthList">
										<logic:iterate id="bean" name="IGWIM01011VO" property="monthList" indexId="index">
											<c:if test="${bean.ischecked != null }">
												<input type="checkbox" monthCk="1" name="wdmonth" id="wdmonth" data-on="${bean.dayvalue }" data-off="${bean.dayvalue }" value="${bean.dayvalue }" checked="checked" />
											</c:if>
											<c:if test="${bean.ischecked == null }">
												<input type="checkbox" monthCk="1" name="wdmonth" id="wdmonth" data-on="${bean.dayvalue }" data-off="${bean.dayvalue }" value="${bean.dayvalue }" />
											</c:if>
										</logic:iterate>
									</logic:present>
									</div>
								</div>
								<!-- 月末是否发起检查 -->
								<div id="month1" style="display:none; height:42px;">
									<span style="display:block; float:left;height:42px;vertical-align: middle;">
										请确认每月最后一天是否发起检查：
									</span>
									<span style="display:block; float:left; height:42px; width:42px;">
										<c:if test="${IGWIM0101Form.monthLastDay != null }">
											<input type="checkbox" name="monthLastDay" monthCk="2" id="monthLastDay" data-on="是" data-off="否" value="Y" checked="checked"/>
										</c:if>
										<c:if test="${IGWIM0101Form.monthLastDay == null }">
											<input type="checkbox" name="monthLastDay" monthCk="2" id="monthLastDay" data-on="是" data-off="否" value="Y"/>
										</c:if>
									</span>	
								</div>
				            	</td>
			            	</tr>
			            	<tr id="time">
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>时间：</strong></td>
				            	<td align="left" width="254px"> 
									<select id="wdhour" name="wdhour">
										<option value="00">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
										<option value="16">16</option>
										<option value="17">17</option>
										<option value="18">18</option>
										<option value="19">19</option>
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
									</select>
									时
									<select id="wdminute" name="wdminute">
										<option value="00">00</option>
										<option value="15">15</option>
										<option value="30">30</option>
										<option value="45">45</option>
									</select>
									分
									<input type="hidden" id="hour" value="${IGWIM01011VO.workDefinitionInfo.wdhour }"/>
									<input type="hidden" id="minutes" value="${IGWIM01011VO.workDefinitionInfo.wdminute }"/>
				            	</td>
				            	<td align="right" width="16px"></td>
				            </tr>	 
				            <tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>启用状态：</strong></td>
				            	<td align="left" width="254px"> 
									<c:if test="${IGWIM01011VO.workDefinitionInfo.wdstatus=='1' }">已启用</c:if>
									<c:if test="${IGWIM01011VO.workDefinitionInfo.wdstatus=='0' }">已停用</c:if>
									<input type="hidden" id="status" name="wdstatus" value="${IGWIM01011VO.workDefinitionInfo.wdstatus }"/>
								</td>
								<td align="right" width="16px"/>
								<td align="right" width="150px" style="background-color: #EEEEEE; ">
				            		<strong>实际完成时间：</strong>
				            	</td>
				            	<td align="left" width="254px"> 
									${IGWIM01011VO.workDefinitionInfo.actualFinishDate }
								</td>
				            	
								
			            	</tr>
			            	<tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>开始日期：</strong></td>
				            	<td align="left" width="254px"> 
								<html:text property="beginDate" value="${IGWIM01011VO.workDefinitionInfo.beginDate }" styleId="beginDate" errorStyleClass="inputError imeDisabled" size="20" readonly="true"/>
								<img src="images/date.gif" align="middle" onclick="calendar(document.forms[0].beginDate)" border="0" style="cursor: hand" /> <br />				            	</td>
				            	<td align="right" width="16px"/>
				            	<td align="right" width="160px" style="background-color: #EEEEEE; ">
				            		<span class="red">*</span>
				            		<strong>预计完成时间：</strong>
				            	</td>
				            	<td align="left" width="254px"> 
									<html:text property="estimateFinishDate" value="${IGWIM01011VO.workDefinitionInfo.estimateFinishDate }" styleId="estimateFinishDate" errorStyleClass="inputError imeDisabled" size="20" readonly="true"/>
									<img src="images/date.gif" align="middle" onclick="calendar(document.forms[0].estimateFinishDate)" border="0" style="cursor: hand" /> <br />
								</td>
								
			            	</tr>
			            	<tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; ">
				            		<span class="red">*</span><strong>负责人：</strong>
				            	</td>
				            	<td align="left" width="254px"> 
				            		<!--对于中心负责人及以上的岗位，发起人为自己，负责人、执行人可以从现有用户列表中选择，且可以选择多个执行人-->
				            		<c:if test="${IGWIM0101Form.isLeader=='1' }">
							   			<html:text property="leaderName" tabindex="15"  readonly="true" value="${IGWIM01011VO.workDefinitionInfo.leaderName }"></html:text>
										<input type="hidden" width="0px" name="leaderId" id="leaderId" value="${IGWIM01011VO.workDefinitionInfo.leaderId }"/>
							   			<img src="images/seek.gif" style="cursor: hand;" alt="选择负责人" width="16" height="16" border="0" onclick="searchFzr();"/>								
				            		</c:if>
				            		<!-- 对于普通员工，发起人、负责人、执行人只能是自己。 -->
				            		<c:if test="${IGWIM0101Form.isLeader=='0' }">
										<input type="hidden" width="0px" name="leaderId" id="leaderId" value="${IGWIM01011VO.workDefinitionInfo.leaderId }"/>
							   			<html:text property="leaderName" styleId="leaderName" readonly="true" tabindex="15" value="${IGWIM01011VO.workDefinitionInfo.leaderName }"></html:text>
				            		</c:if>
						   		</td>
								<td align="right" width="16px"/>
								<td align="right" width="150px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>超时停止处理时间：</strong></td>
				            	<td align="left" width="254px"> 
				            	<html:text property="overtimeStopDealTime" styleId="overtimeStopDealTime" value="${IGWIM01011VO.workDefinitionInfo.overtimeStopDealTime }"/>日
								</td>
								<td align="right" width="16px"/>
								
			            	</tr>
			            	<tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; ">
				            		<span class="red">*</span><strong>执行人：</strong>
				            	</td>
				            	<td align="left" width="254px"> 
				            		<!--对于中心负责人及以上的岗位，发起人为自己，负责人、执行人可以从现有用户列表中选择，且可以选择多个执行人-->
				            		<c:if test="${IGWIM0101Form.isLeader=='1' }">
										<span id="zxrArea">
					            		</span>
					            		<br/>
										<html:hidden property="excutorName" styleId="excutorName" value="${IGWIM01011VO.workDefinitionInfo.excutorName }"></html:hidden>
										<html:hidden property="excutorId" styleId="excutorId" value="${IGWIM01011VO.workDefinitionInfo.excutorId }"></html:hidden>
							   			<img src="images/seek.gif" style="cursor: hand;" alt="选择执行人" width="16" height="16" border="0" onclick="addUser();"/>
				            		</c:if>
				            		<!-- 对于普通员工，发起人、负责人、执行人只能是自己。 -->
				            		<c:if test="${IGWIM0101Form.isLeader=='0' }">
										<html:hidden property="excutorId"  styleId="excutorId" value="${IGWIM01011VO.workDefinitionInfo.excutorId }"></html:hidden>
										<html:text property="excutorName" readonly="true" styleId="excutorName" value="${IGWIM01011VO.workDefinitionInfo.excutorName }"></html:text>
				            		</c:if>
								</td>
				            	<td align="right" width="16px"/>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><strong>超时提醒时间：</strong></td>
				            	<td align="left" width="254px"> 
				            	<html:text property="overtimeTipsTime" tabindex="1" value="${IGWIM01011VO.workDefinitionInfo.overtimeTipsTime }"/>日
								</td>
								<td align="right" width="16px"/>
				            	
			            	</tr>
			            	<tr>
				            	<td align="right" width="150px" style="background-color: #EEEEEE; "><strong>备注：</strong></td>
				            	<td align="left" width="254px" colspan="6"> 
				            		<html:textarea property="remarks" style="width:635px" rows="3" cols="88" tabindex="13" value="${IGWIM01011VO.workDefinitionInfo.remarks }"/>
								</td>
			            	</tr>
			            </table>
				</logic:equal>
				
				
				<div class="enter"><html:submit property="btn_insert" value="提交"
					styleClass="button" onclick="return confirmDisp();" /> <html:reset
					property="btn_clear" styleClass="button" value="重置" /></div>
					
				<html:hidden property="isLeader" styleId="isLeader" />
				<html:hidden property="mode" styleId="mode" />
				<input type="hidden" id="cycyleHide" value="${IGWIM01011VO.workDefinitionInfo.cycle }"/>
				<input type="hidden" id="weekHide" value="${IGWIM01011VO.workDefinitionInfo.wdweek }"/>
				<input type="hidden" id="monthHide" value="${IGWIM01011VO.workDefinitionInfo.wdmonth }"/>
				<input type="hidden" id="lastMonthHide" value="${IGWIM01011VO.workDefinitionInfo.monthLastDay }"/>
				
				</fieldset>
		         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying">
    </div>
</div>
</div>
</body>
</html:html>
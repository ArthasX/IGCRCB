<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSMR0307" toScope="request" />
<bean:define id="title" value="提醒时间设定" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<style>
</style>
<!-- /header1 -->
<script>
function settime(type){
	var month = '';
	var day ='';
	if(type=='1'){
		month = document.getElementById("year_m").value;
		day = document.getElementById("year_d").value;
	}
	if(type=='2'){
		month = document.getElementById("month1_m").value;
		day = document.getElementById("month1_d").value;
	}
	if(type=='3'){
		month = document.getElementById("month2_m").value;
		day = document.getElementById("month2_d").value;
	}
	if(type=='4'){
		month = document.getElementById("month3_m").value;
		day = document.getElementById("month3_d").value;
	}
	if(type=='5'){
		month = document.getElementById("month4_m").value;
		day = document.getElementById("month4_d").value;
	}
	if (month == "") {
		alert("请选择月份！");
		return false;
	}
	if(day==""){
		alert("请选择天数！");
		return false;
	}
	if( window.confirm("是否确认设置？")){
		document.forms[0].action = getAppRootUrl() + "/IGSMR0303_SET.do?rctype="+type+"&rcmonth="+month+"&rcday="+day;
		document.forms[0].submit();
	}else{
		return false;
	}
}
function del(type){
	if( window.confirm("是否确认清除设置？")){
		document.forms[0].action = getAppRootUrl() + "/IGSMR0303_CLEAR.do?rctype="+type;
		document.forms[0].submit();
	}else{
		return false;
	}
}
function stop(type){
	if( window.confirm("是否确认中止？")){
		document.forms[0].action = getAppRootUrl() + "/IGSMR0303_STOP.do?rctype="+type;
		document.forms[0].submit();
	}else{
		return false;
	}
}

function getday(type){
	var month ="";
	var year_d = document.form.year_d;
	var month1_d = document.form.month1_d;
	var month2_d = document.form.month2_d;
	var month3_d = document.form.month3_d;
	var month4_d = document.form.month4_d;

	if(type=='1'){
		month = document.getElementById("year_m").value;
	}
	if(type=='2'){
		month = document.getElementById("month1_m").value;
	}
	if(type=='3'){
		month = document.getElementById("month2_m").value;
	}
	if(type=='4'){
		month = document.getElementById("month3_m").value;
	}
	if(type=='5'){
		month = document.getElementById("month4_m").value;
	}
    if(month=="01"||month=="03"||month=="05"||month=="07"||month=="08"||month=="10"||month=="12"){
    	if(type=="1"){
    		year_d.length=0;
    		for(var i=1;i<=31;i++){
    			if(i<10){   				
				    year_d.options.add(new Option("0"+i, "0"+i)); 
    			}else{
    				year_d.options.add(new Option(i, i)); 
    			}
    		}
    	}
    	if(type=="2"){
    		month1_d.length=0;
    		for(var i=1;i<=31;i++){
    			if(i<10){   				
    				month1_d.options.add(new Option("0"+i, "0"+i)); 
    			}else{
    				month1_d.options.add(new Option(i, i)); 
    			}
    		}
    	}
    	if(type=="3"){
    		month2_d.length=0;
    		for(var i=1;i<=31;i++){
    			if(i<10){   				
    				month2_d.options.add(new Option("0"+i, "0"+i)); 
    			}else{
    				month2_d.options.add(new Option(i, i)); 
    			}
    		}
    	}
    	if(type=="4"){
    		month3_d.length=0;
    		for(var i=1;i<=31;i++){
    			if(i<10){   				
    				month3_d.options.add(new Option("0"+i, "0"+i)); 
    			}else{
    				month3_d.options.add(new Option(i, i)); 
    			}
    		}
    	}
    	if(type=="5"){
    		month4_d.length=0;
    		for(var i=1;i<=31;i++){
    			if(i<10){   				
    				month4_d.options.add(new Option("0"+i, "0"+i)); 
    			}else{
    				month4_d.options.add(new Option(i, i)); 
    			}
    		}
    	}
   		
    }
    if(month=="04"||month=="06"||month=="09"||month=="11"){
    	if(type=="1"){
    		year_d.length=0;
    		for(var i=1;i<=30;i++){
    			if(i<10){   				
				    year_d.options.add(new Option("0"+i, "0"+i)); 
    			}else{
    				year_d.options.add(new Option(i, i)); 
    			}
    		}
    	}
    	if(type=="2"){
    		month1_d.length=0;
    		for(var i=1;i<=30;i++){
    			if(i<10){   				
    				month1_d.options.add(new Option("0"+i, "0"+i)); 
    			}else{
    				month1_d.options.add(new Option(i, i)); 
    			}
    		}
    	}
    	if(type=="3"){
    		month2_d.length=0;
    		for(var i=1;i<=30;i++){
    			if(i<10){   				
    				month2_d.options.add(new Option("0"+i, "0"+i)); 
    			}else{
    				month2_d.options.add(new Option(i, i)); 
    			}
    		}
    	}
    	if(type=="4"){
    		month3_d.length=0;
    		for(var i=1;i<=30;i++){
    			if(i<10){   				
    				month3_d.options.add(new Option("0"+i, "0"+i)); 
    			}else{
    				month3_d.options.add(new Option(i, i)); 
    			}
    		}
    	}
    	if(type=="5"){
    		month4_d.length=0;
    		for(var i=1;i<=30;i++){
    			if(i<10){   				
    				month4_d.options.add(new Option("0"+i, "0"+i)); 
    			}else{
    				month4_d.options.add(new Option(i, i)); 
    			}
    		}
    	}
    }
    if(month=="02"){
    	var myDate = new Date();
    	 var pYear =parseInt(myDate.getFullYear());
    	if((pYear%4==0 && pYear%100!=0)||(pYear%100==0 && pYear%400==0)){
        	if(type=="1"){
        		year_d.length=0;
        		for(var i=1;i<=29;i++){
        			if(i<10){   				
    				    year_d.options.add(new Option("0"+i, "0"+i)); 
        			}else{
        				year_d.options.add(new Option(i, i)); 
        			}
        		}
        	}
        	if(type=="2"){
        		month1_d.length=0;
        		for(var i=1;i<=29;i++){
        			if(i<10){   				
        				month1_d.options.add(new Option("0"+i, "0"+i)); 
        			}else{
        				month1_d.options.add(new Option(i, i)); 
        			}
        		}
        	}
        	if(type=="3"){
        		month2_d.length=0;
        		for(var i=1;i<=29;i++){
        			if(i<10){   				
        				month2_d.options.add(new Option("0"+i, "0"+i)); 
        			}else{
        				month2_d.options.add(new Option(i, i)); 
        			}
        		}
        	}
        	if(type=="4"){
        		month3_d.length=0;
        		for(var i=1;i<=29;i++){
        			if(i<10){   				
        				month3_d.options.add(new Option("0"+i, "0"+i)); 
        			}else{
        				month3_d.options.add(new Option(i, i)); 
        			}
        		}
        	}
        	if(type=="5"){
        		month4_d.length=0;
        		for(var i=1;i<=29;i++){
        			if(i<10){   				
        				month4_d.options.add(new Option("0"+i, "0"+i)); 
        			}else{
        				month4_d.options.add(new Option(i, i)); 
        			}
        		}
        	}
    	}else{
        	if(type=="1"){
        		year_d.length=0;
        		for(var i=1;i<=28;i++){
        			if(i<10){   				
    				    year_d.options.add(new Option("0"+i, "0"+i)); 
        			}else{
        				year_d.options.add(new Option(i, i)); 
        			}
        		}
        	}
        	if(type=="2"){
        		month1_d.length=0;
        		for(var i=1;i<=28;i++){
        			if(i<10){   				
        				month1_d.options.add(new Option("0"+i, "0"+i)); 
        			}else{
        				month1_d.options.add(new Option(i, i)); 
        			}
        		}
        	}
        	if(type=="3"){
        		month2_d.length=0;
        		for(var i=1;i<=28;i++){
        			if(i<10){   				
        				month2_d.options.add(new Option("0"+i, "0"+i)); 
        			}else{
        				month2_d.options.add(new Option(i, i)); 
        			}
        		}
        	}
        	if(type=="4"){
        		month3_d.length=0;
        		for(var i=1;i<=28;i++){
        			if(i<10){   				
        				month3_d.options.add(new Option("0"+i, "0"+i)); 
        			}else{
        				month3_d.options.add(new Option(i, i)); 
        			}
        		}
        	}
        	if(type=="5"){
        		month4_d.length=0;
        		for(var i=1;i<=28;i++){
        			if(i<10){   				
        				month4_d.options.add(new Option("0"+i, "0"+i)); 
        			}else{
        				month4_d.options.add(new Option(i, i)); 
        			}
        		}
        	}	}
    }
}
function getresult(){
	year_m = document.getElementById("year_m").value;
	month1_m = document.getElementById("month1_m").value;
	month2_m = document.getElementById("month2_m").value;
	month3_m = document.getElementById("month3_m").value;
	month4_m = document.getElementById("month4_m").value;

	var year_d = document.form.year_d;
	var month1_d = document.form.month1_d;
	var month2_d = document.form.month2_d;
	var month3_d = document.form.month3_d;
	var month4_d = document.form.month4_d;
	//判断是否有值
	if(year_m!=""){		
		if(year_m=="01"||year_m=="03"||year_m=="05"||year_m=="07"||year_m=="08"||year_m=="10"||year_m=="12"){
			for(var i=1;i<=31;i++){
    			if(i<10){
    				year_d.options.add(new Option("0"+i, "0"+i)); 
    				if("0"+i==${year_d}){
    					year_d.options[i-1].selected=true;
    				}				    
    			}else{
    				year_d.options.add(new Option(i, i)); 
    				if(i==${year_d}){
    					year_d.options[i-1].selected=true;
    				}
    			}
    		}
		}
		if(year_m=="04"||year_m=="06"||year_m=="09"||year_m=="11"){
			for(var i=1;i<=30;i++){
    			if(i<10){   				
				    year_d.options.add(new Option("0"+i, "0"+i)); 
				    if("0"+i==${year_d}){
    					year_d.options[i-1].selected=true;
    				}
    			}else{
    				year_d.options.add(new Option(i, i)); 
    				if(i==${year_d}){
    					year_d.options[i-1].selected=true;
    				}
    				
    			}
    		}
		}
		if(year_m=="02"){
			var myDate = new Date();
	    	 var pYear =parseInt(myDate.getFullYear());
	    	if((pYear%4==0 && pYear%100!=0)||(pYear%100==0 && pYear%400==0)){
	    		for(var i=1;i<=29;i++){
        			if(i<10){   				
    				    year_d.options.add(new Option("0"+i, "0"+i)); 
    				    if("0"+i==${year_d}){
        					year_d.options[i-1].selected=true;
        				}
        			}else{
        				year_d.options.add(new Option(i, i)); 
        				if(i==${year_d}){
        					year_d.options[i-1].selected=true;
        				}
        			}
        		}
	    	}else{
	    		for(var i=1;i<=28;i++){
        			if(i<10){   				
    				    year_d.options.add(new Option("0"+i, "0"+i)); 
    				    if("0"+i==${year_d}){
        					year_d.options[i-1].selected=true;
        				}
        			}else{
        				year_d.options.add(new Option(i, i)); 
        				if(i==${year_d}){
        					year_d.options[i-1].selected=true;
        				}
        			}
        		}
	    	}
		}
	}
	if(month1_m!=""){		
		if(month1_m=="01"||month1_m=="03"||month1_m=="05"||month1_m=="07"||month1_m=="08"||month1_m=="10"||month1_m=="12"){
			for(var i=1;i<=31;i++){
    			if(i<10){
    				month1_d.options.add(new Option("0"+i, "0"+i)); 
    				if("0"+i==${month1_d}){
    					month1_d.options[i-1].selected=true;
    				}				    
    			}else{
    				month1_d.options.add(new Option(i, i)); 
    				if(i==${month1_d}){
    					month1_d.options[i-1].selected=true;
    				}
    			}
    		}
		}
		if(month1_m=="04"||month1_m=="06"||month1_m=="09"||month1_m=="11"){
			for(var i=1;i<=30;i++){
    			if(i<10){   				
    				month1_d.options.add(new Option("0"+i, "0"+i)); 
				    if("0"+i==${month1_d}){
				    	month1_d.options[i-1].selected=true;
    				}
    			}else{
    				month1_d.options.add(new Option(i, i)); 
    				if(i==${month1_d}){
    					month1_d.options[i-1].selected=true;
    				}
    				
    			}
    		}
		}
		if(month1_m=="02"){
			var myDate = new Date();
	    	 var pYear =parseInt(myDate.getFullYear());
	    	if((pYear%4==0 && pYear%100!=0)||(pYear%100==0 && pYear%400==0)){
	    		for(var i=1;i<=29;i++){
        			if(i<10){   				
        				month1_d.options.add(new Option("0"+i, "0"+i)); 
    				    if("0"+i==${month1_d}){
    				    	month1_d.options[i-1].selected=true;
        				}
        			}else{
        				month1_d.options.add(new Option(i, i)); 
        				if(i==${month1_d}){
        					month1_d.options[i-1].selected=true;
        				}
        			}
        		}
	    	}else{
	    		for(var i=1;i<=28;i++){
        			if(i<10){   				
        				month1_d.options.add(new Option("0"+i, "0"+i)); 
    				    if("0"+i==${month1_d}){
    				    	month1_d.options[i-1].selected=true;
        				}
        			}else{
        				month1_d.options.add(new Option(i, i)); 
        				if(i==${month1_d}){
        					month1_d.options[i-1].selected=true;
        				}
        			}
        		}
	    	}
		}
	}
	if(month2_m!=""){		
		if(month2_m=="01"||month2_m=="03"||month2_m=="05"||month2_m=="07"||month2_m=="08"||month2_m=="10"||month2_m=="12"){
			for(var i=1;i<=31;i++){
    			if(i<10){
    				month2_d.options.add(new Option("0"+i, "0"+i)); 
    				if("0"+i==${month2_d}){
    					month2_d.options[i-1].selected=true;
    				}				    
    			}else{
    				month2_d.options.add(new Option(i, i)); 
    				if(i==${month2_d}){
    					month2_d.options[i-1].selected=true;
    				}
    			}
    		}
		}
		if(month2_m=="04"||month2_m=="06"||month2_m=="09"||month2_m=="11"){
			for(var i=1;i<=30;i++){
    			if(i<10){   				
    				month2_d.options.add(new Option("0"+i, "0"+i)); 
				    if("0"+i==${month2_d}){
				    	month2_d.options[i-1].selected=true;
    				}
    			}else{
    				month2_d.options.add(new Option(i, i)); 
    				if(i==${month2_d}){
    					month2_d.options[i-1].selected=true;
    				}
    				
    			}
    		}
		}
		if(month2_m=="02"){
			var myDate = new Date();
	    	 var pYear =parseInt(myDate.getFullYear());
	    	if((pYear%4==0 && pYear%100!=0)||(pYear%100==0 && pYear%400==0)){
	    		for(var i=1;i<=29;i++){
        			if(i<10){   				
        				month2_d.options.add(new Option("0"+i, "0"+i)); 
    				    if("0"+i==${month2_d}){
    				    	month2_d.options[i-1].selected=true;
        				}
        			}else{
        				month2_d.options.add(new Option(i, i)); 
        				if(i==${month2_d}){
        					month2_d.options[i-1].selected=true;
        				}
        			}
        		}
	    	}else{
	    		for(var i=1;i<=28;i++){
        			if(i<10){   				
        				month2_d.options.add(new Option("0"+i, "0"+i)); 
    				    if("0"+i==${month2_d}){
    				    	month2_d.options[i-1].selected=true;
        				}
        			}else{
        				month2_d.options.add(new Option(i, i)); 
        				if(i==${month2_d}){
        					month2_d.options[i-1].selected=true;
        				}
        			}
        		}
	    	}
		}
	}
	if(month3_m!=""){		
		if(month3_m=="01"||month3_m=="03"||month3_m=="05"||month3_m=="07"||month3_m=="08"||month3_m=="10"||month3_m=="12"){
			for(var i=1;i<=31;i++){
    			if(i<10){
    				month3_d.options.add(new Option("0"+i, "0"+i)); 
    				if("0"+i==${month3_d}){
    					month3_d.options[i-1].selected=true;
    				}				    
    			}else{
    				month3_d.options.add(new Option(i, i)); 
    				if(i==${month3_d}){
    					month3_d.options[i-1].selected=true;
    				}
    			}
    		}
		}
		if(month3_m=="04"||month3_m=="06"||month3_m=="09"||month3_m=="11"){
			for(var i=1;i<=30;i++){
    			if(i<10){   				
    				month3_d.options.add(new Option("0"+i, "0"+i)); 
				    if("0"+i==${month3_d}){
				    	month3_d.options[i-1].selected=true;
    				}
    			}else{
    				month3_d.options.add(new Option(i, i)); 
    				if(i==${month3_d}){
    					month3_d.options[i-1].selected=true;
    				}
    				
    			}
    		}
		}
		if(month3_m=="02"){
			var myDate = new Date();
	    	 var pYear =parseInt(myDate.getFullYear());
	    	if((pYear%4==0 && pYear%100!=0)||(pYear%100==0 && pYear%400==0)){
	    		for(var i=1;i<=29;i++){
        			if(i<10){   				
        				month3_d.options.add(new Option("0"+i, "0"+i)); 
    				    if("0"+i==${month3_d}){
    				    	month3_d.options[i-1].selected=true;
        				}
        			}else{
        				month3_d.options.add(new Option(i, i)); 
        				if(i==${month3_d}){
        					month3_d.options[i-1].selected=true;
        				}
        			}
        		}
	    	}else{
	    		for(var i=1;i<=28;i++){
        			if(i<10){   				
        				month3_d.options.add(new Option("0"+i, "0"+i)); 
    				    if("0"+i==${month3_d}){
    				    	month3_d.options[i-1].selected=true;
        				}
        			}else{
        				month3_d.options.add(new Option(i, i)); 
        				if(i==${month3_d}){
        					month3_d.options[i-1].selected=true;
        				}
        			}
        		}
	    	}
		}
	}
	if(month4_m!=""){		
		if(month4_m=="01"||month4_m=="03"||month4_m=="05"||month4_m=="07"||month4_m=="08"||month4_m=="10"||month4_m=="12"){
			for(var i=1;i<=31;i++){
    			if(i<10){
    				month4_d.options.add(new Option("0"+i, "0"+i)); 
    				if("0"+i==${month4_d}){
    					month4_d.options[i-1].selected=true;
    				}				    
    			}else{
    				month4_d.options.add(new Option(i, i)); 
    				if(i==${month4_d}){
    					month4_d.options[i-1].selected=true;
    				}
    			}
    		}
		}
		if(month4_m=="04"||month4_m=="06"||month4_m=="09"||month4_m=="11"){
			for(var i=1;i<=30;i++){
    			if(i<10){   				
    				month4_d.options.add(new Option("0"+i, "0"+i)); 
				    if("0"+i==${month4_d}){
				    	month4_d.options[i-1].selected=true;
    				}
    			}else{
    				month4_d.options.add(new Option(i, i)); 
    				if(i==${month4_d}){
    					month4_d.options[i-1].selected=true;
    				}
    				
    			}
    		}
		}
		if(month4_m=="02"){
			var myDate = new Date();
	    	 var pYear =parseInt(myDate.getFullYear());
	    	if((pYear%4==0 && pYear%100!=0)||(pYear%100==0 && pYear%400==0)){
	    		for(var i=1;i<=29;i++){
        			if(i<10){   				
        				month4_d.options.add(new Option("0"+i, "0"+i)); 
    				    if("0"+i==${month4_d}){
    				    	month4_d.options[i-1].selected=true;
        				}
        			}else{
        				month4_d.options.add(new Option(i, i)); 
        				if(i==${month4_d}){
        					month4_d.options[i-1].selected=true;
        				}
        			}
        		}
	    	}else{
	    		for(var i=1;i<=28;i++){
        			if(i<10){   				
        				month4_d.options.add(new Option("0"+i, "0"+i)); 
    				    if("0"+i==${month4_d}){
    				    	month4_d.options[i-1].selected=true;
        				}
        			}else{
        				month4_d.options.add(new Option(i, i)); 
        				if(i==${month4_d}){
        					month4_d.options[i-1].selected=true;
        				}
        			}
        		}
	    	}
		}
	}
}
</script>
<body onload="getresult();">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation /></p>
	</div>	
<html:form action="/IGSMR0303_Disp" styleId="form">
<!--  message --> <ig:message /> <!--  /message -->
<div id="results_list1">
	<table class="table_style4" align="left">
	<tr >
	<td width="20%">年报提醒时间：</td>
	<td  width="20%">
	<html:select property="year_m" value="${year_m}" onchange="getday('1');" style="width:70px">
	<html:option value=""></html:option>
	<html:option value="01">01</html:option>
	<html:option value="02">02</html:option>
	<html:option value="03">03</html:option>
	<html:option value="04">04</html:option>
	<html:option value="05">05</html:option>
	<html:option value="06">06</html:option>
	<html:option value="07">07</html:option>
	<html:option value="08">08</html:option>
	<html:option value="09">09</html:option>
	<html:option value="10">10</html:option>
	<html:option value="11">11</html:option>
	<html:option value="12">12</html:option>
	</html:select>
	月
	</td>
	<td  width="20%">
	<html:select property="year_d" value="${year_d}" styleId="year_d"  style="width:70px">
	</html:select>
	日
	</td>
	<td  width="20%">
	<html:button property="btn_insert" value="设置" styleClass="button" onclick="settime('1');" />
	</td>
<!-- 	<td> -->
<%-- 	<html:button property="btn_insert" value="中止" styleClass="button" onclick="stop('1');"/> --%>
<!-- 	</td> -->
	<td  width="20%">
	<html:button property="btn_insert" value="清除" styleClass="button" onclick="del('1');"/>
	</td>	
	</tr>	
	<tr >
	<td colspan="6" style="padding-right:433px">季报提醒时间：</td>	
	</tr>
	<tr>
	<td >一季度：</td>

	<td>
	<html:select property="month1_m" value="${month1_m}" onchange="getday('2');" style="width:70px">
	<html:option value=""></html:option>
	<html:option value="01">01</html:option>
	<html:option value="02">02</html:option>
	<html:option value="03">03</html:option>
	<html:option value="04">04</html:option>
	<html:option value="05">05</html:option>
	<html:option value="06">06</html:option>
	<html:option value="07">07</html:option>
	<html:option value="08">08</html:option>
	<html:option value="09">09</html:option>
	<html:option value="10">10</html:option>
	<html:option value="11">11</html:option>
	<html:option value="12">12</html:option> 
	</html:select>
	月
	</td>
	<td>
	<html:select property="month1_d" value="${month1_d}" styleId="month1_d" style="width:70px">
	</html:select>
	日
	</td>
	<td>
	<html:button property="btn_insert" value="设置" styleClass="button"  onclick="settime('2');"/>
	</td>
<!-- 	<td> -->
<%-- 	<html:button property="btn_insert" value="中止" styleClass="button" onclick="stop('2');"/> --%>
<!-- 	</td> -->
	<td>
	<html:button property="btn_insert" value="清除" styleClass="button" onclick="del('2');"/>
	</td>
	</tr>
	<tr>
	<td>二季度：</td>

	<td>
	<html:select property="month2_m" value="${month2_m}" onchange="getday('3');" style="width:70px">
	<html:option value=""></html:option>
	<html:option value="01">01</html:option>
	<html:option value="02">02</html:option>
	<html:option value="03">03</html:option>
	<html:option value="04">04</html:option>
	<html:option value="05">05</html:option>
	<html:option value="06">06</html:option>
	<html:option value="07">07</html:option>
	<html:option value="08">08</html:option>
	<html:option value="09">09</html:option>
	<html:option value="10">10</html:option>
	<html:option value="11">11</html:option>
	<html:option value="12">12</html:option>
	</html:select>
	月
	</td>
	<td>
	<html:select property="month2_d" value="${month2_d}" styleId="month2_d" style="width:70px">
	</html:select>
	日
	</td>
	<td>
	<html:button property="btn_insert" value="设置" styleClass="button"  onclick="settime('3');"/>
	</td>
<!-- 	<td> -->
<%-- 	<html:button property="btn_insert" value="中止" styleClass="button" onclick="stop('3');"/> --%>
<!-- 	</td> -->
	<td>
	<html:button property="btn_insert" value="清除" styleClass="button"  onclick="del('3');"/>
	</td>
	</tr>
	<tr>
	<td>三季度：</td>

	<td>
	<html:select property="month3_m" value="${month3_m}" onchange="getday('4');" style="width:70px">
	<html:option value=""></html:option>
	<html:option value="01">01</html:option>
	<html:option value="02">02</html:option>
	<html:option value="03">03</html:option>
	<html:option value="04">04</html:option>
	<html:option value="05">05</html:option>
	<html:option value="06">06</html:option>
	<html:option value="07">07</html:option>
	<html:option value="08">08</html:option>
	<html:option value="09">09</html:option>
	<html:option value="10">10</html:option>
	<html:option value="11">11</html:option>
	<html:option value="12">12</html:option>
	</html:select>
	月
	</td>
	<td>
	<html:select property="month3_d" value="${month3_d}" styleId="month3_d" style="width:70px">

	</html:select>
	日
	</td>
	<td>
	<html:button property="btn_insert" value="设置" styleClass="button"  onclick="settime('4');"/>
	</td>
<!-- 	<td> -->
<%-- 	<html:button property="btn_insert" value="中止" styleClass="button" onclick="stop('4');"/> --%>
<!-- 	</td> -->
	<td>
	<html:button property="btn_insert" value="清除" styleClass="button" onclick ="del('4');" />
	</td>
	</tr>
	<tr>
	<td>四季度：</td>

	<td>
	<html:select property="month4_m" value="${month4_m}" onchange="getday('5');" style="width:70px">
	<html:option value=""></html:option>
	<html:option value="01">01</html:option>
	<html:option value="02">02</html:option>
	<html:option value="03">03</html:option>
	<html:option value="04">04</html:option>
	<html:option value="05">05</html:option>
	<html:option value="06">06</html:option>
	<html:option value="07">07</html:option>
	<html:option value="08">08</html:option>
	<html:option value="09">09</html:option>
	<html:option value="10">10</html:option>
	<html:option value="11">11</html:option>
	<html:option value="12">12</html:option>
	</html:select>
	月
	</td>	
	<td>
	<html:select property="month4_d" value="${month4_d}" styleId="month4_d" style="width:70px">

	</html:select>
	日
	</td>
	<td>
	<html:button property="btn_insert" value="设置" styleClass="button"  onclick="settime('5');"/>
	</td>
<!-- 	<td> -->
<%-- 	<html:button property="btn_insert" value="中止" styleClass="button" onclick="stop('5');"/> --%>
<!-- 	</td> -->
	<td>
	<html:button property="btn_insert" value="清除" styleClass="button" onclick="del('5');"/>
	</td>
	</tr>
	</table>
	</div>
	<div id="operate">
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
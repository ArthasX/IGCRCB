<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDWP0102" toScope="request" />
<bean:define id="title"	value="日期选择" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/calendarswing.css" rel="stylesheet" />
<script type="text/javascript" src="js/calendarswing.js" charset="GBK"></script>
<script type="text/javascript">
var pdid = '${IGDWP0102Form.pdid}';
function init(){
	var obj = new Calendar.Perpetual();
	obj.drow("date",function(){ 
		var year = obj.currentYear;
		var month = obj.currentMonth > 8 ? (obj.currentMonth + 1) + "" : "0" + (obj.currentMonth + 1);
		var day = parseInt(this.innerHTML) > 9 ? this.innerHTML : "0" + this.innerHTML;
		var dateStr = year + "/" + month + "/" + day;
		var flag = true;
		if(obj.currentYear < obj.year){
			flag = false;
		}else if(obj.currentYear == obj.year && obj.currentMonth < obj.month){
			flag = false;
		}else if(obj.currentYear == obj.year && obj.currentMonth == obj.month && parseInt(this.innerHTML) < obj.day){
			flag = false;
		}
		if(flag){
			location.href = 'IGDWP0103_Disp.do?pdid=' + pdid + '&startdate=' + dateStr;
		}else{
			var rawDate = obj.year + "/";
			if(obj.month > 8){
				rawDate += (obj.month + 1) + "/";
			}else{
				rawDate += "0" + (obj.month + 1) + "/";
			}
			if(obj.day > 9){
				rawDate += obj.day + "";
			}else{
				rawDate += "0" + obj.day;
			}
			alert("请选择 '" + rawDate + "' 之后的时间！");
		}
	});
}
</script>
<body onload="init();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	<ig:ProcessBackUrlTag jump="${jump}"/>
</div>
<div id="date">
</div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
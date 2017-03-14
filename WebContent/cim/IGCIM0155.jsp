<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0155" toScope="request" />
<bean:define id="title" toScope="request">
	指标信息
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>
html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	font-size: 12px;
	overflow-x: hidden;
	overflow-y: auto;
	background-color: #FFFFFF;
}

.table_style {
	width: 732px;
	margin: 10px 10px;
	border-collapse: collapse;
	text-align: center;
	table-layout: fixed;
}

.table_style th {
	color: #000000;
	border-top: 1px solid #CCCCCC;
	border-bottom: 1px solid #CCCCCC;
	background-color: #EEEEEE;
	height: 20px;
}

.table_style td {
	border-bottom: 1px solid #D3D3D3;
	height: 18px;
	word-break: break-all;
	word-wrap: break-word;
}

.table_style td a:link {
	color: #0066CC;
	text-decoration: none;
}

.table_style td a:visited {
	color: #0066CC;
	text-decoration: none;
}

.table_style td a:hover {
	color: #0066CC;
	text-decoration: underline;
}

.table_style td a:active {
	color: #0066CC;
	text-decoration: none;
}
.trbg{
	background-color: #E6F3FF;
}
</style>
<script type="text/javascript">	
	
	function goToRealTimePage(type,para1,para2,para3){
		var title=para3+"  "+para2;
		if(type=='1'){
			var paras="type="+type+"#measurement_id="+para1;
			window.showModelessDialog("IGMTM0504_Disp.do?title="+encodeURIComponent(title)+"&paras="+encodeURIComponent(paras),"a","dialogWidth:800px;dialogHeight:500px;scroll:no;");
		}else if(type=='2'){
			var paras="type="+type+"#server_id="+para1+"#service_typename="+para3+"#measurement_typename="+para2;
			window.showModelessDialog("IGMTM0504_Disp.do?title="+encodeURIComponent(title)+"&paras="+encodeURIComponent(paras),"a","dialogWidth:800px;dialogHeight:500px;scroll:no;");
		}
		
	}
	</script>
<body>
<div style="margin-top: 4px; margin-left: 10px"><ig:message /></div>
<table class="table_style">
	<tr >
		
		<th style="background-color:#9bcdff" >指标名字</th>
		<th style="background-color:#9bcdff" >采集时间</th>
		<th style="background-color:#9bcdff" >当前值</th>
		<th style="background-color:#9bcdff" >单位</th>
	</tr>
	<logic:present name="IGCIM01551VO" property="mdlist">
		<logic:iterate id="bean" name="IGCIM01551VO"
			property="mdlist" indexId="index">
			<tr <c:if test="${index%2==1 }">class='trbg'</c:if>>
				<td align="left">
				<a href ="#" onclick="goToRealTimePage('1','${bean.measurement_id}','${bean.typename}','')" >${bean.typename}</a>
				</td>
				<td>${bean.timestampStr}</td>
				<td>${bean.value}</td>
				<td>${bean.units}</td>
			</tr>
		</logic:iterate>
	</logic:present>
</table>
</body>
</html:html>
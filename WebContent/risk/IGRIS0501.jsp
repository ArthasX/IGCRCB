<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>
<%@ page import="java.util.List" %>
<html:html>
<bean:define id="id" value="IGRIS0501" toScope="request" />
<bean:define id="title" value="检查工作统计画面" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/tablePlugin.js"></script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<!-- /header1 -->
<script type="text/javascript">
window.onload=function(){
	var year=document.getElementById("year");
	if(year.value==null||year.value==""){
		for(var i=1;i<year.options.length;i++){
			if(year.options[i].value==new Date().getYear().toString()){
				year.options[i].selected=true;
			}
		}
			}
	var month=document.getElementById("month");	
	
	if(month.value==null||month.value==""){
		var date=new Date();
		var mon=((date.getMonth()+1).toString().length==1?"0"+(date.getMonth()+1):(date.getMonth()+1));
		for(var i=1;i<month.options.length;i++){
			if(month.options[i].value==mon){
				month.options[i].selected=true;
			}
		}
	}
 
}
function onExcel(){
	form.action = "IGRIS0501_Excel.do";
	form.submit();
}
function onSubmit(){
	var flag=true;
	var year = $("#year").val();
	var month =$("#month").val();
	
	if(year == "" || year == null){
		alert("请您选择年！");
		flag=false;
		return;
	}
	if(month == "" || month == null){
		alert("请您选择月份！");
		flag=false;
		return;
	}
	if(flag){
	form.action = "IGRIS0501.do";
	form.submit();
	}
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGRIS0501" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span class="subscribe"><strong>检查方式：&nbsp;&nbsp;</strong></span>
		<html:select property="rcrtestmode" styleId="rcrtestmode" >
				<html:option value=""></html:option>
				<html:option value="1">内部常规</html:option>
				<html:option value="2">等级保护</html:option>
				<html:option value="3">专项</html:option>
		</html:select>
	<span class="subscribe"><strong><span class="red">*</span>时间：&nbsp;&nbsp;</strong></span>
	<html:select property="year" styleId="year" >
				<html:option value=""></html:option>
				<html:option value="2014">2014年</html:option>
				<html:option value="2015">2015年</html:option>
				<html:option value="2016">2016年</html:option>
				<html:option value="2017">2017年</html:option>
				<html:option value="2018">2018年</html:option>
				<html:option value="2019">2019年</html:option>
				<html:option value="2020">2020年</html:option>
	</html:select>
	<html:select property="month" styleId="month" >
				<html:option value=""></html:option>
				<html:option value="01">1月</html:option>
				<html:option value="02">2月</html:option>
				<html:option value="03">3月</html:option>
				<html:option value="04">4月</html:option>
				<html:option value="05">5月</html:option>
				<html:option value="06">6月</html:option>
				<html:option value="07">7月</html:option>
				<html:option value="08">8月</html:option>
				<html:option value="09">9月</html:option>
				<html:option value="10">10月</html:option>
				<html:option value="11">11月</html:option>
				<html:option value="12">12月</html:option>
	</html:select>
	&nbsp;&nbsp;<html:button property="btn_sub" styleClass="button" value="查询" onclick="onSubmit();" />
	&nbsp;&nbsp;<html:button property="btn_ext" value="导出" styleClass="button" onclick="onExcel()"/>
	</div>
	
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style" id="process">
		<tr>
			<th>序号</th>
			<th>检查项类型</th>
			<th>检查项名称</th>
			<th>检查项说明</th>
			<th>检查频率</th>
			<th>检查结果</th>
			<th>结果说明</th>
			<th>附件</th>
			<th>问题</th>
			
		</tr>
		<logic:present name="IGRIS05011VO" property="checkWorkMap">
			<logic:iterate id="map1" name="IGRIS05011VO" property="checkWorkMap" indexId="index1">
				<logic:present name="map1" property="value">
					<bean:size id="valueSize1" name="map1" property="value"/>
					<bean:define id="valueSizeSum" value="${valueSizeSum + valueSize1}"/> 
					<logic:iterate id="map" name="map1" property="value" indexId="index">
						<logic:present name="map" property="value">
							
							<bean:size id="valueSize" name="map" property="value"/>
							<logic:iterate id="bean" name="map" property="value" indexId="idx">
								<tr>
									<td>${valueSizeSum -valueSize1  + index + 1}</td>
									<td >
										<ig:codeValue ccid="RISKCHECK_CLASS_CODE" cid="${map1.key }"/>
									</td>
									<td >${bean.rcname}</td>
									<td>${bean.rcdesc}</td>
									<td>${bean.rcfrequency}</td>
									<td>${bean.rcrresult}</td>
									<td>${bean.rcrcomment}</td>
									<%-- <td>${bean.rcrattch}</td> --%>
									<td>
									<logic:notEmpty name="bean" property="rcrattch">
									<html:link
										action="downloadSvcFile.do?attId=${bean.attachid }&type=svc">
										<bean:define id="attname" name="bean"  property="rcrattch" />
									<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
									</html:link>
									</logic:notEmpty>
									</td>
									<td>${bean.prtitle}</td>
								</tr>
							</logic:iterate>
						</logic:present>
					</logic:iterate>
				</logic:present>						
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	</html:form>
</div>
</div>
</div>
</div>
</body>
<script type="text/javascript">
$('#process').mergeCell({ 
	// 目前只有cols这么一个配置项, 用数组表示列的索引,从0开始 
	// 然后根据指定列来处理(合并)相同内容单元格 
	cols: [0,1,2] 
	});
</script>
</html:html>

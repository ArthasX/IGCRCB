<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGDRM1811" toScope="request" />
<bean:define id="title" value="演练统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>
.condTable{
	width:80%;
	float: left;
}
.condTable th{
text-align: right;
}
.condTable td{
	line-height: 20px;
	text-align: left;
}
.table_style{
	border: 1px solid #000;
}
.table_style th{
	background: #00B0F0;
	border: 1px solid #000;
	color: #fff;
}
.table_style td{
	border: 1px solid #000;
}
#pieChart div{
	margin-left: 0px;
}
</style>
<script type="text/javascript" src="js/Highcharts/highcharts.src.js">	
</script>
<!-- <script type="text/javascript" src="js/Highcharts/highcharts-nodata.src.js">	</script> -->

<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="formwrapper">
	<!--  message -->
	<ig:message />
	<!--  /message -->
				<html:form  action="/IGDRM1811" styleId="form">
		<div id="search">
			<div class="img"></div>
			<div class="conditions">
					<table class="condTable" >
						<tr>
							<th width="15%">登记时间：</th>
							<td width="20%"><html:text property="drillTimeFrom" readonly="true" styleId="drillTimeFrom" onclick="showDate(this)"/>
							</td>
							<th width="5%">	到：</th>
							<td width="20%"><html:text property="drillTimeTo" readonly="true"  styleId="drillTimeTo" onclick="showDate(this)" />
							</td>
							<td>
								<html:submit styleClass="button">查询</html:submit>
							</td>
						</tr>
					</table>
			</div>
		</div>
				</html:form>
	<fieldset> 
		<legend>演练统计</legend>
		<br/>
		<div style ="width:400px; float: left;margin: 0px;">
		<table class="table_style">
			<tr>
				<th >演练工作</th>
				<th width="16%">总数</th>
				<th width="36%" colspan="2">执行情况</th>
				<th width="16%">占比</th>
			</tr>
			<logic:present name="IGDRM18111VO" property="drillRateList">
				<logic:iterate id="rateMap" name="IGDRM18111VO" property="drillRateList" indexId="index">
					<tr>
						<td rowspan="2">${rateMap['RATENAME'] }</td>
						<td rowspan="2">
							<c:if test="${rateMap['ACCOUNT'] !=null}">${rateMap['ACCOUNT'] }</c:if>
							<c:if test="${rateMap['ACCOUNT'] ==null}">0</c:if>
						</td>
						<td>
							<c:if test="${index==2 }">计划内演练</c:if>
							<c:if test="${index!=2 }">已完成</c:if>
						</td>
						<td>
							<c:if test="${rateMap['YCOUNT'] !=null}">${rateMap['YCOUNT'] }</c:if>
							<c:if test="${rateMap['YCOUNT'] ==null}">0</c:if>
						</td>
						<td>
								${rateMap['YRATE'] }
						</td>
					</tr>
					<tr>
						<td>
							<c:if test="${index==2 }">计划外演练</c:if>
							<c:if test="${index!=2 }">未完成</c:if>
						</td>
						<td>
							<c:if test="${rateMap['WCOUNT'] !=null}">${rateMap['WCOUNT'] }</c:if>
							<c:if test="${rateMap['WCOUNT'] ==null}">0</c:if>
						</td>
						<td>
							${rateMap['WRATE'] }
						</td>
					</tr>
					
				</logic:iterate>
				
			</logic:present>
		</table>
		</div>
		<div  style="width:480px;float: left;margin: 0px; margin-top:-25px; clear: none;">
			<div id = "pieChart" style="margin-left: 90px;" > 没有数据</div>
		</div>
		
	</fieldset>
</div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>

<script type="text/javascript">
jQ(function () {
	
	var dataObj = eval('${IGDRM18111VO.drillTypeRateList}');
	var sum = 0;
	for(var i=0;i<dataObj.length;i++){
		sum = sum + parseInt(dataObj[i].NUM);
	}
	var data = [];
	if(sum!=0){
	for(var i=0;i<dataObj.length;i++){
		data.push({name:dataObj[i].PIVARVALUE,y:(Number(dataObj[i].NUM)/sum).toFixed(2)*100});
	}
	}
	var chart =  jQ('#pieChart').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            height: 200,
            width: 400
        },
        title: {
            text: sum!=0?'演练形式':'饼状图无数据'
        },
        exporting: {
            enabled: false
        },
        credits: {
            enabled: false
        },
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            type: 'pie',
            name: '演练形式',
            data: data
        }]
    });
    
    
//     var chart =  jQ('#pieChart').highcharts();
//     if(chart&&!chart.hasData()) {  // Only if there is no data  
//         chart.hideNoData(); // Hide old message  
//         chart.showNoData("没有演练执行数据");  
//     }  
});
</script>
</html:html>
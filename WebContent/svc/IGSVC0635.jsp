<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List" %>
<%@ page import="com.deliverik.framework.user.model.Organization" %>
<%@ page import="com.deliverik.framework.workflow.prr.model.IG160Info" %>
<%@ page import="com.deliverik.infogovernor.svc.vo.IGSVC05131VO" %>
<html:html>
<bean:define id="id" value="IGSVC0635" toScope="request" />
<bean:define id="title" value="故障类型统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div style="width:1002px; margin:0 auto;">
<!--content  右侧内容-->
   <div id="contentWrap">
   <div id="content">
   <div id="location">
       <div class="image"></div>
        <p class="fonts1"><ig:navigation extname1="故障类型统计"/></p>
    </div>
	 <html:form styleId="form" action="/IGSVC0635.do" onsubmit="return checkSubmit(this);">
     <div id="search">
         <div class="img"></div>
          <div class="conditions">
       		<div>
       			<span>年：</span>
       			<html:select property="year" name="IGSVC0635Form">
       				<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false"/>
       			</html:select>
       			&nbsp;&nbsp;
       			<span>月：</span>
       			<html:select property="month" name="IGSVC0635Form">
       				<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false"/>
       			</html:select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       			<html:submit styleClass="button">查询</html:submit>
       		</div>
     	 </div>
    </div>
    <div>
   		<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
   	</div>
	</html:form>
</div>
</div>
</div>
</div>
</body>
<logic:present name="IGSVC06351VO" property="incidentType">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	var jQ = jQuery.noConflict(true);
</script>
<script src="js/Highcharts/highcharts.js"></script>
<script src="js/Highcharts/modules/exporting.js"></script>
   	<bean:define id="incidentType" name="IGSVC06351VO" property="incidentType"/>
   	<script type="text/javascript">
   	    var chart;
   	    
   	    jQ(document).ready(function () {
   	    	
   	    	// Build the chart
   	        jQ('#container').highcharts({
   	            chart: {
   	                plotBackgroundColor: null,
   	                plotBorderWidth: null,
   	                plotShadow: false
   	            },
   	            title: {
   	                text: '故障类型统计'
   	            },
   	            tooltip: {
   	        	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
   	            },
   	            plotOptions: {
   	                pie: {
   	                    allowPointSelect: true,
   	                    cursor: 'pointer',
   	                    dataLabels: {
   	                        enabled: false
   	                    },
   	                    showInLegend: true
   	                }
   	            },
   	          	exporting:{
        	   enabled:false
          	},
   	            series: [{
   	                type: 'pie',
   	                name: '占比',
   	                data: [
   	                    ['OA办公',${incidentType.oaWork}],
   	                    ['用户名或密码',${incidentType.userNameOrPassWord}],
   	                    ['物资管理',${incidentType.materialsManager}],
   	                    ['分诊导医',${incidentType.triageDaoYi}],
   	                    ['网络故障',${incidentType.netWorkMalfunction}],
   	                    ['病例丢失找回',${incidentType.casesOfLossBack}],
   	                    ['计算机协助',${incidentType.computerHelp}],
   	                    ['护士工作站',${incidentType.nurseWorkstation}],
   	                    ['监控告警',${incidentType.prossessingErrorAlarm}],
   	                ]
   	            }]
   	        });
   	    });
   	</script>
</logic:present>
</html:html>
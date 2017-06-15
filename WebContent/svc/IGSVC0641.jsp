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
<bean:define id="id" value="IGSVC0641" toScope="request" />
<bean:define id="title" value="部门服务年度趋势统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function setOrg(url){
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].orgid.value = "";
		document.forms[0].orgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].orgid.value = temp.split("|")[0];
		document.forms[0].orgname.value = temp.split("|")[1];
	}
}
</script>
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
        <p class="fonts1"><ig:navigation/></p>
    </div>
	 <html:form styleId="form" action="/IGSVC0641.do" onsubmit="return checkSubmit(this);">
     <div id="search">
         <div class="img"></div>
          <div class="conditions">
       		<div>
       			<span>年：</span>
       			<html:select property="year" name="IGSVC0640Form">
       				<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false"/>
       			</html:select>
       			<span>部门：</span>
       			<html:text property="orgname" readonly="true"></html:text>
       			<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" alt="请选择机构"/>
       			<html:hidden property="orgid"/>
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
<logic:present name="IGSVC06401VO" property="incidentnum">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	var jQ = jQuery.noConflict(true);
</script>
<script src="js/Highcharts/highcharts.js"></script>
<script src="js/Highcharts/modules/exporting.js"></script>
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
                text: '部门服务年度趋势统计'
	        },
	        tooltip: {
        	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            xAxis: {
                categories: ['一月', '二月', '三月', '四月', '五月', '六月',
                    '七月', '八月', '九月', '十月', '十一月', '十二月']
            },
            yAxis: {
                title: {
                    text: '数量'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: '°C'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: [{
                name: '故障',
                data: [${IGSVC06401VO.incidentnum}]
            }, {
                name: '服务请求',
                data: [${IGSVC06401VO.servicenum}]
            }, {
                name: '服务工单',
                data: [${IGSVC06401VO.sfnum}]
            }]
        });
    });
</script>
</logic:present>
</html:html>
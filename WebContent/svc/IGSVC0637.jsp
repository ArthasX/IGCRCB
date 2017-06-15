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
<bean:define id="id" value="IGSVC0637" toScope="request" />
<bean:define id="title" value="部门服务TOP5" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
<!--content  右侧内容-->
   <div id="contentWrap">
   <div id="content">
   <div id="location">
       <div class="image"></div>
        <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
    </div>
     <div id="search">
 <html:form styleId="form" action="/IGSVC0637" onsubmit="return checkSubmit(this);">
         <div class="img"></div>
          <div class="conditions">
      <div>
     	 <span>年：</span>
		<html:select property="year" name="IGSVC0637Form">
			<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false"/>
		</html:select>
		&nbsp;&nbsp;
		<span>月：</span>
		<html:select property="month" name="IGSVC0637Form">
			<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false"/>
		</html:select>&nbsp;&nbsp;
		<span>类型：</span>
		<html:select property="type">
			<html:option value="totalCount">&nbsp;</html:option>
			<html:option value="icount">故障</html:option>
			<html:option value="scount">请求</html:option>
			<html:option value="fcount">服务工单</html:option>
		</html:select>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<html:submit styleClass="button">查询</html:submit>
       </div>
      </div>
    </html:form>
    </div>
     <div id="results_list">
     <ig:message />
      	 <table  class="table_style">
      	 	<tr>
      	 		<th width="20%">部门</th>
      	 		<th width="20%">故障数量</th>
      	 		<th width="20%">请求数量</th>
      	 		<th width="20%">工单数量</th>
      	 		<th width="20%">总计</th>
      	 	</tr>
      	 	<logic:present name="IGSVC06371VO" property="serviceTopFiveList">
      	 		<logic:iterate id="bean" name="IGSVC06371VO" property="serviceTopFiveList">
      	 			<tr>
      	 				<td>${bean.orgname }</td>
      	 				<td>${bean.icount }</td>
      	 				<td>${bean.scount }</td>
      	 				<td>${bean.fcount }</td>
      	 				<td>${bean.totalCount }</td>
      	 			</tr>
      	 		</logic:iterate>
      	 	</logic:present>
      	 </table>
      	 
      	 <div id="charcontainer" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
     </div>
     <div id="operate">
	</div>
</div>
</div>
  </div>
</div>
</body>
<logic:present name="IGSVC06371VO" property="serviceTopFiveList">
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
   	        jQ('#charcontainer').highcharts({
   	            chart: {
   	                plotBackgroundColor: null,
   	                plotBorderWidth: null,
   	                plotShadow: false
   	            },
   	            title: {
   	                text: '部门服务top5'
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
					<logic:iterate id="bean" name="IGSVC06371VO" property="serviceTopFiveList">
						['${bean.orgname}',${bean.totalCount}],
					</logic:iterate>
   	                ]
   	            }]
   	        });
   	    });
   	</script>
</logic:present>
</html:html>
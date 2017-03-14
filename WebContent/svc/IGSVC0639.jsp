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
<bean:define id="id" value="IGSVC0639" toScope="request" />
<bean:define id="title" value="人员工作量排名" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	var jQ = jQuery.noConflict(true);
</script>
<script type="text/javascript" src="js/Highcharts/highcharts.src.js"></script>

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
 <html:form styleId="form" action="/IGSVC0639" onsubmit="return checkSubmit(this);">
         <div class="img"></div>
          <div class="conditions">
      <div>
     	 <span>年：</span>
		<html:select property="year" name="IGSVC0639Form">
			<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false"/>
		</html:select>
		&nbsp;&nbsp;
		<span>月：</span>
		<html:select property="month" name="IGSVC0639Form">
			<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false"/>
		</html:select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<html:submit styleClass="button">查询</html:submit>
       </div>
      </div>
    </html:form>
    </div>
        <div id="presonSummary">
        
        </div>
     
     <div id="operate">
	</div>
</div>
</div>
  </div>
</div>
</body>

<script type="text/javascript">
	
	var  preJson ='${IGSVC06391VO.presonsJson}';
	var  acountJson ='${IGSVC06391VO.acountJson}';
	
	jQ(function(){
		
		if(preJson&&acountJson){
			var preObj = eval("("+preJson+")");
			var acountObj = eval("("+acountJson+")");
			var sumseries = [];
			for(var k in acountObj){
				
				sumseries.push({name:k,data:acountObj[k]});
				
			}
		jQ('#presonSummary').highcharts({
	            chart: {
	                type: 'column'
	            },
	            title: {
	                text: '人员工作量排名'
	            },
	            
	            xAxis: {
	                categories: preObj
	            },
	            yAxis: {
	                min: 0,
	                title: {
	                    text: '数量（条） '
	                }
	            },
	            tooltip: {
	                headerFormat: '<span style="font-size:14px">{point.key}</span><table>',
	                pointFormat: '<tr><td style="color:{series.color};padding:0; width:60px;">{series.name}: </td>' +
	                   			 '<td style="padding:0"><b>{point.y}条 </b></td></tr>',
	                footerFormat: '</table>',
	                shared: true,
	                useHTML: true
	            },
	            plotOptions: {
	                column: {
	                    pointPadding: 0.2,
	                    borderWidth: 0
	                }
	            },
	            series: sumseries
	        });
		}
	});
</script>
</html:html>
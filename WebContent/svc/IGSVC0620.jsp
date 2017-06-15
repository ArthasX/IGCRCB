<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.svc.vo.IGSVC05131VO" %>
<%@ page import="com.deliverik.framework.workflow.prr.model.IG003Info" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<%
	IGSVC05131VO vo = (IGSVC05131VO)request.getAttribute("vo");
	List<IG003Info> processsummary = null;
	if(vo != null){
		processsummary = vo.getProcessSummaryList();
	}
%>
<html:html>
<bean:define id="id" value="IGSVC0620" toScope="request" />
<bean:define id="title" value="年度工作报告" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">

if (document.getElementById){ //DynamicDrive.com change
document.write('<style type="text/css">\n')
document.write('.submenu{display: none;}\n')
document.write('</style>\n')
}

function SwitchMenu(obj){
	if(document.getElementById){
	var el = document.getElementById(obj);
	var ar = document.getElementById("masterdiv").getElementsByTagName("span"); //DynamicDrive.com change
		if(el.style.display != "block"){ //DynamicDrive.com change
			for (var i=0; i<ar.length; i++){
				if (ar[i].className=="submenu") //DynamicDrive.com change
				ar[i].style.display = "none";
			}
			el.style.display = "block";
		}else{
			el.style.display = "none";
		}
	}
}

function exportExcel() {
	document.forms[0].action = getAppRootUrl() + "/IGSVC0611.do?report4=1";
	document.forms[0].submit();
}
function search() {
	document.forms[0].action = getAppRootUrl() + "/IGSVC0611.do";
	document.forms[0].submit();
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
   <div id="location">
       <div class="image"></div>
        <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
    </div>
     <div id="search">
     <html:form styleId="form" action="/IGSVC0611" onsubmit="return checkSubmit(this);">
         <div class="img"></div>
          <div class="conditions">
      <div>
        	<span>年份：</span><html:select property="currentyear">
            <ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false" isCodeLabel="true" />
            </html:select>
       <html:submit property="btn_search" styleClass="button" value="查询" onclick="search()"/>
       <html:submit property="btn_search" styleClass="button" value="导出"  onclick="exportExcel()"/>
       </div>
      </div>
    </html:form>
    </div>
        
     
     <div id="results_list"><ig:message />
       <table  class="table_style" id="caseListTable">
						
						<tr>
							<th rowspan="2" width="8%">月份</th>
							<th colspan="2" width="14%">事件</th>
							<th colspan="2" width="14%">问题</th>
							<th colspan="2" width="14%">变更</th>
							<th colspan="2" width="14%">工作</th>
							<th colspan="2" width="14%">月度汇总</th>
							<th rowspan="2" width="8%">同比幅度</th>
						</tr>
						<tr>
							
							<th width="7%">本期</th>
							<th width="7%">同期</th>
							<th width="7%">本期</th>
							<th width="7%">同期</th>
							<th width="7%">本期</th>
							<th width="7%">同期</th>
							<th width="7%">本期</th>
							<th width="7%">同期</th>
							<th width="7%">本期</th>
							<th width="7%">同期</th>
						</tr>
						
						<!-- body部 -->
                            <% 
                            if(null != processsummary){
                            	Integer currentIncidentTotal = 0;
                            	Integer precedingIncidentTotal = 0;
                            	Integer currentProblemTotal = 0;
                            	Integer precedingProblemTotal = 0;
                            	Integer currentChangeTotal = 0;
                            	Integer precedingChangeTotal = 0;
                            	Integer currentWorkTotal = 0;
                            	Integer precedingWorkTotal = 0;
                            	Integer currentTotal = 0;
                            	Integer precedingTotal = 0;
                            	
                            	for(int i=0;i<processsummary.size() ;i++){
                            		IG003Info processSummary = processsummary.get(i);
                            		Integer currentIncident = processSummary.getCurrentIncident();
                            		if(null != currentIncident){
                            			currentIncidentTotal += currentIncident;
                            		}
                            		Integer precedingIncident = processSummary.getPrecedingIncident();
                            		if(null != precedingIncident){
                            			precedingIncidentTotal += precedingIncident;
                            		}
                            		Integer currentProblem = processSummary.getCurrentProblem();
                            		if(null != currentProblem){
                            			currentProblemTotal += currentProblem;
                            		}
                            		Integer precedingProblem = processSummary.getPrecedingProblem();
                            		if(null != precedingProblem){
                            			precedingProblemTotal += precedingProblem;
                            		}
                            		Integer currentChange = processSummary.getCurrentChange();
                            		if(null != currentChange){
                            			currentChangeTotal += currentChange;
                            		}
                            		Integer precedingChange = processSummary.getPrecedingChange();
                            		if(null != precedingChange){
                            			precedingChangeTotal += precedingChange;
                            		}
                            		Integer currentWork = processSummary.getCurrentWork();
                            		if(null != currentWork){
                            			currentWorkTotal += currentWork;
                            		}
                            		Integer precedingWork = processSummary.getPrecedingWork();
                            		if(null != precedingWork){
                            			precedingWorkTotal += precedingWork;
                            		}
                            		Integer totalCurrent = processSummary.getTotalCurrent();
                            		
                            		if(null != totalCurrent){
                            			currentTotal += totalCurrent;
                            		}
                            		Integer totalPreceding = processSummary.getTotalPreceding();
                            		if(null != totalPreceding){
                            			precedingTotal += totalPreceding;
                            		}
                            		double range = 0;
                            		String result = "0";
                            		if(totalCurrent != null && totalPreceding != null && totalPreceding != 0){
                            			double dTotalCurrent = Double.valueOf(totalCurrent);
                            			double dTotalPreceding = Double.valueOf(totalPreceding);
                            			range = (dTotalCurrent - dTotalPreceding)/dTotalPreceding*100;
                            			DecimalFormat df1 = new DecimalFormat("##.##");//##.00%   百分比格式，后面不足2位的用0补齐    
	                     			    result = df1.format(range);
                            		}
                            		
                            %>
                            <tr>
								<td><%=	processSummary.getMonth() %></td>
								<td><%= currentIncident==null?"":currentIncident%></td>
								<td><%= precedingIncident==null?"":precedingIncident%></td>
								<td><%= currentProblem==null?"":currentProblem%></td>
								<td><%= precedingProblem==null?"":precedingProblem%></td>
								<td><%= currentChange==null?"":currentChange%></td>
								<td><%= precedingChange==null?"":precedingChange%></td>
								<td><%= currentWork==null?"":currentWork%></td>
								<td><%= precedingWork==null?"":precedingWork%></td>
								<td><font color="red"><%= totalCurrent==null?"":totalCurrent%></font></td>
								<td><font color="red"><%= totalPreceding==null?"":totalPreceding%></font></td>
								<td><%= range==0?"":result+"%"%></td>
							</tr>
								<%
									}
                            	
	                            	double totalRange = 0;
	                            	String result = "0";
	                        		if(currentTotal != 0 && precedingTotal != 0){
	                        			double dTotalCurrent = Double.valueOf(currentTotal);
	                        			double dTotalPreceding = Double.valueOf(precedingTotal);
	                        			totalRange = (dTotalCurrent - dTotalPreceding)/dTotalPreceding*100;
	                        			DecimalFormat df1 = new DecimalFormat("##.##");//##.00%   百分比格式，后面不足2位的用0补齐    
	                     			    result = df1.format(totalRange);  
	                        		}
								%>
                            	
                            <tr>
								<td>年份汇总</td>
								<td><font color="red"><%=currentIncidentTotal%></font></td>
								<td><font color="red"><%=precedingIncidentTotal %></font></td>
								<td><font color="red"><%=currentProblemTotal%></font></td>
								<td><font color="red"><%=precedingProblemTotal %></font></td>
								<td><font color="red"><%=currentChangeTotal %></font></td>
								<td><font color="red"><%=precedingChangeTotal %></font></td>
								<td><font color="red"><%=currentWorkTotal %></font></td>
								<td><font color="red"><%=precedingWorkTotal %></font></td>
								<td><font color="red"><%=currentTotal %></font></td>
								<td><font color="red"><%=precedingTotal %></font></td>
								<td><%=totalRange==0?"":result+"%" %></td>
							</tr>
                            	
                            <%}%>			
				
					</table>
					
     </div>
     
     <div id="operate">
	</div>

</div>
</div>
  </div>


</div>
</body>
</html:html>
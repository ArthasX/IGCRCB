<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%
	int a = 0;
	int b = 0;
	int c = 0;
	int d = 0;
	int e = 0;
	int f = 0;
%>
<html:html>
<bean:define id="id" value="IGSVC0625" toScope="request" />
<bean:define id="title" value="业务运行报告画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">

function checkForm(){

	if(!checkDate("propentime_from","propentime_to")){
		alert("查询开始时间不能晚于结束时间！");
		return false;
	}else{
		document.forms[0].action = getAppRootUrl() + "/IGSVC0625.do";
		document.forms[0].submit();	
	}
	
}
function exportExcel() {
	if(!checkDate("propentime_from","propentime_to")){
		alert("查询开始时间不能晚于结束时间！");
		return false;
	}else{
		document.forms[0].action = getAppRootUrl() + "/IGSVC0625.do?report=1";
		document.forms[0].submit();
	}
}

function showNewPage1(prassetid,type,from,to){

	openSubWindow('/IGSVC0625_Read.do?prassetid='+prassetid+'&type=003&prtype='+type+'&propentime_from='+from+'&propentime_to='+to+' 23:59&modes=1' ,"_blank","1000","600");
	
}
function showNewPage2(prassetid,type,from,to){

	openSubWindow('/IGSVC0625_Read1.do?prassetid='+prassetid+'&type=003&prtype='+type+'&propentime_from='+from+'&propentime_to='+to+' 23:59&modes=1' ,"_blank","1000","600");
	
}
function showNewPage3(prassetid,type,from,to){

	openSubWindow('/IGSVC0625_Read2.do?prassetid='+prassetid+'&type=003&prtype='+type+'&propentime_from='+from+'&propentime_to='+to+' 23:59&modes=1' ,"_blank","1000","600");
	
}

</script> 


<body style="background-color: white; background-image: none;" >
<div id="maincontent">
<div id="contentainer">

   <div id="location">
       <div class="image"></div>
        <p class="fonts1">业务运行报告</p>
    </div>
     <div id="search">
   <html:form styleId="form" action="/IGSVC0625" onsubmit="return checkSubmit(this);">
         <div class="img"></div>
          <div class="conditions">
      <div>
        <span>时间：从</span><span><html:text property="propentime_from" readonly="true" errorStyleClass="inputError imeActive"/></span>
   		<img src="images/date.gif" align="middle" onClick="calendar($('propentime_from'))" border="0"/>
       <span>&nbsp;&nbsp;到</span><span><html:text property="propentime_to" readonly="true" errorStyleClass="inputError imeActive"/></span>
         <img src="images/date.gif" align="middle" onClick="calendar($('propentime_to'))" border="0"/>
       <span>
       <html:hidden value="003" property="type"/>
       <html:button property="btn_search" styleClass="button" value="查询"  onclick="checkForm();"/> 
    <html:button property="btn_search1" styleClass="button" value="导出"  onclick="exportExcel()"/>
       </span> 
       </div>
      </div>
    </html:form>
    </div>
        
     
     <div id="results_list"><ig:message />
       <table  class="table_style" id="caseListTable">
						
						<tr>
							<th width="17%">业务名称</th>
							<th width="15%">事件</th>
							<th width="15%">问题</th>
							<th width="15%">变更</th>
							<th width="15%">发布</th>
							<th width="15%">工作</th>
							<th width="8%">汇总</th>
						</tr>
					
						
						<!-- body部 -->
                            <logic:present name="IGSVC05131VO" property="processCountList">
								<logic:iterate id="bean" name="IGSVC05131VO"
									property="processCountList" indexId="index">
									<tr class="<ig:rowcss index="${index}"/>">
										<td>
										<div class="nowrapDiv"> ${bean.prassetname}</div>
										</td>
										<td>
										<div class="nowrapDiv"> 
										<bean:define id="incident" name="bean" property="incident" />
										<% 
											int iIncident = Integer.valueOf(incident + "");
											a += iIncident;
											if(iIncident == 0){
												out.print("0");
											} else {
										%>
										<a href="javaScript:showNewPage1('${bean.prassetid}','I','<bean:write name="IGSVC0602Form" property="propentime_from"/>','<bean:write name="IGSVC0602Form" property="propentime_to"/>');"> ${bean.incident}</a>		
										<%
											}
										
										%>
										</div>
										</td>
										<td>
										<div class="nowrapDiv"> 
										<bean:define id="problem" name="bean" property="problem" />
										<% 
											int iproblem = Integer.valueOf(problem + "");
											b += iproblem;
											if(iproblem == 0){
												out.print("0");
											}else{
										%>	
										<a href="javaScript:showNewPage1('${bean.prassetid}','P','<bean:write name="IGSVC0602Form" property="propentime_from"/>','<bean:write name="IGSVC0602Form" property="propentime_to"/>');"> ${bean.problem}</a>	
										<%
											}
										%>
										</div>
										</td>
										<td>
										<div class="nowrapDiv"> 
										<bean:define id="change" name="bean" property="change" />
										<% 
											int ichange = Integer.valueOf(change + "");
											c += ichange;
											if(ichange == 0){
												out.print("0");
											}else{
										%>
										<a href="javaScript:showNewPage2('${bean.prassetid}','C','<bean:write name="IGSVC0602Form" property="propentime_from"/>','<bean:write name="IGSVC0602Form" property="propentime_to"/>');"> ${bean.change}</a>	
										<%
											}
										%>
										</div>
										</td>
										<td>
										<div class="nowrapDiv"> 
										<bean:define id="deployment" name="bean" property="deployment" />
										<% 
											int ideployment = Integer.valueOf(deployment + "");
											d += ideployment;
											if(ideployment == 0){
												out.print("0");
											}else{
										%>
										<a href="javaScript:showNewPage2('${bean.prassetid}','D','<bean:write name="IGSVC0602Form" property="propentime_from"/>','<bean:write name="IGSVC0602Form" property="propentime_to"/>');"> ${bean.deployment}</a>	
										<%
											}
										%>
										</div>
										</td>
										<td>
										<div class="nowrapDiv"> 
										<bean:define id="work" name="bean" property="work" />
										<% 
											int iwork = Integer.valueOf(work + "");
											e += iwork;
											if(iwork == 0){
												out.print("0");
											}else{
										%>
										<a href="javaScript:showNewPage3('${bean.prassetid}','W','<bean:write name="IGSVC0602Form" property="propentime_from"/>','<bean:write name="IGSVC0602Form" property="propentime_to"/>');"> ${bean.work}</a>	
										<%
											}
										%>
										</div>
										</td>
										<td>
										<span class="red">
										${bean.incident+bean.problem+bean.change+bean.deployment+bean.work}
										</span>
										<% f += Integer.valueOf(incident + "")+Integer.valueOf(problem + "")+Integer.valueOf(change + "")+Integer.valueOf(deployment + "")+Integer.valueOf(work + "");%>
										</td>
										
									</tr>
									
								</logic:iterate>
							</logic:present>
							
						<%if(request.getAttribute("message") != null){ 
							out.print(request.getAttribute("message"));
						}else if(f > 0){
						
						%>		
										
						<tr>
							<td width="17%"><strong>统计</strong></td>
							<td width="15%"><span class="red"><%= a %></span></td>
							<td width="15%"><span class="red"><%= b %></span></td>
							<td width="15%"><span class="red"><%= c %></span></td>
							<td width="15%"><span class="red"><%= d %></span></td>
							<td width="15%"><span class="red"><%= e %></span></td>
							<td width="8%"><span class="red"><%= f %></span></td>
						</tr>
						<%} %>
					</table>
					
     </div>
     
     <div id="operate">
	</div>

</div>


<div class="enter">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</div>
</body>
</html:html>
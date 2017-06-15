<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.fin.vo.IGFIN0303VO"%>
<%@ page import="com.deliverik.infogovernor.fin.form.IGFIN0312Form"%>
<%@ page import="java.text.DecimalFormat" %>
<%
	int a = 0;
	int b = 0;
	double c = 0d;
	double d = 0d;
	String bopentime = request.getParameter("bopentime");
	String bclosetime = request.getParameter("bclosetime");
	String type1 = request.getParameter("searchtype");
	IGFIN0312Form form = (IGFIN0312Form)request.getAttribute("0312form");
	IGFIN0303VO[] vos = (IGFIN0303VO[])request.getAttribute("vos");
	
	DecimalFormat nf = new DecimalFormat();
	nf.setMaximumFractionDigits(2);
	nf.setGroupingUsed(false);
%>
<html:html>
<bean:define id="id" value="IGFIN0307" toScope="request" />
<bean:define id="title" value="财务统计报告画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">

function PrintTable(Id){
    var mStr;
    mStr = window.document.body.innerHTML ;
    var mWindow = window;                
    window.document.body.innerHTML =Id.innerHTML; 
    mWindow.print();
    window.document.body.innerHTML = mStr;
}

function outputExcel(tableObject, offColInt) { 
	try { 
	var excelObjectApplication = new ActiveXObject("Excel.Application"); 
	} 
	catch (e) { 
	alert("\u6d4f\u89c8\u5668\u5f53\u524d\u8bbe\u7f6e\u4e0d\u5141\u8bb8\u6b64\u64cd\u4f5c\uff01"); 
	} 
	excelObjectApplication.visible = true; 
	excelObjectApplication.DisplayAlerts = false; 
	var xlBook = excelObjectApplication.Workbooks.Add; 
	var excelObjectActiveSheet = xlBook.Worksheets(1); 
	var rowLength = tableObject.rows.length; 
	var colLength = tableObject.rows[0].cells.length; 
	colLength -= parseInt(offColInt); 
	for (i = 0; i < rowLength - 1; i++) { 
	for (j = 0; j < colLength; j++) { 
	excelObjectActiveSheet.Cells(i + 1, j + 1).value = "'" + tableObject.rows[i].cells[j].innerText; 
	} 
	} 
	}
</script> 


<body style="background-color: white; background-image: none;" >
<div id="maincontent">
<div id="contentainer">

   <div id="location">
       <div class="image"></div>
        <p class="fonts1">财务统计报告</p>
    </div> 
     <div id="search">
    <html:form styleId="form" action="/IGFIN0307" onsubmit="return checkSubmit(this);">
     <div class="img"></div>
      <div class="conditions">
      <div>
        <span>查询方式：</span><html:select property="searchtype" style="width: 100px;">
            <html:option value="Y">按预算查询</html:option>
            <html:option value="F">按费用查询</html:option>
       </html:select>&nbsp;&nbsp;
        <span>时间：从</span><html:text property="bopentime" readonly="true" errorStyleClass="inputError imeDisabled"/>
   		<img src="images/date.gif" align="middle" onClick="calendar($('bopentime'))" border="0">&nbsp;&nbsp;
        <span>到</span><html:text property="bclosetime" readonly="true" errorStyleClass="inputError imeDisabled"/>
         <img src="images/date.gif" align="middle" onClick="calendar($('bclosetime'))" border="0"/>&nbsp;&nbsp;
      <br>
       <span>预算类型：</span><html:select property="btype" style="width: 100px;" errorStyleClass="inputError">
        <ig:optionsCollection ccid="BUDGET_TYPE_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true" />
       </html:select>
       <html:submit property="btn_search" styleClass="button" value="查询" />

       </div>
      </div>
      
     </html:form>
     </div>
     
       <div id="results_list"><ig:message />
       	<table  class="table_style">
       		<tr>
       			<th width="7%">序号</th>
				<th width="13%">预算类型</th>
				<th width="20%">预算个数</th>
				<th width="20%">预算金额</th>
				<th width="20%">支出个数</th>
				<th width="20%">支出金额</th>
       		</tr>
       		
       			<%
       			if(null != vos){
					for (int i = 0; i < vos.length; i++) {
						IGFIN0303VO vo = vos[i];
				%>
				<tr class="<ig:rowcss index="<%=i %>"/>">
	       			<td>
						<div class="nowrapDiv"><%=i + 1%></div>
					</td>
					<td>
						<div class="nowrapDiv">
						<ig:codeValue ccid="BUDGET_TYPE_CATEGORY_CODE" cid= "<%=vo.getBType()%>" isChild="true"/>
						</div>
					</td>
					<td>
						<div class="nowrapDiv">
						<% 
							int SumBudget = vo.getSumBudget();
							a += SumBudget;
							if(SumBudget == 0){
								out.print("0");
							} else {
						%>
						<a href="IGFIN0308.do?searchtype=<%=vo.getBType() %>&bopentime=<%=form.getBopentime()%>&bclosetime=<%=form.getBclosetime()%>&flg=B&type1=<%=form.getSearchtype()%>"><%=vo.getSumBudget()%></a>
						<%} %>
						</div>
					</td>
					<td>
						<div class="nowrapDiv">
						<% 
							double SumBMoney = vo.getSumBMoney();
							c += SumBMoney;
							if(SumBMoney == 0){
								out.print("0");
							} else {
						%>
						<%=nf.format(vo.getSumBMoney()) %>
						</div>
						<%} %>
					</td>
					<td>
						<div class="nowrapDiv">
						<% 
							int SumExpense = vo.getSumExpense();
							b += SumExpense;
							if(SumExpense == 0){
								out.print("0");
							} else {
						%>
						<a href="IGFIN0308.do?searchtype=<%=vo.getBType() %>&bopentime=<%=form.getBopentime()%>&bclosetime=<%=form.getBclosetime()%>&flg=E&type1=<%=form.getSearchtype()%>"><%=vo.getSumExpense()%></a>
						<%} %>
						</div>
					</td>
					<td>
						<div class="nowrapDiv">
						<% 
							double SumExMoney = vo.getSumExMoney();
							d += SumExMoney;
							if(SumExMoney == 0){
								out.print("0");
							} else {
						%>
						<%=nf.format(vo.getSumExMoney()) %>
						</div>
						<%} %>
					</td>
				</tr>
				<% 	
					}
       			}
       			%>
       			<%if(request.getAttribute("message") != null){ 
							out.print(request.getAttribute("message"));
						}else if(a+b > 0){
						
				%>	
       			<tr>
					<td colspan="2"><strong>统计</strong></td>
					<td><span class="red"><%=a %></span></td>
					<td><span class="red"><%=nf.format(c) %></span></td>
					<td><span class="red"><%=b %></span></td>
					<td><span class="red"><%=nf.format(d) %></span></td>
				</tr>
       			<%} %>
        </table>
       </div>
     </div>
     <div class="enter">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
    </div>

   
   
   

 </body>
</html:html>     



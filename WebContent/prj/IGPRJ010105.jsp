<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.*"%>
<%@ page import="com.deliverik.infogovernor.fin.vo.*"%>
<%@ page import="com.deliverik.infogovernor.fin.model.Budget"%>
<%@ page import="com.deliverik.infogovernor.fin.model.Expense"%>
<%
	IGFIN01012VO ifgin01012VO =  (IGFIN01012VO)request.getAttribute("ifgin01012VO");
	Map idListMap = ifgin01012VO.getBudgetIdExpenseListMap();
	Map idNameMap = ifgin01012VO.getBudgetIdNameMap();
	double sum = 0;
%>

<html:html>
<bean:define id="id" value="IGPRJ010105" toScope="request" />
<bean:define id="title" value="项目支出画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>

<body style="background-image: none;background-color: #FFFFFF;">

<!--container  内容-->

<div id="maincontent">    
<div id="location" style="margin-top:10px">
	<div class="image"></div>
	<p class="fonts1">查看 &gt;&gt; 项目支出</p>
	</div>

	<div id="results_list">
	<table class="table_style" >
		<tr>
           <th width="10%">预算名称</th>
           <th width="8%">费用编号</th>
           <th width="10%">费用名称</th>
           <th width="37%">费用说明</th>
           <th width="10%">开始时间</th>
           <th width="10%">结束时间</th>
           <th width="15%">费用金额</th>
         </tr>
         
       <%
    	if(idListMap != null){
    		Iterator i = idListMap.keySet().iterator();
    		int k = 0;
    		while(i.hasNext()){
    			List templist = (List)idListMap.get(i.next());
    			for(int j = 0; j < templist.size(); j++){
    				Expense expense = (Expense) templist.get(j);
    				int bid = expense.getBid();
    				String bname = (String)idNameMap.get(bid);
    				sum += expense.getExamount();
    	%>
    				
    	 <tr class="<ig:rowcss index="<%=k %>"/>">
           <td><%=bname %></td>
           <td><%=expense.getExid() %></td>
           <td><%=expense.getExapvname() %></td>
           <td><%=expense.getExdesc()==null?"" : expense.getExdesc() %></td>
           <td><%=expense.getExopentime() %></td>
           <td><%=expense.getExclosetime() %></td>
           <td><font color="red"><strong><%=expense.getExamount() %></strong></font></td>
         </tr>	   	
     
       <% 
       				k++;
    			}
    		}
    		if(sum > 0){
    			
    			%>
    			
    			<tr>
          			<td colspan="6" align="right"><strong><font color="red">该项目总共花费（元）：</font></strong></td>
          			<td><strong><font color="red"><%=sum %></font></strong></td>
        		</tr>	 
    			
    			<%
    			
    			
    		} else {
    			
    			%>
    			<tr>
          			<td colspan="7" align="center"><strong><font color="red">没有相关费用</font></strong></td>
        		</tr>
    			<%
    		}
    	}
    	%>

        </table>   
     </div>
     
	<div style="margin-top:50px;" align="center">
			<input type="button" class="button" value="关闭" onclick="window.close();">
		</div>
<div class="zishiying"></div>
</div>
</body>
</html:html>
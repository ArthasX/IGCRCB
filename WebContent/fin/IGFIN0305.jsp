<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.fin.vo.IGFIN0303VO"%>
<%@ page import="com.deliverik.infogovernor.fin.model.Expense"%>
<%@ page import="java.text.DecimalFormat" %>
<%
	IGFIN0303VO vo = (IGFIN0303VO)request.getAttribute("vo");
	List<Expense> expenseList = vo.getExpenseList();
	
	DecimalFormat nf = new DecimalFormat();
	nf.setMaximumFractionDigits(2);
	nf.setGroupingUsed(false);
%>
<html:html>
<bean:define id="id" value="IGFIN0305" toScope="request" />
<bean:define id="title" value="费用查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">

function opennewpage(exid){
	openSubWindow('/IGFIN0305_Disp.do?eid='+ exid,"newpage");
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
        <p class="fonts1">查看</p>
        <div class="back"><a href="IGFIN0303.do">返回</a></div>
    </div>
     
     <div id="results_list"><ig:message />
       <table  class="table_style">
						
						<tr>
							<th width="7%">序号</th>
							<th width="14%">预算名称</th>
							<th width="14%">费用名称</th>
							<th width="15%">费用金额</th>
							<th width="30%">说明</th>
							<th width="10%">发生时间</th>
							<th width="10%">登记时间</th>
							
						</tr>
						<!-- body部 -->
						<%
							for (int i = 0; i < expenseList.size(); i++) {
							Expense expense = expenseList.get(i);
						%>
   						<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="opennewpage('<%=expense.getExid()%>');">
   							<td><div class="nowrapDiv"><%=i+1%></div></td>
   							<td><div class="nowrapDiv"><%=expense.getBtitle() %></div></td>
   							<td><div class="nowrapDiv"><%=expense.getExapvname()%></div></td>
   							<td><div class="nowrapDiv">
   								<%=nf.format(expense.getExamount()) %>
   							</div></td>
   							<td><div class="nowrapDiv"><%=expense.getExdesc()==null?"":expense.getExdesc()%></div></td>
   							<td><div class="nowrapDiv"><%=expense.getExopentime()%></div></td>
   							<td><div class="nowrapDiv"><%=expense.getExclosetime()%></div></td>
   							
   						</tr>
   						<%} %>
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
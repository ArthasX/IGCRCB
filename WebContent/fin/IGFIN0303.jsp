<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.fin.vo.IGFIN0303VO"%>
<%@ page import="com.deliverik.infogovernor.fin.model.Budget"%>
<%@ page import="java.text.DecimalFormat" %>

<%
	IGFIN0303VO vo = (IGFIN0303VO)request.getAttribute("vo");
	List<Budget> budgetList = vo.getBudgetList();
	
	DecimalFormat nf = new DecimalFormat();
	nf.setMaximumFractionDigits(2);
	nf.setGroupingUsed(false);
%>
<html:html>
<bean:define id="id" value="IGFIN0303" toScope="request" />
<bean:define id="title" value="预算查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">

function opennewpage(bid){
	openSubWindow('/IGFIN0304_Disp.do?eid='+ bid,"newpage","980","");
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
							<th width="5%">序号</th>
							<th width="10%">类型</th>
							<th width="27%">预算名称</th>
							<th width="10%">预算金额</th>
							<th width="27%">项目名称</th>
							
							<th width="10%">起始时间</th>
							<th width="10%">结束时间</th>
							
						</tr>
						<!-- body部 -->
						<%
		       			if(null != vo){
							for (int i = 0; i < budgetList.size(); i++) {
							Budget budget = budgetList.get(i);
						%>
   						<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="opennewpage('<%=budget.getBid()%>');" >
   							<td><div class="nowrapDiv"><%=i+1%></div></td>
   							<td><div class="nowrapDiv"><ig:codeValue ccid="BUDGET_TYPE_CATEGORY_CODE" cid= "<%=budget.getBtype()%>" isChild="true"/></div></td>
   							<td><div class="nowrapDiv"><%=budget.getBtitle()%></div></td>
   							<td><div class="nowrapDiv">
   								<%=nf.format(budget.getBamount()) %>
   							</div></td>
   							<td><div class="nowrapDiv"><%=budget.getPname()==null?"":budget.getPname()%></div></td>
   							
   							<td><div class="nowrapDiv"><%=budget.getBopentime()%></div></td>
   							<td><div class="nowrapDiv"><%=budget.getBclosetime()%></div></td>
   							
   						</tr>
   						<%}} %>
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
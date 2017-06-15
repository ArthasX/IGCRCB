<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.IGPRJ0101VO"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.MilestoneInfoVO"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.MilestoneInfo"%>
<%@ page import="com.deliverik.infogovernor.prj.model.Project"%>
<%@ page import="com.deliverik.infogovernor.util.PRJHelper"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	String contextPath = request.getContextPath();
	IGPRJ0101VO igprj0101VO = (IGPRJ0101VO)request.getAttribute("igprj0101VO");
	Project project = null;
	if(igprj0101VO != null){
		project = igprj0101VO.getProject();
	}
	int projectId = project.getPid();
	MilestoneInfoVO milestoneInfoVO = (MilestoneInfoVO)request.getAttribute("milestoneInfoVO");
	List<MilestoneInfo> milestoneInfoList = milestoneInfoVO.getMilestoneInfoList();
	String prjOpenTime = project.getPopentime();
	String prjCloseTime = project.getPclosetime();
	Map<String,String> logMap = milestoneInfoVO.getProjectLogMap();
	int iProjectBeginYear = Integer.valueOf(prjOpenTime.split("/")[0]);
	int iProjectBeginMonth = Integer.valueOf(prjOpenTime.split("/")[1]);
	int iProjectEndYear = Integer.valueOf(prjCloseTime.split("/")[0]);
	int iProjectEndMonth = Integer.valueOf(prjCloseTime.split("/")[1]);
	Date todayDate = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	String today = sdf.format(todayDate);
%>
<script type="text/javascript">
	function openPage(projectId,milestoneIndex){
		window.open("IGPRJ0101_Detail_View.do?projectId=" + projectId + "&milestoneIndex=" + milestoneIndex,"_blank");
	}
</script>
<html:html>
<bean:define id="id" value="IGPRJ010110" toScope="request" />
<bean:define id="title" value="项目监控" toScope="request" />
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
	<p class="fonts1">查看 &gt;&gt; 状态监控</p>
	<div class="back"><a href="#" target="_self" onclick="window.location='IGPRJ0101_Detail.do?pid=<%=project.getPid() %>';">返回</a></div>
	</div>
     <div class="title">
	<div class="name">项目信息</div>
	</div>

	<div class="record_list">
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%" align="right">使用预算：</th>
			<td width="35%"><ig:codeValue ccid="Project_ISUSEBUDGET" cid="${igprj0101VO.form.isUseBudget}" /></td>
			<th width="15%" align="right">项目状态：</th>
			<td width="35%"><ig:codeValue ccid="PROJECT_STATUS_CODE" cid="${igprj0101VO.form.pstatus}" /></td>
		</tr>

		<tr>
		  <th width="15%" align="right">项目名称：</th>
		  <td >${igprj0101VO.form.pname}</td>
		  <th width="15%" align="right">项目金额：</th>
		  <td width="35%"><bean:write name="igprj0101VO" property="form.plimit" format="##.##"></bean:write></td>
		</tr>	
		
		<tr>
		  <th align="right">项目编号：</th>
		  <td><pre>${igprj0101VO.form.pcode}</pre></td>
		  <th align="right">计划结束时间：</th>
			<td><%=project.getPplanclosetime() %></td>
		</tr>
		
		<tr>
			<th align="right">开始时间：</th>
			<td><%=project.getPopentime() %></td>
			<th align="right">实际结束时间：</th>
			<td><%=project.getPclosetime() %></td>
		</tr>
		
		<tr>
		    <th align="right">需求部门：</th>
			<td colspan="3"><ig:codeValue ccid="Project_NEEDBRANCH" cid="<%=project.getPbranch()%>" /></td>
		</tr>

		<tr>
		  <th align="right">项目简介：</th>
		  <td colspan="3"><pre><%=project.getPdesc()==null?"":project.getPdesc() %></pre></td>
		</tr>
		
		<tr>
			<th align="right">项目目的：</th>
			<td colspan="3"><%=project.getPaim()==null?"":project.getPaim() %></td>
		</tr>
		 <tr>
		  <th align="right">项目用途：</th>
		  <td colspan="3"><%=project.getPpurpose()==null?"":project.getPpurpose() %></td>
		 </tr>
	</table>
	</div>
	
	 <div class="title">
	<div class="name">项目状态</div>
	</div>
	<div id="formwrapper">
     <table width="760" height="14" border="0" cellspacing="2" cellpadding="0">
 		 <tr>
		    <td width="100" height="15"><div align="center">状态说明</div></td>
		    <td><img alt="" src="images/prj4.gif" /></td>
		    <td width="120">开始日期</td>
		    <td> <img alt="" src="images/prj2.gif" /></td>
		    <td width="170">已完成且按时(提前)完成</td>
		   <td> <img alt="" src="images/prj1.gif" /></td>
		    <td width="150">已完成但滞后完成</td>
		  <td> <img alt="" src="images/prj3.gif" /></td>
		    <td width="140">到期未完成</td>
  		</tr>
  		<tr>
    		<td colspan="9">&nbsp;</td>
    	</tr>
	</table>
 
 <%
 int milestoneIndex = 0;
 int milestoneIndexForColor = 0;
 for(int iYear = iProjectBeginYear; iYear <= iProjectEndYear; iYear++){
	 if(iYear != iProjectBeginYear){
		 iProjectBeginMonth = 1;
	 }
	 for(int iMonth = iProjectBeginMonth; iMonth <= 12; iMonth++){
		 if(iYear == iProjectEndYear && iMonth > iProjectEndMonth){
			 break;
		 }
		 out.println("<table border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"1\" class=\"flag\"><tr>");
		 for(int iDay = 0; iDay <= 31; iDay++){
			 if(0 == iDay){
				 out.println("<td class=\"flag_td1\">&nbsp;</td>");
				 continue;
			 }
			 if(2 == iMonth){   //判断闰年
				 if(29 == iDay && !PRJHelper.isLeapYear(iYear)){
					 out.println("<td class=\"flag_td2\">&nbsp;</td>");
					 out.println("<td class=\"flag_td2\">&nbsp;</td>");
					 out.println("<td class=\"flag_td2\">&nbsp;</td>");
					 break;
				 } else if (30 == iDay) {
					 out.println("<td class=\"flag_td2\">&nbsp;</td>");
					 out.println("<td class=\"flag_td2\">&nbsp;</td>");
					 break;
				 }
			 }
			 if(4 == iMonth || 6 == iMonth || 9 == iMonth || 11 == iMonth){
				 if(31 == iDay){
					 out.println("<td class=\"flag_td2\">&nbsp;</td>");
					 break;
				 }
			 }
			 String currentDate = iYear + "/" + PRJHelper.creatDateStr(iMonth,iDay);
			 if(milestoneInfoList.size() > milestoneIndex && milestoneInfoList.get(milestoneIndex).getMsPlanDate().equals(currentDate)){
				 milestoneIndex++;
				 out.println("<td class=\"flag_td2\" onclick=\"openPage(" + projectId + "," + milestoneIndex + ");\"><a href=\"#\">" + 
				 "<img src=\"" + contextPath + "/images/look.gif\" alt=\"查看详细信息\" width=\"16\" height=\"16\" border=\"0\"/></a></td>");
			 } else {
				 out.println("<td class=\"flag_td2\">&nbsp;</td>");
			 }
		 }
		 out.println("</tr></table>");
		 out.println("<table border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"1\" class=\"milestone_table\"><tr>");
		 for(int iDay = 0; iDay <= 31; iDay++){
			 if(0 == iDay){
				 out.println("<td class=\"month\">" + iMonth + "月份</td>");
				 continue;
			 }
			 if(2 == iMonth){   //判断闰年
				 if(29 == iDay && !PRJHelper.isLeapYear(iYear)){
					 out.println("<td class=\"day\">&nbsp;</td>");
					 out.println("<td class=\"day\">&nbsp;</td>");
					 out.println("<td class=\"day\">&nbsp;</td>");
					 break;
				 } else if (30 == iDay) {
					 out.println("<td class=\"day\">&nbsp;</td>");
					 out.println("<td class=\"day\">&nbsp;</td>");
					 break;
				 }
			 }
			 if(4 == iMonth || 6 == iMonth || 9 == iMonth || 11 == iMonth){
				 if(31 == iDay){
					 out.println("<td class=\"day\"></td>");
					 break;
				 }
			 }
			 String currentDate = iYear + "/" + PRJHelper.creatDateStr(iMonth,iDay);
			 String todayStyle = "";
			 if(currentDate.equals(today)){
				 todayStyle = "style=\"background-image:url(images/today.gif); background-repeat:no-repeat;background-position:center;\"";
			 }
			 if(milestoneInfoList.size() > milestoneIndexForColor && milestoneInfoList.get(milestoneIndexForColor).getMsPlanDate().equals(currentDate)){
				 String url = "IGPRJ0101_DIM_History.do?backurl=plan&pltime_from=2012/04/26&pltime_to="+currentDate+"&pid="+project.getPid();
				 if(logMap.get(currentDate)!=null){
					 out.println("<td class=\"" +  milestoneInfoList.get(milestoneIndexForColor).getMsColor() + "\"" + todayStyle + "><a href="+url+">" + iDay + "</a></td>");
				 }else{
					 out.println("<td class=\"" +  milestoneInfoList.get(milestoneIndexForColor).getMsColor() + "\"" + todayStyle + ">" + iDay + "</td>");
				 }
				 milestoneIndexForColor++;
			 } else {
				 String url = "IGPRJ0101_DIM_History.do?backurl=plan&pltime_from="+currentDate+"&pltime_to="+currentDate+"&pid="+project.getPid();
				 if(logMap.get(currentDate)!=null){
					 out.println("<td class=\"day\"" + todayStyle + "><a href="+url+">" + iDay + "</a></td>");
				 }else{
					 out.println("<td class=\"day\"" + todayStyle + ">" + iDay + "</td>");
				 }
			 }
		 }
		 out.println("</tr></table>");
	 }
 }
 
 %>

  </div>
  <div class="enter" style="margin-top:30px;">
   <input type="button" value="返回" class="button" onclick="window.location='IGPRJ0101_Detail.do?pid=<%=project.getPid() %>';">
   </div>
 </div>   
</div>
</div>



</div>
</body>
</html:html>
<%@page import="java.text.Format"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.IGPRJ0101VO"%>
<%@ page import="com.deliverik.infogovernor.prj.form.IGPRJ0102Form"%>
<%@ page import="com.deliverik.infogovernor.prj.model.ProjectLog"%>
<%@ page import="com.deliverik.infogovernor.prj.bl.IGPRJ01BLType"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.MilestoneInfoVO"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.MilestoneInfo"%>
<%@ page import="com.deliverik.infogovernor.prj.model.Project"%>
<%@ page import="com.deliverik.infogovernor.util.PRJHelper"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.text.SimpleDateFormat"%>
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
	function openPage1(projectId,milestoneIndex){
		window.open("IGPRJ0101_Detail_View.do?projectId=" + projectId + "&milestoneIndex=" + milestoneIndex,"_blank");
	}
	var gid='IGPRJ0403_Detail';
	function goPage(url){
		document.forms[0].action=url;
		document.forms[0].submit();
	}
	function openPage(){
		openSubWindow("/IGPRJ0101_Detail_History.do?pid=${igprj0101VO.project.pid}","_blank",'1000','600');
	}
	function openFINPage(){
		openSubWindow("/IGPRJ0101_Detail_findFIN.do?pcode=${igprj0101VO.project.pid}" ,"_blank",'1000','600');
	}
	function openSVCPage(){
		openSubWindow("/IGSVC0100.do?pcode=${igprj0101VO.project.pid}","_blank",'1000','600');
	}
</script>
<html:html>
<bean:define id="id" value="IGPRJ010111" toScope="request" />
<bean:define id="title" value="项目详细信息" toScope="request" />
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
			<p class="fonts1">查看</p>
			<div class="back"><a href="IGPRJ0101_BACK.do" target="_self">返回</a></div>
		</div>
		<div class="title" style="cursor: hand;">
			<div class="name" onclick="toggleElement('baseMessage','baseMessageImg')">基本信息<img id="baseMessageImg" src="images/add_1.jpg"></div>
		</div>

		<div class="record_list" id="baseMessage" style="display: none">
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
				  <td width="35%"><bean:write name="igprj0101VO" property="form.plimit" format="##.##"></bean:write>(万元)</td>
				</tr>
				
				<tr>
				  <th align="right">项目编号：</th>
				  <td><pre>${igprj0101VO.form.pcode}</pre></td>
				  <th align="right">计划结束时间：</th>
					<td>${igprj0101VO.form.pplanclosetime}</td>
				</tr>
				
				<tr>
					<th align="right">开始时间：</th>
					<td>${igprj0101VO.form.popentime}</td>
					<th align="right">实际结束时间：</th>
					<td>${igprj0101VO.form.pclosetime}</td>
				</tr>
				
				<tr>
					<th align="right">需求部门：</th>
					<td colspan="3"><ig:codeValue ccid="Project_NEEDBRANCH" cid="${igprj0101VO.form.pbranch}" /></td>
				</tr>
		
				<tr>
				  <th align="right">项目简介：</th>
				  <td colspan="3"><pre>${igprj0101VO.form.pdesc}</pre></td>
				</tr>
				
				<tr>
					<th align="right">项目目的：</th>
					<td colspan="3">${igprj0101VO.form.paim}</td>
				</tr>
				<tr>
				  	<th align="right">项目用途：</th>
				  	<td colspan="3"><pre>${igprj0101VO.form.ppurpose}</pre></td>
				</tr>
		</table>
	</div>

	<div class="record_list" >
	    <logic:present name="igprj0101VO" property="actionnameList">
			<logic:iterate id="but" name="igprj0101VO" property="actionnameList">
				<logic:equal name="but" value="<%=IGPRJ01BLType.PROJECT_ACTION_TZJH%>">
					<div class="action">
						<img src="images/plan.gif" width="11" height="11"  border="0" />
						<a href="IGPRJ0101_Detail.do?pid=${igprj0101VO.project.pid}&type=adjustProjectPlan&popentime=${igprj0101VO.form.popentime}&pclosetime=${igprj0101VO.form.pclosetime}">项目计划</a>
					</div>
				</logic:equal>
				
				<logic:equal name="but" value="<%=IGPRJ01BLType.PROJECT_ACTION_XMJZ%>">
					<div class="action">
			             <img src="images/progress.gif" width="11" height="11"  border="0" />
			             <a href="IGPRJ0101_Detail.do?pid=${igprj0101VO.project.pid}&type=confirmMilestone">项目进展</a>
					</div>
				</logic:equal>
				<!-- 
				<logic:equal name="but" value="<%=IGPRJ01BLType.PROJECT_ACTION_ZTJK%>">
					<div class="action">
						<img src="images/gif-0468.gif" width="11" height="11" border="0"  />
						<a href="IGPRJ0101_Detail.do?pid=${igprj0101VO.project.pid}&type=viewProjectPlan">状态监控</a>
					</div>
				</logic:equal>
		 		-->
				<logic:equal name="but" value="<%=IGPRJ01BLType.PROJECT_ACTION_XMRZ%>">
					<div class="action">
						<img src="images/comments.gif" width="11" height="11" />
						<a href="IGPRJ0101_Detail.do?pid=${igprj0101VO.project.pid}&type=assess" >项目日志</a>      
					</div>
				</logic:equal>
				
				<logic:equal name="but" value="<%=IGPRJ01BLType.PROJECT_ACTION_XMGB%>">
					<div class="action">
						<img src="images/delete_16x16.gif" width="11" height="11" />
						<a href="IGPRJ0101_Detail.do?pid=${igprj0101VO.project.pid}&type=close" >项目关闭</a>       
					</div>
				</logic:equal>
				
				<logic:equal name="but" value="<%=IGPRJ01BLType.PROJECT_ACTION_CKLS%>">
					<div class="action">
			             <img src="images/look_h.gif" width="11" height="11" />
			             <a href="IGPRJ0101_Detail_History.do?pid=${igprj0101VO.project.pid}">查看历史</a> 
			        </div> 
		        </logic:equal>
		        
		        <logic:equal name="but" value="<%=IGPRJ01BLType.PROJECT_ACTION_FZR%>">
					<div class="action">
			             <img src="images/xmshr.gif" width="11" height="11" />
			             <a href="IGPRJ0104_Disp.do?pid=${igprj0101VO.project.pid}">负责人</a>       
				    </div>
			    </logic:equal>
			    
			    <logic:equal name="but" value="<%=IGPRJ01BLType.PROJECT_ACTION_CYR%>">
					<div class="action">
			             <img src="images/xmclr.gif" width="11" height="11" />
			             <a href="IGPRJ0107_Disp.do?pid=${igprj0101VO.project.pid}">参与人</a>       
					</div>
				</logic:equal>
			</logic:iterate>
		</logic:present>
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
		    <td><img alt="" src="images/prj2.gif" /></td>
		    <td width="170">已完成且按时(提前)完成</td>
			<td><img alt="" src="images/prj1.gif" /></td>
		    <td width="150">已完成但滞后完成</td>
			<td><img alt="" src="images/prj3.gif" /></td>
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
					}else if(30 == iDay){
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
					out.println("<td class=\"flag_td2\" onclick=\"openPage1(" + projectId + "," + milestoneIndex + ");\"><a href=\"#\">" + 
					"<img src=\"" + contextPath + "/images/look.gif\" alt=\"查看详细信息\" width=\"16\" height=\"16\" border=\"0\"/></a></td>");
				}else{
					out.println("<td class=\"flag_td2\">&nbsp;</td>");
				}
			}
			out.println("</tr></table>");
			out.println("<table border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"1\" class=\"milestone_table\"><tr>");
			for(int iDay = 0; iDay <= 31; iDay++){
				String plandate = igprj0101VO.getForm().getPplanclosetime();
				String currentDate = iYear + "/" + PRJHelper.creatDateStr(iMonth,iDay);
				if(plandate==null){
					plandate = currentDate;
				}
				Date pdate = new SimpleDateFormat("yyyy/MM/dd").parse(plandate.trim());
				Date cdate = new SimpleDateFormat("yyyy/MM/dd").parse(currentDate);
				
				if(0 == iDay){
					out.println("<td class=\"month\">" + iMonth + "月份</td>");
					continue;
				}
				if(2 == iMonth){   //判断闰年
					if(29 == iDay && !PRJHelper.isLeapYear(iYear)){
						if(cdate.after(pdate)){
							out.println("<td class=\"delayday\">&nbsp;</td>");
							out.println("<td class=\"delayday\">&nbsp;</td>");
							out.println("<td class=\"delayday\">&nbsp;</td>");
						}else{
							out.println("<td class=\"day\">&nbsp;</td>");
							out.println("<td class=\"day\">&nbsp;</td>");
							out.println("<td class=\"day\">&nbsp;</td>");
						}
						break;
					}else if(30 == iDay){
						if(cdate.after(pdate)){
							out.println("<td class=\"delayday\">&nbsp;</td>");
							out.println("<td class=\"delayday\">&nbsp;</td>");
						}else{
							out.println("<td class=\"day\">&nbsp;</td>");
							out.println("<td class=\"day\">&nbsp;</td>");
						}
						break;
					}
				}
				if(4 == iMonth || 6 == iMonth || 9 == iMonth || 11 == iMonth){
					if(31 == iDay){
						if(cdate.after(pdate)){
							out.println("<td class=\"delayday\">&nbsp;</td>");
						}else{
							out.println("<td class=\"day\">&nbsp;</td>");
						}
						break;
					}
				}

				String todayStyle = "";
				if(currentDate.equals(today)){
					todayStyle = "style=\"background-image:url(images/today.gif); background-repeat:no-repeat;background-position:center;\"";
				}
				if(milestoneInfoList.size() > milestoneIndexForColor && milestoneInfoList.get(milestoneIndexForColor).getMsPlanDate().equals(currentDate)){
					String url = "IGPRJ0101_DIM_History.do?backurl=plan&pltime_from="+currentDate+"&pltime_to="+currentDate+"&pid="+project.getPid();
					if(logMap.get(currentDate)!=null){
						out.println("<td class=\"" +  milestoneInfoList.get(milestoneIndexForColor).getMsColor() + "\"" + todayStyle + "><a href="+url+">" + iDay + "</a></td>");
					}else{
						out.println("<td class=\"" +  milestoneInfoList.get(milestoneIndexForColor).getMsColor() + "\"" + todayStyle + ">" + iDay + "</td>");
					}
					milestoneIndexForColor++;
				}else{
					String url = "IGPRJ0101_DIM_History.do?backurl=plan&pltime_from="+currentDate+"&pltime_to="+currentDate+"&pid="+project.getPid();
					if(logMap.get(currentDate)!=null){
						out.println("<td class=\"day\"" + todayStyle + "><a href="+url+"><strong>" + iDay + "</strong></a></td>");
					}else if(cdate.after(pdate)){
						out.println("<td class=\"delayday\">" + iDay + "</td>");
					}else{
						out.println("<td class=\"day\"" + todayStyle + ">" + iDay +"</td>");
					}
				}
			}
			out.println("</tr></table>");
		}
	}
%>
	</div>
   </div>
</div>   
</div>
</div>
</body>
</html:html>
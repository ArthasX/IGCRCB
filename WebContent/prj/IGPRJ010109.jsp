<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.IGPRJ0101VO"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.MilestoneInfoVO"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.MilestoneInfo"%>
<%@ page import="com.deliverik.infogovernor.prj.model.ProjectPlan"%>
<%@ page import="com.deliverik.infogovernor.prj.model.ProjectLog"%>
<%@ page import="com.deliverik.infogovernor.prj.model.Project"%>
<%@ page import="com.deliverik.infogovernor.prj.model.ProjectLog"%>
<%
	int index = Integer.valueOf(request.getParameter("milestoneIndex"));
	String contextPath = request.getContextPath();

	MilestoneInfoVO milestoneInfoVO = (MilestoneInfoVO) request.getAttribute("milestoneInfoVO");
	
	List<MilestoneInfo> milestoneInfoList = null;
	if(null != milestoneInfoVO){
		milestoneInfoList = milestoneInfoVO.getMilestoneInfoList();
	}
	MilestoneInfo milestoneInfo = milestoneInfoList.get(index-1);
%>
<html:html>
<bean:define id="id" value="IGPRJ010109" toScope="request" />
<bean:define id="title" value="查看" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">
function setParentValue(bid,btitle){
     window.close();
}
</script>
<body style="background-color: #FFFFFF; background-image: none;">
<div id="maincontent">
<div id="container">
  <html:form styleId="form" action="/IGPRJ0101" onsubmit="return checkSubmit(this);">
  <table>
  <tr>
  <td height="60"></td>
  </tr>
  </table>
<table width="50%" border="0" align="center"  cellpadding="0" cellspacing="5">
  <tr>
    <td width="26%" align="right" valign="middle">
    <% 
       	if(milestoneInfo.getMsConfirmDate()==null||"".equals(milestoneInfo.getMsConfirmDate())){
    %>
    <img src="images/exception.gif" border="0" />
	<% 
       	}else{
    %>
	<img src="images/Round_Icon_09.gif" border="0" />
	<%
       	}
    %></td>
    <td width="74%" align="left" valign="middle"><% 
       			if(milestoneInfo.getMsConfirmDate()==null||"".equals(milestoneInfo.getMsConfirmDate())){
       		%>
       		<h3>该里程碑尚未完成!</h3>
       		<% 
       		}else{
       		%>
       		<h3><font color="green">该里程碑已经完成!</font></h3>
       		<%
       			}
       		%>
   </td>
  </tr>
  <tr>
    <td align="right" valign="top"><strong>项目里程碑</strong>：</td>
    <td align="left"><pre><%= milestoneInfo.getMsName()%></pre></td>
  </tr>
  <tr>
    <td align="right" valign="top"><strong>里程碑描述</strong>：</td>
    <td align="left">
    <%
	      		String milestoneDesc = milestoneInfo.getMsplanDesc();
	      		if(milestoneDesc==null){
	      			milestoneDesc = "";
	      		}
	      	%>
	      	<span >
	      		<div style="width: 500px;">
	      		<pre><%=milestoneDesc %></pre>
	      		</div>
	      	</span>
	 </td>
  </tr>
  <tr>
    <td align="right" valign="top"><strong>开始时间</strong>：</td>
    <td align="left"><%= milestoneInfo.getMsPlanDate()%></td>
  </tr>
  <tr>
    <td align="right" valign="top"><strong>预计结束时间</strong>：</td>
    <td align="left"><%= milestoneInfo.getMsCloseDate()%></td>
  </tr>
  <tr>
    <td align="right" valign="top"><strong>实际结束时间</strong>：</td>
    <td align="left">
    <font color="red">
	      <% 
	      if(milestoneInfo.getMsConfirmDate()==null||"".equals(milestoneInfo.getMsConfirmDate())){}else{
	      %>
	      <%= milestoneInfo.getMsConfirmDate()%>
	      <%}%>
	      </font></td>
  </tr>
  <tr>
    <td align="right" valign="top"><strong>结束说明</strong>：</td>
    <td align="left">
     <%
	      		String msConfirmDesc = milestoneInfo.getMsConfirmDesc();
	      		if(msConfirmDesc==null){
	      			msConfirmDesc = "";
	      		}
	      %>
	      <span title="<%=msConfirmDesc.length()>20?msConfirmDesc:"" %>">
	      	<pre><%=msConfirmDesc.length()>20?msConfirmDesc.substring(0,17) + "...":msConfirmDesc %></pre>	
	      </span></td>
  </tr>
  <tr>
  <td align="right" valign="top"><strong>附件信息</strong>：</td>
  <td align="left">

	<%
	if(milestoneInfo.getAttachmentList()!=null&&milestoneInfo.getAttachmentList().size()>0){
	request.setAttribute("milestoneInfo", milestoneInfo);
	%>
	<bean:define id="attachmentList" name="milestoneInfo" property="attachmentList" />
		<table>
		<logic:iterate id="attachment" name="attachmentList" indexId="number">
		<tr>
			<td>
			<html:link action="downloadSvcFile.do?attId=${attachment.attid}&type=svc" styleId="${attachment.attid}">
			<bean:define id="attname" name="attachment" property="attname" />
			<%=String.valueOf(attname).substring(String.valueOf(attname).indexOf("_")+1)  %>
			</html:link>
			<br>					  
			</td></tr>
		</logic:iterate>
		</table>
	<%
	}
	%>
			
  </td>

  </tr>
  			
			
  <tr>
    <td>&nbsp;</td>
    <td align="left"><input type="button" name="button" id="button" title="确定" Class="button" value="确定" onclick="window.close();"/></td>
  </tr>
</table>
</html:form>
 </div>
 </div>  
 </body>
</html:html>
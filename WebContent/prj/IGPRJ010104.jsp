<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	String contextPath = request.getContextPath();
	IGPRJ0101VO igprj0101VO = (IGPRJ0101VO)request.getAttribute("igprj0101VO");
	Project project = null;
	if(igprj0101VO != null){
		project = igprj0101VO.getProject();
	}
	MilestoneInfoVO milestoneInfoVO = (MilestoneInfoVO) request.getAttribute("milestoneInfoVO");
	ProjectPlan projectPlan = null;
	List<MilestoneInfo> milestoneInfoList = null;
	if(null != milestoneInfoVO){
		milestoneInfoList = milestoneInfoVO.getMilestoneInfoList();
		projectPlan = milestoneInfoVO.getProjectPlan();
	}
%>
<html:html>
<bean:define id="id" value="IGPRJ010104" toScope="request" />
<bean:define id="title" value="项目进展" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function addPlan(pplstatusDisp) {
	document.forms[0].action =  getAppRootUrl() + "/IGPRJ0101_Detail.do?type=confirmMilestone&pid=<%=projectPlan.getPid() %>&pplstatusDisp="+pplstatusDisp;
	document.forms[0].submit();
}

function checkPPTime(flag) {

	var message='';
	if(flag==1){
		message='请确认是否提交项目进展?';
		document.forms[0].action='IGPRJ0101_Detail_ConfirmMilestone.do';
	}else{
		message='请确认是否更改项目进展?';
		document.forms[0].action='IGPRJ0101_Detail_UpdateMilestone.do';
	}
	
	if(document.getElementById("pplshuttime").value==""){
		alert("请填写实际结束时间！");
		return false;
	}
	if(document.getElementById("pplshuttime").value<"${igprj0101VO.form.popentime}".trim()){
		alert("实际结束时间不能早于项目开始时间！");
		return false;
	}
	if(document.getElementById("ppldesc").value.strlen()>1024){
		alert("描述不能大于340个汉字！");
		return false;
	}
	if(confirm(message)){
		return true;
	}
	return false;
	
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
	<p class="fonts1">查看 &gt;&gt; 项目进展</p>
	<div class="back"><a href="#" target="_self" onclick="window.location='IGPRJ0101_Detail.do?pid=<%=projectPlan.getPid() %>';">返回</a></div>
	</div>
	<div class="title">
	<div class="name">基本信息</div>
	</div>

	<div class="record_list">
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%" align="right">使用预算：</th>
			<td width="35%"><ig:codeValue ccid="Project_ISUSEBUDGET" cid="${igprj0101VO.form.isUseBudget}" /></td>
			<th width="15%" align="right">项目状态：</th>
			<td width="35%"><ig:codeValue ccid="PROJECT_STATUS_CODE" cid="${igprj0101VO.form.pstatus}" /></td>
		</tr>

		<c:if test="${igprj0101VO.form.isUseBudget == '0001'}">
		<tr>
			<th width="15%" align="right">预算名称：</th>
			<td width="35%">${igprj0101VO.form.pbname}</td>
			<th width="15%" align="right">预算金额：</th>
			<td width="35%"><bean:write name="igprj0101VO" property="form.pamount" format="##.##"></bean:write></td>
		</tr>
		</c:if>
		
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
	
	 <div class="title">
	<div class="name">项目进展</div>
	</div>
	<ig:message/>
	<div id="formwrapper">
	<form action="<%=contextPath %>/IGPRJ0101_Detail_ConfirmMilestone.do" method="post" enctype="multipart/form-data">
	
	<div class="record_list"  style="margin-left: 0px;">
	<c:if test="${ 'A' <= milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #<%=milestoneInfoVO.getColorA()%>;width: 70px;text-align: center;margin-left: 5px;"><a href="javascript:addPlan('A');" id="addPlan"><img src="images/xm1.gif" border="0" style="vertical-align:-3px;" />&nbsp;需求分析</a></div>
	</c:if>
	<c:if test="${ 'A' > milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm1.gif" border="0" style="vertical-align:-3px;" />&nbsp;需求分析</div>
	</c:if>
	 
	<c:if test="${ 'B' <= milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #<%=milestoneInfoVO.getColorB()%>;width: 70px;text-align: center;margin-left: 5px;"><a href="javascript:addPlan('B');" id="addPlan"><img src="images/xm2.gif" border="0" style="vertical-align:-3px;" />&nbsp;立项</a></div>
	</c:if>
	<c:if test="${ 'B' > milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm2.gif" border="0" style="vertical-align:-3px;" />&nbsp;立项</div>
	</c:if>
	 
	<c:if test="${ 'C' <= milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #<%=milestoneInfoVO.getColorC()%>;width: 70px;text-align: center;margin-left: 5px;"><a href="javascript:addPlan('C');" id="addPlan"><img src="images/xm3.gif" border="0" style="vertical-align:-3px;" />&nbsp;签订合同</a></div>
	</c:if>  
	<c:if test="${ 'C' > milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm3.gif" border="0" style="vertical-align:-3px;" />&nbsp;签订合同</div>
	</c:if>  
	  
	<c:if test="${ 'D' <= milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #<%=milestoneInfoVO.getColorD()%>;width: 70px;text-align: center;margin-left: 5px;"><a href="javascript:addPlan('D');" id="addPlan"><img src="images/xm4.gif" border="0" style="vertical-align:-3px;" />&nbsp;实施</a></div>
	</c:if>  
	<c:if test="${ 'D' > milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm4.gif" border="0" style="vertical-align:-3px;" />&nbsp;实施</div>
	</c:if>  
	  
	 <c:if test="${ 'E' <= milestoneInfoVO.pstatus}">
	  <div class="action" style="background-color: #<%=milestoneInfoVO.getColorE()%>;width: 70px;text-align: center;margin-left: 5px;"><a href="javascript:addPlan('E');" id="addPlan"><img src="images/xm5.gif" border="0" style="vertical-align:-3px;" />&nbsp;测试</a></div>
	</c:if> 
	<c:if test="${ 'E' > milestoneInfoVO.pstatus}">
	  <div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm5.gif" border="0" style="vertical-align:-3px;" />&nbsp;测试</div>
	</c:if> 
	 
	<c:if test="${ 'F' <= milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #<%=milestoneInfoVO.getColorF()%>;width: 70px;text-align: center;margin-left: 5px;"><a href="javascript:addPlan('F');" id="addPlan"><img src="images/xm6.gif" border="0" style="vertical-align:-3px;" />&nbsp;验收</a></div>
	</c:if>  
	<c:if test="${ 'F' > milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm6.gif" border="0" style="vertical-align:-3px;" />&nbsp;验收</div>
	</c:if>
	 
	 <c:if test="${ 'G' <= milestoneInfoVO.pstatus}">
	  <div class="action" style="background-color: #<%=milestoneInfoVO.getColorG()%>;width: 70px;text-align: center;margin-left: 5px;"><a href="javascript:addPlan('G');" id="addPlan"><img src="images/xm7.gif" border="0" style="vertical-align:-3px;" />&nbsp;交付</a></div>
	</c:if> 
	 <c:if test="${ 'G' > milestoneInfoVO.pstatus}">
	  <div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm7.gif" border="0" style="vertical-align:-3px;" />&nbsp;交付</div>
	</c:if> 
	 
	</div>
	<logic:present name="pplstatusDisp">
	<fieldset >
	
	<bean:define id="projectplan" name="milestoneInfoVO" property="projectPlan"></bean:define>
	<div>
    	<span class="label1" style="width:90px; display:inline-block;">标题：</span>
    	<input type="text" name="ppltitle" value="${projectplan.ppltitle }" size="21" readonly="readonly"/>
    	
		<span class="label1" style="width:90px; display:inline-block;">开始时间：</span>
		<input type="text" name="pplopentime" value="${projectplan.pplopentime }" size="20" readonly="readonly"/><br />
		
       	<span class="label1"  style="width:90px; display:inline-block;">预计结束时间：</span>
       	<input type="text" name="pplclosetime" id="pplclosetime" value="${projectplan.pplclosetime }" size="21" readonly="readonly" />
       	
       	<span class="label1"><span class="red">*</span>实际结束时间：</span>
       	<input type="text" name="pplshuttime" id="pplshuttime" value="${projectplan.pplshuttime }" size="20" readonly="readonly" />
       	<img src="<%=contextPath %>/images/date.gif" onClick="calendar($('pplshuttime'))" border=0  style="cursor: hand;"/>
       	<br />
       	<span class="label1" style="width:90px; display:inline-block;vertical-align:top;">描述：</span>&nbsp;
       	<textarea name="ppldesc" cols="54" rows="5">${projectplan.ppldesc }</textarea>
       	<input type="hidden" name="pplversion" value="${projectplan.pplversion+1 }"/>
    	<input type="hidden" name="confirmTime" value="N"/>
       	<input type="hidden" name="confirmDesc" value="N" />
       	<input type="hidden" name="pplstatus" value="${projectplan.pplstatus }" />
		<input type="hidden" name="pid" value="${projectplan.pid }" />
		<input type="hidden" name="pplid" value="${projectplan.pplid }" />
		<input type="hidden" name="pplinfo" value="${projectplan.pplinfo }" />
    </div>
    
    <div>
		<span class="label1" style="width:90px; display:inline-block;">附件信息：</span>
		<input type="hidden" name="pplriskatt" value="${projectplan.pplriskatt }"/>
		<img src="images/attachment.gif" /><a href="javascript:addFile();" id="aAddAttach">添加附件</a><br>
       			<table id="tb" style="height: 50px;"></table> 
	</div>
	<logic:notEmpty name="milestoneInfoVO" property="attachmentList">
		<div>
			<span class="label3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已有附件：</span>
			<bean:define id="attachmentList" name="milestoneInfoVO" property="attachmentList" />

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
		</div>
	</logic:notEmpty>
	<div style="margin-top:50px;">
	
	</div>
	
	
	</fieldset>
	<div class="enter">
	<logic:notPresent name="projectplan" property="pplshuttime">
		<logic:notEqual name="igprj0101VO" property="form.pstatus" value="C">
		<input type="submit" value="确认" class="button" id="confirmMS" onclick="return checkPPTime(1);">
		</logic:notEqual>
	</logic:notPresent>
	<logic:present name="projectplan" property="pplshuttime">
		<input type="submit" value="确认" class="button" id="confirmMS" onclick="return checkPPTime(0);">
	</logic:present>
	<input type="button" value="返回" class="button" onclick="window.location='IGPRJ0101_Detail.do?pid=<%=projectPlan.getPid() %>';">
	</div>
	</logic:present>
	</form>
	</div>
	
	  </div>
	   </div>   
	</div>

</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.IGPRJ0101VO"%>
<%@ page import="com.deliverik.infogovernor.prj.model.Project"%>
<%@ page import="com.deliverik.infogovernor.prj.model.ProjectLog"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.MilestoneInfoVO"%>
<%@ page import="com.deliverik.infogovernor.prj.vo.MilestoneInfo"%>
<%@ page import="com.deliverik.infogovernor.prj.model.ProjectPlan"%>
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
	String pclosetime = String.valueOf(request.getAttribute("pclosetime"));
	String popentime = String.valueOf(request.getAttribute("popentime"));
%>
<html:html>
<bean:define id="id" value="IGPRJ010101" toScope="request" />
<bean:define id="title" value="项目计划" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">

function addPlan(pplstatusDisp) {
	document.forms[0].action =  getAppRootUrl() + "/IGPRJ0101_Detail.do?type=adjustProjectPlan&popentime=<%=popentime%>&pclosetime=<%=pclosetime %>&pid=<%=projectPlan.getPid() %>&pplstatusDisp="+pplstatusDisp;
	document.forms[0].submit();
}

function checkPPTime() {
	<% if(milestoneInfoVO.getSygTime()!=null&&!"".equals(milestoneInfoVO.getSygTime())){%>
	if(document.getElementById("pplopentime").value<="<%=milestoneInfoVO.getSygTime()%>"){
		alert("计划开始时间必须大于上一个计划开始时间！");
		return false;
	}
	<%}%>
	if(document.getElementById("ppltitle").value.trim()==""){
		alert("请填写标题！");
		return false;
	}
	if(document.getElementById("ppltitle").value.strlen()>64){
		alert("标题不能大于20个汉字！");
		return false;
	}
	if(document.getElementById("pplopentime").value==""){
		alert("请填写开始时间！");
		return false;
	}
	if(document.getElementById("pplclosetime").value==""){
		alert("请填写结束时间！");
		return false;
	}
	if(document.getElementById("pplclosetime").value<document.getElementById("pplopentime").value){
		alert("计划结束时间不能小于项目结束时间！");
		return false;
	}
	if(document.getElementById("pplclosetime").value>"<%=pclosetime %>"){
		alert("计划结束时间不能大于项目结束时间！");
		return false;
	}
	if(document.getElementById("pplinfo").value.strlen()>1024){
		alert("描述不能大于340个汉字！");
		return false;
	}
	if(confirm("请确认是否提交项目计划?")){
		return true;
	}
	return false;
	
}

//删除附件
function delFile(attid){
	 if( window.confirm("您是否确定删除附件？")){
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'attid='+ attid + '&type=deleteAttid',
				 onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result!=null && result!=""){
						document.getElementById(result).style.display = "none";
						document.getElementById(result + "IMG").style.display = "none";
					}
			     }
				});

     } 
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
	<p class="fonts1">查看 &gt;&gt; 项目计划</p>
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
	<div class="name">调整计划</div>
	</div>
	<ig:message/>
	<div id="formwrapper">
	<form action="<%=contextPath %>/IGPRJ0101_Detail_AdjustProjectPlan.do" method="post"  enctype="multipart/form-data">
	
	<div class="record_list" style="margin-left: 0px;">
	<c:if test="${ 'A' <= milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #<%=milestoneInfoVO.getColorA()%>;width: 70px;text-align: center;margin-left: 5px;"><a href="javascript:addPlan('A');" id="addPlan"><img src="images/xm1.gif" border="0" style="vertical-align:-3px;" />&nbsp;需求分析</a></div>
	</c:if>
	<c:if test="${ 'A' > milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm1.gif" border="0" style="vertical-align:-3px;"/>&nbsp;需求分析</div>
	</c:if>
	<c:if test="${ 'B' <= milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #<%=milestoneInfoVO.getColorB()%>;width: 70px;text-align: center;margin-left: 5px;"><a href="javascript:addPlan('B');" id="addPlan"><img src="images/xm2.gif" border="0" style="vertical-align:-3px;"/>&nbsp;立项</a></div>
	</c:if>
	<c:if test="${ 'B' > milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm2.gif" border="0" style="vertical-align:-3px;"/>&nbsp;立项</div>
	</c:if>
	 
	<c:if test="${ 'C' <= milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #<%=milestoneInfoVO.getColorC()%>;width: 70px;text-align: center;margin-left: 5px;"><a href="javascript:addPlan('C');" id="addPlan"><img src="images/xm3.gif" border="0" style="vertical-align:-3px;"/>&nbsp;签订合同</a></div>
	</c:if>  
	<c:if test="${ 'C' > milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm3.gif" border="0" style="vertical-align:-3px;"/>&nbsp;签订合同</div>
	</c:if>  
	  
	<c:if test="${ 'D' <= milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #<%=milestoneInfoVO.getColorD()%>;width: 70px;text-align: center;margin-left: 5px;"><a href="javascript:addPlan('D');" id="addPlan"><img src="images/xm4.gif" border="0" style="vertical-align:-3px;"/>&nbsp;实施</a></div>
	</c:if>  
	<c:if test="${ 'D' > milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm4.gif" border="0" style="vertical-align:-3px;"/>&nbsp;实施</div>
	</c:if>  
	  
	 <c:if test="${ 'E' <= milestoneInfoVO.pstatus}">
	  <div class="action" style="background-color: #<%=milestoneInfoVO.getColorE()%>;width: 70px;text-align: center;margin-left: 5px;"><a href="javascript:addPlan('E');" id="addPlan"><img src="images/xm5.gif" border="0" style="vertical-align:-3px;"/>&nbsp;测试</a></div>
	</c:if> 
	<c:if test="${ 'E' > milestoneInfoVO.pstatus}">
	  <div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm5.gif" border="0" style="vertical-align:-3px;"/>&nbsp;测试</div>
	</c:if> 
	 
	<c:if test="${ 'F' <= milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #<%=milestoneInfoVO.getColorF()%>;width: 70px;text-align: center;margin-left: 5px;"><a href="javascript:addPlan('F');" id="addPlan"><img src="images/xm6.gif" border="0" style="vertical-align:-3px;"/>&nbsp;验收</a></div>
	</c:if>  
	<c:if test="${ 'F' > milestoneInfoVO.pstatus}">
	 <div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm6.gif" border="0" style="vertical-align:-3px;"/>&nbsp;验收</div>
	</c:if>
	 
	 <c:if test="${ 'G' <= milestoneInfoVO.pstatus}">
	  <div class="action" style="background-color: #<%=milestoneInfoVO.getColorG()%>;width: 70px;text-align: center;margin-left: 5px;"><a href="javascript:addPlan('G');" id="addPlan"><img src="images/xm7.gif" border="0" style="vertical-align:-3px;"/>&nbsp;交付</a></div>
	</c:if> 
	 <c:if test="${ 'G' > milestoneInfoVO.pstatus}">
	  <div class="action" style="background-color: #efefef;width: 70px;text-align: center;margin-left: 5px;"><img src="images/xm7.gif" border="0" style="vertical-align:-3px;"/>&nbsp;交付</div>
	</c:if>
	 
	</div>
	
	<logic:present name="pplstatusDisp">
	<fieldset >
	
	<bean:define id="projectplan" name="milestoneInfoVO" property="projectPlan"></bean:define>
	<div>
	
    	<span class="label1" style="width:80px; display:inline-block;" ><span class="red">*</span>标题：</span>
    	<input type="text" name="ppltitle" value="${projectplan.ppltitle }" size="74" />
    	<input type="hidden" name="pplversion" value="${projectplan.pplversion+1 }"/>
    	<input type="hidden" name="confirmTime" value="N"/>
       	<input type="hidden" name="confirmDesc" value="N" />
       	<input type="hidden" name="pplstatus" value="${projectplan.pplstatus }" />
		<input type="hidden" name="pid" value="${projectplan.pid }" />
		<input type="hidden" name="pplid" value="${projectplan.pplid }" /><br />
		<input type="hidden" name="pplshuttime" value="${projectplan.pplshuttime }" />
		<input type="hidden" name="ppldesc" value="${projectplan.ppldesc }" />
		<span class="label1" style="width:80px; display:inline-block;" ><span class="red">*</span>开始时间：</span>
		<input type="text" name="pplopentime" value="${projectplan.pplopentime }" size="20" readonly="readonly"/>
		<img src="<%=contextPath %>/images/date.gif" onClick="calendar($('pplopentime'))" border=0 style="cursor: hand;"/>
       	<span class="label1" style="width:80px; display:inline-block;" ><span class="red">*</span>结束时间：</span>
       	<input type="text" name="pplclosetime" id="pplclosetime" value="${projectplan.pplclosetime }" size="19" readonly="readonly" />
       	<img src="<%=contextPath %>/images/date.gif" onClick="calendar($('pplclosetime'))" border=0 style="cursor: hand;" /><br />
       	<span class="label1" style="width:80px; display:inline-block;vertical-align:top;" >描述：</span>
       	<textarea name="pplinfo" cols="54" rows="5">${projectplan.pplinfo }</textarea>
       	
    </div>
    
    <div>
		<span class="label1" style="width:80px; display:inline-block;" >附件信息：</span>
		<input type="hidden" name="pplriskatt" value="${projectplan.pplriskatt }"/>
		<img src="images/attachment.gif" /><a href="javascript:addFile();" id="aAddAttach">添加附件</a><br>
       			<table id="tb" style="height: 50px;"></table> 
	</div>
	<logic:notEmpty name="milestoneInfoVO" property="attachmentList">
		<div>
			<span class="label3">已有附件：</span>
			<bean:define id="attachmentList" name="milestoneInfoVO" property="attachmentList" />

			<table>
			<logic:iterate id="attachment" name="attachmentList" indexId="number">
			<tr>
				<td>
				<html:link action="downloadSvcFile.do?attId=${attachment.attid}&type=svc" styleId="${attachment.attid}">
				<bean:define id="attname" name="attachment" property="attname" />
				<%=String.valueOf(attname).substring(String.valueOf(attname).indexOf("_")+1)  %>
				</html:link>
				<img src="images/delate.gif" align="middle" onClick="delFile('${attachment.attid}')" border="0" style="cursor: hand" alt="删除" id="${attachment.attid}IMG"/><br>					  
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
		<input type="submit" value="提交" class="button" onclick="return checkPPTime();">
		</logic:notEqual>
	</logic:notPresent>
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List" %>
<%@ page import="com.deliverik.framework.user.model.Organization" %>
<%@ page import="com.deliverik.framework.workflow.prr.model.IG160Info" %>
<%@ page import="com.deliverik.infogovernor.svc.vo.IGSVC05131VO" %>
<%
	IGSVC05131VO igsvc05131vo = (IGSVC05131VO)request.getAttribute("igsvc05131vo");
	List<IG160Info> userProcessCountList = null;
	if(igsvc05131vo != null){
		userProcessCountList = igsvc05131vo.getUserProcessCountList();
	}
	int totalSum = 0;
	int incidentSum = 0;
	int problemSum = 0;
	int changeSum = 0;
	int deploymentSum = 0;
	int workSum = 0;
	int allSum = 0;
	int askSum=0;
%>
<html:html>
<bean:define id="id" value="IGSVC0608" toScope="request" />
<bean:define id="title" value="人员工作报告画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
<script type="text/javascript">

if (document.getElementById){ //DynamicDrive.com change
document.write('<style type="text/css">\n')
document.write('.submenu{display: none;}\n')
document.write('</style>\n')
}

function SwitchMenu(obj){
	if(document.getElementById){
	var el = document.getElementById(obj);
	var ar = document.getElementById("masterdiv").getElementsByTagName("span"); //DynamicDrive.com change
		if(el.style.display != "block"){ //DynamicDrive.com change
			for (var i=0; i<ar.length; i++){
				if (ar[i].className=="submenu") //DynamicDrive.com change
				ar[i].style.display = "none";
			}
			el.style.display = "block";
		}else{
			el.style.display = "none";
		}
	}
}

function setOrg(url){
  	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].orgid.value = "";
		document.forms[0].orgName.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		var orgsyscoding ="";
		orgsyscoding = temp.split("|")[0]+"%";
		document.forms[0].orgid.value = orgsyscoding;
		document.forms[0].orgName.value = temp.split("|")[1];
	}		

}



function checkForm(){

	if(!checkDate("propentime_from","propentime_to")){
		alert("查询开始时间不能晚于结束时间！");
		return false;
	}else{
		document.forms[0].action = getAppRootUrl() + "/IGSVC0609.do";
		document.forms[0].submit();	
	}
	
}
function exportExcel() {
	if(!checkDate("propentime_from","propentime_to")){
		alert("查询开始时间不能晚于结束时间！");
		return false;
	}else{
		document.forms[0].action = getAppRootUrl() + "/IGSVC0609.do?report2=1";
		document.forms[0].submit();
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
        <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
    </div>
     <div id="search">
 <html:form styleId="form" action="/IGSVC0609" onsubmit="return checkSubmit(this);">
         <div class="img"></div>
          <div class="conditions">
      <div>
        <span>时间：从</span><span><html:text property="propentime_from" readonly="true" errorStyleClass="inputError imeActive"/></span>
   		<img src="images/date.gif" align="middle" onClick="calendar($('propentime_from'))" border="0"/>                  
        <span>&nbsp;&nbsp;到</span><span><html:text property="propentime_to" readonly="true" errorStyleClass="inputError imeActive"/></span>
         <img src="images/date.gif" align="middle" onClick="calendar($('propentime_to'))" border="0"/>  
         <!--              
	   <span>&nbsp;&nbsp;所属机构：</span><html:text property="orgName" readonly="true" errorStyleClass="inputError imeActive"></html:text>
		<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" alt="请选择机构"/>
      	<html:hidden property="orgid"/> --> 
      	&nbsp;
       <span>
       <input type="hidden" value="user" name="type" />
       <html:submit property="btn_search" styleClass="button" value="查询" onclick="checkForm()"/>
       <html:submit property="btn_search" styleClass="button" value="导出"  onclick="exportExcel()"/>
       </span> 
       </div>
      </div>
    </html:form>
    </div>
        
     
     <div id="results_list"><ig:message />
       <table  class="table_style" id="caseListTable">
						
						<tr>
							<th width="12%">人员</th>
							<th width="12%">部门</th>
							<th width="12%">事件</th>
							<th width="12%">问题</th>
							<th width="12%">变更</th>
							<th width="10%">工单</th>
							<th width="10%">请求</th>
							<th width="16%">汇总</th>
						</tr>
						<!-- body部 -->
        <%
        	if(null != userProcessCountList){
        		for(IG160Info userProcessCount : userProcessCountList){
        			int incident = userProcessCount.getIncident();
        			incidentSum += incident;
        			int problem = userProcessCount.getProblem();
        			problemSum += problem;
        			int change = userProcessCount.getChange();
        			changeSum += change;
        			int work = userProcessCount.getWork();
        			workSum += work;
        			int ask = userProcessCount.getAsk();
        			askSum += ask;
        			totalSum = incident + problem + change + work+ask;
        			allSum += totalSum;
        			String userId = userProcessCount.getPpuserid();
        %>
        
				<tr>
					<td>
					<div class="nowrapDiv"><%=userProcessCount.getPpusername() %></div>
					</td>
					<td>
					<div class="nowrapDiv"><%=userProcessCount.getOrgname() %></div>
					</td>
					<td>
					<div class="nowrapDiv"> 
					<% 
						if(incident == 0){
							out.print("0");
						} else {
					%>
						<a href="IGSVC0604.do?userId=<%=userId %>&prtype=WD&prpdid=01080
						&propentime_from=<bean:write name="IGSVC0602Form" property="propentime_from"/>&propentime_to=<bean:write name="IGSVC0602Form" property="propentime_to"/> 23:59"><%=incident %></a>		
					<%}%>
					</div>
					</td>
					<td>
					<div class="nowrapDiv"> 
					<% 
						if(problem == 0){
							out.print("0");
						} else {
					%>
						<a href="IGSVC0604.do?userId=<%=userId %>&prtype=WD&prpdid=01083
						&propentime_from=<bean:write name="IGSVC0602Form" property="propentime_from"/>&propentime_to=<bean:write name="IGSVC0602Form" property="propentime_to"/> 23:59"><%=problem %></a>		
					<%}%>
					</div>
					</td>
					<td>
					<div class="nowrapDiv"> 
					<% 
						if(change == 0){
							out.print("0");
						} else {
					%>
						<a href="IGSVC0604.do?userId=<%=userId %>&prtype=WD&prpdid=01084
						&propentime_from=<bean:write name="IGSVC0602Form" property="propentime_from"/>&propentime_to=<bean:write name="IGSVC0602Form" property="propentime_to"/> 23:59"><%=change %></a>		
					<%}%>
					</div>
					</td>
					<td>
					<div class="nowrapDiv"> 
					<% 
						if(work == 0){
							out.print("0");
						} else {
					%>
						<a href="IGSVC0604.do?userId=<%=userId %>&prtype=GD
						&propentime_from=<bean:write name="IGSVC0602Form" property="propentime_from"/>&propentime_to=<bean:write name="IGSVC0602Form" property="propentime_to"/> 23:59"><%=work %></a>		
					<%}%>
					</div>
					</td>
					<td>
					<div class="nowrapDiv">
					<% 
						if(ask == 0){
							out.print("0");
						} else {
					%>
						<a href="IGSVC0604.do?userId=<%=userId %>&prtype=WD&prpdid=01100
						&propentime_from=<bean:write name="IGSVC0602Form" property="propentime_from"/>&propentime_to=<bean:write name="IGSVC0602Form" property="propentime_to"/> 23:59"><%=ask %></a>		
					<%}%>
					</div>
					</td>
					<td>
					<span class="red">
					<%=totalSum %>
					</span>
					</td>
					
				</tr>
			<%		
        		} if(null != request.getAttribute("message")){
        			out.print(request.getAttribute("message"));
        		} else {
        	%>
        		<tr>
					<td colspan="2">
						<strong>统计</strong>
					</td>
					<td>
					<div class="nowrapDiv"> 
					<span class="red">
					<%=incidentSum %>
					</span>
					</div>
					</td>
					<td>
					<div class="nowrapDiv"> 
					<span class="red">
					<%=problemSum %>
					</span>
					</div>
					</td>
					<td>
					<div class="nowrapDiv"> 
					<span class="red">
					<%=changeSum %>
					</span>
					</div>
					</td>
					<td>
					<div class="nowrapDiv"> 
					<span class="red">
					<%=workSum %>
					</span>
					</div>
					</td>
					<td>
					<div class="nowrapDiv"> 
					<span class="red">
					<%=askSum %>
					</span>
					</div>
					</td>
					<td>
					<span class="red">
					<%=allSum %>
					</span>
					</td>
					
				</tr>
        	<%
        		}
        	}
            %>
			
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
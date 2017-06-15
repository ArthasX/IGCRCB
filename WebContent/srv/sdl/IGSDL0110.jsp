<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.sdl.bl.QuartzJobsType" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<base target="_self" >
<!--javascript-->
<script type="text/javascript">
var gid='IGSDL0110';


function checkForm(){
	if(confirm("您是否确认删除?")){
		return true;
	}
	return false;
}

function selectEntity(){
	openSubIGCOM0302();
}

function setParamIGCOM0302(eid, elabel,ename,eiid, eilabel, einame,ecategory) {
    $("qjassetid").value = eiid;
	//$("qjassetname").value = eilabel;
	$("qjassetname").value = einame;
}

function showIncident(){
	var ccid = "116";
	var cid = "";
	var syscode = "";
	if(null==syscode || ""==syscode){
		syscode = ccid;
	}else{
		ccid = syscode.substring(0,3);
	}
	url = "IGSYM1202_TREE_BY_STATUS.do" + "?ccid="+ccid+"&cid="+cid+"&syscode="+syscode;
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		$("qjassettypeid").value="";
		$("qjassettypename").value="";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		var id = temp.split("|")[0];
		var name = temp.split("|")[1];
		var treeccid;
		var treecid;
		var treesyscode;
		
		if(id.split("_").length>1){
			treeccid = id.split("_")[0];
			treecid = id.split("_")[1];
			treesyscode = id.split("_")[2];
		}else{
			treeccid = id.split("_")[0];
			treecid = "";
			treesyscode = "";
		}
		$("qjassettypeid").value=treesyscode;
		$("qjassettypename").value=name;
	}		
}

//跳转到服务策略登记页面
function goPageSDL(){
	var date = $("date").value;
	form.action="IGMTP0103_Disp_SOC.do?date=" + date;
	form.submit();
}
</script>
<bean:define id="id" value="IGSDL0110" toScope="request" />
<bean:define id="title" value="日常工作计划查询" toScope="request" />
<bean:define id="user" name="LOGIN_USER" scope="session" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent"><!--header  头部和 一级菜单-->
<div id="container"> <!--container 左菜单 右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form action="/IGSDL0110_SOC" styleId="form">
<div id="location">
<div class="image"></div>
<p class="fonts1">日常工作计划 &gt;&gt;计划查询</p>
</div>
<div id="search">
<div class="img"></div>
<div class="conditions">
	<div>
	<span>&nbsp;&nbsp;工单类型：</span><html:text property="qjassettypename" readonly="true" />
	<img alt="分类查询" src="images/tree.gif" onclick="showIncident();" style="cursor: hand;" />
	<html:hidden property="qjassettypeid" /> 

	<html:hidden property="qjstatus" value="<%=QuartzJobsType.SERVICE_STRATEGY %>"/>
	<span><html:submit styleClass="button" value="查询" /></span>
	<c:if test="${IGSDL0110Form.date >= fn:substring(IGSDL0110Form.date_now,0,10)}">
		<span><input type="button" class="button" value="添加" onclick="goPageSDL();"/></span>
	</c:if>
	</div>
</div>
</div>
<div id="results_list"><ig:message />
<table class="table_style">
	<tr>
		<th width="5%">序号</th>
		<th width="20%">任务名称</th>
		<th width="20%">任务描述</th>
		<th width="15%">任务类型</th>
		<th width="10%">执行人</th>
		<th width="15%">开始时间</th> 
		<th width="8%">查看</th>
		<th width="7%" colspan="2">操作</th>
	</tr>
	<logic:present name="IGSDL01101VO" property="quartzJobsDetailList">
		<logic:iterate id="bean" name="IGSDL01101VO" property="quartzJobsDetailList"
			indexId="index">
			<bean:define id="timebean" name="bean" type="com.deliverik.infogovernor.scheduling.model.QuartzJobsDetail"/>
			<tr class="<ig:rowcss index="${index}"/>">
				<td>${PagingDTO.viewStartCount+index}</td>
				<td><bean:write name="bean" property="qjname" /></td>
				<td><bean:write name="bean" property="qjdesc" /></td>
				<td><ig:codeValue ccid="STRATEGY_WORK_CODE" cid="${bean.qjtype}" /></td>
				<td><bean:write name="bean" property="qjimplusername" /></td>
				<td><bean:write name="bean" property="qjcrttime" /></td>
				<td><a href="IGSDL0111_List_SOC.do?qjid=<bean:write name="bean" property="qjid" />&qjtype=<bean:write name="bean" property="qjtype" />"><img
					src="images/look.gif" width="16" height="16" border="0" alt="查看详细信息" /></a></td>
				<td>

				<logic:equal name="bean" property="qjcrtuser" value="${user.userid}">
					<%
	      	 	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	      	 	    boolean f = true; 	
	      	 	    if(timebean.getQjendtime()!=null && !"".equals(timebean.getQjendtime().trim())){
	      	 		   Date now = new Date();
	      	 		   Date old = sdf.parse(timebean.getQjendtime());
	      	 		   if(now.getTime()>=old.getTime()){
	      	 			  //当前时间大于等于结束时间则不可修改
	      	 			  f = false;
	      	 		   }
	      	 	    }else{
	      	 	       //执行周期为仅一次的不可修改
	      	 		   f = false;
	      	 	    }

	      	 	    if(timebean.getQjendtime()!=null && !"".equals(timebean.getQjendtime().trim()) && f){ 
	      	 	    %>
	      	 	    <c:if test="${bean.qjdtime>IGSDL0110Form.date_now}">
	      	 		<a href="IGMTP0105_Modify_SOC.do?qjid=<bean:write name="bean" property="qjid" />">
						<img alt="修改" src="images/edit.gif" border="0"> 
					</a>
					</c:if>
					<c:if test="${bean.qjdtime<=IGSDL0110Form.date_now}">
						<img alt="不可修改" src="images/noedit.gif">
					</c:if>
					<%}else{ %>
	      	 			<img alt="不可修改" src="images/noedit.gif">
	      	 		<%} %>
				</logic:equal>
				
				</td>
				<td>
					<logic:equal name="bean" property="qjcrtuser" value="${user.userid}">
					<%
	      	 	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	      	 	    boolean f = true; 	
	      	 	    if(timebean.getQjendtime()!=null && !"".equals(timebean.getQjendtime().trim())){
	      	 		   Date now = new Date();
	      	 		   Date old = sdf.parse(timebean.getQjendtime());
	      	 		   if(now.getTime()>=old.getTime()){
	      	 			  //当前时间大于等于结束时间则不可修改
	      	 			  f = false;
	      	 		   }
	      	 	    }else{
	      	 	       //执行周期为仅一次的不可修改
	      	 		   f = false;
	      	 	    }

	      	 	    if(timebean.getQjendtime()!=null && !"".equals(timebean.getQjendtime().trim()) && f){ 
					%>
						
						<a href="IGSDL0111_Del_SOC.do?qjid=<bean:write name="bean" property="qjid"/>" onclick="return checkForm();"> 
							<img alt="删除" src="images/delete.gif" border="0"> 
						</a>
						<%}else{ %>
							<img alt="不可删除" src="images/nodelete.gif">
						<%} %>
					</logic:equal> 
					<logic:notEqual name="bean" property="qjcrtuser" value="${user.userid}">
						<img alt="不可删除" src="images/nodelete.gif">
					</logic:notEqual>
				</td>
			</tr>
		</logic:iterate>
	</logic:present>
</table>
</div>
<div id="operate">
<jsp:include page="/include/paging.jsp" />
</div>
	<html:hidden property="date" /> 
	<html:hidden property="date_now" /> 
</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>
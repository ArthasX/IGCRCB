<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<html:html>
<!--javascript-->
<script type="text/javascript">


function checkForm(){
	if(confirm("是否确认删除?")){
		return true;
	}
	return false;
}

function submitForm(){
	if(!checkDate("startTime","endTime")){
		alert("开始时间必须小于结束时间");
		return false;
	}
	return true;
}
</script>
<bean:define id="id" value="IGSCH0101" toScope="request" />
<logic:equal name="IGSCH0101Form" property="pagetype" value="PSEARCH">
<bean:define id="title" value="我的任务" toScope="request" />
</logic:equal>
<logic:notEqual name="IGSCH0101Form" property="pagetype" value="PSEARCH">
<bean:define id="title" value="任务查询" toScope="request" />
</logic:notEqual>
<bean:define id="user" name="LOGIN_USER" scope="session" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<div id="container">
<!--container 左菜单 右侧内容-->
   <div id="contentWrap">
   <div id="content">
   <html:form action="/IGSCH0101" styleId="form">
   <html:hidden property="qjcrtuser"/>
   <html:hidden property="qjimpluser"/>
   <div id="location">
       <div class="image"></div>
       	<logic:equal name="IGSCH0101Form" property="pagetype" value="PSEARCH">
        <p class="fonts1">流程管理 &gt;&gt; 任务调度 &gt;&gt; 我的任务</p>
        </logic:equal>
        <logic:notEqual name="IGSCH0101Form" property="pagetype" value="PSEARCH">
        <p class="fonts1">流程管理 &gt;&gt; 任务调度 &gt;&gt; 任务查询</p>
        </logic:notEqual>
    </div>
     <div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
    <span>时间：从</span><html:text property="startTime" styleId="startTime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('startTime'))" border="0" style="cursor: hand" />&nbsp;&nbsp;
	<span>到</span><html:text property="endTime" styleId="endTime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('endTime'))" border="0" style="cursor: hand" />
	 <span><html:submit styleClass="button" value="查询" onclick="return submitForm();" /></span></div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
		<tr>
			<th width="5%">序号
			</th>
			<th width="26%">任务名称
			</th>
			<th width="25%">任务描述
			</th>
			<th width="8%">任务类型
			</th>
			<th width="8%">执行人
			</th>
            <th width="8%">开始时间
			</th>
			<th width="8%">结束时间
			</th>
			<th width="5%">查看
			</th>
			<th  colspan="2" width="7%">操作
			</th>
			
		</tr>
		<logic:present name="IGSCH01011VO" property="quartzJobsList">
			<logic:iterate id="bean" name="IGSCH01011VO" property="quartzJobsList"
				indexId="index">
			<bean:define id="timebean" name="bean" type="com.deliverik.infogovernor.scheduling.model.QuartzJobs"/>
			
	  <tr class="<ig:rowcss index="${index}"/>">
      <td>
      	${PagingDTO.viewStartCount+index}
      </td>
      <td><bean:write name="bean" property="qjname" /></td>
      <td><bean:write name="bean" property="qjdesc" /></td>
      <td><ig:codeValue ccid="STRATEGY_WORK_CODE" cid="${bean.qjtype}" /></td>
      <td><bean:write name="bean" property="qjimplusername" /></td>
      <td><bean:write name="bean" property="qjcrttime" /></td>
      <td><bean:write name="bean" property="qjendtime" /></td>
      <td>
      <a href="IGSCH0101_List.do?qjid=<bean:write name="bean" property="qjid" />&qjtype=<bean:write name="bean" property="qjtype" />"><img
      src="images/look.gif" width="16" height="16" border="0" alt="查看详细信息" /></a>
      </td>
      <td>
	      <logic:equal name="bean" property="qjcrtuser"  value="${user.userid}">

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

	      	 	if(timebean.getQjendtime()!=null && !"".equals(timebean.getQjendtime().trim()) && f ){ 
	      	 	%>
	      	 	<a href="IGSCH0101_Modify.do?qjid=<bean:write name="bean" property="qjid" />">
					<img alt="修改" src="images/edit.gif" border="0">
				</a>
				<%}else{ %>
	      	
	      	 		<img alt="不可修改" src="images/noedit.gif">
	      	 	<%} %>
	      </logic:equal>
	      
	      <logic:notEqual name="bean" property="qjcrtuser"  value="${user.userid}">
	      	<img alt="不可修改" src="images/noedit.gif">
	      </logic:notEqual>
      </td>
      <td>
	      <logic:equal name="bean" property="qjcrtuser"  value="${user.userid}">
	      	<a href="IGSCH0101_Del.do?qjid=<bean:write name="bean" property="qjid"/>"  onclick="return checkForm();">
	      		<img alt="删除" src="images/delete.gif" border="0">
	      	</a>
	      </logic:equal>
	      
	      <logic:notEqual name="bean" property="qjcrtuser"  value="${user.userid}">
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
	</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.deliverik.infogovernor.prj.vo.IGPRJ01HistoryVO"%>
<%@ page import="com.deliverik.infogovernor.prj.model.ProjectLog"%>
<%@ page import="com.deliverik.framework.model.Attachment"%>
<%@ page import="java.util.List"%>

<%
	String pid=request.getParameter("pid");
	Integer projectId=Integer.valueOf(pid);
%>
<html:html>
<bean:define id="id" value="IGPRJ010107" toScope="request" />
<bean:define id="title" value="历史记录" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">	
function dimselect(){
		document.forms[0].action =  "IGPRJ0101_DIM_History.do";
		document.forms[0].submit();
}
function openPage(pid,plid,pltype){
	openSubWindow("/IGPRJ010107_SEARCH.do?pid="+pid+"&plid="+plid+"&pltype="+pltype,"_blank",'750','330');
}
WebCalendar.timeShow   = true;          //是否返回时间
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
<html:form styleId="form" action="/IGPRJ010107_EXPORT" enctype="multipart/form-data">
<div id="location">
<div class="image"></div>
<p class="fonts1">查看 &gt;&gt; 历史记录</p>
<div class="back">
		<a href="IGPRJ0101_Detail.do?pid=<%=projectId%>" target="_self">返回</a>
</div>
</div>
   <div id="search">
       <div class="img">
   </div>
	<div class="conditions">
      <div> 
        <span>时间：从</span><html:text property="pltime_from" name="IGPRJ0101DetailForm" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/>
        <img src="images/date.gif" align="middle" onClick="showDate($('pltime_from'))" border="0" style="cursor: hand" />&nbsp;&nbsp;
        <span>到</span><html:text property="pltime_to" name="IGPRJ0101DetailForm" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/>
        <img src="images/date.gif" align="middle" onClick="showDate($('pltime_to'))" border="0" style="cursor: hand" />&nbsp;&nbsp;
        <span>内容：</span><html:text property="plinfo" name="IGPRJ0101DetailForm" errorStyleClass="inputError imeDisabled" size="15"/>&nbsp;&nbsp;
        <span>日志类别：</span><span>
        <html:select name="IGPRJ0101DetailForm" property="pltype"  style="width:100px" >
            <html:option value=""></html:option>
            <logic:iterate id="bean" name="igprj0101VO" property="codeDetailList" indexId="index">
			<html:option value="${bean.cid}">${bean.cvalue}</html:option>
			</logic:iterate>
		</html:select></span>
       <span>
        <input type="hidden" name="pid" value="<%=projectId %>" />
        <input class="button" name="btn_dimselect" type="button" value="查询"  onclick="dimselect()"/>
       </span>    
       </div>
	</div>
</div>   
<div id="results_list">
<table class="table_style">
			<tr>
			        <th width="5%" >序号</th>
					<th width="10%">时间</th>
					<th width="7%">操作人</th>
					<th width="8%">日志类别</th>
					<th width="37%">内容</th>
					<th width="25%">附件</th>
					<th width="8%"></th>	
			</tr>
 <logic:present name="historyVOs">
 <logic:iterate id="bean" name="historyVOs" indexId="index">
 <tr class="<ig:rowcss index='${index}'/>">
  <td>${index+1}</td>
    <td>${bean.projectLog.pltime}<input type="hidden" name="pid" value='${bean.projectLog.pid}' /></td>
    <td>${bean.projectLog.plusername}</td>
    <td><ig:codeValue ccid="Project_LOGTYPE" cid="${bean.projectLog.pltype}" /></td>
    <td align="left"><pre>${bean.projectLog.plinfo}</pre></td>
    <td>
    <logic:present name="bean" property="attachmentList">
	<logic:iterate id="attbean" name="bean" property="attachmentList">
	<html:link action="downloadPrjFile.do?attId=${attbean.attid}&type=prj">
	   <bean:define id="attname" name="attbean" property="attname" />
		<%=String.valueOf(attname).substring(String.valueOf(attname).indexOf("_")+1) %>
	</html:link><br/>
	</logic:iterate>
	</logic:present>
    </td>
    <td><c:if test="${(bean.projectLog.pltype=='C')||(bean.projectLog.pltype=='J') }">
		<a href="javascript:openPage(${bean.projectLog.pid},${bean.projectLog.plid},'${bean.projectLog.pltype}')">明细</a>	
	</c:if></td>
  </tr>
  </logic:iterate>
  </logic:present>
 </table>
</div>
<div style="margin-top:50px;" align="center">
			<input type="reset" value="返回" class="button" onclick="window.location='IGPRJ0101_Detail.do?pid=<%=projectId%>';">
			<bean:size id="num" name="historyVOs"/>
			<c:if test="${num>0}">
			<html:submit property="btn_insert" value="导出" styleClass="button" />	
			</c:if>
</div>
<html:hidden name="IGPRJ0101DetailForm" property="backurl" />
</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>

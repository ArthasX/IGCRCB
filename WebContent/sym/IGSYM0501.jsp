<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.sym.vo.IGSYM05011VO" %>
<html:html>
<bean:define id="id" value="IGSYM0501" toScope="request" />
<bean:define id="title" value="通知管理查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
    var delAttachList = "1";
<!--
	//删除所选
	function deleteRec(obj){
		var message = '<bean:message key="IGCO10000.E002"/>';
	    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="通知基本信息" />';
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
	    if(window.confirm(confirmMsg)){
	        form.action = getAppRootUrl() + "/IGSYM0501_Del.do";
	        return true;
	    } else {
	        return false;
	    }
	}

	function checkForm(){
	
		if(!checkDateWithTimeShow("ntime_from","ntime_to")){
			alert("结束时间必须晚于发布时间！");
			return false;
		}
	}
//-->
WebCalendar.timeShow   = true;          //是否返回时间
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGSYM0501"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>

	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div><span>通知名称：</span> <span> <html:text
		property="nname" styleId="nname"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="32"  tabindex="1"/>
	</span>
	<span>&nbsp;&nbsp;发布时间：从</span><span><html:text property="ntime_from" readonly="true" /></span>
	<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('ntime_from'))" border="0" /> 
	<span>&nbsp;&nbsp;到</span><span><html:text property="ntime_to" readonly="true" /></span>
	<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('ntime_to'))" border="0" />
		<span> 
		 <html:submit property="btn_search" styleClass="button" value="查询" onclick="return checkForm();"/>
		 </span>
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="3%">
				<label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','deleteNid')"/> </label>
				</th>
				<th width="17%">通知名称</th>
				<th width="15%">发布时间</th>
				<th width="8%">发布者</th>
				<th width="16%">发布者部门</th>
				<th width="36%">通知内容</th>
				<th width="5%">修改</th>
				<!--  
				<th width="5%">附件</th>
				-->
			</tr>
			<logic:present name="IGSYM05011VO" property="noticecondList">
				<logic:iterate id="bean" name="IGSYM05011VO"
					property="noticecondList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td><label><html:checkbox
							property="deleteNid" value="${bean.nid}" /></label>
						</td>
						<td>${bean.nname}</td>
						<td>${bean.ntime}</td>
						<td>${bean.nusername}</td>
						<td>${bean.norgname}</td>
						<td>${bean.ndesc}</td>
						<td>							
								<html:link action="/IGSYM0502_Edit_Disp.do?nid=${bean.nid}">
									<img src="images/edit.gif" width="16" height="16" border="0"/>
								</html:link>			
						</td>
						<!-- 
						<td>					
						<bean:define id="ex" value="${bean.nattkey}"/>
						   <logic:notEmpty name="ex">
						   
						   <logic:iterate id="attachment" name="bean" property="attachmentList"
				              indexId="index">
						       <html:link action="/IGSYM0502_loadFIle.do?attid=${attachment.attid}">
						       
						       <bean:define id="attname" name="attachment" property="attname" />
							<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
							  
									附件${index}
								</html:link>	
						    </logic:iterate> 
						     
						   </logic:notEmpty>					   
						</td>
						 --> 
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGSYM05011VO"
		property="noticecondList">
		<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return deleteRec('deleteNid');" /></span>
	</logic:present> <!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
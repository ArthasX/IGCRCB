<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>

<html:html>
<bean:define id="id" value="IGDBM1301" toScope="request" />
<bean:define id="title" value="工作管理画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<script type="text/javascript">	
WebCalendar.timeShow   = true;          //是否返回时间
	function changeStatus(csid,csstatus,rcenddate,rcfrequency,rcstartdate){
		if(confirm("您是否确认改变状态？")){
			if("1"==csstatus){
				if (rcfrequency == 'once' && !checkDateByContent('<%=IGStringUtils.getCurrentDate() %>',rcstartdate.split(" ")[0])) {
					alert("该检查策略的执行日期早于当前日期，不能启用！");
					return;
				}
				if(!checkDateByContent('<%=IGStringUtils.getCurrentDate() %>',rcenddate.split(" ")[0])){
					alert("该检查策略的结束日期早于当前日期，不能启用！");
					return;
				}else{
					var form = document.getElementById("form");
					form.action="IGRIS0201_Change.do?csid="+csid+"&rcstatus="+csstatus;
					form.submit();
				}
			}else{
				var form = document.getElementById("form");
				form.action="IGRIS0201_Change.do?csid="+csid+"&rcstatus="+csstatus;
				form.submit();
			}

		}
	}

	function showIncident(){
		var ccid = "106";
		var cid = "";
		var syscode = "";
		if(null==syscode || ""==syscode){
			syscode = ccid;
		}else{
			ccid = syscode.substring(0,3);
		}
		url = "IGSYM1505_TREE.do" + "?ccid="+ccid+"&cid="+cid+"&syscode="+syscode;
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			$("rccategory").value="";
			$("rccategoryname").value="";
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
			$("rccategory").value=treesyscode;
			$("rccategoryname").value=name;
			
		}		
		
	}
	function isCopy(){
		if( window.confirm("是否确认复制？")){
	        return true;
	     }else{
	    	 false;
	     }
	}
	function exportExcel() {
		document.forms[0].action = getAppRootUrl() + "/IGDBM0301_Export.do";
		document.forms[0].submit();
	}
	function onsearch() {
		document.forms[0].action = getAppRootUrl() + "/IGDBM1301_Search.do";
		document.forms[0].submit();
	}
	function check(obj, message){
		if(window.confirm(message)){
			document.forms[0].action = getAppRootUrl() + obj;
			document.forms[0].submit();
		}
	}
//-->
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGDBM1301_Search" onsubmit="return checkSubmit(this);">
	
<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>查询条件</strong></span>
	</div>
	<div>
	<span class="subscribe">工作名称：</span>
	<html:text property="wmname" styleId="wmname" errorStyleClass="inputError imeDisabled" size="15" maxlength="32"  tabindex="1" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span class="subscribe">工作描述：</span>
	<html:text property="wmdesc" styleId="wmdesc" errorStyleClass="inputError imeDisabled" size="15" maxlength="32"  tabindex="1" />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span class="subscribe" >状态：</span>
	<html:select property="wmstatus">
		<html:option value=""></html:option>
		<html:option value="0">未完成</html:option>	
		<html:option value="1">已完成</html:option>												
    </html:select>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <span class="subscribe">发起人：</span>
	<html:text property="wmusername" size="15" styleId="wmusername"/>
    <br />
	<span class="subscribe">发起时间：</span>
	<html:text property="wmstartdate_from" styleId="wmstartdate_from" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:116px;" />
	<img src="images/date.gif" align="middle" onclick="calendar($('wmstartdate_from'))" border="0" style="cursor: hand" /> <span>&nbsp;--&nbsp;</span>
	<html:text property="wmstartdate_to" styleId="wmstartdate_to" errorStyleClass="inputError imeDisabled" size="16" readonly="true" style="width:116px;" />
	<img src="images/date.gif" align="middle" onclick="calendar($('wmstartdate_to'))" border="0" style="cursor: hand" /> 
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;				
   	 <span class="subscribe">频率：</span>
    <html:select property="wmfrequency">
       	<html:option value=""></html:option>
<%--        	<html:option value="once">立即发起</html:option> --%>
   		<html:option value="day">每日</html:option>
   		<html:option value="week">每周</html:option>
   		<html:option value="month">每月</html:option>
   		<html:option value="quarter">每季度</html:option>
   		<html:option value="halfyear">每半年</html:option>
   		<html:option value="year">每年</html:option>
   	</html:select>
   	&nbsp;&nbsp;&nbsp;&nbsp;
	<html:submit property="btn_search" styleClass="button" value="查询" onclick="onsearch()"/>
	&nbsp;&nbsp;&nbsp;&nbsp;
	 <html:button property="btn_search" styleClass="button" value="导出" onclick="exportExcel()" />
	</div>
	</div>
</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="15%">工作名称</th>
				<th width="15%">工作描述</th>
				<th width="7%">工作周期</th>
				<th width="8%">发起人</th>
				<th width="9%">发起时间</th>
				<th width="9%">限期完成时间</th>
				<th width="9%">实际完成时间</th>
				<th width="10%">备注</th>
				<th width="6%">状态</th>
				<th width="16%">操作</th>
			</tr>
			<logic:present name="IGDBM13011VO" property="wmList">
				<logic:iterate id="bean" name="IGDBM13011VO" property="wmList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						<td title="${bean.wmname}">
							<ig:SubstringShowEllipsisWriteTag len="10" showEllipsis="true">
							${bean.wmname}	
							</ig:SubstringShowEllipsisWriteTag>
						</td>
						<td title="${bean.wmdesc}">
							<ig:SubstringShowEllipsisWriteTag len="10" showEllipsis="true">
							${bean.wmdesc}
							</ig:SubstringShowEllipsisWriteTag>
						</td>
						<td>
<%-- 							<c:if test="${bean.wmfrequency=='once'}" >立即发起</c:if> --%>
							<c:if test="${bean.wmfrequency=='day'}" >每日</c:if>
							<c:if test="${bean.wmfrequency=='week'}" >每周</c:if>
							<c:if test="${bean.wmfrequency=='month'}" >每月</c:if>
							<c:if test="${bean.wmfrequency=='quarter'}" >每季度</c:if> 
							<c:if test="${bean.wmfrequency=='halfyear'}" >每半年</c:if>
							<c:if test="${bean.wmfrequency=='year'}" >每年</c:if>
						</td> 
						<td>${bean.wmusername}</td>
						<td>${bean.wmstartdate}</td>
						<td>${bean.wmlimitdate}</td>
						<td>${bean.wmfactdate}</td>
						<td title="${bean.wmremark}">
							<ig:SubstringShowEllipsisWriteTag len="7" showEllipsis="true">
							${bean.wmremark}
							</ig:SubstringShowEllipsisWriteTag>
						</td>
						<td><!-- 状态 -->
						<c:if test="${bean.wmstatus=='0'}" >未完成</c:if>
						<c:if test="${bean.wmstatus=='1'}" >已完成</c:if>
						</td>
						<td>
							<logic:equal name="bean" property="wmstatus" value="0">
								<a onclick="return check('/IGDBM1301_Finish.do?wmid=${bean.wmid}','是否完成？');" style="cursor: pointer;">完成</a>
						    </logic:equal>
						    <logic:equal name="bean" property="wmstatus" value="0">
						    	<html:link action="/IGDBM1302_Edit.do?wmid=${bean.wmid}">修改</html:link>
						    </logic:equal>
						    <c:if test="${bean.wmremind=='0'}" >
						    	<a onclick="return check('/IGDBM1302_Remind.do?wmid=${bean.wmid}','是否不再提醒？');" style="cursor: pointer;">不再提醒</a>
<%-- 								<html:link action="/IGDBM1302_Remind.do?wmid=${bean.wmid}">不再提醒</html:link> --%>
							</c:if>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>

</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
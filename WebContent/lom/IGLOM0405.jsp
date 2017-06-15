<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0405" toScope="request" />
<bean:define id="title" value="发票部门统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<%
  int index=1;
%>
<script type="text/javascript">	

	var gid = "IGLOM0405";

	function confirmDisp(){
		
		if(!checkDate("idate_from","idate_to")){
			alert("开始日期不能晚于结束日期！");
			return false;
		} else{
			document.forms[0].action = getAppRootUrl() + "/IGLOM0405.do";
			document.forms[0].submit();
		}
	}
	function exportExcel() {
		if(!checkDate("idate_from","idate_to")){
			alert("开始日期不能晚于结束日期！");
			return false;
		} else{
			document.forms[0].action = getAppRootUrl() + "/IGLOM0405.do?report=1";
			document.forms[0].submit();
		}
	}
	function setRoleDomain(url){
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].eiorgsyscoding.value = "";
			document.forms[0].eiorgname.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
			document.forms[0].eiorgname.value = temp.split("|")[1];
		}			

	}
	
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGLOM0405"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 发票管理 &gt;&gt; 发票部门统计</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	    <label>申请部门：</label><html:text property="eiorgname" readonly="true"></html:text>
	    <img src="images/tree.gif" style="cursor: hand;" alt="选择申请部门" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0101_TREE.do');"/>
	    <html:hidden property="eiorgsyscoding"/>
        <label>开票日期：从</label>
        <html:text property="idate_from" styleId="idate_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
        <img src="images/date.gif" align="middle" onClick="calendar($('idate_from'))" border="0" />&nbsp;&nbsp;
        <label>到</label>
        <html:text property="idate_to" styleId="itime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
        <img src="images/date.gif" align="middle" onClick="calendar($('idate_to'))" border="0"/>

	<html:button property="btn_search" styleClass="button" value="查询"  onclick="confirmDisp();"  />
	<html:button property="btn_search1" styleClass="button" value="导出"  onclick="exportExcel()"/>
	</div>
	</div>
	</div>
	
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="8%">序号</th>
			<th width="25%">部门名称</th>
			<th width="10%">发票比数</th>
			<th width="10%">总金额</th>
			<th width="10%">已付金额</th>
			<th width="10%">未付金额</th>
		</tr>
		<logic:present name="IGLOM04021VO" property="invoiceVWList">
		<logic:iterate id="bean" name="IGLOM04021VO" property="invoiceVWList" >
			<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="doLook('IGLOM0409.do?eiorgsyscoding=${bean.eiorgsyscoding}&idate_from=${IGLOM0405Form.idate_from}&idate_to=${IGLOM0405Form.idate_to}');">
                   
                    <td><%=index%></td>
                   <td><logic:empty name="bean" property="ireqemp">&nbsp;</logic:empty>
                   ${bean.ireqemp}
                   </td>
                   <td><logic:empty name="bean" property="invoicenum">&nbsp;</logic:empty>
                   ${bean.invoicenum}
                   </td>
                   <td><logic:empty name="bean" property="sumiamount">&nbsp;</logic:empty>
                   ${bean.sumiamount}
                   </td>
                    <td><logic:empty name="bean" property="sumiamounted">&nbsp;</logic:empty>
                   ${bean.sumiamounted}
                   </td>
                    <td><logic:empty name="bean" property="unsumiamounted">&nbsp;</logic:empty>
                   ${bean.unsumiamounted}
                   </td>
                   <%index++; %>
            </tr>	
        </logic:iterate>
        </logic:present>
	</table>
	</div>
	<div id="operate">
         <logic:present name="IGLOM04021VO" property="invoiceVWList" >
              
         </logic:present>
         <!-- paging -->
         <jsp:include page="/include/paging.jsp"/>
         <!-- /paging -->
    </div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM1307" toScope="request" />
<bean:define id="title" value="新进设备统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function setOrg(url){
	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].eiorgsyscoding_q.value = "";
		document.forms[0].eiorgsyscoding_qname.value = "";
		return false;
	}
	
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].eiorgsyscoding_q.value = temp.split("|")[0];
		document.forms[0].eiorgsyscoding_qname.value = temp.split("|")[1];
	}		

}

function checkForm(){
	
	if(!checkDate("ciupdtime_from","ciupdtime_to")){
		alert("查询开始时间不能晚于结束时间！");
		return false;
	}else{
		document.forms[0].action = getAppRootUrl() + "/IGASM1307.do";
		document.forms[0].submit();	
	}
	
}
function exportExcel() {
	if(!checkDate("ciupdtime_from","ciupdtime_to")){
		alert("查询开始时间不能晚于结束时间！");
		return false;
	}else{
		document.forms[0].action = getAppRootUrl() + "/IGASM1307.do?report1=1";
		document.forms[0].submit();
	}
}
function goToNewPage(eid){
	
	if(!checkDate("ciupdtime_from","ciupdtime_to")){
		alert("查询开始时间不能晚于结束时间！");
		return false;
	}else{
		var ciupdtime_from = document.forms[0].ciupdtime_from.value;
		var ciupdtime_to = document.forms[0].ciupdtime_to.value;
		var orgcode = document.forms[0].eiorgsyscoding_q.value;
		openSubWindow("/IGASM1308.do?type=1&eid="+eid+"&ciupdtime_from="+ciupdtime_from+"&ciupdtime_to="+ciupdtime_to+"&orgcode="+orgcode,'_blank', '', '');
	}
	
}
function openSubIGASM0208(url){
	openSubWindow(url,'_blank','900','600');
}
</script>
<body style="background-color: white; background-image: none;" >
<div id="maincontent">
<div id="contentainer">
<div id="location">
<div class="image"></div>
<p class="fonts1">新进设备统计</p>
</div>
	<div id="search">
<html:form styleId="form" action="/IGASM1307"
	onsubmit="return checkSubmit(this);">
	<html:hidden property="orgType" value="0"/>
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>所属机构：</span><html:text property="eiorgsyscoding_qname" readonly="true"></html:text>
	<img src="images/tree.gif" style="cursor: hand;" alt="选择管理范围" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" />
	<html:hidden property="eiorgsyscoding_q"/>&nbsp;&nbsp;
	<span>时间从：</span><html:text property="ciupdtime_from" readonly="true" />
	<img src="images/date.gif" align="middle" onClick="calendar($('ciupdtime_from'))" border="0" />&nbsp;&nbsp; 
	<span>到</span> <span> <html:text property="ciupdtime_to" readonly="true" /></span> 
	<img src="images/date.gif" align="middle" onClick="calendar($('ciupdtime_to'))" border="0" /> &nbsp;&nbsp; <span> 
    <html:submit property="btn_search" styleClass="button" value="查询"  onclick="return checkForm();"/> 
    <html:submit property="btn_search" styleClass="button" value="导出"  onclick="exportExcel()"/>
    </span></div>
	</div>
</html:form> 
	</div>
<div id="results_list"><ig:message />
<table class="table_style">
	<tr>
		<th>序号</th>
		<th>模型名称</th>
		<th>数量</th>
		<th>所占总量比例</th>
		<th>使用分布情况查询</th>
	</tr>
	<!-- body部 -->
	<logic:present name="IGASM13011VO" property="entityCountList">
		<logic:iterate id="bean" name="IGASM13011VO"
			property="entityCountList" indexId="index">
			<tr class="<ig:rowcss index="${index}"/>">
				<td>
				<div class="nowrapDiv"> ${PagingDTO.viewStartCount+index}</div>
				</td>
				<td>
				<div class="nowrapDiv">
				<logic:equal name="bean" property="total" value="0">
					${bean.cvalue}
				</logic:equal>
				<logic:notEqual name="bean" property="total" value="0">	
					<a href="javascript:openSubIGASM0208('/IGASM0208.do?esyscoding=${bean.cid}&eiupdtime_from=${IGASM1301Form.ciupdtime_from}&eiupdtime_to=${IGASM1301Form.ciupdtime_to}&eiorgsyscoding_q=${IGASM1301Form.eiorgsyscoding_q}')">
						${bean.cvalue}
					</a> 
				</logic:notEqual>
				</div>
				</td>
				<td>
				<div class="nowrapDiv">
				${bean.total}
				</div>
				</td>
				<td>
				<div class="nowrapDiv">${bean.proportion}</div>
				</td>
				<td>
				<a href="javascript:void(0)" onclick="goToNewPage('${bean.cid}')">
					<img src="images/look.gif" alt="查看分布情况" width="16" height="16" border="0"/>
				</a>
				</td>
			</tr>
		</logic:iterate>
	</logic:present>
	<logic:present name="IGASM13011VO" property="entityCountList">
		<tr>
			<td><strong>合计</strong></td>
			<td></td>
			<td><span class="red"><bean:write name="IGASM13011VO" property="total"/></span></td>
			<td></td>
			<td></td>
		</tr>
	</logic:present>
</table>
</div>
<!--	<div id="operate"><jsp:include page="/include/paging.jsp" />-->
<!--	</div>-->
</div>
 <div class="enter">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</div>
</body>
</html:html>
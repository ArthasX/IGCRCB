<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM1301" toScope="request" />
<bean:define id="title" value="设备存量统计" toScope="request" />
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
function exportExcel() {
	document.forms[0].action = getAppRootUrl() + "/IGASM1301.do?report=1";
	document.forms[0].submit();
}
function search() {
	document.forms[0].action = getAppRootUrl() + "/IGASM1301.do";
	document.forms[0].submit();
}
function openSubIGASM0208(url){
	openSubWindow(url,'_blank','900','600');
}
</script>
<body >
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
	<div id="search">
<html:form styleId="form" action="/IGASM1301"
	onsubmit="return checkSubmit(this);">
	<div class="img"></div>
	<div class="conditions">
	
	<div>
	
	<html:select property="orgType">
		<html:option value="0">所属机构</html:option>
		<html:option value="1">使用机构</html:option>
	</html:select>
	<html:text property="eiorgsyscoding_qname" readonly="true"></html:text>
	<img src="images/tree.gif" style="cursor: hand;" alt="选择管理范围" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" />
	<html:hidden property="eiorgsyscoding_q"/>&nbsp;&nbsp;
	<!-- 
	<span>时间截止至：</span><html:text property="ciupdtime_to" readonly="true" />
	<img src="images/date.gif" align="middle" onClick="calendar($('ciupdtime_to'))" border="0" />&nbsp;&nbsp;
	-->
	<span>
	<input type="hidden" name="ciupdtime_from" />
	<html:submit property="btn_search" styleClass="button" value="查询" onclick="search()"/>
    <html:submit property="btn_search" styleClass="button" value="导出"  onclick="exportExcel()"/>
	 </span>
	</div>
	</div>
</html:form> 
	</div>
<div id="results_list">
<ig:message />
<table class="table_style">
	<tr>
		<th>序号</th>
		<th>模型名称</th>
		<th>数量</th>
		<th>所占总量比例</th>
		<!-- 
		<logic:present name="form" property="orgType">
		<logic:equal name="form" property="orgType" value="0">
		<th>使用分布情况查询</th>
		</logic:equal>
		</logic:present>
		 -->
	</tr>
	<!-- body部 -->
	<logic:present name="IGASM13011VO" property="entityCountList">
		<logic:iterate id="bean" name="IGASM13011VO"
			property="entityCountList" indexId="index">
			<tr class="<ig:rowcss index="${index}"/>">
				<td>
				<div class="nowrapDiv">${PagingDTO.viewStartCount+index}</div>
				</td>
				<td>
				<div class="nowrapDiv">
				<logic:equal name="bean" property="total" value="0">
					${bean.cvalue}
				</logic:equal>
				<logic:notEqual name="bean" property="total" value="0">	
					<logic:equal name="IGASM1301Form" property="orgType" value="1">
						<a href="javascript:openSubIGASM0208('/IGASM0208.do?eistatus_q=U&esyscoding=${bean.cid}&eiupdtime_to=${IGASM1301Form.ciupdtime_to}&eiorgsyscoding_q=${IGASM1301Form.eiorgsyscoding_q}')">
						${bean.cvalue}
						</a>
					</logic:equal>
					<logic:notEqual name="IGASM1301Form" property="orgType" value="1">
						<a href="javascript:openSubIGASM0208('/IGASM0208.do?eistatus_q=&esyscoding=${bean.cid}&eiupdtime_to=${IGASM1301Form.ciupdtime_to}&eiorgsyscoding_q=${IGASM1301Form.eiorgsyscoding_q}')">
						${bean.cvalue}
						</a>
					</logic:notEqual>
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
				<!-- 
				<logic:present name="form" property="orgType">
				<logic:equal name="form" property="orgType" value="0">
				<td>
				<a href="javascript:void(0)" onclick="openSubWindow('/IGASM1308.do?eid=${bean.cid}&orgcode=${eiorgsyscoding_q}','_blank','','')">
					<img src="images/look.gif" alt="查看分布情况" width="16" height="16" border="0"/>
				</a>
				</td>
				</logic:equal>
				</logic:present>
				 -->
			</tr>
		</logic:iterate>
	</logic:present>
	<logic:present name="IGASM13011VO" property="entityCountList">
		<tr>
		    <td><strong>合计</strong></td>
			<td></td>
			<td><span class="red"><bean:write name="IGASM13011VO" property="total"/></span></td>
			<td></td>
			<!-- 
			<logic:present name="form" property="orgType">
			<logic:equal name="form" property="orgType" value="0">
			<td></td>
			</logic:equal>
			</logic:present>
			 -->
		</tr>
	</logic:present>
</table>
</div>
</div>
</div>
</div>
</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGSDL0709" toScope="request" />
<bean:define id="title" value="KPI变更明细查询" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function toback(){
	form.action = getAppRootUrl() + "/IGSDL0601.do";
	form.submit();
}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGSVC0401" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; KPI变更明细查询</p>
	</div>
	<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="3%"></th>
			<th width="8%">编号</th>
			<th width="18%">名称</th>
			<th width="11%">类型</th>
			<th width="7%">发起者</th>
			<th width="11%">发起时间</th>
			<th width="11%">执行时间</th>
			<th width="11%">结束时间</th>
			<th width="13%">状态</th>
			<th width="7%">影响程度</th>
		</tr>
		<logic:present name="IGSVC04011VO" property="processList">
			<logic:iterate id="bean" name="IGSVC04011VO" property="processList"
				indexId="index">			
				<tr>
					<td>
					<c:if test="${bean.prurgency != null and bean.prurgency > ' '}">
						 <img
							src="images/<bean:write name="bean" property="prurgency" />.gif" alt="紧急程度：<ig:codeValue ccid="WDURGENCY_GRADE_CODE"
							cid="${bean.prurgency}" />"
							border="0" />
					</c:if>
					</td>
					<td><bean:write name="bean" property="prserialnum" /></td>
					<td>
					<bean:write name="bean" property="prtitle" /></td>
					<td><bean:write name="bean" property="prpdname" /></td>
					<td><bean:write name="bean" property="prusername" /></td>
					<td><bean:write name="bean" property="propentime" /></td>
					<td><bean:write name="bean" property="prplantime" /></td>
					<td><bean:write name="bean" property="prduration" /></td>
					<td>
					<logic:notEqual value="" property="prsubstatus" name="bean">
					<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />(<ig:codeValue ccid="${bean.prtype}SUB" cid="${bean.prsubstatus}"/>)
					</logic:notEqual>
					<logic:equal value="" property="prsubstatus" name="bean">
					<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
					</logic:equal>
					</td>
					<td><ig:codeValue ccid="IMPACT_GRADE_CODE"
						cid="${bean.primpact}" /></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<html:hidden property="year" value="${IGSVC0401Form.year}"/>
	<html:hidden property="month" value="${IGSVC0401Form.month}"/>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>

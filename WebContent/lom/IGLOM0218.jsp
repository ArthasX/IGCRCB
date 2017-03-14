<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0218" toScope="request" />
<bean:define id="title" value="物品出入库统计" toScope="request" />
<!-- header1 -->
<script type="text/javascript">
var gid='IGLOM0218';
function exportExcel() {
	document.forms[0].action = "IGLOM0218.do?report=0";
	document.forms[0].submit();
}
function search() {
	document.forms[0].action = "IGLOM0218.do";
	document.forms[0].submit();	
}
</script>
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 物品出入库统计</p>
</div>
<div id="search">
<html:form action="/IGLOM0218">
<div class="img"></div>
<div class="conditions">
<div>
<span>开始时间</span>
<html:text property="giotime_f" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
<img src="images/date.gif" align="middle" onclick="calendar($('giotime_f'))" border="0" style="cursor: hand" />
<span>&nbsp;&nbsp;结束时间</span>
<html:text property="giotime_t" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
<img src="images/date.gif" align="middle" onclick="calendar($('giotime_t'))" border="0" style="cursor: hand" />
&nbsp;&nbsp;
<input type="button" value="查询" class="button" onclick="search();"/>
<input type="button" value="导出" class="button" onclick="exportExcel();"/>
</div>
</div>
</html:form>
</div>

<div id="results_list">
<ig:message/>
<table class="table_style">
	<tr>
		<th width="10%">物品种类</th>
		<th width="10%">物品名称</th>
		<th width="10%">物品编号</th>
		<th width="15%">日期</th>
		<th width="15%">入库数量</th>
		<th width="10%">出库数量</th>
		<th width="10%">类型</th>
		<th width="10%">领用机构</th>
		<th width="10%">领用人</th>
	</tr>
	
	<logic:present name="IGLOM02181VO" property="giostockdetailList">
		<logic:iterate id="bean" name="IGLOM02181VO" property="giostockdetailList" indexId="index">
			<tr>
				<td>
				<ig:projectTypeValue ptype="${bean.giodcategory}" />
				</td>
				<td>${bean.giodname}</td>
				<td>${bean.giodcode}</td>
				<td>${bean.giodtime}</td>
				<td>
					<logic:equal name="bean" property="giodtype" value="0">
						${bean.giodinnum}
					</logic:equal>
				</td>
				<td>
					<logic:notEqual name="bean" property="giodtype" value="0">
						${bean.giodinnum}
					</logic:notEqual>
				</td>
				<td>
					<ig:cseCodeValue codeIndex="<%=CodeUtils.INOUTSTOCK_TYPE %>" codeValue="${bean.giodtype}" />
				</td>
				<td>
					<logic:present name="bean" property="giodreqorg">
						<ig:cseOrgValue orgsyscoding="${bean.giodreqorg}"/>
					</logic:present>
				</td>
				<td>${bean.giodrequsername}</td>
			</tr>
		</logic:iterate>
	</logic:present>
</table>
</div>
<html:form action="/IGLOM0218">
</html:form>
<div id="operate">
	<jsp:include page="/include/paging.jsp" />
</div>

</div>
</div>
</div>
</div>
</body>
</html:html>
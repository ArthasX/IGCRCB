<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0406" toScope="request" />
<bean:define id="title" value="发票年度统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function exportExcel() {
	
		document.forms[0].action = getAppRootUrl() + "/IGLOM0406.do?report=1";
		document.forms[0].submit();

}

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGLOM0406"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 发票管理 &gt;&gt; 发票年度统计</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
       <span class="red">*</span><span>年度：</span><html:select property="iyear" errorStyleClass="inputError imeActive">
		<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false" isCodeLabel="true" />
	</html:select>

	<html:submit property="btn_search" styleClass="button" value="查询"   />
	<html:button property="btn_search1" styleClass="button" value="导出"  onclick="exportExcel()"/>
	</div>
	</div>
	</div>
	
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="8%">月份</th>
			<th width="10%">发票比数</th>
			<th width="10%">总金额</th>
			<th width="10%">已付金额</th>
			<th width="10%">未付金额</th>
		</tr>
		<logic:present name="IGLOM04021VO" property="invoiceVWList">
		<logic:iterate id="bean" name="IGLOM04021VO" property="invoiceVWList">
			<tr>
                   <td>${bean.num}</td>
                   <td>
                   <c:if test="${bean.invoicenum > 0}">${bean.invoicenum}</c:if>
					<c:if test="${bean.invoicenum == 0}">0</c:if>
                   </td>
                   <td>
                   <c:if test="${bean.sumiamount > 0}">${bean.sumiamount}</c:if>
					<c:if test="${bean.sumiamount == '0.00'}">0</c:if>
                   </td>
                    <td>
                    <c:if test="${bean.sumiamounted > 0}">${bean.sumiamounted}</c:if>
					<c:if test="${bean.sumiamounted == '0.00'}">0</c:if>
                   </td>
                    <td>
                    <c:if test="${bean.unsumiamounted > 0}">${bean.unsumiamounted}</c:if>
					<c:if test="${bean.unsumiamounted == '0.00'}">0</c:if>
                   </td>
                   
            </tr>	
        </logic:iterate>
        </logic:present>
	</table>
	</div>

</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
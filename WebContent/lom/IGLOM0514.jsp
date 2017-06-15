<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0514" toScope="request" />
<bean:define id="title" value="物品库存月统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	function checkSub(gid, goods, year, month){
		//if("合计"==gid){
		//}else{
			doLook('IGLOM0514_POP.do?goods='+goods+'&year='+year+'&month='+month+'&flag=');
		//}
		
	}
	
	function exportExcel() {
		form.action = getAppRootUrl() + "/IGLOM0514_Report.do";
		form.submit();
		form.action = getAppRootUrl() + "/IGLOM0514.do";
	}

	function exportAllExcel() {
		form.action = getAppRootUrl() + "/IGLOM0514d_Report.do?flag=all";
		form.submit();
		form.action = getAppRootUrl() + "/IGLOM0514.do";
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGLOM0514"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 物品库存月统计</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<label for='Name'>年：</label> 
	<html:select property="year"  name="IGLOM0514Form">
		<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
	</html:select>&nbsp;&nbsp;
    <label for='Name'>月：</label> 
    <html:select property="month"  name="IGLOM0514Form">
		<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
	</html:select>&nbsp;&nbsp;
	<html:submit property="btn_search" styleClass="button" value="查询" />
	<html:button property="btn_search" styleClass="button" value="导出"  onclick="exportExcel()"/>
	<html:button property="btn_search" styleClass="button" value="全明细导出"  onclick="exportAllExcel()"/>
	</div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="10%">序号</th>
			<th width="9%">物品名称</th>
			<th width="9%">入库数量</th>
			<th width="9%">出库数量</th>
			<th width="9%">最新库存</th>			
		</tr>
		<logic:present name="IGLOM05141VO" property="map">
		<logic:iterate id="bean" name="IGLOM05141VO" property="map" indexId="index">
			<bean:define id="keycode" name="bean" property="key" type="java.lang.String"/>
			<bean:define id="valuevo" name="bean" property="value" />
			<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="checkSub('<%=keycode.split("-")[0] %>', '<%=keycode.split("-")[1] %>', '<bean:write name="IGLOM0514Form" property="year" />', '<bean:write name="IGLOM0514Form" property="month" />');">
	              <td>${PagingDTO.viewStartCount+index}</td>
                  <td>
                  <%=keycode.split("-")[0] %>
                  </td>
                  <td>${valuevo.innum}</td>
                  <td>${valuevo.outnum}</td>
                  <td>${valuevo.nownum}</td>
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
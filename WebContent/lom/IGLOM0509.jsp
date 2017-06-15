<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0509" toScope="request" />
<bean:define id="title" value="部门招待统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">

function confirmDisp(obj){
	document.getElementById('etime_from').value = document.getElementById('etime_from').value.substring(0,7);
	document.getElementById('etime_to').value = document.getElementById('etime_to').value.substring(0,7);
}
function checkSearch(){
	if(!checkDateByContent("etime_from","etime_to")){
		alert("开始日期不能晚于结束日期！");
		return false;
	}else{
		return true;
	}

}
function exportExcel() {
	form.action = getAppRootUrl() + "/IGLOM0509_Report.do";
	form.submit();
	form.action = getAppRootUrl() + "/IGLOM0509.do";
}
    
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGLOM0509" onsubmit="confirmDisp(this); return checkSubmit(this)">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 部门招待统计</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>时间：从</span><span><html:text
		property="etime_from" styleId="etime_from"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('etime_from'))" border="0" style="cursor: hand" />
	</span>
	<span>&nbsp;&nbsp;到</span><span><html:text
		property="etime_to" styleId="etime_to"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('etime_to'))" border="0" style="cursor: hand" /></span>
	<span> <html:submit
		styleClass="button" value="查询" onclick="return checkSearch();"/></span>
	<html:button property="btn_search" styleClass="button" value="导出"  onclick="exportExcel()"/>
	</div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="15%">部门</th>
			<th width="10%">招待次数</th>
			<th width="15%">菜价</th>
			<th width="15%">酒价</th>
			<th width="15%">烟价</th>
			<th width="12%">其它</th>
			<th width="18%">合计</th>
			
		</tr>
		<logic:present name="IGLOM05091VO" property="deptEentertainmentList">
		<logic:iterate id="bean" name="IGLOM05091VO" property="deptEentertainmentList" indexId="index">
			<tr>	
				  <logic:equal name="bean" property="rid" value="-1">
	              <td>合计</td>
	              </logic:equal>
	              
	              <logic:notEqual name="bean" property="rid" value="-1">
	              <td>${bean.recptionTB.organizationTB.orgname}</td>
	              </logic:notEqual>
                  <td><bean:write name="bean" property="enumber" /></td>
                  <td><bean:write name="bean" property="eefoodprice" /></td>
                  <td><bean:write name="bean" property="eedrinkprice" /></td>
                  <td><bean:write name="bean" property="eesmokeprice" /></td>
                  <td><bean:write name="bean" property="eeotherprice" /></td>
                  <td><bean:write name="bean" property="etotal" /></td>
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
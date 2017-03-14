<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0508" toScope="request" />
<bean:define id="title" value="招待费用统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function checkSub(eedate){
	if("合计"==eedate){
	}else{
		doLook('IGLOM0508_POP.do?eedate='+eedate);
	}
	
}
function checkSearch(){
	if(Number($F('yearFrom')) > Number($F('yearTo'))){
		alert("结束年份不能小于开始年份！");
		return false;
	}else{
		if(Number($F('yearFrom')) == Number($F('yearTo')) && Number($F('monthFrom')) > Number($F('monthTo'))){
			alert("结束月份不能小于开始月份！");
			return false;
		}else{
			return true;
		}
	}
}


function exportExcel() {
	form.action = getAppRootUrl() + "/IGLOM0508_Report.do";
	form.submit();
	form.action = getAppRootUrl() + "/IGLOM0508.do";
}

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGLOM0508" onsubmit=" return checkSubmit(this)">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 招待费用统计</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<label for='Name'>统计开始年：</label> 
	<html:select property="yearFrom"  name="IGLOM0508Form">
		<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
	</html:select>&nbsp;&nbsp;
    <label for='Name'>月：</label> 
    <html:select property="monthFrom"  name="IGLOM0508Form">
		<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
		
	</html:select>&nbsp;&nbsp;
		<label for='Name'>统计结束年：</label> 
	<html:select property="yearTo"  name="IGLOM0508Form">
		<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
	</html:select>&nbsp;&nbsp;
    <label for='Name'>月：</label> 
    <html:select property="monthTo"  name="IGLOM0508Form">
		<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
	</html:select>&nbsp;&nbsp;
	
	<span> <html:submit
		styleClass="button" value="查询" onclick="return checkSearch();"/></span>
	<html:button property="btn_search" styleClass="button" value="导出"  onclick="exportExcel()"/>
	</div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="10%">月度</th>
			<th width="15%">招待次数</th>
			<th width="15%">菜价</th>
			<th width="15%">酒价</th>
			<th width="15%">烟价</th>
			<th width="12%">其它</th>
			<th width="18%">合计</th>
			
		</tr>
		<logic:present name="IGLOM05081VO" property="eentertainmentStatisticsList">
		<logic:iterate id="bean" name="IGLOM05081VO" property="eentertainmentStatisticsList" indexId="index">
			<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="checkSub('<bean:write name="bean" property="edate" />');">		
                  <td><bean:write name="bean" property="edate" /></td>
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
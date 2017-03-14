<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.bl.IGLOMCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGLOM0515" toScope="request" />
<bean:define id="title" value="物品库存统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">

function confirmDisp(obj){
	if($F('goods').trim()==""){
		alert("物品名称不能为空！");
		return false;
	}
	return true;
}

function exportExcel() {
	if($F('goods').trim()==""){
		alert("物品名称不能为空！");
		return false;
	}
	form.action = getAppRootUrl() + "/IGLOM0515_Report.do";
	form.submit();
	form.action = getAppRootUrl() + "/IGLOM0515.do";
	return true;
}

function clearText(){
	$("goods").value = "";
	$("giodcode").value = "";
}
function checkSearch(){
	if(!checkDateByContent("etime_from","etime_to")){
		alert("开始日期不能晚于结束日期！");
		return false;
	}else{
		return true;
	}

}
function selectSeqCode(){
	openSubWindow("/IGLOM0202.do?path=instock&gcategory="+<%=IGLOMCONSTANTS.ST_SEARCH_TYPE %> , "_blank", "800", "600");
}

function setParamLom0203(giodcode, giodname,gcategory) {
    $("goods").value = giodname;
    $("giodcode").value = giodcode;
}

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGLOM0515" onsubmit="return confirmDisp(this); return checkSubmit(this)">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 物品库存统计</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>

	<label for="Name"><span class="red">*</span><strong>物品名称</strong>：</label>
	<html:text property="goods"  size="30" readonly="true" styleClass="inputDisable" />
	<img src="images/seek.gif" style="cursor: hand;" alt="物品模型" width="16" height="16" onclick="selectSeqCode();" />
	<html:hidden property="giodcode" styleId="giodcode"/>
	
	<span>出入库日期：从</span><span><html:text
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
	<br><span> <html:submit
		styleClass="button" value="查询" onclick="return checkSearch();"/></span>
	<html:button property="btn_search" styleClass="button" value="导出"  onclick="return exportExcel();"/>
	</div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="15%">日期</th>
			<th width="10%">出入库类型</th>
			<th width="12%">入库数量</th>
			<th width="12%">出库数量</th>
			<th width="14%">库存数量</th>
			<th width="14%">部门</th>
			<th width="30%">招待活动名称</th>
			
		</tr>
		<logic:present name="IGLOM05151VO" property="singleGoodsStockList">
		<logic:iterate id="bean" name="IGLOM05151VO" property="singleGoodsStockList" indexId="index">
			<tr>	
				  <td>
				  <bean:define id="date" name="bean" property="giodtime" type="java.lang.String"></bean:define>
				  <%=date.split("-")[0] %>
				  </td>
				  <logic:equal name="bean" property="giodtype" value="0">
	              <td>入库</td>
	              </logic:equal>
	              <logic:notEqual name="bean" property="giodtype" value="0">
	              <td>出库</td>
	              </logic:notEqual>
	              
	              <logic:equal name="bean" property="giodtype" value="0">
	              <td><bean:write name="bean" property="giodinnum" /></td>
	              <td>-</td>
	              </logic:equal>
	              <logic:notEqual name="bean" property="giodtype" value="0">
	              <td>-</td>
	              <td><bean:write name="bean" property="giodinnum" /></td>
	              </logic:notEqual>
	              
                  <td><bean:write name="bean" property="giodnum" /></td>
	             <td>${bean.recptionTB.organizationTB.orgname}</td>
	             <td>${bean.recptionTB.rname}</td>
            </tr>	
        </logic:iterate>
        </logic:present>
	</table>
	</div>
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
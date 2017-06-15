<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.LOMHelper" %>
<html:html>
<bean:define id="id" value="IGLOM0585" toScope="request" />
<bean:define id="title" value="工作餐收益明细统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	
	function toback(){
		form.action = getAppRootUrl() + "/IGLOM0505.do?searchtype=M";
		form.submit();
	}
	function exportExcel() {
		form.action = getAppRootUrl() + "/IGLOM0505_Report.do?searchtype=D";
		form.submit();
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGLOM0505"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 工作餐收益统计 &gt;&gt; 工作餐明细查询</p>
	<div class="back"><a href="javascript:toback();" target="_self">返回</a></div> 
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="15%">时间</th>
			<th width="10%">原料成本</th>
			<th width="10%">酒成本</th>
			<th width="10%">其他成本</th>
			<th width="10%">成本合计</th>
			<th width="20%">餐卡名称</th>
			<th width="5%">餐卡面值</th>
			<th width="10%">餐卡数量</th>
			<th width="10%">餐费合计</th>
			
		</tr>
		<logic:present name="IGLOM05051VO" property="workLunchEateryList">
		<logic:iterate id="bean" name="IGLOM05051VO" property="workLunchEateryList" indexId="index">
            	<tr>
                  <td><bean:define id="date" name="bean" property="wldate" type="java.lang.String"></bean:define>
				  <%=date.split("-")[0] %></td>
                  
                  <td><bean:write name="bean" property="estaplecost" /></td>
                  <td><bean:write name="bean" property="eflavouringcost" /></td>
                  <td><bean:write name="bean" property="eothercost" /></td>
                  <td><bean:write name="bean" property="allcost" /></td>
                  <td><bean:write name="bean" property="lunchcardname" /></td>
                  <td><bean:write name="bean" property="lunchcardprice" /></td>
                  <td><bean:write name="bean" property="lunchcardnum" /></td>
                  <td>${bean.lunchcardprice*bean.lunchcardnum}</td>
            </tr>	
        </logic:iterate>
        </logic:present>
	</table>
	</div>
	<div id="operate">
		<div class="enter">
        	<html:button property="btn_search" styleClass="button" value="导出"  onclick="exportExcel()"/>
        </div>
    </div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0517" toScope="request" />
<bean:define id="title" value="物品库存月明细统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	
	function toback(){
		form.action = getAppRootUrl() + "/IGLOM0514.do";
		form.submit();
	}

	function exportExcel() {
		form.action = getAppRootUrl() + "/IGLOM0514d_Report.do";
		form.submit();
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGLOM0514" onsubmit="return checkSubmit(this)">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 物品库存月汇总统计 &gt;&gt; 物品库存月明细统计</p>
	<div class="back"><a href="javascript:toback();" target="_self">返回</a></div> 
	</div>
	
	<div id="results_list"><ig:message />
	<label>物品名称：</label>
	<html:text property="goodsN"  name="IGLOM0514Form" size="30" readonly="true" styleClass="inputDisable" />
	<table class="table_style">
		<tr>
			<th width="10%">日期</th>
			
			<th width="9%">入库数量</th>
			<th width="9%">出库数量</th>
			<th width="9%">最新库存</th>			
		</tr>
		<logic:present name="IGLOM05141VO" property="goodsStockList">
		<logic:iterate id="bean" name="IGLOM05141VO" property="goodsStockList" indexId="index">
			<tr>
				  <td>
				  <bean:define id="date" name="bean" property="gid" type="java.lang.String"></bean:define>
				  <%=date.split("-")[0] %>
				  </td>
                 
                  <logic:equal name="bean" property="type" value="0">
	              <td><bean:write name="bean" property="giodinnum" /></td>
	              <td>-</td>
	              </logic:equal>
	              <logic:notEqual name="bean" property="type" value="0">
	              <td>-</td>
	              <td><bean:write name="bean" property="giodinnum" /></td>
	              </logic:notEqual>
                  <td><bean:write name="bean" property="giodnum" /></td>
            </tr>	
        </logic:iterate>
        </logic:present>
	</table>
	</div>
	<div id="operate">
        <div class="enter">
        <logic:present name="IGLOM05141VO" property="goodsStockList">
			<html:button property="btn_search" styleClass="button" value="导出"  onclick="exportExcel()"/>
		</logic:present>
		</div>
    </div>
	</html:form>
	</div>
	</div>
	
</div>
</div>
<div class="zishiying"></div>
</body>
</html:html>
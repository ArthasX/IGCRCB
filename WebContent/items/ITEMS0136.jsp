<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils" %>
<html:html>
<bean:define id="id" value="ITEMS0136" toScope="request" />
<bean:define id="title" value="支行结账明细" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<script type="text/javascript">

</script>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 
<logic:equal name="ITEMS0136Form" property="mode" value="0">支行结账明细</logic:equal>
<logic:equal name="ITEMS0136Form" property="mode" value="1">汇总明细</logic:equal>
</p>
<div class="back"><a href="ITEMS0135.do?path=page&outtime_f=${ITEMS0136Form.outtime_f}&outtime_t=${ITEMS0136Form.outtime_t}" target="_self">返回</a></div>
</div>

		<div id="results_list">
        <table class="table_style">
            <tr>
                <th width="14%">机构名称</th>
                <th width="12%">领用时间</th>
                <th width="8%">出库类型</th>
                <th width="8%">物品编号</th>
                <th width="8%">物品名称</th>
                <th width="8%">物品型号</th>
                <th width="8%">物品类别</th>
                <th width="8%">结账状态</th> 
                <th width="8%">出库单价</th>
                <th width="8%">数量</th>
                <th width="10%">合计金额</th>
            </tr>
           <logic:present name="ITEMS01011VO" property="outStockList">
				<logic:iterate id="bean" name="ITEMS01011VO" property="outStockList" indexId="index">
            		<tr> 
		                <td><ig:cseOrgValue orgsyscoding="${bean.reqorg}"/></td>
		                <td>${bean.outtime }</td>
		                <td><ig:cseCodeValue codeIndex="5" codeValue="${bean.outtype}" /></td>
		                <td>${bean.seqcode }</td>
		               	<td>${bean.itemsname }</td>
		               	<td>${bean.typecode }</td>
		               	<td><ig:cseCodeValue codeIndex="1" codeValue="${bean.category}" /></td>
		               	<td><ig:cseCodeValue codeIndex="7" codeValue="${bean.accountstatus}" /></td>
		               	<td>${bean.outprice }</td>
		               	<td>${bean.outnum }</td>
		               	<td>${bean.outamount }</td>
		            </tr>
            	</logic:iterate>
            </logic:present>
            </table>
       </div>
       <div class="enter">
       <html:hidden property="outtime_f" value="${ITEMS0136Form.outtime_f}" />
       	<html:hidden property="outtime_t" value="${ITEMS0136Form.outtime_t}"/>
       	<logic:equal name="ITEMS0136Form" property="mode" value="0">
       		<html:button property="button"  value="导出" styleClass="button" 
       		onclick="location='ITEMS0136.do?reqorg=${ITEMS0136Form.reqorg}&path=exportOrg';"/>
       	</logic:equal>
		<logic:equal name="ITEMS0136Form" property="mode" value="1">
			<html:button property="button"  value="导出" styleClass="button" 
			onclick="location='ITEMS0136.do?reqorg=all&path=exportAll';" />
		</logic:equal>
       </div>
      
	
</div>
</div>
</div>
</div>
</body>
</html:html>
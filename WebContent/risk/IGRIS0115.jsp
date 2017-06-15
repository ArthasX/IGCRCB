<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>

<html:html>
<bean:define id="id" value="IGRIS0115" toScope="request" />
<bean:define id="title" value="风险检查查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function selectRiskCheckResult(rcid){
	openSubWindow('/IGRIS0115_Search.do?rcid='+rcid, '_blank','1000','600');
}
function selectRiskCheck(rcid){
	openSubWindow('/IGRIS0115_Detail.do?rcid='+rcid, '_blank','1000','600');
}
	</script>
<body>
<div id="maincontent">
<div id="location">
<div class="image"></div>
<p class="fonts1">检查项查询</p>
</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				
				<th width="15%">序号</th>
				<th width="30%">检查项名称</th>
				<th width="15%">开始日期</th>
				<th width="15%">结束日期</th>
				<th width="15%">状态</th>
				<th width="10%">查看检查结果</th>
			</tr>
			<logic:present name="IGRIS01151VO" property="riskCheckList">
				<logic:iterate id="bean" name="IGRIS01151VO"
					property="riskCheckList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						
						<td>${index+1}</td>
						<td><a href="###" onclick="selectRiskCheck('${bean.rcid}')">${bean.rcname}</a>	
						</td>
						<td>${bean.rcstartdate}</td>
						<td>${bean.rcenddate}</td>
						<td>
							  <logic:equal name="bean" property="rcstatus"  value="1">使用中
						      </logic:equal>
						      <logic:equal name="bean" property="rcstatus"  value="0">停用中
						      </logic:equal>
						</td>
						<td>
						<img src="images/look.gif" alt="查看检查项" width="16" height="16" border="0" onclick="selectRiskCheckResult('${bean.rcid}')" style="cursor: hand"/>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div class="enter">
        <input type="button" name="btn_close" value="关闭" onclick="window.close()" class="button">
	</div>
<div class="zishiying"></div>
</div>
</body>
</html:html>
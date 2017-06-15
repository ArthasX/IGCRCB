<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.risk.bl.IGRISCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGRIS0101" toScope="request" />
<bean:define id="title" value="审计版本查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
	<script type="text/javascript">	
	    function toChange(raid,rastatus){
	    	if( window.confirm("您是否确认修改状态？")){
		        form.action = getAppRootUrl() + "/IGRIS0102_Change.do?raid="+raid+"&rastatus="+rastatus;
		        form.submit();
			}
	    }
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGRIS0101" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">信息安全 &gt;&gt; 风险审计 &gt;&gt; 版本管理</p>
	</div>
	<div id="results_list">
	<ig:message/>
	<table class="table_style">
		<tr>
			<th width="20%">版本名称</th>
            <th width="15%">创建日期</th>
            <th width="15%">创建人</th>
            <th width="30%">说明</th>
            <th width="10%">状态</th>
            <th width="10%">调整</th>
		</tr>
		<logic:present name="IGRIS01011VO" property="riskAuditList">
			<logic:iterate id="bean" name="IGRIS01011VO"
				property="riskAuditList" indexId="index">
				<tr>
					<td><logic:empty name="bean" property="raversion">&nbsp;</logic:empty>${bean.raversion}</td>
					<td><logic:empty name="bean" property="radate">&nbsp;</logic:empty>${bean.radate}</td>
					<td><logic:empty name="bean" property="rausername">&nbsp;</logic:empty>${bean.rausername}</td>
					<td><logic:empty name="bean" property="radesc">&nbsp;</logic:empty>${bean.radesc}</td>
					<td><logic:empty name="bean" property="rastatus">&nbsp;</logic:empty>
					<logic:equal value="<%=IGRISCONSTANTS.RISKAUDIT_STATUS_ENABLE %>" name="bean" property="rastatus">已启用</logic:equal>
					<logic:equal value="<%=IGRISCONSTANTS.RISKAUDIT_STATUS_DISABLE %>" name="bean" property="rastatus">已停用</logic:equal>
					</td>
					<td>
					<logic:equal value="<%=IGRISCONSTANTS.RISKAUDIT_STATUS_DISABLE %>" name="bean" property="rastatus">
						<html:link  href="javascript:toChange('${bean.raid}','${bean.rastatus}')">
						<img src="images/start.gif" width="16" height="16" border="0" alt="启用" />
						</html:link>
					</logic:equal>
					<logic:equal value="<%=IGRISCONSTANTS.RISKAUDIT_STATUS_ENABLE %>" name="bean" property="rastatus">
						<html:link  href="javascript:toChange('${bean.raid}','${bean.rastatus}')">
						<img src="images/stop.gif" width="16" height="16" border="0" alt="停用" />
						</html:link>
					</logic:equal>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><html:submit property="btn_insert" value="创建版本"
			styleClass="button" onclick="window.location.href='IGRIS0102_Disp.do'" /><jsp:include page="/include/paging.jsp" /></div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>

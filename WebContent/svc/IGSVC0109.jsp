<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.LinkedHashMap"%>
<%@ page import="com.deliverik.infogovernor.prm.vo.IGPRM02011VO"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG380Info"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG259Info"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGSVC0109" toScope="request" />
<bean:define id="title" value="服务目录" toScope="request" />
<script>
function selectType(ptstartpg,flag,pdid){
	if(ptstartpg.indexOf("/") != 0){
		ptstartpg = "/"+ptstartpg;
	}
	window.location.href = '<%=request.getContextPath()%>'+ptstartpg+"?flag="+flag+"&prpdid="+pdid;
}
function selectRole(ptstartpg,pdid,ptid){
	window.location.href = "<%=request.getContextPath()%>/IGPRR0102_Disp.do?psdcode=<%=IGPRDCONSTANTS.PROCESS_START_STATUS%>&pdid="+pdid+"&ptid="+ptid;
}


</script>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
<!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
 	<div id="results_list">
 				<%
			int number = 1;
			%>
       <table class="table_style">
			<tr>
                
				<th width="10%">编号</th>
				<th width="25%">服务名称</th>
				<th width="25%">服务类型</th>
                <th width="40%">描述</th>
			</tr>
			<logic:present name="IGPRM00001VO" property="templateDefinitionMap">
			<logic:iterate id="map" name="IGPRM00001VO" property="templateDefinitionMap">
				<bean:define id="pt" name="map" property="key" type="com.deliverik.framework.workflow.prd.model.IG259Info"/>
				<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
				<logic:iterate id="pd" name="list" type="com.deliverik.framework.workflow.prd.model.IG380Info">
					<tr>
					<td><%=number++%></td>
					<td>
					<%if("ID".equals(pt.getPttype())||
							"PD".equals(pt.getPttype())||
							"CD".equals(pt.getPttype())||
							"DD".equals(pt.getPttype())||
							"SD".equals(pt.getPttype())||
							"WD".equals(pt.getPttype())){%>
							<a href="###" onclick="selectRole('${pt.ptstartpg}','${pd.pdid}','${pd.ptid}')"><bean:write name="pd" property="pdname" /></a>
					<%}else{%>
						<a href="###" onclick="selectType('${pt.ptstartpg}','0','${pd.pdid}')"><bean:write name="pd" property="pdname" /></a>
					<%}%>
					<td><bean:write name="pt" property="ptname" /></td>
					<td><bean:write name="pd" property="pddesc" /></td>
					</tr>
				</logic:iterate>
				
			</logic:iterate>
			</logic:present>
		</table>
    </div>

</div>
</div>
</div>


</div>
</body>
</html:html>
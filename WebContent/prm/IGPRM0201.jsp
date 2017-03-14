<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.prm.vo.IGPRM02011VO"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG380Info"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG259Info"%>
<%
	IGPRM02011VO vo = (IGPRM02011VO)request.getAttribute("vo");
	List<IG380Info> processDefinitionList = vo.getProcessDefinitionList();
	List<IG259Info> processTemplateList = vo.getProcessTemplateList();
%>
<html:html>
<bean:define id="id" value="IGPRM0201" toScope="request" />
<bean:define id="title" value="类型查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<script type="text/javascript">
function changeStatus(pdid){
	if(confirm("是否确认改变状态？")){
		var form = document.forms[0];
		form.action="changePDStatus.do?pdid=" + pdid;
		form.submit();
	}
}
</script>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form action="/IGPRM0201_Disp.do">
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程类型 &gt;&gt; 类型列表</p>
</div>
 	<div id="results_list">
       <table class="table_style">
			<tr>
                
				<th width="5%">编号</th>
				<th width="20%">流程模板</th>
				<th width="15%">类型名称</th>
                <th width="30%">类型描述</th>
                <th width="10%">状态</th>
                <th width="10%">调整</th>
                <th width="10%">表单信息</th>
			</tr>
			<%
				for(int i = 0; i < processDefinitionList.size(); i++) {
					IG380Info processDefinition = processDefinitionList.get(i);
					IG259Info processTemplate = processTemplateList.get(i);
			%>
				<tr><bean:define id="index" value="<%=String.valueOf(i) %>"/>
					<td>${PagingDTO.viewStartCount+index}</td>
					<td><%=processTemplate.getPtname() %></td>
                    <td><%=processDefinition.getPdname() %></td>
                    <td><pre><%=processDefinition.getPddesc()==null?"":processDefinition.getPddesc() %></pre></td>
					<td><%="a".equals(processDefinition.getPdstatus())?"使用中":"已停用" %></td>
					<td><a href="javascript:changeStatus('<%=processDefinition.getPdid() %>');">
					<img src="images/<%="a".equals(processDefinition.getPdstatus())?"stop":"start" %>.gif" border="0" alt="<%="a".equals(processDefinition.getPdstatus())?"停用":"启用" %>"/>
					</a>
					</td>
                    <td>
                    	<%if("a".equals(processDefinition.getPdstatus())){ %>
	                    <a href="IGPRM0301_Disp.do?pdid=<%=processDefinition.getPdid() %>">
	                    	<img src="images/xx.gif" alt="定义变量" border="0" />
	                    </a>
	                    <%} %>
                    </td>
				</tr>
			<%} %>
		</table>
    </div>
	<div id="operate">
		<jsp:include page="/include/paging.jsp" />
	</div>
</html:form>
</div>
</div>
</div>


</div>
</body>
</html:html>
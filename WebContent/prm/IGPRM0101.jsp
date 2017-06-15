<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.deliverik.infogovernor.prm.vo.IGPRM01011VO"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG259Info"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>
<%
	IGPRM01011VO vo = (IGPRM01011VO)request.getAttribute("vo");
	List<IG259Info> processTemplateList = vo.getProcessTemplateList();
%>
<html:html>
<bean:define id="id" value="IGPRM0101" toScope="request" />
<bean:define id="title" value="模板查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<script type="text/javascript">
function changeStatus(ptid){
	if(confirm("是否确认改变状态？")){
		var form = document.getElementById("submitForm");
		form.action="changePTStatus.do?ptid=" + ptid;
		form.submit();
	}
}

function showPic(url){
	window.showModalDialog("IGPRM0100.do?url=" + url,null,"dialogWidth:700px;dialogHeight:200px;status:no;help:no;resizable:yes");
}
</script>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<form id="submitForm" method="post" >
</form>
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程模板 &gt;&gt;模板列表</p>
</div>
 <div id="results_list">
       <table class="table_style">
			<tr>
				<th width="5%">编号</th>
				<th width="10%">模板名称</th>
				<th width="8%">模板类型</th>
                <th width="12%">起始URL</th>
                <th width="9%">创建时间</th>
                <th width="5%">状态</th>
				<th width="5%">调整</th>
				<th width="11%">流程图</th>
				<th width="14%">查看页</th>
             	<th width="13%">任务调度URL</th>
				<th width="8%">调度类型</th>
			</tr>
			
			<%
			int index = 0;
			for(IG259Info processTemplate : processTemplateList){ 
				if(IGPROCESSType.SELF_DEFINING_WORK_PRTYPE.equals(processTemplate.getPttype())){
					continue;
				}else{
			%>
				<tr>
	                <td><%=++index %></td>
					<td><%=processTemplate.getPtname() %></td>
					<td><%=processTemplate.getPttype() %></td>
					<td><%=processTemplate.getPtstartpg() %></td>
	                <td><%=processTemplate.getPtcrtdate() %></td>
	                <td><%="a".equals(processTemplate.getPtstatus())?"使用中":"已停用" %></td>
					<td>
						<a href="javascript:changeStatus(<%=processTemplate.getPtid() %>);">
						
						<img src="images/<%="a".equals(processTemplate.getPtstatus())?"stop":"start" %>.gif" border="0" alt="<%="a".equals(processTemplate.getPtstatus())?"停用":"启用" %>"/>
						
							
						</a>
					</td>
	                <td>
	                	<a href="javascript:showPic('<%=processTemplate.getPtpicinfo() %>');">
	                		<%=processTemplate.getPtpicinfo()==null?"":processTemplate.getPtpicinfo() %>
	                	</a>
	                </td>
	                <td><%=processTemplate.getPtdetailpg() %></td>
	                
	                <td><%=processTemplate.getPtsavepg()==null?"":processTemplate.getPtsavepg() %></td>
	                <td><%=processTemplate.getPtqrtzflag()==null?"":processTemplate.getPtqrtzflag() %></td>
	             </tr>
             <%
             	} 
			}	
             %>
                
		</table>
     </div>

</div>
</div>
</div>
</div>
</body>
</html:html>
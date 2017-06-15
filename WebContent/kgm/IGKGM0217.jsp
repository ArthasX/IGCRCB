<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html:html>
<bean:define id="id" value="IGKGM0217" toScope="request" />
<bean:define id="title" value="知识历史记录" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">
</script>
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent">
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGKGM0207"
	styleId="form" onsubmit="return checkSubmit(this);">
	<%-- 事件编号--%>
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">查看</p>
	
	</div>
	
	<logic:present name="IGKGM02051VO" property="voList">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="bean" name="IGKGM02051VO" property="voList" indexId="number">
				<li class="TabbedPanelsTab">
					${bean.knowledge.knversion }版
				</li>
			</logic:iterate>
		</ul>
		<div class="TabbedPanelsContentGroup">
		<logic:present name="IGKGM02051VO" property="voList">
			<logic:iterate id="vo" name="IGKGM02051VO" property="voList">
			<bean:define id="bean1" name="vo" property="knowledge" type="com.deliverik.infogovernor.kgm.model.Knowledge" />
				
				<div class="TabbedPanelsContent">
				<div class="record_list">
							<table cellspacing="2" class="table_style1">
								<tr>
									<th width="15%">标题：</th>
									<td width="35%" >
										${ bean1.kntitle}
									</td>
									
									<td width="15%"></td>
									<td width="35%" >
										
									</td>
			
			
								</tr>
								<tr>
									<th>分类：</th>
									<td>
										${bean1.knclassname}
									</td>
									<th>关键字：</th>
									<td>
										${bean1.knkey}
									</td>
								</tr>
								<tr>
									<th>归档人：</th>
										<td>
											${bean1.user.username }
										</td>
									<th>归档时间：</th>
										<td>
											${bean1.knapprovetime}
										</td>
								</tr>
								<tr>
									<th>来源：</th>
									<td>
										${bean1.knoriginname }
									</td>
									<th>知识贡献人：</th>
									<td>
										${bean1.knproffername}
									</td>
								</tr>
								<tr>
									<th>贡献时间：</th>
									<td>
										${bean1.knproffertime}
									</td>
									<th >部门：</th>
										<td >
											${bean1.kndepartment }
										</td>
								</tr>
								<tr>
									<th>技术领域：</th>
									<td>
										${bean1.kntelareaname}
									</td>
								</tr>
								<tr>
									<th>业务系统：</th>
									<td colspan="3">
									<logic:present name="vo" property="knowledgeAppImpactList">
									<logic:iterate id="bean" name="vo" property="knowledgeAppImpactList">
										<ig:codeValue ccid="BUSINESS_SYSTEM_CODE" cid="${bean.kaicode}" />&nbsp;&nbsp;
									</logic:iterate>
								</logic:present>
									</td>
								</tr>
								<tr>
									<th>问题描述：</th>
									<td colspan="3"><pre>${bean1.knfaultcause}</pre></td>
								</tr>
								<tr>
									<th>解决办法：</th>
									<td colspan="3"><pre>${bean1.knsolveway}</pre></td>
								</tr>
								<tr>
									<th>知识描述：</th>
									<td colspan="3"><pre>${bean1.kndes}</pre></td>
								</tr>
						
								<tr>
									<th>附件：</th>
									<td colspan="3">
									<logic:present name="bean1" property="attachmentList">
									<logic:iterate id="attachment" name="bean1" property="attachmentList">
						
												<html:link
													action="downloadSvcFile.do?attId=${attachment.attid}&type=kgm&filePrefix=${bean1.knserial}">
													<bean:define id="attname" name="attachment" property="attname" />
													<%if(attname.toString().substring(attname.toString().indexOf("_")+1).startsWith(bean1.getKnserial())) {%>
							<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
							<%} else{%>
							${bean1.knserial}_<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
							<%} %>
												</html:link>
												<br />
						
											</logic:iterate>
											</logic:present>
											</td>
								</tr>
							</table>
	
				</div>
				
				</div>
			</logic:iterate>
		</logic:present></div>
		</div>
	<script type="text/javascript">
	<!--
	var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
	//-->
	</script>
	</logic:present>
	
	
	
<div align="center"><ig:message /> <input type="button"
	class="button" value="关闭" onclick="window.close();"></div>
</html:form></div>
</div>

</div>


</div>
</body>
</html:html>
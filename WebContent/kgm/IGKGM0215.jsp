<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html:html>
<bean:define id="id" value="IGKGM0215" toScope="request" />
<bean:define id="title" value="知识详情页面" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">

</script>
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
	
	<logic:present name="IGKGM02051VO" property="knowledge">
	<bean:define id="knowledge" name="IGKGM02051VO" property="knowledge" type="com.deliverik.infogovernor.kgm.model.Knowledge"/>
	<div class="title">
	<div class="name">基本信息</div>
	</div>
	<div class="record_list">
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%">标题：</th>
			<td width="35%" >
				<bean:write name="knowledge" property="kntitle" />
			</td>
			
			<td width="15%"></td>
			<td width="35%" >
				
			</td>
			
			
		</tr>
		<tr>
			<th>分类：</th>
			<td>
				<bean:write name="knowledge" property="knclassname" />
			</td>
			<th>关键字：</th>
			<td>
				<bean:write name="knowledge" property="knkey" />
			</td>
		</tr>
		<tr>
			<th>归档人：</th>
				<td>
					${knowledge.user.username }
				</td>
			<th>归档时间：</th>
				<td>
					<bean:write name="knowledge" property="knapprovetime"/>
				</td>
		</tr>
		<tr>
			<th>来源：</th>
			<td>
				${knowledge.knoriginname }
			</td>
			<th>知识贡献人：</th>
			<td>
				<bean:write name="knowledge" property="knproffername" />
			</td>
		</tr>
		<tr>
			<th>贡献时间：</th>
			<td>
				<bean:write name="knowledge" property="knproffertime" />
			</td>
			<th >部门：</th>
				<td >
					<bean:write name="knowledge" property="kndepartment"/>
				</td>
		</tr>
		<tr>
		<th>技术领域：</th>
			<td>
				<bean:write name="knowledge" property="kntelareaname"/>
			</td>
		</tr>	
		<tr>
			<th>业务系统：</th>
			<td colspan="3">
				<logic:present name="IGKGM02051VO" property="knowledgeAppImpactList">
					<table id="tb2">
						<logic:iterate id="bean" name="IGKGM02051VO" property="knowledgeAppImpactList">
							<ig:codeValue ccid="BUSINESS_SYSTEM_CODE" cid="${bean.kaicode}" />
						</logic:iterate>
					</table>
					</logic:present>
			</td>
		</tr>
		<tr>
			<th>问题描述：</th>
			<td colspan="3"><pre><bean:write name="knowledge" property="knfaultcause" /></pre></td>
		</tr>
		<tr>
			<th>解决办法：</th>
			<td colspan="3"><pre><bean:write name="knowledge" property="knsolveway" /></pre></td>
		</tr>
		<tr>
			<th>知识描述：</th>
			<td colspan="3"><pre><bean:write name="knowledge" property="kndes" /></pre></td>
		</tr>

		<tr>
			<th>附件：</th>
			<td colspan="3">
			<logic:present name="knowledge" property="attachmentList">
			<logic:iterate id="attachment" name="knowledge" property="attachmentList">

						<html:link
							action="downloadSvcFile.do?attId=${attachment.attid}&type=kgm&filePrefix=${knowledge.knserial}">
							<bean:define id="attname" name="attachment" property="attname" />
							<%if(attname.toString().substring(attname.toString().indexOf("_")+1).startsWith(knowledge.getKnserial())) {%>
							<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
							<%} else{%>
							${knowledge.knserial}_<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
							<%} %>
						</html:link>
						<br />

					</logic:iterate>
					</logic:present>
					</td>
		</tr>
	</table>
	
	</div>
	
</logic:present> 
	
<logic:present name="IGKGM02051VO" property="knowledgeProcessList">
	<div class="title">
	<div class="name">参考案例</div>
	</div>
	<div class="record_list">
	<table cellspacing="2" class="table_style1">
		<tr>
			<logic:iterate id="bean" name="IGKGM02051VO" property="knowledgeProcessList" indexId="index">
					<a href="javascript:openRelatedProcess('${bean.processRecord.prid}','${bean.processRecord.prtype}');">${bean.processRecord.prtitle }</a><br/>
			</logic:iterate>
		</tr>
	</table>
	
	</div>
</logic:present> 
<div align="center"><ig:message /> <input type="button"
	class="button" value="关闭" onclick="window.close();"></div>
</html:form></div>
</div>

</div>


</div>
</body>
</html:html>
﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGKGM0223" toScope="request" />
<bean:define id="title" value="知识驳回" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">
function goPage(){
	var url = "IGKGM0214_CHECK.do";
	var knid = document.getElementsByName("knid")[0].value;
	var knversion = document.getElementsByName("knversion")[0].value;
	document.forms[0].action=url+"?knid="+knid+"&knversion="+knversion+"&knflag=0";
	document.forms[0].submit();
}
function checkForm(){
	if($F('rlcomment').trim()==""){
		alert("请添加驳回意见！");
		return false;
	}
	if($F('rlcomment').strlen()>1024){
		alert("驳回意见不能大于"+Math.floor(1024/strByteFlag)+"个汉字！");
		return false;
	}
	if(window.confirm("是否确认提交操作？")){
		var url = "IGKGM0223.do";
		var knid = document.getElementsByName("knid")[0].value;
		var knversion = document.getElementsByName("knversion")[0].value;
		document.forms[0].action=url+"?knid="+knid+"&knversion="+knversion+"&knflag=0";
		document.forms[0].submit();
        return true;
    } else {
        return false;
    }
	
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGKGM0223"
	styleId="form" onsubmit="return checkSubmit(this);">
	<%-- 事件编号--%>
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">流程管理 &gt;&gt; 知识库 &gt;&gt; 知识审批 &gt;&gt;知识驳回</p>
	<div class="back">
		<a href="javascript:goPage()" target="_self">返回</a>
	</div>
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
			<th width="15%">分类：</th>
			<td width="35%">
				<bean:write name="knowledge" property="knclassname" />
			</td>
			<th width="15%">关键字：</th>
			<td width="35%">
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
			<td><bean:write name="knowledge" property="kntelareaname"/>
			</td>
		</tr>	
		<tr>
			<th>业务系统：</th>
			<td colspan="3">
				<logic:present name="IGKGM02051VO" property="knowledgeAppImpactList">
					<table id="tb2">
						<logic:iterate id="bean" name="IGKGM02051VO" property="knowledgeAppImpactList">
<%-- 							<ig:codeValue ccid="BUSINESS_SYSTEM_CODE" cid="${bean.kaicode}" /> --%>
								<span> ${fn:split(bean.kaicode,"_")[1] }</span>
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
	<table>
		<tr>
			<td width="35%">
				
				<logic:iterate id="bean" name="IGKGM02051VO" property="knowledgeProcessList" indexId="index">
					<a href="javascript:openRelatedProcess('${bean.processRecord.prid}','${bean.processRecord.prtype}');">${bean.processRecord.prtitle }</a><br/>
				</logic:iterate>
			</td>
			
		</tr>
	</table>
	
	</div>
</logic:present> 
	<div class="title">
	<div class="name">驳回原因</div>
	</div>
	<div id="formwrapper">
		<fieldset>
			<div>
				<html:textarea property="rlcomment" cols="80" errorStyleClass="inputError imeActive"
					rows="8"></html:textarea> <br />
			</div>
		</fieldset>
		<div class="enter">
			<html:submit styleClass="button" value="提交" onclick="return checkForm();"/>
	
		</div>
	</div>
	<html:hidden name="IGKGM0215Form" property="knid"/>
	<html:hidden name="IGKGM0215Form" property="knflag"/>
	<html:hidden name="IGKGM0215Form" property="knversion"/>
</html:form></div>
</div>

</div>


</div>
</body>
</html:html>
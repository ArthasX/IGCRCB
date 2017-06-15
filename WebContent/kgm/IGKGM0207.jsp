<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGKGM0207" toScope="request" />
<bean:define id="title" value="知识详情页面" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">

<%-- 提交表单--%>
function confirmDisp(){
	
	var i;
	var v = false;
	var kggrade = document.getElementsByName("kggrade");
	
	for(i=0;i<5;i++){
		if(kggrade[i].checked == true){	
			v = true;
		}
	}
	if($F('kgappraise').strlen()>512){
		alert("评价不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
		return false;
	}
	if(v == false){
		alert("请选择评分");
		return false;
	}
	
	if($F('kgappraise').trim()==""){
		alert("请填写评价！");
		return false;
	}
	if(confirm("是否确认提交?")){
		return true;
	}
		return false;
}
	function getDetail(){
		document.forms[0].action = getAppRootUrl() + "/IGKGM0216_READ.do?knid="+$F('knid')+"&knversion="+$F('knversion');
		document.forms[0].submit();
	}

</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGKGM0207"
	styleId="form" onsubmit="return checkSubmit(this);">
	<%-- 事件编号--%>
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">流程管理 &gt;&gt; 知识库 &gt;&gt; 知识查询 &gt;&gt; 知识查看</p>
	<div class="back">
		<a href="IGKGM0205_BACK.do" target="_self">返回</a>
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
			<th>知识编号：</th>
			<td>
				<bean:write name="knowledge" property="knserial" />
			</td>
			<th>知识版本：</th>
			<td>
				<bean:write name="knowledge" property="knversion" />
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
		<div style="text-align: right;padding-top: 8px;">
			<a href="javascript:openHistoryPage('/IGKGM0229_READ.do?klkid=${IGKGM02051VO.knowledge.knid}');">查看历史记录</a>
		</div>
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
					<a href="javascript:openRelatedProcess('${bean.processRecord.prid}','${bean.processRecord.prtype}','1');">${bean.processRecord.prtitle }</a><br/>
			</logic:iterate>
		</tr>
	</table>
	
	</div>
</logic:present> 	
	
	<div class="title">
	<div class="name">评分登记</div>
	</div>
	
	<div class="record_list">
	<table cellspacing="2" class="table_style1">
		<tr>
			<th width="15%"><span id="pingjia" class="red">*</span>评分：</th>
			<td width="35%">
		
				<html:radio property="kggrade" value="5">5</html:radio>
				<html:radio property="kggrade" value="4">4</html:radio>
				<html:radio property="kggrade" value="3">3</html:radio>
				<html:radio property="kggrade" value="2">2</html:radio>
				<html:radio property="kggrade" value="1">1</html:radio>
			</td>
			
		</tr>
		<tr>
			<th width="15%"><span id="pingjia" class="red">*</span>评价：</th>
			<td width="35%">
				<html:textarea property="kgappraise" rows="6" cols="50"></html:textarea>
			</td>
			
		</tr>
		<html:hidden property="knid" value="${knowledge.knid}"/>
		<html:hidden property="knversion" value="${knowledge.knversion}"/>
	</table>
	
	</div>
	
	
	<div class="title">
	<div class="name">历史评分</div>
	</div>
	
		
			<!-- Tab页 -->
				<div class="TabbedPanelsContent">
					<table class="table_style" style="width:900px;" border="1" bordercolor="#cccccc">
						<tr>
							<th width="10%">评分人</th>
							<th width="10%">评分</th>
							<th width="10%">评分时间</th>
							<th width="30%">评价</th>	
						</tr>
					</table>
					<div style="width:900px;height:130px;overflow-y:auto;overflow-x:hidden;margin-left: 51px; ">
					<table class="table_style" style="width:900px;" border="1" bordercolor="#cccccc">
					<logic:present name="IGKGM02051VO" property="knowledgeGradeList">
						<logic:iterate id="bean" name="IGKGM02051VO"
							property="knowledgeGradeList" indexId="index">
							<tr>
								
								<!-- 评分人 -->
								<td width="10%">
								<div class="nowrapDiv"><logic:empty name="bean"
									property="user">&nbsp;</logic:empty> ${bean.user.username}</div>
								</td>
								<!-- 评分 -->
								<td width="10%">
								<div class="nowrapDiv"><logic:empty name="bean"
									property="kggrade">&nbsp;</logic:empty> ${bean.kggrade}</div>
								</td>
								<!-- 时间 -->
								<td width="10%">
								<div class="nowrapDiv"><logic:empty name="bean"
									property="kgtime">&nbsp;</logic:empty> ${bean.kgtime}</div>
								</td>
								
								<!-- 评价 -->
								<td width="30%" align="left">
								<div class="nowrapDiv"><logic:empty name="bean"
									property="kgappraise">&nbsp;</logic:empty> 
									<logic:notEmpty name="bean" property="kgappraise">
									<pre><bean:write name="bean" property="kgappraise"></bean:write></pre>
									</logic:notEmpty>
									</div>
								</td>
							</tr>
						</logic:iterate>
					</logic:present>
					</table>
				</div>
		</div>
			
			
		
	
	<div class="title">
	<div class="name"></div>
	</div>
	<div class="enter">
	<html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
	<c:if test="${versions == 0}">
	<html:button property="btn_update" value="更新" styleClass="button"  onclick="return getDetail();" />
	</c:if>
	<html:button property="btn_update" value="打印知识" styleClass="button"  onclick="javascript:openHistoryPage('/IGKGM0205_Print.do?knid=${knowledge.knid}&knversion=${knowledge.knversion}');" />
	</div>
	
</html:form></div>
</div>

</div>


</div>
</body>
</html:html>
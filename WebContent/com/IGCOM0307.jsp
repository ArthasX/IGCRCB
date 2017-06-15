<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGCOM0307" toScope="request" />
<bean:define id="title" value="配置信息版本比较画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	<!--
	var gid='IGCOM0307';
	function goComp(eiid){
		var url = "/IGASM0344_Disp.do?eiid="+eiid;
		openSubWindow(url, '_blank', '800', '600');
	}
	//-->
</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单-->
<div id="container"><!--sidebar  左菜单-->


<div id="location">
<div class="image"></div>
<p class="fonts1">配置信息版本比较</p>
</div>

<div class="title">
<div class="name">配置基本信息</div>
</div>

<div id="results_list">
<table class="table_style">
	<tr>
		<th width="10%">模型名称</th>
		<th width="13%">配置编号</th>
		<th width="15%">配置名称</th>
		<!--<c:if test="${fn:contains(IGCOM03071VO.entityData.esyscoding, '999012')==false}" ><th width="15%">资产所属机构</th></c:if>-->
		<th width="20%">配置说明</th>
		<th width="7%">管理人</th>
		<th width="10%">登记日</th>
		<th width="15%">更新时间</th>
	</tr>
	<tr>
		<td align="center">${IGCOM03071VO.entityData.ename}</td>
		<td align="center">${IGCOM03071VO.entityData.eilabel}</td>
		<td align="center">${IGCOM03071VO.entityData.einame}</td>
		<!--<c:if test="${fn:contains(IGCOM03071VO.entityData.esyscoding, '999012')==false}" ><td>${IGCOM03071VO.entityData.organizationTB.orgname}</td></c:if>-->
		<td align="center">${IGCOM03071VO.entityData.eidesc}</td>
		<td align="center">${IGCOM03071VO.entityData.eiusername}</td>
		<td align="center">${IGCOM03071VO.entityData.eiinsdate}</td>
		<td align="center">${IGCOM03071VO.entityData.eiupdtime}</td>
	</tr>
</table>
</div>
<div class="title">
<div class="name">配置信息</div>
</div>
<div class="message"><ig:message /></div>
<logic:present name="IGCOM03071VO" property="flag">
	<logic:equal value="true" name="IGCOM03071VO" property="flag">
		<logic:present name="IGCOM03071VO" property="voList">
			<div id="TabbedPanels1" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<logic:iterate id="vo" name="IGCOM03071VO" property="voList"
					indexId="number">
					<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
						ccid="CONFIGURATION_CATEGORY_CODE" cid="${vo.ccategory}" /></li>
				</logic:iterate>
			</ul>
			<div class="TabbedPanelsContentGroup"><logic:present
				name="IGCOM03071VO" property="voList">
				<logic:iterate id="vo" name="IGCOM03071VO" property="voList"
					indexId="number">
					<div class="TabbedPanelsContent">
					<div class="record_list"
					<c:choose>
							<c:when test="${IGCOM0307Form.screenWidth > 1024}">
								style="overflow:auto;width:970px;height:300px;padding-bottom:25px"
							</c:when>
							<c:otherwise>
								style="overflow:auto;width:720px;height:260px;padding-bottom:25px"
							</c:otherwise>
					</c:choose>
					>
					<table class="table_style2">
						<tr>
							<th <c:if test="${(IGCOM03071VO.versionsize) > 4 }">width="180px"</c:if>>配置项名称</th>
							<c:choose>
								<c:when test="${IGCOM03071VO.entityData.eiversion == 0 && IGCOM03071VO.entityData.eismallversion == 0 }">
								</c:when>
								<c:otherwise>
									<logic:present name="IGCOM03071VO" property="versionDate">
										<logic:iterate id="map" name="IGCOM03071VO" property="versionDate">
											<th <c:if test="${(IGCOM03071VO.versionsize) > 4 }">width="200px"</c:if>>${map.key}版(${map.value})</th>
										</logic:iterate>
									</logic:present>
								</c:otherwise>
							</c:choose>
						</tr>
						<logic:present name="vo" property="voList">
							<logic:iterate id="bean" name="vo" property="voList">
								<tr onmouseover="mouseOverNoHand(this);"
									onmouseout="mouseOutNoHand(this);"
									<c:if test="${bean.configuration.cseq == '1'}">style="display: none;"</c:if>>
									<!-- 名称 -->
									<td>
										<div class="nowrapDiv">${bean.configuration.cname}
<%-- 											<c:if test="${bean.configuration.cattach == '8'}"> --%>
<%-- 												<html:button property="btn_look" styleClass="button" value="比较" onclick="goComp('${IGCOM03071VO.entityData.eiid}');" /> --%>
<%-- 											</c:if> --%>
										</div>
									</td>
									<logic:iterate id="ci" name="bean" property="configItemList">
										<td
											<c:if test="${bean.configuration.cattach == '6'}"> align="left"</c:if>
											<c:if test="${ci.cicurver == '1'}">bgcolor="#FFFF99"</c:if>>
										<c:choose>
											<c:when test="${bean.configuration.cattach == '1'}">
												<a
													href="javascript:downloadASMFile('${ci.eiid}','${ci.ciid}');">${ci.civalue}</a>
											</c:when>
											<c:when test="${bean.configuration.cattach == '8'}">
												${ci.civalue}
											</c:when>
											<c:when test="${bean.configuration.cattach == '4'}">
												<bean:define id="ei" value="${ci.civalue}" />
												<bean:define id="civersion" value="${ci.civersion}" />
												<logic:notEmpty name="ei">
													<a href="javascript:void(0)"
														onclick="openSubIGCOM0303('<%=ei.substring(ei.lastIndexOf("(") + 1,ei.length() - 1)%>','<%=civersion%>')"><%=ei.substring(0,ei.lastIndexOf("("))%></a>
												</logic:notEmpty>
											</c:when>
											<c:when test="${bean.configuration.cattach == '6'}">
												<pre>${ci.civalue}</pre>
											</c:when>
											<c:otherwise>
											${ci.civalue}
										</c:otherwise>
										</c:choose></td>
									</logic:iterate>
								</tr>
							</logic:iterate>
						</logic:present>
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
	</logic:equal>
</logic:present>
<div class="enter"><input type="button" name="btn_close"
	value="关闭" onclick="window.close()" class="button"></div>
</div>
</div>
</body>
</html:html>
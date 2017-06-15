<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGAIM1203" toScope="request" />
<bean:define id="title" value="历史版本画面" toScope="request" />
<style>
body{
 overflow-y: auto;
}
</style>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<script type="text/javascript">
var gid='IGCOM0308';
function goLook(eiid,v,sv){
	var url = "/IGASM0341.do?eiid="+eiid+"&eiversion="+v+"&eismallversion="+sv;
	openSubWindow(url, '_blank', '800', '600');
}
</script>
<body>
<div class="title">
<div class="name">设备配置信息</div>
</div>
<div class="message"><ig:message /></div>
<logic:present name="IGCIM12031VO" property="flag">
	<logic:equal value="true" name="IGCIM12031VO" property="flag">
		<logic:present name="IGCIM12031VO" property="configItemVWInfoMap">
			<div id="TabbedPanels1" class="TabbedPanels">
			<ul class="TabbedPanelsTabGroup">
				<logic:iterate id="map" name="IGCIM12031VO" property="configItemVWInfoMap"
					indexId="number">
					<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
						ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
				</logic:iterate>

			</ul>
			<div class="TabbedPanelsContentGroup"><logic:present
				name="IGCIM12031VO" property="configItemVWInfoMap">
				<logic:iterate id="map" name="IGCIM12031VO" property="configItemVWInfoMap"
					indexId="number">
					<bean:define id="list" name="map" property="value"
						type="java.util.ArrayList" />
					<div class="TabbedPanelsContent">
					<div class="record_list">
					<table class="table_style2">
						<tr>
							<th width="4%"></th>
							<th width="20%" align="left">配置项名称</th>
							<th width="35%" align="left">配置项内容</th>
							<th width="10%">版本号</th>
						</tr>
						<logic:iterate id="bean" name="list" indexId="index">
							<tr onmouseover="mouseOverNoHand(this);"
								onmouseout="mouseOutNoHand(this);"
								<logic:equal name="bean" property="cseq" value="1">style="display: none;"</logic:equal>
								<!-- 编号 -->
								<!-- 占位调整格式使用 -->
								<td></td>
								<!-- 名称 -->
								<td align="left">
								<div class="nowrapDiv"><logic:empty name="bean"
									property="cname">&nbsp;</logic:empty>
								${bean.cname}
								
								
								</td>
								<!-- 内容 -->
								<logic:notEqual name="bean" property="cattach"
									value="6">
									<td align="left">
									<div class="nowrapDiv"><logic:notEqual name="bean"
										property="cattach" value="1">
										<logic:notEqual name="bean" property="cattach"
											value="4">
                                                ${bean.civalue}
                                                </logic:notEqual>
									</logic:notEqual> <logic:equal name="bean" property="cattach"
										value="1">
										<a
											href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
										${bean.civalue} </a>
									</logic:equal> <logic:equal name="bean" property="cattach"
										value="4">
										<bean:define id="ei" value="${bean.civalue}" />
										<bean:define id="cldVersionMap" name="IGCIM1203Form" property="cldVersionMap" type="java.util.Map"/>
										<logic:notEmpty name="ei">
											<a href="javascript:void(0)"
												onclick="openSubIGCOM0303('<%=ei.substring(ei.lastIndexOf("(") + 1,ei.length() - 1)%>','<%=cldVersionMap.get(ei.substring(ei.lastIndexOf("(") + 1,ei.length() - 1)) %>')"><%=ei.substring(0,ei.lastIndexOf("("))%></a>
										</logic:notEmpty>
									</logic:equal></div>
									</td>
								</logic:notEqual>
								<logic:equal name="bean" property="cattach"
									value="6">
									<td align="left"><pre> ${bean.civalue} </pre></td>
								</logic:equal>
								<!-- 版本号 -->
								<td>
								<div class="nowrapDiv"><logic:empty name="bean"
									property="civersion">&nbsp;</logic:empty> ${bean.civersion}<c:if test="${IGCIM12031VO.entityData.emodeltype == '1' && (bean.civersion + bean.cismallversion) > 0}">.${bean.cismallversion}</c:if></div>
								</td>
							</tr>
						</logic:iterate>
					</table>
					</div>
					</div>
				</logic:iterate>
			</logic:present></div>
			</div>
			<script type="text/javascript">
	var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
	//-->
</script>
		</logic:present>
	</logic:equal>
</logic:present>
<div class="enter">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>

</body>
</html:html>
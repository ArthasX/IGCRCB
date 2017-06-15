<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCOM0316" toScope="request" />
<bean:define id="title" value ="设备配置信息查看画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
        function goLook(eiid,v,sv){
        	var url = "/IGASM0341.do?eiid="+eiid+"&eiversion="+v+"&eismallversion="+sv;
        	openSubWindow(url, '_blank', '800', '600');
        }
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> 
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">


<html:form styleId="form" action="/IGASM0308"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	 
	<div class="title">
	<div class="name">设备基本信息</div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="10%">模型名称</th>
			<th width="14%">设备编号</th>
			<th width="15%">设备名称</th>
			<th width="15%">设备所属机构</th>
			<th width="18%">设备说明</th>
			
			<th width="10%">管理人</th>
			<th width="10%">登记日</th>
		</tr>
		<tr>
			<td align="center">${IGCOM03081VO.entityData.ename}</td>
			<td>${IGCOM03081VO.entityData.eilabel}</td>
			<td>${IGCOM03081VO.entityData.einame}</td>
			<td>${IGCOM03081VO.entityData.organizationTB.orgname}</td>
			<td>${IGCOM03081VO.entityData.eidesc}</td>
			
			<td>${IGCOM03081VO.entityData.eiusername}</td>
			<td>${IGCOM03081VO.entityData.eiinsdate}</td>
		</tr>
	</table>
</div>

	<div class="title">
	<div class="name">设备配置信息</div>
	</div>
	<div class="message"><ig:message /></div>
	<logic:present name="IGCOM03081VO" property="flag">
	<logic:equal value="true" name="IGCOM03081VO" property="flag">
	<logic:present name="IGCOM03081VO" property="configItemMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGCOM03081VO"
				property="configItemMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGCOM03081VO" property="configItemMap">
			<logic:iterate id="map" name="IGCOM03081VO"
				property="configItemMap" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
					   <th width="20%">配置项名称</th>
							<th width="35%">配置项内容</th>
							<th width="10%">版本号</th>
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);" <logic:equal name="bean" property="configuration.cseq" value="1">style="display: none;"</logic:equal>>
							<!-- 名称 -->
							
							<td >
							<div class="nowrapDiv"><logic:empty name="bean"
									property="configuration.cname">&nbsp;</logic:empty>
								${bean.configuration.cname}
								<logic:equal name="bean" property="configuration.cattach" value="8">
									<html:button property="btn_look" styleClass="button"  onclick="goLook('${bean.eiid}','${bean.civersion}','${bean.cismallversion}');">
									查看</html:button>
								</logic:equal></div>
							</td>
							<!-- 内容 -->
						<logic:notEqual name="bean" property="configuration.cattach"
									value="6">
									<td>
									<div class="nowrapDiv"><logic:notEqual name="bean"
										property="configuration.cattach" value="1">
										<logic:notEqual name="bean" property="configuration.cattach"
											value="4">
                                                ${bean.civalue}
                                                </logic:notEqual>
									</logic:notEqual> <logic:equal name="bean" property="configuration.cattach"
										value="1">
										<a
											href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
										${bean.civalue} </a>
									</logic:equal> <logic:equal name="bean" property="configuration.cattach"
										value="4">
										<bean:define id="ei" value="${bean.civalue}" />
										<logic:notEmpty name="ei">
											<a href="javascript:void(0)"
												onclick="openSubIGCOM0303('<%=ei.substring(ei.lastIndexOf("(") + 1,ei.length() - 1)%>')"><%=ei.substring(0,ei.lastIndexOf("("))%></a>
										</logic:notEmpty>
									</logic:equal></div>
									</td>
								</logic:notEqual>
								<logic:equal name="bean" property="configuration.cattach"
									value="6">
									<td align="left"><pre> ${bean.civalue} </pre></td>
								</logic:equal>
						
							
							<!-- 版本号 -->
							<td>
								<div class="nowrapDiv"><logic:empty name="bean"
									property="civersion">&nbsp;</logic:empty> ${bean.civersion}<c:if test="${IGCOM03081VO.entityData.emodeltype == '1' && (bean.civersion + bean.cismallversion) > 0}">.${bean.cismallversion}</c:if></div>
								</td>
							<!-- 更新时间 -->
							
						</tr>
					</logic:iterate>
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
	<div class="enter">
	</div>
	
	<html:hidden property="eiversion" styleId="eiversion"
		value="${IGCOM03081VO.entityData.eiversion}" />
</html:form></div>
</div>
</div>


</div>
</body>
</html:html>
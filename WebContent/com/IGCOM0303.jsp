<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCOM0303" toScope="request"/>
<bean:define id="title" value="资产详细画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<link rel="stylesheet" href="<html:rewrite forward='pop.css'/>" type="text/css">
	<script type="text/javascript">
    var gid='IGCOM0303';
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>

<body onload="startCheckOpenerClosed();">
<div id="maincontent">
<div id="container">
	    <div id="location">
	        <div class="image"></div>
	            <p class="fonts1">资产详细信息</p>
	    </div>

	    <div class="title">
	        <div class="name">资产基本信息</div>
	    </div>

	    <div id="results_list">
	       <table class="table_style">
	           <tr>
	               <th width="8%">模型名称</th>
	               <th width="11%">资产编号</th>
	               <th width="20%">资产名称</th>
	               <th width="15%">资产所属机构</th>
	               <th width="20%">资产说明</th>
	               <th width="7%">管理人</th>
	               <th width="12%">更新时间</th>
	           </tr>
	           <tr>
	               <td>${IGCOM03031VO.entityData.ename}</td>
	               <td>${IGCOM03031VO.entityData.eilabel}</td>
	               <td>${IGCOM03031VO.entityData.einame}</td>
	               <td>${IGCOM03031VO.entityData.organizationTB.orgname}</td>
	               <td>${IGCOM03031VO.entityData.eidesc}</td>
	               <td>${IGCOM03031VO.entityData.eiusername}</td>
	               <td>${IGCOM03031VO.entityData.eiupdtime}</td>
	           </tr>
	       </table>
	    </div>
	    <div class="title">
	        <div class="name">资产配置信息</div>
	    </div>
	    <div class="message"><ig:message /></div>
	    <logic:present name="IGCOM03031VO" property="flag"> 
<logic:equal value="true" name="IGCOM03031VO" property="flag">	    
		<logic:present name="IGCOM03031VO" property="configItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGCOM03031VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGCOM03031VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGCOM03031VO"
				property="configItemVWInfoMap" indexId="number">
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
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);"
						<logic:equal name="bean" property="cseq" value="1">style="display: none;"</logic:equal>>
						<!-- 编号 -->
						<!-- 占位调整格式使用 -->
						<td></td>
						<!-- 名称 -->
						<td align="left">
						<div class="nowrapDiv"><logic:empty name="bean"
							property="cname">&nbsp;</logic:empty>
						${bean.cname}</div>
						</td>
						<!-- 内容 -->
						<logic:notEqual name="bean" property="cattach" value="6">
						<td align="left">
						<div class="nowrapDiv">
						<logic:notEqual name="bean"
							property="cattach" value="1">
						<logic:notEqual name="bean"
							property="cattach" value="4">
                                                ${bean.civalue}
                                                </logic:notEqual> 
                                                </logic:notEqual> 
                                                <logic:equal
							name="bean" property="cattach" value="1">
							<a
								href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
							${bean.civalue} </a>
						</logic:equal>
						<logic:equal name="bean" property="cattach" value="4">
						<bean:define id="ei" value="${bean.civalue}"/>
						<logic:notEmpty name="ei">
						<a href="javascript:void(0)" onclick="openSubIGCOM0303('<%=ei.substring(ei.lastIndexOf("(")+1, ei.length()-1)%>','${IGCOM0303Form.civersion }')"><%=ei.substring(0,ei.lastIndexOf("("))%></a>
						</logic:notEmpty>
							</logic:equal>
						</div>
						</td>
							</logic:notEqual>
						<logic:equal name="bean" property="cattach" value="6">
							<td align="left"><pre> ${bean.civalue} </pre></td>
						</logic:equal>
						<!-- 版本号 -->
						<td>
						<div class="nowrapDiv"><logic:empty name="bean"
							property="civersion">&nbsp;</logic:empty> ${bean.civersion}<c:if test="${IGCOM03031VO.entityData.emodeltype == '1' && (bean.civersion + bean.cismallversion) > 0}">.${bean.cismallversion}</c:if></div>
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
<!--
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
//-->
</script>
	</logic:present>
	</logic:equal>
	</logic:present>
	    <div id="operate">
		        <div class="content">
			            <div class="enter">
			                <input type="button" name="btn_close" value="关闭"  onclick="window.close()" class="button">
			            </div>
		        </div> 
	    </div>
</div>
</div>
</body>
</html:html>
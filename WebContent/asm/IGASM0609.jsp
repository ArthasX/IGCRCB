<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM0609" toScope="request" />
<bean:define id="title" value="软件配置信息查看画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var gid='IGASM0609';
        function toback(){
        	form.action = getAppRootUrl() + "/IGASM0608_Back.do";
        	form.submit();
        }
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body >
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/>&gt;&gt; 软件配置查看</p>
<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>

<html:form styleId="form" action="/IGASM0604"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	<div class="title">
	<div class="name">软件基本信息</div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="10%">模型名称</th>
            <th width="15%">软件编号</th>
            <th width="20%">软件名称</th>
            <th width="10%">软件所属机构</th>
            <th width="18%">软件说明</th>
            <th width="7%">管理人</th>
            <th width="8%">登记日</th>
           
		</tr>
		<tr>
			<td align="center">${IGASM06041VO.entityData.ename}</td>
			<td>${IGASM06041VO.entityData.eilabel}</td>
			<td>${IGASM06041VO.entityData.einame}</td>
			<td>${IGASM06041VO.eiorgname}</td>
			<td>${IGASM06041VO.entityData.eidesc}</td>
			<td>${IGASM06041VO.entityData.eiusername}</td>
			<td>${IGASM06041VO.entityData.eiinsdate}</td>
			
		</tr>
	</table>
</div>

	<div class="title">
	<div class="name">软件配置信息</div>
	</div>
	<div class="message"><ig:message /></div>
	<logic:present name="IGASM06041VO" property="flag">
	<logic:equal value="true" name="IGASM06041VO" property="flag">
	<logic:present name="IGASM06041VO" property="configItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGASM06041VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGASM06041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM06041VO"
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
						<th width="30%" align="left">附件</th>
						<th width="10%">版本号</th>
						<!--th width="9%">更新时间</th-->
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);" <logic:equal name="bean" property="cseq" value="1">style="display: none;"</logic:equal>>
							<!-- 占位调整格式使用 -->
							<td></td>
							<!-- 名称 -->
							<td align="left">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="cname">&nbsp;</logic:empty> ${bean.cname}</div>
							</td>
							<!-- 内容 -->
							<logic:notEqual name="bean" property="cattach" value="6">
							<td align="left">
							<div class="nowrapDiv">
								<logic:notEqual name="bean" property="cattach" value="4">
								<logic:empty name="bean"
								property="civalue">&nbsp;</logic:empty>${bean.civalue}</logic:notEqual>
								<logic:equal name="bean" property="cattach" value="4">
						<bean:define id="ei" value="${bean.civalue}"/>
						<bean:define id="cldVersionMap" name="IGASM0604Form" property="cldVersionMap" type="java.util.Map"/>
						<logic:notEmpty name="ei">
						<a href="javascript:void(0)" onclick="openSubIGCOM0303('<%=ei.substring(ei.lastIndexOf("(")+1, ei.length()-1)%>','<%=cldVersionMap.get(ei.substring(ei.lastIndexOf("(") + 1,ei.length() - 1)) %>')"><%=ei.substring(0,ei.lastIndexOf("("))%></a>
						</logic:notEmpty>
							</logic:equal>
							</div>
							</td>
							</logic:notEqual>
						<logic:equal name="bean" property="cattach" value="6">
							<td align="left"><pre> ${bean.civalue} </pre></td>
						</logic:equal>
							<!-- 附件 -->
							<td align="left">
							<div class="nowrapDiv"><logic:equal name="bean"
								property="cattach" value="1">
								<a
									href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
								${bean.civalue} </a>
							</logic:equal></div>
							</td>
							<!-- 版本号 -->
							<td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="civersion">&nbsp;</logic:empty> ${bean.civersion}</div>
							</td>
							<!-- 更新时间 -->
							<!--td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="ciupdtime">&nbsp;</logic:empty> ${bean.ciupdtime}</div>
							</td-->
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
	<div class="enter"><html:button property="btn_back" styleClass="button" value="返回" onclick="toback()"/></div>
	<html:hidden property="eiid" styleId="eiid"
		value="${IGASM0604Form.eiid}" />
	<html:hidden property="eiversion" styleId="eiversion"
		value="${IGASM06041VO.entityData.eiversion}" />
</html:form></div>
</div>
</div>


</div>
</body>
</html:html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM1004" toScope="request" />
<bean:define id="title" value="资产项配置信息详细画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		var gid='IGASM1004';
        function toback(){
        	form.action = getAppRootUrl() + "/IGASM1004.do?org.apache.struts.taglib.html.CANCEL=1";
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
<p class="fonts1"><ig:navigation extname1="${urlable}"/>&gt;&gt; 资产配置查看</p>
<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>

<html:form styleId="form" action="/IGASM1004"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	<div class="title">
	<div class="name">资产项基本信息</div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="10%">模型名称</th>
			<th width="12%">资产编号</th>
			<th width="16%">资产名称</th>
			<th width="15%">资产所属机构</th>
			<th width="18%">资产说明</th>
			<th width="7%">管理人</th>
			<th width="10%">登记日</th>
			
		</tr>
		<tr>
			<td>${IGASM10041VO.socEntityItemVWInfo.ename}</td>
			<td>${IGASM10041VO.socEntityItemVWInfo.eilabel}</td>
			<td>${IGASM10041VO.socEntityItemVWInfo.einame}</td>
			<td>${IGASM10041VO.socEntityItemVWInfo.organizationTB.orgname}</td>
			<td><label> ${IGASM10041VO.socEntityItemVWInfo.eidesc} </label></td>
			<td align="center">${IGASM10041VO.socEntityItemVWInfo.eiusername}</td>
			<td align="center">${IGASM10041VO.socEntityItemVWInfo.eiinsdate}</td>
			
		</tr>
	</table>
	</div>

	<div class="title">
	<div class="name">资产项配置信息</div>
	</div>
	<div class="message"><ig:message /></div>
	<logic:present name="IGASM10041VO" property="socConfigItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGASM10041VO"
				property="socConfigItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGASM10041VO" property="socConfigItemVWInfoMap">
			<logic:iterate id="map" name="IGASM10041VO"
				property="socConfigItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
						<th width="4%"></th>
						<th width="20%" align="left">配置项名称</th>
						<th width="40%" align="left">配置项内容</th>
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
						<a href="javascript:void(0)" onclick="openSubIGCOM0303('<%=ei.substring(ei.lastIndexOf("(")+1, ei.length()-1)%>')"><%=ei.substring(0,ei.lastIndexOf("("))%></a>
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
							property="civersion">&nbsp;</logic:empty> ${bean.civersion}</div>
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
	<div class="enter"><html:cancel styleClass="button" value="返回" />
	</div>
	<html:hidden property="eiid" styleId="eiid"
		value="${IGASM1004Form.eiid}" />
	<html:hidden property="eiversion" styleId="eiversion"
		value="${IGASM10041VO.socEntityItemVWInfo.eiversion}" />
	<html:hidden property="eid" styleId="eid"
		value="${IGASM10041VO.entityData.eid}" />
</html:form></div>
</div>
</div>


</div>
</body>
</html:html>
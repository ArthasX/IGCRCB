<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGAIM0309" toScope="request" />
<bean:define id="title" toScope="request" >
    <bean:message bundle="asmResources" key="ietitle.IGCIM0309"/>
</bean:define>

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var gid='IGASM0323';
        function toback(){
        	form.action = getAppRootUrl() + "/IGAIM0308.do";
        	form.submit();
        }
        function goLook(eiid,v,sv){
        	var url = "/IGASM0341.do?eiid="+eiid+"&eiversion="+v+"&eismallversion="+sv;
        	openSubWindow(url, '_blank', '800', '600');
        }
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
	<div class="image"></div>
	<p class="fonts1"><bean:message bundle="asmResources" key="navigation.IGASM.AssetConfig"/>&gt;&gt; <bean:message bundle="asmResources" key="navigation.IGASM.audit"/> &gt;&gt; 
		<bean:message bundle="asmResources" key="navigation.IGASM.CISearch"/> &gt;&gt; <bean:message bundle="asmResources" key="navigation.IGASM.DeviceConfigView"/></p>
	<div class="back">
		<html:link href="javascript:toback();">
			<bean:message bundle="asmResources" key="button.IGCIM0309.btn_toback"/>
		</html:link>
	</div>
</div>

<html:form styleId="form" action="/IGAIM0308"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	<div class="title">
	<div class="name"><bean:message bundle="asmResources" key="label.IGCIM0309.DeviceInfo"/></div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="10%"><bean:message bundle="asmResources" key="label.IGCIM0309.ModelName"/></th>
			<th width="14%"><bean:message bundle="asmResources" key="label.IGCIM0309.DeviceNO"/></th>
			<th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0309.DeviceName"/></th>
			<th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0309.BelongToOrgan"/></th>
			<th width="18%"><bean:message bundle="asmResources" key="label.IGCIM0309.DeviceRemark"/></th>
			<!--<th width="8%">设备状态</th>-->
			<th width="10%"><bean:message bundle="asmResources" key="label.IGCIM0309.Manager"/></th>
			<th width="10%"><bean:message bundle="asmResources" key="label.IGCIM0309.MarkDay"/></th>
		</tr>
		<tr>
			<td align="center">${IGCIM03091VO.entityItemData.ename}</td>
			<td>${IGCIM03091VO.entityItemData.eilabel}</td>
			<td>${IGCIM03091VO.entityItemData.einame}</td>
			<td>${IGCIM03091VO.eiorgname}</td>
			<td>${IGCIM03091VO.entityItemData.eidesc}</td>
			<!--<td><ig:codeValue ccid="EQUIPMENT_STATUS_CODE" cid="${IGCIM03091VO.entityItemData.eistatus}"/></td>-->
			<td>${IGCIM03091VO.entityItemData.eiusername}</td>
			<td>${IGCIM03091VO.entityItemData.eiinsdate}</td>
		</tr>
	</table>
</div>
<logic:present name="IGCIM03091VO" property="configItemVersionTime">
<div class="title">
	<div class="name"><bean:message bundle="asmResources" key="label.IGCIM0309.historyVersionInfo"/></div>
</div>
<div id="results_list">
   <table width="100%" class="table_style" >
     <!-- header部 -->
	 <tr>
		<th width="50%"><bean:message bundle="asmResources" key="label.IGCIM0309.VersionINO"/> </th>
		<th width="50%"><bean:message bundle="asmResources" key="label.IGCIM0309.ModefyTime"/></th>
	 </tr>
		<logic:iterate id="bean" name="IGCIM03091VO" property="configItemVersionTime"
			indexId="index">
			<tr>
	       		<td>
			       <c:if test="${IGCIM03091VO.flag==true}">
			          <a href='javascript:openVersionInfoDetail(${IGCIM03091VO.entityItemData.eiid},${bean.civersion},${bean.cismallversion})'>${bean.civersion}<c:if test="${IGCIM03091VO.entityItemData.emodeltype == '1'}">.${bean.cismallversion}</c:if><bean:message bundle="asmResources" key="label.IGASM0323.VesionInfo"/></a>
			       </c:if>
			       <c:if test="${IGCIM03091VO.flag!=true}">${bean.civersion}<c:if test="${IGCIM03091VO.entityItemData.emodeltype == '1'}">.${bean.cismallversion}</c:if><bean:message bundle="asmResources" key="label.IGASM0323.VesionInfo"/></c:if>
	       		</td>
	       		<td>
	          		${bean.ciupdtime}
	       		</td>
	       </tr>
		</logic:iterate>
    </table>
    <div class="enter">
		<logic:present name="IGCIM03091VO" property="configItemVersionTime">
			<bean:size id="num" name="IGCIM03091VO" property="configItemVersionTime"/>
				<c:if test="${num > 1}">
			    	<html:button property="btn_compare" styleClass="button" style="height:20px;" onclick="openEiVersionWindow('${IGCIM03091VO.entityItemData.eiid}');" >
			    		 <bean:message bundle="asmResources" key="button.IGCIM0309.btn_compare"/> 
			    	</html:button>
    			</c:if>
		</logic:present>
	</div>
</div>
</logic:present>
	<div class="title">
	<div class="name"><bean:message bundle="asmResources" key="label.IGCIM0309.DeviceConfigInfo"/></div>
	</div>
	<div class="message"><ig:message /></div>
	<logic:present name="IGCIM03091VO" property="flag">
	<logic:equal value="true" name="IGCIM03091VO" property="flag">
	<logic:present name="IGCIM03091VO" property="configItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGCIM03091VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGCIM03091VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGCIM03091VO"
				property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
					    <th width="30px"></th>
						<th width="20%" align="left"><bean:message bundle="asmResources" key="label.IGCIM0309.ConfigName"/></th>
						<th width="35%" align="left"><bean:message bundle="asmResources" key="label.IGCIM0309.ConfigItem"/></th>
					<th width="35%"><bean:message bundle="asmResources" key="label.IGCIM0309.Attachment"/></th>
						<th width="10%"><bean:message bundle="asmResources" key="label.IGCIM0309.Version"/></th>
						<!--th width="9%">更新时间</th-->
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);" <logic:equal name="bean" property="cseq" value="1">style="display: none;"</logic:equal>>
							<!-- 名称 -->
							<td></td>
							<td align="left">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="cname">&nbsp;</logic:empty> ${bean.cname}
								<logic:equal name="bean" property="cattach" value="8">
									<html:button property="btn_look" styleClass="button"  onclick="goLook('${IGCIM03091VO.entityItemData.eiid}','${IGCIM03091VO.entityItemData.eiversion}','${IGCIM03091VO.entityItemData.eismallversion}');" >
										<bean:message bundle="asmResources" key="button.IGCIM0309.btn_view"/>
									</html:button>
								</logic:equal></div>
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
						
							<!-- 附件 -->
							<td align="center">
							<div class="nowrapDiv"><logic:equal name="bean"
								property="cattach" value="1">
								<a href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
								${bean.civalue} </a>
							</logic:equal></div>
							</td>
							<!-- 版本号 -->
							<td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="civersion">&nbsp;</logic:empty> ${bean.civersion}<c:if test="${IGCIM03091VO.entityItemData.emodeltype == '1'}">.${bean.cismallversion}</c:if></div>
							</td>
							<!-- 更新时间 -->
							<!--td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="ciupdtime">&nbsp;</logic:empty> ${bean.ciupdtime}</div>
							</td -->
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
</script>
	</logic:present>
	</logic:equal>
	</logic:present>
	<div class="enter">
		<html:button property="btn_back" styleClass="button"  onclick="toback()">
			<bean:message bundle="asmResources" key="button.IGCIM0309.btn_toback"/>
		</html:button>
	</div>
	<html:hidden property="eiid" styleId="eiid"
		value="${IGCIM0309Form.eiid}" />
	<html:hidden property="eiversion" styleId="eiversion"
		value="${IGCIM03091VO.entityItemData.eiversion}" />
</html:form></div>
</div>
</div>


</div>
</body>
</html:html>
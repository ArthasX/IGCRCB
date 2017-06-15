<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM0204" toScope="request" />
<bean:define id="title" value="配置项配置信息编辑画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		var gid='IGASM0204';
		WebCalendar.timeShow   = true;          //是否返回时间
		function confirmDisp(){
			
			if($F('eiorgsyscoding').strlen()>32){
	    		alert("所属机构只能为32位以下的字符！");
	    		return false;
	    	}
//			if($F('eistatus').strlen()>1){
//	    		alert("资产状态只能为1位字符！");
//	    		return false;
//	    	}
			
			var message1 = '<bean:message key="IGCO10000.W003" arg0="资产配置项信息" />';
            if( window.confirm(message1)){
                return true;
            } else {
                return false;
            }
		}
		
        function toback(){
        	form.action = getAppRootUrl() + "/IGASM0204.do?org.apache.struts.taglib.html.CANCEL=1";
        	form.submit();
        }
        var num = 0;
        function selectEntityItem(obj,index){
            num = index;
			openSubIGCOM0302PARAM("?esyscoding="+obj);
       }
        function setParamIGCOM0302(eid, elabel, ename, eiid, eilabel, einame, ecategory) {
            if(einame == "" && eilabel =="" ){
	            $("civalue["+num+"]").value = "";
            }else{
	            $("civalue["+num+"]").value = einame+"("+eiid+")";
            }
            num = 0;
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
<p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 资产配置项编辑</p>
<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>

<html:form styleId="form" action="/IGASM0204"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	<div class="title">
	<div class="name">配置项基本信息</div>
	</div>
	<div id="results_list">
		<table class="table_style">
			<tr>
				<th width="10%">模型名称</th>
	            <th width="8%">资产编号</th>
	            <th width="20%">资产名称</th>
	            <th width="25%">资产说明</th>
	            <th width="10%">所属机构</th>
	            <th width="7%">管理人</th>
	            <th width="10%">登记日</th>
	            
			</tr>
			<tr>
				<td align="center">${IGASM02041VO.entityData.ename}</td>
				<td align="center">${IGASM02041VO.entityData.eilabel}</td>
				<td align="center">${IGASM02041VO.entityData.einame}</td>
				<td align="center">
					<label><html:text property="eidesc" size="40" 
					errorStyleClass="inputError" styleClass="input1" /></label>
				</td>
				<td align="center">
				<label><html:text property="eiorgsyscoding"
					errorStyleClass="inputError" styleClass="input1" /></label>
				</td>
				<td align="center">${IGASM02041VO.entityData.eiusername}</td>
				<td align="center">${IGASM02041VO.entityData.eiinsdate}</td>
				
			</tr>
		</table>
	</div>
	<div class="title">
	<div class="name">配置信息</div>
	</div>
	<div class="message"><ig:message /></div>
	<logic:present name="IGASM02041VO" property="flag">
	<logic:equal value="true" name="IGASM02041VO" property="flag">	
		<logic:present name="IGASM02041VO" property="configItemVWInfoMap">
	<div id="TabbedPanels1" class="TabbedPanels">
	<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGASM02041VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>
		
	</ul>
	<div class="TabbedPanelsContentGroup"><logic:present
		name="IGASM02041VO" property="configItemVWInfoMap">
		<logic:iterate id="map" name="IGASM02041VO"
			property="configItemVWInfoMap" indexId="number">
			<bean:define id="list" name="map" property="value"
				type="java.util.ArrayList" />
			<div class="TabbedPanelsContent">
			<div class="record_list">
			<table class="table_style2">
				<tr>
					<th width="15%">配置项名称</th>
					<th width="30%">配置项内容</th>
					<th width="25%">配置项说明</th>
					<th width="20%">附件</th>
					<th width="10%">版本号</th>
				</tr>
				<logic:iterate id="bean" name="list" indexId="index">
					<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
						<!-- 名称 -->
						<td>
						<div class="nowrapDiv"><logic:empty name="bean"
							property="cname">&nbsp;</logic:empty> ${bean.cname}</div>
						</td>
						<!-- 内容 -->
						<td align="center">
						<div class="nowrapDiv"><logic:equal name="bean"
							property="cattach" value="1">
							<html:file property="attachFile[${ADcount}]"
								styleId="attachFile[${ADcount}]" size="30"
								errorStyleClass="inputError imeDisabled"
								onkeydown="return false;" styleClass="imeDisabled" />
							<html:hidden property="civalue[${ADcount}]" styleId="civalue" />
						</logic:equal> <logic:equal name="bean" property="cattach" value="0">
							<%
								if (index.intValue() % 2 == 0) {
							%>
							<html:text property="civalue[${ADcount}]" styleId="civalue"
								size="40" errorStyleClass="inputError"
								styleClass="input1" />
							<%
								} else {
							%>
							<html:text property="civalue[${ADcount}]" styleId="civalue"
								size="40" errorStyleClass="inputError"
								styleClass="input1" />
							<%
								}
							%>
						</logic:equal>
						<logic:equal name="bean" property="cattach" value="2">
								<html:select property="civalue[${ADcount}]" style="width:53.5%;" errorStyleClass="inputError imeActive">
									<html:options collection="ADlist${ADmapcount}" property="value" name="" labelProperty="label" />
								</html:select>
								<c:set var="ADmapcount" value="${ADmapcount+1}"/>
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="3">
								<html:text property="civalue[${ADcount}]" styleId="civalue[${ADcount}]" 
								errorStyleClass="inputError imeDisabled" size="20" readonly="true" />
								<img src="images/date.gif" align="middle" 
								onclick="calendar($('civalue[${ADcount}]'))" border="0" style="cursor: hand" />
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="4">
								<html:text property="civalue[${ADcount}]" styleId="civalue[${ADcount}]" 
								errorStyleClass="inputError imeDisabled" size="30" readonly="true" />
								<img src="images/seek.gif" border="0" width="16" height="16" alt="查询" onclick="selectEntityItem('${bean.coption}','${ADcount}')" style="cursor: hand"/> <br />
							</logic:equal>
						</div>
						</td>
						<!-- 配置项说明 -->
						<td align="center">
						<div class="nowrapDiv"><logic:empty name="bean"
							property="cdesc">&nbsp;</logic:empty> ${bean.cdesc}</div>
						</td>
						<!-- 附件 -->
						<td align="center">
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
						<td align="center">
						<div class="nowrapDiv"><logic:empty name="bean"
							property="ciupdtime">&nbsp;</logic:empty> ${bean.ciupdtime}</div>
							<html:hidden property="ciid" styleId="ciid" value="${bean.ciid}" />
					<html:hidden property="cid" styleId="cid" value="${bean.cid}" />
					<html:hidden property="clabel" styleId="clabel"
						value="${bean.clabel}" />
					<html:hidden property="ciattach" styleId="ciattach"
						value="${bean.cattach}" />
					<html:hidden property="eid" styleId="eid"
						value="${bean.eid}" />
					<html:hidden property="esyscoding" styleId="esyscoding"
						value="${bean.esyscoding}" />
						</td>
					</tr>
					
					<c:set var="ADcount" value="${ADcount+1}"/>
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
	<logic:present name="IGASM02041VO" property="flag">
	<logic:equal value="true" name="IGASM02041VO" property="flag">
	<html:submit property="btn_insert" value="保存" styleClass="button" onclick="return confirmDisp();" /> 
	</logic:equal>
	</logic:present>
	<html:cancel styleClass="button" value="返回" /></div>
	<html:hidden property="eiid" styleId="eiid" value="${IGASM0204Form.eiid}" />
	<html:hidden property="eiversion" styleId="eiversion" value="${IGASM02041VO.entityData.eiversion}" />
</html:form></div>
</div>
</div>
</div>
</body>
</html:html>
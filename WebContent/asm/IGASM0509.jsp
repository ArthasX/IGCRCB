<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM0509" toScope="request" />
<bean:define id="title" value="文档配置信息查看画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
var gid='IGASM0509';
function toback(){
	form.action = getAppRootUrl() + "/IGCRC1301.do";
	form.submit();
}

function init(){
	var a = document.getElementById("tab1").rows[10].cells[2].innerText;
	if(a.trim()=='否'){
		var download = document.getElementById("download");
		download.removeAttribute("href");
	}
}

function selectVersion(){
	var a = document.getElementById("selecteiversion").value;
	var eiid=document.getElementById("eiid").value;
	if(document.getElementById("isModify").value == '1' && document.getElementById("eiversion").value == a){
		window.location.href="IGASM0504_Disp.do?eiid="+eiid+"&eiversion="+a;
	}else{
		window.location.href="IGASM0509_Disp.do?eiid="+eiid+"&eiversion="+a;
	}
	
	
  }
</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body onload="init()">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">
	 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/>&gt;&gt; 文档配置查看</p>
<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>

<html:form styleId="form" action="/IGASM0504"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	<div class="title">
	<div class="name">文档基本信息</div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
            <th width="20%">文档名称</th>
            <th width="20%">文档所属机构</th>
            <th width="20%">文档说明</th>
            <th width="20%">管理人</th>
            <th width="20%">登记日</th>
           
		</tr>
		<tr>
			<td>${IGASM05041VO.entityData.einame}</td>
			<td>${IGASM05041VO.eiorgname}</td>
			<td>${IGASM05041VO.entityData.eidesc}</td>
			<td>${IGASM05041VO.entityData.eiusername}</td>
			<td>${IGASM05041VO.entityData.eiinsdate}</td>
			
		</tr>
	</table>
</div>

	<div class="title">
	<div class="name">文档配置信息</div>
	</div>
	<div class="message"><ig:message /></div>
	<logic:present name="IGASM05041VO" property="flag">
	<logic:equal value="true" name="IGASM05041VO" property="flag"> 
	<logic:present name="IGASM05041VO" property="configItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGASM05041VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
					<li>
					<html:select property="selecteiversion" onchange="selectVersion();">
					<option value="">版本选择&nbsp&nbsp当前版本${IGASM0504Form.selecteiversion}.0 </option>
					 <logic:present name="IGASM05041VO" property="checkVersionMap" >
					 <logic:iterate id="versionMap" name="IGASM05041VO" property="checkVersionMap" indexId="index">
						<option value="${versionMap.value}">版本选择&nbsp&nbsp第&nbsp&nbsp ${versionMap.value} &nbsp&nbsp版</option>
					   </logic:iterate>
					  </logic:present>
					</html:select>
					</li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGASM05041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM05041VO"
				property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2" id = "tab1">
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
						<bean:define id="cldVersionMap" name="IGASM0504Form" property="cldVersionMap" type="java.util.Map"/>
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
								<a id="download"
									href="javascript:downloadFile('${bean.eiid}','${bean.ciid}');">
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
		value="${IGASM0504Form.eiid}" />
	<html:hidden property="eiversion" styleId="eiversion"
		value="${IGASM05041VO.entityData.eiversion}" />
	<html:hidden property="isModify" styleId="isModify" value="${IGASM0504Form.isModify}" />
	</html:form></div>
</div>
</div>


</div>
<script type="text/javascript">

function downloadFile(eiid, ciid){
	var param = "";
	var type = "asm";
	param = $H({type: type, eiid: eiid, ciid:ciid}).toQueryString();
	openSubWindow('/download.do?flag=1&' + param, '','800','600');
}

</script>
</body>

</html:html>
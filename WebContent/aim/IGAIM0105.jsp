<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGAIM0105" toScope="request" />
<bean:define id="title"  toScope="request" >
	<bean:message bundle="asmResources" key="ietitle.IGCIM0105"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var gid='IGCIM0105';
	function toback() {
		form.action = getAppRootUrl() + "/IGAIM0105_Back.do?btn_back=1";
		form.submit();
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1"><bean:message bundle="asmResources" key="navigation.IGASM.assetConfig"/> &gt;&gt; <bean:message bundle="asmResources" key="navigation.IGASM.deviceAsset"/> &gt;&gt;
		 <bean:message bundle="asmResources" key="navigation.IGASM.deviceManager"/> &gt;&gt;<bean:message bundle="asmResources" key="navigation.IGASM.historyVersion"/></p>
<div class="back"><html:link href="javascript:toback();">
                       <bean:message bundle="asmResources" key="button.IGCIM0105.btn_toback"/> 
                  </html:link></div>
</div>



<div class="title">
<div class="name"><bean:message bundle="asmResources" key="label.IGCIM0105.DeviceInfo"/></div>
</div>

<div id="results_list">
<table class="table_style">
	<tr>
		<th width="8%"><bean:message bundle="asmResources" key="label.IGCIM0105.ModelName"/></th>
		<th width="12%"><bean:message bundle="asmResources" key="label.IGCIM0105.DeviceNO"/></th>
		<th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0105.DeviceName"/></th>
		<th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0105.DeviceOrgan"/></th>
		<th width="20%"><bean:message bundle="asmResources" key="label.IGCIM0105.DeviceRemark"/></th>
		<!--<th width="8%">设备状态</th>-->
		<th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0105.DeviceManager"/></th>
		<th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0105.DeviceMarkDay"/></th>
		
	</tr>
	<tr>
		<td align="center">${IGCIM01051VO.entityData.ename}</td>
		<td align="center">${IGCIM01051VO.entityData.eilabel}</td>
		<td align="center">${IGCIM01051VO.entityData.einame}</td>
		<td align="center">${IGCIM01051VO.eiorgname}</td>
		<td align="center">${IGCIM01051VO.entityData.eidesc}</td>
		<!--<td><ig:codeValue ccid="EQUIPMENT_STATUS_CODE"
			cid="${IGCIM01051VO.entityData.eistatus}" /></td>-->
		<td align="center">${IGCIM01051VO.entityData.eiusername}</td>
		<td align="center">${IGCIM01051VO.entityData.eiinsdate}</td>
		
	</tr>
</table>
</div>

<div class="title">
<div class="name"><bean:message bundle="asmResources" key="label.IGCIM0105.historyVersionInfo"/></div>
</div>
<div class="message"><ig:message /></div>
 <div id="results_list">
    <table width="100%" class="table_style" >
      <!-- header部 -->
		 <tr>
			<th width="25%"><bean:message bundle="asmResources" key="label.IGCIM0105.VersionINO"/> </th>
			<c:if test='${IGCIM01051VO.entityData.eirootmark != null && IGCIM01051VO.entityData.eirootmark != ""}'>
			<th width="25%"><bean:message bundle="asmResources" key="label.IGCIM0105.BelongRelationshipDiagram"/></th>
			</c:if>
			<th width="50%"><bean:message bundle="asmResources" key="label.IGCIM0105.ModefyTime"/></th>
		 </tr>
		 <logic:present name="IGCIM01051VO" property="configItemVersionTime">
			<logic:iterate id="bean" name="IGCIM01051VO" property="configItemVersionTime"
				indexId="index">
				<tr>
		       		<td>
				       <c:if test="${IGCIM01051VO.flag==true}">
				          <a href='javascript:openVersionInfoDetail(${IGCIM01051VO.entityData.eiid},${bean.civersion},${bean.cismallversion})'>${bean.civersion}<c:if test="${IGCIM01051VO.entityData.emodeltype == '1'}">.${bean.cismallversion}</c:if><bean:message bundle="asmResources" key="label.IGCIM0105.Vesion"/></a>
				       </c:if>
				       <c:if test="${IGCIM01051VO.flag!=true}">${bean.civersion}<c:if test="${IGCIM01051VO.entityData.emodeltype == '1'}">.${bean.cismallversion}</c:if><bean:message bundle="asmResources" key="label.IGCIM0105.Vesion"/></c:if>
		       		</td>
		       		<c:if test='${IGCIM01051VO.entityData.eirootmark != null && IGCIM01051VO.entityData.eirootmark != ""}'>
			       		<td>
        		 			<a href="javascript:void(0)" onclick="openSubIGCIM0146('${IGCIM01051VO.entityData.eirootmark}','${IGCIM01051VO.entityData.eiid}','${bean.civersion}','${bean.cismallversion}')"><img src="images/relationships.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0101.belongrelationshipDiagram.alt"/>' width="16" height="16"  border="0"/></a>
			       		</td>
					</c:if>
		       		<td>
		          		${bean.ciupdtime}
		       		</td>
		       </tr>
			</logic:iterate>
		</logic:present>
     </table>
 </div>
 
<div class="enter">
	<html:form styleId="form"  action="/IGCIM0105_Back" onsubmit="return checkSubmit(this);">
	<c:if test="${IGCIM01051VO.flag==true}">
		<logic:present name="IGCIM01051VO" property="configItemVersionTime">
			<bean:size id="num" name="IGCIM01051VO" property="configItemVersionTime"/>
				<c:if test="${num > 1}">
			    	<html:button property="btn_compare" styleClass="button"  onclick="openEiVersionWindow('${IGCIM01051VO.entityData.eiid}');" >
			    		 <bean:message bundle="asmResources" key="button.IGCIM0105.btn_compare"/> 
			    	</html:button>	
    			</c:if>
		</logic:present>
	</c:if>
		<html:submit property="btn_back" styleClass="button"  >
			 <bean:message bundle="asmResources" key="button.IGCIM0105.btn_toback"/> 
		</html:submit>
	</html:form>
</div>


</div>
</div>
</div>


</div>
</body>
</html:html>
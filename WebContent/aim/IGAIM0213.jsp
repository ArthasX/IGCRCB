<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGAIM0213" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0213" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function setParamIGCOM0327(eid, elabel, ename, eiid, eilabel, einame, ecategory) {
    $("eilabel").value = eilabel;
    $("eiid").value = eiid;
}
function selectEntityItem(){
	 openSubIGCOM0327PARAM("?flag=true");
   }
function clearParentValue(){
    if(!window.opener.closed){
        window.opener.setParamIGCOM0327("", "", "", "", "", "" ,"");
    }
    window.close();
}
function check(){
	if($F('eilabel').trim()!=""){
		if($F('typeId').trim()=="2"){
			alert('<bean:message bundle="asmResources" key="message.IGCIM0213.001"/>');
    		return false;
		}
	}
}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGAIM0213"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
		<ig:navigation extname1="${urlable}"/>
	</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div class="conditions_border1">
	<div><label>&nbsp;&nbsp; 
<%-- 	<bean:message bundle="asmResources" key="label.IGCIM0213.name" /> </label>  --%>
<%-- 	<html:select name="IGCIM0213Form" styleId="eiddid" property="eiddid" style="width: 130px;" errorStyleClass="inputError"> --%>
<%-- 	 		<html:options collection="ADDomainList" property="value" name="" labelProperty="label"/> --%>
<%-- 	</html:select> --%>
	<!-- 
	 <label>&nbsp;&nbsp; 
	<bean:message bundle="asmResources" key="label.IGCIM0213.CIName" /> </label>
	<html:select name="IGCIM0213Form" styleId="typeId" property="typeId" style="width: 130px;" errorStyleClass="inputError">
	 		<html:options collection="ADTypeList" property="value" name="" labelProperty="label"/>
	</html:select>
	 -->
	<label>
	&nbsp;&nbsp; 
	<bean:message bundle="asmResources" key="label.IGCIM0213.Incidence" /></label>
	<html:text property="eilabel" styleId="eilabel" size="18" style="width:85" errorStyleClass="inputError imeActive" tabindex="3" readonly="true"/>
	<img src="images/seek.gif" width="16" height="16" alt='<bean:message bundle="asmResources" key="img.IGCIM0213.search.alt"/>' onclick="selectEntityItem()" style="cursor: hand"/>
	<html:hidden property="eiid" styleId="eiid" name="IGCIM0213Form"/>
	<html:hidden property="typeId" styleId="typeId" name="IGCIM0213Form" value="1"/>
		<html:submit property="btn_search" styleClass="button" onclick="return check();">
		<bean:message bundle="asmResources" key="button.IGCIM0213.btn_search" />
		</html:submit>
	</div>
	</div>
	</div>

	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="4%"><label> </label></th>
<%-- 			<th width="15%"><bean:message bundle="asmResources" --%>
<%-- 				key="title.IGCIM0213.name" /></th> --%>
<%-- 			<th width="15%"><bean:message bundle="asmResources" --%>
<%-- 				key="title.IGCIM0213.version" /></th> --%>
			<th width="10%"><bean:message bundle="asmResources"
				key="title.IGCIM0213.CIName" /></th>
			<th width="15%"><bean:message bundle="asmResources"
				key="title.IGCIM0213.CIVersion" /></th>
			<th width="15%"><bean:message bundle="asmResources"
				key="title.IGCIM0213.createtime" /></th>
			<th width="10%"><bean:message bundle="asmResources"
				key="title.IGCIM0213.Incidence" /></th>	
		</tr>
		<!-- body部 -->
		<logic:present name="IGCIM02131VO" property="eilabel">
		<logic:notEmpty name="IGCIM02131VO" property="eilabel">
			<logic:present name="IGCIM02131VO" property="soc0136infoList">
			<logic:iterate id="bean" name="IGCIM02131VO"
				property="soc0136infoList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td>${(PagingDTO.viewPage-1)*PagingDTO.pageDispCount + index+1}</td>
					<!-- CI名称-->
					<td>
					<div class="nowrapDiv">${bean.einame}</div>
					</td>
					<!-- CI版本-->
					<td>
					<div class="nowrapDiv">${bean.eiversion}</div>
					</td>
					<!-- 创建时间-->
					<td>
					<div class="nowrapDiv">${bean.eiupdtime}</div>
					</td>
					<!-- 影响图-->
			        <td>
			        <div class="nowrapDiv">
			            <logic:notEqual name="bean" property="eircount" value="0">
	                    <a href="javascript:void(0)" onclick="openSubIGCOM0310('${bean.eiid}','${bean.domainid}','${bean.domainversion}','${bean.eiupdtime}','${IGCIM0213Form.eiid}')"><img src="images/relationships.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0213.Incidence.alt"/>' width="16" height="16"  border="0"/></a>
	                   </logic:notEqual>
	                   <logic:equal name="bean" property="eircount" value="0">
	                    <img src="images/unrelationships.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0213.norelationship.alt"/>' width="16" height="16"  border="0"/>
	                   </logic:equal>
			        </div>
			       </td>
				</tr>
			</logic:iterate>
		</logic:present>
		</logic:notEmpty>
		</logic:present>
		<logic:present name="IGCIM02131VO" property="soc0138InfoList">
			<logic:iterate id="bean" name="IGCIM02131VO"
				property="soc0138InfoList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
				<td></td>
<%-- 					<td>${(PagingDTO.viewPage-1)*PagingDTO.pageDispCount + index+1}</td>  --%>

					<!-- CI名称-->
					<td>
					<div class="nowrapDiv">${bean.einame}</div>
					</td>
					<!-- CI版本-->
					<td>
					<div class="nowrapDiv">${bean.eiImportversion}</div>
					</td>
					<!-- 创建时间-->
					<td>
					<div class="nowrapDiv">${bean.createtime}</div>
					</td>
					<!-- 影响图-->
			        <td>
			        <div class="nowrapDiv">
		         	<logic:notEqual name="bean" property="eircount" value="0">
                    <a href="javascript:void(0)" onclick="openSubIGCOM0310('${bean.eiid}','${bean.eiDomainDefTB.eiddid}','${bean.eiDomainDefTB.version}','${bean.eiDomainDefTB.updatetime}')"><img src="images/relationships.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0213.Incidence.alt"/>' width="16" height="16"  border="0"/></a>
                   	</logic:notEqual>
                  	<logic:equal name="bean" property="eircount" value="0">
                    <img src="images/unrelationships.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0213.norelationship.alt"/>' width="16" height="16"  border="0"/>
                  	</logic:equal>
			        </div>
			       </td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<!-- paging --> <jsp:include page="/include/paging.jsp" /> <!-- /paging -->
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
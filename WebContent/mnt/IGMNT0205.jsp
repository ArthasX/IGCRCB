<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<html:html>
<bean:define id="id" value="IGMNT0205" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="mntResources" key="ietitle.IGMNT0205" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" /> 
<!-- /header1 -->
<script type="text/javascript">
	function chkform(){
		var reg=/^\d+$/;
		var count=0;
		var test1=document.getElementsByTagName("input");
		for(var i=0;i<test1.length;i++){
			if(test1[i].type=="checkbox"){
				if(test1[i].checked){
					count++;
				}
			}
			if(test1[i].type=="text"&&test1[i].id!="objectName"&& !reg.test(test1[i].value)){
				alert('<bean:message bundle="mntResources" key="message.IGMNT0205.numOnly" />');
				return false;
			}
		}
		if(count==0){
			alert('<bean:message bundle="mntResources" key="message.IGMNT0205.chkbox" />');
			return false;
		}
	}
	
	function confirmUpdate(){
		if(chkform()==false){
			return false;
		}
		if(window.confirm('<bean:message bundle="mntResources" key="message.IGMNT0205.confirmUP" />')){
			document.forms[0].action="IGMNT0205_Update.do";
			document.forms[0].submit();
			return true;
		}
		return false;
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGMNT0205"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
     <ig:navigation extname1="${urlable}"/>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div class="conditions_border1">
	<div>
	<label>
	&nbsp;&nbsp;<bean:message bundle="mntResources" key="label.IGMNT0104.hostName" />：
	</label> 
	<html:select name="IGMNT0205Form" styleId="name" property="name" style="width: 130px;" errorStyleClass="inputError">
		<html:options collection="ADHostList" property="value" name=""
			labelProperty="label" />
	</html:select>
	<label>
	&nbsp;&nbsp;<bean:message bundle="mntResources" key="label.IGMNT0104.monitorType" />：
	</label> 
	<html:select name="IGMNT0205Form" styleId="objectType" property="objectType" style="width: 130px;" errorStyleClass="inputError">
	<ig:optionsCollection ccid="CAPCITY_OBJECT_LIST_TYPE" isMakeBlankRow="false"/>
	</html:select>&nbsp;&nbsp;
	<label>
	<bean:message bundle="mntResources" key="label.IGMNT0104.moName" />：
	</label>
	<html:text property="objectName" styleId="objectName"></html:text>
	&nbsp;&nbsp;
	<html:submit property="btn_search" styleClass="button">
	<bean:message bundle="mntResources" key="button.IGMNT0104.btn_search" />
	</html:submit>
	&nbsp;&nbsp;
	
	</div>
	</div>
	</div>

	</div>

	<div id="results_list">
	<!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style2">
		<!-- header部 -->
		<tr>
			<th width="10%"><input type="checkbox" id="mysel" onclick="selectAll('mysel','selArr')" ></th>
			<th><bean:message bundle="mntResources"
				key="title.IGMNT0205.hostName" /></th>
			<th><bean:message bundle="mntResources"
				key="title.IGMNT0205.capType" /></th>
			<th><bean:message bundle="mntResources"
				key="label.IGMNT0104.moName" /></th>
			<th><bean:message bundle="mntResources"
				key="title.IGMNT0205.custtomErrorNum" /></th>
			<th><bean:message bundle="mntResources"
				key="title.IGMNT0205.custtomWarningNum" /></th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGMNT02051VO" property="capacityObjectListInfoList">
			<logic:iterate id="bean" name="IGMNT02051VO"
				property="capacityObjectListInfoList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					
					<!-- chkbox -->
					<td>
					<input type="checkbox" value="${index}" name="selArr">
					<html:hidden property="ids" value="${bean.id}"/>
					</td>
					<!-- 主机名称-->
					<td>
					<div class="nowrapDiv">${fn:substringBefore(bean.name, "_")}</div>
					<html:hidden property="names" value="${bean.name}"/>
					</td>
					<!-- 容量类型-->
					<td>
					<div class="nowrapDiv">${bean.objectType}</div>
					<html:hidden property="objectTypes" value="${bean.objectType}"/>
					</td>
					<td>
					<!-- FS/TS -->
					<div class="nowrapDiv">${bean.objectName}</div>
					<html:hidden property="objectNames" value="${bean.objectName}"/>
					</td>
					<!-- 严重告警阈值 -->
					<td>
					<div class="nowrapDiv"><html:text styleClass="input1" property="errorNums" value="${bean.errorNum}" size="5" maxlength="2"></html:text>%</div>
					</td>
					<!-- 普通告警阈值-->
					<td>
					<div class="nowrapDiv"><html:text styleClass="input1" property="warningNums" value="${bean.warningNum}" size="5" maxlength="2"></html:text>%</div>
					</td>
					
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGMNT02051VO" property="capacityObjectListInfoList">
		<input type="button" value="<bean:message bundle="mntResources" key="button.IGMNT0205.updateButton" />" onclick="return confirmUpdate()" class="button"/><!-- paging --> <jsp:include page="/include/paging.jsp" /> <!-- /paging -->
	</logic:present> 
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
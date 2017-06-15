<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils"%>

<%@page import="org.apache.commons.lang.StringUtils"%><html:html>
<bean:define id="id" value="IGCIM0302" toScope="request" />
<bean:define id="title"  toScope="request" >
<bean:message bundle="asmResources" key="ietitle.IGCIM0302"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	 function setEntity(url){

			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				document.forms[0].ename.value = "";
				document.forms[0].esyscoding.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
				var syscode_eid = temp.split("|")[0];
				var name = temp.split("|")[1];
				var syscode;
				var eid;
				if(syscode_eid =="999")
				{
					eid = "";
					syscode = syscode_eid;
					
				}else if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
				}
				document.forms[0].ename.value = name;
				document.forms[0].esyscoding.value = syscode;
			}		
			
		}

	 function checkForm(){
		 if($("autid").value == ""){
			 alert('<bean:message bundle="asmResources" key="message.IGCIM0301.007"/>');
			 return false;
		 }
	     var confirmMsg = '<bean:message bundle="asmResources" key="message.IGCIM0302.001"/>'; 
		 
        if( window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGCIM0302_Save.do";
            return true;
        } else {
            return false;
        }
	 }

	 function checkFormForUpdate(){
		 if($("autid").value == ""){
			 alert('<bean:message bundle="asmResources" key="message.IGCIM0301.007"/>');
			 return false;
		 }
		 var confirmMsg = '<bean:message bundle="asmResources" key="message.IGCIM0302.003"/>';
		 $("autupdtime").value = "<%= IGStringUtils.getCurrentDateTime() %>";
	        if( window.confirm(confirmMsg)){
	        	document.getElementById("upd").style.display = "none";
	            form.action = getAppRootUrl() + "/IGCIM0302_Update.do";
	            return true;
	        } else {
	            return false;
	        }
	 }
	 
	 function exportExcel() {
		 if($("autid").value == ""){
			 alert('<bean:message bundle="asmResources" key="message.IGCIM0301.007"/>');
			 return false;
		 }
	 	document.forms[0].action = getAppRootUrl() + "/IGCIM0302_Export.do";
	 	document.forms[0].submit();
	 }

	 function exportExcelOne() {
		 if($("autid").value == ""){
			 alert('<bean:message bundle="asmResources" key="message.IGCIM0301.007"/>');
			 return false;
		 }
	 	document.forms[0].action = getAppRootUrl() + "/IGCIM0302_ExportOne.do";
	 	document.forms[0].submit();
	 }
	 
	 function search() {
		 if($("autid").value == ""){
			 alert('<bean:message bundle="asmResources" key="message.IGCIM0301.007"/>');
			 return false;
		 }
	 	document.forms[0].action = getAppRootUrl() + "/IGCIM0302.do";
	 	document.forms[0].submit();
	 }
     function setParamIGCIM0311(autid, autdesc, autupdtime, autcomptime) {
         if(autid == "" && autid != null){
	            $("autid").value = "";
	            $("autdesc").value = "";
	            $("autupdtime").value = "";
	            $("autcomptime").value = "";
	            if(document.getElementById("upd") != null){
					document.getElementById("upd").style.display = "none";
	            }
         }else{
	            $("autid").value = autid;
	            $("autdesc").value = autdesc;
	            $("autupdtime").value = autupdtime;
	            $("autcomptime").value = autcomptime;
	            if(document.getElementById("upd") != null){
		            if($("autupdtime").value == null || $("autupdtime").value == ""){
		            	document.getElementById("upd").style.display = "";
		            }else{
		            	document.getElementById("upd").style.display = "none";
			        }
	            }
         }
     }
     function goLook(){
     	
 		var url = "/IGCIM0310.do";
 		openSubWindow(url, '_blank', '1000', '600');
 		
     }

	 function init(){
		 if(document.getElementById("upd") != null){
			 if($("autupdtime").value == null || $("autupdtime").value == ""){
	            	document.getElementById("upd").style.display = "";
             }else{
            	document.getElementById("upd").style.display = "none";
	         }
		 }
	 }
	</script>
<body onload = "init();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
          <html:form styleId="form" action="/IGCIM0302" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">
						<ig:navigation extname1="${urlable}"/>
					</p>
            </div>
            <div id="search">
                   <div class="img"></div>
                   <div class="conditions">
                   <div>
            		<label><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0302.autdesc"/>：</label>
            		<html:text property="autdesc" styleId="autdesc" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
					<img src="images/seek.gif" border="0" width="16" height="16" alt='<bean:message bundle="asmResources" key="img.IGASM0304.find.alt"/>' onclick="goLook()" style="cursor: hand"/>
            		<html:hidden property="autid" />
                    &nbsp;&nbsp;
                    <label><bean:message bundle="asmResources" key="label.IGCIM0302.autimeFrom"/></label><html:text property="autupdtime" styleId="autupdtime" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                    &nbsp;&nbsp;
                    <label><bean:message bundle="asmResources" key="label.IGCIM0302.autimeTo"/></label><html:text property="autcomptime" styleId="autcomptime" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
					&nbsp;&nbsp;
					<label><bean:message bundle="asmResources" key="label.IGCIM0302.ename"/></label><html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
					<img src='images/tree.gif' style="cursor: hand;" alt='<bean:message bundle="asmResources" key="img.IGCIM0302.tree.alt"/>' width="16" height="16" border="0" onclick="setEntity('IGSYM1203_ENTITY_TREE.do?type=0&levelnode=999');"/>
					<html:hidden property="esyscoding"/>&nbsp;&nbsp;	
					<html:button property="btn_search" styleClass="button" onclick="search();"  >
					<bean:message bundle="asmResources" key="button.IGCIM0302.btn_search"/>
					</html:button>
					
					<html:button property="btn_search" styleClass="button" onclick="exportExcelOne();"  >
						<bean:message bundle="asmResources" key="button.IGCIM0302.btn_exportOne"/>
					</html:button>
					<html:button property="btn_search" styleClass="button" onclick="exportExcel();"  >
						<bean:message bundle="asmResources" key="button.IGCIM0302.btn_export"/>
					</html:button>
                   </div>
                   </div>
                </div>
                
                <div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
                    <table class="table_style">
						<!-- header部 -->
							<tr>
								<th width="8%">
								<input type="hidden" name="checkbox" id="checkbox"  />
								<bean:message bundle="asmResources" key="title.IGCIM0302.auflag"/></th>
								<th width="17%"><bean:message bundle="asmResources" key="title.IGCIM0302.einame"/></th>
								<th width="12%"><bean:message bundle="asmResources" key="title.IGCIM0302.ename"/></th>
								<th width="8%"><bean:message bundle="asmResources" key="title.IGCIM0302.aucmptype"/></th>
								<th width="8%"><bean:message bundle="asmResources" key="title.IGCIM0302.detailInfo"/></th>
							</tr>
						<!-- body部 -->
                            <logic:present name="IGCIM03021VO" property="auditResultOneInfoList">
								<logic:iterate id="bean" name="IGCIM03021VO" property="auditResultOneInfoList" indexId="index">
									<tr>
										<td>
										<c:if test="${bean.auflag == '1'}">
											<input name="checkbox" id="checkbox" type="checkbox" value="${bean.autid},${bean.eiid}" checked="checked"/>
										</c:if>
										<c:if test="${bean.auflag == '0'}">
											<html:checkbox property="checkbox" value="${bean.autid},${bean.eiid}" />
										</c:if>
										</td>

										<!-- 资产名称 -->
										<td>
											<div class="nowrapDiv">${bean.einame}</div>
										</td>
										
										<!-- 资产模型 -->
										<td>
											<div class="nowrapDiv">${bean.entityTB.ename}</div>
										</td>

										<!-- 对比结果类型 -->
										<td>
											<div class="nowrapDiv"><ig:codeValue ccid="AUDITRESULT_AUCMPTYPE" cid="${bean.aucmptype}" /></div>
										</td>
										<td>
										<div class="nowrapDiv">
											<html:link action="/IGCIM0302_Show.do?eiid=${bean.eiid}&autid=${bean.autid}">
											<img src="images/xx.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0302.detailInfo.alt"/>' width="16" height="16"  border="0"/>
											</html:link>
										</div>
										</td>
										
									</tr>
									
									
								</logic:iterate>
							</logic:present>
					</table>
				</div>
	         <logic:present name="IGCIM03021VO" property="auditResultOneInfoList">
	         <bean:size id="num" name="IGCIM03021VO" property="auditResultOneInfoList" />
	         	<c:if test="${num > 0}">
	         	<logic:equal name="IGCIM0302Form" property="autupdtime" value="">
				<div class="operate">
					<html:submit property="btn_search" styleClass="button" onclick="return checkForm();" >
					<bean:message bundle="asmResources" key="button.IGCIM0302.btn_submit"/>
					</html:submit>
					<html:submit property="btn_search" styleClass="button" onclick="return checkFormForUpdate();" styleId="upd">
					<bean:message bundle="asmResources" key="button.IGCIM0302.btn_update"/>
					</html:submit>
				</div>
				</logic:equal>
				</c:if>
	         </logic:present>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
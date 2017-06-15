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
<bean:define id="id" value="IGAIM0312" toScope="request" />
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
		 var frm = window.document.forms[0];
	        if(frm.checkbox.length > 0){
	            var bchecked = false;
	            for(var i = 0; i<frm.checkbox.length; i++ ){
	                if (frm.checkbox[i].checked == true){
	                	if(document.getElementsByName("auresultdesces")[i-1].value.strlen()>256){
	                		alert('<bean:message bundle="asmResources" key="message.IGCIM0302.001" arg0="审计结果说明" arg1="' + Math.floor(256/strByteFlag) + '"/>');
	                		return false;
	                	}
	                }
	            }
	        }
	        if( window.confirm(confirmMsg)){
	            form.action = getAppRootUrl() + "/IGAIM0302_Save.do";
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
	            form.action = getAppRootUrl() + "/IGAIM0302_Update.do";
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
	 	document.forms[0].action = getAppRootUrl() + "/IGAIM0302_Export.do";
	 	document.forms[0].submit();
	 }
	 
	 function search() {
		 if($("autid").value == ""){
			 alert('<bean:message bundle="asmResources" key="message.IGCIM0301.007"/>');
			 return false;
		 }
	 	document.forms[0].action = getAppRootUrl() + "/IGAIM0302.do";
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
     	
 		var url = "/IGAIM0310.do";
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
	 function toback(){
		form.action = getAppRootUrl() + "/IGAIM0302.do";
		form.submit();
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
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">
					<bean:define id="urlable">
					<bean:message bundle="asmResources" key="navigation.IGCIM0302.detailInfo"/>
					</bean:define>
					<ig:navigation extname1="${urlable}" />
					</p>
					<div class="back"><a href="javascript:toback();" target="_self">
					<bean:message bundle="asmResources" key="label.IGCIM0305.back" /></a>
					</div>
            </div>
                <html:form styleId="form" action="/IGCIM0302" onsubmit="return checkSubmit(this);">
                <div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
                    <table class="table_style">
						<!-- header部 -->
							<tr>
								<th width="17%"><bean:message bundle="asmResources" key="title.IGCIM0302.einame"/></th>
								<th width="12%"><bean:message bundle="asmResources" key="title.IGCIM0302.ename"/></th>
								<th width="8%"><bean:message bundle="asmResources" key="title.IGCIM0302.aucmptype"/></th>
								<th width="15%"><bean:message bundle="asmResources" key="title.IGCIM0302.cname"/></th>
								<th width="10%"><bean:message bundle="asmResources" key="title.IGCIM0302.civalue"/></th>
								<th width="10%"><bean:message bundle="asmResources" key="title.IGCIM0302.auvalue"/></th>
<!--							<th width="10%"><bean:message bundle="asmResources" key="title.IGCIM0302.auflag"/></th>-->
<!--							<th width="20%"><bean:message bundle="asmResources" key="title.IGCIM0302.auresultdesc"/></th>-->
							</tr>
						<!-- body部 -->
                            <logic:present name="IGCIM03021VO" property="auditResultList">
								<logic:iterate id="bean" name="IGCIM03021VO" property="auditResultList" indexId="index">
									<tr>

										<!-- 资产名称 -->
										<td>
											<div class="nowrapDiv">${bean.einame}</div>
											<html:hidden property="aurids" value="${bean.aurid}"/>
										</td>
										
										<!-- 资产模型 -->
										<td>
											<div class="nowrapDiv">${bean.entityTB.ename}</div>
										</td>

										<!-- 对比结果类型 -->
										<td>
											<div class="nowrapDiv"><ig:codeValue ccid="AUDITRESULT_AUCMPTYPE" cid="${bean.aucmptype}" /></div>
										</td>
										
										<!-- 属性名称 -->
										<td>
											<div class="nowrapDiv">${bean.cname}</div>
										</td>
										
										<!-- 当前版本值 -->
										<td>
											<div class="nowrapDiv">${bean.civalue}</div>
										</td>
										
										<!-- 采集值 -->
										<td>
											<div class="nowrapDiv">${bean.auvalue}</div>
										</td>
										
										<!-- 合理标识 -->
<!--										<td>-->
<!--											<div class="nowrapDiv"><ig:codeValue ccid="AUDITRESULT_AUFLAG" cid="${bean.auflag}" /></div>-->
<!--										</td>-->
										
										<!-- 审计结果说明 -->
<!--										<td>-->
<!--												<div class="nowrapDiv"><html:text property="auresultdesces" name="auresultdesces" value="${bean.auresultdesc}"/></div>-->
<!--										</td>-->
									</tr>
									
									
								</logic:iterate>
							</logic:present>
					</table>
				</div>
			</html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
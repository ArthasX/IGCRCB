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
<bean:define id="id" value="IGASM2102" toScope="request" />
<bean:define id="title"  toScope="request" >
审计对比结果查询画面
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
			 alert('审计任务不能为空！');
			 return false;
		 }
	     var confirmMsg = '是否确认提交？'; 
		 var frm = window.document.forms[0];
	        if(frm.checkbox.length > 0){
	            var bchecked = false;
	            for(var i = 0; i<frm.checkbox.length; i++ ){
	                if (frm.checkbox[i].checked == true){
	                	if(document.getElementsByName("auresultdesces")[i-1].value.strlen()>256){
	                		alert("审计结果说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
	                		return false;
	                	}
	                }
	            }
	        }
	        if( window.confirm(confirmMsg)){
	            form.action = getAppRootUrl() + "/IGASM2102_Save.do";
	            return true;
	        } else {
	            return false;
	        }
	 }

	 function checkFormForUpdate(){
		 if($("autid").value == ""){
			 alert('审计任务不能为空！');
			 return false;
		 }
		 var confirmMsg = '请确认是否执行更新操作？';
		 document.getElementById("upd").style.display = "none";
		 $("autupdtime").value = "<%= IGStringUtils.getCurrentDateTime() %>";
	        if( window.confirm(confirmMsg)){
	            form.action = getAppRootUrl() + "/IGASM2102_Update.do";
	            return true;
	        } else {
	            return false;
	        }
	 }
	 
	 function exportExcel() {
		 if($("autid").value == ""){
			 alert('审计任务不能为空！');
			 return false;
		 }
	 	document.forms[0].action = getAppRootUrl() + "/IGASM2102_Export.do";
	 	document.forms[0].submit();
	 }
	 
	 function search() {
		 if($("autid").value == ""){
			 alert('审计任务不能为空！');
			 return false;
		 }
	 	document.forms[0].action = getAppRootUrl() + "/IGASM2102.do";
	 	document.forms[0].submit();
	 }
     function setParamIGASM2111(autid, autdesc, autupdtime, autcomptime) {
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
     	
 		var url = "/IGASM2110.do";
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
          <html:form styleId="form" action="/IGASM2102" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">资产管理 &gt;&gt; 审计管理 &gt;&gt; 审计对比</p>
            </div>
            <div id="search">
                   <div class="img"></div>
                   <div class="conditions">
                   <div>
            		<label><span class="red">*</span>审计任务：</label>
            		<html:text property="autdesc" styleId="autdesc" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
					<img src="images/seek.gif" border="0" width="16" height="16" alt='查询' onclick="goLook()" style="cursor: hand"/>
            		<html:hidden property="autid" />
                    &nbsp;&nbsp;
                    <label>更新时间:</label><html:text property="autupdtime" styleId="autupdtime" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                    &nbsp;&nbsp;
                    <label>对比时间: </label><html:text property="autcomptime" styleId="autcomptime" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
					&nbsp;&nbsp;
					<label>资产模型</label><html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
					<img src='images/tree.gif' style="cursor: hand;" alt='资产模型' width="16" height="16" border="0" onclick="setEntity('IGSYM1203_ENTITY_TREE.do?type=0&levelnode=999');"/>
					<html:hidden property="esyscoding"/>&nbsp;&nbsp;	
					<html:button property="btn_search" styleClass="button" onclick="search();"  >
					查询
					</html:button>
					
					<html:button property="btn_search" styleClass="button" onclick="exportExcel();"  >
						导出
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
								不合理标识</th>
								<th width="17%">资产名称</th>
								<th width="12%">资产模型</th>
								<th width="8%">对比结果</th>
								<th width="15%">属性名称 </th>
								<th width="10%">当前版本值</th>
								<th width="10%">采集值</th>
<!--								<th width="10%">不合理标识</th>-->
								<th width="20%">审计结果说明</th>
							</tr>
						<!-- body部 -->
                            <logic:present name="IGASM21021VO" property="auditResultList">
								<logic:iterate id="bean" name="IGASM21021VO" property="auditResultList" indexId="index">
									<tr>
										<td>
										<c:if test="${bean.auflag == '1'}">
											<input name="checkbox" id="checkbox" type="checkbox" value="${bean.aurid}" checked="checked"/>
										</c:if>
										<c:if test="${bean.auflag == '0'}">
											<html:checkbox property="checkbox" value="${bean.aurid}" />
										</c:if>
										</td>

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
										<td>
											<div class="nowrapDiv"><html:text property="auresultdesces" name="auresultdesces" value="${bean.auresultdesc}"/></div>
										</td>
									</tr>
									
									
								</logic:iterate>
							</logic:present>
					</table>
				</div>
	         <logic:present name="IGASM21021VO" property="auditResultList">
	         <bean:size id="num" name="IGASM21021VO" property="auditResultList" />
	         	<c:if test="${num > 0}">
				<div class="operate">
					<html:submit property="btn_search" styleClass="button" onclick="return checkForm();" >
					保存
					</html:submit>
					<html:submit property="btn_search" styleClass="button" onclick="return checkFormForUpdate();" styleId="upd">
					更新
					</html:submit>
				</div>
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
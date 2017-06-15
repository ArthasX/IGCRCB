<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGAIM0307" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0307" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
        var gid='IGCIM0311';


        function setParentValue(autid, autdesc, autupdtime, autcomptime){
            if(!window.opener.closed){
	        	window.opener.setParamIGCIM0311(autid, autdesc, autupdtime, autcomptime);
            }
            window.close();
        }
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setParamIGCIM0311("", "", "", "");
            }
            window.close();
        }
        function setEntity(url){

        	if(document.forms[0].esyscodingbegin.value.trim()!=""){
        		url+=document.forms[0].esyscodingbegin.value;
            }else{
        		url+="999";
            }
        	if(document.forms[0].ecategory.value.trim()!="" && document.forms[0].ecategory.value.trim()!="SDL" ){
        		url+=document.forms[0].ecategory.value;
            	}
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
					alert('<bean:message bundle="comResources" key="message.IGCOM0302.001"/>');
					return false;
				}else if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
				}
				document.forms[0].ename.value = name;
				document.forms[0].esyscoding.value = syscode;
			}		
			
		}

        function checkForm(){
    		var alertTime= '<bean:message bundle="asmResources" key="message.IGCIM0307.003"/>';
    		if(!checkDateWithTimeShow("auttime_from","auttime_to")){
    			alert(alertTime);
    			return false;
    		}
    	}
	</script>

<body>
<div id="maincontent" style="background-color: #FFFFFF; background-image: none;">
<div id="container">
	<html:form styleId="form" action="/IGAIM0310" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><bean:message bundle="asmResources" key="navigation.IGASM.TaskMng" /></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div class="conditions_border1">
	<div><label>&nbsp;&nbsp; <bean:message
		bundle="asmResources" key="label.IGCIM0307.autdesc" /> </label> <html:text
		property="autdesc_like" styleId="autdesc_like"
		errorStyleClass="inputError imeDisabled" size="21" maxlength="21"
		name="IGCIM0307Form" /> 
	&nbsp;&nbsp;<label> 
	<bean:message bundle="asmResources" key="label.IGCIM0307.markDayFrom" /> 
	</label> 
	<html:text property="auttime_from" styleId="auttime_from"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true"name="IGCIM0307Form" /> 
	<img src="images/date.gif" align="middle" onClick="calendar($('auttime_from'))" border="0" /> 
	&nbsp;&nbsp; <label>
	<bean:message bundle="asmResources" key="label.IGCIM0307.markDayTo" />
	</label> 
	<html:text property="auttime_to" styleId="auttime_to"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true" name="IGCIM0307Form" />
	<img src="images/date.gif" align="middle" onClick="calendar($('auttime_to'))" border="0" /> 
	<html:submit property="btn_search" styleClass="button" onclick="return checkForm();">
		<bean:message bundle="asmResources" key="button.IGCIM0307.btn_search"/>
	</html:submit>
	</div>
	</div>
	</div>

	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="5%"><label>NO.</label></th>
			<th width="40%"><bean:message bundle="asmResources"
				key="title.IGCIM0307.autdesc" /></th>
			<th width="10%"><bean:message bundle="asmResources"
				key="title.IGCIM0307.autstatus" /></th>
			<th width="15%"><bean:message bundle="asmResources"
				key="title.IGCIM0307.autupdtime" /></th>
			<th width="15%"><bean:message bundle="asmResources"
				key="title.IGCIM0307.autcomptime" /></th>
			<th width="15%"><bean:message bundle="asmResources"
				key="title.IGCIM0307.auttime" /></th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGCIM03071VO" property="soc0104List">
			<logic:iterate id="bean" name="IGCIM03071VO"
				property="soc0104List" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" 
				onclick="javaScript:setParentValue(
                                                  '${bean.autid}',
                                                  '${bean.autdesc}',
                                                  '${bean.autupdtime}',         
                                                  '${bean.autcomptime}'      
                                              );">
					<!-- 序号 -->
					<td>
					<div class="nowrapDiv">${(PagingDTO.viewPage-1)*PagingDTO.pageDispCount + index+1}</div>
					</td>
					<!-- 审计任务描述 -->
					<td>
					<div class="nowrapDiv">${bean.autdesc}</div>
					</td>
					<!-- 任务状态 -->
					<td>
					<div class="nowrapDiv"><ig:codeValue ccid="AUTSTATUS" cid="${bean.autstatus}" /></div>
					</td>
					<!-- 更新时间-->
					<td>
					<div class="nowrapDiv">${bean.autupdtime}</div>
					</td>
					<!-- 对比时间-->
					<td>
					<div class="nowrapDiv">${bean.autcomptime}</div>
					</td>
					<!-- 审计任务创建时间-->
					<td>
					<div class="nowrapDiv">${bean.auttime}</div>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><logic:present name="IGCIM03071VO"
		property="soc0104List">
	</logic:present> 
	<!-- paging --> <jsp:include page="/include/paging.jsp" /> <!-- /paging -->
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>



</body>
</html:html>
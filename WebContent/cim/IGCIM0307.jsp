<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0307" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0307" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function deleteRec(){
	    var message ='<bean:message key="IGCO10000.E002"/>';
	    var arg0  = '<bean:message bundle="asmResources" key="message.IGCIM0307.001"/>';
	    var alertMsg= '<bean:message bundle="asmResources" key="message.IGCIM0307.002"/>';
	    var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="'+arg0+'" />';
	    var frm = window.document.forms[0];
    	if(frm.deleteImpeiid) {
        	if(frm.deleteImpeiid.length > 0){
           	 	var bchecked = false;
            	for( i=0; i<frm.deleteImpeiid.length; i++ ){
                	if (frm.deleteImpeiid[i].checked == true){
                    bchecked = true;
                }
            }
            if (!bchecked) {
            	alert(message);
                return false;
            }
        } else {
          if ($("deleteImpeiid").checked == false){
        	  alert(message);
              return false;
          }  
        }
    } else {
    	alert(alertMsg);
        return false;
    }
	
    if( window.confirm(confirmMsg)){
        form.action = getAppRootUrl() + "/IGCIM0307_Del.do";
        return true;
    } else {
        return false;
    }
}
	function checkForm(){
		var alertTime= '<bean:message bundle="asmResources" key="message.IGCIM0307.003"/>';
		if(!checkDateWithTimeShow("auttime_from","auttime_to")){
			alert(alertTime);
			return false;
		}
	}
	function changeStatus(autid){
		//"是否改变状态？"
		if(confirm('<bean:message bundle="asmResources" key="message.IGCIM0307.002"/>')){
			var form = document.getElementById("form");
			form.action="ChangeAutstatus.do?autid=" + autid;
			form.submit();
		}
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGCIM0307"
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
	<html:submit property="btn_add" styleClass="button" onclick="location.href='IGCIM0305_Disp.do'">
		<bean:message bundle="asmResources" key="button.IGCIM0307.btn_add"/>
	</html:submit>
	</div>
	</div>
	</div>

	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="4%"><label>NO.</label></th>
			<th width="15%"><bean:message bundle="asmResources"
				key="title.IGCIM0307.autdesc" /></th>
			<th width="10%"><bean:message bundle="asmResources"
				key="title.IGCIM0307.auttime" /></th>
			<!-- 	
			<th width="8%"><bean:message bundle="asmResources"
				key="title.IGCIM0307.autstatusInfo" /></th>
			-->
			<th width="8%"><bean:message bundle="asmResources"
				key="title.IGCIM0307.auditTaskMody" /></th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGCIM03071VO" property="soc0104List">
			<logic:iterate id="bean" name="IGCIM03071VO"
				property="soc0104List" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<!-- 序号 -->
					<td>
					<div class="nowrapDiv">${(PagingDTO.viewPage-1)*PagingDTO.pageDispCount + index+1}</div>
					</td>
					<!-- 审计任务描述 -->
					<td>
					<div class="nowrapDiv">${bean.autdesc}</div>
					</td>
					<!-- 审计任务创建时间-->
					<td>
					<div class="nowrapDiv">${bean.auttime}</div>
					</td>
					<!-- 调整-->
					<!--  
					<td>
					<div class="nowrapDiv">
					<logic:equal name="bean" property="autstatus" value="0">
						<a href="javascript:changeStatus('${bean.autid}');"> <img
							src="images/stop.gif" border="0"
							alt='<bean:message bundle="asmResources" key="img.IGCIM0307.logic.stop"/>' />
						</a>
					</logic:equal> 
					<logic:equal name="bean" property="autstatus" value="1">
						<a href="javascript:changeStatus('${bean.autid}');"> <img
							src="images/start.gif" border="0"
							alt='<bean:message bundle="asmResources" key="img.IGCIM0307.logic.start"/>' />
						</a>
					</logic:equal>
					</div>
					</td>
					-->
					<!-- 修改 -->
					<td>
					<logic:equal name="bean" property="autstatus" value="0">
					<div align="center"><html:link
						action="/IGCIM0305_Edit_Disp.do?autid=${bean.autid}">
						<img src="images/edit.gif" width="16" height="16" border="0" />
					</html:link></div>
					</logic:equal>
					<logic:equal name="bean" property="autstatus" value="1">
					<div align="center">
						<img src="images/noedit.gif" width="16" height="16" border="0" />
					</div>
					</logic:equal>
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
</div>


</div>
</body>
</html:html>
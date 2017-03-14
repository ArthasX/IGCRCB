<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM0203" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0203" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function deleteRec(){
   		 var message ='<bean:message key="IGCO10000.E002"/>';
    	 var arg0  = '<bean:message bundle="asmResources" key="message.IGCIM0203.001"/>';
   		 var alertMsg = '<bean:message bundle="asmResources" key="message.IGCIM0203.002"/>';
   		 var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="'+arg0+'" />';
   		 var frm = window.document.forms[0];
    		if(frm.deleteEiddid) {
       			 if(frm.deleteEiddid.length > 0){
            		var bchecked = false;
           		 for(var i=0; i<frm.deleteEiddid.length; i++ ){
               		 if (frm.deleteEiddid[i].checked == true){
                   		 bchecked = true;
               	 }
            }
           		 if (!bchecked) {
            		alert(message);
                	return false;
            }
        } else {
          if ($("deleteEiddid").checked == false){
              alert(message);
              return false;
          }  
        }
    } else {
    	alert(alertMsg);
        return false;
    }
    
    if( window.confirm(confirmMsg)){
        form.action = getAppRootUrl() + "/IGCIM0203_Del.do";
        return true;
    } else {
        return false;
    }
}

	function checkForm(){
		var alertTime= '<bean:message bundle="asmResources" key="message.IGCIM0203.003"/>';
		if(!checkDateWithTimeShow("createtime_from","createtime_to")){
			alert(alertTime);
			return false;
		}
	}
	function check(){
		var confirmMsg1='<bean:message bundle="asmResources" key="message.IGCIM0203.confirmMsg"/>';
		if(window.confirm(confirmMsg1)){
			return true;
		}else{
			return false;
		}
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGCIM0203"
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
	<div>
	<label>&nbsp;&nbsp; <bean:message bundle="asmResources" key="label.IGCIM0203.name" /> </label> 
	<html:text property="name_like" styleId="name_like"
		errorStyleClass="inputError imeDisabled" size="21" maxlength="21" />
	&nbsp;&nbsp; <label> 
	<bean:message bundle="asmResources" key="label.IGCIM0203.markDayFrom" /> </label> 
	<html:text property="createtime_from" styleId="createtime_from"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true" name="IGCIM0203Form" /> 
	<img src="images/date.gif" align="middle" onClick="calendar($('createtime_from'))" border="0" /> 
	&nbsp;&nbsp; <label>
	<bean:message bundle="asmResources" key="label.IGCIM0203.markDayTo" />
	</label> 
	<html:text property="createtime_to" styleId="createtime_to"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true" name="IGCIM0203Form" />
	<img src="images/date.gif" align="middle" onClick="calendar($('createtime_to'))" border="0" /> 
	<html:submit property="btn_search" styleClass="button" onclick="return checkForm();">
		<bean:message bundle="asmResources" key="button.IGCIM0203.btn_search" />
	</html:submit>
	<html:button property="btn_add" styleClass="button" onclick="location.href='IGCIM0202_Disp.do'">
		<bean:message bundle="asmResources" key="button.IGCIM0203.btn_add" />
	</html:button>
	</div>
	</div>
	</div>

	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="4%"><label> </label></th>
			<th width="10%"><bean:message bundle="asmResources"
				key="title.IGCIM0203.name" /></th>
			<th width="6%"><bean:message bundle="asmResources"
				key="title.IGCIM0203.version" /></th>
			<th width="10%"><bean:message bundle="asmResources"
				key="title.IGCIM0203.createtime" /></th>
			<th width="10%"><bean:message bundle="asmResources"
				key="title.IGCIM0203.updatetime" /></th>
			<th width="8%"><bean:message bundle="asmResources"
				key="title.IGCIM0203.eiDomainDetailInfo" /></th>
			<th width="8%"><bean:message bundle="asmResources"
				key="title.IGCIM0203.eiDomainDefmody" /></th>
			<th width="8%"><bean:message bundle="asmResources"
				key="title.IGCIM0203.HistoryVersion" /></th>
			<th width="8%"><bean:message bundle="asmResources"
				key="title.IGCIM0203.relationshipDiagram" /></th>
			<th width="8%"><bean:message bundle="asmResources"
				key="title.IGCIM0203.handsnapshot" /></th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGCIM02031VO" property="soc0111List">
			<logic:iterate id="bean" name="IGCIM02031VO"
				property="soc0111List" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><html:checkbox property="deleteEiddid"
						value="${bean.eiddid}_${bean.version}" /></td>
					<!-- 名称 -->
					<td>
					<div class="nowrapDiv"><html:link
						action="/IGCIM0205_Disp.do?eiddid=${bean.eiddid}&&version=${bean.version}">${bean.name}</html:link>
					</div>
					</td>
					<!-- 版本号-->
					<td>
					<div class="nowrapDiv"> ${bean.version}</div>
					</td>
					<!-- 登记时间-->
					<td>
					<div class="nowrapDiv"> ${bean.createtime}</div>
					</td>
					<!-- 登记时间-->
					<td>
					<div class="nowrapDiv">${bean.updatetime}</div>
					</td>
					<!-- 资产预范围 -->
					<td>
					<div class="nowrapDiv"><html:link
						action="/IGCIM0204_Disp.do?eiddid=${bean.eiddid}&eiddversion=${bean.version}">
						<img src="images/record_(copy)_16x16.gif"
							alt='<bean:message bundle="asmResources" key="img.IGCIM0203.eiDomainDetail.alt"/>'
							width="16" height="16" border="0" />
					</html:link></div>
					</td>
					<!-- 修改 -->
					<td>
					<div align="center"><html:link
						action="/IGCIM0202_Edit_Disp.do?eiddid=${bean.eiddid}&&version=${bean.version}">
						<img src="images/edit.gif" width="16" height="16" border="0" />
					</html:link></div>
					</td>
					<!-- 历史版本 -->
			        <td>
			        <div class="nowrapDiv">
                          <html:link action="/IGCIM0212_Disp.do?eiddid=${bean.eiddid}&&version=${bean.version}"><img src="images/notepad_16x16.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0203.HistoryVersion.alt"/>'  width="16" height="16"  border="0"/></html:link>
			        </div>
			        </td>
					<!-- 拓扑图 -->
			        <td>
			        <div class="nowrapDiv">
                          <a href="javascript:void(0)" onclick="openSubIGCOM0324('0','${bean.eiddid}','${bean.version}','${bean.updatetime}')"><img src="images/relationships.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0203.relationshipDiagram.alt"/>' width="16" height="16"  border="0"/></a>
			        </div>
			        </td>
			        
			        <!-- 手动快照 -->
					<td>
					<div align="center"><html:link
						action="/IGCIM0205_Snapshot.do?eiddid=${bean.eiddid}&&version=${bean.version}">
						<img src="images/edit.gif" width="16" height="16" border="0" onclick="return check();"/>
					</html:link></div>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><logic:present name="IGCIM02031VO"
		property="soc0111List">
		<html:submit property="btn_delete" styleClass="button"
			onclick="return deleteRec();">
			<bean:message bundle="asmResources" key="button.IGCIM0203.btn_delete" />
		</html:submit>
	</logic:present> <!-- paging --> <jsp:include page="/include/paging.jsp" /> <!-- /paging -->
	</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
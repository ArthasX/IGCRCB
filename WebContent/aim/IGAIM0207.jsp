<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGAIM0207" toScope="request" />
<bean:define id="title" toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0207" />
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function deleteRec(){
	    var message ='<bean:message key="IGCO10000.E002"/>';
	    var arg0  = '<bean:message bundle="asmResources" key="message.IGCIM0207.001"/>';
	    var alertMsg= '<bean:message bundle="asmResources" key="message.IGCIM0207.002"/>';
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
        form.action = getAppRootUrl() + "/IGAIM0207_Del.do";
        return true;
    } else {
        return false;
    }
}
	function changeStatus(impversion,impeiname){
		//"是否改变状态？"
		if(confirm('<bean:message bundle="asmResources" key="message.IGCIM0207.002"/>')){
			var form = document.getElementById("form");
			form.action="ChangeStatus.do?impversion=" + impversion +"&impeiname_eq="+impeiname;
			form.submit();
		}
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGAIM0207"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">
		<ig:navigation></ig:navigation>
	</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div class="conditions_border1">
	<div><label>&nbsp;&nbsp; <bean:message
		bundle="asmResources" key="label.IGCIM0207.impeiname" /> </label> <html:text
		property="impeiname_like" styleId="impeiname_like"
		errorStyleClass="inputError imeDisabled" size="21" maxlength="21"
		name="IGCIM0207Form" /> &nbsp;&nbsp; <html:submit
		property="btn_search" styleClass="button">
		<bean:message bundle="asmResources" key="button.IGCIM0207.btn_search" />
	</html:submit>
		<html:button property="btn_add" styleClass="button" onclick="location.href='IGCIM0206_Disp.do'">
			<bean:message bundle="asmResources" key="button.IGCIM0207.btn_add" />
		</html:button>
	</div>
	</div>
	</div>

	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<!--<th width="4%"><label> </label></th>-->
			<th width="15%"><bean:message bundle="asmResources"
				key="title.IGCIM0207.impeiname" /></th>
			<th width="5%"><bean:message bundle="asmResources"
				key="title.IGCIM0207.impversion" /></th>
			<th width="10%"><bean:message bundle="asmResources"
				key="title.IGCIM0207.impcitype" /></th>	
			<th width="12%"><bean:message bundle="asmResources"
				key="title.IGCIM0207.impcreatetime" /></th>
			<th width="25%"><bean:message bundle="asmResources"
				key="title.IGCIM0207.impfilename" /></th>	
			<th width="5%"><bean:message bundle="asmResources"
				key="title.IGCIM0207.deleteflagInfo" /></th>
			<th width="15%"><bean:message bundle="asmResources"
				key="title.IGCIM0207.HistoryVersion" /></th>	
			<!-- 	
			<th width="8%"><bean:message bundle="asmResources"
				key="title.IGCIM0207.importVersionInfo" /></th>
			<th width="8%"><bean:message bundle="asmResources"
				key="title.IGCIM0207.importVersionMody" /></th>
			-->
		</tr>
		<!-- body部 -->
		<logic:present name="IGCIM02071VO" property="importVersionInfoList">
			<logic:iterate id="bean" name="IGCIM02071VO"
				property="importVersionInfoList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<!--
					<td><html:checkbox property="deleteImpeiid"
						value="${bean.impeiname}_${bean.impversion}" /></td>
						-->
					<!-- 实体名称 -->
					<td>
					<div class="nowrapDiv">${bean.impeiname}</div>
					</td>
					<!-- 版本号-->
					<td>
					<div class="nowrapDiv">${bean.impversion}</div>
					</td>
					<!-- 顶级CI类型 -->
					<td>${bean.soc0113TB.impTypename}</td>
					<!-- 导入时间-->
					<td>
					<div class="nowrapDiv">${bean.impcreatetime}</div>
					</td>
					<!-- 导入文件名-->
					<td>
					<div class="nowrapDiv">${bean.impfilename}</div>&nbsp;
					</td>
					<!-- 调整-->
					<td>
					<div class="nowrapDiv">
					<logic:equal name="bean" property="deleteflag" value="0">
						<a href="javascript:changeStatus('${bean.impversion}','${bean.impeiname}');"> <img
							src="images/stop.gif" border="0"
							alt='<bean:message bundle="asmResources" key="img.IGCIM0207.logic.stop"/>' />
						</a>
					</logic:equal> 
					<logic:equal name="bean" property="deleteflag" value="1">
						<a href="javascript:changeStatus('${bean.impversion}','${bean.impeiname}');"> <img
							src="images/start.gif" border="0"
							alt='<bean:message bundle="asmResources" key="img.IGCIM0207.logic.start"/>' />
						</a>
					</logic:equal>
					</div>
					</td>
					 <!-- 历史版本 -->
			          <td>
			          <div class="nowrapDiv">
                          <html:link action="/IGAIM0211_Disp.do?impeiname=${bean.impeiname}&&impversion=${bean.impversion}"><img src="images/notepad_16x16.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0207.HistoryVersion.alt"/>'  width="16" height="16"  border="0"/></html:link>
			          </div>
			          </td>
					<!-- 详细信息 -->
					<!-- 
					<td>
					<div align="center"><html:link
						action="/###.do?impeiname=${bean.impeiname}&&impversion=${bean.impversion}">
						<img src="images/xx.gif"
							alt='<bean:message bundle="asmResources" key="img.IGCIM0207.importVersionInfo.alt"/>'
							width="16" height="16" border="0" />
					</html:link></div>
					</td>
					 -->
					<!-- 修改 -->
					<!-- 
					<td>
					<div align="center"><html:link
						action="/###.do?impeiname=${bean.impeiname}&&impversion=${bean.impversion}">
						<img src="images/edit.gif" width="16" height="16" border="0" />
					</html:link></div>
					</td>
					 -->
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><logic:present name="IGCIM02071VO"
		property="importVersionInfoList">
		<!--  
		<html:submit property="btn_delete" styleClass="button"
			onclick="return deleteRec();">
			<bean:message bundle="asmResources" key="button.IGCIM0207.btn_delete" />
		</html:submit>
		-->
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
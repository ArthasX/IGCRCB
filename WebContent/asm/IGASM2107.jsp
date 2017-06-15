<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2107" toScope="request" />
<bean:define id="title" toScope="request">
	审计任务管理界面
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function deleteRec(){
	    var message ='请选择删除对象！';
	    var arg0  = '审计任务基本信息';
	    var alertMsg= '没有可删除的数据。';
	    var confirmMsg ='请确认是否要进行'+arg0+'删除处理?';
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
        form.action = getAppRootUrl() + "/IGASM2107_Del.do";
        return true;
    } else {
        return false;
    }
}
	function checkForm(){
		var alertTime= '开始时间不能晚于结束时间！';
		if(!checkDateWithTimeShow("auttime_from","auttime_to")){
			alert(alertTime);
			return false;
		}
	}
	function changeStatus(autid){
		//"是否改变状态？"
		if(confirm('没有可删除的数据。')){
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
<div id="content"><html:form styleId="form" action="/IGASM2107"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">资产管理 &gt;&gt; 审计管理 &gt;&gt; 任务管理</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div class="conditions_border1">
	<div><label>&nbsp;&nbsp; 审计任务描述 </label> <html:text
		property="autdesc_like" styleId="autdesc_like"
		errorStyleClass="inputError imeDisabled" size="21" maxlength="21"
		name="IGASM2107Form" /> 
	&nbsp;&nbsp;<label> 
	创建时间：从 
	</label> 
	<html:text property="auttime_from" styleId="auttime_from"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true"name="IGASM2107Form" /> 
	<img src="images/date.gif" align="middle" onClick="calendar($('auttime_from'))" border="0" /> 
	&nbsp;&nbsp; <label>
	到
	</label> 
	<html:text property="auttime_to" styleId="auttime_to"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true" name="IGASM2107Form" />
	<img src="images/date.gif" align="middle" onClick="calendar($('auttime_to'))" border="0" /> 
	<html:submit property="btn_search" styleClass="button" onclick="return checkForm();">
		查询
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
			<th width="15%">审计任务描述</th>
			<th width="10%">创建时间</th>
			<!-- 	
			<th width="8%">调整</th>
			-->
			<th width="8%">修改</th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGASM21071VO" property="auditTaskInfoList">
			<logic:iterate id="bean" name="IGASM21071VO"
				property="auditTaskInfoList" indexId="index">
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
							alt='停用' />
						</a>
					</logic:equal> 
					<logic:equal name="bean" property="autstatus" value="1">
						<a href="javascript:changeStatus('${bean.autid}');"> <img
							src="images/start.gif" border="0"
							alt='启用' />
						</a>
					</logic:equal>
					</div>
					</td>
					-->
					<!-- 修改 -->
					<td>
					<logic:equal name="bean" property="autstatus" value="0">
					<div align="center"><html:link
						action="/IGASM2105_Edit_Disp.do?autid=${bean.autid}">
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
	<div id="operate"><logic:present name="IGASM21071VO"
		property="auditTaskInfoList">
		<!--  
		<html:submit property="btn_delete" styleClass="button"
			onclick="return deleteRec();">
			删除
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
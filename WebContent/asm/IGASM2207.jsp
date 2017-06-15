<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2207" toScope="request" />
<bean:define id="title" toScope="request">
	CI更新任务管理界面
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	function deleteRec(){
	    var message ='请选择删除对象！';
	    var arg0  = 'CI更新任务信息基本信息';
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
        form.action = getAppRootUrl() + "/IGASM2207_Del.do";
        return true;
    } else {
        return false;
    }
}
	function checkForm(){
		var alertTime= '开始时间不能晚于结束时间！';
		if(!checkDateWithTimeShow("cittime_from","cittime_to")){
			alert(alertTime);
			return false;
		}
	}
	function changeStatus(citid){
		//"是否改变状态？"
		if(confirm('没有可删除的数据')){
			var form = document.getElementById("form");
			form.action="ChangeCitstatus.do?citid=" + citid;
			form.submit();
		}
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGASM2207"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">资产管理 &gt;&gt; CI更新管理 &gt;&gt; 任务管理</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div class="conditions_border1">
	<div><label>&nbsp;&nbsp; CI更新任务描述 </label> <html:text
		property="citdesc_like" styleId="citdesc_like"
		errorStyleClass="inputError imeDisabled" size="21" maxlength="21"
		name="IGASM2207Form" /> 
	&nbsp;&nbsp;<label> 
	创建时间：从 
	</label> 
	<html:text property="cittime_from" styleId="cittime_from"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true"name="IGASM2207Form" /> 
	<img src="images/date.gif" align="middle" onClick="calendar($('cittime_from'))" border="0" /> 
	&nbsp;&nbsp; <label>
	到
	</label> 
	<html:text property="cittime_to" styleId="cittime_to"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true" name="IGASM2207Form" />
	<img src="images/date.gif" align="middle" onClick="calendar($('cittime_to'))" border="0" /> 
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
			<th width="15%">CI更新任务描述</th>
			<th width="10%">创建时间</th>
			<!-- 	
			<th width="8%">调整</th>
			-->
			<th width="8%">修改</th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGASM22071VO" property="ciTaskInfoList">
			<logic:iterate id="bean" name="IGASM22071VO"
				property="ciTaskInfoList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<!-- 序号 -->
					<td>
					<div class="nowrapDiv">${index+1}</div>
					</td>
					<!-- 审计任务描述 -->
					<td>
					<div class="nowrapDiv">${bean.citdesc}</div>
					</td>
					<!-- 审计任务创建时间-->
					<td>
					<div class="nowrapDiv">${bean.cittime}</div>
					</td>
					<!-- 调整-->
					<!--  
					<td>
					<div class="nowrapDiv">
					<logic:equal name="bean" property="citstatus" value="0">
						<a href="javascript:changeStatus('${bean.citid}');"> <img
							src="images/stop.gif" border="0"
							alt='停用' />
						</a>
					</logic:equal> 
					<logic:equal name="bean" property="citstatus" value="1">
						<a href="javascript:changeStatus('${bean.citid}');"> <img
							src="images/start.gif" border="0"
							alt='启用' />
						</a>
					</logic:equal>
					</div>
					</td>
					-->
					<!-- 修改 -->
					<td>
					<logic:equal name="bean" property="citstatus" value="0">
					<div align="center"><html:link
						action="/IGASM2205_Edit_Disp.do?citid=${bean.citid}">
						<img src="images/edit.gif" width="16" height="16" border="0" />
					</html:link></div>
					</logic:equal>
					<logic:equal name="bean" property="citstatus" value="1">
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
	<div id="operate"><logic:present name="IGASM22071VO"
		property="ciTaskInfoList">
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
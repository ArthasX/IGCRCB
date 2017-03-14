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
        var gid='IGASM2111';


        function setParentValue(autid, autdesc, autupdtime, autcomptime){
            if(!window.opener.closed){
	        	window.opener.setParamIGASM2111(autid, autdesc, autupdtime, autcomptime);
            }
            window.close();
        }
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setParamIGASM2111("", "", "", "");
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
					alert('资产模型不可用！请选择其他模型！');
					return false;
				}else if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
				}
				document.forms[0].ename.value = name;
				document.forms[0].esyscoding.value = syscode;
			}		
			
		}
	</script>

<body>
<div id="maincontent" style="background-color: #FFFFFF; background-image: none;">
<div id="container">
	<html:form styleId="form" action="/IGASM2107" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">任务管理</p>
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
			<th width="5%"><label>NO.</label></th>
			<th width="40%">审计任务描述</th>
			<th width="10%">任务状态</th>
			<th width="15%">更新时间</th>
			<th width="15%">对比时间</th>
			<th width="15%">创建时间</th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGASM21071VO" property="auditTaskInfoList">
			<logic:iterate id="bean" name="IGASM21071VO"
				property="auditTaskInfoList" indexId="index">
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
	<div id="operate"><logic:present name="IGASM21071VO"
		property="auditTaskInfoList">
	</logic:present> 
	<!-- paging --> <jsp:include page="/include/paging.jsp" /> <!-- /paging -->
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>



</body>
</html:html>
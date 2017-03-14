<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGDRM04023" toScope="request"/>
<bean:define id="title" value="应急资源选择" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<link type="text/css" rel="stylesheet"	href="<html:rewrite forward='tree.css'/>">
<script src="<html:rewrite forward='tree.js'/>"></script>
<style type="text/css">
.conditions a img{
	border: 0px;
}
.conditions .hover{
	background-color: #d3d3d3;
	cursor: pointer;
}
.conditions .leftd{
	text-align: left;
}
.conditions .delFlag{
	display: none;
}
.conditions .titBox{
	background-color: #FFB1BB;
	font-size: 14px; 
	font-weight: bold;
	color:#fff;
	border-bottom: 1px solid #BB0500;
	line-height: 30px;
	height: 30px;
	text-indent: 10px;
}
.conditions a{
	text-decoration: none;
	color: #f00;
}
.conditions a:HOVER{
	text-decoration: none;
}
.conditions a:VISITED {
	color:#f00;
}
.ellips{
	width:100%; 
	white-space:nowrap; 
	text-overflow:ellipsis; 
	overflow:hidden;
}
</style>
<!-- /header1 -->
<script type="text/javascript">

</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container">
	<!--content  右侧内容-->
	<div id="contentWrap">
			<html:form styleId="form" action="/IGDRM0402" onsubmit="">			
			<div id="content"  >
			<div id="search">
				<div class="img"></div>
				<div class="conditions">
					<div>
						<label for="Name">应急资源模型：</label>
						<html:text property="ername" style="width:85;" errorStyleClass="inputError" tabindex="5" readonly="true"/>
						<img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity('IGDRM0412_Tree.do');"/>
						&nbsp;&nbsp;<label>应急资源名称：</label>
						<html:text property="einame" styleId="einame" style="width:110px;"  errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp;
						<label>负责人：</label><html:text property="eiusername" styleId="eiusername" style="width:110px;" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp;
						<html:hidden property="esyscoding" styleId="esyscoding"/>
						<html:hidden property="eistatus" value="1"/>
						<html:submit property="btn_search" value="查询" styleClass="button" onclick=""/>
					</div>
				</div>
			</div>
			<div id="results_list">
				<!--  message -->
				<ig:message/>
				<!--  /message -->
				<table width="100%" class="table_style">
					<!-- header部 -->
					<tr>
						<th width="3%">
							<label>
								<input type="checkbox" class="delFlag" name="allbox" id="allbox" onclick="selectAll('allbox','relationEiid')"/>
							</label>
						</th>
						<th width="35%">应急资源名称</th>
						<th width="12%">应急资源模型</th>
						<th width="11%">资产模型</th>
						<th width="10%">负责人</th>
						<th width="10%">登记日期</th>
					</tr>
					<!-- body部 -->
					<logic:present name="IGDRM04021VO" property="entityVWItemList" >
						<logic:iterate id="bean" name="IGDRM04021VO" property="entityVWItemList" indexId="index">
							<tr class="<ig:rowcss index="${index}"/>">
								<td>
									<html:checkbox property="relationEiid"  styleClass="delFlag" value="${bean.id}_${bean.eiid}_EIID_${bean.einame}_SOC_${bean.fingerPrint}"/>
								<td>
									<div class="nowrapDiv" style="text-align: left;">
										<logic:empty name="bean" property="einame">&nbsp;</logic:empty>
										<div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;" >
											<span title="${bean.einame}">${bean.einame} </span>
										</div>
									</div>
								</td>
								<td>
								${fn:split(bean.fingerPrint,"_")[1]}
								</td>
								<td>
								<ig:GetMOdelNameByEiid eiid="${bean.eiid}" id="${bean.id}"/>
								</td>
								<!-- 说明 -->
								<!-- 管理人-->
								<td>
									<div class="nowrapDiv">
										<logic:empty name="bean" property="eiusername">&nbsp;</logic:empty>
										${bean.eiusername}
									</div>
								</td>
								<!-- 登记日期 -->
								<td>
									<div class="nowrapDiv">
										<logic:empty name="bean" property="eiinsdate">&nbsp;</logic:empty>
										${bean.eiinsdate}
									</div>
								</td>
										
							</tr>
						</logic:iterate>
					</logic:present>
				</table>
			</div>
			
			<div id="operate">
				<logic:present name="IGDRM04021VO" property="entityVWItemList" >
				<html:button property="btn_delete" value="选择" styleClass="button" onclick="getRelationEntityRec(false);" />
				<c:if test="${IGDRM0402Form.hasAClear==1}">
					<html:button property="btn_delete" value="清空" styleClass="button" onclick="getRelationEntityRec(true);" />
				</c:if>
				</logic:present>
				<!-- paging -->
				<jsp:include page="/include/paging.jsp"/>
				<!-- /paging -->
			</div>
<%-- 			<html:hidden property="ecategory" styleId="ecategory" value="${IGASM0501Form.ecategory}"/> --%>
				<input type="hidden" name="ercode" id="ercode" value="${IGDRM0402Form.ercode }"/>
				<input type="hidden" name="erid" id="erid"/>
			</div>
		</html:form>
	</div>
</div>

<div class="zishiying"></div>
</div>
</body>
<script type="text/javascript">

function getRelationEntityRec(resetFlag){
	if(resetFlag){
		window.opener.setParamIGDRM04023("resetAll");
		window.close();
	}else{
		var message ='请至少选择一条数据！';
		var frm = window.document.forms[0];
		if(frm.relationEiid) {
			//调用flex中的保存状态表单-资产的方法
			var result = "";
			jQuery(".delFlag:checked:not(#allbox)").each(function(i,t){
				result += (t.value+"*##*");
			});
			if(result){
				result = result.substring(0,result.length-4);
				window.opener.setParamIGDRM04023(result);
				window.close();
				return;
			}else{
				alert(message);
			} 
				
		} else {
			alert("请至少选择一条数据！");
			return false;
		}
	}
}
function setEntity(url){

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].erid.value = "";
		document.forms[0].ername.value = "";
		document.forms[0].ercode.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].erid.value = temp.split("|")[0];
		document.forms[0].ername.value = temp.split("|")[1];
		document.forms[0].ercode.value = temp.split("|")[2];
	
	}		
}
jQ(document).ready(function(){
if('${IGDRM0402Form.sign}'){
	jQ("#allbox").hide();
	jQ("input[name=relationEiid]").click(function(event){
		jQ("input[name=relationEiid]").attr("checked",false);
		jQ(this).attr("checked",true);
	}); 
}

	
	});
</script>
</html:html>